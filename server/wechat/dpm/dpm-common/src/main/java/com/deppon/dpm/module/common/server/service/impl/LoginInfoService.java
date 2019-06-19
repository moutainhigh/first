package com.deppon.dpm.module.common.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.common.server.dao.ILoginInfoDao;
import com.deppon.dpm.module.common.server.service.ILoginInfoService;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.LoginInfoEntity;
import com.deppon.dpm.module.common.shared.domain.UserDeviceEntity;

/**
 * 登陆service实现层
 * 
 * @author 231586
 * 
 */
public class LoginInfoService implements ILoginInfoService {
	/**
	 * logger
	 */
	private final static Logger LOG = LoggerFactory
			.getLogger(LoginInfoService.class);
	/**
	 * set injection
	 */
	private ILoginInfoDao loginInfoDao;
	/**
	 * jdbc 模板
	 */
	private JdbcTemplate template;

	/**
	 * 插入登录用户信息
	 */
	@Override
//	@Transactional("transactionManager")
	public int saveUserLogin(String userCode, String loginType, String osType, String appVersion) {
		// 获取当前时间
		Date date = new Date();
		// 创建用户实体类
		LoginInfoEntity loginInfo = new LoginInfoEntity();
		// 工号
		loginInfo.setUserCode(userCode);
		// 登录时间
		loginInfo.setLoginTime(date);
		// 登陆类型
		loginInfo.setLoginType(loginType);
		// 登陆设备类型
		loginInfo.setOsType(osType);
		// 应用版本号
		loginInfo.setAppVersion(appVersion);
		// 返回结果的错与对
		int flag = 0;
		try {
			// 插入登录记录
			flag = loginInfoDao.insert(loginInfo);
			// 插入每月登录记录
			String monthTime = new SimpleDateFormat("yyyyMM").format(date).toString();
			String sql = "INSERT INTO month_login_information (emp_code, month_login_time, count,update_time,create_time) VALUES (?,?,1,?,?) " +
					"ON DUPLICATE KEY UPDATE count = count + 1, update_time = NOW()";
			template.update(sql, userCode,Integer.parseInt(monthTime),date,date);
			// log
			LOG.info("工号为" + userCode + "的用户信息插入成功");
		} catch (Exception e) {
			// log
			LOG.error("工号为" + userCode + "的用户信息失败", e);
		} finally {
			// 重置
			date = null;
			// 重置
			loginInfo = null;
		}
		// 返回
		return flag;
	}
	
	/**
	 * 存储用户设备信息
	 */
	@Override
	public void saveUserDevice(String userId, String osType, String deviceToken) {
		List<UserDeviceEntity> list = template.query("SELECT * from om_user_device WHERE user_id = ?", new String[]{userId}, new RowMapper<UserDeviceEntity>(){

			@Override
			public UserDeviceEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDeviceEntity entity = new UserDeviceEntity();
				entity.setId(rs.getInt("id"));
				entity.setDeviceToken(rs.getString("device_token"));
				entity.setOsType(rs.getString("os_type"));
				return entity;
			}
		});
		
