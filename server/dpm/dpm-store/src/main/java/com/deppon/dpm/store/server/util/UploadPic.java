package com.deppon.dpm.store.server.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.jpush.api.utils.StringUtils;

import com.deppon.foss.framework.server.sso.util.BASE64Decoder;
/**
 * 上传图片通用接口
 * @author RY
 *
 */
public class UploadPic {
	// 文件路径
	private static final String filePath = "/dpmfile/storerecord/";
	
	
	/** 
     * base64字符串转换成图片 
     * @param imgStr        base64字符串 
     * @param imgName       图片存放名称 
     * @return 
     * 
     * @author XiaoTian 
     * @dateTime 2018-06-11 17:02:17 
     */  
    public static String Base64ToImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片  
  
        if (StringUtils.isEmpty(imgStr)) // 图像数据为空  
            return null;  
        // 得到文件格式
		String spcode = imgStr.substring(imgStr.lastIndexOf("."));
		//去掉后缀,在去掉了头部,用imagecode进行文件上传
		String imgUrl = imgStr.substring(0,imgStr.lastIndexOf(".")).replace("data:image/*;base64,","");
		
        StringBuilder sb = new StringBuilder();
		// 文件名用UUID防止重复
		sb.append(UUID.randomUUID().toString().replaceAll("-", ""));
        // 文件名fileName
		String imgName = sb.toString() + spcode;
		
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {  
            // Base64解码  
            byte[] b = decoder.decodeBuffer(imgUrl);  
            for (int i = 0; i < b.length; ++i) {  
                if (b[i] < 0) {// 调整异常数据  
                    b[i] += 256;  
                }  
            }  
            out = new FileOutputStream(filePath+imgName);  
            out.write(b);  
            out.flush();  
            out.close();  
            return imgName;  
        } catch (Exception e) {  
            return null;  
        }finally{
        	if(out!=null){
        		try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }  
    }
    
    /** 
     * base64字符串转换成图片 
     * @param imgStr        base64字符串 
     * @param imgName       图片存放名称 
     * @return 
     * 
     * @author XiaoTian 
     * @dateTime 2018-06-11 17:02:17 
     */  
    public static String Base64ToImage(String imgStr,String imgName) { // 对字节数组字符串进行Base64解码并生成图片  
  
        if (StringUtils.isEmpty(imgStr)) // 图像数据为空  
            return null;  
        // 得到文件格式
		String spcode = imgStr.substring(imgStr.lastIndexOf("."));
		//去掉后缀,在去掉了头部,用imagecode进行文件上传
		String imgUrl = imgStr.substring(0,imgStr.lastIndexOf(".")).replace("data:image/*;base64,","");
		
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out= null;
        try {  
            // Base64解码  
            byte[] b = decoder.decodeBuffer(imgUrl);
            for (int i = 0; i < b.length; ++i) {  
                if (b[i] < 0) {// 调整异常数据  
                    b[i] += 256;  
                }  
            }  
			out = new FileOutputStream(filePath+imgName);  
            out.write(b);  
            out.flush();  
            out.close();  
            return imgName;  
        } catch (Exception e) {  
            return null;  
        }finally{
        	if(out!=null){
        		try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
    }
    
    /**
     * 获取图片后缀,添加名称
     */
    public String stringImgSuffix(String imgStr){
    	// 得到文件格式
    	String spcode = imgStr.substring(imgStr.lastIndexOf("."));
    	// 生成任务子表id
		IdWorker idWorkerstoreTaskVo = new IdWorker();
		// 生成id为 long类型转为String
		String taskidstoreTaskVo = Long
				.toString(idWorkerstoreTaskVo.nextId());
        // 文件名fileName
		String imgName = taskidstoreTaskVo + spcode;
		//返回名字
		return imgName;
    }
}
