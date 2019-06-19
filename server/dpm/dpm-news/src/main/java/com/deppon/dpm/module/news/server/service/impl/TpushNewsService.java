package com.deppon.dpm.module.news.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.module.news.shared.domain.PushMessage;
import com.techown.tpush.api.MessageResult;
import com.techown.tpush.api.MsgTypeEnum;
import com.techown.tpush.api.Payload;
import com.techown.tpush.api.TPushClient;
import com.techown.tpush.http.BaseURL;

/**
 * @author 046130
 * 
 */
public class TpushNewsService implements ITpushNewsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TpushNewsService.class);
	
	/**
	 * 消息推送地址
	 */
	private TpushAddressService tpushAddressService;
	/**
	 * jdbc模板
	 */
	private JdbcTemplate jdbcTemplate;
	/**
	 * 常量
	 */
	private static int MAXLENGTH_8 = MagicNumber.NUM8;
	/**
	 * 常量
	 */
	private static int MAXLENGTH_80 = MagicNumber.NUM80;
	/**
	 * 推送链接
	 */
	private String url;
	
	/**
	 * 为外部系统调用推送提供的接口
	 */
	@POST
	@Path("pushUserNews")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response pushUserNewsForOtherModule(String json){
		try {
			JSONObject jsonObject = JSON.parseObject(json);
			NewsCenterEntity newsCenterEntity = JSON.parseObject((jsonObject.get("newsCenterEntity")).toString(), NewsCenterEntity.class);
			String pushUserId = (String) jsonObject.get("pushUserId");
			String messageTitle = (String) jsonObject.get("messageTitle");
			String messageContent = (String) jsonObject.get("messageContent");
			String pushResult = this.pushUserNews(pushUserId, messageTitle, messageContent, newsCenterEntity);
			LOG.info("外部系统调用推送接口成功，返回结果：" + pushResult);
			return Response.ok(pushResult).header("ESB-ResultCode", "1").build();
		} catch (Exception e) {
			LOG.error("外部系统调用推送接口出错，json = "+json,e);
			return Response.ok("{\"errcode\":0}").header("ESB-ResultCode", "1").build();
		}
	}

	/**
	 * 对指定工号进行消息推送
	 */
	@Override
	public String pushUserNews(String pushUserId, String messageTitle,
			String messageContent, NewsCenterEntity newsCenterEntity) {
		// 推送结果
		String returnResult = "";
		// 因为可以推送多人，用","隔开
		String[] split = pushUserId.split(",");
		// 推送内容
		String content = messageContent;
		// 推送标题
		String title = messageTitle;
		// 最大
		int maxLength = MAXLENGTH_80;
		// 遍历所有员工
		for (String empCode : split) {
			// uuid
			String uuid = UUID.randomUUID().toString();
			if (isSend(empCode, newsCenterEntity.getB())) {
				TPushClient tpush = obtainTPushClient();
				BaseURL.HOST_NAME = tpushAddressService.getTpushAddress();
				int titleLength = 0;
				int contentLength = 0;
				// 标题不为空
				if (StringUtils.isNotEmpty(title)) {
					titleLength = title.getBytes().length;
				}
				// 内容不为空
				if (StringUtils.isNotEmpty(content)) {
					contentLength = content.getBytes().length;
				}
				if (StringUtils.isNotEmpty(newsCenterEntity.getE())) {// 超链接
					if (contentLength > maxLength) {
						content = messageContent.substring(maxLength
								/ MAXLENGTH_8)
								+ "...";
					}
				}
				if (titleLength + contentLength > MagicNumber.NUM170) {
					// 字数太多，ios接收不到，170是估计的数值，因为还有是否显示小红点，
					// 是否在消息中心显示，推送的id等要显示，而ios默认是支持256bytes
					// 存放到数据库，然后转换成超链接形式

					String sql = "insert into om_push_message values(?,?,?,now())";
					jdbcTemplate.update(sql, new Object[] { uuid, title,
							content }, new int[] { Types.CHAR, Types.VARCHAR,
							Types.VARCHAR });

					if (titleLength > maxLength) {
						title = messageTitle.substring(0, maxLength
								/ MAXLENGTH_8)
								+ "...";
						newsCenterEntity.setF(title);
					}

					/*
					 * if (contentLength > maxLength) { content =
					 * messageContent.substring(0, maxLength / MAXLENGTH_8) +
					 * "..."; }
					 */
					String href = url + "dpmManage/topushhref.action?id="
							+ uuid;
					newsCenterEntity.setE(href);
				}
				MessageResult messageResult = tpush.sendCustomMessageWithAlias(
						empCode, title, content, "", MsgTypeEnum.MESSAGE,
						getPayload(newsCenterEntity));
				returnResult = JSON.toJSONString(messageResult);
				// sonar 整改
				// System.out.println("推送结果：" +
				// JSON.toJSONString(messageResult));
			} else {
				// "该员工没有安装推送的应用"
				returnResult = "{\"errcode\":0,\"errmsg\":\"success\",\"msg_id\":\"ff8080814e95b1c1014eb43e28c20162\",\"response_status\":201}";
			}
		}

		return returnResult;
	}
	
	/**
	 * 是否推送消息<br>
	 * 如果用户安装了该应用，则返回true
	 */
	public boolean isSend(String empCode, int type) {
		// TODO
		if (type == 1 || type == 2) {
			return true;
		}
		// 根据工号查询用户首页所包含的应用信息
		String sql = "select sort_str from apply_store_sort where emp_code = '"
				+ empCode + "'";
		// 查询出应用信息
		String applySort = jdbcTemplate.query(sql,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next())
							return rs.getString("sort_str");
						return null;
					}
				});
		// 不为空
		if (StringUtils.isNotEmpty(applySort)) {
			// 分隔
			StringTokenizer tokenizer = new StringTokenizer(applySort, ",");
			/**
			 * 推送类型<br> 
			 * 
			 * 0 表示我的工资条<br> 
			 * 1 表示HR自助<br>  
			 * 2 表示系统通知<br>  
			 * 3 表示 固定资产<br>
			 * 4表示it服务台<br>  
			 * 5表示我的任务<br> 
			 * 6表示工作流<br> 
			 * 7表示差旅助手<br>
			 */
			/** 
			 * 1 邮箱 2 固定资产 3 IT服务台 4 班车 5 日程 6 差旅助手 7 运营安全 8 人才选拔 9 移动crm 10
			 * 项目管理工具 11 工程巡检 12 快递可视化 13钱包
			 * 有三个固定的（请审批，BI，德邦e站）不在商店展示,我的任务砍了
			 */
			while (tokenizer.hasMoreElements()) {
				// 挨个对比
				int appId = Integer.parseInt((String) tokenizer.nextElement());
				if (judgePusthType(appId, type)){
					return true;
				}
				
			}
		}
		// 返回错误
		return false;
	}
	
	
	private boolean judgePusthType(int appId, int type){
		
		List<String> typesArr = new ArrayList<String>();
		// 我的任务
		typesArr.add(String.valueOf(DpmConstants.TPUSH_MY_TASK));
		// 工作流
		typesArr.add(String.valueOf(DpmConstants.TPUSH_WORK_FLOW));
		// 德邦E站
		typesArr.add(String.valueOf(DpmConstants.TPUSH_DEPPON_E));
		// BI
		typesArr.add(String.valueOf(DpmConstants.TPUSH_BI));
		// 项目管理
		typesArr.add(String.valueOf(DpmConstants.TPUSH_DPPM));
		// 后勤服务
		typesArr.add(String.valueOf(DpmConstants.TPUSH_B_S));
		// 人事服务
		typesArr.add(String.valueOf(DpmConstants.TPUSH_NHR));
		
		

		List<String> apps = new ArrayList<String>();
		// 工资条
		apps.add(String.valueOf(DpmConstants.wage) + "," + String.valueOf(DpmConstants.TPUSH_WAGE));
		// HR自助
		apps.add(String.valueOf(DpmConstants.talentSelection) + "," + String.valueOf(DpmConstants.TPUSH_HR_HELP));
		// 固定资产
		apps.add(String.valueOf(DpmConstants.fixedAssets) + "," + String.valueOf(DpmConstants.TPUSH_FIXED_ASSETS));
		// IT服务台
		apps.add(String.valueOf(DpmConstants.itPlatform) + "," + String.valueOf(DpmConstants.TPUSH_IT_PLATFORM));
		// 差旅助手
		apps.add(String.valueOf(DpmConstants.travelAssistant) + "," + String.valueOf(DpmConstants.TPUSH_TRAVEL_ASSISTANT));
		// 工程管理
		apps.add(String.valueOf(DpmConstants.projectManage) + "," + String.valueOf(DpmConstants.TPUSH_PROJECT_MANAGMENT));
		// 收发室
		apps.add(String.valueOf(DpmConstants.inOut) + "," + String.valueOf(DpmConstants.TPUSH_IN_OUT));
		// 发现
		apps.add(String.valueOf(DpmConstants.discovery) + "," + String.valueOf(DpmConstants.TPUSH_DISCOVERY));
		// crm
		apps.add(String.valueOf(DpmConstants.crm) + "," + String.valueOf(DpmConstants.TPUSH_CRM));

		// 早安快递
		apps.add(String.valueOf(DpmConstants.express) + "," + String.valueOf(DpmConstants.TPUSH_EXPRESS_VISUALIZE));
		// 在线学习 微课堂
		apps.add(String.valueOf(DpmConstants.learning_online) + "," + String.valueOf(DpmConstants.TPUSH_LEARNING_ONLINE));
		// 场地预定
		apps.add(String.valueOf(DpmConstants.venue_booking) + "," + String.valueOf(DpmConstants.TPUSH_VENUE_BOOKING));
		
		if (typesArr.contains(String.valueOf(type)) || apps.contains(String.valueOf(appId) + "," + String.valueOf(type))) {
			return true;
		}
		
		// 工资条
	/*	if ((appId == DpmConstants.wage && type == DpmConstants.TPUSH_WAGE)
				||
				// HR自助
				(appId == DpmConstants.talentSelection && type == DpmConstants.TPUSH_HR_HELP)
				||
				// 固定资产
				(appId == DpmConstants.fixedAssets && type == DpmConstants.TPUSH_FIXED_ASSETS)
				||
				// IT服务台
				(appId == DpmConstants.itPlatform && type == DpmConstants.TPUSH_IT_PLATFORM)
				||
				// 我的任务
				(type == DpmConstants.TPUSH_MY_TASK)
				||
				// 工作流
				(type == DpmConstants.TPUSH_WORK_FLOW)
				||
				// 差旅助手
				(appId == DpmConstants.travelAssistant && type == DpmConstants.TPUSH_TRAVEL_ASSISTANT)
				||
				// 工程管理
				(appId == DpmConstants.projectManage && type == DpmConstants.TPUSH_PROJECT_MANAGMENT)
				||
				// 收发室
				(appId == DpmConstants.inOut && type == DpmConstants.TPUSH_IN_OUT)
				||
				// 德邦E站
				(type == DpmConstants.TPUSH_DEPPON_E)
				||
				// 发现
				(appId == DpmConstants.discovery && type == DpmConstants.TPUSH_DISCOVERY)
				||
				// crm
				(appId == DpmConstants.crm && type == DpmConstants.TPUSH_CRM)
				||
				// BI
				(type == DpmConstants.TPUSH_BI)
				||
				// 早安快递
				(appId == DpmConstants.express && type == DpmConstants.TPUSH_EXPRESS_VISUALIZE)
				||
				// 在线学习 微课堂
				(appId == DpmConstants.learning_online && type == DpmConstants.TPUSH_LEARNING_ONLINE)
				||
				// 场地预定
				(appId == DpmConstants.venue_booking && type == DpmConstants.TPUSH_VENUE_BOOKING)
				||
				// 项目管理
				(type == DpmConstants.TPUSH_DPPM) ||
				// 后勤服务
				(type == DpmConstants.TPUSH_B_S) ||
				// 人事服务
				(type == DpmConstants.TPUSH_NHR)) {
			return true;
		}*/
		return false;
	}
	

	/**
	 * 对所有用户进行推送
	 */
	@Override
	public void pushAllUserNew(String messageTitle, String messageContent,
			NewsCenterEntity newsCenterEntity) {
		// uuid
		String uuid = UUID.randomUUID().toString();
		// 获取tpush客户端
		TPushClient tpush = obtainTPushClient();
		// 获取推送地址
		BaseURL.HOST_NAME = tpushAddressService.getTpushAddress();
		// 标题长度
		int titleLength = 0;
		// 内容长度
		int contentLength = 0;
		// 传过来的标题
		String title = messageTitle;
		// 传过来的内容
		String content = messageContent;
		// 标题不为空
		if (StringUtils.isNotEmpty(title)) {
			// 查看标题长度
			titleLength = title.getBytes().length;
		}
		// 内容不为空
		if (StringUtils.isNotEmpty(content)) {
			// 查看内容长度
			contentLength = content.getBytes().length;
		}
		// 最大长度
		int maxLength = MagicNumber.NUM30;
		// 判断是否含有超链接
		if (StringUtils.isNotEmpty(newsCenterEntity.getE())) {// 超链接
			// 链接长度不能超过30字节
			if (contentLength > maxLength) {
				// 截取显示
				content = messageContent.substring(MagicNumber.NUM10) + "...";
			}
		}
		if (titleLength + contentLength > MagicNumber.NUM170) {
			// 字数太多，ios接收不到，170是估计的数值，因为还有是否显示小红点，
			// 是否在消息中心显示，推送的id等要显示，而ios默认是支持256bytes
			// 存放到数据库，然后转换成超链接形式
			String sql = "insert into om_push_message values(?,?,?,now())";
			// 更新
			jdbcTemplate.update(sql, new Object[] { uuid, title, content },
					new int[] { Types.CHAR, Types.VARCHAR, Types.VARCHAR });
			// 截取显示
			if (titleLength > maxLength) {
				title = messageTitle.substring(0, maxLength) + "...";
				newsCenterEntity.setF(title);
			}
			// 截取显示
			if (contentLength > maxLength) {
				content = messageContent.substring(0, maxLength) + "...";
			}
			// 生成链接
			String href = url + "dpmManage/topushhref.action?id=" + uuid;
			// 换成链接显示
			newsCenterEntity.setE(href);
		}
		// 推送消息
		tpush.sendCustomMessageWithAppKey(title, content, "",
				MsgTypeEnum.MESSAGE, getPayload(newsCenterEntity));
	}

	/**
	 * 整理参数对象
	 * 
	 * @param newsCenterEntity
	 * @return Payload
	 */
	private Payload getPayload(NewsCenterEntity newsCenterEntity) {
		Payload payload = new Payload();
		// 编号
		String a = newsCenterEntity.getA();
		// 不为空
		if (StringUtils.isNotEmpty(a)) {
			// 添加编号
			payload.addParam("a", a);
		}
		// 类型
		int b = newsCenterEntity.getB();
		// 添加类型
		payload.addParam("b", b);
		// 是否显示小红点
		int c = newsCenterEntity.getC();
		// 添加小红点
		payload.addParam("c", c);
		// 是否是消息中心
		int d = newsCenterEntity.getD();
		// 添加消息中心
		payload.addParam("d", d);
		// 超链接
		String e = newsCenterEntity.getE();
		// 时都含有超链接
		if (StringUtils.isNotEmpty(e)) {
			// 添加超链接
			payload.addParam("e", e);
		}
		// 标题
		String f = newsCenterEntity.getF();
		// 标题是否为空
		if (StringUtils.isNotEmpty(f)) {
			// 添加标题
			payload.addParam("f", f);
		}
		// 返回
		return payload;
	}

	/**
	 * 获取推送对象
	 */
	private TPushClient obtainTPushClient() {
		// 推送密钥
		String masterSercret = tpushAddressService.getTpushMasterSercret();
		// 推送appKey
		String appKey = tpushAddressService.getTpushAppKey();
		// 消息存活时间
		int timeToLive = Integer.parseInt(tpushAddressService
				.getTpushTimeLive());
		// 返回推送对象
		return new TPushClient(masterSercret, appKey, timeToLive);
	}

	/**
	 * @author 046130
	 * @since 2015-09-01
	 */
	public Object getMessage(final String uuid) {
		// 获取推送信息sql
		String sql = "select title,content,push_time from om_push_message where uuid = '"
				+ uuid + "'";
		// 查询
		PushMessage query = jdbcTemplate.query(sql,
				new ResultSetExtractor<PushMessage>() {
					@Override
					public PushMessage extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							// 消息实体
							PushMessage message = new PushMessage();
							// 标题
							message.setTitle(rs.getString("title"));
							// 内容
							message.setContent(rs.getString("content"));
							// 发布时间
							message.setPushTime(rs.getTimestamp("push_time"));
							// 返回信息
							return message;
						}
						return null;
					}

				});
		// 返回查询信息
		return query;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * set
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public TpushAddressService getTpushAddressService() {
		return tpushAddressService;
	}

	/**
	 * set
	 * 
	 * @param tpushAddressService
	 */
	public void setTpushAddressService(TpushAddressService tpushAddressService) {
		this.tpushAddressService = tpushAddressService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * set
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
