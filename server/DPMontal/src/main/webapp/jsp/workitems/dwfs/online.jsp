<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.OnlineBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_win8.jsp" %>
	<style>
/* 	tr.details, tr.qytr { display:none;} */
	</style>
</head>
<body onload="autoShowApproval()">
<%
OnlineBean info = (OnlineBean)request.getAttribute("entity");
 %>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
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
					   <td>开线申请</td>
					</tr>
				   <tr><th>申请人：</th><td><%=info.getApplyPersonName() %></td></tr>
                   <tr><th>申请人部门：</th><td><%=info.getApplyDept() %></td></tr>
                   <tr><th>出发外场：</th><td><%=info.getOutField() %></td></tr>
                   <tr><th>到达外场：</th><td><%=info.getInField() %></td></tr>
                   <tr><th>出发外场所在区域：</th><td><%= info.getOutFieldAre()%></td></tr><!--WFS_ALL_PERSONALDEPT-->
                   <tr><th>到达外场所在区域：</th><td><%= info.getInFieldAre() %></td></tr><!--WFS_ALL_PERSONALDEPT-->
                   <tr><th>车辆类型：</th><td><%= info.getCarType()%></td></tr><!--WFS_ONLINE_CARTYPE-->
                   <tr><th>车辆型号：</th><td><%= info.getCarModel()%></td></tr><!-- WFS_CARMODEL -->
                   <tr><th>线路类型：</th><td><%= info.getLineType() %></td></tr><!-- WFS_LINETYPE -->
                   <tr><th>计划线路开设时间：</th><td><%=FormatUtil.formatDate(info.getPlanOnlineTime())%></td></tr>
                   <tr><th>车辆需求：</th><td><%=info.getCarNeed()%></td></tr>
                   <tr><th>公里数：</th><td><%=info.getKillMeter() %></td></tr>
                   <% if(info.getCarNum()!=null && !"".equals(info.getCarNum())){%>
                   <tr><th>预期车辆数：</th><td><%=info.getCarNum() %></td></tr>
                    <tr><th>预期货柜数：</th><td><%=info.getContainerNumNeed() %></td></tr>
                   <% } %>
                    <% if(info.getCarHeadNum()!=null && !"".equals(info.getCarHeadNum())){%>
                     <tr><th>实际车头数：</th><td><%=info.getCarHeadNum() %></td></tr>
                     <tr><th>实际货柜数：</th><td><%=info.getContainerNumActual() %></td></tr>
                     <tr><th>所属车队：</th><td><%=info.getCarGroup() %></td></tr>
                    <% } %>
                    <% if(info.getOutTime()!=null && !"".equals(info.getOutTime())){%>
                      <tr><th>出发时间：</th><td><%=info.getOutTime() %></td></tr>
                      <tr><th>到达时间：</th><td><%=info.getInTime() %></td></tr>
                     <% } %>
                     
                     <% if(info.getBackOutTime()!=null && !"".equals(info.getBackOutTime())){%>
                     <tr><th>返程出发时间：</th><td><%=info.getBackOutTime() %></td></tr>
                     <tr><th>返程到达时间：</th><td><%=info.getBackInTime() %></td></tr>
                     <% } %>
                     
                     <% String activitydefid = (String)request.getAttribute("activitydefid");
                      //运力管理组负责人
                        if("manualActivity221".equals(activitydefid)){%>
                      	<tr><th>实际车头数：</th><td><input id="carHeadNum" style="border: 1px solid;border-color: #aaa;width: 100px" type="text" name="bizEntity.carHeadNum" onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></td></tr>
                   		<tr><th>实际货柜数：</th><td><input id="containerNumActual" style="border: 1px solid;border-color: #aaa;width: 100px" type="text" name="bizEntity.containerNumActual"  onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></td></tr>
						<f:selector displayName="所属车队" searchModel="selectorDeptModel" locationMessage="所属车队不能为空，o(~_~)o" selectorViewId="selectorDeptId"  nullText="点击查询部门" id="searchId"/>
                    <%}%>
                    <% 
                      //运输规划组审批界面
                    if("manualActivity22".equals(activitydefid)){
                    //必填项，最大长度8位整数
                    %> 
                      <tr><th>预期车辆数：</th><td><input id="carNum" name="bizEntity.carNum" type="text" style="border: 1px solid;border-color: #aaa;width: 100px" onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></td></tr>
                   	<tr><th>预期货柜数：</th><td><input id="containerNumNeed" name="bizEntity.containerNumNeed" style="border: 1px solid;border-color: #aaa;width: 100px"  type="text" onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></td></tr>
                    <%}%>
                    <%
                      //时效节点组负责人审批界面  此项必填,20位长度
                        if("manualActivity311".equals(activitydefid)){%>
                      <tr><th>出发时间：</th><td><input id="outTime" name="bizEntity.outTime" style="border: 1px solid;border-color: #aaa;width: 100px" type="text" onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></td></tr>
                   	<tr><th>到达时间：</th><td><input id="inTime" name="bizEntity.inTime" style="border: 1px solid;border-color: #aaa;width: 100px" type="text"  onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></td></tr>
                   	<% String lineType = info.getLineType();
                   	//线路类型为 对发
                   	 if("对发".equals(lineType)){%>
                   		<tr><th>返程出发时间：</th><td><input id="backOutTime" type="text" style="border: 1px solid;border-color: #aaa;width: 100px" name="bizEntity.backOutTime" onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></td></tr>
                		<tr><th>返程到达时间：</th><td><input id="backInTime" type="text" style="border: 1px solid;border-color: #aaa;width: 100px" name="bizEntity.backInTime" onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></td></tr>	 
                   	 <%}}%>
                   	 
                    <tr><th valign="top" style="width:150px;">申请事由：</th><td colspan="3"><%=info.getReason() %></td></tr>	   
				<%@include file="approve_process.jsp" %>	   					   
	    	</table>
	    </div>
	     <%@include file="workflow_approve_button.jsp" %>
	</div>
