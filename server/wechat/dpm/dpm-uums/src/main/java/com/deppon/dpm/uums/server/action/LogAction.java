/**
 * Project Name:dpm-uums
 * File Name:LogAction.java
 * Package Name:com.deppon.dpm.uums.server.action
 * Date:
 * Copyright (c) 2014, yu@yyx-me.com All Rights Reserved.
 *
 */

package com.deppon.dpm.uums.server.action;

import com.deppon.dpm.uums.server.service.ILogService;
import com.deppon.dpm.uums.server.vo.AppLogVo;
import com.deppon.foss.framework.server.web.action.AbstractAction;
import com.deppon.foss.framework.server.web.result.json.annotation.JSON;


/**
 * 
* @ClassName: LogAction 
* @Description: 查看日志页面
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年09月18日15:48:53
*
 */
public class LogAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private ILogService logService;

	private AppLogVo vo;
	
	/**
	 * 
	 * @Title: 查询所有的操作日志
	 *
	 * @Description: 插入,更新
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午6:07:59
	 *
	 * @return String 返回类型
	 *
	 * @throws
	 * @see yu
	 */

	@JSON
	public String selectLimitShow() {

		if(vo == null){
			//return returnError("参数错误!");
			vo=new AppLogVo();
		}
		vo.setLimit(limit);
		vo.setStartLimit(start);
		logService.select(vo);
		
		return returnSuccess();
	}

	/** 
	 * @param logService 要设置的 logService 
	 */
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}

	/** 
	 * @return vo 
	 */
	public AppLogVo getVo() {
		return vo;
	}

	/** 
	 * @param vo 要设置的 vo 
	 */
	public void setVo(AppLogVo vo) {
		this.vo = vo;
	}
}
