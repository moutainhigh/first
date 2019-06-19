package com.deppon.dpm.doc.server.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IAddMessageDao;
import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 提示消息调用接口
 * @author gwl
 *
 */
public class AddMessageDao extends iBatis3DaoImpl  implements IAddMessageDao{

	private static final String NAME_SPACE="com.deppon.dpm.doc.server.domain.EmployeeEntity.";
	
	public AddMessageDao() {
		super();
	}
	
	/*
	 * 
	 * 新增消息记录
	 */
	@Override
	public int insert(List<String> userIdList , String dept) {
		if(userIdList.size()==0){
			return 0;
		}
//		Map<String,String> map = new HashMap<String,String>();
		List<PushMessageVO>  addVOList = new ArrayList<PushMessageVO>();
		for(String temp : userIdList){
			PushMessageVO pushmessagevo = new PushMessageVO();
			pushmessagevo.setDept(Integer.valueOf("123"));
			pushmessagevo.setUserid(temp);
			pushmessagevo.setState("0");
			pushmessagevo.setMessage("您好,您当月部门预算余额已用完,无法进行打车。");
			pushmessagevo.setMsgtitle("部门预算余额提醒");
			addVOList.add(pushmessagevo);
		}
		return this.getSqlSession().insert(NAME_SPACE+"insertMessage",addVOList);
	}
	/*
	 * 更新消息状态
	 */
	@Override
	public int updateMessage(String id) {
		return getSqlSession().update(NAME_SPACE+"updateById",id);
	}
	/*
	 * 根据部门查询所有的用户ID
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> queryAlluserId(String dept) {
		String newdept = "%."+dept.toString()+".%"; 
			return getSqlSession().selectList(NAME_SPACE+"queryAlluserId",newdept);
	}
	/*
	 * 根据部门查询所有的用户ID
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> queryGGuserId(String dept) {
		String newdept = "%."+dept.toString()+".%"; 
		return getSqlSession().selectList(NAME_SPACE+"queryGGuserId",newdept);
	}
	/*
	 * 根据部门查询所有的用户ID
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> queryOrguserId(String dept) {
		//String newdept = "%."+dept.toString()+".%"; 
		return getSqlSession().selectList(NAME_SPACE+"queryOrguserId",dept);
	}
	/*
	 * 根据用户ID查询所有的消息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PushMessageVO> queryMessage(String userId) {
		
		return getSqlSession().selectList(NAME_SPACE+"queryMsgByUSERId",userId);
	}
	
	/*
	 * 根据用户ID查询所有的消息,分页
	 */
	@SuppressWarnings("unchecked")
	public List<PushMessageVO> queryMessage4Pagination(Map<String,Object> params){
		return getSqlSession().selectList(NAME_SPACE+"queryMsgByUSERId4Pagination",params);
	}
	
	/*
	 * 根据用户ID查询指定状态的消息总条数
	 */
	public Integer queryMsgByUSERId4Total(Map<String,Object> params){
		return (Integer)getSqlSession().selectOne(NAME_SPACE+"queryMsgByUSERId4Total",params);
	}

	/*
	 * 新增预算余额不足提醒
	 */
	@Override
	public int insertRemind(List<PushMessageVO> addVOList) {
//		List<PushMessageVO>  addVOList = new ArrayList<PushMessageVO>();
//		for(String temp : userIdList){
//			PushMessageVO pushmessagevo = new PushMessageVO();
//			pushmessagevo.setDept(Integer.valueOf(dept));
//			pushmessagevo.setUserid(temp);
//			pushmessagevo.setState("0");
//			pushmessagevo.setMessage("您好,您当月部门预算余额已用完,无法进行打车。");
//			pushmessagevo.setMsgtitle("部门预算余额提醒");
//			addVOList.add(pushmessagevo);
//		}
		return this.getSqlSession().insert(NAME_SPACE+"insertMessage",addVOList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryOrgId(String deptcode) {
		return getSqlSession().selectList(NAME_SPACE+"queryOrgIdByCode",deptcode);
	}

	@Override
	public List<PushMessageVO> queryMessageByContent(String message) {
		return getSqlSession().selectList(NAME_SPACE+"queryMessageByContent",message);
	}
	
	/*
	 * 插入预算不足推送通知消息
	 */
	public int insertMessagePush(QueryResponseBudgetEntity qrEntity){
		
		return this.getSqlSession().insert(NAME_SPACE+"insertMessagePush",qrEntity);
	}
	
	/**
	 * 查询待推送的预算通知
	 */
	public List<QueryResponseBudgetEntity> getMessagePush(Map<String,String> map){
		
		return getSqlSession().selectList(NAME_SPACE+"getMessagePush", map);
	}
	
	/**
	 * 预算通知改为已推送状态
	 * @param map
	 * @return
	 */
	public int updatePushStatus(Map<String,String> map){
		
		return getSqlSession().update(NAME_SPACE+"updatePushStatus", map);
	}
}
