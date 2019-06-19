<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.module.workitems.webservice.client.DWFSWorkItemServiceClient"%>
<%@page import="com.deppon.wfs.workflow.domain.YardRentBean"%>
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
<body onload="autoShowApproval()">
<%
YardRentBean info = (YardRentBean)request.getAttribute("entity");
%>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.YARDRENT_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工&nbsp;&nbsp;作&nbsp;&nbsp;流:</th>
					   <td>场地租赁/转租合同<input type="hidden" id ="type_id" value="qualification"></td>
					</tr>
				   <tr>
					  <th>申请人:</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
					 <tr>
					  <th>申请人工号:</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>
				   <tr>
					  <th>业务类型:</th>
					  <td><%=info.getBusiTypeName()%></td>
				   </tr>
					 <tr>
					  <th>所属财务部:</th>
					  <td><%=info.getFinanceName()%></td>
				   </tr>
					 <tr>
					  <th>租赁开始日期:</th>
					  <td><%=info.getStartDateStr()%></td>
				   </tr>
				   <tr>
					  <th>租赁结束日期:</th>
					  <td><%=info.getEndDateStr()%></td>
				   </tr>
				   
				   <tr>
					  <th>所属事业部:</th>
					  <td><%=info.getDivisionName()%></td>
				   </tr>
					 <tr>
					  <th>所属公共事务组:</th>
					  <td><%=info.getAffairsName()%></td>
				   </tr>
					 <tr>
					  <th>签订类型:</th>
					  <td><%=info.getSignTypeName()%></td>
				   </tr>
				   <%if(!"1".equals(info.getSignType())){ %>
				    <tr>
					  <th>原合同编号:</th>
					  <td><%=info.getOldContarctNO()%></td>
				   </tr>
				   <%}%>
				   <!-- --------------------------------------------- -->
				   <%if("1".equals(info.getBusiType())){%>
					 <tr>
					  <th>所属子公司:</th>
					  <td><%=info.getSubComName()==null?"":info.getSubComName()%></td>
				   </tr>
				   <%}%>
				   <%if("1".equals(info.getBusiType())){%>
				   <tr>
					  <th>出租方名称:</th>  
					  <td><%=info.getYrentName()==null?"":info.getYrentName()%></td>
				   </tr>				   
				   
				   <tr>
					  <th>承租方名称:</th>
					  <td><%=info.getLeaseNameText()==null?"":info.getLeaseNameText()%></td>
				   </tr>
				   <tr>
					  <th>承租部门:</th>
					  <td><%=info.getLeaseDept()%></td>
				   </tr>
				   <tr>
					  <th>承租房屋面积:</th>
					  <td><%=info.getLeaseArea()%></td>
				   </tr>
				   <tr>
					  <th>每年租金:</th>
					  <td><%=info.getYearRental()%></td>
				   </tr>
				   	<tr>
					  <th>付款方式:</th>
					  <td><%=info.getPayTypeName()%></td>
				   </tr>
				   <tr>
					  <th>免租开始日期:</th>
					  <td><%=info.getFreeStartDateStr()%></td>
				   </tr>	
				   <tr>
					  <th>免租结束日期:</th>
					  <td><%=info.getFreeEndDdateStr()%></td>
				   </tr>
				   <tr>
					  <th>租赁类型:</th>
					  <td><%=info.getLeaseTypeName()%></td>
				   </tr>
				   <tr>
					  <th>工程项目编号:</th>
					  <td><%=info.getProjectID()%></td>
				   </tr>
				   <tr>
					  <th>工程项目名称:</th>
					  <td><%=info.getProjectName()%></td>
				   </tr>
				   <tr>
					  <th>押金金额:</th>
					  <td><%=info.getDepositAmount()%></td>
				   </tr>
				   <%}else{%>
				   <tr>
					  <th>出租方名称:</th>
					  <td><%=info.getPrentNameText()==null?"":info.getPrentNameText()%></td>
				   </tr>	
				   <tr>
				   <!-- -------------------------------------------------------------------------- -->
					  <th>承租方主要业务:</th>
					  <td><%=info.getLeaseBussiness()==null?"":info.getLeaseBussiness()%></td>
				   </tr>
				    <tr>
					  <th>是否改造:</th>
					  <td><%=info.getIsChangeName()==null?"":info.getIsChangeName()%></td>
				   </tr>
				    <tr>
					  <th>改造金额:</th>
					  <td><%=info.getChangeAmt()==null?"":info.getChangeAmt()%></td>
				   </tr>
				    <tr>
					  <th>转租部门:</th>
					  <td><%=info.getSubletDept()==null?"":info.getSubletDept()%></td>
				   </tr>
				    <tr>
					  <th>付款月数:</th>
					  <td><%=info.getPayMonths()==null?"":info.getPayMonths()%>月</td>
				   </tr>
				   <tr>
					  <th>原租赁面积:</th>
					  <td><%=info.getOldLeaseArea()==null?"":info.getOldLeaseArea()%>平米</td>
				   </tr>
				   <tr>
					  <th>原租赁单价:</th>
					  <td><%=info.getOldLeasePrice()==null?"":info.getOldLeasePrice()%>元/平米/月</td>
				   </tr>
				   <tr>
					  <th>现租赁面积:</th>
					  <td><%=info.getNewLeaseArea()==null?"":info.getNewLeaseArea()%>平米</td>
				   </tr>
				    <tr>
					  <th>现租赁单价:</th>
					  <td><%=info.getNewLeasePrice()==null?"":info.getNewLeasePrice()%>元/平米/月</td>
				   </tr>
				   <% }%>
				   <tr>
					  <th>优先盖章方:</th>
					  <td><%=info.getYfirstChopName()%></td>
				   </tr>
					   <%if("2".equals(info.getBusiType())) {%>
						   <tr>
							  <th>租赁总金额:</th>
							  <td><%=info.getTotalAmount()==null?"":info.getTotalAmount()%></td>
						   </tr>
					   <%} %>
					   <tr>
						  <th>申请事由:</th>
						  <td><%=info.getApplyReason()%></td>
					   </tr>
				<%@include file="approve_process.jsp" %>					   					   
	    	</table>
	    	
	    	<!-- <table width="100%" style="display: none" id="msg">
				<tr><td style="color: red" align="center" colspan="2">该节点暂不支持手机审批</td></tr>
			</table> -->
	    </div>
	</div>
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