<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.model.OAManagerRegularizationApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<%
	OAManagerRegularizationApply apply  = (OAManagerRegularizationApply)request.getAttribute("managerBecome");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   		<div class="ulBox2">
			<ul>
			    <li class="first">工作流号:
			        <em><%=apply.getProcessinstid() %>
			  	   		<input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">		  	   		
			   		</em>
			    </li>
			    <li>工作流:<em>
		   		  	管理人员转正/成长期通过申请工作流
			    </em></li>
				
				<li><em class="yellow">以下信息由申请人拟申请时填写</em></li>
				<li>申请人:<em><%=apply.getName() %></em></li>	
				<li>所在部门:<em><%=apply.getDept() %></em></li>	
				<li>工号：<em><%=apply.getUserid() %></em></li>				
				<li>
					事业部区域：<em>
					<%=apply.getEnterprisearea() %></em>
				</li>		
				<li>
					申请类别：<em>
					<%=apply.getApplytype() %></em>
				</li>							
				<%if(!"管理人员成长期通过".equals(apply.getApplytype())){%>
				<li>
					转正类别：<em>
					<%=apply.getApptype()%></em>
				</li>
				<%} else {%>
				<li>
					成长期通过类别：<em>
					<%=apply.getGrowththroughtype()%></em>
				</li>
				<li>
					岗位：<em>
					<%=apply.getPosition()%></em>
				</li>
				<li>
					考核等级：<em>
					<%=apply.getInspectionlevel()%></em>
				</li>
				<li>
					任命日期：<em>
					<%=FormatUtil.formatDate(apply.getAppointmentdate())%></em>
				</li>
				<li>
					转正工作流号：<em>
					<%=apply.getPositiveproid()%></em>
				</li>
				<li>
					转正日期：<em>
					<%=FormatUtil.formatDate(apply.getPositivedate())%></em>
				</li>				
				<%}%>
				<li>申请事由:<em><%=apply.getReason()==null?"":apply.getReason()%></em></li>
				<li><em class="yellow">以下信息由薪酬专员审批时填写</em></li>
				<li>是否谈判工资:<em><%=apply.getIstalkspay()==null?"":apply.getIstalkspay() %></em></li>	
				<li>谈判工资金额:<em><%=apply.getTalkspay()==null?"":apply.getTalkspay() %></em></li>
				<li>生效日期:<em><%=FormatUtil.formatDate(apply.getStartdate()) %></em></li>
	    	</ul>
	    </div>
	     <%@include file="approve_process.jsp" %>
	</div>
	<div>
		<ul>
			<%if("相应薪酬福利专员".equals(apply.getCurrentnode())){%>
				<li class="fyy-textCt"><em style="color: red">该节点暂不支持手机审批</em></li>
			<%}%>	
		</ul>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<%if("相应薪酬福利专员".equals(apply.getCurrentnode())){%>
		<script type="text/javascript">
		$(function(){
			document.getElementById("disagree_but").style.display = "none";
			document.getElementById("agree_but").style.display = "none";
			document.getElementById("rollback_but").style.display = "none";
			document.getElementById("approve_area").style.display = "none";
		});
		</script>
	<%}%>
</div>
</body>
</html>