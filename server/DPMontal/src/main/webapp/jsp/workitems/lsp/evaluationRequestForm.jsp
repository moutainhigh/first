<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyRaterDetailEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyRaterRulesEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyRaterScaleEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplySupplierEntryEntity"%>
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
	//评标申请单
	JudgeApplyVo info = (JudgeApplyVo)request.getAttribute("lspResponseEntity");
 	//评标申请单单头
	JudgeApplyEntity entity = info.getEntity();
 	//评标申请单-评标物品信息分录
	JudgeApplyEntryEntity[] entrys = info.getEntrys();
	//评标申请单-评委清单信息分录
	JudgeApplyRaterDetailEntryEntity[] detailEntrys = info.getDetailEntrys();
	//评标申请单-评标细则分录
	JudgeApplyRaterRulesEntryEntity[] raterRuleEntrys = info.getRaterRuleEntrys();
	//评标申请单-评委比例规则分录
	JudgeApplyRaterScaleEntryEntity[] raterScaleEntrys = info.getRaterScaleEntrys();
	//评标申请单-供应商信息分录
	JudgeApplySupplierEntryEntity[] supplierEntrys = info.getSupplierEntrys();

 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>评标申请单</td></tr>
				<tr><th>评标申请单单号:</th><td><%=entity.getFnumber()%></td></tr>
				<tr><th>评标细则模板号:</th><td><%=entity.getCfjudgedetailnumber()%></td></tr>
				<tr><th>RFQ单号:</th><td><%=entity.getCfrfqnumber()%></td></tr>
				<tr><th>申请时间:</th><td><%=FormatUtil.formatDate(entity.getCfapplydate())%></td></tr>
				<tr><th>评标时间:</th><td><%=FormatUtil.formatDate(entity.getCfjudgedate())%></td></tr>
				<tr><th>评标地点:</th><td><%=entity.getCfjudgelocation()%></td></tr>
				<tr><th>招标执行组长:</th><td><%=entity.getCfbidleader()%></td></tr>
				<tr><th>评委数量:</th><td><%=entity.getCfjudgesamountDto()%></td></tr>
				<tr><th>专业部门:</th><td><%=entity.getCfprofessordept().getName()%></td></tr>
