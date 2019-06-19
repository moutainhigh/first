<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>

<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.InquiryConfirmVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.InquiryConfirmEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.InquiryConfirmEntryDEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.InquiryConfirmEntryEntity"%>
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
 InquiryConfirmVo info = (InquiryConfirmVo)request.getAttribute("lspResponseEntity");
 InquiryConfirmEntity entityPro = info.getEntity();
 InquiryConfirmEntryEntity[] two = info.getEntrys();
 InquiryConfirmEntryDEntity[]  three = info.getEntryDEs();
 
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>					  
	    		<tr><th colspan="2" class="yellow">基本信息-询价确认单</th></tr>
	    		<tr><th>询价确认单号:</th><td><%= entityPro.getFnumber() %></td></tr>
			   	<tr><th>报价分析单号:</th><td><%= entityPro.getFquoteNumber() %></td></tr>
			   	<tr><th>RFQ单号:</th><td><%= entityPro.getCfrfqNumber()%></td></tr>
				<tr><th>单据状态:</th><td><%= entityPro.getcFBillState()%></td></tr>
			   	<tr><th>询价伦次:</th><td><%= entityPro.getcFInquiryNum() %></td></tr>
			   	<tr><th>RFQ类型:</th><td><%= entityPro.getcFRFQTypeName() %></td></tr>
			   	<tr><th>总金额:</th><td><%= entityPro.getAmountMoney()==null?"":entityPro.getAmountMoney() %></td></tr>
			   	<tr><th>备注:</th><td><%= entityPro.getcFRemark()==null?"":entityPro.getcFRemark()%></td></tr>
       			<tr class="yellow" id="otherInfo1Open"><td colspan="2">其他信息-询价物品</td></tr>
  			  	<tbody style="display: none" class="otherInfo1">
				  <%for(int i = 0; i < two.length ; i++ ) {
					  InquiryConfirmEntryEntity obj1 = two[i];
					  String fid = obj1.getFid();
					  fid = fid.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
				%>
					<tr  onclick="changeThree('<%=fid%>')"  <%=i==0?"class='first'":"class='topLine'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>物品编码:</th><td><%= obj1.getcFMaterialNumber()%></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>物品名称:</th><td><%= obj1.getcFMaterialName()%></td></tr>
				   	<tr onclick="changeThree('<%=fid%>')"><th>物品类型:</th><td><%= obj1.getcFMeterialType()%></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>物品规格:</th><td><%= obj1.getcFMeterialStandard()%></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>数量:</th><td><%= obj1.getcFMeterialNum()%></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>计量单位:</th><td><%= obj1.getcFBaseUnit()%></td></tr>
				   	<tr onclick="changeThree('<%=fid%>')"><th>是否含运费:</th><td><%= "1".equals(obj1.getcFContainFreight())?"是":"否"%></td></tr>
				   	<tr onclick="changeThree('<%=fid%>')"><th>是否含税:</th><td><%= "1".equals(obj1.getcFContainTax())?"是":"否"%></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>开票类型:</th><td><%= obj1.getcFInvoiceTypeName()%></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>提供实效（天）:</th><td><%= obj1.getcFSupplyExpire()%></td></tr>
				    <tr onclick="changeThree('<%=fid%>')"><th>备注:</th><td><%= obj1.getcFRemark()==null?"":obj1.getcFRemark()%></td></tr>
			   <%} %>
		  <tr class="yellow" style="display: none" id="otherInfo1Close"><td colspan="2">关闭询价物品</td></tr>
    		</tbody>
    		<tr class="yellow" id="otherInfo2Open" ><td colspan="2">其他信息-报价信息</td></tr>
    		<tbody style="display: none" class="otherInfo2">
				  <%for(int i = 0; i < three.length ; i++ ) {
					  InquiryConfirmEntryDEntity obj1 = three[i];
					  String classKey = obj1.getfParentID();
					  classKey = classKey.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
				%>
					<tr style="display: none;" <%=i==0?"class='first "+classKey+"'":"class='topLine "+classKey+"'"%>><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr style="display: none;" class="<%=classKey%>"><th>供应商编码:</th><td><%= obj1.getcFSupplierNumber()%></td></tr>
				    <tr style="display: none;" class="<%=classKey%>"><th>供应商名称:</th><td><%= obj1.getcFSupplierName()%></td></tr>
				   	<tr style="display: none;" class="<%=classKey%>"><th>单价（元）:</th><td><%= obj1.getcFPrice()%></td></tr>
				    <tr style="display: none;" class="<%=classKey%>"><th>报价总额（元）:</th><td><%= obj1.getcFQuoteAmount()%></td></tr>
				    <tr style="display: none;" class="<%=classKey%>"><th>配额类型:</th><td><%= obj1.getcFQuotaType()%></td></tr>
				    <tr style="display: none;" class="<%=classKey%>"><th>配额（%）:</th><td><%= obj1.getcFQuota()==null?"":obj1.getcFQuota()%></td></tr>
				    <tr style="display: none;" class="<%=classKey%>"><th>配额说明:</th><td><%=obj1.getcFQuotaExplain()==null?"":obj1.getcFQuotaExplain()%></td></tr>
			   <%} %>
		   <tr class="yellow" style="display: none" id="otherInfo2Close"><td colspan="2">关闭报价信息</td></tr>
		  </tbody>
		  </table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
<script type="text/javascript">
	$("#otherInfo1Open").click(function (){
		$(".otherInfo1").show();
		$("#otherInfo1Close").show();
	});
	$("#otherInfo1Close").click(function (){
		$(".otherInfo1").hide();
		$("#otherInfo1Close").hide();
	});
	$("#otherInfo2Open").click(function (){
		$(".otherInfo2").show();
		$("#otherInfo2Close").show();
	});
	$("#otherInfo2Close").click(function (){
		$(".otherInfo2").hide();
		$("#otherInfo2Close").hide();
	});
	
	function changeThree(fid){
// 		$(".otherInfo2").hide();
		var rr = $(".otherInfo2").find("tr").attr("style","display:none");
		//隐藏其他列
		$('.'+fid).show();
		$(".otherInfo2").show();
		$("#otherInfo2Close").show();
// 			$('.'+classK+'topLine1').css('border-top','1px solid #373c64');
// 			$('.'+classK+'topLine1').show();
// 			$('.'+classK+'sh').show();
	}
</script>
</html>