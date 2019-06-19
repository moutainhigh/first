package com.deppon.dpm.module.announce.server.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.module.announce.server.service.IAnnounceService;
import com.deppon.dpm.module.announce.server.service.impl.AnnounceJob;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;
import com.deppon.dpm.module.announce.shared.vo.AnnounceIndexResult;
import com.deppon.dpm.module.announce.shared.vo.AnnounceResult;
import com.deppon.dpm.module.announce.shared.vo.AnnounceUserResult;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.server.util.WhetherMonitorCutffPoint;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.Result;

/**
 * 登陆服务的控制转发类.
 * 
 * @author 045925
 * 
 */
public class AnnounceAction extends BaseAction {
	private static final long serialVersionUID = 1397420409043898745L;
	// 起始条数
	private int pageSize = 0;
	// 公告ID
	private String announceId;
	// 操作类型
	private String optType;
	// 操作状态
	private String optState;
	// set injection
	private IAnnounceService announceService;
	
	// set injection
	private AnnounceJob announceJob;
	
	// 公告详细分类的参数 0-营运 1-职能 2-项目
	private String type = "0";
	// 搜索的字符串
	private String searchString;
	// 收藏自负
	private String myCollsJsonStr;
	private static final int totalNums = 390;

	/**
	 * 查询高管随笔
	 */
	@WhetherMonitorCutffPoint
	public void queryCommonAnnounces() {
		// 一页显示多少条
		int limit = MagicNumber.NUM10;
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 查询参数
		AnnounceDto dto = new AnnounceDto();
		// 查询参数为高管随笔
		dto.setType("LEADER_NOTES");
		// 起始值
		start = pageSize * limit;
		// 通过查询参数查询的返回值
		List<AnnounceEntity> announceList = announceService.queryCommonAll(
				limit, start, dto);
		// 封装list
		AnnounceResult announceResult = new AnnounceResult();
		// 设置返回实体
		announceResult.setAnnounceList(announceList);
		// 返回实体 AnnounceResult = announceList
		Result<AnnounceResult> res = new Result<AnnounceResult>();
		// 包含的数据
		res.setData(announceResult);
		// 包含数据的数量
		res.setCount(announceList.size());
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 前端返回
		writeToPage(response, res);
	}

	/**
	 * 查询违纪信息
	 */
	@WhetherMonitorCutffPoint
	public void queryBreachPrinciple() {
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 一页显示多少条
		int limit = MagicNumber.NUM10;
		// 查询参数
		AnnounceDto dto = new AnnounceDto();
		// 查询参数为违纪信息
		dto.setType("BREACH_PRINCIPLE");
		// 起始值
		start = pageSize * limit;
		// 通过查询参数查询的返回值
		List<AnnounceEntity> entitys = announceService.queryCommonAll(limit,
				start, dto);
		// 封装list
		AnnounceResult result = new AnnounceResult();
		// 设置返回实体
		result.setAnnounceList(entitys);
		// 返回实体 AnnounceResult = announceList
		Result<AnnounceResult> res = new Result<AnnounceResult>();
		// 包含的数据
		res.setData(result);
		// 包含数据的数量
		res.setCount(entitys.size());
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 前端返回
		writeToPage(res);
	}

	/**
	 * 查询任免公告
	 */
	@WhetherMonitorCutffPoint
	public void queryCommonNotices() {
		// 一页显示多少条
		int limit = MagicNumber.NUM10;
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 查询参数
		AnnounceDto dto = new AnnounceDto();
		// 任免公告分类
		String[] detailType = { "营运", "职能", "项目" };
		// 查询参数为任免公告
		dto.setType("ANNOUNCE");
		// 起始值
		start = pageSize * limit;
		// 传入类型对比
		if ("0".equals(type)) {
			// 营运的任免公告
			dto.setDetailType(detailType[0]);
		} else if ("1".equals(type)) {
			// 职能的任免公告
			dto.setDetailType(detailType[1]);
		} else {
			// 项目的任免公告
			dto.setDetailType(detailType[2]);
		}
		// 通过查询参数查询的返回值
		List<AnnounceEntity> announceList = announceService.queryCommonAll(
				limit, start, dto);
		// 封装list
		AnnounceResult announceResult = new AnnounceResult();
		// 设置返回实体
		announceResult.setAnnounceList(announceList);
		// 返回实体 AnnounceResult = announceList
		Result<AnnounceResult> res = new Result<AnnounceResult>();
		// 包含的数据
		res.setData(announceResult);
		// 包含数据的数量
		res.setCount(announceList.size());
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		// errorMessage
		res.setErrorMessage("");
		// 前端返回
		writeToPage(response, res);
	}

