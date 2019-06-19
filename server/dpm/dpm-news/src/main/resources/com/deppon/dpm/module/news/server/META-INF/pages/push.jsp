<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/ext" prefix="ext"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="ionicApp">
<head lang="en">
<meta charset="UTF-8">
<title>消息推送</title>
<link href="${styles}/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="${scripts}/ionic.bundle.js"></script>
<script src="${scripts}/jquery-2.0.0.js"></script>
<script src="${scripts}/bootstrap.min.js"></script>
<script src="${scripts}/config.js"></script>
<script>
	var url = location.search;
	var userId = '';
	if (url.indexOf('?') >= 0) {
		userId = url.substring(url.indexOf('?'));
	}

	angular
			.module('ionicApp', [ 'ionic' ])
			.controller(
					'MyCtrl',
					function($scope, $http, $timeout, $ionicPopup,
							$ionicSlideBoxDelegate) {
						var lctype = 0;
						var isdefault = 'Yes';
						$("#showTask").hide();
						$("#showRadio").hide();

						$("#pushTwo").attr("disabled", "disabled");
						$scope.myitmes = [];
						var Request = new Object();
						Request = GetRequestBack();
						var goback = Request["back"];
						var userId = Request["userId"];
						var userName = decodeURI(Request["empName"]);
						var backData = '';
						if (goback == 1) {
							backData = localStorage.getItem("transData");
							var splitArr = new Array();
							var splitTwoArr = new Array();
							var nameArr = new Array();
							var numberArr = new Array();
							var name = '';
							var transNum = '';
							// alert('backData'+backData +'}}'+backData.length);
							splitArr = backData.split(',')
							for ( var i = 0; i < splitArr.length; i++) {
								var str = splitArr[i];
								// alert('str'+str);
								splitTwoArr = str.split('?');
								for ( var j = 0; j < 2; j++) {
									if (j % 2 == 0) {
										numberArr.push(splitTwoArr[0]);
									} else {
										nameArr.push(splitTwoArr[1]);
									}
								}
							}
							$("#pushTwo").val(nameArr);
						} else if (userId) {
							//广播推送
							var myTemp = userName;
							backData = myTemp;
							$("#pushTwo").val(myTemp);
						} else {
							//广播推送
							if (confirm('收件人含高层领导，请仔细确认，谨慎发送')) {
								var myTemp = '推送给公司所有的人';
								backData = myTemp;
								$("#pushTwo").val(myTemp);
							} else {
								var compont = '';
							}

						}
						//实时获取 选取框的值
						$('#pushselect').change(
								function() {
									var selectedType = $("#pushselect").find(
											"option:selected").text();
									if (selectedType == '固定资产'
											|| selectedType == 'IT服务台' || selectedType == '收发室') {
										//新增的两个东西添加
										isdefault = 'NO';
										$("#showTask").show();
										$("#showRadio").show();

									} else {
										isdefault = 'Yes';
										$("#showTask").hide();
										$("#showRadio").hide();
									}
								})

						$(function() {
							$(document)
									.on(
											"input propertychange",
											"#pushThree",
											function() {
												var linkStr = $('#link').val();
												var contentStr = $('#pushThree')
														.val();
												var allLength = contentStr.length
														+ linkStr.length;
												$("#lclimit").text(
														allLength + "/1500");
												if (allLength > 1500) {
													//截取
													var mysp = $('#pushThree')
															.val()
															.substr(
																	0,
																	1500 - linkStr.length);
													$("#pushThree").val(mysp);
												}
											})
						})
						$("#senlc").click(function() {
							window.location.href = ("/dpm/detail.action");
						})
						$("#confirm")
								.click(
										function() {
											//判断内容是否为空
											var s1 = $("#pushselect").find(
													"option:selected").text();
											var s2 = $("input[name='pushOne']")
													.val();
											var s3 = numberArr;
											var s4 = $('#pushThree').val();
											var s5 = $("input[name='linkStr']")
													.val();
											var s6 = 0;//任务ID
											var s7 = 0;//是否显示小红点
											var s8 = 1;//是否是消息中心
											if (s2.length < 2) {
												alert('╭(╯3╰)╮标题太短');
											} else if (s4.length < 2) {
												alert(':）内容不能为空');
											} else if (backData.length < 2) {
												alert('╭(╯3╰)╮收信人不能为空');
											} else {
												if (isdefault == 'NO') {
													s6 = $('#taskId').val();
													var yy = $("#isShowRadio")
															.find(
																	"option:selected")
															.text();
													if (yy == '是') {
														s7 = 0;
													} else {
														s7 = 1;
													}
												}
												if (s1 == '工资条') {
													s8 = 0;
													lctype = 0;
												}else if (s1 == 'HR自助') {
													lctype = 1;
												} else if (s1 == '系统通知') {
													s8 = 0;
													lctype = 2;
												}else if (s1 == '固定资产') {
													lctype = 3;
												} else if (s1 == 'IT服务台') {
													lctype = 4;
												} else if (s1 == '我的任务') {
													lctype = 5;
												} else if(s1 == '工作流'){
													s8 = 0;
													lctype = 6;
												}else if(s1 == '差旅助手'){
													lctype = 7;
												}else if(s1 == '工程管理'){
													lctype = 8;
												}else if(s1 == '收发室'){
													lctype = 9;
												}else if(s1 == '德邦e站'){
													lctype = 10;
												}else if(s1 == '发现'){
													lctype = 11;
												}else if(s1 == '移动CRM'){
													lctype = 12;
												}else if(s1 == '移动BI'){
													lctype = 13;
												}else if(s1 == '收派助手'){
													lctype = 14;
												}else if(s1 == '项目管理'){
													lctype = 15;
												}else if(s1 == '后勤服务'){
													lctype = 16;
												}else if(s1 == '人事服务'){
													lctype = 17;
												}else if(s1 == '微课堂'){
													lctype = 18;
												}else if(s1 == '场地预定'){
													lctype = 19;
												}
												if (goback == 1) {
													//普通推送
													var strData = 'userId=xxx'
															+ '&pushUserId='
															+ s3 + '&content='
															+ s4 + '&title='
															+ s2 + '&type='
															+ lctype + '&link='
															+ s5 + '&taskId='
															+ s6
															+ '&isTextNews='
															+ s8 + '&isActive='
															+ s7;

													var confirmUrl = '/dpm/dpm/tpush_pushMessage.action?';
													$
															.ajax({
																type : 'Post',
																url : confirmUrl,
																data : strData,
																dataType : 'json',
																timeout : 30000,
																context : $('body'),
																success : function(
																		data) {
																	if(data.response_status==200){
																		alert('推送成功');
																	}else{
																		alert('推送失败');
																	}
																},
																error : function(
																		xhr,
																		type) {
																	alert('推送失败');
																}
															})
												} else if (userId) {
													//意见反馈推送
													var strData = 'userId=xxx'
															+ '&pushUserId='
															+ userId
															+ '&content=' + s4
															+ '&title=' + s2
															+ '&type=' + lctype
															+ '&link=' + s5
															+ '&taskId=' + s6
															+ '&isTextNews='
															+ s8 + '&isActive='
															+ s7;
													var confirmUrl = '/dpm/dpm/tpush_pushMessage.action?';
													$
															.ajax({
																type : 'Post',
																url : confirmUrl,
																data : strData,
																dataType : 'json',
																timeout : 30000,
																context : $('body'),
																success : function(
																		data) {
																	if(data.response_status==200){
																		alert('推送成功');
																	}else{
																		alert('推送失败');
																	}
																},
																error : function(
																		xhr,
																		type) {
																	alert('推送失败');
																}
															})
												} else {
													//广播推送
													var strData = 'userId=xxx'
															+ '&content=' + s4
															+ '&title=' + s2
															+ '&type=' + lctype
															+ '&link=' + s5
															+ '&taskId=' + s6
															+ '&isTextNews='
															+ s8 + '&isActive='
															+ s7;
													var confirmUrlTwo = '/dpm/dpm/tpush_pushAll.action?';
													$
															.ajax({
																type : 'Post',
																url : confirmUrlTwo,
																data : strData,
																dataType : 'json',
																timeout : 30000,
																context : $('body'),
																success : function(
																		data) {
																	if(data.response_status==200){
																		alert('推送成功');
																	}else{
																		alert('推送失败');
																	}
																},
																error : function(
																		xhr,
																		type) {
																	alert('推送失败');
																}
															})
												}
											}
										})
					})
