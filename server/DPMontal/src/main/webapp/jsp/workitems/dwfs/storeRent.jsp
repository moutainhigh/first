<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.StoreRent"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	StoreRent info = (StoreRent)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>商铺租赁合同申请</td>
					</tr>
				   <tr>
					  <th>申请人：</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
				   <tr>
					  <th>申请人工号：</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>	
				  
				  <tr>
					  <th>签订类型：</th>
					  <td><%=info.getSignType()%></td>
				   </tr>
				   <tr>
					  <th>业务类型：</th>
					  <td><%="1".equals(info.getBusinessType()) ? "租赁" : "转租"%></td>
				   </tr>
				   <tr>
					  <th>是否开设新点或搬迁旧点：</th>
					  <td><%="1".equals(info.getStartOrMove()) ? "是" : "否"%></td>
				   </tr>
				   <!-- signType != 1 -->
				   <%if(!"新签".equals(info.getSignType())){%>	
					    <tr>
					  		<th>原合同编号：</th>
					  		<td><%=info.getOriginalPactNo()%></td>
				        </tr>			   
				   <%} %>
				   <%if("1".equals(info.getStartOrMove())){%>
						<tr>
					  		<th>工作流号：</th>
					  		<td><%=info.getIfStartPro()%></td>
				  	    </tr>			   
				   <%} %>
				   <tr>
					  <th>所属财务部：</th>
					  <td><%=info.getBelongFinanceDepartment()%></td>
				   </tr>
				   <tr>
					  <th>优先盖章方：</th>
					  <td><%="1".equals(info.getPriorSeal()) ? "我方先盖章/签字" : "对方先盖章/签字"%></td>
				   </tr>
				   <tr>
					  <th>所属事业部：</th>
					  <td><%=info.getBelongBusinessDepartment()%></td>
				   </tr>
				   <tr>
					  <th>所属子公司：</th>
					  <td><%=info.getBelongSubsidiary()%></td>
				   </tr>
				   <tr>
					  <th>出租方名称：</th>
					  <td><%=info.getLeaser()%></td>
				   </tr>
				   <%if("2".equals(info.getBusinessType())){%>
				   <tr>
					  <th>承租方名称：</th>
					  <td><%=info.getLesseeInput()%></td>
				   </tr>
				   <tr>
					  <th>出租部门：</th>
					  <td><%=info.getDepartment()%></td>
				   </tr>
				   <tr>
					  <th>出租房屋面积：</th>
					  <td><%=info.getFloorSpace()%></td>
				   </tr>	   
				   <%}else{%>
				   <tr>
					  <th>承租方名称：</th>
					  <td><%=info.getLessee()%></td>
				   </tr>
				   <tr>
					  <th>承租部门：</th>
					  <td><%=info.getDepartment()%></td>
				   </tr>
				   <tr>
					  <th>承租房屋面积：</th>
					  <td><%=info.getFloorSpace()%></td>
				   </tr>
				   <%}%>
				   <tr>
					  <th>每年租金：</th>
					  <td><%=info.getCharterMoney()%></td>
				   </tr>
				   <tr>
					  <th>付款方式：</th>
					  <td><%=info.getPaymentType()%></td>
				   </tr>
				   <tr>
					  <th>租赁开始日期：</th>
					  <td><%=info.getRentStartDate() == null ? "" : FormatUtil.formatDate(info.getRentStartDate())%></td>
				   </tr>
				   <tr>
					  <th>租赁结束日期：</th>
					  <td><%=info.getRentEndDate() == null ? "" : FormatUtil.formatDate(info.getRentEndDate())%></td>
				   </tr>
				   <tr>
					  <th>免租开始日期：</th>
					  <td><%=info.getFreeRentStartDate() == null ? "" : FormatUtil.formatDate(info.getFreeRentStartDate())%></td>
				   </tr>
				   <tr>
					  <th>免租结束日期：</th>
					  <td><%=info.getFreeRentEndDate() == null ? "" : FormatUtil.formatDate(info.getFreeRentEndDate())%></td>
				   </tr>
				   <tr>
					  <th>租赁类型：</th>
					  <td><%="1".equals(info.getRentType()) ? "商铺" : "宿舍"%></td>
				   </tr>
				   <tr>
					  <th>押金金额：</th>
					  <td><%=info.getAntecedentMoney()%></td>
				   </tr>
				   <%if("新签".equals(info.getSignType()) && "1".equals(info.getRentType())){%>
				   <tr>
					  <th>工程项目编号：</th>
					  <td><%=info.getProjectNo()%></td>
				   </tr>
				   <tr>
					  <th>工程项目名称：</th>
					  <td><%=info.getProjectName()%></td>
				   </tr>
				   <%}%>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReason()  %></td>
				   </tr>
				<%@include file="approve_process.jsp" %>		   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>