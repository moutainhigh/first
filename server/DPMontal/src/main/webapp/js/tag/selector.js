/**
 * 请求后台获得查询结果集合
 * @param selectorView-传输媒介整个选择器界面对象
 * @param loadType-改参数用来区分是追加文档内容还是清空后追加
 */
function getQueryDataList(selectorView,loadType) {
	var params = getQueryParam (selectorView);//构建查询参数
	params.timestamp = new Date().getTime();//这个是为了每次都发送新的请求到后台
	selectorView.children("div.tac").addClass("loadingbox").find("span").text("正在加载请稍后。。。");//处理查询显示
	$.ajax({
		   type: "POST",
		   url: selectorView.get(0).selectorModel.store.url,
		   data:params,
		   cache:false,
		   success: function(jsonStr){
			   if(jsonStr != '' && jsonStr != null){
				   var json = null;
					try {
						json = eval('(' + jsonStr + ')');
					} catch(e) {
						json = jsonStr;
					}
					var selectorList = eval('(' + json.selectorList + ')');
					if (selectorList.length > 0) {

						var s = createDataLiView(selectorList,selectorView.get(0).selectorModel.dataModel.fields,selectorView.get(0).selectorModel.store.selectorType);
						selectorView.get(0).totalCount = parseInt(json.totalCount);
						appendDataList(s,loadType,selectorView.get(0));
						var flag = canLoadMore(selectorView);
						changeLoadingDiv(flag,selectorView);
						//显示
						showSelectorView(selectorView);
					}else{
						$(selectorView).find("ul.list_tdd").find("li").remove();
						changeLoadingDiv(false,selectorView);
						//显示
						showSelectorView(selectorView);
					}
			   }else{
				   alert("对不起系统正在维护~o~,请稍后在查询！");
			   }
		   },
		   error:function () {
			   alert("对不起系统正在维护~o~,请稍后在查询！");
		   }
	});
};

/**
 * 当用户选中人员点击确定后出发这个方法
 */
function onSelectorOk(confirmChoice) {
	var selectorView = $(confirmChoice).parent().parent('div.selector_tdd');
	var selectorViewObj = selectorView.get(0);
	var inputLabel = $(selectorViewObj.initiateInput);
	var inputValue = inputLabel.next();
	var inputSelectorView = selectorView.children("ul.list_tdd").find("span.check_ico_on").next();
	var value = inputSelectorView.val();
	//把inputSelectorView这个对象的按照模型取值传递给inputLabel和inputValue
	var displayFieldValue = selectorViewObj.selectorModel.displayField;
	var valueField = selectorViewObj.selectorModel.valueField;
	if (displayFieldValue) {
		if (value){
			inputLabel.val(eval("(" + value + "." + displayFieldValue + ")"));
			inputLabel.removeClass("gray");
		}else {
			inputLabel.val("");
			inputLabel.addClass("gray");
		}
	}
	if (valueField) {
		if (value){
			inputValue.val(eval("(" + value + "." + valueField + ")"));
		}else {
			inputValue.val("");
		}
	}
	//值装载好后要显示审批界面，隐藏数显的选择器样式界面
	hiddenSelectView(selectorView);
	//扩展onWindowOk方法，掉用户写的选中后的操作
	if (selectorViewObj.selectorModel.onWindowOk) {
		selectorViewObj.onWindowOk = selectorViewObj.selectorModel.onWindowOk;
		selectorViewObj.onWindowOk(eval("(" + value + ")"));
	}
	//清空掉已经输入（显示）的查询条件，隐藏域的不清空
	clearInpt(selectorView);
};

/**
 * 用户选择取消的时候出发这个方法
 * @param cancleChoice
 */
function onSelectorCancle(cancleChoice){
	var selectorView = $(cancleChoice).parent().parent('div.selector_tdd');
	hiddenSelectView(selectorView);
	clearInpt(selectorView);
};

