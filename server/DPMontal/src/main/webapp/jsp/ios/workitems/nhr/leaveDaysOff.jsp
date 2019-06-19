<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.VacationInfo" %>
<%@page import="com.deppon.nhr.module.remote.dpm.shared.domain.workflow.Vacationdetail" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title")%>-待办事项</title>
<meta http-equiv="Content-Type"
	content="application/xhtml+xml; charset=UTF-8" />
<%@include file="/common_ios.jsp"%>
<style type="text/css">
li {
	word-wrap: break-word;
}
</style>
</head>
<%
QueryWorkflowInfoResponse hrBusiLea = (QueryWorkflowInfoResponse)request.getAttribute("hrBusiRsp");
VacationInfo info = hrBusiLea.getVacationInfo();
List detailList = info.getVacationdetails();
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
				<li style="border-top: 1px none #aaa;">
					<em class="yellow">基本信息</em>
				</li>
 				<li> 申请单编号:<em><%=info.getWfno() == null ? "" : info.getWfno()%></em></li> 
			   	<li> 申请人工号:<em><%= info.getApplypsncode() == null ? "" : info.getApplypsncode()%></em></li>
			   	<li>申请人姓名:<em><%= info.getApplypsnname() == null ? "" : info.getApplypsnname()%></em></li>
			   	<li>申请人职位:<em><%=info.getPosition() == null ? "" : info.getPosition()%></em></li>
			    <li>入职日期:<em><%=info.getIndate() == null ? "" : FormatUtil.formatDate(info.getIndate())%></em></li>
			   	<li>申请时间:<em><%=info.getApplydate() == null ? "" : FormatUtil.formatDate(info.getApplydate())%></em></li>
			   	<li>身份证号:<em><%=info.getDocnumber() == null ? "" : info.getDocnumber()%></em></li>
			   	<li> 您在本年度已休假明细:<em><%=info.getAnnualVacationDetailInfo()%>
			   	</em></li> 
			   	<li> 所属部门:<em><%=info.getApplydeptname() == null ? "" : info.getApplydeptname()%></em></li>
			   	<li>所属区域:<em><%=info.getHrdeptname() == null ? "" : info.getHrdeptname()%></em></li>
			   	<li>申请类型:<em><%= info.getApplytype() == null ? "" : info.getApplytype()%></em></li>
			   	<!-- 申请类型为请假申请时显示 classOne --> 
			    <li class="classOne">请假类型:<em class="classOne"><%=info.getVacationclass() == null ? "" : info.getVacationclass()%></em></li>
			    <li class="classOne">假期所属类型:
			     <%if("病假".equals(info.getVacationclass())){ %>
			    	<em class="classOne">病假</em>
			     <%}else if("产假".equals(info.getVacationclass())){ %>
			    	<em class="classOne">产假</em>
			     <%}else if("事假".equals(info.getVacationclass())){ %>
			    	<em class="classOne">无薪假</em>
			     <%}else{ %>
			    	<em class="classOne">全薪假</em>
			     <%} %>	
			    </li>
			    <!-- 请假类型为婚嫁时显示 classMarry -->
			   	<li class="classOne classMarry">结婚日期:<em class="classOne classMarry"><%=info.getWeddingday() == null ? "" : FormatUtil.formatDate(info.getWeddingday())%></em></li>
			   	<li class="classOne">请假开始日期:<em class="classOne"><%=info.getBegindate() == null ? "" : FormatUtil.formatDate(info.getBegindate()) %></em></li>
			  	<li class="classOne">请假结束日期:<em class="classOne"><%=info.getEnddate() == null ? "" : FormatUtil.formatDate(info.getEnddate()) %></em></li>
			  	<li class="classOne">请假天数:<em class="classOne"><%= info.getVacationdays() == null ? "" : info.getVacationdays()%></em></li>
			  	<li class="classOne">工作交接人:<em class="classOne"><%= info.getHandovername() == null ? "" : info.getHandovername()%></em></li>
			  	<!-- 申请类型为加班调休申请时显示 classTwo --> 
			  	<li class="classTwo">加班工作流号:<em class="classTwo"><%=info.getVacationwokflowno() == null ? "" : info.getVacationwokflowno()%></em></li>
			  	<li class="classTwo">加班天数:<em class="classTwo"><%=info.getExtraworkdays() == null ? "" : info.getExtraworkdays()%></em></li>
			  	<li class="classTwo">请假/调休开始日期:<em class="classTwo"><%=info.getBegindate() == null ? "" : FormatUtil.formatDate(info.getBegindate()) %></em></li>
			  	<li class="classTwo">请假/调休结束日期:<em class="classTwo"><%=info.getEnddate() == null ? "" : FormatUtil.formatDate(info.getEnddate()) %></em></li>
			  	<li class="classTwo">请假/调休天数:<em class="classTwo"><%= info.getVacationdays() == null ? "" : info.getVacationdays()%></em></li>
			  	<li class="classTwo">工作交接人:<em class="classTwo"><%= info.getHandovername() == null ? "" : info.getHandovername()%></em></li>
			  	<!-- 申请类型为销假申请时显示 classThree --> 
			  	<li class="classThree">请假工作流号:<em class="classThree"><%=info.getVacationwokflowno() == null ? "" : info.getVacationwokflowno()%></em></li>
			  	<li class="classThree">销假类型:<em class="classThree"><%=info.getVacationclass() == null ? "" : info.getVacationclass()%></em></li>
			  	<li class="classThree">销假开始日期:<em class="classThree"><%=info.getBegindate() == null ? "" : FormatUtil.formatDate(info.getBegindate()) %></em></li>
			  	<li class="classThree">销假结束日期:<em class="classThree"><%=info.getEnddate() == null ? "" : FormatUtil.formatDate(info.getEnddate()) %></em></li>
			  	<li class="classThree">销假天数:<em class="classThree"><%= info.getVacationdays() == null ? "" : info.getVacationdays()%></em></li>
			  	<li class="classThree">工作交接人:<em class="classThree"><%= info.getHandovername() == null ? "" : info.getHandovername()%></em></li> 
			  	<!-- 申请类型为加班调休时不显示 classFour-->
			  	  <li class="yellow classFour">
						<em colspan="2" class="classFour">假期明细</em>
					</li>
				<%
					int detailSize = detailList ==  null ? 0:detailList.size();
					for(int i = 0; i<detailSize; i++){
						Vacationdetail detail = (Vacationdetail)detailList.get(i);
				%>
				 	<li class='topLine classFour'> 假期年月:<em class='classFour'><%= detail.getVacationperiod() == null ? "" : detail.getVacationperiod()%></em></li>
				   <li class="classFour">假期天数:<em class="classFour"><%=detail.getVacationdays() == null ? "" : detail.getVacationdays() %></em></li>
				   <%}%> 
				<li>申请事由:<em><%= info.getApplyreason() == null ? "" : info.getApplyreason()%></em></li> 
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
		</div>
		<%@include file="workflow_approve_button.jsp"%>
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