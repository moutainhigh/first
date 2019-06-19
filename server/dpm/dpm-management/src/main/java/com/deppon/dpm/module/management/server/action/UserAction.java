package com.deppon.dpm.module.management.server.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IUserService;
import com.deppon.dpm.module.management.shared.vo.LoginUserVO;
import com.deppon.dpm.module.management.shared.vo.ResultVO;

/**
 * @author 268101
 * 用户action
 *
 */
public class UserAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -9033965159123191334L;

	/**
	 * userServiceMs
	 */
	private IUserService userServiceMs;
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	/**
	 * 得到人员
	 */
	public void getUserInfo(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//ResultVO
		ResultVO<LoginUserVO> result = new ResultVO<LoginUserVO>();
        //try catch 捕获异常
		try{
			//得到uid
			String userNo = this.getUserId();
			logger.info("获取用户信息参数:当前登录用户工号是"+userNo);
			//判断工号是否为null
			if(StringUtils.isNotBlank(userNo)){
				//判断工号是否为null
				if(StringUtils.isNotBlank(userNo)){
					//得到登录信息
					LoginUserVO user = this.userServiceMs.getLoginUserVO(userNo);
					//塞入标志位
					result.setResultFlag(true);
					result.setDomain(user);
				}
			}else{
				logger.info("获取参数失败,参数信息为空");
				result.setResultFlag(false);
				result.setFailureReason("参数信息为空");
			}
		}catch (Exception e) {
			//捕获异常
			result.setResultFlag(false);
			result.setFailureReason("系统出现异常");
			e.printStackTrace();
		}
		result.setData(null);
		//转json格式
		JSONObject json = JsonUtil.beanToJSONObject(result);
		//写入数据
		writeToPage(response,json.toString());
	}

	/**
	 * @return userServiceMs
	 */
	public IUserService getUserServiceMs() {
		return userServiceMs;
	}

	/**
	 * @param userServiceMs 接口
	 */
	public void setUserServiceMs(IUserService userServiceMs) {
		this.userServiceMs = userServiceMs;
	}
	
}