/**
 * 改变加载更多的提示
 * @param flag
 * @param selectorView
 */
function changeLoadingDiv(flag,selectorView) {
	var loadDiv = selectorView.children("div.loadingbox.tac");
	if (flag) {
		loadDiv.find("span").text("点击加载更多。。。");
		loadDiv.removeClass("loadingboxNoImg");
		loadDiv.addClass("loadingbox");
		//<div class="loadingbox tac"><span onclick="clickMore(this)">点击加载更多...</span></div>  
		//loadingboxNoImg
	}else {
		loadDiv.removeClass("loadingbox");
		loadDiv.addClass("loadingboxNoImg");
		if (selectorView.get(0).totalCount == 0) {
			loadDiv.find("span").text("对不起没查到信息。。。");
		}else {
			loadDiv.find("span").text("已加载全部。。。");
		}
	}
};

/**
 * 获得总的页数
 * @param selectorView
 * @returns
 */
function getTotalPage (selectorView) {
	var totalCount = selectorView.get(0).totalCount;
	var pageSize = selectorView.get(0).pageSize;
	if (totalCount % pageSize == 0) {
		selectorView.get(0).totalPage = totalCount/pageSize;
	} else {
		selectorView.get(0).totalPage = parseInt(totalCount/pageSize) + 1;
	}
	return selectorView.get(0).totalPage;
};

/**
 * 根据选择器这个对象的总页数以及现在当前页判断能否继续加载
 * @param selectorView
 * @returns {Boolean}
 */
function canLoadMore (selectorView) {
	var totalPage = getTotalPage (selectorView);
	if (selectorView.get(0).currentPage < totalPage) return true;
	return false;
};

/**
 * 追加查询结果集合的时候会调用这个方法
 * @param htmlStr
 * @param loadType
 * @param selectorId
 */
function appendDataList(htmlStr,loadType,selectorView) {
	if (loadType == 'load-first') {
		$(selectorView).find("ul.list_tdd").empty().append(htmlStr);
	}else {
		$(selectorView).find("ul.list_tdd").append(htmlStr);
	}
};

/**
 * 点击查询的手后调用这个方法
 * @param obj
 */
function clickQuery(obj){
	var selectorView = $(obj).parent().parent();
	initSelector(selectorView.get(0));
	getQueryDataList(selectorView,'load-first');
};

/**
 * 点击加载更多的时候录调用这个方法
 * @param obj
 */
function clickMore (obj) {
	var selectorView = $(obj).parent().parent();
	if (canLoadMore(selectorView)) {
		var tempPage = selectorView.get(0).currentPage;
		selectorView.get(0).currentPage = tempPage + 1;
		getQueryDataList(selectorView,'load-more');
	}else {
		alert("已经加载全部");
	}
};

/**
 * 用户点击选择器的入口
 * @param inputField
 * @param selectorId
 */
function openSelectorView(inputField,selectorId) {
	hiddenMainWindow();
	var selectorView = $("#" + selectorId);
	if (typeof(selectorView.get(0).window) == 'undefined') {
		selectorView.get(0).window = true;
		var selectorModelStr = $(selectorView.get(0)).attr("selectorModel");
		var model = eval(selectorModelStr);
		selectorView.get(0).selectorModel = model;
		$(inputField).addClass("gray");
		selectorView.get(0).initiateInput = inputField;
		var html = createQueryView(model.queryModel.fields);
		$(selectorView.get(0)).find(".searchBox").append(html);
		initSelector(selectorView.get(0));
		/*//构建查询参数
		var params = getQueryParam (selectorView);*/
		//<ul class="tabs_tdd fix"
		var selectorTypeHtml = createSelectorType(selectorView);
		$(selectorView.get(0)).find("ul.tabs_tdd.fix").append(selectorTypeHtml);
	}
	//调用异步请求加载数据
	getQueryDataList(selectorView,'load-first');
};

