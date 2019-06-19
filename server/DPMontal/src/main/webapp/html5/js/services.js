 angular.module('starter.services', [])
	.service("localStorageTools",function(){
	    return {
	    get: function (key) {
	        return localStorage.getItem(key);
	    },
	    set:function (key, value) {
	        return localStorage.setItem(key, value);
	    },
	    remove :function (key) {
	        return localStorage.removeItem(key);
	    },
	    removeAll : function () {
	        return localStorage.clear();
	    }
	}
	})
	//监听 公告滚动事件
    .directive('whenScrolled',function(localStorageTools,$ionicScrollDelegate){
        
    	return function($scope,elm,attr){
            var raw = elm[0];
            //事件绑定
            elm.bind('scroll',function(){
            	
            	//得到滚动高度
                var localTops = $ionicScrollDelegate.getScrollPosition().top || $ionicScrollDelegate.getScrollView().__scrollTop;
                //滚动条高度 放入缓存
                localStorageTools.set("noticeScroolPos",localTops);
            	//存入缓存 数据
                localStorageTools.set("localList", angular.toJson($scope.news));
                //console.info(localTops);
            });
        }
    })
    //监听 新闻滚动事件
    .directive('whenNewsScrolled',function(localStorageTools,$ionicScrollDelegate){
        
    	return function($scope,elm,attr){
            var raw = elm[0];
            //事件绑定
            elm.bind('scroll',function(){
            	
            	//得到滚动高度
                var localTops = $ionicScrollDelegate.getScrollPosition().top || $ionicScrollDelegate.getScrollView().__scrollTop;
                //滚动条高度 放入缓存
                localStorageTools.set("localListScroolPos",localTops);
            	//存入缓存 数据
                localStorageTools.set("newsList", angular.toJson($scope.news));
                
            });
        }
    })
    
    /**
 * 加载框组件
 */
    .directive('loadCompent', function () {
        return {
            restrict: 'EA',
            compile: function (tElement, tAttrs) {
                tElement
                    .append(
                        '<div ng-show="' + tAttrs.loadCompent + '" class="backdrop" style="visibility:visible;opacity:1">' +
                        '<div class="loading-container visible active" style="opacity:1;">' +
                        '<div class="loading" style="opacity: 1;">' +
                        '<div style="border-radius:5px;text-align:center;">' +
                        '<img src="css/images/loadss.gif" class="load-img">' +
                        '<p style="text-align:center;margin-top:10px;">加载中，请稍后..</p></div>' +
                        '</div>' +
                        '</div>' +
                        '</div>'
                );
            }
        };
    })
;
