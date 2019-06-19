package com.deppon.dpm.module.anps.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.deppon.dpm.module.anps.server.service.INoticeGroupService;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.dpm.module.anps.shared.vo.GroupMemberVo;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.Constants;

/**
 * 公文群组
 * @author 491275
 *
 */
@SuppressWarnings("serial")
public class NoticeGroupAction extends BaseAction {
	
	private static Logger logger  = LoggerFactory.getLogger(NoticeGroupAction.class);
	
	private INoticeGroupService noticeGroupService;

	/**
	 * 群组实体类
	 */
	private NoticeGroupEntity groupEntity = new NoticeGroupEntity();
	/**
	 * 群组名
	 */
	private String groupName;
	/**
	 * 群主
	 */
	private String groupOwner;
	/**
	 * 群组成员实体
	 */
	private List<GroupMemberVo> groupMemberVo;
	/**
	 * 岗位的部门
	 */
	private String positionDep;
    /**
     * 群组id
     */
	private String groupId;
    /**
     * 成员类型
     */
	private String memberType;
	/**
	 * 成员编号
	 */
	private String memberCode;
	

	/**
	 * 创建群组
	 * @return
	 */
	public void insertGroupInfo(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			ServletActionContext.getRequest().getMethod();
			//编码转换
			String str = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				groupMemberVo = JSONArray.parseArray(str, GroupMemberVo.class);
				System.out.println(groupMemberVo);
				noticeGroupService.insertGroupInfo(groupName, groupOwner, groupMemberVo);
			}
			writeToPage(response, str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加群组成员
	 */
	public void insertGroupMember(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		Result<Integer> result = new Result<Integer>();
		int res = 0;
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			ServletActionContext.getRequest().getMethod();
			//编码转换
			String str = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				groupMemberVo = JSONArray.parseArray(str, GroupMemberVo.class);
				res = noticeGroupService.insertGroupMember(groupId, groupName, groupOwner, groupMemberVo);
			}
			if(res>0){
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage("群组成员添加成功");
				result.setData(res);
			}
			writeToPage(result);
			/*writeToPage(response, str);*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("群组成员添加出错信息", e);
		}
	}
	
	/**
	 * 显示群组列表
	 */
	public void getAllGroup(){
		solveCrossDomain();
		// 定义数据库查询结果
		List<NoticeGroupEntity> groupList = new ArrayList<NoticeGroupEntity>();
		// 定义返回实体信息
		Result<List<NoticeGroupEntity>> result = new Result<List<NoticeGroupEntity>>();
		// 获取返回实体
		try {
			groupList = noticeGroupService.getAllGroup(userId);
			System.out.println(groupList);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage("群组列表查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log
			logger.error("群组列表查询出错信息", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("群组列表查询失败");
		}
		// 返回条数
		result.setCount(groupList.size());
		// 实体类
		result.setData(groupList);
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 显示群组成员
	 */
	public void getGroupMember(){
		solveCrossDomain();
		List<NoticeGroupEntity> groupMemberList = new ArrayList<NoticeGroupEntity>();
		// 定义返回实体信息
		Result<List<NoticeGroupEntity>> result = new Result<List<NoticeGroupEntity>>();
		try {
			groupMemberList = noticeGroupService.getGroupMember(groupId);
			System.out.println(groupMemberList);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage("群组成员查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log
			logger.error("群组成员查询出错信息", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("群组成员查询失败");
		}
		// 返回条数
		result.setCount(groupMemberList.size());
		// 实体类
		result.setData(groupMemberList);
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 重命名群组
	 */
	public void updateGroupName(){
		solveCrossDomain();
		// 定义返回实体信息
		Result<String> result = new Result<String>();
		int res = 0;
		try {
			res = noticeGroupService.updateGroupName(groupId, groupName, userId);
			System.out.println(res);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage("重命名群组成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log
			logger.error("重命名群组出错信息----------" + e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("重命名群组失败" + e.getCause());
		}
		// 实体类
		result.setData(res+"");		
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 删除群组
	 */
	public void deleteGroup(){
		solveCrossDomain();
		// 定义返回实体信息
		Result<String> result = new Result<String>();
		int res = 0;
		try {
			res = noticeGroupService.deleteGroup(groupId);
			System.out.println(res);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage("删除群组成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log
			logger.error("删除群组出错信息", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("删除群组失败");
		}
		// 实体类
		result.setData(res + "");
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 删除群组成员
	 */
	public void deleteGroupMember(){
		solveCrossDomain();
		// 定义返回实体信息
		Result<String> result = new Result<String>();
		int res = 0;
		try {
			res = noticeGroupService.deleteGroupMember(groupId, memberType, memberCode, positionDep);
			System.out.println(res);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage("删除群组成员成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log
			logger.error("删除群组成员出错信息", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("删除群组成员失败");
		}
		// 实体类
		result.setData(res + "");
		// 返回前端
		writeToPage(result);
	}
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		NoticeGroupAction.logger = logger;
	}

	public INoticeGroupService getNoticeGroupService() {
		return noticeGroupService;
	}

	public void setNoticeGroupService(INoticeGroupService noticeGroupService) {
		this.noticeGroupService = noticeGroupService;
	}

	public NoticeGroupEntity getGroupEntity() {
		return groupEntity;
	}

	public void setGroupEntity(NoticeGroupEntity groupEntity) {
		this.groupEntity = groupEntity;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupOwner() {
		return groupOwner;
	}

	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}
	
	public String getPositionDep() {
		return positionDep;
	}

	public void setPositionDep(String positionDep) {
		this.positionDep = positionDep;
	}

	public List<GroupMemberVo> getGroupMemberVo() {
		return groupMemberVo;
	}

	public void setGroupMemberVo(List<GroupMemberVo> groupMemberVo) {
		this.groupMemberVo = groupMemberVo;
	}
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

}
