package com.deppon.dpm.module.management.server.service.test;

import org.junit.Before;
import org.junit.Test;

import com.deppon.dpm.module.management.server.ApplicationTestXML;
import com.deppon.dpm.module.management.server.service.impl.StandardTableService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;

public class StandardTableServiceTest  extends JunitTest{

	/*@Override
	public Response updateStandardTable(String json) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	ApplicationTestXML xml = new ApplicationTestXML();
	
	StandardTableService service = null;	
	@Before
	public void setUp(){
		this.service = (StandardTableService) xml.getBean("standarService");
	}

	@Test
	public void updateStandardTable() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("{");
		sb.append("\"navCode\":\"YSBW0001-4\",");
		sb.append("\"navName\":\"招牌\",");
		sb.append("\"origItemCode\":\"YSSX0001-52\",");
		sb.append("\"origItemName\":\"招牌面板\",");
		sb.append("\"standName\":\"平整；无色差；无破损划痕；按标准组织排水；符合施工工艺；\",");
		sb.append("\"isKeyPro\":\"是\",");
		sb.append("\"score\":2,");
		sb.append("\"checkMethed\":\"近距离目测，正面，侧面，底面\",");
		sb.append("\"status\":\"1\"");
		sb.append("}");
		sb.append("]");
		this.service.updateStandardTable(sb.toString());
	}

}
