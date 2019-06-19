package com.deppon.dpm.module.announce.server.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.announce.server.dao.IDpmExpressDao;
import com.deppon.dpm.module.announce.server.service.IDpmExpressService;
import com.deppon.dpm.module.announce.shared.domain.DpmExpress;
import com.deppon.dpm.module.announce.shared.domain.EmpDivisionEntity;
import com.deppon.dpm.module.common.server.util.JdbcTemplateUtil;

/**
 * 早安快递数据的service层处理
 * 
 * @author 231586
 * 
 */
public class ExpressService implements IDpmExpressService {
	
	// set injection
	private IDpmExpressDao iDpmExpressDao;
	/**
	 * 从oa同步早安快递
	 */
	@Override
	public void syncFromOa(DpmExpress dpmExpress) {
		// 同步插入数据
		iDpmExpressDao.syncFromOa(dpmExpress);
	}
	
	/**
	 * jdbcTemplate
	 */
	private JdbcTemplate template;

	/**
	 * 根据id获取早安快递
	 */
	@Override
	public DpmExpress getExpressById(String userId, int id, String morningType) {
		// 根据id获取早安快递数据
		return iDpmExpressDao.getExpressById(userId, id, morningType);
	}
	
	/**
	 * 获取历史数据
	 */
	@Override
	public List<DpmExpress> getHistory(String userId, String morningType) {
		// 获取早安快递历史数据
		return iDpmExpressDao.getHistory(userId, morningType);
	}

	/**
	 * 完成学习模块
	 */
//	@Transactional("transactionManager")
	@Override
	public void study(String userId, int id, int part) {
		//封装参数
		Map<String,Serializable> map = new HashMap<String,Serializable>();
		// 工号
		map.put("userId", userId);
		// id
		map.put("id", id);
		//查询第一次学习的时间
		Date studyTime = iDpmExpressDao.getFirstStudyTime(map);
		// 模块
		map.put("part" + part, part);
		map.put("studyTime", studyTime);
		// 学习
		iDpmExpressDao.study(map);
	}

	/**
	 * 获取今天的早安快递数据
	 * 
	 * @param userId
	 * @param morningType
	 * @return
	 */
//	@Transactional("transactionManager")
	@Override
	public DpmExpress getExpressToday(String userId, String morningType) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("morningType", morningType);
		String divisionName = "";
		//1、根据工号查事业部表有没有对应的事业部信息（关联员工表）
		EmpDivisionEntity empDivisionEntity = iDpmExpressDao.getDivisionEntity(userId);
		//2、判断是否有相应数据
		if(null == empDivisionEntity){
			//没有，说明用户是第一次使用早安快递，则需要查询用户所在的事业部
			divisionName = iDpmExpressDao.getDivisionName(userId);
			//sql
			String sql = "SELECT a.DEPTSEQ from om_organization a " +
					"INNER JOIN om_employee b ON a.ORGID = b.ORGID AND b.empcode = ?";
			//查询出该员工所在部门组织id
			String currentDeptSeq = JdbcTemplateUtil.queryForString(template, sql, new String[]{userId});
			//封装参数
			empDivisionEntity = new EmpDivisionEntity();
			empDivisionEntity.setEmpCode(userId);
			empDivisionEntity.setUpdateTime(new Date());
			empDivisionEntity.setDivision(divisionName);
			empDivisionEntity.setCurrentDeptSeq(currentDeptSeq);
			//插入数据
			iDpmExpressDao.insetEmpDivisionInfo(empDivisionEntity);
		}else if(empDivisionEntity.getCurrentDeptSeq().equals(empDivisionEntity.getDeptSeq())){
			//相同表示人员没有异动，直接获取对应的事业部即可
			divisionName = empDivisionEntity.getDivision();
		}else{
			//表示人员所在部门有异动需要查询最新的所在事业部
			divisionName = iDpmExpressDao.getDivisionName(userId);
			empDivisionEntity.setDivision(divisionName);
			empDivisionEntity.setUpdateTime(new Date());
			empDivisionEntity.setCurrentDeptSeq(empDivisionEntity.getDeptSeq());
			//更新数据
			iDpmExpressDao.updateEmpDivisionInfo(empDivisionEntity);
		}
		//封装参数
		map.put("division", divisionName);
		//3、插入早安快递学习进度数据
		iDpmExpressDao.insertExpressStudy(map);
		//4、今天的数据查询
		return iDpmExpressDao.getExpressToday(map);
	}

	/**
	 * get
	 * @return
	 */
	public IDpmExpressDao getiDpmExpressDao() {
		return iDpmExpressDao;
	}

	/**
	 * set
	 * @param iDpmExpressDao
	 */
	public void setiDpmExpressDao(IDpmExpressDao iDpmExpressDao) {
		this.iDpmExpressDao = iDpmExpressDao;
	}
	/**
	 * setter
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
