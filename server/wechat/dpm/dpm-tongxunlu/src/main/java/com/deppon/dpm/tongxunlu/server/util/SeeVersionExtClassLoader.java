package com.deppon.dpm.tongxunlu.server.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.deppon.dpm.module.common.server.util.MagicNumber;

/**
 * 自定义类加载器
 */
public class SeeVersionExtClassLoader extends ClassLoader {
	
	// 全类名
	private String className;

	// class文件路径
	private String fileUrl;

	// 空参构造器
	public SeeVersionExtClassLoader() {
		super();
	}

	// 构造器
	public SeeVersionExtClassLoader(ClassLoader parant,String fileUrl,String className) {
		super(parant);
		this.fileUrl = fileUrl;
		this.className = className;
	}

	// 复写
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		// 如果调用方法传递的className与classLoader实例传递的不一致，则交给父类加载器
		if(this.className.equals(name) && !"java".equals(name)) {
			// 定义输入流
			FileInputStream in = null;
			// 功能流
			ByteArrayOutputStream baos = null;
			try {
				in = new FileInputStream(new File(fileUrl));
				baos = new ByteArrayOutputStream();
				// 缓冲大小
				byte[] buf = new byte[MagicNumber.NUM1024];
				int len = 0;
				// 循环写出
				while ((len = in.read(buf)) != -1) {
					baos.write(buf, 0, len);
				}
				// 将class文件转为byte[]
				byte[] byteArray = baos.toByteArray();
				// 返回Class
				return defineClass(name, byteArray, 0, byteArray.length);
			} catch (Exception e) {
				throw new ClassNotFoundException();
			} finally {
				// 释放资源
				if(baos != null){
					try {
						baos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return super.loadClass(name);
	}
}
