package com.deppon.dpm.module.common.server.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.esafenet.dll.FileDlpUtil;



/**
 * 远程服务.
 * 
 * @ClassName: InterfaceService
 * @Description: TODO
 * @date 2014-3-19 下午01:56:13
 * 
 */
@Service
public class DlpCommonFiles {
	/**
	 * 日志
	 */
	private static final Logger logger = Logger.getLogger(DlpCommonFiles.class);
	
	// 加密文件保存路径
	public static final String ENCRYPT_FILE_PATH = "/opt/files/encrypt";
	// 解密文件保存路径
	public static final String DECRYPT_FILE_PATH = "/opt/files/decrypt";

	
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
	public static File decryptFile(InputStream in, String fileName, String ext,
			String deviceType) throws Exception {
		logger.info("解密开始----------commonfile");
		File returnfile =null;
		try {
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
					OfficeToWords.jiexi(old, targetPath2);
					old.delete();
				}
			}
			returnfile = new File(targetPath2);
			// 返回文件.
			//return returnfile;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("dlp 附件解密失败>>>>commonfile", e);
		}
		return returnfile;
	}

	

	
}
