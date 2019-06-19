<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesmaterialVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesmaterialapplyEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NewsalesentryEntity"%>
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
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 NewsalesmaterialVo temp = info.getNewsalesmaterialVo();
 NewsalesmaterialapplyEntity base = temp.getNewsalesmaterialapplyEntity();
 NewsalesentryEntity[] items = temp.getNewsalesentryEntityList();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-新点物料申请单</h4>
    	<div class="ulBox2">
	    	<ul>				  
			    <li>单据编号:<em id="workid"><%=base.getBillnumber() %></em></li>
	    		<li>所属子公司:<em id="workid"><%=base.getControlName() %></em></li>
	    		<li>申请时间:<em><%=FormatUtil.formatDate(base.getApplydate(), "yyyy-MM-dd HH:mm") %></em></li>
				<li>申请人:<em><%=base.getCreateUser()%></em></li>
				<li>申请人部门:<em><%=base.getCreateDept()%></em></li>
				<li>单据状态:<em><%=base.getBillstatus()%></em></li>
				
				<li>预算承担部门:<em><%=base.getExpenseDeptName()%></em></li>
			   	<li>库存组织:<em><%=base.getStorageOrgUnitName()%></em></li>
			   	<li>到货部门:<em><%=base.getReceiveDeptName()%></em></li>
			   	<li>部门人数:<em><%=base.getDeptNumber()%></em></li>
			   	<li>采购组织:<em><%=base.getPurchaseOrgUnitName()%></em></li>
			   	<li>申请总金额:<em><%=base.getApplyamount()%></em></li>
			   	<li>项目编号:<em><%=base.getProjectNumber()%></em></li>
			   	<li>项目名称:<em><%=base.getProjectname()%></em></li>
			    <li>联系电话:<em><%=base.getPhonenumber()%></em></li>
			    <li>到货地址:<em><%=base.getReceiveaddress()==null?"":base.getReceiveaddress()%></em></li>
			    <li>备注:<em><%=base.getRemark()%></em></li>
			    <li>是否计划外采购:<em><%=base.getIsunplanned()==0?"否":"是"%></em></li>
          	</ul>
        </div>
        <h4 class="yellow">其他信息</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < items.length; i++ ) {%>
					<li  <%=i==0?"class='first'":"class='line'" %> >序号:<em><%=i+1 %></em></li>
				    <li>预算项目:<em><%= items[i].getBudgetName()%></em></li>
				    <li>物料编码:<em><%= items[i].getMaterialCode()%></em></li>
				   	<li>物料名称:<em><%= items[i].getMaterialName()%></em></li>
				    <li>物料类型:<em><%= items[i].getMaterialType()==null?"":items[i].getMaterialType()%></em></li>
				    <li>规格型号:<em><%= items[i].getMaterialModel()==null?"":items[i].getMaterialModel()%></em></li>
				    <li>单位:<em><%= items[i].getBaseunitName()==null?"":items[i].getBaseunitName()%></em></li>
				    <li>申请数量:<em><%= items[i].getApplyNum()==null?"":items[i].getApplyNum()%></em></li>
				    <li>物料属性:<em><%= items[i].getMaterialattName()==null?"":items[i].getMaterialattName()%></em></li>
				    <li>未签收数量:<em><%= items[i].getUnsignNum()==null?"":items[i].getUnsignNum()%></em></li>
				    <li>调拨数量:<em><%= items[i].getMoveableNum()==null?"0":items[i].getMoveableNum()%></em></li>
				    <li>参考单价:<em><%= items[i].getReferencePrice()==null?"":items[i].getReferencePrice()%></em></li>
				    <li>参考金额:<em><%= items[i].getReferenceAmount()==null?"":items[i].getReferenceAmount()%></em></li>
				    <li>申请原因:<em><%= items[i].getApplyreason()%></em></li>
				    <li>报废申请单编号:<em><%= items[i].getScrapapplyedCode()==null?"":items[i].getScrapapplyedCode()%></em></li>
				    <li>备注:<em><%= items[i].getRemark()==null?"":items[i].getRemark()%></em></li>
				    <li>出库数量:<em><%= items[i].getOutstoreNum()==null?"0":items[i].getOutstoreNum()%></em></li>
				    <li>使用部门:<em><%= items[i].getUsedeptName()==null?"":items[i].getUsedeptName()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>

</html>