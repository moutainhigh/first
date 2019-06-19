package com.deppon.dpm.module.announce.server.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.module.announce.server.dao.IDpmExpressDao;
import com.deppon.dpm.module.announce.shared.domain.DpmExpress;
import com.deppon.dpm.module.announce.shared.domain.EmpDivisionEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 早安快递dao层实现
 */
public class DpmExpressDao extends iBatis3DaoImpl implements IDpmExpressDao {
	// namespace
	private String NAME_SPACE = "com.deppon.dpm.module.announce.shared.domain.express.";
	
	private String ORG_NAME_SPACE = "com.deppon.dpm.tongxunlu.server.dao.organization.";

	/**
	 * 数据同步
	 */
	@Override
	public void syncFromOa(DpmExpress dpmExpress) {
		// 插入
		getSqlSession().insert(NAME_SPACE + "insert", dpmExpress);
	}

	/**
	 * 根据id获取数据
	 */
	@Override
	public DpmExpress getExpressById(String userId, int id, String morningType) {
		// map，用以存储参数
		Map<String, Serializable> map = new HashMap<String, Serializable>();
		// 工号
		map.put("userId", userId);
		// id
		map.put("id", id);
		// 类型
		map.put("morningType", morningType);
		// 查询
		getSqlSession().selectOne(NAME_SPACE + "expressById", map);
		// 返回数据
		return (DpmExpress) getSqlSession().selectOne(
				NAME_SPACE + "selectById", map);
	}

	/**
	 * 历史数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DpmExpress> getHistory(String userId, String morningType) {
		// map，用以存储参数
		Map<String, Serializable> map = new HashMap<String, Serializable>();
		// 工号
		map.put("userId", userId);
		// 类型
		map.put("morningType", morningType);
		
		// 查询事业部表中对应的该工号数据
		EmpDivisionEntity entity = this.getDivisionEntity(userId);
		if(null != entity) {
			map.put("divisionName", entity.getDivision());
		} else {
			map.put("divisionName", this.getDivisionName(userId));
		}
		// 数据返回
		return getSqlSession().selectList(NAME_SPACE + "history", map);
	}

	/**
	 * 学习
	 */
	@Override
	public void study(Map<String,Serializable> map) {
		// 更新
		getSqlSession().update(NAME_SPACE + "study", map);
	}
	
	/**
	 * 查询第一次学习的时间
	 */
	@Override
	public Date getFirstStudyTime(Map<String, Serializable> map) {
		return (Date) this.getSqlSession().selectOne(NAME_SPACE + "selectFirstStudyTime", map);
	}
	

	// @Override
	// public String getSyb(String userId) {
	// Map<String, String> param = new HashMap<String, String>();
	// param.put("userId", userId);
	// getSqlSession().selectOne(NAME_SPACE + "getOrgName", param);
	// return param.get("orgNameResult");
	// }
	/**
	 *获取今日早安快递信息 
	 */
	@Override
	public DpmExpress getExpressToday(Map<String,String> map) {
		// 数据返回
		return (DpmExpress) getSqlSession().selectOne(
				NAME_SPACE + "expressToday", map);
	}
	
	/**
	 * 根据工号查询所在的事业部信息
	 */
	@Override
	public EmpDivisionEntity getDivisionEntity(String userId) {
		return (EmpDivisionEntity) this.getSqlSession().selectOne(NAME_SPACE + "getDivisionEntity", userId);
	}
	/**
	 * 查询该用户所在部门的最近期的早安快递的学习进度信息，若没有，则插入默认的记录
	 */
	@Override
	public void insertExpressStudy(Map<String, String> map) {
		this.getSqlSession().selectOne(NAME_SPACE + "expressLastInsert", map);
	}
	/**
	 * 根据用户id查询出所在的事业部名称
	 */
	@Override
	public String getDivisionName(String userId) {
//		return (String) this.getSqlSession().selectOne(NAME_SPACE + "getDivisionName", userId);
		// 查询出所在的部门，和父部门的id
		OrganizationEntity entity = (OrganizationEntity) this.getSqlSession().selectOne(ORG_NAME_SPACE + "getOrgByUserId", userId);
		while(entity != null && StringUtils.isNotEmpty(entity.getOrgName())
				&& !entity.getOrgName().equals("总裁")
				&& !entity.getOrgName().endsWith("事业部")
				&& !entity.getOrgName().endsWith("枢纽中心")
				&& entity.getOrgId() != entity.getParentOrgId()) {
			entity = (OrganizationEntity) this.getSqlSession().selectOne(ORG_NAME_SPACE + "getOrgById", entity.getParentOrgId());
		}
		
		if(null == entity || StringUtils.isEmpty(entity.getOrgName())
				|| entity.getOrgName().endsWith("总裁")
				|| entity.getOrgId() == entity.getParentOrgId()) {
			return "上海事业部";
		}
		return entity.getOrgName();
	}
	/**
	 * 插入员工所在部门信息记录
	 */
	@Override
	public void insetEmpDivisionInfo(EmpDivisionEntity empDivisionEntity) {
		this.getSqlSession().insert(NAME_SPACE + "insetEmpDivisionInfo", empDivisionEntity);
	}
	/**
	 * 更新员工事业部信息表
	 */
	@Override
	public void updateEmpDivisionInfo(EmpDivisionEntity empDivisionEntity) {
		this.getSqlSession().update(NAME_SPACE + "updateEmpDivisionInfo", empDivisionEntity);
	}
}
