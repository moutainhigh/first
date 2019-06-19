package com.deppon.dpm.doc.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.deppon.dpm.doc.server.dao.IPageFunctionDao;
import com.deppon.dpm.doc.server.service.IPageFunctionService;
import com.deppon.dpm.doc.server.vo.DidiOrderVO;

/**
 * 分页功能调用接口
 * 
 * @author gwl
 *
 */

public class PageFunctionService implements IPageFunctionService{

	private IPageFunctionDao pageFunctionDao;
	
	public PageFunctionService() {
		super();
	}
	/**
	 * 获取全部数据
	 */
	@Override
	public List<DidiOrderVO> totalRecord(String userId, int pageSize,boolean islead,String deptname) {
		
		
		// 如果是部门负责人，查询部门下所有人的当月打车记录
		if (islead) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ufdate = sdf.format(System.currentTimeMillis());
			String currdate = ufdate.substring(0,7);
			return pageFunctionDao.deptRecord(deptname, pageSize, currdate);
		}else {// 如果是普通员工，查询自己的打车记录
			return pageFunctionDao.totalRecord(userId, pageSize);
		}
	}
	
	
	
	/**
	 * 返回某一页数据集合
	 */
	@Override
	public List<DidiOrderVO> pageMsg(String userId,int requestBeginNum) {
		return pageFunctionDao.pageMsg(userId,requestBeginNum);
	}
	/**
	 * getPageFunctionDao()
	 */
	public IPageFunctionDao getPageFunctionDao() {
		return pageFunctionDao;
	}
	/**
	 * setPageFunctionDao()
	 */
	public void setPageFunctionDao(IPageFunctionDao pageFunctionDao) {
		this.pageFunctionDao = pageFunctionDao;
	}
	
	
	/**
	 * @Desciption:TODO(个人当月打车消费记录)
	 * @author lvdefu
	 * @date:2018年4月8日15:38:30
	 */
	@Override
	public List<DidiOrderVO> queryDetailByDate(String userId, String startDate,String endDate, String remark) {
		return pageFunctionDao.queryDetailByDate(userId,startDate,endDate,remark);
	}
	
	/**
	 * @Desciption:TODO(根据年月领导查询部门打车明细)
	 * @author lvdefu
	 * @date:2018年4月8日17:44:27
	 */
	@Override
	public List<DidiOrderVO> departmentTaxi(List<String> deptNameList,String startDate, String endDate, String remark, String employee) {
		return pageFunctionDao.departmentTaxi(deptNameList,startDate,endDate,remark,employee);
	}
	


}
