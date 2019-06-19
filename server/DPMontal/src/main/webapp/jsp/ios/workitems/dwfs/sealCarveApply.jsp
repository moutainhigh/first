<%@page import="com.deppon.wfs.workflow.domain.SealCarveApplyBean"%>
<%@page import="com.deppon.wfs.workflow.domain.SealCarveApplyDetailBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
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
SealCarveApplyBean info = (SealCarveApplyBean)request.getAttribute("entity");
List<SealCarveApplyDetailBean> line = info.getSealCarveDetail();
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			   <li>工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		  刻章申请
			   </em></li>
					  <li>申请人:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号：<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
					 
					  <li>部门：<em>
					  <%=info.getDeptName()%></em>
				   </li>
				   
				   	  <li>所属事业部 ：<em>
					  <%=info.getDivision()%></em>
				   </li>
				     <li>所属财务部:<em>
					  <%=info.getFinanceDept()%></em>
				   </li>
				    <li>所属公共事务组:<em>
					  <%=info.getAffairsSection()%></em>
				   </li>
					 <%if("".equals(info.getSubcom()) || info.getSubcom() == null) {%>
					  <li>印章类型：<em>
					  <%=info.getSealType()%></em>
				   </li>
					 <%} else {%>
					  <li>所属子公司：<em>
					  <%=info.getSubcom()%></em>
				   </li>
				   
				   	  <li>印章类型 ：<em>
					  <%=info.getSealType()%></em>
				   </li>
				   <%}%>
				  <li><em class="yellow">刻章申请明细</em></li>
				    <%for (int i = 0 ;i < line.size() ; i ++ ) {%>
					   <li <%= i == 0 ? "" :  "class='line'"%> >印章名称:<em><%=line.get(i).getSealName()%></em></li>	
					   
					   <li>是否首次刻制:<em><%=line.get(i).getFirstCarve()%></em></li>	
					   <li>发证日期(营业执照):<em><%=FormatUtil.formatDate(line.get(i).getProvideTime())%></em></li>	
			    <%} %>
				   	
				     <li>申请事由:<em>
					  <%=info.getApplyReason()%></em>
			 </ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>