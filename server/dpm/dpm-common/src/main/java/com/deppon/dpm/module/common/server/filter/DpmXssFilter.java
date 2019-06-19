package com.deppon.dpm.module.common.server.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class DpmXssFilter implements Filter{

	private static ArrayList<String> filterModule = new ArrayList<String>();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		filterParameters((HttpServletRequest)request);
		chain.doFilter(request, response);
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String moduleStr = filterConfig.getInitParameter("filterModule");
		if(StringUtils.isNoneBlank(moduleStr)){
			String[] module = filterConfig.getInitParameter("filterModule").split(",");
			for (int i = 0; i < module.length; i++) {
				filterModule.add(module[i]);
			}
		}
	}

	@Override
	public void destroy() {}
	
	@SuppressWarnings("unchecked")
	private void filterParameters(HttpServletRequest request){
		if(request != null) {
			//get request path
			String uri = request.getRequestURI();
			String module = "";
			if(StringUtils.isNotBlank(uri)){
				String[] str = uri.split("/");
				module = str[2];
			}
			//filter module
			if(!filterModule.contains(module)){
				Map<String, String[]> params = request.getParameterMap();
				
				for (Map.Entry<String, String[]> entry : params.entrySet()) {
					String[] values = entry.getValue();
					if (values == null) {
						continue;
					}
					
					for(int i = 0; i < values.length; i++) {
						values[i] = xssEncode(values[i]);
					}
					
				}
			}
		}
	}
	

    /**
     * 将容易引起xss漏洞的字符过滤
     *
     * @param s
     * @return
     */
    private static String xssEncode(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        
        // Avoid anything in a <script>alert(a);</script>" type of e­xpression
        Pattern scriptPattern = Pattern.compile("/<script>(.*?)</script>/i", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll(" ");
        // 删除单个的 </script> 标签
        scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll(" ");
        // 删除单个的<script ...> 标签
        scriptPattern = Pattern.compile("<script(.*?)>",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        value = scriptPattern.matcher(value).replaceAll(" ");
        // Avoid eval(...) e­xpressions
        scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        value = scriptPattern.matcher(value).replaceAll(" ");
        // Avoid e­xpression(...) e­xpressions
        scriptPattern = Pattern.compile("e­xpression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        value = scriptPattern.matcher(value).replaceAll(" ");
        // Avoid javascript:... e­xpressions
        scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll(" ");
        // Avoid vbscript:... e­xpressions
        scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
        value = scriptPattern.matcher(value).replaceAll(" ");
        // Avoid onload= e­xpressions
        String onExpress = "(onafterprint|onbeforeprint|onbeforeunload|onerror|onhaschange|onload"
        		+ "|onmessage|onoffline|ononline|onpagehide|onpageshow|onpopstate|onredo|onresize|onstorage"
        		+ "|onundo|onunload|onblur|onchange|oncontextmenu|onfocus|onformchange|onforminput|oninput"
        		+ "|oninvalid|onreset|onselect|onsubmit|onkeydown|onkeypress|onkeyup|onclick|ondblclick"
        		+ "|ondrag|ondragend|ondragenter|ondragleave|ondragover|onmousedown|onmousemove|onmouseout"
        		+ "|onmouseover|onmouseup|onmousewheel|onscroll|onabort|oncanplay|onerror|onloadeddata|onloadstart"
        		+ "|onpause|onplay|onplaying|onprogress|onreadystatechange|onsuspend|ontimeupdate|onwaiting)(.*?)=";
        scriptPattern = Pattern.compile(onExpress, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        value = scriptPattern.matcher(value).replaceAll(" ");
        return value;
    }
}
