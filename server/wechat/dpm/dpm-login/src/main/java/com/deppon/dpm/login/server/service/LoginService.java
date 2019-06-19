package com.deppon.dpm.login.server.service;

import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.login.server.domain.CasUserEntity;
import com.deppon.dpm.login.server.domain.FailLoginInfoEntity;
import com.deppon.dpm.module.common.server.service.IUserFuncStatusService;
import com.deppon.dpm.module.common.server.util.IHttpClient;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.NetUtil;
import com.deppon.dpm.module.common.shared.domain.AppAutoRefreshControlEntity;
import com.deppon.dpm.module.common.shared.domain.UserFuncStatusEntity;
import com.deppon.dpm.module.management.server.service.IApplyStoreService;
import com.deppon.dpm.module.management.server.service.IInformationService;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;
import com.deppon.dpm.tongxunlu.server.dao.IOrganizationDao;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.PropertiesUtil;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.dpm.uums.server.dao.IRoleResourceDao;
import com.deppon.dpm.uums.server.domain.ResourceEntity;
import com.deppon.dpm.uums.server.domain.RoleResourceEntity;
import com.deppon.dpm.uums.server.service.IResourceService;
import com.deppon.foss.framework.define.FunctionType;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.context.SessionContext;
import com.deppon.foss.framework.server.web.message.IMessageBundle;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 登陆服务.
 * 
 * @author 130126
 * 
 */
public class LoginService implements ILoginService {
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(LoginService.class);
	/**
	 * cas服务注入
	 */
	private CasLoginService casLoginService;
	/**
	 * 员工信息service注入
	 */
	private IEmployeeDao employeeDao;
	/**
	 * 角色信息service注入
	 */
	private IRoleResourceDao roleResourceDao;
	/**
	 * 组织信息service注入
	 */
	private IOrganizationDao organizationDao;
	/**
	 * 资源信息service注入
	 */
	private IResourceService resourceService;
	/**
	 * 个人头像service注入
	 */
	private IPersonlyImageService personlyImageService;
	/**
	 * 应用商店service注入
	 */
	private IApplyStoreService iApplyStoreService;
	/**
	 * 公告排序service注入
	 */
	private IInformationService informationService;
	@Resource
	protected IMessageBundle messageBundle;
	
	/**
	 * 用户模块监控开关Service
	 */
	private IUserFuncStatusService userFuncStatusService;

	/**
	 * 手势密码db
	 */
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 查询用户模块异常监控开关
	 */
	public boolean queryUserFuncStatus(String userId) {
		List<UserFuncStatusEntity> list = userFuncStatusService.queryByUserId(userId);
		if(list != null && list.size() > 0){
			UserFuncStatusEntity userFuncStatusEntity = list.get(0);
			Boolean status = userFuncStatusEntity.getExceptionMonitorStatus();
			return status ? true : false;
		}
		return false;
	}
	
	/**
	 * 查询用户登录校验用户名密码错误记录
	 */
	public FailLoginInfoEntity queryFailLoginInfo(String userId){
		// 查询sql
		String sql = "select * from fail_login_info where empcode = ?";
		// 执行查询
		List<FailLoginInfoEntity> list = jdbcTemplate.query(sql, new RowMapper<FailLoginInfoEntity>(){
			// 复写方法
			public FailLoginInfoEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// 返回实体类
				FailLoginInfoEntity failLoginInfoEntity = new FailLoginInfoEntity();
				// 工号
				failLoginInfoEntity.setEmpCode(rs.getString("empcode"));
				// 错误次数
				failLoginInfoEntity.setErrorCount(rs.getInt("error_count"));
				// 最后一次登录错误时间
				failLoginInfoEntity.setLastErrorLoginTime(rs.getTimestamp("last_errorlogintime"));
				// 被锁定时间
				failLoginInfoEntity.setLockedTime(rs.getTimestamp("locked_time"));
				// 更新时间
				failLoginInfoEntity.setUpdateTime(rs.getTimestamp("update_time"));
				// 返回
				return failLoginInfoEntity;
			}
		}, userId);
		// 判断 是否有数据
		if(null != list && list.size() > 0){
			// 如果有数据返回第一条
			return list.get(0);
		}
		// 返回
		return null;
	}
	
	/**
	 * 保存错误登录记录
	 */
//	@Transactional("transactionManager")
	public void saveFailLoginInfo(FailLoginInfoEntity entity) {
		// sql
		String sql = "INSERT INTO fail_login_info (empcode, last_errorlogintime, error_count, locked_time, update_time) VALUES (?, NOW(), 1, NULL, NOW())";
		// 执行
		jdbcTemplate.update(sql, entity.getEmpCode());
	}
	
	/**
	 * 更新错误登录记录
	 */
