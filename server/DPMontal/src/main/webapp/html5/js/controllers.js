var localPagenum=5;
var widthsss;
var heightsss;
function uniqueMethod(temp,factorys,test){
    var result = [], hash = {};
    for (var i = 0, elem; (elem = temp[i]) != null; i++) {
        if (!hash[elem.ggid]) {
            if(test==0){
                if(result.length==factorys.pageSize()*localPagenum){
                    break;
                }
            }
            result.push(elem);
            hash[elem.ggid] = true;
        }
    }
    return result;
}
//function usertimeout(json,useridss,urlhistory,$http,$location){
//    var str = "\""+json+"\"";
//    if(str.indexOf("访问过期，请重新刷新或者登录APP。")>-1||str.indexOf("userisnull")>-1){
//        $http.get('../UserLoginCheckAction?controller=1&useridss='+( useridss)).success(function (json) {
//            //factorys.timeOut(json);
////    		console.log(json);
//            if(json=='success'){
//                $location.path(urlhistory);
//            }else{
//                window.location.href="../appTimeOut.jsp";
//                return;
//            }
//        });
////        window.location.href="../appTimeOut.jsp";
////        return;
//    }
//}
applicationCache.onupdateready = function(){
	applicationCache.swapCache();
    location.reload();
}
angular.module('starter.controllers', [])

