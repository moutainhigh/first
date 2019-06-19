<%@page import="com.deppon.wfs.workflow.domain.RealContractBorrowBean"%>
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
	RealContractBorrowBean info = (RealContractBorrowBean)request.getAttribute("entity");
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
			   <li>工作流:<em>实体合同借阅申请</em></li>
				<li>姓名:<em><%=info.getApplyPersonName()%></em></li>
				<li>工号:<em><%=info.getApplyPersonId()%></em></li>
				<li>所属事业部:<em><%=info.getArea()==null ? "":info.getArea()%></em></li>
				<li>合同编号:<em><%=info.getContractNum()==null ? "":info.getContractNum()%></em></li>
				<li>客户名称:<em><%=info.getCustomerName()==null ? "":info.getCustomerName()%></em></li>
				<li>签订部门:<em><%=info.getSignDepartment()==null ? "":info.getSignDepartment()%></em></li>
				<li>合同类别:<em><%=info.getContractType()==null ? "":info.getContractType()%></em></li>
				<li>合同密级:<em><%=info.getContractDense()==null ? "":info.getContractDense()%></em></li>
				<li>借阅天数:<em><%=info.getBorrowDays()==null ? "":info.getBorrowDays()%></em></li>
				<li>开始时间:<em><%=info.getStartDate()==null ? "":info.getStartDate()%></em></li>
				<li>结束时间:<em><%=info.getEndDate()==null ? "":info.getEndDate()%></em></li>
				<li>申请事由:<em><%=info.getApplyReason()==null ? "":info.getApplyReason()%></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	//回退按钮隐藏
	$("#rollback_but").hide();
});
</script>
</html>