//	@Transactional("transactionManager")
	public void updateFailLoginInfo(FailLoginInfoEntity entity) {
		// sql
		String sql = "UPDATE fail_login_info SET last_errorlogintime=?, error_count=?, locked_time=?, update_time=? WHERE empcode = ?";
		// 执行
		jdbcTemplate.update(sql, entity.getLastErrorLoginTime(),entity.getErrorCount(),entity.getLockedTime(),entity.getUpdateTime(),entity.getEmpCode());
	}
	
	/**
	 * 移动门户单点登录
	 * 
	 * @param validInfo
	 * @return ticket
	 */
	public String doSSOLogon(Map<String, Object> validInfo, String userId)
			throws Exception {
		// cas请求地址
		String casaction = null;
		// cookie
		String cookie = null;
		// sessionId
		String sessionId = null;
		// 用以参数拼接
		StringBuilder param = new StringBuilder("_eventId=submit");
		// 获取casUrl
		String action = PropertiesUtil.cas_url;
		// // 传入的信息进行遍历
		// Collection<String> keyset = validInfo.keySet();
		// // 迭代遍历
		// for (Iterator<String> iter = keyset.iterator(); iter.hasNext();) {
		// // key
		// String argName = (String) iter.next();
		// // value
		// String argValue = (String) validInfo.get(argName);
		// // key = casaction
		// if (argName.equals("casaction")) {
		// // 值拼接
		// casaction = argValue;
		// // key = cookie
		// } else if (argName.equals("cookie")) {
		// // 值拼接
		// cookie = argValue;
		// // key = sessionId
		// } else if (argName.equals("sessionId")) {
		// // 值拼接
		// sessionId = argValue;
		// } else {
		// // 其余直接拼接
		// param.append("&");
		// param.append(argName);
		// param.append("=");
		// param.append(URLEncoder.encode(argValue, "utf8"));
		// }
		// }
		// 传入的信息进行遍历
		Collection<Map.Entry<String, Object>> entrySet = validInfo.entrySet();
		// 迭代遍历
		for (Map.Entry<String, Object> entry : entrySet) {
			// key
			String argName = entry.getKey();
			// value
			String argValue = (String) entry.getValue();
			// key = casaction
			if (argName.equals("casaction")) {
				// 值拼接
				casaction = argValue;
				// key = cookie
			} else if (argName.equals("cookie")) {
				// 值拼接
				cookie = argValue;
				// key = sessionId
			} else if (argName.equals("sessionId")) {
				// 值拼接
				sessionId = argValue;
			} else {
				// 其余直接拼接
				param.append("&");
				param.append(argName);
				param.append("=");
				param.append(URLEncoder.encode(argValue, "utf8"));
			}
		}
		// 最终的url
		action = action
				+ casaction
				+ "?"
				+ URLEncoder.encode("service=" + PropertiesUtil.main_page_url,
						"utf8");
		// 得到HTTP客户端对象 完成所有HTTP请求的工作
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		// 设置请求url
		httpClient.setRequestURL(action);
		// 设置cookie
		httpClient.setCookie(cookie);
		// 提示登陆信息
		logger.info("Do first login[user=" + userId + "][action=" + action
				+ "]");
		// 发送请求
		httpClient.send(param.toString(), "utf-8");
		// 获取相应的cookie
		String cookei = httpClient.fetchCookie();
		// 如果不为空
		if (cookei != null && !"".equals(cookei.trim())) {
			// 打印log信息
			logger.info("[CAS][do first login][Response cookie:" + cookei
					+ "][username:" + userId + "][sessionId:" + sessionId + "]");
			// 返回cookei
			return cookei;
		}
		// cookie为空，登录失败,打印log
		logger.info("[PORTAL][Login failure!][username:" + userId
				+ "]sessionId:" + sessionId + "]");
		// 跳出
		return null;
	}

	/**
	 * 得到CAS登录所需的验证信息、SESSION ID. 伪造一下url进行登录
	 */
	public void fetchCASValidInfo(Map<String, Object> validInfo)
			throws Exception {
		// 得到HTTP客户端对象 完成所有HTTP请求的工作
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		// 请求地址
		httpClient.setRequestURL(PropertiesUtil.cas_login_url);
		// 伪造登录
		httpClient.send("");
		// 获取输出流
		if (httpClient.getOutputStream() == null) {
			// 为null直接抛出异常
			throw new Exception("fetchCASValidInfo no OutputStream");
		}
		// 获取返回信息
		String result = httpClient.getOutputStream().toString("UTF-8");
		// 匹配规则
		Pattern pattern = Pattern
				.compile("<input type=\"hidden\" name=\"lt\" value=\"[\\w\\W]{0,77}\" />");
		// 匹配内容
		Matcher matcher = pattern.matcher(result);
		// 查询
		matcher.find();
		// 获取匹配值
		String lt = matcher.group();
		// 匹配规则
		pattern = Pattern.compile("action=\"[^(\">)]{0,}(\"){1}");
		// 匹配内容
		matcher = pattern.matcher(result);
		// 查询
		matcher.find();
		// 获取匹配值
		String action = matcher.group();
		// 替换
		action = action.replaceFirst("action=\\\"", "");
		// 替换
		action = action.replace("\"", "");
		// 替换
		lt = lt.replaceFirst("<input type=\"hidden\" name=\"lt\" value=\"", "");
		// 替换
		lt = lt.replace("\" />", "");
		// 获取cookie
		String cookie = httpClient.fetchCookie();
		// 获取sessionId
		String sessionId = action.replaceFirst("/cas/login;jsessionid=", "");
		// 拼接信息
		validInfo.put("casaction", action);
		// 拼接信息
		validInfo.put("lt", lt);
		// 拼接信息
		validInfo.put("cookie", cookie);
		// 拼接信息
		validInfo.put("sessionId", sessionId);
	}

	@Override
	public String getRole(String userId, String appId) {
		// 定义返回字段
		String str = null;
		try {
			// 获取角色权限
			str = LoginUtil.getInstance().getUrl(
					PropertiesUtil.roleUrl + "?appID=" + appId + "&userCode="
							+ userId, "utf8");
			// logger
			logger.info("[请求角色链接]---" + PropertiesUtil.roleUrl + "?appID="
					+ appId + "&userCode=" + userId);
		} catch (Exception e) {
			// 打印
			e.printStackTrace();
		}
		// 返回字段
		return str;
	}

	/**
	 * 用户登录
	 * 
	 * @see com.deppon.dpm.login.server.service.ILoginService#userLogin(java.lang.String,
	 *      java.lang.String)
	 */
	public CasUserEntity userLogin(String userName, String pwd)
			throws Exception {
		// 提交验证服务器验证用户信息
		CasUserEntity casUserEntity = casLoginService.login(userName, pwd);
		// 把登录用户ID、工号与默认部门编码存入session中
		// 存入用户ID
		SessionContext.setCurrentUser(userName);
		// 存入用户工号
		SessionContext.getSession().setObject(Constants.FRAMEWORK_KEY_EMPCODE,userName);
		// 存入默认部门名称
//		SessionContext.getSession().setObject(
//				Constants.FOSS_KEY_CURRENT_DEPTNAME,
//				casUserEntity.getDeptName());
		// 将角色信息存入session
//		SessionContext.getSession().setObject(Constants.FOSS_KEY_CURRENT_ROLES,
//				casUserEntity.getRoleCodes());
		// 返回cas用户
		return casUserEntity;
	}
	
	/**
	 * web端的登录
	 */
	public CasUserEntity webUserLogin(String userName, String pwd, CasUserEntity casUserEntity1) {
		// 提交验证服务器验证用户信息
		CasUserEntity casUserEntity2 = null;
		try {
			casUserEntity2 = casLoginService.login(userName, pwd);
		} catch (Exception e) {
			throw new BusinessException("用户名或密码错误");
		}
		// 把登录用户ID、工号与默认部门编码存入session中
		// 存入用户ID
		SessionContext.setCurrentUser(userName);
		// 存入用户工号
		SessionContext.getSession().setObject(Constants.FRAMEWORK_KEY_EMPCODE,userName);
		// 存入默认部门名称
		SessionContext.getSession().setObject(Constants.FOSS_KEY_CURRENT_DEPTNAME,
				casUserEntity1.getDeptName());
		// 将角色信息存入session
		SessionContext.getSession().setObject(Constants.FOSS_KEY_CURRENT_ROLES,
				casUserEntity1.getRoleCodes());
		// 返回cas用户
		casUserEntity1.setCasSessionId(casUserEntity2.getCasSessionId());
		casUserEntity1.setCookie(casUserEntity2.getCookie());
		return casUserEntity1;
	}

	/**
	 * 
	 * 验证用户信息是否有管理平台权限
	 * 
	 * @see com.deppon.dpm.login.server.service.ILoginService#validBpmWebUser(java.lang.String,
	 *      com.deppon.dpm.login.server.domain.CasUserEntity)
	 */
	public boolean validBpmWebUser(String userCode, CasUserEntity casUserEntity) {
		// 查询用户及权限信息
		UserEntity userEntity = queryUser(userCode,
				casUserEntity.getRoleCodes());
		// 查询用户信息为null
		if (userEntity == null) {
			// 抛异常
			throw new BusinessException(
					messageBundle.getMessage("foss.login.userInfoInvalid"));
		}
		// 查询下一级菜单资源
		List<ResourceEntity> rootMenuLst = findResources(
				Constants.MENU_ROOT_CODE, userEntity);
		// 菜单资源为空
		if (rootMenuLst == null || rootMenuLst.size() <= 0) {
			// 抛出异常
			throw new BusinessException(
					messageBundle.getMessage("foss.login.noBpmWebFunction"));
		}
		// 否则有权限
		return true;
	}

	// 查询功能方法
	@Override
	public List<ResourceEntity> findResources(String parentCode,
			UserEntity userEntity) {
		// 权限
		Set<String> resCodes = userEntity.getOrgResCodes();
		// 当前部门未配置角色
		if (resCodes == null) {
			// 抛出异常
			throw new BusinessException(
					messageBundle.getMessage("foss.login.noBpmWebFunction"));
		}
		// 菜单对象集合
		List<ResourceEntity> resNodes = new ArrayList<ResourceEntity>();
		// 查询下一级资源
		List<ResourceEntity> childResources = resourceService
				.getDirectChildResourceByCode(parentCode);
		for (ResourceEntity res : childResources) {
			// 判断权限是否为空
			if (res == null) {
				continue;
			}
			// 判断权限的类型是否为按钮
			if (StringUtil.equalsIgnoreCase(FunctionType.BUTTON,
					res.getResType())) {
				continue;
			}
			// 判断是否是WEB菜单
			if (!StringUtil.equalsIgnoreCase(
					Constants.BPM_RESOURCE_BELONG_SYSTEM_TYPE_WEB,
					res.getBelongSystemType())) {
				continue;
			}
			// 判断权限为非检查的权限时，直接增加到权限列表中
			if (StringUtil.equalsIgnoreCase(Constants.ACTIVE_NO,
					res.getChecked())) {
				resNodes.add(res);
				continue;
			}
			// 菜单添加
			if (resCodes.contains(res.getCode())) {
				resNodes.add(res);
			}
		}
		// 返回
		return resNodes;
	}

	/**
	 * 查询用户及权限信息 queryUser: <br/>
	 * 
	 * Date:2014-8-20下午2:18:52
	 * 
	 * @author 157229-zxy
	 * @param userCode
	 * @param roles
	 * @return
	 * @since JDK 1.6
	 */
	public UserEntity queryUser(String userCode, List<String> roles) {
		// 用户返回实体
		UserEntity userEntity = null;
		// 查询参数
		EmployeeVO params = new EmployeeVO();
		// 条件设置
		params.setEmpCode(userCode);
		// 查询的结果
		EmployeeEntity employee = employeeDao.selectOne(params);
		// 不为空
		if (employee != null) {
			// 判断是不是管理族群
			if ("管理族群".equals(employee.getJobGroups())) {
				// 更改属性，前后端统一
				employee.setJobGroups("1");
			} else {
				// 更改属性，前后端统一
				employee.setJobGroups("0");
			}
			try {
				// 个人头像设置
				employee.setHeadPhoto(personlyImageService
						.downloadImage(userCode));
			} catch (FileNotFoundException e) {
				// 异常抛出
				e.printStackTrace();
			}
			// 实例化
			userEntity = new UserEntity();
			// 设置属性
			userEntity.setEmployee(employee);
			// 组织信息
			OrganizationVO orgVo = new OrganizationVO();
			// 组织id
			orgVo.setOrgId(employee.getOrgId());
			// 大小
			orgVo.setLimit(1);
			// 起始
			orgVo.setStart(0);
			// 查询到的组织信息
			OrganizationEntity orgEntity = organizationDao
					.queryOrganizationByOrgEntity(orgVo);
			// 设置组织信息
			userEntity.setOrganization(orgEntity);
			// 属性拷贝
			BeanUtils.copyProperties(employee, userEntity);
			if (roles != null) {
				// 角色集合
				Set<String> rolesSet = new HashSet<String>(roles);
				// 设置角色信息
				userEntity.setRoleids(rolesSet);
				// 信息集合
				Set<String> funcSet = new HashSet<String>();
				// 查询权限
//				for (int i = 0; i < roles.size(); i++) {
//					// 实例化
//					RoleResourceEntity roleResourceParam = new RoleResourceEntity();
//					// 设置权限
//					roleResourceParam.setRoleCode(roles.get(i));
//					// 获取角色权限对应的功能模块
//					List<RoleResourceEntity> roleResourceLst = roleResourceDao
//							.queryRoleResourceExactByEntity(roleResourceParam);
//					// 功能模块不为null
//					if (roleResourceLst != null) {
//						// 循环
//						for (int j = 0; j < roleResourceLst.size(); j++) {
//							// 获取
//							RoleResourceEntity roleResource = roleResourceLst
//									.get(j);
//							if (!funcSet.contains(roleResource
//									.getResourceCode())) {
//								// 添加
//								funcSet.add(roleResource.getResourceCode());
//							}
//						}
//					}
//				}

				if(roles.size() > 1){
					// 获取角色权限对应的功能模块
					List<RoleResourceEntity> roleResourceLst = roleResourceDao
							.queryRoleResourceExactByRoles(roles);
					// 功能模块不为null
					if (roleResourceLst != null) {
						//遍历
						for (RoleResourceEntity roleResourceEntity : roleResourceLst) {
							if (!funcSet.contains(roleResourceEntity.getResourceCode())) {
								// 添加
								funcSet.add(roleResourceEntity.getResourceCode());
							}
						}
					}
				}
				// 附件解密权限对全员开发 2015-11-05
				funcSet.add("DPMDLP");
				// 设置权限功能
				userEntity.setOrgResCodes(funcSet);
			}
		}
		// 返回用户权限信息
		return userEntity;
	}

	/****************** 手势密码 ******************/
	/**
	 * 是否有手势密码
	 */
	@Override
	public boolean hasGesturePassword(String userId) {
		// sql
		String sql = "select count(1) from om_gesture_password where user_id = ?";
		// 条件查询
		int queryForInt = jdbcTemplate.queryForInt(sql,
				new Object[] { userId }, new int[] { Types.VARCHAR });
		// true || false
		return queryForInt > 0;
	}

	/**
	 * 更新手势密码
	 */
	@Override
