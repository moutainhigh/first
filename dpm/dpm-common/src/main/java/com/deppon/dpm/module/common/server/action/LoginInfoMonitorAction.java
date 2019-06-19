package com.deppon.dpm.module.common.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

import com.deppon.dpm.module.common.server.service.ILoginInfoMonitorService;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.module.common.shared.domain.LoginInfoMonitorEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.module.common.shared.vo.MobileInfoVo;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 登录信息（含登录地点）
 */
public class LoginInfoMonitorAction extends BaseAction implements ModelDriven<LoginInfoMonitorEntity>{

	private static final Logger LOG = LoggerFactory.getLogger(LoginInfoMonitorAction.class);
	
	private LoginInfoMonitorEntity entity = new LoginInfoMonitorEntity();
	
	private ILoginInfoMonitorService loginInfoMonitorService;
	
    private String msg_imei; //设备号
	
	private String msg_androidid; //  安卓ID
	
	private String msg_systemmodel; // 手机型号
	
	private String msg_phonenum; // 手机号
	
	private String msg_subscriberid; // SIM卡唯一的用户ID
	
	private String msg_simserialnumber; // SIM卡序列号
	
	private String msg_basebandstring; // 手机基带版本
	
	private String msg_macaddress; // 手机mac地址
	
	private String msg_contactphonenumber; // 手机部分联系人

	private String empCode;
	
	@Override
	public LoginInfoMonitorEntity getModel() {
		return entity;
	}

	public void saveLoginInfo(){
		try {
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			EmpExtensionEntity empExtensionEntity = loginResult.getEmpExtensionEntity();
			entity.setOsType(loginResult.getOsType());
			entity.setAppVersion(loginResult.getAppVersion());
			entity.setDeviceToken(empExtensionEntity == null ? null : empExtensionEntity.getDeviceToken());
			entity.setPhoneModel(loginResult.getPhoneModel());
			entity.setOsVersion(loginResult.getOsVersion());
			entity.setPhoneMac(empExtensionEntity == null ? null : empExtensionEntity.getPhoneMac());
			entity.setLoginTime(empExtensionEntity == null ? null : empExtensionEntity.getLoginTime());
		} catch (Exception e) {
			LOG.error("LoginInfoMonitorAction保存登录信息获取登录结果集出错>>>>",e);
		}
		try {
			loginInfoMonitorService.saveLoginInfo(entity);
		} catch (Exception e) {
			LOG.error("LoginInfoMonitorAction保存登录信息出错>>>>" + entity.toString(),e);
		}
	}
	
	public void saveMobileInfo(){
		MobileInfoVo moVo = new MobileInfoVo();
		try {
			moVo.setEmpCode(empCode);
			moVo.setMsgAndroidid(msg_androidid);
			moVo.setMsgBasebandstring(msg_basebandstring);
			moVo.setMsgContactphonenumber(msg_contactphonenumber);
			moVo.setMsgImei(msg_imei);
			moVo.setMsgMacaddress(msg_macaddress);
			moVo.setMsgPhonenum(msg_phonenum);
			moVo.setMsgSimserialnumber(msg_subscriberid);
			moVo.setMsgSubscriberid(msg_simserialnumber);
			moVo.setMsgModel(msg_systemmodel);
			
			loginInfoMonitorService.saveMobileInfo(moVo);
		} catch (Exception e) {
			LOG.error("LoginInfoMonitorAction保存手机信息出错>>>>" + moVo.toString(),e);
		}
	}

	// setter
	public void setLoginInfoMonitorService(
			ILoginInfoMonitorService loginInfoMonitorService) {
		this.loginInfoMonitorService = loginInfoMonitorService;
	}

	public String getMsg_imei() {
		return msg_imei;
	}

	public void setMsg_imei(String msg_imei) {
		this.msg_imei = msg_imei;
	}

	public String getMsg_androidid() {
		return msg_androidid;
	}

	public void setMsg_androidid(String msg_androidid) {
		this.msg_androidid = msg_androidid;
	}

	public String getMsg_systemmodel() {
		return msg_systemmodel;
	}

	public void setMsg_systemmodel(String msg_systemmodel) {
		this.msg_systemmodel = msg_systemmodel;
	}

	public String getMsg_phonenum() {
		return msg_phonenum;
	}

	public void setMsg_phonenum(String msg_phonenum) {
		this.msg_phonenum = msg_phonenum;
	}

	public String getMsg_subscriberid() {
		return msg_subscriberid;
	}

	public void setMsg_subscriberid(String msg_subscriberid) {
		this.msg_subscriberid = msg_subscriberid;
	}

	public String getMsg_simserialnumber() {
		return msg_simserialnumber;
	}

	public void setMsg_simserialnumber(String msg_simserialnumber) {
		this.msg_simserialnumber = msg_simserialnumber;
	}

	public String getMsg_basebandstring() {
		return msg_basebandstring;
	}

	public void setMsg_basebandstring(String msg_basebandstring) {
		this.msg_basebandstring = msg_basebandstring;
	}

	public String getMsg_macaddress() {
		return msg_macaddress;
	}

	public void setMsg_macaddress(String msg_macaddress) {
		this.msg_macaddress = msg_macaddress;
	}

	public String getMsg_contactphonenumber() {
		return msg_contactphonenumber;
	}

	public void setMsg_contactphonenumber(String msg_contactphonenumber) {
		this.msg_contactphonenumber = msg_contactphonenumber;
	}

	public ILoginInfoMonitorService getLoginInfoMonitorService() {
		return loginInfoMonitorService;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	

}
