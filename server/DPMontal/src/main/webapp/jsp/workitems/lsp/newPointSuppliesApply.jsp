<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesmaterialVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesmaterialapplyEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesentryEntity"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 NewsalesmaterialVo temp = info.getNewsalesmaterialVo();
 NewsalesmaterialapplyEntity base = temp.getNewsalesmaterialapplyEntity();
 NewsalesentryEntity[] items = temp.getNewsalesentryEntityList();
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table>
	    		<tr><th colspan="2" class="yellow">基本信息</th></tr>
	    		<tr><th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th><td>新点物料申请单</td></tr>
	    		<tr><th>单据编号:</th><td id="workid"><%=base.getBillnumber() %></td></tr>
	    		<tr><th>所属子公司:</th><td id="workid"><%=base.getControlName() %></td></tr>
	    		<tr><th>申请时间:</th><td><%=FormatUtil.formatDate(base.getApplydate(), "yyyy-MM-dd HH:mm") %></td></tr>
				<tr><th>申请人:</th><td><%=base.getCreateUser()%></td></tr>
				<tr><th >申请人部门:</th><td><%=base.getCreateDept()%></td></tr>
				<tr><th >单据状态:</th><td><%=base.getBillstatus()%></td></tr>
				
				<tr><th >预算承担部门:</th><td><%=base.getExpenseDeptName()%></td></tr>
			   	<tr><th >库存组织:</th><td><%=base.getStorageOrgUnitName()%></td></tr>
			   	<tr><th >到货部门:</th><td><%=base.getReceiveDeptName()%></td></tr>
			   	<tr><th >部门人数:</th><td><%=base.getDeptNumber()%></td></tr>
			   	<tr><th >采购组织:</th><td><%=base.getPurchaseOrgUnitName()%></td></tr>
			   	<tr><th >申请总金额:</th><td><%=base.getApplyamount()%></td></tr>
			   	<tr><th >项目编号:</th><td><%=base.getProjectNumber()%></td></tr>
			   	<tr><th >项目名称:</th><td><%=base.getProjectname()%></td></tr>
			    <tr><th >联系电话:</th><td><%=base.getPhonenumber()%></td></tr>
			    <tr><th >到货地址:</th><td><%=base.getReceiveaddress()==null?"":base.getReceiveaddress()%></td></tr>
			    <tr><th >备注:</th><td><%=base.getRemark()%></td></tr>
			    <tr><th >是否计划外采购:</th><td><%=base.getIsunplanned()==0?"否":"是"%></td></tr>

				<tr class="yellow"><td colspan="2" >其他信息</td></tr>
				<%for(int i = 0; i < items.length; i++ ) {%>
					<tr <%=i==0 ? "" : "class='topLine'" %>><th>序号:</th><td><%=i+1 %></td></tr>
				   	<tr><th>预算项目:</th><td><%= items[i].getBudgetName()%></td></tr>
				    <tr><th>物料编码:</th><td><%= items[i].getMaterialCode()%></td></tr>
				   	<tr><th>物料名称:</th><td><%= items[i].getMaterialName()%></td></tr>
				    <tr><th>物料类型:</th><td><%= items[i].getMaterialType()==null?"":items[i].getMaterialType()%></td></tr>
				    <tr><th>规格型号:</th><td><%= items[i].getMaterialModel()==null?"":items[i].getMaterialModel()%></td></tr>
				    <tr><th>单位:</th><td><%= items[i].getBaseunitName()==null?"":items[i].getBaseunitName()%></td></tr>
				    <tr><th>申请数量:</th><td><%= items[i].getApplyNum()==null?"":items[i].getApplyNum()%></td></tr>
				    <tr><th>物料属性:</th><td><%= items[i].getMaterialattName()==null?"":items[i].getMaterialattName()%></td></tr>
				    <tr><th>未签收数量:</th><td><%= items[i].getUnsignNum()==null?"":items[i].getUnsignNum()%></td></tr>
				    <tr><th>调拨数量:</th><td><%= items[i].getMoveableNum()==null?"0":items[i].getMoveableNum()%></td></tr>
				    <tr><th>参考单价:</th><td><%= items[i].getReferencePrice()==null?"":items[i].getReferencePrice()%></td></tr>
				    <tr><th>参考金额:</th><td><%= items[i].getReferenceAmount()==null?"":items[i].getReferenceAmount()%></td></tr>
				    <tr><th>申请原因:</th><td><%= items[i].getApplyreason()%></td></tr>
				    <tr><th>报废申请单编号:</th><td><%= items[i].getScrapapplyedCode()==null?"":items[i].getScrapapplyedCode()%></td></tr>
				    <tr><th>备注:</th><td><%= items[i].getRemark()==null?"":items[i].getRemark()%></td></tr>
				    <tr><th>出库数量:</th><td><%= items[i].getOutstoreNum()==null?"0":items[i].getOutstoreNum()%></td></tr>
				    <tr><th>使用部门:</th><td><%= items[i].getUsedeptName()==null?"":items[i].getUsedeptName()%></td></tr>
			   <%} %>
		  </table>
		  <%@include file="approve_process_esb.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button_esb.jsp" %>
</div>
<script type="text/javascript">

</script>
</body>
</html>