package com.deppon.dpm.module.announce.test.service;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestStream {
	public String DestDir = "WEB-INF";
	//是否指定目录
	private boolean flag=false;

	// 默认采用Web项目下build文件夹与根目录的关系得到项目根目录的绝对路径
	public TestStream() {
		flag=false;
		this.DestDir = "WEB-INF";
	}

	// 利用项目的名字获取根目录的绝对路径
	public TestStream(String programName) {
		flag=true;
		this.DestDir = programName;
	}

	// 利用字符串拼凑方法获取项目中的根目录结构
	public  String getPath() {
		// 获取获得当前类所在路径：Window下形如file:/F:/work_litao/uri_test/WebContent/WEB-INF/classes/
		String base = this.getClass().getResource("").getPath();
		// base="E:\\hell\\wile\\my.code";
		System.out.println(base);
		// 字符分割
		String regex = "/";
		// 判断分隔符
		String[] temp = null;
		if (base.contains("\\")) {
			regex = "\\";
			temp = base.split(regex + regex);
		}
		if (base.contains("/")) {
			regex = "/";
			temp = base.split(regex);
		}
		String DestPath = "";
		// 开头存在/ 去掉/前的空元素  否则不去掉
		int i = 0;
		if (temp[0].equals("")) {
			i = 1;
		} else {
			i = 0;
		}
		// 匹配目标文件夹
		for (; i < temp.length - 1; i++) {
			// System.out.println(temp[i]);
			DestPath += temp[i] + regex;
			// 当前目录等于目标目录或者下级目录为build时跳出循环
			if (temp[i].equalsIgnoreCase(DestDir )&& flag) {
				break;
			}
			if (temp[i + 1].equalsIgnoreCase(DestDir)&& !flag) {
				break;
			}
		}
		//Linux系统下加上开头"/"
		String OS = System.getProperty("os.name").toLowerCase();
		if( OS.indexOf( "linux" ) >= 0 ){
			DestPath="/"+DestPath;
		}
		System.out.println(DestPath);
		return DestPath;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String dir = createDirs();
		//System.out.println(dir);
		//TestStream t = new TestStream();
		//String path = t.getPath();
		//System.out.println("path:"+path);*/
		//String t=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//System.out.println("t---:"+t);
		//String str = createDirs();
		//System.out.println("str:"+str);
		//String p2= this.class.getResource("").getPath(); 
		//System.out.println("JdomParse.class.getResource---"+p2);
		//String[] str = {"/E:/project/mobileSys/dpam/workspace","dpm-announce/target/classes/"};
	/*	String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println("JdomParse.class.getResource---"+path);*/
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
		String secendPath = path.substring(1, path.lastIndexOf("/"));
		String absolutelyPath = secendPath.substring(0,secendPath.lastIndexOf("/"));
		String webAnnouncePath = absolutelyPath.substring(0,absolutelyPath.lastIndexOf("/"));
		String dmpPath = webAnnouncePath.substring(0,webAnnouncePath.lastIndexOf("/"));
		System.out.println("path:"+path);
		System.out.println("secendPath:"+secendPath);
		StringBuffer webRootPath = new StringBuffer();
		webRootPath.append(dmpPath.replace("/", "\\"));
		webRootPath.append("\\dpm-web\\src\\main\\webapp");
		//String rootPath = "E:\\project\\mobileSys\\dpam\\workspace\\dpm\\dpm-web\\src\\main\\webapp";
		System.out.println("absolutelyPath:"+absolutelyPath);
		System.out.println("dmpPath:"+dmpPath);
		System.out.println("webRootPath:"+webRootPath.toString());
	}

	// 创建文件夹
	private static String createDirs() {
		String path = null;
		String savePath = "src/main/webapp/upload/announce/image";
		File savedDir = new File(savePath);
		// 如果不存在文件夹
		if (!savedDir.exists()) {
			savedDir.mkdirs();
			String message = "文件夹创建成功！";
			System.out.println(message);
		}
		String l = savedDir.getAbsolutePath();
		System.out.println(l);
		return path;
	}

//	private static void testCreateFile() {
//		String srcPath = "E:\\新闻图片\\列表图片";
//		String savePath = "E:\\project\\mobileSys\\dpam\\workspace\\dpm\\dpm-web\\src\\main\\webapp\\upload\\announce\\img\\normal";
//		// File file = new File(path);
//		File savedDir = new File(savePath);
//		// boolean flag = false;
//		String message = null;
//		// 如果目录不存在就创建
//		if (!savedDir.exists()) {
//			savedDir.mkdirs();
//			message = "文件夹创建成功！";
//		} else {
//			message = "文件夹存在！";
//		}
//
//		System.out.println(message);
//		try {
//			readfile(srcPath, savePath);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("文件未找到！");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("文件流错误！");
//		}
//		System.out.println("生成图片成功");
//	}
//
//	private static boolean createImage(File file, String savePath) {
//		boolean flag = false;
//		InputStream is;
//		OutputStream os;
//		try {
//			is = new FileInputStream(file);
//			byte buffer[] = new byte[8192];
//			int count = 0;
//			// StringBuffer sb = new StringBuffer();
//			String saveFilePath = savePath + "\\" + file.getName();
//			os = new FileOutputStream(saveFilePath);
//			while ((count = is.read(buffer)) > 0) {
//				os.write(buffer, 0, count);
//			}
//			os.close();
//			is.close();
//		} catch (FileNotFoundException e) {
//
//		} catch (IOException e) {
//
//		}
//		return flag;
//	}

	// 字符串生成流
	/*
	 * private static InputStream getStringStream(String str) { if (str != null
	 * && !str.trim().equals("")) { try { byte[] buff = hex2byte(str);
	 * ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(buff);
	 * return tInputStringStream; } catch (Exception ex) {
	 * //ex.printStackTrace(); } } return null; }
	 

	
	 * private static void writeToImage(InputStream is){ String saveFilePath =
	 * "E:\\个人简历\\000000.jpg"; //再将字符串，转成流 OutputStream os; try { os = new
	 * FileOutputStream(saveFilePath); byte buffer[] = new byte[8192]; int count
	 * = 0; while ((count = is.read(buffer)) > 0) { os.write(buffer, 0, count);
	 * } os.close(); System.out.println("******************成功"); } catch
	 * (FileNotFoundException e) { // Auto-generated catch block
	 * //e.printStackTrace(); } catch (IOException e) { // Auto-generated catch
	 * block //e.printStackTrace(); } }
	 

	// 二进制转字符串
	
	 * public static String byte2hex(byte[] b) { StringBuffer sb = new
	 * StringBuffer(); String stmp = ""; for (int n = 0; n < b.length; n++) {
	 * stmp = Integer.toHexString(b[n] & 0XFF); if (stmp.length() == 1) {
	 * sb.append("0" + stmp); } else { sb.append(stmp); }
	 * 
	 * } return sb.toString(); }
	 

	// 字符串转二进制
	public static byte[] hex2byte(String str) {
		if (str == null) {
			return null;
		}
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1) {
			return null;
		}
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer
						.decode("0X" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	*//**
	 * 读取某个文件夹下的所有文件
	 *//*
	public static boolean readfile(String srcPath, String savePath)
			throws FileNotFoundException, IOException {
		try {

			File file = new File(srcPath);
			if (!file.isDirectory()) {
				
				 * System.out.println("文件"); System.out.println("path=" +
				 * file.getPath()); System.out.println("absolutepath=" +
				 * file.getAbsolutePath()); System.out.println("name=" +
				 * file.getName());
				 
				createImage(file, savePath);
			} else if (file.isDirectory()) {
				// System.out.println("文件夹");
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(srcPath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						
						 * System.out.println("path=" + readfile.getPath());
						 * System.out.println("absolutepath=" +
						 * readfile.getAbsolutePath());
						 * System.out.println("name=" + readfile.getName());
						 
						createImage(readfile, savePath);
					} else if (readfile.isDirectory()) {
						readfile(srcPath + "\\" + filelist[i], savePath);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		return true;
	}*/
}
