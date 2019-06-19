<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectDesignVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.Projectdesign"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectdesignentryVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectdesignassentryVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectdesignotherentryEntity"%>
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
	//工程项目设计单
	ProjectDesignVo info = (ProjectDesignVo)request.getAttribute("lspResponseEntity");
	//工程项目设计单表头信息查询
	Projectdesign billList = info.getBillList();
	//工程项目设计单设计明细分录（基础资料分录）信息查询
	List<ProjectdesignentryVo> entryList = info.getEntryList();
	//工程项目设计单概算情况分录（辅助资料分录）信息查询
	List<ProjectdesignassentryVo> assEntryList = info.getAssEntryList();
	//工程项目设计单会审记录单分录（其他资料分录）信息查询
	List<ProjectdesignotherentryEntity> otherEntryList = info.getOtherEntryList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目设计单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>工程项目设计单</em></li>
				<li>设计编号:<em><%=billList.getFnumber()%></em></li>
				<li>项目名称:<em><%=billList.getCfprojectname()%></em></li>
				<li>所属事业部:<em><%=billList.getCfdivision()%></em></li>
				
				<li>项目类型:<em><%=billList.getCfprojecttype()%></em></li>
				<li>申请部门:<em><%=billList.getCfcreateorg()%></em></li>
				<li>单据状态:<em><%=billList.getCfstate()%></em></li>
				<li>项目状态:<em><%=billList.getCfprojectstate()%></em></li><!--  -->
				<li>项目所在地点:<em><%=billList.getCfprojectaddress()%></em></li>
				<li>项目编号:<em><%=billList.getCfprojectnumber()==null?"":billList.getCfprojectnumber()%></em></li>
				
				<li>设计部门:<em><%=billList.getCfdesign()==null?"":billList.getCfdesign()%></em></li>
				
				<li>项目经理:<em><%=billList.getCfprojectmanager()==null?"":billList.getCfprojectmanager()%></em></li>
				<li>设计面积:<em><%=billList.getCftxtdesignarea()==null?"":billList.getCftxtdesignarea()%></em></li>
				<li>施工部门:<em><%=billList.getCforgunit()%></em></li>
				<li>概算费用:<em><%=billList.getCfdesignestimate()%></em></li>
				<li>设计类型:<em><%=billList.getCfdesigntype()%></em></li><!--  -->
				<li>预计难度:<em><%=billList.getCfdesigndegree()==null?"":billList.getCfdesigndegree()%></em></li>
				<li>版本号:<em><%=billList.getFversions()%></em></li>
				<li>施工类型:<em><%=billList.getCfconstractiontype()%></em></li>
				<li>是否变更:<em><%="0".equals(billList.getCfisdesign())?"否":"是"%></em></li>
				<li>项目级别:<em><%=billList.getCfprojectlevel()==null?"":billList.getCfprojectlevel()%></em></li>
				<li>非网点分类:<em><%=billList.getCfnotnetworktype()== null ? "":billList.getCfnotnetworktype()%></em></li><!--  -->
				
          	</ul>
        </div>
        <h4 class="yellow" onclick="otherInfoOpen(1);">其他信息-设计明细</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%//工程项目设计单设计明细分录（基础资料分录）信息查询 List<ProjectdesignentryEntity> entryList
			int entryListSize = entryList == null ? 0:entryList.size();
			for(int i = 0; i < entryListSize ; i++ ) {
				ProjectdesignentryVo obj1 = entryList.get(i);
				%>
					<li <%=i==0?"class='first otherInfo tab1'":"class='line otherInfo tab1'" %>>序号:<em><%=i+1 %></em></li>
					   	<li class="otherInfo tab1">图纸名称:<em><%= obj1.getCfblueprintname()%></em></li>
					    <li class="otherInfo tab1">设计日期:<em><%= obj1.getCfdesigndate()==null?"":FormatUtil.formatDate(obj1.getCfdesigndate())%></em></li>
					   	<li class="otherInfo tab1">设计负责人:<em><%= obj1.getCfdesignperson()%></em></li>
					    <li class="otherInfo tab1">设计项目名称:<em><%= obj1.getCfdesignname()%></em></li>
					    <li class="otherInfo tab1">数量:<em><%= obj1.getCfamount()==null?"":obj1.getCfamount()%></em></li>
					    <li class="otherInfo tab1">单位:<em><%= obj1.getCfunit()==null?"":obj1.getCfunit()%></em></li>
					    <li class="otherInfo tab1">占比%:<em><%= obj1.getCfoccupy()==null?"":obj1.getCfoccupy()%></em></li>
					    <li class="otherInfo tab1">备注:<em><%= obj1.getCfremark()==null?"":obj1.getCfremark()%></em></li>
				   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);">关闭信息-设计明细</h4>
	    <h4 class="yellow" onclick="otherInfoOpen(2);">其他信息-概算情况</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%//工程项目设计单概算情况分录（辅助资料分录）信息查询 List<ProjectdesignassentryEntity> assEntryList
			int assEntryListSize = assEntryList==null?0:assEntryList.size();
			for(int i = 0; i < assEntryListSize ; i++ ) {
				ProjectdesignassentryVo obj1 = assEntryList.get(i);
				%>
				   	<li <%=i==0?"class='first otherInfo tab2'":"class='line otherInfo tab2'" %>>序号:<em><%=i+1 %></em></li>
				    <li class="otherInfo tab2">费用名称:<em><%= obj1.getFchargename()%></em></li>
				   	<li class="otherInfo tab2">费用类型:<em><%= obj1.getCfexpensetype()%></em></li>
				   	<li class="otherInfo tab2">概算金额:<em><%= obj1.getCfestimate()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo2Close" onclick="otherInfoClose(2);">关闭信息-概算情况</h4>
	    
	    <h4 class="yellow" onclick="otherInfoOpen(3);">其他信息-会审纪录单</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%//工程项目设计单会审记录单分录（其他资料分录）信息查询 List<ProjectdesignotherentryEntity> otherEntryList
			int otherEntryListSize = otherEntryList==null?0:otherEntryList.size();
			for(int i = 0; i < otherEntryListSize ; i++ ) {
				ProjectdesignotherentryEntity obj1 = otherEntryList.get(i);
				%>
				   	<li <%=i==0?"class='first otherInfo tab3'":"class='line otherInfo tab3'" %>>序号:<em><%=i+1 %></em></li>
				    <li class="otherInfo tab3">会议记录项目:<em><%= obj1.getCfrecordproject()%></em></li>
				   	<li class="otherInfo tab3">图纸信息:<em><%= obj1.getCfblueprintinformation()%></em></li>
				   	<li class="otherInfo tab3">时间(年/月/日):<em><%= obj1.getCfdate()%></em></li>
				   	<li class="otherInfo tab3">会议纪要:<em><%= obj1.getCfremark()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo3Close" onclick="otherInfoClose(3);">关闭信息-会审纪录单</h4>
	    
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