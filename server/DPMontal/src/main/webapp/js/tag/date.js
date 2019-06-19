var DateObj = function (element) {
	element.validate = validateDate;
	element.getValue = getDateValue;
	element.setVerifiable = setVerifiable;
};

function getDateValue() {
	return $(this).val();
};
function validateDate(){
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