<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.DeptInfoModify"%>
<%@page import="com.deppon.wdgh.inteface.domain.ModifyDeptDetail"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<%
QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
DeptInfoModify base = infoNew.getDeptInfoModify();
List<ModifyDeptDetail> modifyDeptDetail = base.getModifyDeptDetail();
%>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<li>工作流:<em>营业部信息更改申请</em></li>
				<li>申请人姓名:<em><%= base.getCreateUserName()%></em></li>
				<li>所属事业部:<em><%=base.getBusinessDivsionName()%></em></li>
				
				<li><em class="yellow">明细信息</em></li>
				<%
				int modifyDeptDetailsize = modifyDeptDetail == null?0:modifyDeptDetail.size();
				for(int i = 0; i < modifyDeptDetailsize; i++ ) {
					ModifyDeptDetail detail = modifyDeptDetail.get(i);
				%>
				<li <%=i==0?"":"class='line'" %>>部门名称:<em><%= detail.getDeptName()%></em></li>
				<% if("DEPTINFO_MODIFY_TYPE_DEPT_NAME".equals(detail.getModifyType())){%>
					 <li>修改类型:<em>部门名称</em></li>
					 <%} else if("DEPTINFO_MODIFY_TYPE_DEPT_TEL".equals(detail.getModifyType())){%>
					<li>修改类型:<em>部门电话</em></li>
					<%}  else if("DEPTINFO_MODIFY_TYPE_DEPT_FAX".equals(detail.getModifyType())){%>
					<li>修改类型:<em>部门传真</em></li>
					<%}  else if("DEPTINFO_MODIFY_TYPE_DEPT_ADDRESS".equals(detail.getModifyType())){%>
					<li>修改类型:<em>部门地址</em></li>
					<%}  else {%>
					<li>修改类型:<em><%= detail.getModifyType()%></em></li>
					<%} %>
				    <li>修改前内容:<em><%= detail.getBeforeContent()%></em></li>
				    <li>修改后内容:<em><%= detail.getAfterContent()%></em></li>
				<%
					}
				%>		
				<li>申请事由:<em><%=base.getReason()%></em></li>
		  </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
</script>
</body>
</html>