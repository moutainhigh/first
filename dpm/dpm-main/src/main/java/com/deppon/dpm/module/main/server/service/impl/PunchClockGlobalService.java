package com.deppon.dpm.module.main.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.module.common.shared.vo.OrganizationEntity;
import com.deppon.dpm.module.main.server.dao.IMainPageDao;
import com.deppon.dpm.module.main.server.dao.IPunchClockGlobalDao;
import com.deppon.dpm.module.main.server.service.IPunchClockGlobalService;
import com.deppon.dpm.module.main.shared.domain.PunchClockPositionGlobalEntity;

public class PunchClockGlobalService implements IPunchClockGlobalService {
	
	private IPunchClockGlobalDao punchClockGlobalDao;
	
	private IMainPageDao mainPageDao;

	private JdbcTemplate template;
	
	private static List<String> managers = new ArrayList<String>();
	
	static{
		managers.add("106998");
		managers.add("021198");
		//上海徐汇营业区
		managers.add("097496");
		managers.add("177380");
		managers.add("379615");
		managers.add("219128");
		managers.add("445258");
		managers.add("296204");
		managers.add("484888");
		managers.add("409497");
		managers.add("402570");
		managers.add("377182");
		managers.add("072419");
		managers.add("138881");
		managers.add("153698");
		managers.add("177340");
		managers.add("472203");
		//上海闵行营业区
		managers.add("071070");
		managers.add("260467");
		managers.add("303946");
		managers.add("209362");
		managers.add("490580");
		managers.add("630983");
		managers.add("171839");
		managers.add("499408");
		managers.add("120401");
		managers.add("073278");
		managers.add("175836");
		managers.add("515935");
		managers.add("252030");
	}
	
	public IPunchClockGlobalDao getPunchClockGlobalDao() {
		return punchClockGlobalDao;
	}

	public void setPunchClockGlobalDao(IPunchClockGlobalDao punchClockGlobalDao) {
		this.punchClockGlobalDao = punchClockGlobalDao;
	}

	public IMainPageDao getMainPageDao() {
		return mainPageDao;
	}

	public void setMainPageDao(IMainPageDao mainPageDao) {
		this.mainPageDao = mainPageDao;
	}
	
	@Override
	public int addClockPosition(PunchClockPositionGlobalEntity entity) {
		
		//设定一条新的打卡位置
		return punchClockGlobalDao.addClockPosition(entity);
	}
	
	@Override
	@Transactional
	public int updateClockPosition(PunchClockPositionGlobalEntity entity) throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("orgId", Integer.toString(entity.getOrgId()));
		param.put("isEnable", "1");
		PunchClockPositionGlobalEntity temp = null;
		
		List<PunchClockPositionGlobalEntity> temps = punchClockGlobalDao.getPunchClockAvailablePosition(param);
		if(null == temps){
			return 0;
		}
		temp = temps.get(0);
		//更新打卡位置为无效，变为历史记录
		int update = punchClockGlobalDao.updateClockPosition(temp);
		
		//新增有效待审核的打卡位置
		temp.setManagerId(entity.getManagerId());
		temp.setLatitude(entity.getLatitude());
		temp.setLongitude(entity.getLongitude());
		temp.setRadius(entity.getRadius());
		temp.setIsEnable(1);
		temp.setVerifyStatus(0);
		temp.setSalesDepartAddr(entity.getSalesDepartAddr());
		//手机及设备信息
		temp.setAppVersion(entity.getAppVersion());
		temp.setOsType(entity.getOsType());
		temp.setOsVersion(entity.getOsVersion());
		temp.setPhoneModel(entity.getPhoneModel());
		temp.setDeviceToken(entity.getDeviceToken());
		
		int insert = punchClockGlobalDao.addClockPosition(temp);
		
