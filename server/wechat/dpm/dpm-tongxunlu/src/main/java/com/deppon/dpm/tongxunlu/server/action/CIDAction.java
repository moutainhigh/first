package com.deppon.dpm.tongxunlu.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.tongxunlu.server.service.ICIDService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.CIDEntity;
import com.deppon.dpm.tongxunlu.shared.vo.CIDEMP;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 来电显示
 */
public class CIDAction extends BaseAction implements ModelDriven<CIDEntity> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2367990358365771816L;

	private static final Logger LOG = LoggerFactory.getLogger(CIDAction.class);

	private CIDEntity entity = new CIDEntity();

	private ICIDService cIDService;

	private RedisService redisService;
	
	private String userId;

	private static final String REDIS_KEY = "CID_PERMISSION_ON_OFF";
	private static final String REDIS_KEY_ANDROID = "CID_PERMISSION_ANDROID_ON_OFF";
	private static final String REDIS_TONGXUNLU_VOICE = "DPM_TONGXUNLU_VOICE_ON_OFF";

	@Override
	public CIDEntity getModel() {
		return entity;
	}

	/**
	 * 查询来电显示的通讯录版本信息
	 */
	public void queryCID() {
		try {
			String isManagePage = ServletActionContext.getRequest()
					.getParameter("isManagePage");
			// pc
			if ("true".equals(isManagePage)) {
				List<CIDEntity> list = cIDService.queryCIDByOsType(entity.getOsType());
				Map<String, Object> result = new HashMap<String, Object>();
				result.put("rows", list);
				writeToPage(result);
			} else {
				// 科大讯飞语音控制
				if(entity!=null && "voice".equals(entity.getOsType())){
					String str = redisService.get(REDIS_TONGXUNLU_VOICE);
					writeToPage(StringUtils.isEmpty(str)?"0":str);
					return ;
				}
				// android
				if(entity!=null && "android".equals(entity.getOsType())){
					// redis中获取权限开关信息
					String str = redisService.get(REDIS_KEY_ANDROID);
					// 查询数据
					List<CIDEntity> list = cIDService.queryCIDByOsType(entity.getOsType());
					// 返回结果集
					CIDEntity cid = new CIDEntity();
					// 结果集处理
					if(list != null && list.size()>0){
						cid = list.get(0);
					}
					// android是否打开来电显示权限 1:显示，0：不显示
					String authority = "0";
					if(str != null && "1".equals(str)){
						authority = "1";
					} else if (str != null && "0".equals(str)){
						authority = cIDService.judgeOrgIdByUserId(userId)+"";
					}
					cid.setAuthority(authority);
					writeToPage(cid);
				}else{// ios
					// redis中获取权限开关信息
					String str = redisService.get(REDIS_KEY);
					// 如果没有控制或者已经开放了权限
					if (null == str || "1".equals(str)) {
						List<CIDEntity> list = cIDService.queryCIDByOsType(entity
								.getOsType());
						writeToPage(list.size() > 0 ? list.get(0) : null);
						return;
					}
					
					// 限制了权限，从本地线程中获取当前用户所在的部门，如果是办公门户研发部，就开放下载来电显示本
					LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
					if (null != loginResult
							&& loginResult.getUserEntity().getOrganization()
							.getOrgId() == 10051) {
						List<CIDEntity> list = cIDService.queryCIDByOsType(entity
								.getOsType());
						writeToPage(list.size() > 0 ? list.get(0) : null);
					}
				}
			}
		} catch (Exception e) {
			LOG.error("查询来电显示的通讯录版本信息出错!!! osType=" + entity.getOsType(), e);
		}
	}

	/**
	 * 来电显示部分开放控制
	 */
	public void permissionControl() {
		String operate = ServletActionContext.getRequest().getParameter("operate");
		try {
			// 科大讯飞语音控制
			if(entity!=null && "voice".equals(entity.getOsType())){
				if ("1".equals(operate)) {
					// 开启
					redisService.set(REDIS_TONGXUNLU_VOICE, "1");
				} else {
					// 关闭
					redisService.set(REDIS_TONGXUNLU_VOICE, "0");
				}
			} else if(entity!=null && "android".equals(entity.getOsType())){
				if ("2".equals(operate)) {
					// 全部关闭
					redisService.set(REDIS_KEY_ANDROID, "2");
				}
				if ("1".equals(operate)) {
					// 开启
					redisService.set(REDIS_KEY_ANDROID, "1");
				} else {
					// 关闭
					redisService.set(REDIS_KEY_ANDROID, "0");
				}
			}else{
				if ("1".equals(operate)) {
					// 开启
					redisService.set(REDIS_KEY, "1");
				} else {
					// 关闭
					redisService.set(REDIS_KEY, "0");
				}
			}
		} catch (Exception e) {
			LOG.error("通讯录来电显示开放关闭权限出错！！！", e);
		}
		writeToPage("success");
	}

	/**
	 * 同步来电显示通讯录
	 */
	public void syncCIDBook() {
		boolean result = cIDService.syncCIDBook();
		if (result) {
			writeToPage("success");
		} else {
			writeToPage("fail");
		}
	}

	/**
	 * 根据手机号查询用户信息,只为android使用
	 */
	@CookieNotCheckedRequired
	public void queryUserInfoByNo() {
		// 定义返回前端
		Result<CIDEMP> result = new Result<CIDEMP>();
		CIDEMP emp = null;
		try {
			if (entity != null && StringUtils.isNotEmpty(entity.getOsType())
					&& "android".equals(entity.getOsType())
					&& StringUtils.isNotEmpty(entity.getIphoneNo())) {
				// 手机号正则表达式
				String regex = "^1[3|4|5|7|8]\\d{9}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher m = pattern.matcher(entity.getIphoneNo());
				// 如果手机不合法或者姓名为空或者部门为空则跳过
				if (m.find()) {
					// 根据手机号查询用户信息
					emp = cIDService.queryUserInfoByNo(entity.getIphoneNo());
				}
			}
			if (emp != null) {
				// 包含的数据
				result.setData(emp);
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
			} else {
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			}
		} catch (Exception e) {
			LOG.error("根据手机号查询用户信息出错！！！", e);
		}
		// 返回
		writeToPage(result);
	}

	public void setCIDService(ICIDService cIDService) {
		this.cIDService = cIDService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

	public CIDEntity getEntity() {
		return entity;
	}

	public void setEntity(CIDEntity entity) {
		this.entity = entity;
	}

	public void setcIDService(ICIDService cIDService) {
		this.cIDService = cIDService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
