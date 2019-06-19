package com.esafenet.dll;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NativeClientInterface {
	static {
		try {
			String desktop = System.getProperty("sun.desktop");
			if (desktop != null && desktop.equals("windows")) {
				String fileLock = "FileLock";
				String cdgControl = "CdgControl";
				fileLock = getSysLibName(fileLock);
				loadLib(fileLock, null);
				cdgControl = getSysLibName(cdgControl);
				loadLib(cdgControl, null);
			} else {
				System.loadLibrary("CdgControl");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getSysLibName(String libName) {
		String oaArch = System.getProperty("os.arch");
		if (oaArch.indexOf("64") >= 0) {
			libName = libName + "64";
		}
		libName = System.mapLibraryName(libName);
		return libName;
	}

	private synchronized static void loadLib(String fileName, String tempName)
			throws IOException {
		if (tempName == null || "".equals(tempName)) {
			tempName = fileName;
		}
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		String path = System.getProperty("java.io.tmpdir");
		String filePath = path + File.separator + tempName;
		File extractedFile = new File(filePath);
		System.out.println("加载本地文件：" + filePath);
		InputStream in = null;
		BufferedInputStream reader = null;
		FileOutputStream writer = null;

		if (!extractedFile.exists()) {
			try {
				in = classLoader.getResourceAsStream(fileName);

				reader = new BufferedInputStream(in);
				writer = new FileOutputStream(extractedFile);

				byte[] buffer = new byte[1024];

				while (reader.read(buffer) > 0) {
					writer.write(buffer);
					buffer = new byte[1024];
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null)
					in.close();
				if (writer != null)
					writer.close();
			}
		}
		System.load(filePath);
	}

	public static native String getCDGFileId(String path);

	public static native String getCDGFileVersion(String path);

	public static native boolean isDynamicDecrypt(String path);

	public static native boolean makeCDG(String srcFile, String destFile,
			String fileId, String passwd);

	public static native boolean removeCDG(String srcFile, String destDir,
			String passwd);

	public static native String buildSerialNumber(String code);

	// add by songyan 2009-07-06 解密文件
	public static native boolean DecryptFile(String sourcePath,
			String targetPath, String cypherKey);

	public static native boolean EncryptFile(String sourcePath,
			String targetPath, String cypherKey);
	// end add by songyan 2009-07-06 解密文件
}
