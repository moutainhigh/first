package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IQueryPcInfoService;
import com.deppon.dpm.module.management.server.service.IServeOriginatorsMessageService;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;
import com.deppon.dpm.module.management.shared.vo.PcDetailInfoVo;
import com.deppon.dpm.module.management.shared.vo.ResultVO;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**   
* @Description: 拼车吧
* @author 268087 张广波
* @date 2016-1-5 下午4:20:30 
* @version V1.0 
*/
public class ServeOriginatorsMessageAction extends BaseAction  {
	/**
	 * 版本
	 */
	private static final long serialVersionUID = 7731375327304041011L;	
	/** 
	* @Fields logger 日志
	*/ 
	Logger logger = LoggerFactory.getLogger(ServeOriginatorsMessageAction.class);
	/*
	*//**
	 * 门户头像service
	 *//*
	private IPersonlyImageService personlyImageService;
	*/	
	
	/** 
	* @Fields serveOriginatorsMessageService 拼车操作service
	*/ 
	private IServeOriginatorsMessageService serveOriginatorsMessageService;
	
	/** 
	* @Fields queryPcInfoService 查询所有拼车信息
	*/ 
	private IQueryPcInfoService queryPcInfoService;
	
	/** 
	* @Description: 保存参与信息
	* @author 268087 张广波
	* @date 2016-1-5 下午4:53:12  
	*/
	public void saveParticipants(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = "";
		BufferedReader bu = null;
		ResultVO<Object> result = new ResultVO<Object>();
		try{
			//获取请求参数
			bu = ServletActionContext.getRequest().getReader();
			//转换为json参数
			str = com.deppon.dpm.module.common.server.util.StringUtil.bufferString(bu);
			logger.info("保存参与拼车参数是:"+str);
			if(StringUtils.isNotBlank(str)){
				JSONObject json = JsonUtil.parseObject(str);
				ResultVO<Object> res = this.jumpPart(json);
				if(res.isResultFlag()){		
					//根据前端请求参数获取实体类
					ServeParticipantsInfoEntity entity = JsonUtil.jsonToEntity(str, ServeParticipantsInfoEntity.class);
					//发布信息主键id
					int origId = entity.getOrigId();
					//员工号
					String userNo = entity.getPartNO();					
					PcDetailInfoVo allList = this.queryPcInfoService.queryPCDetailById(origId+"");
					List<String> userNoList = new ArrayList<String>();
					userNoList.add(allList.getServeOriginatorsInfoEntity().getOrigNo());
					for(ServeParticipantsInfoEntity entity2 : allList.getServeParticipantsInfoEntities()){
						userNoList.add(entity2.getPartNO());
					}
					ServeOriginatorsInfoEntity realEntity = this.serveOriginatorsMessageService.getLimitSize(origId);
					if(realEntity != null ){
						//抽取方法
						checkSave(result, entity, origId, userNo, userNoList,
								realEntity);
					}
					//活动状态为已取消不能参与
					else{
						result.setResultFlag(false);
						result.setFailureReason("该活动已经取消,请选择其他活动");
					}
				}else{
					result.setResultFlag(false);
					result.setFailureReason(res.getFailureReason());
				}
			}else{
				logger.info("获取参数失败,参数信息为空");
				result.setResultFlag(false);
				result.setFailureReason("参数信息为空");
			}
		}catch (Exception e) {
			result.setResultFlag(false);
			result.setFailureReason("系统出现异常");
			e.printStackTrace();
		}
		JSONObject json = JsonUtil.beanToJSONObject(result);
		logger.info("返回信息APP信息:"+json.toString());
		writeToPage(response,json.toString());
	}

	private void checkSave(ResultVO<Object> result,
			ServeParticipantsInfoEntity entity, int origId, String userNo,
			List<String> userNoList, ServeOriginatorsInfoEntity realEntity)
			throws BusinessException {
		if(!userNoList.contains(userNo)){
			int numSize = this.queryPcInfoService.getPeoCount(String.valueOf(origId));	
			//获取上限人数
			int limitSize = realEntity.getLimitNum();
			if(numSize >= limitSize ){
				logger.info("报名人数超出上限人数！请选择其他拼车服务报名！");
				result.setResultFlag(false);
				result.setFailureReason("报名人数超出上限人数！请选择其他拼车服务报名！");
			}else{
				if(StringUtils.isNotBlank(entity.getPartNO())){
					boolean re = false;
					//校验是否有重复的参与信息
					//如果有重复就做修改操作
					if (serveOriginatorsMessageService.checkPartRepeat(entity)) {
						re = this.serveOriginatorsMessageService.updatePartInfo(entity);
					}
					//否则做添加操作
					else {
						re = this.serveOriginatorsMessageService.saveServePartInfo(entity);										
					}
					if(re){
						result.setResultFlag(true);
					}else{
						logger.info("保存数据失败");
						result.setResultFlag(false);
						result.setFailureReason("保存数据失败");
					}
				}else{
					logger.info("获取用户信息失败!参与人空号为空！");
					result.setResultFlag(false);
					result.setFailureReason("获取用户信息失败!");
				}			
			}								
		}
		//已报名，不能重复提交
		else{
			logger.info("已经参与该活动");
			result.setResultFlag(false);
			result.setFailureReason("您已经参与该活动,不要再次报名了吧~");
		}
	}