		// 该工号已经有了对应的推送设备信息
		if(null != list && list.size() > 0){
			// 判断传递的设备号、手机类型是否与记录中的一致，不一致则更新
			UserDeviceEntity UserDevice = list.get(0);
			if(!(UserDevice.getDeviceToken().equals(deviceToken) && UserDevice.getOsType().equals(osType))){
				this.template.update("UPDATE om_user_device SET device_token = ? , os_type = ? , update_time = NOW() WHERE id = ?",deviceToken,osType,UserDevice.getId());
			}
		} else{
			// 没有，则保存
			this.template.update("INSERT INTO om_user_device (user_id,device_token,os_type,create_time,update_time) VALUES (?,?,?,NOW(),NOW())",userId,deviceToken,osType);
		}
	}

	/**
	 * 当该用户在线的登录记录超过一条时，更正其登录状态
	 * 
	 * @param list
	 */
	private void updateStatus(List<EmpExtensionEntity> list) {
		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 1; i < list.size(); i++) {
			ids.add(list.get(i).getId());
		}
		loginInfoDao.updateStatusByIds(ids);
	}

	/**
	 * 处理参数
	 * @param parm
	 */
	private void dealEmpExtensionParm(EmpExtensionEntity parm){
		String latitude = ("".equals(parm.getLatitude())||"(null)".equals(parm.getLatitude())) ? null : parm.getLatitude();
		String longitude = ("".equals(parm.getLongitude())||"(null)".equals(parm.getLongitude())) ? null : parm.getLongitude();
		String location = ("".equals(parm.getLocation())||"(null)".equals(parm.getLocation())) ? null : parm.getLocation();
		// ios 替换 , 为 _
		String phoneModel = parm.getPhoneModel() != null ? parm.getPhoneModel().replaceAll(",", "_") : null;
		String osVersion = (parm.getOsVersion() == null||"(null)".equals(parm.getOsVersion())) ? "" : parm.getOsVersion();
		String phoneMac = (parm.getPhoneMac() == null||"(null)".equals(parm.getPhoneMac())) ? "" : parm.getPhoneMac();
		
		parm.setLatitude(latitude);
		parm.setLongitude(longitude);
		parm.setLocation(location);
		parm.setPhoneModel(phoneModel);
		parm.setOsVersion(osVersion);
		parm.setPhoneMac(phoneMac);
	}
	/**
	 * 踢出下线逻辑判断
	 */
	@Override
