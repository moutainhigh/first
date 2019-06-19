/**
 * Created by deppon on 14/08/2017.
 */
var dp_url = '/dpm/dpm/feedback_getReportListByHandleId.action?';
var app = angular.module('reportApp',[]);
app.controller('reportCtl', function ($scope, $http, $location) {

	var userId = sessionStorage.getItem('userId');
	console.log('反馈userId:'+ userId);

	$scope.uid = userId;
    $scope.sch = {};
    $scope.sch['type'] = '';
    $scope.sch.executeStatus = '';
    //查询结果的页数
    $scope.pageCount = 0;
    //每页显示的条数 默认是10
    $scope.pageSize = 10;
    //一共的条目
    $scope.recodersCount = 0;
    //要查询的页数
    $scope.pos = 1;
    //查询请求配置,默认全部查询
    $scope.searchUrl = dp_url + "userId=" + userId;
    //分页显示数字
    $scope.pageSep = [];
    $scope.pageGroup = 1;

    $scope.checkValue = function (val) {
        if (val == undefined)
            return "";
        return val;
    }

    $scope.searchAction = function () {
        //获取日期
        var startDate = document.getElementById('startDate').value;
        var endDate = document.getElementById('endDate').value;
        var tm_dp_url = dp_url;
        tm_dp_url += 'userId=' + userId;
        tm_dp_url += '&search.searchCode=' + $scope.checkValue($scope.sch.userId);
        tm_dp_url += '&search.searchName=' + $scope.checkValue($scope.sch.userName);
        tm_dp_url += '&search.searchContent=' + $scope.checkValue($scope.sch.content);
        tm_dp_url += '&search.searchOsType=' + $scope.checkValue($scope.sch.type);
        tm_dp_url += '&search.searchBeginTime=' + $scope.checkValue(startDate);
        tm_dp_url += '&search.searchEndTime=' + $scope.checkValue(endDate);
        tm_dp_url += '&search.searchStatus=' + $scope.checkValue($scope.sch.executeStatus);
        $scope.searchUrl = tm_dp_url;
        $scope.pos = 1;
        $scope.pageGroup = 1;
        $scope.resetPage();
        $scope.searchData(1);
    }

    function rangeArr(start, end) {
        var arr = [];
        for (var i = start;i <= end;i++) {
            arr.push(i)
        }
        return arr;
    }

    /**
     * 重置分页信息
     */
    $scope.resetPage = function () {
        var mod = parseInt($scope.pageCount/($scope.pageGroup*10));
        if (mod >= 1) {
            $scope.pageSep = rangeArr(($scope.pageGroup - 1)*10 + 1, $scope.pageGroup*10);
        } else {
            $scope.pageSep = rangeArr(($scope.pageGroup - 1)*10 + 1,($scope.pageGroup - 1)*10 + $scope.pageCount%10);
        }
    }

    /**
     * 查询数据
     * @param pos 查询第几页
     */
    $scope.searchData = function (pos) {
    	
    	var sessionId = sessionStorage.getItem('sessionId');
        var casCookie = sessionStorage.getItem('casCookie');
        var config = {
        		url:encodeURI($scope.searchUrl + '&currentPage=' + pos + '&sessionId=' + sessionId + '&casCookie=' + casCookie),
            method:'get',
        }

        $http(config).success(function (data) {
            if (data.errorCode != 0) {
                alert('请重新登录');
                window.location.href = 'login.html';
                return;
            }
            $scope.recoders = data.data;
            $scope.recodersCount = data.count;
            if ($scope.recodersCount%10 === 0) {
                    $scope.pageCount = $scope.recodersCount/10;
            } else {
                $scope.pageCount = parseInt($scope.recodersCount/10) + 1;
            }
            $scope.resetPage();
        }).error(function (data) {
            console.log(data);
        })
    }

    $scope.searchData(1);

    /**
     * 重置搜索表单
     */
    $scope.resetAction = function () {
        $scope.status = '1';
        for (var key in $scope.sch) {
            $scope.sch[key] = '';
        }
        $scope.sch['type'] = '';
        $scope.sch['executeStatus'] = '';
        document.getElementById('startDate').value = '';
        document.getElementById('endDate').value = '';
        $scope.detailHidden = '0';
        $scope.imgHidden = '0';
        $scope.boxHidden = '0';
    }

    $scope.searchPage = function (i) {
        $scope.pos = i;
        $scope.searchData($scope.pos);
    }

    $scope.backList = function () {
        if ($scope.pageGroup*10 + 1 < $scope.pageCount) {
            $scope.pos = $scope.pageGroup*10 + 1;
            ++$scope.pageGroup;
        } else {
            alert('没有下一页了');
            return;
        }
        $scope.searchData($scope.pos);
    }

    $scope.forwardList = function() {
        if (($scope.pageGroup - 1)*10 < 1) {
            alert('没有以前了');
            return;
        }
        $scope.pos = ($scope.pageGroup - 2)*10 + 1;
        --$scope.pageGroup;
        $scope.searchData($scope.pos);
    }


    $scope.imgPos = 0;
    $scope.imgPaths = [];
    $scope.showImg = function (item) {
        $scope.imgPos = 0;
        $scope.imgHidden = '1';
        $scope.imgPaths = item.fileName.split(',');
        if ($scope.imgPaths.length >= 1) {
            $scope.imgPath = $scope.imgPaths[0];
        }
    }

    $scope.preImg = function () {
        if ($scope.imgPos - 1 < 0) {
            alert('已经第一张了');
            return;
        }
        $scope.imgPath = $scope.imgPaths[--$scope.imgPos];
    }

    $scope.nextImg = function () {
        if ($scope.imgPos + 1 >= $scope.imgPaths.length) {
            alert("最后一张了");
            return;
        }
        $scope.imgPath = $scope.imgPaths[++$scope.imgPos];
    }

    $scope.showTextDetail = function (details) {
        $scope.detailHidden = '1';
        $scope.textDetail = details;
    }
    
    $scope.closeTextDetail = function () {
        $scope.detailHidden = '0';
    }
    
    var maxChars = 200;//最多字符数
    /*$scope.count = maxChars;
    $scope.reply = "您好，此问题的解决方法是xxx。若按此操作后问题还未解决，请电话联系xxx xxxx xxxx"*/
    $scope.replyWord = function(){
    	var replycontent = $scope.reply;
        if (replycontent.length > maxChars)
        	$scope.reply = replycontent.substring(0,maxChars); 
        if($scope.count > 0){
        	$scope.count = $scope.reply.length; 
        }
    }

    
    $scope.closeImgShow = function () {
        $scope.imgHidden = '0';
    }
    
    $scope.showbox = function(item){
    	$scope.boxHidden = '1';
    	$scope.receiver = item.empName;
    	$scope.replyTitle = "您有一条\"" + item.type + "\"相关的意见反馈回复";
    	$scope.desp = item.content;
    	$scope.feedBackId = item.feedBackId;
    	$scope.empCode = item.empCode;
    	$scope.reply = "您好，此问题的解决方法是xxx。若按此操作后问题还未解决，请电话联系xxx xxxx xxxx";
    	$scope.count = $scope.reply.length;
    }
    
    $scope.closeBoxDetail = function () {
        $scope.boxHidden = '0';
        $scope.reply = "";
    }
    

    $scope.submitBox = function(){
    	
    	/*回复不为空才进行提交*/
    	if($scope.reply != ""){
    		var sessionId = sessionStorage.getItem('sessionId');
            var casCookie = sessionStorage.getItem('casCookie');
    		var dp_fb_url = '/dpm/dpm/feedback_feedbackReply.action?';
        	dp_fb_url += '&feedBackDetailsEntity.id=' + $scope.feedBackId;
        	dp_fb_url += '&feedBackDetailsEntity.reply=' + $scope.reply;
        	dp_fb_url += '&feedBackDetailsEntity.executeStatus=' + 1;
        	dp_fb_url += '&feedBackDetailsEntity.empCode=' + $scope.empCode;
        	dp_fb_url += '&userId=' + userId;
        	dp_fb_url += '&sessionId=' + sessionId;
        	dp_fb_url += '&casCookie=' + casCookie;
        	dp_fb_url += '&replyTitle=' + $scope.replyTitle;
        	var config = {
                    url: encodeURI(dp_fb_url),
                    method: 'get'
                }
        	
        	$http(config).success(function (data) {
                if (data.errorCode != 0) {
                    alert('请重新登录');
                    window.location.href = 'login.html';
                    return;
                }
                $scope.searchData($scope.pos);
                $scope.boxHidden = '0';
            }).error(function (data) {
                console.log(data);
            })
    	}else{
    		alert('回复内容不能为空');
    	}
    	
    }
    
    //huanxing type done button 
    $scope.solve = function(item){
    	
    	//$scope.boxHidden = '1';
    	$scope.receiver = item.empName;
    	$scope.replyTitle = "您有一条\"" + item.type + "\"相关的意见反馈回复";
    	$scope.desp = item.content;
    	$scope.feedBackId = item.feedBackId;
    	$scope.empCode = item.empCode;
    	$scope.reply = "您好，此问题已经线下解决，此处是默认的回复!";//问题线下解决，此处是默认的回复
    	$scope.count = $scope.reply.length;
    	
    	/*回复不为空才进行提交*/
    	if($scope.reply != ""){
    		var sessionId = sessionStorage.getItem('sessionId');
            var casCookie = sessionStorage.getItem('casCookie');
    		var dp_fb_url = '/dpm/dpm/feedback_feedbackReply.action?';
        	dp_fb_url += '&feedBackDetailsEntity.id=' + $scope.feedBackId;
        	dp_fb_url += '&feedBackDetailsEntity.reply=' + $scope.reply;
        	dp_fb_url += '&feedBackDetailsEntity.executeStatus=' + 1;
        	dp_fb_url += '&feedBackDetailsEntity.empCode=' + $scope.empCode;
        	dp_fb_url += '&feedBackDetailsEntity.type=' + item.type;
        	dp_fb_url += '&userId=' + userId;
        	dp_fb_url += '&sessionId=' + sessionId;
        	dp_fb_url += '&casCookie=' + casCookie;
        	dp_fb_url += '&replyTitle=' + $scope.replyTitle;
        	var config = {
                    url: encodeURI(dp_fb_url),
                    method: 'get'
                }
        	
        	$http(config).success(function (data) {
                if (data.errorCode != 0) {
                    alert('请重新登录');
                    window.location.href = 'login.html';
                    return;
                }
                $scope.searchData($scope.pos);
                $scope.boxHidden = '0';
            }).error(function (data) {
                console.log(data);
            })
    	}else{
    		alert('回复内容不能为空');
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
        var point = 'report3.html';
        window.location.href = point;
    }
});