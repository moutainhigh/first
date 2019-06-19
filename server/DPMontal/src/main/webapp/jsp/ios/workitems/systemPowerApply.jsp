<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OASystempowerApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
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
	OASystempowerApply apply = (OASystempowerApply)request.getAttribute("systemApply");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   		<div class="ulBox2">
			<ul data-role="listview" id="ulist" data-inset="ture" data-theme="c" data-dividertheme="b">
			   <li class="first">工作流号:
			        <em><%=apply.getProcessinstid() %>
			  	   		<input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
			  	   		<input type="hidden" id="type_id" value="systemPowerApply">
			   		</em>
			   </li>
			   <li>工作流:<em>系统权限申请</em></li>
			   <li>申请人:<em><%=apply.getApplyname()%></em></li>
			   <li>工号:<em><%=apply.getEmpid()%></em></li>
			   <li>部门:<em><%=apply.getEmpdept()%></em></li>
			   <li>职位:<em><%=apply.getEmpposition()%></em></li>
			   <li>申请权限:<em><%=apply.getPowertype()%></em></li> 
			   	<%
			   		if(null != apply.getUsername()){
			   	%>
			   	<li>使用人:<em><%=apply.getUsername()%></em></li>
			    <li>使用人工号:<em><%=apply.getUserid()%></em></li>
			    <li>使用人入职日期:<em><%=FormatUtil.formatDate(apply.getEntrydate())%></em></li>
			    <li>使用人职位:<em><%=apply.getUserposition()%></em></li>
				<%
			   		}
			   		if(null != apply.getEndtime()){
				%>
					<li>权限截止日期:<em><%=FormatUtil.formatDate(apply.getEndtime())%></em></li>
				<%
			   		}
				%>
				<%
					if(null != apply.getApplytype()){
				%>
			   	<li>
					申请类型:
			   	<%
			   			if(apply.getDefPowertype().equals("LMS")){
			   	%>
			   			<em><%=F_Constants.SYSTEM_POWER_APPLYTYPE1.get(apply.getApplytype())%></em>
			   	<%
			   			}else if(apply.getDefPowertype().equals("EAS7.0")){
			   	%>
			   			<em><%=F_Constants.SYSTEM_POWER_APPLYTYPE2.get(apply.getApplytype())%></em>
			   	<%		
			   			}
			   	%>
			   	<%
					} 
				%>
				</li>
				<%	
					if(apply.getDefPowertype().equals("EAS7.0")){
						if(null != apply.getBeforedept()){
			   	%>
			   		<li>
						异动前部门:
						<em><%=apply.getBeforedept() %></em>
					</li>
			   	<%
						}
						if(null != apply.getBeforeposition()){
			   	%>	
			   		<li>
						异动前岗位:
						<em><%=apply.getBeforeposition() %></em>
					</li>
			   	
			   	<%
						}
			   	%>
		   		<li>
					主机是否需要认证:
					<em><%=apply.getIscertification().equals("1")?"是":(apply.getIscertification().equals("2")?"否":"") %></em>
				</li>
				<li>
					固定资产编码:
					<em><%=apply.getFixedassetcode()==null?"":apply.getFixedassetcode() %></em>
				</li>
				<li>
					负责子公司:
					<em><%=apply.getSubcom() %></em>
				</li>
			   	<%
					}
			   	%>
				
				<li class="last">申请事由：<em><%=apply.getWhyapply()==null?"":apply.getWhyapply() %></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
		<%
	    	if(null != apply.getCurrentnode() && apply.getCurrentnode().equals("manualActivity3")){
	    %>
	    <div style="font-size: 14px;padding-left: 10px;">
    		审批结果		    	
    		<input type="radio" name="radio-choice" value="0" checked="checked"/><label>确认成功</label>
    		<input type="radio" name="radio-choice" value="1"/><label>权限异常</label>
	    </div>
	    <%
	    	}else if(null != apply.getCurrentnode() && apply.getCurrentnode().equals("manualActivity311")){
	    		if(apply.getDefPowertype().indexOf("EIS") != -1 || apply.getDefPowertype().indexOf("FSSC") != -1){
	    %>
		    <div style="font-size: 14px;padding-left: 10px;">
	    		是否需要财务信息化审批		    	
	    		<input type="radio" name="radio-isNeed" value="1" /><label>是</label>
				<input type="radio" name="radio-isNeed" value="0" checked="checked"/><label>否</label>
		    </div>
	    <% 		
	    	
	    		}
	    	}
	    %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	var currNode = "<%=apply.getCurrentnode()%>";
	if(currNode == "用户确认"){
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