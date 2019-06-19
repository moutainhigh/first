package com.deppon.dpm.doc.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;

/**
 * 提示消息调用接口
 * @author gwl
 *
 */
public interface IAddMessageService {
	
	/*
	 * 新增消息记录
	 */
	public int insert(List<String> userIdList , String dept);
	/*
	 * 更新消息状态
	 */
	public int updateMessage(String id);
	/*
	 * 根据部门查询所有的用户ID
	 */
	public List<EmployeeEntity> queryAlluserId(String dept);
	/*
	 * 查询该部门下的所有高管
	 */
	public List<EmployeeEntity> queryGGuserId(String dept);
	/*
	 * 查询直属于该部门的所有员工
	 */
	public List<EmployeeEntity> queryOrguserId(String dept);
	/*
	 * 根据用户ID查询所有的消息
	 */
	public List<PushMessageVO> queryMessage(String userId);
	/*
	 * 根据用户ID查询所有的消息，分页
	 */
	public List<PushMessageVO> queryMessage4Pagination(Map<String,Object> params);
	/*
	 * 根据用户ID查询指定状态的消息总条数
	 */
	public Integer queryMsgByUSERId4Total(Map<String,Object> params);
	/*
	 * 新增预算余额不足提醒
	 */
	public int insertRemind(List<PushMessageVO> addVOList);
	
	
	public List<String> queryOrgId(String deptcode);
	
	
	public List<PushMessageVO> queryMsgByContent(String message);
	
	/*
	 * 插入预算不足推送通知消息
	 */
	public int insertMessagePush(QueryResponseBudgetEntity qrEntity);
	/*
	 * 查询待推送的预算通知
	 */
	public List<QueryResponseBudgetEntity> getMessagePush(String month,String day,String hour,String status);
	/*
	 * 预算通知改为已推送状态
	 */
	public int updatePushStatus(String month,String day,String hour,String deptCode);
	
}
