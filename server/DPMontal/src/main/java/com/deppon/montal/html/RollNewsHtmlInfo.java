package com.deppon.montal.html;

import java.util.List;
import java.util.Map;

import com.deppon.montal.util.InitDataServlet;

/**
 * RollNewsHtmlInfo(已作废)
 * @author Administrator
 *
 */
public class RollNewsHtmlInfo {

	public static final String ROLLNEW_LSIT_FILENAME = "rollnewlist.html";
	
	/**
	 * 创建滚动新闻html
	 * @param newMapList
	 */
	public static void createHtmlForRollNew(List<Map> newMapList){
		
		String htmlStr = getRollNewListForWin8(newMapList).toString();
		
		CreateFile.createNewFile(htmlStr, ROLLNEW_LSIT_FILENAME, 
				   InitDataServlet.prop.getProperty("imgnews_distPath"));
		
		for(int i=0; i<newMapList.size(); i++){
			Map map = newMapList.get(i);
			CreateFile.createNewFile(getRollNewDetailForWin8(map).toString(), "rollnew_"+(i+1)+".html", 
					                 InitDataServlet.prop.getProperty("imgnews_distPath"));
		}
	}
	
	
	/**
	 * 滚动新闻列表
	 * @param context
	 * @return
	 */
	public  static StringBuffer getRollNewListForWin8(List<Map> newMapList){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
		sb.append("<head>\n");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" />\n");
		sb.append("<meta content=\"telephone=no\" name=\"format-detection\" />\n");
		sb.append("<meta http-equiv = \"Content-Type\" content = \"application/xhtml+xml; charset=UTF-8\" />\n");
		sb.append("<title>德邦物流-图片新闻</title>\n");
		sb.append("<link rel=\"stylesheet\" href=\"../../css/reset.css\" />\n");
		sb.append("<link rel=\"stylesheet\" href=\"../../css/win8/common.css\" />\n");
		sb.append("<link rel=\"stylesheet\" href=\"../../css/win8/list.css\" />\n");
		sb.append("<script type=\"text/javascript\" src=\"../../js/jquery-1.8.2.min.js\"></script>\n");
		sb.append("<script type=\"text/javascript\" src=\"../../js/win8_auto_resize.js\"></script>\n");
		sb.append("</head>\n");
		sb.append("<body>\n<div id=\"list\">\n<div id=\"div1\"><a class=\"return\" href=\"javascript:history.back()\">\n<img src=\"../../imgnews/win8/list_return_btn.png\" width=\"100%\" />\n</a><div class=\"logo\">\n<img src=\"../../imgnews/win8/list_logo.png\" width=\"100%\" />\n</div>");
		sb.append("</div>\n<div id=\"div2\"><h3 class=\"yellow\">新闻列表</h3>\n<div class=\"tableBox3\">");
		
		sb.append(arrangerNewList(newMapList));
		
		sb.append("</div>\n</div>\n</div>\n");
		
		sb.append("<script>\n");
		sb.append("$(function(){\n");
		sb.append("  $(\"#div2\").find(\"tr\").live('touchstart',function(){\n");
		sb.append("		$(this).addClass(\"on\");\n");
		sb.append("	});\n");
		sb.append("	$(\"#div2\").find(\"tr\").live('touchend',function(){\n");
		sb.append("		$(this).removeClass(\"on\");\n");
		sb.append("	});\n");
		sb.append("	$(\"#div2\").find(\"tr\").live('touchmove',function(){\n");
		sb.append("		$(this).removeClass(\"on\");\n");
		sb.append("	});\n");
		sb.append("	$(\"#div2\").find(\"tr\").click(function(){\n");
		sb.append("		var name = $(this).attr(\"id\");\n");
		sb.append("		location.href =name+\".html\";\n");
		sb.append("	});\n ");
		sb.append("	$(\".logo\").click(function(){\n");
		sb.append("		location.href =\"../../showmain\";\n");
		sb.append("	});\n   });\n");
		sb.append("</script>\n");
		sb.append("</body>\n</html>");
		
