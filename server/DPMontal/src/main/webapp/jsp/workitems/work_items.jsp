<!DOCTYPE html>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.model.OaWorkItem"%>
<%@page import="java.util.List"%>
<%@page import="com.deppon.montal.util.InitDataServlet" %>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<% 
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
	<meta content="telephone=no" name="format-detection" />
	<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
	<link rel="stylesheet" href="<%= basePath %>/css/reset.css" />
	<link rel="stylesheet" href="<%= basePath %>/css/win8/common.css" />
	<link rel="stylesheet" href="<%= basePath %>/css/win8/list.css" />
	<script src="<%=basePath%>/js/jquery-1.8.2.min.js"></script>
	<script src="<%= basePath %>/js/win8_auto_resize.js"></script>
	<%
       Object obj=request.getSession().getAttribute("version");
       if(obj==null || !obj.toString().equals("new")){
    %>
    <style>
        #list #div2{
            top:0px;
        }
    </style>
    <%}%>
</head>
<%
	List<OaWorkItem> workitems = (List<OaWorkItem>)request.getAttribute("workItems");
	String flowTypes = request.getAttribute("flowTypes").toString();
%>
<body>
   
<div id="list">
	<div id="div1">
	   	<a class="return" id="back_showmain">
	   		<img src="" width="100%" />
	   	</a>
		<div class="logo" id="to_showmain">
			<img src="" width="100%" />
		</div>
	</div>
   <div id="div2">
   	<h3 class="yellow" id="title">待办事项</h3>
   	<div class="searchBox">
    	<table>
    		<tr>
    			<td><input class="text" type="text" id="key" placeholder="请输入工作流号..." /></td>
    			<td>
    				<input class="btn" type="button" value="查询" onclick="qclick()"/>
    			</td>
    		</tr>
    	</table>
   	</div>
   	<div class="tableBox">
   		<table width="100%" id="ulist">
   		<%
   			for(OaWorkItem item :workitems){ 
   				String pName = ""; 
   				String pNo = "";
   				if(!(item.getSyscode().equals(F_Constants.DIPOA_WORKFLOW_SYSCODE)
   						||item.getSyscode().equals(F_Constants.DWFS_WORKFLOW_SYSCODE))){//FSSC和DLSP工作流
   					String[] arr = item.getProcessinstname().split(item.getSyscode());
   					pName = arr[0];//名称   
   					pNo = item.getBusino();//流程号
   				}else{//老平台和门户二期
   					pName = item.getProcessinstname();
   					pNo = item.getProcessinstid().toString();
   				}
   		%>
   			
   			<tr id="<%=item.getProcessinstid()+"&type="+item.getFlowtype()+"&activitydefid=" + item.getActivitydefid() 
   			        +"&syscode="+item.getSyscode()+"&busino="+item.getBusino()+"&workitemid="+item.getWorkitemid()+
   			        "&activityinstid="+item.getActivityinstid() %>"  style="height: 50px;" title="<%=pNo%>">
   				<th style="width:65%">
					<%=pName %><br/>
					<em><%=item.getDepartment()%></em>
				</th>
				 <td class="fyy-textRt">
            		<%=pNo%><br/>
            		<%=item.getAppler()%>
           		</td>
   			</tr>
   			<%} %>
   		</table>
   	</div>
  		<%
  		if(workitems.size() == 0){
 	%>
  	<div style="text-align: center;">
  	<img src="images/ios/db_null.png" style="width:100px;height:115px;margin-top:80px;">
  	</div>
  	<div style="text-align: center;margin-top:40px;">
  	<font color="#403b65" style="font-size:16px;">您当前没有可以审批的工作流！</font>
  	</div>
    <%
  	    }
    %>
    <div id="query_info" style="display: none;"><font color="#403b65">记录为空！</font></div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	$('#ulist tr').click(function(){
		var workId = $(this).attr("id");
		//var workId = "35422"+"&type=com.deppon.bpms.module.fssc.bpsdesign.salaryWelfareBill.WelfareFeeApply"+"&syscode=FSSC&busino=FSSC106131112000003&workitemid=67834";
		window.location.assign("<%= basePath %>/toApprove?workId="+ workId);
	});
	$("#div2").find("tr").live('touchstart',function(){
		$(this).addClass("on");
	});
	$("#div2").find("tr").live('touchend',function(){
		$(this).removeClass("on");
	});
	$("#div2").find("tr").live('touchmove',function(){
		$(this).removeClass("on");
	});
	$("#back_showmain").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
	$("#to_showmain").click(function(){
		location.href ="<%=basePath%>/showmain";
	});
});

function qclick(){
	var key = $("#key").val();
	var  arr = $("#ulist").find("tr");
	var count = 0;
	if(arr.length == 0){
		return;
	}
	for(var i=0; i<arr.length; i++){
		if(arr[i].title.indexOf(key) == -1){
			$(arr[i]).hide();
		}else{
			$(arr[i]).show();
			count++;
		}
	}
	if(count == 0){
		$("#query_info").show();
	}else{
		$("#query_info").hide();
	}
}

//图片缓加载
window.onload = function(){
	$(".return").find("img").attr("src","<%=basePath%>/imgnews/win8/list_return_btn.png");
	$(".logo").find("img").attr("src","<%=basePath%>/imgnews/win8/list_logo.png");
}
</script>
<%@include file="/titleControl.jsp" %>
</body>
</html>