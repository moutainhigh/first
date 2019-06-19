package com.deppon.app.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import base.util.ParamUtils;

import com.deppon.app.po.User;
import com.deppon.app.service.InterfaceService;
import com.deppon.app.service.UserService;
import com.deppon.app.util.LogUtil;

@Controller
@RequestMapping("/center")
public class InterfaceController {

	private static Logger logger = Logger.getLogger(InterfaceController.class);
	@Resource
	private InterfaceService interfaceService;
	@Resource
	private UserService userService;

	public static void main(String[] a) {
		String aa = "123.java";
		System.out.println(aa.split("[.]")[0]);
	}

	@RequestMapping(value = "checkLogin")
	public void checkLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String result = InterfaceService.ERROR;
		try {
			ServletOutputStream out = response.getOutputStream();
			// 工号
			String userId = ParamUtils.getParameter(request, "userId", "");
			// 密码
			String password = ParamUtils.getParameter(request, "password", "");
			// 手机序列号
			String serial = ParamUtils.getParameter(request, "serial", "");
			//
			logger.info("userId = " + userId + ",serialId = " + serial);
			result = interfaceService.checkLogin(userId, password, serial);
			out.write(result.getBytes());
			out.close();
			return;
		} catch (Exception e) {
			logger.error(e, e);
		}
	}

	@RequestMapping(value = "decryptFile", method = RequestMethod.POST)
	public void decryptFile(@RequestParam("file") CommonsMultipartFile mFile,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			// 工号
			String userId = ParamUtils.getParameter(request, "userId", "");
			// 手机序列号
			String serial = ParamUtils.getParameter(request, "serial", "");
			// 手机类型,仅仅在通过移动OA进行文件解密的时候有这个参数，如果直接在dlp程序中进行解密，是没有这个参数的.
			String deviceType = ParamUtils.getParameter(request, "deviceType",
					"");

			System.out.println("[DecryptFile...] userId = " + userId + ",serialId = "
							+ serial + "\n");
			//logger.info("[DecryptFile...] userId = " + userId + ",serialId = "
			//		+ serial);
			String filename = ParamUtils.getParameter(request, "filename", "");
			// 查询用户信息.
			User user = userService.getUser(userId);
			// 开始解密的时间
			Date startDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
			// 1.判断是否有该用户,只有在没有传递deviceType（老的dlp解密方式）才验证用户.
			if ("".equals(deviceType)&&user == null) {
				out.write(InterfaceService.NOPEOPLE.getBytes());
				return;
			}
			// 2.如果有设备类型，说明是通过新的app进行的界面操作。不是走的以前的手机序列号方式解密的。
			// 判断是否手机序列号匹配
			if ("".equals(deviceType) && !interfaceService.auth(user, serial)) {
				out.write(InterfaceService.WRONGSERIAL.getBytes());
				return;
			} else {// 3.获取文件流，解密文件，并返回文件流
				if (mFile == null) {
					logger.info("Input file is not exist!!");
					out.write(InterfaceService.ERROR.getBytes());
					return;
				}
				System.out.println("File name = " + mFile.getOriginalFilename()+ "\n");
				//logger.info("File name = " + mFile.getOriginalFilename());
				Random ran = new Random();
				// 文件后缀名.
				String ext = "";
				if (filename != null && !"".equals(filename.trim()))
					ext = filename.substring(filename.lastIndexOf("."))
							.toLowerCase();
				// 随机文件名，防多线程解同一文件名，需求对文件名不敏感
				String fileName = String
						.valueOf(ran.nextInt(Integer.MAX_VALUE));
				// 上传的文件大小.
				int fileSize = mFile.getInputStream().available();

				File file = interfaceService.decryptFile(
						mFile.getInputStream(), fileName, ext, deviceType);
				if (!file.exists()) {
					out.write(InterfaceService.ERROR.getBytes());
					return;
				}
				FileInputStream fis = new FileInputStream(file);
				byte[] buff = new byte[1024];
				int len = 0;
				while ((len = fis.read(buff)) != -1) {
					out.write(buff, 0, len);
				}
				fis.close();
				fis = null;
				// 文件删除
				file.delete();
				// 进行日志记录.如果文件名不为空
				/*if (!"".equals(filename))

					System.out.println("File name = " + filename+ "\n");
					//LogUtil.insertReqInfo(request, fileSize, filename, userId,
					//		sdf.format(startDate));*/
				return;
			}
		} catch (Exception e) {
			out.write(InterfaceService.ERROR.getBytes());
			System.out.println("发生异常，错误信息为：" + e.getMessage() + "\n");
			System.out.println("发生异常，异常栈信息为：" + e.getStackTrace());
			//logger.error(e, e);
		}
	}

}
