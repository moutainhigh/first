<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="appDetail">
<head>
   <meta http-equiv="Access-Control-Allow-Origin" content="*">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/appdetail/lib/bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/appdetail/lib/font-awesome-4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/appdetail/css/appDetailList.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/appdetail/lib/angular/angular.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/appdetail/js/appdetailController.js"></script>
   <title>应用商店后台</title>
</head>
<body ng-controller="appDetailCtl">

  <!-- 菜单栏 -->
  <div class="header">
      <div class="w990">   
       <div class="head-nav">
          <ul>
             <li ng-click="feedback()"><a href="#" id="menu-send">意见反馈</a></li>
             <li ng-click="searchData()"><a href="#">应用详情</a></li>
              <li ng-if="uid==265564"><a href="" id="menu-track">德邦欢行 <i class="fa fa-angle-down fa-lg"></i></a>
                  <ul>
                      <li ng-click="recordList()"><a href="#">欢行备案</a></li>
                      <li ng-click="upPhone()"><a href="#">欢行手机号</a></li>
                      <li ng-click="account()"><a href="#">欢行对账</a></li>
                      <li ng-click="approver()"><a href="#">修改审核人</a></li>
                      <li ng-click="point()"><a href="#">提示推送</a></li>
                  </ul>
              </li>
          </ul> 
       </div>
       <a href="" class="btn-default btn-loginout" ng-click="logout()">注销</a>
       <div class="head-uid">
         <i class="fa fa-user fa-2x"></i>
         <span>{{uid}}</span>
       </div>
    </div>
  </div> 
  
  <!--展示列表-->
  <div class="dp-panel">
    <div class="dp-panel-list">
        <!-- 新增按钮 -->
        <div class="dp-add-button" ng-if="uid==265564">
            <button class="btn btn-info" ng-click="insertBox()">添加</button>
        </div>
        <!-- 详情列表 -->
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>应用名称</th>
                <th>应用介绍</th>
                <th>详细信息</th>
                <th>APP图片</th>
                <th>新特性</th>
                <th>更新时间</th>
                <th>处理</th>
            </tr>
            </thead>
            <tr ng-repeat="item in recoders">
                <td class="td-width-100"><span>{{item.appName}}</span></td>
                <td class="td-width-240"><span>{{item.appIntroduce}}</span></td>
                <td class="td-width-160"><span>{{item.detailMessage}}</span></td>
                <td class="td-width-80 td-pic">
                    <a ng-if="item.appPhoto!='' && item.appPhoto!=undefined" ng-click="showImg(item)">查看</a>
                    <span ng-if="item.appPhoto==''||item.appPhoto==undefined">-</span>
                </td>
                <td class="td-width-160"><span>{{item.newFeature}}</span></td>
                <td class="td-width-100"><span>{{item.updateTime}}</span></td>
                <td class="td-width-60">
                    <button class="btn btn-success button-update" ng-click="updateBox(item)">修改</button>        
                </td>
            </tr>
        </table>
    </div>
    </div>
    
    <div style="height:30px">  </div>
    
    
    <!-- 新增 -->
    <div class="dp-box-show" ng-show="iboxHidden">
       <div class="dp-add-content">
			<div class="div-content-title">应用详情录入</div>
			<div class="box-perdiv">
				<label>应用商店:</label> 
				<select ng-model="selectedApp" ng-options="y.cnName for (x, y) in applist"></select> 
				<input type="hidden" ng-model="selectedApp.appId">
				<input type="hidden" ng-model="selectedApp.cnName">
			</div>
			<div class="box-perdiv">
				<label>应用介绍:</label>
				<textarea class="textarea-align" ng-model="appintroduce"></textarea>
			</div>
			<div class="box-perdiv">
				<label>详细信息:</label>
				<textarea class="textarea-align detail-height" ng-model="detailmessage"></textarea>
			</div>
			<div class="box-perdiv">
				<label class="box-div-label">新特性:</label>
				<textarea class="textarea-align" ng-model="newfeature"></textarea>
			</div>
			<div class="box-perdiv">
				<label>APP图片:</label> 
				<!-- <input type="file" id="fileupload" multiple file-model="filetoupload" > -->
				<input type="file" id="fileupload" multiple>
			</div>
			<div class="dp-addbox-button">
				<button ng-click="submitiBox()" class="btn btn-success box-button">提交</button>
				<button ng-click="closeBox()" class="btn btn-default box-button button-gray">取消</button>
			</div>
		</div>  
    </div>
    
    <!--修改-->
    <div class="dp-box-show" ng-show="boxHidden">
    <div class="dp-add-content">
        <div class="div-content-title">修改应用详情</div>
        <div class="box-perdiv">
            <label>应用商店:</label>
            <input readonly ng-model="appName">
            <input type="hidden" ng-model="id">
        </div>
        <div class="box-perdiv">
            <label>应用介绍:</label>
            <textarea class="textarea-align" ng-model="appIntroduce"></textarea>
        </div>
        <div class="box-perdiv">
            <label>详细信息:</label>
            <textarea class="textarea-align detail-height" ng-model="detailMessage"></textarea>
        </div>
        <div class="box-perdiv">
            <label class="box-div-label">新特性:</label>
            <textarea class="textarea-align" ng-model="newFeature"></textarea>
        </div>
        <div class="box-perdiv">
            <label>APP图片:</label>
            <input type="file" id="fileToUpload" multiple>
        </div>
        <div class="box-perdiv">
            <label>应用对接人:</label>
            <textarea class="textarea-align manager-height" ng-model="appManager"></textarea>
        </div>
        <div class="dp-addbox-button">
          <button ng-click="submitBox()" class="btn btn-success box-button">提交</button>
          <button ng-click="closeBoxDetail()" class="btn btn-default box-button button-gray">取消</button>
        </div>
    </div> 
    </div>

	<!-- 图片 -->
	<div class="dp-box-show" ng-show="imgHidden">
	<div class="img-position">
		<div class="dp-img-detail">
			<img src="{{imgPath}}" />
		</div>
		<button ng-click="preImg()" class="btn btn-success img-button-pre">上一张</button>
		<button ng-click="nextImg()" class="btn btn-success img-button-next">下一张</button>
		<button ng-click="closeImgShow()" class="btn btn-default img-button-close">关闭</button>
	</div>
	</div>
</body>
</html>