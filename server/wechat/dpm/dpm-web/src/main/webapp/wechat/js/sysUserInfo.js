//更新
var sysUrl = '/dpm/dpm-wechat/wechat_updateUserInfo.action?';
//先删除再创建
var createUserInfoUrl = '/dpm/dpm-wechat/wechat_createUser.action?';
angular.module('wechatApp.sysUserInfo', ['ionic'])
.controller('sysUserInfoCtl', function ($scope, $http, $stateParams) {
	$scope.sysInfo = {
			sysUserId: ''
	}
	var person = "";
	var userId = $stateParams.userId;
	//跳转信息同步界面   陈育旺：098701  何俊敏：039047两个是超级管理员权限 
    if (userId == "098701" || userId == "039047") {
    	//超级管理员 可以更新任何人的个人信息
    	person = $scope.sysInfo.sysUserId;
	}else {
		//普通用户   只能 更新自己的工号信息
		person = userId;
	}
    //更新用户信息
	$scope.sysInfo = function () {
		console.log("-------------" + $stateParams.userId);
		
		var url = sysUrl + 'userId=' + userId + '&casCookie=' + sessionStorage.getItem('casCookie') 
					+ '&sessionId=' + sessionStorage.getItem('sessionId') + '&sysUserId=' + $scope.sysInfo.sysUserId ;
		var config = {
	            url: url,
	            method: 'get'
	        }
		
		 $http(config).success(function (data) {
	            if (data.errorCode != 0) {
	            	alert('请求出现异常 reson:' + data.errorMessage);
	                return;
	            }

	            var requestData = data.data;
	            if (requestData.errcode == 0) {
	                 alert('工号：' + person +  ' 更新成功');
	            }else {
	            	alert('更新失败，errorCode：' + requestData.errorCode + 
	            	' errmsg:' + requestData.errmsg)
	            }

	        }).error(function (data) {
	            console.log(data);
	        })
		
		
	}
	
	//先删除用户信息  再创建用户信息
	$scope.createUserInfo = function () {
		var url = createUserInfoUrl + 'userId=' + userId+ '&casCookie=' + sessionStorage.getItem('casCookie') 
		+ '&sessionId=' + sessionStorage.getItem('sessionId')  + '&sysUserId=' + $scope.sysInfo.sysUserId ;
		var config = {
	            url: url,
	            method: 'get'
	        }
		 $http(config).success(function (data) {
	            if (data.errorCode != 0) {
	            	alert('请求出现异常 reson:' + data.errorMessage);
	                return;
	            }

	            var requestData = data.data;
	            if (requestData.errcode == 0) {
	                 alert('工号：' + person +  ' 更新成功');
	            }else {
	            	alert('更新失败，errorCode：' + requestData.errorCode + 
	            	' errmsg:' + requestData.errmsg)
	            }

	        }).error(function (data) {
	            console.log(data);
	        })
	}

});