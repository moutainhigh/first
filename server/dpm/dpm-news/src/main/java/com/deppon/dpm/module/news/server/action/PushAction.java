package com.deppon.dpm.module.news.server.action;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.foss.framework.server.components.security.SecurityNonCheckRequired;

/**
 * 消息推送中转类
 * 
 * @author 245968
 * 
 */
public class PushAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -985457849428421150L;
	/**
	 * set injection
	 */
	private ITpushNewsService iTpushNewsService;
	
	/**
	 * id获取
	 */
	private String id;
	
	/**
	 * 后台管理web页面，跳转到推送页面
	 */
	@SecurityNonCheckRequired
	public String push() {
		// 跳转jsp页面
		return "push";
	}
	
	/**
	 * 后台管理web页面，跳转到选择推送人员页面
	 */
	@SecurityNonCheckRequired
	public String detail() {
		// 跳转jsp页面
		return "detail";

	}

	/**
	 * ios字数有限制，安卓没有。所以讲字数多的截取一部分推送给手机端<br>
	 * 将字多的保存到数据库，手机端已超链接的形式打开网页
	 */
	@SecurityNonCheckRequired
	public String getMessage() {
		// 定义结果集
		Result<Object> result = new Result<Object>();
		// 根据id获取推送信息
		Object object = iTpushNewsService.getMessage(id);
		// 设置信息
		result.setData(object);
		// 前端显示
		writeToPage(object);
		// 返回
		return null;
	}

	/**
	 * 跳转推送字数多时的展示界面
	 */
	@SecurityNonCheckRequired
	public String topushhref() {
		// 跳转jsp页面
		return "topushhref";
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * set
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ITpushNewsService getiTpushNewsService() {
		return iTpushNewsService;
	}

	/**
	 * set
	 * 
	 * @param iTpushNewsService
	 */
	public void setiTpushNewsService(ITpushNewsService iTpushNewsService) {
		this.iTpushNewsService = iTpushNewsService;
	}
}
