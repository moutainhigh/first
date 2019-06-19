<%@page import="com.deppon.wfs.workflow.domain.LegalSignBean"%>
<%@page import="com.deppon.wfs.workflow.domain.SignDataBean"%>
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
LegalSignBean info = (LegalSignBean)request.getAttribute("entity");
List<SignDataBean> detials = info.getDataCells();
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
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em> 法定代表人/负责人签字申请 </em></li>
			   <li> 申请人:<em><%=info.getApplyPersonName()%></em></li>
			   <li>申请人工号:<em><%=info.getApplyPersonId()%></em></li>	
			   
			   <li>所属部门:<em><%= info.getAppDept()%></em></li>	
			   <li>申请人职位:<em><%= info.getPosition()%></em></li>	
			   <li>所属公共事业部:<em><%=info.getDivisionName()%></em></li>	
			   <li>所属公共事务组:<em><%=info.getGroupName()%></em></li>	
			   <li>所属公共事务小组:<em><%=info.getTeamName() == null ? "" : info.getTeamName()%></em></li>	
			   <li>签字人:<em><%=info.getSignName()%></em></li>	
			   <li>签字人身份:<em><%="1".equals(info.getSignIdentity()) ? "法定代表人" : "分公司负责人 "%></em></li>	
			   <li>是否涉及财务信息披露:<em><%= "1".equals(info.getIsDisclosure()) ? "是" : "否"%></em></li>	
			   <%if("1".equals(info.getIsDisclosure())){%>
			   <li>数据来源部门:<em><%=info.getDatasourceDept()%></em></li>	
			   <li>工作流号:<em><%=info.getWorkflowNo() == null ? "" : info.getWorkflowNo()%></em></li>	
			    <%}%>
			   <li style="color: red">填写签字资料:</li>	
			    <%for (int i = 0 ;i < detials.size() ; i ++ ) {%>
			   <li <%= i == 0 ? "" :  "class='line'"%> >签字资料名称:<em><%=detials.get(i).getSigndataName()%></em></li>	
			   <li>签字资料份数:<em><%=detials.get(i).getSigndataNum()%></em></li>	
			    <%} %>
			   <li>申请事由:<em><%=info.getApplyReason()  %></em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>

</html>