/**
 * 通知列表
 */
    .controller('NoticeCtrl', function ($scope, $http,$ionicSlideBoxDelegate,$timeout,factorys,$ionicNavBarDelegate,$stateParams,$location,$ionicModal,$rootScope,localStorageTools,$ionicScrollDelegate) {
    	$scope.searchCancleHide = true;
        $scope.pageNum = 1;
        $scope.news = []; // 列表
        $scope.nullNews;
        $scope.openShow=function(){
        	$scope.buttonShow=true;
        };
        $scope.goTop=function(){
        	$ionicScrollDelegate.scrollTop();
        	$scope.buttonShow=false;
        };
        $scope.onScroll=function(){
        	var p=$ionicScrollDelegate.getScrollPosition();
        	if(p.top==0){
        		$scope.buttonShow=false;
        	}
        	
        };
            // 下拉刷新事件
        $scope.doRefresh = function (param) {
        		
        	$scope.pageNum = 1;
        	$scope.isShow=true;//显示加载框
            var searchValue  = '';
            if($scope.$$childHead!=null&&typeof($scope.$$childHead)!="undefined"){
                searchValue = $scope.$$childHead.searchValue;
            }

            if(typeof(searchValue)=="undefined"){
                searchValue='';
            }
            
            var urlhistory = '../NewToAnnouncementAction?controller=1&key='+(searchValue)+'&pageNum=1&pageSize='+  factorys.pageSize()+'&useridss='+$stateParams.useridss;
            // 通过Ajax获取信息
            $http.get(urlhistory).success(function (json) {
//                usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);
//                factorys.timeOut(json,$stateParams.userid,$stateParams.password,urlhistory,$http,$location);
            	localStorageTools.set("localList", angular.toJson(json));
            	console.log(json+"----"); 
                $scope.isShow=false;//隐藏加载框
                if(json==null||json==""||json=="userisnull"){
                    $scope.news =[];
                    $scope.pageNum=0;
                    localStorage.setItem("onotices",angular.toJson($scope.news));
                    localStorage.onewspnum = $scope.pageNum;
                    $scope.doRefresh(0);
                }else{
//                	  $scope.news = json;
//                	  localStorage.onotices=angular.toJson($scope.news);
                    if(json=="userisnull"){
                        $scope.news =[];
                        $scope.pageNum=0;
                        localStorage.onotices=angular.toJson($scope.news);
                        localStorage.noticepnum = $scope.pageNum;
                        $scope.doRefresh(0);
                    }else{
                        if(param==0){
                            $scope.news = json;
                            console.log($scope.news);
                            localStorage.onotices=angular.toJson($scope.news);
                            $scope.pageNum=1;
                            localStorage.noticepnum = $scope.pageNum;
                        }else{
                            if(json[json.length-1].ggid>localStorage.noticeid){
                                $scope.news = json;
                                localStorage.onotices=angular.toJson($scope.news);
                                $scope.pageNum=1;
                                localStorage.noticepnum = $scope.pageNum;
                            }else{
                                var temp=json.concat(JSON.parse(localStorage.getItem("onotices")));
                                $scope.news =uniqueMethod(temp,factorys,0);
                                localStorage.onotices=angular.toJson($scope.news);
                                $scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());
                                localStorage.noticepnum = $scope.pageNum;
                            }
                        }
                        localStorage.noticeid = $scope.news[0].ggid;
			// 开启加载更多
                	$scope.moreDataCanBeLoaded =true;
                    }
                }

               
                
                $ionicSlideBoxDelegate.update();
            }).error(function (data, status, headers, config) {

            }).finally(function () {
                // Stop the ion-refresher from spinning
                $scope.$broadcast('scroll.refreshComplete');
            });
            
        };
		
			//获取缓存中数据
        	var localList = localStorageTools.get("localList");
        	
        	if("[]" == localList||localList == '' || "null" == localList || null == localList || localList === undefined){
			$scope.doRefresh(0);
        	 }else{
        		 
        		 $timeout(function () {
                     
                     $scope.news = JSON.parse(localStorage.getItem("localList"));
                     $scope.$broadcast('scroll.infiniteScrollComplete');
                     $ionicSlideBoxDelegate.update();
                     // 开启加载更多
                     $scope.moreDataCanBeLoaded =true;
                     
                   //滚动 到指定位置
              		var localListScrollPos =  localStorageTools.get("noticeScroolPos");
                     console.info(localListScrollPos+"==============");
                     $ionicScrollDelegate.scrollTo(0, localListScrollPos, false);
                     
                 }, 20);
        		 
         	}
        
//        if(localStorage.getItem("onotices") == '' || localStorage.getItem("onotices") == undefined){
//            $scope.doRefresh(0);
//        }else{
//        	
        	
            var localNoticeList = localStorage.getItem("onotices");
            if(localNoticeList == null || localNoticeList == "null" || localNoticeList == '' || localNoticeList===undefined){
                $scope.doRefresh(0);
            }else{
        	
            $scope.news = JSON.parse(localNoticeList);
            $scope.pageNum = localStorage.noticepnum;
            $scope.doRefresh(1);
        }

       

        // 上拉加载更多
        $scope.loadMore = function () {
            //console.log($scope.pageNum+"---");
            /*if($scope.news==null||$scope.news==""){
             return;
             }*/
            var searchValue = '';
            if ($scope.pageNum  > 0) {
                searchValue = $scope.$$childHead.searchValue;
            }
            if(typeof(searchValue)=="undefined"){
                searchValue='';
            }
            /*	if($scope.$$childHead != null){
             searchValue = $scope.$$childHead.searchValue;
             }*/
            $scope.pageNum++;
            $scope.moreDataCanBeLoaded = false;
            var urlhistory ='../NewToAnnouncementAction?controller=1&key='+(searchValue)+'&pageNum='+($scope.pageNum)+'&pageSize='+  factorys.pageSize()+'&useridss='+$stateParams.useridss;
            $http.get(urlhistory).success(function (json) {
//                usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);
//                factorys.timeOut(json);
                if (json==""/* ||json.news.length == 0 */) {
                    // 如果没有更多信息，关闭加载更多
                    $scope.nullNews=true;
                    $scope.moreDataCanBeLoaded = false;
                    return;
                }
                $scope.news =uniqueMethod($scope.news.concat(json),factorys,1);
                if($scope.pageNum<=localPagenum){
                    localStorage.setItem("onotices",angular.toJson($scope.news));
                    localStorage.noticepnum = $scope.pageNum;
                }
                //$scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());
                $scope.moreDataCanBeLoaded = true;
               
            }).error(function (data, status, headers, config) {
                // 如果请求失败，关闭加载更多
                $scope.moreDataCanBeLoaded = false;
            });

            $scope.$broadcast('scroll.infiniteScrollComplete');
            
        };
        
        $scope.$on('stateChangeSuccess', function () {
            $scope.loadMore();
        });
        
        $scope.back=function(){
            if(window.deviceType=="IOS"){
                window.location.href="js-call://IOS/NavCallBack";
            }else{
                window.Android.closeAndroid();
            }
        }
 // 控制公告详情返回按钮
        $rootScope.noticeDetailBack=false;
 // 公告详情图片
        $ionicModal.fromTemplateUrl('pages/notice/notice_detail.html', {
            scope: $scope
        }).then(function(modal) {
            $scope.noticeDetailModal = modal;
        });
// 打开公告详情
        $scope.noticeDetailGo=function(ggid){
        	$scope.ggidd = ggid;
        	$http.get('../NewAnnouncementDetailAction?controller=1&ggId='+( $scope.ggidd)+'&unread=0').success(function (json) {
                $scope.newsDetail = json;
            }).error(function (data, status, headers, config) {
                // 如果请求失败，关闭加载更多
         	   console.log("error");
            });
            $rootScope.noticeDetailBack=true;
            $ionicScrollDelegate.$getByHandle('detailScroll').scrollTop();
            $scope.noticeDetailModal.show();
        } 
        // 关闭公告详情
        $scope.noticeToBack = function(){
            $rootScope.noticeDetailBack=false;
            $scope.noticeDetailModal.hide();
        }	
	 $scope.$on('$destroy', function() {
            //$scope.imageModal.remove();
            $scope.noticeDetailModal.remove();
        });	
        $scope.search = function(){
            $scope.doRefresh();
        }
        $scope.canceled = function(){
            $scope.$$childHead.searchValue = "";
            $scope.cancleHideShow();
        }
        $scope.searchChange = function(){
            $scope.doRefresh();
            $scope.cancleHideShow();
        }
        $scope.searchFocus = function(){
            $scope.cancleHideShow();
        }
        $scope.$on('$locationChangeStart', function(e) {
            if($rootScope.noticeDetailBack){
                $scope.noticeDetailModal.hide();
                $rootScope.noticeDetailBack=false;
                e.preventDefault();
            }
        });
        $scope.cancleHideShow = function(){

            if(typeof($scope.$$childHead.searchValue)=="undefined"){
                $scope.$$childHead.searchValue='';
            }
            if($scope.$$childHead.searchValue.length>0){
                $scope.searchCancleHide = false;
            }else{
                $scope.searchCancleHide = true;
            }
        }
    })

