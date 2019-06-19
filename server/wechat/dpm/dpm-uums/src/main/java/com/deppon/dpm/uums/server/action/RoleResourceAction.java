/**
 * Project Name:dpm-uums
 * File Name:AuthorityFunctionAction.java
 * Package Name:com.deppon.dpm.uums.server.action
 * Date:2014-8-12下午11:27:24
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.deppon.dpm.uums.server.action;

import com.deppon.dpm.uums.server.service.IRoleResourceService;
import com.deppon.dpm.uums.server.vo.AppRoleResourceVo;
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
public class RoleResourceAction extends AbstractAction {

	private IRoleResourceService roleResourceService;

	private AppRoleResourceVo vo;

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
	 * @return String 返回类型
	 *
	 * @throws
	 * @see yu
	 */

	@JSON
	public String insertOrUpdateRR() {

		roleResourceService.insertOrUpdateOne(vo);

		return returnSuccess();
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
	 * @return String 返回类型
	 *
	 * @throws
	 * @see yu
	 */
	@JSON
	public String selectlimitRR() {
		try {
			if (null == vo) {
				vo = new AppRoleResourceVo();
			}

			vo.setResourceList(roleResourceService.selectlimit(vo
					.getResourceEntity().getId()));
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
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
	 * @return String 返回类型
	 *
	 * @throws
	 * @see yu
	 */
	@JSON
	public String selectRoleLimitRR() {
		try {
			if (null == vo) {
				vo = new AppRoleResourceVo();
			}
			vo.setResourceedSelectedList(roleResourceService.selectRolelimit(vo
					.getResourceEntity().getId()));
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
	}

	/******************** getter and setter *****************************/

	/**
	 * @param roleService
	 *            要设置的 roleService
	 */
	public void setRoleResourceService(IRoleResourceService roleService) {
		this.roleResourceService = roleService;
	}

	/**
	 * @return vo
	 */
	public AppRoleResourceVo getVo() {
		return vo;
	}

	/**
	 * @param vo
	 *            要设置的 vo
	 */
	public void setVo(AppRoleResourceVo vo) {
		this.vo = vo;
	}

}