//	@Transactional("transactionManager")
	public void updateGesturePassword(String userId, String password) {
		// sql
		String sql = "select count(1) from om_gesture_password where user_id = '"
				+ userId + "'";
		// 条件查询
		int result = jdbcTemplate.queryForInt(sql);
		// 查询手势密码
		String pwd = employeeDao.queryGesturePassword(userId);
		// 不存在
		if (result == 0 && null == pwd) {
			// 保存
			employeeDao.saveGesturePassword(userId, password);
		} else {
			// 更改
			employeeDao.updateGesturePassword(userId, password);
		}
	}

	/**
	 * 验证手势密码是否正确
	 */
	@Override
	public boolean validateGesturePassword(String userId, String password) {
		// sql
		String sql = "select count(1) from om_gesture_password where user_id = ? and g_password = '"
				+ password + "'";
		// 条件查询
		int queryForInt = jdbcTemplate.queryForInt(sql,
				new Object[] { userId }, new int[] { Types.VARCHAR });
		// 判断true或者false
		return queryForInt > 0;
	}

	/**
	 * 获取手势密码状态
	 */
	@Override
	public Map<String, Object> getGustureStatus(String empCode) {
		// 获取
		return employeeDao.getGustureStatus(empCode);
	}

	/**
	 * 更新手势密码状态
	 */
	@Override
	public int updateGustureStatus(String empCode, String inGustureStatus) {
		// 更新
		return employeeDao.updateGustureStatus(empCode, inGustureStatus);
	}

	/**
	 * 保存手势密码状态
	 */
	@Override
	public int saveGustureStatus(String userId, String inGustureStatus) {
		// 保存
		return employeeDao.saveGustureStatus(userId, inGustureStatus);
	}

	/****************** 手势密码 ******************/

	@Override
	public Map<String,Object> getApplyStoreSort(String userId, String deviceToken, String clearHistory, int newVersion,List<String> rolesList,String osType,String appVersion) {
		
		int appVersionIntVal = 0;
		try {
			if(StringUtils.isNotBlank(appVersion)){
				appVersion = appVersion.replace(".", "");
				appVersionIntVal = Integer.parseInt(appVersion);
			}
		} catch (Exception e) {
			logger.error("LoginService.getApplyStoreSort解析appVersion出错!!!",e);
		}
		
		// 用以查询
		EmployeeVO vo = new EmployeeVO();
		// 设置查询参数
		vo.setEmpCode(userId);
		// 查询实体
		EmployeeEntity entity = employeeDao.selectOne(vo);
		// 获取应用商店排序 ,查询apply_store_sort
		String sortStr = iApplyStoreService.getSort(userId);
		// 获取设备号对应应用列表
//		String sortStr = getDeviceSort(deviceToken, clearHistory);

		// 根据用户角色获取应有的应用商店列表
		List<ApplyStore> list = iApplyStoreService.list(entity,rolesList,osType,appVersion);
		// 获取应用商店排序
		sortStr = getSortStr(sortStr, list, userId);
		// 有权限的appId
		List<Integer> hasPermissionApplys = new ArrayList<Integer>();
		// 配置自动更新的appId
		List<ApplyStore> refreshApplyStores = new ArrayList<ApplyStore>();
		Map<String,Object> map = new HashMap<String, Object>();
		for (ApplyStore applyStore : list) {
			hasPermissionApplys.add(applyStore.getAppId());
			// 如果开启了自动更新，根据控制的版本判断是否需要自动更新
			if(applyStore.getAutoUpdate()) {
				this.handleAutoRefreshControl(refreshApplyStores,applyStore,appVersionIntVal,osType);
				// 将没用的属性设置为null，不返回给前台
				applyStore.setCnName(null);
				applyStore.setEnName(null);
				applyStore.setCreateTime(null);
				applyStore.setSummary(null);
				applyStore.setAndroidAppVersion(null);
				applyStore.setIosAppVersion(null);
				applyStore.setAppAutoRefreshControlList(null);
				// 如果downloadUrl为null，则设置为空字符串，以免转为json串的时候属性被排除
				if(applyStore.getDownloadUrl() == null) {
					applyStore.setDownloadUrl("");
				}
			}
		}
		// 如果有这3个默认应用的权限则需要前台显示
		map.put("hasBIPermission", hasPermissionApplys.contains(MagicNumber.NUM25));
		map.put("hasECCPermission", hasPermissionApplys.contains(MagicNumber.NUM26));
		map.put("hasWorkFlowPermission", hasPermissionApplys.contains(MagicNumber.NUM27));
		map.put("hasRDVSPermission", hasPermissionApplys.contains(MagicNumber.NUM35));
		
		// 首页排序
		map.put("sortStr", sortStr);
		map.put("hasPermissionApplys", hasPermissionApplys);
		map.put("refreshApplyStores", refreshApplyStores);
		// 返回信息
		return map;
	}
	
	/**
	 * 处理自动更新
	 * @param tmpList
	 * @param autoRefreshControlList
	 * @param refreshApplyStores
	 * @param applyStore
	 * @param appVersionIntVal
	 * @param osType
	 */
	private void handleAutoRefreshControl(List<ApplyStore> refreshApplyStores,ApplyStore applyStore,int appVersionIntVal,String osType){
		// 如果没有传递appVersion 或osType，默认不自动更新
		if(appVersionIntVal == 0 || !("android".equalsIgnoreCase(osType) || "iphone".equalsIgnoreCase(osType))){
			return;
		}
		List<AppAutoRefreshControlEntity> autoRefreshControlList = applyStore.getAppAutoRefreshControlList();
		// 如果没有控制条件，设置自动更新
		if(null == autoRefreshControlList || autoRefreshControlList.size() == 0){
			refreshApplyStores.add(applyStore);
			return;
		}
		
		boolean flag = true;
		for (AppAutoRefreshControlEntity autoRefreshEntity : autoRefreshControlList) {
			if(autoRefreshEntity.getOsType().equalsIgnoreCase(osType)){
				flag = false;
				int judgeSymbol = autoRefreshEntity.getJudgeSymbol();
				try {
					int controlAppVersionIntVal = Integer.parseInt(autoRefreshEntity.getAppVersion().replace(".", ""));
					// 判断当前传递的版本与配置的版本的大小关系，judgeSymbol：0代表条件是= 1代表>=  2代表<=
					if((judgeSymbol == 0 && appVersionIntVal == controlAppVersionIntVal)
							|| (judgeSymbol == 1 && appVersionIntVal >= controlAppVersionIntVal)
							|| (judgeSymbol == 2 && appVersionIntVal <= controlAppVersionIntVal)){
						refreshApplyStores.add(applyStore);
					}
				} catch (Exception e) {
					logger.error("LoginService.handleAutoRefreshControl出错!!!",e);
				}
				break;
			}
		}
		if(flag){
			refreshApplyStores.add(applyStore);
		}
	}

	/**
	 * 根据设备号获取应用商店排序
	 * @param deviceToken 设备号
	 * @param clearHistory 删除APP标志  0：正常  1：删除
	 * @return
	 */
