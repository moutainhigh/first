angular.module('wechatApp', ['ionic','wechatApp.login','wechatApp.sysUserInfo'])
//路由跳转设置
.config(['$stateProvider', '$urlRouterProvider', '$ionicConfigProvider', function ($stateProvider, $urlRouterProvider, $ionicConfigProvider) {
	//主界面 
	$stateProvider
	  	.state('wechatLogin', {
	      url: '/wechatLogin',
	      controller: 'loginCtl',
	      templateUrl: './wechatLogin.html'
	    })
	
	 
	 //信息同步界面 普通用户
	$stateProvider
  	.state('sysUserInfo', {
//      url: '/sysUserInfo?userId&password',
  	  url: '/sysUserInfo?userId',
      controller: 'sysUserInfoCtl',
      templateUrl: './sysUserInfo.html'
    })
	 
     //信息同步界面 超级管理员
	$stateProvider
  	.state('sysUserInfoSuper', {
//      url: '/sysUserInfo?userId&password',
  	  url: '/sysUserInfoSuper?userId',
      controller: 'sysUserInfoCtl',
      templateUrl: './superSysUserInfo.html'
    })
	    
    
    $urlRouterProvider.otherwise('/wechatLogin'); 
}]);
