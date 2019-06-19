<%@page import="com.deppon.wfs.workflow.domain.CourseDevelopUpdateAuditBean"%>
<%@page import="com.deppon.montal.conf.domain.DictEntry"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
		<%@include file="/common_ios.jsp" %>
</head>
</head>
<%
//CourseDevelopUpdateAuditBean info = (CourseDevelopUpdateAuditBean)request.getAttribute("OALessonApply");
CourseDevelopUpdateAuditBean info = (CourseDevelopUpdateAuditBean)request.getAttribute("entity");
CourseDevelopUpdateAuditBean info1 = info.getReSetEntity();
// List<DictEntry> toCourse = (List<DictEntry>) request.getAttribute("toCourse");
// List<DictEntry> isHaveCourse = (List<DictEntry>) request.getAttribute("isHaveCourse");
//CourseDevelopUpdateAuditBean num = (CourseDevelopUpdateAuditBean) request.getAttribute("queryProcessinstid");
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
   	<div class="ulBox2">
			<ul>
				<li class="first" >工作流号:<em><%=info.getProcessinstid() %></em></li>
				<li>工作流:<em>课程研发/更新/审核申请</em></li>
				<li>申请人:<em><%=info.getApplyPersonName()%></em></li>
				<li>申请人工号:<em><%=info.getApplyPersonId()%></em></li>
				<li>所在部门:<em><%=info.getApplyDept()%></em></li>
				<%if("research".equals(info.getApplyCourseType())){%>
					<li>申请课程类型:<em>课程研发申请</em></li>
				<%}else if("check".equals(info.getApplyCourseType())){ %>
					<li>申请课程类型:<em>课程审核申请</em></li>
				<%}else if("update".equals(info.getApplyCourseType())){ %>
					<li>申请课程类型:<em>课程更新申请</em></li>
				<%}else{ %>
					<li>申请课程类型:<em><%=info.getApplyCourseType()%></em></li>
				<%} %>
				<li>申请课程名称:<em><%=info.getCourseName()%></em></li>
				<li>所属培训管理组:<em><%=info.getTrainManagementGroup()%></em></li>
				<% if("check".equals(info.getApplyCourseType())) {%>
				<li>课程研发/更新申请工作流号:<em><a style="color:blue;"  href="#showQueryDetails" onclick="workflowdetail()" id="jumpUrl"><%=info.getDevlopUpdateId()%></a></em></li>
				<%} %>
				<li>申请事由:<em><%=info.getReason()%></em></li>
		 	</ul>
		 	
		 	<%if(info1.getApplyPersonName()!=""){%>
		 	<div class="showQueryDetails" style="display: none"> 
		 	<h4 class="showQueryDetails yellow" id="showQueryDetails" style="display: none">以下是工作流号：<%=info.getDevlopUpdateId()%>,校验详情</h4>
			 	<ul class="queryDetails"  >
			 		<li class="first queryDetails" >工作流号:<em><%=info1.getProcessinstid() %></em></li>
					<li class="queryDetails">申请人:<em><%=info1.getApplyPersonName()%></em></li>
					<li class="queryDetails">申请人工号:<em><%=info1.getApplyPersonId()%></em></li>
					<li class="queryDetails">所在部门:<em><%=info1.getApplyDept()%></em></li>
						<%if("research".equals(info1.getApplyCourseType())){%>
							<li>申请课程类型:<em>课程研发申请</em></li>
						<%}else if("check".equals(info1.getApplyCourseType())){ %>
							<li>申请课程类型:<em>课程审核申请</em></li>
						<%}else if("update".equals(info1.getApplyCourseType())){ %>
							<li>申请课程类型:<em>课程更新申请</em></li>
						<%}else{ %>
							<li>申请课程类型:<em><%=info1.getApplyCourseType()%></em></li>
						<%} %>
					<li class="queryDetails">申请课程名称:<em><%=info1.getCourseName()%></em></li>
					<li class="queryDetails">所属培训管理组:<em><%=info1.getTrainManagementGroup()%></em></li>
					<li class="queryDetails">申请事由:<em><%=info1.getReason()%></em></li>
			 	</ul>
		 	<%} else{%>
		 		<ul class="queryDetails">
		 			<li class="queryDetails"> <b>该工作流号不存在！</b></li>
		 		</ul>
		 	<%}%>
		 	 <h4 class="showQueryDetails yellow"  onclick="closeDetails()" style="display: none">关闭工作流号校验详情</h4>	
		 	 </div>
    	</div>
    	<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
    <input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
    
<%-- 		 <input type="hidden" id="num" value="<%=num%>"> --%>
</div>
</body>
<script type="text/javascript">
// 	function workflowdetail(){
		
// 		var testUrl = $("#isHaveCourse").val();
// 		var busino = $("#num").val();
// 		var goUrl = $("#toCourse").val();
// 		var workId = $("#workid").val();
// 		$.ajax({
// 			type:"GET",
<%-- 			url:"<%=basePath%>/curriculumAudit", --%>
// 			data:"workId="+workId,
// 		   	cache:false,
// 			success:function(msg){
// 				var html = msg;
// 				if (html == ""){
// 					html = "无详细信息";
// 				}
// 				$("#queryRentEntry_id").hide();
// 				$("#queryRentEntry_id").after(html);
// 			}
// 		});
		//1、请求http://192.168.20.166/wfs/workflowmsg/courseDevelopUpdateAuditQueryAction.action?processinstid=1233432  这个页面
		//2、获取返回值,返回值为busino
		//document.getElementById('jumpUrl').href = 'http://192.168.20.166/wfs/workflowmsg/courseDevelopUpdateAuditQueryAction.action?processinstid=1233432';
		//var str = $("#jumpUrl").href("http://192.168.20.166/wfs/workflowmsg/courseDevelopUpdateAuditQueryAction.action?processinstid=1233432 ");
		
		//3、判断返回值
// 		if(str == null || str == ''){
// 			alert("工作流不存在!");
// 	    	return;
// 		}
		//3、判断返回值
// 		if(busino == null || busino == ''){
// 			alert("工作流不存在!");
// 	    	return;
// 		}
		
// 		//4、返回值不为null或者‘’时，访问http://192.168.20.166/wfs/workflow/getBizEntityByProcessinstid.action?&processInstId="+processInstID+"&processDefName=com.deppon.bpms.module.wfs.bpsdesign.personnel.curriculumDevelopmentUpdateAudit&busino="+busino
// 		var url = goUrl+"?&processInstId="+$("#workid").val()+"&processDefName=com.deppon.bpms.module.wfs.bpsdesign.personnel.curriculumDevelopmentUpdateAudit&busino="+str;
		
// 	}
	$(document).ready(function(){
		/* $("#jumpUrl").clike(function(){
			$("#queryDetails").show();
			$("#queryDetails").slideDown(200);
		}); */
	});
	function workflowdetail(){
		$(".showQueryDetails").slideDown(200);
		$('.queryDetails').show();
	};
	function closeDetails(){
		$(".showQueryDetails").slideUp(200);
		$('.queryDetails').hide();
	};
	

</script>
</html>