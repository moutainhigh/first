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
	<%@include file="/common_win8.jsp" %>
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
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>工程项目设计单</td></tr>
				<tr><th>设计编号:</th><td><%=billList.getFnumber()%></td></tr>
				<tr><th>项目名称:</th><td><%=billList.getCfprojectname()%></td></tr>
				<tr><th>所属事业部:</th><td><%=billList.getCfdivision()%></td></tr>
				
				<tr><th>项目类型:</th><td><%=billList.getCfprojecttype()%></td></tr>
				<tr><th>申请部门:</th><td><%=billList.getCfcreateorg()%></td></tr>
				<tr><th>单据状态:</th><td><%=billList.getCfstate()%></td></tr>
				<tr><th>项目状态:</th><td><%=billList.getCfprojectstate()%></td></tr><!--  -->
				<tr><th>项目所在地点:</th><td><%=billList.getCfprojectaddress()%></td></tr>
				<tr><th>项目编号:</th><td><%=billList.getCfprojectnumber()==null?"":billList.getCfprojectnumber()%></td></tr>
				
				<tr><th>设计部门:</th><td><%=billList.getCfdesign()==null?"":billList.getCfdesign()%></td></tr>
				
				<tr><th>项目经理:</th><td><%=billList.getCfprojectmanager()==null?"":billList.getCfprojectmanager()%></td></tr>
				<tr><th>设计面积:</th><td><%=billList.getCftxtdesignarea()==null?"":billList.getCftxtdesignarea()%></td></tr>
				<tr><th>施工部门:</th><td><%=billList.getCforgunit()%></td></tr>
				<tr><th>概算费用:</th><td><%=billList.getCfdesignestimate()%></td></tr>
				<tr><th>设计类型:</th><td><%=billList.getCfdesigntype()%></td></tr><!--  -->
				<tr><th>预计难度:</th><td><%=billList.getCfdesigndegree()==null?"":billList.getCfdesigndegree()%></td></tr>
				<tr><th>版本号:</th><td><%=billList.getFversions()%></td></tr>
				<tr><th>施工类型:</th><td><%=billList.getCfconstractiontype()%></td></tr>
				<tr><th>是否变更:</th><td><%="0".equals(billList.getCfisdesign())?"否":"是"%></td></tr>
				<tr><th>项目级别:</th><td><%=billList.getCfprojectlevel()==null?"":billList.getCfprojectlevel()%></td></tr>
				<tr><th>非网点分类:</th><td><%=billList.getCfnotnetworktype()== null ? "":billList.getCfnotnetworktype()%></td></tr><!--  -->
				
				
			    
				<tr class="yellow" id="otherInfo1Open" onclick="otherInfoOpen(1);"><td colspan="2">其他信息-设计明细</td></tr>
				
					<%//工程项目设计单设计明细分录（基础资料分录）信息查询 List<ProjectdesignentryEntity> entryList
					int entryListSize = entryList == null ? 0:entryList.size();
					for(int i = 0; i < entryListSize ; i++ ) {
						ProjectdesignentryVo obj1 = entryList.get(i);
					%>
						<tr <%=i==0 ? "" : "class='topLine otherInfo tab1'" %> class="otherInfo tab1"><th>序号:</th><td><%=i+1 %></td></tr>
					   	<tr class="otherInfo tab1"><th>图纸名称:</th><td><%= obj1.getCfblueprintname()==null?"":obj1.getCfblueprintname()%></td></tr>
					    <tr class="otherInfo tab1"><th>设计日期:</th><td><%= obj1.getCfdesigndate()==null?"":FormatUtil.formatDate(obj1.getCfdesigndate())%></td></tr>
					   	<tr class="otherInfo tab1"><th>设计负责人:</th><td><%= obj1.getCfdesignperson()%></td></tr>
					    <tr class="otherInfo tab1"><th>设计项目名称:</th><td><%= obj1.getCfdesignname()%></td></tr>
					    <tr class="otherInfo tab1"><th>数量:</th><td><%= obj1.getCfamount()==null?"":obj1.getCfamount()%></td></tr>
					    <tr class="otherInfo tab1"><th>单位:</th><td><%= obj1.getCfunit()==null?"":obj1.getCfunit()%></td></tr>
					    <tr class="otherInfo tab1"><th>占比%:</th><td><%= obj1.getCfoccupy()==null?"":obj1.getCfoccupy()%></td></tr>
					    <tr class="otherInfo tab1"><th>备注:</th><td><%= obj1.getCfremark()==null?"":obj1.getCfremark()%></td></tr>
				   <%} %>
				   <tr class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);"><td colspan="2">关闭信息-设计明细</td></tr>
			   
			   <tr class="yellow" id="otherInfo2Open"  onclick="otherInfoOpen(2);"><td colspan="2">其他信息-概算情况</td></tr>
				<%//工程项目设计单概算情况分录（辅助资料分录）信息查询 List<ProjectdesignassentryEntity> assEntryList
				int assEntryListSize = assEntryList==null?0:assEntryList.size();
				for(int i = 0; i < assEntryListSize ; i++ ) {
					ProjectdesignassentryVo obj1 = assEntryList.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo tab2'" %> class="otherInfo tab2"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo tab2"><th>费用名称:</th><td><%= obj1.getFchargename()%></td></tr>
				   	<tr class="otherInfo tab2"><th>费用类型:</th><td><%= obj1.getCfexpensetype()%></td></tr>
				   	<tr class="otherInfo tab2"><th>概算金额:</th><td><%= obj1.getCfestimate()%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo2Close"  onclick="otherInfoClose(2);"><td colspan="2">关闭信息-概算情况</td></tr>
			   
			   
			   <tr class="yellow" id="otherInfo3Open"  onclick="otherInfoOpen(3);"><td colspan="2">其他信息-会审纪录单</td></tr>
				<%//工程项目设计单会审记录单分录（其他资料分录）信息查询 List<ProjectdesignotherentryEntity> otherEntryList
				int otherEntryListSize = otherEntryList==null?0:otherEntryList.size();
				for(int i = 0; i < otherEntryListSize ; i++ ) {
					ProjectdesignotherentryEntity obj1 = otherEntryList.get(i);
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo tab3'" %> class="otherInfo tab3"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo tab3"><th>会议记录项目:</th><td><%= obj1.getCfrecordproject()%></td></tr>
				   	<tr class="otherInfo tab3"><th>图纸信息:</th><td><%= obj1.getCfblueprintinformation()%></td></tr>
				   	<tr class="otherInfo tab3"><th>时间(年/月/日):</th><td><%= obj1.getCfdate()%></td></tr>
				   	<tr class="otherInfo tab3"><th>会议纪要:</th><td><%= obj1.getCfremark()%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo3Close" onclick="otherInfoClose(3);"><td colspan="2">关闭信息-会审纪录单</td></tr>
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