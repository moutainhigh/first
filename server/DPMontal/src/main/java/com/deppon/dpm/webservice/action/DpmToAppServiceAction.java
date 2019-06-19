package com.deppon.dpm.webservice.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deppon.montal.action.RootAbstractAction;
import com.deppon.montal.util.InitDataServlet;

public class DpmToAppServiceAction extends RootAbstractAction{

	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    @SuppressWarnings("unused")
	@Override
    public void init() throws ServletException {
    	
//    	String basePath = "http://127.0.0.1:8080/DpmToAppService";
    	InitDataServlet in = new InitDataServlet();
//    	dpmToAppServiceAnnounce(in.getValue("dpmToAppServiceAdress"));
		
    }
	public static void dpmToAppServiceAnnounce(String path) {
		
//		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
//		factory.setAddress(path);
//		factory.setServiceClass(DpmToAppServiceImpl.class);
//		Server server = factory.create();
//		server.start();
		
	}

}
