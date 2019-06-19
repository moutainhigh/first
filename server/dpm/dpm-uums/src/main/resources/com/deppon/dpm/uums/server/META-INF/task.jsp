<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的任务</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload1/upload1.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<!--  -->
	添加我的任务<br>
	<form
		action="${pageContext.request.contextPath}/dpm/task_insert.action">
		优先级：<input type="text" name="task.priority"><br>
		标题：<input type="text" name="task.title"><br>
		内容：<input type="text" name="task.content"><br>
		截止日期：<input type="date" name="task.endDate"><br>
		<input type="submit" value="提交任务">
	</form>
</body>
</html>