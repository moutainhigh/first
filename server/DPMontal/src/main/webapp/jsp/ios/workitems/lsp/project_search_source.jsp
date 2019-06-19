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
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 WorkflowSecondEntity info = (WorkflowSecondEntity)request.getAttribute("lspResponseEntity");
 ProjectSourceVo temp = info.getProjectSourceVo();
 List<ProjectSourceEntity> baseTemp = temp.getBilllist();
 List<ProjectSourceEntryEntity> items1 = temp.getEntryList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>工程寻源申请单</em></li>
	    		<%for(int i = 0; i < baseTemp.size() ; i++ ) {
	    			ProjectSourceEntity base = baseTemp.get(i);
				%>
	    		<li>需求单号:<em><%=base.getFnumber()%></em></li>
				<li>申请部门:<em><%=base.getApplyDeptName()%></em></li>
				<li>申请时间:<em><%=base.getFcreatetimeStr()%></em></li>
				<li>申请人:<em><%=base.getApplyPersonName()%></em></li>
				<li>工程项目编号:<em><%=base.getProjectcode()%></em></li>
			   	<li>申请类型:<em><%=base.getFapplitypeidname()%></em></li>
			   	<li>工程项目名称:<em><%=base.getFprojectname()%></em></li>
			   	<li>项目级别:<em><%=base.getFprojectlevelname()%></em></li>
			   	<li>项目类型:<em><%=base.getFprojecttpyename()%></em></li>
			   	<li>施工类型:<em><%=base.getFconstructiontypeiname()%></em></li>
			   	<li>申请事项:<em><%=base.getFappliedmatteridname()%></em></li>
			   	<li>人数要求:<em><%=base.getFrequestsnoStr()%>&nbsp;&nbsp;</em>人</li>
			    <li>注册资金:<em id="fregistcapitalID"><%=base.getFregistcapitalStr()%></em></li>
				<li>量单编码:<em><%=base.getFvolumecodidnum()%></em></li>
			    <li>期望寻源结束时间:<em><%=base.getFexpectendtimeStr()%></em></li>
				<li>期望交付时间:<em><%=base.getFexpdelitimeStr()%></em></li>
			    <li>概算金额:<em id="fbudgetamountID"><%=base.getFbudgetamountStr()%></em></li>
				<li>联系人:<em><%=base.getFcontactpersonidname()%></em></li>
			    <li>联系方式:<em><%=base.getFteleno()%></em></li>
				<li>面积:<em><%=base.getFmeasureareaStr()%>&nbsp;&nbsp;㎡</em></li>
			    <li>项目所在地:<em><%=base.getFprojectadd()%></em></li>
			    <li><em class="yellow">寻源要求</em></li>
	    		<li>公司资质及人员要求:<em><%=base.getFcomquali()%></em></li>
			    <li>质量要求:<em><%=base.getFqualityrequire()%></em></li>
				<li>技术要求:<em><%=base.getFtechrequire()%></em></li>
			    <li>人员项目经验及奖项:<em><%=base.getFstaffproawards()%></em></li>
				<li>其他要求:<em><%=base.getFotherrequire()%></em></li>
				 <%} %>
          	</ul>
        </div>
        <h4 class="yellow">其他信息--明细信息</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < items1.size() ; i++ ) {
					ProjectSourceEntryEntity obj1 = items1.get(i);
				%>
					<li   <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				   	<li>物品编码:<em><%= obj1.getFgoodscoding()%></em></li>
				    <li>物品名称:<em><%= obj1.getFitemnameidname()%></em></li>
				   	<li>物品类型:<em><%= obj1.getFitemtype()%></em></li>
				    <li>物品规格:<em><%= obj1.getFprodspecifi()%></em></li>
				    <li>计量单位:<em><%= obj1.getFunit()%></em></li>
				   	<li>数量:<em><%= obj1.getFamountStr()%></em></li>
				    <li>备注:<em><%= obj1.getFcomment()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb2.jsp"%> 
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