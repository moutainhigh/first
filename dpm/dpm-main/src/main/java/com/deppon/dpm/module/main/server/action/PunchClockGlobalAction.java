package com.deppon.dpm.module.main.server.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.AutoPunchClockMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.module.common.shared.vo.OrganizationEntity;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.common.shared.vo.UserEntity;
import com.deppon.dpm.module.main.server.service.IAutoPunchClockMonitorGlobalService;
import com.deppon.dpm.module.main.server.service.IPunchClockGlobalService;
import com.deppon.dpm.module.main.shared.domain.PunchClockPositionGlobalEntity;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * global punch clock action
 * @author 
 * @since 2018-11-12
 */
public class PunchClockGlobalAction extends BaseAction{

	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory.getLogger(PunchClockGlobalAction.class);
	
	private static final long serialVersionUID = 1L;
	
	private IPunchClockGlobalService punchClockGlobalService;
	
	private String objectJSON;
	
	private IAutoPunchClockMonitorGlobalService autoPunchClockMonitorGlobalService;
	
	private String punchUrl;
	
	//测试，模拟登陆
	private void test(){
		LoginResult lr = new LoginResult();
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmpName("胡龙龙");
		emp.setOrgName("德邦");
		emp.setMobileNo("1234123");
		emp.setGender("M");
		emp.setpEmail("1243@qq.com");
		emp.setEmpId(057051);
		OrganizationEntity org = new OrganizationEntity();
		org.setOrgName("德邦");
		UserEntity userEntity = new UserEntity();
		userEntity.setEmployee(emp);
		userEntity.setOrganization(org);
		userEntity.setPassword("12343");
		userEntity.setUserName("lisi");
		userEntity.setEmpCode("500612");
		lr.setUserEntity(userEntity);
		lr.setAppVersion("4.2");
		lr.setOsType("android");
		lr.setOsVersion("6.7.5");
		lr.setPhoneModel("PE5");
		lr.setDeviceToken("123423eefsfdgfd66bf6zdfgqsdgs5");
		ThreadLocalUtil.setThreadLocal(lr);
	}
	
