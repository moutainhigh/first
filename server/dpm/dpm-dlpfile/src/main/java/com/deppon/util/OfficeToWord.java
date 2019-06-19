package com.deppon.util;


import java.io.File;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class OfficeToWord {
	/**
	 * 将文件转换为pdf.
	 * 
	 * @param f
	 * @param newDirName
	 */
	public static void jiexi(File f, String fileName) {
		System.out.println("解密文件：" + f.getName());
		System.out.println("文件长度：" + f.length()+",,目标文件："+fileName);
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
		long start = 0;
		try {
			connection.connect();
			start = System.currentTimeMillis();
			DocumentConverter converter = new OpenOfficeDocumentConverter(
					connection);
			converter.convert(f, new File(fileName));
		} catch (ConnectException e) {
			e.printStackTrace();
		} finally {
			long end = System.currentTimeMillis();
			System.out.println("解析：" + f.getName() + "耗时:" + (end - start));
			try {
				if (connection != null)
					connection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}