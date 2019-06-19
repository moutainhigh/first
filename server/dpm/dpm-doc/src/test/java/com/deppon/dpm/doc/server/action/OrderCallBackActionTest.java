package com.deppon.dpm.doc.server.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.util.HttpClientUtil;

public class OrderCallBackActionTest {

	public static void main(String[] args) {
		//orderCallBack();
	}
	
	public static void orderCallBack(){
		try {
            String encoding="GBK";
            String filePath = "D:/callback.txt";
            
            File file=new File(filePath);
            ExecutorService exe = Executors.newFixedThreadPool(30);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String orderId = null;
                int countRow = 0;
                while((orderId = bufferedReader.readLine()) != null){
                	countRow++;
                	if(StringUtils.isNoneBlank(orderId)){
                    	System.out.println("第"+countRow+"行"+orderId);
                    	final String order = orderId;
                    	final int count = countRow;
                    	exe.submit(new Callable<String>() {
							@Override
							public String call() throws Exception {
								String url = "https://dpm.deppon.com:8881/dpm/dpm-doc/order_sendOrderStatus.action?order_id=";
								String result = HttpClientUtil
		                    			.httpPost(url+order,JSON.toJSONString(new HashMap<>(),SerializerFeature.WriteNullStringAsEmpty));
								System.out.println("第"+count+"行"+result);
								return result;
							}
						});
                    }
                }
                read.close();
		    }else{
		        System.out.println("找不到指定的文件");
		    }
	    } catch (Exception e) {
	        System.out.println("读取文件内容出错");
	        e.printStackTrace();
	    }
	}
}
