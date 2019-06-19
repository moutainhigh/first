<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectapprovalVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectApprovalDEntryEntity"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 ProjectapprovalVo temp = info.getProjectapprovalVo();
 ProjectApprovalEntity base = temp.getProjectApprovalEntity();
 ProjectApprovalEntryEntity[] items1 = temp.getProjectApprovalEntryEntityList();
 ProjectApprovalDEntryEntity[] items2 = temp.getProjectApprovalDEntryEntityList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-工程项目立项单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>项目编号:<em><%=base.getNumber() %></em></li>
			   	<li>项目名称:<em><%=base.getName()%></em></li>
			   	<li>项目状态:<em><%=base.getProjectstatus()%></em></li>
				<li>所属事业部:<em><%=base.getDivision()%></em></li>
			   	<li>项目类型:<em><%=base.getProjecttpye()%></em></li>
			   	<li>单据状态:<em><%=base.getState()%></em></li>
				<li>申请时间:<em><%=base.getProapplitimeStr()%></em></li>
			   	<li>项目地点:<em><%=base.getProjectseat()%></em></li>
			   	<li>申请部门:<em><%=base.getCreateorg()%></em></li>
			   	<li>总工程编号:<em><%=base.getTotalprojectno()%></em></li>
			   	<li>预计开始时间:<em><%=base.getProjectexpstartStr()%></em></li>
			   	<li>项目经理:<em><%=base.getProjectmanager()%></em></li>
			   	<li>预计结束时间:<em><%=base.getProjectexpendStr()%></em></li>
			    <li>概算金额:<em><%=base.getBudgetamountStr()%></em></li>
			    <%if (base.getNeedrecovery() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>是否需要复原</li>
				<%} else { %>
					<li><input type="checkbox" />是否需要复原</li>
				<%}%>
				<%if (base.getWheneeddesign() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>是否做办公深度设计</li>
				<%} else { %>
					<li><input type="checkbox" />是否做办公深度设计</li>
				<%}%>
				<%if (base.getInternalaudit() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>内部审计</li>
				<%} else { %>
					<li><input type="checkbox" />内部审计</li>
				<%}%>
				<%if (base.getExteraudit() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>外部审计</li>
				<%} else { %>
					<li><input type="checkbox" />外部审计</li>
				<%}%>
				<%if (base.getPromanaout() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>工程管理服务外包</li>
				<%} else { %>
					<li><input type="checkbox" />工程管理服务外包</li>
				<%}%>
				<%if (base.getFireapproval() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>消防报批</li>
				<%} else { %>
					<li><input type="checkbox" />消防报批</li>
				<%}%>
				<%if (base.getWhetherfor() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>是否甲供</li>
				<%} else { %>
					<li><input type="checkbox" />是否甲供</li>
				<%}%>
				<%if (base.getDesignout() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>设计外包</li>
				<%} else { %>
					<li><input type="checkbox" />设计外包</li>
				<%}%>
				<%if (base.getConstout() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>施工外包</li>
				<%} else { %>
					<li><input type="checkbox" />施工外包</li>
				<%}%>
				<%if (base.getSignsapproval() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>招牌报批</li>
				<%} else { %>
					<li><input type="checkbox" />招牌报批</li>
				<%}%>
				<%if (base.getBuild() == 1) { %>
			    	<li><input type="checkbox" checked="checked"/>报建</li>
				<%} else { %>
					<li><input type="checkbox" />报建</li>
				<%}%>
				<li>非网点分类:<em><%=base.getNotpointtype()%></em></li>
				<li>分部工程:<em><%=base.getEngindivision()%></em></li>
				<li>项目级别:<em><%=base.getProjectlevel()%></em></li>
				<li>备注:<em><%=base.getRemarks()%></em></li>
          	</ul>
        </div>
        
        <h4 class="yellow">其他信息-项目交付范围</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < items1.length; i++ ) {%>
					<li  <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				    <li>交付项:<em><%= items1[i].getDeliveryitem()%></em></li>
				    <li>接受方部门:<em><%= items1[i].getOrgName()%></em></li>
				   	<li>预计接受时间:<em><%= items1[i].getEstideliverydateStr()%></em></li>
				    <li>备注:<em><%= items1[i].getNoteen()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow">其他信息-项目干系人</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < items2.length; i++ ) {%>
					<li  <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				   	<li>姓名:<em><%= items2[i].getPerson()%></em></li>
				    <li>部门姓名:<em><%= items2[i].getOrgName()%></em></li>
				   	<li>项目角色:<em><%= items2[i].getProjectrole()%></em></li>
				    <li>工作职责:<em><%= items2[i].getJobRespon()%></em></li>
				    <li>联系电话:<em><%= items2[i].getTelephoneNo()%></em></li>
				    <li>邮箱:<em><%= items2[i].getEmail()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>