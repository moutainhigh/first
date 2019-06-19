<%@page import="com.deppon.montal.model.CCEntertainmentExpenseEntry"%>
<%@page import="com.deppon.montal.model.CCEntertainmentExpense"%>
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
	CCEntertainmentExpense expense = (CCEntertainmentExpense)request.getAttribute("expense");
	List<CCEntertainmentExpenseEntry> entryList = (List<CCEntertainmentExpenseEntry>)request.getAttribute("expenseEntryList");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
   	<div class="ulBox2">
		<ul data-role="listview" id="ulist" data-inset="ture" data-theme="c" data-dividertheme="b">
		 
		   <li class="first">工作流号:
		        <em><%=expense.getProcessinstid() %>
		  	   		<input type="hidden" id="workid" value="<%=expense.getProcessinstid()%>">
		  	   		<input type="hidden" id="type_id" value="entertainmentExpense">
		   		</em>
		   </li>
		   <li>工作流:<em>
	   		  <%
			  	if(null != expense.getApplytype() && expense.getApplytype().equals("3")) {
			  %> 
			   	应酬费用报销单
		   	  <%
			  	}else if(null != expense.getApplytype() && expense.getApplytype().equals("44")){ 
		   	  %>
			   	应酬费-工程项目
		   	  <%
			  	}
		   	  %>
		   </em></li>
		   <li>申请人姓名:<em><%=expense.getApplypersonname() %></em></li>
		   <li>申请人部门:<em><%=expense.getApplydept()%></em></li>
		   
		   <li>所属子公司:<em><%=expense.getApplycompany() %></em></li>
		   <li>发票抬头:<em><%=expense.getInvoicetitle() %></em></li>
		   <li>收款方:<em><%=expense.getPayee() %></em></li>
		   <li>申请总金额:<em><%=expense.getAmount() %></em></li>
		   <li>账号:<em><%=expense.getBanknumber() %></em></li>
		   <li>会计核定金额:<em><%=expense.getAmountapproved() %></em></li>
		   <li>开户银行:<em><%=expense.getBank() %></em></li>
		   <li>最迟汇款日期:<em><%=expense.getLastremitdate() %></em></li>
		   
		   <li>详细信息</li>
			<%
				for(int i=0;i<entryList.size();i++){
					CCEntertainmentExpenseEntry entry = entryList.get(i);
			%>
						   
			   <li <%=i==0?"":"class='line'" %>>费用类型:<em><%=entry.getExpensetype()%></em></li>
			   <li>费用说明:<em><%=entry.getDiscription() %></em></li>
			   <li>发生日期:<em><%=entry.getBizdate() %></em></li>
			   <li>报销金额:<em><%=entry.getAmount() %></em></li>
			   <li>核定金额:<em><%=entry.getAmountapproved() %></em></li>
			   <li>费用承担部门:<em><%=entry.getCostdept() %></em></li>
			   <li>备注:<em><%=entry.getRemark()==null?"":entry.getRemark() %></em></li>
			<%
				}
			%>			   
			   <li class="last">事由及说明：<em><%=expense.getDiscription()==null?"":expense.getDiscription() %></em></li>
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