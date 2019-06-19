package com.deppon.dpm.module.anps.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import com.deppon.dpm.module.anps.server.dao.INoticeGroupDao;
import com.deppon.dpm.module.anps.server.dao.IReceiveObjectDao;
import com.deppon.dpm.module.anps.server.service.INoticeGroupService;
import com.deppon.dpm.module.anps.shared.define.AnpsConstants;
import com.deppon.dpm.module.anps.shared.domain.NoticeGroupEntity;
import com.deppon.dpm.module.anps.shared.vo.GroupMemberVo;

public class NoticeGroupService implements INoticeGroupService{
	
	/**
	 * 日志
	 */
    private static final Logger logger = Logger.getLogger(NoticeGroupService.class);
    /**
	 * set injection
	 */
    private INoticeGroupDao noticeGroupDao;
    
    private IReceiveObjectDao receiveDao;
    


	/**
	 * 群组实体类
	 */
	private NoticeGroupEntity groupEntity = new NoticeGroupEntity();
    
    /**
     * 创建群组
     */
    public int insertGroupInfo(String groupName, String groupOwner, List<GroupMemberVo> groupMemberVo){
    	int res =0;
    	List<NoticeGroupEntity> groupList = new ArrayList<NoticeGroupEntity>();
    	//生成UUID
		String groupId = UUID.randomUUID().toString().replaceAll("-", "");
    	for(GroupMemberVo gmVo : groupMemberVo){
    		/*每个群组成员生成一个群组实体*/
    		NoticeGroupEntity groupEntity = new NoticeGroupEntity();
    		//拼装实体
    		//唯一id
    		groupEntity.setGroupId(groupId);
    		//群组名
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("groupName", groupName);
    		map.put("groupOwner", groupOwner);
    		int count = noticeGroupDao.getGroupNameCount(map);
    		if(count == 0){
    			groupEntity.setGroupName(groupName);
    		}else{
    			int i=0;
    			int n=0;
    			String gName = groupName;
    			do{
    				i=i+1;
    				gName = groupName + "(" + String.valueOf(i);
    				System.out.println(gName);
    				Map<String,String> gmap = new HashMap<String,String>();
    	    		gmap.put("groupName", gName);
    	    		gmap.put("groupOwner", groupOwner);
    				n = noticeGroupDao.getGroupNameCount(gmap);
    			}while(n != 0);
    			groupEntity.setGroupName(gName);
    		}  	
    		//群主
        	groupEntity.setGroupOwner(groupOwner);
        	//成员编号
        	groupEntity.setMemberCode(gmVo.getMemberCode());
        	//成员类型
        	groupEntity.setMemberType(gmVo.getMemberType());
        	//成员类型
        	groupEntity.setMemberName(gmVo.getMemberName());
        	//成员人数
        	if(gmVo.getMemberType().equals("0")){   
        		groupEntity.setNumber(1);
        	}
        	else if(gmVo.getMemberType().equals("1")){
        		groupEntity.setNumber(receiveDao.getDepartmentMemberNumByOrgid(gmVo.getMemberCode()));
        	}
        	else if(gmVo.getMemberType().equals("2")){
                if(gmVo.getPositionDep()!=null && gmVo.getCodeType()!=null){
                	//PositionDep和CodeType都不为空，CodeType分为empId和orgId
                	groupEntity.setPositionDep(gmVo.getPositionDep());
            		groupEntity.setCodeType(gmVo.getCodeType());
            		if(gmVo.getCodeType().equals("empid")){
            			groupEntity.setNumber(1);
            		}else if(gmVo.getCodeType().equals("orgid")){
            			groupEntity.setNumber(receiveDao.getJobNumber(gmVo.getMemberCode(),gmVo.getPositionDep()));
            		}
                }else{
                	//若直接选的一个岗位，则PositionDep和CodeType都为空
                	groupEntity.setNumber(receiveDao.getJobNumber(gmVo.getMemberCode(), gmVo.getMemberName()));  	
                }
        	}
        	/*if(gmVo.getMemberType().equals("2") && gmVo.getPositionDep()!=null && gmVo.getCodeType()!=null){
        		groupEntity.setPositionDep(gmVo.getPositionDep());
        		groupEntity.setCodeType(gmVo.getCodeType());
        	}*/
        	//实体插入list
        	groupList.add(groupEntity);
    	}
    	res = noticeGroupDao.insertGroupInfo(groupList);
    	return res;	
    }
    
