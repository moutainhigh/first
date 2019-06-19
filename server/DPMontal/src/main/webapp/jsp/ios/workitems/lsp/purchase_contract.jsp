<%@page import="java.text.DecimalFormat"%>
<%@page import="com.deppon.lsp.module.purchase.purchasecontact.share.domain.PurchaseContactDetailEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.Auditparameters"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.bpms.module.shared.domain.ApprovalInfo"%>
<%@page import="com.deppon.lsp.module.mobileworkflow.server.service.WorkflowData"%>
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
	WorkflowData info = (WorkflowData)request.getAttribute("entity");
	Auditparameters auditparameters = (Auditparameters)request.getAttribute("auditparameters");
	String[] str = info.getPurchaseContactVo().getFid().split(",");
	ApprovalInfo[] arrays = info.getApprovalInfoList();
	PurchaseContactDetailEntity[] entities = info.getPurchaseContactDetailEntityList();
%>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
    	<div class="ulBox2">
	    	<ul>				  
          <li class="first">工&nbsp;&nbsp;作&nbsp;&nbsp;流:<em>采购合同<input type="hidden" id ="type_id" value=""></em></li>
          <li>
					  申请人:
					  <em><%=info.getPurchaseContactVo().getApplier()%></em>
				<input type="hidden" id="workid" value="<%=auditparameters.getWfInstanceId()%>">
			   <input type="hidden" id="docId" value="<%=auditparameters.getDocId()%>">
			   <input type="hidden" id="workItemId" value="<%=auditparameters.getWfWorkItemId()%>">
			   <input type="hidden" id="wfState" value="<%=auditparameters.getWfState()%>">
			   <input type="hidden" id ="type_id" value="">
			   <input type="hidden" id="type" value="<%=F_Constants.DLSP_PURCHASE_CONTRACT%>">					  
				   </li>
					 <li>
					  申请时间:
					  <em><%=str[1].substring(0, 10)%></em>
				   </li>
				   <li>
					  采购合同号:
					  <em><%=info.getPurchaseContactVo().getContactNo()%></em>
				   </li>
					 <li>
					  合同名称:
					  <em><%=info.getPurchaseContactVo().getContactName()%></em>
				   </li>
					 <li>
					  归档事业部:
					  <em><%=info.getPurchaseContactVo().getDepartment()==null?"":info.getPurchaseContactVo().getDepartment()%></em>
				   </li>
				   <li>
					  合同类别:
					  <em><%=info.getPurchaseContactVo().getType()%></em>
				   </li>
				   
				   <li>
					  合同类型:
					  <em><%=info.getPurchaseContactVo().getContactType()%></em>
				   </li>
					 <li>
					  签订类别:
					  <em><%=info.getPurchaseContactVo().getSignedType()%></em>
				   </li>
				   <li>
					  甲方:
					  <em><%=info.getPurchaseContactVo().getPartyA()%></em>
				   </li>
					 <li style="color: red">
					  供应商:
					  <em><%=info.getPurchaseContactVo().getPartyB()%></em>
				   </li>
					 <li>
					  丙方:
					  <em><%=info.getPurchaseContactVo().getPartyC()==null?"":info.getPurchaseContactVo().getPartyC()%></em>
				   </li>
				   <li>
					  合同起始日期:
					  <em><%=str[2].substring(0, 10)%></em>
				   </li>				   
				   
				   <li>
					  合同结束日期:
					  <em><%=str[3].substring(0, 10)%></em>
				   </li>
				   <li>
					  优先盖章方:
					  <em><%=info.getPurchaseContactVo().getSealParty()%></em>
				   </li>
				   
					<li style="color: red">
					  备注:
					  <em><%=info.getPurchaseContactVo().getRemark()%></em>
				   </li>
				   <li>
					  合同金额:
					  <em><%=info.getPurchaseContactVo().getContactAmount()%></em>
				   </li>
				   <li>
					  合同金额大写:
					  <em><%=info.getPurchaseContactVo().getAmountCn()%></em>
				   </li>
				   <li>
					  币种:
					  <em><%=info.getPurchaseContactVo().getCurrency()%></em>
				   </li>
			</ul>
	    </div>
	    <h4 class="yellow" onclick="showDetails()">查看物品明细分录</h4>
	    <div id="ulBoxDetails" style="display: none">
	    	<div class="ulBox2">
	    		<ul>
	    		<% for(int i = 0 ; i< entities.length ; i++) {
					if(i==0){
						%><li class="first">物料编号:<em><%=entities[i].getFmatNumber()%></em></li><%
					}else {
		    			%><li class="line">物料编号:<em><%=entities[i].getFmatNumber()%></em></li><%
					}
	    			%><li>物料名称:<em><%=entities[i].getFmaterialname() %></em></li><%
	    			%><li>规格型号:<em><%=entities[i].getFnonummaterialmodel() %></em></li><%
	    			%><li>数量:<em><%=entities[i].getFqty() %></em></li><%
	    			%><li>单价:<em><%=new DecimalFormat("0.00").format(entities[i].getFprice()) %></em></li><%
	    			%><li>税率(%):<em><%=new DecimalFormat("0.00").format(entities[i].getFtaxrate()) + "%"%></em></li><%
	    			%><li>含税单价:<em><%=new DecimalFormat("0.00").format(entities[i].getFtaxprice()) %></em></li><%
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
						 String[] s = arrays[i].getApplyno().split(",");
						 if(i==0){
							 %><li class="first">审批时间:<em><%=s[1] %></em></li><%
						 }else{
							 %><li class="line">审批时间:<em><%=s[1] %></em></li><%
						 }
						%><li>审批处理人:<em><%=arrays[i].getApprover()%></em></li><%
						%><li>审批人岗位:<em><%=s[0]%> </em></li><%
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