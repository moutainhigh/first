package com.deppon.dpm.doc.server.dao;

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
public interface IAddMessageDao {
	
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
	 * 根据部门查询所有的用户ID
	 */
	public List<EmployeeEntity> queryGGuserId(String dept);
	/*
	 * 根据部门查询所有的用户ID
	 */
	public List<EmployeeEntity> queryOrguserId(String dept);
	/*
	 * 根据用户ID查询所有的消息
	 */
	public List<PushMessageVO> queryMessage(String userId);
	/*
	 * 根据用户ID查询所有的消息,分页
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
	
	/*
	 * 根据消息内容查询消息是否已经存在
	 */
	public List<PushMessageVO> queryMessageByContent(String message);
	
	/*
	 * 插入预算不足推送通知消息
	 */
	public int insertMessagePush(QueryResponseBudgetEntity qrEntity);
	/*
	 * 查询待推送的预算通知
	 */
	public List<QueryResponseBudgetEntity> getMessagePush(Map<String,String> map);
	/*
	 * 预算通知改为已推送状态
	 */
	public int updatePushStatus(Map<String,String> map);
}