/**
 * 拼接查询参数的json格式字符串
 * @param selectorView
 * @returns {String}
 */
function getQueryParamStr (selectorView) {
	var queryInputFields = $(selectorView.get(0)).find(".searchBox").find("input");
	var paramStr = '({';
	for (var i = 0;i < queryInputFields.length;i++) {
		var input = queryInputFields[i];
		paramStr += $(input).attr("name") + ':"' + $(input).val() + '",';
	}
	if (paramStr.indexOf(",")) {
		paramStr = paramStr.substring(0, paramStr.length - 1);
	}
	paramStr += '})';
	return paramStr;
};

/**
 * 从查询参数的json格式生成对象类型数据，构建查询参数的对象
 * @param selectorView
 * @returns {___params2}
 */
function getQueryParam (selectorView) {
	var str = getQueryParamStr(selectorView);
	var params = eval(str);
	//params.selectorType = (selectorView.selectorModel.store.selectorType == null ||typeof(selectorView.selectorModel.store.selectorType) == 'undefined') ? 'empSelector' :  selectorView.selectorModel.store.selectorType + '"';
	params.selectorType = selectorView.get(0).selectType;
	params.page = selectorView.get(0).currentPage;
	params.limit = selectorView.get(0).pageSize;
	return params;
};

/**
 * 隐藏审批的主界面
 */
function hiddenMainWindow() {
	$('#div2').attr("style","display:none");
	/*//创建显示查询处
	$(selectorId).show();*/
};

/**
 * 显示选择器界面
 * @param selectorId
 */
function showSelectorView (selectorView) {
	selectorView.show();
	//selectorView.get(0).selectorModel;
};

/**
 * 隐藏选择器界面
 * @param selectorView
 */
function hiddenSelectView (selectorView) {
	$('#div2').show();
	selectorView.hide();
	selectorView.find("ul.list_tdd").empty();
};

/**
 * 获得选中的对象
 * @param liObj
 * @param isSelect
 */
function getSelectObj(liObj,isSelect) {
	var liObjJQ = $(liObj);
	var inputObj = liObjJQ.children("input");
	var pObjs = liObjJQ.find("p");
	var inputValue = "{";
	for (var i = 0; i < pObjs.length; i ++) {
		var pObj = pObjs[i];
		inputValue += "" + i + ":" + $(pObj).text() + ",";
	}
	if(inputValue.indexOf(",") > 0 ) {
		var subLength = inputValue.length-1;
		inputValue = inputValue.substring(0, subLength);
	}
	inputValue += "}";
	inputObj.val(inputValue);
};

/**
 * 根据传递过来的数据以及模型层中定义的数据系显示域，获得值，将值放到每行对象的隐藏域中
 * @param data
 * @param fields
 * @returns {String}
 */
function getSelectValue(data,fields) {
	var value = '{';
	for (var i = 0; i < fields.length; i++) {
		var left = fields[i].left;
		var right = fields[i].right;
		if (left) {
			for (var j = 0;j < left.length;j++) {
				value += "'" + left[j].property + "':'" + eval('data.' + left[j].property) + "',";
			}
		}
		if (right) {
			for (var j = 0;j < right.length;j++) {
				value += "'" + right[j].property + "':'" + eval('data.' + right[j].property) + "',";
			}
		}
	}
	if (value.length > 0) {
		value = value.substring(0,value.length - 1);
	}
	value += '}';
	return value;
};

/**
 * 创建查询标志-是人员还是部门
 * @param selectorView
 * @returns {String}
 */
function createSelectorType (selectorView) {
	var html = '';
	var selectorType = selectorView.get(0).selectorModel.store.selectorType;
	
	if (selectorType == "empSelector") {
		html += '<li class="on">人员选择</li>';
	}else {
		html += '<li class="on">部门选择</li>';
	}
	html += '<li onclick="clickQuery(this)">查询</li>';
	return html;
};

/**
 * 创建查询框
 * @param queryModelFields
 * @returns {String}
 */
