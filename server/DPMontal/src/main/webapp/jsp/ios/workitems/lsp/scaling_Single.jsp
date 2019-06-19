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
	<%@include file="/common_ios.jsp" %>
</head>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-定标单</h4>
    	<div class="ulBox2">
	    	<ul>				  
          		<li>
					  单据编号:
					  <em><%=CalibrateBillEntity.getFnumber()%></em>
				   </li>
					 <li>
					  评标报告单号:
					  <em><%=CalibrateBillEntity.getReportNumber()%></em>
				   </li>
				   <li>
					  RFQ单号:
					  <em><%=CalibrateBillEntity.getRfqNumber()%></em>
				   </li>
					 <li>
					  版本号:
					  <em><%=CalibrateBillEntity.getEditionNumber()%></em>
				   </li>
					 <li>
					  执行小组名:
					  <em><%=CalibrateBillEntity.getNameList()%></em>
				   </li>
				      	<li>定标结果:<em><%= CalibrateBillEntity.getCalibrateRest()==null?"":CalibrateBillEntity.getCalibrateRest()%></em></li>
			   	<li>标的物金额:<em><%=CalibrateBillEntity.getDestAmount()%></em></li>
			   	<li>需求评委意见:<em><%=CalibrateBillEntity.getNeedSuggest()==null?"":("0".equals(CalibrateBillEntity.getNeedSuggest())?"同意":"不同意")%></em></li>
			   	<li>专业评委意见:<em><%=CalibrateBillEntity.getSpecialtySuggest()==null?"":("0".equals(CalibrateBillEntity.getSpecialtySuggest())?"同意":"不同意")%></em></li>
			   	<li>采购评委意见:<em><%=CalibrateBillEntity.getPurchaseSuggest()==null?"":("0".equals(CalibrateBillEntity.getPurchaseSuggest())?"同意":"不同意")%></em></li>
          	
          	</ul>
        </div>
        <h4 class="yellow">其他信息--物品信息</h4>
	   	<div class="ulBox2">
    		<ul>
    		<% for(int i = 0 ; i< cbEntryEntity.length ; i++) {
    			String classK = cbEntryEntity[i].getId().replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");%>
    		<li <%=i==0?"class='first'":"class='line'" %>  onclick="showRelationship('<%=classK%>');">物品编码:<em><%=cbEntryEntity[i].getMaterialNumber()%></em></li>
    		<li onclick="showRelationship('<%=classK%>');">物品名称:<em><%=cbEntryEntity[i].getMaterialName() %></em></li>
    		<li onclick="showRelationship('<%=classK%>');">物品类型:<em><%=cbEntryEntity[i].getMaterialType() %></em></li>
    		<li onclick="showRelationship('<%=classK%>');">物品规格:<em><%=cbEntryEntity[i].getMaterialModel() %></em></li>
    		<li onclick="showRelationship('<%=classK%>');">计量单位:<em><%=cbEntryEntity[i].getUnit()%></em></li>
    		<li onclick="showRelationship('<%=classK%>');">试用数量:<em><%=cbEntryEntity[i].getNum()%></em></li><%}%>
		</ul>
	    </div>
	    <h4 class="yellow">其他信息--供应商报价</h4>
	   	<div class="ulBox2">
    		<ul>
    		<% Iterator iterator = supplierPriceMap.keySet().iterator();
			while(iterator.hasNext()){
				String key = (String)iterator.next();
				String classKey = key.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
				CalibrateBillDEntrysEntity[] CalibrateBillDEntrysEntity= supplierPriceMap.get(key);
				int lengthTempS = (CalibrateBillDEntrysEntity == null?0:CalibrateBillDEntrysEntity.length);
				for(int i = 0 ; i< lengthTempS ; i++) {%>
    		<li <%=i==0?"class='"+classKey+"first'":"class='"+classKey+"line'" %> style="display: none">供应商编码:<em><%=CalibrateBillDEntrysEntity[i].getSupplierNumber()%></em></li>
    		<li class="<%=classKey%>" style="display: none">供应商名称:<em><%=CalibrateBillDEntrysEntity[i].getSupplierName() %></em></li>
    		<li class="<%=classKey%>" style="display: none">单价:<em><%=FormatUtil.formatDoubleStr(CalibrateBillDEntrysEntity[i].getPrice())%></em></li>
    		 <%}}%>
		</ul>
	    </div>
	    <h4 class="yellow">其他信息--定标结果信息</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%Iterator iterator1 = CalibrateBillResultMap.keySet().iterator();
			while(iterator1.hasNext()){
				String key = (String)iterator1.next();
				String classKey = key.replaceAll("=","");
				CalibrateBillThreeEntrysEntity[] trEntities= CalibrateBillResultMap.get(key);
				int lengthTempS2 = (trEntities == null?0:trEntities.length);
			for(int i = 0 ; i< lengthTempS2 ; i++) {%>
    		<li <%=i==0?"class='"+classKey+"first'":"class='"+classKey+"line'" %> style="display: none">供应商编码:<em><%=trEntities[i].getSupplierNumber()%></em></li>
    		<li style="display: none;" class="<%=classKey%>">供应商名称:<em><%=trEntities[i].getSupplierName() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">商务标排名:<em><%=trEntities[i].getBusinessRank() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">技术标排名:<em><%=trEntities[i].getTechnologyRank() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">综合排名:<em><%=trEntities[i].getRank() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">综合得分:<em><%=trEntities[i].getScores() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">配额类型:<em><%=trEntities[i].getType() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">配额说明:<em><%=trEntities[i].getQuota() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">审批结论:<em><%=trEntities[i].getQuptaDescription() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">评标结果:<em><%=trEntities[i].getResult() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">审批意见:<em><%=trEntities[i].getAuditOpinion()==null?"":trEntities[i].getAuditOpinion() %></em></li>
    		<li style="display: none;" class="<%=classKey%>">备注:<em><%=trEntities[i].getRemark()==null?"":trEntities[i].getRemark()  %></em></li><%}}%>
		</ul>
	    </div>
	    <h4 class="yellow">其他信息--评委信息</h4>
	   	<div class="ulBox2">
    	<ul>
    		<% for(int i = 0 ; i< judgePersonList.length ; i++) {%>
    		<li <%=i==0?"class='first'":"class='line'"%>>评委姓名:<em><%=judgePersonList[i].getJudgeName()==null?"":judgePersonList[i].getJudgeName()%></em></li>
    		<li>评委类别:<em><%=judgePersonList[i].getJudgeType()==null?"":judgePersonList[i].getJudgeType()%></em></li>
    		<li>评委专长:<em><%=judgePersonList[i].getJudgeExpertise()==null?"":judgePersonList[i].getJudgeExpertise() %></em></li>
    		<li>是否评标组长:<em><%=judgePersonList[i].isIfGroupleader()== true ? "是":"否" %></em></li>
    		<li>授权信息:<em><%=judgePersonList[i].getGrantInformation()==null?"":judgePersonList[i].getGrantInformation()%></em></li><%}%>						
		</ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>
<script type="text/javascript">
function showRelationship(classK){
	$('.'+classK).show();
	$('.'+classK+'line').show();
	$('.'+classK+'first').show();
	$('.'+classK+'line').css('border-color','#faaf19');
}
</script>
</html>