		return (update > 0 && insert > 0) ? 1 : 0;
	}

	@Override
	public boolean isDepartmentManager(String empCode) throws Exception{
		/*
		try {
			List<OrganizationEntity> orgList = punchClockGlobalDao.getOrgIdByEmpCode(empCode);
			if(null == orgList || orgList.isEmpty()){
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		*/
		List<String> managers=this.queryList();
		if(!managers.contains(empCode)){
			return Boolean.FALSE;
		}
		/*String managerId = punchClockGlobalDao.getManagerIdByEmpcode(empCode);
		if(managerId.equals(empCode)){
			return Boolean.TRUE;
		}*/
		
		return Boolean.TRUE;
	}

	@Override
	public List<OrganizationEntity> getOrgIdByEmpCode(String empCode) throws Exception{
		
		return punchClockGlobalDao.getOrgIdByEmpCode(empCode);
	}

	@Override
	public List<PunchClockPositionGlobalEntity> getPunchClockPositionByOrgId(
			Map<String, String> param) throws Exception{
		
		//根据部门ID获取部门有效打卡位置信息
		List<PunchClockPositionGlobalEntity> list = punchClockGlobalDao.getPunchClockPositionByOrgId(param);
		if(null != list && !list.isEmpty()){
			return list;
		}
		//获取当前部门信息
		List<OrganizationEntity> orgList = punchClockGlobalDao.getOrgById(param.get("orgId"));
		if(null == orgList || orgList.isEmpty()){
			return null;
		}
		OrganizationEntity org = orgList.get(0);
		//获取上级部门信息
		List<OrganizationEntity> orgParentList = punchClockGlobalDao.getOrgById(Integer.valueOf(org.getParentOrgId()).toString());
		if(null == orgParentList || orgParentList.isEmpty()){
			return null;
		}
		OrganizationEntity orgParent = orgParentList.get(0);
		//判断当前部门的部门经理和上级部门的部门经理是否为同一个人
		String manager = org.getManagerId();
		String managerParent = orgParent.getManagerId();
		if(StringUtils.isBlank(manager) || StringUtils.isBlank(managerParent)){
			return null;
		}
		//如果当前部门的部门经理和上级部门的部门经理为同一个人
		if(!manager.equalsIgnoreCase(managerParent)){
			return null;
		}
		//获取上级部门打卡位置信息
		param.put("orgId", Integer.valueOf(orgParent.getOrgId()).toString());
		
		return punchClockGlobalDao.getPunchClockPositionByOrgId(param);
	}

	@Override
	public int updateClockPositionStatus(Map<String, Object> param) throws Exception{
		
		return punchClockGlobalDao.updateClockPositionStatus(param);
	}

	@Override
	public List<PunchClockPositionGlobalEntity> getPunchClockAvailablePosition(
			Map<String, String> param) throws Exception {
		
		return punchClockGlobalDao.getPunchClockAvailablePosition(param);
	}

	@Override
	public int addNoticeDetail(Map<String, String> notice) {
		
		return mainPageDao.addNoticeDetail(notice);
	}

	@Override
	public List<OrganizationEntity> getOrgById(String orgId) throws Exception {
		
		return punchClockGlobalDao.getOrgById(orgId);
	}

	@Override
	public List<PunchClockPositionGlobalEntity> getPositionByParentOrgId(
			Map<String, String> param) throws Exception {
		
		return punchClockGlobalDao.getPositionByParentOrgId(param);
	}

	@Override
	public PunchClockPositionGlobalEntity getPunchClockPositionById(int id)
			throws Exception {
		
		return punchClockGlobalDao.getPunchClockPositionById(id);
	}

	//查询所有数据
	public List<String> queryList() {
		//sql
		String sql = "SELECT userid FROM autoPunchGlobalAddress_permission ";
		//执行sql
		List<String> list = template.query(sql, new RowMapper<String>(){
			//实现方法
			public String mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				String appPermission=rs.getString(1);
				//返回
				return appPermission;
			}

		});

		return list;
	}



	public void setAutoPunchGlobalAddressService(String autoPunchGlobalAddressService) {
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
