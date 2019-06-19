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
	<%@include file="/common_win8.jsp" %>
	<style type="text/css">
		.otherInfo1{
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
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>供应商考核单</td></tr>
				<tr><th>申请人:</th><td><%=supplierCheckEntity.getCreatorName()%></td></tr>
				<tr><th>申请时间:</th><td><%=FormatUtil.formatDate(supplierCheckEntity.getCreateTime())%></td></tr>
				<tr><th>单据编号:</th><td><%=supplierCheckEntity.getNumber()%></td></tr>
				<tr><th>考核周期:</th><td><%=supplierCheckEntity.getCheckCycName()%></td></tr>
				<tr><th>考核细则模版名称:</th><td><%=supplierCheckEntity.getCheckDetailName()%></td></tr>
				<tr><th>供应商编码:</th><td><%=supplierCheckEntity.getSupplierNumber()%></td></tr>
				<tr><th>供应商名称:</th><td><%=supplierCheckEntity.getSupplierName()%></td></tr>
				<tr><th>加权得分(100):</th><td><%=supplierCheckEntity.getCheckScoreDto()%></td></tr>
				<tr><th>年份:</th><td><%=supplierCheckEntity.getCheckDate()%></td></tr>
				
				<tr><th>考核细则模版编号:</th><td><%=supplierCheckEntity.getCheckDetailNumName()%></td></tr>
				<tr><th>评语:</th><td><%=supplierCheckEntity.getComment()%></td></tr>
				
			    
				<tr class="yellow" id="otherInfo1Open"><td colspan="2">其他信息-供应商审核单</td></tr>
				
					<%////供应商审核单分录信息List<SupplierCheckBillEntity> supplierCheckEntryList
					int entrysSize = supplierCheckEntryList == null ? 0:supplierCheckEntryList.size();
					for(int i = 0; i < entrysSize ; i++ ) {
						SupplierCheckBillEntity obj1 = supplierCheckEntryList.get(i);
					%>
						<tr <%=i==0 ? "" : "class='topLine otherInfo1'" %> class="otherInfo1"><th>序号:</th><td><%=i+1%></td></tr>
					   	<tr class="otherInfo1"><th>考评项目:</th><td><%= obj1.getCheckProjectName()%></td></tr>
					    <tr class="otherInfo1"><th>得分权重（%）:</th><td><%= obj1.getScoreWeightDto()%></td></tr>
					   	<tr class="otherInfo1"><th>评分:</th><td><%= obj1.getScoredDto()%></td></tr>
					    <tr class="otherInfo1"><th>考核细则:</th><td><%= obj1.getCheckDetail()==null?"":obj1.getCheckDetail()%></td></tr>
				   <%} %>
				   <tr class="yellow" style="display: none" id="otherInfo1Close"><td colspan="2">关闭信息-供应商审核单</td></tr>
		  </table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
<script type="text/javascript">
	$("#otherInfo1Open").click(function (){
		$(".otherInfo1").show();
		$("#otherInfo1Close").show();
	});
	$("#otherInfo1Close").click(function (){
		$(".otherInfo1").hide();
		$("#otherInfo1Close").hide();
	});
</script>
</body>
</html>