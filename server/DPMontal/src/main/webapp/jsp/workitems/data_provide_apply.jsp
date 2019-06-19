<%@page import="com.deppon.montal.model.OADataProvideApply"%>
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
	OADataProvideApply info = (OADataProvideApply)request.getAttribute("OADataProvideApply");
	String target = "1".equals(info.getTarget())?"工资核算小组":
	    			"2".equals(info.getTarget())?"考核小组":
	    			"3".equals(info.getTarget())?"营业部经理调薪":
	    			"4".equals(info.getTarget())?"质量处理小组":"";
	boolean bool = "考核小组考核专员审批".equals(info.getCurrentnode())||"薪资核算组经理审批".equals(info.getCurrentnode());
%>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid()%></td></tr>
				<tr><th>工作流:</th><td>数据提供审批</td></tr>
				<tr><th>申请人姓名:</th><td><%=info.getName() %></td></tr>
				<tr><th>数据提供给:</th><td><%=target%></td></tr>
			<%if("3".equals(info.getTarget())){ %>
				<tr><th>所属事业部:</th><td><%=info.getArea()%></td></tr>
			<%} %>
			<tr><th>申请事由:</th><td><%=info.getWhyapply()%></td></tr>
	    	</table>
	    	<%@include file="approve_process.jsp" %>
	    	<%if(bool) {%>
	    	<table width="100%">
	    	 <tr>
	    	 	<th>是否同意并结束:</th>
				<td>
					<input type="radio" name="agree-end" value="5"><label>是</label>
				 	<input type="radio" name="agree-end" value="0" checked="checked"><label>否</label>
				 <td>
	    	 </tr>
	    	</table>
	    	<%} %>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">
$(function(){
	var bool=<%=bool%>;
	if(bool){
		$("#agree_but").unbind();
		$("#agree_but").click(function(){
			agreeBut();
		});
	}
});
function agreeBut(){
	var v_id =  $('input[name="agree-end"]:checked').val();
	  if("0" == v_id){
		  $("#app_val").val("0");
		  $("#confirm_msg").html("您当前选择【同意】该工作流，是否确定提交？");
		  $("#app_window").fadeIn(600);
		  $(".tipsWinCnt").show();
	  } else if("5" == v_id){
		  $("#app_val").val("5");
		  $("#confirm_msg").html("您当前选择【同意并结束】该工作流，是否确定提交？");
		  $("#app_window").fadeIn(600);
		  $(".tipsWinCnt").show();
	  }
}
</script>
</html>