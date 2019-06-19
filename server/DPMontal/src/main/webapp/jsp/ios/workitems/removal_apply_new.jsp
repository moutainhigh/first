<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OARemoval"%>
<%@page import="com.deppon.montal.model.OASubSidiarySet"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
<%
OARemoval info = (OARemoval)request.getAttribute("removal");

%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="removal">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
          <li>工作流:<em>开设新点/搬迁旧点<input type="hidden" id ="type_id" value="removal"></em></li>
			<li>
					  申请人姓名:<em>
					  <%=info.getName()%></em></li>
				   
					 <li>
					  所属子公司:<em>
					  <%=info.getSubcompany()%></em></li>
				   
				   <li>
					  部门经理:<em>
					  <%=info.getManagername()%></em></li>
				   
					 <li>
					  现部门名称:<em>
					  <%=info.getNeworgname()%></em></li>
				   
				   <%if("成立派送部".equals(info.getApplytype())){%>
					   <li>
						  部门电话:<em>
						  <%=info.getOrgphone()%></em></li>
					   
					   <li>
						  原部门名称:<em>
						  <%=info.getOrgname()%></em></li>
					   
					   <li>
					  派送部地址:<em>
					  <%=info.getSendorgaddress()%></em></li>
				   	   
				   <%}else if("搬迁".equals(info.getApplytype())){%>
					   <li>
						  原部门名称:<em>
						  <%=info.getOrgname()%></em></li>
					   
				   <%} %>
					 <li>
					  事业部:<em>
					  <%=info.getDivision()%></em></li>
				   
				   <li>
					  租金支付期:
					  <%if("其他".equals(info.getPaymentperiod())){%>
						  <em><%=info.getOtherperiod()%></em>
					  <%}else{%>
						  <em><%=info.getPaymentperiod()%></em>
					  <%} %>
				   </li>
				   <li>
					  新点性质:<em>
					  <%=info.getApplytype()%></em></li>
				   
					<li>
					  档口一楼面积(单位平方米):<em>
					  <%=info.getArea()%></em></li>
				   
				   <li>
					  大区:<em>
					  <%=info.getBigregional()%></em></li>
				   
					 <li>
					  押金（元）:<em>
					  <%=info.getDeposit()%></em></li>
				   
				   <li>
					  所属营业区:<em>
					  <%=info.getManagerarea()%></em></li>
				   
					 <li>
					  网点性质:<em>
					  <%=info.getBranchnature()%></em></li>
				   
				   <li>
					  合同面积:<em>
					  <%=info.getContractarea()%></em></li>
				   
					 <li>
					  档口租期(月):<em>
					  <%=info.getLease()%></em></li>
				   
				   <li>
					  省份:<em>
					  <%=info.getProvince()%></em></li>
				   
					 <li>
					  是否驻地部门:<em>
					  <%=info.getIssector()%></em></li>
				   
				   <li>
					  城市:<em>
					  <%=info.getCity()%></em></li>
				   
					 <li>
					  档口间数:<em>
					  <%=info.getPointnumber()==null?"":info.getPointnumber()%></em></li>
				   
				   <li>
					  区域:<em>
					  <%=info.getRegional()%></em></li>
				   
					 <li>
					  档口租金(元/月):<em>
					  <%=info.getRent()%></em></li>
				   
				   <li>
					  转让费用:<em>
					  <%=info.getTransfer()%></em></li>
				   
					 <li>
					  是否可以办证:<em>
					  <%=info.getCancard()%></em></li>
				   
				   <li>
					  找点开始时间:<em>
					  <%=FormatUtil.formatDate(info.getStarttime())%></em></li>
				   
					 <li>
					  单位面积租金:<em>
					  <%=info.getArearent()%></em></li>
				   
				   <li>
					  档口层数:<em>
					  <%=info.getLayers()%></em></li>
				   
					 <li>
					  物料发放办公室:<em>
					  <%=info.getOfficename()%></em></li>
				   
				   <li>
					  支付方式:<em>
					  <%=info.getPaymentmethod()%></em></li>
				   
					 <li>
					  物料发放目的站:<em>
					  <%=info.getPurposename()%></em></li>
				   
				   <%if(info.getPname() == null||info.getPname()==""){%>
				    <li>
					  是否按开点计划表申请:
					  <em style="color: red">未按开点计划表申请</em></li>
				   <%}else{%>
						<li>
						是否按开点计划表申请:
						<em style="color: red">由开点计划表<%=info.getPname()%>计划申请</em></li>
				   <%} %>
				   <li>
					  申请事由:<em>
					  <%=info.getReason()==null?"":info.getReason()%></em></li>
				   
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>