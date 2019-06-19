<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OARemoval"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<body>
<%
	OARemoval info = (OARemoval)request.getAttribute("removal");
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=info.getProcessinstid()%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>开设新点/搬迁旧点<input type="hidden" id ="type_id" value="removal"></td>
					</tr>
				   <tr>
					  <th>申请人姓名:</th>
					  <td><%=info.getName()%></td>
				   </tr>
					 <tr>
					  <th>所属子公司:</th>
					  <td><%=info.getSubcompany()%></td>
				   </tr>
				   <tr>
					  <th>部门经理:</th>
					  <td><%=info.getManagername()%></td>
				   </tr>
					 <tr>
					  <th>现部门名称:</th>
					  <td><%=info.getNeworgname()%></td>
				   </tr>
				   <%if("成立派送部".equals(info.getApplytype())){%>
					   <tr>
						  <th>部门电话:</th>
						  <td><%=info.getOrgphone()%></td>
					   </tr>
					   <tr>
						  <th>原部门名称:</th>
						  <td><%=info.getOrgname()%></td>
					   </tr>
					   <tr>
					  <th>派送部地址:</th>
					  <td><%=info.getSendorgaddress()%></td>
				   </tr>	   
				   <%}else if("搬迁".equals(info.getApplytype())){%>
					   <tr>
						  <th>原部门名称:</th>
						  <td><%=info.getOrgname()%></td>
					   </tr>
				   <%} %>
					 <tr>
					  <th>事业部:</th>
					  <td><%=info.getDivision()%></td>
				   </tr>
				   <tr>
					  <th>租金支付期:</th>
					  <%if("其他".equals(info.getPaymentperiod())){%>
						  <td><%=info.getOtherperiod()%></td>
					  <%}else{%>
						  <td><%=info.getPaymentperiod()%></td>
					  <%} %>
				   </tr>
				   <tr>
					  <th>新点性质:</th>
					  <td><%=info.getApplytype()%></td>
				   </tr>
					<tr>
					  <th>档口一楼面积(单位平方米):</th>
					  <td><%=info.getArea()%></td>
				   </tr>
				   <tr>
					  <th>大区:</th>
					  <td><%=info.getBigregional()%></td>
				   </tr>
					 <tr>
					  <th>押金（元）:</th>
					  <td><%=info.getDeposit()%></td>
				   </tr>
				   <tr>
					  <th>所属营业区:</th>
					  <td><%=info.getManagerarea()%></td>
				   </tr>
					 <tr>
					  <th>网点性质:</th>
					  <td><%=info.getBranchnature()%></td>
				   </tr>
				   <tr>
					  <th>合同面积:</th>
					  <td><%=info.getContractarea()%></td>
				   </tr>
					 <tr>
					  <th>档口租期(月):</th>
					  <td><%=info.getLease()%></td>
				   </tr>
				   <tr>
					  <th>省份:</th>
					  <td><%=info.getProvince()%></td>
				   </tr>
					 <tr>
					  <th>是否驻地部门:</th>
					  <td><%=info.getIssector()%></td>
				   </tr>
				   <tr>
					  <th>城市:</th>
					  <td><%=info.getCity()%></td>
				   </tr>
					 <tr>
					  <th>档口间数:</th>
					  <td><%=info.getPointnumber()==null?"":info.getPointnumber()%></td>
				   </tr>
				   <tr>
					  <th>区域:</th>
					  <td><%=info.getRegional()%></td>
				   </tr>
					 <tr>
					  <th>档口租金(元/月):</th>
					  <td><%=info.getRent()%></td>
				   </tr>
				   <tr>
					  <th>转让费用:</th>
					  <td><%=info.getTransfer()%></td>
				   </tr>
					 <tr>
					  <th>是否可以办证:</th>
					  <td><%=info.getCancard()%></td>
				   </tr>
				   <tr>
					  <th>找点开始时间:</th>
					  <td><%=FormatUtil.formatDate(info.getStarttime())%></td>
				   </tr>
					 <tr>
					  <th>单位面积租金:</th>
					  <td><%=info.getArearent()%></td>
				   </tr>
				   <tr>
					  <th>档口层数:</th>
					  <td><%=info.getLayers()%></td>
				   </tr>
					 <tr>
					  <th>物料发放办公室:</th>
					  <td><%=info.getOfficename()%></td>
				   </tr>
				   <tr>
					  <th>支付方式:</th>
					  <td><%=info.getPaymentmethod()%></td>
				   </tr>
					 <tr>
					  <th>物料发放目的站:</th>
					  <td><%=info.getPurposename()%></td>
				   </tr>
				   <%if(info.getPname() == null||info.getPname()==""){%>
				    <tr>
					  <th>是否按开点计划表申请:</th>
					  <td style="color: red">未按开点计划表申请</td>
				   </tr>
				   <%}else{%>
						<tr>
						<th>是否按开点计划表申请:</th>
						<td style="color: red">由开点计划表<%=info.getPname()%>计划申请</td>
						</tr>			   
				   <%} %>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getReason()==null?"":info.getReason()%></td>
				   </tr>
			     <%@include file="approve_process.jsp" %>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>