//	@Transactional("transactionManager")
	public EmpExtensionEntity checkDevice(String userCode, String deviceToken,
			EmpExtensionEntity parm) {
		dealEmpExtensionParm(parm);
		// 请求参数
		String osType = parm.getOsType();
		String latitude = parm.getLatitude();
		String longitude = parm.getLongitude();
		String location = parm.getLocation();
		String phoneModel = parm.getPhoneModel();
		String osVersion = parm.getOsVersion();
		String phoneMac = parm.getPhoneMac();
		String appVersion = parm.getAppVersion();
		// 日志输出
		LOG.info("LoginInfoService-->checkDevice传入参数=============>{userCode:"
				+ userCode + ",deviceToken:" + deviceToken + ",osType" + osType
				+ ",latitude:" + latitude + ",longitude:" + longitude
				+ ",location:" + location + "}");
		// 前端奇葩的传值
		if (StringUtils.isEmpty(deviceToken) || null == deviceToken
				|| "(null)".equals(deviceToken)) {
			// 直接返回，不在考虑范围之内
			return null;
		} else {
			// 实体
			EmpExtensionEntity empExtensionEntity = new EmpExtensionEntity();
			// 根据工号查询对应设备号
			// List<String> list =
			// loginInfoDao.queryDeviceNumByEmpCode(userCode);
			try {
				// 根据工号查询出所有的在线登录信息
				List<EmpExtensionEntity> list = loginInfoDao
						.queryLoginInfoByEmpCode(userCode);
				if (null != list && list.size() > 1) {
					this.updateStatus(list);
				}
				// 空判断
				if (null != list && list.size() > 0
						&& StringUtils.isNotEmpty(list.get(0).getDeviceToken())) {
					// 这次的设备号和上次的设备号不一样，说明别人登陆了
					if (!list.get(0).getDeviceToken().equals(deviceToken)) {
						/***** 把上一台设备状态改成off *****/
						// 工号
						empExtensionEntity.setEmpCode(userCode);
						// 上一个设备
						empExtensionEntity.setDeviceToken(list.get(0)
								.getDeviceToken());
						// 上一个设备应该对应的状态
						empExtensionEntity.setEmpStatus("off");
						// 更新上一个设备对应的属性
						loginInfoDao
								.updateStatusByDeviceToken(empExtensionEntity);
						/***** 将当前设备存储 *****/
						// 设备号
						empExtensionEntity.setDeviceToken(deviceToken);
						// 设备对应状态
						empExtensionEntity.setEmpStatus("on");
						// 设备类型
						empExtensionEntity.setOsType(osType);
						// 更新时间
						empExtensionEntity.setUpdateTime(String
								.valueOf(new Date().getTime()));
						// 登录时间
						empExtensionEntity.setLoginTime(new Date());
						// 是否提出别人
						empExtensionEntity.setIsKickOff("Y");
						// 经度
						empExtensionEntity.setLatitude(latitude);
						// 纬度
						empExtensionEntity.setLongitude(longitude);
						// 地址
						empExtensionEntity.setLocation(location);
						// 手机机型
						empExtensionEntity.setPhoneModel(phoneModel);
						// 操作系统版本号
						empExtensionEntity.setOsVersion(osVersion);
						// 手机mac地址
						empExtensionEntity.setPhoneMac(phoneMac);
						// app版本
						empExtensionEntity.setAppVersion(appVersion);
						// 信息添加
						loginInfoDao.addDeviceToken(empExtensionEntity);
					} else {
						// 设备和上次一样,直接保存就可以
						// TODO 可以不进行数据库操作,不知道当时怎么想，等优化
						// 登录信息id
						empExtensionEntity.setId(list.get(0).getId());
						// 工号
						empExtensionEntity.setEmpCode(userCode);
						// 设备号
						empExtensionEntity.setDeviceToken(deviceToken);
						// 设备对应状态
						empExtensionEntity.setEmpStatus("on");
						// 对应设备类型
						empExtensionEntity.setOsType(osType);
						// 更新时间
						empExtensionEntity.setUpdateTime(String
								.valueOf(new Date().getTime()));
						// 登录时间
						empExtensionEntity.setLoginTime(new Date());
						// 有没有踢出别人
						empExtensionEntity.setIsKickOff("N");
						// 经度
						empExtensionEntity.setLatitude(latitude);
						// 纬度
						empExtensionEntity.setLongitude(longitude);
						// 地址
						empExtensionEntity.setLocation(location);
						// 手机机型
						empExtensionEntity.setPhoneModel(phoneModel);
						// 操作系统版本号
						empExtensionEntity.setOsVersion(osVersion);
						// 手机mac地址
						empExtensionEntity.setPhoneMac(phoneMac);
						// app版本
						empExtensionEntity.setAppVersion(appVersion);
						// 更新信息
						loginInfoDao.updateLoginInfoById(empExtensionEntity);
					}
					// 前端返回
					return empExtensionEntity;
					// 为空,直接保存
				} else {
					// 设备对应状态
					empExtensionEntity.setEmpStatus("on");
					// 设备号
					empExtensionEntity.setDeviceToken(deviceToken);
					// 工号
					empExtensionEntity.setEmpCode(userCode);
					// 有没有踢出别人
					empExtensionEntity.setIsKickOff("N");
					// 经度
					empExtensionEntity.setLatitude(latitude);
					// 纬度
					empExtensionEntity.setLongitude(longitude);
					// 地址
					empExtensionEntity.setLocation(location);
					// 设备号
					empExtensionEntity.setOsType(osType);
					// 手机机型
					empExtensionEntity.setPhoneModel(phoneModel);
					// 操作系统版本号
					empExtensionEntity.setOsVersion(osVersion);
					// 手机mac地址
					empExtensionEntity.setPhoneMac(phoneMac);
					// app版本
					empExtensionEntity.setAppVersion(appVersion);
					// 更新时间
					empExtensionEntity.setUpdateTime(String.valueOf(new Date()
							.getTime()));
					// 登录时间
					empExtensionEntity.setLoginTime(new Date());
					// 信息新增
					loginInfoDao.addDeviceToken(empExtensionEntity);
				}
				// 异常直接返回，不考虑
			} catch (IndexOutOfBoundsException e) {
				LOG.error("LoginInfoService-->checkDevice发生异常，异常信息=====>", e);
				return null;
				// 异常直接返回，不考虑
			} catch (Exception e) {
				LOG.error("LoginInfoService-->checkDevice发生异常，异常信息=====>", e);
				return null;
			}
			// 返回实体信息
			return empExtensionEntity;
		}
	}

	/**
	 * 设备当前状态检查
	 */
	@Override
	public EmpExtensionEntity checkStatus(String empCode, String deviceToken) {
		// 返回的实体类
		EmpExtensionEntity empExtensionEntity = new EmpExtensionEntity();
		// 工号
		empExtensionEntity.setEmpCode(empCode);
		// 设备号
		empExtensionEntity.setDeviceToken(deviceToken);
		// 条件查询
		List<EmpExtensionEntity> list = loginInfoDao
				.queryMore(empExtensionEntity);
		// 为空
		if (null == list || list.size() == 0) {
			// 表示没有被踢下，继续在线上
			empExtensionEntity.setEmpStatus("on");
			// 返回
			return empExtensionEntity;
		}
		// 不为空，查询之前的设备
		List<String> queryDeviceNumByEmpCode = loginInfoDao
				.queryDeviceNumByEmpCode(empCode);
		// 之前设备号
		empExtensionEntity.setDeviceToken(queryDeviceNumByEmpCode.get(0));
		// 当前设备的状态
		empExtensionEntity.setEmpStatus(list.get(0).getEmpStatus());
		// 查询当前的信息
		list = loginInfoDao.queryMore(empExtensionEntity);
		// 地址信息
		empExtensionEntity.setLocation(list.get(0).getLocation());
		// 时间信息
		empExtensionEntity.setUpdateTime(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(list.get(
				0).getUpdateTime()))));
		// 返回实体
		return empExtensionEntity;
	}

	/**
	 * 判断该用户的密码状态
	 */
	public String existUserIdAndDeviceToken(String userId, String deviceToken,
			boolean flag) {
		// 查询判断
		return loginInfoDao
				.existUserIdAndDeviceToken(userId, deviceToken, flag);
	}

	/**
	 * 保存短信状态
	 */
