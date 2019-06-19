<%@page import="com.deppon.montal.util.StringUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.Bankaccount"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.QualificationApplyBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
	tr.details, tr.qytr { display:none;}
	</style>
</head>
<body onload="autoShowApproval()">
<%
	Bankaccount info = (Bankaccount)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<input type="hidden" id="approval_url_special" value="<%=F_Constants.APPROVAL_SAVEENTITY_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>银行开户销户申请</td>
					</tr>
				   <tr>
					  <th>申请人姓名:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人部门:</th>
					  <td><%=info.getApplyDepartment()%></td>
				   </tr>
				   <tr>
					  <th>所属财务部:</th>
					  <td><%=info.getBelongFinanceDepartment()%></td>
				   </tr>
					 <tr>
							<!--WFS_APPLYTYPE -->
						  <th>申请类别:</th>
						  <td><%=info.getApplyType() %></td>
				   </tr>
					<tr>
						 <!-- WFS_ACCOUNT_TYPE -->
						  <th>账户类别:</th>
						  <td><%=info.getAccountType() %></td>
					 </tr>
				   <%if("对公户".equals(info.getAccountType())) {%>
						<tr>
							<!-- WFS_ACCOUNT_ATTRIBUTE -->
							<th>账号属性:</th>
							<td><%=info.getAccountAttribute() %></td>
						</tr>  			
				   <%} %>
				   <%if("分公司".equals(info.getAccountAttribute())){%>
					   <tr>
						  <th>挂靠营业部:</th>
						  <td><%=info.getSalesDepartment()%></td>
					   </tr>
				  <% } %>
				   <%if("销户".equals(info.getApplyType())) {%>
	 					<tr>
						  <th>银行账号:</th>
						  <td><%=info.getBankAccount()%></td>
					   </tr>
				   <%} %>				  
					 <tr>
					  <th>开户名:</th>
					  <td><%=info.getOpenAccountUser()%></td>
				   </tr>
				   <%if(("对公户".equals(info.getAccountType()))&&("开户".equals(info.getApplyType()))){%>
					 <tr>
					  <th>开户地区:</th>
					  <td><%=info.getOpenAccountAddress()==null?"":info.getOpenAccountAddress()%></td>
				   </tr>
				   <%} %>
				   <tr>
				   		<!-- WFS_OPEN_ACCOUNT_BANK -->
					  <th>开户银行:</th>
					  <td><%=info.getOpenAccountBank() %></td>
				   </tr>				   		
				   <%if("其他".equals(info.getOpenAccountBank())) {%>
					   <tr>
						  <th>填写银行名称:</th>
						  <td><%=info.getBankName()==null?"":info.getBankName()%></td>
					   </tr>
				   <%}%>
				<%if ("开户".equals(info.getApplyType())||"对公户".equals(info.getAccountType())&&"销户".equals(info.getApplyType())) {%>
					<tr>
						<!-- WFS_ACCOUNT_PROPERTY -->
						<th>账户性质:</th>
						<td><%=info.getAccountProperty() %></td>
					</tr>					
				<%}%>
				<%if ("开户".equals(info.getApplyType())){%>
					<tr>
					<!-- WFS_IN_OUT_PROPERTY -->
						<th>收支性质:</th>
						<td><%=info.getInOutProperty() %></td>
					</tr>
				<%} %>				   
 				<%if(!StringUtil.isEmptyOrNull(info.getBankAccountApproval())){%>				   
					   <tr>
						  <th>银行账号:</th>
						  <td><%=info.getBankAccountApproval()==null?"":info.getBankAccountApproval()%></td>
					   </tr>
					   <tr>
						  <th>开户支行:</th>
						  <td><%=info.getOpenAccountBranch()==null?"":info.getOpenAccountBranch()%></td>
					   </tr>
				  <%} %>
				  <%if(!StringUtil.isEmptyOrNull(info.getCurrentOrTeminal())){%>
					   <tr>
						  <th>开户日期:</th>
						  <td><%=FormatUtil.formatDate(info.getOpenAccountDate())%></td>
					   </tr>
					   	<tr>
						  <th>活期定期:</th>
						  <td><%=info.getCurrentOrTeminal()==null?"":info.getCurrentOrTeminal()%></td>
					   </tr>
				   <%} %>
				    <%if(!(info.getClosingDate()==null)){%>
					   <tr>
						  <th>销户日期:</th>
						  <td><%=FormatUtil.formatDate(info.getClosingDate())%></td>
					   </tr>
				   <%} %>
				    <%if(info.getAccountDeposit()!= "" && info.getAccountDeposit()!=null){%>
					   <tr>
						 <th>存款方式：</th>
						 <td><%=info.getAccountDeposit()%></td>
					  </tr>
				   <%} %>
 					   <tr>
						  <th>申请事由:</th>
						  <td><%=info.getApplyReason()%></td>
					   </tr>
						<tr class="manualActivity3" style="display: none">
							<th colspan="2"><a class="yellow" >添加审批信息</a></th>
						</tr>
						 <tr class="manualActivity3" style="display: none"  >
							 <th>银行账号：</th>
							 <td><input type="text" id="manualActivity3bankAccount" maxLength="50"/></td>
						  </tr>
						  <tr class="manualActivity3" style="display: none"  >
							 <th>开户支行：</th>
							 <td><input type="text" id="manualActivity3openAccountBranch" maxLength="50"/></td>
						  </tr>
						<tr class="manualActivity3" style="display: none">
							<td colspan="2" class="fyy-textRt"></td>
						</tr>
				<%@include file="approve_process.jsp" %>
	    	</table>
	    	<table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">该节点暂不支持手机审批</td></tr>
			</table>
	    </div>
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