/**
 * 公告内容
 */
/*    .controller('NoticeDetialCtrl', function ($scope, $stateParams, $http,factorys,$ionicNavBarDelegate) {

        $scope.ggid = $stateParams.ggid;
        $http.get('../NewAnnouncementDetailAction?controller=1&ggId='+( $scope.ggid)+'&unread=0').success(function (json) {
//            factorys.timeOut(json);
            $scope.news = json;
        }).error(function (data, status, headers, config) {
            // 如果请求失败，关闭加载更多

        });
        $scope.back=function(){
            $ionicNavBarDelegate.back();
        }

    })*/



/**
 * 新闻列表
 */
    
    .controller('NewsCtrl', function ($scope, $http,$ionicSlideBoxDelegate,$timeout,factorys,$ionicNavBarDelegate,$stateParams,$location,$ionicModal,$rootScope,localStorageTools,$ionicScrollDelegate) {
    	
        $scope.imgs = []; // 图片滚动新闻
        $scope.news = []; // 列表新闻
        $scope.nullNews;
        $scope.pageNum = 1; // 增加页码
        $scope.openShow=function(){
        	$scope.buttonShow=true;
        };
        $scope.goTop=function(){
        	$ionicScrollDelegate.scrollTop();
        	$scope.buttonShow=false;
        };
        $scope.onScroll=function(){
        	var p=$ionicScrollDelegate.getScrollPosition();
        	if(p.top==0){
        		$scope.buttonShow=false;
        	}
        	
        };
        // 下拉刷新事件
        $scope.doRefresh = function (param) {
        	
            $scope.pageNum = 1;
            $scope.isShow=true;//显示加载框
            // 通过Ajax获取信息
            var urlhistory ='../NewsListHtml5Action?controller=1&pageNum=1&pageSize='+  factorys.pageSize()+'&useridss='+$stateParams.useridss;
            $http.get(urlhistory).success(function (json) {
//                usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);
//                factorys.timeOut(json);
                localStorageTools.set("newsList", angular.toJson(json));
                console.log(json+"-----------------");
                $scope.isShow=false;//隐藏加载框
                if(json==null||json==""||json=="userisnull"){
                	$scope.news =[];
                    $scope.pageNum=0;
                    localStorage.setItem("onewss",angular.toJson($scope.news));
                    localStorage.onewspnum = $scope.pageNum;
                    $scope.doRefresh(0);
                }else{
                    if(param==0){
                        $scope.news = json.news;
//		                  		  console.log($scope.news);
                        localStorage.setItem("onewss",angular.toJson($scope.news));
                        $scope.pageNum=1;
                        localStorage.onewspnum = $scope.pageNum;
                    }else{
                        if(json.news[json.news.length-1].ggid>localStorage.onewssid){
                            $scope.news = json.news;
                            localStorage.setItem("onewss",angular.toJson($scope.news));
                            $scope.pageNum=1;
                            localStorage.onewspnum = $scope.pageNum;
                        }else{
                            var temp=json.news.concat(JSON.parse(localStorage.getItem("onewss")));
                            $scope.news =uniqueMethod(temp,factorys,0);
                            localStorage.onewss=angular.toJson($scope.news);
                            $scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());
                            localStorage.onewspnum = $scope.pageNum;
                        }
                    }
                    localStorage.onewssid = $scope.news[0].ggid;
                    // 开启加载更多
                    $scope.moreDataCanBeLoaded =true;
                    
                }
                $ionicSlideBoxDelegate.update();
            }).error(function (data, status, headers, config) {

            }).finally(function () {
                // Stop the ion-refresher from spinning
                $scope.$broadcast('scroll.refreshComplete');
            });
        	
        }
			//获取缓存中数据
        	var newsList = localStorage.getItem("onewss");
        	//var newsList = localStorageTools.get("onewss");
        	if("[]" == newsList || newsList == ''|| "null" == newsList || null == newsList || newsList === undefined){
				$scope.doRefresh(0);
			}else{
				$timeout(function () {
                    
                    $scope.news = JSON.parse(localStorage.getItem("onewss"));
                    $scope.$broadcast('scroll.infiniteScrollComplete');
                    $ionicSlideBoxDelegate.update();
                    // 开启加载更多
                    $scope.moreDataCanBeLoaded =true;
                    
                    //滚动 到指定位置
             		var localListScrollPos =  localStorageTools.get("localListScroolPos");
                    console.info(localListScrollPos+"++++++++");
                    $ionicScrollDelegate.scrollTo(0, localListScrollPos, false);
                    
                }, 20);  		
			}
        /*$scope.doRefreshImgNews = function (param) {
         var a=0;
         // 通过Ajax获取信息
         var urlhistory ='../afficheManagerServlet?controller=1';
         $http.get(urlhistory).success(function (json) {
         usertimeout(json,$stateParams.userid,$stateParams.password,urlhistory,$http,$location);
         //               factorys.timeOut(resultContent.msg);
         $ionicSlideBoxDelegate.update();
         if(json==null||json==""||json=="userisnull"){
         $scope.imgs =[];
         localStorage.setItem("onewsimgs",angular.toJson($scope.imgs));
         localStorage.onewspnum = $scope.pageNum;
         a=1;
         $scope.doRefreshImgNews(0);
         }else{
         var resultContent =json.resultContent;
         resultContent = eval("("+resultContent+")");
         $scope.imgs = resultContent.msg;
         localStorage.setItem("onewsimgs",angular.toJson($scope.imgs));
         localStorage.onewspnum = $scope.pageNum;
         }
         }).error(function (data, status, headers, config) {

         }).finally(function () {
         $scope.$broadcast('scroll.refreshComplete');
         });
         if(a!=1){
         $scope.doRefresh(param);
         }
         };*/
        var localNewsList = localStorage.getItem("onewss");
        if(localNewsList == '' || localNewsList===undefined){
            $scope.doRefresh(0);
        }else{
//      	 	$scope.imgs = JSON.parse(localStorage.getItem("onewsimgs"));
            $scope.news = JSON.parse(localNewsList);
            $scope.onewspnum = localStorage.getItem("onewspnum");
            $scope.doRefresh(1);
        }

        
        // 上拉加载更多
        
        $scope.loadMore = function () {
            $scope.moreDataCanBeLoaded = false;
            $scope.pageNum++;
            var urlhistory ='../NewsListHtml5Action?controller=1&pageNum='+( $scope.pageNum)+'&pageSize='+  factorys.pageSize()+'&useridss='+$stateParams.useridss;
            $http.get(urlhistory).success(function (json) {
//                usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);

                if (json==null || json==""||json.news==null||json.news==""||json.news.length == 0) {
                    // 如果没有更多信息，关闭加载更多
                    $scope.nullNews=true;
                    $scope.moreDataCanBeLoaded = false;
                    return;
                }

                $scope.news = uniqueMethod($scope.news.concat(json.news),factorys,1);
                if($scope.pageNum<=localPagenum){
                    localStorage.setItem("onewss",angular.toJson($scope.news));
                    localStorage.onewspnum = $scope.pageNum;
                }
                // $scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());

                $scope.moreDataCanBeLoaded = true;
            }).error(function (data, status, headers, config) {
                // 如果请求失败，关闭加载更多
                $scope.moreDataCanBeLoaded = false;
            });

            $scope.$broadcast('scroll.infiniteScrollComplete');
        };

        $scope.$on('stateChangeSuccess', function () {
            $scope.loadMore();
        });

        $scope.back=function(){
            if(window.deviceType=="IOS"){
                window.location.href="js-call://IOS/NavCallBack";
            }else{
                window.Android.closeAndroid();
            }
        }
      
        
        
        // 控制新闻详情返回按钮
        $rootScope.controlDetailBack=false;
        // 新闻详情图片
        $ionicModal.fromTemplateUrl('pages/news/news_detail.html', {
            scope: $scope
        }).then(function(modal) {
            $scope.newsDetailModal = modal;
        });
        // 打开新闻详情
        $scope.newsDetailGo=function(ggid,index,filename){
        	try{
        	var localNews  = JSON.parse(localStorage.getItem("onewss"));
        	function hasClass(obj, cls) {  
            return obj.classsName.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));  
	        }  
	          
	        function addClass(obj, cls) {  
	        	obj.className += " " + cls;  
	        }  
	          
	        function removeClass(obj, cls) {  
	            if (hasClass(obj, cls)) {  
	                var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');  
	                obj.className = obj.className.replace(reg, ' ');  
	            }  
	        }  
	        if(typeof(localNews)!="undefined"){
        	for(var i=0;i<localNews.length;i++){
        		var newsItem = localNews[i];
        		if(ggid==newsItem.ggid){
        			newsItem.ckbh=1;
        			 localNews[i]=newsItem;
        			 removeClass(document.getElementById("h2id_"+ggid),"unread");
        			 addClass(document.getElementById("h2id_"+ggid),"read");
        			 removeClass(document.getElementById("pid_"+ggid),"unread");
        			 addClass(document.getElementById("pid_"+ggid),"read");
        			break;
        		}
        	}}
        	localStorage.setItem("onewss",angular.toJson(localNews));
        	}catch(e){
        		console.log("set read faied");
        	}
        	
            $rootScope.controlDetailBack=true;
            $ionicScrollDelegate.$getByHandle('detailScroll').scrollTop();
            $scope.newsDetailModal.show();
            $scope.detailggid = ggid;
            if(filename!=null){
            	$scope.detailfilename = filename;
            }
            $scope.doDetailRefresh = function(){
                $http.get('../NewOfRollNewsDetailAction?controller=1&ggid='+( $scope.detailggid)+'&unread=0&filename='+($scope.detailfilename)).success(function (json) {
//                    factorys.timeOut(json);
                    $scope.newsDetail = json;
                    localStorage.setItem((($scope.detailggid)+"xxnewsdetail"),angular.toJson($scope.newsDetail));
                    // $scope.news.filename =
                    // "http://a.hiphotos.baidu.com/image/pic/item/7af40ad162d9f2d33f7caaf2aaec8a136327ccba.jpg";
                }).error(function (data, status, headers, config) {
                    // 如果请求失败，关闭加载更多

                });
            }
            if(localStorage.getItem(($scope.detailggid)+"xxnewsdetail") == '' || localStorage.getItem(($scope.detailggid)+"xxnewsdetail") == undefined){
                $scope.doDetailRefresh();
            }else{
                $scope.newsDetail = JSON.parse(localStorage.getItem(($scope.detailggid)+"xxnewsdetail"));
            }
            //控制新闻详情图片
            $rootScope.controlDetailImageButton=false;
            //打开图片
            $ionicModal.fromTemplateUrl('imageDetail-modal.html', {
                scope: $scope
            }).then(function(modal) {
                $scope.imageModal = modal;
            });
            
            //打开新闻详情图片
            $scope.openImageModal = function() {
                $rootScope.controlDetailImageButton=true;
                $scope.imageModal.show();
                if(widthsss==null||widthsss==""){
                	widthsss = document.getElementById("notice_img").offsetWidth;
                    heightsss = document.getElementById("notice_img").offsetHeight;
                }
                $scope.picmargintop = -(heightsss/2+heightsss/6)+"px";
                $scope.picmarginleft = -(widthsss/2)+"px";
                $scope.zlz1=$ionicScrollDelegate.getScrollPosition();
            };
            //查看新闻详情图片
            $scope.showDetailImage = function(index) {
                $scope.openImageModal();
            };
            $scope.closeImageDetailModal = function() {
                $rootScope.controlDetailImageButton=false;
                $scope.imageModal.hide();
            };
        }
        
       

        // 关闭新闻详情
        $scope.newsToBack = function(){
            $rootScope.controlDetailBack=false;
            $scope.newsDetailModal.hide();
        }
        //Cleanup the modal when we're done with it!
        $scope.$on('$destroy', function() {
            //$scope.imageModal.remove();
            $scope.newsDetailModal.remove();
        });
        // Execute action on hide modal
        $scope.$on('modal.hide', function() {
        });
        // Execute action on remove modal
        $scope.$on('modal.removed', function() {
            // Execute action
        });
        $scope.$on('modal.shown', function() {
        });

        $scope.$on('$locationChangeStart', function(e) {
            if($rootScope.controlDetailImageButton){
                $scope.imageModal.hide();
                $rootScope.controlDetailImageButton = false;
                e.preventDefault();
            }else if($rootScope.controlDetailBack){
                $scope.newsDetailModal.hide();
                $rootScope.controlDetailBack=false;
                e.preventDefault();
            }
        });

    })

