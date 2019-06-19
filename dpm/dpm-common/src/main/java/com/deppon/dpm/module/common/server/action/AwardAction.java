package com.deppon.dpm.module.common.server.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.service.IAwardService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.AwardDetailEntity;
import com.deppon.dpm.module.common.shared.domain.AwardEntity;
import com.deppon.dpm.module.common.shared.vo.Result;

/**
 * 悬赏
 * 
 * @date 2015-08-28
 * @author 231586
 * 
 */
public class AwardAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1989955782810249L;
	/**
	 * log
	 */
	private static final Logger logger = Logger.getLogger(AwardAction.class);
	/**
	 * 悬赏service
	 */
	private IAwardService awardService;
	/**
	 * 实体参数
	 */
	private AwardDetailEntity entity;
	/**
	 * 文章ID
	 */
	private String articleID;
	/**
	 * 起始页
	 */
	private int start;
	/**
	 * 页面大小
	 */
	private int pageSize = MagicNumber.NUM10;
	/**
	 * 起始条数
	 */
	private int begin;

	/**
	 * 获取悬赏列表信息
	 */
	public void getAwardList() {
		// 获取起始条数
		begin = start * pageSize;
		// 定义返回数据
		int count = 0;
		// 返回数据定义
		Result<List<Map<String, Object>>> result = new Result<List<Map<String, Object>>>();
		// 内部信息定义
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		// 悬赏实体
		List<AwardEntity> awardEntities = new ArrayList<AwardEntity>();
		try {
			// 获取信息
			awardEntities = awardService.getAwardList(begin, pageSize);
			// 循环
			for (AwardEntity awardEntitie : awardEntities) {
				try {
					// 阅读量获取
					count = awardService.setReadingQuantityById(awardEntitie
							.getArticleID());
				} catch (Exception e) {
					// log
					logger.error("悬赏数据阅读量查询错误:" + e.getMessage());
				}
				// 设置阅读量
				awardEntitie.setReadingQuantity(count);
				// 添加实体信息
				res.add(remixRes(awardEntitie));
			}
			// errorCode
			result.setErrorCode(0);
			// errorMessage
			result.setErrorMessage("查询成功");
		} catch (Exception e) {
			// log
			logger.error("悬赏信息查询出错:", e);
			// errorCode
			result.setErrorCode(-1);
			// errorMessage
			result.setErrorMessage("查询出错");
		}
		// 返回数据
		result.setData(res);
		// count
		result.setCount(res.size());
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 获取悬赏详情信息
	 */
	public void getAwardDetail() {
		// 开始条数
		begin = start * pageSize;
		// 用以存放返回给前端的信息,拼接详情和回复
		Result<List<Object>> result = new Result<List<Object>>();
		// 用以存储转换性质后的属性
		List<Object> res = new ArrayList<Object>();
		// 悬赏详情
		List<AwardDetailEntity> awardDetail = new ArrayList<AwardDetailEntity>();
		// 用以存储回帖信息
		Map<String, Object> detailMap = null;
		try {
			// 获取回复信息
			awardDetail = awardService.getAwardDetail(articleID, begin,
					pageSize);
			// 数据监控
			try {
				// 阅读量的插入
				awardService.insertRecord(articleID, userId);
			} catch (Exception e) {
				// log
				logger.error("悬赏数据监控插入出错:" + e.getMessage());
			}
			// 循环添加信息
			for (int i = 0; i < awardDetail.size(); i++) {
				// new 实体
				detailMap = new HashMap<String, Object>();
				// 排序
				detailMap.put("rank", awardDetail.get(i).getId());
				// 创建人
				detailMap.put("From", awardDetail.get(i).getEmpName());
				// 文章ID
				detailMap.put("ID", awardDetail.get(i).getUserId());
				// 内容
				detailMap.put("content", awardDetail.get(i).getSendContent());
				// 回复时间
				detailMap.put("replyTime", formatTime(awardDetail.get(i)
						.getSendTime()));
				// 头像
				detailMap.put("headImage",
						"https://dpm.deppon.com:8881/dpm/headPhoto/"
								+ awardDetail.get(i).getPictPath());
				// 职位
				detailMap.put("jobName", awardDetail.get(i).getJobName());
				// 性别
				detailMap.put("gender", awardDetail.get(i).getGender());
				// 将回复信息添加进去
				res.add(detailMap);
			}
			// errorCode
			result.setErrorCode(0);
			// errorMessage
			result.setErrorMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			// errorCode
			result.setErrorCode(-1);
			// errorMessage
			result.setErrorMessage("查询出错");
		}
		// 返回数据
		result.setData(res);
		// 返回数据量
		result.setCount(awardDetail.size());
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 悬赏回复
	 */
	public void replyTo() {
		// 定义返回结果
		Result<String> result = new Result<String>();
		// 判断
		int res = 0;
		try {
			// 回复插入
			res = awardService.insertReply(entity);
			// > 0 表示成功插入
			if (res > 0) {
				// errorCode
				result.setErrorCode(0);
				// errorMessage
				result.setErrorMessage("Y");
				// data
				result.setData("回复成功");
			} else {
				// errorCode
				result.setErrorCode(1);
				// errorMessage
				result.setErrorMessage("N");
				// data
				result.setData("回复插入失败");
			}
		} catch (Exception e) {
			// log
			logger.error("悬赏回复失败：", e);
			// errorCode
			result.setErrorCode(-1);
			// errorMessage
			result.setErrorMessage("N");
			// data
			result.setData("回复失败");
		}
		// count
		result.setCount(res);
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 将返回结果混合,为了配合前端的命名而更改
	 * 
	 * @return
	 */
	private Map<String, Object> remixRes(AwardEntity awardEntitie) {
		// 定义返回值
		Map<String, Object> awardMap = new HashMap<String, Object>();
		// 文章ID
		awardMap.put("articleID", awardEntitie.getArticleID());
		// 标题拼接
		/*
		 * awardMap.put("title", awardEntitie.getTitle() + "【奖金" +
		 * awardEntitie.getReward() + "元】");
		 */
		awardMap.put("title", awardEntitie.getTitle());
		// 描述
		awardMap.put("distribute", awardEntitie.getRecruitPosition());
		// 子标题
		awardMap.put("subTitle", awardEntitie.getTitle());
		// 发件人
		awardMap.put("from", awardEntitie.getPublisher());
		// 发件人邮箱
		awardMap.put("fromEmail", awardEntitie.getPublisherEmail());
		// 发布时间
		awardMap.put("time", formatTime(awardEntitie.getPublishTime()));
		// 内容
		awardMap.put("content", awardEntitie.getContent());
		// 阅读量
		awardMap.put("count", awardEntitie.getReadingQuantity());
		// 奖金量
		awardMap.put("reward", awardEntitie.getReward());
		// 联系人
		awardMap.put("contactPerson", awardEntitie.getContactPerson());
		// 联系方式
		awardMap.put("contactPhone", awardEntitie.getContactPhone());
		// 返回
		return awardMap;
	}

	// 时间格式化
	private String formatTime(Date date) {
		// 时间格式转换
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * set
	 * 
	 * @param awardService
	 */
	public void setAwardService(IAwardService awardService) {
		this.awardService = awardService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public AwardDetailEntity getEntity() {
		return entity;
	}

	/**
	 * set
	 * 
	 * @param entity
	 */
	public void setEntity(AwardDetailEntity entity) {
		this.entity = entity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getArticleID() {
		return articleID;
	}

	/**
	 * set
	 * 
	 * @param articleID
	 */
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * set
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * get
	 */
	public int getStart() {
		return start;
	}

	/**
	 * set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * set
	 * 
	 * @param begin
	 */
	public void setBegin(int begin) {
		this.begin = begin;
	}
}
