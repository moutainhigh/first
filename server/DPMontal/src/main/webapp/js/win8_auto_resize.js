$(function (){
	var app_ui = $(".App_ui_flag").val();
	if (app_ui == "true"){
		$("#div1").hide();
		$("#title").hide();
	}
	$(".logo").find("img").height(function(){
		return $(this).width()*0.35;
	})
	$(".return").find("img").height(function(){
		return $(this).width();
	})
	$(".wide").height(function(){
		$(this).height(parseFloat($(this).width())*0.5-7);
	});
	$(".tips").height(function(){
		return $(".wide").height();
	});
	$(".tips").width(function(){
		return $(this).height()-35;
	});
	$(".tipsWinCnt").width(function(){
		return $(window).width();
	})
	$(".icon0").height(function(){
		return $(".wide").height()-20;
	});
	$(".icon0").width(function(){
		return $(this).height();
	});
	$("input[type='text']").addClass("gray");
	$("input[type='password']").addClass("gray");
	$("textarea").addClass("gray");
	$("input[type='text']").focus(function(){
		$(this).removeClass("gray");
	});
	$("input[type='text']").blur(function(){
		if($(this).val()==""){
			$(this).addClass("gray");
		}
	});
	$("input[type='password']").focus(function(){
		$(this).removeClass("gray");
	});
	$("input[type='password']").blur(function(){
		if($(this).val()==""){
			$(this).addClass("gray");
		}
	});
	$("textarea").focus(function(){
		$(this).removeClass("gray");
	});
	$("textarea").blur(function(){
		if($(this).val()==""){
			$(this).addClass("gray");
		}
	})
	var i;
	for(i=2;i<=7;i++){
		$(".icon"+i).height(function(){
			return $(".wide").height();
		});
		$(".icon"+i).width(function(){
			return $(this).height();
		});
	}
//	var obj = $("#basePath").val();
//	
//	var j=0;
//	var image = $(".icon6").find("#adPic");
//	image.click(function(){
//		location.href=	imageUrl;
//	});
//	$(".icon6").find(".arrowR").click(function(){
//		j++;
//		if(j>=3){
//			j=0;
//			rollload(j,rollArray,basePath);
//		}
//		else{
//			rollload(j,rollArray,basePath);
//		}
//	});
	$("#div3").find(".icon6").height(function(){
		return $(this).width()*0.5;
	});
});
$(window).resize(function(){
	$(".logo").find("img").height(function(){
		return $(this).width()*0.35;
	})
	$(".return").find("img").height(function(){
		return $(this).width();
	})
	$(".tipsWinCnt").height(function(){
		return $(window).height();
	})
	$(".shadowBg").height(function(){
		return $(window).height();
	})
	
	$(".wide").height(function(){
		$(this).height(parseFloat($(this).width())*0.5-7);
	});
	$(".tips").height(function(){
		return $(".wide").height();
	});
	$(".tips").width(function(){
		return $(this).height()-35;
	});
	$(".tipsWinCnt").width(function(){
		return $(window).width();
	})
	$(".tipsWin").css("top","25%");
	var i;
	for(i=2;i<=7;i++){
		$(".icon"+i).height(function(){
			return $(".wide").height();
		});
		$(".icon"+i).width(function(){
			return $(this).height();
		});
	}
});

//数字转金额大写
function numToCny(numberValue){
	var numberValue=new String(Math.round(numberValue*100)); // 数字金额
	var chineseValue=""; // 转换后的汉字金额
	var String1 = "零壹贰叁肆伍陆柒捌玖"; // 汉字数字
	var String2 = "万仟佰拾亿仟佰拾万仟佰拾元角分"; // 对应单位
	var len=numberValue.length; // numberValue 的字符串长度
	var Ch1; // 数字的汉语读法
	var Ch2; // 数字位的汉字读法
	var nZero=0; // 用来计算连续的零值的个数
	var String3; // 指定位置的数值
	if(len>15){
	alert("超出计算范围");
	return "";
	}
	if (numberValue==0){
	chineseValue = "零元整";
	return chineseValue;
	}
	String2 = String2.substr(String2.length-len, len); // 取出对应位数的STRING2的值
	for(var i=0; i<len; i++){
	String3 = parseInt(numberValue.substr(i, 1),10); // 取出需转换的某一位的值
	if ( i != (len - 3) && i != (len - 7) && i != (len - 11) && i !=(len - 15) ){
	if ( String3 == 0 ){
	Ch1 = "";
	Ch2 = "";
	nZero = nZero + 1;
	}
	else if ( String3 != 0 && nZero != 0 ){
	Ch1 = "零" + String1.substr(String3, 1);
	Ch2 = String2.substr(i, 1);
	nZero = 0;
	}
	else{
	Ch1 = String1.substr(String3, 1);
	Ch2 = String2.substr(i, 1);
	nZero = 0;
	}
	}
	else{ // 该位是万亿，亿，万，元位等关键位
	if( String3 != 0 && nZero != 0 ){
	Ch1 = "零" + String1.substr(String3, 1);
	Ch2 = String2.substr(i, 1);
	nZero = 0;
	}
	else if ( String3 != 0 && nZero == 0 ){
	Ch1 = String1.substr(String3, 1);
	Ch2 = String2.substr(i, 1);
	nZero = 0;
	}
	else if( String3 == 0 && nZero >= 3 ){
	Ch1 = "";
	Ch2 = "";
	nZero = nZero + 1;
	}
	else{
	Ch1 = "";
	Ch2 = String2.substr(i, 1);
	nZero = nZero + 1;
	}
	if( i == (len - 11) || i == (len - 3)){ // 如果该位是亿位或元位，则必须写上
	Ch2 = String2.substr(i, 1);
	}
	}
	chineseValue = chineseValue + Ch1 + Ch2;
	}
	if ( String3 == 0 ){ // 最后一位（分）为0时，加上“整”
	chineseValue = chineseValue + "整";
	}
	return chineseValue;
}
