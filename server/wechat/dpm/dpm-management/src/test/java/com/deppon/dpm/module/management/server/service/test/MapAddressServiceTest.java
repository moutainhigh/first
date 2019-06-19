package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;

import com.deppon.dpm.module.management.server.ApplicationTestXML;
import com.deppon.dpm.module.management.server.service.impl.MapAddressService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;


public class MapAddressServiceTest  extends JunitTest{

	/*
	public String getNameInfoByXY(String x, String y) {
		// TODO Auto-generated method stub
		return null;
	}*/
	ApplicationTestXML xml = new ApplicationTestXML();
	
	MapAddressService service = null;
	
	@Before
	public void setUp(){
		this.service = (MapAddressService) xml.getBean("addressService");
	}
	
	@Test
	public void getNameInfoByXY() {
		String x = "10.0";
		String y = "32.0";
		this.service.getNameInfoByXY(x, y);
	}


}
