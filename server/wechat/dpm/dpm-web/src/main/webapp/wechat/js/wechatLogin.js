var wechat_login = '/dpm/dpm/feedback_loginFeedback.action?';
angular.module('wechatApp.login', ['ionic'])
.controller('loginCtl', function ($scope, $http, $state) {

	$scope.userInfo = {
			userName: '',
			password:''
	}
    $scope.loginAction = function () {

        var userName = $scope.userInfo.userName;
        var password = $scope.userInfo.password;

        if (userName === undefined || password === undefined) {
            alert(data.errorMessage);
            return;
        }

//        sessionStorage.setItem('userId', userName);

        var url = wechat_login + 'loginId=' + userName;
        url += '&loginPassword=' + password;
        var config = {
            url: url,
            method: 'post'
        }

        $http(config).success(function (data) {

            if (data.errorCode != 0) {
                alert('账号或密码错误');
                return;
            }

            var loginData = data.data;
            if (loginData.casCookie != undefined) {
                sessionStorage.setItem('casCookie', loginData.casCookie);
            }


            if (loginData.sessionId != undefined) {
                sessionStorage.setItem('sessionId', loginData.sessionId);
            }
            if (userName == "098701" || userName == "039047") {
            	//超级管理员 可以更新任何人的个人信息
            	$state.go("sysUserInfoSuper", {userId: userName});
        	}else {
        		//普通用户   只能 更新自己的工号信息
        		$state.go("sysUserInfo", {userId: userName});
        	}
//            window.location.href = 'report.html';


        }).error(function (data) {
            console.log(data);
        })
    }

});