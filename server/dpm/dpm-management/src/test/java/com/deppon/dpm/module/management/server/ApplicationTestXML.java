package com.deppon.dpm.module.management.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ApplicationTestXML {

	
	public ApplicationContext context = null;

	public ApplicationTestXML(){}
	
	public ApplicationTestXML(String nameSpace){
		context = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
	}

	public Object getBean(String nameSpace) {
		if(context == null){
			context = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		}
		return context.getBean(nameSpace);
	}

	public void setApplicationContext(String xmlPath) {
		this.context = new ClassPathXmlApplicationContext(xmlPath);
	}

}