	/**
	 * 全国打卡，调用其他系统的打卡接口
	 * @author
	 * @since 2019-03-08
	 * */
	@SuppressWarnings("unchecked")
	@CookieNotCheckedRequired
	public void punchClockGlobal(){
		//test();
		//处理跨域
		this.solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String response4clock = null;
		//获取登录用户信息
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		if(loginResult == null){
			logger.error("全国打卡失败:请先登录后再打卡!");
			result.setData(null);
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("全国打卡失败:请先登录后再打卡!");
			result.setCount(1);
			writeToPage(result);
			return;
		}
		//parse request data 
		HashMap<String,String> params = null;
		try {
			params = (HashMap<String,String>)JSON.parseObject(objectJSON, HashMap.class);
		} catch (Exception e) {
			logger.error("全国打卡失败:"+e.getMessage());
			result.setData(null);
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("全国打卡失败:"+e.getMessage());
			result.setCount(1);
			writeToPage(result);
			return;
		}
		String empCode = params.get("empcode");
		String type = params.get("type");
		String moodScore = params.get("moodScore");
		String moodMessage = params.get("moodMessage");
		String yesterday = params.get("yesterday");
		String longitude = params.get("longitude");
		String latitude = params.get("latitude");
		String ip = params.get("ip");
		String network = params.get("network");
		String within = params.get("within");
		String auto = params.get("auto");
		//打卡监控entity
		AutoPunchClockMonitorEntity entity = new AutoPunchClockMonitorEntity();
		//assemble punch clock monitor information
		entity.setEmpCode(empCode);//工号
		entity.setOsType(loginResult.getOsType());//操作系统类型
		entity.setAppVersion(loginResult.getAppVersion());//dpm应用版本
		entity.setPhoneModel(loginResult.getPhoneModel());//手机型号
		entity.setOsVersion(loginResult.getOsVersion());//操作系统版本
		entity.setAuto("true".equalsIgnoreCase(auto));//是否自动打卡，false为手动，true为自动
		entity.setIp(ip);//ip
		entity.setNetwork(network);//网络类型
		entity.setLongitude(longitude);//经度
		entity.setLatitude(latitude);//纬度
		entity.setWithin("true".equalsIgnoreCase(within));//是否在打卡范围内
		
		try {
			//assemble request punch parameters
			HashMap<String,Object> paramsToPunchClock = new HashMap<String,Object>();
			paramsToPunchClock.put("empCode", empCode);
			paramsToPunchClock.put("type", type);
			paramsToPunchClock.put("moodScore", moodScore);
			paramsToPunchClock.put("moodMessage", moodMessage);
			paramsToPunchClock.put("yesterday", yesterday);
			
			//request punch clock action
			response4clock = HttpUtil.doPostJson(punchUrl, JSON.toJSONString(paramsToPunchClock));
			if(response4clock != null){
				JSONObject responseData = JSONObject.parseObject(response4clock, JSONObject.class); 
				if(responseData == null || responseData.getJSONObject("data")==null){
					logger.error("请求人力打卡接口【失败】:"+response4clock);
					//assemble punch clock monitor information
					entity.setStatus(false);//状态
					entity.setErrorMsg("请求人力打卡接口【失败】:"+response4clock);//原因
					
					result.setData(null);
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					result.setErrorMessage("调用打卡接口失败:没有打卡数据信息!");
				}else{
					JSONObject response = responseData.getJSONObject("data");
					logger.error("请求人力打卡接口【成功】:"+responseData.toString());
					//assemble punch clock monitor information
					entity.setStatus("0".equals(response.getString("result")));//状态
					entity.setErrorMsg("请求人力打卡接口【成功】:"+responseData.toString());//原因
					
					result.setData(JSON.toJSONString(response));
					result.setErrorCode(Constants.ACTION_RESULT_SUC);
					result.setErrorMessage("全国打卡成功!");
				}
			}else{
				logger.error("请求人力打卡接口【失败】:"+response4clock);
				//assemble punch clock monitor information
				entity.setStatus(false);//状态
				entity.setErrorMsg("请求人力打卡接口【失败】:"+response4clock);//原因
				
				result.setData(null);
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("调用打卡接口失败,没有返回任何打卡信息!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("全国打卡报错:"+e.getMessage());
			//assemble punch clock monitor information
			entity.setStatus(false);//状态
			entity.setErrorMsg("全国打卡【失败】!");//原因
			
			result.setData(null);
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("全国打卡报错:"+e.getMessage());
		}
		try {
			//save punch clock information in auto_punch_clock_monitor_global table
			autoPunchClockMonitorGlobalService.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("全国打卡插入监控数据报错:"+e.getMessage());
			result.setData(null);
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("全国打卡插入监控数据报错:"+e.getMessage());
		}
		// count
		result.setCount(1);
		// 返回
		writeToPage(result);
		return;
	}
	
	/**
	 * 设定全国打卡位置,该位置只能由该部门负责人设定
	 * @author 
	 * @since 2018-11-12
	 * */
	public void addClockPosition(){
		//处理跨域
		this.solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		//测试数据
		//test();
		//获取登录用户信息
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		if(null == loginResult || null == loginResult.getUserEntity() || StringUtils.isBlank(loginResult.getUserEntity().getEmpCode())){
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("设定全国打卡位置报错: 获取登录信息失败!");
			//count
			result.setCount(1);
			//data
			result.setData(null);
			writeToPage(result);
			return;
		}
		
		try {
			//查看是否为部门负责人和是否有权限设定打卡位置
			String empCode = loginResult.getUserEntity().getEmpCode();
			boolean isDepartManager = punchClockGlobalService.isDepartmentManager(empCode);
			if(!isDepartManager){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("设定全国打卡位置报错: 非部门负责人,没有权限设定打卡位置!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			PunchClockPositionGlobalEntity entity = JSON.parseObject(objectJSON, PunchClockPositionGlobalEntity.class);
			if(null == entity || StringUtils.isBlank(entity.getLatitude()) || StringUtils.isBlank(entity.getLongitude())){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("设定全国打卡位置报错: 设定打卡位置的经纬度不能为空!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			//设置entity中的orgId
			List<OrganizationEntity> orgList = punchClockGlobalService.getOrgIdByEmpCode(empCode);
			entity.setOrgId(orgList.get(0).getOrgId());
			entity.setOrgName(orgList.get(0).getOrgName());
			entity.setManagerId(empCode);
			entity.setParentOrgId(orgList.get(0).getParentOrgId());
			
			//校验具体的经纬度的位置是否已经存在并且在使用
			Map<String,String> param = new HashMap<String,String>();
			param.put("orgId", Integer.toString(entity.getOrgId()));
			param.put("isEnable", "1");//有效的打卡位置
			List<PunchClockPositionGlobalEntity> positions = punchClockGlobalService.getPunchClockAvailablePosition(param);
			if(null != positions && !positions.isEmpty()){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("设定全国打卡位置报错: 设定打卡位置已经存在!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			//设置手机的打卡信息
			entity.setAppVersion(loginResult.getAppVersion());
			entity.setOsType(loginResult.getOsType());
			entity.setOsVersion(loginResult.getOsVersion());
			entity.setPhoneModel(loginResult.getPhoneModel());
			entity.setDeviceToken(loginResult.getDeviceToken());
			//新增全国打卡位置
			int count = punchClockGlobalService.addClockPosition(entity);
			if(count > 0){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage("设定全国打卡位置成功!");
				//查询上级部门信息，获取上级部门经理ID
				List<OrganizationEntity> parentOrgs = punchClockGlobalService.getOrgById(Integer.toString(entity.getParentOrgId()));
				if(parentOrgs != null && !parentOrgs.isEmpty()){
					String parentManagerId = parentOrgs.get(0).getManagerId();
					//发送通知让直属领导去审核打卡地址
					Map<String,String> notice = new HashMap<String,String>();
					notice.put("type", "10");//消息类型
					notice.put("noticeId", UUID.randomUUID().toString());//消息ID，随机生成
					notice.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));//消息生成时间
					notice.put("title", "新增打卡地址审核提醒");//消息title
					notice.put("content", "同事你好，烦请审核下辖部门的打卡地址设置。（点击跳转地址查看页面）");//消息类型
					notice.put("creatorName", loginResult.getUserEntity().getEmployee().getEmpName());//消息发送人的名字
					notice.put("userId", parentManagerId);//消息接收人的工号
					punchClockGlobalService.addNoticeDetail(notice);
				}
				
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("设定全国打卡位置失败!");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("设定全国打卡位置信息异常:" + e);
			e.printStackTrace();
			logger.error("设定全国打卡位置信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(null);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 更新全国打卡位置,该位置只能由该部门负责人设定
	 * @author 
	 * @since 2018-11-12
	 * */
	public void updateClockPosition(){
		//处理跨域
		this.solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		//测试数据
		//test();
		//获取登录用户信息
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		if(null == loginResult || null == loginResult.getUserEntity() || StringUtils.isBlank(loginResult.getUserEntity().getEmpCode())){
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("更新全国打卡位置报错: 获取登录信息失败!");
			//count
			result.setCount(1);
			//data
			result.setData(null);
			writeToPage(result);
			return;
		}
		
		try {
			//查看是否为部门负责人和是否有权限设定打卡位置
			String empCode = loginResult.getUserEntity().getEmpCode();
			boolean isDepartManager = punchClockGlobalService.isDepartmentManager(empCode);
			if(!isDepartManager){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("更新全国打卡位置报错: 非部门负责人,没有权限设定打卡位置!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			PunchClockPositionGlobalEntity entity = JSON.parseObject(objectJSON, PunchClockPositionGlobalEntity.class);
			if(null == entity || StringUtils.isBlank(entity.getLatitude()) || StringUtils.isBlank(entity.getLongitude())){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("更新全国打卡位置报错: 设定打卡位置的经纬度不能为空!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			//设置entity中的orgId
			List<OrganizationEntity> orgList = punchClockGlobalService.getOrgIdByEmpCode(empCode);
			entity.setOrgId(orgList.get(0).getOrgId());
			entity.setManagerId(empCode);
			entity.setParentOrgId(orgList.get(0).getParentOrgId());
			//设置手机的打卡信息
			entity.setAppVersion(loginResult.getAppVersion());
			entity.setOsType(loginResult.getOsType());
			entity.setOsVersion(loginResult.getOsVersion());
			entity.setPhoneModel(loginResult.getPhoneModel());
			entity.setDeviceToken(loginResult.getDeviceToken());
			//新增或更改全国打卡位置
			int count = punchClockGlobalService.updateClockPosition(entity);
			if(count > 0){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage("更新全国打卡位置成功!");
				//查询上级部门信息，获取上级部门经理ID
				List<OrganizationEntity> parentOrgs = punchClockGlobalService.getOrgById(Integer.toString(entity.getParentOrgId()));
				if(parentOrgs != null && !parentOrgs.isEmpty()){
					String parentManagerId = parentOrgs.get(0).getManagerId();
					//发送通知让直属领导去审核打卡地址
					Map<String,String> notice = new HashMap<String,String>();
					notice.put("type", "10");//消息类型
					notice.put("noticeId", UUID.randomUUID().toString());//消息ID，随机生成
					notice.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));//消息生成时间
					notice.put("title", "修改打卡地址审核提醒");//消息title
					notice.put("content", "同事你好，烦请审核下辖部门的打卡地址设置。（点击跳转地址查看页面）");//消息类型
					notice.put("creatorName", loginResult.getUserEntity().getEmployee().getEmpName());//消息发送人的名字
					notice.put("userId", parentManagerId);//消息接收人的工号
					punchClockGlobalService.addNoticeDetail(notice);
				}
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("更新全国打卡位置失败!");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("更新全国打卡位置信息异常:" + e);
			e.printStackTrace();
			logger.error("更新全国打卡位置信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(null);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 更新全国打卡位置状态,该位置只能由该部门的直属上级部门负责人设定
	 * @author 
	 * @since 2018-11-12
	 * */
	public void updateClockPositionStatus(){
		//处理跨域
		this.solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		//测试数据
		//test();
		//获取登录用户信息
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		if(null == loginResult || null == loginResult.getUserEntity() || StringUtils.isBlank(loginResult.getUserEntity().getEmpCode())){
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("审核全国打卡位置报错: 获取登录信息失败!");
			//count
			result.setCount(1);
			//data
			result.setData(null);
			writeToPage(result);
			return;
		}
		
		try {
			//查看是否为部门负责人和是否有权限设定打卡位置
			String empCode = loginResult.getUserEntity().getEmpCode();
			boolean isDepartManager = punchClockGlobalService.isDepartmentManager(empCode);
			if(!isDepartManager){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("审核全国打卡位置报错: 非部门负责人,没有权限审核打卡位置!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			@SuppressWarnings("unchecked")
			HashMap<String,Object> param = (HashMap<String,Object>)JSON.parseObject(objectJSON, HashMap.class);
			if(null == param || null == param.get("id")){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("更新全国打卡位置报错: 没有参数!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			//校验需要审核的打卡位置是否存在
			PunchClockPositionGlobalEntity entityCheck = punchClockGlobalService.getPunchClockPositionById((Integer)param.get("id"));
			if(null == entityCheck){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("审核全国打卡位置报错: 该打卡位置不存在!");
				//count
				result.setCount(1);
				//data
				result.setData(null);
				writeToPage(result);
				return;
			}
			//校验不能审核逻辑不能由 退回 --》 通过 状态的流程
			String isEnable = (String)param.get("isEnable");
			String verifyStatus = (String)param.get("verifyStatus");
			if(StringUtils.isNotBlank(isEnable) && StringUtils.isNotBlank(verifyStatus) 
					&& "1".equals(verifyStatus) && "1".equals(verifyStatus)){
				//如果当前地址是审核退回状态,则不允许执行审核通过状态
				if(null != entityCheck && 2 == entityCheck.getVerifyStatus()){
					// errorCode
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					// errorMessage
					result.setErrorMessage("审核全国打卡位置报错: 该打卡位置的状态已退回，不能直接审核通过!");
					//count
					result.setCount(1);
					//data
					result.setData(null);
					writeToPage(result);
					return;
				}
			}
			//更改全国打卡位置审核状态
			int count = punchClockGlobalService.updateClockPositionStatus(param);
			if(count > 0){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage("审核全国打卡位置状态成功!");
				
				//获取打卡位置对应的部门信息
				List<OrganizationEntity> orgList = punchClockGlobalService.getOrgById(Integer.toString(entityCheck.getOrgId()));
				
				//发送通知让直属领导去审核打卡地址
				Map<String,String> notice = new HashMap<String,String>();
				notice.put("type", "11");//消息类型
				notice.put("noticeId", UUID.randomUUID().toString());//消息ID，随机生成
				notice.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));//消息生成时间
				notice.put("title", "打卡地址审核提醒");//消息title
				
				if(StringUtils.isNotBlank(isEnable) && StringUtils.isNotBlank(verifyStatus) 
						&& "1".equals(verifyStatus) && "1".equals(verifyStatus)){
					notice.put("content", "同事你好，部门打卡地址已审核，请知晓。");//消息内容
				}else{
					notice.put("content", "同事您好，经上级领导审核，贵部打卡地址维护异常，请重新设置。");//消息内容
				}
				notice.put("creatorName", loginResult.getUserEntity().getEmployee().getEmpName());//消息发送人的名字
				notice.put("userId", orgList.get(0).getManagerId());//消息接收人的工号
				punchClockGlobalService.addNoticeDetail(notice);
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("更新全国打卡位置状态失败!");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("更新全国打卡位置状态信息异常:" + e);
			e.printStackTrace();
			logger.error("更新全国打卡位置状态信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(null);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 根据部门ID查询全国打卡位置
	 * @author 
	 * @since 2018-11-13
	 * */
	public void getPunchClockPositionByOrgId(){
		//处理跨域
		this.solveCrossDomain();
		//结果集
		Result<Object> result = new Result<Object>();
		Map<String,Object> resultData = new HashMap<String,Object>();
		try {
			@SuppressWarnings("unchecked")
			HashMap<String,String> param = (HashMap<String,String>)JSON.parseObject(objectJSON, HashMap.class);
			List<PunchClockPositionGlobalEntity> positionList = punchClockGlobalService.getPunchClockPositionByOrgId(param);
			if(null == positionList || positionList.isEmpty()){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				//新增返回时间戳
				long timeStamp = Calendar.getInstance().getTimeInMillis();
				resultData.put("timeStamp", timeStamp);
				resultData.put("position", null);
				//data
				result.setData(resultData);
				// errorMessage
				result.setErrorMessage("获取全国打卡位置失败:您还没有设置打卡位置!");
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				//新增返回时间戳
				long timeStamp = Calendar.getInstance().getTimeInMillis();
				resultData.put("timeStamp", timeStamp);
				resultData.put("position", positionList.get(0));
				// data
				result.setData(resultData);
				// errorMessage
				result.setErrorMessage("获取全国打卡位置成功!");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("设定全国打卡位置信息异常:" + e);
			e.printStackTrace();
			logger.error("设定全国打卡位置信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 获取可待审核打卡位置列表
	 * @author 
	 * @since 2018-11-22
	 * */
	public void getPositionByParentOrgId(){
		//处理跨域
		this.solveCrossDomain();
		//结果集
		Result<Object> result = new Result<Object>();
		Map<String,Object> resultData = new HashMap<String,Object>();
		try {
			@SuppressWarnings("unchecked")
			HashMap<String,String> param = (HashMap<String,String>)JSON.parseObject(objectJSON, HashMap.class);
			List<PunchClockPositionGlobalEntity> positionList = punchClockGlobalService.getPositionByParentOrgId(param);
			if(null == positionList || positionList.isEmpty()){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				//新增返回时间戳
				long timeStamp = Calendar.getInstance().getTimeInMillis();
				resultData.put("timeStamp", timeStamp);
				resultData.put("position", null);
				//data
				result.setData(resultData);
				// errorMessage
				result.setErrorMessage("获取全国打卡位置失败:您还没有设置打卡位置!");
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				//新增返回时间戳
				long timeStamp = Calendar.getInstance().getTimeInMillis();
				resultData.put("timeStamp", timeStamp);
				resultData.put("position", positionList);
				// data
				result.setData(resultData);
				// errorMessage
				result.setErrorMessage("获取全国打卡位置成功!");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("设定全国打卡位置信息异常:" + e);
			e.printStackTrace();
			logger.error("设定全国打卡位置信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 根据工号判断当前员工是否是其所在部门的部门经理
	 * @author 
	 * @since 2018-11-23
	 * */
	public void isDepartmentManager(){
		//处理跨域
		this.solveCrossDomain();
		//结果集
		Result<Object> result = new Result<Object>();
		//测试模拟登录
		//test();
		//获取登录用户信息
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		if(null == loginResult || null == loginResult.getUserEntity() || StringUtils.isBlank(loginResult.getUserEntity().getEmpCode())){
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("设定全国打卡位置报错: 获取登录信息失败!");
			//count
			result.setCount(1);
			//data
			result.setData(null);
			writeToPage(result);
			return;
		}
		
		Map<String,Object> resultData = new HashMap<String,Object>();
		try {
			//当前登录用户的工号
			String empCode = loginResult.getUserEntity().getEmpCode();
			boolean isManager = punchClockGlobalService.isDepartmentManager(empCode);
			if(isManager){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				resultData.put("isManager", isManager);
				// data
				result.setData(resultData);
				// errorMessage
				result.setErrorMessage("是所在部门的经理!");
			}else{
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				resultData.put("isManager", isManager);
				// data
				result.setData(resultData);
				// errorMessage
				result.setErrorMessage("不是所在部门的经理!");
			}
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("判断是否是部门经理时异常:" + e);
			e.printStackTrace();
			logger.error("判断是否是部门经理时异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// 返回
		writeToPage(result);
	}

	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public IPunchClockGlobalService getPunchClockGlobalService() {
		return punchClockGlobalService;
	}

	public void setPunchClockGlobalService(IPunchClockGlobalService punchClockGlobalService) {
		this.punchClockGlobalService = punchClockGlobalService;
	}

	public String getObjectJSON() {
		return objectJSON;
	}

	public void setObjectJSON(String objectJSON) {
		this.objectJSON = objectJSON;
	}

	public IAutoPunchClockMonitorGlobalService getAutoPunchClockMonitorGlobalService() {
		return autoPunchClockMonitorGlobalService;
	}

	public void setAutoPunchClockMonitorGlobalService(
			IAutoPunchClockMonitorGlobalService autoPunchClockMonitorGlobalService) {
		this.autoPunchClockMonitorGlobalService = autoPunchClockMonitorGlobalService;
	}

	public String getPunchUrl() {
		return punchUrl;
	}

	public void setPunchUrl(String punchUrl) {
		this.punchUrl = punchUrl;
	}

}
