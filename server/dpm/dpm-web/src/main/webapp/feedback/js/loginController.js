/**
 * Created by deppon on 17/08/2017.
 */
var dp_feedback_login = '/dpm/dpm/feedback_loginFeedback.action?';
var app = angular.module('loginApp', []);
app.controller('loginCtl', function ($scope, $http) {

    $scope.loginAction = function () {

        var userName = $scope.userName;
        var password = $scope.password;

        if (userName === undefined || password === undefined) {
            alert('账号或密码不能为空');
            return;
        }

        sessionStorage.setItem('userId', userName);

        var url = dp_feedback_login + 'loginId=' + userName;
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
            window.location.href = 'report1.html';
            /*../../appdetail/pages/appDetailList.jsp*/

        }).error(function (data) {
            console.log(data);
        })
    }

});