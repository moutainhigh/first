<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.Modifyscope"%>
<%@page import="com.deppon.wdgh.inteface.domain.ModifyscopeDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
		<%@include file="/common_win8.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<%
QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
Modifyscope base = infoNew.getModifyscope();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
List <ModifyscopeDetail> detailList = base.getModifyscopeDetail();
%>
<body>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流:</th><td>自提/派送范围变更工作流</td></tr>
				<tr><th>申请人姓名:</th><td><%= base.getCreateUser()%></td></tr>
				<tr><th>部门名称:</th><td><%=base.getDeptName()%></td></tr>
				<%if("MODIFYSCOPE_TYPE_CANCEL".equals(base.getAppType())){%>
						<tr><th>申请类型:</th><td>取消</td></tr>
					<%}else if("MODIFYSCOPE_TYPE_RETURN".equals(base.getAppType())){%>
						<tr><th>申请类型:</th><td>加收进仓</td></tr>
					<%}else if("MODIFYSCOPE_TYPE_ADD".equals(base.getAppType())){%>
						<tr><th>申请类型:</th><td>新增</td></tr>
					<%}else if("MODIFYSCOPE_TYPE_MODIFY".equals(base.getAppType())){%>
						<tr><th>申请类型:</th><td>修改</td></tr>
					<%}else if("MODIFYSCOPE_TYPE_LIMIT".equals(base.getAppType())){%>
					<tr><th>申请类型:</th><td>限制</td></tr>
					<%}else{%>
					 <tr><th>申请类型:</th><td><%=base.getDeptType()%></td></tr>
					<%} %>
				<tr><th>部门详细地址:</th><td><%=base.getDeptAddress()%></td></tr>
				<tr><th>营业部面积（含仓库和柜台）:</th><td><%=FormatUtil.formatDoubleStr(base.getDeptArea())%></td></tr>
				<tr><th>仓库面积:</th><td><%=FormatUtil.formatDoubleStr(base.getWarehouseArea())%></td></tr>
				<tr><th>电话及传真:</th><td><%=base.getTelFax()%></td></tr>
				<tr><th>开业日期:</th><td><%= FormatUtil.formatDate(base.getOpenTime(),"yyyy-MM-dd") %></td></tr>
				<!-- 新增 -->
				<% if("MODIFYSCOPE_TYPE_ADD".equals(base.getAppType())){%>
				
				<tr><th>新点开设工作流号:</th><td><%=base.getNewDeptWorkflowNo()%></td></tr>
				<tr><th>所属外场:</th><td><%=base.getTransferCode()%></td></tr>
				<tr class='topLine'><th>申请后部门性质:</th><td><%
						if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
							%>	
							派送
						<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
							自提

						<%}else{%>
							自提+派送
						<%}%>
						</td></tr>
				<tr><th>自提范围:</th><td><%=base.getPickupScope()==null?"":base.getPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></td></tr>
				<%
				int modifyDeptDetailsize = detailList == null?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
			<tr class='topLine'><th>申请后部门性质:</th><td><%
			if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
				%>	
				派送
			<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
				自提

			<%}else{%>
				自提+派送
			<%}%>
						</td></tr>
						
				<tr><th>修改部门:</th><td><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></td></tr>
				<tr><th>自提范围:</th><td><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></td></tr>
				<%}%>
				
				<%} %>
				<!-- 修改 -->
				<% if("MODIFYSCOPE_TYPE_MODIFY".equals(base.getAppType())){%>
				<tr class='topLine'><th>申请后部门性质:</th><td><%
				if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</td></tr>
				<tr><th>自提范围:</th><td><%=base.getPickupScope()==null?"":base.getPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></td></tr>
				<%
				int modifyDeptDetailsize = detailList == null?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
			<tr class='topLine'><th>申请后部门性质:</th><td><%
			if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
				%>	
				派送
			<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
				自提

			<%}else{%>
				自提+派送
			<%}%>
						</td></tr>
						
				<tr><th>修改部门:</th><td><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></td></tr>
				<tr><th>自提范围:</th><td><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></td></tr>
				<%}%>
				<%} %>
				<!-- 限制 -->
				<% if("MODIFYSCOPE_TYPE_LIMIT".equals(base.getAppType())){%>
				<tr><th>单件重量上限（KG）:</th><td><%=FormatUtil.formatDoubleStr(base.getSinglePieceLimitkg())%></td></tr>
				<tr><th>单件体积上限（F）:</th><td><%=FormatUtil.formatDoubleStr(base.getSinglePieceLimitvol())%></td></tr>
				<tr><th>单票体积上限（F）:</th><td><%= FormatUtil.formatDoubleStr(base.getSinglePieceLimitvol())%></td></tr>
				<tr><th>近一个月日均到达体积（F）:</th><td><%=FormatUtil.formatDoubleStr(base.getLastmonthArriveVolume())%></td></tr>
				<%if("DEPT_TYPE_SEND_MENTION".equals(base.getDeptType())){%>
						<tr><th>现有部门性质:</th><td>自提+派送</td></tr>
					<%}else if("DEPT_TYPE_SETOUT".equals(base.getDeptType())){%>
						<tr><th>现有部门性质:</th><td>纯出发</td></tr>
					<%}else if("DEPT_TYPE_SETOUT_MENTION".equals(base.getDeptType())){%>
						<tr><th>现有部门性质:</th><td>出发+自提</td></tr>
					<%}else if("DEPT_TYPE_SETOUT_SEND_MENTION".equals(base.getDeptType())){%>
						<tr><th>现有部门性质:</th><td>出发+自提+派送</td></tr>
					<%}else{ %>
						<tr><th>现有部门性质:</th><td><%=base.getDeptType()%></td></tr>
					<%} %>
				<tr><th>前一月饱和度（%）:</th><td><%=FormatUtil.formatDoubleStr(base.getLast1MonthSaturation())%></td></tr>
				<tr><th>前二月饱和度（%）:</th><td><%= FormatUtil.formatDoubleStr(base.getLast2MonthSaturation())%></td></tr>
				<tr><th>前三月饱和度（%）:</th><td><%=FormatUtil.formatDoubleStr(base.getLast3MonthSaturation())%></td></tr>
				<tr><th>自提范围:</th><td><%=base.getPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=base.getDeliverScope()%></td></tr>
				<%} %>
				<!-- 取消-->
				<% if("MODIFYSCOPE_TYPE_CANCEL".equals(base.getAppType())){%>
				<tr><th>取消时间:</th><td><%=FormatUtil.formatDate(base.getCanleTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>转货部门:</th><td><%=base.getChangeDept()%></td></tr>
				<tr><th>所属外场:</th><td><%=base.getTransferCode()%></td></tr>
				<tr class='topLine'><th>申请后部门性质:</th><td><%
				if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</td></tr>
				<tr><th>自提范围:</th><td><%=base.getPickupScope()==null?"":base.getPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></td></tr>
					<%
				int modifyDeptDetailsize = detailList == null?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
				<tr class='topLine'><th>申请后部门性质:</th><td><%
				if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</td></tr>
						
				<tr><th>修改部门:</th><td><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></td></tr>
				<tr><th>自提范围:</th><td><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></td></tr>
				<%}%>
				<%} %>
					<!-- 加收进仓-->
				<% if("MODIFYSCOPE_TYPE_RETURN".equals(base.getAppType())){%>
				<tr class='topLine'><th>申请后部门性质:</th><td><%
				if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</td></tr>
				<tr><th>自提范围:</th><td><%=base.getPickupScope()==null?"":base.getPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></td></tr>
					<%
				int modifyDeptDetailsize = detailList == null?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
				<tr class='topLine'><th>申请后部门性质:</th><td><%
				if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</td></tr>
						
				<tr><th>修改部门:</th><td><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></td></tr>
				<tr><th>自提范围:</th><td><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></td></tr>
				<tr><th>派送范围:</th><td><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></td></tr>
				<%} 
				
				}%>
				<tr><th>申请事由:</th><td><%=base.getReason()%></td></tr>
	  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
</script>
</body>
</html>