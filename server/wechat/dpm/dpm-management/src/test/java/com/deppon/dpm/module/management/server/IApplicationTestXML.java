package com.deppon.dpm.module.management.server;


public abstract class IApplicationTestXML {
	
	
	abstract void setApplicationContext(String xmlPath);
	
	abstract Object getBean(String nameSpace);
}
