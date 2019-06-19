package com.deppon.wfs.workflow.service;

import com.deppon.wfs.workflow.dao.CheckProcessinstIdDao;


public class CheckProcessinstIdService {
	
	protected CheckProcessinstIdDao dao = new CheckProcessinstIdDao();
	
	public char check(int pro){
		char flag = '0';
		Object obj = dao.check(pro);
		if (obj != null && !"".equals(obj)) {
			flag = '1';
		}
		return flag;
	}

	
}
