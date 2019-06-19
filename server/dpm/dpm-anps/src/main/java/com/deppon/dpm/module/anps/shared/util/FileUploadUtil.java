package com.deppon.dpm.module.anps.shared.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.ThreadCallBack;
import com.deppon.foss.framework.shared.encypt.base64.BASE64Decoder;
import com.deppon.foss.framework.shared.encypt.base64.BASE64Encoder;

public class FileUploadUtil {

	// 附件上传文件路径
	private static String filePath = "/dpmfile/noticeattachment/";
	private static final int BYTE_2014 = 2014;
	private static final int BYTE_400 = 400;
	private static final int TOHEX_0XFF = 0XFF;
	private final static Logger LOG = LoggerFactory
			.getLogger(FileUploadUtil.class);

	/*
	 * 描述：根据二进制编码保存附件，并返回附件附件总名称
	 * 
	 * @auth 198787
	 * 
	 * @create 2015-3-7 下午5:04:03
	 * 
	 * @return
	 */
	/*public static String uploadFile(List<Attachment> attachments,
			String reportCode) throws IOException {
		StringBuffer sb = new StringBuffer();
		for (Attachment a : attachments) {
			a.setAttachmentName(reportCode + System.currentTimeMillis()
					+ "@AS@P" + a.getAttachmentName());
			*//**
			 * 保存附件
			 *//*
			upload(a.getAttachmentName(), a.getAttachmentUrl());
			sb.append(a.getAttachmentName()).append("@CF@L");
		}
		return sb.toString();
	}*/

	/**
	 * @throws Exception
	 * @throws IOException
	 * 
	 * @Title: uploadFileApp
	 * @Description: 移动端上传单个图片处理类
	 * @param @param attachment
	 * @param @param reportCode
	 * @param @return
	 * @author 123240
	 * @date 2015-4-2 上午11:05:08
	 * @version V1.0
	 * @return String 返回类型
	 * @throws
	 */
	/*public static void uploadFileApp(Attachment attachment, String reportCode) {
		Attachment att = new Attachment();
		att.setAttachmentName(reportCode + "@AS@P"
				+ attachment.getAttachmentName());
		att.setAttachmentUrl(attachment.getAttachmentUrl());
		try {
			decoderBase64File(att.getAttachmentName(), att.getAttachmentUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * 
	 * @Title: uploadFileAppAll
	 * @Description: 移动端上传整个事件信息附件处理类
	 * @param @param attachments
	 * @param @param reportCode
	 * @param @return
	 * @param @throws IOException
	 * @author 123240
	 * @date 2015-4-2 下午1:56:23
	 * @version V1.0
	 * @return String 返回类型
	 * @throws
	 */
	public static String uploadFileAppAll(String[] attachmentsName,
			String reportCode) throws IOException {
		StringBuffer sb = new StringBuffer();
		for (String a : attachmentsName) {
			String attmentName = null;
			attmentName = reportCode + "@AS@P" + a;
			sb.append(attmentName).append("@CF@L");
		}
		return sb.toString();
	}

