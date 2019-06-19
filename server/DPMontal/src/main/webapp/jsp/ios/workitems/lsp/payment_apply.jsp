<%@page import="java.math.BigDecimal"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.shared.domain.PayApplyVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.shared.domain.PayApplyEntryVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.shared.domain.ApprovalInfoVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.PayApplyWorkflowData"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters"%>
<%@page import="com.deppon.bpms.module.shared.domain.ApprovalInfo"%>
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
	PayApplyWorkflowData info = (PayApplyWorkflowData)request.getAttribute("entity");
	Auditparameters auditparameters = (Auditparameters)request.getAttribute("auditparameters");
	ApprovalInfoVo[] arrays = info.getApprovalInfoVoList();
	PayApplyVo payapplyvo = info.getPayApplyVo();
	PayApplyEntryVo[] entities = info.getPayApplyEntryVoList();
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>			  
          <li class="first">工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>付款申请单</em></li>
          
					  <li>付款申请单号:<em>
					  <%=payapplyvo.getPayApplyNo()%></em>
			   <input type="hidden" id="workid" value="<%=auditparameters.getWfInstanceId()%>">
			   <input type="hidden" id="docId" value="<%=auditparameters.getDocId()%>">
			   <input type="hidden" id="workItemId" value="<%=auditparameters.getWfWorkItemId()%>">
			   <input type="hidden" id="wfState" value="<%=auditparameters.getWfState()%>">
			   <input type="hidden" id ="type_id" value="">
			   <input type="hidden" id="type" value="<%=F_Constants.DLSP_PAYMENT_APPLY%>">					  
				   </li>
					 
					  <li>公司:<em>
					  <%=payapplyvo.getCompanyName()%></em>
				   </li>
				   
					  <li>单据日期:<em>
					  <%=payapplyvo.getBizDateStr().substring(0, 10)%></em>
				   </li>
					 
					  <li>申请人:<em>
					  <%=payapplyvo.getUserName()%></em>
				   </li>
					 
					  <li>审批类型:<em>
					  <%=payapplyvo.getApprovalType()%></em>
				   </li>
				   
					  <li>发票抬头:<em>
					  <%=entities[0].getPayBank()%></em>
				   </li>
				   
				   
					  <li>收款方:<em>
					  <%=entities[0].getAsstName()%></em>
				   </li>
					  <li style="color: red">请款事由:<em>
					  <%=payapplyvo.getRequestReason()==null?"":payapplyvo.getRequestReason()%></em>
				   </li>
				   
					  <li>付款情况:<em>
					  <%=payapplyvo.getSituation()%></em>
				   </li>
					 
					  <li>票据单号:<em>
					  <%=payapplyvo.getBillNumber()==null?"":payapplyvo.getBillNumber()%></em>
				   </li>
					 
					  <li>到期日期:<em>
					  <%=payapplyvo.getDeadLineStr()==null?"":payapplyvo.getDeadLineStr()%></em>
				   </li>
				   
					  <li>申请金额:<em>
					  <%=new DecimalFormat("0.00").format(payapplyvo.getRequestAmount())%></em>
				   </li>				   
				   
				   
					  <li>审批金额:<em>
					  <%=new DecimalFormat("0.00").format(payapplyvo.getAuditAmount())%></em>
				   </li>
				   
					  <li>申请金额大写:<em>
					  <%=payapplyvo.getCurrencyUpCase()%></em>
				   </li>
				   
					
					  <li>币种:<em>
					  <%=payapplyvo.getCurrencyName()%></em>
				   </li>
			</ul>
	    </div>
	    <h4 class="yellow" onclick="showDetails()">查看物品明细分录</h4>
	    <div id="ulBoxDetails" style="display: none">
	    	<div class="ulBox2">
	    		<ul>
					<% for(int i = 0 ; i< entities.length ; i++) {
						if(i==0){
							%><li class="first">付款类型:<em><%=entities[i].getPayType()%></em></li><%
						}else{
							%><li class="line">付款类型:<em><%=entities[i].getPayType()%></em></li><%
						}
						%><li>来往类型:<em><%=entities[i].getAsstType() %></em></li><%
						%><li>往来户编码:<em><%=entities[i].getAsstNo() %></em></li><%
						%><li>往来户名称:<em><%=entities[i].getAsstName() %></em></li><%
						%><li>审批付款金额:<em><%=new DecimalFormat("0.00").format(entities[i].getReqAmount())%></em></li><%
						%><li>审批金额:<em><%=new DecimalFormat("0.00").format(entities[i].getAuditAmount()) %></em></li><%
						%><li>付款日期:<em><%=entities[i].getPayDayStr().substring(0, 10)%></em></li><%
						%><li>未付款金额:<em><%=new DecimalFormat("0.00").format(entities[i].getUnPayAmount())%></em></li><%
						%><li>往来户银行账号:<em><%=entities[i].getAccountBankNo() %></em></li><%
						%><li>往来户开户银行:<em><%=entities[i].getAccountBank() %></em></li><%
						%><li>结算方式:<em><%=entities[i].getBanlanceType() %></em></li><%
						%><li>付款银行:<em><%=entities[i].getPayBank() %></em></li><%
						%><li>付款账号:<em><%=entities[i].getPayBankAccount() %></em></li><%
						%><li>费用承担部门:<em><%=entities[i].getFeeOwnerDept() %></em></li><%								
						%><li>源单未申请预付款金额:<em><%=entities[i].getSrcPrepAmount().compareTo(new BigDecimal(0))==0?"":new DecimalFormat("0.00").format(entities[i].getSrcPrepAmount() )%></em></li><%
						%><li>源单未审批付款金额:<em><%=new DecimalFormat("0.00").format( entities[i].getSrcReqAmount() )%></em></li><%
						%><li>累积付款金额:<em><%=new DecimalFormat("0.00").format( entities[i].getTotalAmount() )%></em></li><%								
					} %>						
	    		</ul>
	    	</div>
	    </div>
	    <h4 id="hideListDetails" class="yellow" onclick="closeDetails()" style="display: none">关闭物品明细分录</h4>
	    <!-- 以下是上传附件 -->
		<%@include file="workflow_file_record.jsp" %> 
	    
		<h4 id="showAppId" class="yellow">查看审批记录</h4>
		<div id="ulBox" style="display:none;">
		     <div class="ulBox2">
		     	<ul>
					<% for(int i = 0 ; i<arrays.length - 1 ; i++) {
						if(i==0){
							%><li class="first">审批时间:<em><%=arrays[i].getApprovedateStr()%></em></li><%
						}else{
							%><li class="line">审批时间:<em><%=arrays[i].getApprovedateStr()%></em></li><%
						}
						%><li>审批处理人:<em><%=arrays[i].getApprover()%></em></li><%
						%><li>审批人岗位:<em><%=arrays[i].getApplyno()%> </em></li><%
						if("0".equals(arrays[i].getIsagree())) {
							%><li>审批结果:<em>同意</em></li><%
						} else if ("1".equals(arrays[i].getIsagree())) {
							%><li>审批结果:<em>不同意</em></li><%
						} else if ("2".equals(arrays[i].getIsagree())) {
							%><li>审批结果:<em>起草流程</em></li><%
						} else if ("4".equals(arrays[i].getIsagree())) {
							%><li>审批结果:<em>退回</em></li><%
						} else if ("5".equals(arrays[i].getIsagree())) {
							%><li>审批结果:<em>同意并结束</em></li><%
						} else if ("6".equals(arrays[i].getIsagree())) {
							%><li>审批结果:<em>收回</em></li><%
						} else {
							%><li>审批结果:<em>业务回退</em></li><%
						}
						%><li>审批意见:<em><%=arrays[i].getApprovever()==null?"":arrays[i].getApprovever()%></em></li><%
					} %>		     		
		     	</ul>
		     </div>
		     <h4 id="hideList" class="yellow">关闭审批记录</h4>
		</div>	  
		<div class="ulBox2" id="approve_area">
			<ul>
				<li class="first gray"><textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" class="gray" id="textarea-a"  placeholder="请输入审批意见..."></textarea></li>
				<li class="num">剩余<i id="textareaNum">300</i><i >/300</i>字</li>
			</ul>
		</div>		  
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
	function showDetails(){
		$('#ulBoxDetails').slideDown(200);
		$('#hideListDetails').show();
	}
	function closeDetails(){
		$('#ulBoxDetails').slideUp(200);
		$('#hideListDetails').hide();
	}
</script>
</body>

</html>