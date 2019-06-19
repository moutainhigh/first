<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/ext" prefix="ext" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta content="LOGIN_JSP">
	<link rel="stylesheet" type="text/css" href="${styles}/layout.css"/>
	<ext:module groups="jquerylib"/>
	<ext:module groups="login"/>
	<style type="text/css"></style>
</head>
<body onload='bodyReady()'>
	<div class="layout">
		<div class="login_layout">
			<div class="login">
				<h2 id="dateTime" style="display: none;"></h2>
				<ul style="padding-top: 80px">
					<form id='loginForm' action='../login/index.action' method='post'>
						<input type="hidden" name="doLogin" value="true"/>
						<input id='loginName' name='loginName' class="i_userName" onfocus="javascript:this.className='i_userName_focus'" onblur="javascript:this.className='i_userName'"  />
						<li></li>
						<input id='password' name='password' class="i_password" type='password' onfocus="javascript:this.className='i_password_focus'" onblur="javascript:this.className='i_password'" />
						<li></li>
						<li id='errorLi'><label></label><span class="error" id='error'>${requestScope.message}</span></li>
						<li class="t-r"><a class="a_login" href="javascript:" onclick='loginHandler()'><ext:i18nForJsp key="foss.login.submit"/></a></li>	
					</form>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>