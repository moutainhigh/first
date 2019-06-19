package com.deppon.dpm.dlpfile.server.service;

import java.io.File;
import java.io.InputStream;

public interface IDlpService {
	public static final String SUCCESS = "40001";// 验证成功
	public static final String NOPEOPLE = "40002"; // 没有该用户
	public static final String WRONGSERIAL = "40003";// 序列号不匹配
	public static final String WRONGPASSWORD = "40004";// 密码错误
	public static final String ERROR = "40005";// 其他错误

	public File decryptFile(InputStream in, String fileName, String ext);
}
