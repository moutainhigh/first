package com.deppon.dpm.module.common.server.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.module.common.server.dao.IMonitorActionInfoDao;
import com.deppon.dpm.module.common.server.service.IMonitorActionInfoService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.MonitorActionInfo;

/**
 * 监控Action详细信息Service实现类
 *
 */
public class MonitorActionInfoServiceImpl implements IMonitorActionInfoService {

	/**
	 * monitorActionInfoDao
	 */
	private IMonitorActionInfoDao monitorActionInfoDao;

	/**
	 * 保存action执行详细信息
	 * 
	 * @param entity
	 */
	@Override
	public int saveActionInfo(MonitorActionInfo entity) {
		// 处理请求参数
		if(entity != null && StringUtils.isNotEmpty(entity.getReqParameter())){
			entity.setReqParameter(dealParameter(entity.getReqParameter()));
		}
		// 处理返回参数
		if(entity != null && StringUtils.isNotEmpty(entity.getResParameter())){
			entity.setResParameter(dealParameter(entity.getResParameter()));
		}
		// 调用dao
		return monitorActionInfoDao.saveActionInfo(entity);
	}
	
	/**
	 * 处理请求参数
	 * 
	 * @return
	 */
	private String dealParameter(String param){
		// 使用正则表达式删除无需保存参数
		if(StringUtils.isNotEmpty(param)){
			// 正则规则
			String regex1 = "\\\"casCookie\\\":\\[\\\"[^\\]]*\\\"\\],?";
			String regex2 = "\\\"sessionId\\\":\\[\\\"[^\\]]*\\\"\\],?";
			String regex3 = "\\\"token\\\":\\[\\\"[^\\]]*\\\"\\],?";
			param = param.replaceAll(regex1, "").replaceAll(regex2, "").replaceAll(regex3, "");
		}
		// 长度切割
		if(param.length() > MagicNumber.NUM1800){
			param = param.substring(0, MagicNumber.NUM1800);
		}
		// 返回
		return param;
	}
	
	/**
	 * 获取需要监控的用户List
	 * 
	 * @return
	 */
	public List<String> queryMonitorEmpCodeList(){
		// 查询list
		return monitorActionInfoDao.queryMonitorEmpCodeList();
	}

	/**
	 * set
	 * 
	 * @param monitorActionInfoDao
	 */
	public void setMonitorActionInfoDao(
			IMonitorActionInfoDao monitorActionInfoDao) {
		this.monitorActionInfoDao = monitorActionInfoDao;
	}

}
