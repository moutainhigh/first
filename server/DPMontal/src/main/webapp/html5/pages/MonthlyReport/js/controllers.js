var localPagenum=3;
function uniqueMethod(temp,factorys,test){
	var result = [], hash = {};
    for (var i = 0, elem; (elem = temp[i]) != null; i++) {
        if (!hash[elem.articleId]) {
        	if(test==0){
        		if(result.length==factorys.pageSize()*localPagenum){
            		break;
            	}
        	}
            result.push(elem);
            hash[elem.articleId] = true;
        }
    }
    return result;
}
function uniqueMethod2(temp,factorys,test){
	var result = [], hash = {};
    for (var i = 0, elem; (elem = temp[i]) != null; i++) {
        if (!hash[elem.periodicalId]) {
        	if(test==0){
        		if(result.length==factorys.pageSize()*localPagenum){
            		break;
            	}
        	}
            result.push(elem);
            hash[elem.periodicalId] = true;
        }
    }
    return result;
}
function usertimeout(json,useridss,urlhistory,$http,$location){
	var str = "\""+json+"\"";
    if(str.indexOf("<html")>-1||str.indexOf("访问过期，请重新刷新或者登录APP。")>-1||str.indexOf("userisnull")>-1){
    	$http.get('../../../UserLoginCheckAction?controller=1&userid='+( useridss)).success(function (json) {
            //factorys.timeOut(json);
    		console.log(json);
            if(json=='success'){
            	$location.path(urlhistory);
            }else{
            	window.location.href="../../../appTimeOut.jsp";
            	return;
            }
        });
//        window.location.href="../appTimeOut.jsp";
//        return;
    }
}
//检测缓存清单文件是否更新
applicationCache.onupdateready = function(){
	applicationCache.swapCache();
    location.reload();
}
angular.module('starter.controllers', [])

/**
 * 期刊列表
 */
    .controller('QikanCtrl', function ($scope, $stateParams,$http,$ionicSlideBoxDelegate,factorys,$location) {
    	 $scope.pageNum = 1;
         $scope.news = []; // 列表
         $scope.nullNews;
//         $scope.userid=$stateParams.userid;
//         $scope.password=$stateParams.password;
//         localStorage.clear();
         $scope.doRefresh=function(param){
        	 $scope.pageNum = 1;
        	 var urlhistory = '../../../MonthPeriodicalAction?controller=1&pageNum='+$scope.pageNum+'&pageSize='+factorys.pageSize();
        	 $http.get(urlhistory).success(function (json) {
        		 /*if(factorys.timeOut(json)){
        			 return;
        		 }*/
        		 usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);
        		 if(json==""||json==null||json=="userisnull"||json.qikan==null||json.qikan==""){
		        	  $scope.news = [];
		        	  $scope.pageNum=0;
         			  localStorage.qikan=angular.toJson($scope.news);
                 	  localStorage.qkpnum = $scope.pageNum;
                 	  $scope.nullNews=true;
		        	  $scope.doRefresh(0);
		         }else{
		        	 if(param==0){
		        		  $scope.news = json.qikan;
//	               		  console.log($scope.news);
	               		  localStorage.qikan= angular.toJson($scope.news);
		            	  localStorage.qkpnum = $scope.pageNum;
	                   	  $scope.pageNum=1;
		           	  }else{
		           		  if(json.qikan[json.qikan.length-1].periodicalId>localStorage.qkqid){
		           			  $scope.news = json.qikan;
		           			  localStorage.qikan=angular.toJson($scope.news);
		           			  $scope.pageNum=1;
		           			  localStorage.qkpnum = $scope.pageNum;
		           		  }else{
		           			  var temp=json.qikan.concat(JSON.parse(localStorage.getItem("qikan")));
//		           			  console.log(temp+"*********");
		           			  $scope.news =uniqueMethod2(temp,factorys,0);
		           			  localStorage.qikan=angular.toJson($scope.news);
		           			  $scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());
		           			  localStorage.qkpnum = $scope.pageNum;
		           		  }
		           	  }
		           	  localStorage.qkqid = $scope.news[0].periodicalId;
//		           	  console.log(localStorage.qkqid);
//		            	 $scope.news = json.qikan;
		            	 $ionicSlideBoxDelegate.update();
//		            	 localStorage.qikan= angular.toJson($scope.news);
//		            	 localStorage.qkpnum = $scope.pageNum;
		         }
//		         console.log($scope.news.length+"---yuebao");
		    }).error(function (data, status, headers, config) {
		        	
		    }).finally(function () {
		            // Stop the ion-refresher from spinning
		         $scope.$broadcast('scroll.refreshComplete');
		    });
         }
