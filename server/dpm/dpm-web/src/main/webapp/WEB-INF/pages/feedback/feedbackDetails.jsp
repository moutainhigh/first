<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page
	import="com.deppon.dpm.tongxunlu.shared.domain.FeedBackDetailsEntity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>意见反馈列表</title>
<style type="text/css">
.editNav{
	padding-bottom:10px;
}
.current_page{
	color: red;
}
.hide{
	display:none;
}
.pageTag{
	float:right;
	margin:0 auto;
	padding-top:10px;
}
.action{
	margin-left:20px;
}
.editInput{
	width:80px;
	height:20px;
	margin-left:10px;
	margin-right:10px;
	border: 0px solid gray;   
	font-family: 华文楷体;   
	font-size: 16px;
	background-color: #d5eaf0;
	border-collapse: collapse;
	overflow:hidden;
}
th{
	background-color: #91c5d4;
	font-family: 华文楷体;
}
table td{
	height: 32px;
	border: 1px solid gray;   
	font-family: 华文楷体;   
	font-size: 16px;
	background-color: #d5eaf0;
	border-collapse: collapse;
}
td select{
	height:24px;
	margin-left:10px;
	border: 0px solid gray;   
	font-family: 华文楷体;   
	font-size: 16px;
	background-color: #d5eaf0;
	border-collapse: collapse;
}
#tooltipdiv {
	position: absolute;
	border: 1px solid #666;
	background: white;
	padding: 3px 3px 3px 3px;
	color: #666;
	display: none;
}
</style>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/dpm/scripts/common/common.js"></script>
</head>
<body>
<div>
	<form id="searchForm" method="post" enctype="multipart/form-data">
		<table id="searchTableId" border="1px" cellpadding="0" cellspacing="0" style="width: 100%;">
	        <tr>
	            <td>工号:</td>
	            <td><input type="text" name="search.searchCode" value="${search.searchCode }" style="width: 280px;"></input>
	            </td>
	            <td>姓名:</td>
	            <td><input type="text" name="search.searchName" value="${search.searchName }" style="width: 280px;"></input></td>
	            <td>内容:</td>
	            <td><input type="text" name="search.searchContent" value="${search.searchContent }" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>处理状态:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="search.searchStatus" value="0"/> 未答复
	            	<input class="easyui-radio" type="radio" name="search.searchStatus" value="1"/> 已答复
	            </td>
	            <td>提交开始时间:</td>
	            <td><input class="easyui-datebox" value="${search.searchBeginTime }" type="text" name="search.searchBeginTime" style="width: 280px;" editable="false" data-options="formatter:formatDate" />
	            </td>
	            <td>提交结束时间:</td>
	            <td><input class="easyui-datebox" value="${search.searchEndTime }" type="text" name="search.searchEndTime"  style="width: 280px;" editable="false" data-options="formatter:formatDate" />
	            </td>
	        </tr>
	        <tr>
	            <td>设备类型:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="search.searchOsType" value="iOS"/> iOS
	            	<input class="easyui-radio" type="radio" name="search.searchOsType" value="android"/> android
	            </td>
	            <td>问题类型:</td>
	            <td>
	            	<select name="search.searchType" style="width:280px;">  
						<option value="">---请选择---</option>  
						<option value="邮箱">邮箱</option>  
						<option value="审批工作流">审批工作流</option>  
						<option value="移动CRM">移动CRM</option>  
						<option value="移动BI">移动BI</option>  
						<option value="我的工资条">我的工资条</option>
						<option value="德邦E站">德邦E站</option>
						<option value="班车">班车</option>  
						<option value="日程">日程</option>  
						<option value="其他">其他</option>  
					</select>
	            </td>
	            <td>是否解决:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="search.searchIsSolve" value="1"/> 否
	            	<input class="easyui-radio" type="radio" name="search.searchIsSolve" value="0"/> 是
	            </td>
	        </tr>
	    </table>
	<div style="padding:5px;text-align: center;">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="searchOnclick()">查询</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearEditForm()">重置</a>
	</div>
	
	<input type="hidden" name="currentPage" value="${currentPage}"/>
		<div class="editNav">
			<input id="edit" type="button" value="编辑"/>
			<input id="save" type="button" onclick="saveFeedback()" value="保存" class="hide"/>
			<a onclick="exportExcelFeedback()"><input id="export" type="button" value="导出"/></a>
		</div>
		<table border="1px" cellpadding="0" cellspacing="0">
			<tr>
				<th width="5%">工号</th>
				<th width="5%">姓名</th>
				<th width="20%">内容</th>
				<th width="10%">提交时间</th>
				<th width="10%">图片</th>
				<th width="5%">处理状态</th>
				<th width="7%">处理意见</th>
				<th width="5%">是否解决</th>
				<th width="7%">处理人</th>
				<th width="7%">迭代安排</th>
				<th width="5%">设备</th>
				<th width="7%">问题类型</th>
				<th width="7%">用户回复</th>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr >
					<td class="hide"><input name="id" readonly="readonly" type="text" value="${list.feedBackId}"/></td>
					<td width="5%">${list.empCode}</td>
					<td width="5%">${list.empName}</td>
					<td width="20%">${list.content}</td>
					<td width="10%"><fmt:formatDate value="${list.submitTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td width="10%">
						<c:forEach items="${list.fileName}" var="li">
							<a href="${li}" target="_blank">
								<img id="pic" src="${li}" width="30px" height="30px">
							</a>
						</c:forEach>
					</td>
					<td width="5%">
						<select name="status" disabled="disabled" class="selectMode">
							<option value="0" <c:if test="${list.executeStatus==0}">selected</c:if>>未答复</option>
							<option value="1" <c:if test="${list.executeStatus==1 || list.executeStatus==2 || list.executeStatus==3 || list.executeStatus==4}">selected</c:if>>已答复</option>
						</select>
					</td>
					<td width="7%"><input name="editInput3" readonly="readonly" type="text" value="${list.PS}" class="editInput"/></td>
					<td width="5%">
						<select name="isSolve" disabled="disabled" >
							<option value="" ></option>
							<option value="1" <c:if test="${list.isSolve == 1 || list.isSolve == '' || list.isSolve == null}">selected</c:if>>否</option>
							<option value="0" <c:if test="${list.isSolve == 0 && list.isSolve != '' && list.isSolve != null}">selected</c:if>>是</option>
						</select>
					</td>
					<td width="7%"><input width="20px" name="editInput1" readonly="readonly" type="text" value="${list.executePerson}" class="editInput"/></td>
					<td width="7%"><input name="editInput2" readonly="readonly" type="text" value="${list.plan}" class="editInput"/></td>
					<td width="5%">${list.osType}</td>
					<td width="7%">${list.type}</td>
					<td width="7%"><a href="../dpmManage/push.action?userId=${list.empCode}&empName=${list.empName}" class="action" target="blank"><input type="button" value="ACTION"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<form action="getFeedbackDetails.action" method="post">
		 <div class="pageTag">
		 <span>共${count}条记录
		 &nbsp;&nbsp;
		 第${currentPage}页/${totalpage}页
		 &nbsp;&nbsp;
		 <a onclick="feedbackPage(1)" href="#"><input type="button" value="首页"/></a>
           <c:choose>
           		<c:when test="${currentPage == 1}">
           			<a href="#">上一页</a>
           		</c:when>
           		<c:otherwise>
           			<a onclick="feedbackPage('${currentPage - 1}')" href="#">上一页</a>
           		</c:otherwise>
           	</c:choose>
   	        <%-- <c:forEach begin="1" end="${totalpage}" var="p">
   	        	<c:choose>
   	        		<c:when test="${p == currentPage}">
   	        			<a href="getFeedbackDetails.action?currentPage=${p}" class="current_page">${p}</a>
   	        		</c:when>
   	        		<c:otherwise>
   	        			<a href="getFeedbackDetails.action?currentPage=${p}">${p}</a>
   	        		</c:otherwise>
   	        	</c:choose>
            </c:forEach> --%>
            <c:choose>
           		<c:when test="${totalpage == currentPage}">
           			<a href="#">下一页</a>
           		</c:when>
           		<c:otherwise>
           			<a onclick="feedbackPage('${currentPage + 1}')" href="#" >下一页</a>
           		</c:otherwise>
            </c:choose>
            &nbsp;&nbsp; 
            <span><a onclick="feedbackSelectPage()" href="#">跳转</a>到<input type="text" name="selectPage" value="${currentPage }" style="width:30px"/>页</span>
            <a onclick="feedbackPage('${totalpage}')" href="#" ><input type="button" value="尾页"/></a>
            &nbsp;&nbsp;
            </span>
         </div>
	</form>