//
///**
// * 新闻内容
// */
//    .controller('NewsDetailCtrl', function ($scope, $stateParams, $http,factorys,$ionicNavBarDelegate,$ionicModal,$rootScope,$ionicScrollDelegate) {
//        $scope.ggid = $stateParams.ggid;
//        $scope.filename = $stateParams.filename;
//        $scope.doRefresh = function(){
//        	$http.get('../NewOfRollNewsDetailAction?controller=1&ggid='+( $scope.ggid)+'&unread=0&filename='+($scope.filename)).success(function (json) {
//        		factorys.timeOut(json);
//        		$scope.news = json;
//        		localStorage.setItem((($scope.ggid)+"xxnewsdetail"),angular.toJson($scope.news));
//        		//   $scope.news.filename = "http://a.hiphotos.baidu.com/image/pic/item/7af40ad162d9f2d33f7caaf2aaec8a136327ccba.jpg";
//        	}).error(function (data, status, headers, config) {
//        		// 如果请求失败，关闭加载更多
//        		
//        	});
//        }
//        if(localStorage.getItem(($scope.ggid)+"xxnewsdetail") == '' || localStorage.getItem(($scope.ggid)+"xxnewsdetail") == undefined){
//       	 	$scope.doRefresh();
//        }else{
//       	 	$scope.news = JSON.parse(localStorage.getItem(($scope.ggid)+"xxnewsdetail"));
//        }
//        $scope.back=function(){
//        	$ionicNavBarDelegate.back();
//        }
//        
//		
//		
//		  $scope.showImage = function(index) {
//		    $scope.openModal();
//		  };
//		  
//		  $rootScope.controlSystemBackButton=false;
//		  $ionicModal.fromTemplateUrl('image-modal.html', {
//		      scope: $scope,
//		    }).then(function(modal) {
//		      $scope.modal = modal;
//		    });
//
//		    $scope.openModal = function() {
//	            $rootScope.controlSystemBackButton=true;
//		      $scope.modal.show();
////		      var image = new Image();
//			  	var widthsss = document.getElementById("notice_img").offsetWidth;
//			  	var heightsss = document.getElementById("notice_img").offsetHeight;
//			  $scope.picmargintop = -(heightsss/2+heightsss/6)+"px";
//			  $scope.picmarginleft = -(widthsss/2)+"px";
//			  $scope.zlz1=$ionicScrollDelegate.getScrollPosition();
//			  
//		    };
//
//		    $scope.closeModal = function() {
//	            $rootScope.controlSystemBackButton=false;
//		      $scope.modal.hide();
//		    };
//
//		    //Cleanup the modal when we're done with it!
//		    $scope.$on('$destroy', function() {
//		      $scope.modal.remove();
//		    });
//		    // Execute action on hide modal
//		    $scope.$on('modal.hide', function() {
//		      // Execute action
//		    });
//		    // Execute action on remove modal
//		    $scope.$on('modal.removed', function() {
//		      // Execute action
//		    });
//		    $scope.$on('modal.shown', function() {
//		      console.log('Modal is shown!');
//		    });
//
//	        $scope.$on('$locationChangeStart', function(e) {
//	            if($rootScope.controlSystemBackButton){
//	                $scope.modal.hide();
//	                $rootScope.controlSystemBackButton = false;
//	                e.preventDefault();
//	            }
//	        });
//	        
//	        
//	        