//	private String getDeviceSort(String deviceToken, String clearHistory) {
//		// 返回值
//		StringBuilder sb = new StringBuilder();
//		// 删除APP标志为1的情况，设备号对应的应用版本号应该全部清除  
//		// IOS删除APP的时候会把H5资源包也删除掉
//		if("1".equals(clearHistory) && StringUtils.isNotEmpty(deviceToken)){
//			ApplyDevice device = new ApplyDevice();
//			device.setDeviceToken(deviceToken);
//			// 删除
//			iApplyStoreService.deleteApplyDevice(device);
//			// 返回
//			return sb.toString();
//		}
//		
//		// 设备号对应应用版本号信息对象
//		if (StringUtils.isNotEmpty(deviceToken)) {
//			// 查询条件
//			ApplyDevice device = new ApplyDevice();
//			device.setDeviceToken(deviceToken);
//			// 根据设备号查询 对应应用版本号列表
//			List<ApplyDevice> deviceList = iApplyStoreService
//					.getApplyDeviceList(device);
//			if (deviceList != null && deviceList.size() > 0) {
//
//				for (int i = 0; i < deviceList.size(); i++) {
//					ApplyDevice applyDevice = deviceList.get(i);
//					if (i != 0) {
//						sb.append(",");
//					}
//					sb.append(applyDevice.getApplyStoreId());
//				}
//			}
//		}
//		return sb.toString();
//	}

	/**
	 * 应用商店排序 与应用商店列表比对，不在应用商店列表中的应用属无权限，需去除 应用商店排序为空时，默认把应用商店列表都加入到应用商店排序中
	 * 应用商店排序根据设备号获取 2015-11-25   不需要更新H5资源默认显示在应用列表
	 * @param sortStr
	 * @param list
	 * @param userId
	 * @return
	 */
