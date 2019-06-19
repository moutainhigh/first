<%@page import="com.deppon.wfs.workflow.domain.CourtRelocationBean"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<%@taglib prefix="f" uri="http://jspTag.common.montal.deppon.com" %>
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
	CourtRelocationBean info = (CourtRelocationBean)request.getAttribute("entity");
	String activitydefid = (String)request.getAttribute("activitydefid");
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
					<input type="hidden" id="approval_url" value="<%=F_Constants.NORMOL_APPROVAL_URL%>">		  	   		
			   		</em>
			   </li>
			   <li>工作流:<em> 场地搬迁资源协调</em></li>
				   <li>申请人：<em><%=info.getApplyPersonName()%></em></li>
				   <li>申请人工号：<em><%=info.getApplyPersonId()%></em></li>	
				   <li>申请人部门：<em><%=info.getApplyPersonDept()%></em></li>
				   <li>所属事业部：<em><%=info.getBelongDivision()%></em></li>
				   <li>资源协调类型：<em><%=info.getCoordinationType() == null ? "" : info.getCoordinationType() %></em></li>
				   
				   <%if("线路、时效细化".equals(info.getCoordinationType())){%>	
				   	  <li>是否枢纽：<em><%=info.getIsHub()%></em></li>		   
				    <%} %>
				   <!-- 搬迁日期确定： 场地租赁组负责人节点 manualActivity3  info.getContractProcessinstid() -->
				    <%if(info.getContractProcessinstid() != null){ %>
				        <li>场地租赁/转租合同工作流号：<em><%=info.getContractProcessinstid()%></em></li>	
				    <%} %>
				    <!-- 搬迁日期确定：事业部总裁节点 manualActivity5  info.getRelocationDate() -->
				    <!-- 目的站货区排布：事业部总裁节点 manualActivity11-->
				    <%if(info.getRelocationDate() != null) { %>
				       <li>搬迁日期：<em><%=info.getRelocationDate() == null ? "" : FormatUtil.formatDate(info.getRelocationDate())%></em></li>	
				   <%} %>
				   <!-- 搬迁日期确定： 场地租赁组负责人节点 manualActivity3  info.getContractProcessinstid() -->
	    		   <%if("manualActivity3".equals(activitydefid)) { %>
	    		       <li>场地租赁/转租合同工作流号：<em>
							<input id="contractProcessinstid" type="text" style="border: 1px solid #ccc;width: 100px" onblur="checkProcessinstid(this.id)"/>
	    		            <font style="display:none;color: red">&nbsp;&nbsp;*场地工作流号为必填项，且工作流应为已同意状态</font></em>
	    		            <input type="hidden" id="processinstIDFlag"/>
    		            </li>
	    		   <%} %> 
				   <!-- 搬迁日期确定：事业部总裁节点 manualActivity5  info.getRelocationDate() -->
				   <!-- 目的站货区排布：事业部总裁节点 manualActivity11-->
				   <%if("manualActivity5".equals(activitydefid) || "manualActivity11".equals(activitydefid)) { %>
	    		       <f:date displayName="搬迁日期" jspType="ios" allowNull="false" locationMessage="搬迁日期必填" id="relocationDate"/>
	    		   <%} %> 
				    
				   <li>申请事由：<em><%=info.getApplyReason()%></em></li>
				   <li class="fyy-textCt"><em style="color: red" id="titleInfo">*&nbsp;如需上传附件，请登录PC网页版！</em></li>
			</ul>
		</div>
		<%@include file="approve_process.jsp" %>
	</div>
	<%@include file="workflow_approve_button.jsp" %>
</div>
<f:init/>
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
			$("#titleInfo").html("*&nbsp;需上传附件，如需“同意”操作，请登录PC网页版");
			//同意按钮隐藏，请将同意之后 提示框隐藏
			$("#agree_but").css("background","#ccc");
			$("#agree_but").click(function(){
				$("#app_window").hide();
				$(".tipsWinCnt").hide();
				return;
			});
		}
	});

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
						alert($("#"+id).next().html());
						$("#processinstIDFlag").val(false);
						return false;
					}
				} 
			});	
		}else {
			$("#"+id).css("border-color","rgb(255, 0, 0)");
			alert($("#"+id).next().html());
			$("#processinstIDFlag").val(false);
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