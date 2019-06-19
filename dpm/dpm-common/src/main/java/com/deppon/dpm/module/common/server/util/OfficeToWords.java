package com.deppon.dpm.module.common.server.util;

import java.io.File;
import java.net.ConnectException;

import org.apache.log4j.Logger;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

/**
 * 将office系列文档转换为pdf.
 * 
 * @author 130126
 * 
 */
public class OfficeToWords {
	/**
	 * 日志
	 */
	private static final Logger logger = Logger.getLogger(OfficeToWords.class);
	/**
	 * 将文件转换为pdf.
	 * 
	 * @param f
	 * @param newDirName
	 */
	public static void jiexi(File f, String fileName) {
		System.out.println("解密文件：" + f.getName());
		System.out.println("文件长度：" + f.length()+",,目标文件："+fileName);
		/*InetAddress address;
		String hostAddress =null;
		try {
			address = InetAddress.getLocalHost();
			 hostAddress = address.getHostAddress();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		// 获取主机地址
		
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
		long start = 0;
		try {
			connection.connect();
			start = System.currentTimeMillis();
			//DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
			DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
			converter.convert(f, new File(fileName));
		} catch (ConnectException e) {
			e.printStackTrace();
			logger.error("openoffice连接失败",e);
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
