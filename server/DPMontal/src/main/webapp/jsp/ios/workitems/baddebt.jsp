<%@page import="com.deppon.montal.model.OABaddebtChild"%>
<%@page import="com.deppon.montal.model.OABaddebtApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.model.OaContractApply"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				<%
					OABaddebtApply apply = (OABaddebtApply)request.getAttribute("badApply");
					List<OABaddebtChild> badChildList = (List<OABaddebtChild>)request.getAttribute("badChildList");
				%>
					<li class="first">工作流号：<em><%=apply.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=apply.getProcessinstid()%>">
				    </li>
				    <li>工作流：<em>非业务类坏账申请</em>	</li>				
					<li>申请人：<em><%=apply.getApplyname() %></em></li>
					
					<li>申请部门：<em><%=apply.getApplydeptment()%></em></li>
					<li>申请时间：<em><%=FormatUtil.formatDate(apply.getApplydate()) %></em></li>
					<li>坏账类型：<em><%=apply.getBaddebttype() %></em></li>
					<%
						if(null != apply.getBaddebttype() && apply.getBaddebttype().equals("押金、保证金")){
					%>
					<li>押金编号：<em><%=apply.getDepositcode()==null?"":apply.getDepositcode() %></em></li>
					<li>押金收取方：<em><%=apply.getAcceptdeposit()==null?"":apply.getAcceptdeposit() %></em></li>
					<li>起始日期：<em><%=FormatUtil.formatDate(apply.getBegindate()) %></em></li>
					<li>到期日期：<em><%=FormatUtil.formatDate(apply.getMaturedate()) %></em></li>
					<li>押金类型：<em><%=apply.getDeposittype() %></em></li>
					<%
						}
						if(null != apply.getBaddebttype() && apply.getBaddebttype().equals("员工私人借支")){
					%>
					<li>借支编号：<em><%=apply.getDebitcode()==null?"":apply.getDebitcode() %></em></li>
					<li>借支人：<em><%=apply.getDebitname()==null?"":apply.getDebitname() %></em></li>
					<%
						}
						if(null != apply.getBaddebttype() && apply.getBaddebttype().equals("应交营业款")){
					%>
					<li>客户：<em><%=apply.getCustomername() %></em></li>
					<%
						}
					%>
					<li>坏账金额：<em><%=FormatUtil.formatMoney(apply.getBaddebtmoney())%></em></li>
					<li>差错编号：<em><%=apply.getMishapcode() %></em></li>
					<li>产生坏账原因：<em><%=apply.getBaddebtreason()==null?"": apply.getBaddebtreason()%></em></li>
					<%
						if(null != apply.getMishapcode() && !apply.getMishapcode().equals("")){
					%>
					<li><em class="yellow">差错详细</em></li>		
					<%
						for(int i=0;i<badChildList.size();i++){
							OABaddebtChild entry = badChildList.get(i);
					%>
					<li <%=i==0?"":"class='line'" %>>责任部门:<em><%=entry.getResponsibilitydept()==null?"":entry.getResponsibilitydept()%></em></li>
			  		<li>入部门费用:<em><%=entry.getTodeptaccount()%></em></li>
			  	    <li>责任人:<em><%=entry.getResponsibilityperson()==null?"":entry.getResponsibilityperson()%></em></li>
			        <li>个人扣款:<em><%=entry.getPersonwithhold() %></em></li>
					<%
							}
						}
					%>						
				</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>