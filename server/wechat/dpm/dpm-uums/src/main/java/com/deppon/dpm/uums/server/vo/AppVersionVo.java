package com.deppon.dpm.uums.server.vo;

import java.io.Serializable;
import java.util.List;

import com.deppon.dpm.uums.server.domain.VersionEntity;

/** 
 * @ClassName: AppFunctionVo 
 * @Description: 功能权限的VO
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月22日 下午4:10:23 
 *  
 */
public class AppVersionVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 功能类的基础映射
	 */
	private VersionEntity versionEntity;
	private List<VersionEntity> versionList;
	

	public List<VersionEntity> getVersionList() {
		return versionList;
	}

	public void setVersionList(List<VersionEntity> versionList) {
		this.versionList = versionList;
	}

	public VersionEntity getVersionEntity() {
		return versionEntity;
	}

	public void setVersionEntity(VersionEntity versionEntity) {
		this.versionEntity = versionEntity;
	}
	
	
}
