<%@page import="com.deppon.montal.util.InitDataServlet" %>
<% 
	
	String path1 = request.getContextPath();   
    String basePath1 = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path1;   
%>
<div style="width: 100%;margin: 0px;padding: 0px;">
	
	<table style="width: 100%;border-collapse:collapse;background-color: #403b65;">
		<tr>
			<td width="15%" style="text-align: left;padding: 3px;">
				<a>
					<img  alt="back" id="back_img" src="<%=basePath1%>/images/ios/back.png" width="30px" >
				</a>
			</td>
			<td width="85%" style="text-align: center;padding: 3px;">
				<img alt="logo" id="logo_img" src="<%=basePath1%>/images/ios/head_logo.png" width="60%">
			</td>
		</tr>
	</table>
	
</div>
<script type="text/javascript">
	var winht = $(window).height();
	var winwd = $(window).width();
	$('#back_img').width(winwd*0.10);
	$('#back_img').height(winwd*0.10);
	$('#logo_img').width(winwd*0.63);
	$('#logo_img').height(winwd*0.10);
	
	$('#logo_img').live('tap', function() {
		location.href ="<%=basePath1%>/showmain";
	});
</script>
<div style="clear: both;"></div>