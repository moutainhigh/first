package com.deppon.dpm.module.management.server.service.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.deppon.dpm.module.management.server.ApplicationTestXML;
import com.deppon.dpm.module.management.server.service.IReserveSubmitSerivce;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.dpm.module.management.shared.domain.TimeEntity;

public class ReserveSubmitSerivceTest extends JunitTest {

	ApplicationTestXML xml = new ApplicationTestXML();
		
	private IReserveSubmitSerivce service = null;
	
	@Before
	public void setUp(){
		this. service = (IReserveSubmitSerivce)xml.getBean("reserveSubmitSerivce");
	}
	
	@Test
	public void getDayTimeList() {
		Date date = new Date();
		int playRoomId = 0;
		this.service.getDayTimeList(date, playRoomId);	
	}
	
	@Test
	public void addReserveEntity() {
		ReserveRecordEntity entity = new ReserveRecordEntity();
		entity.setSiteMark(0);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setStartTime(new Date());
		entity.setAreaCode("0001");
		entity.setEndTime(new Date());
		entity.setRoomCode("009");
		entity.setUserNo("439923");
		this.service.addReserveEntity(entity);
	}

	@Test
	public void isCanAdd() throws ParseException {
		ReserveRecordEntity entity = new ReserveRecordEntity();
		entity.setSiteMark(0);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setStartTime(new Date());
		entity.setAreaCode("0001");
		entity.setEndTime(new Date());
		try{
			this.service.addReserveEntity(entity);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void isCanAddList() throws ParseException {
		List<TimeEntity> list = new ArrayList<TimeEntity>();
		TimeEntity time = new TimeEntity();
		time.setStartTime(new Date());
		time.setEndTime(new Date());
		list.add(time);
		int playRoomId = 0 ;
		this.service.isCanAddList(list, playRoomId);
		
	}

	@Test
	public void canBeReserve() {
		ReserveRecordEntity entity = new ReserveRecordEntity();
		entity.setStartTime(new Date());
		entity.setEndTime(new Date());
		this.service.canBeReserve(entity);
	}

	@Test
	public void canBeReserveList() {
		List<TimeEntity> list = new ArrayList<TimeEntity>();
		String userNo = "";
		int siteMark = 0;
		this.service.canBeReserveList(list, userNo, siteMark);
	}
	

	@Test
	public void getReserveRecordList() {
		String fromTime = "2015-10-11";
		String toTime = "2015-10-12";
		this.service.getReserveRecordList(fromTime, toTime);
	}

}
