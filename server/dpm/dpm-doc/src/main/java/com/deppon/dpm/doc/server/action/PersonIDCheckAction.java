package com.deppon.dpm.doc.server.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.entity.HxMsmSwitchEntity;
import com.deppon.dpm.doc.server.entity.LoadRecordEntity;
import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.entity.QueryRquestBudgetEntity;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;
import com.deppon.dpm.doc.server.service.IPersonIDService;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.module.common.server.action.AppToUseTimeMonitorAction;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 人员身份检查类
 * @author wanc
 * 20171115
 * 
 *
 */
public class PersonIDCheckAction extends BaseAction {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(AppToUseTimeMonitorAction.class);
	
	// 查询服务接口
	private IPersonIDService personIDService;
	
	private IOtherOffDutiesService otherOffDutiesService;
	//根据工号查询直属上级
	private IExternalMethodService externalMethodService;
	
	private RedisService redisService;
	
	// 预算查询url地址
	private String budgetqryurl;
    //设备号
	private String deviceId;
	//欢行短信开关状态
	private String state;
	//区别于登录校验的工号
	private String userCode;
	
	
	/**
	 * 构造方法
	 */
	public PersonIDCheckAction(){
		super();
	}
	
	/**
	 * 人员身份检查
	 * @return
	 */
	@CookieNotCheckedRequired
	public void checkID() {
		
		JSONObject jsonObject = new JSONObject();
		
		if (userId == null || userId.length() < 1) {// 参数为空
			
			jsonObject.put("fulg", "2");
			jsonObject.put("msg", "error");
			
		}else {
			// 根据员工号查询员工身份信息
			EmployeeEntity empentity = personIDService.queryPersonIDByID(userId);
			LOG.debug("查询用户权限与预算" + userId);
			if (empentity != null){
				String jobgroups = empentity.getJobGroups()+"";
				String joblevel = empentity.getJobLevel()+"";
				
				if (jobgroups.equals("管理族群") && (joblevel.equals("09") || 
						joblevel.equals("10") || joblevel.equals("C") || joblevel.equals("D")) ) {// 高管
					jsonObject.put("fulg", "0");
					jsonObject.put("msg", "success");
				}else {// 普通员工
					jsonObject.put("fulg", "1");
					jsonObject.put("msg", "success");
				}
				
				jsonObject.put("empName", empentity.getEmpName());// 员工姓名
				jsonObject.put("orgName", empentity.getOrgName());// 部门名称
				
				// 查询员工所属部门预算数据
				QueryRquestBudgetEntity queryentity = new QueryRquestBudgetEntity();
				queryentity.setEmpCode(userId);
				
				String json = JSON.toJSONString(queryentity,SerializerFeature.WriteNullStringAsEmpty);
				// 替换掉特殊字符
				Pattern p = Pattern.compile("\r|\n");
				Matcher m = p.matcher(json);
				json = m.replaceAll("");
//				String url = "http://10.224.64.149:8881/claim/webservice/budgetForDD/query";
				try {
					// 调用预算查询接口
					String resultstr = HttpClientUtil.httpPost(budgetqryurl,json);
					
					//String resultstr = "{\"deptCode\":\"DP20575\",\"deptName\":\"大数据研发中心\",\"empCode\":\"245102\",\"failReason\":\"\",\"isSuccess\":\"y\",\"leftAmount\":1700,\"subCom\":\"上海德启信息科技有限公司\",\"subComCode\":\"SQZ0000\",\"thisMonthAmount\":42700,\"toDayAmount\":39}";
					
					// 预算数据加工
					QueryResponseBudgetEntity resentity = JSON.parseObject(resultstr, QueryResponseBudgetEntity.class);
					jsonObject.put("dmny", resentity.getToDayAmount());// 日累计消费
					jsonObject.put("mmny", resentity.getThisMonthAmount());// 月累计消费
					jsonObject.put("totalmny", resentity.getLeftAmount());// 预算余额
					jsonObject.put("deptName", resentity.getDeptName());// 成本中心
					jsonObject.put("subCom", resentity.getSubCom());// 子公司名称 
					
				} catch (Exception e) {
					jsonObject.put("fulg", "3");
					jsonObject.put("msg", "查询权限预算异常userId" + e.getMessage());
					LOG.debug("查询权限预算异常userId" + e.getMessage());
				}
				
			}else {// 没有查询到数据
				jsonObject.put("fulg", "2");
				jsonObject.put("msg", "error");
			}
			
		}
		
		//领导人是否审批检查
		try {
			//EmployeeVO evo = externalMethodService.getLeaderInfo(userId);
			String leaderCode = redisService.get(RedisService.DPM_DOC_LEADER_CODE_KEY + userId);
			String leaderLevel = redisService.get(RedisService.DPM_DOC_LEADER_LEVEL_KEY + userId);
			if((leaderCode == null || leaderCode.trim().length() == 0) || (leaderLevel == null || leaderLevel.trim().length() == 0)){
				EmployeeVO evo = externalMethodService.getLeaderInfo(userId);
				redisService.set(RedisService.DPM_DOC_LEADER_CODE_KEY + userId, evo.getEmpCode(), 43200);
				redisService.set(RedisService.DPM_DOC_LEADER_LEVEL_KEY + userId, evo.getJobLevel(), 43200);
				leaderCode = redisService.get(RedisService.DPM_DOC_LEADER_CODE_KEY + userId);
				leaderLevel = redisService.get(RedisService.DPM_DOC_LEADER_LEVEL_KEY + userId);
			}
			int mark = 0;
			String identity = "staff";
			//非领导情况
			//B10及以上不在该规则内
			if(leaderLevel.compareTo("10") < 0){
				//未审批超过5条，mark=1
				int othCount = otherOffDutiesService.getNoApproval2(leaderCode);
				if(othCount >= 5){
					mark = 1;
				}else{
					int douCount = otherOffDutiesService.getNoApproval1(leaderCode);
					if(douCount >= 5 || (othCount + douCount) >= 5){
						mark = 1;
					}
				}
			}
			
			EmployeeVO emp = externalMethodService.getEmpInfo(userId);
			//是领导情况
			//if(mark == 0){			
            int approvalCount = 0;
			if(emp != null && emp.getJobGroups().equals("管理族群")){
				int othnum = otherOffDutiesService.getNoApproval02(userId);
				int dounum = otherOffDutiesService.getNoApproval01(userId);
				approvalCount = othnum + dounum;
				if(mark == 0){	
					if(emp.getJobLevel().compareTo("10") < 0){
						//未审批超过5条，mark=1
						int othCount = otherOffDutiesService.getNoApproval2(userId);
						if(othCount >= 5){
							mark = 1;
							identity = "leader";
						}else{
							int douCount = otherOffDutiesService.getNoApproval1(userId);
							if(douCount >= 5 || (othCount + douCount) >= 5){
								mark = 1;
								identity = "leader";
							}
						}
					}
				}
			}
			
			jsonObject.put("shr", identity);  //未审批身份
			jsonObject.put("xsp", mark);	  //需审批	
			jsonObject.put("approvalCount", approvalCount);
		} catch (Exception e) {
			// TODO: handle exception
			jsonObject.put("msg", "判断领导人审批异常" + e.getMessage());
			LOG.debug("判断领导人审批异常" + e.getMessage());
		}
		
		// 返回页面数据
		writeToPage(jsonObject);
//		ServletOutputStream  outputstream = null;
//		PrintWriter writer = null;
//		try {
//			HttpServletResponse response = ServletActionContext.getResponse();
//			// 设置响应类型
//			response.setContentType("text/html;charset=utf-8");
//			// 跨域设置
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			
//			// 获取一个printWriter对象
//			writer = response.getWriter();
////			// 获取一个printWriter对象
////			outputstream = response.getOutputStream();
//			// 打印,将null值输出为空字符串
//			writer.write(JSON.toJSONString(jsonObject,
//					SerializerFeature.WriteNullStringAsEmpty));
////			outputstream.println(JSON.toJSONString(jsonObject,
////					SerializerFeature.WriteNullStringAsEmpty));
//		} catch (IOException e) {
//			// 错误打印
//			LOG.debug(e.getMessage());
//		} finally {
//			if (writer != null) {
//				writer.flush();
//				writer.close();
////				try {
////					// 关闭连接
////				} catch (IOException e) {
////					LOG.debug(e.getMessage());
////				}  
//			}
//		}
		LOG.debug("success");
//		return SUCCESS;
	}
	//添加欢行短信验证开关
	public void insertHxMsmSwitch(){
		JSONObject jsonObject = new JSONObject();
		try{
			int insert = personIDService.insertHxMsmSwitch(userCode);
			if(insert>0){
				jsonObject.put("data", "添加成功");
				jsonObject.put("code", 0);
			}else{
				jsonObject.put("data", "账号已存在或添加失败");
				jsonObject.put("code", 1);
			}
		}catch(DuplicateKeyException e){
			e.printStackTrace();
			jsonObject.put("data", "账号已存在");
			jsonObject.put("code", 2);
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.put("data", "添加失败");
			jsonObject.put("code", 1);
		}
		writeToPage(jsonObject);
		
	}
	//更新欢行短信验证开关
	public void updateHxMsmSwitch(){
		JSONObject jsonObject = new JSONObject();
		int update = personIDService.updateHxMsmSwitch(userCode,state);
		if(update>0){
			jsonObject.put("data", "更新成功");
			jsonObject.put("code", 0);
		}else{
			jsonObject.put("data", "更新失败");
			jsonObject.put("code", 1);
		}
		writeToPage(jsonObject);
	}
	//搜索欢行短信验证开关
	public void getHxMsmSwitch(){
		JSONObject jsonObject = new JSONObject();
		HxMsmSwitchEntity hx = personIDService.getHxMsmSwitch(userCode);
		if(hx!=null){
			jsonObject.put("data", hx);
			jsonObject.put("code", 0);
		}else{
			jsonObject.put("data", "账号未添加");
			jsonObject.put("code", 1);
		}
		writeToPage(jsonObject);
	}
		
	
	