	/** 
	* @Description: 保存发布信息
	* @author 268087 张广波
	* @date 2016-1-5 下午5:26:31  
	*/
	public void saveOriginator(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = "";
		BufferedReader bu = null;
		ResultVO<Object> result = new ResultVO<Object>();
		try{
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			logger.info("保存拼车记录参数是:"+str);
			if(StringUtils.isNotBlank(str)){
				JSONObject json = JsonUtil.parseObject(str);
				ResultVO<Object> jump = this.jumpRecorde(json);
				if(jump.isResultFlag()){
					//根据请求参数获取实体类
					ServeOriginatorsInfoEntity entity = JsonUtil.jsonToEntity(str, ServeOriginatorsInfoEntity.class);
					//boolean flag = true;
					if(entity.getOrigType()==2){
						//校验主题是否为空
						if(StringUtils.isBlank(entity.getOrigTitle())){
							//flag = false;
							logger.info("该记录为活动记录,但是主题title却是空！");
							result.setResultFlag(false);
							result.setFailureReason("请填写活动主题,再提交!");
							return;
						}
					}
					//if(flag){
					//校验是否重复提交
					if (serveOriginatorsMessageService.checkOrigRepeat(entity)) {
						logger.info("不能重复提交");
						result.setResultFlag(false);
						result.setFailureReason("不能重复提交!");
					}
					else {
						//保存发布信息
						boolean re = this.serveOriginatorsMessageService.saveServeOriginatorInfo(entity);
						if(re){
							result.setResultFlag(true);
						}else{
							logger.info("保存数据失败");
							result.setResultFlag(false);
							result.setFailureReason("保存数据失败");
						}
					}						
			       //}
				}else{
					result.setResultFlag(false);
					result.setFailureReason(jump.getFailureReason());
				}
			}else{
				logger.info("获取参数失败,参数信息为空");
				result.setResultFlag(false);
				result.setFailureReason("参数信息为空");
			}
		}catch (Exception e) {
			result.setResultFlag(false);
			result.setFailureReason("系统出现异常");
			e.printStackTrace();
		}
		JSONObject json = JsonUtil.beanToJSONObject(result);
		logger.info("返回信息APP信息:"+json.toString());
		writeToPage(response,json.toString());
	}
	
	/**
	 * 保存记录信息验证
	 * @param json
	 * @return
	 * @throws ParseException 
	 */
	private ResultVO<Object> jumpRecorde(JSONObject json) throws ParseException {
		ResultVO<Object> result = new ResultVO<Object>();
		result.setResultFlag(true);
		//校验发布信息类型是否非空
		if(StringUtils.isNotBlank(json.getString("origType"))){
			int origType = json.getInteger("origType");
			//始发地省名称
			String startProvinceName = json.getString("startProvinceName");
			//始发地市名称
			String startCityName = json.getString("startCityName");
			//目的地省名称
			String endProvinceName = json.getString("endProvinceName");
			//目的地市名称
			String endCityName = json.getString("endCityName");
			//上班车  //活动
			if(origType==0 || origType==2){
				if(StringUtils.isBlank(startProvinceName) || StringUtils.isBlank(startCityName)){
					result.setResultFlag(false);
					result.setFailureReason("请选择出发地点!");
				}
			}
			//下班车 //活动
			if(origType==1 || origType==2){
				if(StringUtils.isBlank(endProvinceName) || StringUtils.isBlank(endCityName)){
					result.setResultFlag(false);
					result.setFailureReason("请选择到达地点!");
				}
			}
		}else{
			result.setResultFlag(false);
			result.setFailureReason("系统异常,没有类型参数传入!");
		}	
		//校验上限人数
		if(StringUtils.isBlank(json.getString("limitNum"))){
			result.setResultFlag(false);
			result.setFailureReason("请填写限定人数!");
		}
		//校验联系电话
		else if(StringUtils.isBlank(json.getString("origTel"))){
			result.setResultFlag(false);
			result.setFailureReason("请填写联系电话!");
		}
		//校验始发地
		else if(StringUtils.isBlank(json.getString("startPlace"))){
			result.setResultFlag(false);
			result.setFailureReason("请输入出发地点!");
		}
		//校验目的地
		else if(StringUtils.isBlank(json.getString("endPlace"))){
			result.setResultFlag(false);
			result.setFailureReason("请输入目的地!");
		}
		//校验出发时间
		else if(StringUtils.isBlank(json.getString("startTime"))){
			result.setResultFlag(false);
			result.setFailureReason("请选择出发时间!");
		}
		//校验出发时间是否合理
		else if(!StringUtils.isBlank(json.getString("startTime"))&&checkPartTime(json, "startTime")){
			result.setResultFlag(false);
			result.setFailureReason("请重新选择出发时间(出发时间不能早于当前时间)!");
		}		
		/*if(result.isResultFlag()){
			Date partTime = json.getDate("partTime");
			Date startTime = json.getDate("startTime");
			if(!partTime.before(startTime)){
				result.setResultFlag(false);
				result.setFailureReason("报名截止时间要在出发时间之前！");
			}
		}*/		
		//抽取方法
		checkResult(json, result);
		
		return result;
	}