//	@Transactional("transactionManager")
	public void saveUserIdAndDeviceToken(String userId, String deviceToken,
			String smsStatus) {
		// 保存
		loginInfoDao.saveUserIdAndDeviceToken(userId, deviceToken, smsStatus);
	}

	/**
	 * 获取手机号
	 */
	@Override
	public String getPhone(String userId) {
		// 查询
		return loginInfoDao.getPhone(userId);
	}

	/**
	 * 判断是否强制更新
	 */
	@Override
	public Map<String, Object> getChange() {
		// sql
		String isChange = "select dict_name,dict_value from t_app_dictionary";
		// 结果集定义
		Map<String, Object> result = null;
		try {
			// 获取值
			result = template.queryForMap(isChange);
		} catch (DataAccessException e) {
			// log
			LOG.error("getChange异常现象：", e);
		}
		// 返回前端
		return result;
	}
	
	/**
	 * 根据工号查询用户历史登录设备等信息
	 */
	@Override
	public List<EmpExtensionEntity> queryAllLoginInfoByEmpCode(String empCode,int start,int rows) {
		return loginInfoDao.queryAllLoginInfoByEmpCode(empCode,start,rows);
	}
	
	/**
	 * 根据工号查询用户历史登录设备等信息总条数
	 */
	@Override
	public long queryCountByEmpCode(String empCode) {
		return loginInfoDao.queryCountByEmpCode(empCode);
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ILoginInfoDao getLoginInfoDao() {
		return loginInfoDao;
	}

	/**
	 * set
	 * 
	 * @param loginInfoDao
	 */
	public void setLoginInfoDao(ILoginInfoDao loginInfoDao) {
		this.loginInfoDao = loginInfoDao;
	}

	/**
	 * set
	 * 
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
