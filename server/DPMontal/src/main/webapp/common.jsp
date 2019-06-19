<%@page import="com.deppon.montal.util.InitDataServlet" %>
<% 
	
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path;   
%>

<link rel="stylesheet" href="<%=basePath%>/css/jquery.mobile-1.2.0.css" />
<script src="<%=basePath%>/js/jquery-1.8.2.min.js"></script>
<script src="<%=basePath%>/js/jquery.mobile-1.2.0.min.js"></script>

<script type="text/javascript">
<!--
	//用于ajax的传参转译，如加号(+)和符号(&)
	function filter(str)
	{
	    str = str.replace(/\+/g,"%2B");
	    str = str.replace(/\&/g,"%26");
	    return str;
	}

//-->
</script>
