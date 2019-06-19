<%@page import="com.deppon.montal.model.CCFenlumingxiTable"%>
<%@page import="com.deppon.montal.model.CCExpenseaccountBill"%>
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
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
	CCExpenseaccountBill expense = (CCExpenseaccountBill)request.getAttribute("bill");
	List<CCFenlumingxiTable> entryList = (List<CCFenlumingxiTable>)request.getAttribute("billEntryList");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
		<ul>
		 
		   <li class="first">工作流号:
		        <em><%=expense.getProcessinstid() %>
		  	   		<input type="hidden" id="workid" value="<%=expense.getProcessinstid()%>">		  	   		
		   		</em>
		   </li>
		   <li>工作流:<em>
	   		  外请车-付款单
		   </em></li>
		   <li>发票抬头:<em><%=expense.getInvoicetitle() %></em></li>
		   <li>申请人工号:<em><%=expense.getApplypersonnumber() %></em></li>
		   <li>申请人姓名:<em><%=expense.getApplypersonname() %></em></li>
		   <li>申请人部门:<em><%=expense.getApplydept() %></em></li>
		   <li>银行:<em><%=expense.getFbank() %></em></li>
		   <li>开户行支行:<em><%=expense.getFsubbank() %></em></li>
		   <li>开户行账号:<em><%=expense.getFaccountnumber() %></em></li>
		   <li>开户行省份:<em><%=expense.getFprovince() %></em></li>
		   <li>收款方:<em><%=expense.getFaccountname() %></em></li>
		   <li>押回单到达:<em><%=expense.getFisback()%></em></li>
		   <li>代理到达:<em><%=expense.getFisagency() %></em></li>
		   <li>开户行城市：<em><%=expense.getFcity()%></em></li>
		   <li>支付方式:<em><%=expense.getFpaytype()%></em></li>
		   <li>是否冲借支:<em><%=expense.getFisrevpaymentbill() %></em></li>
		   <li>申请日期：<em><%=expense.getFapplydate()%></em></li>
		   <li>最迟汇款日期:<em><%=expense.getLastremitdate()%></em></li>
		   <li>申请总金额:<em><%=expense.getFtotalamount() %></em></li>
		   <li>实付金额：<em><%=expense.getFpayamount()%></em></li>
		   <li>冲销金额:<em><%=expense.getFrevamount() %></em></li>
		   <li>冲销付款单号：<em><%=expense.getFpaymentbillno()==null?"":expense.getFpaymentbillno()%></em></li>
		  
		   <li><em class="yellow">详细信息</em></li>
			<%
				for(int i=0;i<entryList.size();i++){
					CCFenlumingxiTable entry = entryList.get(i);
			%>
		   <li <%=i==0?"":"class='line'" %>>出发部门:<em><%=entry.getFstartdept()%></em></li>
		   <li>到达部门:<em><%=entry.getFenddept() %></em></li>
		   <li>付款类型:<em><%=entry.getFtype() %></em></li>
		   <li>车次号:<em><%=entry.getFtrucknumber() %></em></li>
		   <li>车牌号:<em><%=entry.getFtruckno() %></em></li>
		   <li>司机:<em><%=entry.getFdriver() %></em></li>
		   <li>总额:<em><%=entry.getFamount()==null?"":entry.getFamount()%></em></li>
		   <li>出发付金额:<em><%=entry.getFstartamount() %></em></li>
		   <li>到达付金额:<em><%=entry.getFendamount() %></em></li>
		   <li>增减变化:<em><%=entry.getFchangeamount() %></em></li>
		   <li>押回单:<em><%=entry.getFisbackpay() %></em></li>
		   <li>奖励/扣款:<em><%=entry.getFchangetype() %></em></li>
			<%
				}
			%>			   
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
		<%
	 		 if("财务副总".equals(expense.getCurrentnode())){
	 	%>
	   <div class="ulBox2">
     	 <ul>
			 <li class="first">
			 	是否总裁审批:
			 	<em>
				 	<input type="radio" name="need" value="1"><label>需要</label>
				 	<input type="radio" name="need" value="0" checked="checked"><label>不需要</label>
			 	</em>
			 </li>
		</ul>
     </div>
	 <% } %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
</body>
</html>