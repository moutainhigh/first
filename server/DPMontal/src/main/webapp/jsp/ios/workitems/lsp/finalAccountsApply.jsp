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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-决算单申请</h4>
    	<div class="ulBox2">
	    	<ul>				  
			   	<li>单据编号:<em><%=finalAccountEntity.getfNumber()%></em></li>
				<li>申请时间:<em><%=FormatUtil.formatDate(finalAccountEntity.getfCreateTime(),"yyyy-MM-dd hh:mm:ss")%></em></li>
				<li>决算申请人:<em><%=finalAccountEntity.getfPersonnelName()%></em></li>
				<li>申请部门:<em><%=finalAccountEntity.getfCreatorgName()%></em></li>
				<li>项目编号:<em><%=finalAccountEntity.getCfProjectNumberName()%></em></li>
				<li>项目名称:<em><%=finalAccountEntity.getCfProjectName()%></em></li>
				
				<li>项目经理:<em><%=finalAccountEntity.getfPromanagerName()%></em></li>
				<li>申请金（元）:<em><%=FormatUtil.formatDouble("###,###,###.00",finalAccountEntity.getCfApplyAmount())%></em></li>
				<li>供应商:<em><%=finalAccountEntity.getCfSupplierName()%></em></li>
				<li>项目开始时间:<em><%=FormatUtil.formatDate(finalAccountEntity.getCfStartTime())%></em></li>
				<li>项目竣工时间:<em><%=FormatUtil.formatDate(finalAccountEntity.getCfStartDate())%></em></li>
          	</ul>
        </div>
        <h4 class="yellow" onclick="otherInfoOpen(1);">其他信息-分录信息</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
    		//决算申请单分录实体 List<FinalAccountEntriesEntity> faEntriesList
			int faEntriesListSize = faEntriesList == null ? 0:faEntriesList.size();
			for(int i = 0; i < faEntriesListSize ; i++ ) {
				FinalAccountEntriesEntity obj1 = faEntriesList.get(i);
			%>
			<li <%=i==0?"class='first otherInfo tab1'":"class='line otherInfo tab1'" %>>序号:<em><%=i+1 %></em></li>
			<li class="otherInfo tab1">决算事项:<em><%= obj1.getCfMatterName()%></em></li>
			<li class="otherInfo tab1">验收情况:<em><%= obj1.getCfAcceptMatter()%></em></li>
			<li class="otherInfo tab1">竣工档案:<em><%= obj1.getCfCompletelreCord()==null?"":obj1.getCfCompletelreCord()%></em></li>
			<li class="otherInfo tab1">备注:<em><%= obj1.getCfRemark() == null ? "":obj1.getCfRemark()%></em></li>
		<%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);">关闭信息-分录信息</h4>
	    <%@include file="approve_process_esb3.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
<script type="text/javascript">
function otherInfoClose(obj){
	$(".otherInfo.tab"+obj).slideUp(200);
	$("#otherInfo"+obj+"Close").slideUp(200);
}
function otherInfoOpen(obj){
	$(".otherInfo.tab"+obj).slideDown(200);
	$("#otherInfo"+obj+"Close").slideDown(200);
}
</script>
</html>