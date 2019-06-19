var ad_dp_url = '/dpm/dpm-management/appDetail_getAppDetailList.action?';
var app = angular.module('appDetail',[]);
app.controller('appDetailCtl', function ($scope, $http) {
	console.log("11111111111");
	var userId = sessionStorage.getItem("userId");
	console.log('应用userId:'+ userId);
	
	$scope.uid = userId;
	
	$scope.detailHidden = '0';
	
	
	/**
     * 查询详情数据
     */
    $scope.searchData = function () {
    	
    	var sessionId = sessionStorage.getItem('sessionId');
        var casCookie = sessionStorage.getItem('casCookie');
        
        /*获取详情数据*/
        $scope.searchUrl = ad_dp_url + 'userId=' + userId;
        var config = {
        		url:encodeURI($scope.searchUrl + '&sessionId=' + sessionId + '&casCookie=' + casCookie),
            method:'get',
        }

        $http(config).success(function (data) {
            if (data.errorCode != 0) {
                alert('请重新登录');
                window.location.href = 'login.html';
                return;
            }
            $scope.recoders = data.data;
        }).error(function (data) {
            console.log(data);
        })
    }
    /**
     * 跳转到页面时先执行一次查询数据，列表展示
     */
    $scope.searchData();
    
    /**
     * 查看图片
     */
    $scope.imgPos = 0;
    $scope.imgPaths = [];
    $scope.showImg = function (item) {
        $scope.imgPos = 0;
        $scope.imgHidden = '1';
        $scope.imgPaths = item.appPhoto.split(',');
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
    
    $scope.closeImgShow = function () {
        $scope.imgHidden = '0';
    }
    
    /**
     * 打开添加应用详情
     */
    $scope.insertBox = function(){
    	/*获取下拉框所有应用*/
    	console.log("添加应用详情");    
    	var sessionId = sessionStorage.getItem('sessionId');
        var casCookie = sessionStorage.getItem('casCookie');
        var seaUrl = '/dpm/dpm-management/appDetail_showAllApp.action?';
        console.log("0000");      
        var con = {
        		url:encodeURI(seaUrl + '&sessionId=' + sessionId + '&casCookie=' + casCookie),
            method:'get',
        }

        $http(con).success(function (data) {
            if (data.errorCode != 0) {
                alert('请重新登录');
                window.location.href = 'login.html';
                return;
            }
            $scope.applist = data.data;
            console.log(data+"111");
        }).error(function (data) {
            console.log(data+"222");
        })
        /*$scope.piclist = [1];*/
        
        $scope.filetoupload = '';
        $scope.detailmessage = '开发部门：\n应用对接人：';
        $scope.iboxHidden = '1';
    }
    
    /**
     * 关闭添加应用
     */
    $scope.closeBox = function () {

    	/*var filetoupload = document.getElementById('fileupload') ; 
    	filetoupload.select(); 
    	document.selection.clear();*/
    	var obj = document.getElementById('fileupload') ; 
    	obj.outerHTML=obj.outerHTML; 
    	$scope.filetoupload = '';
    	$scope.appintroduce = '';
    	$scope.detailmessage = '开发部门：\n应用对接人：';
    	$scope.newfeature = '';
        $scope.iboxHidden = '0';
    }
    
    /**
     * 提交添加
     */
    $scope.submitiBox = function(){
    	
    	var sessionId = sessionStorage.getItem('sessionId');
    	var casCookie = sessionStorage.getItem('casCookie');
    	var url = '/dpm/dpm-management/appDetail_insertAppDetail.action?' + "userId=" + userId + '&sessionId=' + sessionId + '&casCookie=' + casCookie;
      
    	var fd = new FormData();
        fd.append( "appstoreId", $scope.selectedApp.appId);
        fd.append( "appName", $scope.selectedApp.cnName);
        fd.append( "appIntroduce", $scope.appintroduce);
        fd.append( "detailMessage", $scope.detailmessage);
        fd.append( "newFeature", $scope.newfeature);
        //fd.append( "sessionId", sessionId);
        //fd.append( "casCookie", casCookie);
        
        
        /*var files = $scope.filetoupload;
        fd.append( "photos", files );*/
        /*for (var i = 0; i < files.length; i++) {
        	fd.append('photos', files[i])
        }*/
        
        var fileinput = document.getElementById('fileupload');
        var files = fileinput.files
        for (var i = 0; i < files.length; i++) {
        	fd.append('photos', files[i])
        }
        
        
        $http.post( url, fd, {
           transformRequest: angular.identity,
           headers: { "Content-Type": undefined }
        })
        .success(function(data){
        	console.log("success");
        	if (data.errorCode != 0) {
        		alert('请重新登录');
        		window.location.href = '/dpm/feedback/pages/login.html?';
        		return;
        	}
        	if(data.data == "99"){
        		alert('该应用详情已存在，无法重复添加');
        	}
        	$scope.searchData();
        	var obj = document.getElementById('fileupload') ; 
        	obj.outerHTML=obj.outerHTML; 
        	$scope.filetoupload = '';
        	$scope.appintroduce = '';
        	$scope.detailmessage = '开发部门：\n应用对接人：';
        	$scope.newfeature = '';
        	$scope.iboxHidden = '0';
        })
        .error( function(data){
        	console.log(data);
        })	
    }
    
    /**
     * 打开修改应用详情
     */
    $scope.updateBox = function(item){
    	$scope.boxHidden = '1';
    	$scope.appName = item.appName;
    	$scope.appIntroduce = item.appIntroduce;
    	$scope.detailMessage = item.detailMessage;
    	$scope.newFeature = item.newFeature;
    	$scope.id = item.id;
    	$scope.fileToUpload = '';
    	$scope.appManager = '';
    	/*$scope.piclist = [1];*/
    }
    /**
     * 关闭应用详情
     */
    $scope.closeBoxDetail = function () {
        $scope.boxHidden = '0';
        $scope.fileToUpload = '';
    }
    
    /**
     * 提交修改
     */
    $scope.submitBox = function(){
    	
    	var sessionId = sessionStorage.getItem('sessionId');
    	var casCookie = sessionStorage.getItem('casCookie');
    	var url = "/dpm/dpm-management/appDetail_updateAppDetail.action?" + "userId=" + userId + '&sessionId=' + sessionId + '&casCookie=' + casCookie;
      
    	var fd = new FormData();
        fd.append( "appdetailEntity.id", $scope.id);
        fd.append( "appdetailEntity.appName", $scope.appName);
        fd.append( "appdetailEntity.appIntroduce", $scope.appIntroduce);
        fd.append( "appdetailEntity.detailMessage", $scope.detailMessage);
        fd.append( "appdetailEntity.newFeature", $scope.newFeature);
        fd.append( "appManager", $scope.appManager);
        fd.append( "sessionId", sessionId);
        fd.append( "casCookie", casCookie);
        
        
        /*var file = $scope.fileToUpload;
        fd.append( "photos", files );*/
        var fileinput = document.getElementById('fileToUpload');
        var files = fileinput.files
        for (var i = 0; i < files.length; i++) {
        	fd.append('photos', files[i])
        }
        
        $http.post( url, fd, {
           transformRequest: angular.identity,
           headers: { "Content-Type": undefined }
        })
        .success(function(data){
        	console.log("success");
        	if (data.errorCode != 0) {
        		alert('请重新登录');
        		window.location.href = '/dpm/feedback/pages/login.html?';
        		return;
        	}
        	$scope.searchData();
        	$scope.boxHidden = '0';
        })
        .error( function(data){
        	console.log(data);
        })	
        
        var obj = document.getElementById('fileupload') ; 
    	obj.outerHTML=obj.outerHTML; 
    	$scope.filetoupload = '';
    }
    
    /*跳转到意见反馈页面*/
    $scope.feedback = function() {
    	console.log("444");
        console.log('应用-反馈userId:'+ userId);
    	var feedback = '/dpm/feedback/pages/report1.html?';
    	window.location.href = feedback;
    }
    
    /*跳转到应用添加页面*/
    $scope.appDetailAdd = function() {
    	console.log("65");
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
    
    /*跳转到修改审核人页面*/
    $scope.approver = function() {
    	var approver = '/dpm/didirecord/approver.html?';
    	window.location.href = approver;
    }
    
    /*跳转到消息推送页面*/
    $scope.point = function() {
    	var point = '/dpm/didirecord/message_push.html?';
    	window.location.href = point;
    }
    
    /*注销*/
    $scope.logout = function(){
    	sessionStorage.clear();
    	window.location.href = '/dpm/feedback/pages/login.html';
    }
   	
});

/*上传图片*/
app.directive( "fileModel", [ "$parse", function( $parse ){
	  return {
	    restrict: "A",
	    link: function( scope, element, attrs ){
	      var model = $parse( attrs.fileModel );
	      var modelSetter = model.assign;

	      element.bind( "change", function(){
	        scope.$apply( function(){
	          modelSetter( scope, element[0].files[0] );
	          // console.log( scope );
	        } )
	      } )
	    }
	  }
	}]);