<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.DeptRent"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<%
QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
DeptRent base = infoNew.getDeptRent();
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li>工作流:<em>转租/扩租/退租申请工作流</em></li>
				<li>申请人姓名:<em><%=base.getCreateUser()== null?"":base.getCreateUser()%></em></li>
				<% if("LEASE_APPLY_TYPE_EXPAND".equals(base.getAppType())){%>
				<li>申请类型:<em>扩租</em></li>
				<%} else if("LEASE_APPLY_TYPE_OUT".equals(base.getAppType())){%>
				<li>申请类型:<em>退租</em></li>
				<%}  else if("LEASE_APPLY_TYPE_EXCHANGE".equals(base.getAppType())){%>
				<li>申请类型:<em>转租</em></li>
				<%}  else {%>
				<li>申请类型:<em><%=base.getAppType()%></em></li>
				<%} %>
				<li>部门名称:<em><%=base.getDeptName()%></em></li>
				<li>事业部名称:<em><%=base.getBusinessDivsionName()%></em></li>
				<li>大区:<em><%=base.getBigRegionName()%></em></li>
				<%if("LEASE_APPLY_TYPE_EXCHANGE".equals(base.getAppType())||"LEASE_APPLY_TYPE_OUT".equals(base.getAppType())){%>
				<li>谈判人:<em><%=base.getNegotiator()== null?"":base.getNegotiator()%></em></li>
				<li>谈判人工号:<em><%=base.getNegotiatorCode()== null?"":base.getNegotiatorCode()%></em></li>
				<li>谈判人上级领导:<em><%=base.getLeader()== null?"":base.getLeader()%></em></li>
				<li>谈判人上级领导工号:<em><%=base.getLeaderCode()== null?"":base.getLeaderCode()%></em></li>
				<li>谈判人上上级领导:<em><%=base.getParentLeader()== null?"":base.getParentLeader()%></em></li>
				<li>谈判人上上级领导工号:<em><%=base.getParentLeaderCode()== null?"":base.getParentLeaderCode()%></em></li>
				<li>转租/退租期（月）:<em><%=base.getTransferTime()%></em></li>
				<li>变更后部门档口层数:<em><%=base.getChangedStallFloor()%></em></li>
				<li>部门原租用面积（平米）:<em><%=base.getOriginRentArea()%></em></li>
				<li>转租/退租面积（平米）:<em><%=base.getTransferArea()%></em></li>
				<li>部门原租金（元/月）:<em><%=FormatUtil.formatDoubleStr(base.getOriginRent())%></em></li>
				<li>转租/退租租金（元/月）:<em><%=base.getTransferRent()%></em></li>
				<li>部门原单位面积租金（元/平米）:<em><%=FormatUtil.formatDoubleStr(base.getOriginRentPerarea())%></em></li>
				<li>转退租部分单位面积租金（元/平/月）:<em><%=base.getTransferRentPerarea()%></em></li>
				<li>变更后档口一楼面积（平米）:<em><%=base.getChangedStallArea()%></em></li>
				<li>变更后租金（元/月）:<em><%=FormatUtil.formatDoubleStr(base.getChangedRentAmount())%></em></li>
				<li>变更后单位面积租金（元/月/平米）:<em><%=FormatUtil.formatDoubleStr(base.getChangedRentamountPerarea())%></em></li>
				<li>部门原档口间数:<em><%=base.getOriginStallRooms()%></em></li>
				<li>档口押金（元）:<em><%=FormatUtil.formatDoubleStr(base.getStallPledgeAmount())%></em></li>
				<li>转让费（元）:<em><%=FormatUtil.formatDoubleStr(base.getTransferFee())%></em></li>
				<%} %>
				
				<% if("LEASE_APPLY_TYPE_EXPAND".equals(base.getAppType())){%>
					<li>变更后部门档口层数:<em><%=base.getChangedStallFloor()%></em></li>
					<li>部门原租用面积（平米）:<em><%=base.getOriginRentArea()%></em></li>
					<li>部门原租金（元/月）:<em><%=FormatUtil.formatDoubleStr(base.getOriginRent())%></em></li>
					<li>部门原单位面积租金（元/平米）:<em><%=FormatUtil.formatDoubleStr(base.getOriginRentPerarea())%></em></li>
					<li>变更后档口一楼面积（平米）:<em><%=base.getChangedStallArea()%></em></li>
					<li>变更后租金（元/月）:<em><%=FormatUtil.formatDoubleStr(base.getChangedRentAmount())%></em></li>
					<li>变更后单位面积租金（元/月/平米）:<em><%=FormatUtil.formatDoubleStr(base.getChangedRentamountPerarea())%></em></li>
					<li>部门原档口间数:<em><%=base.getOriginStallRooms()%></em></li>
					<li>档口押金（元）:<em><%=FormatUtil.formatDoubleStr(base.getStallPledgeAmount())%></em></li>
					<li>转让费（元）:<em><%=FormatUtil.formatDoubleStr(base.getTransferFee())%></em></li>
					<li>扩租面积（平）:<em><%=base.getExpandArea()%></em></li>
					<li>扩租租金（元/月）:<em><%=FormatUtil.formatDoubleStr(base.getExpandRentamount())%></em></li>
					<li>扩租期:<em><%=base.getExpandTime()%></em></li>
					<li>扩租部分单位面积租金（元/平/月）:<em><%=FormatUtil.formatDoubleStr(base.getExpandRentamountPerarea())%></em></li>
				<%} %>
				<li>是否需要重新装修或改造:<em><%="Y".equals(base.getIsRedecorated())?"是":"否"%></em></li>
				<li>申请事由:<em><%=base.getReason()%></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>

<script type="text/javascript">
</script>
</body>
</html>