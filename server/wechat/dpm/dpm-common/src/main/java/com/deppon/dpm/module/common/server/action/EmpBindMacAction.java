package com.deppon.dpm.module.common.server.action;

import com.deppon.dpm.module.common.server.service.IEmpBindMacService;
import com.deppon.dpm.module.common.shared.domain.EmpBindMacEntity;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.opensymphony.xwork2.ModelDriven;

public class EmpBindMacAction extends BaseAction implements ModelDriven<EmpBindMacEntity>{

	private EmpBindMacEntity entity = new EmpBindMacEntity();
	
	private IEmpBindMacService empBindMacService;
 	
	// 复写方法
	@Override
	public EmpBindMacEntity getModel() {
		return entity;
	}
	
	// 保存
	public void save(){
		Result<Object> result = new Result<Object>();
		try {
			empBindMacService.save(entity);
			result.setErrorCode(0);
			// 成功
			writeToPage(result);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.setErrorCode(1);
		// 失败
		writeToPage(result);
	}

	// setter
	public void setEmpBindMacService(IEmpBindMacService empBindMacService) {
		this.empBindMacService = empBindMacService;
	}
	
}