//         console.log(localStorage.qikan+'local');
         if(localStorage.qikan == '' || localStorage.qikan == undefined){
        	 $scope.doRefresh(0);
         }else{
        	 $scope.news = JSON.parse(localStorage.qikan);
        	 $scope.pageNum = localStorage.qkpnum;
        	 $scope.doRefresh(1);
         }
        $scope.slideChange =function(index){
        	if(index==(($scope.pageNum-1)*2+1)){
        		$scope.pageNum++ ;
        		var urlhistory = '../../../MonthPeriodicalAction?controller=1&pageNum='+($scope.pageNum)+'&pageSize='+factorys.pageSize();
        		$http.get(urlhistory).success(function (json) {
//                	factorys.timeOut(json);
           		 usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);

                	if(json==""||json==null||json.qikan==null||json.qikan==""){
                    	$scope.news =[];
                  	    $scope.nullNews=true;
                        return;
                    }else{
                    	$scope.news =uniqueMethod2($scope.news.concat(json.qikan),factorys,1);
//                    	 $scope.news = $scope.news.concat(json.qikan);
                    	 if($scope.pageNum<=3){
                    		 localStorage.qikan=angular.toJson($scope.news);
                    		 localStorage.qkpnum = $scope.pageNum;
                    	 }
                    	 $scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());
                    }
                    $ionicSlideBoxDelegate.update();
                }).error(function (data, status, headers, config) {
                	
                }).finally(function () {
                    // Stop the ion-refresher from spinning
                    $scope.$broadcast('scroll.refreshComplete');
                });
        	}
        };

        $scope.back=function(){
            if(window.deviceType=="IOS"){
                window.location.href="js-call://IOS/NavCallBack";
            }else{
                window.Android.closeAndroid();
            }
        }
      
    })
 /**
	 * 版块列表
	 */
    .controller('NewsCtrl', function ($scope, $stateParams, $http,$ionicSlideBoxDelegate,$ionicNavBarDelegate,factorys,$location) {
    	 $scope.pageNum = 1;
         $scope.news = []; // 列表
         $scope.pid = $stateParams.id;
         $scope.nullNews;
//         $scope.newspics = [];
        // 下拉刷新事件
        $scope.doRefresh = function (param) {
        	$scope.pageNum = 1;
        	// 通过Ajax获取信息
        	var urlhistory='../../../MonthPaperAction?controller=1&pid='+( $scope.pid)+'&pageNum='+$scope.pageNum+'&pageSize='+factorys.pageSize();
            $http.get(urlhistory).success(function (json) {
//            	factorys.timeOut(json);
          		 usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);
//                console.log(json+"--news--");
                if(json==""||json==null||json.wenzhang==null||json.wenzhang==""){
                	  $scope.news =[];
                	  $scope.nullNews=true;
                      $scope.moreDataCanBeLoaded = false;
                      return;
                }else{
                	if(json=="userisnull"){
            			  $scope.news =[];
//            			  $scope.newspics = [];
            			  $scope.pageNum=0;
            			  localStorage.setItem((($scope.pid)+"qknews"),angular.toJson($scope.news));
//                    	  localStorage.setItem((($scope.pid)+"qknewspics"),angular.toJson($scope.newspics));
                    	  localStorage.qknewspnum = $scope.pageNum;
                    	  $scope.doRefresh(0);
            		}else{
	                  	  if(param==0){
//	                  		  $scope.newspics = json.picwenzhang;
	                  		  $scope.news = json.wenzhang;
	                  		  localStorage.setItem((($scope.pid)+"qknews"),angular.toJson($scope.news));
//	                  		  localStorage.setItem((($scope.pid)+"qknewspics"),angular.toJson($scope.newspics));
	                  		  $scope.pageNum=1;
	                  		  localStorage.qknewspnum = $scope.pageNum;
//	                  			  $scope.news = json; 
//	                      		  console.log($scope.news);
//	                          	  localStorage.onotices=angular.toJson($scope.news);
	                          	  
//	                          	  localStorage.noticepnum = $scope.pageNum;
	                  	  }else{
//	                  		  $scope.newspics = json.picwenzhang;
//	                  		  localStorage.setItem((($scope.pid)+"qknewspics"),angular.toJson($scope.newspics));
	                  		  if(json.wenzhang[json.wenzhang.length-1].ggid>localStorage.qknewsid){
	                  			  $scope.news = json.wenzhang;
	                  			 localStorage.setItem((($scope.pid)+"qknews"),angular.toJson($scope.news));
	                  			  $scope.pageNum=1;
	                  			localStorage.qknewspnum = $scope.pageNum;
	                  		  }else{
	                  			  var temp=json.wenzhang.concat(JSON.parse(localStorage.getItem((($scope.pid)+"qknews"))));
	                  			  $scope.news =uniqueMethod(temp,factorys,0);
	                  			  localStorage.setItem((($scope.pid)+"qknews"),angular.toJson($scope.news));
	                  			  $scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());
	                  			  localStorage.qknewspnum = $scope.pageNum;
	                  		  }
	                  	  }
	                  	  localStorage.qknewsid = $scope.news[0].articleId;
            		}
                	  /*$scope.newspics = json.picwenzhang;
                	  $scope.news = json.wenzhang;
                	  localStorage.setItem((($scope.pid)+"qknews"),angular.toJson($scope.news));
                	  localStorage.setItem((($scope.pid)+"qknewspics"),angular.toJson($scope.newspics));
                	  localStorage.qknewspnum = $scope.pageNum;*/
                }
                 $ionicSlideBoxDelegate.update();
                // 开启加载更多
                if(json.noMoreData!=null&&json.noMoreData=="no"){
                	$scope.moreDataCanBeLoaded =false;
                }else{
                	$scope.moreDataCanBeLoaded =true;
                }
            }).error(function (data, status, headers, config) {

            }).finally(function () {
                // Stop the ion-refresher from spinning
                $scope.$broadcast('scroll.refreshComplete');
            });
        };
        if(localStorage.getItem(($scope.pid)+"qknews") == '' || localStorage.getItem(($scope.pid)+"qknews") == undefined){
       	 	$scope.doRefresh(0);
        }else{
       	 	$scope.news = JSON.parse(localStorage.getItem(($scope.pid)+"qknews"));
//       	 	$scope.newspics = JSON.parse(localStorage.getItem(($scope.pid)+"qknewspics"));
       	 	$scope.pageNum = localStorage.qknewspnum;
       	    $scope.doRefresh(1);
        }
