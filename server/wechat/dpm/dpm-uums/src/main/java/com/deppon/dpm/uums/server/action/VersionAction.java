/**
 * Project Name:dpm-uums
 * File Name:AuthorityFunctionAction.java
 * Package Name:com.deppon.dpm.uums.server.action
 * Date:2014-8-12下午11:27:24
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.uums.server.action;

import com.deppon.dpm.uums.server.service.IVersionService;
import com.deppon.dpm.uums.server.vo.AppVersionVo;
import com.deppon.foss.framework.server.web.action.AbstractAction;
import com.deppon.foss.framework.server.web.result.json.annotation.JSON;


/**
 * 
* @ClassName: VersionAction 
* @Description: 版本 action
* @author gcl-195406
* @date 2014年11月28日 
*
 */
public class VersionAction extends AbstractAction{
	
	private IVersionService versionService;
	
	private AppVersionVo vo;

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7369897918724179551L;
	@JSON
	public String intoVersion(){
		return returnSuccess();
	}
	/**
	 * 
	 * @Title: selectVersion 
	 *
	 * @Description: 查询全部
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午6:08:17 
	 *
	 * @return String    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	@JSON
	public String selectVersion(){
		
		if(null == vo){
			vo=new AppVersionVo();
		}
		vo.setVersionList(versionService.selectVersions());
		return returnSuccess();
	}
	
	@JSON
	public String updateVersion(){
		//sonar 整改
//		System.out.println(vo.getVersionEntity().getVid()+"------------");
		versionService.updateVersion(vo.getVersionEntity());
		
		return returnSuccess();
	}
	
	
	/******************** getter and setter *****************************/

	
	
	public void setVersionService(IVersionService versionService) {
		this.versionService = versionService;
	}


	public AppVersionVo getVo() {
		return vo;
	}


	public void setVo(AppVersionVo vo) {
		this.vo = vo;
	}
	

}

