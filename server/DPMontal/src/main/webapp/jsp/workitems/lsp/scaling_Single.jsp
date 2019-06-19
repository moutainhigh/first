<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibratebillVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillDEntrysEntity" %>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillFourEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillThreeEntrysEntity"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
 WorkflowEntity workflowEntity = (WorkflowEntity)request.getAttribute("lspResponseEntity");
	//定标单
	CalibratebillVo CalibratebillVo = workflowEntity.getCalibratebillVo();
	//定标单表头实体
	CalibrateBillEntity CalibrateBillEntity = CalibratebillVo.getCalibrateBillEntity();
	//定标单物料分录
	CalibrateBillEntryEntity[] cbEntryEntity = CalibratebillVo.getMaterialEntryList();
	//定标单供应商报价明细分录
	Map<String,CalibrateBillDEntrysEntity[]> supplierPriceMap = CalibratebillVo.getSupplierPriceMap();
	//定标单定标结果分录
 	Map<String,CalibrateBillThreeEntrysEntity[]> CalibrateBillResultMap = CalibratebillVo.getCalibrateBillResultMap();
	//定标单评委信息分录
	CalibrateBillFourEntryEntity[] judgePersonList = CalibratebillVo.getJudgePersonList();
	//单据附件列表
	AttachEntity[] attachList = workflowEntity.getAttachList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>定标单</td></tr>
	    		<tr>
					  <th>单据编号:</th>
					  <td><%=CalibrateBillEntity.getFnumber()%></td>
				   </tr>
					 <tr>
					  <th>评标报告单号:</th>
					  <td><%=CalibrateBillEntity.getReportNumber()%></td>
				   </tr>
				   <tr>
					  <th>RFQ单号:</th>
					  <td><%=CalibrateBillEntity.getRfqNumber()%></td>
				   </tr>
					 <tr>
					  <th>版本号:</th>
					  <td><%=CalibrateBillEntity.getEditionNumber()%></td>
				   </tr>
					 <tr>
					  <th>执行小组名:</th>
					  <td><%=CalibrateBillEntity.getNameList()%></td>
				   </tr>
				     	<tr><th>定标结果:</th><td><%=CalibrateBillEntity.getCalibrateRest()==null?"":CalibrateBillEntity.getCalibrateRest()%></td></tr>
			   	<tr><th>标的物金额:</th><td><%=CalibrateBillEntity.getDestAmount()%></td></tr>
			   	<tr><th>需求评委意见:</th><td><%=CalibrateBillEntity.getNeedSuggest()==null?"":("0".equals(CalibrateBillEntity.getNeedSuggest())?"同意":"不同意")%></td></tr>
			   	<tr><th>专业评委意见:</th><td><%=CalibrateBillEntity.getSpecialtySuggest()==null?"":("0".equals(CalibrateBillEntity.getSpecialtySuggest())?"同意":"不同意")%></td></tr>
			   	<tr><th>采购评委意见:</th><td><%=CalibrateBillEntity.getPurchaseSuggest()==null?"":("0".equals(CalibrateBillEntity.getPurchaseSuggest())?"同意":"不同意")%></td></tr>
				   
				<tr class="yellow"><td colspan="2" >其他信息-物品信息</td></tr>
					<% for(int i = 0 ; i< cbEntryEntity.length ; i++) {
						String classK = cbEntryEntity[i].getId().replaceAll("=","");
					%>
								<tr <%=i==0?"class='sh1'":"class='topLine1'" %> onclick="showRelationship('<%=classK%>');">
								<th>物品编码:</th><td><%=cbEntryEntity[i].getMaterialNumber()%></td></tr>
								<tr onclick="showRelationship('<%=classK%>');"><th>物品名称:</th><td><%=cbEntryEntity[i].getMaterialName() %></td></tr>
								<tr onclick="showRelationship('<%=classK%>');"><th>物品类型:</th><td><%=cbEntryEntity[i].getMaterialType() %></td></tr>
								<tr onclick="showRelationship('<%=classK%>');"><th>物品规格:</th><td><%=cbEntryEntity[i].getMaterialModel() %></td></tr>
								<tr onclick="showRelationship('<%=classK%>');"><th>计量单位:</th><td><%=cbEntryEntity[i].getUnit()%></td></tr>
								<tr onclick="showRelationship('<%=classK%>');"><th>试用数量:</th><td><%=cbEntryEntity[i].getNum()%></td></tr>
								<%}%>
			<tr class="yellow"><td colspan="2" >其他信息--供应商报价</td></tr>
 						<% Iterator iterator = supplierPriceMap.keySet().iterator();
 							while(iterator.hasNext()){
 								String key = (String)iterator.next();
 								String classKey = key.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
 								CalibrateBillDEntrysEntity[] CalibrateBillDEntrysEntity= supplierPriceMap.get(key);
 								int lengthTempS = (CalibrateBillDEntrysEntity == null?0:CalibrateBillDEntrysEntity.length);
 								for(int i = 0 ; i< lengthTempS ; i++) {%> 
 							<tr <%=i==0?"class='"+classKey+"sh'":"class='"+classKey+"topLine1'"%> style="display: none;">
 							<th>供应商编码:</th><td><%=CalibrateBillDEntrysEntity[i].getSupplierNumber()%></td></tr>
							<tr style="display: none;" class="<%=classKey%>"><th>供应商名称:</th><td><%=CalibrateBillDEntrysEntity[i].getSupplierName() %></td></tr>
 							<tr style="display: none;" class="<%=classKey%>"><th>单价:</th><td><%=FormatUtil.formatDoubleStr(CalibrateBillDEntrysEntity[i].getPrice())%></td></tr>
 							<%}} %>
			<tr class="yellow"><td colspan="2" >其他信息--定标结果信息</td></tr>
 							<% Iterator iterator1 = CalibrateBillResultMap.keySet().iterator();
							while(iterator1.hasNext()){
								String key = (String)iterator1.next();
 								String classKey = key.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
								CalibrateBillThreeEntrysEntity[] trEntities= CalibrateBillResultMap.get(key);
								int lengthTempS2 = (trEntities == null?0:trEntities.length);
 							for(int i = 0 ; i< lengthTempS2 ; i++) {%>
 							<tr <%=i==0?"class='"+classKey+"sh'":"class='"+classKey+"topLine1'"%>  style="display: none;">
 							<th>供应商编码:</th><td><%=trEntities[i].getSupplierNumber()%></td></tr>
							<tr style="display: none;" class="<%=classKey%>"><th>供应商名称:</th><td><%=trEntities[i].getSupplierName() %></td></tr>
 							<tr style="display: none;" class="<%=classKey%>"><th>商务标排名:</th><td><%=trEntities[i].getBusinessRank() %></td></tr>
 							<tr style="display: none;" class="<%=classKey%>"><th>技术标排名:</th><td><%=trEntities[i].getTechnologyRank() %></td></tr>
 							<tr style="display: none;" class="<%=classKey%>"><th>综合排名:</th><td><%=trEntities[i].getRank() %></td></tr>
							<tr style="display: none;" class="<%=classKey%>"><th>综合得分:</th><td><%=trEntities[i].getScores() %></td></tr>
							<tr style="display: none;" class="<%=classKey%>"><th>配额类型:</th><td><%=trEntities[i].getType() %></td></tr>
 							<tr style="display: none;" class="<%=classKey%>"><th>配额说明:</th><td><%=trEntities[i].getQuota() %></td></tr>
							<tr style="display: none;" class="<%=classKey%>"><th>审批结论:</th><td><%=trEntities[i].getQuptaDescription() %></td></tr>
 							<tr style="display: none;" class="<%=classKey%>"><th>评标结果:</th><td><%=trEntities[i].getResult() %></td></tr>
 							<tr style="display: none;" class="<%=classKey%>"><th>审批意见:</th><td><%=trEntities[i].getAuditOpinion()==null?"":trEntities[i].getAuditOpinion() %></td></tr>
							<tr style="display: none;" class="<%=classKey%>"><th>备注:</th><td><%=trEntities[i].getRemark()==null?"":trEntities[i].getRemark() %></td></tr>
 							<%}} %>
		<tr class="yellow"><td colspan="2" >其他信息--评委信息</td></tr>
		<%for(int i = 0 ; i< judgePersonList.length ; i++) {%>
							<tr <%=i==0?"class='sh1'":"class='topLine1'" %>><th>评委姓名:</th><td><%=judgePersonList[i].getJudgeName()==null?"":judgePersonList[i].getJudgeName() %></td></tr>
							<tr><th>评委类别:</th><td><%=judgePersonList[i].getJudgeType()==null?"":judgePersonList[i].getJudgeType()%></td></tr>
							<tr><th>评委专长:</th><td><%=judgePersonList[i].getJudgeExpertise()==null?"":judgePersonList[i].getJudgeExpertise() %></td></tr>
							<tr><th>是否评标组长:</th><td><%=judgePersonList[i].isIfGroupleader()== true ? "是":"否" %></td></tr>
							<tr><th>授权信息:</th><td><%=judgePersonList[i].getGrantInformation()==null?"":judgePersonList[i].getGrantInformation() %></td></tr>
							<%}%>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">
function showRelationship(classK){
	$('.'+classK).show();
	$('.'+classK+'topLine1').css('border-top','1px solid #373c64');
	$('.'+classK+'topLine1').show();
	$('.'+classK+'sh').show();
}
</script>
</body>
</html>