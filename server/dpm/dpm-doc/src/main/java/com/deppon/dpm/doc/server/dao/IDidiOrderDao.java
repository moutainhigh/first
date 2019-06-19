package com.deppon.dpm.doc.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;


/**
 * 滴滴订单信息表(DIDI_OEDER) 
 * @author 
 * 2017-11-20
 */
public interface IDidiOrderDao{

	/**
	 * 新增
	 * @param didiOeder
	 * @return
	 */
	Integer insert(DidiOrderEntity didiOrder) ;

//	/**
//	 * ��������ҳ��ѯ
//	 * @param didiOeder
//	 * @return
//	 */
//	Page queryPage(DidiOrderEntity didiOeder) ;
	
	/**
	 * 查询
	 * @param didiOeder
	 * @return DidiOeder
	 */
	DidiOrderEntity find(DidiOrderEntity didiOrder) ;
	
	/**
	 * 更新
	 * @param didiOeder
	 * @return
	 */
	Integer update(DidiOrderEntity didiOrder) ;

	/**
	 * 删除
	 * @param didiOeder
	 * @return
	 */
	int delete(DidiOrderEntity didiOrder);
	
	/**
	 * pk删除
	 * @param ids
	 * @return
	 */
	int deleteBatch(String ids);
	
	/**
	 * 检查员工是否有未完成的订单
	 * @param userId
	 * @return
	 */
	public boolean statusCheck(String userId);
	/**
	 * 根据会议名称和日期返回订单数据
	 */
	public List<DidiOrderEntity> Querymeeting(String userId,String meetingname,String date);
	
	/**
	 * 更新订单中电话字段
	 */
	public Integer updatePhone(String userId , String phone) ;
	
	/**
	 * 根据主键查询当月订单用于对账
	 */
	public List<DidiOrderEntity> accountOrder(String str);
	
	/**
	 * 根据日期查询当月订单用于对账
	 */
	public List<DidiOrderEntity> dateOrder(String date);
	
	public List<DidiOrderEntity> dateOrderByOrderIds(List<Map<String,String>> list);
	
	/**
	 * 新增对账数据
	 */
	public Integer insertdef(DidiOrderEntity didiOrder);
	
	/**
	 * 新增对账数据
	 */
	public Integer finddef(String order);
	
	/*
	 * 查询对账数据前台展示，分页功能
	 */
	public List<DidiOrderEntity> query(String getDate , int pageNum);
	//根据工号查询上一次打车记录
	public DidiOrderEntity selectLastOrder(String userId);
	
}
