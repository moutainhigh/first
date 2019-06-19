package com.deppon.montal.common.jspTag;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import com.deppon.montal.conf.DictEntryService;
import com.deppon.montal.conf.domain.DictEntry;

/**
 * 本类封装了页面的search标签
 *<f:selector id="" selectorViewId="" searchModel="" jspType="ios" dpmontalTag="dpmontalTag"/>
 * @author 关波
 *
 */
public class DPMontalRadioTag  extends BodyTagSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7587997331290462471L;
	
	private static Logger logger = Logger.getLogger(DPMontalSelectTag.class);
	
	/** The id. */
	private String id;
	
	private String displayName;
	
	/** The jspType. */
	private String jspType="android";
	
	/** The allow null. 
	 * 该属性主要是用于页面js验证用的
	 * */
	private String allowNull = "false";
	
	private String defaultCheck = "-1";
	
	private String classCSS;
	
	private String style;
	
	private String isValidate="true";
	
	private String locationMessage;
	
	private String dicttypeid;
	
	private String dictid;
	
	private String onselect;
	
	private String name;
	
	private List<DictEntry> dataLists;
	
	/**
	 * Clear.
	 */
	private void clear() {
		id = null;
		displayName = null;
		jspType = "android";
		allowNull = "false";
		defaultCheck = "-1";
		classCSS = null;
		style = null;
		isValidate = "true";
		locationMessage = null;
		dicttypeid = null;
		dictid = null;
		onselect = null;
		name = null;
	}
	private void handle() {
		if (displayName == null) {
			displayName = "";
		}
		if (jspType.length() == 0) {
			jspType = "android";
		}
		if (isValidate == null || "".equals(isValidate)) {
			isValidate = "true";
		}
		if (classCSS != null) {
			classCSS = "class=\"" + classCSS + "\"";
		}
		if (style != null) {
			style = "style=\"" + style + "\"";
		}else {
			style = "style";
		}
		if (dicttypeid != null) {
			dataLists = DictEntryService.getInstance().getDictEntries(dicttypeid,dictid);
		}
		if (dataLists == null) {
			dataLists = new ArrayList<DictEntry>();
		}
		if (locationMessage == null) {
			locationMessage = "";
		}
		if (defaultCheck.length() == 0) {
			defaultCheck = "-1";
		}
		if (name == null || "".equals("")) {
			name = "radioName";
		}
	}

	private String makeUpOption(){
		StringBuilder stringBuffer = new StringBuilder();
		if ((int) dataLists.size() == 0) {
			return stringBuffer.toString();
		}else {
			//对业务字典 按序号排序
			Collections.sort(dataLists);
			for (DictEntry item : dataLists) {
				if (defaultCheck.equals(item.getDictid())){
					//<input type="radio" value=<%=dicList2.getDictid()%> name="isMyselfSystem" <%=str%> class="inputRemoveDiv"  /><em><%=dicList2.getDictname() %></em>
					stringBuffer.append("<input type=\"radio\" ")
					.append("value=\"")
					.append(item.getDictid())
					.append("\" checked=\"checked\" ")
					.append("name=\"").append(name).append("\" />")
					.append("<em>")
					.append(item.getDictname())
					.append("</em>");
				}else {
					stringBuffer.append("<input type=\"radio\" ")
					.append("value=\"")
					.append(item.getDictid()).append("\" ")
					.append("name=\"").append(name).append("\" />")
					.append("<em>")
					.append(item.getDictname())
					.append("</em>");
				}
			}
			stringBuffer.append("</select>");
		}
		return stringBuffer.toString();
	}
	
	private StringBuilder makeUp() {
		StringBuilder stringBuffer = new StringBuilder();
		handle();
		if ("android".equalsIgnoreCase(jspType)) {
			stringBuffer.append("<tr ").append(classCSS).append(" "+ style)
			.append(" id=\"").append(id).append("\"")
			.append(" jspTag=\"DPMontalRadio\"")
			.append(" allowNull=\"").append(allowNull).append("\"")
			.append(" isValidate=\"").append(isValidate).append("\"")
			.append(" onselect=\"").append(onselect).append("\"")
			.append(" locationMessage=\"").append(locationMessage).append("\"")
			.append(">")
			.append("<th>").append(displayName).append(":</th>")
			.append("<td>")
			.append(makeUpOption())
			.append("</td></tr>");
		}else {
			stringBuffer.append("<li ").append(classCSS).append(" "+ style)
			.append(" id=\"").append(id).append("\"")
			.append(" jspTag=\"DPMontalRadio\"")
			.append(" allowNull=\"").append(allowNull).append("\"")
			.append(" isValidate=\"").append(isValidate).append("\"")
			.append(" onselect=\"").append(onselect).append("\"")
			.append(" locationMessage=\"").append(locationMessage).append("\"")
			.append(">")
			.append(displayName).append(":")
			.append("<em>")
			.append(makeUpOption())
			.append("</em></li>");
		}
		return stringBuffer;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			StringBuilder stringBuffer = makeUp();
			/**
			 * 将stringBuffer输出到页面中
			 * 抛出异常信息
			 * 返回skip_body
			 */
			out.write(stringBuffer.toString());
			clear();
		} catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getJspType() {
		return jspType;
	}

	public void setJspType(String jspType) {
		this.jspType = jspType;
	}

	public String getAllowNull() {
		return allowNull;
	}

	public void setAllowNull(String allowNull) {
		this.allowNull = allowNull;
	}

	public String getClassCSS() {
		return classCSS;
	}

	public void setClassCSS(String classCSS) {
		this.classCSS = classCSS;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	public String getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}
	public String getLocationMessage() {
		return locationMessage;
	}
	public void setLocationMessage(String locationMessage) {
		this.locationMessage = locationMessage;
	}
	public String getDicttypeid() {
		return dicttypeid;
	}
	public void setDicttypeid(String dicttypeid) {
		this.dicttypeid = dicttypeid;
	}
	public String getDictid() {
		return dictid;
	}
	public void setDictid(String dictid) {
		this.dictid = dictid;
	}
	public String getOnselect() {
		return onselect;
	}
	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}
	public String getDefaultCheck() {
		return defaultCheck;
	}
	public void setDefaultCheck(String defaultCheck) {
		this.defaultCheck = defaultCheck;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
}
