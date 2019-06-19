<%@page import="com.deppon.montal.model.OASealCarveApply"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<meta http-equiv = "Content-Type" content = "application/xhtml+xml; charset=UTF-8" />
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
	 li{word-wrap: break-word;}
	</style>
</head>
<body>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
    <!--div2 S-->
    <div id="div2">
    	<div class="ulBox2">
    		<ul>
				 <%
				 OASealCarveApply info = (OASealCarveApply)request.getAttribute("oasealcarveapply");
				 %>
				   <li class="first">工作流号：<em><%=info.getProcessinstid() %></em>
				  	 <input type="hidden" id="workid" value="<%=info.getProcessinstid()%>">
				  	 <input type="hidden" id="type_id" value="contractSignApply">
				   </li>
				   <li>工作流:<em>刻章申请</em></li>
				<li>申请人:<em><%=info.getName()%></em></li>
				<li>工号:<em><%=info.getUserid()%></em></li>
				<li>部门:<em><%=info.getDeptname()%></em></li>
				<li>所属事业部:<em><%=info.getArea()%></em></li>
				<li>所属子公司:<em><%=info.getSubcom()%></em></li>
				<li>印章类型:<em><%=info.getSealtype()%></em></li>
				<li>申请事由<em><%=info.getReason()==null?"":info.getReason()%></em></li>
				<li><em class="yellow">详细信息</em></li>
				<%if(info.getSublist()!= null){
					for(int i=0;i<=info.getSublist().size()-1 ;i++){
						OASealCarveApply temp = (OASealCarveApply)info.getSublist().get(i);%>
					<li class="line">印章名称:<em><%=temp.getSealname()%></em></li>
					<li>是否首次刻制:<em><%=temp.getIsfirstcarve()%></em></li>
					<li>发放单位:<em><%=temp.getProvidecom()%></em></li>
					<li>是否在公安局备案<em><%=temp.getIsrecordinps()%></em></li>
				<%	}
				} %>
			</ul>
		</div>
			<%@include file="approve_process.jsp" %>
		 <%
			  if("逐级审批至高级经理".equals(info.getCurrentnode())){
			 %>
			<ul>
			 	 <li class="first">
				 	请选择你的职位级别:
				 	<em>
					 	<input id="level" type="radio" name="level" value="1" onclick="checkLevel()"><label>经理</label>
					 	<input id="level" type="radio" name="level" value="2" checked="checked" onclick="checkLevel()"><label>高级（区域）经理</label>
				 	</em>
				 </li>
			 	<li id="sealneed" class="first">
				 	是否需要总监(大区总)审批:
				 	<em>
					 	<input type="radio" name="need" value="0" checked="checked"><label>是</label>
					 	<input type="radio" name="need" value="1" ><label>否</label>
				 	</em>
				 </li>				 
			 </ul>
		 	<% } %>
		</div>
	<%@include file="workflow_approve_button.jsp" %>
<script type="text/javascript">
	function checkLevel(){
		var level = $('input[name="level"]:checked').val();
		if(level=="1"){
			document.getElementById("sealneed").style.display = "none";
			var needobject = document.getElementsByName("need");
			needobject[1].checked = true;
		}else{
			document.getElementById("sealneed").style.display = "table-row";
			var needobject = document.getElementsByName("need");
			needobject[0].checked = true;
		}
	}

</script>
</body>
</html>