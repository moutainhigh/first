<%@page import="com.deppon.wfs.workflow.domain.StoreRent"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
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
StoreRent info = (StoreRent)request.getAttribute("entity");
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
			   <li>工作流:<em> 商铺租赁合同申请</em></li>
				   <li>申请人：<em><%=info.getApplyPersonName()%></em></li>
				   <li>申请人工号：<em><%=info.getApplyPersonId()%></em></li>	
				   <li>签订类型：<em><%=info.getSignType()%></em></li>
				   <li>业务类型：<em><%="1".equals(info.getBusinessType()) ? "租赁" : "转租"%></em></li>
				   <li>是否开设新点或搬迁旧点：<em><%="1".equals(info.getStartOrMove()) ? "是" : "否"%></em></li>
				   <!-- signType != 1 -->
				   <%if(!"新签".equals(info.getSignType())){%>
						<li>原合同编号：<em><%=info.getOriginalPactNo()%></em></li>				   
				   <%} %>
				   <%if("1".equals(info.getStartOrMove())){%>
						<li>工作流号：<em><%=info.getIfStartPro()%></em></li>			   
				   <%} %>
				   <li>所属财务部：<em><%=info.getBelongFinanceDepartment()%></em></li>
				   <li>优先盖章方：<em><%="1".equals(info.getPriorSeal()) ? "我方先盖章/签字" : "对方先盖章/签字"%></em></li>
				   <li>所属事业部：<em><%=info.getBelongBusinessDepartment()%></em></li>
				   <li>所属子公司：<em><%=info.getBelongSubsidiary()%></em></li>
				   <li>出租方名称：<em><%=info.getLeaser()%></em></li>
				   <%if("2".equals(info.getBusinessType())){%>
						<li>承租方名称：<em><%=info.getLesseeInput()%></em></li>	
						<li>出租部门：<em><%=info.getDepartment()%></em></li>
						<li>出租房屋面积：<em><%=info.getFloorSpace()%></em></li>		   
				   <%}else{%>
					   <li>承租方名称：<em><%=info.getLessee()%></em></li>
					   <li>承租部门：<em><%=info.getDepartment()%></em></li>
					   <li>承租房屋面积：<em><%=info.getFloorSpace()%></em></li>
				   <%}%>
				   <li>每年租金：<em><%=info.getCharterMoney()%></em></li>
				   <li>付款方式：<em><%=info.getPaymentType()%></em></li>
				   <li>租赁开始日期：<em><%=info.getRentStartDate() == null ? "" : FormatUtil.formatDate(info.getRentStartDate())%></em></li>
				   <li>租赁结束日期：<em><%=info.getRentEndDate() == null ? "" : FormatUtil.formatDate(info.getRentEndDate())%></em></li>
				   <li>免租开始日期：<em><%=info.getFreeRentStartDate() == null ? "" : FormatUtil.formatDate(info.getFreeRentStartDate())%></em></li>
				   <li>免租结束日期：<em><%=info.getFreeRentEndDate() == null ? "" : FormatUtil.formatDate(info.getFreeRentEndDate())%></em></li>
				   <li>租赁类型：<em><%="1".equals(info.getRentType()) ? "商铺" : "宿舍"%></em></li>
				   <li>押金金额：<em><%=info.getAntecedentMoney()%></em></li>
				   <%if("新签".equals(info.getSignType()) && "1".equals(info.getRentType())){%>
						<li>工程项目编号：<em><%=info.getProjectNo()%></em></li>
				   		<li>工程项目名称：<em><%=info.getProjectName()%></em></li>
				    <%}%>
				   <li>申请事由：<em><%=info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>