//})

.directive('alignMiddle', function () {
    return function (scope, element, attrs) {
        console.log(element[0].offsetHeight)
    };
})

/**
 * 分割
 */
    .filter("spliteFilter", function() {
        return function(param,c){
            var str = param.split(c);
            if(str.length>1){
                str[0] = str[0]+"】";
            }else{
                str[1] = str[0];
                str[0] = '';
            }
            return str;
        }
    })
/**
 * URL中的问号转义
 */
    .filter("transform", function() {
        return function(param,c){
            var str = param;
            var rtn = "";
            for (var int = 0; int < str.length; int++) {
                if (c=="?"  ) {
                    if (str[int]==c) {
                        rtn += "|";
                        continue;
                    }
                    rtn += str[int];
                }else{
                    if(str[int]==c){
                        rtn += "?";
                        continue;
                    }
                    rtn += str[int];
                }
            }
            return rtn;
        }
    })


/**
 * 小助手
 */
    .controller('AssCtrl', function ($scope,$stateParams, $http,$ionicSlideBoxDelegate,$timeout,factorys,$location) {
        $scope.items = []; // 列表新闻
        $scope.pageNum = 1;
        $scope.nullNews;
        // 下拉刷新事件
        $scope.doRefresh = function () {
            // 通过Ajax获取信息
        	$scope.isShow=true;//显示加载框
            var urlhistory ='../ToBusAssistant?controller=1&pageNum='+1+'&pageSize='+  factorys.pageSize()+'&useridss='+$stateParams.useridss;
            $http.get(urlhistory).success(function (json) {
//                factorys.timeOut(json);
//                usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);
                $scope.isShow=false;//隐藏加载框
                if(json==null||json==""||json=="userisnull"){
                    $scope.items = []; // 列表新闻
                    $scope.pageNum = 1;
                    $scope.doRefresh();
                    return;
                }
//                console.log(json);
                $scope.items = json;

                // 开启加载更多
                $scope.moreDataCanBeLoaded =true;
                $ionicSlideBoxDelegate.update();
            }).error(function (data, status, headers, config) {

            });
        };
        $scope.doRefresh();
        // 上拉加载更多
        $scope.loadMore = function () {
            $scope.pageNum++;
            $scope.moreDataCanBeLoaded = false;
            var urlhistory ='../ToBusAssistant?controller=1&pageNum='+( $scope.pageNum)+'&pageSize='+  factorys.pageSize()+'&useridss='+$stateParams.useridss;
            $http.get(urlhistory).success(function (json) {
//                factorys.timeOut(json);
//                usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);
                if (json=="") {
                    // 如果没有更多信息，关闭加载更多
                    $scope.nullNews=true;
                    $scope.moreDataCanBeLoaded = false;
                    return;
                }
//                console.log(json);
                $scope.items =$scope.items.concat(json);
                $scope.moreDataCanBeLoaded = true;

            }).error(function (data, status, headers, config) {
                // 如果请求失败，关闭加载更多
                $scope.moreDataCanBeLoaded = false;
            });

            $scope.$broadcast('scroll.infiniteScrollComplete');
        };

        $scope.$on('stateChangeSuccess', function () {
            $scope.loadMore();
        });


        $scope.back=function(){
            if(window.deviceType=="IOS"){
                window.location.href="js-call://IOS/NavCallBack";
            }else{
                window.Android.closeAndroid();
            }
        }
    })

