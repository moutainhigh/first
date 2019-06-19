<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.ResignationBean"%>
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
ResignationBean info = (ResignationBean)request.getAttribute("entity");
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
					<input type="hidden" id="approval_url" value="<%=F_Constants.RESIGN_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		    辞职申请
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号:<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
					  <li>申请人职位:<em>
					  <%=info.getPosition()%></em>
				   </li>
				    <li>所属部门:<em>
					  <%=info.getAppDept()%></em>
				   </li>
					 
					  <li>辞职类型:<em>
					  <%=info.getResignTypeName()%></em>
				   </li>
				   
					  <li>入职日期:<em>
					  <%=info.getJoinDateStr()%></em>
				   </li>
				     <%if("1".equals(info.getResignType())){ %>
					  <li>直属上级级别:<em>
					  <%=info.getSuperiorDegreeName()%></em>
				   </li>
					 <% }%> 
					  <li>工作年限:<em>
					  <%=info.getWorkYears()%></em>
				   </li>
					<%if("2".equals(info.getSuperiorDegree())|| "3".equals(info.getSuperiorDegree())){%> 
					  <li>岗位类型:<em>
					  <%=info.getPostsortName()%></em>
				   </li>
					 
					  <%if("2".equals(info.getSuperiorDegree())){%>
					   <% if("2".equals(info.getPostsort())){%>
					    <li>是否管理岗位:<em>
					     <%=info.getIsManagerName()%></em>
				       </li>
				     <%}%>
					<%}%>
				   <%}%>
					  <li>所在人事部:<em>
					  <%=info.getPersonnelDeptName()%></em>
				   </li>
				   
					  <li>辞职原因:<em>
					 <%=info.getResignReason()==null?"":info.getResignReason()%></em>
				   </li>				   
				   
				   
					  <li>差错编号:<em>
					  <%=info.getErrorNo()==null?"":info.getErrorNo()%></em>
				   </li>
				 
				   
					  <li>申请事由:<em>
					  <%=info.getApplyReason()%></em>
				   </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	
	<div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">该节点暂不支持手机审批</em></li>
		</ul>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
$(function(){
	var activitydefid=$('#activitydefid').val();
	if(activitydefid=="manualActivity2"){
		$('#disagree_but').hide();
		$('#agree_but').text("已回收");
	};
	if(activitydefid=="manualActivity6"){
		$('#msg').show();
		document.getElementById("disagree_but").style.display = "none";
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}
});
</script>
</body>
</html>