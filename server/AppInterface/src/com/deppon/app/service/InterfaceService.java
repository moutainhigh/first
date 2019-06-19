package com.deppon.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;
import base.util.OfficeToWord;
import base.util.PropertiesTools;
import base.util.StringUtils;

import com.deppon.app.dlpUtil.FileDlpUtil;
import com.deppon.app.po.User;

/**
 * 远程服务.
 * 
 * @ClassName: InterfaceService
 * @Description: TODO
 * @date 2014-3-19 下午01:56:13
 * 
 */
@Service
public class InterfaceService {
	/**
	 * 登陆服务.
	 */
	@Resource
	private CheckLoginService checkLoginService;
	/**
	 * 用户服务.
	 */
	@Resource
	private UserService userService;
	public static final String SUCCESS = "40001";// 验证成功
	public static final String NOPEOPLE = "40002"; // 没有该用户
	public static final String WRONGSERIAL = "40003";// 序列号不匹配
	public static final String WRONGPASSWORD = "40004";// 密码错误
	public static final String ERROR = "40005";// 其他错误
	// 加密文件保存路径
	public static final String ENCRYPT_FILE_PATH = PropertiesTools
			.getPathTypeByConfigProperties("encrypt_file_path");
	// 解密文件保存路径
	public static final String DECRYPT_FILE_PATH = PropertiesTools
			.getPathTypeByConfigProperties("decrypt_file_path");

	public static final String POST_URL = PropertiesTools
			.getConfigProperties("logservice");
	
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}
	public String checkLogin(String userId, String password, String serial)
			throws Exception {
		System.out.println("调试的用户名："+userId+"，手机序列号："+serial+","+encryptBASE64((password+"DPM").getBytes()));
		// 1.工号判断是否可以使用移动端
		User user = userService.getUser(userId);
		if (user == null) {
			return NOPEOPLE;
		}
		// 2.判断手机序列号是否匹配，注：数据库中序列号为空，视为首次使用，并记录序列号
		boolean flag = this.auth(user, serial);
		if (flag) {
			// 3.登录验证
			Map<String, String> validInfo = new HashMap<String, String>();
			//return SUCCESS;

			// 得到CAS的认证信息
			checkLoginService.fetchCASValidInfo(validInfo);
			validInfo.put("username", userId);
			validInfo.put("password", password);
			String cookie = checkLoginService.doSSOLogon(validInfo, userId);
			if (!StringUtils.isEmpty(cookie)) {
				return SUCCESS;
			} else {
				return WRONGPASSWORD;
			} 
		} else {
			return WRONGSERIAL;
		}
	}

	/**
	 * 验证用户
	 * 
	 * @Title: auth
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param user
	 * @param @param serial
	 * @param @return
	 * @param @throws Exception
	 * @return boolean
	 * @throws
	 */
	public boolean auth(User user, String serial) throws Exception {
		// 序列号1
		String uSerial = user.getSerial();
		// 序列号2
		String uSerial1 = user.getSerial1();
		// 序列号3
		String uSerial2 = user.getSerial2();
		// 如果序列号1不存在就保存到数据库
		if (StringUtils.isEmpty(uSerial)) {
			user.setSerial(serial);
			userService.save(user);
			return true;
		}
		// 存在了并且相等就返回.
		else if (uSerial.equals(serial)) {
			return true;
		}
		// 进行其他判断.
		else {
			// 第二个序列号不存在
			if (StringUtils.isEmpty(uSerial1)) {
				user.setSerial1(serial);
				userService.save(user);
				return true;
			}
			// 第二个序列号想扥就返回true
			else if (uSerial1.equals(serial)) {
				return true;
			}
			// 进行其他判断
			else {
				// 第三个序列号不存在
				if (StringUtils.isEmpty(uSerial2)) {
					user.setSerial2(serial);
					userService.save(user);
					return true;
				}
				// 第三个序列号相等
				else if (uSerial2.equals(serial)) {
					return true;
				}
				// 不等就返回false
				else {
					return false;
				}
			}
		}
	}

	/**
	 * 
	 * @Title: decryptFile
	 * @Description: 文件解密.
	 * @param in
	 * @param fileName
	 * @param ext
	 * @param deviceType  设备类型。如果通过dlp程序直接解密，这个参数为空，否则说明是来自新的移动oa里面的解密.
	 * @param @return
	 * @param @throws Exception
	 * @return File
	 * @throws
	 */
	public File decryptFile(InputStream in, String fileName, String ext,
			String deviceType) throws Exception {
		// 源文件临时文件夹
		File dir = new File(ENCRYPT_FILE_PATH);
		// 不存在就创建
		if (!dir.exists())
			dir.mkdirs();
		// 目标文件夹
		dir = new File(DECRYPT_FILE_PATH);
		// 不存在就创建.
		if (!dir.exists())
			dir.mkdirs();
		dir = null;
		// 源文件.
		String sourcePath = ENCRYPT_FILE_PATH + "/" + fileName + ext;
		// 目标文件.
		String targetPath = DECRYPT_FILE_PATH + "/" + fileName + ext;
		// 源文件.
		File sourceFile = new File(sourcePath);
		// 目标文件输出流.
		FileOutputStream fos = new FileOutputStream(sourceFile);
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len = in.read(buff)) != -1) {
			fos.write(buff, 0, len);
			fos.flush();
		}
		fos.close();
		fos = null;
		// 解密
		FileDlpUtil.decryptFile(sourcePath, targetPath);
		// 删除源文件
		sourceFile.delete();
		String targetPath2 = targetPath;

		// 如果deviceType为空，说明是老的解密的接口.
		// 如果deviceType不是空，并且类型为android，说明要进行转换pdf的操作.
		if ("".equals(deviceType) || "android".equals(deviceType)) {
			// 如果源文件后缀名是，转换office系列文件到pdf文件.
			if (ext.endsWith(".docx") || ext.endsWith(".xls")
					|| ext.endsWith(".xlsx") || ext.endsWith(".ppt")
					|| ext.endsWith(".pptx") || ext.endsWith(".doc")) {
				// 生成新的pdf文件名
				targetPath2 = targetPath.replace(".", "_") + ".pdf";
				// 文件
				File old = new File(targetPath);
				// 进行转换..
				OfficeToWord.jiexi(old, targetPath2);
				old.delete();
			}
		}

		// 返回文件.
		return new File(targetPath2);
	}

	public static void main(String[] args) {
		InterfaceService service = new InterfaceService();
		service.testPost();
	}

	public static void testPost() {
		System.out.println("POST_URL==" + POST_URL);
		ClientResource client = new ClientResource(POST_URL);
		try {
			Form form = new Form();
			form.add("AppCode", "DMP");
			form.add("EmpCode", "130126");
			form.add("OperationTime", "2013-1-1 12:00");
			form.add("ModuleName", "DLPfile");
			form.add("OperationContent", "解密文件:test.text,文件大小：123445");
			form.add("PassWord", "Dp987239#88");
			String id = client.post(form.getWebRepresentation()).getText();
			System.out.println(id);
			/*
			 * client = new ClientResource(url+"student/"+id+"/xml");
			 * System.out.println(client.get().getText());
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
