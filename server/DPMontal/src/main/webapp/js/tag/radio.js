var RadioObj = function (element) {
	element.validate = validateRadio;
	element.addlistener = radioSelectListener;
	element.setVerifiable = setVerifiable;
	element.getValue = getRadioValue;
	element.getLabel = getRadioLabel;
	$(element).find("input[type=radio]").click(radioOnclick);
};
function radioSelectListener (fun) {
	if (typeof(this.radioSelectListener) == "undefined") {
		this.radioSelectListener = new Array();
	}
	this.radioSelectListener.push(fun);
};
function radioOnclick (){
	var This = $(this).parents("[jspTag=DPMontalRadio]").get(0);
	if (!This.validate()) {
		messageTip(This.getAttribute("locationMessage"));
	} 
	//调用方法
	if (This.radioSelectListener == null) {
		return;
	}
	for (var i = 0; i < This.radioSelectListener.length; i++) {
		var fun = This.radioSelectListener[i];
		fun(This.getLabel(),This.getValue(),This);
	}
};

function getRadioValue() {
	var input = $(this).find("input[type=radio]:checked");
	return input.val();
};

function getRadioLabel() {
	var input = $(this).find("input[type=radio]:checked");
	return input.next().text();
};

function validateRadio(){
	var flag = true;
	if ($(this).attr("isValidate")=="false") {
		return flag;
	}
	if ("false" == $(this).attr("allowNull")){
		var v = this.getValue();
		if ("" == v) {
			flag = false; 
		}
	}
	return flag;
};