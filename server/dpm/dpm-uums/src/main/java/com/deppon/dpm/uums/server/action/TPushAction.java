package com.deppon.dpm.uums.server.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;

/**
 * 推送action
 * 
 * @author 245968
 * 
 */
public class TPushAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 565494465654724022L;
	/**
	 * log
	 */
	private Logger logger = Logger.getLogger(getClass());
	/**
	 * 推送内容
	 */
	private String content;
	/**
	 * 推送标题
	 */
	private String title;
	/**
	 * 推送的工号
	 */
	private String pushUserId;
	/**
	 * 推送类型，0表示我的工资条，1表示HR自助，2表示系统通知
	 */
	private int type;
	/**
	 * 是否是消息中心 0 是 1不是
	 */
	private int isTextNews;
	/**
	 * 是否显示小红点 0显示 1 不显示
	 */
	private int isActive;
	/**
	 * 任务编号
	 */
	private String taskId;
	/**
	 * 超链接
	 */
	private String link;
	/**
	 * 推送服务
	 */
	private ITpushNewsService tpushNewsService;

	/**
	 * 消息推送
	 */
	public void pushMessage() {
		// log
		logger.info("---------推送请求：" + getRequestUrl());
		// 推送返回信息定义
		String pushUserNews = null;
		try {
			// 推送返回信息
			pushUserNews = tpushNewsService.pushUserNews(pushUserId, title,
					content, createNewCenterEntity());
			// 返回前端
			writeToPage(pushUserNews);
		} catch (Exception e) {
			// 错误，返回null
			writeToPage(pushUserNews);
		}
	}

	/**
	 * 推送给全部
	 */
	public void pushAll() {
		// log
		logger.info("---------推送请求：" + getRequestUrl());
		// 全部推送
		tpushNewsService
				.pushAllUserNew(title, content, createNewCenterEntity());
	}

	/**
	 * 新建推送实体
	 * 
	 * @return
	 */
	private NewsCenterEntity createNewCenterEntity() {
		// 新建
		NewsCenterEntity newsCenterEntity = new NewsCenterEntity(taskId, type,
				isActive, isTextNews, link, title);
		// 返回
		return newsCenterEntity;
	}

	/**
	 * 获取请求url
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getRequestUrl() {
		// 用于参数拼接
		StringBuilder builder = new StringBuilder();
		// request
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取请求类型
		builder.append(request.getScheme()).append("://");
		// 获取ip
		builder.append(request.getServerName()).append(":");
		// 获取端口
		builder.append(request.getServerPort());
		// 获取uri
		builder.append(request.getRequestURI());
		// 参数追加
		builder.append("?");
		// 获取参数枚举值
		Enumeration<String> parameterNames = request.getParameterNames();
		// 循环追加
		while (parameterNames.hasMoreElements()) {
			// 是否包含下一个
			String nextElement = parameterNames.nextElement();
			// 追加 参数名=
			builder.append(nextElement + "=");
			// 追加 参数值&
			builder.append(request.getParameter(nextElement) + "&");
		}
		// sb-->string
		String string = builder.toString();
		// 截取最后的&
		String url = string.substring(0, string.length() - 1);
		// 返回url
		return url;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPushUserId() {
		return pushUserId;
	}

	/**
	 * set
	 * 
	 * @param pushUserId
	 */
	public void setPushUserId(String pushUserId) {
		this.pushUserId = pushUserId;
	}

	/**
	 * set
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * set
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ITpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}

	/**
	 * set
	 * 
	 * @param tpushNewsService
	 */
	public void setTpushNewsService(ITpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getType() {
		return type;
	}

	/**
	 * set
	 * 
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLink() {
		return link;
	}

	/**
	 * set
	 * 
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getIsTextNews() {
		return isTextNews;
	}

	/**
	 * set
	 * 
	 * @param isTextNews
	 */
	public void setIsTextNews(int isTextNews) {
		this.isTextNews = isTextNews;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getIsActive() {
		return isActive;
	}

	/**
	 * set
	 * 
	 * @param isActive
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * set
	 * 
	 * @param taskId
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}
