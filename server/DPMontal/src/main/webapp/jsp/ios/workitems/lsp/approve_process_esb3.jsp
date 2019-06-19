<%@page import="com.deppon.montal.util.FormatUtil" %>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain.WorkflowSecondEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.AttachEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ApprovalInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>

<% 
	//审批记录
	List<ApprovalInfo> ApprovalInfoList = (List<ApprovalInfo>)request.getAttribute("approvalInfoList");
	//附件
	List<AttachEntity> attachList = (List<AttachEntity>)request.getAttribute("attachList");
%>
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
	
	<h4 id="showList" class="yellow">打开审批记录</h4>	
	<div id="ulBox" style="display:none;">
	     <div class="ulBox2">
	     	<ul>
	     		<%
					int size = ApprovalInfoList == null ? 0:ApprovalInfoList.size();
					for(int i=0; i< size - 1; i++){
						ApprovalInfo  appInfo = ApprovalInfoList.get(i);
				%>
	     		<li <%=i==0?"class='first'":"class='line'" %> >审批时间:<em><%=appInfo.getApprovedate()%></em></li>
	     		<li>审批处理人:<em><%=appInfo.getApprover()%></em></li>
	     		<li>审批人结果:<em><%=F_Constants.WORKFLOW_RESULT_MAP.get(appInfo.getIsagree())%></em></li>
	     		<li>审批人意见:<em><%=appInfo.getApprovever()==null?"":appInfo.getApprovever()%></em></li>
	     		<%
					}
				%>
	     	</ul>
	     </div>
	     <h4 id="hideList" class="yellow">关闭审批记录</h4>
	</div>
	<div class="dpFiles">
			<!-- 以下是上传附件 -->
		<h4 id="showFile" class="yellow">打开附件列表</h4>	
		<div  id='toFile' style="display:none;">
		<%	
			int length = attachList == null ? 0:attachList.size();
				for(int i = 0 ; i < length  ; i++) {
					%>
				<br><a href = "<%=attachList.get(i).getFileURL()%>" ><%=attachList.get(i).getFileName()%></a><br>&nbsp;
		<%} %>
			 <h4 id='hideFile' class="yellow">关闭附件列表</h4>
		   </div> 
		 </div>
  
	<h4 class="yellow">审批意见</h4>		
	<div class="ulBox2" id="approve_area">
		<ul>
			<li class="first gray"><textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" class="gray" id="textarea-a"  placeholder="请输入审批意见..."></textarea></li>
			<li class="num">剩余<i id="textareaNum">300</i><i >/300</i>字</li>
		</ul>
	</div>	
	<script type="text/javascript">
		$("#showFile").click(function(){
			$("#toFile").slideDown();
		});
		$("#hideFile").click(function(){
			$("#toFile").slideUp();
		});
		$("#showList").click(function(){
			$("#ulBox").slideDown();
		});
		$("#hideList").click(function(){
			$("#ulBox").slideUp();
		});
		$(function(){
			//显示审批记录
			$("#sliderDown").click(function(){
				$("table").find(".sh").show();
			});
			//关闭审批记录
			$("#sliderUp").click(function(){
				$("table").find(".sh").hide();
			});
			if($("#app_ui").val()=="false"){
				$(".dpFiles").hide();
			}
		});
		
		$('#textarea-a').bind('input propertychange', function(event) {
		    $("#textarea-a").parent().css("border-color","#aaa");
		    	var length1 = event.srcElement.value.length;
		    	if(length1 <= length0){
		    		var length2 = length0-length1;
		        	$("#textareaNum").text((length2));
		    	}
		    	if($(this).val().length >300){
					$(this).val(this.value.substring(0,300));		
				}
		});
		
		var length0 = 300;
		
		//审批意见输入监听
		document.getElementById("textarea-a").onkeydown = function(event_e){
			if( window.event ) event_e = window.event;
			var int_keycode = event_e.charCode||event_e.keyCode;
			var length = document.getElementById("textarea-a").value.length;
			var obj = document.getElementById("textarea-a");
			if(length == 0 ){
				if(int_keycode ==32){
					return false;
			 	}
			}
			if (/^\s+/.test(obj.value)) {
				return false;
			} 
			if(int_keycode ==13){
					return false;
			 }
		}
	</script>