	/**
	 * 更新收藏、点赞
	 */
	public void operateAnnounce() {
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 查询参数
		AnnounceDto dto = new AnnounceDto();
		//参数校验
		if(ParamUtils.checkUserId(userId)){
			Result<Object> result = new Result<Object>();
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
		}
		// 参数为公告对应的id
		dto.setId(announceId);
		// 工号
		dto.setUserId(userId);
		// sure cacel
		dto.setOptType(optType);
		// read collection priase
		dto.setType(optState);
		// 操作表
		int row = announceService.updateAnnounceState(dto);
		// 返回值
		String message = "SUCCESS";
		if (row == 0) {
			// 为0表示失败
			message = "ERROR";
		}
		// 前端展示
		writeToPage(response, message);
	}

	/**
	 * 查询公告详情
	 */
	@WhetherMonitorCutffPoint
	public void queryAnnounceDetail() {
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//参数校验
		if(ParamUtils.checkUserId(userId)){
			Result<Object> result = new Result<Object>();
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
		}
		// 体检查询
		AnnounceEntity entity = announceService.queryDetialRead(announceId,
				userId);
		if (entity != null) {
			// 通过查询参数查询的返回值
			Result<AnnounceEntity> res = new Result<AnnounceEntity>();
			// 设置返回实体
			res.setData(entity);
			// 包含数据的数量
			res.setCount(1);
			// errorCode
			res.setErrorCode(Constants.SUCCESS);
			// 前端返回
			writeToPage(response, res);
		} else {
			String message = "ERROR";
			// 前端返回
			writeToPage(response, message);
		}
	}