	/**
	 * 
	 * @Title: upload
	 * @Description: 上传附件方法
	 * @param @param fileName
	 * @param @param atachmentUrl
	 * @param @throws IOException
	 * @author 123240
	 * @date 2015-4-2 下午1:53:14
	 * @version V1.0
	 * @return void 返回类型
	 * @throws
	 */
	public static void upload(String fileName, String atachmentUrl)
			throws IOException {
		OutputStream out = null;
		InputStream in = null;
		try {
			// 将字符串转换成二进制
			byte[] fileByte = hex2byte(atachmentUrl);
			in = new ByteArrayInputStream(fileByte);

			File file = new File(filePath);
			// 文件夹不存在则创建文件夹
			if (!file.exists()) {
				file.mkdir();
			}
			File newFile = new File(filePath + fileName);
			out = new FileOutputStream(newFile);
			byte[] b = new byte[BYTE_2014];
			int n = 0;
			while ((n = in.read(b)) != -1) {
				out.write(b, 0, n);
			}
		} catch (IOException e) {
			LOG.error("upload+IOException:", e);
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				LOG.error("upload+Exception:", e);
			}
			try {
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				LOG.error("upload+Exception:", e);
			}
		}
	}

	/**
	 * 
	 * @Title: upload
	 * @Description: 上传附件方法
	 * @param @param fileName
	 * @param @param atachmentUrl
	 * @param @throws IOException
	 * @author 123240
	 * @date 2015-4-2 下午1:53:14
	 * @version V1.0
	 * @return void 返回类型
	 * @throws
	 */
	public static void uploadFile(String fileName, String atachmentUrl)
			throws IOException {
		// 将字符串转换成二进制
		final byte[] fileByte = hex2byte(atachmentUrl);
		File file = new File(filePath);
		// 文件夹不存在则创建文件夹
		if (!file.exists()) {
			file.mkdir();
		}
		final File newFile = new File(filePath + fileName);
		// 附件存在则不再次保存
		if (!newFile.exists()) {
			ThreadCallBack.run(new Runnable(){
				@Override
				public void run() {
					try {
						FileUtils.writeByteArrayToFile(newFile, fileByte);
					} catch (IOException e) {
						LOG.error("upload+IOException:", e);
					}
				}
				
			});
		}
	}

	/**
	 * 描述： 字符串转化二进制
	 * 
	 * @auth 198787
	 * @create 2015-3-9 上午9:39:43
	 * @param str
	 * @return
	 */
	private static byte[] hex2byte(String str) {
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		// if (len == 0 || len % 2 == 1)
		if (len == 0 || (len & 1) == 1)
			return null;
		byte[] b = new byte[len / 2];

		for (int i = 0; i < str.length(); i += 2) {
			b[i / 2] = (byte) Integer.decode("0X" + str.substring(i, i + 2))
					.intValue();
		}
		return b;
	}

	public static String byte2hex(byte[] b) { // 二进制转字符串
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & TOHEX_0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}
		}
		return sb.toString();
	}

	/**
	 * file对象转换为二进制
	 * 
	 * @param file
	 * @return
	 */
	public static byte[] file2byte(File file) {
		byte[] buffer = null;
		FileInputStream fis = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[BYTE_2014];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}

			buffer = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fis) {
					fis.close();
				}
			} catch (IOException e) {
				LOG.error("file2byte+Exception:", e);
			}
			try {
				if (null != bos) {
					bos.close();
				}
			} catch (IOException e) {
				LOG.error("file2byte+Exception:", e);
			}
		}
		return buffer;
	}

	/**
	 * 将文件转成base64 字符串
	 * 
	 * @param path文件路径
	 * @return 
	 * @throws IOException *
	 * @throws Exception
	 */

	public static String encodeBase64File(String path) throws IOException {
		File file = new File(path);
		// FileInputStream inputFile = new FileInputStream(file);
		// byte[] buffer = new byte[(int) file.length()];
		// inputFile.read(buffer);
		// inputFile.close();

		FileInputStream inputFile = null;
		byte[] buffer = new byte[(int) file.length()];
		try {
			inputFile = new FileInputStream(file);
			inputFile.read(buffer);
		} catch (Exception e) {
			LOG.error("encodeBase64File+Exception:", e);
		} finally {
			if (null != inputFile) {
				inputFile.close();
			}
		}
		return new BASE64Encoder().encode(buffer);

	}

	/**
	 * 将base64字符解码保存文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws IOException 
	 * @throws Exception
	 */

	public static void decoderBase64File(String fileName, String base64Code) throws IOException
			 {
		byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
		// FileOutputStream out = new FileOutputStream(new File(filePath
		// + File.separator + fileName));
		// out.write(buffer);
		// out.close();
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File(filePath + File.separator
					+ fileName));
			out.write(buffer);
		} catch (Exception e) {
			LOG.error("decoderBase64File+Exception:", e);
		} finally {
			if (null != out) {
				out.close();
			}
		}
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
	public static void uploadFiles(File[] files, String path, String[] fileNames) throws IOException {
		// 输出流
		OutputStream os = null;
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
					if(null != files[i]){
						// 文件输入流获取
						is = new FileInputStream(files[i]);
						// 新建文件
						destFile = new File(path, fileNames[i]);
						// 写出文件
						os = new FileOutputStream(destFile);
						// 定义字节数组
						byte[] buffer = new byte[BYTE_400];
						// 用以接收读取的长度
						int length = 0;
						// 循环
						while ((length = is.read(buffer)) > -1) {
							// 写出
							os.write(buffer, 0, length);
						}
						
						os.flush();
						
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
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
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
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			// 不为null
			if (null != os) {
				try {
					// 关闭流
					os.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
