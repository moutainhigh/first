<%@page import="com.deppon.wfs.workflow.domain.BudgeDataChildrenMinusBean"%>
<%@page import="com.deppon.wfs.workflow.domain.BudgeDataChildrenBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.Budgedata"%>
<%@page import="com.deppon.wfs.workflow.domain.BudgeDataSubmitDetailBean"%>
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
Budgedata info = (Budgedata)request.getAttribute("entity");
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
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>预算数据申请</td>
					</tr>
					<tr>
					   <th>工作流类型:</th>
					   <td>
					   <% if("1".equals(info.getWorkflowType())){%>
					   	预算提交
					   <%}else{%>
					  	 预算调整
					   <%}%>
					   </td>
					</tr>
					<% if("0".equals(info.getWorkflowType())){%>
						<tr>
							<th>调整方式:</th><!-- WFS_ADJUSTMENT_TYPE -->
						  	<td><%=info.getAdjustmentType()%></td>
					   	</tr>
					<%}%>					
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				   <tr>
					  <th>预算部门:</th>
					  <td><%=info.getDepartment()%></td>
				   </tr>
					 <tr>
					  <th>部门性质:</th><!-- WFS_DEPARTMENT_PROPERTY_NEW -->
					  <td><%=info.getDepartmentProperty()%></td>
				   </tr>
				   <%if ("营运管职能".equals(info.getDepartmentProperty())) {%>
					   <tr>
						  <th>所属经营本部:</th><!-- WFS_HEADQUARTERS -->
						  <td><%=info.getBelongOffice()%></td>
					   </tr>
				   <%}%>
				   <tr>
					  <th>预算年份:</th>
					  <td><%=info.getBudgetYear()%></td>
				   </tr>
				    
				   <% if("1".equals(info.getWorkflowType())){
				   		if("否".equals(info.getIfYearlyBudget())){%>
						   <tr>
							  <th>调整成本项:</th><!-- WFS_ADJUSTMENT_ITEM -->
							  <td><%=info.getAdjustmentCostItem()%></td>
						   </tr>
				   		<%} %>
					   <tr>
						  <th>是否年度预算:</th><!-- WFS_ISORNO -->
						  <td><%=info.getIfYearlyBudget()%></td>
					   </tr>
					   
					   <!-- 是否年度预算：是               提交明细==展示-->
					   <%
					   if("否".equals(info.getIfYearlyBudget())){%>
						<tr>
							<th colspan="2" class="yellow">提交明细：</th>
						</tr>
						<%List<BudgeDataSubmitDetailBean> budgeDataSubmitDetailBeans = info.getBudgeDataSubmitDetail();
					   for (int i = 0 ; i < budgeDataSubmitDetailBeans.size() ; i ++) {
						   BudgeDataSubmitDetailBean temp = budgeDataSubmitDetailBeans.get(i);%>
						   <tr class=<%=i==0?"":"'topLine'" %>>
							  <th>成本项:</th>
							  <td><%=temp.getSubmitDetailCostItem()%></td>
						   </tr>
						   <tr>
							  <th>提交金额:</th>
							  <td><%=temp.getSubmitDetailMoney()%></td>
						   </tr>
					   <%} }%>
					   
				   <%}else{%>
					   <tr>
						  <th>调增成本项:</th><!-- WFS_ADJUSTMENT_ITEM -->
						  <td><%=info.getAddCostItem()%></td>
					   </tr>
					   	<tr>
							<th colspan="2" class="yellow">调增信息</th>
						</tr>
					   <%List<BudgeDataChildrenBean> entities = info.getBudgeDataChildren();
					   for (int i = 0 ; i < entities.size() ; i ++) {
						   BudgeDataChildrenBean temp = entities.get(i);%>
						   <tr class="topLine">
							  <th>调增科目:</th>
							  <td><%=temp.getAdjustmentSubject()%></td>
						   </tr>
						   <tr>
							  <th>调增部门:</th>
							  <td><%=temp.getAdjustmentDept()%></td>
						   </tr>
						   <tr>
							  <th>调整月份:</th><!-- WFS_MONTH -->
							  <td><%=temp.getAdjustmentMonth()%></td>
						   </tr>
						   <tr>
							  <th>调整金额:</th>
							  <td><%=temp.getAdjustmentMoney()%></td>
						   </tr>
					   <%}%>
					   <tr>
					  		<th>调增年度利润影响值:</th>
					  		<td><%=info.getProfitEffectAdd()%></td>
				   		</tr>
				   <%}%>
				   <%if("0".equals(info.getWorkflowType())){%> 		
				   		<%if (!"新增费用调整".equals(info.getAdjustmentType())){%>
				   			<tr>
							  <th>调减成本项:</th><!-- WFS_ADJUSTMENT_ITEM -->
							  <td><%=info.getMinusCostItem()%></td>
						   </tr>
						   	<tr>
								<th colspan="2" class="yellow">调减信息</th>
							</tr>
				   			<%List<BudgeDataChildrenMinusBean> entities = info.getBudgeDataChildrenMinus();
				   			for (int i = 0 ;i < entities.size() ; i ++ ) {
				   				BudgeDataChildrenMinusBean temp = entities.get(i);%>
				   				<tr class="topLine">
								  <th>调减科目:</th>
								  <td><%=temp.getAdjustmentSubjectMinus()%></td>
							   </tr>
							   <tr>
								  <th>调减部门:</th>
								  <td><%=temp.getAdjustmentDeptMinus()%></td>
							   </tr>
							   <tr>
								  <th>调整月份:</th><!-- WFS_MONTH -->
								  <td><%=temp.getAdjustmentMonthMinus()%></td>
							   </tr>
							   <tr>
								  <th>调整金额:</th>
								  <td><%=temp.getAdjustmentMoneyMinus()%></td>
							   </tr>
				   			<%} %>
				   			
						   <tr>
							  <th>调减年度利润影响值:</th>
							  <td><%=info.getProfitEffectMinus()%></td>
						   </tr>
						   
				   	<%	} %>
				   <%}%>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReason()==null?"":info.getApplyReason()%></td>
				   </tr> 
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>