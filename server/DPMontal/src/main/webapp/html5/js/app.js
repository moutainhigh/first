// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
angular.module('starter', ['ionic', 'starter.controllers','starter.services'])
    .run(function ($ionicPlatform) {
        $ionicPlatform.ready(function () {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            if (window.cordova && window.cordova.plugins.Keyboard) {
                cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
            }
            if (window.StatusBar) {
                StatusBar.styleDefault();
            }
        })
    })

    .config(function ($stateProvider, $urlRouterProvider) {

        // Ionic uses AngularUI Router which uses the concept of states
        // Learn more here: https://github.com/angular-ui/ui-router
        // Set up the various states which the app can be in.
        // Each state's controller can be found in controllers.js
        $stateProvider

            .state('news', {
                url: '/news/:useridss',
                templateUrl: 'pages/news/news.html',
                controller: 'NewsCtrl'
            })
//             .state('newsDetail', {
//                url: '/newsDetail/:ggid/:unread/:filename',
//                templateUrl: 'pages/news/news_detail.html',
//                controller: 'NewsDetailCtrl'
//            })
            .state('img', {
                url: '/img/{url:.*}',
                templateUrl: 'pages/news/img.html',
                controller: 'ImgCtrl'
            })
              .state('notice', {
            	url: '/notice/:useridss',
            	templateUrl: 'pages/notice/notice.html',
                controller: 'NoticeCtrl'
            })
             .state('noticeDetail', {
            	url: '/noticeDetail/:ggid',
            	templateUrl: 'pages/notice/notice_detail.html',
                controller: 'NoticeDetialCtrl'
            })
             .state('ass', {
            	url: '/ass/:useridss',
            	templateUrl: 'pages/ass/ass.html',
                controller: 'AssCtrl'
            })
             .state('assDetail', {
            	url: '/assDetail/:ID',
            	templateUrl: 'pages/ass/ass_detail.html',
                controller: 'AssDetialCtrl'
            })
;
        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/notice/*');

    });