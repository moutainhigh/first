<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.SupplierCheckVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.SupplierCheckEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.SupplierCheckBillEntity"%>
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
	//供应商审核
	SupplierCheckVo info = (SupplierCheckVo)request.getAttribute("lspResponseEntity");
	//供应商审核单表头信息
	SupplierCheckEntity supplierCheckEntity = info.getSupplierCheckEntity();
	//供应商审核单分录信息
	List<SupplierCheckBillEntity> supplierCheckEntryList = info.getSupplierCheckEntryList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-供应商考核单</h4>
    	<div class="ulBox2">
	    	<ul>				  
			   	<li>申请人:<em><%=supplierCheckEntity.getCreatorName()%></em></li>
				<li>申请时间:<em><%=FormatUtil.formatDate(supplierCheckEntity.getCreateTime())%></em></li>
				<li>单据编号:<em><%=supplierCheckEntity.getNumber()%></em></li>
				<li>考核周期:<em><%=supplierCheckEntity.getCheckCycName()%></em></li>
				<li>考核细则模版名称:<em><%=supplierCheckEntity.getCheckDetailName()%></em></li>
				<li>供应商编码:<em><%=supplierCheckEntity.getSupplierNumber()%></em></li>
				<li>供应商名称:<em><%=supplierCheckEntity.getSupplierName()%></em></li>
				<li>加权得分(100):<em><%=supplierCheckEntity.getCheckScoreDto()%></em></li>
				<li>年份:<em><%=supplierCheckEntity.getCheckDate()%></em></li>
				
				<li>考核细则模版编号:<em><%=supplierCheckEntity.getCheckDetailNumName()%></em></li>
				<li>评语:<em><%=supplierCheckEntity.getComment()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow" onclick="otherInfoOpen(1);">其他信息-供应商审核单</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
    		////供应商审核单分录信息List<SupplierCheckBillEntity> supplierCheckEntryList
			int entrysSize = supplierCheckEntryList == null ? 0:supplierCheckEntryList.size();
			for(int i = 0; i < entrysSize ; i++ ) {
			SupplierCheckBillEntity obj1 = supplierCheckEntryList.get(i);
			%>
			<li <%=i==0?"class='first otherInfo tab1'":"class='line otherInfo tab1'" %>>序号:<em><%=i+1%></em></li>
			<li class="otherInfo tab1">考评项目:<em><%= obj1.getCheckProjectName()%></em></li>
			<li class="otherInfo tab1">得分权重（%）:<em><%= obj1.getScoreWeightDto()%></em></li>
			<li class="otherInfo tab1">评分:<em><%= obj1.getScoredDto()%></em></li>
			<li class="otherInfo tab1">考核细则:<em><%= obj1.getCheckDetail()==null?"":obj1.getCheckDetail()%></em></li>
		<%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);">关闭信息-供应商审核单</h4>
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