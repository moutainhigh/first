<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OASystempowerApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
<%
	OASystempowerApply apply = (OASystempowerApply)request.getAttribute("systemApply");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr>
				   <th>工作流号:</th>
				   <td id="workid"><%=apply.getProcessinstid()%></td>
				</tr>
				<tr>
				   <th>工作流:</th>
				   <td>系统权限申请<input type="hidden" id ="type_id" value="systemPowerApply">
				   </td>
				</tr>
				<tr>
					<th>申请人:</th>
					<td><%=apply.getApplyname()%></td> 
				</tr>
				<tr>
					<th>工号:</th>
					<td><%=apply.getEmpid()%></td>
				</tr>
				<tr>
					<th>部门:</th>
					<td><%=apply.getEmpdept()%></td>
				</tr>
				<tr>
					<th>职位:</th>
					<td><%=apply.getEmpposition()%></td>
				</tr>
				<tr>
					<th>申请权限:</th>
					<td><%=apply.getPowertype()%></td>
				</tr>
			   	<%
			   		if(null != apply.getUsername()){
			   	%>
			   	<tr>
					<th>使用人:</th>
					<td><%=apply.getUsername()%></td>
				</tr>
				<tr>
					<th>使用人工号:</th>
					<td><%=apply.getUserid()%></td>
				</tr>
				<tr>
					<th>使用人入职日期:</th>
					<td><%=FormatUtil.formatDate(apply.getEntrydate())%></td>
				</tr>
				<tr>
					<th>使用人职位:</th>
					<td><%=apply.getUserposition()%></td>
				</tr>
				<%
			   		}
			   		if(null != apply.getEndtime()){
				%>
				<tr>
					<th>权限截止日期:</th>
					<td><%=FormatUtil.formatDate(apply.getEndtime())%></td>
				</tr>
				<%
			   		}
				%>
				<%
					if(null != apply.getApplytype()){
				%>
			   	<tr>
					<th>申请类型:</th>
			   	<%
			   			if(apply.getDefPowertype().equals("LMS")){
			   	%>
			   			<td><%=F_Constants.SYSTEM_POWER_APPLYTYPE1.get(apply.getApplytype())%></td>
			   	<%
			   			}else if(apply.getDefPowertype().equals("EAS7.0")){
			   	%>
			   			<td><%=F_Constants.SYSTEM_POWER_APPLYTYPE2.get(apply.getApplytype())%></td>
			   	<%		
			   			}
			   	%>
			   	<%
					} 
				%>
				</tr>
				<%	
					if(apply.getDefPowertype().equals("EAS7.0")){
						if(null != apply.getBeforedept()){
			   	%>
			   		<tr>
						<th>异动前部门:</th>
						<td><%=apply.getBeforedept() %></td>
					</tr>
			   	<%
						}
						if(null != apply.getBeforeposition()){
			   	%>	
			   		<tr>
						<th>异动前岗位:</th>
						<td><%=apply.getBeforeposition() %></td>
					</tr>
			   	
			   	<%
						}
			   	%>
		   		<tr>
					<th>主机是否需要认证:</th>
					<td><%=apply.getIscertification().equals("1")?"是":(apply.getIscertification().equals("2")?"否":"") %></td>
				</tr>
				<tr>
					<th>固定资产编码:</th>
					<td><%=apply.getFixedassetcode()==null?"":apply.getFixedassetcode() %></td>
				</tr>
				<tr>
					<th>负责子公司:</th>
					<td><%=apply.getSubcom() %></td>
				</tr>
			   	<%
					}
			   	%>
			    
			    <tr>
				  <th>申请事由:</th>
				  <td style="word-wrap:break-word;word-break:break-all"><%=apply.getWhyapply()==null?"":apply.getWhyapply() %></td>
			    </tr>
			    <%@include file="approve_process.jsp" %>
			    <%
			    	if(null != apply.getCurrentnode() && apply.getCurrentnode().equals("manualActivity3")){
			    %>
			    <tr>
			    	<th>
			    		审批结果
			    	</th>
			    	<td>
			    		<input type="radio" name="radio-choice" value="0" checked="checked"/><label>确认成功</label>
			    		<input type="radio" name="radio-choice" value="1"/><label>权限异常</label>
			    	</td>
			    </tr>
			    <%
			    	}else if(null != apply.getCurrentnode() && apply.getCurrentnode().equals("manualActivity311")){
			    		if(apply.getDefPowertype().indexOf("EIS") != -1 || apply.getDefPowertype().indexOf("FSSC") != -1){
			    %>
					    <tr>
					    	<th>
					    		是否需要财务信息化审批
					    	</th>
					    	<td>
					    		<input type="radio" name="radio-isNeed" value="1" /><label>是</label>
					    		<input type="radio" name="radio-isNeed" value="0" checked="checked"/><label>否</label>
					    	</td>
					    </tr>
			    <% 		
			    		}
			    	}
			    %>
		  </table>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>

</body>
<script type="text/javascript">
$(function(){
	var currNode = "<%=apply.getCurrentnode()%>";
	if(currNode == "manualActivity3"){
		$('#div3').html("<span class=\"btn\" id=\"agree_sub\" onClick=\"submitSys()\">提&nbsp;&nbsp;交</span>");
		$('#div3').trigger("create");
	}
	
});
function submitSys(){
	//解除事件
	$("#btnConfirm").unbind();
	var v_id =  $('input[name="radio-choice"]:checked').val();
	if(v_id == "0"){
		$("#confirm_msg").html("您当前选择【确认成功】，是否确定提交？");
		
		$("#btnConfirm").click(function(){
			$("#result_window").hide();
			$(".tipsWinCnt").show();
			$("#app_window").hide();
			var appval = $("#app_val").val();
			approve(v_id);//确认提交
		});
	}else{
		$("#confirm_msg").html("您当前选择【权限异常】，是否确定提交？");
		var pType = "<%=apply.getDefPowertype()%>";
		var isFanical = "<%=apply.getIsFanical()%>";
		if(pType.indexOf("DLP") > -1){
			$('input[name="radio-choice"]:checked').val("manualActivity2");
		}else if(pType.indexOf("OUTER") > -1){
			$('input[name="radio-choice"]:checked').val("manualActivity7");
		}else if(pType.indexOf("LMS") > -1){
			$('input[name="radio-choice"]:checked').val("manualActivity10");
		}else if(pType.indexOf("EAS7.0") > -1){
			$('input[name="radio-choice"]:checked').val("manualActivity3");
		}else{
			if(isFanical == "1"){
				$('input[name="radio-choice"]:checked').val("manualActivity8");
			}else{
				$('input[name="radio-choice"]:checked').val("manualActivity311");
			}
		}
		$("#btnConfirm").click(function(){
			$("#result_window").hide();
			$(".tipsWinCnt").show();
			$("#app_window").hide();
			//alert($('input[name="radio-choice"]:checked').val());
			var appval = $("#app_val").val();
			rollBackWorkFlow();//退回上个节点
		});
	}
	$("#app_window").fadeIn(600);
	$(".tipsWinCnt").show();
	
}
</script>
</html>