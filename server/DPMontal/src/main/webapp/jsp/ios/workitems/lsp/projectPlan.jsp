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
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 WorkflowEntity temp = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 ProjectProgrammeVo info = temp.getProjectProgrammeVo();
 
 ProgrammingEntity entityPro = info.getProgrammingEntity();
 List<ProjectplanningTwo> two = info.getArticleLineEntityList();
 List<ProjectPlannintLineEntity> lineEntity = info.getPpEntityList();
 List<ProjectPlannintThree> three = info.getPpThreeList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目规划单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>计划编号:<em><%= entityPro.getfNumber() %></em></li>
			   	<li>计划编制人:<em><%= entityPro.getfFormationPeopleName() %></em></li>
			   	<li>创建部门:<em><%= entityPro.getfCreateorgName() %></em></li>
				<li>计划年份:<em><%= entityPro.getfPlanYear() == null ? "" : FormatUtil.formatDate(entityPro.getfPlanYear()) %></em></li>
			   	<li>版本号:<em><%= entityPro.getfVersionSnumber() %></em></li>
			   	
			   	<li>计划编制部门:<em><%= entityPro.getfPlanDepartmentName() %></em></li>
				<li>项目类型:<em><%= entityPro.getfProjectTypeName() %></em></li>
			   	<li>单据状态:<em><%= entityPro.getfState() %></em></li>
			   	<li>甲供材料模板:<em><%= entityPro.getfTemplateMaterialsName() == null ? "" :  entityPro.getfTemplateMaterialsName()%></em></li>
			    
          	</ul>
        </div>
        
        <h4 class="yellow">其他信息-项目规划</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < lineEntity.size(); i++ ) {%>
					<li  <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				    <li>所属工程部:<em><%= lineEntity.get(i).getfDepartmentName() == null ? "" : lineEntity.get(i).getfDepartmentName()%></em></li>
				    <li>施工类型:<em><%= lineEntity.get(i).getCfConstructTypeName() == null ? "" : lineEntity.get(i).getCfConstructTypeName()%></em></li>
				   	<li>1月数量:<em><%= lineEntity.get(i).getfJanuary() == null ? "" : lineEntity.get(i).getfJanuary()%></em></li>
			   		<li>2月数量:<em><%= lineEntity.get(i).getfFebruary() == null ? "" : lineEntity.get(i).getfFebruary()%></em></li>
		   			<li>3月数量:<em><%= lineEntity.get(i).getfMarch() == null ? "" : lineEntity.get(i).getfMarch()%></em></li>
	   				<li>4月数量:<em><%= lineEntity.get(i).getfApril() == null ? "" : lineEntity.get(i).getfApril()%></em></li>
   					<li>5月数量:<em><%= lineEntity.get(i).getfMay() == null ? "" : lineEntity.get(i).getfMay()%></em></li>
					<li>6月数量:<em><%= lineEntity.get(i).getfJune() == null ? "" : lineEntity.get(i).getfJune()%></em></li>
					<li>7月数量:<em><%= lineEntity.get(i).getfJuly() == null ? "" : lineEntity.get(i).getfJuly()%></em></li>
					<li>8月数量:<em><%= lineEntity.get(i).getfAugust() == null ? "" : lineEntity.get(i).getfAugust()%></em></li>
					<li>9月数量:<em><%= lineEntity.get(i).getfSeptember() == null ? "" : lineEntity.get(i).getfSeptember()%></em></li>
					<li>10月数量:<em><%= lineEntity.get(i).getfOctober() == null ? "" : lineEntity.get(i).getfOctober()%></em></li>
					<li>11月数量:<em><%= lineEntity.get(i).getfNovember() == null ? "" : lineEntity.get(i).getfNovember()%></em></li>
			   		<li>12月数量:<em><%= lineEntity.get(i).getfDecember() == null ? "" : lineEntity.get(i).getfDecember()%></em></li>									
				    <li>备注:<em><%= lineEntity.get(i).getfComment() == null ? "" : lineEntity.get(i).getfComment()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow">其他信息-物品明细</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < two.size(); i++ ) {%>
					<li  <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				   	<li>物品编码:<em><%= two.get(i).getfMateriallongId() == null ? "" : two.get(i).getfMateriallongId()%></em></li>
				    <li>物品名称:<em><%= two.get(i).getfMaterialName() == null ? "" : two.get(i).getfMaterialName()%></em></li>
				   	<li>物品类型:<em><%= two.get(i).getfMaterialType() == null ? "" : two.get(i).getfMaterialType()%></em></li>
				    <li>计划数量:<em><%= two.get(i).getfPlanQuantity() == null ? "" : two.get(i).getfPlanQuantity()%></em></li>
				    <li>计划单位:<em><%= two.get(i).getfUnits() == null ? "" : two.get(i).getfUnits()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow">其他信息-寻源类型</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < two.size(); i++ ) {%>
					<li  <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				   	<li>寻源类型:<em><%= three.get(i).getfSourcIngTypeName() == null ? "" : three.get(i).getfSourcIngTypeName()%></em></li>
				    <li>计划数量:<em><%= three.get(i).getfPlanAmount() == null ? "" : three.get(i).getfPlanAmount()%></em></li>
				   	<li>备注:<em><%= three.get(i).getfRemark() == null ? "" : three.get(i).getfRemark()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>