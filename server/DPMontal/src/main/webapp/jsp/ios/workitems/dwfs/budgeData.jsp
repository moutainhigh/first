<%@page import="com.deppon.wfs.workflow.domain.BudgeDataChildrenMinusBean"%>
<%@page import="com.deppon.wfs.workflow.domain.BudgeDataChildrenBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.Budgedata"%>
<%@page import="com.deppon.wfs.workflow.domain.BudgeDataSubmitDetailBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
Budgedata info = (Budgedata)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em> 预算数据申请</em></li>
			   <li>工作流类型:<em>
					<% if("1".equals(info.getWorkflowType())){%>
					   	预算提交
					<%}else{%>
					  	 预算调整
					<%}%></em>
				</li>
				<% if("0".equals(info.getWorkflowType())){%>
					<li>调整方式:<em><!-- WFS_ADJUSTMENT_TYPE --><%=info.getAdjustmentType()%></em></li>
				<%}%>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>申请人工号:<em><%=info.getApplyPersonId()%></em></li>
				<li>预算部门:<em><%=info.getDepartment()%></em></li>
				<li>部门性质:<em><%=info.getDepartmentProperty()%></em></li>
				<%if ("营运管职能".equals(info.getDepartmentProperty())) {%>
					<li>所属经营本部:<em><!-- WFS_HEADQUARTERS --><%=info.getBelongOffice()%></em></li>
				<%}%>
				<li>预算年份:<em><%=info.getBudgetYear()%></em></li>
				<% if("1".equals(info.getWorkflowType())){%>
					<%if("否".equals(info.getIfYearlyBudget())){%>
						<li>调整成本项:<em><!-- WFS_ADJUSTMENT_ITEM --><%=info.getAdjustmentCostItem()%></em></li>
					<%}%>
					<li>是否年度预算:<em><!-- WFS_ISORNO --><%=info.getIfYearlyBudget()%></em></li>
					<!-- 是否年度预算：是               提交明细==展示-->
					   <%
					   if("否".equals(info.getIfYearlyBudget())){%>
						<li style="color: red">提交明细：</li>
						<%List<BudgeDataSubmitDetailBean> budgeDataSubmitDetailBeans = info.getBudgeDataSubmitDetail();
					   for (int i = 0 ; i < budgeDataSubmitDetailBeans.size() ; i ++) {
						   BudgeDataSubmitDetailBean temp = budgeDataSubmitDetailBeans.get(i);%>
						   <li class=<%=i==0?"":"'topLine'" %>>成本项:<em><%=temp.getSubmitDetailCostItem()%></em></li>
						   <li>提交金额:<em><%=temp.getSubmitDetailMoney()%></em></li>
					   <%} }%>
				<%}else{%>
					<li>调增成本项:<em><!-- WFS_ADJUSTMENT_ITEM --><%=info.getAddCostItem()%></em></li>
					<li style="color: red">调增信息</li>
					<%List<BudgeDataChildrenBean> entities = info.getBudgeDataChildren();
					   for (int i = 0 ; i < entities.size() ; i ++) {
						   	BudgeDataChildrenBean temp = entities.get(i);%>
							<li <%=i==0?"":"class='line'" %>>调增科目:<em><%=temp.getAdjustmentSubject()%></em></li>
					   		<li>调增部门:<em><%=temp.getAdjustmentDept()%></em></li>
					   		<li>调整月份:<em><!-- WFS_MONTH --><%=temp.getAdjustmentMonth()%></em></li>
					   		<li>调整金额:<em><%=temp.getAdjustmentMoney()%></em></li>
					   <%}%>
						<li>调增年度利润影响值:<em><%=info.getProfitEffectAdd()%></em></li>
				   <%}%>
				   <%if("0".equals(info.getWorkflowType())){%> 		
				   			<%if (!"新增费用调整".equals(info.getAdjustmentType())){%>
				   				<li>调减成本项:<em><!-- WFS_ADJUSTMENT_ITEM --><%=info.getMinusCostItem()%></em></li>
				   				<li style="color: red">调减信息</li>
				   				<%List<BudgeDataChildrenMinusBean> entities = info.getBudgeDataChildrenMinus();
				   				for (int i = 0 ;i < entities.size() ; i ++ ) {
				   					BudgeDataChildrenMinusBean temp = entities.get(i);%>
				   					<li <%=i==0?"":"class='line'" %>>调减科目:<em><%=temp.getAdjustmentSubjectMinus()%></em></li>
							   		<li>调减部门:<em><%=temp.getAdjustmentDeptMinus()%></em></li>
							   		<li>调整月份:<em><!-- WFS_MONTH --><%=temp.getAdjustmentMonthMinus()%></em></li>
							   		<li>调整金额:<em><%=temp.getAdjustmentMoneyMinus()%></em></li>
				   				<%} %>
				   				<li>调减年度利润影响值:<em><%=info.getProfitEffectMinus()%></em></li>
				   			<%} %>
				   <%}%>
				<li>申请事由:<em><%=info.getApplyReason()==null?"":info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>