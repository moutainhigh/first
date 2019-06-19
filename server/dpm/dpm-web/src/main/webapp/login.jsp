<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/dpm/scripts/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var flag = true;
	$(function(){
		$('#loginName').focus();
		$(document).on('keydown',function(e){
			if(e.keyCode == 13 && flag) {
				// 如果按下enter键
				$('input[type="submit"]').click();
			}
		});
		
	});
	
	function checkInput(){
		// 将焦点放到登录按钮上
		$('input[type="submit"]').focus();
		if(!$('#loginName').validatebox('isValid')) {
			$.messager.alert('提示','用户名必须为6位!','warning',function(){
				flag = true;
				$('#loginName').focus();
			});
			flag = false;
			return false;
		}
		if(!$('#password').validatebox('isValid')) {
			$.messager.alert('提示','密码必须为6~30位!','warning',function(){
				flag = true;
				$('#password').focus();
			});
			flag = false;
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript">
	if(window.self != window.top){
		window.top.location = window.location;
	}
</script>
</head>
<body style="height: 100%;width: 100%;overflow: hidden;border: none;visibility: visible;background-color: #DDDDDD;">
	<div id="mainwindow" class="easyui-window" collapsible="false" minimizable="false" maximizable="false" resizable="false"
		style="width: 550px;height: 350px;background: url('${pageContext.request.contextPath }/images/loginbackground.png') ;overflow: hidden"
		title="管理员登录" data-options="iconCls:'icon-login'">
		<div class="header" style="height: 35px">
			<div class="toptitle" style="margin-top: 25px;font-size: 20px;margin-left: 60px;">
				<font color="#696969"><strong>后台管理系统</strong></font>
			</div>
		</div>
		
		<div style="padding: 30px 0;">
			<div id="loginForm">
				<div style="padding-left: 180px">
					<s:form action="manage_login.action" namespace="/dpmManage" autocomplete="off" method="POST" theme="simple" onsubmit="return checkInput();">
						<table cellpadding="0" cellspacing="3">
								<tr style="height: 40px;">
									<td colspan="2">
										<!-- 验证码返回提示 -->
										<font color="red">
											<!-- 错误提示 -->
											<s:actionerror/>
										</font>
									</td>
								</tr>
								<tr>
									<td>账号</td>
									<td>
										<input class="easyui-validatebox" 
											data-options="required:true,validType:'length[6,6]',missingMessage:'请输入用户名',invalidMessage:'用户名必须为6位!'" 
											type="text" id="loginName" name="loginName" maxLength="15" size="15" style="width: 150px"/>
									</td>
								</tr>
								<tr>
									<td>密码</td>
									<td>
										<input class="easyui-validatebox" 
											data-options="required:true,validType:'length[6,30]',missingMessage:'请输入密码',invalidMessage:'密码必须为6~30位!'"
											type="password" id="password" name="password" maxLength="15" size="15" style="width: 150px"/>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<input type="submit" value="登录" class="easyui-linkbutton" style="width: 60px"/>
										<input type="reset" value="取消" class="easyui-linkbutton" style="width: 60px"/>
									</td>
								</tr>
						</table>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>