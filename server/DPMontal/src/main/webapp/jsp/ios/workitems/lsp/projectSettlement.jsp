<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectclearVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectClearEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectClearEntryEntity"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
 ProjectclearVo temp = info.getProjectclearVo();
 List<ProjectClearEntity> base = temp.getBilllist();
 List<ProjectClearEntryEntity> items = temp.getEntryList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目结算单</h4>
    	<div class="ulBox2">
	    	<ul>				  
          		<% int size1 = base==null?0:base.size();
	    		   for(int i=0;i<size1;i++){
	    			   ProjectClearEntity entity = base.get(i);%>
	    		<li>结算单编号:<em id="workid"><%=entity.getFnumber() %></em></li>
	    		<li>创建人:<em id="workid"><%=entity.getApplyPersonName() %></em></li>
	    		<li>创建部门:<em><%=entity.getApplyDeptName()%></em></li>
				<li>项目编号:<em><%=entity.getProjectcode()%></em></li>
				<li>工程项目名称:<em><%=entity.getCfprojectname()%></em></li>
				<li>结算日期:<em><%=FormatUtil.formatDate(entity.getCfbalancedate(), "yyyy-MM-dd")%></em></li>
				<li>合同编号:<em><%=entity.getCfcontractno()%></em></li>
			   	<li>合同名称:<em><%=entity.getCfcontractname()%></em></li>
			   	<li>所属子公司:<em><%=entity.getCfkaleidescope().getName()%></em></li>
			   	<li>合同版本号:<em><%=entity.getCfcontractversionnumber()%></em></li>
			   	<li>预算项目类型:<em><%=entity.getFbudgetname()%></em></li>
			   	<li>结算类型:<em><%=entity.getCfseetlementstypesName()%></em></li>
			   	<li>合同总金额:<em><%=entity.getCfcontractgrandtotal()%></em></li>
			   	<li>已支付金额:<em><%=entity.getCfalreadyamountpaid()%></em></li>
			    <li>已支付比例:<em><%=entity. getCfalreadypayscale()%></em></li>
			    <li>本次结算金额:<em><%=entity.getCfsettlementamount()%></em></li>
			    <li>本次结算比例:<em><%=entity.getCfpayscale()%></em></li>
			    <li>完成比:<em><%=entity.getCfpercentcomplete()%></em></li>
			    <li>公司财务组织:<em><%=entity.getFcompanyName()%></em></li>
			    <li>供应商:<em><%=entity.getFsupplierName()%></em></li>
			    <li>备注:<em><%=entity.getCfnote()%></em></li>   	   
	    		  <%}%>
          	</ul>
        </div>
        <h4 class="yellow">其他信息</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < items.size(); i++ ) {
					ProjectClearEntryEntity en = items.get(i);
				%>
					<li <%=i==0?"class='first'":"class='line'" %>>序号:<em><%=i+1 %></em></li>
				   	<li>费用承担部门:<em><%= en.getCfcostundertakedepName()%></em></li>
				    <li>费用比例:<em><%= en.getCfcostratio()%>%</em></li>
				   	<li>金额:<em><%= en.getCfsum()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>