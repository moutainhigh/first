package com.deppon.dpm.module.common.server.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ZipUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(ZipUtil.class);

	/**
	 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 * 
	 * @param sourceFilePath
	 *            :待压缩的文件路径
	 * @param zipFilePath
	 *            :压缩后存放路径
	 * @param fileName
	 *            :压缩后文件的名称
	 * @return
	 */
	public static boolean fileToZip(String sourceFilePath, String zipFilePath,
			String fileName) {
		boolean flag = false;
		File sourceFile = new File(sourceFilePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;

		if (!sourceFile.exists()) {
			LOG.info("ZipUtil---->待压缩的文件目录：" + sourceFilePath + "不存在.");
		} else {
			try {
				File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
				File[] sourceFiles = sourceFile.listFiles();
				if (null == sourceFiles || sourceFiles.length < 1) {
					LOG.info("ZipUtil---->待压缩的文件目录：" + sourceFilePath
							+ "里面不存在文件，无需压缩.");
				} else {
					fos = new FileOutputStream(zipFile);
					zos = new ZipOutputStream(new BufferedOutputStream(fos));
					byte[] bufs = new byte[MagicNumber.NUM1024 * MagicNumber.NUM10];
					for (int i = 0; i < sourceFiles.length; i++) {
						// 创建ZIP实体，并添加进压缩包
						ZipEntry zipEntry = new ZipEntry(
								sourceFiles[i].getName());
						zos.putNextEntry(zipEntry);
						// 读取待压缩的文件并写进压缩包里
						fis = new FileInputStream(sourceFiles[i]);
						bis = new BufferedInputStream(fis, MagicNumber.NUM1024 * MagicNumber.NUM10);
						int read = 0;
						while ((read = bis.read(bufs, 0, MagicNumber.NUM1024 * MagicNumber.NUM10)) != -1) {
							zos.write(bufs, 0, read);
						}
						
						fis.close();
						bis.close();
					}
					flag = true;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				// 关闭流
				if(null != fis) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (null != bis){
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (null != zos){
					try {
						zos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(null != fos) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return flag;
	}
}