<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ComUtil"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectApplyVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectApplyEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectApplyEntity	"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectApplyE4Entity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectApplyE3Entity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectApplyE2Entity"%>
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
 ProjectApplyVo info = (ProjectApplyVo)request.getAttribute("lspResponseEntity");
 ProjectApplyEntity entityPro = info.getBilll();
 List<ProjectApplyE3Entity> three = info.getEntryList3();
 List<ProjectApplyE2Entity> two = info.getEntryList2();
 List<ProjectApplyE4Entity> four = info.getEntryList4();
 //办公人员明细
 List<ProjectApplyEntryEntity> five = info.getEntryList();
 
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>		
	    		<tr><th colspan="2" class="yellow">基本信息-工程项目申请单</th></tr>		  
	    		<tr><th>项目单号:</th><td><%= entityPro.getFnumber() %></td></tr>
			   	<tr><th>申请人:</th><td><%= entityPro.getFlistperson().getName() %></td></tr>
			   	<tr><th>申请时间:</th><td><%= entityPro.getFbizdate()  == null ? "" : FormatUtil.formatDate(entityPro.getFbizdate(),"yyyy-MM-dd hh:mm:ss")%></td></tr>
				<tr><th>申请部门:</th><td><%= entityPro.getFpersondept().getName()%></td></tr>
			   	<tr><th>单据状态:</th><td><%= entityPro.getFstate()==null?"": entityPro.getFstate()%></td></tr>
			   	<tr><th>项目名称:</th><td><%= entityPro.getCfprojectname() %></td></tr>
			   	<tr><th>项目类型:</th><td><%= entityPro.getCfprojecttype() %></td></tr>
			   	<tr><th>施工类型:</th><td><%= entityPro.getFconttype() %></td></tr>
				<tr><th>所属区域:</th><td><%= entityPro.getCfregion().getName()%></td></tr>
			   	<tr><th>所属事业部:</th><td><%= entityPro.getCfbusinessdivisionName().getName() %></td></tr>
			   	<tr><th>所属子公司:</th><td><%= entityPro.getCfkaleidescope().getName()%></td></tr>
			   	<tr><th>项目所在地:</th><td><%= entityPro.getCfprojectplace()==null?"":entityPro.getCfprojectplace() %></td></tr>
				<tr><th>项目负责部门:</th><td><%= entityPro.getCfprojectdepartmenName()==null?"":entityPro.getCfprojectdepartmenName().getName()%></td></tr>
			   	<tr><th>项目经理:</th><td><%= entityPro.getCfprojectmanager()==null?"":entityPro.getCfprojectmanager().getName() %></td></tr>
			   	
			   	<% if("网点".equals(entityPro.getCfprojecttype())) {%>
			   	<tr><th>计划网点年份:</th><td><%= entityPro.getCfplanyear() %></td></tr>
			   	<%}else{%>
			   		<tr><th>非网点分类:</th><td><%= entityPro.getCfbranchtype().getSimpleChinese() %></td></tr>
			   		<tr><th>项目级别:</th><td><%= entityPro.getCfprojectlevel() %></td></tr>
			   	<%}%>
			   	<tr><th>备注:</th><td><%= entityPro.getFremake()==null?"":entityPro.getFremake() %></td></tr>
			   	
			   	<%
			   	String cfdeependesign = entityPro.getCfdeependesign()==null?"":entityPro.getCfdeependesign().toString();
			   	if ("1".equals(cfdeependesign)) { %>
			    	<tr><th><input type="checkbox" checked="checked" disabled="disabled"/>是否深化设计</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" disabled="disabled"/>是否计划外采购</th></tr>
				<%}%>
				<%
				String cfyard = entityPro.getCfyard()==null?"":entityPro.getCfyard().toString();
				if ("1".equals(cfyard)) { %>
			    	<tr><th><input type="checkbox" checked="checked" disabled="disabled"/>场地</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" disabled="disabled"/>场地</th></tr>
				<%}%>
				<%
				String cfparea = entityPro.getCfparea()==null?"":entityPro.getCfparea().toString();
				if ("1".equals(cfparea)) { %>
			    	<tr><th><input type="checkbox" checked="checked"disabled="disabled"/>区域</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" disabled="disabled"/>区域</th></tr>
				<%}%>
				<%
				if("网点".equals(entityPro.getCfprojecttype())){
				String cfIsNationalSupplier = entityPro.getCfIsNationalSupplier()==null?"":entityPro.getCfIsNationalSupplier().toString();
				if ("1".equals(cfIsNationalSupplier)) { %>
			    	<tr><th><input type="checkbox" checked="checked"disabled="disabled"/>是否全国供应商</th></tr>
				<%} else { %>
					<tr><th><input type="checkbox" disabled="disabled"/>是否全国供应商</th></tr>
				<%}	}%>
			   	
			   	<% if("网点".equals(entityPro.getCfprojecttype())) {%>
			   		<tr class="yellow" id="otherInfo1Open" onclick="otherInfoOpen(1);"><td colspan="2">其他信息-店面定位及需求</td></tr>
        		<tbody style="display: none" class="otherInfo tab1">
					<tr><th>业务类型:</th><td>
					<%
					String cfstart = entityPro.getCfstart()==null?"":entityPro.getCfstart().toString();
					if ("1".equals(cfstart)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>出发
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>出发
					<%}%>
					<%
					String cfsend = entityPro.getCfsend()==null?"":entityPro.getCfsend().toString();
					if ("1".equals(cfsend)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>派送
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>派送
					<%}%>
					<%
					String cftake = entityPro.getCftake()==null?"":entityPro.getCftake().toString();
					if ("1".equals(cftake)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>自提
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>自提
					<%}%>
					<%
					String cfreceipt = entityPro.getCfreceipt()==null?"":entityPro.getCfreceipt().toString();
					if ("1".equals(cfreceipt)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>集中接货
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>集中接货
					<%}%>
				</td></tr>
			   	<tr><th>货物类型:</th><td>
			   		<%
			   		String cflightcargo = entityPro.getCflightcargo()==null?"":entityPro.getCflightcargo().toString();
			   		if ("1".equals(cflightcargo)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>泡货
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>泡货
					<%}%>
					<%
					String cfheavycargo = entityPro.getCfheavycargo()==null?"":entityPro.getCfheavycargo().toString();
					if ("1".equals(cfheavycargo)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>重货
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>重货
					<%}%>
			   	</td></tr>
			   	<tr><th>仓库需求:<td>
			   		<%
			   		String fforkliftscales = entityPro.getFforkliftscales()==null?"":entityPro.getFforkliftscales().toString();
			   		if ("1".equals(fforkliftscales)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>外场需求提货
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>外场需求提货
					<%}%>
					<%
					String cfoutdoor = entityPro.getCfoutdoor()==null?"":entityPro.getCfoutdoor().toString();
					if ("1".equals(cfoutdoor)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>外场柜台需要强弱电位
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>外场柜台需要强弱电位
					<%}%>
					<%
					String cfweighbridge = entityPro.getCfweighbridge()==null?"":entityPro.getCfweighbridge().toString();
					if ("1".equals(cfweighbridge)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>地磅
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>地磅
					<%}%>
					<%
					String cfelectronic = entityPro.getCfelectronic()==null?"":entityPro.getCfelectronic().toString();
					if ("1".equals(cfelectronic)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>电子秤
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>电子秤
					<%}%>
					<%
					String cfouttake = entityPro.getCfouttake()==null?"":entityPro.getCfouttake().toString();
					if ("1".equals(cfouttake)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>叉车秤
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>叉车秤
					<%}%>
			   	</td></tr>
				<tr><th>生活配套需求:</th><td>
					<%
					String cfwashroom = entityPro.getCfwashroom()==null?"":entityPro.getCfwashroom().toString();
					if ("1".equals(cfwashroom)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>卫生间
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>卫生间
					<%}%>
					<%
					String cfbreedroom = entityPro.getCfbreedroom()==null?"":entityPro.getCfbreedroom().toString();
					if ("1".equals(cfbreedroom)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>宿舍
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>宿舍
					<%}%>
				</td></tr>
			   	<tr><th>其他需求:</th><td>
			   		<%
			   		String cfconferenceroom = entityPro.getCfconferenceroom()==null?"":entityPro.getCfconferenceroom().toString();
			   		if ("1".equals(cfconferenceroom)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>会议
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>会议
					<%}%>
					<%
					String cfservicearea = entityPro.getCfservicearea()==null?"":entityPro.getCfservicearea().toString();
					if ("1".equals(cfservicearea)) { %>
			    	<input type="checkbox" checked="checked"disabled="disabled"/>客服办公室
					<%} else { %>
					<input type="checkbox" disabled="disabled"/>客服办公室
					<%}%>
			   	</td></tr>
			   	<tr><th>营业厅办公需求:</th><td>柜台<%= entityPro.getCfcounter() %>位   &nbsp;打印机配置<%= entityPro.getCfmarking() %>台</td></tr>
			   	<tr><th>备注:</th><td><%= entityPro.getCfremark()==null?"":entityPro.getCfremark()%></td></tr>
			 	<tr class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);"><td colspan="2">关闭店面定位及需求</td></tr>
			 </tbody>
			   	<%}else{%>
		<tr class="yellow" id="otherInfo2pen" onclick="otherInfoOpen(2);"><td colspan="2">其他信息-资源描述</td></tr>
		<tbody style="display: none" class="otherInfo tab2">
				  <%for(int i = 0; i < three.size() ; i++ ) {
					  ProjectApplyE3Entity obj1 = three.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>主控事项:</th><td><%= obj1.getCfmatter().getName()%></td></tr>
				    <tr><th>主控细项:</th><td><%= obj1.getCfminutess().getName()%></td></tr>
				   	<tr><th>评判结果:</th><td><%= obj1.getCfjudgeResult()%></td></tr>
				    <tr><th>备注说明:</th><td><%= obj1.getCfremark()%></td></tr>
			   <%} %>
		<tr class="yellow" style="display: none" id="otherInfo2Close"  onclick="otherInfoClose(2);"><td colspan="2">关闭资源描述</td></tr>
		</tbody>
		<tr class="yellow" id="otherInfo3Open"  onclick="otherInfoOpen(3);"><td colspan="2">其他信息-办公人员明细</td></tr>
		<tbody style="display: none" class="otherInfo tab3">
				  <%for(int i = 0; i < five.size() ; i++ ) {
					  ProjectApplyEntryEntity obj1 = five.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>部门:</th><td><%= obj1.getCfuseDepartment()%></td></tr>
				    <tr><th>岗位:</th><td><%= obj1.getCfstation()==null?"":obj1.getCfstation()%></td></tr>
				   	<tr><th>现状（人数）:</th><td><%= obj1.getCfnumberOfPeopleDto()%></td></tr>
				    <tr><th>现状（办公卡位）:</th><td><%= obj1.getCfcurrentofficenumDto()%></td></tr>
				    <tr><th>明年（人数）:</th><td><%= obj1.getCfnewNumberPeopleDto()%></td></tr>
				    <tr><th>明年（办公卡位）:</th><td><%= obj1.getCfnextofficenumDto()%></td></tr>
				    <tr><th>后年（人数）:</th><td><%= obj1.getPeopleNumberDto()%></td></tr>
				    <tr><th>后年（办公卡位）:</th><td><%= obj1.getCfafternextoffnumDto()%></td></tr>
				    <tr><th>办单窗口数:</th><td><%= obj1.getCfwindownumDto()%></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getCfremark()%></td></tr>
			   <%} %>
		 <tr class="yellow" style="display: none" id="otherInfo3Close"  onclick="otherInfoClose(3);"><td colspan="2">关闭办公人员明细</td></tr>
    	</tbody>
    	 <tr class="yellow" id="otherInfo4Open" onclick="otherInfoOpen(4);"><td colspan="2">其他信息-车辆配套明细</td></tr>
    	 <tbody style="display: none" class="otherInfo tab4">
				  <%for(int i = 0; i < two.size() ; i++ ) {
					  ProjectApplyE2Entity obj1 = two.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>车型:</th><td><%= obj1.getCfproject().getNameChinese()%></td></tr>
				    <tr><th>现状:</th><td><%= obj1.getCfthisYearDto()%></td></tr>
				   	<tr><th>明年:</th><td><%= obj1.getCfnextYearDto()%></td></tr>
				    <tr><th>后年:</th><td><%= obj1.getCfendYearDto()%></td></tr>
				    <tr><th>计量单位:</th><td><%= obj1.getFunits().getName()%></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getCfremark()%></td></tr>
			   <%} %>
		 <tr class="yellow" style="display: none" id="otherInfo4Close" onclick="otherInfoClose(4);"><td colspan="2">关闭车辆配套明细</td></tr>
		</tbody>
    	 <tr class="yellow" id="otherInfo5Open"  onclick="otherInfoOpen(5);"><td colspan="2">其他信息-办公配套明细</td></tr>
    	 <tbody style="display: none" class="otherInfo tab5">
				  <%for(int i = 0; i < four.size() ; i++ ) {
					  ProjectApplyE4Entity obj1 = four.get(i);
				%>
					<tr <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr><th>配套名称:</th><td><%= obj1.getCfpackageName().getName()%></td></tr>
				    <tr><th>现状:</th><td><%= obj1.getCfcurrentNum()%></td></tr>
				   	<tr><th>明年:</th><td><%= obj1.getCfnextNum()%></td></tr>
				    <tr><th>后年:</th><td><%= obj1.getCfafterNextNum()%></td></tr>
				    <tr><th>计量单位:</th><td><%= obj1.getCfunit().getName()%></td></tr>
				    <tr><th>备注:</th><td><%= obj1.getCfcommon()%></td></tr>
			   <%} %>
		 <tr class="yellow" style="display: none" id="otherInfo5Close"  onclick="otherInfoClose(5);"><td colspan="2">关闭办公配套明细</td></tr>
		 </tbody>
		 <%}%>
		</table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
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
</html>