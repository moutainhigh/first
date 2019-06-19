package com.deppon.dpm.store.server.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.store.server.dao.IStoreDynamicsDao;
import com.deppon.dpm.store.server.dao.IStoreMarkDao;
import com.deppon.dpm.store.server.dao.IStoreTaskSublistDao;
import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.service.IStoreMarkService;
import com.deppon.dpm.store.server.util.ArrayToString;
/**
 * 
 * @author XiaoTian
 *
 */
@Transactional
public class StoreMarkService implements IStoreMarkService {
	//注入dao
	private IStoreMarkDao storeMarkDao;
	/**
	 * 注入动态
	 */
	private IStoreDynamicsDao storeDynamicsDao;
	/**
	 * 注入任务子表
	 */
	private IStoreTaskSublistDao storeTaskSublistDao;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreMarkService.class);
	/**
	 * 
	 * @return
	 */
	public IStoreMarkDao getStoreMarkDao() {
		return storeMarkDao;
	}
	/**
	 * 
	 * @param storeMarkDao
	 */
	public void setStoreMarkDao(IStoreMarkDao storeMarkDao) {
		this.storeMarkDao = storeMarkDao;
	}
	
	/**
	 * 
	 * @return
	 */
	public IStoreDynamicsDao getStoreDynamicsDao() {
		return storeDynamicsDao;
	}
	/**
	 * 
	 * @param storeDynamicsDao
	 */
	public void setStoreDynamicsDao(IStoreDynamicsDao storeDynamicsDao) {
		this.storeDynamicsDao = storeDynamicsDao;
	}
	
	/**
	 * 进行模块打分,添加打分记录
	 */
	@Override
	public boolean insertMark(ArrayList<StoreMark> storeMark,String exeid){
		boolean bool = true;
		try {
		  BigDecimal countgrade = new BigDecimal("0.0");
		  List<StoreMark> storeMarks = new ArrayList<StoreMark>();
		  /*Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		  List<QueryModInfo> listQueryModInfo = storeMarkDao.selectFirstmod();
		  for (QueryModInfo queryModInfo : listQueryModInfo) {
			  map.put(queryModInfo.getFirstmodid(), queryModInfo.getCheckallgrade());
		  }*/
		  //所有模块打分分数
		  BigDecimal gradeNum = new BigDecimal("0.0");
		  BigDecimal checkgradeNum = new BigDecimal("0.0");
		  for(StoreMark storeMarkvalue : storeMark){
			  gradeNum = gradeNum.add(storeMarkvalue.getGrade());
			  checkgradeNum = checkgradeNum.add(new BigDecimal(storeMarkvalue.getCheckGarde()));
			  //将接受到的标签数组,转换为字符串以逗号分隔
			  String label = ArrayToString.arrayToStrWithComma(storeMarkvalue.getArraylabel());
			  storeMarkvalue.setLabel(label);  
			  storeMarkvalue.setPhoto(linkpht(storeMarkvalue.getArrayphoto()));
			  storeMarks.add(storeMarkvalue);
		  }
		  //批量插入模块打分数据
		  storeMarkDao.updateSelective(storeMarks);
		  // 添加动态信息,提交了考评
		  StoreTaskSublist record= new StoreTaskSublist(Long.valueOf(exeid), "待反馈",gradeNum.divide(checkgradeNum,2, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal("100")),new Date());
		  //修改任务子表状态
		  storeTaskSublistDao.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("打分模块异常,打分失败-------------");
			
			bool = false;
			logger.error("打分进行回滚------------");
			throw new RuntimeException();
		}
		return bool;
	}
	/**
	 * record
	 */
	@Override
	public int insertSelective(List<StoreMark> record) {
		// TODO Auto-generated method stub
		return storeMarkDao.insertSelective(record);
	}
	/**
	 * 
	 * @return
	 */
	public IStoreTaskSublistDao getStoreTaskSublistDao() {
		return storeTaskSublistDao;
	}
	/**
	 * 
	 * @param storeTaskSublistDao
	 */
	public void setStoreTaskSublistDao(IStoreTaskSublistDao storeTaskSublistDao) {
		this.storeTaskSublistDao = storeTaskSublistDao;
	}
	/**
	 * @param record
	 */
	@Override
	public int selectList(List<StoreMark> record) {
		// TODO Auto-generated method stub
		return storeMarkDao.selectList(record);
	}
	private String linkpht(String[] strings){
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < strings.length; i++) {
			stringBuffer.append(strings[i]);
			if (i<strings.length-1) {
				stringBuffer.append("-");
			} 
		}
		return stringBuffer.toString();
	}
}
