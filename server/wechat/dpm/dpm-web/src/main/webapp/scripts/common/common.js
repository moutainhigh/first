// 此函数返回顶部工具栏控件的组件数组，数组的顺序就是组件显示的顺序
//function getFrameToolbarItems() {
//	return [
//      { xtype:'muserinfospace' }, // 用户信息按钮
//		{ xtype:'mannounceLink' }, // 通知按钮
//		{ xtype:'mhomeLink' }, // 主页按钮
//		{ xtype:'mnavConfigLink' }, // 常用功能按钮
//		{ xtype:'mlogout' } // 登出按钮
//		// { xtype:'mybutton' }  // 添加自定义的组件
//	];
//}

Date.prototype.format = function(format){ 
    var o =  { 
    "M+" : this.getMonth()+1, //month 
    "d+" : this.getDate(), //day 
    "h+" : this.getHours(), //hour 
    "m+" : this.getMinutes(), //minute 
    "s+" : this.getSeconds(), //second 
    "q+" : Math.floor((this.getMonth()+3)/3), //quarter 
    "S" : this.getMilliseconds() //millisecond 
    };
    if(/(y+)/.test(format)){ 
    	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    }
    for(var k in o)  { 
	    if(new RegExp("("+ k +")").test(format)){ 
	    	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	    } 
    } 
    return format; 
};