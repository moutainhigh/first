package com.deppon.dpm.uums.server.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.deppon.dpm.uums.server.domain.LogEntity;

/** 
 * @ClassName: AppLogVo 
 * @Description: 日志VO
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年09月18日23:04:39
 *  
 */
public class AppLogVo implements Serializable {

	/** 
	*/ 
	private static final long serialVersionUID = -867991797232250764L;
	
	/**
	 * 日志实体
	 */
	private LogEntity logEntity;
	
	private List<LogEntity> logList;
	/**
	 * 总数
	 */
	private  Long totalCount;
	
	private int limit;
	private int startLimit;
	
	/**
	 * 查询时间段开始时间
	 */
	private Date startTime;
	/**
	 * 查询时间段结束时间
	 */
	private Date endTime;
	
	/**
	 * 根据操作人工号查询
	 */
	private String userCode;
	
	/**
	 * 根据操作人名称查询
	 */
	private String userName;

	/** 
	 * @return logEntity 
	 */
	public LogEntity getLogEntity() {
		return logEntity;
	}

	/** 
	 * @param logEntity 要设置的 logEntity 
	 */
	public void setLogEntity(LogEntity logEntity) {
		this.logEntity = logEntity;
	}

	/** 
	 * @return userCode 
	 */
	public String getUserCode() {
		return userCode;
	}

	/** 
	 * @param userCode 要设置的 userCode 
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/** 
	 * @return userName 
	 */
	public String getUserName() {
		return userName;
	}

	/** 
	 * @param userName 要设置的 userName 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/** 
	 * @return logList 
	 */
	public List<LogEntity> getLogList() {
		return logList;
	}

	/** 
	 * @return totalCount 
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/** 
	 * @param totalCount 要设置的 totalCount 
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	/** 
	 * @param logList 要设置的 logList 
	 */
	public void setLogList(List<LogEntity> logList) {
		this.logList = logList;
	}

	/** 
	 * @return limit 
	 */
	public int getLimit() {
		return limit;
	}

	/** 
	 * @param limit 要设置的 limit 
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/** 
	 * @return startLimit 
	 */
	public int getStartLimit() {
		return startLimit;
	}

	/** 
	 * @param startLimit 要设置的 startLimit 
	 */
	public void setStartLimit(int startLimit) {
		this.startLimit = startLimit;
	}

	/** 
	 * @return startTime 
	 */
	public Date getStartTime() {
		return startTime;
	}

	/** 
	 * @param startTime 要设置的 startTime 
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/** 
	 * @return endTime 
	 */
	public Date getEndTime() {
		return endTime;
	}

	/** 
	 * @param endTime 要设置的 endTime 
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
