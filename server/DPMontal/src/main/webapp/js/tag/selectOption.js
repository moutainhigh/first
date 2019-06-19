var SelectOptionObj = function (element) {
	element.validate = validateSelectOption;
	element.setVerifiable = setVerifiable;
	element.getValue = getSelectOptionValue;
	element.getLabel = getSelectOptionLabel;
};

function getSelectOptionValue() {
	var selectOption = $(this).find("select");
	var value = selectOption.val();
	if (typeof(value) == "undefined") {
		value = "";
	}
	return value;
};

function getSelectOptionLabel() {
	//var selectOption = $(this).find("select").find("option[checked=checked]");
	//return selectOption.text();
	var selectOption = $(this).find("select").find("option");
	if (selectOption) {
		for (var i=0;i<selectOption.length;i++) {
			if (selectOption[i].selected) {
				return $(selectOption[i]).text();
			}
		}
	}
	return "";
};

function validateSelectOption(){
	var flag = true;
	if ($(this).attr("isValidate")=="false") {
		return flag;
	}
	if ("false" == $(this).attr("allowNull")){
		var v = this.getValue();
		//这里需要优化，弄一个变脸判断下ia显示框中的值是默认显示的有异议数据还是没意义数据
		if ("" == v || "default" == v) {
			flag = false; 
		}
	}
	return flag;
};