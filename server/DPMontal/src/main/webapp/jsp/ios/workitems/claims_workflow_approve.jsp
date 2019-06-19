<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaRewardpunishmentInfo"%>
<%@page import="com.deppon.montal.model.OaDeptexpenses"%>
<%@page import="com.deppon.montal.model.OaAccidentdescriptionInfo"%>
<%@page import="com.deppon.montal.model.OaNomalClaim"%>
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
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
			<ul>
			 <%
				 OaNomalClaim info = (OaNomalClaim)request.getAttribute("claims");

			 %>
				   <li>工作流号：<em><%=info.getProcessinstid() %>
				  	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
				  	 <input type="hidden" id="type_id" value="normalClaim">
				   </em></li>
				   <li>工作流：<em>常规理赔申请</em></li>
				   <li>运单号: <em><%=info.getTransportorerrorcode() %></em></li>
				   <li>运输类型: <em><%=info.getHaultype() %></em></li>
				   <li>报价人：<em><%=info.getInsuredunits() %></em></li>
				   <li>联系电话：<em><%=info.getContactphone() %></em></li>				
				   <li>收货部门：<em><%=info.getReceivingdept() %></em></li>
				   <li>始发站: <em><%=info.getStartingstation() %></em></li>
				   <li>货物名称：<em><%=info.getGoodsname() %></em></li>
			       <li>件/重/体：<em><%=info.getGoodsattribute() %></em></li>
			       <li>保险金额：<em><%=info.getInsuredamount() %></em></li>
				   <li>目标部门：<em><%=info.getTargetdept()%></em></li>
				   <li>发货日期：<em><%=FormatUtil.formatDate(info.getSendingdate()) %></em></li>
				   <li>出险日期：<em><%=FormatUtil.formatDate(info.getDangerdate())%></em></li>
				   <li>所属区域：<em><%=info.getArea()%></em></li>
				   <li>理赔类型：<em><%=info.getClaimstype()%></em></li>
				   <li>冲账方式：<em><%=info.getOffsettypt()==null ? "" : info.getOffsettypt()%></em></li>
				   <li>报案人：<em><%=info.getCasereporter()%></em></li>
				   <li>报案部门：<em><%=info.getReportdept()%></em></li>
				   <li>报案日期：<em><%=FormatUtil.formatDate(info.getReportdate())%></em></li>
				   <li>处理人：<em><%=info.getHandler()%></em></li>
				   <li>处理日期：<em><%=FormatUtil.formatDate(info.getHandledate())%></em></li>
				   <li>索赔金额：<em><%=info.getNormalamount()%></em></li>
				   <li>正常理赔金额：<em><%=info.getNormalamount()%></em></li>
				   <li>实际理赔金额：<em><%=info.getActualclaimsamount()%></em></li>
				   <li>入公司费用：<em><%=info.getTocompanycost()%></em></li>
				   <li><em class="yellow">出险情况说明</em></li>
				   <%
						OaAccidentdescriptionInfo 	description = (OaAccidentdescriptionInfo)request.getAttribute("description");
					%>                
					<li>出险类型：<em><%=description.getAccidenttype() %></em></li>
				 	<li>出险件数：<em><%=description.getAccidentacount() %></em></li>
					 <li>出险描述：<em><br/><%=description.getDescription()%></em></li>
				 	
				   <li><em class="yellow">入部门费用</em></li>
				   <% 
						List<OaDeptexpenses> deptexpenses = (List<OaDeptexpenses>)request.getAttribute("deptexpenses");
						for(OaDeptexpenses expenses : deptexpenses){
					%>
					  <li>大区/部门：<em><%=expenses.getDept()%></em></li>
					  <li>费用：<em><%=expenses.getCharges()%></em></li>
				   <%} %>
				   <li>其他费用说明：<em><%=info.getOthercost()%></em></li>
				   <li><em class="yellow">奖罚明细</em></li>
				   <% 
			   			OaRewardpunishmentInfo reinfo = (OaRewardpunishmentInfo)request.getAttribute("punishment");
			   	  %>
					  <li>奖罚类型：<em><%=reinfo.getRewardpunishmenttype()%></em></li>
					  <li>处理对象：<em><%=reinfo.getDisposetarget()%></em></li>
					  <li>奖罚金额：<em><%=reinfo.getMoney()%></em></li>
				   <li>责任部门：<em><%=info.getResponsibiledept()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp" %>
		</div>
		<%@include file="workflow_approve_button.jsp" %>
	</div>
<script>
window.onload = function(){
	$(".tit").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_tit.png");
	$(".return").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_return.png");
	$(".addr").find("img").attr("src","<%=basePath%>/imgnews/ios/ios_addr.png");
}
</script>
</body>
</html>