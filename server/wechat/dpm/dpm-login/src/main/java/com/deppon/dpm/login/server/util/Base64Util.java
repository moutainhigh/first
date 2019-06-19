package com.deppon.dpm.login.server.util;

import java.io.ByteArrayOutputStream;

import com.deppon.dpm.module.common.server.util.MagicNumber;

/**
 * base64工具类
 * 
 */
public class Base64Util {

	/**
	 * base64DecodeChars
	 */
	private static byte[] base64DecodeChars = new byte[] { MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1,
			MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1,
			MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1,
			MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUM62, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUM63, MagicNumber.NUM52, MagicNumber.NUM53, MagicNumber.NUM54, MagicNumber.NUM55, MagicNumber.NUM56, MagicNumber.NUM57, MagicNumber.NUM58, MagicNumber.NUM59,
			MagicNumber.NUM60, MagicNumber.NUM61, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUM0, MagicNumber.NUM1, MagicNumber.NUM2, MagicNumber.NUM3, MagicNumber.NUM4, MagicNumber.NUM5, MagicNumber.NUM6, MagicNumber.NUM7, MagicNumber.NUM8, MagicNumber.NUM9,
			MagicNumber.NUM10, MagicNumber.NUM11, MagicNumber.NUM12, MagicNumber.NUM13, MagicNumber.NUM14, MagicNumber.NUM15, MagicNumber.NUM16, MagicNumber.NUM17, MagicNumber.NUM18, MagicNumber.NUM19, MagicNumber.NUM20, MagicNumber.NUM21, MagicNumber.NUM22, MagicNumber.NUM23, MagicNumber.NUM24, MagicNumber.NUM25, MagicNumber.NUMNEGATIVE1,
			MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUM26, MagicNumber.NUM27, MagicNumber.NUM28, MagicNumber.NUM29, MagicNumber.NUM30, MagicNumber.NUM31, MagicNumber.NUM32, MagicNumber.NUM33, MagicNumber.NUM34, MagicNumber.NUM35, MagicNumber.NUM36, MagicNumber.NUM37,
			MagicNumber.NUM38, MagicNumber.NUM39, MagicNumber.NUM40, MagicNumber.NUM41, MagicNumber.NUM42, MagicNumber.NUM43, MagicNumber.NUM44, MagicNumber.NUM45, MagicNumber.NUM46, MagicNumber.NUM47, MagicNumber.NUM48, MagicNumber.NUM49, MagicNumber.NUM50, MagicNumber.NUM51, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1,
			MagicNumber.NUMNEGATIVE1, MagicNumber.NUMNEGATIVE1 };

	/**
	 * 解密
	 */
	private static byte[] decode(String str) {
		// 转byte
		byte[] data = str.getBytes();
		// 数组大小
		int len = data.length;
		// 返回值
		ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
		// 变量
		int i = 0;
		// 变量
		int b1, b2, b3, b4;
		// 循环
		while (i < len) {
			do {
				// 循环
				b1 = base64DecodeChars[data[i++]];
			} while (i < len && b1 == -1);
			// 判断
			if (b1 == -1) {
				// 中断
				break;
			}

			do {
				// 循环
				b2 = base64DecodeChars[data[i++]];
			} while (i < len && b2 == -1);
			// 判断
			if (b2 == -1) {
				// 中断
				break;
			}
			buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> MagicNumber.NUM4)));

			do {
				// 循环
				b3 = data[i++];
				// 判断
				if (b3 == MagicNumber.NUM61) {
					// 跳出
					return buf.toByteArray();
				}
				// 赋值
				b3 = base64DecodeChars[b3];
			} while (i < len && b3 == -1);
			// 判断
			if (b3 == -1) {
				// 中断
				break;
			}
			buf.write((int) (((b2 & 0x0f) << MagicNumber.NUM4) | ((b3 & 0x3c) >>> 2)));

			do {
				// 循环
				b4 = data[i++];
				// 判断
				if (b4 == MagicNumber.NUM61) {
					// 跳出
					return buf.toByteArray();
				}
				// 赋值
				b4 = base64DecodeChars[b4];
			} while (i < len && b4 == -1);
			// 判断
			if (b4 == -1) {
				// 中断
				break;
			}
			buf.write((int) (((b3 & 0x03) << MagicNumber.NUM6) | b4));
		}
		// 返回
		return buf.toByteArray();
	}

	/**
	 * decodeToString
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeToString(String str) {
		// 返回
		return new String(decode(str));
	}

}
