package com.deppon.montal.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.montal.module.workitems.webservice.client.LSPWorkItemServiceClient;
import com.deppon.montal.util.redis.service.impl.InitAllUsers;

/**
 * Servlet implementation class InitDataServlet
 */
public class InitDataServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = Logger.getLogger(InitDataServlet.class); 
	
	public static Properties prop;

    public InitDataServlet() {
        super();
    }

	@Override
	public void init() throws ServletException {

		prop = new Properties();
		InputStream is = 
			Thread.currentThread().getContextClassLoader().getResourceAsStream("prop.properties");	
		
		try {
			prop.load(is);
		} catch (IOException e) {
			logger.error("读取配置文件出错了:"+e.getMessage());
			e.printStackTrace();
		}
		
		try {
			logger.info("初始化CXF JaxWsDynamicClientFactory...");
			LSPWorkItemServiceClient.getLSPWorkItemServiceClient();
			logger.info("初始化CXF LSPWorkItemServiceClient JaxWsDynamicClientFactory...完成 ");
		} catch (Exception e) {
			logger.error("初始化CXF LSPWorkItemServiceClient JaxWsDynamicClientFactoryr失败");
		}
	}
	
	/**
	 * 获取key对应的值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		if(null != prop){
			return prop.getProperty(key);
		}
		return null;
	}
    
    

}
