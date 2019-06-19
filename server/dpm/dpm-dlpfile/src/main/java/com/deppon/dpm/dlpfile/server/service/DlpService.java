package com.deppon.dpm.dlpfile.server.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dlpfile.FileDlpUtil;
import com.deppon.util.OfficeToWord;
import com.deppon.util.PropertiesTools;

public class DlpService implements IDlpService{
	
	private static final Logger LOG = LoggerFactory.getLogger(DlpService.class);
	
	 // 加密文件保存路径
	public static final String ENCRYPT_FILE_PATH = PropertiesTools
			.getPathTypeByConfigProperties("encrypt_file_path");
	// 解密文件保存路径
	public static final String DECRYPT_FILE_PATH = PropertiesTools
			.getPathTypeByConfigProperties("decrypt_file_path");

	public File decryptFile(InputStream in, String fileName, String ext) {
		// 目标文件输出流.
		FileOutputStream fos = null;
		try{
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
			
			fos = new FileOutputStream(sourceFile);
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = in.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
			fos.flush();
			
			// 解密
			FileDlpUtil.decryptFile(sourcePath, targetPath);
			// 删除源文件
			sourceFile.delete();
			String targetPath2 = targetPath;
	
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
			// 返回文件.
			return new File(targetPath2);
		} catch (Exception e) {
			LOG.error("DlpService.decryptFile出错!!!",e);
		} finally {
			// 释放资源
			if(null != fos){
				try {
					fos.close();
				} catch (IOException e) {
					LOG.error("DlpService.decryptFile关闭流出错!!!",e);
				}
			}
		}
		return null;
	}
}
