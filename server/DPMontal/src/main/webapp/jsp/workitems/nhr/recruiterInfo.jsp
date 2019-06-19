<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.RecruiterInfo" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.RecInfoList" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.WorkflowInfo" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	
</head>

<body>
 <%
 QueryWorkflowInfoResponse hrBusiRsp = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
 RecruiterInfo info = hrBusiRsp.getRecruiterInfo();
 List<RecInfoList> recInfoList = info.getRecInfoList();
 List<WorkflowInfo> workflowInfos = info.getWorkflowInfo();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					<th colspan="2" class="yellow">基本信息</th>
				</tr>
<!-- 				<tr> -->
<!-- 				  <th >申请单编号:</th> -->
<%-- 				  <td><%=info.getWfno() == null ? "" : info.getWfno() == null%></td> --%>
<!-- 			   	</tr> -->
			   	<tr>
				  <th >申请人工号:</th>
				  <td><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></td>
			   	</tr>
			   	<tr>
				  <th >申请单编号:</th>
				  <td><%= info.getWfno() == null ? "" : info.getWfno()%></td>
			   	</tr>
			   	<tr>
				  <th >申请人姓名:</th>
				  <td><%= info.getApplypsnname() == null ? "" : info.getApplypsnname()%></td>
			   	</tr>
			   	<tr>
				  <th >当地人事部:</th>
				  <td><%=info.getHrdeptname() == null ? "" : info.getHrdeptname()%></td>
			    </tr>
			   	<tr>
				  <th >补员性质:</th>
				  <td><%= info.getRecruitertypename() == null ? "" : info.getRecruitertypename()%></td>
			   	</tr>
			   	<tr>
				  <th >增补员总人数:</th>
				  <td><%=info.getTotalcount()%></td>
			    </tr>
			   	<tr>
				  <th >申请事由:</th>
				  <td><%=info.getApplyreason() == null ? "" : info.getApplyreason()%></td>
			  	 </tr>
			  	 
			  	 
			  	  <tr class="yellow">
						<td colspan="2" >增补员明细</td>
					</tr>
				<%
					int recInfoSize = recInfoList ==  null ? 0:recInfoList.size();
					for(int i = 0;i<recInfoSize;i++){
						RecInfoList recinfo = recInfoList.get(i);
				%>
				 <tr  class='topLine'>
					  <th>用人部门:</th>
					  <td><%=recinfo.getUsedeptname()== null ?"":recinfo.getUsedeptname()%></td>
				   </tr>
					<tr>
					  <th>安排职位名称:</th><!-- amountOfConsignment -->
					  <td><%=recinfo.getArrangeposname()%></td>
				   </tr>
				   <tr  >
					  <th>增补员人数:</th>
					  <td><%=recinfo.getRecruiternum()%></td>
				   </tr>
				    <tr  >
					  <th>人数（男）:</th>
					  <td><%=recinfo.getMannum()%></td>
				   </tr>
				   <tr  >
					  <th>人数（女）:</th>
					  <td><%=recinfo.getWomannum()%></td>
				   </tr>
				   <tr  >
					  <th>上班类型:</th>
					  <td><%=recinfo.getWorktype()== null ?"":recinfo.getWorktype()%></td>
				   </tr>
				   <tr  >
					  <th>上班时长:</th>
					  <td><%=recinfo.getWorklongtime()%></td>
				   </tr>
				   <tr  >
					  <th>岗位类别:</th>
					  <td><%=recinfo.getPosname()== null ?"":recinfo.getPosname()%></td>
				   </tr>
				   <tr  >
					  <th>人均货量:</th>
					  <td><%=recinfo.getPeravgnum()== null ?"":recinfo.getPeravgnum()%></td>
				   </tr>
				   <tr  >
					  <th>线路:</th>
					  <td><%=recinfo.getWorkline()== null ?"":recinfo.getWorkline()%></td>
				   </tr>
				   <tr  >
					  <th>增补员原因:</th>
					  <td><%=recinfo.getRecruiterreason()== null ?"":recinfo.getRecruiterreason()%></td>
				   </tr>
				   <tr>
					  <th>工作流号或编号:</th>
					  <td><%=recinfo.getPopcode()== null ?"":recinfo.getPopcode()%></td>
				   </tr>
				   <tr  >
					  <th>部门性质:</th>
					  <td><%=recinfo.getDepartmentType()== null ?"":recinfo.getDepartmentType()%></td>
				   </tr>
				   <%}%> 
				   
				   
				 <tr class="yellow">
						<td colspan="2">大区缺口情况</td>
					</tr>
				<%
					int workflowsize = workflowInfos ==  null ? 0:workflowInfos.size();
					for(int i = 0;i<workflowsize;i++){
						WorkflowInfo wfInfo = workflowInfos.get(i);
				%>
					<tr class='topLine'>
					  <th>部门性质:</th><!-- amountOfConsignment -->
					  <td><%=wfInfo.getDeptType()%></td>
				   </tr>
				   <tr  >
					  <th>预算人数:</th>
					  <td><%=wfInfo.getBudgetNum()%></td>
				   </tr>
				   <tr  >
					  <th>现有人数:</th>
					  <td><%=wfInfo.getNowNum()%></td>
				   </tr>
				   <tr>
					  <th>已申请人数:</th>
					  <td><%=wfInfo.getNeedNum()%></td>
				   </tr>
				   <tr  >
					  <th>可增补人数:</th>
					  <td><%=wfInfo.getAllowNum()%></td>
				   </tr>
				   <tr>
					  <th>备注:</th>
					  <td><%=wfInfo.getComment()== null ?"":wfInfo.getComment()%></td>
				   </tr>
					 <%}%>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>