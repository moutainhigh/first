$(function () {
	(function (a) {
		var inputs = $(this.document.body).find("input[jsptag=DPMontalSelector]");
		if (inputs) {
			for (var i=0;i < inputs.length;i++) {
				var id = $(inputs[i]).attr("selectorViewId");
				var selectorModel = $(inputs[i]).attr("searchModel");
				var html = makeSourceSelectorView(id,selectorModel);
				$(this.document.body).append(html);
				SelectObj(inputs[i]);
			}
		}
		var inputsDate =  $(this.document.body).find("input[jsptag=DPMontalDate]");
		if (inputsDate) {
			for (var i=0;i < inputsDate.length;i++) {
				var inputsDateObj = inputsDate[i];
				DateObj(inputsDateObj);
			}
		}
		var inputsRadio =  $(this.document.body).find("[jsptag=DPMontalRadio]");
		if (inputsRadio) {
			for (var i=0;i < inputsRadio.length;i++) {
				var radioObj = inputsRadio[i];
				RadioObj(radioObj);
				var fun = radioObj.getAttribute('onselect');
				if (fun && fun != '') {
					radioObj.addlistener(eval(fun));
				}
			}
		}
		var inputsSelectOption =  $(this.document.body).find("[jsptag=DPMontalSelectOption]");
		if (inputsSelectOption) {
			for (var i=0;i < inputsSelectOption.length;i++) {
				var selectOptionObj = inputsSelectOption[i];
				SelectOptionObj(selectOptionObj);
			}
		}
	})(jQuery);
});

function validate() {
	var flag = true;
	var inputs = $("input[jsptag=DPMontalSelector]");
	if (inputs) {
		for (var i=0;i < inputs.length;i++) {
			flag = inputs[i].validate();
			if (!flag) {
				messageTip($(inputs[i]).attr("locationMessage"));
				return flag;
			}
		}
	}
	var inputsDates = $("input[jsptag=DPMontalDate]");
	if (inputsDates) {
		for (var i=0;i < inputsDates.length;i++) {
			flag = inputsDates[i].validate();
			if (!flag) {
				messageTip($(inputsDates[i]).attr("locationMessage"));
				return flag;
			}
		}
	}
	var inputsRadio = $("[jsptag=DPMontalRadio]");
	if (inputsRadio) {
		for (var i=0;i < inputsRadio.length;i++) {
			flag = inputsRadio[i].validate();
			if (!flag) {
				messageTip($(inputsRadio[i]).attr("locationMessage"));
				return flag;
			}
		}
	}
	var inputsSelectOption = $("[jsptag=DPMontalSelectOption]");
	if (inputsSelectOption) {
		for (var i=0;i < inputsSelectOption.length;i++) {
			flag = inputsSelectOption[i].validate();
			if (!flag) {
				messageTip($(inputsSelectOption[i]).attr("locationMessage"));
				return flag;
			}
		}
	}
	return flag;
};

function messageTip(message) {
	if (message.length == 0) {
		message = "需要填写的信息没有填写完整，亲把你盖填写的数据填上吧";
	}
	$('#result_msg').html(message);
	$("#confirm_back").show();
	$("#result_window").fadeIn(600);
	$(".tipsWinCnt").show();
};


function setVerifiable (flag) {
	if (typeof(flag)=="undefined" || flag.length==0) {
		flag = "" + flag;
	}
	$(this).attr("isValidate",flag);
};