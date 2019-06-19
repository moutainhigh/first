/**
 * String对象的trim方法在某些版本浏览器下不兼容
 */
if(typeof String.prototype.trim !== 'function') {
	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, ''); 
	}
}

// 取得cookie
function getCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');    // 把cookie分割成组
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];                      // 取得字符串
		while (c.charAt(0)==' ') {          // 判断一下字符串有没有前导空格
			c = c.substring(1,c.length);      // 有的话，从第二位开始取
		}
		if (c.indexOf(nameEQ) == 0) {       // 如果含有我们要的name
			return unescape(c.substring(nameEQ.length,c.length));    // 解码并截取我们要值
		}
	}
	return false;
}

// 设置cookie
function setCookie(name, value, days) {
	days = days || 0;   // days有值就直接赋值，没有为0，这个根php不一样。
	var expires = "";
	if (days != 0 ) {      // 设置cookie生存时间
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		expires = "; expires="+date.toGMTString();
	}
	document.cookie = name+"="+escape(value)+expires+"; path=/";   // 转码并赋值
}

function constructDate(){
	var today = new Date(),
		day = today.getDay(),
		dd = today.getDate(),
		mm = today.getMonth()+1, // January is 0!
		yyyy = today.getFullYear();
	if(dd<10){dd='0'+dd;} 
	if(mm<10){mm='0'+mm;} 
	var today = yyyy+'-'+mm+'-'+dd;
	var dateString = today+'  ';
	switch(day){
	  case 0: dateString = dateString + login.i18n('foss.login.Sunday');break;
	  case 1: dateString = dateString + login.i18n('foss.login.Monday');break;
	  case 2: dateString = dateString + login.i18n('foss.login.Tuesday');break;
	  case 3: dateString = dateString + login.i18n('foss.login.Wednesday');break;
	  case 4: dateString = dateString + login.i18n('foss.login.Thursday');break;
	  case 5: dateString = dateString + login.i18n('foss.login.Friday');break;
	  case 6: dateString = dateString + login.i18n('foss.login.Saturday');break;
	}
	return dateString;
}
function bodyReady(){
	var dateTime = document.getElementById('dateTime'),
		error = document.getElementById('error'),
		loginName = document.getElementById('loginName'),
	loginNameValue = getCookie('loginName');
	if(loginNameValue){
		loginName.value = loginNameValue;		
	}
	writeErrorMessage(error.innerHTML);
	dateTime.innerHTML = constructDate();
	document.onkeydown = function(evt){
		if(window.event){
			evt = window.event;
		}
		if(evt.keyCode==13){
			loginHandler();
		}
	};
}

function loginHandler(){
	var loginName = document.getElementById('loginName'),
		password = document.getElementById('password'),
		loginForm = document.getElementById('loginForm'),
		loginNameValue = loginName.value.trim(),
		passwordValue = password.value.trim();
	loginName.value=encode64(loginNameValue);
	password.value=encode64(passwordValue);
	message = check(loginNameValue,passwordValue);
// setCookie('loginName',loginNameValue,6);
	if (!message) {
		if(login.dev){
			loginForm.action = '../login/index.action';			
		}
		loginForm.submit();
		loginName.value=loginNameValue;
		password.value=passwordValue;
	}else{
		writeErrorMessage(message);
	}
}
   
function encode64(input) { 
// base64加密开始
	var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv" 
	+ "wxyz0123456789+/" + "="; 
    var output = ""; 
    var chr1, chr2, chr3 = ""; 
    var enc1, enc2, enc3, enc4 = ""; 
    var i = 0; 
    do { 
        chr1 = input.charCodeAt(i++); 
        chr2 = input.charCodeAt(i++); 
        chr3 = input.charCodeAt(i++); 
        enc1 = chr1 >> 2; 
        enc2 = ((chr1 & 3) << 4) | (chr2 >> 4); 
        enc3 = ((chr2 & 15) << 2) | (chr3 >> 6); 
        enc4 = chr3 & 63; 
        if (isNaN(chr2)) { 
            enc3 = enc4 = 64; 
        } else if (isNaN(chr3)) { 
            enc4 = 64; 
        } 
        output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2) 
                + keyStr.charAt(enc3) + keyStr.charAt(enc4); 
        chr1 = chr2 = chr3 = ""; 
        enc1 = enc2 = enc3 = enc4 = ""; 
    } while (i < input.length); 

    return output; 
} 


function writeErrorMessage(message){
	var errorLi = document.getElementById('errorLi'),
		error = document.getElementById('error');
	if(message!=''){
		errorLi.style.display='inline';
		error.innerHTML = message;
	}else{
		errorLi.style.display='none';
	}
}

/**
 * 验证方法
 * 
 * @param logName
 *            登录名
 * @param logPwd
 *            登录密码
 * @returns message 验证信息字符串
 */
function check(logName,logPwd) {
	var message = null;
	if (logName == "" || logName == null || logName == undefined) {
		message = login.i18n('foss.login.UserNameIsNullException');
	}
	if (logPwd == '' || logPwd == null || logPwd == undefined) {
		if (message != null) {
			message = message + ','
					+ login.i18n('foss.login.LoginPasswordIsNullException');
		} else {
			message = login.i18n('foss.login.LoginPasswordIsNullException');
		}
	}
	return message;
};