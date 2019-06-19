<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wdgh.inteface.domain.QueryWorkflowInfoResponse"%>
<%@page import="com.deppon.wdgh.inteface.domain.NewPointDept"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
</head>

<body>
 <%
 QueryWorkflowInfoResponse infoNew = (QueryWorkflowInfoResponse)request.getAttribute("wdghBusiRsp");
 NewPointDept base = infoNew.getNewPointDept();

 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
				<tr><th>工作流:</th><td>新点开设旧点搬迁</td></tr>
				
				<!-- 新点性质为派送部成立时显示字段 -->
				<% if("SEND_POINT_FOUND".equals(base.getOriginDeptName())){%>
				<tr><th>申请人姓名:</th><td><%=base.getCreateUserName()%></td></tr>
					 <% if("NEW_POINT_OPEN".equals(base.getNewDeptType())){%>
					<tr><th>新点性质:</th><td>新点开设</td></tr>
					 <%} else if("OLD_POINT_MOVE".equals(base.getNewDeptType())){%>
					<tr><th>新点性质:</th><td>旧点搬迁</td></tr>
					<%}  else if("SEND_POINT_FOUND".equals(base.getNewDeptType())){%>
					<tr><th>新点性质:</th><td>派送部成立</td></tr>
					<%}  else {%>
					<tr><th>新点性质:</th><td><%= base.getNewDeptType()%></td></tr>
					<%} %>
				<tr><th>现部门名称:</th><td><%=base.getNewDeptType()%></td></tr>
				<tr><th>部门经理:</th><td><%=base.getDeptManagerName()%></td></tr>
					<% if("DEPT_TYPE_SETOUT".equals(base.getDeptType())){%>
				<tr><th>网点性质:</th><td>纯出发</td></tr>
				 <%} else if("DEPT_TYPE_SEND_MENTION".equals(base.getDeptType())){%>
					<tr><th>网点性质:</th><td>自提+派送</td></tr>
					<%}  else if("DEPT_TYPE_SETOUT_MENTION".equals(base.getDeptType())){%>
					<tr><th>网点性质:</th><td>出发+自提</td></tr>
					<%}  else if("DEPT_TYPE_SETOUT_SEND_MENTION".equals(base.getDeptType())){%>
					<tr><th>网点性质:</th><td>出发+自提+派送</td></tr>
					<%}  else {%>
					<tr><th>网点性质:</th><td><%= base.getDeptType()%></td></tr>
					<%} %>
				<tr><th>找点开始时间:</th><td><%=FormatUtil.formatDate(base.getLookStartTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>原部门名称:</th><td><%=base.getOriginDeptName()%></td></tr>
				<tr><th>部门电话:</th><td><%=base.getDeliverDeptAddress()%></td></tr>
				<tr><th>派送部地址:</th><td><%=base.getDeliverDeptAddress()%></td></tr>
				<tr><th>事业部:</th><td><%=base.getBusinessName()%></td></tr>
				<tr><th>档口押金（元）:</th><td><%=base.getStallPledgeAmount()%></td></tr>
				<tr><th>档口一楼面积（平方米）:</th><td><%=base.getStallGroundfloorArea()%></td></tr>
				<tr><th>大区:</th><td><%=base.getBigRegionName()%></td></tr>
				<tr><th>档口间数:</th><td><%=base.getStallsRooms()%></td></tr>
				<tr><th>合同面积:</th><td><%=base.getContractArea()%></td></tr>
				<tr><th>所属营业区:</th><td><%=base.getSmallRegionName()%></td></tr>
				<tr><th>档口层数:</th><td><%=base.getStallFloor()%></td></tr>
				<tr><th>档口租期（月）:</th><td><%=base.getStallRentPeriod()%></td></tr>
				<tr><th>所属子公司:</th><td><%=base.getCompanyName()%></td></tr>
				<tr><th>转让费用（元）:</th><td><%=base.getTransferFee()%></td></tr>
				<% if("RENT_PAYMENT_TYPE_YEAR".equals(base.getRentPaymentTime())){%>
				<tr><th>租金支付期:</th><td>年份</td></tr>
				 <%} else if("RENT_PAYMENT_TYPE_MONTH".equals(base.getRentPaymentTime())){%>
					<tr><th>租金支付期:</th><td>月度</td></tr>
					<%}  else if("RENT_PAYMENT_TYPE_QUARTER".equals(base.getRentPaymentTime())){%>
					<tr><th>租金支付期:</th><td>季度</td></tr>
					<%}  else {%>
					<tr><th>租金支付期:</th><td><%= base.getRentPaymentTime()%></td></tr>
					<%} %>
				<tr><th>省份:</th><td><%=base.getProvinceName()%></td></tr>
				<tr><th>单位面积租金（元/平方米）:</th><td><%=base.getRentPerUnitarea()%></td></tr>
				<tr><th>是否驻地部门:</th><td><%="Y".equals(base.getIsStation())?"是":"否"%></td></tr>
				<tr><th>城市:</th><td><%=base.getCityName()%></td></tr>
				<tr><th>档口月租金（元/月）:</th><td><%=base.getStallRentAmount()%></td></tr>
				<tr><th>是否可以办证:</th><td><%="Y".equals(base.getIsCanhandleCretificate())?"是":"否"%></td></tr>
				<tr><th>区/县:</th><td><%=base.getCountyName()%></td></tr>
					<% if("RENT_PAY_TYPE_REMIT".equals(base.getRentPaymentType())){%>
					<tr><th>租金支付方式:</th><td>汇款</td></tr>
				 	<%} else if("RENT_PAY_TYPE_CASH".equals(base.getRentPaymentType())){%>
					<tr><th>租金支付方式:</th><td>现金</td></tr>
					<%}  else {%>
					<tr><th>租金支付方式:</th><td><%= base.getRentPaymentType()%></td></tr>
					<%} %>
				<tr><th>大区总看点时间:</th><td><%=FormatUtil.formatDate(base.getLookTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>网络是否满足2M:</th><td><%="Y".equals(base.getIsSatisfy())?"是":"否"%></td></tr>
				<tr><th>计划网点名称:</th><td><%=base.getPlanDeptName()%></td></tr>
				<tr><th>申请事由:</th><td><%=base.getReason()%></td></tr>
				<%} else {%>
					<tr><th>申请人姓名:</th><td><%=base.getCreateUserName()== null?"":base.getCreateUserName()%></td></tr>
				 <% if("NEW_POINT_OPEN".equals(base.getNewDeptType())){%>
				<tr><th>新点性质:</th><td>新点开设</td></tr>
					 <%} else if("OLD_POINT_MOVE".equals(base.getNewDeptType())){%>
					<tr><th>新点性质:</th><td>旧点搬迁</td></tr>
					<%}  else if("SEND_POINT_FOUND".equals(base.getNewDeptType())){%>
					<tr><th>新点性质:</th><td>派送部成立</td></tr>
					<%}  else {%>
					<tr><th>新点性质:</th><td><%= base.getNewDeptType()%></td></tr>
					<%} %>
				<tr><th>现部门名称:</th><td><%=base.getCurrentDeptName()%></td></tr>
				<tr><th>部门经理:</th><td><%=base.getDeptManagerName()%></td></tr>
					<% if("DEPT_TYPE_SETOUT".equals(base.getDeptType())){%>
				<tr><th>网点性质:</th><td>纯出发</td></tr>
				 <%} else if("DEPT_TYPE_SEND_MENTION".equals(base.getDeptType())){%>
					<tr><th>网点性质:</th><td>自提+派送</td></tr>
					<%}  else if("DEPT_TYPE_SETOUT_MENTION".equals(base.getDeptType())){%>
					<tr><th>网点性质:</th><td>出发+自提</td></tr>
					<%}  else if("DEPT_TYPE_SETOUT_SEND_MENTION".equals(base.getDeptType())){%>
					<tr><th>网点性质:</th><td>出发+自提+派送</td></tr>
					<%}  else {%>
					<tr><th>网点性质:</th><td><%= base.getDeptType()%></td></tr>
					<%} %>
					<!-- 当新点性质为旧点搬迁时方显 -->
				<% if("OLD_POINT_MOVE".equals(base.getNewDeptType())){%>
				<tr><th>原部门名称:</th><td><%=base.getOriginDeptName()%></td></tr>
				<%} %>
				<tr><th>所属子公司:</th><td><%=base.getCompanyName()%></td></tr>
				<tr><th>事业部:</th><td><%=base.getBusinessName()%></td></tr>
				<tr><th>大区:</th><td><%=base.getBigRegionName()%></td></tr>
				<tr><th>所属营业区:</th><td><%=base.getSmallRegionName()%></td></tr>
				<tr><th>省份:</th><td><%=base.getProvinceName()%></td></tr>
				<tr><th>城市:</th><td><%=base.getCityName()%></td></tr>
				<tr><th>区/县:</th><td><%=base.getCountyName()%></td></tr>
				<tr><th>找点开始时间:</th><td><%=FormatUtil.formatDate(base.getLookStartTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>大区总看点时间:</th><td><%=FormatUtil.formatDate(base.getLookTime(),"yyyy-MM-dd")%></td></tr>
				<tr><th>档口押金（元）:</th><td><%=base.getStallPledgeAmount()%></td></tr>
				<tr><th>档口间数:</th><td><%=base.getStallsRooms()%></td></tr>
				<tr><th>档口层数:</th><td><%=base.getStallFloor()%></td></tr>
				<tr><th>档口一楼面积:</th><td><%=base.getStallGroundfloorArea()%></td></tr>
				<tr><th>合同面积:</th><td><%=base.getContractArea()%></td></tr>
				<tr><th>是否驻地部门:</th><td><%="Y".equals(base.getIsStation())?"是":"否"%></td></tr>
				<tr><th>转让费用（元）:</th><td><%=base.getTransferFee()%></td></tr>
				<tr><th>档口月租金（元/月）:</th><td><%=base.getStallRentAmount()%></td></tr>
				<tr><th>是否可以办证:</th><td><%="Y".equals(base.getIsCanhandleCretificate())?"是":"否"%></td></tr>
				<tr><th>单位面积租金:</th><td><%=base.getRentPerUnitarea()%></td></tr>
				<% if("RENT_PAYMENT_TYPE_YEAR".equals(base.getRentPaymentTime())){%>
				<tr><th>租金支付期:</th><td>年份</td></tr>
				 <%} else if("RENT_PAYMENT_TYPE_MONTH".equals(base.getRentPaymentTime())){%>
					<tr><th>租金支付期:</th><td>月度</td></tr>
					<%}  else if("RENT_PAYMENT_TYPE_QUARTER".equals(base.getRentPaymentTime())){%>
					<tr><th>租金支付期:</th><td>季度</td></tr>
					<%}  else {%>
					<tr><th>租金支付期:</th><td><%= base.getRentPaymentTime()%></td></tr>
					<%} %>
				<tr><th>网络是否满足2M:</th><td><%="Y".equals(base.getIsSatisfy())?"是":"否"%></td></tr>
				<tr><th>档口租期（月）:</th><td><%=base.getStallRentPeriod()%></td></tr>
					<% if("RENT_PAY_TYPE_REMIT".equals(base.getRentPaymentType())){%>
					<tr><th>租金支付方式:</th><td>汇款</td></tr>
				 	<%} else if("RENT_PAY_TYPE_CASH".equals(base.getRentPaymentType())){%>
					<tr><th>租金支付方式:</th><td>现金</td></tr>
					<%}  else {%>
					<tr><th>租金支付方式:</th><td><%= base.getRentPaymentType()%></td></tr>
					<%} %>
				<tr><th>是否集中接货:</th><td><%="Y".equals(base.getIsFocusReceive())?"是":"否"%></td></tr>
				
				<tr><th>出发选址得分:</th><td><%=base.getDepartureLocateScore()%></td></tr>
				<tr><th>到达选址得分:</th><td><%=base.getArriveLocateScore()%></td></tr>
				<tr><th>市场评分:</th><td><%=base.getMarketingScore()== null?"":base.getMarketingScore()%></td></tr>
				<tr><th>申请事由:</th><td><%=base.getReason()%></td></tr>
				<%} %>
				<tbody class="oneTicNoDetil" style="display: none">
					<tr>
						<th>一票否决（以下任意情况的新档口，不给予开设）：</th>
						<td>
							<input type="checkbox" value="网点合同面积小于规划面积" id="oneTicNoDetil1">网点合同面积小于规划面积<br>
							<input type="checkbox" value="不能办理电信或网通的网线（流量≥2M）、电话线的" id="oneTicNoDetil2">不能办理电信或网通的网线（流量≥2M）、电话线的<br>
							<input type="checkbox" value="不能取得或代开房租发票的" id="oneTicNoDetil3">不能取得或代开房租发票的<br>
							<input type="checkbox" value="部门两旁的商户或房东强烈反对做到达业务" id="oneTicNoDetil4">部门两旁的商户或房东强烈反对做到达业务<br>
							<input type="checkbox" value="部门两旁的商户强烈反对做物流行业的" id="oneTicNoDetil5">部门两旁的商户强烈反对做物流行业的<br>
							<input type="checkbox" value="部门前面台阶影响装卸车且不允许改建" id="oneTicNoDetil6">部门前面台阶影响装卸车且不允许改建<br>
							<input type="checkbox" value="纯出发：集中接送货区域面积>70M²，非集中接送货区域>100M²,出发加自提：地级<85%规划面积,县级<85%规划面积²" id="oneTicNoDetil7">纯出发：集中接送货区域面积>70M²，非集中接送货区域>100M²,出发加自提：地级<85%规划面积,县级<85%规划面积²<br>
							<input type="checkbox" value="物流园任何一个门进，都需拐三次弯才可到达部门" id="oneTicNoDetil8">物流园任何一个门进，都需拐三次弯才可到达部门<br>
							<input type="checkbox" value="道路存在交通管制影响车辆进出（货车限行、禁止停车等）" id="oneTicNoDetil9">道路存在交通管制影响车辆进出（货车限行、禁止停车等）<br>
							<input type="checkbox" value="房东没有房产证明，或部门不能正常办理各证件的" id="oneTicNoDetil10">房东没有房产证明，或部门不能正常办理各证件的<br>
							<input type="checkbox" value="附近300米之内有加气站的" id="oneTicNoDetil11">附近300米之内有加气站的<br>
							<input type="checkbox" value="距离部门50米范围内有学校、医院、菜市场等非客户人员密集场所" id="oneTicNoDetil12">距离部门50米范围内有学校、医院、菜市场等非客户人员密集场所<br>
							<input type="checkbox" value="若新租点的停车位不能停4.2的车的" id="oneTicNoDetil13">若新租点的停车位不能停4.2的车的<br>
							<input type="checkbox" value="停车位倾斜度导致液压叉车不能使用" id="oneTicNoDetil14">停车位倾斜度导致液压叉车不能使用<br>
							<input type="checkbox" value="物流、专线、快递同行总数小于15家，禁止用此此测评表" id="oneTicNoDetil15">物流、专线、快递同行总数小于15家，禁止用此此测评表<br>
							<input type="checkbox" value="新进地级城市在市区10公里范围之外的，档口面积少于300M²的" id="oneTicNoDetil16">新进地级城市在市区10公里范围之外的，档口面积少于300M²的<br>
							<input type="checkbox" value="一次交租超过12个月(不含12个月)的" id="oneTicNoDetil17">一次交租超过12个月(不含12个月)的<br>
							<input type="checkbox" value="政府有城建规划而使部门无法营业的" id="oneTicNoDetil18">政府有城建规划而使部门无法营业的<br>
							<input type="checkbox" value="专业市场内存在某条线路或某类货物不允许做的" id="oneTicNoDetil19">专业市场内存在某条线路或某类货物不允许做的
						</td>
					</tr>
				</tbody>
		  </table>
		  <%@include file="approve_process.jsp" %>
		</div>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
	<input type="hidden" value="<%=request.getAttribute("activitydefid")%>" id="activitydefid">
</div>
<script type="text/javascript">
$(document).ready(function(){
	var activitydefid = $("#activitydefid").val();
	if("manualActivity1" == activitydefid){
		$('.oneTicNoDetil').show();
		
		$("#oneTicNoDetil1").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil1").val();
			$("#textarea-a").val(area + oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil1").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil2").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil2").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil2").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil3").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil3").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil3").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue =$(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil4").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil4").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil4").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil5").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil5").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil5").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue =$(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil6").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil6").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil6").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil7").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil7").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil7").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil8").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil8").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil8").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil9").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil9").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil9").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil10").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil10").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil10").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil11").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil11").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil11").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue =$(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil12").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil12").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil12").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue =$(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil13").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil13").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil13").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil14").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil14").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil14").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue =$(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil15").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil15").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil15").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil16").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil16").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil16").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil17").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil17").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil17").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil18").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil18").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil18").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
		$("#oneTicNoDetil19").click(function(){
			var area = $("#textarea-a").val();
			var oneTicNoDetil1 = $("#oneTicNoDetil19").val();
			$("#textarea-a").val(area +";"+ oneTicNoDetil1);
			if(!(document.getElementById("oneTicNoDetil19").checked)){
				$("#textarea-a").val("");
			var input = $(".oneTicNoDetil").find("input");
			var testArea = "";
				for(var i =0 ; i<input.length;i++){
					if(input[i].checked){
					var areaValue = $(input[i]).val();
					
					testArea = testArea + areaValue;
					 $("#textarea-a").val(testArea);
					}
				}
			}
			textArea();
		});
	}
});
		
</script>
</body>
</html>