	/**
	 * 查询新闻资讯
	 */
	public void queryIndexNews() {
		int newslimit = MagicNumber.NUM10;
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 查询参数
		AnnounceDto dto = new AnnounceDto();
		// 查询参数为新闻
		dto.setType("NEWS");
		// 剔除掉滚动新闻
		// 起始值
		start = pageSize * newslimit;
		// 通过查询参数查询的返回值
		List<AnnounceEntity> normalNews = announceService.queryNormalNews(
				newslimit, start);
		// 滚动新闻
		List<AnnounceEntity> scrollNews = announceService.queryScrollNews();
		
		/*******兼容android3.8.9及以下版本的bug  start******/
		String osType = ThreadLocalUtil.getThreadLocal().getOsType();
		String appVersion = ThreadLocalUtil.getThreadLocal().getAppVersion();
		int intVal = 0;
		try {
			intVal = Integer.parseInt(appVersion.replace(".", ""));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		if("android".equalsIgnoreCase(osType) && intVal < totalNums 
				&& scrollNews.size() > normalNews.size()) {
			int num = scrollNews.size() - normalNews.size();
			normalNews.addAll(normalNews.size(), scrollNews.subList(0, num));
		}
		/*******兼容android3.8.9及以下版本你的bug  end******/
		
		// 封装list
		AnnounceIndexResult announceIndexResult = new AnnounceIndexResult();
		// 设置列表新闻
		announceIndexResult.setNormalNews(normalNews);
		// 何止滚动新闻
		announceIndexResult.setScrollNews(scrollNews);
		// 设置返回实体
		Result<AnnounceIndexResult> res = new Result<AnnounceIndexResult>();
		// 包含的数据
		res.setData(announceIndexResult);
		// 包含数据的数量
		res.setCount(2);
		// errorCode
		res.setErrorCode(Constants.SUCCESS);
		// 前端返回
		writeToPages(response, res);
	}
	
	
	

	public void writeToPages(HttpServletResponse response,
			Result<AnnounceIndexResult> res) {
		// 定义输出流
				PrintWriter writer = null;
				try {
					if (response == null) {
						response = ServletActionContext.getResponse();
					}
					// 设置响应类型
					response.setContentType("text/html;charset=utf-8");
					// 跨域设置
					response.setHeader("Access-Control-Allow-Origin", "*");
					// 获取一个printWriter对象
					writer = response.getWriter();
					// 打印,将null值输出为空字符串
					writer.write(JSON.toJSONString(res,SerializerFeature.DisableCircularReferenceDetect));
				} catch (IOException e) {
					// 错误打印
					e.printStackTrace();
				} finally {
					if (writer != null) {
						// 关闭流
						writer.close();
					}
				}
		
	}

	/**
	 * 我的收藏
	 * 
	 * @return
	 */
	public void queryMyCollections() {
		// 设置返回实体
		Result<AnnounceUserResult> res = new Result<AnnounceUserResult>();
		// response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 更具工号查询我的收藏
		List<AnnounceUserEntity> announceUserList = announceService
				.queryMyCollectAll(userId);
		if (null != announceUserList && announceUserList.size() > 0) {
			// 返回实体 AnnounceUserResult = announceUserList
			AnnounceUserResult data = new AnnounceUserResult();
			// 封装list
			data.setAnnounceUserList(announceUserList);
			
			// 包含的数据
			res.setData(data);
			// 包含数据的数量
			res.setCount(announceUserList.size());
			// errorCode
			res.setErrorCode(Constants.SUCCESS);
			// 前端返回
			writeToPage(response, res);
		} else {
			AnnounceUserResult data = new AnnounceUserResult();
			// 返回信息
			List<AnnounceUserEntity> arrayList = new ArrayList<AnnounceUserEntity>();
			data.setAnnounceUserList(arrayList);
			res.setData(data);
			// 包含数据的数量
			res.setCount(0);
			// errorCode
			res.setErrorCode(Constants.SUCCESS);
			// 前端返回
			writeToPage(response, res);
			//writeToPage(response, message);
		}
	}

	/**
	 * 删除我的收藏
	 */
	public void deleteMyColls() {
		// response
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 删除我的收藏
		int row = announceService.deleteMyColls(myCollsJsonStr);
		// 返回信息
		String message = "SUCCESS";
		if (row == 0) {
			// 返回信息
			message = "ERROR";
		}
		// 前端返回
		writeToPage(response, message);
	}

	/**
	 * 搜索结果展示
	 * 
	 * @author 231586
	 */
	@WhetherMonitorCutffPoint
	public void searchInter() {
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 定义返回值类型
		List<AnnounceEntity> lists = null;
		// 定义返回前端
		Result<List<AnnounceEntity>> result = null;
		// 一页显示多少条
		int limit = MagicNumber.NUM20;
		// 起始值
		start = pageSize * limit;
		// 通过查询参数查询的返回值
		lists = announceService.getSearchResult(searchString, limit, start);
		// 结果集
		result = new Result<List<AnnounceEntity>>();
		// 包含数据的数量
		result.setCount(lists.size());
		// 包含的数据
		result.setData(lists);
		// errorMessage
		result.setErrorMessage(Constants.ACTIVE_YES);
		// 返回
		writeToPage(result);
	}

	/**
	 * 搜索结果详情
	 * 
	 * @author 231586
	 */
	@WhetherMonitorCutffPoint
	public void searchInterDetail() {
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 搜多结果详情数据
		AnnounceEntity announceEntity = announceService
				.getDetailSearchResultByAnnounceId(searchString, announceId,
						userId);
		// 结果集
		Result<AnnounceEntity> detailResult = new Result<AnnounceEntity>();
		// 包含数据的数量
		detailResult.setCount(0);
		// 包含的数据
		detailResult.setData(announceEntity);
		// errorCode
		detailResult.setErrorCode(Constants.ACTION_RESULT_SUC);
		// errorMessage
		detailResult.setErrorMessage(Constants.ACTIVE_YES);
		// 前端返回
		writeToPage(detailResult);
	}

	// get
	public int getPageSize() {
		return pageSize;
	}

	// set
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// get
	public String getAnnounceId() {
		return announceId;
	}

	// set
	public void setAnnounceId(String announceId) {
		this.announceId = announceId;
	}

	// get
	public String getOptType() {
		return optType;
	}

	// set
	public void setOptType(String optType) {
		this.optType = optType;
	}

	// get
	public String getOptState() {
		return optState;
	}

	// set
	public void setOptState(String optState) {
		this.optState = optState;
	}

	// get
	public String getMyCollsJsonStr() {
		return myCollsJsonStr;
	}

	// set
	public void setMyCollsJsonStr(String myCollsJsonStr) {
		this.myCollsJsonStr = myCollsJsonStr;
	}

	// set
	public void setAnnounceService(IAnnounceService announceService) {
		this.announceService = announceService;
	}

	// get
	public String getType() {
		return type;
	}

	// set
	public void setType(String type) {
		this.type = type;
	}

	// get
	public String getSearchString() {
		return searchString;
	}

	// set
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public AnnounceJob getAnnounceJob() {
		return announceJob;
	}

	public void setAnnounceJob(AnnounceJob announceJob) {
		this.announceJob = announceJob;
	}
	
	@CookieNotCheckedRequired
	public void changeJob(){
		// response请求
		HttpServletResponse response = ServletActionContext.getResponse();
		// 处理跨域请求
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许的请求方式
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// 允许的请求消息头
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 搜多结果详情数据
		announceJob.changeJob();
		// 结果集
		Result<AnnounceEntity> detailResult = new Result<AnnounceEntity>();
		// 包含数据的数量
		detailResult.setCount(0);
		// 包含的数据
		detailResult.setData(null);
		// errorCode
		detailResult.setErrorCode(Constants.ACTION_RESULT_SUC);
		// errorMessage
		detailResult.setErrorMessage(Constants.ACTIVE_YES);
		// 前端返回
		writeToPage(detailResult);
	}

}
