<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.RecruiterInfo" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.RecInfoList" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.WorkflowInfo" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=UTF-8" />
<%@include file="/common_ios.jsp"%>
<style type="text/css">
li {
	word-wrap: break-word;
}
</style>
</head>
<%
QueryWorkflowInfoResponse hrBusiRsp = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
RecruiterInfo info = hrBusiRsp.getRecruiterInfo();
List<RecInfoList> recInfoList = info.getRecInfoList();
List<WorkflowInfo> workflowInfos = info.getWorkflowInfo();
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
				<li style="border-top: 1px none #aaa;">
					<em class="yellow">基本信息</em>
				</li>
<!-- 				<li> -->
<!-- 				  申请单编号: -->
<%--  				  <em><%=info.getWfno() == null ? "" : info.getWfno() == null%></em> --%>
<!-- 			   	</li> -->
			   	<li>
				  申请人工号:
				  <em><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></em>
			   	</li>
			   	<li>申请单编号:
				  <em><%= info.getWfno() == null ? "" : info.getWfno()%></em>
			   	</li>
			   	<li>
				  申请人姓名:
				  <em><%= info.getApplypsnname() == null ? "" : info.getApplypsnname()%></em>
			   	</li>
			   	<li>
				  当地人事部:
				  <em><%=info.getHrdeptname() == null ? "" : info.getHrdeptname()%></em>
			    </li>
			    <li>补员性质:
				  <em><%=info.getRecruitertypename() == null ? "" : info.getRecruitertypename()%></em>
			    </li>
			   	<li>
				  增补员总人数:
				  <em><%=info.getTotalcount()%></em>
			    </li>
			   	<li>
				  申请事由:
				  <em><%=info.getApplyreason() == null ? "" : info.getApplyreason()%></em>
			  	 </li>
			  	 
			  	 
			  	  <li class="yellow">
						<em colspan="2" >增补员明细</em>
					</li>
				<%
					int recInfoSize = recInfoList ==  null ? 0:recInfoList.size();
					for(int i = 0;i<recInfoSize;i++){
						RecInfoList recinfo = recInfoList.get(i);
				%>
				 	<li class='topLine'>
					  用人部门:
					  <em><%=recinfo.getUsedeptname()== null ?"":recinfo.getUsedeptname()%></em>
				   </li>
				   <li >安排职位名称:<!-- amountOfConsignment --><em><%=recinfo.getArrangeposname()%></em></li>
				   <li>增补员人数:<em><%=recinfo.getRecruiternum()%></em></li>
				   <li  >人数（男）:<em><%=recinfo.getMannum()%></em></li>
				   <li  >人数（女）:<em><%=recinfo.getWomannum()%></em></li>
				   <li>上班类型:<em><%=recinfo.getWorktype()== null ?"":recinfo.getWorktype()%></em></li>
				   <li>上班时长:<em><%=recinfo.getWorklongtime()%></em></li>
				   <li>岗位类别:<em><%=recinfo.getPosname()== null ?"":recinfo.getPosname()%></em></li>
				   <li>人均货量:<em><%=recinfo.getPeravgnum()== null ?"":recinfo.getPeravgnum()%></em></li>
				   <li>线路:<em><%=recinfo.getWorkline()== null ?"":recinfo.getWorkline()%></em></li>
				   <li>增补员原因:<em><%=recinfo.getRecruiterreason()== null ?"":recinfo.getRecruiterreason()%></em></li>
				   <li>工作流号或编号:<em><%=recinfo.getPopcode()== null ?"":recinfo.getPopcode()%></em></li>
				   <li  >部门性质:<em><%=recinfo.getDepartmentType()== null ?"":recinfo.getDepartmentType()%></em></li>
				   <%}%> 
				   
				   
				 <li class="yellow">
						<em colspan="2">大区缺口情况</em>
					</li>
				<%
					int workflowsize = workflowInfos ==  null ? 0:workflowInfos.size();
					for(int i = 0;i<workflowsize;i++){
						WorkflowInfo wfInfo = workflowInfos.get(i);
				%>
					<li class='topLine'>部门性质:<!-- amountOfConsignment --><em><%=wfInfo.getDeptType()%></em></li>
					<li>预算人数:<em><%=wfInfo.getBudgetNum()%></em></li>
					<li>现有人数:<em><%=wfInfo.getNowNum()%></em></li>
					<li>已申请人数:<em><%=wfInfo.getNeedNum()%></em></li>
					<li>可增补人数:<em><%=wfInfo.getAllowNum()%></em></li>
				    <li>备注:<em><%=wfInfo.getComment()== null ?"":wfInfo.getComment()%></em></li>
					 
					 <%}%>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
	</div>
</body>
</html>