<%-- 			    <tr><th>单据状态:</th><td><%=entity.getCfbillstate()%></td></tr> --%>
			    <tr><th>商务标评分:</th><td><%=entity.getCfbusinessscoreDto()%></td></tr>
			    <tr><th>技术标评分:</th><td><%=entity.getCftechnologyscoreDto()%></td></tr>
			    <tr><th>综合评分:</th><td><%=entity.getCfcompositescoreDto()%></td></tr>
			    <tr><th>标的物金额:</th><td><%=FormatUtil.formatDouble("###,###,###.00",entity.getCfdestamountDto())%></td></tr>
			    <tr><th>项目描述:</th><td><%=entity.getCfprojectdescriber()%></td></tr>
			    
				<tr class="yellow" id="otherInfo1Open" onclick="otherInfoOpen(1);"><td colspan="2">其他信息-评标物料信息</td></tr>
				
					<%//评标申请单-评标物品信息分录
					int entrysSize = entrys == null ? 0:entrys.length;
					for(int i = 0; i < entrysSize ; i++ ) {
						JudgeApplyEntryEntity obj1 = entrys[i];
					%>
						<tr <%=i==0 ? "" : "class='topLine otherInfo tab1'" %> class="otherInfo tab1"><th>序号:</th><td><%=i+1 %></td></tr>
					   	<tr class="otherInfo tab1"><th>物品编码:</th><td><%= obj1.getCfmaterialnumber()%></td></tr>
					    <tr class="otherInfo tab1"><th>物品名称:</th><td><%= obj1.getCfmaterialname()%></td></tr>
					   	<tr class="otherInfo tab1"><th>物品类型:</th><td><%= obj1.getCfmaterialtype()%></td></tr>
					    <tr class="otherInfo tab1"><th>物品规格:</th><td><%= obj1.getCfmaterialmodel()%></td></tr>
					    <tr class="otherInfo tab1"><th>计量单位:</th><td><%= obj1.getCfunit()%></td></tr>
					    <tr class="otherInfo tab1"><th>申请数量:</th><td><%= FormatUtil.formatDouble("###.00",obj1.getCfmaterialamountDto())%></td></tr>
				   <%} %>
				   <tr class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);"><td colspan="2">关闭信息-评标物料信息</td></tr>
			   
			   <tr class="yellow" id="otherInfo5Open"  onclick="otherInfoOpen(5);"><td colspan="2">其他信息- 供应商信息</td></tr>
				<%//评标申请单-供应商信息分录 JudgeApplySupplierEntryEntity[] supplierEntrys 
 				int supplierEntrysSize = supplierEntrys==null?0:supplierEntrys.length;
 				for(int i = 0; i < supplierEntrysSize ; i++ ) {
 					JudgeApplySupplierEntryEntity obj1 = supplierEntrys[i];
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo tab5'" %> class="otherInfo tab5"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo tab5"><th>供应商编码:</th><td><%= obj1.getCfsuppliernumber()%></td></tr>
				   	<tr class="otherInfo tab5"><th>供应商名称:</th><td><%= obj1.getCfsuppliername()%></td></tr>
				   	<tr class="otherInfo tab5"><th>供应商状态:</th><td><%= "1".equals(obj1.getCfsupplierstate())?"正式":"潜在"%></td></tr>
				   	<tr class="otherInfo tab5"><th>评审结果:</th><td><%="10".equals(obj1.getCfjudgeresult())?"通过":"不通过"%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo5Close" onclick="otherInfoClose(5);" ><td colspan="2">关闭信息-供应商信息</td></tr>
			  
			  <tr class="yellow" id="otherInfo4Open" onclick="otherInfoOpen(4);" ><td colspan="2">其他信息- 评委比例规则</td></tr>
				<%//评标申请单-评委比例规则分录 JudgeApplyRaterScaleEntryEntity[] raterScaleEntrys 
 				int raterScaleEntrysSize = raterScaleEntrys==null?0:raterScaleEntrys.length;
 				for(int i = 0; i < raterScaleEntrysSize ; i++ ) {
 					JudgeApplyRaterScaleEntryEntity obj1 = raterScaleEntrys[i];
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo tab4'" %> class="otherInfo tab4"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo tab4"><th>评委类别:</th><td><%= obj1.getCfjudgestype()%></td></tr>
				   	<tr class="otherInfo tab4"><th>数量:</th><td><%= obj1.getCfjudgesamount()%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo4Close"  onclick="otherInfoClose(4);"><td colspan="2">关闭信息-评委比例规则</td></tr>
			    
			   <tr class="yellow" id="otherInfo2Open" onclick="otherInfoOpen(2);"><td colspan="2">其他信息-评委清单信息</td></tr>
				<%//评标申请单-评委清单信息分录 JudgeApplyRaterDetailEntryEntity[] detailEntrys
				int detailEntrysSize = detailEntrys==null?0:detailEntrys.length;
				for(int i = 0; i < detailEntrysSize ; i++ ) {
					JudgeApplyRaterDetailEntryEntity obj1 = detailEntrys[i];
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo tab2'" %> class="otherInfo tab2"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo tab2"><th>评委库编码:</th><td><%= obj1.getCfjudgeinfonum()%></td></tr>
				   	<tr class="otherInfo tab2"><th>评委姓名:</th><td><%= obj1.getCfjudgesname()%></td></tr>
				   	<tr class="otherInfo tab2"><th>评委类别:</th><td><%= obj1.getCfjudgestype()%></td></tr>
				   	<tr class="otherInfo tab2"><th>评委专长:</th><td><%= obj1.getCfjudgesmajor()%></td></tr>
				   	<tr class="otherInfo tab2"><th>是否评标组长:</th><td><%=obj1.getCfisleader()==1?"是":"否"%></td></tr>
				   	<tr class="otherInfo tab2"><th>是否选中:</th><td><%=obj1.getCfisselected()==1?"是":"否"%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo2Close"  onclick="otherInfoClose(2);"><td colspan="2">关闭信息-评委清单信息</td></tr>
			   
			  <tr class="yellow" id="otherInfo3Open" onclick="otherInfoOpen(3);"><td colspan="2">其他信息-评标细则</td></tr>
				<%//评标申请单-评标细则分录 JudgeApplyRaterRulesEntryEntity[] raterRuleEntrys
 				int raterRuleEntrysSize = raterRuleEntrys==null?0:raterRuleEntrys.length;
 				for(int i = 0; i < raterRuleEntrysSize ; i++ ) {
 					JudgeApplyRaterRulesEntryEntity obj1 = raterRuleEntrys[i];
				%>
					<tr <%=i==0 ? "" : "class='topLine otherInfo tab3'" %> class="otherInfo tab3"><th>序号:</th><td><%=i+1 %></td></tr>
				    <tr class="otherInfo tab3"><th>评标项类别:</th><td><%= obj1.getCfjudgebidtype()%></td></tr>
				   	<tr class="otherInfo tab3"><th>评标项:</th><td><%= obj1.getCfjudgeitem()%></td></tr>
				   	<tr class="otherInfo tab3"><th>评委类别:</th><td><%= obj1.getCfjudgestype()%></td></tr>
				   	<tr class="otherInfo tab3"><th>分值:</th><td><%= obj1.getCfjudgescore()%></td></tr>
				   	<tr class="otherInfo tab3"><th>评标细则:</th><td><%=obj1.getCfjudgedetail()%></td></tr>
			   <%} %>
			   <tr class="yellow" style="display: none" id="otherInfo3Close" onclick="otherInfoClose(3);"><td colspan="2">关闭信息-评标细则</td></tr>
		  </table>
		  <%@include file="approve_process_esb3.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb2.jsp" %>
</div>
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
</body>
</html>