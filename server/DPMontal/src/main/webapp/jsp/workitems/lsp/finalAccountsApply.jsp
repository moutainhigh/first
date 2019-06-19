<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.FinalAccountVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.FinalAccountEntriesEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.FinalAccountEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style type="text/css">
		.otherInfo{
			display:none;
		}
	</style>
</head>
<body>
 <%
	//评标申请单
	FinalAccountVo info = (FinalAccountVo)request.getAttribute("lspResponseEntity");
 	/**
	 * 决算申请单主体实体
	 */
	FinalAccountEntity finalAccountEntity = info.getFinalAccountEntity();
	/**
	 * 决算申请单分录实体
	 */
	List<FinalAccountEntriesEntity> faEntriesList = info.getFaEntriesList();

 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>决算单申请</td></tr>
				<tr><th>单据编号:</th><td><%=finalAccountEntity.getfNumber()%></td></tr>
				<tr><th>申请时间:</th><td><%=FormatUtil.formatDate(finalAccountEntity.getfCreateTime(),"yyyy-MM-dd hh:mm:ss")%></td></tr>
				<tr><th>决算申请人:</th><td><%=finalAccountEntity.getfPersonnelName()%></td></tr>
				<tr><th>申请部门:</th><td><%=finalAccountEntity.getfCreatorgName()%></td></tr>
				<tr><th>项目编号:</th><td><%=finalAccountEntity.getCfProjectNumberName()%></td></tr>
				<tr><th>项目名称:</th><td><%=finalAccountEntity.getCfProjectName()%></td></tr>
				
				<tr><th>项目经理:</th><td><%=finalAccountEntity.getfPromanagerName()%></td></tr>
				<tr><th>申请金（元）:</th><td><%=FormatUtil.formatDouble("###,###,###.00",finalAccountEntity.getCfApplyAmount())%></td></tr>
				<tr><th>供应商:</th><td><%=finalAccountEntity.getCfSupplierName()%></td></tr>
				<tr><th>项目开始时间:</th><td><%=FormatUtil.formatDate(finalAccountEntity.getCfStartTime())%></td></tr>
				<tr><th>项目竣工时间:</th><td><%=FormatUtil.formatDate(finalAccountEntity.getCfStartDate())%></td></tr>
				
			    
				<tr class="yellow" id="otherInfo1Open" onclick="otherInfoOpen(1);"><td colspan="2">其他信息-分录信息</td></tr>
				
					<%//决算申请单分录实体 List<FinalAccountEntriesEntity> faEntriesList
					int faEntriesListSize = faEntriesList == null ? 0:faEntriesList.size();
					for(int i = 0; i < faEntriesListSize ; i++ ) {
						FinalAccountEntriesEntity obj1 = faEntriesList.get(i);
					%>
						<tr <%=i==0 ? "" : "class='topLine otherInfo tab1'" %> class="otherInfo tab1"><th>序号:</th><td><%=i+1 %></td></tr>
					   	<tr class="otherInfo tab1"><th>决算事项:</th><td><%= obj1.getCfMatterName()%></td></tr>
					    <tr class="otherInfo tab1"><th>验收情况:</th><td><%= obj1.getCfAcceptMatter()%></td></tr>
					   	<tr class="otherInfo tab1"><th>竣工档案:</th><td><%= obj1.getCfCompletelreCord()==null?"":obj1.getCfCompletelreCord()%></td></tr>
					    <tr class="otherInfo tab1"><th>备注:</th><td><%= obj1.getCfRemark() == null ? "":obj1.getCfRemark()%></td></tr>
				   <%} %>
				   <tr class="yellow" style="display: none" id="otherInfo1Close"  onclick="otherInfoClose(1);"><td colspan="2">关闭信息-分录信息</td></tr>
		  </table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
<script type="text/javascript">
function otherInfoClose(obj){
	$(".otherInfo.tab"+obj).hide();
	$("#otherInfo"+obj+"Close").hide();
}
function otherInfoOpen(obj){
	$(".otherInfo.tab"+obj).show();
	$("#otherInfo"+obj+"Close").show();
}
</script>
</body>
</html>