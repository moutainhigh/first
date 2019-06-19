/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2012-12-19
 *******************************************************************************/


package com.deppon.montal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.deppon.foss.framework.shared.encypt.base64.BASE64Decoder;

public class Base64DecodeParse {

	
	
	   /** 
	   * @Title: Base64Decode 
	   * @Description:(base64解码) 
	   * @param @param str
	   * @param @return 设定文件 
	   * @returnString 返回类型 
	   * @throws 
	   * @date 2013-8-5 下午2:34:17 
	   */
	public static String Base64Decode(String str) {
		String temp = "";
		String regEx = "[\\u4e00-\\u9fa5]"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(str); 
		
		if(!m.find()){
			str=str.replaceAll(" ", "+");
			BASE64Decoder be = new BASE64Decoder();
			try {
				temp = new String(be.decodeBuffer(str), "utf-8");
			} catch (Exception e) {
			}
			if(isMessyCode(temp)){
				temp=getMessyCode(temp);
			}
		}
		
		if("".equals(temp)){
			temp=str;
		}
		return temp;
	}
	
	public static String getMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");    
		Matcher m = p.matcher(strName);    
		String after = m.replaceAll("");  
		String returnVal="";
		String temp = after.replaceAll("\\p{P}", "");    
		char[] ch = temp.trim().toCharArray();  
		float count = 0;    
		   for (int i = 0; i < ch.length; i++) {    
		      char c = ch[i];    
		      if (Character.isLetterOrDigit(c)) {    
		    
		        if (isChinese(c)) {    
		          count = count + 1;  
		          returnVal+=c;
		       }    
		      }    
		    }
		   return returnVal;

	}
	
	public static boolean isMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");    
		Matcher m = p.matcher(strName);    
		String after = m.replaceAll("");  
		String temp = after.replaceAll("\\p{P}", "");    
		char[] ch = temp.trim().toCharArray();  
		float chLength = ch.length; 
		float count = 0;    
		   for (int i = 0; i < ch.length; i++) {    
		      char c = ch[i];    
		      if (!Character.isLetterOrDigit(c)) {    
		    
		        if (!isChinese(c)) {    
		          count = count + 1;  
		       }    
		      }    
		    }
		    float result = count / chLength;    
		    if (result > 0.4) {    
		      return true;    
		    } else {    
		      return false;    
	    }    

	}
	public static boolean isChinese(char c) {    
		    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);    
		    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS    
		        || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS    
		        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A    
		        || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION    
		        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION    
		        || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {    
		      return true;    
		    }    
		    return false;    
		  } 

}
