<%@page import="com.deppon.montal.model.OASubSidiarySet"%>
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
OASubSidiarySet info = (OASubSidiarySet)request.getAttribute("subsidiaryset");

%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>
			   <li class="first">工作流号:<em><%=info.getProcessinstid() %></em>
			   <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
			   <input type="hidden" id ="type_id" value="subsidiaryset">
<%-- 		   <input type="hidden" id ="currentnode_id" value="<%=info.getCurrentnode() %>"> --%>
			   </li>				  
          <li>工作流:<em>子公司设立及变更申请<input type="hidden" id ="type_id" value="subsidiaryset"></em></li>
	    	<li>申请人姓名:<em><%=info.getName()%></em></li>
			<li>申请类别:<em><%=info.getType()%></em></li>
			<li>所属区域:<em><%=info.getArea()%></em></li>
			<li>当地财务部:<em><%=info.getFinancedep()%></em></li>
			<li>所属公共事务组:<em><%=info.getMatterteam()%></em></li>
			<li>子公司名称:<em><%=info.getSubcompany()%></em></li>
			<li> 所属薪酬组:<em><%=info.getCompensation()%></em></li>
			<%if("变更".equals(info.getType())){%>
			<li> 变更类型:<em><%=info.getUpdatetype()%></em></li>
			<li> 变更前内容:<em><%=info.getBeforeupdate()%></em></li>
			<li>变更后内容:<em><%=info.getAfterupdate()%></em></li>
			<%} %>
			<li>申请事由:<em><%=info.getReason()==null?"":info.getReason()%></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
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
</html>