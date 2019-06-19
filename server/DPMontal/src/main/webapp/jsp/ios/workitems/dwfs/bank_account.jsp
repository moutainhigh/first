<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.StringUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.Bankaccount"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
		.manualActivity3 input {
			border: 1px solid #ccc;
			width: 55%;
		}
	</style>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
Bankaccount info = (Bankaccount)request.getAttribute("entity");
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
					<input type="hidden" id="approval_url_special" value="<%=F_Constants.APPROVAL_SAVEENTITY_URL%>">	  	   		
			   		</em>
			   </li>
			   <li>工作流:<em> 银行开户销户申请</em></li>
			   	<li>
					  申请人姓名:<em>
					  <%=info.getApplyPersonName()%></em>
				   </li>
					 <li>
					  申请人部门:<em>
					  <%=info.getApplyDepartment()%></em>
				   </li>
				   <li>
					  所属财务部:<em>
					  <%=info.getBelongFinanceDepartment()%></em>
				   </li>
					 <li>
							<!--WFS_APPLYTYPE -->
						  申请类别:<em>
						  <%=info.getApplyType() %></em>
				   </li>
					<li>
						 <!-- WFS_ACCOUNT_TYPE -->
						  账户类别:<em>
						  <%=info.getAccountType() %></em>
					 </li>
				   <%if("对公户".equals(info.getAccountType())) {%>
						<li>
							<!-- WFS_ACCOUNT_ATTRIBUTE -->
							账号属性:<em>
							<%=info.getAccountAttribute() %></em>
						</li>  			
				   <%} %>
				   <%if("分公司".equals(info.getAccountAttribute())){%>
					   <li>
						  挂靠营业部:<em>
						  <%=info.getSalesDepartment()%></em>
					   </li>
				  <% } %>
				   <%if("销户".equals(info.getApplyType())) {%>
	 					<li>
						  银行账号:<em>
						  <%=info.getBankAccount()%></em>
					   </li>
				   <%} %>				  
					 <li>
					  开户名:<em>
					  <%=info.getOpenAccountUser()%></em>
				   </li>
				   <%if(("对公户".equals(info.getAccountType()))&&("开户".equals(info.getApplyType()))){%>
					 <li>
					  开户地区:<em>
					  <%=info.getOpenAccountAddress()==null?"":info.getOpenAccountAddress()%></em>
				   </li>
				   <%} %>
				   <li>
				   		<!-- WFS_OPEN_ACCOUNT_BANK -->
					  开户银行:<em>
					  <%=info.getOpenAccountBank() %></em>
				   </li>				   		
				   <%if("其他".equals(info.getOpenAccountBank())) {%>
					   <li>
						  填写银行名称:<em>
						  <%=info.getBankName()==null?"":info.getBankName()%></em>
					   </li>
				   <%}%>
				<%if ("开户".equals(info.getApplyType())||"对公户".equals(info.getAccountType())&&"销户".equals(info.getApplyType())) {%>
					<li>
						<!-- WFS_ACCOUNT_PROPERTY -->
						账户性质:<em>
						<%=info.getAccountProperty() %></em>
					</li>					
				<%}%>
				<%if ("开户".equals(info.getApplyType())){%>
					<li>
					<!-- WFS_IN_OUT_PROPERTY -->
						收支性质:<em>
						<%=info.getInOutProperty() %></em>
					</li>
				<%} %>				   
 				<%if(!StringUtil.isEmptyOrNull(info.getBankAccountApproval())){%>				   
					   <li>
						  银行账号:<em>
						  <%=info.getBankAccountApproval()==null?"":info.getBankAccountApproval()%></em>
					   </li>
					   <li>
						  开户支行:<em>
						  <%=info.getOpenAccountBranch()==null?"":info.getOpenAccountBranch()%></em>
					   </li>
				  <%} %>
				  <%if(!StringUtil.isEmptyOrNull(info.getCurrentOrTeminal())){%>
					   <li>
						  开户日期:<em>
						  <%=FormatUtil.formatDate(info.getOpenAccountDate())%></em>
					   </li>
					   	<li>
						  活期定期:<em>
						  <%=info.getCurrentOrTeminal()==null?"":info.getCurrentOrTeminal()%></em>
					   </li>
				   <%} %>
				    <%if(!(info.getClosingDate()==null)){%>
					   <li>
						  销户日期:<em>
						  <%=FormatUtil.formatDate(info.getClosingDate())%></em>
					   </li>
				   <%} %>
				    <%if(info.getAccountDeposit()!= "" && info.getAccountDeposit()!=null){%>
					   <li>
						 存款方式：<em>
						 <%=info.getAccountDeposit()%></em>
					  </li>
				   <%} %>
 					   <li>
						  申请事由:<em>
						  <%=info.getApplyReason()%></em>
					   </li>
			</ul>
		</div>
		<h4 class="yellow manualActivity3" style="display: none">添加审批信息</h4>
   		<div class="ulBox2 manualActivity3" style="display: none">
   			<ul>				  
         			<li>银行账号:<em><input type="text" id="manualActivity3bankAccount" maxLength="50"/></em></li>
         			<li>开户支行:<em><input type="text" id="manualActivity3openAccountBranch" maxLength="50"/></em></li>
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
$(document).ready(function(){
	var activitydefid = $('#activitydefid').val();
	if(activitydefid=="manualActivity5"||activitydefid=="manualActivity1"||activitydefid=="manualActivity4"||activitydefid=="manualActivity6"||activitydefid=="manualActivity7"){
		$('#msg').show();
		document.getElementById("disagree_but").style.display = "none";
		document.getElementById("agree_but").style.display = "none";
		document.getElementById("rollback_but").style.display = "none";
		document.getElementById("approve_area").style.display = "none";
	}else if (activitydefid=="manualActivity3"){
		$('.manualActivity3').show();
	}
});
</script>
</body>
</html>