package com.deppon.dpm.module.wechat.server.dao;

import java.util.List;

import net.sf.json.JSONObject;

import com.deppon.dpm.module.wechat.shared.domain.WechatDelleteUserInfoEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatExecuteResultEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatOrgInfoEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatUserInfoEntity;
import com.deppon.dpm.module.wechat.shared.dto.DepartmentDto;
import com.deppon.dpm.module.wechat.shared.dto.JobDto;
import com.deppon.dpm.module.wechat.shared.dto.UserDto;

public interface IWechatTongxunluDao {
	/**
	 * 获取所有组织部门信息
	 * @return
	 */
	public List<WechatOrgInfoEntity> getOrgInfoAll();
	/**
	 * 获取所有员工信息 增量
	 * @return
	 */
	public List<WechatUserInfoEntity> getUserInfoAll();
	/**
	 * 全量更新员工  只在上线的时候执行一次
	 */
	public List<WechatUserInfoEntity> getUserInfoForOnce();
	/**
	 * 从微信拉取部门信息 存入数据库中
	 */
	public int insertDepartmentInfo(List<DepartmentDto> departmentsList);
	/**
	 * 从微信拉取员工信息 存入数据库中
	 * @return
	 */
	public int insertUserInfo(List<UserDto> userList);
	/**
	 * 把执行结果获取得jodid存入数据库中 方便异常排查
	 * @return
	 */
	public int insertJobInfo(JobDto job);
	/**
	 * 删除最近三天离职的员工信息
	 * @return
	 */
	public List<WechatDelleteUserInfoEntity> delUserInfo();
	/**
	 * 获取微信同步结果
	 * @return
	 */
	public WechatExecuteResultEntity executeResult(int type);
	/**
	 * 更新单个员工信息
	 * @param empcode
	 * @return
	 */
	public WechatUserInfoEntity getUserInfoByEmpcode(String empcode);
	/**
	 * 查询M6 M7 M8 M9的人员信息
	 * @param level
	 * @return
	 */
	public List<String> getUserInfoByManagerLevel(String level);
	
}