function createQueryView (queryModelFields) {
	var html = '';
	if (queryModelFields) {
		//queryModelFields = eval("(" + queryModelFields + ")");
		for (var i = 0;i < queryModelFields.length;i++) {
			var param = queryModelFields[i];
			html += '<input class="text100" '+
					' type="' + ((param.type == null ||typeof(param.type) == 'undefined') ? 'text' :  param.type) + '"' +
					' name="' + ((param.name == null ||typeof(param.name) == 'undefined') ? 'text' :  param.name) + '"' +
					' placeholder="' + ((param.nullText == null ||typeof(param.nullText) == 'undefined') ? '' :  param.nullText) + '"' +
					' value="' + getQueryFieldsValue(param) + '"' +
					' />';
		}
	}
	return html;
};

/**
 * 得到模型层中定义的查询条件的值
 * @param param
 * @returns
 */
function getQueryFieldsValue (param){
	if (param.value) {
		if (typeof(param.value) == 'function') {
			return param.value();
		}else {
			return param.value;
		}
	}else {
		return '';
	}
};

/**
 * 构建数据视图
 * @param dataList
 * @param dataModelFields
 * @returns {String}
 */
function createDataLiView (dataList,dataModelFields,selectorType) {
	/*var dataModelFields = 
		'[{left:[{"label":"姓名","property":"EMPNAME"},{"label":"职位","property":"JOBNAME"}],right:[{"label":"工号","property":"EMPCODE"},{"label":"部门","property":"ORGNAME"}]},{right:[{"label":"部门标杆编码","property":"FINASYSCODE","hidden":"hidden"}]}]';
	*/
	//dataModelFields = eval("(" + dataModelFields + ")");
	var dataHtml = '';
	for (var i = 0;i<dataList.length ;i++) {
		var data = dataList[i];
		dataHtml += '<li onclick="selectChoice(this)">' + 
						'<span class="check_ico"/>' + '<input type="hidden" value="' + getSelectValue(data,dataModelFields) + '"/>' ;
		var liElement = '';
		for (var m = 0; m < dataModelFields.length; m++) {
			var liObj = dataModelFields[m];
			var liLeftObj = liObj.left;
			var liRightObj = liObj.right;
			/*if (liLeftObj && liLeftObj.length == 0 && liRightObj && liRightObj.length == 0) {
				return '';
			}*/
			var liElementLeft = '';
			var liElementRight = '';
			//造左侧的数据
			liElementLeft = createLeftData(liLeftObj,data,selectorType);
			//造右侧的数据
			liElementRight = createRightData(liRightObj,data,selectorType);
			liElement = liElementLeft + liElementRight;
			dataHtml += liElement ;
		}
		dataHtml +=  '</li>';
	}
	return dataHtml;
};

/**
 * 按照模型层，创建右侧数据
 */
function createRightData(liRightObj,data,selectorType) {
	var liElementRight = '';
	//人员选择器   每行底部隐藏
	var bottomHiddenFlag = '';
	if(selectorType == 'empSelector'){
		bottomHiddenFlag = 'style="display:none"';
	}
	if (liRightObj) {
		liElementRight = '<div class="uidbox dib">';
		for (var j = 0;j < liRightObj.length;j++) {
			var rightElements = liRightObj[j];
			var hiddenType = rightElements.hidden;
			if (hiddenType) {
				continue;
			}
			if(j == 0){
				liElementRight += '<p class="ell">' + eval('data.' + rightElements.property) + '</p>';
			}else{
				liElementRight += '<p '+bottomHiddenFlag+' class="ell">' + eval('data.' + rightElements.property) + '</p>';
			}
			
		}
		liElementRight += '</div>';
	}
	return liElementRight;
};

/**
 * 按照模型层，创建左侧数据
 * @param liLeftObj
 * @param data
 * @returns {String}
 */
