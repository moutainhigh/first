package com.deppon.dpm.doc.server.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.AddMessageDao;
import com.deppon.dpm.doc.server.entity.DDOrderRequestEntity;
import com.deppon.dpm.doc.server.entity.DidiCityEntity;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.DidiTicketEntity;
import com.deppon.dpm.doc.server.entity.OccupyBudgetResponseEntity;
import com.deppon.dpm.doc.server.entity.OccupyBudgetRquestEntity;
import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.entity.QueryRquestBudgetEntity;
import com.deppon.dpm.doc.server.entity.SmsInfo;
import com.deppon.dpm.doc.server.vo.CitiesClassVO;
import com.deppon.dpm.doc.server.vo.CitiesInfoVO;
import com.deppon.dpm.doc.server.vo.CityResultVO;
import com.deppon.dpm.doc.server.vo.DidiOrderDetailVO;
import com.deppon.dpm.doc.server.vo.DidiOrderVO;
import com.deppon.dpm.doc.server.vo.DidiTicketItemVO;
import com.deppon.dpm.doc.server.vo.DidiTicketResultVO;
import com.deppon.dpm.doc.server.vo.DidiTicketVO;
import com.deppon.dpm.doc.server.vo.Lineup_InfoVO;
import com.deppon.dpm.doc.server.vo.OrderVO;
import com.deppon.dpm.doc.server.vo.PriceDetailVO;
import com.deppon.dpm.doc.server.vo.PriceVO;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.doc.server.vo.Reassign_InfoVO;

