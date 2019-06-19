<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/ext" prefix="ext"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="ionicApp">
<head lang="en">
<meta charset="UTF-8">
<title>消息推送</title>
<script type="text/javascript" src="/dpm/scripts/js/ionic.bundle.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/dpm/scripts/demo.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/config.js"></script>
<script type="text/javascript" src="/dpm/scripts/js/jquery-confirm.js"></script>

<link type="text/css" href="/dpm/styles/bootstrap.min.css" rel="stylesheet" media="screen">

<style type="text/css">
	.modal-backdrop {
	  opacity: 0 !important;
	  filter: alpha(opacity=0) !important;
	}
	
	.ecclink-checkbox {
		display: inline-block;
	    height: 1.1em;
	    width: 1.1em;
	    border-radius: 4px;
	    background-color: gray;  
	}
	
	#dataShow td {
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
	}
</style>
<script>

	$(function(){
		// 请求所有的本部
		$.get('${pageContext.request.contextPath}/dpmManage/jPushNewAction_queryPrimaryDept.action',function(data){
			var orgList = $.parseJSON(data);
			var deptStr = '';
			for(var i in orgList) {
				if(orgList[i].orgId == '-1'){
					continue;
				}
				deptStr += '<label style="padding-right:20px;"><input type="checkbox" name="orgId" value="'+orgList[i].orgId+'"/>'+orgList[i].orgName+'</label>';
			}
			
			$('#deptDiv').empty().append(deptStr);
		});
		
		// 推送条件选择框的选择事件
		$('#pushCondition').change(function(){
			// 获取选项的value值
			var conditionKey = $("#pushCondition").val();
			if(conditionKey != 'none'){
				// 如果选择了推送项，将推送人清空
				$("#pushTwo").val('');
			}
			
			if(conditionKey == 'osType') {
				$("#conditionDiv").attr('style','padding-top: 10px;');
				$("#conditionDiv div").attr('style','display: none')
				$("#osTypeDiv").attr('style','display: ""');
			} else if(conditionKey == 'joblevel') {
				$("#conditionDiv").attr('style','padding-top: 10px;');
				$("#conditionDiv div").attr('style','display: none')
				$("#joblevelDiv").attr('style','display: ""');
			} else if(conditionKey == 'jobname') {
				$("#conditionDiv").attr('style','padding-top: 10px;');
				$("#conditionDiv div").attr('style','display: none')
				$("#jobnameDiv").attr('style','display: ""');
			} else if(conditionKey == 'dept') {
				$("#conditionDiv").attr('style','padding-top: 10px;');
				$("#conditionDiv div").attr('style','display: none')
				$("#deptDiv").attr('style','display: ""');
			} else {
				$("#conditionDiv").attr('style','');
				$("#conditionDiv div").attr('style','display: none')
			}
		});
		
		
		// 链接类型选择
		$('.dropdown-menu a').on('click',function(){
			$('#selectLinkBtn').html('<span id="linktype">'+$(this).html()+'</span>' + ' <span class="caret"></span>');
			if($('#linktype').html() == '无链接') {
				$('.input-group input[name="linkaddr"]').val('').attr('disabled','false');
				$('#extrasDiv input[name="extras"]').val('');
				$('#extrasDiv').removeAttr('hidden');
				$('#extrasDiv').attr('hidden',true);
			} else {
				$('.input-group input[name="linkaddr"]').removeAttr('disabled');
				$('#extrasDiv').removeAttr('hidden');
			}
		});
		
		// 消息来源选择事件
		$('#pushselect').change(function(){
			if($("#pushselect").find("option:selected").text() == '德邦e站'){
				
				// 将链接改为内部链接
				$('.dropdown-menu a').each(function(){
					if($(this).text() == '内部链接') {
						$(this).trigger("click");
					}
				});
				
				// 弹出框
				$('#eccLinkModal').modal();
			}
		});
		
		//搜索
	    $("#searchBtn").click(function () {
	    	if($('#searchKey').val() == ''){
	    		return;
	    	}
	    	
	        $(this).button('loading');
	        
	        // 发起请求数据
	        $.post('${pageContext.request.contextPath}/dpmManage/jpushForEcc_searchEccLink.action',
	        		{searchKey:$('#searchKey').val()},function(data){
	        	$('#searchBtn').button('reset');
	        	data = $.parseJSON(data);
	        	for(var i in data){
	        		$('#dataShow tbody').append($('<tr><td><input type="checkbox" class="ecclink-checkbox"/><input type="hidden" class="pushLink" value="'+data[i].pushLink+'"/><input type="hidden" class="linkParam" value="'+data[i].linkParam+'"/></td><td class="type">'+data[i].type+'</td><td class="title">'+data[i].title+'</td><td class="pubTime">'+data[i].pubTime+'</td></tr>'));
	        	}
	        	
			 	// 让表格里面的所有checkbox只能单选
				$('#dataShow tr').each(function() {
					$(this).click(function() {
						var _checkbox = $(this).children().find('input[type="checkbox"]').get(0);
						if(!_checkbox.checked){
							$('#dataShow tr').find('input').removeAttr('checked');
						}
						_checkbox.checked = !_checkbox.checked;
					});
				});
			 	
			 	$('#eccLinkConfirmBtn').unbind('click').bind('click',function(){
			 		// 将选择的数据回填到推送表单中
			 		var pushLink = $('#dataShow input[class="ecclink-checkbox"]:checked').next().val();
			 		$('.input-group input[name="linkaddr"]').val(pushLink);
			 		
			 		var linkParam = $('#dataShow input[class="ecclink-checkbox"]:checked').next().next().val();
			 		$('#extrasDiv input[name="extras"]').val(linkParam);
			 		
			 		// 关闭弹框
			 		$('#eccLinkModal').modal('hide');
			 	});
	        });
	    });
		
	 	

		// 弹出框的关闭事件
		$('#eccLinkModal').on('hidden.bs.modal', function() {
			// 清空表格
			$('#dataShow tbody').empty();

			// 重置button和清空搜索框的值
			$("#searchBtn").button('reset');
			$('#searchKey').val('');

			// 如果链接输入框没有值则触发链接类型的无链接点击事件
			if ($('.input-group input[name="linkaddr"]').val() == '') {
				// 将链接改为无链接
				$('.dropdown-menu a').each(function() {
					if ($(this).text() == '无链接') {
						$(this).trigger("click");
					}
				});
			}
		});

	});

	function resetForm() {
		$(":input").val("");
	}

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
						}

				/* 		else {
							//广播推送
							if (confirm('收件人含高层领导，请仔细确认，谨慎发送')) {
								var myTemp = '推送给公司所有的人';
								backData = myTemp;
								$("#pushTwo").val(myTemp);
							} else {
								var compont = '';
							}

						} */

						$("#senlc")
								.click(
										function() {
											window.location.href = ("/dpm/dpmManage/detail.action");
										})

						$("#confirm")
								.click(
										function() {
											
											Ewin.confirm({ message: "确认推送？" }).on(function (e) {
											   if (!e) {
											      return;
											   }
											   
												//判断内容是否为空
												var s1 = $("#pushselect").find(
														"option:selected").text();
												var s2 = $("input[name='pushOne']")
														.val();
												
												// 推送人
												if($("#pushTwo").val() == ''){
													var s3 = '';
												} else {
													var s3 = numberArr;
												}
												
												var s4 = $('#pushThree').val();
												// 链接类型
												var linktype = $('#linktype')
														.html();
												if (linktype == '无链接') {
													linktype = 0;
												} else if (linktype == '外部链接') {
													linktype = 1;
												} else if (linktype == '内部链接') {
													linktype = 2;
												}

												// 链接地址
												var linkaddr = $(
														"input[name='linkaddr']")
														.val();

												// 链接参数
												var extras = $(
														'#extrasDiv input[name="extras"]')
														.val();
												var extrasParams = '';
												if (extras != '') {
													var extrasArr = extras
															.split("&");
													for ( var i in extrasArr) {
														var arr = extrasArr[i].split('=');
														extrasParams += '&'
																+ 'extras.'
																+ arr[0] + '='
																+ arr[1];
													}
												}

												var s6 = 0;//任务ID
												var s7 = 0;//是否显示小红点
												var s8 = true;//是否是消息中心

												// 推送条件选项
												var pushConditionKey = $(
														"#pushCondition").val();
												// 推送条件值
												var pushConditionValue = '';
												if (pushConditionKey == 'osType') {
													pushConditionValue = $(
															'#osTypeDiv input[name="osType"]:checked')
															.val();
													if (pushConditionValue == '') {
														$('#dialogContent').text(
																'请选择机型!')
														$('#myModal').modal();
														return;
													}
												} else if (pushConditionKey == 'joblevel') {
													var joblevelArr = [];
													$(
															'#joblevelDiv input[name="joblevel"]:checked')
															.each(
																	function() {
																		joblevelArr
																				.push($(
																						this)
																						.val());
																	});
													pushConditionValue = joblevelArr
															.join(',');

													if (pushConditionValue == '') {
														$('#dialogContent').text(
																'请选择层级!')
														$('#myModal').modal();
														return;
													}
												} else if (pushConditionKey == 'jobname') {
													pushConditionValue = $(
															'#jobnameDiv input[name="jobname"]')
															.val();
													if (pushConditionValue == '') {
														$('#dialogContent').text(
																'请填写岗位!')
														$('#myModal').modal();
														return;
													}
												} else if (pushConditionKey == 'dept') {
													var orgIdArr = [];
													$(
															'#deptDiv input[name="orgId"]:checked')
															.each(
																	function() {
																		orgIdArr
																				.push($(
																						this)
																						.val());
																	});
													pushConditionValue = orgIdArr
															.join(',');
													if (pushConditionValue == '') {
														$('#dialogContent').text(
																'请选择本部!')
														$('#myModal').modal();
														return;
													}
												}

												if (s2.length < 2) {
													$('#dialogContent').text('标题太短!');
													$('#myModal').modal();
												} 
											/* 	else if (backData.length < 2) {
													alert('╭(╯3╰)╮收信人不能为空');
												}  */
												
												else {
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
													if (s1 == '系统通知') {
														lctype = false;
													} else if (s1 == '德邦e站') {
														lctype = true;
													}

													// 根据层级或本部或岗位推送
													if (pushConditionKey != 'none'
															&& pushConditionKey != '') {
														var strData = '&pushConditionKey='
																+ pushConditionKey
																+ '&pushConditionValue='
																+ pushConditionValue
																+ '&content='
																+ s4
																+ '&alert='
																+ s2
																+ '&linktype='
																+ linktype
																+ '&linkaddr='
																+ linkaddr
																+ '&isEcc='
																+ lctype
																+ '&intoMC='
																+ s8
																+ extrasParams;

														var confirmUrl = '/dpm/dpmManage/jPushNewAction_pushByCondition.action?';
														$
																.ajax({
																	type : 'Post',
																	url : confirmUrl,
																	data : strData,
																	timeout : 30000,
																	success : function(
																			msg) {
																		if (msg == 'success') {
																			$(
																					'#dialogContent')
																					.text(
																							'推送成功!');
																			$(
																					'#myModal')
																					.modal();
																		} else {
																			$(
																					'#dialogContent')
																					.text(
																							'推送失败!');
																			$(
																					'#myModal')
																					.modal();
																		}
																	},
																	error : function(
																			xhr,
																			type) {
																		$(
																				'#dialogContent')
																				.text(
																						'推送失败!');
																		$(
																				'#myModal')
																				.modal();
																	}
																});
														return;

													}

													if (goback == 1) {
														if(s3.length == 0){
															$('#dialogContent').text('请选择推送人!');
															$('#myModal').modal();
															return;
														}
														//普通推送
														var strData = '&userIds='
																+ s3 + '&content='
																+ s4 + '&alert='
																+ s2 + '&linktype='
																+ linktype
																+ '&linkaddr='
																+ linkaddr
																+ '&isEcc='
																+ lctype
																+ '&intoMC=' + s8
																+ extrasParams;

														var confirmUrl = '/dpm/dpmManage/jPushNewAction_pushByUserIds.action?';
														$
																.ajax({
																	type : 'Post',
																	url : confirmUrl,
																	data : strData,
																	timeout : 30000,
																	success : function(
																			msg) {
																		if (msg == 'success') {
																			$(
																					'#dialogContent')
																					.text(
																							'推送成功!');
																			$(
																					'#myModal')
																					.modal();
																		} else {
																			$(
																					'#dialogContent')
																					.text(
																							'推送失败!');
																			$(
																					'#myModal')
																					.modal();
																		}
																	},
																	error : function(
																			xhr,
																			type) {
																		$(
																				'#dialogContent')
																				.text(
																						'推送失败!');
																		$(
																				'#myModal')
																				.modal();
																	}
																})
													} else if (userId) {
														//意见反馈推送
														var strData = '&userIds='
																+ s3 + '&content='
																+ s4 + '&alert='
																+ s2 + '&linktype='
																+ linktype
																+ '&linkaddr='
																+ linkaddr
																+ '&isEcc='
																+ lctype
																+ '&intoMC=' + s8
																+ extrasParams;
														var confirmUrl = '/dpm/dpmManage/jPushNewAction_pushByUserIds.action?';
														$
																.ajax({
																	type : 'Post',
																	url : confirmUrl,
																	data : strData,
																	timeout : 30000,
																	success : function(
																			msg) {
																		if (msg == 'success') {
																			$(
																					'#dialogContent')
																					.text(
																							'推送成功!');
																			$(
																					'#myModal')
																					.modal();
																		} else {
																			$(
																					'#dialogContent')
																					.text(
																							'推送失败!');
																			$(
																					'#myModal')
																					.modal();
																		}
																	},
																	error : function(
																			xhr,
																			type) {
																		$(
																				'#dialogContent')
																				.text(
																						'推送失败!');
																		$(
																				'#myModal')
																				.modal();
																	}
																})
													} else {
														$('#dialogContent').text(
																'不能广播推送!');
														$('#myModal').modal();
														//广播推送
														/* 													var strData = 
														 '&userIds='+ s3 + 
														 '&content='+ s4 + 
														 '&alert='+ s2 + 
														 '&linktype='+ linktype +
														 '&linkaddr=' + linkaddr +
														 '&isEcc='+ lctype + 
														 '&intoMC='+ s8 + 
														 extrasParams;
														 var confirmUrlTwo = '/dpm/dpmManage/jPushNewAction_pushAll.action?';
														 $.ajax({
														 type : 'Post',
														 url : confirmUrlTwo,
														 data : strData,
														 timeout : 30000,
														 success : function(msg) {
														 if(msg == 'success'){
														 $('#dialogContent').text('推送成功!');
														 $('#myModal').modal();
														 }else{
														 $('#dialogContent').text('推送失败!');
														 $('#myModal').modal();
														 }
														 },
														 error : function(xhr,type) {
														 $('#dialogContent').text('推送失败!');
														 $('#myModal').modal();
														 }
														 }) */
													}
												}
											});
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
	<div class=container>
		<nav class="navbar navbar-default" role="navigation">
			<h3 align="center">消息推送平台</h3>
		</nav>
		<div class="row">
			<div class="col-xs-4" align="center">
				<button type="button" class="btn btn-default" id="senlc">收信人</button>
			</div>
			<div class="col-xs-6">
				<input type="text" class="form-control" name="pushTwo" id="pushTwo">
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-xs-4" align="center">
				<p align="center" style="margin-top: 5px">推送条件</p>
			</div>
			<div class="col-xs-6">
				<select class="form-control" id="pushCondition">
					<option value="none" selected="selected">选择推送项</option>
					<!-- <option value="osType">机型</option> -->
					<option value="joblevel">层级</option>
					<option value="jobname">岗位</option>
					<option value="dept">本部</option>
				</select>
				
				<div id="conditionDiv">
					<div id="osTypeDiv" class="radio" style="display: none">
						<label>
							<input type="radio" name="osType" value="android" checked="checked"/>android
						</label>
						&nbsp;
						<label>
							<input type="radio" name="osType" value="iphone"/>ios
						</label>
					</div>
					<div id="joblevelDiv" class="checkbox" style="display: none">
						<label>
							<input type="checkbox" name="joblevel" value="04"/>04
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="05"/>05
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="06"/>06
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="07"/>07
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="08"/>08
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="09"/>09
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="10"/>10
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="D"/>D
						</label>
						&nbsp;
						<label>
							<input type="checkbox" name="joblevel" value="C"/>C
						</label>
					</div>
					<div id="jobnameDiv" style="display: none">
						<input type="text" name="jobname" class="form-control" placeholder="例如：快递员,人事专员"/>
					</div>
					<div id="deptDiv" class="checkbox" style="display: none">
					</div>
				</div>
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-xs-4">
				<p align="center" style="margin-top: 5px">消息来源</p>
			</div>
			<div class="col-xs-6">
				<select class="form-control" id="pushselect">
					<option>德邦e站</option>
					<option selected="selected">系统通知</option>
				</select>
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-xs-4">
				<p align="center" style="margin-top: 5px">标题</p>
			</div>
			<div class="col-xs-6">
				<input type="text" class="form-control" name="pushOne"
					placeholder="必填项:）">
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-xs-4">
				<p align="center" style="margin-top: 5px">链接</p>
			</div>
			<div class="col-xs-6">
				<div class="input-group">
					<div class="input-group-btn">
						<button type="button" id="selectLinkBtn" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							<span id="linktype">无链接</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">无链接</a></li>
							<li><a href="#">内部链接</a></li>
							<li><a href="#">外部链接</a></li>
						</ul>
					</div>
					<input type="text" class="form-control" name="linkaddr" disabled="false">
				</div>
			</div>
		</div>
		<h1></h1>
		<div class="row" id="extrasDiv" hidden="true">
			<div class="col-xs-4">
				<p align="center" style="margin-top: 5px">链接参数</p>
			</div>
			<div class="col-xs-6">
				<input type="text" class="form-control" name="extras" placeholder="例如：name=张三&age=20">
			</div>
		</div>
		<h1></h1>
		<div class="row">
			<div class="col-xs-4">
				<p align="center" style="margin-top: 5px">内容</p>
			</div>
			<div class="col-xs-6">
				<textarea class="form-control" rows="3" id="pushThree"></textarea>
			</div>
			<div class="col-xs-1" style="margin-top: 90px">
				<p id="lclimit">0/50</p>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2 col-xs-offset-5">
				<button type="button" class="btn btn-primary" id="confirm">确认</button>
			</div>
			<div class="col-xs-2 ">
				<button type="button" class="btn btn-info" id="cancel" onclick="resetForm()">取消</button>
			</div>
		</div>
	</div>
	<h1></h1>
	
	<div class="container">
	  	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" >
	  		<div class="modal-dialog modal-sm" role="document">
	  			<div class="modal-content">
					<div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
						<p id="dialogContent"></p>
					</div>
	  			</div>
	  		</div>
		</div>
	</div>
	
	
	<div class="container">
	  	<div class="modal fade" id="eccLinkModal" role="dialog" aria-hidden="true" data-backdrop="static">
	  		<div class="modal-dialog modal-lg" role="document">
	  			<div class="modal-content">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal">×</button>
					    <div class="input-group col-md-3" style="margin-top:0px;positon:relative">
				            <input type="text" class="form-control" id="searchKey" placeholder="请输入关键字" />
				            <span class="input-group-btn">
				               <button class="btn btn-info btn-search" id="searchBtn">Search</button>
				            </span>
				        </div>
					</div>
				    <div class="modal-body">
				        <table class="table table-striped table-hover" id="dataShow" style="table-layout:fixed;">
				            <thead>
					            <tr>
					                <th width="10%">选择</th>
					                <th width="20%">类型</th>
					                <th width="45%">标题</th>
					                <th width="25%">发布时间</th>
					            </tr>
				            </thead>
				            <tbody>
				            	
				            </tbody>
				        </table>
                    </div>
                    <div class="modal-footer">
                    	<button id="eccLinkConfirmBtn" class="btn btn-primary">确定</button>
                    </div>
	  			</div>
	  		</div>
		</div>
	</div>
	
	<div class="container">
	  	
    </div>
</body>
</html>