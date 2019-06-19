<%@page import="com.deppon.montal.util.InitDataServlet"%>
<% 
	
	String path1 = request.getContextPath();   
    String basePath1 = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path1;   
%>
<div data-role="header" data-theme="f" style="width: 100%;margin-top: 10px">
	<div  style="float: left;margin-left: 10px;">
		<a>
			<img  alt="back" id="back_img" src="<%=basePath1%>/images/win8/back.png" width="30px" height="30px;">
		</a>
	</div>
	<div style="float: right;margin-right: 10px;">
		<img alt="logo" id="logo_img" src="<%=basePath1%>/images/win8/deppon-logo.png" width="50%" style="float: right;">
	</div>
</div>
<script type="text/javascript">
	var winht = $(window).height();
	var winwd = $(window).width();
	$('#back_img').width(winwd*0.12);
	$('#back_img').height(winwd*0.12);
	$('#logo_img').width(winwd*0.30);
	$('#logo_img').height(winwd*0.12);
	
	$('#logo_img').live('tap', function() {
		location.href ="<%=basePath1%>/showmain";
	});
</script>
<div style="clear: both;"></div>