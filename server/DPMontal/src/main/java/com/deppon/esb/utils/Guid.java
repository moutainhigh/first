package com.deppon.esb.utils;

import java.util.Random;

public class Guid {
	//生成随机数
	private static Random rd = new Random();
	//synchronized  加锁
	public synchronized static String newGuid() {
		//系统编号
		String sysCode = "DPM";
		StringBuffer rtn = new StringBuffer(sysCode);
		//时间 戳
		rtn.append(System.currentTimeMillis());

		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		rtn.append(Integer.toHexString(rd.nextInt(16)).toUpperCase());
		
		return rtn.toString();
	}

}