</div>
<f:init/>
</body>
<script>
//String左侧去除特定字符
String.prototype.LTrim = function(obj) 
{
	var str = "/(^"+obj+"*)/g";
	var str = eval(str);
	return this.replace(str, ""); 
}
$(function(){
	$("#rollback_but").hide();
	//不同意按钮隐藏
	$("#disagree_but").hide();
	var activitydefid = $("#activitydefid").val();
	//场地和线路规划组部门负责人节点 不同意按钮显示
	if("manualActivity1" == activitydefid){
		$("#disagree_but").show();
	}
	if("manualActivity221" == activitydefid || "manualActivity22" == activitydefid || "manualActivity311" == activitydefid){
		$("#approval_url").val('<%=F_Constants.APPROVAL_SAVEENTITY_URL%>');
	}
});
function checkInputVal(id,type,length){
	var val = $("#"+id).val();
	var text = $("#"+id).parent().prev().text();
	var val = val.trim();
	if(type == "int"){
		//整数类型
		var reg = /^\d+$/;
		var val = val.LTrim("0");
		if(reg.test(val) && val.length <= length ){
			var val = parseInt(val);
			$("#"+id).css("border-color","#aaa");
// 			$("#"+id).css("border","1px solid");
		}else{
			$("#"+id).css("border-color","rgb(255, 0, 0)");
			alert($("#"+id).next().html());
			return false;
		}	
	}else if(type == "string"){
		//String类型
		if(val.length <= length && val.length > 0){
			$("#"+id).css("border-color","#aaa");
		}else{
			$("#"+id).css("border-color","rgb(255, 0, 0)");
			alert($("#"+id).next().html());
			return false;
		}
	}
	$("#"+id).val(val);
	return true;
}

function isValid(){
	var flag = false;
// 	var input = $.find("input");
//获取所有input[type=text]框
	var inputs = $.find("input[type=text]");
	for(var i = 0;i < inputs.length;i++){
		var input = inputs[i];
		var input_onblur = input.getAttribute("onblur");
		if(input_onblur != null){
			var inputID = input.getAttribute("id");
			var input_onblur = $(input).attr("onblur");
			input_onblur = input_onblur.replace("this.id",'"'+input.id+'"');
			flag = eval(input_onblur);
			//校验失败
			if(flag == false){
				//当前框    下一个对象文本  提示消息
				var input_next = $(input).next();
				var html = input_next.html();
				alert(html);
				return flag;
			}
		}
	}
	//当页面没有需要添加字段时
	if(inputs == null || inputs.length == 0){
		flag = true;
	}
	return flag;
}
function alert(message){
	if (message.length == 0) {
		message = "需要填写的信息没有填写完整，请把你该填写的数据填上吧";
	}
	$('#result_msg').html(message);
	$("#confirm_back").show();
	$("#result_window").fadeIn(600);
	$(".tipsWinCnt").show();
}
</script>
</html>