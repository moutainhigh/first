package com.deppon.dpm.doc.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IAddMessageDao;
import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;

/**
 * 提示消息调用接口
 * @author gwl
 *
 */
public class AddMessageService implements IAddMessageService {

	private IAddMessageDao addMessageDao;
	/**
	 * 提示消息接口构造函数
	 * @author gwl
	 *
	 */
	public AddMessageService() {
		super();
	}
	/*
	 * 
	 * 新增消息记录
	 */
	@Override
	public int insert(List<String> userIdList , String dept) {
		return addMessageDao.insert(userIdList,dept);
	}
	
	public IAddMessageDao getAddMessageDao() {
		return addMessageDao;
	}

	public void setAddMessageDao(IAddMessageDao addMessageDao) {
		this.addMessageDao = addMessageDao;
	}
	/*
	 * 更新消息状态
	 */
	@Override
	public int updateMessage(String id) {
		return addMessageDao.updateMessage(id);
	}
	/*
	 * 根据部门查询所有的用户ID
	 */
	@Override
	public List<EmployeeEntity> queryAlluserId(String dept) {
		return addMessageDao.queryAlluserId(dept);
	}
	/*
	 * 查询该部门下的所有高管
	 */
	@Override
	public List<EmployeeEntity> queryGGuserId(String dept) {
		return addMessageDao.queryGGuserId(dept);
	}
	/*
	 * 查询直属于该部门的所有员工
	 */
	@Override
	public List<EmployeeEntity> queryOrguserId(String dept) {
		return addMessageDao.queryOrguserId(dept);
	}
	/*
	 * 根据用户ID查询所有的消息
	 */
	@Override
	public List<PushMessageVO> queryMessage(String userId) {
		return addMessageDao.queryMessage(userId);
	}
	
	/*
	 * 根据用户ID查询所有的消息
	 */
	@Override
	public List<PushMessageVO> queryMessage4Pagination(Map<String,Object> params){
		return addMessageDao.queryMessage4Pagination(params);
	}
	
	/*
	 * 根据用户ID查询指定状态的消息总条数
	 */
	public Integer queryMsgByUSERId4Total(Map<String,Object> params){
		return (Integer)addMessageDao.queryMsgByUSERId4Total(params);
	}
	
	/*
	 * 
	 * 新增预算余额不足提醒
	 */
	@Override
	public int insertRemind(List<PushMessageVO> addVOList) {
		return addMessageDao.insertRemind(addVOList);
	}
	@Override
	public List<String> queryOrgId(String deptcode) {
		return addMessageDao.queryOrgId(deptcode);
	}
	@Override
	public List<PushMessageVO> queryMsgByContent(String message) {
		return addMessageDao.queryMessageByContent(message);
	}
	
	/*
	 * 插入预算不足推送通知消息
	 */
	@Override
	public int insertMessagePush(QueryResponseBudgetEntity qrEntity) {
		
		return addMessageDao.insertMessagePush(qrEntity);
	}
	
	/*
	 * 查询待推送的预算通知
	 */
	@Override
	public List<QueryResponseBudgetEntity> getMessagePush(String month,String day,String hour,String status){
		Map<String,String> map = new HashMap<String,String>();
		map.put("month", month);
		map.put("day", day);
		map.put("hour", hour);
		map.put("status", status);
		return addMessageDao.getMessagePush(map);
	}
	
	/*
	 * 预算通知改为已推送状态
	 */
	@Override
	public int updatePushStatus(String month,String day,String hour,String deptCode){
		Map<String,String> map = new HashMap<String,String>();
		map.put("month", month);
		map.put("day", day);
		map.put("hour", hour);
		map.put("deptCode", deptCode);
		return addMessageDao.updatePushStatus(map);
	}
}