//	private String getSortStr(String sortStr, List<ApplyStore> list,
//			String userId, int newVersion) {
//		// 用以拼接
//		StringBuilder sb = new StringBuilder();
//		// 应用商店列表Id List
//		List<String> appList = new ArrayList<String>();
//		// 用户装机应用
//		List<String> appUserList = getSortStrUser(userId);
//		// 循环添加
//		for (ApplyStore str : list) {
//			// 不需要更新H5资源默认显示在应用列表   0：不需要，1：需要
//			// 根据用户装机应用显示  两个条件
//			if(("0".equals(str.getHasResources()) || newVersion != com.deppon.dpm.module.management.util.Constants.NEWVERSION)&&appUserList.contains(String.valueOf(str.getAppId()))){
//				sb.append(str.getAppId()).append(",");
//			} else if(!"0".equals(str.getDefaultApp())){
//				// 不在应用商店的应用，不加入到list中
//				appList.add(str.getAppId() + "");
//			}
//		}
//		// 不为空
//		if (StringUtils.isNotBlank(sortStr)) {
//			// 应用商店排序 与应用商店列表比对，不在应用商店列表中的应用属无权限，需去除
//			String[] strs = sortStr.split(",");
//			for (String str : strs) {
//				// 条件判断：1、是否有权限  2、用户是否安装
//				// if (appList.contains(str)&&appUserList.contains(str)) {
//				// 2015-12-04 H5资源的根据权限判断，如有权限全部安装
//				if (appList.contains(str)) {
//					sb.append(str).append(",");
//				}
//			}
//		}
//		// 应用商店添加按钮
//		sb.append(0);
//		// 保存
//		iApplyStoreService.sort(userId, sb.toString());
//		return sb.toString();
//	}
	
	/**
	 *  获取用户装机应用
	 * @param userId
	 * @return
	 */
