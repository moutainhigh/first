package com.deppon.dpm.module.announce.server.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.deppon.dpm.module.announce.server.dao.IAnnounceDao;
import com.deppon.dpm.module.announce.server.service.IAnnounceService;
import com.deppon.dpm.module.announce.server.service.IAnnounceUserService;
import com.deppon.dpm.module.announce.shared.define.ConstansUtil;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.domain.AnnounceUserEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;
import com.deppon.dpm.module.announce.shared.util.UUIDUtils;
import com.deppon.dpm.module.common.server.util.MagicNumber;

/**
 * 
 * @ClassName: AnnounceService
 * @Description: 公告管理Service实现类
 * @author 045925/YANGBIN
 * @date 2015-3-18 下午3:32:20
 * 
 */
public class AnnounceService implements IAnnounceService {
	private static final Logger logger = Logger.getLogger(AnnounceService.class);
	/**
	 * set injection
	 */
	private IAnnounceDao announceDao;
	/**
	 * set injection
	 */
	private IAnnounceUserService announceUserService;
	/**
	 * set injection
	 */
	private String webUrl;
	/**
	 * set injection
	 */
	private IAnnounceService announceService;

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入公告
	 * @param @param entity
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
//	@Transactional("transactionManager")
	public int insert(AnnounceEntity entity) {
		// 生成uuid
		String id = UUIDUtils.getUUID();
		// 创建时间
		Date createDate = new Date();
		// uuid
		entity.setId(id);
		// 收藏数
		entity.setCollectionNum(0);
		// 阅读数
		entity.setReadNum(0);
		// 点赞数
		entity.setPraiseNum(0);
		// 设置创建人
		entity.setCreateUserCode("000000");
		// 设置创建人姓名
		entity.setCreateUserName("system");
		// 创建时间
		entity.setCreateTime(createDate);
		// 插入
		return announceDao.insert(entity);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 更新公告
	 * @param @param entity
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
	public int update(AnnounceEntity entity) {
		// 如果公告ID为空，返回0
		if (StringUtils.isEmpty(entity.getId())) {
			return 0;
		}
		// 设置更新时间
		entity.setModifyTime(new Date());
		// 设置修改人工号
		entity.setModifyUserCode("000000");
		// 设置修改人姓名
		entity.setModifyUserName("system");
		// 更新
		return announceDao.update(entity);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 根据ID删除公告
	 * @param @param id
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
	public int delete(String id) {
		// 如果公告ID为空，返回0
		if (StringUtils.isEmpty(id)) {
			return 0;
		}
		// 删除
		return announceDao.delete(id);
	}

	/**
	 * 
	 * @Title: queryCommonAll
	 * @Description: 分页查询公告
	 * @param @param limit
	 * @param @param start
	 * @param @param queryParam
	 * @param @return 设定文件
	 * @return List<AnnounceEntity> 返回类型
	 * @throws
	 */
	@Override
	public List<AnnounceEntity> queryCommonAll(int limit, int start,
			AnnounceDto queryParam) {
		// 获取类型
		String type = queryParam.getType();
		// 判断类型是否为高管随笔，如果是高管随笔，则不设置查询时间
		if (null != type
				&& (!type.equals(ConstansUtil.LEADER_NOTES) )) {
			// 获取日期时间
			Calendar currCalendar = Calendar.getInstance();
			// 获取截止时间
			Date endTime = currCalendar.getTime();
			// 当前月
			int currmonth = currCalendar.get(Calendar.MONTH) + 1;
			// 前三个月
			currCalendar.set(Calendar.MONTH, currmonth - MagicNumber.NUM4);
			// 前三个月对应的时间点
			Date startTime = currCalendar.getTime();
			// 设置查询开始时间
			queryParam.setStartTime(startTime);
			// 设置查询结束时间
			queryParam.setEndTime(endTime);
		}
		// 查询结果
		List<AnnounceEntity> list = announceDao.queryCommonAll(limit, start,
				queryParam);
		// 定义新结果集
		List<AnnounceEntity> newList = new ArrayList<AnnounceEntity>();
		if (CollectionUtils.isNotEmpty(list) && list.size() > 0) {
			// 不为空进行循环
			for (AnnounceEntity entity : list) {
				// 获取标题
				String title = entity.getTitle().trim();
				// 标题分隔
				String newTitle = splitTitle(title);
				// 无需加载内容
				entity.setContent("");
				// 新标题
				entity.setTitle(newTitle);
				// 新结果集
				newList.add(entity);
			}
		}
		if (newList.size() > 0) {
			// 返回
			return newList;
		}
		// 返回
		return list;
	}

	/**
	 * 标题分隔
	 * 
	 * @param title
	 * @return
	 */
	private String splitTitle(String title) {
		// 如果标题为空，直接返回
		if (StringUtils.isEmpty(title)) {
			return "";
		}
		// 定义返回标题
		String newTitle = "";
		// 截取起始位置
//		int start = title.lastIndexOf("】") + 1;
//		// 截取结束为止
//		int end = title.length();
//		// 子字符串
		String subStr = null;
//		if (start >= 0) {
//			// 截取
//			subStr = title.substring(start, end);
//		} else {
			// 截取
			subStr = title;
		//}
		// 截取
		int index = subStr.lastIndexOf("(图)");
		if (index >= 0) {
			// 截取
			newTitle = subStr.substring(0, subStr.length() - MagicNumber.NUM3);
		} else {
			// 截取
			newTitle = subStr;
		}
		// 返回
		return newTitle;
	}

	/**
	 * 
	 * @Title: queryCommonCount
	 * @Description: 根据查询参数返回公告条数
	 * @param @param queryParam
	 * @param @return 设定文件
	 * @return Long 返回类型
	 * @throws
	 */
	@Override
	public Long queryCommonCount(AnnounceDto queryParam) {
		// 获取类型
		String type = queryParam.getType();
		// 判断类型是否为高管随笔，如果是高管随笔，则不设置查询时间
		if (null != type && !type.equals(ConstansUtil.LEADER_NOTES)) {
			// 当前时间
			Calendar currCalendar = Calendar.getInstance();
			// 结束时间
			Date endTime = currCalendar.getTime();
			// 当前月
			int currmonth = currCalendar.get(Calendar.MONTH) + 1;
			// 两个月前
			currCalendar.set(Calendar.MONTH, currmonth - MagicNumber.NUM3);
			// 查询开始时间
			Date startTime = currCalendar.getTime();
			// 设置时间
			queryParam.setStartTime(startTime);
			// 设置时间
			queryParam.setEndTime(endTime);
		}
		// 结果查询
		return announceDao.queryCommonCount(queryParam);
	}

	@Override
//	@Transactional("transactionManager")
	/**
	 * 更改公告状态
	 */
	public int updateAnnounceState(AnnounceDto dto) {
		// 信息id
		String id = dto.getId();
		// 工号
		String userId = dto.getUserId();
		// 操作状态为空 返回
		if (StringUtils.isEmpty(dto.getOptType())) {
			return 0;
		}
		// 如果公告id或者员工工号不为空
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(userId)) {
			return updateAnnounceTypeNum(dto);
		}
		// 返回
		return 0;
	}

	/**
	 * 更改公告点赞数
	 * 
	 * @param dto
	 * @return
	 */
	private int updateAnnounceTypeNum(AnnounceDto dto) {
		// 信息id
		String id = dto.getId();
		// 为0直接返回
		if (StringUtils.isEmpty(id)) {
			return 0;
		}
		// 查询参数
		AnnounceDto queryParamDto = new AnnounceDto();
		// 条件
		queryParamDto.setId(id);
		// 查询结果
		AnnounceEntity entity = announceDao.queryCommonOne(queryParamDto);
		if (null == entity) {
			return 0;
		}
		// 标题
		String title = splitTitle(entity.getTitle());
		int updateRow = operateAnnounceUser(dto, title);
		if (updateRow == 0) {
			return 0;
		}
		// 收藏数展示
		int collectionNum = entity.getCollectionNum() == null ? 0 : entity
				.getCollectionNum();
		// 点赞数展示
		int praiseNum = entity.getPraiseNum() == null ? 0 : entity
				.getPraiseNum();
		// 阅读数展示
		int readNum = entity.getReadNum() == null ? 0 : entity.getReadNum();
		// 如果操作状态为确认,查看是否存在数据
		if (ConstansUtil.OPERATE_SURE.equals(dto.getOptType())) {
			// 判断公告操作类型，如果是收藏
			if (ConstansUtil.COLLECTION.equals(dto.getType())) {
				collectionNum = collectionNum + 1;
			}
			// 判断公告操作类型，如果是点赞
			else if (ConstansUtil.PRAISE.equals(dto.getType())) {
				praiseNum = praiseNum + 1;
			}
			// 判断公告操作类型，如果是阅读
			else if (ConstansUtil.READ.equals(dto.getType())) {
				readNum = readNum + 1;
			}
		} else if (ConstansUtil.OPERATE_CANCEL.equals(dto.getOptType())) {
			// 判断公告操作类型，如果是收藏
			if (ConstansUtil.COLLECTION.equals(dto.getType())) {
				if (collectionNum > 0) {
					collectionNum = collectionNum - 1;
				}
			}
			// 判断公告操作类型，如果是点赞
			else if (ConstansUtil.PRAISE.equals(dto.getType())) {
				if (praiseNum > 0) {
					praiseNum = praiseNum - 1;
				}
			}
		}
		// 返回实体类
		AnnounceEntity updateEntity = new AnnounceEntity();
		// 对应id
		updateEntity.setId(entity.getId());
		// 收藏数
		updateEntity.setCollectionNum(collectionNum);
		// 阅读数
		updateEntity.setReadNum(readNum);
		// 点赞数
		updateEntity.setPraiseNum(praiseNum);
		// 返回影响行数
		return update(updateEntity);
	}

	/**
	 * 数据操作
	 * 
	 * @param dto
	 * @param title
	 * @return
	 */
	private int operateAnnounceUser(AnnounceDto dto, String title) {
		// 初始化返回数据
		int row = 0;
		// 定义type
		String type = dto.getType();
		// type不能为空
		if (StringUtils.isEmpty(dto.getOptType())) {
			return 0;
		}
		// type为阅读类型
		if (ConstansUtil.READ.equals(type)) {
			return 0;
		}
		// 实例化操作实体
		AnnounceUserEntity queryParam = new AnnounceUserEntity();
		// 设置对应的oaID
		queryParam.setAppAnnounceId(dto.getId());
		// 设置操作人
		queryParam.setEmpCode(dto.getUserId());
		// 设置操作类型
		queryParam.setType(dto.getType());
		// 通过参数查询该操作是否存在
		String id = announceUserService.queryCommonId(queryParam);
		// 实例化
		AnnounceDto queryParamDto = new AnnounceDto();
		// 设置对应的oaID
		queryParamDto.setId(dto.getId());
		// 查询到对应公告
		AnnounceEntity announceEntity = announceDao
				.queryCommonOne(queryParamDto);
		// 查询到
		String announceType = null;
		if (null != announceEntity) {
			// 设置type
			announceType = announceEntity.getType();
		}
		// 如果操作状态为确认,查看是否存在数据
		if (ConstansUtil.OPERATE_SURE.equals(dto.getOptType())) {
			if (StringUtils.isEmpty(id)) {
				// 增加公告用户数据
				AnnounceUserEntity entity = new AnnounceUserEntity();
				// 对应的oaID
				entity.setAppAnnounceId(dto.getId());
				// 设置工号
				entity.setEmpCode(dto.getUserId());
				// 设置类型
				entity.setType(dto.getType());
				// 设置公告类型
				entity.setAnnounceType(announceType);
				// 插入
				row = announceUserService.insert(entity);
			}
			// 取消操作
		} else if (ConstansUtil.OPERATE_CANCEL.equals(dto.getOptType())) {
			// 删除
			row = announceUserService.delete(id);
		}
		// 返回
		return row;
	}

	/**
	 * 查询公告详情
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public AnnounceEntity queryCommonOne(String id) {
		// 如果为空
		if (StringUtils.isEmpty(id)) {
			// 返回失败
			return null;
		}
		// 实例化
		AnnounceDto dto = new AnnounceDto();
		// id设置
		dto.setId(id);
		// 根据查询条件查询
		AnnounceEntity entity = announceDao.queryCommonOne(dto);
		// 详情图片路径
		if(null!=entity&&null!=entity.getAppConImgPath()){
		entity.setAttachmentPath(webUrl + entity.getAppConImgPath().replace("/upload", ""));
		}else{
			entity.setAttachmentPath("");
		}
		// 返回
		return entity;
	}

	/**
	 * 查询公告详情
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	@Override
//	@Transactional("transactionManager")
	public AnnounceEntity queryDetialRead(String id, String userId) {
		// id为空或者工号为空均为错
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(userId)) {
			// 跳出
			return null;
		}
		// 获得公告实体对象
		AnnounceEntity announceEntity = queryCommonOne(id);
		// 没获取
		if (null == announceEntity) {
			// 跳出
			return null;
		}
		// 标题分隔
		String title = splitTitle(announceEntity.getTitle());
		// 类型
		String announceType = announceEntity.getType();
		// 查询参数实例化
		AnnounceUserEntity queryParam = new AnnounceUserEntity();
		// 设置oaId
		queryParam.setAppAnnounceId(id);
		// 设置工号
		queryParam.setEmpCode(userId);
		// 设置类型
		queryParam.setType(ConstansUtil.READ);
		// 先查看用户与公告表是否存在，存在，直接返回对象
		String announceUserId = announceUserService.queryCommonId(queryParam);
		// 查询操作过程是否存在
		if (StringUtils.isEmpty(announceUserId)) {
			// 增加公告用户数据
			AnnounceUserEntity announceUserEntity = new AnnounceUserEntity();
			// 设置oaId
			announceUserEntity.setAppAnnounceId(id);
			// 设置工号
			announceUserEntity.setEmpCode(userId);
			// 设置类型
			announceUserEntity.setType(ConstansUtil.READ);
			// 公告类型
			announceUserEntity.setAnnounceType(announceType);
			// 插入数据库
			int row = announceUserService.insert(announceUserEntity);
			// 更新阅读总量
			if (row > 0) {
				// 实例化实体类
				AnnounceEntity updateEntity = new AnnounceEntity();
				// 设置oaId
				updateEntity.setId(announceEntity.getId());
				// 阅读量
				int readNum = announceEntity.getReadNum() + 1;
				// 设置阅读量
				updateEntity.setReadNum(readNum);
				// 设置阅读量
				announceEntity.setReadNum(readNum);
				// 更新
				update(updateEntity);
			}
		}
		// 获取收藏状态
		String collectionStatus = getUserAnnounceStatus(id, userId,
				ConstansUtil.COLLECTION);
		// 获取点赞状态
		String praiseStatus = getUserAnnounceStatus(id, userId,
				ConstansUtil.PRAISE);
		// 设置收藏状态
		announceEntity.setCollectionStatus(collectionStatus);
		// 设置点赞状态
		announceEntity.setPraiseStatus(praiseStatus);
		// 设置标题
		announceEntity.setTitle(title);
		announceEntity.setContent(announceEntity.getContent().replace("<style>#weaver_doccontent img{display:none}</style>", ""));
		// 返回
		return announceEntity;
	}

	/**
	 * 获取用户对公告的操作状态
	 * 
	 * @param announceId
	 * @param userId
	 * @param type
	 * @return
	 */
	private String getUserAnnounceStatus(String announceId, String userId,
			String type) {
		// 查询实例化
		AnnounceUserEntity queryParam = new AnnounceUserEntity();
		// 设置oaId
		queryParam.setAppAnnounceId(announceId);
		// 工号
		queryParam.setEmpCode(userId);
		// 类型
		queryParam.setType(type);
		// 查询单个公告状态
		String id = announceUserService.queryCommonId(queryParam);
		// 不为空
		if (StringUtils.isNotEmpty(id)) {
			// 收藏
			return "on";
		}
		return "";
	}

	/**
	 * 查询所有的我的收藏
	 * 
	 * @param empCode
	 * @return
	 */
	@Override
	public List<AnnounceUserEntity> queryMyCollectAll(String empCode) {
		// 如果用户工号为空
		if (null == empCode || "".equals(empCode)) {
			// 返回空
			return null;
		}
		// 收藏类型
		String type = ConstansUtil.COLLECTION;
		// 查询参数
		AnnounceUserEntity queryParam = new AnnounceUserEntity();
		// 工号参数设置
		queryParam.setEmpCode(empCode);
		// 类型参数设置
		queryParam.setType(type);
		// 查询所有的收藏
		List<AnnounceUserEntity> list = announceUserService
				.queryCommonAll(queryParam);
		// 返回结果定义
		List<AnnounceUserEntity> newList = new ArrayList<AnnounceUserEntity>();
		if (null != list && list.size() > 0) {
			// 循环查询
			for (AnnounceUserEntity entity : list) {
				// 参数设置
				AnnounceDto announceDto = new AnnounceDto();
				// id
				announceDto.setId(entity.getAppAnnounceId());
				// 查询
				AnnounceEntity announceResult = announceDao
						.queryCommonOne(announceDto);
				
				// 健壮性判断
				if(null == announceResult){
					// 标题设置
					entity.setTitle("");
				}else{
					// 标题
					String title = announceResult.getTitle();
					// 标题设置
					entity.setTitle(splitTitle(title));
				}
				// 添加
				newList.add(entity);
			}
			/*
			 * if (null != newList && newList.size() > 0) { return newList; }
			 * return null; } return null;
			 */
		}
		//  返回
		return newList;
	}

	/**
	 * 新闻咨询查询
	 */
	@Override
	public List<AnnounceEntity> queryNormalNews(int limit, int start) {
		String appConPath="";
		String appScrollPath="";
		// 初始化对象，用于设置参数
		AnnounceDto queryParam = new AnnounceDto();
		// Calendar实例获取
		Calendar currCalendar = Calendar.getInstance();
		// 当前时间获取
		Date endTime = currCalendar.getTime();
		// 当前月
		int currmonth = currCalendar.get(Calendar.MONTH) + 1;
		// 三个月前
		currCalendar.set(Calendar.MONTH, currmonth - MagicNumber.NUM3);
		// 开始时间
		Date startTime = currCalendar.getTime();
		// 开始时间设置
		queryParam.setStartTime(startTime);
		// 结束时间设置
		queryParam.setEndTime(endTime);
		// 新闻资讯(滚动)的查询
		List<AnnounceEntity> scrollList = announceDao.queryScrollNews();
		// 定义list，用以存取公告id
		List<String> announceList = new ArrayList<String>();
		// 非空
		if (null != scrollList && scrollList.size() > 0) {
			// 循环
			for (AnnounceEntity announceEntity : scrollList) {
				// id获取
				String id = announceEntity.getId();
				// id存储
				announceList.add(id);
			}
		}
		// 非空
		if (null != announceList && announceList.size() > 0) {
			// 公告id集合
			queryParam.setAnnounceList(announceList);
		}
		// 查询普通新闻资讯
		List<AnnounceEntity> list = announceDao.queryNormalNews(limit, start,
				queryParam);
		// 定义，用以设置属性值
		List<AnnounceEntity> newList = new ArrayList<AnnounceEntity>();
		// 循环
		for (AnnounceEntity entity : list) {
			// 获取详情图片
			if(null!=entity.getAppConImgPath()){
			 appConPath = webUrl + entity.getAppConImgPath().replace("/upload", "");
			}
			
			// 获取滚动图片
			if(null!=entity.getAppScrollImgPath()){
			 appScrollPath = webUrl + entity.getAppScrollImgPath().replace("/upload", "");
			// 设置详情图片
			}
			entity.setAttachmentPath(appConPath);
			// 设置滚动图片
			entity.setSrcollImagPath(appScrollPath);
			// 实体添加集合
			newList.add(entity);
		}
		/*if (null != newList && newList.size() > 0) {
			return newList;
		}
		return null;*/
		// 返回
		return newList;
	}

	/**
	 * 滚动新闻查询
	 */
	@Override
	public List<AnnounceEntity> queryScrollNews() {
		String appConPath = "";
		String appScrollPath = "";
		// 滚动新闻的查询
		List<AnnounceEntity> list = announceDao.queryScrollNews();
		// 空处理
		if (null == list || list.size() == 0) {
			// 没有直接返回
			return null;
		}
		// 存储实体
		List<AnnounceEntity> newList = new ArrayList<AnnounceEntity>();
		// 循环
		for (AnnounceEntity entity : list) {
			if(null!=entity.getAppConImgPath()){
			// 获取详情图片
			 appConPath = webUrl + entity.getAppConImgPath().replace("/upload", "");
			}
			// 获取滚动图片
			if(null!=entity.getAppScrollImgPath()){
			 appScrollPath = webUrl + entity.getAppScrollImgPath().replace("/upload", "");
			}
			// 设置详情图片
			entity.setAttachmentPath(appConPath);
			// 设置滚动图片
			entity.setSrcollImagPath(appScrollPath);
			// 实体添加集合
			newList.add(entity);
		}
		/*if (null != newList && newList.size() > 0) {
			return newList;
		}
		return null;*/
		// 返回
		return newList;
	}

	/**
	 * 删除我的收藏
	 */
	@Override
//	@Transactional("transactionManager")
	public int deleteMyColls(String collIds) {
		// 为空
		if (StringUtils.isEmpty(collIds)) {
			// 返回0
			return 0;
		}
		// 获取对应id
		List<String> list = getMyCollIds(collIds);
		// 为空
		if (null == list) {
			// 返回0
			return 0;
		}
		// 定义返回值
		int rownum = 0;
		// 循环
		for (String id : list) {
			// 不为空删除
			if (StringUtils.isNotEmpty(id)) {
				// 删除累加
				rownum += announceUserService.delete(id);
			} else {
				// 继续
				continue;
			}
		}
		// 返回删除条数
		return rownum;
	}

	/**
	 * 获取我的收藏id
	 * @param jsonStr
	 * @return
	 */
	private List<String> getMyCollIds(String jsonStr) {
		// 定义返回集合
		List<String> list = new ArrayList<String>();
		// jsonString-->jsonArr
		JSONArray array = JSON.parseArray(jsonStr);
		// jsonArr长度
		int length = array.size();
		// 如果 > 0
		if (length > 0) {
			// 循环
			for (int i = 0; i < length; i++) {
				// 获取id
				String id = array.getString(i);
				// 不为空
				if (StringUtils.isNotEmpty(id)) {
					// 添加id
					list.add(id);
				}
			}
		}
		// 不为0
		if (list.size() > 0) {
			// 返回集合
			return list;
		}
		// 0返回null
		return null;
	}

	/**
	 * 根据id查询一个公告
	 */
	@Override
	public AnnounceEntity queryOneByOaId(String oaId) {
		// 查询
		return announceDao.queryOneByOaId(oaId);
	}

	/**
	 * 搜索结果查询
	 */
	@Override
	public List<AnnounceEntity> getSearchResult(String searchString, int limit,
			int start) {
		// 后期删除的时候用到
		AnnounceEntity announceEntity = null;
		// 用以拼装参数
		Map<String, Object> map = new HashMap<String, Object>();
		String searchStrings="%"+searchString+"%";
		// 标题
		map.put("title", searchStrings);
		// 内容
		map.put("content", searchStrings);
		// 大小
		map.put("limit", limit);
		// 起始
		map.put("start", start);
		// 搜索结果返回
		List<AnnounceEntity> lists = announceDao.getSearchResult(map);
		// 去除标签前内容
		String title, content = null;
		// 去除标签后内容
		String stripTitle, stripContent = null;
		// 起始，结果
		int begin, end = 0;
		// 查询到的结果不为空
		if (null != lists && lists.size() > 0) {
			// 循环
			for (int i = 0; i < lists.size(); i++) {
				// 获取标题
				title = lists.get(i).getTitle();
				// 获取内容
				content = lists.get(i).getContent();
				// 截取开始位置
				begin = content.indexOf(searchString) - MagicNumber.NUM10 < 0 ? 0 : content
						.indexOf(searchString) - MagicNumber.NUM10;
				// 截取结束为止
				end = content.indexOf(searchString) + MagicNumber.NUM10 > content.length() ? content
						.length() : content.indexOf(searchString) + MagicNumber.NUM10;
				// title-->去掉html标签后的title-->过滤常用标签之后的title
				stripTitle = stripTag(stripHtml(title));
				// content-->去掉html标签后的content-->过滤常用标签之后的content
				stripContent = stripTag(stripHtml(content));
				// 如果截取之后的title不包含查询的字段
				if (stripTitle.indexOf(searchString) < 0) {
					// 如果截取之后的content不包含查询的字段
					if (stripContent.indexOf(searchString) < 0) {
						// 将title置为空
						lists.get(i).setTitle("");
						// 将content置为空
						lists.get(i).setContent("");
					}
				} else {
					// 不为空就将查询字段高亮显示
					lists.get(i).setTitle(
							"<div style='font-size:16px;'>"
									+ highLighter(title, searchString)
									+ "</div>");
					// 内容过多，截取显示
					content = content.substring(begin, end);
					// 设置更改过后的内容
					lists.get(i).setContent(highLighter(content, searchString));
					// 设置查询时间
					lists.get(i).setCreateTime(lists.get(i).getCreateTime());
				}
			}
			// 迭代器将置为空的内容和标题删除
			Iterator<AnnounceEntity> iterator = lists.iterator();
			// 判断是否存在下一个元素
			while (iterator.hasNext()) {
				// 获取下一个元素
				announceEntity = iterator.next();
				// 如果标题内容都为空
				if ("".equals(announceEntity.getTitle())
						&& "".equals(announceEntity.getContent())) {
					// 用迭代器删除
					iterator.remove();
				}
			}
		}
		// 返回list
		return lists;
	}

	/**
	 * 获取搜索结果详情
	 */
	@Override
	public AnnounceEntity getDetailSearchResultByAnnounceId(
			String searchString, String announceId, String userId) {
		// 获取详情信息
		AnnounceEntity announceEntity = announceService.queryDetialRead(
				announceId, userId);
		try {
			// 字段查询解码
			searchString = URLDecoder.decode(searchString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// log
			logger.error("咨询搜索字段解码出错", e);
		}
		// title,content
		String title, content = null;
		// 不为空
		if (null != announceEntity) {
			// 获取标题
			title = announceEntity.getTitle();
			// 获取内容
			content = announceEntity.getContent();
			// 常用便签去除
			//content = stripTag(content).replaceAll("text-indent:[ 0-9.]*pt[;]*", "")
//			content = stripTag(content).replaceAll("text-indent:348.0pt;", "").
//					replaceAll("text-indent: 324pt", "")
//					.replace("<style>#weaver_doccontent img{display:none}</style>", "");
			content = removeHtmlAttr(stripTag(content),"德邦物流股份有限公司","text-indent:[ 0-9.]*pt[;]*","","text-indent")
					.replace("<style>#weaver_doccontent img{display:none}</style>", "");
			// 设置滚动新闻图片
			if(null!=announceEntity.getAppConImgPath()){
			announceEntity.setAttachmentPath(webUrl
					+ announceEntity.getAppConImgPath().replace("/upload", ""));
			}else{
				announceEntity.setAttachmentPath("");
			}
			// 高亮设置标题
			announceEntity.setTitle(highLighter(title, searchString));
			// 高亮设置内容
			announceEntity.setContent(highLighter(content, searchString));
		}
		// 返回
		return announceEntity;
	}
	
	/**
	 * 去除HTML页面content某个内容subStr前后的样式属性attrName
	 * */
	private String removeHtmlAttr(String content,String subStr,String regx,String replacement,String attrName){
		if(StringUtils.isEmpty(content) || StringUtils.isEmpty(subStr)){
			return "";
		}
		if(content.indexOf(subStr) == -1){
			return content;
		}
		String[] contents = content.split(subStr);
		int offset = contents[0].lastIndexOf(attrName);
		String lastStr = contents[0].substring(0,offset)+contents[0].substring(offset).replaceFirst(regx, replacement);
		String firstStr = contents[1].replaceFirst(regx, replacement);
		return lastStr+subStr+firstStr;
	}

	/**
	 * 高亮显示搜索文字
	 * 
	 * @author 231586
	 * @param str
	 * @param ser
	 * @return
	 */
	private String highLighter(String str, String ser) {
		List<Character> qIn = new ArrayList<Character>();
		List<Character> qOut = new ArrayList<Character>();
		List<String> lableArr = new ArrayList<String>();
		List<String> dateArr = new ArrayList<String>();
		List<String> replaceDateArr = new ArrayList<String>();
		boolean flg = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				qIn.add(str.charAt(i));
				flg = true;
				StringBuilder tmp2 = new StringBuilder();
				for (int k = 0; k < qOut.size(); k++) {
					tmp2.append(qOut.get(k));
				}
				qOut = new ArrayList<Character>();
				dateArr.add(tmp2.toString());
			} else if (str.charAt(i) == '>') {
				qIn.add(str.charAt(i));
				flg = false;
				StringBuilder tmp = new StringBuilder();
				for (int j = 0; j < qIn.size(); j++) {
					tmp.append(qIn.get(j));
				}
				qIn = new ArrayList<Character>();
				lableArr.add(tmp.toString());
			} else if (flg) {
				qIn.add(str.charAt(i));
			} else {
				qOut.add(str.charAt(i));
			}
		}
		if (qOut.size() > 0) {
			StringBuilder tmp2 = new StringBuilder();
			for (int k = 0; k < qOut.size(); k++) {
				tmp2.append(qOut.get(k));
			}
			qOut = new ArrayList<Character>();
			dateArr.add(tmp2.toString());
		}
		for (String tmp : dateArr) {
			tmp = tmp.replaceAll(ser,
					"<strong><font color='#ffc50a' size='3px'>" + ser
							+ "</font></strong>");
			replaceDateArr.add(tmp);
		}
		StringBuilder sbtr = new StringBuilder();
//		str = new String();
		dateArr = replaceDateArr;
		int num = lableArr.size() + dateArr.size();
		for (int i = 0, j = 0, k = 0; i < num; i++) {
			if (i % 2 == 0) {
				// str += dateArr.get(j);
				if(j < dateArr.size()){
					sbtr.append(dateArr.get(j));
				}
				++j;
				} else {
					// str += lableArr.get(k);
					if(k < lableArr.size()){
						sbtr.append(lableArr.get(k));
					}
					++k;
				}
			}
		return sbtr.toString();
	}