// //上拉加载更多
        $scope.loadMore = function () {
        	if($scope.news==null||$scope.news==""){
        		return;
        	}
            $scope.pageNum++;
            $scope.moreDataCanBeLoaded = false;
            var urlhistory='../../../MonthPaperAction?controller=1&pid='+( $scope.pid)+'&pageNum='+($scope.pageNum)+'&pageSize='+factorys.pageSize();
            $http.get(urlhistory).success(function (json) {
//            	factorys.timeOut(json);
         		 usertimeout(json,$stateParams.useridss,urlhistory,$http,$location);

            	if (json==""/* ||json.news.length == 0 */) {
                    // 如果没有更多信息，关闭加载更多
                    $scope.moreDataCanBeLoaded = false;
                    return;
                }
                $scope.news =uniqueMethod($scope.news.concat(json.wenzhang),factorys,1);

//                $scope.news = $scope.news.concat(json.wenzhang);
                if($scope.pageNum<=3){
                	localStorage.setItem((($scope.pid)+"qknews"),angular.toJson($scope.news));
              	  	localStorage.qknewspnum = $scope.pageNum;
                }
                $scope.pageNum=Math.ceil($scope.news.length/factorys.pageSize());
                if(json.noMoreData!=null&&json.noMoreData=="no"){
                	$scope.moreDataCanBeLoaded =false;
                }else{
                	$scope.moreDataCanBeLoaded =true;
                }
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
        	$ionicNavBarDelegate.back();
        }
      
    })
    /**
	 * 版块列表
	 */
    .controller('LayoutCtrl', function ($scope, $stateParams, $http,$timeout,$ionicNavBarDelegate,factorys) {
         $scope.news = []; // 列表
         $scope.pid = $stateParams.id;
         $scope.nullLayout;
         $scope.nullNews;
         $scope.news2 = []; // 列表
         $scope.pageNum=1;
         $scope.layoutId;
        // 下拉刷新事件
        $scope.doRefresh = function () {
        	// 通过Ajax获取信息
            $http.get('../../../MonthPlayoutAction?controller=1&pid='+( $scope.pid)+'&pageNum='+($scope.pageNum)+'&pageSize='+factorys.pageSize()).success(function (json) {
            	factorys.timeOut(json);
                if(json==""||json==null||json.layout==null||json.layout==""){
                	  $scope.news =[];
                	  $scope.nullLayout=true;
                      return;
                }else{
                	  $scope.news = json.layout;
                	  $scope.activedIndex = 0;
                }
                if(json==""||json==null||json.news==null||json.news==""){
              	  	$scope.news2 =[];
              	  	$scope.nullNews=true;
                    $scope.moreDataCanBeLoaded = false;
                    return;
                }else{
              	   	$scope.news2 = json.news;
                }
                $scope.layoutId =  json.layoutId;
                if(json.noMoreData!=null&&json.noMoreData=="no"){
                	$scope.moreDataCanBeLoaded =false;
                }else{
                	$scope.moreDataCanBeLoaded =true;
                }
            }).error(function (data, status, headers, config) {

            }).finally(function () {
                // Stop the ion-refresher from spinning
                $scope.$broadcast('scroll.refreshComplete');
            });
        };
        $scope.loadMore = function () {
        	if($scope.news2==null||$scope.news2==""){
        		return;
        	}
            $scope.pageNum++;
            $scope.moreDataCanBeLoaded = false;
            $http.get('../../../MonthPaperBylayoutAction?controller=1&pid='+( $scope.pid)+'&layoutId='+( $scope.layoutId)+'&pageNum='+($scope.pageNum)+'&pageSize='+factorys.pageSize()).success(function (json) {
            	factorys.timeOut(json);
                if (json==""/* ||json.news.length == 0 */) {
                    // 如果没有更多信息，关闭加载更多
                    $scope.moreDataCanBeLoaded = false;
                    return;
                }
                $scope.news2 = $scope.news2.concat(json.news);
                if(json.noMoreData!=null&&json.noMoreData=="no"){
                	$scope.moreDataCanBeLoaded =false;
                }else{
                	$scope.moreDataCanBeLoaded =true;
                }
            }).error(function (data, status, headers, config) {
                // 如果请求失败，关闭加载更多
                $scope.moreDataCanBeLoaded = false;
            });

            $scope.$broadcast('scroll.infiniteScrollComplete');
        };
        $scope.$on('stateChangeSuccess', function () {
            $scope.loadMore();
        });
        $scope.switchMonth = function(layoutId,index){
        	$timeout(function(){
            	$scope.activedIndex = index;
        	},150);
        	if(layoutId!=$scope.layoutId){
        		$scope.pageNum=1;
        	}
        	$scope.layoutId = layoutId;
        	// target.addClass( 'item activated' );
        	 $http.get('../../../MonthPaperBylayoutAction?controller=1&pid='+( $scope.pid)+'&layoutId='+($scope.layoutId)+'&pageNum='+($scope.pageNum)+'&pageSize='+factorys.pageSize()).success(function (json) {
             	factorys.timeOut(json);
                 if(json==""||json==null||json.news==null||json.news==""){
               	  	$scope.news2 =[];
               	  	$scope.nullNews=true;
                    $scope.moreDataCanBeLoaded = false;
                    return;
                 }else{
               	   	$scope.news2 = json.news;
                 }
                 if(json.noMoreData!=null&&json.noMoreData=="no"){
                 	$scope.moreDataCanBeLoaded =false;
                 }else{
                 	$scope.moreDataCanBeLoaded =true;
                 }
             }).error(function (data, status, headers, config) {

             }).finally(function () {
                 // Stop the ion-refresher from spinning
                 $scope.$broadcast('scroll.refreshComplete');
             });
        };
        
        $scope.back=function(){
        	$ionicNavBarDelegate.back();
        }
      
    })
