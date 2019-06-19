package com.deppon.dpm.tongxunlu.server.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.opensymphony.xwork2.ModelDriven;

public class JPushNewAction extends BaseAction implements ModelDriven<JPushParam>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private static final Logger LOG = LoggerFactory.getLogger(JPushNewAction.class);
	
	private JPushParam entity = new JPushParam();
	
	/**
	 * 推送人(推送到谁)
	 */
	private String userIds;

	/**
	 * 推送标题
	 */
	private String alert;
	/**
	 * 推送内容 
	 */
	private String content;
	/**
	 * 来自Pda
	 */
	private Boolean isPda = false;
	/**
	 * 链接参数（json字符串）
	 */
	private String args;
    /**
     * 推送人工号（谁推送的）
     */
	private String empCode;
	/**
	 * 推送人密码
	 */
	private String empPassword;
	

	private IJPushNewService jPushNewService;
    
	
	// getModel
	public JPushParam getModel() {
		return entity;
	}

	/**
	 * 查询所有的本部
	 */
	public void queryPrimaryDept(){
		List<OrganizationVO> list = null;
		try {
			list = jPushNewService.queryPrimaryDept();
		} catch (Exception e) {
			LOG.error("查询所有本部信息出错!!!",e);
		}
		writeToPage(list);
	}
	
	/**
	 * 全员推送
	 */
//	public void pushAll() {
//		try {
//			PushResult result = jPushNewService.pushAll(entity);
//			LOG.info("Got result - " + result);
//			writeToPage("success");
//			return;
//		} catch (Exception e) {
//			LOG.error("全员推送失败!!! " + entity.toString(),e);
//		}
//		writeToPage("error");
//	}
	
	/**
	 * 根据工号推送
	 */
	public void pushByUserIds(){
		try {
			// 推送
			jPushNewService.pushByUserIds(entity);
			// 保存推送记录到消息中心
			entity.setPushConditionValue(entity.getUserIds());
			jPushNewService.saveToMsgCentre(entity, 0);
			writeToPage("success");
		} catch (Exception e) {
			LOG.error("根据工号推送失败!!! " + entity.toString(),e);
		}
		writeToPage("error");
	}
	
	/**
	 * 外网消息推送
	 */
	@CookieNotCheckedRequired
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void pushNotification(){
		//跨域处理
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//5：来自Pda
		/*entity.setLinktype(linktype);*/
	    // 进消息中心
	 	entity.setIntoMC(true);
	 	//json字符串转map
	 	Map maps = (Map)JSON.parse(args); 
	 	//链接参数
	 	if(maps != null){
	 		entity.setExtras(maps);
	 	}
	    try {
			//推送
	    	jPushNewService.pushByUserIds(entity);
			//保存推送记录到消息中心
			entity.setPushConditionValue(entity.getUserIds());
			jPushNewService.saveToMsgCentre(entity, 0);
		} catch (Exception e) {
			Log.error("根据工号推送失败!!! " + entity.toString(),e);	
		}
	    Result<JPushParam> result = new Result<JPushParam>();
	    result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(entity);
		this.writeToPage(result);
	}
	
	/**
	 * 根据条件推送
	 */
	public void pushByCondition(){
		try {
			jPushNewService.pushByCondition(entity);
			writeToPage("success");
		} catch (Exception e) {
			LOG.error("根据条件推送失败!!! " + entity.toString(),e);
		}
		writeToPage("error");
	}

	// setter
	public void setJPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}
	
	public JPushParam getEntity() {
		return entity;
	}

	public void setEntity(JPushParam entity) {
		this.entity = entity;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsPda() {
		return isPda;
	}

	public void setIsPda(Boolean isPda) {
		this.isPda = isPda;
	}
	/*public String getLinkaddr() {
		return linkaddr;
	}

	public void setLinkaddr(String linkaddr) {
		this.linkaddr = linkaddr;
	}*/

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

}
