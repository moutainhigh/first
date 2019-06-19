/**
 * Created by deppon on 14/08/2017.
 */
var dp_url = '/dpm/dpm-doc/getHxMsmSwitch.action?';
var add_url = '/dpm/dpm-doc/insertHxMsmSwitch.action?';
var upd_url = '/dpm/dpm-doc/updateHxMsmSwitch.action?';
//var dp_url = '/dpm/dpm/feedback_getReportListByHandleId.action?';
var app = angular.module('reportApp',[]);
app.controller('reportCtl', function ($scope, $http, $location) {
    
	var userId = sessionStorage.getItem('userId');
    var sessionId = sessionStorage.getItem('sessionId');
    var casCookie = sessionStorage.getItem('casCookie');

    $scope.uid = userId;

    // 检查为不为空
    $scope.checkValue = function (val) {
        if (val == undefined)
            return "";
        return val;
    }
    // 点击查询添加
    $scope.searchAction = function () {
        var tm_dp_url = add_url;
        tm_dp_url += 'userId=' + userId;
        tm_dp_url += '&sessionId=' + sessionId;
        tm_dp_url += '&casCookie=' + casCookie;
        tm_dp_url += '&userCode=' + $scope.checkValue($scope.sch.userId);
        $scope.searchUrl = tm_dp_url;
        var config = {
                url:encodeURI($scope.searchUrl),
                method:'get',
        }

        $http(config).success(function (data) {
            console.log(data)
            if (data.code == 0 || data.code == 2) {
                  //获取当前用户的状态 
                  $scope.selCheck();
            }else{
                    alert('请重新登录');
                    window.location.href = 'login.html';
                    return;
             }
           
        }).error(function (data) {
            console.log(data);
        })

    }
    // 查询状态
    $scope.selCheck = function(){
        var tm_dp_url = dp_url;
        tm_dp_url += 'userId=' + userId;
        tm_dp_url += '&sessionId=' + sessionId;
        tm_dp_url += '&casCookie=' + casCookie;
        tm_dp_url += '&userCode=' + $scope.checkValue($scope.sch.userId);
        $scope.searchUrl = tm_dp_url;
        var config = {
                url:encodeURI($scope.searchUrl),
                method:'get',
        }

        $http(config).success(function (data) {
            console.log(data)
             if (data.code == 0) {
                    var arr = [];
                    arr.push(data.data);
                    $scope.recoders = arr;
             }else{
                    alert('请重新登录');
                    window.location.href = 'login.html';
                    return;
             }
        }).error(function (data) {
            console.log(data);
        })
    }
    // 改变状态
    $scope.updateState = function(state){
        var tm_dp_url = upd_url;
        tm_dp_url += 'userId=' + userId;
        tm_dp_url += '&sessionId=' + sessionId;
        tm_dp_url += '&casCookie=' + casCookie;
        tm_dp_url += '&userCode=' + $scope.checkValue($scope.sch.userId);
        tm_dp_url += '&state=' + state;
        $scope.searchUrl = tm_dp_url;
        var config = {
                url:encodeURI($scope.searchUrl),
                method:'get',
        }

        $http(config).success(function (data) {
            if (data.code == 0) {
                    $scope.selCheck();
             }else{
                    alert('请重新登录');
                    window.location.href = 'login.html';
                    return;
             }
           
        }).error(function (data) {
            console.log(data);
        }) 
    }
    function rangeArr(start, end) {
        var arr = [];
        for (var i = start;i <= end;i++) {
            arr.push(i)
        }
        return arr;
    }
    
    $scope.toDone = function(item) {
      console.log('-----', item);
    }

    /**
     * 重置搜索表单
     */
    $scope.resetAction = function () {
        $scope.status = '1';
        for (var key in $scope.sch) {
            $scope.sch[key] = '';
        }
    }

    

  
    
    $scope.logout = function(){
    	sessionStorage.clear();
    	window.location.href = 'login.html';
    }
    
    /*跳转到应用列表页面*/
    $scope.appDetailList = function() {
    	console.log("222222");
    	/*var sessionId = sessionStorage.getItem('sessionId');
        var casCookie = sessionStorage.getItem('casCookie');
        console.log('反馈-应用userId:'+ userId);*/
    	var applist = '/dpm/appdetail/pages/appDetailList.jsp?';
    	/*userId =' + $scope.uid + '&sessionId=' + $scope.sessionId + '&casCookie=' + $scope.casCookie
*/    	window.location.href = applist;
    }
    
    /*跳转到应用添加页面*/
    $scope.appDetailAdd = function() {
    	console.log("33333");
    	var appadd = '/dpm/dpm-management/appDetail_showAllApp.action?';
    	window.location.href = appadd;
    }
    
    /*跳转到欢行审批页面*/
    $scope.recordList = function() {
    	var record = '/dpm/didirecord/record.html?';
    	window.location.href = record;
    }
    
    /*跳转到欢行手机号页面*/
    $scope.upPhone = function() {
    	var upPhone = '/dpm/didirecord/upPhone.html?';
    	window.location.href = upPhone;
    }
    
    /*跳转到欢行对账页面*/
    $scope.account = function() {
    	var account = '/dpm/didirecord/account.html?';
    	window.location.href = account;
    }
    
    /*跳转到修改审批人页面*/
    $scope.approver = function() {
    	var approver = '/dpm/didirecord/approver.html?';
    	window.location.href = approver;
    }
    
    /*跳转到消息推送页面*/
    $scope.point = function() {
    	var point = '/dpm/didirecord/message_push.html?';
    	window.location.href = point;
    }
 
    //跳转到工作流及其他模块的提示信息的推送编辑界面
    $scope.goToWorkflowTip = function () {
        var point = '/dpm/didirecord/messagePush_v2.html?';
    	window.location.href = point;
    }
    /*跳转到控制短信验证页面*/
    $scope.openmsg = function() {
        console.log('触发跳转')
        var point = 'report3.html';
        window.location.href = point;
    }
    

});