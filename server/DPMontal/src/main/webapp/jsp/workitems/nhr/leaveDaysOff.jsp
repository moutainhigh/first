<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>

<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.VacationInfo" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.Vacationdetail" %>

<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@page import="java.util.Date"%> 
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	
</head>

<body>
 <%
 QueryWorkflowInfoResponse hrBusiLea = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
 VacationInfo info = hrBusiLea.getVacationInfo();
 List detailList = info.getVacationdetails();
 
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    		<tr>
					<th colspan="2" class="yellow">基本信息</th>
				</tr>
				<tr>
				  <th >申请单编号:</th>
				  <td><%=info.getWfno() == null ? "" : info.getWfno()%></td>
			   	</tr>
			   	<tr>
				  <th >申请人工号:</th>
				  <td><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></td>
			   	</tr>
			   	<tr>
				  <th >申请人姓名:</th>
				  <td><%= info.getApplypsnname() == null ? "" : info.getApplypsnname()%></td>
			   	</tr>
			   	<tr>
				  <th >申请人职位:</th>
				  <td><%=info.getPosition() == null ? "" : info.getPosition()%></td>
			    </tr>
			   	<tr>
				  <th >入职日期:</th>
				  <td><%=info.getIndate() == null ? "" : FormatUtil.formatDate(info.getIndate())%></td>
			  	 </tr>
			  	 	<tr>
				  <th >申请时间:</th>
				  <td><%=info.getApplydate() == null ? "" : FormatUtil.formatDate(info.getApplydate())%></td>
			  	 </tr>
				<tr>
				  <th >身份证号:</th>
				  <td><%=info.getDocnumber() == null ? "" : info.getDocnumber()%></td>
			    </tr>	
			   <tr>
					<th >您在本年度已休假明细:</th>
					<td><%=info.getAnnualVacationDetailInfo()%></td>
				</tr>
				<tr>
					<th >所属部门:</th>
					<td><%=info.getApplydeptname() == null ? "" : info.getApplydeptname()%></td>
				</tr>
				<tr>
					<th >所属区域:</th>
					<td><%=info.getHrdeptname() == null ? "" : info.getHrdeptname()%></td>
				</tr>
				<tr>
					<th >申请类型:</th>
					<td><%= info.getApplytype() == null ? "" : info.getApplytype()%></td>
				</tr>
				
				<!-- 申请类型为请假申请时显示 classOne --> 
				 <tr class="classOne">
				  <th class="classOne">请假类型:</th>
				  <td class="classOne"><%=info.getVacationclass() == null ? "" : info.getVacationclass()%></td>
			    </tr>
			    <tr class="classOne">
				  <th class="classOne">假期所属类型:</th>
 				  <%if("病假".equals(info.getVacationclass())){ %>
				  	<td class="classOne">病假</td>
				  <%}else if("产假".equals(info.getVacationclass())){ %>
				  	<td class="classOne">产假</td>
				  <%}else if("事假".equals(info.getVacationclass())){ %>
				  	<td class="classOne">无薪假</td>
				  <%}else{ %>
				  	<td class="classOne">全薪假</td>
				  <%} %>
			    </tr>
			    	
			    	<!-- 请假类型为婚嫁时显示 classMarry -->
			   <tr class="classOne classMarry">
					<th class="classOne classMarry">结婚日期:</th>
					<td class="classOne classMarry"><%=info.getWeddingday() == null ? "" : FormatUtil.formatDate(info.getWeddingday()) %></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">请假开始日期:</th>
					<td class="classOne"><%=info.getBegindate() == null ? "" : FormatUtil.formatDate(info.getBegindate()) %></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">请假结束日期:</th>
					<td class="classOne"><%=info.getEnddate() == null ? "" : FormatUtil.formatDate(info.getEnddate()) %></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">请假天数:</th>
					<td class="classOne"><%= info.getVacationdays() == null ? "" : info.getVacationdays()%></td>
				</tr>
				<tr class="classOne">
					<th class="classOne">工作交接人:</th>
					<td class="classOne"><%= info.getHandovername() == null ? "" : info.getHandovername()%></td>
				</tr> 
				
				<!-- 申请类型为加班调休申请时显示 classTwo --> 
				 <tr class="classTwo">
				  <th class="classTwo">加班工作流号:</th>
				  <td class="classTwo"><%=info.getVacationwokflowno() == null ? "" : info.getVacationwokflowno()%></td>
			    </tr>	
			   <tr class="classTwo">
					<th class="classTwo">加班天数:</th>
					<td class="classTwo"><%=info.getExtraworkdays() == null ? "" : info.getExtraworkdays()%></td>
				</tr>
				<tr class="classTwo">
					<th class="classTwo">请假/调休开始日期:</th>
					<td class="classTwo"><%=info.getBegindate() == null ? "" : FormatUtil.formatDate(info.getBegindate()) %></td>
				</tr>
				<tr class="classTwo">
					<th class="classTwo">请假/调休结束日期:</th>
					<td class="classTwo"><%=info.getEnddate() == null ? "" : FormatUtil.formatDate(info.getEnddate()) %></td>
				</tr>
				<tr class="classTwo">
					<th class="classTwo">请假/调休天数:</th>
					<td class="classTwo"><%= info.getVacationdays() == null ? "" : info.getVacationdays()%></td>
				</tr>
				<tr class="classTwo">
					<th class="classTwo">工作交接人:</th>
					<td class="classTwo"><%= info.getHandovername() == null ? "" : info.getHandovername()%></td>
				</tr>  
				
				<!-- 申请类型为销假申请时显示 classThree --> 
				 <tr class="classThree">
				  <th class="classThree">请假工作流号:</th>
				  <td class="classThree"><%=info.getVacationwokflowno() == null ? "" : info.getVacationwokflowno()%></td>
			    </tr>	
			   <tr class="classThree">
					<th class="classThree">销假类型:</th>
					<td class="classThree"><%=info.getVacationclass() == null ? "" : info.getVacationclass()%></td>
				</tr>
				<tr class="classThree">
					<th class="classThree">销假开始日期:</th>
					<td class="classThree"><%=info.getBegindate() == null ? "" : FormatUtil.formatDate(info.getBegindate()) %></td>
				</tr>
				<tr class="classThree">
					<th class="classThree">销假结束日期:</th>
					<td class="classThree"><%=info.getEnddate() == null ? "" : FormatUtil.formatDate(info.getEnddate()) %></td>
				</tr>
				<tr class="classThree">
					<th class="classThree">销假天数:</th>
					<td class="classThree"><%= info.getVacationdays() == null ? "" : info.getVacationdays()%></td>
				</tr>
				<tr class="classThree">
					<th class="classThree">工作交接人:</th>
					<td class="classThree"><%= info.getHandovername() == null ? "" : info.getHandovername()%></td>
				</tr> 
				<!-- 申请类型为加班调休时不显示 classFour-->
				 <tr class="yellow classFour">
						<td colspan="2" class="classFour">假期明细</td>
					</tr>
				<%
					int detailSize = detailList ==  null ? 0:detailList.size();
					for(int i = 0; i<detailSize; i++){
						Vacationdetail detail = (Vacationdetail)detailList.get(i);
				%>
				 <tr  class='topLine classFour'>
					  <th class="classFour">假期年月:</th>
					  <td class="classFour"><%= detail.getVacationperiod() == null ? "" : detail.getVacationperiod()%></td>
				   </tr>
					<tr class="classFour">
					  <th class="classFour">假期天数:</th><!-- amountOfConsignment -->
					  <td class="classFour"><%=detail.getVacationdays() == null ? "" : detail.getVacationdays() %></td>
				 </tr>
				   <% } %> 	
				<tr>
					<th >申请事由:</th>
					<td><%= info.getApplyreason() == null ? "" : info.getApplyreason()%></td>
				</tr>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<script type="text/javascript">
$(function(){

	var applyTypeCode = '<%=info.getApplytypeCode()%>';
	var vacationclass = '<%=info.getVacationclass()%>';
	
	//申请类型为请假申请时显示 classOne
	if (applyTypeCode == 'vctapply' ) {
		//请假类型为婚嫁时显示 classMarry
		$(".classOne").show();
		$(".classTwo").hide();
		$(".classThree").hide();
		//请假类型为婚假时显示 classMarry
		if(vacationclass == "婚假" ) {
			$(".classMarry").show();
		}else{
			$(".classMarry").hide();
		}
	}
	//申请类型为加班调休申请时显示 classTwo
	//申请类型为加班调休时不显示 classFour
	else if(applyTypeCode == 'overtime' ){
		$(".classOne").hide();
		$(".classTwo").show();
		$(".classThree").hide();
		$(".classFour").hide();
	}
	//申请类型为销假申请时显示 classThree
	else {
		$(".classOne").hide();
		$(".classTwo").hide();
		$(".classThree").show();
	}
});
</script>
</body>
</html>