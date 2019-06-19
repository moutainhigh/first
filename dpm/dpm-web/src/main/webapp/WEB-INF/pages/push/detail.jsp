<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/ext" prefix="ext"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="ionicdetail">
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" href="/dpm/styles/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="/dpm/scripts/js/ionic.bundle.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/config.js"></script>
<script type="text/javascript">
	$(function() {
		//全选
		$(document).on("input propertychange", "#nomber", function() {
			var nomber = $("input[name='nomber']").val();
			if (nomber.length > 5) {
				$("#myname").attr("disabled", "disabled");
				$("#depart").attr("disabled", "disabled");
				$("#work").attr("disabled", "disabled");
				$("#degree").attr("disabled", "disabled");
				//清空
				$("#depart").val('');
				$("#myname").val('');
				$("#work").val('');
				$("#degree").val('');

			} else {
				$("#myname").removeAttr("disabled");
				$("#depart").removeAttr("disabled");
				$("#work").removeAttr("disabled");
				$("#degree").removeAttr("disabled");
			}
		});
	})
</script>
<script>
	angular
			.module('ionicdetail', [ 'ionic' ])
			.controller(
					'MyDetail',
					function($scope, $http) {
						//获得选取框的值
						 var isBan = 0;
						$("#link").hide();
						//清空
						$("#depart").val('');
						$("#myname").val('');
						$("#work").val('');
						$("#degree").val('');
						$("#nomber").val('');

						var allPage = 1;
						var allPage2 = 1;
						var index = 1;
						var index2 = 1;
						var flagIndex = 0;
						var flageIndex2 = 0;
						var flagSave = 1;
						var flagSave2 = 1;
						$scope.items = [];
						$scope.allitems = [];
						$scope.splitArray = [];
						$scope.checkedFlagArr = [];
						$scope.allcheckedArr = [];
						$scope.allSaveArr = [];
						$scope.saveArr = [];
						var myArray = [];
						var isnext = 0;
						//全选
						var checkflag = "false";
						$("#selectedAll").click(function() {
							var field = document.getElementsByName("mybox");
							if (checkflag == "false") {
								for ( var i = 0; i < field.length; i++) {
									field[i].checked = true;
								}
								checkflag = "true";
							} else {
								for ( var i = 0; i < field.length; i++) {
									field[i].checked = false;
								}
								checkflag = "false";
							}
						})
						//数组去重
						function getArray(a) {
							var hash = {}, len = a.length, result = [];

							for ( var i = 0; i < len; i++) {
								if (!hash[a[i]]) {
									hash[a[i]] = true;
									result.push(a[i]);
								}
							}
							return result;
						}
						//第一次查询
						var allUrl = '/dpm/dpm/tongxunlu_getAllUser.action?userId=xxx';
						var config = {
							url : allUrl,
							method : "get"
						};
						$http(config).success(function(data) {
							/*  if(null!=data){
							     $scope.allitems = data;
							     $scope.splitArray = data;
							     //分页是否显示
							     if($scope.allitems.length<50){
							         $("#link").hide();
							         $scope.items = $scope.allitems
							     }else{
							         $("#link").show();
							         //分页
							         allPage = Math.ceil( $scope.allitems.length/10);
							         $("#link a")[5].innerHTML='共'+allPage+'页';
							         $scope.items = $scope.allitems.slice(0,10);
							     }
							 } */
						}).error(function(data, status, header, config) {
							alert("请求失败");
						});

						$("#search")
								.click(
										function() {

											//第一个框的值
											//存取的值
											var myname = $(
													"input[name='myname']")
													.val();
											var nomber = $(
													"input[name='nomber']")
													.val();
											var depart = $(
													"input[name='depart']")
													.val();
											var work = $("input[name='work']")
													.val();
											var degree = $(
													"input[name='degree']")
													.val();
											//                        alert('inputOne'+$("input[name='myname']").val());
											//                        //第二个框的值
											//                        alert('inputTwo'+$("input[name='nomber']").val());
											//                        //第三个框的值
											//                        alert('inputOne'+$("input[name='depart']").val());
											//                        //第四个框的值
											//                        alert('inputTwo'+$("input[name='work']").val());
											//                        //第五个框的值
											//                        alert('inputTwo'+$("input[name='degree']").val());
											//工号选择后 其他选择框不可用

											var data = {
												"empname" : myname,
												"empcode" : nomber,
												"orgname" : depart,
												"jobname" : work,
												"joblevel" : degree
											};
											//$scope.saveDeletes = new Array();
											// $scope["myname",myname];
											//                        $scope.saveDeletes.push(myname);
											//                        $scope.saveDeletes.push(nomber);
											//                        $scope.saveDeletes.push(depart);
											//                        $scope.saveDeletes.push(work);
											//                        $scope.saveDeletes.push(degree);
											// alert('ddd--'+$scope.saveDeletes);
											var transArr = JSON.stringify(data);
											// alert('transArr'+transArr);
											var searhUrl = '/dpm/dpm/tongxunlu_pushUser.action?json='
													+ transArr;
											var config = {
												url : searhUrl,
												method : "get"
											};
											$http(config)
													.success(
															function(data) {
																if (null != data) {
																	$scope.allitems = data;
																	$scope.splitArray = data;
																	//分页是否显示
																	if ($scope.allitems.length < 50) {
																		$(
																				"#link")
																				.hide();
																		$scope.items = $scope.allitems
																	} else {
																		$(
																				"#link")
																				.show();
																		//分页

																		allPage = Math
																				.ceil($scope.allitems.length / 10);
																		$("#link a")[5].innerHTML = '共'
																				+ allPage
																				+ '页';
																		$scope.items = $scope.allitems
																				.slice(
																						0,
																						10);
																	}

																}
															}).error(
															function(data,
																	status,
																	header,
																	config) {
																alert("请求失败");
															});
										})
						//分页
						$("#link ul li")
								.each(
										function() {
											$(this)
													.click(
															function() {
																index = $(this)
																		.text();
																index = $
																		.trim(index)
																		+ "";
																var yy = "尾页";
																yy = $.trim(yy)
																		+ "";
																//previous
																if (index == '<') {
																	if (flagSave > 1) {
																		flagSave = parseInt(flagSave) - 1;
																		$("#link a")[3].innerHTML = flagSave;
																		//判断是否是选过的标记
																		//                                    var obj = document.getElementsByName("mybox");
																		//                                    for(var i=0;i<obj.length;i++){
																		//                                        var checkValue =  obj[i].value;
																		//                                        alert('chekvealue'+checkValue);
																		//                                    }
																	} else {
																		flagSave = 1;
																	}
																} else if (index == '>') {
																	//next
																	//存储选取框的值
																	if (flagSave >= allPage) {

																	} else {
																		flagSave = parseInt(flagSave) + 1;
																		$("#link a")[3].innerHTML = flagSave;
																	}
																} else if (index == '首页') {
																	flagSave = 1;
																	$("#link a")[3].innerHTML = flagSave;
																} else if (index == yy) {
																	flagSave = allPage;
																	$("#link a")[3].innerHTML = flagSave;
																} else if (index == '添加') {
																	// $scope.saveArr.splice(0,$scope.saveArr.length);

																} else {
																	flagSave = flagIndex + 1;
																}
																$scope.items = $scope.splitArray
																		.slice(
																				(flagSave - 1) * 10,
																				flagSave * 10);

															});
										});
						//对已选择的人分页
						$("#link2 ul li")
								.each(
										function() {
											$(this)
													.click(
															function() {
																index2 = $(this)
																		.text();
																index2 = $
																		.trim(index2)
																		+ "";
																var yy = "尾页";
																yy = $.trim(yy)
																		+ "";
																//previous
																if (index2 == '<') {
																	if (flagSave2 > 1) {
																		flagSave2 = parseInt(flagSave2) - 1;
																		$("#link2 a")[3].innerHTML = flagSave2;
																	} else {
																		flagSave2 = 1;
																	}
																} else if (index2 == '>') {
																	//next
																	//存储选取框的值
																	if (flagSave2 >= allPage2) {

																	} else {
																		flagSave2 = parseInt(flagSave2) + 1;
																		$("#link2 a")[3].innerHTML = flagSave2;
																	}
																} else if (index2 == '首页') {
																	flagSave2 = 1;
																	$("#link2 a")[3].innerHTML = flagSave2;
																} else if (index2 == yy) {
																	flagSave2 = allPage2;
																	$("#link2 a")[3].innerHTML = flagSave2;
																} else {
																	flagSave2 = flageIndex2 + 1;
																}
																$scope.allcheckedArr = $scope.allSaveArr
																		.slice(
																				(flagSave2 - 1) * 10,
																				flagSave2 * 10);

															});
										});
						//对已选择的人分页

						//清除按钮
						$("#clear").click(function() {
							$("#depart").val('');
							$("#myname").val('');
							$("#work").val('');
							$("#degree").val('');
							$("#nomber").val('');
						})
						//获取选取框的值
						var id_array = new Array();
						$("#choose")
								.click(
										function() {
											//1
											//1 2
											//1 2 3
											// $scope.saveArr.splice(0,$scope.saveArr.length);
											$('input[name="mybox"]:checked')
													.each(
															function() {
																for ( var i = 0; i < $scope.splitArray.length; i++) {

																	if ($scope.splitArray[i].empcode == $(
																			this)
																			.attr(
																					"id")) {
																		//指定位置
																		$scope.saveArr
																				.push($scope.splitArray[i]);
																		 if($scope.splitArray[i].joblevel== 10 ||$scope.splitArray[i].joblevel== 'D' ||$scope.splitArray[i].joblevel== 'C'){
									                                            isBan =1;
									                                        }
																		$scope.splitArray
																				.splice(
																						i,
																						1);
																		$scope.items = $scope.splitArray
																				.slice(
																						(flagSave - 1) * 10,
																						flagSave * 10);
																	}

																}
															})
											$scope.allSaveArr = $scope.saveArr;

											if ($scope.allSaveArr.length >= 10) {
												allPage2 = Math
														.ceil($scope.allSaveArr.length / 10);
												$("#link2 a")[5].innerHTML = '共'
														+ allPage2 + '页';
												$scope.allcheckedArr = $scope.allSaveArr
														.slice(0, 10);
											} else {
												$scope.allcheckedArr = $scope.allSaveArr;
											}

											isnext = 1;
											// $scope.allcheckedArr =  $scope.splitArray.slice(0,3);
											//第一个框的值
											//存取的值
											var myname = $(
													"input[name='myname']")
													.val();
											var nomber = $(
													"input[name='nomber']")
													.val();
											var depart = $(
													"input[name='depart']")
													.val();
											var work = $("input[name='work']")
													.val();
											var degree = $(
													"input[name='degree']")
													.val();
											var data = {
												"empname" : myname,
												"empcode" : nomber,
												"orgname" : depart,
												"jobname" : work,
												"joblevel" : degree
											};
											var transArr = JSON.stringify(data);
											var searhUrl = '/dpm/dpm/tongxunlu_pushUser.action?json='
													+ transArr;
											var config = {
												url : searhUrl,
												method : "get"
											};
											$http(config)
													.success(
															function(data) {
																if (null != data) {
																	

																}
															})
											var before = '';
											var after = '';
											$http(config).success(
													function(data) {

													})
											$('input[name="mybox"]:checked')
													.each(function() {
														//                            var  compont =$(this).attr("id")+'?'+$(this).val();
														//                            id_array.push(compont);//向数组中添加元素

													})
											//标记

										})
						//取消按钮
						$("#lcCancel").click(function() {
							id_array.splice(0, id_array.length);
							 history.back();
						});
						//确定按钮
						$("#confirm").click(function(){
                    	
                        if(isBan==1){
                            if(confirm('收件人含高层领导，请仔细确认，谨慎发送')){
                                var  compont = '';
                                for(var i=0;i<$scope.allSaveArr.length;i++){
                                    compont = $scope.allSaveArr[i].empcode+'?'+$scope.allSaveArr[i].empname;
                                    id_array.push(compont);//向数组中添加元素
                                }
                                id_array = getArray(id_array);
                                localStorage.setItem("transData",id_array);
                                window.location.href = "/dpm/dpmManage/push.action?back=1";
                            }else{
                                var  compont = '';
                            }
                        }else{
                            var  compont = '';
                            for(var i=0;i<$scope.allSaveArr.length;i++){
                                compont = $scope.allSaveArr[i].empcode+'?'+$scope.allSaveArr[i].empname;
                                id_array.push(compont);//向数组中添加元素
                            }
                            id_array = getArray(id_array);
                            localStorage.setItem("transData",id_array);
                            window.location.href = "/dpm/dpmManage/push.action?back=1";
                        }

                    })
						
						//广播推送

						$("#breadCast").click(function() {
							window.location.href = "/dpm/dpmManage/push.action?back=2";
						})
						//已选人员全选
						var checkflag2 = "false";
						$("#AlchooseAll").click(function() {

							var field = document.getElementsByName("mybox2");
							if (checkflag2 == "false") {
								for ( var i = 0; i < field.length; i++) {
									field[i].checked = true;
								}
								checkflag2 = "true";
							} else {
								for ( var i = 0; i < field.length; i++) {
									field[i].checked = false;
								}
								checkflag2 = "false";
							}

						})
						//已选人员删除
						$("#Aldelete")
								.click(
										function() {
											$('input[name="mybox2"]:checked')
													.each(
															function() {
																var myid = $(
																		this)
																		.val();
																for ( var i = 0; i < $scope.allcheckedArr.length; i++) {
																	if ($scope.allcheckedArr[i].empcode == myid) {
																		$scope.splitArray
																				.push($scope.allcheckedArr[i]);
																		$scope.items = $scope.splitArray
																				.slice(
																						(flagSave - 1) * 10,
																						flagSave * 10);
																		$scope.allcheckedArr
																				.splice(
																						i,
																						1);
																		$scope.allSaveArr
																				.splice(
																						i,
																						1);
																		// 保存到本地的删除

																	}
																}
															})
											var myname = $(
													"input[name='myname']")
													.val();
											var nomber = $(
													"input[name='nomber']")
													.val();
											var depart = $(
													"input[name='depart']")
													.val();
											var work = $("input[name='work']")
													.val();
											var degree = $(
													"input[name='degree']")
													.val();
											var data = {
												"empname" : myname,
												"empcode" : nomber,
												"orgname" : depart,
												"jobname" : work,
												"joblevel" : degree
											};
											var transArr = JSON.stringify(data);
											var searhUrl = '/dpm/dpm/tongxunlu_pushUser.action?json='
													+ transArr;
											var config = {
												url : searhUrl,
												method : "get"
											};
											$http(config)
													.success(
															function(data) {
																if (null != data) {
																	$scope.allitems = data;
																	$scope.splitArray = data;
																	//分页是否显示
																	if ($scope.allitems.length < 50) {
																		$(
																				"#link")
																				.hide();
																		$scope.items = $scope.allitems
																	} else {
																		$(
																				"#link")
																				.show();
																		//分页
																		allPage = Math
																				.ceil($scope.allitems.length / 10);
																		$scope.items = $scope.allitems
																				.slice(
																						0,
																						10);
																	}

																}
															})
										})

					})
