package com.deppon.montal.module.workitems.service; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

//import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
   
import com.deppon.montal.model.OaAccidentdescriptionInfo;
import com.deppon.montal.model.OaApprovalInfo;
import com.deppon.montal.model.OaDeptexpenses;
import com.deppon.montal.model.OaLeaveDetail;
import com.deppon.montal.model.OaNomalClaim;
import com.deppon.montal.model.OaContractApply;
import com.deppon.montal.model.OaDecoprogramApply;
import com.deppon.montal.model.OaFilePublish;
import com.deppon.montal.model.OaLeaveApply;
import com.deppon.montal.model.OaPersonAdd;
import com.deppon.montal.model.OaPersonAddEntry;
import com.deppon.montal.model.OaResignApply;
import com.deppon.montal.model.OaRewardpunishmentInfo;
import com.deppon.montal.model.OaWorkItem;
import com.deppon.montal.module.workitems.webservice.client.WorkItemsWebServiceClient;
//import com.deppon.montal.module.workitems.webservice.client.WorkItemsWebServiceClient;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
import com.deppon.montal.util.StringUtil;
/** 
 * @Title: WorkItemsService.java
 * @Package com.deppon.montal.module.todolist.service 
 * @Description:(待办事项) 
 * @author 廖建雄 
 * @date 2013-2-21 下午4:13:27 
 * @version V1.0 
 */
public class WorkItemsService implements IWorkItemsService {
    private static Logger logger = Logger.getLogger(WorkItemsService.class);
   
