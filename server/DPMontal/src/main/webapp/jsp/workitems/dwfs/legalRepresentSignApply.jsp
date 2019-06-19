<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.LegalSignBean"%>
<%@page import="com.deppon.wfs.workflow.domain.SignDataBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	LegalSignBean info = (LegalSignBean)request.getAttribute("entity");
	List<SignDataBean> detials = info.getDataCells();
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>法定代表人/负责人签字申请</td>
					</tr>
				   <tr>
					  <th>申请人：</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
				   <tr>
					  <th>申请人工号：</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>	
				  
				  <tr>
					  <th>所属部门：</th>
					  <td><%= info.getAppDept()%></td>
				   </tr>
				   <tr>
					  <th>申请人职位：</th>
					  <td><%= info.getPosition()%></td>
				   </tr>
				   <tr>
					  <th>所属公共事业部：</th>
					  <td><%=info.getDivisionName()%></td>
				   </tr>
				   <tr>
					  <th>所属公共事务组：</th>
					  <td><%=info.getGroupName()%></td>
				   </tr>
				   <tr>
					  <th>所属公共事务小组：</th>
					  <td><%=info.getTeamName() == null ? "" : info.getTeamName()%></td>
				   </tr>
				   <tr>
					  <th>签字人：</th>
					  <td><%=info.getSignName()%></td>
				   </tr>
				   <tr>
					  <th>签字人身份：</th>
					  <td><%="1".equals(info.getSignIdentity()) ? "法定代表人" : "分公司负责人 "%></td>
				   </tr>
				   <tr>
					  <th>是否涉及财务信息披露：</th>
					  <td><%= "1".equals(info.getIsDisclosure()) ? "是" : "否"%></td>
				   </tr>
				   <!-- 是  1 -->
				   <%if("1".equals(info.getIsDisclosure())){%>
				   <tr>
					  <th>数据来源部门：</th>
					  <td><%=info.getDatasourceDept()%></td>
				   </tr>
				   <tr>
					  <th>工作流号：</th>
					  <td><%=info.getWorkflowNo() == null ? "" : info.getWorkflowNo()%></td>
				   </tr>
				   <%}%>
				   <tr colspan="2" class="yellow">
				   	<th>填写签字资料：</th>
				   </tr>
	   			   <%for (int i = 0 ;i < detials.size() ; i ++ ) {%>
	   			   <tr <%= i == 0 ? "" :  "class='topLine'"%> >
					  <th>签字资料名称:</th>
					  <td><%=detials.get(i).getSigndataName()%></td>
				   </tr>
				   <tr>
					  <th>签字资料份数:</th>
					  <td><%=detials.get(i).getSigndataNum()%></td>
				   </tr>
	   			   <%} %>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReason()  %></td>
				   </tr>
				<%@include file="approve_process.jsp" %>		   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>