    /**
     * 插入群组成员
     */
    public int insertGroupMember(String groupId,String groupName, String groupOwner, List<GroupMemberVo> groupMemberVo){
    	int res = 0;
    	List<NoticeGroupEntity> groupList = new ArrayList<NoticeGroupEntity>();
    	for(GroupMemberVo gmVo : groupMemberVo){
    		//判断该群组成员是否存在
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("groupId", groupId);
    		map.put("memberCode", gmVo.getMemberCode());
    		map.put("memberType", gmVo.getMemberType());
    		map.put("memberName", gmVo.getMemberName());
    		if(gmVo.getMemberType().equals("2") && gmVo.getPositionDep() != null ){
    			map.put("positionDep", gmVo.getPositionDep());
        		map.put("codeType", gmVo.getCodeType());
    		}
    		int mcount = noticeGroupDao.getMemberCount(map);
    		System.out.println(mcount + "群组成员重复数");
    		if(mcount == 0){
    			/*每个群组成员生成一个群组实体*/
        		NoticeGroupEntity groupEntity = new NoticeGroupEntity();
        		//拼装实体
        		//唯一id
        		groupEntity.setGroupId(groupId);
        		//群组名
        		groupEntity.setGroupName(groupName);
        		//群主
            	groupEntity.setGroupOwner(groupOwner);
            	//成员编号
            	groupEntity.setMemberCode(gmVo.getMemberCode());
            	//成员类型
            	groupEntity.setMemberType(gmVo.getMemberType());
            	//成员类型
            	groupEntity.setMemberName(gmVo.getMemberName());
            	//成员人数
            	if(gmVo.getMemberType().equals("0")){   
            		groupEntity.setNumber(1);
            	}
            	else if(gmVo.getMemberType().equals("1")){
            		groupEntity.setNumber(receiveDao.getDepartmentMemberNumByOrgid(gmVo.getMemberCode()));
            	}
            	else if(gmVo.getMemberType().equals("2")){
                    if(gmVo.getPositionDep()!=null && gmVo.getCodeType()!=null){
                    	//PositionDep和CodeType都不为空，CodeType分为empId和orgId
                    	groupEntity.setPositionDep(gmVo.getPositionDep());
                		groupEntity.setCodeType(gmVo.getCodeType());
                		if(gmVo.getCodeType().equals("empid")){
                			groupEntity.setNumber(1);
                		}else if(gmVo.getCodeType().equals("orgid")){
                			groupEntity.setNumber(receiveDao.getJobNumber(gmVo.getMemberCode(),gmVo.getPositionDep()));
                		}
                    }else{
                    	//若直接选的一个岗位，则PositionDep和CodeType都为空
                    	groupEntity.setNumber(receiveDao.getJobNumber(gmVo.getMemberCode(), gmVo.getMemberName()));
                    }
            	
            	}
            	//实体插入list
            	groupList.add(groupEntity);
    		}
    	}
    	if(groupList.size() != 0){
    		res = noticeGroupDao.insertGroupInfo(groupList);
    	}else{
    		res = AnpsConstants.groupTag;
    	}
    	return res;	
    }
    
    /**
     * 获取群组列表
     */
    public List<NoticeGroupEntity> getAllGroup(String userId){
    	
    	List<NoticeGroupEntity> groupList = new ArrayList<NoticeGroupEntity>();
    	groupList = noticeGroupDao.getAllGroup(userId);
    	//遍历群组列表
    	for(NoticeGroupEntity ng : groupList){
    		int totalnum = 0;
    		List<NoticeGroupEntity> groupMemberList = new ArrayList<NoticeGroupEntity>();
    		groupMemberList = getGroupMember(ng.getGroupId());
    		//遍历群组成员列表,计算总人数
    		for(NoticeGroupEntity ngm : groupMemberList){
    			totalnum += ngm.getNumber();
    		}
    		ng.setTotalNumber(totalnum);
    	}
    	//返回群组列表信息
    	return groupList;
    }
    
