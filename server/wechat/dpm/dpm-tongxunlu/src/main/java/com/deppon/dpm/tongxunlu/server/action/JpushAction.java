package com.deppon.dpm.tongxunlu.server.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.tongxunlu.server.service.IJpushService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 
 * 通讯录服务请求.
 */
public class JpushAction extends BaseAction {

	private static final long serialVersionUID = -4099570287001753597L;

	// set injection
	private IJpushService jpushService;
	// 系统编号
	private String sysCode;
	// 内容
	private String content;
	// 发送对象
	private String toUser;
	// 设备类型
	private String deviceType;
	private String businoId;
	// 设备信息
	private String iphoneToken;
	// 链接地址
	private String url;
	// type：推送的数据类型，如果是空，对两种设备都推送，等于1，只推送iphone的版本更新，等于2只推送android的版本更新；
	// 等于3：只推送iphone的其他信息；等于4：只推送android的其他信息
	private String type;
	// id
	private String id;
	// 是不是强制
	private String force;
	// sum
	private String sum;

	/**
	 * 推送服务
	 */
	// set injection
	private ITpushNewsService iTpushNewsService;

	/**
	 * 推送到一群客户端.
	 * 
	 * @return
	 */
	public void sendMessageToAll() {
		// 定义返回前端参数
		Result<String> res = new Result<String>();
		// 将前台传进来的参数作为对象添加到推送信息上面.
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 拼接内容
		map.put("content", content);
		if (url != null && !"".equals(url.trim())) {
			// 拼接url
			map.put("url", url);
		}
		if (type != null && !"".equals(type.trim())) {
			// 拼接type
			map.put("type", type);
		}
		if (id != null && !"".equals(id.trim())) {
			// 拼接id
			map.put("id", id);
		}
		if (force != null && !"".equals(force.trim())) {
			// 是否强制
			map.put("force", force);
		}
		if (StringUtil.isNotBlank(sum)) {
			// 拼接sum
			map.put("sum", sum);
		} else {
			map.put("sum", "1");
		}
		// 发送通知
		res.setData(jpushService.sendNotification(sysCode, content, map));
		// 设置errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 返回json
		writeToPage(res);
	}

	/**
	 * 推送到指定的客户.
	 */
	public void sendMessageToOne() {
		// 新建推送实体
		NewsCenterEntity entity = new NewsCenterEntity(null, MagicNumber.NUM6, 0, 1, "工作流");
		// entity.setApplicationId(DpmConstants.WORK_FLOW);
		// entity.setActive(DpmConstants.YES);
		// entity.setContent(content);
		// entity.setCreateDate(new Date());
		// entity.setCreateUser(userId);
		// entity.setId(userId);
		// entity.setIsTxtNews(DpmConstants.NO);
		// entity.setModifyDate(new Date());
		try {
			// 推送工作流信息
			iTpushNewsService.pushUserNews(userId, "工作流待办", content, entity);
			// 返回前端
			writeToPage("推送工作流消息成功");
		} catch (Exception e) {
			// 错误信息
			e.printStackTrace();
			// 返回前端
			writeToPage("推送工作流消息失败");
		}
	}

	/**
	 * 返回别名.
	 * 
	 * @return
	 */
	public void setTagAndAlias() {
		// response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 返回实体
		Result<String> res = new Result<String>();
		// 保存别名
		String token = jpushService.saveTagAndAlias(businoId, sysCode,
				deviceType, iphoneToken);
		// token
		res.setData(token);
		//errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 返回json
		writeToPage(response, res);
	}

	/**
	 * 删除别名和标签.
	 * 
	 * @return
	 */
	public void deleteTagAndAlias() {
		// response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 返回实体
		Result<String> res = new Result<String>();
		// 删除别名
		jpushService.deleteTagAndAlias(businoId, sysCode, deviceType);
		// 提示信息
		res.setData("删除成功.");
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 返回json
		writeToPage(response, res);
	}

	// get
	public ITpushNewsService getiTpushNewsService() {
		return iTpushNewsService;
	}

	// set
	public void setiTpushNewsService(ITpushNewsService iTpushNewsService) {
		this.iTpushNewsService = iTpushNewsService;
	}

	/**
	 * @return sum
	 */
	// get
	public String getSum() {
		return sum;
	}

	/**
	 * @param sum
	 *            要设置的 sum
	 */
	// set
	public void setSum(String sum) {
		this.sum = sum;
	}

	// get
	public String getForce() {
		return force;
	}

	// set
	public void setForce(String force) {
		this.force = force;
	}

	// get
	public String getUrl() {
		return url;
	}

	// set
	public void setUrl(String url) {
		this.url = url;
	}

	// get
	public String getType() {
		return type;
	}

	// set
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return jpushService
	 */
	// get
	public IJpushService getJpushService() {
		return jpushService;
	}

	/**
	 * @param jpushService
	 *            要设置的 jpushService
	 */
	// set
	public void setJpushService(IJpushService jpushService) {
		this.jpushService = jpushService;
	}

	// get
	public String getId() {
		return id;
	}

	// set
	public void setId(String id) {
		this.id = id;
	}

	// get
	public String getIphoneToken() {
		return iphoneToken;
	}

	// set
	public void setIphoneToken(String iphoneToken) {
		this.iphoneToken = iphoneToken;
	}

	// get
	public String getSysCode() {
		return sysCode;
	}

	// set
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	// get
	public String getDeviceType() {
		return deviceType;
	}

	// set
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	// get
	public String getBusinoId() {
		return businoId;
	}

	// set
	public void setBusinoId(String businoId) {
		this.businoId = businoId;
	}

	// get
	public String getToUser() {
		return toUser;
	}

	// set
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	// get
	public String getContent() {
		return content;
	}

	// set
	public void setContent(String content) {
		this.content = content;
	}

}