    /**
	 * 判断是否需要短信校验
	 */
	public void getloadRecord(){
		
		JSONObject jsonObject = new JSONObject();
		
		//add log for deviceId is null
		if(deviceId == null || StringUtils.isEmpty(deviceId) || "null".equalsIgnoreCase(deviceId.trim())){
			LOG.error("==============addloadRecord:{userId:"+userId+",deviceId:"+deviceId+"}=================");
		}
		
		//VP用户无需校验
		try {
			boolean isSeniorLeader = personIDService.isSeniorLeader(userId);
			if(isSeniorLeader == false){
				LoadRecordEntity lrEntity = personIDService.getloadRecord(userId, deviceId);
				jsonObject.put("data", lrEntity);
				jsonObject.put("code", 0);
			}else{
				jsonObject.put("data", "");
				jsonObject.put("code", 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeToPage(jsonObject);
	}
	/**
	 * 新增登陆记录
	 */
	public void addloadRecord(){
		
		JSONObject jsonObject = new JSONObject();

		//add log for deviceId is null
		if(deviceId == null || StringUtils.isEmpty(deviceId) || "null".equalsIgnoreCase(deviceId.trim())){
			LOG.error("==============addloadRecord:{userId:"+userId+",deviceId:"+deviceId+"}=================");
		}
		
		try {
			int res = personIDService.addloadRecord(userId, deviceId);

			jsonObject.put("data", res);
			jsonObject.put("code", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writeToPage(jsonObject);
	}
	

	public void setBudgetqryurl(String budgetqryurl) {
		this.budgetqryurl = budgetqryurl;
	}


	public void setPersonIDService(IPersonIDService personIDService) {
		this.personIDService = personIDService;
	}

	public IOtherOffDutiesService getOtherOffDutiesService() {
		return otherOffDutiesService;
	}

	public void setOtherOffDutiesService(IOtherOffDutiesService otherOffDutiesService) {
		this.otherOffDutiesService = otherOffDutiesService;
	}

	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}

	public void setExternalMethodService(IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}

	public RedisService getRedisService() {
		return redisService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

    public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public IPersonIDService getPersonIDService() {
		return personIDService;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	
}
