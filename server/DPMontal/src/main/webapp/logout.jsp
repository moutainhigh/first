<%@page import="com.deppon.montal.util.redis.service.impl.UserRedisService"%>
<%@page import="redis.clients.jedis.Jedis"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.montal.util.NetUtil"%>
<%@page import="com.deppon.montal.util.IHttpClient"%>
<% 
	//退出注销
	
	String path = request.getContextPath();   
    String basePath = InitDataServlet.getValue("dpm_domain_url") + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path; 
	request.getSession().setAttribute("loginUser", null);
	String cascookie = (String)request.getSession().getAttribute("CAS-LOGIN-TGC");
	System.out.println("CAS-LOGIN-TGC="+cascookie);
	request.getSession().invalidate();
	IHttpClient httpClient = NetUtil.fetchHttpClient();
	httpClient.setRequestURL(InitDataServlet.prop.getProperty("cas_login_out"));
	System.out.println("cas_login_out="+InitDataServlet.prop.getProperty("cas_login_out"));
	httpClient.setCookie(cascookie);
	httpClient.send("");
	System.out.println("logout success...");
	//clear redis key
	String sessionId = null;
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		if("JSESSIONID".equalsIgnoreCase(c.getName())){
			sessionId = c.getValue();
		}
	}
	System.out.println("logout:remove:sessionId------------------>"  + sessionId);
	if(sessionId != null){
		UserRedisService redisService = new UserRedisService();
		redisService.removeFromRedis(sessionId);
	}
    //response.sendRedirect(basePath+"/login_redirect.jsp");
    request.getRequestDispatcher("login").forward(request, response);
%>