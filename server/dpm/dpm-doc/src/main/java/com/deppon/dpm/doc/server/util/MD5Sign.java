package com.deppon.dpm.doc.server.util;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
  
/** 
 * 类MD5Sign.java的实现描述：MD5签名和验签 
 *  
 */  
public class MD5Sign {  
  
    /** 
     * 方法描述:将字符串MD5加码 生成32位md5码 
     *  
     * @param inStr 
     * @return 
     * @throws UnsupportedEncodingException 
     */  
    public static String md5(String inStr) throws UnsupportedEncodingException {  
        return DigestUtils.md5Hex(inStr.getBytes("UTF-8"));  
    }  
  
    /** 
     * 方法描述:签名字符串 
     *  
     * @param params 需要签名的参数 
     * @param appSecret 签名密钥 
     * @return 
     * @throws UnsupportedEncodingException 
     */  
    public static String sign(HashMap<String, Object> params, String appSecret) throws UnsupportedEncodingException {  
    	StringBuilder valueSb = new StringBuilder();  
        params.put("sign_key", appSecret);  
        // 将参数以参数名的字典升序排序  
        Map<String, Object> sortParams = new TreeMap<String, Object>(params);  
        Set<Entry<String, Object>> entrys = sortParams.entrySet();  
        // 遍历排序的字典,并拼接key1=value1&key2=value2......格式  
        for (Entry<String, Object> entry : entrys) {  
        	if(valueSb.length()<1){
        		valueSb.append(entry.getKey()).append("=").append(entry.getValue());
//        		valueSb = entry.getKey()+"="+entry.getValue();
        	}else{
        		valueSb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
//        		valueSb = valueSb+"&"+entry.getKey()+"="+entry.getValue();
        	}
        }  
        params.remove("sign_key");
        return md5(valueSb.toString());  
    }  
}  