</div>
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var searchType = '${search.searchType}';
	if(searchType != '' && typeof(searchType) != 'undefied'){
	 $("select[name='search.searchType']").attr("value", searchType);
	}
	var searchStatus = '${search.searchStatus}';
	if(searchStatus != '' && typeof(searchStatus) != 'undefied'){
	 $("input[type='radio'][name='search.searchStatus'][value='" + searchStatus + "']").attr("checked", true);
	}
	var searchOsType = '${search.searchOsType}';
	if(searchOsType != '' && typeof(searchOsType) != 'undefied'){
	 $("input[type='radio'][name='search.searchOsType'][value='" + searchOsType + "']").attr("checked", true);
	}
	var searchIsSolve = '${search.searchIsSolve}';
	if(searchIsSolve != '' && typeof(searchIsSolve) != 'undefied'){
	 $("input[type='radio'][name='search.searchIsSolve'][value='" + searchIsSolve + "']").attr("checked", true);
	}
});
function submitFeedbackList(){
	$.ajax({
		cache: true,
        type: "POST",
        url: "/dpm/dpmManage/getFeedbackDetails.action",
        data:$('#searchForm').serialize(),// 你的formid
        async: false,
        success: function(data) {
            $("#searchForm").parent().html(data);
        }
	});
}
function feedbackSelectPage(){
	var selectPage = $("input[type='text'][name='selectPage']").val();
	var totalpage = '${totalpage}';
	if(selectPage != '' && typeof(selectPage) != 'undefied'){
		var type = parseInt(selectPage)>parseInt(totalpage);
		if(type){
			alert("请输入正确页数！！");
			return;
		}
		$("input[type='hidden'][name='currentPage']").val(selectPage);
		submitFeedbackList();
	} else{
		alert("请输入正确页数！！");
	}
}
function searchOnclick(){
	// 查询 分页重置为1
	$("input[type='hidden'][name='currentPage']").val('1');
	submitFeedbackList();
}
function feedbackPage(page){
	$("input[type='hidden'][name='currentPage']").val(page);
	submitFeedbackList();
}
function saveFeedback(){
	$.ajax({
		cache: true,
        type: "POST",
        url: "/dpm/dpmManage/saveEditFeedback.action",
        data:$('#searchForm').serialize(),// 你的formid
        async: false,
        success: function(data) {
            $("#searchForm").parent().html(data);
        }
	});
}
function exportExcelFeedback(){
	var path = "exportExcel.action";  
    $('#searchForm').attr("action", path).submit();
}
function clearEditForm(){
	$("input[type='hidden'][name='search.searchBeginTime']").val('');
	$("input[type='hidden'][name='search.searchEndTime']").val('');
	$(':input','#searchTableId')
	　　.not(':button, :submit, :reset, :hidden')
	　　.removeAttr('checked')
	　　.removeAttr('selected')
	  .val("");
}
function formatDate(val,row){
	var now = new Date(val);
	return now.format("yyyy-MM-dd");
}
	$('input.editInput').live(
			'mouseover',
			function(e) {
				text = $(this).attr("value");
				if(null != text && '' != text){
				tooltip = "<div id='tooltipdiv'><font style='font-size:10px'> "
						+ text + "</font></div>";
				$("body").append(tooltip);
				$("#tooltipdiv").show();
				$("#tooltipdiv").css({
					"top" : (e.pageY + 10) + "px",
					"left" : (e.pageX + 10) + "px"
				}).show("fast");
				}
			});

	$('input.editInput').live('mouseout', function(e) {
		$("#tooltipdiv").remove();
	});

	$('input.editInput').live('mousemove', function(e) {
		$("#tooltipdiv").css({
			"top" : (e.pageY + 10) + "px",
			"left" : (e.pageX + 10) + "px"
		}).show();
	});
	
	$(function() {
		$(document).on("click", "#edit", function() {
			$("#save").show();
			$("#edit").addClass("hide");
			$(".editInput").removeAttr("readonly");
			$(".selectMode").removeAttr("disabled");
		});
	});
</script>
</body>
</html>