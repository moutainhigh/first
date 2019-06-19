<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.OnlineBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
<%@include file="/common_ios.jsp"%>
</head>
<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<%
OnlineBean info = (OnlineBean)request.getAttribute("entity");
%>
<body>
	<div id="list">
		<%@include file="/jsp/ios/work_items_head.jsp"%>
		<!--div2 S-->
		<div id="div2">
			<div class="ulBox2">
				<ul>
					<li class="first">工作流号:<em><%=request.getAttribute("processinstid") %>
					<input type="hidden" id="busino" value="<%=info.getBusino()%>">
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>"> </em>
					</li>
					<li>工作流:<em>开线申请</em></li>
				   <li>申请人：<em><%=info.getApplyPersonName() %></em></li>
                   <li>申请人部门：<em><%=info.getApplyDept() %></em></li>
                   <li>出发外场：<em><%=info.getOutField() %></em></li>
                   <li>到达外场：<em><%=info.getInField() %></em></li>
                   <li>出发外场所在区域：<em><%= info.getOutFieldAre()%></em></li><!--WFS_ALL_PERSONALDEPT-->
                   <li>到达外场所在区域：<em><%= info.getInFieldAre() %></em></li><!--WFS_ALL_PERSONALDEPT-->
                   <li>车辆类型：<em><%= info.getCarType()%></em></li><!--WFS_ONLINE_CARTYPE-->
                   <li>车辆型号：<em><%= info.getCarModel()%></em></li><!-- WFS_CARMODEL -->
                   <li>线路类型：<em><%= info.getLineType() %></em></li><!-- WFS_LINETYPE -->
                   <li>计划线路开设时间：<em><%=FormatUtil.formatDate(info.getPlanOnlineTime())%></em></li>
                   <li>车辆需求：<em><%=info.getCarNeed()%></em></li>
                   <li>公里数：<em><%=info.getKillMeter() %></em></li>
                   <% if(info.getCarNum()!=null && !"".equals(info.getCarNum())){%>
                   <li>预期车辆数：<em><%=info.getCarNum() %></em></li>
                    <li>预期货柜数：<em><%=info.getContainerNumNeed() %></em></li>
                   <% } %>
                    <% if(info.getCarHeadNum()!=null && !"".equals(info.getCarHeadNum())){%>
                     <li>实际车头数：<em><%=info.getCarHeadNum() %></em></li>
                     <li>实际货柜数：<em><%=info.getContainerNumActual() %></em></li>
                     <li>所属车队：<em><%=info.getCarGroup() %></em></li>
                    <% } %>
                    <% if(info.getOutTime()!=null && !"".equals(info.getOutTime())){%>
                      <li>出发时间：<em><%=info.getOutTime() %></em></li>
                      <li>到达时间：<em><%=info.getInTime() %></em></li>
                     <% } %>
                     
                     <% if(info.getBackOutTime()!=null && !"".equals(info.getBackOutTime())){%>
                     <li>返程出发时间：<em><%=info.getBackOutTime() %></em></li>
                     <li>返程到达时间：<em><%=info.getBackInTime() %></em></li>
                     <% } %>
                     
                     <% String activitydefid = (String)request.getAttribute("activitydefid");
                      //运力管理组负责人
                        if("manualActivity221".equals(activitydefid)){%>
                      	<li>实际车头数：<em><input id="carHeadNum" style="border: 1px solid;border-color: #aaa;width: 100px" type="text" name="bizEntity.carHeadNum" onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></em></li>
                   		<li>实际货柜数：<em><input id="containerNumActual" style="border: 1px solid;border-color: #aaa;width: 100px" type="text" name="bizEntity.containerNumActual"  onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></em></li>
						<f:selector displayName="所&nbsp;属&nbsp车&nbsp;队" searchModel="selectorDeptModel" jspType="ios" locationMessage="所属车队不能为空，o(~_~)o" selectorViewId="selectorDeptId"  nullText="点击查询部门" id="searchId"/>
                    <%}%>
                    <% 
                      //运输规划组审批界面
                    if("manualActivity22".equals(activitydefid)){
                    //必填项，最大长度8位整数
                    %> 
                     <li>预期车辆数：<em><input id="carNum" name="bizEntity.carNum" style="border: 1px solid;border-color: #aaa;width: 100px" type="text" onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></em></li>
                   	<li>预期货柜数：<em><input id="containerNumNeed" name="bizEntity.containerNumNeed" style="border: 1px solid;border-color: #aaa;width: 100px"  type="text" onblur="checkInputVal(this.id,'int',8);"/><font style="display:none;color: red">&nbsp;&nbsp;*必填项，最大长度8位整数</font></em></li>
                    <%}%>
                    <%
                      //时效节点组负责人审批界面  此项必填,20位长度
                        if("manualActivity311".equals(activitydefid)){%>
                      <li>出发时间：<em><input id="outTime" name="bizEntity.outTime" type="text" style="border: 1px solid;border-color: #aaa;width: 100px" onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></em></li>
                   	<li>到达时间：<em><input id="inTime" name="bizEntity.inTime" type="text"  style="border: 1px solid;border-color: #aaa;width: 100px" onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></em></li>
                   	<% String lineType = info.getLineType();
                   	//线路类型为 对发
                   	 if("对发".equals(lineType)){%>
                   		<li>返程出发时间：<em><input id="backOutTime" type="text" name="bizEntity.backOutTime" style="border: 1px solid;border-color: #aaa;width: 100px" onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></em></li>
                		<li>返程到达时间：<em><input id="backInTime" type="text" name="bizEntity.backInTime" style="border: 1px solid;border-color: #aaa;width: 100px" onblur="checkInputVal(this.id,'string',20)"/><font style="display:none;color: red">&nbsp;&nbsp;*此项必填,20位长度</font></em></li>	 
                   	 <%}}%>
                    <li>申请事由:<em><%=info.getReason()%></em></li>
				</ul>
			</div>
			<%@include file="approve_process.jsp"%>
			<%@include file="workflow_approve_button.jsp"%>
		</div>
	</div>
</body>
<f:init/>
<script type="text/javascript">
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
		if(reg.test(val) && val.length <= 8 ){
			var val = parseInt(val);
			$("#"+id).css("border-color","#aaa");
// 			$("#"+id).next().css("display","none");
		}else{
			$("#"+id).css("border-color","rgb(255, 0, 0)");
// 			$("#"+id).next().html();
			alert($("#"+id).next().html());
			return false;
		}	
	}else if(type == "string"){
		//String类型
		if(val.length <= 20 && val.length > 0){
			$("#"+id).css("border-color","#aaa");
// 			$("#"+id).next().css("display","none");
		}else{
			$("#"+id).css("border-color","rgb(255, 0, 0)");
// 			$("#"+id).next().css("display","");
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
		message = "需要填写的信息没有填写完整，请把你盖填写的数据填上吧";
	}
	$('#result_msg').html(message);
	$("#confirm_back").show();
	$("#result_window").fadeIn(600);
	$(".tipsWinCnt").show();
}
</script>
</html>