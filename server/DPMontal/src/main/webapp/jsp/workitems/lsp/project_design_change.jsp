<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectDesignChangeVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.DesignChangeVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.DesignChangeEntryVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.DesignChangee2Vo"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 ProjectDesignChangeVo temp = info.getProjectDesignChangeVo();
 DesignChangeVo base = temp.getDesignChangeVo();
 List<DesignChangeEntryVo> items1 = temp.getDesignChangeEntryVo();
 List<DesignChangee2Vo> items2 = temp.getDesignChagee2Vo();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>项目设计变更单</td></tr>
	    		<tr><th>变更单号:</th><td id="workid"><%=base.getNumber()%></td></tr>
				<tr><th>项目编号:</th><td><%=base.getProjectNumber()%></td></tr>
				<tr><th>项目名称:</th><td><%=base.getProjectName()%></td></tr>
				<tr><th>原设计单号:</th><td><%=base.getSourceBillNumber()%></td></tr>
				<tr><th>单据状态:</th><td><%=base.getStateName()%></td></tr>
			   	<tr><th>申请部门:</th><td><%=base.getCreatorGName()%></td></tr>
			   	<tr><th>变更发起人:</th><td><%=base.getChangeSponsorName()%></td></tr>
			   	<tr><th>变更原因:</th><td><%=base.getReasonChangeDesc()%></td></tr>
			   	<tr><th>设计总面积（单位：M2）:</th><td class="floatForm"><%=base.getDesiginAreaStr()%></td></tr>
			   	<tr><th>变更前概算费用:</th><td class="floatForm"><%=base.getChangeEstimateCostStr()%></td></tr>
			   	<tr><th>设计部门:</th><td><%=base.getDesignDempName()%></td></tr>
			   	<tr><th>施工负责部门:</th><td><%=base.getConstructDepartmName()%></td></tr>
			    <tr><th>变更概算费用:</th><td class="floatForm"><%=base.getChangeCostStr()%></td></tr>
			    <tr><th>变更类型:</th><td><%=base.getChangeName()%></td></tr>
			    <tr><th>变更后设计难度:</th><td><%=base.getChangeDesignDifficulty()%></td></tr>
			    <tr><th>具体描述:</th><td><%=base.getSpecificDescribe()%></td></tr>

				<tr class="yellow"  ><td colspan="2">其他信息-变更明细</td></tr>
				<%for(int i = 0; i < items1.size() ; i++ ) {
					DesignChangeEntryVo obj1 = items1.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=obj1.getSeqStr() %></td></tr>
				   	<tr><th>图纸名称:</th><td><%= obj1.getDrawingName()%></td></tr>
				    <tr><th>设计日期:</th><td><%= obj1.getDesignDateStr()%></td></tr>
				   	<tr><th>设计负责人:</th><td><%= obj1.getDesignResponsiblName()%></td></tr>
				    <tr><th>设计项目名称:</th><td><%= obj1.getDesProName()%></td></tr>
				    <tr><th>单位:</th><td><%= obj1.getUnitName()%></td></tr>
				    <tr><th>数量:</th><td class="floatForm"><%= obj1.getAmountStr()%></td></tr>
				    <tr><th>占比:</th><td class="floatForm"><%= obj1.getProportionStr()%></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getNote()%></td></tr>
			   <%} %>
			   <tr class="yellow" ><td colspan="2" >其他信息-概算情况</td></tr>
				<%for(int i = 0; i < items2.size(); i++ ) {
					DesignChangee2Vo obj2 = items2.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=obj2.getSeqStr() %></td></tr>
				   	<tr><th>费用名称:</th><td><%= obj2.getExpenseName()%></td></tr>
				    <tr><th>费用类型:</th><td><%= obj2.getExpenseTypeName()%></td></tr>
				   	<tr><th>核算金额:</th><td class="floatForm"><%= obj2.getBudgetAmountStr()%></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">
	var num = $(".floatForm");
	for (var i = 0;i < num.length;i ++ ) {
		if ($(num[i]).text() == "") {
			$(num[i]).text("");
		}else {
			var valueTemp = parseFloat($(num[i]).text());
			$(num[i]).text(valueTemp);
		}
	}
</script>
</body>
</html>