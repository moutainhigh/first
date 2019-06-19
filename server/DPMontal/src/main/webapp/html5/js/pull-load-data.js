
(function pullPagePullImplementation($) {
  "use strict";
  var pullDownGeneratedCount = 0,
      pullUpGeneratedCount = 0,
      listSelector = "div.pull-demo-page ul.ui-listview",
      lastItemSelector = listSelector + " > li:last-child";
    
  /**
	 * 下拉数据处理函数
	 */
	  function gotPullDownData(event, data) {
		var i, newContent = "";
		// TEST
		for (i = 0; i < 3; i += 1) { // Generate some fake new content
			newContent = "<li  class='ui-btn ui-btn-icon-right ui-icon-carat-r'>Pull 下拉 "
					+ (++pullDownGeneratedCount) + "</li>" + newContent;
		}
		// newContent 就是我们要现实的内容
		$(listSelector).prepend(newContent).listview("refresh"); 
		data.iscrollview.refresh(); 
	}
  

	  function gotPullUpData(event, data) {
		var i, iscrollview = data.iscrollview;
		query();
	//  这里可以通过下面一行来现实数据 到listview, 因在query()中已完成现实, 所以这里不再需要
		//$(listSelector).append(newContent).listview("refresh");
		iscrollview.refresh(null, null, $.proxy(function afterRefreshCallback(
				iscrollview) {
			this.scrollToElement(lastItemSelector, 400);
		}, iscrollview));
	}
  
	// 回调,就是当用户已经完成了
		// 下拉的姿势。
		// 你的代码应该开始从服务器检索数据,本地数据库等。
		// 一般情况下,你会调用某些函数像jQuery.ajax(),这将使一个回调
		// 一次数据检索。
		// 演示,我们只使用超时来模拟完成操作所需的时间。
 function onPullDown(event, data) {
		setTimeout(function fakeRetrieveDataTimeout() {
			gotPullDownData(event, data);
		}, 1500);
	}    

 // 当用户完成向上拉的动作调用。
	 function onPullUp(event, data) {
		setTimeout(function fakeRetrieveDataTimeout() {
			gotPullUpData(event, data);
		}, 1500);
	}    
  
	 //设置jQuery事件回调
  $(document).delegate("div.pull-demo-page", "pageinit", 
    function bindPullPagePullCallbacks(event) {
      $(".iscroll-wrapper", this).bind( {
      iscroll_onpulldown : onPullDown,
      iscroll_onpullup   : onPullUp
      } );
    } );  

  }(jQuery));
