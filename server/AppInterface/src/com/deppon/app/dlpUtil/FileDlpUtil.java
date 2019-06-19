package com.deppon.app.dlpUtil;

import java.io.File;

import base.util.PropertiesTools;

import com.esafenet.dll.NativeClientInterface;

/**
 * 文件解密工具类.
 * 
 * @ClassName: FileDlpUtil
 * @Description: TODO
 * @date 2014-3-27 下午04:33:47
 * 
 */
public class FileDlpUtil {
	public static final String DEPPON_DLP_KEY = PropertiesTools
			.getConfigProperties("DEPPON_DLP_KEY");
	public static final String FILE_UNLOCK = "-UN";
	public static final String FILE_LOCKED = "-LD";

	// private static Log log = LogFactory.getLog(FileDlpUtil.class);

	// 加密源文件到目标位置
	public static boolean encryptFile(String sourcePath, String targetPath) {
		return NativeClientInterface.EncryptFile(sourcePath, targetPath,
				FileDlpUtil.DEPPON_DLP_KEY);
	}

	// 加密源文件返回加密后文件路径
	public static String getEncryptFile(String sourcePath) {
		String targetPath = getChangeFilePath(sourcePath,
				FileDlpUtil.FILE_LOCKED);
		boolean isEncryptFile = FileDlpUtil.isDynamicDecrypt(sourcePath);
		if (isEncryptFile) {
			return sourcePath;
		}
		boolean encryptFile = NativeClientInterface.EncryptFile(sourcePath,
				targetPath, FileDlpUtil.DEPPON_DLP_KEY);
		if (encryptFile) {
			return targetPath;
		} else {
			return null;
		}
	}

	// 解密源文件到目标位置
	public static boolean decryptFile(String sourcePath, String targetPath) {
		return NativeClientInterface.DecryptFile(sourcePath, targetPath,
				FileDlpUtil.DEPPON_DLP_KEY);
	}

	// 解密源文件返回解密后文件路径
	public static String getDecryptFile(String sourcePath) {
		String targetPath = getChangeFilePath(sourcePath,
				FileDlpUtil.FILE_UNLOCK);
		boolean isEncryptFile = FileDlpUtil.isDynamicDecrypt(sourcePath);
		boolean decryptFile = false;
		if (isEncryptFile) {
			decryptFile = NativeClientInterface.DecryptFile(sourcePath,
					targetPath, FileDlpUtil.DEPPON_DLP_KEY);
		}
		if (decryptFile) {
			return targetPath;
		} else {
			return sourcePath;
		}
	}

	// 判断路径文件是否动态加密过
	public static boolean isDynamicDecrypt(String path) {
		return NativeClientInterface.isDynamicDecrypt(path);
	}

	public static String getChangeFilePath(String sourcePath, String suffix) {
		File file = new File(sourcePath);
		String filePath = file.getParent();
		String fileName = file.getName();
		String targetPath = filePath + "/" + FileUtil.getFileNameNoEx(fileName)
				+ suffix + "." + FileUtil.getExtensionName(fileName);
		return targetPath;
	}

	public static void main(String[] args) {
		try {
			FileDlpUtil.decryptFile("d:/IT-DPM-项目测试报告V1.0.doc", "d:/RIT-DPM-项目测试报告_doc");
			// System.out.println(FileDlpUtil.isDynamicDecrypt("d:/待办事项-de.xlsx"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(System.getProperty("java.io.tmpdir"));
		// System.out.println(System.getProperty("java.library.path"));
	}
}
