<%@page import="java.text.DecimalFormat"%>
<%@page import="com.deppon.lsp.module.purchase.purchasecontact.share.domain.PurchaseContactDetailEntity"%>
<%@page import="com.deppon.bpms.module.shared.domain.ApprovalInfo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.WorkflowData"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.AttachEntity"%>
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
	WorkflowData info = (WorkflowData)request.getAttribute("entity");
	Auditparameters auditparameters = (Auditparameters)request.getAttribute("auditparameters");
	String[] str = info.getPurchaseContactVo().getFid().split(",");
	ApprovalInfo[] arrays = info.getApprovalInfoList();
	PurchaseContactDetailEntity[] entities = info.getPurchaseContactDetailEntityList();
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	   <input type="hidden" id="workid" value="<%=auditparameters.getWfInstanceId()%>">
	   <input type="hidden" id="docId" value="<%=auditparameters.getDocId()%>">
	   <input type="hidden" id="workItemId" value="<%=auditparameters.getWfWorkItemId()%>">
	   <input type="hidden" id="wfState" value="<%=auditparameters.getWfState()%>">
	   <input type="hidden" id="type" value="<%=F_Constants.DLSP_PURCHASE_CONTRACT%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>采购合同<input type="hidden" id ="type_id" value="over_time"></td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getPurchaseContactVo().getApplier()%></td>
				   </tr>
					 <tr>
					  <th>申请时间:</th>
					  <td><%=str[1].substring(0, 10)%></td>
				   </tr>
				   <tr>
					  <th>采购合同号:</th>
					  <td><%=info.getPurchaseContactVo().getContactNo()%></td>
				   </tr>
					 <tr>
					  <th>合同名称:</th>
					  <td><%=info.getPurchaseContactVo().getContactName()%></td>
				   </tr>
					 <tr>
					  <th>归档事业部:</th>
					  <td><%=info.getPurchaseContactVo().getDepartment()==null?"":info.getPurchaseContactVo().getDepartment()%></td>
				   </tr>
				   <tr>
					  <th>合同类别:</th>
					  <td><%=info.getPurchaseContactVo().getType()%></td>
				   </tr>
				   
				   <tr>
					  <th>合同类型:</th>
					  <td><%=info.getPurchaseContactVo().getContactType()%></td>
				   </tr>
					 <tr>
					  <th>签订类别:</th>
					  <td><%=info.getPurchaseContactVo().getSignedType()%></td>
				   </tr>
				   <tr>
					  <th>甲方:</th>
					  <td><%=info.getPurchaseContactVo().getPartyA()%></td>
				   </tr>
					 <tr style="color: red">
					  <th>供应商:</th>
					  <td><%=info.getPurchaseContactVo().getPartyB()%></td>
				   </tr>
					 <tr>
					  <th>丙方:</th>
					  <td><%=info.getPurchaseContactVo().getPartyC()==null?"":info.getPurchaseContactVo().getPartyC()%></td>
				   </tr>
				   <tr>
					  <th>合同起始日期:</th>
					  <td><%=str[2].substring(0, 10)%></td>
				   </tr>				   
				   
				   <tr>
					  <th>合同结束日期:</th>
					  <td><%=str[3].substring(0, 10)%></td>
				   </tr>
				   <tr>
					  <th>优先盖章方:</th>
					  <td><%=info.getPurchaseContactVo().getSealParty()%></td>
				   </tr>
				   
					<tr style="color: red">
					  <th>备注:</th>
					  <td><%=info.getPurchaseContactVo().getRemark()%></td>
				   </tr>
				   <tr>
					  <th>合同金额:</th>
					  <td><%=info.getPurchaseContactVo().getContactAmount()%></td>
				   </tr>
				   <tr>
					  <th>合同金额大写:</th>
					  <td><%=info.getPurchaseContactVo().getAmountCn()%></td>
				   </tr>
				   <tr>
					  <th>币种:</th>
					  <td><%=info.getPurchaseContactVo().getCurrency()%></td>
				   </tr>
					<table width="100%">
						<tr id="appstr">
							<th colspan="2"><a class="yellow" onclick="showDetails()">查看物品明细分录</a></th>
						</tr>
							<% for(int i = 0 ; i< entities.length ; i++) {
								%><tr class="details topLine"><th>物料编号:</th><td><%=entities[i].getFmatNumber()%></td></tr><%
								%><tr class="details"><th>物料名称:</th><td><%=entities[i].getFmaterialname() %></td></tr><%
								%><tr class="details"><th>规格型号:</th><td><%=entities[i].getFnonummaterialmodel() %></td></tr><%
								%><tr class="details"><th>数量:</th><td><%=entities[i].getFqty() %></td></tr><%
								%><tr class="details"><th>单价:</th><td><%=new DecimalFormat("0.00").format(entities[i].getFprice()) %></td></tr><%
								%><tr class="details"><th>税率(%):</th><td><%=new DecimalFormat("0.00").format(entities[i].getFtaxrate()) + "%"%></td></tr><%
								%><tr class="details"><th>含税单价:</th><td><%=new DecimalFormat("0.00").format(entities[i].getFtaxprice()) %></td></tr><%
							} %>						
						<tr class="sh">
							<th colspan="2"><a class="yellow" id="closeDetails" onclick="closeDetails()">关闭物品明细分录</a></th>
						</tr>
						<%@include file="workflow_file_record.jsp" %>
						<tr id="appstr">
							<th colspan="2"><a class="yellow" onclick="showApproval()">查看审批记录</a></th>
						</tr>
						 <% for(int i = 0 ; i<arrays.length - 1 ; i++) {
							 String[] s = arrays[i].getApplyno().split(",");
							%><tr class="qytr topLine"><th>审批时间:</th><td><%=s[1] %></td></tr><%
							%><tr class="qytr"><th>审批处理人:</th><td><%=arrays[i].getApprover()%></td></tr><%
							%><tr class="qytr"><th>审批人岗位:</th><td><%=s[0]%> </td></tr><%
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