    /**
     *  查询代办列表(yin)
     */
    public List<OaWorkItem> queryWorkItem(String userid,String syscodes){
//		String sql = SQLManager.getQueryWorkflowList(syscodes);
    	String sql = SQLManager.queryWFListSql();
//		Object[] params = {userid,userid,userid,userid};
    	Object[] params = {userid,userid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		List<OaWorkItem> oawWorkItemList = new ArrayList<OaWorkItem>(); 
		try {
		   rs = ConnectionManager.query(conn, sql, params);
		   List  resultList = ConvertPojoUtil.resultSetToList(rs);
		   for (Object object : resultList) {
			   OaWorkItem  workItem = (OaWorkItem) ConvertPojoUtil.mapToBean(new OaWorkItem(), 
			       (Map)object);
		       oawWorkItemList.add(workItem);
		}
		} catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oawWorkItemList;
    }
    
    /**
     *  查询代办列表(分页查询)
     */
    public List<OaWorkItem> queryWorkItem(String userid,String key,int pageNum,int pageSize,String syscodes){
    	//默认b=true 外部系统工作流
    	boolean b = false;
    	if(null == key){
			key = "";
		}else{
			//外部系统
			if(Pattern.compile("(?i)[A-Z]").matcher(key).find() || "".equals(key)){
				b = true;
			}
		}
		String sql = SQLManager.getQueryWorkflowPageintion(b);
		int end = pageNum*pageSize;
		int start = (pageNum-1)*pageSize+1;
		if(pageNum > 1){//第一页显示4条，以后都8条
			end = pageNum*pageSize - 4;
			start = (pageNum-1)*pageSize+1-4;
		}
		Object[] params = {userid,userid,"%"+key+"%",userid,userid,"%"+key+"%",end,start};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		List<OaWorkItem> oawWorkItemList = new ArrayList<OaWorkItem>(); 
		try {
		   rs = ConnectionManager.query(conn, sql, params);
		   List  resultList = ConvertPojoUtil.resultSetToList(rs);
		   for (Object object : resultList) {
			   OaWorkItem  workItem = (OaWorkItem) ConvertPojoUtil.mapToBean(new OaWorkItem(), 
			       (Map)object);
		       oawWorkItemList.add(workItem);
		}
		} catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oawWorkItemList;
    }
    
    
    /**
     * 装修工程申请详细信息获取(yin)
     * @param processinstid
     * @return
     */
    public OaDecoprogramApply getDecoprogramApplyById(String processinstid){
    	 
    	String sql = SQLManager.QUERY_DECOPROGRAM_APPLY_BY_ID;
    	Object[] params = {processinstid};
    	Connection conn = ConnectionManager.getConnection();
    	OaDecoprogramApply apply = null;
		ResultSet rs = null;
    	try{
    		rs = ConnectionManager.query(conn, sql, params);
    		List  resultList = ConvertPojoUtil.resultSetToList(rs);
    		apply = (OaDecoprogramApply) ConvertPojoUtil.mapToBean(new OaDecoprogramApply(), 
 			       (Map)resultList.get(0));
    	}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
    	return apply;
    }
    
    /**
     * 查询审批处理记录(yin)
     * @param processinstid
     * @return
     */
    public List<OaApprovalInfo> queryApprovalInfoList(String processinstid){
    	
    	String sql = SQLManager.QUERY_FLOW_APPROVE_INFO;
    	Object[] params = {processinstid};
    	Connection conn = ConnectionManager.getConnection();
    	List<OaApprovalInfo> list = new ArrayList<OaApprovalInfo>();
		ResultSet rs = null;
    	try{
    		rs = ConnectionManager.query(conn, sql, params);
    		List  resultList = ConvertPojoUtil.resultSetToList(rs);
    		for (Object object : resultList) {
    			OaApprovalInfo  info = (OaApprovalInfo) ConvertPojoUtil.mapToBean(new OaApprovalInfo(), 
 			       (Map)object);
    			list.add(info);
    		}
    		
    	}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
    	return list;
    }
    public Map getLeaveWorkFlowApplyById(String processinstid){
	String sql = SQLManager.QUERY_LEAVE_WORKFLOW_BY_ID;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	Map<String, Object> map = new HashMap<String, Object>();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    List<OaLeaveDetail> leaveDetailList = new ArrayList<OaLeaveDetail>();
	    OaLeaveApply leaveApplyInfo = new OaLeaveApply();
	    if (resultList.size() > 0) {
		 leaveApplyInfo = (OaLeaveApply) ConvertPojoUtil.mapToBean(new OaLeaveApply(), 
			       (Map)resultList.get(0));
		
		// 获取详细信息
		String detailSQL=SQLManager.QUERY_LEAVEDETAIL_BY_ID;
		rs = ConnectionManager.query(conn, detailSQL, params);
		String[] month = null;
		String[] days = null;
		while(rs.next()){
			if(rs.getString(1)!=null){
				month = rs.getString(1).split("[|]");
				days = rs.getString(2).split("[|]");
				int i = 0;
            	for (String string : month) {
            		OaLeaveDetail d = new OaLeaveDetail();
        			d.setMonth(string);
        			d.setDays(days[i]);
            		leaveDetailList.add(d);
            		i++;
            	}
			}
		}
            	
        	map.put("leaveApplyInfo", leaveApplyInfo);
    		map.put("detailList", leaveDetailList);
	    }
	} catch (SQLException e) {
	       e.printStackTrace();
	} catch (IOException e) {
	       e.printStackTrace();
	}finally{
		ConnectionManager.closeAll(conn, null, rs);
	}
	return map;
    }

