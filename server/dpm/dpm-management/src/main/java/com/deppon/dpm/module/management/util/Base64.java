package com.deppon.dpm.module.management.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 268101 base64 压缩
 * 
 */
public class Base64 {

	/**
	 * legalChars 静态
	 */
	private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
			.toCharArray();

	/**
	 * @param data
	 *            参数
	 * @return str
	 */
	public static String encode(byte[] data) {
		//设置变量等于0
		int start = 0;
		//得到长度
		int len = data.length;
		//StringBuffer 进行组装
		StringBuffer buf = new StringBuffer(data.length * MagicNumber.NUM3 / 2);
		//组装
		int end = len - MagicNumber.NUM3;
		int i = start;
		int n = 0;
		//判断是否符合条件
		while (i <= end) {
			int d = ((((int) data[i]) & 0x0ff) << MagicNumber.NUM16)
					| ((((int) data[i + 1]) & 0x0ff) << MagicNumber.NUM8)
					| (((int) data[i + 2]) & 0x0ff);
			// buf 的拼装
			buf.append(legalChars[(d >> MagicNumber.NUM18) & MagicNumber.NUM63]);
			// buf 的拼装
			buf.append(legalChars[(d >> MagicNumber.NUM12) & MagicNumber.NUM63]);
			// buf 的拼装
			buf.append(legalChars[(d >> MagicNumber.NUM6) & MagicNumber.NUM63]);
			// buf 的拼装
			buf.append(legalChars[d & MagicNumber.NUM63]);
			i += MagicNumber.NUM3;
			//判断是否符合条件
			if (n++ >= MagicNumber.NUM14) {
				n = 0;
				//拼装
				buf.append(" ");
			}
		}
		//判断是否符合条件
		if (i == start + len - 2) {
			int d = ((((int) data[i]) & 0x0ff) << MagicNumber.NUM16)
					| ((((int) data[i + 1]) & MagicNumber.NUM255) << MagicNumber.NUM8);
			// buf 的拼装
			buf.append(legalChars[(d >> MagicNumber.NUM18) & MagicNumber.NUM63]);
			// buf 的拼装
			buf.append(legalChars[(d >> MagicNumber.NUM12) & MagicNumber.NUM63]);
			// buf 的拼装
			buf.append(legalChars[(d >> MagicNumber.NUM6) & MagicNumber.NUM63]);
			// buf 的拼装
			buf.append("=");
		} else if (i == start + len - 1) {
			//判断是否符合条件
			int d = (((int) data[i]) & 0x0ff) << MagicNumber.NUM16;
			buf.append(legalChars[(d >> MagicNumber.NUM18) & MagicNumber.NUM63]);
			buf.append(legalChars[(d >> MagicNumber.NUM12) & MagicNumber.NUM63]);
			buf.append("==");
		}
		//返回数据
		return buf.toString();
	}

	/**
	 * @param s 参数
	 * @return byte
	 */
	public static byte[] decode(String s) {
		//new 一个新对象
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			//判断
			decode(s, bos);
		} catch (IOException e) {
			//抛出异常
			throw new BusinessException();
		}
		//进行byte转换
		byte[] decodedBytes = bos.toByteArray();
		try {
			//关闭
			bos.close();
			bos = null;
		} catch (IOException ex) {
			// ccf修改
			ex.toString();
			// System.err.println("Error while decoding BASE64: " +
			// ex.toString());
		}
		//返回数据
		return decodedBytes;

	}

	/**
	 * @param s 参数
	 * @param os 参数
	 * @throws IOException 抛出异常
	 */
	private static void decode(String s, OutputStream os) throws IOException {
		int i = 0;
		//得到其长度
		int len = s.length();
		//进行判断
		while (true) {
			while (i < len && s.charAt(i) <= ' ')
				i++;
			//进行判断
			if (i == len)
				//返回
				break;
			//判断
			int tri = (decode(s.charAt(i)) << MagicNumber.NUM18)
					+ (decode(s.charAt(i + 1)) << MagicNumber.NUM12)
					+ (decode(s.charAt(i + 2)) << MagicNumber.NUM6)
					+ (decode(s.charAt(i + MagicNumber.NUM3)));
			//写入数据
			os.write((tri >> MagicNumber.NUM16) & MagicNumber.NUM255);
			if (s.charAt(i + 2) == '=')
				break;
			//写入数据
			os.write((tri >> MagicNumber.NUM8) & MagicNumber.NUM255);
			if (s.charAt(i + MagicNumber.NUM3) == '=')
				break;
			//写入数据
			os.write(tri & MagicNumber.NUM255);
			i += MagicNumber.NUM4;
		}
	}

	/**
	 * @param c 参数
	 * @return int
	 */
	private static int decode(char c) {
		//对传入的参数进行判断
		if (c >= 'A' && c <= 'Z')
			return ((int) c) - MagicNumber.NUM65;
		else if (c >= 'a' && c <= 'z')
			return ((int) c) - MagicNumber.NUM97 + MagicNumber.NUM26;
		else if (c >= '0' && c <= '9')
			return ((int) c) - MagicNumber.NUM48 + MagicNumber.NUM26 + MagicNumber.NUM26;
		else
			switch (c) {
			case '+':
				return MagicNumber.NUM62;
			case '/':
				return MagicNumber.NUM63;
			case '=':
				return 0;
			default:
				throw new BusinessException("unexpected code: " + c);
			}
	}
}