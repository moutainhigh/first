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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目申请单</h4>
    	<div class="ulBox2">
	    	<ul>				  
			   	<li>项目单号:<em><%= entityPro.getFnumber() %></em></li>
			   	<li>申请人:<em><%= entityPro.getFlistperson().getName() %></em></li>
			   	<li>申请时间:<em><%= entityPro.getFbizdate()  == null ? "" : FormatUtil.formatDate(entityPro.getFbizdate(),"yyyy-MM-dd hh:mm:ss")%></em></li>
				<li>申请部门:<em><%= entityPro.getFpersondept().getName()%></em></li>
			   	<li>单据状态:<em><%= entityPro.getFstate()==null?"": entityPro.getFstate()%></em></li>
			   	<li>项目名称:<em><%= entityPro.getCfprojectname() %></em></li>
			   	<li>项目类型:<em><%= entityPro.getCfprojecttype() %></em></li>
			   	<li>施工类型:<em><%= entityPro.getFconttype() %></em></li>
				<li>所属区域:<em><%= entityPro.getCfregion().getName()%></em></li>
			   	<li>所属事业部:<em><%= entityPro.getCfbusinessdivisionName().getName() %></em></li>
			   	<li>所属子公司:<em><%= entityPro.getCfkaleidescope().getName()%></em></li>
			   	<li>项目所在地:<em><%= entityPro.getCfprojectplace()==null?"":entityPro.getCfprojectplace() %></em></li>
				<li>项目负责部门:<em><%= entityPro.getCfprojectdepartmenName()==null?"":entityPro.getCfprojectdepartmenName().getName()%></em></li>
			   	<li>项目经理:<em><%= entityPro.getCfprojectmanager()==null?"":entityPro.getCfprojectmanager().getName() %></em></li>
			   	
			   <% if("网点".equals(entityPro.getCfprojecttype())) {%>
			   	<li>计划网点年份:<em><%= entityPro.getCfplanyear() %></em></li>
			   	<%}else{%>
			   		<li>非网点分类:<em><%= entityPro.getCfbranchtype().getSimpleChinese() %></em></li>
			   		<li>项目级别:<em><%= entityPro.getCfprojectlevel() %></em></li>
			   	<%}%>
			   	<li>备注:<em><%= entityPro.getFremake()==null?"":entityPro.getFremake() %></em></li>
			   	
			   	<%
			   	String cfdeependesign = entityPro.getCfdeependesign()==null?"":entityPro.getCfdeependesign().toString();
			   	if ("1".equals(cfdeependesign)) { %>
			    	<li><input type="checkbox" checked="checked" disabled="disabled"/>是否深化设计</li>
				<%} else { %>
					<li><input type="checkbox" disabled="disabled"/>是否计划外采购</li>
				<%}%>
				<%
				String cfyard = entityPro.getCfyard()==null?"":entityPro.getCfyard().toString();
				if ("1".equals(cfyard)) { %>
			    	<li><input type="checkbox" checked="checked" disabled="disabled"/>场地</li>
				<%} else { %>
					<li><input type="checkbox" disabled="disabled"/>场地</li>
				<%}%>
				<%
				String cfparea = entityPro.getCfparea()==null?"":entityPro.getCfparea().toString();
				if ("1".equals(cfparea)) { %>
			    	<li><input type="checkbox" checked="checked"disabled="disabled"/>区域</li>
				<%} else { %>
					<li><input type="checkbox" disabled="disabled"/>区域</li>
				<%}%>
				<%
				if("网点".equals(entityPro.getCfprojecttype())){
				String cfIsNationalSupplier = entityPro.getCfIsNationalSupplier()==null?"":entityPro.getCfIsNationalSupplier().toString();
				if ("1".equals(cfIsNationalSupplier)) { %>
			    	<li><input type="checkbox" checked="checked"disabled="disabled"/>是否全国供应商</li>
				<%} else { %>
					<li><input type="checkbox" disabled="disabled"/>是否全国供应商</li>
				<%}}%>
          	</ul>
        </div>
        <% if("网点".equals(entityPro.getCfprojecttype())) {%>
        <h4 class="yellow" id="otherInfo1Open" onclick="otherInfoOpen(1);">其他信息-店面定位及需求</h4>
	   	<div class="ulBox2 otherInfo tab1">
    		<ul>
				<li>业务类型:<em>
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
				</em></li>
			   	<li>货物类型:<em>
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
			   	</em></li>
			   	<li>仓库需求:<em>
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
			   	</em></li>
				<li>生活配套需求:<em>
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
				</em></li>
			   	<li>其他需求:<em>
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
			   	</em></li>
			   	<li>营业厅办公需求:<em>柜台<%= entityPro.getCfcounter() %>位   &nbsp;打印机配置<%= entityPro.getCfmarking() %>台</em></li>
			   	<li>备注:<em><%= entityPro.getCfremark()==null?"":entityPro.getCfremark() %></em></li>
		   </ul>
	    </div>
	   <h4 id="otherInfo1Close" class="yellow"  style="display: none" onclick="otherInfoClose(1);">关闭店面定位及需求</h4>	
	   	<%}else{%>
	    <h4 class="yellow" id="otherInfo2Open" onclick="otherInfoOpen(2);">其他信息-资源描述</h4>
	   	<div class="ulBox2 otherInfo tab2">
    		<ul>
				  <%for(int i = 0; i < three.size() ; i++ ) {
					  ProjectApplyE3Entity obj1 = three.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>主控事项:<em><%= obj1.getCfmatter().getName()%></em></li>
				    <li>主控细项:<em><%= obj1.getCfminutess().getName()%></em></li>
				   	<li>评判结果:<em><%= obj1.getCfjudgeResult()%></em></li>
				    <li>备注说明:<em><%= obj1.getCfremark()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    	   <h4 id="otherInfo2Close" class="yellow"  style="display: none"  onclick="otherInfoClose(2);">关闭资源描述</h4>	
	    
	    <h4 class="yellow" onclick="otherInfoOpen(3);">其他信息-办公人员明细</h4>
	   	<div class="ulBox2 otherInfo tab3">
    			<ul>
				  <%for(int i = 0; i < five.size() ; i++ ) {
					  ProjectApplyEntryEntity obj1 = five.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>部门:<em><%= obj1.getCfuseDepartment()%></em></li>
				    <li>岗位:<em><%= obj1.getCfstation()==null?"":obj1.getCfstation()%></em></li>
				   	<li>现状（人数）:<em><%= obj1.getCfnumberOfPeopleDto()%></em></li>
				    <li>现状（办公卡位）:<em><%= obj1.getCfcurrentofficenumDto()%></em></li>
				    <li>明年（人数）:<em><%= obj1.getCfnewNumberPeopleDto()%></em></li>
				    <li>明年（办公卡位）:<em><%= obj1.getCfnextofficenumDto()%></em></li>
				    <li>后年（人数）:<em><%= obj1.getPeopleNumberDto()%></em></li>
				    <li>后年（办公卡位）:<em><%= obj1.getCfafternextoffnumDto()%></em></li>
				    <li>办单窗口数:<em><%= obj1.getCfwindownumDto()%></em></li>
				    <li>备注:<em><%= obj1.getCfremark()%></em></li>
			   <%} %>
		   </ul>
		     </div>
		 <h4 id="otherInfo3Close" class="yellow"  style="display: none" onclick="otherInfoClose(3);">关闭办公人员明细</h4>	
		     
	    <h4 class="yellow" onclick="otherInfoOpen(4);">其他信息-车辆配套明细</h4>
	   	<div class="ulBox2 otherInfo tab4">
    		<ul>
				  <%for(int i = 0; i < two.size() ; i++ ) {
					  ProjectApplyE2Entity obj1 = two.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>车型:<em><%= obj1.getCfproject().getNameChinese()%></em></li>
				    <li>现状:<em><%= obj1.getCfthisYearDto()%></em></li>
				   	<li>明年:<em><%= obj1.getCfnextYearDto()%></em></li>
				    <li>后年:<em><%= obj1.getCfendYearDto()%></em></li>
				    <li>计量单位:<em><%= obj1.getFunits().getName()%></em></li>
				    <li>备注:<em><%= obj1.getCfremark()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 id="otherInfo4Close" class="yellow"  style="display: none" onclick="otherInfoClose(4);">关闭车辆配套明细</h4>	
	    
	      <h4 class="yellow" onclick="otherInfoOpen(5);">其他信息-办公配套明细</h4>
	   	<div class="ulBox2 otherInfo tab5">
    		<ul>
				  <%for(int i = 0; i < four.size() ; i++ ) {
					  ProjectApplyE4Entity obj1 = four.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li>配套名称:<em><%= obj1.getCfpackageName().getName()%></em></li>
				    <li>现状:<em><%= obj1.getCfcurrentNum()%></em></li>
				   	<li>明年:<em><%= obj1.getCfnextNum()%></em></li>
				    <li>后年:<em><%= obj1.getCfafterNextNum()%></em></li>
				    <li>计量单位:<em><%= obj1.getCfunit().getName()%></em></li>
				    <li>备注:<em><%= obj1.getCfcommon()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 id="otherInfo5Close" class="yellow"  style="display: none" onclick="otherInfoClose(5);">关闭车辆配套明细</h4>	
	     <%}%>
	    <%@include file="approve_process_esb3.jsp"%> 
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