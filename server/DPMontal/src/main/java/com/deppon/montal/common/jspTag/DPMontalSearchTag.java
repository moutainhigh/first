package com.deppon.montal.common.jspTag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

/**
 * 本类封装了页面的search标签
 *<f:selector id="" selectorViewId="" searchModel="" jspType="ios" dpmontalTag="dpmontalTag"/>
 * @author 关波
 *
 */
public class DPMontalSearchTag  extends BodyTagSupport {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7587997331290462471L;
	
	private static Logger logger = Logger.getLogger(DPMontalSearchTag.class);
	
	/** The id. */
	private String id;
	
	private String displayName;
	private String locationMessage;
	
	/** The selectorViewId. */
	private String selectorViewId;
	
	/** The search model. 
	 * var selectorModel = {
		store : {
			url : './getSelectorAction',
			pageSize : 2,
			root : 'deptList',
			selectorType :'empSelector'
		},
		displayField : 'EMPNAME',
		valueField : 'EMPCODE',
		queryModel : {
			fields : [ {
				nullText : '请输入员工姓名',
				name : 'empNameQuery',
				type:'text'
			}, {
				nullText : '请输入员工工号',
				name : 'empCodeQuery',
				type:'hidden'
			} ]
		},
		dataModel :{
			fields :[
			         {left:[{"label":"姓名","property":"EMPNAME"},
			                {"label":"职位","property":"JOBNAME"}],
			          right:[{"label":"工号","property":"EMPCODE"},
			                 {"label":"部门","property":"ORGNAME"}]
			         },
			         {right:[{"label":"部门标杆编码","property":"FINASYSCODE","hidden":"hidden"}]
			         }
			        ]
		},
		onWindowOk : function(v) {
			console.log("===");
		}
	};*/
	private String searchModel;
	
	/** The jspType. */
	private String jspType="android";
	
	/** The allow null. 
	 * 该属性主要是用于页面js验证用的
	 * */
	private String allowNull = "false";
	private String nullText = "请输入检索条件";
	
	private String classCSS;
	private String style;
	
	private String isValidate="true";
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		/*private String id;
		
		*//** The selectorViewId. *//*
		private String selectorViewId;
		private String searchModel;
		
		*//** The jspType. *//*
		private String jspType="android";
		
		*//** The allow null. 
		 * 该属性主要是用于页面js验证用的
		 * *//*
		private String allowNull = "false";*/
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
		if (selectorViewId == null) {
			selectorViewId = "selectorView" + id;
		}
		if (displayName == null) {
			displayName = "";
		}
		if ("".equals(id)) {
			System.out.println("id未定义");
		}
		if (classCSS != null) {
			classCSS = "class=\"" + classCSS + "\"";
		}else {
			classCSS = "class=\"\"";
		}
		if (style != null) {
			style = "style=\"" + style + "\"";
		}else {
			style = "style";
		}
		if (isValidate == null || "".equals(isValidate)) {
			isValidate = "true";
		}
		if (jspType.length() == 0) {
			jspType = "android";
		}
		if (allowNull.length() == 0) {
			allowNull = "false";
		}
		if ("android".equalsIgnoreCase(jspType)) {
			/*<tr class="selector_tdd">
			   <th>工作流号:</th>
			   <td class="searchBox"><input class="text100" onclick="openSelectorView(this,'selectorId')" id="opeanSelectorid" type="text" placeholder="点击选择人员..." />
			<input type="hidden" /></td>
			</tr>*/
			stringBuffer.append("<tr ").append(classCSS).append(" "+ style).append(" >")
			.append("<th>").append(displayName).append("：</th>")
			.append("<td class=\"text-search\"><span class=\"icon-search\"  style=\"left:0px\" ><img class=\"imgSearch\" src=\"imgnews/ios/search_icon.png\" /></span>")
			.append("<input type=\"text\" onclick=\"openSelectorView(this,'").append(selectorViewId).append("')\"")
			.append(" jspTag=\"DPMontalSelector\"")
			.append(" allowNull=\"").append(allowNull).append("\"")
			.append(" searchModel=\"").append(searchModel).append("\"")
			.append(" placeholder=\"").append(nullText).append("\"")
			.append(" isValidate=\"").append(isValidate).append("\"")
			.append(" locationMessage=\"").append(locationMessage  == null ? "" : locationMessage).append("\"")
			.append(" id=\"").append(id == null ? "" : id).append("\"")
			.append(" selectorViewId=\"").append(selectorViewId).append("\"")
			.append(" />").append("<input type=\"hidden\" /><span class=\"icon-search\"><img class=\"imgclear\" src=\"imgnews/ios/clear_icon.png\" onclick=\"clearSelector(this)\" /></span></td></tr>");
		}else {
			/*<li class="selector_tdd">
		   	<em class="searchBox">
		   		<input class="text100" onclick="openSelectorView(this,'selectorId')" id="opeanSelectorid" type="text" placeholder="点击选择人员..." />
		   		<input type="hidden" />
		   	</em>
		   </li>
		   <li class="text-search">
		   		<span class="icon-search">
		   			<img class="imgSearch" src="search_icon.png" />
		   		</span>
		   		<input type="text" readonly="readonly" />
		   		<span class="icon-search">
		   			<img class="imgclear" src="clear_icon.png" />
		   		</span>
		   	</li>
		   */
			stringBuffer.append("<li ").append(classCSS).append(" "+ style).append(" >")
			.append(displayName).append(":")
			.append("<em class=\"text-search\"><span class=\"icon-search\" style=\"left:0px\" ><img class=\"imgSearch\" src=\"imgnews/ios/search_icon.png\" /></span>")
			.append("<input type=\"text\" onclick=\"openSelectorView(this,'").append(selectorViewId).append("')\"")
			.append(" jspTag=\"DPMontalSelector\"")
			.append(" allowNull=\"").append(allowNull).append("\"")
			.append(" searchModel=\"").append(searchModel).append("\"")
			.append(" placeholder=\"").append(nullText).append("\"")
			.append(" isValidate=\"").append(isValidate).append("\"")
			.append(" locationMessage=\"").append(locationMessage  == null ? "" : locationMessage).append("\"")
			.append(" id=\"").append(id == null ? "" : id).append("\"")
			.append(" selectorViewId=\"").append(selectorViewId).append("\"")
			.append(" />").append("<input type=\"hidden\" /><span class=\"icon-search\"><img class=\"imgclear\" src=\"imgnews/ios/clear_icon.png\" onclick=\"clearSelector(this)\" /></span></em></li>");
		}
		return stringBuffer;
	}

	/**
	 * Clear.
	 */
	private void clear() {
		id = null;
		displayName = null;
		selectorViewId = null;
		searchModel = null;
		jspType="android";
		allowNull = "false";
		nullText = "";
		classCSS = null;
		style = null;
		isValidate="true";
		locationMessage = null;
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

	public String getSelectorViewId() {
		return selectorViewId;
	}

	public void setSelectorViewId(String selectorViewId) {
		this.selectorViewId = selectorViewId;
	}

	public String getSearchModel() {
		return searchModel;
	}

	public void setSearchModel(String searchModel) {
		this.searchModel = searchModel;
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
}
