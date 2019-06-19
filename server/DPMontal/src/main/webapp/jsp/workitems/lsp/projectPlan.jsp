<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>

<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProgrammingEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectplanningTwo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectPlannintLineEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectPlannintThree"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectProgrammeVo"%>
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
 
 WorkflowEntity temp = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 ProjectProgrammeVo info = temp.getProjectProgrammeVo();
 ProgrammingEntity entity = info.getProgrammingEntity();
 List<ProjectplanningTwo> two = info.getArticleLineEntityList();
 List<ProjectPlannintLineEntity> lineEntity = info.getPpEntityList();
 List<ProjectPlannintThree> three = info.getPpThreeList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程项目规划单</td></tr>
	    		<tr><th>计划编号:</th><td id="workid"><%= entity.getfNumber() %></td></tr>
			   	<tr><th>计划编制人:</th><td><%= entity.getfFormationPeopleName() %></td></tr>
			   	<tr><th>创建部门:</th><td><%= entity.getfCreateorgName() %></td></tr>
				<tr><th>计划年份:</th><td><%= entity.getfPlanYear() == null ? "" : FormatUtil.formatDate(entity.getfPlanYear()) %></td></tr>
			   	<tr><th>版本号:</th><td><%= entity.getfVersionSnumber() %></td></tr>
			   	
			   	<tr><th>计划编制部门:</th><td><%= entity.getfPlanDepartmentName() %></td></tr>
				<tr><th>项目类型:</th><td><%= entity.getfProjectTypeName() %></td></tr>
			   	<tr><th>单据状态:</th><td><%= entity.getfState() %></td></tr>
			   	<tr><th>甲供材料模板:</th><td><%= entity.getfTemplateMaterialsName() == null ? "" :  entity.getfTemplateMaterialsName()%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息-项目规划</td></tr>
				<%for(int i = 0; i < lineEntity.size(); i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>所属工程部:</th><td><%= lineEntity.get(i).getfDepartmentName() == null ? "" : lineEntity.get(i).getfDepartmentName()%></td></tr>
				    <tr><th>施工类型:</th><td><%= lineEntity.get(i).getCfConstructTypeName() == null ? "" : lineEntity.get(i).getCfConstructTypeName()%></td></tr>
				   	<tr><th>1月数量:</th><td><%= lineEntity.get(i).getfJanuary() == null ? "" : lineEntity.get(i).getfJanuary()%></td></tr>
				   	<tr><th>2月数量:</th><td><%= lineEntity.get(i).getfFebruary() == null ? "" : lineEntity.get(i).getfFebruary()%></td></tr>
				   	<tr><th>3月数量:</th><td><%= lineEntity.get(i).getfMarch() == null ? "" : lineEntity.get(i).getfMarch()%></td></tr>
				   	<tr><th>4月数量:</th><td><%= lineEntity.get(i).getfApril() == null ? "" : lineEntity.get(i).getfApril()%></td></tr>
				   	<tr><th>5月数量:</th><td><%= lineEntity.get(i).getfMay() == null ? "" : lineEntity.get(i).getfMay()%></td></tr>
				   	<tr><th>6月数量:</th><td><%= lineEntity.get(i).getfJune() == null ? "" : lineEntity.get(i).getfJune()%></td></tr>
				   	<tr><th>7月数量:</th><td><%= lineEntity.get(i).getfJuly() == null ? "" : lineEntity.get(i).getfJuly()%></td></tr>
				   	<tr><th>8月数量:</th><td><%= lineEntity.get(i).getfAugust() == null ? "" : lineEntity.get(i).getfAugust()%></td></tr>
				   	<tr><th>9月数量:</th><td><%= lineEntity.get(i).getfSeptember() == null ? "" : lineEntity.get(i).getfSeptember()%></td></tr>
				   	<tr><th>10月数量:</th><td><%= lineEntity.get(i).getfOctober() == null ? "" : lineEntity.get(i).getfOctober()%></td></tr>
				   	<tr><th>11月数量:</th><td><%= lineEntity.get(i).getfNovember() == null ? "" : lineEntity.get(i).getfNovember()%></td></tr>
				   	<tr><th>12月数量:</th><td><%= lineEntity.get(i).getfDecember() == null ? "" : lineEntity.get(i).getfDecember()%></td></tr>
				    <tr><th>备注:</th><td><%= lineEntity.get(i).getfComment() == null ? "" : lineEntity.get(i).getfComment()%></td></tr>
			   <%} %>
			   
			   <tr class="yellow"><td colspan="2" >其他信息-物品明细</td></tr>
				<%for(int i = 0; i < two.size(); i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>物品编码:</th><td><%= two.get(i).getfMateriallongId() == null ? "" : two.get(i).getfMateriallongId()%></td></tr>
				    <tr><th>物品名称:</th><td><%= two.get(i).getfMaterialName() == null ? "" : two.get(i).getfMaterialName()%></td></tr>
				   	<tr><th>物品类型:</th><td><%= two.get(i).getfMaterialType() == null ? "" : two.get(i).getfMaterialType()%></td></tr>
				    <tr><th>计划数量:</th><td><%= two.get(i).getfPlanQuantity() == null ? "" : two.get(i).getfPlanQuantity()%></td></tr>
				    <tr><th>计划单位:</th><td><%= two.get(i).getfUnits() == null ? "" : two.get(i).getfUnits()%></td></tr>
			   <%} %>
			   
			   <tr class="yellow"><td colspan="2" >其他信息-寻源类型</td></tr>
				<%for(int i = 0; i < three.size(); i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>寻源类型:</th><td><%= three.get(i).getfSourcIngTypeName() == null ? "" : three.get(i).getfSourcIngTypeName()%></td></tr>
				    <tr><th>计划数量:</th><td><%= three.get(i).getfPlanAmount() == null ? "" : three.get(i).getfPlanAmount()%></td></tr>
				   	<tr><th>备注:</th><td><%= three.get(i).getfRemark() == null ? "" : three.get(i).getfRemark()%></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">

</script>
</body>
</html>