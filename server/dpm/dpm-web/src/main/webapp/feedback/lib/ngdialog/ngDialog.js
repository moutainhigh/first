angular.module("ngDialog", []).directive('ngdialog', [function() {
	return {
		restrict: 'E',
		transclude: true,
		template: '<div class="ngdialog {{dialog.containerClassName}}" ng-if="dialog.isShow" ng-class="{'+"'"+'ngdialog-closing'+"'"+':dialog.closing}"><div class="ngdialog-overlay"></div>' +
			'<div class="ngdialog-content" ng-class="{'+"'"+'without-btns'+"'"+':!dialog.isShowBtns}"><div class="ngdialog-message"><h3 ng-if="dialog.title">' +
			'{{dialog.title}}</h3><div ng-switch on="dialog.hasHtmlTag" class="ngdialog-wrap"><p ng-switch-when="false" ng-if="dialog.content" class="{{dialog.contentClassName}}">{{dialog.content}}</p><div ng-switch-when="true" ng-if="dialog.content" class="{{dialog.contentClassName}}" data-ng-bind-html="dialog.content"></div></div>' +
			'</div><div class="ngdialog-buttons" ng-if="dialog.isShowBtns" ng-class="{single: !dialog.isShowScondaryBtn}"><button type="button" class="ngdialog-button ngdialog-button-secondary" ng-if="dialog.isShowScondaryBtn" ng-click="dialog.close()">取消</button><button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="dialog.confirmEvent()">{{dialog.primaryBtnText}}</button></div></div></div>',
	}
}]).service('ngdialogService', ['$timeout', function($timeout) {
	var $body = angular.element(document.getElementsByTagName('body'));
	var $html = angular.element(document.getElementsByTagName('html'));
	var service = {
		isShow: false,
		closing: false,
		title: '提示',
		hasHtmlTag: false, // 是否需要html转义
		content: '',
		containerClassName: '', // 最外层容器添加class
		contentClassName: '', // 内容容器添加class
		isShowBtns: true, // 是否显示按钮
		isShowScondaryBtn: true, // 是否显示取消按钮
		primaryBtnText: '确定', // 功能按钮文本
		autoClose: false, // 是否自动关闭，默认不关闭
		duration: 2000, // 定时消失，只有当自动关闭打开后此值才有意义
		confirmEvent: null, // 确认回调函数
		closeCallback: null, //关闭回调函数
		open: function(params) {
			$body.addClass('ngdialog-open');
			$html.addClass('ngdialog-open');
			this.isShow = true;
			this.closing = false;
			for(var item in params){
				this[item] = (params[item] != undefined) ? params[item] : this[item];
			}
			if(this.autoClose){
				$timeout(function(){
					service.close();
				},this.duration);
			}
			return this;
		},
		close: function() {
			this.closing = true;
			$timeout(function() {
				service.isShow = false;
				$body.removeClass('ngdialog-open');
				$html.removeClass('ngdialog-open');
				if('function' == typeof(service.closeCallback)){
					service.closeCallback();
				}
			}, 500);
		},
		init: function(){
			this.isShow = false;
			this.closing = false;
			this.title = '提示';
			this.hasHtmlTag = false; // 是否需要html转义
			this.content = '';
			this.containerClassName = ''; // 最外层容器添加class
			this.contentClassName = ''; // 内容容器添加class
			this.isShowBtns = true; // 是否显示按钮
			this.isShowScondaryBtn = true; // 是否显示取消按钮
			this.primaryBtnText = '确定'; // 功能按钮文本
			this.autoClose = false; // 是否自动关闭，默认不关闭
			this.duration = 2000; // 定时消失，只有当自动关闭打开后此值才有意义
			this.confirmEvent = null; // 确认回调函数
			this.closeCallback = null; //关闭回调函数
		}
	};
	return service;
}]);