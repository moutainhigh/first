<%@page import="java.math.BigDecimal"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.shared.domain.PayApplyEntryVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.shared.domain.PayApplyVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.shared.domain.ApprovalInfoVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.PayApplyWorkflowData"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="java.util.ArrayList"%>
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
<body>
<%
	PayApplyWorkflowData info = (PayApplyWorkflowData)request.getAttribute("entity");
	Auditparameters auditparameters = (Auditparameters)request.getAttribute("auditparameters");
	ApprovalInfoVo[] arrays = info.getApprovalInfoVoList();
	PayApplyVo payapplyvo = info.getPayApplyVo();
	PayApplyEntryVo[] entities = info.getPayApplyEntryVoList();
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	   <input type="hidden" id="workid" value="<%=auditparameters.getWfInstanceId()%>">
	   <input type="hidden" id="docId" value="<%=auditparameters.getDocId()%>">
	   <input type="hidden" id="workItemId" value="<%=auditparameters.getWfWorkItemId()%>">
	   <input type="hidden" id="wfState" value="<%=auditparameters.getWfState()%>">
	   <input type="hidden" id="type" value="<%=F_Constants.DLSP_PAYMENT_APPLY%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>付款申请单</td>
					</tr>
				   <tr>
					  <th>付款申请单号:</th>
					  <td><%=payapplyvo.getPayApplyNo()%></td>
				   </tr>
					 <tr>
					  <th>公司:</th>
					  <td><%=payapplyvo.getCompanyName()%></td>
				   </tr>
				   <tr>
					  <th>单据日期:</th>
					  <td><%=payapplyvo.getBizDateStr().substring(0, 10)%></td>
				   </tr>
					 <tr>
					  <th>申请人:</th>
					  <td><%=payapplyvo.getUserName()%></td>
				   </tr>
					 <tr>
					  <th>审批类型:</th>
					  <td><%=payapplyvo.getApprovalType()%></td>
				   </tr>
				   <tr>
					  <th>发票抬头:</th>
					  <td><%=entities[0].getPayBank()%></td>
				   </tr>
				   
				   <tr>
					  <th>收款方:</th>
					  <td><%=entities[0].getAsstName()%></td>
				   </tr>
					 <tr style="color: red">
					  <th>请款事由:</th>
					  <td><%=payapplyvo.getRequestReason()==null?"":payapplyvo.getRequestReason()%></td>
				   </tr>
				   <tr>
					  <th>付款情况:</th>
					  <td><%=payapplyvo.getSituation()%></td>
				   </tr>
					 <tr>
					  <th>票据单号:</th>
					  <td><%=payapplyvo.getBillNumber()==null?"":payapplyvo.getBillNumber()%></td>
				   </tr>
					 <tr>
					  <th>到期日期:</th>
					  <td><%=payapplyvo.getDeadLineStr()==null?"":payapplyvo.getDeadLineStr()%></td>
				   </tr>
				   <tr>
					  <th>申请金额:</th>
					  <td><%=new DecimalFormat("0.00").format(payapplyvo.getRequestAmount())%></td>
				   </tr>				   
				   
				   <tr>
					  <th>审批金额:</th>
					  <td><%=new DecimalFormat("0.00").format(payapplyvo.getAuditAmount())%></td>
				   </tr>
				   <tr>
					  <th>申请金额大写:</th>
					  <td><%=payapplyvo.getCurrencyUpCase()%></td>
				   </tr>
				   
					<tr>
					  <th>币种:</th>
					  <td><%=payapplyvo.getCurrencyName()%></td>
				   </tr>
					<table width="100%">
						<tr id="appstr">
							<th colspan="2"><a class="yellow" onclick="showDetails()">查看物品明细分录</a></th>
						</tr>
							<% for(int i = 0 ; i< entities.length ; i++) {
								%><tr class="details topLine"><th>付款类型:</th><td><%=entities[i].getPayType()%></td></tr><%
								%><tr class="details"><th>来往类型:</th><td><%=entities[i].getAsstType() %></td></tr><%
								%><tr class="details"><th>往来户编码:</th><td><%=entities[i].getAsstNo() %></td></tr><%
								%><tr class="details"><th>往来户名称:</th><td><%=entities[i].getAsstName() %></td></tr><%
								%><tr class="details"><th>审批付款金额:</th><td><%=new DecimalFormat("0.00").format(entities[i].getReqAmount())%></td></tr><%
								%><tr class="details"><th>审批金额:</th><td><%=new DecimalFormat("0.00").format(entities[i].getAuditAmount()) %></td></tr><%
								%><tr class="details"><th>付款日期:</th><td><%=entities[i].getPayDayStr().substring(0, 10)%></td></tr><%
								%><tr class="details"><th>未付款金额:</th><td><%=new DecimalFormat("0.00").format(entities[i].getUnPayAmount())%></td></tr><%
								%><tr class="details"><th>往来户银行账号:</th><td><%=entities[i].getAccountBankNo() %></td></tr><%
								%><tr class="details"><th>往来户开户银行:</th><td><%=entities[i].getAccountBank() %></td></tr><%
								%><tr class="details"><th>结算方式:</th><td><%=entities[i].getBanlanceType() %></td></tr><%
								%><tr class="details"><th>付款银行:</th><td><%=entities[i].getPayBank() %></td></tr><%
								%><tr class="details"><th>付款账号:</th><td><%=entities[i].getPayBankAccount() %></td></tr><%
								%><tr class="details"><th>费用承担部门:</th><td><%=entities[i].getFeeOwnerDept() %></td></tr><%								
								%><tr class="details"><th>源单未申请预付款金额:</th><td><%=entities[i].getSrcPrepAmount().compareTo(new BigDecimal(0))==0?"":new DecimalFormat("0.00").format(entities[i].getSrcPrepAmount() )%></td></tr><%
								%><tr class="details"><th>源单未审批付款金额:</th><td><%=new DecimalFormat("0.00").format( entities[i].getSrcReqAmount() )%></td></tr><%
								%><tr class="details"><th>累积付款金额:</th><td><%=new DecimalFormat("0.00").format( entities[i].getTotalAmount() )%></td></tr><%								
							} %>						
						<tr class="sh">
							<th colspan="2"><a class="yellow" id="closeDetails" onclick="closeDetails()">关闭物品明细分录</a></th>
						</tr>
						<!-- 以下是上传附件 -->
						<%@include file="workflow_file_record.jsp" %>
						<tr id="appstr">
							<th colspan="2"><a class="yellow" onclick="showApproval()">查看审批记录</a></th>
						</tr>
						 <% for(int i = 0 ; i<arrays.length - 1 ; i++) {
							%><tr class="qytr topLine"><th>审批时间:</th><td><%=arrays[i].getApprovedateStr() %></td></tr><%
							%><tr class="qytr"><th>审批处理人:</th><td><%=arrays[i].getApprover()%></td></tr><%
							%><tr class="qytr"><th>审批人岗位:</th><td><%=arrays[i].getApplyno() %> </td></tr><%
							if("0".equals(arrays[i].getIsagree())) {
								%><tr class="qytr"><th>审批结果:</th><td>同意</td></tr><%
							} else if ("1".equals(arrays[i].getIsagree())) {
								%><tr class="qytr"><th>审批结果:</th><td>不同意</td></tr><%
							} else if ("2".equals(arrays[i].getIsagree())) {
								%><tr class="qytr"><th>审批结果:</th><td>起草流程</td></tr><%
							} else if ("4".equals(arrays[i].getIsagree())) {
								%><tr class="qytr"><th>审批结果:</th><td>退回</td></tr><%
							} else if ("5".equals(arrays[i].getIsagree())) {
								%><tr class="qytr"><th>审批结果:</th><td>同意并结束</td></tr><%
							} else if ("6".equals(arrays[i].getIsagree())) {
								%><tr class="qytr"><th>审批结果:</th><td>收回</td></tr><%
							} else {
								%><tr class="qytr"><th>审批结果:</th><td>业务回退</td></tr><%
							}
							%><tr class="qytr"><th>审批意见:</th><td><%=arrays[i].getApprovever()==null?"":arrays[i].getApprovever()%> </td></tr><%
						} %>
						 </tr>
						<tr class="sh">
							<th colspan="2"><a class="yellow" id="closeApproval" onclick="closeApproval()">关闭审批记录</a></th>
						</tr>
						<tr>
							<td colspan="2" class="fyy-textRt"></td>
						</tr>
						<tr>
						   	<td colspan="2">
						   		<div class="area" id="approve_area">
									<textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" id="textarea-a" placeholder="请输入审批意见..."></textarea>
									<h6>剩余<i id="textareaNum">300</i><i>/300</i>字</h6>
								</div>
						   	</td>
						</tr>
					</table>
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
	function showApproval(){
		$('.qytr').show();
		$('#closeApproval').parents("tr").show();
		
	}
	function closeApproval(){
		$('.qytr').hide();
		$('#closeApproval').parents("tr").hide();
	}
	function showDetails(){
		$('.details').show();
		$('#closeDetails').parents("tr").show();
	}
	function closeDetails(){
		$('.details').hide();
		$('#closeDetails').parents("tr").hide();
	}
</script>
</body>
</html>