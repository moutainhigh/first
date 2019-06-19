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
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
		.otherInfo2{
			display: none;
		}
		.otherInfo1{
			display: none;
		}
	</style>
</head>
<body>
 <%
 InquiryConfirmVo info = (InquiryConfirmVo)request.getAttribute("lspResponseEntity");
 InquiryConfirmEntity entityPro = info.getEntity();
 InquiryConfirmEntryEntity[] two = info.getEntrys();
 InquiryConfirmEntryDEntity[]  three = info.getEntryDEs();
 
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-询价确认单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>询价确认单号:<em><%= entityPro.getFnumber() %></em></li>
			   	<li>报价分析单号:<em><%= entityPro.getFquoteNumber() %></em></li>
			   	<li>RFQ单号:<em><%= entityPro.getCfrfqNumber()%></em></li>
				<li>单据状态:<em><%= entityPro.getcFBillState()%></em></li>
			   	<li>询价伦次:<em><%= entityPro.getcFInquiryNum() %></em></li>
			   	<li>RFQ类型:<em><%= entityPro.getcFRFQTypeName() %></em></li>
			   	<li>总金额:<em><%= entityPro.getAmountMoney()==null?"":entityPro.getAmountMoney() %></em></li>
			   	<li>备注:<em><%= entityPro.getcFRemark()==null?"":entityPro.getcFRemark()%></em></li>
          	</ul>
        </div>
        
	    <h4 class="yellow" id="otherInfo1Open">其他信息-询价物品</h4>
	   	<div class="ulBox2 otherInfo1">
    		<ul>
				  <%for(int i = 0; i < two.length ; i++ ) {
					  InquiryConfirmEntryEntity obj1 = two[i];
					  String fid = obj1.getFid();
					  fid = fid.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
				%>
					<li  onclick="changeThree('<%=fid%>')"  <%=i==0?"class='first'":"class='line'"%>>序号:<em><%=i+1 %></em></li>
				    <li onclick="changeThree('<%=fid%>')" >物品编码:<em><%= obj1.getcFMaterialNumber()%></em></li>
				    <li onclick="changeThree('<%=fid%>')" >物品名称:<em><%= obj1.getcFMaterialName()%></em></li>
				   	<li onclick="changeThree('<%=fid%>')" >物品类型:<em><%= obj1.getcFMeterialType()%></em></li>
				    <li onclick="changeThree('<%=fid%>')" >物品规格:<em><%= obj1.getcFMeterialStandard()%></em></li>
				    <li onclick="changeThree('<%=fid%>')" >数量:<em><%= obj1.getcFMeterialNum()%></em></li>
				    <li onclick="changeThree('<%=fid%>')" >计量单位:<em><%= obj1.getcFBaseUnit()%></em></li>
				   	<li onclick="changeThree('<%=fid%>')" >是否含运费:<em><%= "1".equals(obj1.getcFContainFreight())?"是":"否"%></em></li>
				   	<li onclick="changeThree('<%=fid%>')" >是否含税:<em><%= "1".equals(obj1.getcFContainTax())?"是":"否"%></em></li>
				    <li onclick="changeThree('<%=fid%>')" >开票类型:<em><%= obj1.getcFInvoiceTypeName()%></em></li>
				    <li onclick="changeThree('<%=fid%>')" >提供实效（天）:<em><%= obj1.getcFSupplyExpire()%></em></li>
				    <li onclick="changeThree('<%=fid%>')" >备注:<em><%= obj1.getcFRemark()==null?"":obj1.getcFRemark()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow otherInfo1" id="otherInfo1Close">关闭询价物品</h4>
	    <h4 class="yellow" id="otherInfo2Open">其他信息-报价信息</h4>
	   	<div class="ulBox2 otherInfo2">
    			<ul>
				  <%for(int i = 0; i < three.length ; i++ ) {
					  InquiryConfirmEntryDEntity obj1 = three[i];
					  String classKey = obj1.getfParentID();
					  classKey = classKey.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
				%>
					<li style="display: none;" <%=i==0?"class='first "+classKey+"'":"class='line "+classKey+"'"%>>序号:<em><%=i+1 %></em></li>
				    <li style="display: none;" class="<%=classKey%>">供应商编码:<em><%= obj1.getcFSupplierNumber()%></em></li>
				    <li style="display: none;" class="<%=classKey%>">供应商名称:<em><%= obj1.getcFSupplierName()%></em></li>
				   	<li style="display: none;" class="<%=classKey%>">单价（元）:<em><%= obj1.getcFPrice()%></em></li>
				    <li style="display: none;" class="<%=classKey%>">报价总额（元）:<em><%= obj1.getcFQuoteAmount()%></em></li>
				    <li style="display: none;" class="<%=classKey%>">配额类型:<em><%= obj1.getcFQuotaType()%></em></li>
				    <li style="display: none;" class="<%=classKey%>">配额（%）:<em><%= obj1.getcFQuota()==null?"":obj1.getcFQuota()%></em></li>
				    <li style="display: none;" class="<%=classKey%>">配额说明:<em><%= obj1.getcFQuotaExplain()==null?"":obj1.getcFQuotaExplain()%></em></li>
			   <%} %>
		   </ul>
		 </div>
		 <h4 class="yellow otherInfo2" id="otherInfo2Close">关闭报价信息</h4>
	    <%@include file="approve_process_esb3.jsp"%> 
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
<script type="text/javascript">
	$("#otherInfo1Open").click(function (){
		$(".otherInfo1").slideDown(200);
		$("#otherInfo1Close").slideDown(200);
	});
	$("#otherInfo1Close").click(function (){
		$(".otherInfo1").slideUp(200);
		$("#otherInfo1Close").slideUp(200);
	});
	$("#otherInfo2Open").click(function (){
		$(".otherInfo2").slideDown(200);
		$("#otherInfo2Close").slideDown(200);
	});
	$("#otherInfo2Close").click(function (){
		$(".otherInfo2").slideUp(200);
		$("#otherInfo2Close").slideUp(200);
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