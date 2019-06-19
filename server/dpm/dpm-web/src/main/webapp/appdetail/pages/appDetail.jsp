<%@ page language="java" import="java.util.*,com.deppon.dpm.module.management.shared.domain.ApplyStore;" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>应用详情录入</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/appdetail/lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/appdetail/lib/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/appdetail/css/appDetail.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/appdetail/scripts/appDetail.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/appdetail/lib/jquery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/appdetail/lib/jquery/jquery-form.js"></script>
    <script type="text/javascript">
    function load(){
    	$(".input1 select").each(function(){     
    	  $(this).find("option").eq(0).prop("selected",true)    
    	})   
    }
    </script>
</head>

<body onload="load()">
  <form id="formid" action="/dpm/dpm-management/appDetail_insertAppDetail.action" method="post" enctype="multipart/form-data">  <!-- action="/dpm/dpm-management/appDetail_insertAppDetail.action" method="post" enctype="multipart/form-data" -->
    <div id="app-detail">
    <div id="app-detail-content">
    <h2>应用详情录入</h2>
       <div class="input1">
          <label>应用名称:</label>
          <select name="appstoreId">
            <c:forEach var="app" items="${list}">
               <option value="${app.appId}" selected>${app.cnName} </option>
            </c:forEach>
          </select>
       </div>
       <div class="input2">
          <label>应用介绍:</label>
          <textarea type="text" name="appIntroduce" id="appIntroduce"></textarea>
       </div>
       <div class="input5">
          <label>新特性:</label>
          <textarea type="text" name="newFeature" id="newFeature"></textarea>
       </div>
       <div class="input3">
          <label>详细信息:</label>
          <textarea type="text" name="detailMessage" id="detailMessage">开发部门：&#10;应用对接人：</textarea>
       </div>
       <div class="input4">
          <label>图片展示:</label>
          <input type="file" name="photos" multiple="multiple" id="photos">
       </div>
    <div id="app-detail-submit">
       <button class="btn btn-success">提交</button>   <!-- type="button" onclick="submitForm()" -->
       <button class="btn btn-default" type="button" onclick="reset()">重置</button>
    </div>
    </div>
    </div>
   </form>
</body>
</html>