function createLeftData(liLeftObj,data,selectorType) {
	var liElementLeft = '';
	//左侧隐藏标志  当部门选择器时 隐藏
	var leftHiddenFlag = '';
	if (selectorType == 'deptSelector') {
		leftHiddenFlag = 'style="display:none"';
	}
	//人员选择器 每行底部隐藏
	var bottomHiddenFlag = '';
	if(selectorType == 'empSelector'){
		bottomHiddenFlag = 'style="display:none"';
	}
	if (liLeftObj) {
		liElementLeft = '<div class="namebox dib" ' + leftHiddenFlag + '>';
		for (var j = 0;j < liLeftObj.length;j++) {
			var leftElements = liLeftObj[j];
			var hiddenType = leftElements.hidden;
			if (hiddenType) {
				continue;
			}
			if (j == 0) {
				if (leftElements.isB) {
					liElementLeft += '<p class="uname">' + eval('data.' + leftElements.property) + '</p>';
				}else {
					liElementLeft += '<p class="uname">' + eval('data.' + leftElements.property) + '</p>';
				}
			}else {
				liElementLeft += '<p '+bottomHiddenFlag+' >' + eval('data.' + leftElements.property) + '</p>';
			}
		}
		liElementLeft += '</div>';
	}
	return liElementLeft;
};

/**
 * 在每一行上绑定这个方法控制界面的选中后的样式
 * @param obj
 */
function selectChoice (obj) {
	var isSelect = $(obj).find("span").attr("class");
	var ulParent = $(obj).parent();
	ulParent.children("li").find("span").removeClass("check_ico_on");
	var p = ulParent.children("li").find(".uidbox.dib").find("p");
	if (p) {
		p.removeClass("ell");
	}
	//check_ico check_ico_on
	if (isSelect == "check_ico") {
		$(obj).find("span").addClass("check_ico_on");
		//$(obj).find("p").addClass("ell");
	}else {
		$(obj).find("span").removeClass("check_ico_on");
	}
	//选中之后需要赋值到隐藏域中,下面的方法只是为了测试，真正交互到后台的时候input框是有值的
	/*getSelectObj(obj ,isSelect);*/
};

/**
 * 实例化选择器这个对象
 * @param selectorView
 */
function initSelector(selectorView) {
	selectorView.currentPage = 1;
	selectorView.totalPage = 0;
	selectorView.totalCount = 0;
	var fields = selectorView.selectorModel.queryModel.fields;
	var inputs = $(selectorView).find(".searchBox").find("input");
	for (var i = 0; i < inputs.length; i++) {
		for (var j = 0; j < fields.length; j++) {
			if (fields[j].name == inputs[i].name) {
				if (fields[j].value && fields[j].value != null) {
					try {
						inputs[i].oldValue = fields[j].value();
					} catch(e) {
						inputs[i].oldValue = fields[j].value;
					}
					break;
				}
			}
		}
	}
	var selectType = selectorView.selectorModel.store.selectorType;
	if (selectType == null || typeof(selectType) == 'undefined') {
		selectorView.selectType = "empSelector";
	}else {
		selectorView.selectType = selectorView.selectorModel.store.selectorType;
	}
	if (selectorView.selectorModel.store.pageSize && selectorView.selectorModel.store.pageSize != null) {
		selectorView.pageSize = selectorView.selectorModel.store.pageSize;
	}else {
		selectorView.pageSize = '10';
	}
};

/**
 * 清空选择器
 * @param selectorView
 */
function clearSelectorWindow(selectorView) {
	var inputs = $(selectorView).find(".searchBox").find("input");
	for (var i = 0; i < inputs.length; i++) {
		inputs[i].value = (inputs[i].oldValue == null ||typeof(inputs[i].oldValue) == 'undefined') ? '' : inputs[i].oldValue;
	}
	selectorView.currentPage = 0;
	selectorView.totalPage = 0;
};

function clearSelector(obj) {
	$(obj).parents(".text-search").find("input").val("");
};


