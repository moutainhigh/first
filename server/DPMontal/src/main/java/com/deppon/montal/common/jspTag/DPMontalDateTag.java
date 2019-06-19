package com.deppon.montal.common.jspTag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

/**
 * @author 关波
 *
 */
public class DPMontalDateTag  extends BodyTagSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7587997331290462471L;
	
	private static Logger logger = Logger.getLogger(DPMontalDateTag.class);
	
	/** The id. */
	private String id;
	
	private String formate;
	
	private String displayName;
	
	/** The jspType. */
	private String jspType="android";
	
	/** The allow null. 
	 * 该属性主要是用于页面js验证用的
	 * */
	private String allowNull = "false";
	private String nullText = "点击选择时间";
	
	private String locationMessage;
	
	private String isValidate="true";
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

	private StringBuilder makeUp() {
		StringBuilder stringBuffer = new StringBuilder();
		if (displayName == null) {
			displayName = "";
		}
		if (id == null) {
			id = "";
		}
		if (locationMessage == null) {
			locationMessage = "";
		}
		if (formate == null || "".equals(formate)) {
			formate="yyyy-MM-dd";
		}
		if (allowNull == null || "".equals(allowNull)) {
			allowNull  = "false";
		}
		if (isValidate == null || "".equals(isValidate)) {
			isValidate = "true";
		}
		if ("android".equalsIgnoreCase(jspType)) {
			/*<tr class="selector_tdd">
			   <th>工作流号:</th>
			   <td class="searchBox"><input class="text100" onclick="openSelectorView(this,'selectorId')" id="opeanSelectorid" type="text" placeholder="点击选择人员..." />
			<input type="hidden" /></td>
			</tr>*/
			stringBuffer.append("<tr>")
			.append("<th>").append(displayName).append(":</th>")
			.append("<td>")
			.append("<div  class=\"dateDPMontal\">")
			.append("<input")
			.append(" jspTag=\"DPMontalDate\"")
			.append(" id=\"").append(id).append("\"")
			.append(" allowNull=\"").append(allowNull).append("\"")
			.append(" formate=\"").append(formate).append("\"")
			.append(" locationMessage=\"").append(locationMessage).append("\"")
			.append(" isValidate=\"").append(isValidate).append("\"")
			.append(" placeholder=\"").append(nullText).append("\"")
			.append(" onfocus=\"WdatePicker({skin:'default',dateFmt:'").append(formate).append("',isShowClear:true})\"")
			.append(" type=\"text\"").append(" readonly=\"readonly\"")
			.append(" />").append("<em></em></div></td></tr>");
		}else {
			/*<li class="selector_tdd">
		   	<em class="searchBox">
		   		<input class="text100" onclick="openSelectorView(this,'selectorId')" id="opeanSelectorid" type="text" placeholder="点击选择人员..." />
		   		<input type="hidden" />
		   	</em>
		   </li>
		   <li>点击选择日期：
					<div  class="dateDPMontal">
					<input type="text" readonly="readonly" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy-MM-dd',isShowClear:true})">
					<em></em></div>
				</li>
		   */
			stringBuffer.append("<li>")
			.append(displayName).append(":")
			.append("<div  class=\"dateDPMontal\">")
			.append("<input")
			.append(" jspTag=\"DPMontalDate\"")
			.append(" id=\"").append(id).append("\"")
			.append(" allowNull=\"").append(allowNull).append("\"")
			.append(" formate=\"").append(formate).append("\"")
			.append(" locationMessage=\"").append(locationMessage).append("\"")
			.append(" isValidate=\"").append(isValidate).append("\"")
			.append(" placeholder=\"").append(nullText).append("\"")
			.append(" onfocus=\"WdatePicker({skin:'default',dateFmt:'").append(formate).append("',isShowClear:true})\"")
			.append(" type=\"text\"").append(" readonly=\"readonly\"")
			.append(" />").append("<em></em></div></li>");
		}
		return stringBuffer;
	}

	/**
	 * Clear.
	 */
	private void clear() {
		id = null;
		formate = "yyyy-MM-dd";
		jspType="android";
		allowNull = "false";
		nullText = "点击选择时间";
		displayName = "";
		locationMessage = null;
		isValidate="true";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFormate() {
		return formate;
	}

	public void setFormate(String formate) {
		this.formate = formate;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getLocationMessage() {
		return locationMessage;
	}

	public void setLocationMessage(String locationMessage) {
		this.locationMessage = locationMessage;
	}

	public String getIsValidate() {
		return isValidate;
	}

	public void setIsValidate(String isValidate) {
		this.isValidate = isValidate;
	}
}
