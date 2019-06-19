package com.deppon.montal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CovertDate {
	public static String covertMSToDate(String msTime){
		try {
			long d = Long.parseLong(msTime);
			Date date = new Date(d);
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
			String sDate = sp.format(date);
			return sDate;
		} catch (Exception e) {
			// TODO: handle exception
			return msTime;
		}
	}
}
