<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.ProjectSourceVo"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.ProjectSourceEntity"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.ProjectSourceEntryEntity"%>
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
 WorkflowSecondEntity info = (WorkflowSecondEntity)request.getAttribute("lspResponseEntity");
 ProjectSourceVo temp = info.getProjectSourceVo();
 List<ProjectSourceEntity> baseTemp = temp.getBilllist();
 List<ProjectSourceEntryEntity> items1 = temp.getEntryList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程寻源申请单</td></tr>
	    		<%for(int i = 0; i < baseTemp.size() ; i++ ) {
	    			ProjectSourceEntity base = baseTemp.get(i);
				%>
	    		<tr><th>需求单号:</th><td id="workid"><%=base.getFnumber()%></td></tr>
				<tr><th>申请部门:</th><td><%=base.getApplyDeptName()%></td></tr>
				<tr><th>申请时间:</th><td><%=base.getFcreatetimeStr()%></td></tr>
				<tr><th>申请人:</th><td><%=base.getApplyPersonName()%></td></tr>
				<tr><th>工程项目编号:</th><td><%=base.getProjectcode()%></td></tr>
			   	<tr><th>申请类型:</th><td><%=base.getFapplitypeidname()%></td></tr>
			   	<tr><th>工程项目名称:</th><td><%=base.getFprojectname()%></td></tr>
			   	<tr><th>项目级别:</th><td><%=base.getFprojectlevelname()%></td></tr>
			   	<tr><th>项目类型:</th><td><%=base.getFprojecttpyename()%></td></tr>
			   	<tr><th>施工类型:</th><td><%=base.getFconstructiontypeiname()%></td></tr>
			   	<tr><th>申请事项:</th><td><%=base.getFappliedmatteridname()%></td></tr>
			   	<tr><th>人数要求:</th><td><%=base.getFrequestsnoStr()%>&nbsp;&nbsp;人</td></tr>
			    <tr><th>注册资金:</th><td id="fregistcapitalID"><%=base.getFregistcapitalStr()%></td></tr>
				<tr><th>量单编码:</th><td><%=base.getFvolumecodidnum()%></td></tr>
			    <tr><th>期望寻源结束时间:</th><td><%=base.getFexpectendtimeStr()%></td></tr>
				<tr><th>期望交付时间:</th><td><%=base.getFexpdelitimeStr()%></td></tr>
			    <tr><th>概算金额:</th><td id="fbudgetamountID"><%=base.getFbudgetamountStr()%></td></tr>
				<tr><th>联系人:</th><td><%=base.getFcontactpersonidname()%></td></tr>
			    <tr><th>联系方式:</th><td><%=base.getFteleno()%></td></tr>
				<tr><th>面积:</th><td><%=base.getFmeasureareaStr()%>&nbsp;&nbsp;㎡</td></tr>
			    <tr><th>项目所在地:</th><td><%=base.getFprojectadd()%></td></tr>
				<tr><th colspan="2" class="yellow">寻源要求</th></tr>
	    		<tr><th>公司资质及人员要求:</th><td><%=base.getFcomquali()%></td></tr>
			    <tr><th>质量要求:</th><td><%=base.getFqualityrequire()%></td></tr>
				<tr><th>技术要求:</th><td><%=base.getFtechrequire()%></td></tr>
			    <tr><th>人员项目经验及奖项:</th><td><%=base.getFstaffproawards()%></td></tr>
				<tr><th>其他要求:</th><td><%=base.getFotherrequire()%></td></tr>
				 <%} %>

				<tr class="yellow"><td colspan="2" >其他信息-明细信息</td></tr>
				<%for(int i = 0; i < items1.size() ; i++ ) {
					ProjectSourceEntryEntity obj1 = items1.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>物品编码:</th><td><%= obj1.getFgoodscoding()%></td></tr>
				    <tr><th>物品名称:</th><td><%= obj1.getFitemnameidname()%></td></tr>
				   	<tr><th>物品类型:</th><td><%= obj1.getFitemtype()%></td></tr>
				    <tr><th>物品规格:</th><td><%= obj1.getFprodspecifi()%></td></tr>
				    <tr><th>计量单位:</th><td><%= obj1.getFunit()%></td></tr>
				   	<tr><th>数量:</th><td><%= obj1.getFamountStr()%></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getFcomment()%></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb2.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
<script type="text/javascript">
	$(function(){
		myChageFormate(" 元","fregistcapitalID");
		myChageFormate(" 以上","fbudgetamountID");
	});
	function myChageFormate(Str,id) {
		var num = $("#" + id);
		for (var i = 0;i < num.length;i ++ ) {
			if ($(num[i]).text() == "") {
				$(num[i]).text("");
			}else {
				var valueTempInt = $(num[i]).text();
				var valueTempFolat;
				var indexNum = valueTempInt.indexOf(".");
				if (indexNum > -1) {
					valueTempFolat = valueTempInt.substring(indexNum+1,valueTempInt.length);
					valueTempInt = valueTempInt.substring(0,indexNum);
					valueTempInt = valueTempInt.replace(/\d+?(?=(?:\d{3})+$)/img, "$&,");
					if (valueTempFolat) {
						valueTempInt += "." + valueTempFolat;
					}
				}else {
					valueTempInt = valueTempInt.replace(/\d+?(?=(?:\d{3})+$)/img, "$&,");
				}
				$(num[i]).text(valueTempInt + Str);
			}
		}
	};
</script>
</body>
</html>