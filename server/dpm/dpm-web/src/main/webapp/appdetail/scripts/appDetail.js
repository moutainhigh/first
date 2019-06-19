/**/
/*function submitForm(){
	var photos = $("#photos").val();
    if(Utils.isEmpty(photos)) {
        alert("请选择文件");
        return false;
    }
   
    if (!value.match(/.jpg|.jpeg|.gif|.png|.bmp/i)) {
        alert("文件格式错误");
        return false;
    }
	alert(document.getElementById("appIntroduce").value);
	alert("1111111");
    if(document.getElementById("appIntroduce").value == "" || document.getElementById("detailMessage").value == ""){
    	alert("输入框不能为空！请填写完整~");
        return false;
    }
    var option = {
        url : '/dpm/dpm-management/appDetail_insertAppDetail.action',
        type : 'POST',
        dataType : 'json',
        headers : {"ClientCallMode" : "ajax"}, //添加请求头部
        success : function(data) {
            alert("success");
        },
        error: function(data) {
            alert("error") + "--上传失败,请刷新后重试");
        }
     };
    alert("1111111");
    $("#formid").ajaxSubmit(option);
    return false;
	alert("1111111");
}*/

function reset(){
	document.getElementById("appIntroduce").innerHTML = "";
	document.getElementById("detailMessage").innerHTML = "";
	document.getElementById("photos").innerHTML = "";
}
