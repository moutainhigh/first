/**
 * 
 */
package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OASystempowerApply;
import com.deppon.montal.module.workitems.dao.IOASystempowerApplyDao;
import com.deppon.montal.module.workitems.dao.OASystempowerApplyDao;

/**
 * 系统权限申请
 * @author yin
 *
 */
public class OASystempowerApplyService implements IOASystempowerApplyService{

	public static IOASystempowerApplyDao systemPowerApplyDao = new OASystempowerApplyDao();
	
	@Override
	public OASystempowerApply getOASystempowerApply(String processinstid) {
		// TODO Auto-generated method stub
		return systemPowerApplyDao.getOASystempowerApply(processinstid);
	}

}
