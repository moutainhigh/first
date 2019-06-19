package com.deppon.dpm.module.management.util;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.FileUtils;

import com.deppon.dpm.module.common.server.util.ThreadCallBack;

/**
 * @author 268101、 CleanAttachmentThread 实体类
 * 
 */
public class CleanAttachmentThread {

	// 文件路径
	private static String filePath = "/dpmfile/emailattachment";
	// 文件路径 it服务台附件
	private static String filePathIt = "/dpmfile/it";
	// 秒 分
	private final int TIME_60 = 60;
	// 时 12
	private final int TIME_12 = 12;
	// 时 12
	private final int TIME_36 = 36;
	// 毫秒
	private final int TIME_1000 = 1000;

	/**
	 * 执行方法
	 */
	public void execute() {
		// 路径
		File file = new File(filePath);
		// 如果文件夹不存在，创建文件夹
		if (!file.exists() || !file.isDirectory()) {
			// 创建
			file.mkdirs();
		}
		// 路径的匿名内部类
		File[] listFiles = file.listFiles(new FileFilter() {
			@Override
			// 操作
			public boolean accept(File pathname) {
				long lastModified = pathname.lastModified();
				// 判断时间
				if (System.currentTimeMillis() - lastModified - TIME_12 * TIME_60 * TIME_60
						* TIME_1000 > 0) {
					return true;
				}
				// 返回数据
				return false;
			}
		});
		// 删除附件
		deleteFiles(listFiles);

		// 路径
		File fileTt = new File(filePathIt);
		// 如果文件夹不存在，创建文件夹
		if (!fileTt.exists() || !fileTt.isDirectory()) {
			// 创建
			fileTt.mkdirs();
		}
		// 路径的匿名内部类
		File[] listFilesIt = fileTt.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				long lastModified = pathname.lastModified();
				// 判断时间
				if (System.currentTimeMillis() - lastModified - TIME_36 * TIME_60 * TIME_60
						* TIME_1000 > 0) {
					// 返回数据
					return true;
				}
				// 返回数据
				return false;
			}
		});
		// 删除附件
		deleteFiles(listFilesIt);
	}

	/**
	 * @param files
	 *            参数
	 */
	private void deleteFiles(File... files) {
		// 循环组装
		for (final File file : files) {
			// 判断
			if (file.exists()) {
				// 线程
				ThreadCallBack.run(new Runnable() {
					@Override
					// 线程启动
					public void run() {
						try {
							// 删除
							FileUtils.forceDelete(file);
						} catch (Exception e) {
							// ccf整改
							e.printStackTrace();
						}
					}
				});
			}
		}
	}

}