//	private List<String> getSortStrUser(String userId){
//		// 返回值
//		List<String> appUserList = new ArrayList<String>();
//		// 获取用户装机应用
//		String sortStrUser = iApplyStoreService.getSort(userId);
//		if (StringUtils.isNotBlank(sortStrUser)) {
//			// 转换List
//			appUserList = Arrays.asList(sortStrUser.split(","));
//		}
//		// 返回
//		return appUserList;
//	}
	
	/**
	 * 首页应用排序根据工号走
	 * @param sortStr
	 * @param list
	 * @param userId
	 * @return
	 */
	private String getSortStr(String sortStr, List<ApplyStore> applyStores,String userId) {
		String result = "0";
		List<ApplyStore> list = new ArrayList<ApplyStore>();
		// 为空
		if (StringUtils.isEmpty(sortStr)) {
			//遍历传递过来的应用商店列表
			for (ApplyStore applyStore : applyStores) {
				//判断如果不是默认应用，(defaultApp的值  0:表示默认应用，1表示应用商店应用),并且也不是H5应用
				if("1".equals(applyStore.getDefaultApp()) && "0".equals(applyStore.getHasResources())){
					//添加
					list.add(applyStore);
				}
			}
			// 用以拼接
			StringBuilder builder = new StringBuilder();
			// 循环添加
			for (ApplyStore string : list) {
				builder.append(string.getAppId()).append(",");
			}
			// 应用商店添加按钮
			builder.append(0);
			// 保存
			iApplyStoreService.sort(userId, builder.toString());
			// 转换属性
			result = builder.toString();
		} else {
			//遍历传递过来的应用商店列表
			for (ApplyStore applyStore : applyStores) {
				//判断如果不是默认应用， (defaultApp的值  0:表示默认应用，1表示应用商店应用)
				if("1".equals(applyStore.getDefaultApp())){
					//添加
					list.add(applyStore);
				}
			}
			// 应用商店排序 与应用商店列表比对，不在应用商店列表中的应用属无权限，需去除
			// 用以拼接
			StringBuilder builder = new StringBuilder();
			// 应用商店列表Id List
			List<String> appList = new ArrayList<String>();
			// 循环添加
			for (ApplyStore string : list) {
				appList.add(string.getAppId() + "");
			}
			String[] strs = sortStr.split(",");
			for (String str : strs) {
				// 是否有权限
				if (appList.contains(str)) {
					builder.append(str).append(",");
				}
			}
			// 应用商店添加按钮
			builder.append(0);
			// 转换属性
			result = builder.toString();
		}
		return result;
	}
	

	@Override
	public String getInfoStoreSort(String userId) {
		// 获取排序
		return informationService.getSort(userId);
	}

	/**
	 * 去除公交
	 * 
	 * @param sortStr
	 * @return
	 */
