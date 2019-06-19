<!DOCTYPE html>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.model.OaWorkItem"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
<%@include file="/common_ios.jsp" %>
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

<%
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
%>
<body>
<%@include file="/jsp/ios/ios_menu.jsp" %>
<div id="list">
	<div id="div1" class="white">
	<div class="tit"><img src="" width="100%" /></div>
	<a class="return" href="<%=basePath%>/showmain"><img src="" width="100%" /></a>
	<div class="home"><img src="" width="100%" /></div>
	</div>
    <div >
    	<div >
					<ul id="ulist" class="m-list add-role">
						<%
							for(int i=0; i<workitems.size(); i++){
								OaWorkItem item = workitems.get(i);
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
							<li value="<%=item.getFlowtype()%>" id="<%=item.getProcessinstid()+"&type="+item.getFlowtype()
							    +"&syscode="+item.getSyscode()+"&busino="+item.getBusino()
							    +"&workitemid="+item.getWorkitemid()+"&activitydefid=" + item.getActivitydefid()
							    +"&activityinstid="+item.getActivityinstid() %>" <%=i==0?"class='first'":"" %>  <%=i==workitems.size()-1?"class='last'":"" %> >
							 	 <p>
							 		<em class="fyy-fl" style="display:block; width:55%;"><%=pName%></em>
							 		<em class="fyy-fr blue" style="display:block; width:40%;"><%=pNo%></em>
								 </p>
								 <p>
			    					<em class="fyy-fl blue" style="font-size:12px; display:block; width:55%;"><%=item.getDepartment() %></em>
			    					<em class="fyy-fr blue" style="display:block; width:40%; white-space:nowrap;"><%=item.getAppler() %></em>
			    				</p>
<!-- 				    	<div class="border-b pb15"> -->
<!-- 								<span class="to_right"></span> -->
<!-- 								<div class="fr tar"> -->
<%-- 									<p><%=pNo%></p> --%>
<%-- 									<p><%=item.getAppler() %></p> --%>
<!-- 								</div> -->
<!-- 								<div class="fl"> -->
<%-- 									<p><%=pName%></p> --%>
<%-- 									<p><%=item.getDepartment() %></p> --%>
<!-- 								</div> -->
							
<!-- 						</div> -->
			    				
			    			</li>
						<%
							}
						%>
						
					</ul>
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
		</div>
	</div>
	<%@include file="/titleControl.jsp" %>
</body>
<script>
$(function(){
	$("#div2").find("li").live('touchstart',function(){
		$(this).addClass("on");
	});
	$("#div2").find("li").live('touchend',function(){
		$(this).removeClass("on");
	});
	$("#div2").find("li").live('touchmove',function(){
		$(this).removeClass("on");
	});
	
	$('#ulist li').click(function(){
		var workId = $(this).attr("id");
		var type = $(this).val();
		window.location.assign("<%= basePath %>/toApprove?workId=" + workId);
	});
});
</script>
</html>