</script>
<script language="javascript">
	function GetRequestBack() {

		var url = location.search; //获取url中"?"符后的字串
		var theRequest = new Object();
		if (url.indexOf("?") != -1) {
			var str = url.substr(1);
			strs = str.split("&");
			for ( var i = 0; i < strs.length; i++) {
				theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
			}
		}
		return theRequest;
	}
</script>
</head>
<body ng-controller="MyCtrl">
	<div class="container">
		<h1 align="center">消息中心推送平台</h1>
	</div>
	<div class="row">
		<div class="col-lg-4" align="center">
			<button type="button" class="btn btn-default" id="senlc">收信人</button>
		</div>
		<div class="col-lg-6">
			<input type="text" class="form-control" name="pushTwo" id="pushTwo">
		</div>
	</div>
	<h1></h1>
	<div class="row">
		<div class="col-lg-4">
			<p align="center" style="margin-top: 5px">消息来源</p>
		</div>
		<div class="col-lg-6">
			<select class="form-control" id="pushselect">
				
				<option>工资条</option>
				<option>HR自助</option>
				<option selected="selected">系统通知</option>
				<option>固定资产</option>
				<option>IT服务台</option>
				<option>我的任务</option>
				<option>工作流</option>
				<option>差旅助手</option>
				<option>工程管理</option>
				<option>收发室</option>
				<option>德邦e站</option>
				<option>发现</option>
				<option>移动CRM</option>
				<option>移动BI</option>
				<option>收派助手</option>
				<option>项目管理</option>
				<option>后勤服务</option>
				<option>人事服务</option>
				<option>微课堂</option>
				<option>场地预定</option>
			</select>
		</div>
	</div>
	<h1></h1>
	<div class="row">
		<div class="col-lg-4">
			<p align="center" style="margin-top: 5px">标题</p>
		</div>
		<div class="col-lg-6">
			<input type="text" class="form-control" name="pushOne"
				placeholder="必填项:）">
		</div>
	</div>
	</div>
	<h1></h1>
	<div class="row">
		<div class="col-lg-4">
			<p align="center" style="margin-top: 5px">链接</p>
		</div>
		<div class="col-lg-6">
			<input type="text" class="form-control" name="linkStr" id="link"
				placeholder="推送内容中的链接地址!!">
		</div>
	</div>
	<h1></h1>

	<div class="row" id="showTask">
		<div class="col-lg-4">
			<p align="center" style="margin-top: 5px">任务ID</p>
		</div>
		<div class="col-lg-6">
			<input type="text" class="form-control" name="taskStr" id="taskId"
				placeholder="任务ID">
		</div>
	</div>

	<h1></h1>

	<div class="row" id="showRadio">
		<div class="col-lg-4">
			<p align="center" style="margin-top: 5px">是否显示小红点</p>
		</div>
		<div class="col-lg-6">
			<select class="form-control" id="isShowRadio">
				<option>是</option>
				<option>否</option>
			</select>
		</div>
	</div>
	<h1></h1>

	<div class="row">
		<div class="col-lg-4">
			<p align="center" style="margin-top: 5px">内容</p>
		</div>
		<div class="col-lg-6">
			<textarea class="form-control" rows="4" id="pushThree"
				placeholder="╭(╯3╰)╮内容和链接地址少于50字!!"></textarea>
		</div>
		<div class="col-lg-1" style="margin-top: 90px">
			<p id="lclimit">0/50</p>
		</div>
	</div>
	</div>
	<h1></h1>
	<div class="row">
		<div class="col-lg-2 col-md-offset-5">
			<button type="button" class="btn btn-primary" id="confirm">确认</button>
		</div>
		<div class="col-lg-2 ">
			<button type="button" class="btn btn-info">取消</button>
		</div>
	</div>
	</div>
</body>
</html>