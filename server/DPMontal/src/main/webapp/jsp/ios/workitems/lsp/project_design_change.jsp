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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
				<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>项目设计变更单</em></li>
	    		<li>变更单号:<em><%=base.getNumber()%></em></li>
				<li>项目编号:<em><%=base.getProjectNumber()%></em></li>
				<li>项目名称:<em><%=base.getProjectName()%></em></li>
				<li>原设计单号:<em><%=base.getSourceBillNumber()%></em></li>
				<li>单据状态:<em><%=base.getStateName()%></em></li>
			   	<li>申请部门:<em><%=base.getCreatorGName()%></em></li>
			   	<li>变更发起人:<em><%=base.getChangeSponsorName()%></em></li>
			   	<li>变更原因:<em><%=base.getReasonChangeDesc()%></em></li>
			   	<li>设计总面积（单位：M2）:<em class="floatForm"><%=base.getDesiginAreaStr()%></em></li>
			   	<li>变更前概算费用:<em class="floatForm"><%=base.getChangeEstimateCostStr()%></em></li>
			   	<li>设计部门:<em><%=base.getDesignDempName()%></em></li>
			   	<li>施工负责部门:<em><%=base.getConstructDepartmName()%></em></li>
			    <li>变更概算费用:<em class="floatForm"><%=base.getChangeCostStr()%></em></li>
			    <li>变更类型:<em><%=base.getChangeName()%></em></li>
			    <li>变更后设计难度:<em><%=base.getChangeDesignDifficulty()%></em></li>
			    <li>具体描述:<em><%=base.getSpecificDescribe()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息-变更明细</h4>
	   	<div class="ulBox2">
    		<ul>
			   <%for(int i = 0; i < items1.size() ; i++ ) {
					DesignChangeEntryVo obj1 = items1.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=obj1.getSeqStr() %></em></li>
				   	<li>图纸名称:<em><%= obj1.getDrawingName()%></em></li>
				    <li>设计日期:<em><%= obj1.getDesignDateStr()%></em></li>
				   	<li>设计负责人:<em><%= obj1.getDesignResponsiblName()%></em></li>
				    <li>设计项目名称:<em><%= obj1.getDesProName()%></em></li>
				    <li>单位:<em><%= obj1.getUnitName()%></em></li>
				    <li>数量:<em class="floatForm"><%= obj1.getAmountStr()%></em></li>
				    <li>占比:<em class="floatForm"><%= obj1.getProportionStr()%></em></li>
				    <li>备注:<em><%= obj1.getNote()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow">其他信息-概算情况</h4>
	   	<div class="ulBox2">
    		<ul>
			  <%for(int i = 0; i < items2.size(); i++ ) {
					DesignChangee2Vo obj2 = items2.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=obj2.getSeqStr() %></em></li>
				   	<li>费用名称:<em><%= obj2.getExpenseName()%></em></li>
				    <li>费用类型:<em><%= obj2.getExpenseTypeName()%></em></li>
				   	<li>核算金额:<em class="floatForm"><%= obj2.getBudgetAmountStr()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
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