package com.deppon.dpm.module.wechat.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.deppon.dpm.module.wechat.server.dao.IWechatTongxunluDao;
import com.deppon.dpm.module.wechat.shared.domain.WechatDelleteUserInfoEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatExecuteResultEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatOrgInfoEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatUserInfoEntity;
import com.deppon.dpm.module.wechat.shared.dto.DepartmentDto;
import com.deppon.dpm.module.wechat.shared.dto.JobDto;
import com.deppon.dpm.module.wechat.shared.dto.UserDto;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class WechatTongxunluDao extends iBatis3DaoImpl implements IWechatTongxunluDao {
	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.module.wechat.server.dao.impl.WechatTongxunluDao.";
	/**
	 * 获取所有部门信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WechatOrgInfoEntity> getOrgInfoAll() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAMESPACE + "selectOrgInfoAll");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WechatUserInfoEntity> getUserInfoAll() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAMESPACE + "selectUserInfoAll");
	}

	@Override
	public int insertDepartmentInfo(List<DepartmentDto> departmentsList) {
		
		return  this.getSqlSession().insert(NAMESPACE + "insertDepartment", departmentsList);
	}
	
	@Override
	public int insertUserInfo(List<UserDto> userList){
		
		return  this.getSqlSession().insert(NAMESPACE + "insertUserInfo", userList);
	}

	@Override
	public int insertJobInfo(JobDto job) {
		
		return this.getSqlSession().insert(NAMESPACE + "insertJobidInfo", job);
	}

	@Override
	public List<WechatUserInfoEntity> getUserInfoForOnce() {
		// 上线第一次全量更新部门
		return this.getSqlSession().selectList(NAMESPACE + "selectUserInfoAllForOnce");
	}

	@Override
	public List<WechatDelleteUserInfoEntity> delUserInfo() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAMESPACE + "userDel");
	}

	/**
	 * 微信同步结果
	 */
	@Override
	public WechatExecuteResultEntity executeResult(int type) {
		// TODO Auto-generated method stub
		
		return (WechatExecuteResultEntity)this.getSqlSession().selectOne(NAMESPACE + "executeResult", type);
	}
	
	/**
	 * 更新单个员工信息
	 */
	@Override
	public WechatUserInfoEntity getUserInfoByEmpcode(String empcode) {
		
		return (WechatUserInfoEntity)this.getSqlSession().selectOne(NAMESPACE + "updateUserInfoSingle", empcode);
	}

	/**
	 * 根据级别查询人员信息
	 */
	@Override
	public List<String> getUserInfoByManagerLevel(String level) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(NAMESPACE + "selectUserInfoByLevel", level);
	}
}
