<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OaRewardpunishmentInfo"%>
<%@page import="com.deppon.montal.model.OaDeptexpenses"%>
<%@page import="com.deppon.montal.model.OaAccidentdescriptionInfo"%>
<%@page import="com.deppon.montal.model.OaNomalClaim"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.conf.Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
	 OaNomalClaim info = (OaNomalClaim)request.getAttribute("claims");
 %>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
				   <th>工作流号:</th>
			
				   <td id="workid"><%=info.getProcessinstid() %></td>
				</tr>
				<tr>
				   <th >工作流:</th>
				   <td>常规理赔申请<input type="hidden" id ="type_id" value="normalClaim"></td>
				</tr>
			    <tr>
					  <th >运单号:</th>
					  <td><%=info.getTransportorerrorcode()%></td>
				   </tr>
					 <tr>
					  <th >运输类型:</th>
					  <td><%=info.getHaultype()%></td>
				   </tr>
				   <tr>
					  <th >报价人:</th>
					  <td><%=info.getInsuredunits()%></td>
				   </tr>
					 <tr>
					  <th >联系电话:</th>
					  <td><%=info.getContactphone()%></td>
				   </tr>
					 <tr>
					  <th >收货部门:</th>
					  <td><%=info.getReceivingdept()%></td>
				   </tr>
					 <tr>
					  <th >始发站:</th>
					  <td><%=info.getStartingstation()%></td>
				   </tr>	
					<tr>
						<th >货物名称:</th>
						<td ><%=info.getGoodsname()%></td>
					</tr>
					<tr>
						<th >件/重/体:</th>
						<td><%=info.getGoodsattribute()%></td>
					</tr>
					<tr>
						<th >保险金额:</th>
						<td><%=info.getInsuredamount()%></td>
					</tr>
					<tr>
						<th >目标部门:</th>
						<td><%=info.getTargetdept()%></td>
					</tr>
	
					<tr>
						<th >发货日期:</th>
						<td><%=FormatUtil.formatDate(info.getSendingdate())%></td>
					</tr>
					<tr>
						<th >出险日期:</th>
						<td ><%=FormatUtil.formatDate(info.getDangerdate())%></td>
					</tr>

					<br/>
<!-- 					<tr>常规理赔详细信息</tr> -->
					
					<tr>
						<th>所属区域:</th>
						<td><%=info.getArea()%></td>
					</tr>
					<tr>
						<th>理赔类型:</th>
						<td><%=info.getClaimstype()%></td>
					</tr>

					<tr>
						<th>冲账方式:</th>
						<td><%=info.getOffsettypt()==null ? "" : info.getOffsettypt()%></td>
					</tr>
					<tr>
						<th>报案人:</th>
						<td><%=info.getCasereporter()%></td>
					</tr>                  
					
				   <tr>
					  <th >报案部门:</th>
					  <td><%=info.getReportdept()%></td>
				   </tr>
					 <tr>
					  <th >报案日期:</th>
					  <td><%=FormatUtil.formatDate(info.getReportdate())%></td>
				   </tr>
				   <tr>
					  <th >处理人:</th>
					  <td><%=info.getHandler()%></td>
				   </tr>
					 <tr>
					  <th >处理日期:</th>
					  <td><%=FormatUtil.formatDate(info.getHandledate())%></td>
				   </tr>
				   <tr>
						<th >索赔金额:</th>
						<td ><%=info.getClaimamount()%></td>
					</tr>				
					<tr>
						<th>正常理赔金额:</th>
						<td><%=info.getNormalamount()%></td>
					</tr>
					<tr>
						<th>实际理赔金额:</th>
						<td><%=info.getActualclaimsamount()%></td>
					</tr>

					<tr>
						<th>入公司费用:</th>
						<td><%=info.getTocompanycost() == null? "":info.getTocompanycost()%></td>
					</tr>
					<tr class="yellow">
						<td colspan="2" >出险情况说明</td>
					</tr>
					<%
						OaAccidentdescriptionInfo 	description = (OaAccidentdescriptionInfo)request.getAttribute("description");
					%>                
					<tr>
						<th>出险类型:</th>
						<td><%=description.getAccidenttype() %></td>
					</tr>
					<tr>
					 	<th>出险件数:</th>
					 	<td><%=description.getAccidentacount() %></td>
					</tr>
					<tr>
					 	<th >出险描述:</th>
					 	<td style="word-wrap:break-word;word-break:break-all"><br/><%=description.getDescription()%></td>
				   </tr>
				   <tr class="topLine yellow">
					  <td colspan="2">入部门费用</td>
				   </tr>
					<% 
						List<OaDeptexpenses> deptexpenses = (List<OaDeptexpenses>)request.getAttribute("deptexpenses");
						for(OaDeptexpenses expenses : deptexpenses){
					%>
				   <tr>
					  <th>大区/部门:</th>
					  <td><%=expenses.getDept()%></td>
				   </tr>
				   <tr>
					  <th >费用:</th>
					  <td ><%=expenses.getCharges()%></td>
				   </tr>
				   <%} %>
				   <tr class="topLine">
					  <th>其他费用说明:</th>
					  <td><%=info.getOthercost()%></td>
				   </tr>
				   <tr class="yellow">
					  <td colspan="2">奖罚明细</td>
				   </tr>
				   <% 
				   		OaRewardpunishmentInfo reinfo = (OaRewardpunishmentInfo)request.getAttribute("punishment");
				   %>
				   <tr>
					  <th>奖罚类型</th>
					  <td><%=reinfo.getRewardpunishmenttype()%></td>
				   </tr>
				   <tr>
					  <th>处理对象</th>
					  <td><%=reinfo.getDisposetarget()%></td>
				   </tr>
				   <tr>
					  <th>奖罚金额</th>
					  <td><%=reinfo.getMoney()%></td>
				   </tr>
				   <tr class="topLine">
					  <th>责任部门:</th>
					  <td><%=info.getResponsibiledept()%></td>
				   </tr>
				   <%@include file="approve_process.jsp" %>
		  </table>
		</div>
		<%@include file="workflow_approve_button.jsp" %>
	</div>
</div>
<script>
//图片缓加载
window.onload = function(){
	$(".return").find("img").attr("src","<%=basePath%>/imgnews/win8/list_return_btn.png");
	$(".logo").find("img").attr("src","<%=basePath%>/imgnews/win8/list_logo.png");
}
</script>
</body>
</html>