//	@SuppressWarnings("unused")
//	@Deprecated
//	private String splitMethod(String sortStr) {
//		// 获取角色
//		String[] splits = sortStr.split(",");
//		// 用于拼接参数
//		StringBuilder sb = new StringBuilder();
//		// 循环
//		for (String split : splits) {
//			// 不为4拼接
//			if (!"4".equals(split)) {
//				// 拼接
//				sb.append(split).append(",");
//			}
//		}
//		// 截取逗号
//		String str = sb.substring(0, sb.length() - 1);
//		// 返回
//		return str;
//	}

	/**
	 * set
	 * 
	 * @param informationService
	 */
	public void setInformationService(IInformationService informationService) {
		this.informationService = informationService;
	}

	/**
	 * set
	 * 
	 * @param iApplyStoreService
	 */
	public void setiApplyStoreService(IApplyStoreService iApplyStoreService) {
		this.iApplyStoreService = iApplyStoreService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * set
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public CasLoginService getCasLoginService() {
		return casLoginService;
	}

	/**
	 * set
	 * 
	 * @param casLoginService
	 */
	public void setCasLoginService(CasLoginService casLoginService) {
		this.casLoginService = casLoginService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	/**
	 * set
	 * 
	 * @param employeeDao
	 */
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IRoleResourceDao getRoleResourceDao() {
		return roleResourceDao;
	}

	/**
	 * set
	 * 
	 * @param roleResourceDao
	 */
	public void setRoleResourceDao(IRoleResourceDao roleResourceDao) {
		this.roleResourceDao = roleResourceDao;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IOrganizationDao getOrganizationDao() {
		return organizationDao;
	}

	/**
	 * set
	 * 
	 * @param organizationDao
	 */
	public void setOrganizationDao(IOrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * set
	 * 
	 * @param resourceService
	 */
	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IPersonlyImageService getPersonlyImageService() {
		return personlyImageService;
	}

	/**
	 * set
	 * 
	 * @param personlyImageService
	 */
	public void setPersonlyImageService(
			IPersonlyImageService personlyImageService) {
		this.personlyImageService = personlyImageService;
	}

	public void setUserFuncStatusService(
			IUserFuncStatusService userFuncStatusService) {
		this.userFuncStatusService = userFuncStatusService;
	}

}