	private void checkResult(JSONObject json, ResultVO<Object> result) {
		if(result.isResultFlag()){
			try{
				int a = json.getInteger("limitNum");
				if(a<1){
					result.setResultFlag(false);
					result.setFailureReason("请输入大于0的限定人数!");
				}
			}catch (Exception e) {
				result.setResultFlag(false);
				result.setFailureReason("请输入正确的限定人数!");
			}
		}
		if(result.isResultFlag()){
			boolean flag = isPhoneNumber(json.getString("origTel"));
			if(!flag){
				result.setResultFlag(false);
				result.setFailureReason("请输入或修改成正确的联系电话!");
			}
		}
	}
	
	/** 
	* @Description: 比较传入的时间和当前时间
	* @author 268087 张广波
	* @date 2015-12-29 下午4:34:39 
	*  @param str
	*  @param key
	*  @return
	 * @throws ParseException 
	*/
	private  boolean checkPartTime(JSONObject json,String key) throws ParseException  {		
		boolean flag = false;
		if (!StringUtil.isBlank(json.getString(key))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date keyValDate = sdf.parse(json.getString(key));
			//当前时间
			Date dt = new Date();
			flag = keyValDate.before(dt);
		}
		return flag;
	}
	
	/**
	 * 参与者保存验证
	 * @param json
	 * @return
	 */
	private ResultVO<Object> jumpPart(JSONObject json){
		ResultVO<Object> result = new ResultVO<Object>();		
		result.setResultFlag(true);
		//校验参与者电话号
		if(StringUtils.isBlank(json.getString("partTel"))){
			result.setResultFlag(false);
			result.setFailureReason("请填写联系电话!");
		}		
		if(result.isResultFlag()){
			//正则表达式校验电话号格式是否正确
			boolean flag = isPhoneNumber(json.getString("partTel"));
			if(!flag){
				result.setResultFlag(false);
				result.setFailureReason("请输入或修改成正确的联系电话!");
			}
		}
		return result;
	}
	

	/** 
	* @Description: 校验是否是电话号
	* @author 268087 张广波
	* @date 2016-1-5 下午5:17:56 
	*  @param input
	*  @return 
	*/
	private boolean isPhoneNumber(String input){  
	    String regex="1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";  
//	    Pattern p = Pattern.compile(regex);  
	    return Pattern.matches(regex, input);  
	} 
	
	
	/** 
	* @Description: 获取拼车操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午5:17:24 
	*  @return 
	*/
	public IServeOriginatorsMessageService getServeOriginatorsMessageService() {
		return serveOriginatorsMessageService;
	}

	/** 
	* @Description: 设置操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午5:17:48 
	*  @param serveOriginatorsMessageService 
	*/
	public void setServeOriginatorsMessageService(IServeOriginatorsMessageService serveOriginatorsMessageService) {
		this.serveOriginatorsMessageService = serveOriginatorsMessageService;
	}

	/** 
	* @Description: 获取操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午5:17:13 
	*  @return 
	*/
	public IQueryPcInfoService getQueryPcInfoService() {
		return queryPcInfoService;
	}

	/** 
	* @Description: 设置操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午5:16:39 
	*  @param queryPcInfoService 
	*/
	public void setQueryPcInfoService(IQueryPcInfoService queryPcInfoService) {
		this.queryPcInfoService = queryPcInfoService;
	}	
}
