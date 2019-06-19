package com.deppon.dpm.tongxunlu.server.action;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.tongxunlu.server.service.ISystemConfigService;
import com.deppon.dpm.tongxunlu.shared.domain.MonitorTime;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.foss.framework.server.context.UserContext;

public class FunctionAccessAction extends BaseAction {

	/**
	 * 功能访问监控的类型<br>
	 * *******************start*******************
	 * 
	 * 200表示----办公平台登录----登录 
	 * 201表示----查询邮件列表----邮件 
	 * 202表示----邮件回复-------邮件
	 * 203表示----邮件单条删除----邮件 
	 * 205表示----邮件详情查看----邮件 
	 * 206表示----发送邮件-------邮件
	 * 207表示----邮件转发-------邮件 
	 * 208表示----查看邮件附件----邮件 
	 * 209表示----转为日程-------邮件
	 * 213表示----点击通讯录，通讯录数据加载----通讯录 
	 * 214表示----组织查询----------------通讯录
	 * 216表示----查看人员详情-------------通讯录 
	 * 218表示----点击任免公告-----------------资讯
	 * 219表示----查看任免公告详情--------------资讯 
	 * 220表示----点击高管随笔-----------------资讯
	 * 222表示----点击新闻动态-----------------资讯 
	 * 223表示----点击违纪--------------------资讯
	 * 224表示----资讯详情，点赞----------------资讯 
	 * 225表示----资讯详情，收藏----------------资讯
	 * 229表示----搜索（资讯模块，左上角搜索入口）----资讯 
	 * 230表示----点击发现，发现数据加载-------发现
	 * 231表示----点击送蛋----------------发现 
	 * 232表示----点击送花----------------发现
	 * 233表示----点击看男生---------------发现 
	 * 234表示----点击看女生---------------发现
	 * 235表示----点击排行榜---------------发现 
	 * 237表示----点击IT服务台，加载未受理数据----IT服务台
	 * 240表示----未受理详情，点击受理----------IT服务台 
	 * 241表示----已受理详情，点击提交----------IT服务台
	 * 247表示----点击日期----日程 
	 * 248表示----点击悬赏----悬赏 
	 * 249表示----悬赏评论----悬赏
	 * 251表示----点击意见反馈----意见反馈 ------------------------------------我---快捷帮助
	 * 252表示----提交意见反馈----意见反馈 
	 * 253表示----点击更多----更多
	 * 255表示--- 版本更新检测 
	 * 259表示----人员关注-------------------------------通讯录---------------
	 * 260表示----点击热线电话----------------------------通讯录 
	 * 262表示----手势验证
	 * 263表示----日程详情------日程 
	 * 264表示----排班信息加载------日程 
	 * 265表示----日程删除------日程
	 * 266表示----当日日程加载------日程 
	 * 267表示----小黄点------日程 
	 * 268表示----悬赏详情------悬赏
	 * 269表示----应用商店-安装 
	 * 270表示----应用商店-更新 
	 * 271表示----手势开关 
	 * 272表示----短信开关------------------------------------------------我---短信设置
	 * 273表示----资讯搜索，搜索历史单条删除 
	 * 274表示----资讯搜索，清空搜索历史 
	 * 275表示----资讯，标签排序
	 * 276表示----我，上传头像 
	 * 277表示----点击人员头像，进入到人员相片（发现排行榜里也有）----通讯录 
	 * 278版本更新
	 * 279表示----在邮件列表，点击查看邮件
	 * 280表示----首页应用排序监控-------------------------首页
	 * 281表示----人员搜索--------------------------------通讯录
	 * 282表示----职责搜索--------------------------------通讯录
	 * 283表示----语音搜索--------------------------------通讯录
	 * 284表示----我的收藏--------------------------------我
	 * 286表示----推荐给好友--------------------------------我
	 * 287表示----邮箱设置--------------------------------我
	 * 288表示----打卡设置--------------------------------我
	 * 290表示----创建-----------------------------------日程
	 * 291表示----搜索-全部-----------------------------------邮箱
	 * 292表示----搜索-发件人-----------------------------------邮箱
	 * 293表示----搜索-主题-----------------------------------邮箱
	 * 294表示----全部回复-----------------------------------邮箱
	 * 295表示----编辑(删除)-----------------------------------邮箱
	 * 296表示----全部已读-----------------------------------邮箱
	 * 297表示----营业部晨会-----------------------------------新闻资讯
	 * 298表示----早安快递-----------------------------------新闻资讯
	 * *******************end*********************
	 */
	
	/**
	 * 模块访问时长监控类型号<br>
	 * *******************start*******************
	 * 1表示----通讯录
	 * 2表示----邮箱
	 * 3表示----IT服务台
	 * 
	 * *******************end*********************
	 */

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -1571440082255970159L;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 监控功能类型
	 */
	private String monitorType;

	/**
	 * 访问使用的设备类型
	 */
	private String osType;

	/**
	 * service
	 */
	private ISystemConfigService systemConfigService;

	/**
	 * 数据监控，监控模块访问时长
	 */
	private MonitorTime monitorTime;

	/**
	 * 功能访问监控
	 */
	public void functionAccessMonitor() {
		// 结果集的定义
		String result = null;
		try {
			// 判断userId是否为空
			if (userId == null) {
				// 从环境中获取userEntity
				UserEntity user = (UserEntity) UserContext.getCurrentUser();
				if (user != null) {
					// 获取工号
					userId = user.getEmpCode();
				}
			}
			// 工号为空，直接返回，不记录
			if (StringUtils.isEmpty(userId))
				return;
			// 访问监控
			systemConfigService.functionAccessMonitor(userId, monitorType,
					osType.toLowerCase());

			// 结果返回
			result = "{\"result\":\"0\",\"errorCode\":\"0\"}";
		} catch (Exception e) {
			// 结果返回
			result = "{\"result\":\"1\",\"errorCode\":\"1\"}";
		}
		// 前端展示
		writeToPage(result);
	}

	/**
	 * 数据监控 监控模块访问时长
	 * 
	 */
	public void monitorTime() {
		// 结果集的定义
		String result = null;
		try {
			// 工号为空，直接返回，不记录
			if (null != monitorTime && StringUtils.isNotEmpty(monitorTime.getEmpCode())) {
				// 访问监控
				systemConfigService.dataMonitorTime(monitorTime);
				// 结果返回
				result = "{\"result\":\"1\",\"errorCode\":\"0\"}";
			} else {
				result = "{\"result\":\"0\",\"errorCode\":\"1\"}";
			}

		} catch (Exception e) {
			// 结果返回
			result = "{\"result\":\"0\",\"errorCode\":\"1\"}";
		}
		// 前端展示
		writeToPage(result);
	}

	/**
	 * getter
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * setter
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public String getMonitorType() {
		return monitorType;
	}

	/**
	 * setter
	 * 
	 * @param monitorType
	 */
	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * setter
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * setter注入
	 * 
	 * @param systemConfigService
	 */
	public void setSystemConfigService(ISystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public MonitorTime getMonitorTime() {
		return monitorTime;
	}

	/**
	 * set
	 * 
	 * @param monitorTime
	 */
	public void setMonitorTime(MonitorTime monitorTime) {
		this.monitorTime = monitorTime;
	}

}
