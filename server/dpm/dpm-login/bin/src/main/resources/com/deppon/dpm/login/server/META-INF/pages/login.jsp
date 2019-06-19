<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/ext" prefix="ext" %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="LOGIN_JSP">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--<link rel="stylesheet" type="text/css" href="${styles}/layout.css" />-->
    <style type="text/css">
          
    </style>
  </head>

  <body>
    <div class="layout">
      <div class="login_layout">
        <div class="login">
          <h2 id="dateTime" style="display: none;"></h2>
          <ul style="padding-top: 80px">
            
          </ul>
        </div>
      </div>
    </div>
  </body>
  <script type="text/javascript">
  /*   var login_server = 'http://192.168.68.117:8080'; */
    var login_server = 'https://dpm.deppon.com:8881';
    var showLoginUrl = login_server + '/dpm/dpm-management/store_listLimitTen.action';
  	
  	window.onload = function() {
  	  var xhr = null;
  	  if (window.XMLHttpRequest) {
  	    xhr = new XMLHttpRequest();
  	  } else {
  	    xhr = new ActiveXObject("Microsoft.XMLHTTP");
  	  }
  	  
  	  if (xhr) {
  	    xhr.open("GET", showLoginUrl, true);
  	    xhr.onreadystatechange = function() {
  	      if (xhr.readyState === 4 && xhr.status === 200) {
  	        // 成功
  	       
  	      }
  	    }
  	    xhr.send();  	    
  	  } 	
  	}
  </script>
</html>