<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.YardRentBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
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
YardRentBean info = (YardRentBean)request.getAttribute("entity");
%>
<body>
<div id="list">
<%@include file="/jsp/ios/work_items_head.jsp" %>
   <!--div2 S-->
   <div id="div2">
	   	<div class="ulBox2">
			<ul>
			 
			   <li class="first">工作流号:
			        <em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.YARDRENT_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em>
		   		   场地租赁/转租合同
			   </em></li>
					  <li>申请人:<em>
					 <%=info.getApplyPersonName()%></em>
				   </li>
					 
					  <li>申请人工号:<em>
					  <%=info.getApplyPersonId()%></em>
				   </li>
				   
					  <li>业务类型:<em>
					  <%=info.getBusiTypeName()%></em>
				   </li>
					 
					  <li>所属财务部:<em>
					 <%=info.getFinanceName()%></em>
				   </li>
					 
					  <li>租赁开始日期:<em>
					  <%=info.getStartDateStr()%></em>
				   </li>
				   
					  <li>租赁结束日期:<em>
					  <%=info.getEndDateStr()%></em>
				   </li>
					  <li>所属事业部:<em>
					 <%=info.getDivisionName()%></em>
				   </li>
					  <li>所属公共事务组:<em>
					  <%=info.getAffairsName()%></em>
				   </li>
					  <li>签订类型:<em>
				   <%=info.getSignTypeName()%></em>
				   </li>
					<%if(!"1".equals(info.getSignType())){ %> 
					  <li>原合同编号:<em>
					  <%=info.getOldContarctNO()%></em>
				   </li>
				   <%}%>
				   <%if("1".equals(info.getBusiType())){%>
					  <li>所属子公司:<em>
					  <%=info.getSubComName()==null?"":info.getSubComName()%></em>
				   </li>				   
				    <%}%>
				   <%if("1".equals(info.getBusiType())){%>
					  <li>出租方名称:<em>
					  <%=info.getYrentName()==null?"":info.getYrentName()%></em>
				   </li>
				  <li>承租方名称:<em>
					  <%=info.getLeaseNameText()==null?"":info.getLeaseNameText()%></em>
				   </li>
				   
					  <li>承租部门:<em>
					  <%=info.getLeaseDept()%></em>
				   </li>
				   
					  <li>承租房屋面积:<em>
					 <%=info.getLeaseArea()%></em>
				   </li>
				   	
					  <li>每年租金:<em>
					  <%=info.getYearRental()%></em>
				   </li>
				   
					  <li>付款方式:<em>
					  <%=info.getPayTypeName()%></em>
				   </li>	
				   
					  <li>免租开始日期:<em>
					  <%=info.getFreeStartDateStr()%></em>
				   </li>
				   
					  <li>免租结束日期:<em>
					 <%=info.getFreeEndDdateStr()%></em>
				   </li>
				   
					  <li>租赁类型:<em>
					  <%=info.getLeaseTypeName()%></em>
				   </li>
				   
					  <li>工程项目编号:<em>
					 <%=info.getProjectID()%></em>
				   </li>
				   
					  <li>工程项目名称:<em>
					 <%=info.getProjectName()%></em>
				   </li>
				   <li>押金金额:<em>
						  <%=info.getDepositAmount()%></em>
					   </li>
					<%}else{%>   
						  <li>出租方名称:<em>
						  <%=info.getPrentNameText()==null?"":info.getPrentNameText()%></em>
					   </li>
					   
						  <li>承租方主要业务:<em>
						  <%=info.getLeaseBussiness()==null?"":info.getLeaseBussiness()%></em>
					   </li>
					   
						  <li>是否改造:<em>
						  <%=info.getIsChangeName()==null?"":info.getIsChangeName()%></em>
					   </li>
					   
						  <li>改造金额:<em>
						  <%=info.getChangeAmt()==null?"":info.getChangeAmt()%></em>
					   </li>		
						  <li>转租部门:<em>
						  <%=info.getSubletDept()==null?"":info.getSubletDept()%></em>
					   </li>
					   
					    <li>付款月数:<em>
						 <%=info.getPayMonths()==null?"":info.getPayMonths()%>月</em>
					   </li>
					    <li>原租赁面积:<em>
						  <%=info.getOldLeaseArea()==null?"":info.getOldLeaseArea()%>平米</em>
					   </li>
					    <li>原租赁单价:<em>
						  <%=info.getOldLeasePrice()==null?"":info.getOldLeasePrice()%>元/平米/月</em>
					   </li>
					    <li>现租赁面积:<em>
						 <%=info.getNewLeaseArea()==null?"":info.getNewLeaseArea()%>平米</em>
					   </li>
					   <li>现租赁单价:<em>
						 <%=info.getNewLeasePrice()==null?"":info.getNewLeasePrice()%>元/平米/月</em>
					   </li>
					   <% }%>
					   <li>优先盖章方:<em>
						 <%=info.getYfirstChopName()%></em>
					   </li>
					   <%if("2".equals(info.getBusiType())) {%>
					   <li>租赁总金额:<em>
						 <%=info.getTotalAmount()==null?"":info.getTotalAmount()%></em>
					   </li>
					   <%} %>
					   <li>申请事由:<em>
						 <%=info.getApplyReason()%></em>
					   </li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<!-- <div>
		<ul id="msg" style="display: none"> 
			<li class="fyy-textCt"><em style="color: red">该节点暂不支持手机审批</em></li>
		</ul>
	</div> -->
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
	/* $(document).ready(function(){
		var activitydefid = $('#activitydefid').val();
		//当审批节点为场地租赁组负责人时 上传附件
		if(activitydefid=="manualActivity"){
			$('#msg').show();
			document.getElementById("disagree_but").style.display = "none";
			document.getElementById("agree_but").style.display = "none";
			document.getElementById("rollback_but").style.display = "none";
			document.getElementById("approve_area").style.display = "none";
		}
	}); */
</script>
</body>
</html>