<%@page import="com.deppon.wfs.workflow.domain.ContractApplyBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	ContractApplyBean info = (ContractApplyBean)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		合同签订申请
			   </em></li>
					<li>
						 申请人： 
						<em><%=info.getApplyPersonName()%></em>
					</li>
					<li>
						 申请人工号： 
						<em><%=info.getApplyPersonId()%></em>
					</li>
				   <li>
					   经办部门 ： 
					  <em><%=info.getChargeinDepartment()%></em>
				   </li>
					 <li>
					   是否框架合同： 
					  <em><%=info.getIsFrameContract()%></em>
				   </li>
				   <li>
					   所属事业部： 
					  <em><%=info.getSubordinateDepartment()%></em>
				   </li>
					<li>
					   所属财务部： 
					  <em><%=info.getFinanceDept()%></em>
				   </li>
				   <li>
					   签订类型 ： 
					  <em><%=info.getSignType()%></em>
				   </li>
				     <li>
					   合同类型： 
					  <em><%=info.getContractType()%></em>
				   </li>
				   <%if("2".equals(info.getSignType())|| "3".equals(info.getSignType()) || "4".equals(info.getSignType()) || "续签".equals(info.getSignType())|| "变更".equals(info.getSignType())|| "终止".equals(info.getSignType())){%>
					<li>
					   原合同编号 ： 
					  <em><%=info.getOriginalContractNumbers()==null?"":info.getOriginalContractNumbers()%></em>
				   </li>
				   <%}%>
				    <%if("采购类".equals(info.getContractType())){%>
				   <li>
					   物品名称： 
					  <em><%=info.getItemName()==null?"":info.getItemName()%></em>
				   </li>
						<li>
							 单价 ： 
						  	<em><%=info.getUnitPrice()== null ? "" : info.getUnitPrice()%></em>
					   	</li>
				   <%}%>
						<li>
							 合同名称： 
						  	<em><%=info.getContractName() %></em>
					   	</li>
					   	<li>
							 合同金额： 
						  	<em><%=info.getContractAmount()%></em>
					   	</li>
						 <li>
					   签约对方单位： 
					  <em><%=info.getSigningEachOtherUnit()%></em>
				   </li>
				   <li>
					   签约我方单位： 
					  <em><%=info.getSigningOurUnit()%></em>
				   </li>
					<li>
					   合同开始日期： 
					  <em><%=FormatUtil.formatDate(info.getContractStartTime())%></em>
				   </li>
				   <li>
					   合同结束日期 ： 
					  <em><%=FormatUtil.formatDate(info.getContractEndTime())%></em>
				   </li>
				     <li>
					   优先盖章方： 
					  <em><%=info.getSeal()%></em>
				   </li>
					   	<li>
						   申请事由: 
						  <em><%=info.getReason()%></em>
					   </li>
				</ul>
			</div>
			<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		var activitydefid=$('#activitydefid').val();
		if(activitydefid == 'manualActivity6' || activitydefid == 'manualActivity7' || activitydefid == 'manualActivity8' || activitydefid == 'manualActivity5'){
			document.getElementById("rollback_but").style.display = "none";

		}
	});
</script>
</html>