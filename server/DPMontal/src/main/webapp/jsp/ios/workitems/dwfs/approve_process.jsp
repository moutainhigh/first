<%@page import="java.util.List"%>
<%@page import="com.deppon.wfs.workflow.domain.Fileupload"%>
<%@page errorPage="/errorPage.jsp" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%List<Fileupload> fileList = (List<Fileupload>)request.getAttribute("fileList"); %>
<h4 id="showAppId" class="yellow">查看审批记录</h4>
<div id="ulBox" style="display:none;">
     <div class="ulBox2">
     	<ul>
     		<li id="qytr" class="first">查询中,请稍等...</li>
     	</ul>
     </div>
     <h4 id="hideList" class="yellow">关闭审批记录</h4>
</div>
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
<!-- 以下是附件 -->
<div class="dpFiles">
	<h4 id="showFile" class="yellow">打开附件列表</h4>	
		<div  class='toFile' style="display:none;">
	   	<ul>
	    	<%Fileupload temp = new Fileupload();
	    	if(fileList!=null&&fileList.size()>0){
			for(int i = 0 ; i < fileList.size() ; i++) {
				temp = fileList.get(i);%>
				<li class="<%=i == 0 ? "first" : "line" %>">
				<em>
					<a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&fileId=<%=temp.getFileId()%>"><%=temp.getFileName()%></a>
				</em>
				</li>
			<%}} %>
		</ul>
			 <h4 id='hideFile' class="yellow">关闭附件列表</h4>
		</div>  
</div>
<div class="ulBox2" id="approve_area">
	<ul>
		<li class="first gray"><textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" class="fccc opinion-area" id="textarea-a"  placeholder="请输入审批意见..."></textarea></li>
		<li class="num">剩余<i id="textareaNum">300</i><i >/300</i>字</li>
	</ul>
</div>
<script type="text/javascript">
$(function(){
	//显示附件列表
	$("#showFile").click(function(){
		$(".toFile").show();
	});
	//关闭附件列表
	$("#hideFile").click(function(){
		$(".toFile").hide();
	});
	$("#showAppId").click(function(){
		$("#ulBox").slideDown();
	});
	$("#hideList").click(function(){
		$("#ulBox").slideUp();
	});
	if($("#app_ui").val()=="false"){
		$(".dpFiles").hide();
	}
});	
</script>