		return sb;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	private static StringBuffer arrangerNewList(List<Map> newMapList){
		StringBuffer sb = new StringBuffer();
		sb.append("<table width=\"100%\">\n");
		for(int i=0; i<newMapList.size(); i++){
			Map map = newMapList.get(i);
			sb.append("<tr id=\"rollnew_"+(i+1)+"\">\n");
			sb.append("<th width=\"70%\"><div class=\"hidden\">"+map.get("HEADER")+"</div></th>\n");
			sb.append("<td width=\"30%\" class=\"fyy-textRt\">"+map.get("SHORTFBDATE")+"</td>\n");
			sb.append("</tr>\n");
		}
		sb.append("</table>\n");
		
		return sb;
	}
	
	/**
	 * 滚动新闻详细
	 * @param context
	 * @return
	 */
	public static StringBuffer getRollNewDetailForWin8(Map newMap){
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
		sb.append("<head>\n");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" />\n");
		sb.append("<meta content=\"telephone=no\" name=\"format-detection\" />\n");
		sb.append("<meta http-equiv = \"Content-Type\" content = \"application/xhtml+xml; charset=UTF-8\" />\n");
		sb.append("<title>德邦物流-图片新闻</title>\n");
		sb.append("<link rel=\"stylesheet\" href=\"../../css/reset.css\" />\n");
		sb.append("<link rel=\"stylesheet\" href=\"../../css/win8/common.css\" />\n");
		sb.append("<link rel=\"stylesheet\" href=\"../../css/win8/list.css\" />\n");
		sb.append("<script type=\"text/javascript\" src=\"../../js/jquery-1.8.2.min.js\"></script>\n");
		sb.append("<script type=\"text/javascript\" src=\"../../js/win8_auto_resize.js\"></script>\n");
		sb.append("</head>\n");
		
		
		sb.append("<body>\n");
		sb.append("<div id=\"list\">\n");
		sb.append("    <div id=\"div1\">\n");
		sb.append("    	<a class=\"return\" href=\"javascript:history.back()\">\n<img src=\"../../imgnews/win8/list_return_btn.png\" width=\"100%\" />\n</a>\n");
		sb.append("        <div class=\"logo\">\n<img src=\"../../imgnews/win8/list_logo.png\" width=\"100%\" />\n</div>\n");
		sb.append("    </div>\n");
		sb.append("    <div id=\"div2\">");
		sb.append("    	<div class=\"tableBox2\">\n");
		
		sb.append(arrangerNewDetail(newMap));
		
		sb.append("<script>\n");
		sb.append("$(function(){\n");
		sb.append("	$(\".logo\").click(function(){\n");
		sb.append("		location.href =\"../../showmain\";\n");
		sb.append("	});\n   });\n");
		sb.append("</script>\n");
		
		sb.append("</div>\n</div>\n</div>\n</body>\n</html>");
		return sb;
	}
	
	private static StringBuffer arrangerNewDetail(Map newMap){
		StringBuffer sb = new StringBuffer();
		sb.append("<table width=\"100%\">\n");
		
		sb.append("<tr><th  style=\"text-align:center;\">"+newMap.get("HEADER")+"</th></tr>\n");
		sb.append("<tr><td style=\"line-height:30px;\">发布时间:&nbsp;"+newMap.get("FBDATE")+"</td></tr>\n");
		sb.append("<tr><td style=\"line-height:30px;\">发布人:&nbsp;"+newMap.get("FBR")+"</td></tr>\n");
		
		sb.append("<tr><td ><h5><img src=\""+newMap.get("FILE_NEW_NAME")+"\" width=\"500\" /><br />"+newMap.get("TPSM")+"</h5></td></tr>\n");
		sb.append("<tr><td style=\"text-indent:48px;\">"+newMap.get("CONTENT")+"</td></tr>\n");
		
		sb.append("</table>\n");
		
		return sb;
	}
}