    /**
     * 获取群组成员
     */
    public List<NoticeGroupEntity> getGroupMember(String groupId){
    	List<NoticeGroupEntity> groupMemberList = new ArrayList<NoticeGroupEntity>();
		groupMemberList = noticeGroupDao.getGroupMember(groupId);
		//遍历群组成员列表
		for(NoticeGroupEntity ngm : groupMemberList){
			//依次计算成员人数
			if(ngm.getMemberType().equals("0")){
				//计算员工人数
				ngm.setNumber(1);
				//获取员工部门
    			ngm.setEmpOrgname(noticeGroupDao.getEmpOrgname(ngm.getMemberCode()));
			}else if(ngm.getMemberType().equals("1")){
				//计算部门人数
				ngm.setNumber(receiveDao.getDepartmentMemberNumByOrgid(ngm.getMemberCode()));
			}else if(ngm.getMemberType().equals("2")){
				//计算岗位人数
				if(ngm.getPositionDep()!=null && ngm.getCodeType()!=null){
                	//岗位-部门/人员，PositionDep和CodeType都不为空，CodeType分为empId和orgId
            		if(ngm.getCodeType().equals("empid")){
            			ngm.setNumber(1);
            		}else if(ngm.getCodeType().equals("orgid")){
            			ngm.setNumber(receiveDao.getJobNumber(ngm.getMemberCode(),ngm.getPositionDep()));
            		}
                }else{
                	//若直接选的一个岗位，则PositionDep和CodeType都为空
                	ngm.setNumber(receiveDao.getJobNumber(ngm.getMemberCode(), ngm.getMemberName()));  	
                }
				//拼接岗位名
    			if(ngm.getPositionDep()!=null){
    				ngm.setPositionName(ngm.getMemberName() + "-" + ngm.getPositionDep());
    			}else{
    				ngm.setPositionName(ngm.getMemberName());
    			}
			}
		}
		return groupMemberList;
    }
    
    /**
     * 群组重命名
     */
    public int updateGroupName(String groupId,String groupName,String groupOwner){
    	Map<String,String> map = new HashMap<String,String>();
    	//群组id
    	map.put("groupId", groupId);
   	    //群组名
    	Map<String,String> gmap = new HashMap<String,String>();
		gmap.put("groupName", groupName);
		gmap.put("groupOwner", groupOwner);
    	int count = noticeGroupDao.getGroupNameCount(gmap);
		if(count == 0){
			map.put("groupName", groupName);
		}else{
			int i=0;
			int n=0;
			String gName = groupName;
			do{
				i=i+1;
				gName = groupName + "(" + String.valueOf(i);
				System.out.println(gName);
				Map<String,String> gmap1 = new HashMap<String,String>();
				gmap1.put("groupName", gName);
				gmap1.put("groupOwner", groupOwner);
				n = noticeGroupDao.getGroupNameCount(gmap1);
			}while(n != 0);
			map.put("groupName", gName);
		}  
    	//更新群组名
    	return noticeGroupDao.updateGroupName(map);
    }
    
    /**
     * 删除群组
     */
    public int deleteGroup(String groupId){
    	return noticeGroupDao.deleteGroup(groupId);
    }
    
    /**
     * 删除群组成员
     */
    public int deleteGroupMember(String groupId,String memberType,String memberCode,String positionDep){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("groupId", groupId);
    	map.put("memberType", memberType);
    	map.put("memberCode", memberCode);
    	if(positionDep != null){
    		boolean boo = positionDep.equals("false");
    		if(memberType.equals("2") && (! boo)){
        		map.put("positionDep", positionDep);
        	}
    	}
    	//删除群组成员
    	return noticeGroupDao.deleteGroupMember(map);
    }
    

    public INoticeGroupDao getNoticeGroupDao() {
		return noticeGroupDao;
	}
    
	public void setNoticeGroupDao(INoticeGroupDao noticeGroupDao) {
		this.noticeGroupDao = noticeGroupDao;
	}
	
	public static Logger getLogger() {
		return logger;
	}

	public NoticeGroupEntity getGroupEntity() {
		return groupEntity;
	}

	public void setGroupEntity(NoticeGroupEntity groupEntity) {
		this.groupEntity = groupEntity;
	}


	public IReceiveObjectDao getReceiveDao() {
		return receiveDao;
	}


	public void setReceiveDao(IReceiveObjectDao receiveDao) {
		this.receiveDao = receiveDao;
	}

}
