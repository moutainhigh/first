/**
 * 
 */
package com.deppon.montal.action;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.deppon.montal.service.IAppThreadService;

/**
 * @author Administrator
 *
 */
public class AppThreadLaunchAction extends HttpServlet {
	
	private static Logger logger  = Logger.getLogger(AppThreadLaunchAction.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		Enumeration enumm = config.getInitParameterNames();
		while(enumm.hasMoreElements()){
			String servname = (String)enumm.nextElement();
			String clsname = config.getInitParameter(servname);
			Class c;
			try {
				c = Class.forName(clsname);
				IAppThreadService service = (IAppThreadService)c.newInstance();
				Thread t = new Thread(service);
				t.start();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				logger.error("service["+servname+"] not found! "+e.getMessage());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				logger.error("service["+servname+"] instantiation exception! "+e.getMessage());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				logger.error("service["+servname+"] illegal accessing exception! "+e.getMessage());
			}
		}
		// TODO Auto-generated method stub
		super.init(config);
	}

}
