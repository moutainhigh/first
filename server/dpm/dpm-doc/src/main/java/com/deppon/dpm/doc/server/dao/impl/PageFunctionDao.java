package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IPageFunctionDao;
import com.deppon.dpm.doc.server.vo.DidiOrderVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 分页功能调用接口
 * 
 * @author gwl
 *
 */

public class PageFunctionDao extends iBatis3DaoImpl  implements IPageFunctionDao{

	private static final String NAME_SPACE="com.deppon.dpm.doc.server.domain.EmployeeEntity.";
	/**
	 * 获取全部数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderVO> totalRecord(String userId, int pageSize) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("pageSize", String.valueOf(pageSize));
    	return getSqlSession().selectList(NAME_SPACE+"totalRecordByUserId",map);
    	
	}
	
	/**
	 * 查询某部门当月的打车信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderVO> deptRecord(String deptname, int pageSize,
			String taxidate) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("deptname", deptname);
    	map.put("pageSize", String.valueOf(pageSize));
    	map.put("taxidate", String.valueOf(taxidate));
    	return getSqlSession().selectList(NAME_SPACE+"totalRecordBydept",map);
	}
	
	/**
	 * 返回某一页数据集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderVO> pageMsg(String userId,int requestBeginNum) {
		Map<String,Object> map = new HashMap<String,Object>();
//		List<Integer> id_List = new ArrayList<Integer>();
//		for(DidiOrderVO temp : orderList){
//			id_List.add(temp.getId());
//		}
		map.put("userId", userId);
    	map.put("requestBeginNum", requestBeginNum);
		//List<DidiOrderVO> didiOrderList = 
		return getSqlSession().selectList(NAME_SPACE+"pageMsgByUserId",map);
    	
	}
	
	/**
	 * @Desciption:TODO(个人当月打车消费记录)
	 * @author lvdefu
	 * @date:2018年4月8日16:06:59
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderVO> queryDetailByDate(String userId, String startDate,String endDate, String remark) {
		//传入参数
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("remark", remark);
		List<DidiOrderVO> list = getSqlSession().selectList(NAME_SPACE+"queryDetailByDate", map);
		if(list==null || list.size()==0){
			return null;
		}else{
			return list;
		}
		
	}
	/**
	 * @Desciption:TODO(根据年月领导查询部门打车明细)
	 * @author lvdefu
	 * @date:2018年4月8日17:44:27
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiOrderVO> departmentTaxi(List<String> deptNameList,String startDate, String endDate,String remark,String employee) {
		//传入参数
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("deptNameList", deptNameList);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("remark", remark);
		map.put("employee", employee);
		List<DidiOrderVO> list=getSqlSession().selectList(NAME_SPACE+"departmentTaxi", map);
		if(list==null || list.size()==0){
			return null;
		}else{
			return list;
		}
	}
	

}