	/**
	 * 过滤html标签
	 * 
	 * @author 231586
	 * @param htmlStr
	 * @return
	 */
	private String stripHtml(String htmlStr) {
		// 定义script的正则表达式
		String regExScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";
		// 定义style的正则表达式
		String regExStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
		// 定义HTML标签的正则表达式
		String regExHtml = "<[^>]+>";
		// 定义匹配条件
		Pattern pScript = Pattern.compile(regExScript,
				Pattern.CASE_INSENSITIVE);
		// 匹配tag标签
		Matcher mScript = pScript.matcher(htmlStr);
		// 过滤tag标签
		htmlStr = mScript.replaceAll("");
		// 定义匹配条件
		Pattern pStyle = Pattern
				.compile(regExStyle, Pattern.CASE_INSENSITIVE);
		// 匹配tag标签
		Matcher mStyle = pStyle.matcher(htmlStr);
		// 过滤tag标签
		htmlStr = mStyle.replaceAll("");
		// 定义匹配条件
		Pattern pHtml = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
		// 过滤tag标签
		Matcher mHtml = pHtml.matcher(htmlStr);
		// 过滤tag标签
		htmlStr = mHtml.replaceAll("");
		// 返回文本字符串
		return htmlStr.trim();
	}

	/**
	 * 过滤常用标签
	 * 
	 * @author 231586
	 * @param str
	 * @return
	 */
	private String stripTag(String str) {
		// 定义常见的标签
		String[] tags = { "&rdquo;", "&ldquo;", "&nbsp;", "&mdash;", "&lsquo;",
				"&rsquo;", "&hellip;" };
		// 循环标签数组
		for (String tag : tags) {
			// 定义匹配条件
			Pattern pTag = Pattern.compile(tag, Pattern.CASE_INSENSITIVE);
			// 匹配tag标签
			Matcher mTag = pTag.matcher(str);
			// 过滤tag标签
			str = mTag.replaceAll("");
		}
		// 返回
		return str.trim();
	}

	/**
	 * set
	 * 
	 * @param announceDao
	 */
	public void setAnnounceDao(IAnnounceDao announceDao) {
		this.announceDao = announceDao;
	}

	/**
	 * set
	 * 
	 * @param announceUserService
	 */
	public void setAnnounceUserService(IAnnounceUserService announceUserService) {
		this.announceUserService = announceUserService;
	}

	/**
	 * set
	 * 
	 * @param webUrl
	 */
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	/**
	 * set
	 * 
	 * @param announceService
	 */
	public void setAnnounceService(IAnnounceService announceService) {
		this.announceService = announceService;
	}

}
