<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibratebillChangeVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeDEntrysEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeThreeEntrysEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeFourEntryEntity"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<style>
.topLine1{
border-top:1px solid #373c64;
}
</style>
<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 CalibratebillChangeVo change = info.getCalibratebillChangeVo();
 //基本信息
 CalibrateBillChangeEntity base = change.getCalibrateBillChangeEntity();
 //其他信息之物品信息
 CalibrateBillChangeEntryEntity[] materiaArr = change.getMaterialList();
 //其他信息之供应商报价 
 Map<String, CalibrateBillChangeDEntrysEntity[]> priceMap = change.getSupplierPriceMap();
 //其他信息之定标结果信息
 Map<String, CalibrateBillChangeThreeEntrysEntity[]> resultMap = change.getChangeResultMap();
 //其他信息之评委信息
 CalibrateBillChangeFourEntryEntity[] judgeArr = change.getJudgePersonList();
 //临时循环变量
 double d;
 String str;
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>定标变更单</td></tr>
	    		<tr><th>单据编号:</th><td><%=base.getFnumber() %></td></tr>
				<tr><th>定标单号:</th><td><%=base.getCalibrateNumber()%></td></tr>
				<tr><th>RFQ单号:</th><td><%=base.getRfqNumber()%></td></tr>
				<tr><th>版本号:</th><td><%=base.getEditionNumber()%></td></tr>
				<tr><th>执行小组名:</th><td><%=base.getNameList()%></td></tr>
			   	<tr><th>定标结果:</th><td><%=base.getCalibrateRest()==null?"":base.getCalibrateRest()%></td></tr>
			   	<tr><th>标的物金额:</th><td><%=base.getDestAmount()%></td></tr>
			   	<tr><th>需求评委意见:</th><td><%=base.getNeedSuggest()==null?"":("0".equals(base.getNeedSuggest())?"同意":"不同意")%></td></tr>
			   	<tr><th>专业评委意见:</th><td><%=base.getSpecialtySuggest()==null?"":("0".equals(base.getSpecialtySuggest())?"同意":"不同意")%></td></tr>
			   	<tr><th>采购评委意见:</th><td><%=base.getPurchaseSuggest()==null?"":("0".equals(base.getPurchaseSuggest())?"同意":"不同意")%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息-物品信息</td></tr>
				<%for(int i = 0; i < materiaArr.length; i++ ) {
					String classK = materiaArr[i].getId().replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
				%>
					<tr <%=i==0?"class='sh1'":"class='topLine1'" %> onclick="showRelation('<%=classK%>');"><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr onclick="showRelation('<%=classK%>');"><th>物品编码:</th><td><%= materiaArr[i].getMaterialNumber()%></td></tr>
				    <tr onclick="showRelation('<%=classK%>');"><th>物品名称:</th><td><%= materiaArr[i].getMaterialName()%></td></tr>
				   	<tr onclick="showRelation('<%=classK%>');"><th>物品类型:</th><td><%= materiaArr[i].getMaterialType()%></td></tr>
				    <tr onclick="showRelation('<%=classK%>');"><th>物品规格:</th><td><%= materiaArr[i].getMaterialModel()%></td></tr>
				    <%
				    	d = materiaArr[i].getNum();
				    	str = String.valueOf(d);
				    %>
				    <tr><th>数量:</th><td><%= str.substring(0,str.indexOf("."))%></td></tr>
				    <tr><th>计量单位:</th><td><%= materiaArr[i].getUnit()%></td></tr>
			   <%} %>
			   
			   <tr class="yellow"><td colspan="2" >其他信息-供应商报价</td></tr>
			   <%
			   Iterator iterator = priceMap.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					String classKey = key.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
					CalibrateBillChangeDEntrysEntity[] priceArr= priceMap.get(key);
						int lengthTemp = (priceArr == null ? 0:priceArr.length);
				  		for(int j = 0; j < lengthTemp; j++) {%>
				  			<tr <%=j==0?"class='"+classKey+"sh'":"class='"+classKey+"topLine1'"%> style="display: none;">
				  			<th>序号:</th><td><%=j+1 %></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>供应商编码:</th><td><%= priceArr[j].getSupplierNumber()%></td></tr>
						    <tr style="display: none;" class="<%=classKey%>"><th>供应商名称:</th><td><%= priceArr[j].getSupplierName()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>单价:</th><td><%= priceArr[j].getPrice()%></td></tr>
				  		<%}
				   }
			   %>
			   
			   <tr class="yellow"><td colspan="2" >其他信息-定标结果信息</td></tr>
			   <%
			   Iterator iterator1 = resultMap.keySet().iterator();
				while(iterator1.hasNext()){
					String key = (String)iterator1.next();
					String classKey = key.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
					CalibrateBillChangeThreeEntrysEntity[] resultArr= resultMap.get(key);
					int lengthTemp2 = (resultArr == null? 0:resultArr.length);
				  		for(int k = 0; k < lengthTemp2; k++) {%>
				  			<tr <%=k==0?"class='"+classKey+"sh'":"class='"+classKey+"topLine1'"%>  style="display: none;"><th>序号:</th><td><%=k+1 %></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>供应商编码:</th><td><%= resultArr[k].getSupplierNumber()%></td></tr>
						    <tr style="display: none;" class="<%=classKey%>"><th>供应商名称:</th><td><%= resultArr[k].getSupplierName()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>商务标排名:</th><td><%= resultArr[k].getBusinessRank()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>技术标排名:</th><td><%= resultArr[k].getTechnologyRank()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>综合排名:</th><td><%= resultArr[k].getRank()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>综合得分:</th><td><%= resultArr[k].getScores()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>配额类型:</th><td><%= resultArr[k].getType()==null?"":("10".equals(resultArr[k].getType())?"文本":"数字")%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>配额(%):</th><td><%= resultArr[k].getQuota()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>配额说明:</th><td><%= resultArr[k].getQuptaDescription()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>审批结论:</th><td><%= resultArr[k].getAuditConclusion()==null?"":resultArr[k].getAuditConclusion()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>评标结果:</th><td><%= resultArr[k].getResult()%></td></tr>
						   	<tr style="display: none;" class="<%=classKey%>"><th>变更原因:</th><td><%= resultArr[k].getRemark()==null?"":resultArr[k].getRemark()%></td></tr>
				  		<%}
				   }
			   %>
			   
			   <tr class="yellow"><td colspan="2" >其他信息-评委信息</td></tr>
			   <%for(int l = 0; l < judgeArr.length; l++) {%>
		  			<tr <%=l==0?"class='sh1'":"class='topLine1'" %>><th>序号:</th><td><%=l+1 %></td></tr>
				   	<tr><th>评委姓名:</th><td><%= judgeArr[l].getJudgeName()%></td></tr>
				    <tr><th>评委类别:</th><td><%= judgeArr[l].getJudgeType()%></td></tr>
				   	<tr><th>评委专长:</th><td><%= judgeArr[l].getJudgeExpertise()%></td></tr>
				   	<tr><th>是否评标组长:</th><td><%= judgeArr[l].isIfGroupleader()?"是":"否"%></td></tr>
				   	<tr><th>授权信息:</th><td><%= judgeArr[l].getGrantInformation()==null?"":judgeArr[l].getGrantInformation()%></td></tr>
		  		<%}%>
			   
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">
function showRelation(classK){
	$('.'+classK).show();
	$('.'+classK+'topLine1').css('border-top','1px solid #373c64');
	$('.'+classK+'topLine1').show();
	$('.'+classK+'sh').show();
}
</script>
</body>
</html>