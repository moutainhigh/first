<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ProjectRepairVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RepairSettlementEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.RepairSettlementEntryEntity"%>
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
	//维修结算单
	ProjectRepairVo info = (ProjectRepairVo)request.getAttribute("lspResponseEntity");
	//维修结算单表头信息
	RepairSettlementEntity repairSettlementEntity = info.getRepairSettlementEntity();
	//维修结算单分录实体
	List<RepairSettlementEntryEntity>  repairSettlementEntryEntities = info.getRepairSettlementEntryEntities();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-维修结算单</h4>
    	<div class="ulBox2">
	    	<ul>				  
			   	<li>单据编号:<em><%=repairSettlementEntity.getFnumber()%></em></li>
				<li>创建人:<em><%=repairSettlementEntity.getFcreatorID()%></em></li>
				<li>创建时间:<em><%=FormatUtil.formatDate(repairSettlementEntity.getFcreateTime())%></em></li>
				<li>创建部门:<em><%=repairSettlementEntity.getCfCreateDepID()%></em></li>
				<li>结算日期:<em><%=FormatUtil.formatDate(repairSettlementEntity.getCfClearMonth())%></em></li>
				<li>结算总计:<em><%=FormatUtil.formatDouble("###,###,###.00",repairSettlementEntity.getCfClearTotalDto())%></em></li>
				<li>维修供应商:<em><%=repairSettlementEntity.getCfRepairSupplierID()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow" onclick="otherInfoOpen(1);">其他信息-明细信息</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
    		//List<RepairSettlementEntryEntity>  repairSettlementEntryEntities
			int entrysSize = repairSettlementEntryEntities == null ? 0:repairSettlementEntryEntities.size();
			for(int i = 0; i < entrysSize ; i++ ) {
				RepairSettlementEntryEntity obj1 = repairSettlementEntryEntities.get(i);
			%>
			<li <%=i==0?"class='first otherInfo tab1'":"class='line otherInfo tab1'" %>>序号:<em><%=i+1 %></em></li>
			<li class="otherInfo tab1">维修记录单编号:<em><%= obj1.getCfRepairRecordNum()%></em></li>
			<li class="otherInfo tab1">维修申请/计划单编号:<em><%= obj1.getCfRepairApplyNum()%></em></li>
			<li class="otherInfo tab1">被服务部门:<em><%= obj1.getCfByServiceDepID()%></em></li>
			<li class="otherInfo tab1">所属大区:<em><%= obj1.getCfBelongsAreaID()%></em></li>
			<li class="otherInfo tab1">发票抬头:<em><%= obj1.getCfInvoiceTitleID()%></em></li>
			<li class="otherInfo tab1">维修事项:<em><%= obj1.getCfMaintenanceMatte()%></em></li>
			<li class="otherInfo tab1">维修开始日期:<em><%= FormatUtil.formatDate(obj1.getCfDateStartRepair())%></em></li>
			<li class="otherInfo tab1">维修完成日期:<em><%= FormatUtil.formatDate(obj1.getCfDateComRepair())%></em></li>
			<li class="otherInfo tab1">结算总额:<em><%= FormatUtil.formatDouble("###,###,###.00",obj1.getCfTotalAmountDto())%></em></li>
			<li class="otherInfo tab1">是否预提:<em><%= obj1.getCfIfProvision()%></em></li>
			<li class="otherInfo tab1">安排人:<em><%= obj1.getCfArrangerID()%></em></li>
			<li class="otherInfo tab1">费用承担部门:<em><%= obj1.getCfFeeAssumeDeptID()%></em></li>
		<%} %>
		
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);">关闭信息-明细信息</h4>
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