    /**
     * 获取增补员申请详细(yin)
     * @param processinstid
     * @return 
     */
    public Map getPersonAddInfo(String processinstid){
    	
    	Map map = new HashMap();
    	
    	String sql1 = SQLManager.QUERY_PERSONADD_APPLY_BY_ID;
    	String sql2 = SQLManager.QUERY_PERSONADD_ENTRY_BY_ID;
    	Object[] params = {processinstid};
    	Connection conn = ConnectionManager.getConnection();
    	OaPersonAdd padd = null;
    	List<OaPersonAddEntry> penteyList = new ArrayList<OaPersonAddEntry>();
    	ResultSet rs = null;
		try{
			//申请信息
			rs = ConnectionManager.query(conn, sql1, params);
			List  resultList = ConvertPojoUtil.resultSetToList(rs);
			padd = (OaPersonAdd) ConvertPojoUtil.mapToBean(new OaPersonAdd(), 
 			       (Map)resultList.get(0));
			//详细列表
			rs = ConnectionManager.query(conn, sql2, params);
			List  resultList2 = ConvertPojoUtil.resultSetToList(rs);
			for (Object object : resultList2) {
				OaPersonAddEntry  pentey = (OaPersonAddEntry) ConvertPojoUtil.mapToBean(new OaPersonAddEntry(), 
				       (Map)object);
				penteyList.add(pentey);
			}
		}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		map.put("personAdd", padd);
		map.put("personList", penteyList);
		
		return map;
    }
    public OaResignApply getResingWorkFlowApplyById(String processinstid){
	String sql = SQLManager.QUERY_RESIGN_WORKFLOW_BY_ID;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OaResignApply  oaResignApplyInfo = new OaResignApply();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    List resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
		oaResignApplyInfo = (OaResignApply) ConvertPojoUtil.mapToBean(new OaResignApply(), 
			(Map)resultList.get(0));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}finally{
		ConnectionManager.closeAll(conn, null, rs);
	}
	return oaResignApplyInfo;
    }
    /**
     * 获取文件发布申请详细(yin)
     * @param processinstid
     * @return 
     */
    public OaFilePublish getFilePublishInfo(String processinstid){
    	
    	String sql = SQLManager.QUERY_FILEPUBLISH_BY_ID;
    	Object[] params = {processinstid};
    	Connection conn = ConnectionManager.getConnection();
    	OaFilePublish pub = null;
		ResultSet rs = null;
    	try{
    		rs = ConnectionManager.query(conn, sql, params);
    		List  resultList = ConvertPojoUtil.resultSetToList(rs);
    		pub = (OaFilePublish) ConvertPojoUtil.mapToBean(new OaFilePublish(), 
 			       (Map)resultList.get(0));
    	}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
    	return pub;
    }
    
    /**
     * 获取签订合同申请详细(yin)
     * @param processinstid
     * @return 
     */
    public OaContractApply getContractSignInfo(String processinstid){
    	
    	String sql = SQLManager.QUERY_CONTRACTSIGN_APPLY_BY_ID;
    	Object[] params = {processinstid};
    	Connection conn = ConnectionManager.getConnection();
    	OaContractApply apply = null;
		ResultSet rs = null;
    	try{
    		rs = ConnectionManager.query(conn, sql, params);
    		List  resultList = ConvertPojoUtil.resultSetToList(rs);
    		apply = (OaContractApply) ConvertPojoUtil.mapToBean(new OaContractApply(), 
 			       (Map)resultList.get(0));
    	}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
    	return apply;
    }
    public String getWfActivityInstInfo(long processinstid){
	
   	String sql = SQLManager.QUERY_WFACTIVITYINST;
   	Object[] params = {processinstid};
   	Connection conn = ConnectionManager.getConnection();
   	ResultSet rs = null;
   	try{
   	    rs = ConnectionManager.query(conn, sql, params);
   	    while (rs.next()) {
   		String activityId = rs.getString(1);
   		Object[] obj = {Long.parseLong(activityId)};
   		//发送请求
		String acitivityJson = getActivityInstWebService(obj,1);
		return acitivityJson;
	    }
   	}catch (SQLException e) {
   	    logger.error("SQL语句出错！" + e.getMessage());
	}finally{
		ConnectionManager.closeAll(conn, null, rs);
	}
   	return null;
       }
    //调用工作流接口查询可回退节点
    private String getActivityInstWebService(Object[] obj, int num) {
	String acitivityJson = "";
	try {
	    acitivityJson = WorkItemsWebServiceClient.findAcitivityInst(obj);
	} catch (Exception e) {
	    logger.error("ERROR: getActivityInstWebService...." + e.getMessage());
	    return "[{\"name\":\"failure\"}] ";
	}
	if(num >= 20){
	    return StringUtil.isEmptyOrNull(acitivityJson)?"[{\"name\":\"failure\"}] ":
		"[{\"name\":\"failure\"}]".equals(acitivityJson)?"[{\"name\":\"failure\"}] ":
		"[{\"name\":\"failure2\"}]".equals(acitivityJson)?"[{\"name\":\"failure\"}] ":
		"[{\"name\":\"failure3\"}]".equals(acitivityJson)?"[{\"name\":\"failure\"}] ":acitivityJson;
	}else if(StringUtil.isEmptyOrNull(acitivityJson)){
	    return getActivityInstWebService(obj,++num);
	}else if ("[{\"name\":\"failure\"}]".equals(acitivityJson)) {
	    return getActivityInstWebService(obj,++num);
	}else if("[{\"name\":\"failure2\"}]".equals(acitivityJson)){
	    return getActivityInstWebService(obj,++num);
	}else if("[{\"name\":\"failure3\"}]".equals(acitivityJson)){
	    return getActivityInstWebService(obj,++num);
	}else{
	    return acitivityJson;
	}
    }
    public Map getClaimsWorkFlowApplyById(String processinstid){
	
	String sql = SQLManager.QUERY_CLAIMS_WORKFLOW_BY_ID; //申请信息
	
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	
	OaNomalClaim claims = new OaNomalClaim();
	Map<String, Object> map = new HashMap<String, Object>();
	ResultSet rs = null;
	try{
	    rs = ConnectionManager.query(conn, sql, params);
	    List  resultList = ConvertPojoUtil.resultSetToList(rs);
	    if (resultList.size() > 0) {
		claims = (OaNomalClaim) ConvertPojoUtil.mapToBean(new OaNomalClaim(), 
			(Map)resultList.get(0));
	    }
	    OaAccidentdescriptionInfo description = getDescription(params, conn);
	    List<OaDeptexpenses> deptexpenses = getDeptexpenses(params, conn);
	    OaRewardpunishmentInfo punishment = getPunishment(params, conn);
	    
	    map.put("claims", claims);
	    map.put("description", description);
	    map.put("deptexpenses", deptexpenses);
	    map.put("punishment", punishment);
	}catch (SQLException e) {
	    logger.error("SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("文件流读取失败！" + e.getMessage());
	}finally{
		ConnectionManager.closeAll(conn, null, rs);
	}
	return map;
    }

    private OaRewardpunishmentInfo getPunishment( Object[] params,
	    Connection conn) throws SQLException, IOException {
	OaRewardpunishmentInfo punishment = new OaRewardpunishmentInfo();
	String sql = SQLManager.QUERY_CLAIMS_REWARDPUNISHMENTINFO_BY_ID; //奖罚明细申请信息
	ResultSet rs = null;
	rs = ConnectionManager.query(conn, sql, params);
	List  resultList = ConvertPojoUtil.resultSetToList(rs);
	if (resultList.size() > 0) {
        	punishment = (OaRewardpunishmentInfo) ConvertPojoUtil.mapToBean(new OaRewardpunishmentInfo(), 
        		(Map)resultList.get(0));
	}
	return punishment;
    }

    private List<OaDeptexpenses> getDeptexpenses(Object[] params,
	    Connection conn) throws SQLException, IOException {
	List<OaDeptexpenses> deptexpenses = new ArrayList<OaDeptexpenses>();
	String sql = SQLManager.QUERY_CLAIMS_DEPTEXPENSES_BY_ID; //入部门费用信息
	ResultSet rs = null;
	rs = ConnectionManager.query(conn, sql, params);
	List  resultList1 = ConvertPojoUtil.resultSetToList(rs);
	for (Object object : resultList1) {
	    deptexpenses.add((OaDeptexpenses) ConvertPojoUtil.mapToBean(new OaDeptexpenses(), 
		    (Map)object));
	}
	return deptexpenses;
    }

    private OaAccidentdescriptionInfo getDescription( Object[] params,
	    Connection conn) throws SQLException, IOException {
	OaAccidentdescriptionInfo description = new OaAccidentdescriptionInfo();
	String sql = SQLManager.QUERY_CLAIMS_ACCIDENTDESCRIPTIONINFO_BY_ID; //出险情况说明信息
	ResultSet rs = null;
	rs = ConnectionManager.query(conn, sql, params);
	List  resultList = ConvertPojoUtil.resultSetToList(rs);
	if (resultList.size() > 0) {
	    description = (OaAccidentdescriptionInfo) ConvertPojoUtil.mapToBean(new OaAccidentdescriptionInfo(), 
		    (Map)resultList.get(0));
	}
	return description;
    }
    
    public Map getActivityStartId(String processinstid){
	String sql = SQLManager.QUERY_WFACTIVITYINST_BY_WOKRID;
	Object[] params = {processinstid,processinstid};
	Connection conn = ConnectionManager.getConnection();
	Map<String, String> map = new HashMap<String, String>();
	ResultSet rs = null;
	try {
	     rs = ConnectionManager.query(conn, sql, params);
	    while(rs.next()){
		map.put("startActId", rs.getString(1));
		map.put("currentActId", rs.getString(2));
	    }
	}catch (SQLException e) {
	    logger.error("SQL语句出错！" + e.getMessage());
	}finally{
		ConnectionManager.closeAll(conn, null, rs);
	}
	return map;
    }
}

