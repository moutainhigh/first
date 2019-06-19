<%@page import="com.deppon.montal.model.OASubSidiarySet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.deppon.montal.model.OvertimeInfo"%>
<%@page import="com.deppon.montal.model.OAOvertimeApply"%>
<%@page import="com.deppon.montal.model.CCBobenefits"%>
<%@page import="com.deppon.montal.model.CCPorent"%>
<%@page import="com.deppon.montal.model.CCExpenseClaim"%>
<%@page import="com.deppon.montal.model.PorentCarOutside"%>
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
	OASubSidiarySet info = (OASubSidiarySet)request.getAttribute("subsidiaryset");
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
					   <td>子公司设立及变更申请 <input type="hidden" id ="type_id" value="subsidiaryset"></td>
					</tr>
				   <tr>
					  <th>申请人姓名:</th>
					  <td><%=info.getName()%></td>
				   </tr>
					 <tr>
					  <th>申请类别:</th>
					  <td><%=info.getType()%></td>
				   </tr>
				   <tr>
					  <th>所属区域:</th>
					  <td><%=info.getArea()%></td>
				   </tr>
					 <tr>
					  <th>当地财务部:</th>
					  <td><%=info.getFinancedep()%></td>
				   </tr>
					 <tr>
					  <th>所属公共事务组:</th>
					  <td><%=info.getMatterteam()%></td>
				   </tr>
				   <tr>
					  <th>子公司名称:</th>
					  <td><%=info.getSubcompany()%></td>
				   </tr>
				   				   <tr>
					  <th>所属薪酬组:</th>
					  <td><%=info.getCompensation()%></td>
				   </tr>
					<%if("变更".equals(info.getType())){%>
					 <tr>
					  <th>变更类型:</th>
					  <td><%=info.getUpdatetype()%></td>
				   </tr>
				   <tr>
					  <th>变更前内容:</th>
					  <td><%=info.getBeforeupdate()%></td>
				   </tr>
					 <tr>
					  <th>变更后内容:</th>
					  <td><%=info.getAfterupdate()%></td>
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
<script type="text/javascript">
$(function(){
	//税务管理部负责人审批、财务本部负责人审批、资本与公共事务本部副总裁审批、总裁审批、各区域公共事业部负责人审批；
	//manualActivity0，manualActivity4，manualActivity1，manualActivity2， manualActivity16
// 	var activitydefid = $("#activitydefid").val();
// 	if(activitydefid != 'manualActivity0' && 
// 			activitydefid != 'manualActivity4' && 
// 			activitydefid != 'manualActivity1' && 
// 			activitydefid != 'manualActivity2' && 
// 			activitydefid != 'manualActivity16'){
// 		$("#div3").hide();
// 		$("#approve_area").hide();
// 		var html = "<div id='div_span'><span style='color:red;float:left;text-align:center;line-height:20px;width: 100%;font-size: 20px;'>该节点未设置手机端，请至网页端审批，谢谢。</span></div>";
// 		$("body").append(html);
// 	}
});
</script>
</body>
</html>