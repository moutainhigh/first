<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OAManagerRegularizationApply"%>
<%@page import="com.deppon.montal.model.OAMuchRecompensate"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    	<%
				OAManagerRegularizationApply apply  = (OAManagerRegularizationApply)request.getAttribute("managerBecome");
			%>
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=apply.getProcessinstid() %></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>管理人员转正/成长期通过申请工作流</td>
				</tr>				
				<tr>
					<th colspan="2" class="yellow">以下信息由申请人拟申请时填写</th>
				</tr>
				<tr>
					<th>申请人：</th>
					<td><%=apply.getName() %></td>
				</tr>
				<tr>
					<th>工号：</th>
					<td><%=apply.getUserid() %></td>
				</tr>				
				<tr>
					<th>所在部门：</th>
					<td><%=apply.getDept() %></td>
				</tr>
				<tr>
					<th>事业部区域：</th>
					<td><%=apply.getEnterprisearea() %></td>
				</tr>		
				<tr>
					<th>申请类别：</th>
					<td><%=apply.getApplytype() %></td>
				</tr>							
				<%if(!"管理人员成长期通过".equals(apply.getApplytype())){%>
				<tr>
					<th>转正类别：</th>
					<td><%=apply.getApptype()%></td>
				</tr>
				<%} else {%>
				<tr>
					<th>成长期通过类别：</th>
					<td><%=apply.getGrowththroughtype()%></td>
				</tr>
				<tr>
					<th>岗位：</th>
					<td><%=apply.getPosition()%></td>
				</tr>
				<tr>
					<th>考核等级：</th>
					<td><%=apply.getInspectionlevel()%></td>
				</tr>
				<tr>
					<th>任命日期：</th>
					<td><%=FormatUtil.formatDate(apply.getAppointmentdate())%></td>
				</tr>
												<tr>
					<th>转正工作流号：</th>
					<td><%=apply.getPositiveproid()%></td>
				</tr>
				<tr>
					<th>转正日期：</th>
					<td><%=FormatUtil.formatDate(apply.getPositivedate())%></td>
				</tr>				
				<%}%>
				<tr>
					<th>申请事由：</th>
					<td><%=apply.getReason()==null?"":apply.getReason() %></td>
				</tr>
				<tr>
					<th colspan="2" class="yellow">以下信息由薪酬专员审批时填写</th>
				</tr>
				<tr>
					<th>是否谈判工资：</th>
					<td><%=apply.getIstalkspay()==null?"":apply.getIstalkspay() %></td>					
				</tr>
				<tr>
					<th>谈判工资金额：</th>
					<td><%=apply.getTalkspay()==null?"":apply.getTalkspay()%></td>					
				</tr>
				<tr>
					<th>生效日期：</th>
					<td><%=FormatUtil.formatDate(apply.getStartdate())%></td>					
				</tr>
				<%@include file="approve_process.jsp" %>					
			</table>
	    	<table width="100%">
				<%if("相应薪酬福利专员".equals(apply.getCurrentnode())){%>
					 <tr><td style="color: red" align="center" colspan="2">该节点暂不支持手机审批</td></tr>
				<%}%>
				</table>
	    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<%if("相应薪酬福利专员".equals(apply.getCurrentnode())){%>
		<script type="text/javascript">
		$(function(){
			document.getElementById("disagree_but").style.display = "none";
			document.getElementById("agree_but").style.display = "none";
			document.getElementById("rollback_but").style.display = "none";
			document.getElementById("approve_area").style.display = "none";
		});
		</script>
	<%}%>
</div>
</body>
</html>