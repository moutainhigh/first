<%@page import="sun.text.resources.FormatData"%>
<%@page import="java.text.Format"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.wfs.workflow.domain.CourtRelocationBean"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>
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
	CourtRelocationBean info = (CourtRelocationBean)request.getAttribute("entity");
	String activitydefid = (String)request.getAttribute("activitydefid");
%>
<f:init/>
<div id="list">
	<%@include file="../wf_head_win8.jsp" %>
	<input type="hidden" id="busino" value="<%=info.getBusino()%>">
	<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">
	<div id="div2">
		<h3 class="yellow">审批工作流</h3>
    	<div class="tableBox">
	    	<table width="100%">
	    	
	    			<!-- 公共部分 -->
	    		    <tr>
					   <th>工作流号:</th>
					   <td id="workid"><%=request.getAttribute("processinstid")%></td>
					</tr>
					<tr>
					   <th>工作流:</th>
					   <td>场地搬迁资源协调</td>
					</tr>
				   <tr>
					  <th>申请人：</th>
					  <td><%=info.getApplyPersonName()%></td>
				   </tr>
				   <tr>
					  <th>申请人工号：</th>
					  <td><%=info.getApplyPersonId()%></td>
				   </tr>	
				   <tr>
					  <th>申请人部门：</th>
					  <td><%=info.getApplyPersonDept()%></td>
				   </tr>
				   <tr>
					  <th>所属事业部：</th>
					  <td><%=info.getBelongDivision()%></td>
				   </tr>
				   <tr>
					  <th>资源协调类型：</th>
					  <td><%=info.getCoordinationType() == null ? "" : info.getCoordinationType() %></td>
				   </tr>
				   
				    <%if("线路、时效细化".equals(info.getCoordinationType())){%>	
					  <tr>
					  	<th>是否枢纽：</th>
					 	 <td><%=info.getIsHub()%></td>
				   	  </tr>			   
				    <%} %>
				    <!-- 搬迁日期确定： 场地租赁组负责人节点 manualActivity3  info.getContractProcessinstid() -->
				    <%if(info.getContractProcessinstid() != null && info.getContractProcessinstid() != ""){ %>
				        <tr>
					      <th>场地租赁/转租合同工作流号：</th>
					      <td><%=info.getContractProcessinstid()%></td>
				        </tr>
				    <%} %>
				   <!-- 搬迁日期确定：事业部总裁节点 manualActivity5  info.getRelocationDate() -->
				   <!-- 目的站货区排布：事业部总裁节点 manualActivity11-->
				   <%if(info.getRelocationDate() != null) { %>
				       <tr>
					      <th>搬迁日期：</th>
					      <td><%=info.getRelocationDate() == null ? "" : FormatUtil.formatDate(info.getRelocationDate())%></td>
				       </tr>
				   <%} %>
				   
				   <!-- 搬迁日期确定： 场地租赁组负责人节点 manualActivity3  info.getContractProcessinstid() -->
	    		   <%if("manualActivity3".equals(activitydefid)) { %>
	    		       <tr>
	    		           <th>场地租赁/转租合同工作流号：</th>
	    		           <td>
	    		               <input id="contractProcessinstid" type="text" style="border: 1px solid #aaa;width: 100px" onblur="checkProcessinstid(this.id)"/>
	    		               <font style="display:none;color: red">&nbsp;&nbsp;*场地工作流号为必填项，且工作流应为已同意状态</font>
	    		                <input type="hidden" id="processinstIDFlag"/>
	    		           </td>
	    		       </tr>
	    		   <%} %>
	    		   <!-- 搬迁日期确定：事业部总裁节点 manualActivity5  info.getRelocationDate() -->
				   <!-- 目的站货区排布：事业部总裁节点 manualActivity11-->
				   <%if("manualActivity5".equals(activitydefid) || "manualActivity11".equals(activitydefid)) { %>
	    		       <f:date displayName="搬迁日期" locationMessage="搬迁日期必填" id="relocationDate"/>
	    		   <%} %>
				   <tr>
					  <th>申请事由:</th>
					  <td><%=info.getApplyReason()  %></td>
				   </tr>
				   <tr><td id="titleInfo" style="color: red" align="center" colspan="2">*&nbsp;如需上传附件，请登录PC网页版！ </td></tr>
				<%@include file="approve_process.jsp" %>		   					   
	    	</table>
	    </div>
	</div>
	 <%@include file="workflow_approve_button.jsp" %>
</div>
</body>
<script type="text/javascript">

	$(function(){
		var activitydefid = $("#activitydefid").val();
		if ( "manualActivity3" == activitydefid || "manualActivity5" == activitydefid || "manualActivity11" == activitydefid ) {
			$("#approval_url").val('<%=F_Constants.APPROVAL_COURTRELOCATION_URL%>');
		}
		//搬迁日期确定:场地工程组负责人   车辆采购下单:运力管理组负责人   人员需求确认:人员配置组负责人”和“区域人力资源办公室负责人
		//目的站货区排布: 场地工程组负责人”和“场内布局组负责人"
		//线路、时效细化:“线路规划组负责人”和“时效节点设计组负责人
		if("manualActivity4" == activitydefid || "manualActivity15" == activitydefid || 
				"manualActivity" == activitydefid || "manualActivity1" == activitydefid || 
				"manualActivity10" == activitydefid || "manualActivity12" == activitydefid || 
				"manualActivity8" == activitydefid || "manualActivity9" == activitydefid){
			$("#titleInfo").html("*&nbsp;需上传附件，请登录PC网页版！");
			//同意按钮隐藏，请将同意之后 提示框隐藏
			$("#agree_but").css("background","#ccc");
			$("#agree_but").click(function(){
				$("#app_window").hide();
				$(".tipsWinCnt").hide();
				return;
			});
		}
	});
/**
 * 工作流号校验
 */
	function checkProcessinstid(id){
		
		var val = $("#"+id).val().trim();
		var reg = /^\d+$/;
		
		if(reg.test(val) && val.length > 0 && val.length <= 20 ) {
			
			$("#"+id).css("border-color","#ccc");
			//校验工作流
			$.ajax({
				type: "GET",
				url: "<%=basePathBut%>/checkProcessinstIdAction",
				data: "contractProcessinstid=" + val,
				cache: false,
				async:false,
				success: function(msg){
					//1表示验证成功，0表示验证失败
					if( msg == 1){
						$("#"+id).css("border-color","#ccc");
						$("#processinstIDFlag").val(true);
						return true;
					}else {
						$("#"+id).css("border-color","rgb(255, 0, 0)");
						$("#processinstIDFlag").val(false);
						alert($("#"+id).next().html());
						return false;
					}
				} 
			});	
		}else {
			$("#"+id).css("border-color","rgb(255, 0, 0)");
			$("#processinstIDFlag").val(false);
			alert($("#"+id).next().html());
			return false;
		}
	}
	
	function isValid(){
		var flag = false;
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
			message = "必填项请填写完整！";
		}
		$('#result_msg').html(message);
		$("#confirm_back").show();
		$("#result_window").fadeIn(600);
		$(".tipsWinCnt").show();
	}

</script>

</html>



