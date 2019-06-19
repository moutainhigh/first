package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.entity.DidiTicketEntity;


public interface IDidiTicketDao {

	/**
	 * 新增
	 * @param didiOeder
	 * @return
	 */
	Integer insert(DidiTicketEntity didiTicket) ;

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
	DidiTicketEntity find(DidiTicketEntity didiTicket) ;
	
	/**
	 * 更新
	 * @param didiOeder
	 * @return
	 */
	Integer update(DidiTicketEntity didiTicket) ;

	/**
	 * 删除
	 * @param didiOeder
	 * @return
	 */
	int delete(DidiTicketEntity didiTicket);
	
	/**
	 * pk删除
	 * @param ids
	 * @return
	 */
	int deleteBatch(String ids);
	/**
	 * 根据标识筛选不存在的订单
	 * @param userId
	 * @return
	 */
	public List<DidiTicketEntity> queryByFlag(String userId);
}
