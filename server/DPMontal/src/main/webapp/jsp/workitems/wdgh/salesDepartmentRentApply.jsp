<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.DeptRent"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
 DeptRent base = infoNew.getDeptRent();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流:</th><td>转租/扩租/退租申请工作流</td></tr>
				<tr><th>申请人姓名:</th><td><%=base.getCreateUser()== null?"":base.getCreateUser()%></td></tr>
				<% if("LEASE_APPLY_TYPE_EXPAND".equals(base.getAppType())){%>
				<tr><th>申请类型:</th><td>扩租</td></tr>
				<%} else if("LEASE_APPLY_TYPE_OUT".equals(base.getAppType())){%>
				<tr><th>申请类型:</th><td>退租</td></tr>
				<%}  else if("LEASE_APPLY_TYPE_EXCHANGE".equals(base.getAppType())){%>
				<tr><th>申请类型:</th><td>转租</td></tr>
				<%}  else {%>
				<tr><th>申请类型:</th><td><%=base.getAppType()%></td></tr>
				<%} %>
				<tr><th>部门名称:</th><td><%=base.getDeptName()%></td></tr>
				<tr><th>事业部名称:</th><td><%=base.getBusinessDivsionName()%></td></tr>
				<tr><th>大区:</th><td><%=base.getBigRegionName()%></td></tr>
				<%if("LEASE_APPLY_TYPE_EXCHANGE".equals(base.getAppType())||"LEASE_APPLY_TYPE_OUT".equals(base.getAppType())){%>
				<tr><th>谈判人:</th><td><%=base.getNegotiator()== null?"":base.getNegotiator()%></td></tr>
				<tr><th>谈判人工号:</th><td><%=base.getNegotiatorCode()== null?"":base.getNegotiatorCode()%></td></tr>
				<tr><th>谈判人上级领导:</th><td><%=base.getLeader()== null?"":base.getLeader()%></td></tr>
				<tr><th>谈判人上级领导工号:</th><td><%=base.getLeaderCode()== null?"":base.getLeaderCode()%></td></tr>
				<tr><th>谈判人上上级领导:</th><td><%=base.getParentLeader()== null?"":base.getParentLeader()%></td></tr>
				<tr><th>谈判人上上级领导工号:</th><td><%=base.getParentLeaderCode()== null?"":base.getParentLeaderCode()%></td></tr>
				<tr><th>转租/退租期（月）:</th><td><%=base.getTransferTime()%></td></tr>
				<tr><th>变更后部门档口层数:</th><td><%=base.getChangedStallFloor()%></td></tr>
				<tr><th>部门原租用面积（平米）:</th><td><%=base.getOriginRentArea()%></td></tr>
				<tr><th>转租/退租面积（平米）:</th><td><%=base.getTransferArea()%></td></tr>
				<tr><th>部门原租金（元/月）:</th><td><%=FormatUtil.formatDoubleStr(base.getOriginRent())%></td></tr>
				<tr><th>转租/退租租金（元/月）:</th><td><%=base.getTransferRent()%></td></tr>
				<tr><th>部门原单位面积租金（元/平米）:</th><td><%=FormatUtil.formatDoubleStr(base.getOriginRentPerarea())%></td></tr>
				<tr><th>转退租部分单位面积租金（元/平/月）:</th><td><%=base.getTransferRentPerarea()%></td></tr>
				<tr><th>变更后档口一楼面积（平米）:</th><td><%=base.getChangedStallArea()%></td></tr>
				<tr><th>变更后租金（元/月）:</th><td><%=FormatUtil.formatDoubleStr(base.getChangedRentAmount())%></td></tr>
				<tr><th>变更后单位面积租金（元/月/平米）:</th><td><%=FormatUtil.formatDoubleStr(base.getChangedRentamountPerarea())%></td></tr>
				<tr><th>部门原档口间数:</th><td><%=base.getOriginStallRooms()%></td></tr>
				<tr><th>档口押金（元）:</th><td><%=FormatUtil.formatDoubleStr(base.getStallPledgeAmount())%></td></tr>
				<tr><th>转让费（元）:</th><td><%=FormatUtil.formatDoubleStr(base.getTransferFee())%></td></tr>
				<%} %>
				<% if("LEASE_APPLY_TYPE_EXPAND".equals(base.getAppType())){%>
					<tr><th>变更后部门档口层数:</th><td><%=base.getChangedStallFloor()%></td></tr>
					<tr><th>部门原租用面积（平米）:</th><td><%=base.getOriginRentArea()%></td></tr>
					<tr><th>部门原租金（元/月）:</th><td><%=FormatUtil.formatDoubleStr(base.getOriginRent())%></td></tr>
					<tr><th>部门原单位面积租金（元/平米）:</th><td><%=FormatUtil.formatDoubleStr(base.getOriginRentPerarea())%></td></tr>
					<tr><th>变更后档口一楼面积（平米）:</th><td><%=base.getChangedStallArea()%></td></tr>
					<tr><th>变更后租金（元/月）:</th><td><%=FormatUtil.formatDoubleStr(base.getChangedRentAmount())%></td></tr>
					<tr><th>变更后单位面积租金（元/月/平米）:</th><td><%=FormatUtil.formatDoubleStr(base.getChangedRentamountPerarea())%></td></tr>
					<tr><th>部门原档口间数:</th><td><%=base.getOriginStallRooms()%></td></tr>
					<tr><th>档口押金（元）:</th><td><%=FormatUtil.formatDoubleStr(base.getStallPledgeAmount())%></td></tr>
					<tr><th>转让费（元）:</th><td><%=FormatUtil.formatDoubleStr(base.getTransferFee())%></td></tr>
					<tr><th>扩租面积（平）:</th><td><%=base.getExpandArea()%></td></tr>
					<tr><th>扩租租金（元/月）:</th><td><%=FormatUtil.formatDoubleStr(base.getExpandRentamount())%></td></tr>
					<tr><th>扩租期:</th><td><%=base.getExpandTime()%></td></tr>
					<tr><th>扩租部分单位面积租金（元/平/月）:</th><td><%=FormatUtil.formatDoubleStr(base.getExpandRentamountPerarea())%></td></tr>
				<%} %>
				<tr><th>是否需要重新装修或改造:</th><td><%="Y".equals(base.getIsRedecorated())?"是":"否"%></td></tr>
				<tr><th>申请事由:</th><td><%=base.getReason()%></td></tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>