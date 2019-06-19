package com.deppon.dpm.module.management.server.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.deppon.dpm.module.management.server.ApplicationTestXML;
import com.deppon.dpm.module.management.server.dao.IServeOriginatorsMessageDao;
import com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;

public class ServeOriginatorsMessageServiceTest extends JunitTest{

	private IServeOriginatorsMessageDao serveOriginatorsMessageDao;
	
	ApplicationTestXML xml = new ApplicationTestXML();
	
	private IServeOriginatorsMessageService service = (IServeOriginatorsMessageService) xml.getBean("serveOriginatorsMessageService");;
	
	@Before
	public void setUp(){
		this.service = (IServeOriginatorsMessageService) xml.getBean("serveOriginatorsMessageService");
	}
	
	@Test
	public void getImageUrl() {
		List<String> userList = new ArrayList<String>();
		userList.add("268105");
		this.service.getImageUrl(userList);
	}

	@Test
	public void saveServePartInfo() {
		ServeParticipantsInfoEntity entity = new ServeParticipantsInfoEntity();
		entity.setOrigId(10);
		entity.setCreateTime(new Date());
		entity.setPartTel("te");
		entity.setPartName("xiao qiang");
		entity.setPartNO("000008");
		this.service.saveServePartInfo(entity);
	}

	@Test
	public void saveServeOriginatorInfo() {
		ServeOriginatorsInfoEntity entity = new ServeOriginatorsInfoEntity();
		entity.setCreateTime(new Date());
		entity.setLimitNum(4);
		entity.setOrigName("test");
		entity.setOrigNo("000008");
		entity.setStartTime(new Date());
		entity.setOrigTel("test");
		entity.setStartPlace("sh");
		entity.setEndPlace("bj");
		entity.setCarType(1);
		entity.setPartTime(new Date());
		this.service.saveServeOriginatorInfo(entity);
	}

	/*@Test
	public void getImageURL() {
		String userNo = "00872";
		this.service.getImageURL(userNo);
	}
*/
	@Test
	public void getLimitSize() {
		int id = 10;
		this.service.getLimitSize(id);
	}
	@Test
	public void checkOrigRepeatTest() {
		ServeOriginatorsInfoEntity entity = new ServeOriginatorsInfoEntity();
		entity.setOrigNo("237396");
		entity.setStartTime(new Date());
		entity.setStartPlace("徐泾东");
		entity.setEndPlace("公司");
		this.service.checkOrigRepeat(entity);
		
	}
	@Test
	public void checkPartRepeatTest() {
		ServeParticipantsInfoEntity entity = new ServeParticipantsInfoEntity();
		entity.setOrigId(398);
		entity.setPartNO("074115");
		this.service.checkPartRepeat(entity);
	}
	@Test
	public void updatePartInfoTest() {
		ServeParticipantsInfoEntity entity = new ServeParticipantsInfoEntity();
		entity.setPartName("ccf");
		entity.setPartTel("13761302259");
		entity.setRemark("哈哈哈哈来吧,gogoogogo");
		entity.setPartNO("268101");
		entity.setPartState(0);
		entity.setOrigId(398);
		this.service.updatePartInfo(entity);
	}
	@Test
	public void getImageURLTest() {
		this.service.getImageURL("268101");
	}
	@Test
	public void getLimitSizeTest() {
		this.service.getLimitSize(397);
		
	}

	public IServeOriginatorsMessageDao getServeOriginatorsMessageDao() {
		return serveOriginatorsMessageDao;
	}

	public void setServeOriginatorsMessageDao(
			IServeOriginatorsMessageDao serveOriginatorsMessageDao) {
		this.serveOriginatorsMessageDao = serveOriginatorsMessageDao;
	}
	
	

}
