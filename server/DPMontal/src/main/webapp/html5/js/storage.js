//临时存储
var TempCache = {
	cache:function(value){
		sessionStorage.setItem("EasyWayTempCache",value);
	},
	getCache:function(){
		return  sessionStorage.getItem("EasyWayTempCache");
	},
	setItem:function(key,value){
		sessionStorage.setItem(key,value);
	},
	getItem:function(key){
		return sessionStorage.getItem(key);
	},
	removeItem:function(key){
		return sessionStorage.removeItem(key);
	}
};