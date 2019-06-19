package com.deppon.dpm.module.main.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.AutoPunchClockMonitorEntity;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.module.main.server.service.IAutoPunchClockMonitorGlobalService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author
 * @since 2018-11-21
 * 
 * */
public class AutoPunchClockMonitorGlobalAction extends BaseAction implements ModelDriven<AutoPunchClockMonitorEntity>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(AutoPunchClockMonitorGlobalAction.class);
	
	// 构建实体对象
	private AutoPunchClockMonitorEntity entity = new AutoPunchClockMonitorEntity();
	
	// service
	private IAutoPunchClockMonitorGlobalService autoPunchClockMonitorService;
	
	// getModle
	public AutoPunchClockMonitorEntity getModel() {
		return entity;
	}

	// 保存
	public void save() {
		try {
			// 排除android手动打卡传入empCode为null
			if(null == entity.getEmpCode()) {
				LOG.info("打卡监控插入信息传参错误!!! " + entity.toString());
				return;
			}
			
			// 从ThreadLocal中获取登录时存入的信息
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			if(loginResult != null){
				entity.setOsType(loginResult.getOsType());
				entity.setAppVersion(loginResult.getAppVersion());
				entity.setPhoneModel(loginResult.getPhoneModel());
				entity.setOsVersion(loginResult.getOsVersion());
			}
			int versionIntVal = Integer.parseInt(entity.getAppVersion().replace(".", ""));
			// 排除errorMsg为空、或者版本是<=3.8.4的版本的监控，这个是android产生的bug，防止插入过多的无用数据
			if("android".equalsIgnoreCase(entity.getOsType()) &&
					(versionIntVal <= MagicNumber.NUM384 || StringUtils.isBlank(entity.getErrorMsg()))) {
				return;
			}
			// 保存
			autoPunchClockMonitorService.save(entity);
		} catch (Exception e) {
			LOG.error("打卡监控插入信息失败：" + entity.toString(),e);
		}
	}
	
	// 分页查询
	public void queryByPage() {
		String empCode = entity.getEmpCode();
		if(StringUtils.isEmpty(empCode)){
			return;
		}
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			// 当前页
			int page = entity.getPage();
			// 每页条数
			int rows = entity.getRows();
			int start = 0;
			if(page != 0) {
				start = (page -1) * rows;
			}
			// 查询
			List<NativePushCfgEntity> list = autoPunchClockMonitorService.queryByPage(start,rows,empCode);
			// 总条数
			long count = autoPunchClockMonitorService.queryCount(empCode);
			result.put("total", count);
			result.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回
		writeToPage(result);
	}

	// setter
	public void setAutoPunchClockMonitorService(
			IAutoPunchClockMonitorGlobalService autoPunchClockMonitorService) {
		this.autoPunchClockMonitorService = autoPunchClockMonitorService;
	}
	
}