/**
 * 
 * @param id
 * @param selectorModel
 * @returns {String}
 */
function makeSourceSelectorView(id,selectorModel){
	var html = '';
	html += '<div class="selector_tdd" id="'+id +'" style="display:none" selectorModel="' + selectorModel + '">' + 
				'<div class="searchBox"></div>' + 
				'<ul class="tabs_tdd fix"></ul>' + 
				'<ul class="list_tdd"></ul>' + 
				'<div class="tac"><span onclick="clickMore(this)">点击加载更多。。。</span></div>' + 
				'<div class="btnbox">' + 
					'<a class="btn" onclick="onSelectorOk(this)">选择</a>' + 
					'<a class="btn btn-no" onclick="onSelectorCancle(this)">取消</a>' + 			
				'</div>' + 
			'</div>';
	return html;
};

function clearInpt(selectorView) {
	initSelector(selectorView.get(0));
	var inputs = selectorView.find("div.searchBox").find("input[type=text]");
	for (var i = 0;i < inputs.length;i++) {
		$(inputs[i]).val("");
	}
};

/**
 * 定义模型层
 */
var selectorPeopleModel = {
		store : {
			url : './getSelectorAction',
			pageSize : 2,
			root : 'deptList',
			selectorType :'empSelector'
		},
		displayField : 'EMPNAME',
		valueField : 'EMPCODE',
		queryModel : {
			fields : [ {
				nullText : '请输入员工姓名',
				name : 'empNameQuery',
				type:'text'
			}, {
				nullText : '请输入员工工号',
				name : 'empCodeQuery',
				type:'hidden'
			}, {
				nullText : '标杆编码',
				name : 'finasyscodeQuery',
				value: '',
				type:'hidden'
			}]
		},
		dataModel :{
			fields :[
			         {left:[{"label":"姓名","property":"EMPNAME"},
			                {"label":"职位","property":"JOBNAME"}],
			          right:[{"label":"工号","property":"EMPCODE"},
			                 {"label":"部门","property":"ORGNAME"}]
			         },
			         {right:[{"label":"部门标杆编码","property":"FINASYSCODE","hidden":"hidden"}]
			         }
			        ]
		},
		onWindowOk : function(v) {
			console.log("===");
		}
	};

var selectorDeptModel = {
		store : {
			url : './getSelectorAction',
			pageSize : 10,
			root : 'deptList',
			selectorType :'deptSelector'
		},
		displayField : 'ORGNAME',
		valueField : 'FINASYSCODE',
		queryModel : {
			fields : [ {
				nullText : '请输入部门名称',
				name : 'deptNameQuery',
				type:'text'
			}/*, {
				nullText : '标杆编码',
				name : 'finasyscodeQuery',
				value :'DP06859',
				type:'hidden'
			}*/ ]
		},
		dataModel :{
			fields :[
			         {left:[{"label":"部门标杆编码","property":"ORGCODE"},
			                {"label":"部门编码","property":"FINASYSCODE"}],
			          right:[{"label":"部门名称","property":"ORGNAME"}]
			         }
			        ]
		},
		onWindowOk : function(v) {
		}
	};
/**
 * 下面都是实力化的方法
 * @returns {Boolean}
 */
var SelectObj = function (element) {
	element.validate = validateSelector;
	element.setVerifiable = setVerifiable;
	element.getValue = getSelectorValue;
	element.getLabel = getSelectorLabel;
};

function validateSelector(){
	var flag = true;
	if ($(this).attr("isValidate")=="false") {
		return flag;
	}
	if ("false" == $(this).attr("allowNull")){
		var v = this.value;
		if ("" == v) {
			flag = false; 
		}
	}
	return flag;
};

function getSelectorValue(){
	return $(this).next().val();
};

function getSelectorLabel() {
	return $(this).val();
};
/*function validateSelector (selectorView) {
if (selectorView.get(0)) {
	
}
}*/