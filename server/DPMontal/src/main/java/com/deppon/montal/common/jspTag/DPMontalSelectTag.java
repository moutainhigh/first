package com.deppon.montal.common.jspTag;


import java.util.ArrayList;
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
public class DPMontalSelectTag  extends BodyTagSupport {
	
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
	
	private String nullText = "--请选择--";
	
	private String classCSS;
	
	private String style;
	
	private String isValidate="true";
	
	private String locationMessage;
	
	private String dicttypeid;
	
	private String dictid;
	
	private String onselect;
	
	private List<DictEntry> dataLists;
	
	private String optionValue = "default";
	
	private String optionStr = "";
	/**
	 * Clear.
	 */
	private void clear() {
		id = null;
		displayName = null;
		jspType = "android";
		allowNull = "false";
		nullText =  "--请选择--";
		classCSS = null;
		style = null;
		isValidate = "true";
		locationMessage = null;
		dicttypeid = null;
		dictid = null;
		onselect = null;
	}
	private void handle() {
		if (displayName == null) {
			displayName = "";
		}
		if (jspType.length() == 0) {
			jspType = "android";
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
		if ("".equals(nullText)) {
			nullText = "--请选择--";
		}
		if (allowNull.length() == 0) {
			allowNull = "false";
		}
		if (isValidate == null || "".equals(isValidate)) {
			isValidate = "true";
		}
		for (DictEntry item : dataLists) {
			if (nullText.equals(item.getDictname())) {
				optionValue = item.getDictid();
				optionStr = "<option value=\"default\">" + item.getDictname() + "</option>";
				break;
			}
		}
		if ("default".equals(optionValue)) {
			optionStr = "<option value=\"default\">" + nullText + "</option>";
		}
	}

	private String makeUpOption(){
		StringBuilder stringBuffer = new StringBuilder();
		if ((int) dataLists.size() == 0) {
			if ("default".equals(optionValue)) {
				stringBuffer.append("<select>")
				.append(optionStr)
				.append("</select>");
			}
			return stringBuffer.toString();
		}else {
			stringBuffer.append("<select>");
			if ("default".equals(optionValue)) {
				stringBuffer.append(optionStr);
			}
			for (DictEntry item : dataLists) {
				if (optionValue.equals(item.getDictid())){
					//<option value=<%=dicList.getDictid()%>><%=dicList.getDictname()%></option>
					stringBuffer.append("<option ")
					.append("value=\"")
					.append(item.getDictid())
					.append("\" checked=\"checked\" >")
					.append(item.getDictname())
					.append("</option>");
				}else {
					stringBuffer.append("<option ")
					.append("value=\"")
					.append(item.getDictid())
					.append("\" >")
					.append(item.getDictname())
					.append("</option>");
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
			.append(" jspTag=\"DPMontalSelectOption\"")
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
			.append(" jspTag=\"DPMontalSelectOption\"")
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

	public String getNullText() {
		return nullText;
	}

	public void setNullText(String nullText) {
		this.nullText = nullText;
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
}
