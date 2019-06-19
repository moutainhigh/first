package com.deppon.dpm.module.wechat.server.service;

import net.sf.json.JSONObject;


/**
 * 企业微信通讯录service
 * @author 276344
 *
 */
public interface IWechatTongxunluService {
	/**
	 * 获取token
	 * @return
	 */
	public JSONObject getWechatAccess_token(); 
	/**
	 * 全量更新部门 异步
	 * @return
	 */
	public JSONObject updateDepponDepartmentAll();
	/**
	 * 增量更新员工 异步
	 * @return
	 */
	public JSONObject updateDepponUserAll();
	/**
	 * 首次上线时执行一次全量更新员工  异步
	 * @return
	 */
	public JSONObject updateDepponUserAllForOnce();
	/**
	 * 在这个里面测试方法
	 */
	public void  methodTest();
	/**
	 * 删除成员信息
	 * @return
	 */
	public void deleteUserInfo();
	/**
	 * 获取部门列表
	 * @param token
	 * @param id
	 * @return
	 */
	public JSONObject getDepartmentInfoFromWechat(String token, String id);
	/**
	 * 从企业微信拉取成员信息
	 * @param token
	 * @param department_id
	 * @param fetch_child
	 * @return
	 */
	public JSONObject getUserInfoFromWechat(String token, String department_id, String fetch_child);
	/**
	 * 查询异步执行任务结果
	 * @param jobid
	 * @return
	 */
	public JSONObject getTaskResult(String jobid);
	/**
	 * 企业微信推送消息 type:0-部门  1-员工
	 */
	public void sendMessage(int type);
	/**
	 * 更新单个员工信息
	 * @param empcode
	 * @return
	 */
	public JSONObject updateUserInfoByEmpcode(String empcode);
	/**
	 * 创建标签
	 * @param tagname 标签名称，长度限制为32个字（汉字或英文字母），标签名不可与其他标签重名。
	 * @param tagid
	 * @return 标签id，非负整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。
	 */
	public JSONObject createTag(String tagname, String tagid);
	/**
	 * 增加成员标签
	 * @return
	 */
	public JSONObject addTagUsers(String tagid);
	/**
	 * 创建员工  先删除再创建
	 * @param empCode
	 * @return
	 */
	public JSONObject createUserByEmpcode(String empCode);
	
}
