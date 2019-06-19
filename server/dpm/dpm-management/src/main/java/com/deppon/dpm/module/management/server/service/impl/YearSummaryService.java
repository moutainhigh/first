package com.deppon.dpm.module.management.server.service.impl;

import com.deppon.dpm.module.management.server.dao.IYearSummaryDao;
import com.deppon.dpm.module.management.server.service.IYearSummaryService;
import com.deppon.dpm.module.management.shared.domain.YearSummaryEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 2017年度总结
 * @author 276344
 *
 */
public class YearSummaryService implements IYearSummaryService {
	
	private IYearSummaryDao summaryDao;
	@Override
	public YearSummaryEntity getSummaryByEmpcode(String userId) {
		// TODO Auto-generated method stub
		return summaryDao.getYearSummaryByEmpCode(userId);
	}
	
	@Override
	public YearSummaryEntity getYearSummary(String empCode) {
		// TODO Auto-generated method stub
		return summaryDao.getYearSummary(empCode);
	}
	
	@Override
	public EmployeeVO getLeaveEmpcode(String userId) {
		// TODO Auto-generated method stub
		return summaryDao.getLeaveByEmpCode(userId);
	}
	public void setSummaryDao(IYearSummaryDao summaryDao) {
		this.summaryDao = summaryDao;
	}
	
}
