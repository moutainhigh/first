/**
 * Project Name:dpm-uums
 * File Name:AuthorityFunctionAction.java
 * Package Name:com.deppon.dpm.uums.server.action
 * Date:2014-8-12下午11:27:24
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.uums.server.action;

import java.util.HashMap;
import java.util.Map;

import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.uums.server.service.IRoleService;
import com.deppon.dpm.uums.server.vo.AppRoleVo;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.web.action.AbstractAction;
import com.deppon.foss.framework.server.web.result.json.annotation.JSON;


/**
 * 
* @ClassName: AuthorityFunctionAction 
* @Description: 功能类的action
* @author yuyongxiang-134019-yuyongxiang@deppon.com
* @date 2014年8月25日 下午3:45:43 
*
 */
public class RoleAction extends AbstractAction{
	
	private IRoleService roleService;
	
	private AppRoleVo vo;

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7369897918724179551L;
	
	/**
	 * 
	 * @Title: insertOrUpdate 
	 *
	 * @Description: 插入,更新
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午6:07:59 
	 *
	 * @return String    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	
	@JSON
	public String insertOrUpdate(){
		try{
			
		String id=roleService.insertOrUpdateOne(vo.getRoleEntity());
		vo.getRoleEntity().setId(id);
		vo.setRoleEntity(vo.getRoleEntity());
		
		}catch (BusinessException e){
			return returnError(e);
		}
		return returnSuccess();
	}
	/**
	 * 
	 * @Title: delete 
	 *
	 * @Description: 删除
	 *
	 * @author 134019-yuyongxiang@deppon.com
	 *
	 * @date 2014年8月25日 下午9:08:37 
	 *
	 * @return String    返回类型 
	 *
	 * @throws 
	 * @see yu
	 */
	public String delete(){
			roleService.deleteRole(vo.getRoleEntity().getId());
		return  returnSuccess();
	}
	/**
	 * 
	 * @Title: selectlimit 
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
	public String selectlimit(){
		if(null == vo){
			vo=new AppRoleVo();
		}
		Map<String,Object> map=new HashMap<String, Object>(MagicNumber.NUM3);
		map.put("start", (start)*limit);
		map.put("limit", limit);
		
		vo.setRoleList(roleService.selectlimit(map));
		vo.setTotalCount(roleService.selectlimitCount(map));
		return returnSuccess();
	}
	
	
	/******************** getter and setter *****************************/

	/** 
	 * @param roleService 要设置的 roleService 
	 */
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	/** 
	 * @return vo 
	 */
	public AppRoleVo getVo() {
		return vo;
	}
	/** 
	 * @param vo 要设置的 vo 
	 */
	public void setVo(AppRoleVo vo) {
		this.vo = vo;
	}

}