/**
 * 小助手Detail
 */
    .controller('AssDetialCtrl', function ($scope, $stateParams,$http,factorys,$ionicNavBarDelegate) {
        $scope.id = $stateParams.ID;
        $http.get('../ToBusAssistantDetail?controller=1&Id='+( $scope.id)).success(function (json) {
//            factorys.timeOut(json);
            $scope.item = json;
        }).error(function (data, status, headers, config) {
            // 如果请求失败，关闭加载更多

        });
        $scope.back=function(){
            $ionicNavBarDelegate.back();
        }
    })

/**
 * HMTL转义
 */
    .filter('rawHtml', ['$sce', function($sce){
        return function(val) {
            return $sce.trustAsHtml(val);
        };
    }])
/**
 * 图片
 */
    .controller('ImgCtrl', function ($scope, $stateParams,$ionicNavBarDelegate) {
        $scope.url = $stateParams.url;
        $scope.save = function(){
            // TODO
        }

        $scope.back=function(){
            $ionicNavBarDelegate.back();
        }
    })
/**
 * 自定义Search事件
 */
//    .directive('ngEnter', function () {
//        return function (scope, element, attrs) {
//            element.bind("keypress", function (event) {
//                if (event.which == 13) {
//                    scope.search();
//                }
//            });
//        };
//    })

    .factory("factorys",function(){
        return {
            timeOut:function(json){
                var str = "\""+json+"\"";
                if(str.indexOf("访问过期，请重新刷新或者登录APP。")>-1||str.indexOf("userisnull")>-1){
                    window.location.href="../appTimeOut.jsp";
                    return;
                }
            },
            pageSize:function(){
                return 5;
            }
        }
    })
    
   .directive('goTop', function($ionicScrollDelegate) {
    return {
        restrict : 'EA',
        replace : true,
        transclude : true,
//        require: ['?^$ionicScrollDelegate'],
        template : '<a id="container" class="topBtn" ng-init="buttonShow=false" ng-show="buttonShow" ng-hide="buttonHide=true" style="" ng-click="goTop()"></a>',
        link : function($scope, element) {
            element.bind('click',function(){
                $ionicScrollDelegate.scrollTop();
                $scope.buttonShow=false;
            })
        },
    }
})    
;
	    




