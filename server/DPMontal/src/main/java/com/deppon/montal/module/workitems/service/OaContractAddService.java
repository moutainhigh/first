package com.deppon.montal.module.workitems.service;

import com.deppon.montal.model.OaContractAdd;
import com.deppon.montal.module.workitems.dao.IOaContractAddDao;
import com.deppon.montal.module.workitems.dao.OaContractAddDao;
import com.deppon.montal.util.CovertDate;

public class OaContractAddService implements IOaContractAddService{
	IOaContractAddDao oacontractadddao = new OaContractAddDao(); 
	@Override
	public OaContractAdd getContractAdd(String processinstid) {
		// TODO Auto-generated method stub
		OaContractAdd oacontractadd = oacontractadddao.getOaContraAddInfo(processinstid);
		oacontractadd.setContractstartdate(CovertDate.covertMSToDate(oacontractadd.getContractstartdate()));
		oacontractadd.setContractenddate(CovertDate.covertMSToDate(oacontractadd.getContractenddate()));
		return oacontractadd;
	}
}
