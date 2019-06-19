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
	<%@include file="/common_ios.jsp" %>
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
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li>工作流:<em>自提/派送范围变更工作流</em></li>
				<li>申请人姓名:<em><%= base.getCreateUser()%></em></li>
				
				<%if("MODIFYSCOPE_TYPE_CANCEL".equals(base.getAppType())){%>
						<li>申请类型:<em>取消</em></li>
					<%}else if("MODIFYSCOPE_TYPE_RETURN".equals(base.getAppType())){%>
						<li>申请类型:<em>加收进仓</em></li>
					<%}else if("MODIFYSCOPE_TYPE_ADD".equals(base.getAppType())){%>
						<li>申请类型:<em>新增</em></li>
					<%}else if("MODIFYSCOPE_TYPE_MODIFY".equals(base.getAppType())){%>
						<li>申请类型:<em>修改</em></li>
					<%}else if("MODIFYSCOPE_TYPE_LIMIT".equals(base.getAppType())){%>
					<li>申请类型:<em>限制</em></li>
					<%}else{%>
					 <li>申请类型:<em><%=base.getDeptType()%></em></li>
					<%} %>
				<li>部门名称:<em><%=base.getDeptName()%></em></li>
				<li>部门详细地址:<em><%=base.getDeptAddress()%></em></li>
				<li>营业部面积（含仓库和柜台）:<em><%=FormatUtil.formatDoubleStr(base.getDeptArea())%></em></li>
				<li>仓库面积:<em><%=FormatUtil.formatDoubleStr(base.getWarehouseArea()) %></em></li>
				<li>电话及传真:<em><%=base.getTelFax()%></em></li>
				<li>开业日期:<em><%= FormatUtil.formatDate(base.getOpenTime(),"yyyy/MM/dd") %></em></li>
				<!-- 新增 -->
				<% if("MODIFYSCOPE_TYPE_ADD".equals(base.getAppType())){%>
				
				<li>新点开设工作流号:<em><%=base.getNewDeptWorkflowNo()%></em></li>
				<li>所属外场:<em><%=base.getTransferCode()%></em></li>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
				<li>自提范围:<em><%=base.getPickupScope()==null?"":base.getPickupScope()%></em></li>
				<li>派送范围:<em><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></em></li>
				<%
				int modifyDeptDetailsize = detailList == null?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
						
				<li>修改部门:<em><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></em></li>
				<li>自提范围:<em><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></em></li>
				<li>派送范围:<em><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></em></li>
				<%}%>
				
				<%} %>
				<!-- 修改 -->
				<% if("MODIFYSCOPE_TYPE_MODIFY".equals(base.getAppType())){%>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
				<li>自提范围:<em><%=base.getPickupScope()==null?"":base.getPickupScope()%></em></li>
				<li>派送范围:<em><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></em></li>
				<%
				int modifyDeptDetailsize = detailList.size() == 0?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
						
				<li>修改部门:<em><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></em></li>
				<li>自提范围:<em><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></em></li>
				<li>派送范围:<em><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></em></li>
				<%}%>
				<%} %>
				<!-- 限制 -->
				<% if("MODIFYSCOPE_TYPE_LIMIT".equals(base.getAppType())){%>
				<li>单件重量上限（KG）:<em><%=FormatUtil.formatDoubleStr(base.getSinglePieceLimitkg())%></em></li>
				<li>单件体积上限（F）:<em><%=FormatUtil.formatDoubleStr(base.getSinglePieceLimitvol())%></em></li>
				<li>单票体积上限（F）:<em><%=FormatUtil.formatDoubleStr( base.getSinglePieceLimitvol())%></em></li>
				<li>近一个月日均到达体积（F）:<em><%=FormatUtil.formatDoubleStr(base.getLastmonthArriveVolume())%></em></li>
					<%if("DEPT_TYPE_SEND_MENTION".equals(base.getDeptType())){%>
						<li>现有部门性质:<em>自提+派送</em></li>
					<%}else if("DEPT_TYPE_SETOUT".equals(base.getDeptType())){%>
						<li>现有部门性质:<em>纯出发</em></li>
					<%}else if("DEPT_TYPE_SETOUT_MENTION".equals(base.getDeptType())){%>
						<li>现有部门性质:<em>出发+自提</em></li>
					<%}else if("DEPT_TYPE_SETOUT_SEND_MENTION".equals(base.getDeptType())){%>
						<li>现有部门性质:<em>出发+自提+派送</em></li>
					<%}else{ %>
						<li>现有部门性质:<em><%=base.getDeptType()%></em></li>
					<%} %>
				
				<li>前一月饱和度（%）:<em><%=FormatUtil.formatDoubleStr(base.getLast1MonthSaturation()) %></em></li>
				<li>前二月饱和度（%）:<em><%= FormatUtil.formatDoubleStr(base.getLast2MonthSaturation())%></em></li>
				<li>前三月饱和度（%）:<em><%=FormatUtil.formatDoubleStr(base.getLast3MonthSaturation())%></em></li>
				<li>自提范围:<em><%=base.getPickupScope()%></em></li>
				<li>派送范围:<em><%=base.getDeliverScope()%></em></li>
				<%} %>
				<!-- 取消-->
				<% if("MODIFYSCOPE_TYPE_CANCEL".equals(base.getAppType())){%>
				<li>取消时间:<em><%=FormatUtil.formatDate(base.getCanleTime(),"yyyy-MM-dd")%></em></li>
				<li>转货部门:<em><%=base.getChangeDept()%></em></li>
				<li>所属外场:<em><%=base.getTransferCode()%></em></li>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
				<li>自提范围:<em><%=base.getPickupScope()==null?"":base.getPickupScope()%></em></li>
				<li>派送范围:<em><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></em></li>
					<%
				int modifyDeptDetailsize = detailList == null?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
						
				<li>修改部门:<em><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></em></li>
				<li>自提范围:<em><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></em></li>
				<li>派送范围:<em><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></em></li>
				<%}%>
				<%} %>
					<!-- 加收进仓-->
				<% if("MODIFYSCOPE_TYPE_RETURN".equals(base.getAppType())){%>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(base.getPickupSelf())&&  "Y".equals(base.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(base.getPickupSelf())&& "N".equals(base.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
				<li>自提范围:<em><%=base.getPickupScope()==null?"":base.getPickupScope()%></em></li>
				<li>派送范围:<em><%=base.getDeliverScope()==null?"":base.getDeliverScope()%></em></li>
					<%
				int modifyDeptDetailsize = detailList.size() == 0?0:detailList.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyscopeDetail detail = detailList.get(i);
				%>
				<li class='line'>申请后部门性质:<em><%
				if( "N".equals(detail.getPickupSelf())&&  "Y".equals(detail.getDeliver())){
					%>	
					派送
				<%}else if( "Y".equals(detail.getPickupSelf())&& "N".equals(detail.getDeliver())){%>
					自提

				<%}else{%>
					自提+派送
				<%}%>
						</em></li>
						
				<li>修改部门:<em><%=detail.getChildDeptName()==null?"":detail.getChildDeptName()%></em></li>
				<li>自提范围:<em><%=detail.getChildPickupScope()==null?"":detail.getChildPickupScope()%></em></li>
				<li>派送范围:<em><%=detail.getChildDeliverScope()==null?"":detail.getChildDeliverScope()%></em></li>
				<%} 
				
				}%>
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