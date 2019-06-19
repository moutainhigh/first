package com.deppon.dpm.store.server.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.store.server.dao.impl.QueryTaskInfoDao;
import com.deppon.dpm.store.server.entity.QueryAppraisal;
import com.deppon.dpm.store.server.entity.QueryModInfo;
import com.deppon.dpm.store.server.entity.QueryTaskInfo;

import junit.framework.TestCase;
/**
 * 
 * @author RY
 *
 */
public class QueryTaskInfoDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	/**
	 * dao
	 */
	QueryTaskInfoDao queryTaskInfoDao;
	@Before
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("classpath:com/deppon/dpm/store/server/META-INF/spring.xml");//
		queryTaskInfoDao =  (QueryTaskInfoDao) appContext.getBean("QueryTaskInfoDao");//
	}
	@Test
	public void test(){
		QueryAppraisal qa = new QueryAppraisal();//
		qa.setFeedbackinfo(qa.getFeedbackinfo());//
		qa.setGrade(qa.getGrade());//
		qa.setMarkinfo(qa.getMarkinfo());//
		qa.setModid(qa.getModid());//
		qa.setPhoto(qa.getPhoto());//
		qa.setPiclist(qa.getPiclist());//
		qa.setPicpath(qa.getPicpath());//
		
		QueryModInfo qmi = new QueryModInfo();//
		qmi.setFirstmodid(qmi.getFirstmodid());//
		qmi.setFirstmodname(qmi.getFirstmodname());//
		qmi.setSecondmodid(qmi.getSecondmodid());//
		qmi.setSecondmodname(qmi.getSecondmodname());//
		
		QueryTaskInfo qti=new QueryTaskInfo();//
		qti.setDenominator(qti.getDenominator());//
		qti.setDeptname(qti.getDeptname());//
		qti.setEndtime(qti.getEndtime());//
		qti.setExeer(qti.getExeer());//
		qti.setExeerid(qti.getExeerid());//
		qti.setIsoverdue(qti.getIsoverdue());//
		qti.setJobname(qti.getJobname());//
		qti.setNum(qti.getNum());//
		qti.setNumerator(qti.getNumerator());//
		qti.setOrgname(qti.getOrgname());//
		qti.setOverdueTime(qti.getOverdueTime());//
		qti.setPictpath(qti.getPictpath());//
		qti.setStarttime(qti.getStarttime());//
		qti.setSublistendtime(qti.getSublistendtime());//
		qti.setTaskcreator(qti.getTaskcreator());//
		qti.setTaskid(qti.getTaskid());//
		qti.setTaskname(qti.getTaskname());//
		qti.setTaskstatus(qti.getTaskstatus());//
		qti.setTestgrade(qti.getTestgrade());//
		
		String exeid="123";//
		String feedbackinfo="123";//
		String picpath="1.jpg";//
		String submittime = "2018-06-19 09:00:00";//
		String taskid="123";//
		String finishtime= "2018-06-19 10:00:00";//
		String firstmodid="firstmodid";//
		String secondmodname ="secondmodname";//
		String secondremarks = "secondremarks";//
		
		
		
	}
}