</script>
</head>
<body ng-controller="MyDetail">
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-xs-1">
				<p align="center" style="margin-top: 5px">姓名</p>
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" name="myname"
					placeholder="姓名" id="myname">
			</div>
			<div class="col-xs-1">
				<p align="center" style="margin-top: 5px">工号</p>
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" name="nomber"
					placeholder="工号" id="nomber">
			</div>
			<div class="col-xs-1">
				<p align="center" style="margin-top: 5px">部门</p>
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" name="depart"
					placeholder="部门" id="depart">
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-xs-1">
				<p align="center" style="margin-top: 5px">岗位</p>
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" name="work" placeholder="岗位"
					id="work">
			</div>
			<div class="col-xs-1">
				<p align="center" style="margin-top: 5px">级别</p>
			</div>
			<div class="col-xs-3">
				<input type="text" class="form-control" name="degree"
					placeholder="级别" id="degree">
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-xs-2 col-md-offset-4">
				<button type="button" class="btn btn-primary" id="search">查询</button>
			</div>
			<div class="col-xs-2 ">
				<button type="button" class="btn btn-info" id="clear">清除</button>
			</div>
		</div>
		<h1></h1>

		<div class="row">
			<div class="col-xs-7 ">
				<table class="table table-striped">
					<button type="button" class="btn btn-danger" id="selectedAll">全选</button>
					<button type="button" class="btn btn-info" id="breadCast"
						style="margin-left: 50px">广播推送</button>
					<thead>
						<tr>
							<th>姓名</th>
							<th>工号</th>
							<th>部门</th>
							<th>职级</th>
							<th>岗位</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in items">
							<td><input type="checkbox" name="mybox"
								id='{{item.empcode}}' value='{{item.empname}}'>{{item.empname}}</td>
							<td ng-bind="item.empcode"></td>
							<td ng-bind="item.orgname"></td>
							<td ng-bind="item.joblevel"></td>
							<td ng-bind="item.jobname"></td>
						</tr>
					</tbody>
				</table>
			</div>


			<div class="col-xs-1 ">
				<button type="button" class="btn btn-success" id="Aldelete"
					style="margin-top: 100px"><</button>

				<button type="button" class="btn btn-success" id="choose"
					style="margin-top: 200px">></button>
			</div>


			<div class="col-xs-4 ">
				<table class="table table-striped">
					<button type="button" class="btn btn-danger" id="AlchooseAll">全选</button>
					<!--<button type="button" class="btn btn-success" style="margin-left: 50px" id="Aldelete">删除</button>-->
					<thead>
						<tr>
							<th>姓名</th>
							<th>工号</th>
							<th>部门</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in allcheckedArr" class="active">
							<td><input type="checkbox" name="mybox2"
								value='{{item.empcode}}'>{{item.empname}}</td>
							<!--<td ng-bind="item.empname"></td>-->
							<td ng-bind="item.empcode"></td>
							<td ng-bind="item.orgname"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6" id="link">
				<ul class="pagination" >
					<li id="lc1"><a href="#">首页</a></li>
					<li><a href="#"><</a></li>
					<li><a>第</a></li>
					<li><a>1</a></li>
					<li><a>页</a></li>
					<li><a>共75页</a></li>
					<li><a href="#">></a></li>
					<li><a href="#">尾页</a>
				</ul>
			</div>
			<div class="col-xs-6" id="link2">
				<ul class="pagination">
					<li id="lc2"><a href="#">首页</a></li>
					<li><a href="#"><</a></li>
					<li><a>第</a></li>
					<li><a>1</a></li>
					<li><a>页</a></li>
					<li><a>共75页</a></li>
					<li><a href="#">></a></li>
					<li><a href="#">尾页</a>
				</ul>
			</div>

		</div>
		<div class="row">
			<div class="col-xs-2 col-md-offset-4">
				<button type="button" class="btn btn-danger" id="confirm">确定</button>
			</div>
			<div class="col-xs-2 ">
				<button type="button" class="btn btn-warning" id="lcCancel">取消</button>
			</div>
		</div>
	</div>
</body>
</html>