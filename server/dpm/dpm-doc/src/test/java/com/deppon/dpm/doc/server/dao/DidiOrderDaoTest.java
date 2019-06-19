package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.DidiOrderDao;
import com.deppon.dpm.doc.server.entity.Customer2DphxRequestEntity;
import com.deppon.dpm.doc.server.entity.Customer2DphxResponseEntity;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.Member2DphxEntity;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.dpm.doc.server.vo.DidiBankCardVO;
import com.deppon.dpm.doc.server.vo.EmployeeVO;

public class DidiOrderDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private DidiOrderDao didiOrderDao;
	
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiOrderDao = (DidiOrderDao) appContext.getBean("didiOrderDao");
	}
	/*
	 * testinsert
	 */
	@Test
	public void testinsert() {
		Customer2DphxRequestEntity q1 = new Customer2DphxRequestEntity();
		q1.setTel(q1.getTel());
		
		Customer2DphxResponseEntity q2 = new Customer2DphxResponseEntity();
		q2.setErrorMsg(q2.getErrorMsg());
		q2.setIfSuccess(q2.getIfSuccess());
		q2.setiMember(q2.getiMember());
		
		Member2DphxEntity w1 = new Member2DphxEntity();
		w1.setCustCode(w1.getCustCode());
		w1.setCustName(w1.getCustName());
		w1.setCustStatus(w1.getCustStatus());
		w1.setCustType(w1.getCustType());
		
		DidiBankCardVO d1 = new DidiBankCardVO();
		d1.setBankCardNumber(d1.getBankCardNumber());
		d1.setCardHolder(d1.getCardHolder());
		d1.setDeptCode(d1.getDeptCode());
		d1.setId(d1.getId());
		d1.setUserDept(d1.getUserDept());
		d1.setUserId(d1.getUserId());
		
		DiDiRecordVO qq = new DiDiRecordVO();
		qq.setAmount(qq.getAmount());
		qq.setCarremark(qq.getCarremark());
		qq.setComment(qq.getComment());
		qq.setDept(qq.getDept());
		qq.setFromName(qq.getFromName());
		qq.setId(qq.getId());
		qq.setRecordpic(qq.getRecordpic());
		qq.setRecordpicArray(qq.getRecordpicArray());
		qq.setRecordstate(qq.getRecordstate());
		qq.setRecordtime(qq.getRecordtime());
		qq.setRecordtype(qq.getRecordtype());
		qq.setTaxidate(qq.getTaxidate());
		qq.setToName(qq.getToName());
		qq.setUserId(qq.getUserId());
		qq.setUserName(qq.getUserName());
		
		EmployeeVO aa = new EmployeeVO();
		aa.setAddress(aa.getAddress());
		aa.setBirthDate(aa.getBirthDate());
		aa.setCallFrequency(aa.getCallFrequency());
		aa.setCardNo(aa.getCardNo());
		aa.setCardType(aa.getCardType());
		aa.setCreateTime(aa.getCreateTime());
		aa.setDepart(aa.getDepart());
		aa.setDeptSeq(aa.getDeptSeq());
		aa.setEmail(aa.getEmail());
		aa.setEmailPassword(aa.getEmailPassword());
		aa.setEmailUserName(aa.getEmailUserName());
		aa.setEmpCode(aa.getEmpCode());
		aa.setEmpId(aa.getEmpId());
		aa.setEmpName(aa.getEmpName());
		aa.setEmpStatus(aa.getEmpStatus());
		aa.setFurlough(aa.getFurlough());
		aa.setGender(aa.getGender());
		aa.setHandoverPerson(aa.getHandoverPerson());
		aa.setHeadPhoto(aa.getHeadPhoto());
		aa.setInDate(aa.getInDate());
		aa.setJobDuty(aa.getJobDuty());
		aa.setJobGroups(aa.getJobGroups());
		aa.setJobLevel(aa.getJobLevel());
		aa.setJobName(aa.getJobName());
		aa.setJobSequence(aa.getJobSequence());
		aa.setLimit(aa.getLimit());
		aa.setMobileNo(aa.getMobileNo());
		aa.setMyFavoritesStatus(aa.getMyFavoritesStatus());
		aa.setOrgId(aa.getOrgId());
		aa.setOrgName(aa.getOrgName());
		aa.setParentOrgId(aa.getParentOrgId());
		aa.setStart(aa.getStart());
		aa.setTel(aa.getTel());
		aa.setUpdateTime(aa.getUpdateTime());
		aa.setZipCode(aa.getZipCode());
		
		DidiOrderEntity didiOrder = new DidiOrderEntity();
		didiOrder.setBillno("1125900159586568");
		didiOrderDao.insert(didiOrder);
	}
	/*testfind
	 * 
	 */
//	@Test
//	public void testfind() {
//		DidiOrderEntity didiOrder = new DidiOrderEntity();
//		didiOrder.setBillno("1125900159586568");
//		didiOrderDao.find(didiOrder);
//	}
	/*
	 * testupdate
	 */
	@Test
	public void testupdate() {
		DidiOrderEntity didiOrder = new DidiOrderEntity();
		didiOrder.setBillno("1125900159586568");
		didiOrderDao.update(didiOrder);
	}
	/*
	 * testdelete
	 */
	@Test
	public void testdelete() {
		DidiOrderEntity didiOrder = new DidiOrderEntity();
		didiOrder.setBillno("1125900159586568");
		didiOrderDao.delete(didiOrder);
	}
	/*
	 * testdeleteBatch
	 */
	@Test
	public void testdeleteBatch() {
		String ids = "1";
		didiOrderDao.deleteBatch(ids);
	}
	
}
