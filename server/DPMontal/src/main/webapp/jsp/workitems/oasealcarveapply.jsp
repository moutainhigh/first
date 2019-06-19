<%@page import="com.deppon.montal.model.OASealCarveApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>
</head>
<%
OASealCarveApply info = (OASealCarveApply)request.getAttribute("oasealcarveapply");
%>
<body>
<div id="list">
	<%@include file="wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流号:</th><td id="workid"><%=info.getProcessinstid() %></td></tr>
				<tr><th>工作流:</th><td>刻章申请</td></tr>
				<tr><th>申请人:</th><td><%=info.getName()%></td></tr>
				<tr><th>工号:</th><td><%=info.getUserid()%></td></tr>
				<tr><th>部门:</th><td><%=info.getDeptname()%></td></tr>
				<tr><th>所属事业部:</th><td><%=info.getArea()%></td></tr>
				<tr><th>所属子公司:</th><td><%=info.getSubcom()%></td></tr>
				<tr><th>印章类型:</th><td><%=info.getSealtype()%></td></tr>
				<tr><th>申请事由</th><td><%=info.getReason()==null?"":info.getReason()%></td></tr>
				<tr class="yellow"><th colspan="2">刻章信息</tr>
				<%if(info.getSublist()!= null){
					for(int i=0;i<=info.getSublist().size()-1 ;i++){
						OASealCarveApply temp = (OASealCarveApply)info.getSublist().get(i);%>
					<tr class="topLine"><th>印章名称:</th><td><%=temp.getSealname()%></td></tr>
					<tr><th>是否首次刻制:</th><td><%=temp.getIsfirstcarve()%></td></tr>
					<tr><th>发放单位:</th><td><%=temp.getProvidecom()%></td></tr>
					<tr><th>是否在公安局备案</th><td><%=temp.getIsrecordinps()%></td></tr>
				<%	}
				} %>
		 </table>
		<%@include file="approve_process.jsp" %>
		
						 <%
			  if("逐级审批至高级经理".equals(info.getCurrentnode())){
			 %>
			 <table>
			 	<tr>
				 	<th>请选择你的职位级别:</th>
				 	<td>
					 	<input id="level" type="radio" name="level" value="1" onclick="checkLevel()"><label>经理</label>
					 	<input id="level" type="radio" name="level" value="2" checked="checked" onclick="checkLevel()"><label>高级（区域）经理</label>
				 	<td>
				 </tr>
			 	<tr id="sealneed">
				 	<th>是否需要总监(大区总)审批:</th>
				 	<td>
					 	<input type="radio" name="need" value="0" checked="checked"><label>是</label>
					 	<input type="radio" name="need" value="1" ><label>否</label>
				 	<td>
				 </tr>				 
			 </table>
		 	<% } %>
		
    	</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	
</div>
<script type="text/javascript">
	function checkLevel(){
		var level = $('input[name="level"]:checked').val();
		if(level=="1"){
			document.getElementById("sealneed").style.display = "none";
			var needobject = document.getElementsByName("need");
			needobject[1].checked = true;
		}else{
			document.getElementById("sealneed").style.display = "table-row";
			var needobject = document.getElementsByName("need");
			needobject[0].checked = true;
		}
	}

</script>
</body>
</html>