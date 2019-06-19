<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectclearVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectClearEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectClearEntryEntity"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
 ProjectclearVo temp = info.getProjectclearVo();
 List<ProjectClearEntity> base = temp.getBilllist();
 List<ProjectClearEntryEntity> items = temp.getEntryList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程项目结算单</td></tr>
	    		<% int size1 = base==null?0:base.size();
	    		   for(int i=0;i<size1;i++){
	    			   ProjectClearEntity entity = base.get(i);%>
	    		<tr><th>结算单编号:</th><td id="workid"><%=entity.getFnumber() %></td></tr>
	    		<tr><th>创建人:</th><td id="workid"><%=entity.getApplyPersonName() %></td></tr>
	    		<tr><th>创建部门:</th><td><%=entity.getApplyDeptName()%></td></tr>
				<tr><th>项目编号:</th><td><%=entity.getProjectcode()%></td></tr>
				<tr><th >工程项目名称:</th><td><%=entity.getCfprojectname()%></td></tr>
				<tr><th >结算日期:</th><td><%=FormatUtil.formatDate(entity.getCfbalancedate(), "yyyy-MM-dd")%></td></tr>
				<tr><th >合同编号:</th><td><%=entity.getCfcontractno()%></td></tr>
			   	<tr><th >合同名称:</th><td><%=entity.getCfcontractname()%></td></tr>
			   	<tr><th >所属子公司:</th><td><%=entity.getCfkaleidescope().getName()%></td></tr>
			   	<tr><th >合同版本号:</th><td><%=entity.getCfcontractversionnumber()%></td></tr>
			   	<tr><th >预算项目类型:</th><td><%=entity.getFbudgetname()%></td></tr>
			   	<tr><th >结算类型:</th><td><%=entity.getCfseetlementstypesName()%></td></tr>
			   	<tr><th >合同总金额:</th><td><%=entity.getCfcontractgrandtotal()%></td></tr>
			   	<tr><th >已支付金额:</th><td><%=entity.getCfalreadyamountpaid()%></td></tr>
			    <tr><th >已支付比例:</th><td><%=entity. getCfalreadypayscale()%></td></tr>
			    <tr><th >本次结算金额:</th><td><%=entity.getCfsettlementamount()%></td></tr>
			    <tr><th >本次结算比例:</th><td><%=entity.getCfpayscale()%></td></tr>
			    <tr><th >完成比:</th><td><%=entity.getCfpercentcomplete()%></td></tr>
			    <tr><th >公司财务组织:</th><td><%=entity.getFcompanyName()%></td></tr>
			    <tr><th >供应商:</th><td><%=entity.getFsupplierName()%></td></tr>
			    <tr><th >备注:</th><td><%=entity.getCfnote()%></td></tr>   
	    			   
	    		  <%}%>

				<tr class="yellow"><td colspan="2" >其他信息</td></tr>
				<%for(int i = 0; i < items.size(); i++ ) {
					ProjectClearEntryEntity en = items.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>费用承担部门:</th><td><%= en.getCfcostundertakedepName()%></td></tr>
				    <tr><th>费用比例:</th><td><%= en.getCfcostratio()%>%</td></tr>
				   	<tr><th>金额:</th><td><%= en.getCfsum()%></td></tr>
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