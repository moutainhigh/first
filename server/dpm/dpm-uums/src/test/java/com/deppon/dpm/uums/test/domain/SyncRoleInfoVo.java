package com.deppon.dpm.uums.test.domain;

import java.util.List;

import com.deppon.uums.inteface.domain.usermanagement.RoleInfo;
import com.deppon.uums.inteface.domain.usermanagement.SendRoleInfoRequest;

public class SyncRoleInfoVo extends SendRoleInfoRequest{
	
	public SyncRoleInfoVo(List<RoleInfo> roleInfo){
		this.roleInfo = roleInfo;
	}
}
