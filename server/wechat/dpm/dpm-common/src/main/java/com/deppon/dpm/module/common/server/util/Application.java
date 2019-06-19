package com.deppon.dpm.module.common.server.util;

public class Application {
	/**
	 * 获取根路径
	 * 
	 * @return
	 */
	public static String getRootPath() {
		// 因为类名为"Application"，因此" Application.class"一定能找到
		String result = Application.class.getResource("Application.class").toString();
		// 查看路径下是否能够查询到WEB-INF
		int index = result.indexOf("WEB-INF");
		// 如果获取不到
		if (index == -1) {
			// 查看路径下是否能够查询到bin目录
			index = result.indexOf("bin");
		}
		// 地址截取
		result = result.substring(0, index);
		// 地址是否为jar开头
		if (result.startsWith("jar")) {
			// 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径
			result = result.substring(MagicNumber.NUM10);
			// 地址是否为file开头
		} else if (result.startsWith("file")) {
			// 当class文件在class文件中时，返回"file:/F:/ ..."样的路径
			result = result.substring(MagicNumber.NUM6);
		}
		// 地址是否以“/”结尾
		if (result.endsWith("/")) {
			// 不包含最后的"/"
			result = result.substring(0, result.length() - 1);
		}
		// 返回最终结果
		return result;
	}
}