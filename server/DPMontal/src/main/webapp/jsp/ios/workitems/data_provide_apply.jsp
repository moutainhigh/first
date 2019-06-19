<%@page import="com.deppon.montal.model.OADataProvideApply"%>
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
	OADataProvideApply info = (OADataProvideApply)request.getAttribute("OADataProvideApply");
	String target = "1".equals(info.getTarget())?"工资核算小组":
	    			"2".equals(info.getTarget())?"考核小组":
	    			"3".equals(info.getTarget())?"营业部经理调薪":
	    			"4".equals(info.getTarget())?"质量处理小组":"";
	boolean bool = "考核小组考核专员审批".equals(info.getCurrentnode())||"薪资核算组经理审批".equals(info.getCurrentnode());
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2"> 
    	<div class="ulBox2">
	    	<ul>
	    		<li class="first">工作流号:<em><%=info.getProcessinstid()%></em></li>
				<li>工作流:<em>数据提供审批</em></li>
				<li>申请人姓名:<em><%=info.getName() %></em></li>
				<li>数据提供给:<em><%=target%></em></li>
			<%if("3".equals(info.getTarget())){ %>
				<li>所属事业部:<em><%=info.getArea()%></em></li>
			<%} %>
			<li>申请事由:<em><%=info.getWhyapply()%></em></li>
	    	</ul>
	    </div>
	    <%@include file="approve_process.jsp" %>
	    <%if(bool){%>
	    	<div class="ulBox2">
		     	<ul>
					 <li class="first">
					 	是否同意并结束:
					 	<em>
						 	<input type="radio" name="agree-end" value="5"><label>是</label>
						 	<input type="radio" name="agree-end" value="0" checked="checked"><label>否</label>
					 	</em>
					 </li>
		     	</ul>
	     	</div>
	    <%} %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
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