/**
 * 新闻内容
 */
    .controller('NewsDetailCtrl', function ($scope, $stateParams, $http,$ionicNavBarDelegate) {
        $scope.id = $stateParams.id;
        $scope.doRefresh = function (){
        	 $http.get('../../../MonthPaperDetailAction?controller=1&id='+( $scope.id)).success(function (json) {
                 $scope.news = json;
                 localStorage.setItem((($scope.id)+"newsdetail"),angular.toJson($scope.news));
             }).error(function (data, status, headers, config) {
                 // 如果请求失败，关闭加载更多

             });
        }
        if(localStorage.getItem(($scope.id)+"newsdetail") == '' || localStorage.getItem(($scope.id)+"newsdetail") == undefined){
       	 	$scope.doRefresh();
        }else{
       	 	$scope.news = JSON.parse(localStorage.getItem(($scope.id)+"newsdetail"));
        }
       
        $scope.back=function(){
        	$ionicNavBarDelegate.back();
        }
    })
    .controller('MainCtrl', function ($scope, $ionicSideMenuDelegate) {
    	$scope.toggleLeft = function() {
    		 $ionicSideMenuDelegate.toggleLeft();
    	};
    })
/**
 * HMTL转义
 */
    .filter('rawHtml', ['$sce', function($sce){
        return function(val) {
            return $sce.trustAsHtml(val);
        };
    }])
    
.factory("factorys",function(){
    return {
        timeOut:function(json){
            var str = "\""+json+"\"";
            if(str.indexOf("<html")>-1){
                window.location.href="../../../appTimeOut.jsp";
                return true;
            }
        },
        pageSize:function(){
        	return 2;
        }
    }
})
;