public class AddMessageDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private AddMessageDao addMessageDao;
	
	@Before
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		addMessageDao = (AddMessageDao) appContext.getBean("addMessageDao");
	}
	
	@Test
	public void testinsert(){
		
		DDOrderRequestEntity dds = new DDOrderRequestEntity();
		dds.setBillno(dds.getBillno());
		dds.setBoardingtime(dds.getBoardingtime());
		dds.setDept(dds.getDept());
		dds.setEmployeeno(dds.getEmployeeno());
		dds.setEstimateAmount(dds.getEstimateAmount());
		dds.setFinancedept(dds.getFinancedept());
		dds.setFromName(dds.getFromName());
		dds.setId(dds.getId());
		dds.setModels(dds.getModels());
		dds.setName(dds.getName());
		dds.setNormalDistance(dds.getNormalDistance());
		dds.setOfftime(dds.getOfftime());
		dds.setOrderstatus(dds.getOrderstatus());
		dds.setSub_status(dds.getSub_status());
		dds.setTaxidate(dds.getTaxidate());
		dds.setToName(dds.getToName());
		dds.setTotalPrice(dds.getTotalPrice());
		
		DidiCityEntity didis = new DidiCityEntity();
		didis.setCityid(didis.getCityid());
		didis.setId(didis.getId());
		didis.setName(didis.getName());
		didis.setOpenKuaiche(didis.getOpenKuaiche());
		didis.setOpenZhuanche(didis.getOpenZhuanche());
		didis.setTs(didis.getTs());
		
		SmsInfo dsds = new SmsInfo();
		dsds.setLatestSendTime(dsds.getLatestSendTime());
		dsds.setMobile(dsds.getMobile());
		dsds.setMsgContent(dsds.getMsgContent());
		dsds.setMsgSource(dsds.getMsgSource());
		dsds.setMsgType(dsds.getMsgType());
		dsds.setRepeatState(dsds.getRepeatState());
		dsds.setSendDept(dsds.getSendDept());
		dsds.setSender(dsds.getSender());
		dsds.setSendTime(dsds.getSendTime());
		dsds.setServiceType(dsds.getServiceType());
		dsds.setUnionId(dsds.getUnionId());
		dsds.setWaybillNo(dsds.getWaybillNo());
		
		CitiesClassVO aass = new CitiesClassVO();
		aass.setCities(aass.getCities());
		aass.setName(aass.getName());
		
		CitiesInfoVO fovo = new CitiesInfoVO();
		fovo.setCityid(fovo.getCityid());
		fovo.setName(fovo.getName());
		fovo.setOpen_kuaiche(fovo.getOpen_kuaiche());
		fovo.setOpen_zhuanche(fovo.getOpen_zhuanche());
		
		CityResultVO aaass = new CityResultVO();
		aaass.setData(aaass.getData());
		aaass.setErrmsg(aaass.getErrmsg());
		aaass.setErrno(aaass.getErrno());
		
		Lineup_InfoVO ssss = new Lineup_InfoVO();
		ssss.setQueue_length(ssss.getQueue_length());
		ssss.setRanking(ssss.getRanking());
		ssss.setWait_time(ssss.getWait_time());
		
		DidiOrderDetailVO d1 = new DidiOrderDetailVO();
		d1.setBegin_charge_time(d1.getBegin_charge_time());
		d1.setCallback_info(d1.getCallback_info());
		d1.setCity(d1.getCity());
		d1.setClat(d1.getClat());
		d1.setClng(d1.getClat());
		d1.setDelay_time_start(d1.getDelay_time_start());
		d1.setDeparture_time(d1.getDeparture_time());
		d1.setDlat(d1.getDlat());
		d1.setDlng(d1.getDlng());
		d1.setDriver_avatar(d1.getDriver_avatar());
		d1.setDriver_car_color(d1.getDriver_car_color());
		d1.setDriver_car_type(d1.getDriver_car_type());
		d1.setDriver_card(d1.getDriver_card());
		d1.setDriver_level(d1.getDriver_level());
		d1.setDriver_name(d1.getDriver_name());
		d1.setDriver_num(d1.getDriver_num());
		d1.setDriver_order_count(d1.getDriver_order_count());
		d1.setDriver_phone(d1.getDriver_phone());
		d1.setDriver_phone_real(d1.getDriver_phone_real());
		d1.setEnd_address(d1.getEnd_address());
		d1.setEnd_name(d1.getEnd_name());
		d1.setExtra_info(d1.getExtra_info());
		d1.setFinish_time(d1.getFinish_time());
		d1.setFlat(d1.getFlat());
		d1.setFlng(d1.getFlng());
		d1.setId(d1.getId());
		d1.setIs_lineup(d1.getIs_lineup());
		d1.setLineup_info(d1.getLineup_info());
		d1.setNormal_distance(d1.getNormal_distance());
		d1.setNormal_time(d1.getNormal_time());
		d1.setOrder_time(d1.getOrder_time());
		d1.setPassenger_phone(d1.getPassenger_phone());
		d1.setPricing_mode(d1.getPricing_mode());
		d1.setReassign_info(d1.getReassign_info());
		d1.setRemark(d1.getRemark());
		d1.setRequire_level(d1.getRequire_level());
		d1.setStart_address(d1.getStart_address());
		d1.setStart_name(d1.getStart_name());
		d1.setStatus(d1.getStatus());
		d1.setStrive_level(d1.getStrive_level());
		d1.setStrive_time(d1.getStrive_time());
		d1.setSub_status(d1.getSub_status());
		d1.setTlat(d1.getTlat());
		d1.setTlng(d1.getTlng());
		d1.setType(d1.getType());
		
		DidiOrderVO dd = new DidiOrderVO();
		dd.setBillno(dd.getBillno());
		dd.setBoardingtime(dd.getBoardingtime());
		dd.setBudgetratio(dd.getBudgetratio());
		dd.setCompany(dd.getCompany());
		dd.setDept(dd.getDept());
		dd.setEmployeeno(dd.getEmployeeno());
		dd.setFinancedept(dd.getFinancedept());
		dd.setFromName(dd.getFromName());
		dd.setId(dd.getId());
		dd.setModels(dd.getModels());
		dd.setName(dd.getName());
		dd.setNormalDistance(dd.getNormalDistance());
		dd.setOfftime(dd.getOfftime());
		dd.setOrderstatus(dd.getOrderstatus());
		dd.setRemark(dd.getRemark());
		dd.setRemarkinfo(dd.getRemarkinfo());
		dd.setSub_status(dd.getSub_status());
		dd.setTaxidate(dd.getTaxidate());
		dd.setTimeschedule(dd.getTimeschedule());
		dd.setToName(dd.getToName());
		dd.setTotalPrice(dd.getTotalPrice());
		
		DidiTicketItemVO aa = new DidiTicketItemVO();
		aa.setAirport_id(aa.getAirport_id());
		aa.setAuth_type(aa.getAuth_type());
		aa.setCallback_info(aa.getCallback_info());
		aa.setCity_id(aa.getCity_id());
		aa.setClat(aa.getClat());
		aa.setClient_id(aa.getClient_id());
		aa.setClient_order_id(aa.getClient_order_id());
		aa.setClient_secret(aa.getClient_secret());
		aa.setClng(aa.getClng());
		aa.setDeparture_time(aa.getDeparture_time());
		aa.setEmployee_number(aa.getEmployee_number());
		aa.setFlat(aa.getFlat());
		aa.setFlight_number(aa.getFlight_number());
		aa.setFlight_time(aa.getFlight_time());
		aa.setFlng(aa.getFlng());
		aa.setForbid_city_cross(aa.getForbid_city_cross());
		aa.setFrom_name(aa.getFrom_name());
		aa.setMaster_phone(aa.getMaster_phone());
		aa.setOrganization(aa.getOrganization());
		aa.setPassenger_phone(aa.getPassenger_phone());
		aa.setRemark(aa.getRemark());
		aa.setRequire_level_list(aa.getRequire_level_list());
		aa.setRestrict_from_point(aa.getRestrict_from_point());
		aa.setTlat(aa.getTlat());
		aa.setTlng(aa.getTlng());
		aa.setTo_name(aa.getTo_name());
		
		DidiTicketItemVO qq = new DidiTicketItemVO();
		qq.setAirport_id(qq.getAirport_id());
		qq.setAuth_type(qq.getAuth_type());
		qq.setCallback_info(qq.getCallback_info());
		qq.setCity_id(qq.getCity_id());
		qq.setClat(qq.getClat());
		qq.setClient_id(qq.getClient_id());
		qq.setClient_order_id(qq.getClient_order_id());
		qq.setClient_secret(qq.getClient_secret());
		qq.setClng(qq.getClng());
		qq.setDeparture_time(qq.getDeparture_time());
		qq.setEmployee_number(qq.getEmployee_number());
		qq.setFlat(qq.getFlat());
		qq.setFlight_number(qq.getFlight_number());
		qq.setFlight_time(qq.getFlight_time());
		qq.setFlng(qq.getFlng());
		qq.setForbid_city_cross(qq.getForbid_city_cross());
		qq.setFrom_name(qq.getFrom_name());
		qq.setMaster_phone(qq.getMaster_phone());
		qq.setOrganization(qq.getOrganization());
		qq.setPassenger_phone(qq.getPassenger_phone());
		qq.setRemark(qq.getRemark());
		qq.setRequire_level_list(qq.getRequire_level_list());
		qq.setRestrict_from_point(qq.getRestrict_from_point());
		qq.setRestrict_to_point(qq.getRestrict_to_point());
		qq.setTlat(qq.getTlat());
		qq.setTlng(qq.getTlng());
		qq.setTo_name(qq.getTo_name());
		
		DidiTicketResultVO ss1 = new DidiTicketResultVO();
		ss1.setData(ss1.getData());
		ss1.setErrmsg(ss1.getErrmsg());
		ss1.setErrno(ss1.getErrno());
		
		DidiTicketVO ssw = new DidiTicketVO();
		ssw.setClient_id(ssw.getClient_id());
		ssw.setData_encode(ssw.getData_encode());
		
		OrderVO ssd = new OrderVO();
		ssd.setOrder(ssd.getOrder());
		ssd.setPrice(ssd.getPrice());
		
		PriceDetailVO as1 = new PriceDetailVO();
		as1.setAmount(as1.getAmount());
		as1.setName(as1.getName());
		as1.setType(as1.getType());
		
		PriceVO po = new PriceVO();
		po.setDetail(po.getDetail());
		po.setFee_objection(po.getFee_objection());
		po.setTotal_price(po.getTotal_price());
		
		PushMessageVO qw = new PushMessageVO();
		qw.setDept(qw.getDept());
		qw.setId(qw.getId());
		qw.setMessage(qw.getMessage());
		qw.setMsgtitle(qw.getMsgtitle());
		qw.setSavetime(qw.getSavetime());
		qw.setState(qw.getState());
		qw.setUserid(qw.getUserid());
		
		Reassign_InfoVO re = new Reassign_InfoVO();
		re.setInit_order_id(re.getInit_order_id());
		re.setLatest_order_id(re.getLatest_order_id());
		re.setNext_order_id(re.getNext_order_id());
		re.setPre_order_id(re.getPre_order_id());
		
		DidiOrderEntity ss = new DidiOrderEntity();
		ss.setBillno(ss.getBillno());
		ss.setBoardingtime(ss.getBoardingtime());
		ss.setBudgetratio(ss.getBudgetratio());
		ss.setCompany(ss.getCompany());
		ss.setDept(ss.getDept());
		ss.setEmployeeno(ss.getEmployeeno());
		ss.setFinancedept(ss.getFinancedept());
		ss.setFromName(ss.getFromName());
		ss.setId(ss.getId());
		ss.setModels(ss.getModels());
		ss.setName(ss.getName());
		ss.setNormalDistance(ss.getNormalDistance());
		ss.setOfftime(ss.getOfftime());
		ss.setOrderstatus(ss.getOrderstatus());
		ss.setRemark(ss.getRemark());
		ss.setRemarkinfo(ss.getRemarkinfo());
		ss.setSub_status(ss.getSub_status());
		ss.setTaxidate(ss.getTaxidate());
		ss.setTimeschedule(ss.getTimeschedule());
		ss.setToName(ss.getToName());
		ss.setTotalPrice(ss.getTotalPrice());
		
		DidiTicketEntity ssa = new DidiTicketEntity();
		ssa.setCompany(ssa.getCompany());
		ssa.setDef1(ssa.getDef1());
		ssa.setDef2(ssa.getDef2());
		ssa.setDef3(ssa.getDef3());
		ssa.setDef4(ssa.getDef4());
		ssa.setDef5(ssa.getDef5());
		ssa.setDept(ssa.getDept());
		ssa.setFinancedept(ssa.getFinancedept());
		ssa.setFlag(ssa.getFlag());
		ssa.setId(ssa.getId());
		ssa.setOrderId(ssa.getOrderId());
		ssa.setRemark(ssa.getRemark());
		ssa.setRemarkinfo(ssa.getRemarkinfo());
		ssa.setTicket(ssa.getTicket());
		ssa.setUserid(ssa.getUserid());
		ssa.setUsername(ssa.getUsername());
		ssa.setUsertel(ssa.getUsertel());
		
		OccupyBudgetResponseEntity ddf = new OccupyBudgetResponseEntity();
		ddf.setBusinessId(ddf.getBusinessId());
		ddf.setFailReason(ddf.getFailReason());
		ddf.setIsSuccess(ddf.getIsSuccess());
		
		OccupyBudgetRquestEntity zz = new OccupyBudgetRquestEntity();
		zz.setAmount(zz.getAmount());
		zz.setBusinessId(zz.getBusinessId());
		zz.setBusinessStartTime(zz.getBusinessStartTime());
		zz.setEmpCode(zz.getEmpCode());
		
		QueryResponseBudgetEntity xx = new QueryResponseBudgetEntity();
		xx.setDeptCode(xx.getDeptCode());
		xx.setDeptName(xx.getDeptName());
		xx.setEmpCode(xx.getEmpCode());
		xx.setFailReason(xx.getFailReason());
		xx.setIsSuccess(xx.getIsSuccess());
		xx.setLeftAmount(xx.getLeftAmount());
		xx.setThisMonthAmount(xx.getThisMonthAmount());
		xx.setToDayAmount(xx.getToDayAmount());
		
		QueryRquestBudgetEntity ddd = new QueryRquestBudgetEntity();
		ddd.setEmpCode(ddd.getEmpCode());
		
		List<String> userIdList = new ArrayList<String>();
		userIdList.add("005565");
		String dept = "95930";
		addMessageDao.insert(userIdList, dept);
	}
	@Test
	public void testupdateMessage(){
		String id = "1";
		addMessageDao.updateMessage(id);
	}
//	@Test
//	public void testqueryAlluserId(){
//		String dept = "95930";
//		addMessageDao.queryAlluserId(dept);
//	}
	@Test
	public void testqueryMessage(){
		String userId = "005565";
		addMessageDao.queryMessage(userId);
	}
}
