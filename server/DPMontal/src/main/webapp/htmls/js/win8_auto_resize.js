// JavaScript Document
function resize(){
	var obj = document.getElementsByName("wide")[0];
	var i;
	obj.offsetHeight = obj.offsetWidth*0.5-10;
	for(i=2;i<=5;i++){
		document.getElementById("icon"+i).offsetHeight = obj.offsetHeight;
		document.getElementById("icon"+i).offsetWidth = obj.offsetHeight;
	}
	
}
$(function (){
	$(".wide").height(function(){
		$(this).height(parseFloat($(this).width())*0.5-10);
	});
	$(".tips").height(function(){
		return $(".wide").height();
	});
	$(".tips").width(function(){
		return $(this).height()-70;
	});
	var i;
	for(i=2;i<=5;i++){
		$(".icon"+i).height(function(){
			return $(".wide").height();
		});
		$(".icon"+i).width(function(){
			return $(this).height();
		});
	}
	var j=1;
	var image = $(".icon6").find("#adPic");
	$(".icon6").find(".arrowL").click(function(){
		j--;
		if(j<1){
			image.attr("src","../images/r30.jpg");
			j=3;
		}
		else{
			image.attr("src","../images/r"+j+"0.jpg");
		}
	});
	$(".icon6").find(".arrowR").click(function(){
		j++;
		if(j>=4){
			image.attr("src","../images/r10.jpg");
			j=1;
		}
		else{
			image.attr("src","../images/r"+j+"0.jpg");
		}
	});
	image.click(function(){
		if(j==1){
			image.location.href="#";
		}
		if(j==2){
			image.location.href="#";
		}
	});
});