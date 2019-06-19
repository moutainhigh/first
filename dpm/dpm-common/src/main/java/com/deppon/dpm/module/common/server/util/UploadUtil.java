package com.deppon.dpm.module.common.server.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

/**
 * 上传工具类
 * 
 * @author 231586
 * 
 */
public class UploadUtil {
	
	//上传图片后缀格式限制
	private static final String[] IMAGE_TYPE = new String[]{".bmg",".jpg",".jpeg",".gif",".png"};
	
	/**
	 * 上传图片格式校验，限定指定格式才能上传：".bmg",".jpg",".jpeg",".gif",".png"。
	 * @param files 文件标签
	 * @param fileNames 文件名
	 * @return boolean true:格式合法，false:格式错误
	 * @throws IOException
	 * */
	public static boolean validateImage(File[] files,String[] fileNames) throws IOException{
		boolean isLegal = false;
		
		if(fileNames == null) return false;
		//检验图片格式
		for(int index = 0,length = fileNames.length;index < length; index ++){
			for (String type : IMAGE_TYPE) {
			   String end=fileNames[index].substring(fileNames[index].lastIndexOf("."));
		    	if(type.equalsIgnoreCase(end)){
		    		isLegal = true;
		    	}
		   	}
		   	BufferedImage image = ImageIO.read(files[index]);
		   	if(image!=null){
		   		isLegal = true;
		   	}
		}
	   	
		return isLegal;
	}
	/**
	 * 
	 * @param files
	 *            文件标签
	 * @param path
	 *            保存路径
	 * @param fileNames
	 *            文件名
	 * @return
	 * @throws IOException
	 */
	public static List<String> uploadFiles(File[] files, String path, String[] fileNames) throws IOException {
		// 文件名
		String fileName;
		// 用以拼接
		StringBuilder sb;
		// 输出流
		OutputStream os = null;
		// 定义返回结果
		List<String> result = new ArrayList<String>();
		// 输入流
		InputStream is = null;
		try {
			// 根据路径获取文件夹
			File destFile = new File(path);
			// 如果文件夹不存在，创建文件夹
			if (!destFile.exists() || !destFile.isDirectory()) {
				// 创建
				destFile.mkdirs();
			}
			// file的存在与否
			if (null != files && files.length > 0) {
				// 循环写出文件
				for (int i = 0; i < files.length; i++) {
					// 拼接开始
					sb = new StringBuilder();
					// 文件输入流获取
					is = new FileInputStream(files[i]);
					// 文件名获取
					fileName = fileNames[i];
					// 文件名用UUID防止重复
					sb.append(UUID.randomUUID().toString());
					// 拼接后缀名，如果存在的话
					if (fileName.indexOf(".") != -1) {
						// 拼接
						sb.append(fileName.substring(fileName.lastIndexOf(".")));
					}
					// 新建文件
					destFile = new File(path, sb.toString());
					// 写出文件
					os = new FileOutputStream(destFile);
					// 定义字节数组
					byte[] buffer = new byte[MagicNumber.NUM1024];
					// 用以接收读取的长度
					int length = 0;
					// 循环
					while ((length = is.read(buffer)) > -1) {
						// 写出
						os.write(buffer, 0, length);
					}
					os.flush();
					// 多个文件就返回多个文件名
					result.add(sb.toString());
					
					// 释放资源
					try {
						// 关闭流
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
					try {
						// 关闭流
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				// 没有返回空
				result = null;
			}
		} catch (IOException e) {
			// 抛出异常
			throw new IOException(e);
		} finally {
			// 不为null
			if (null != is) {
				try {
					// 关闭流
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 不为null
			if (null != os) {
				try {
					// 关闭流
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		// 返回
		return result;
	}
}