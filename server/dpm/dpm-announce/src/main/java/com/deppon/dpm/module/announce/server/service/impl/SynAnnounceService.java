package com.deppon.dpm.module.announce.server.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.announce.server.service.IAnnounceLogService;
import com.deppon.dpm.module.announce.server.service.IAnnounceService;
import com.deppon.dpm.module.announce.server.service.ISynAnnounceService;
import com.deppon.dpm.module.announce.shared.define.ConstansUtil;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.domain.AnnounceLogEntity;
import com.deppon.dpm.module.announce.shared.util.ImagePressPic;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;

/**
 * 
 * @ClassName: SynAnnounceService
 * @Description: 公告管理与OA外部Service实现类
 * @author 045925/YANGBIN
 * @date 2015-3-18 下午3:32:20
 * 
 */
public class SynAnnounceService implements ISynAnnounceService {

	// log
	private static Logger logger = Logger.getLogger(SynAnnounceService.class);
	// 对应服务器图片存放路径
	private String webUrl;
	// set injection
	private IAnnounceService announceService;
	// set injection
	private IAnnounceLogService announceLogService;

	// 同步新闻资讯给社区的URL
	private String communitySynNewsUrl;

	/**
	 * @author 231586 改
	 */
	// jboss存储图片路径
	private String jbossImagePath = File.separator + "dpmfile" + File.separator
			+ "announce" + File.separator + "image" + File.separator;
	// jboss存储压缩图片路径
	private String jbossPressImagePath = File.separator + "dpmfile"
			+ File.separator + "announce" + File.separator + "image"
			+ File.separator + "press" + File.separator;

	/**
	 * 
	 * @Title: SynAnnounceRequest
	 * @Description: 同步OA资讯(任免公告、新闻动态、高管随笔)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return Response 返回类型
	 * @throws IOException
	 */
	@Override
	public Response synAnnounceRequest(String announeJson) throws IOException {

		/*
		 * 同步新闻资讯给社区
		 */
		Map<String, Object> params = new HashMap<String, Object>();
		// 设置请求参数
		params.put("announeJson", announeJson);
		// 定义调用接口的返回结果
		String result = null;

		try {
			logger.info("synAnnounceRequest===>开始向社区同步新闻资讯   announeJson = "
					+ announeJson);
			// 使用httpClient调用社区接口传递新闻资讯数据
			result = HttpUtil.doPost(communitySynNewsUrl, params);
		} catch (Exception e) {
			// 调用接口异常
			logger.error("synAnnounceRequest===>向社区同步新闻资讯失败，httpClient请求异常", e);
		}

		// 返回success，说明同步成功
		if ("success".equalsIgnoreCase(result)) {
			logger.info("synAnnounceRequest===>向社区同步新闻资讯成功！announeJson = "
					+ announeJson);

			// 否则就是失败
		} else {
			logger.info("synAnnounceRequest===>向社区同步新闻资讯失败！announeJson = "
					+ announeJson);
		}

		// 用以存储日志信息
		AnnounceLogEntity newLog = new AnnounceLogEntity();
		// 设置日志参数
		newLog.setRequestparam(announeJson);
		// 时间
		newLog.setCreateTime(new Date());
		// 状态
		String status = "New";
		Response response = null;
		try {
			// 为null就出错
			if (StringUtils.isNotEmpty(announeJson)) {
				response = setResponse(announeJson, newLog, status,response);
			} else {
				// 出错信息
				String message = "传入的参数：announeJson为空";
				// 状态
				newLog.setStatus(status);
				// 插入数据库
				announceLogService.insert(newLog);
				// log
				logger.error(message);
				// 返回oa
				return Response
						.ok("{\"resultFlag\":\"false\",\"failureReason\":\""
								+ message + "\"}").header("ESB-ResultCode", 1)
						.build();
			}

		} catch (Exception e) {
			// 出错信息
			String message = e.getMessage();
			// 状态
			newLog.setStatus(status);
			// 插入数据库
			announceLogService.insert(newLog);
			// log
			logger.error("SynAnnounceRequest===>" + message + "解析Json发生异常!");
			// 返回oa
			return Response
					.ok("{\"resultFlag\":\"false\",\"failureReason\":\""
							+ message + "\"}").header("ESB-ResultCode", 0)
					.build();
		}
		return null;
	}

	private Response setResponse(String announeJson, AnnounceLogEntity newLog, String status,Response response) {
		logger.info("SynAnnounceRequest===>请求参数:" + announeJson);
		JSONObject jsonObject = JSONObject.parseObject(announeJson);
		String optState = jsonObject.get("optState").toString();
		// 判断操作状态是否为空，如果不为空
		if (StringUtils.isNotEmpty(optState)) {
			// 如果是新增
			if (ConstansUtil.INSERT.equals(optState)) {
				// 先获得OAid
				String oaId = jsonObject.get("id").toString();
				// 根据oaId查询公告
				AnnounceEntity oldEntity = announceService
						.queryOneByOaId(oaId);
				// 如果不存在，则新增，否则更新
				if (null == oldEntity) {
					// 参数转实体类
					AnnounceEntity entity = getAnnounceEntity(jsonObject);
					// 没有转换成实体类说明传值不正确
					// if (null == entity) {
					// // 存储日志
					// String message = "动态新闻图片传入为空！";
					// // 设置状态
					// newLog.setStatus(status);
					// // 插入数据库
					// announceLogService.insert(newLog);
					// // log
					// logger.info("SynAnnounceRequest===>" + oaId
					// + "" + message);
					// // 返回oa
					// return Response
					// .ok("{\"id\":\""
					// + oaId
					// +
					// "\",\"resultFlag\":\"false\",\"failureReason\":\""
					// + message + "\"}")
					// .header("ESB-ResultCode", 1).build();
					// }
					// 插入
					int row = announceService.insert(entity);
					// row > 0表示保存成功
					if (row > 0) {
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ "插入成功");
						// 返回oa
						response = Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"success\",\"failureReason\":\"\"}")
								.header("ESB-ResultCode", 1).build();
						// 否则失败
					} else {
						// 存储日志
						String message = "插入失败！";
						// 设置状态
						newLog.setStatus(status);
						// 插入数据库
						announceLogService.insert(newLog);
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ "" + message);
						// 返回oa
						response =  Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"false\",\"failureReason\":\""
										+ message + "\"}")
								.header("ESB-ResultCode", 1).build();
					}
				} else {
					// 参数转实体类
					AnnounceEntity entity = getAnnounceEntity(jsonObject);
					// odId
					entity.setId(oldEntity.getId());
					// 修改人
					entity.setModifyUser("system");
					// 修改账号
					entity.setModifyUserCode("000000");
					// 修改时间
					entity.setModifyTime(new Date());
					// 更新
					int row = announceService.update(entity);
					// 返回值>0表示成功
					if (row > 0) {
						// 设置状态
						newLog.setStatus(status);
						// 插入数据库
						announceLogService.insert(newLog);
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ "更新成功!");
						// 返回oa
						response = Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"success\",\"failureReason\":\"\"}")
								.header("ESB-ResultCode", 1).build();
					} else {
						// 存储日志
						String message = "更新失败！";
						// 设置状态
						newLog.setStatus(status);
						// 插入数据库
						announceLogService.insert(newLog);
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ ":" + message);
						// 返回oa
						response = Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"false\",\"failureReason\":\""
										+ message + "\"}")
								.header("ESB-ResultCode", 1).build();
					}
				}
			}
			// 如果是更新
			else if (ConstansUtil.UPDATE.equals(optState)) {
				// 获取oaId
				String oaId = jsonObject.get("id").toString();
				// 通过oaId查询公告
				AnnounceEntity oldEntity = announceService
						.queryOneByOaId(oaId);
				// 如果为空，则插入数据，存在，则更新
				if (null == oldEntity) {
					// 通过参数获取公告
					AnnounceEntity entity = getAnnounceEntity(jsonObject);
					// 如果为null，表示传入失败
					// if (null == entity) {
					// // 存储日志
					// String message = "动态新闻图片传入为空！";
					// // 设置状态
					// newLog.setStatus(status);
					// // 插入数据库
					// announceLogService.insert(newLog);
					// // log
					// logger.info("SynAnnounceRequest===>" + oaId
					// + "" + message);
					// // 返回oa
					// return Response
					// .ok("{\"id\":\""
					// + oaId
					// +
					// "\",\"resultFlag\":\"false\",\"failureReason\":\""
					// + message + "\"}")
					// .header("ESB-ResultCode", 1).build();
					// }
					// 插入
					int row = announceService.insert(entity);
					// >0表示插入成功
					if (row > 0) {
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ "插入成功");
						// 设置状态
						newLog.setStatus(status);
						// 插入数据库
						announceLogService.insert(newLog);
						// 返回oa
						response = Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"success\",\"failureReason\":\"\"}")
								.header("ESB-ResultCode", 1).build();
					} else {
						// 存储日志
						String message = "插入失败！";
						// 设置状态
						newLog.setStatus(status);
						// 插入数据库
						announceLogService.insert(newLog);
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ "" + message);
						// 返回oa
						response = Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"false\",\"failureReason\":\""
										+ message + "\"}")
								.header("ESB-ResultCode", 1).build();
					}
				} else {
					// json转实体类
					AnnounceEntity entity = getAnnounceEntity(jsonObject);
					// odId
					entity.setId(oldEntity.getId());
					// 修改人姓名
					entity.setModifyUserName("system");
					// 修改人工号
					entity.setModifyUserCode("000000");
					// 修改日期
					entity.setModifyTime(new Date());
					// 更新
					int row = announceService.update(entity);
					// >0表示更新成功
					if (row > 0) {
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ "更新成功!");
						// 状态
						newLog.setStatus(status);
						// 插入数据库
						announceLogService.insert(newLog);
						// 返回oa
						response = Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"success\",\"failureReason\":\"\"}")
								.header("ESB-ResultCode", 1).build();
					} else {
						// 信息
						String message = "更新失败！";
						// 状态
						newLog.setStatus(status);
						// 插入数据库
						announceLogService.insert(newLog);
						// log
						logger.info("SynAnnounceRequest===>" + oaId
								+ ":" + message);
						// 返回oa
						response =  Response
								.ok("{\"id\":\""
										+ oaId
										+ "\",\"resultFlag\":\"false\",\"failureReason\":\""
										+ message + "\"}")
								.header("ESB-ResultCode", 1).build();
					}
				}
			} else if (ConstansUtil.DELETE.equals(optState)) {
				// 接受删除idList
				String jsonIdList = jsonObject.get("deleteList")
						.toString();
				// 获取收藏集合
				List<String> list = getMyCollIds(jsonIdList);
				if (null == list || list.size() == 0) {
					// 信息
					String message = "删除的集合ID为空！";
					// 状态
					newLog.setStatus(status);
					// 插入数据库
					announceLogService.insert(newLog);
					// 返回oa
					response = Response
							.ok("{\"resultFlag\":\"false\",\"failureReason\":\""
									+ message + "\"}")
							.header("ESB-ResultCode", 1).build();
				}
				// 删除返回值
				int deleteRow = 0;
				// 循环删除
				for (String oaId : list) {
					// oa-->entity
					AnnounceEntity entity = announceService
							.queryOneByOaId(oaId);
					if (null == entity) {
						continue;
					}
					// 累加
					deleteRow += announceService.delete(entity.getId());
				}
				// 如果删除行数大于0,则返回成功
				if (deleteRow > 0) {
					// 状态
					newLog.setStatus(status);
					// 插入数据库
					announceLogService.insert(newLog);
					// 返回oa
					response = Response
							.ok("{\"resultFlag\":\"success\",\"failureReason\":\"\"}")
							.header("ESB-ResultCode", 1).build();
				}
				// 出错信息
				String message = "删除OA公告集合失败";
				// 状态
				newLog.setStatus(status);
				// 插入数据库
				announceLogService.insert(newLog);
				// 返回oa
				response =  Response
						.ok("{\"resultFlag\":\"false\",\"failureReason\":\""
								+ message + "\"}")
						.header("ESB-ResultCode", 1).build();
			}

		}
		// 判断OAId是否存在，如果存在，则更新,不存在，则新增
		return response;
	}

	/**
	 * 
	 * @Title: operate
	 * @Description: 同步OA资讯(任免公告、新闻动态、高管随笔)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return Response 返回类型
	 * @throws IOException
	 */
	private AnnounceEntity getAnnounceEntity(JSONObject jsonObject) {
		// 实体类实例化
		AnnounceEntity announceEntity = new AnnounceEntity();
		// oaId
		String oaId = jsonObject.get("id").toString();
		// 发布时间
		String publishTime = jsonObject.get("publishTime").toString();
		// 内容
		String content = jsonObject.get("content").toString();
		// 标题
		String title = jsonObject.get("title").toString();
		// 详情图片地址
		String conImgPath = jsonObject.get("conImg").toString();
		// 滚动图片地址
		String scrollImgPath = jsonObject.get("scrollImg").toString();
		// 消息类型
		String type = jsonObject.get("type").toString();
		// 图片真实名称
		String conImgName = jsonObject.get("conImgName").toString();
		// 图片真实名称
		String scrollImgName = jsonObject.get("scrollImgName").toString();
		// 发布时间转换
		Long longDate = Long.valueOf(publishTime);
		// 发布时间转换为date
		Date publishDate = new Date(longDate);
		// oaId设置
		announceEntity.setOaId(oaId);
		// 类型设置
		announceEntity.setTitle(title);
		// 类型设置
		announceEntity.setType(type);
		// 发布时间设置
		announceEntity.setPublishTime(publishDate);
		// 内容设置
		announceEntity.setContent(content);
		// 图片设置
		announceEntity.setConImgName(conImgName);
		// 如果类型不为空并且为NEWS
		if (null != type && type.equals(ConstansUtil.NEWS)) {
			// 设置滚动图片名称
			announceEntity.setScrollImgName(scrollImgName);
			// 设置滚动图片路径
			announceEntity.setSrcollImagPath(scrollImgPath);
			// 如果滚动图片路径不为空
			if (StringUtils.isNotEmpty(scrollImgPath)) {
				// 压缩图片
				String appScrollImgPath = pressImage(scrollImgPath);
				// 设置压缩图片路径
				announceEntity.setAppScrollImgPath(appScrollImgPath);
			}
			// 如果详情图片路径不为空
			if (StringUtils.isNotEmpty(conImgPath)) {
				// 压缩详情图片
				String appConImgPath = pressImage(conImgPath);
				// 设置详情图片路径
				announceEntity.setAppConImgPath(appConImgPath);
			}
			// 下标
			int index = scrollImgPath.lastIndexOf("/");
			// 文件名
			String imageName = scrollImgPath.substring(index + 1,
					scrollImgPath.length());
			// 滚动图片路径
			announceEntity.setSrcollImagPath(webUrl
					+ "/announce/image/" + imageName);
			// 下标
			index = conImgPath.lastIndexOf("/");
			// 文件名
			imageName = conImgPath
					.substring(index + 1, conImgPath.length());
			// 正文图片路径
			announceEntity.setAttachmentPath(webUrl
					+ "/announce/image/" + imageName);
		}
		// 返回
		return announceEntity;
	}

	/**
	 * 压缩图片
	 * 
	 * @param imgURLPath
	 * @return
	 */
	private String pressImage(String imgURLPath) {
		// 确认下标
		int index = imgURLPath.lastIndexOf("/");
		// 截取文件名
		String imageName = imgURLPath.substring(index + 1, imgURLPath.length());
		// 输入文件名
		String inputFileName = imageName;
		// 输出文件名
		String outputFileName = imageName;
		// 查找文件
		File imageFile = new File(jbossImagePath + inputFileName);
		// 查看对应路径下的文件是不是存在
		if (imageFile.exists()) {
			// 实例化压缩工具类
			ImagePressPic prePic = new ImagePressPic();
			// 图片压缩路径
			File saveDir = new File(jbossPressImagePath);
			// 路径不存在
			if (!saveDir.exists()) {
				// 生成文件夹
				saveDir.mkdirs();
			}
			// 压缩图片
			prePic.compressPic(jbossImagePath, jbossPressImagePath,
					inputFileName, outputFileName, MagicNumber.NUM300, MagicNumber.NUM300, true);
			// 返回压缩图片路径
			return "/upload/announce/image/press/" + imageName;
		} else {
			// 对应路径不存在文件夹，生成文件
			boolean flag = makeImg(imgURLPath, jbossImagePath);
			// 标志
			if (flag) {
				// 文件
				File newImageFile = new File(jbossImagePath + imageName);
				// 文件存在
				if (newImageFile.exists()) {
					// 压缩实体类
					ImagePressPic prePic = new ImagePressPic();
					// jboss压缩之后的路径
					File save = new File(jbossPressImagePath);
					if (!save.exists()) {
						// 不存在创建
						save.mkdirs();
					}
					// 压缩图片
					prePic.compressPic(jbossImagePath, jbossPressImagePath,
							inputFileName, outputFileName, MagicNumber.NUM300, MagicNumber.NUM300, true);
				}
			}
			// 返回压缩图片路径
			return "/upload/announce/image/press/" + imageName;
		}
	}

	/**
	 * json-->list
	 * 
	 * @param jsonStr
	 * @return
	 */
	private List<String> getMyCollIds(String jsonStr) {
		// 定义返回类型
		List<String> list = new ArrayList<String>();
		// 转换成json数组
		JSONArray array = JSON.parseArray(jsonStr);
		// 数组大小
		int length = array.size();
		if (length > 0) {
			// 循环
			for (int i = 0; i < length; i++) {
				// 获取oaId
				String id = array.getString(i);
				if (StringUtils.isNotEmpty(id)) {
					// 添加集合
					list.add(id);
				}
			}
		}
		// 返回list
		return list;
	}

	/**
	 * url转图片文件
	 * 
	 * @param imgUrl
	 * @param fileURL
	 * @return
	 */
	private boolean makeImg(String imgUrl, String fileURL) {
		boolean flag = false;
		BufferedOutputStream os = null;
		BufferedInputStream is = null;
		try {
			// 创建流
			is = new BufferedInputStream(new URL(imgUrl).openStream());
			// 生成图片名
			int index = imgUrl.lastIndexOf("/");
			// 截取文件名
			String sName = imgUrl.substring(index + 1, imgUrl.length());
			// 存放地址
			File img = new File(fileURL + sName);
			// 生成图片
			os = new BufferedOutputStream(new FileOutputStream(img));
			// 定义byte数组
			byte buffer[] = new byte[MagicNumber.NUM8192];
			// 用以接收读取数据
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				// 循环写出
				os.write(buffer, 0, count);
			}
			// 标识符
			flag = true;
		} catch (Exception e) {
			logger.error("oa新闻资讯生成图片失败", e);
		}finally{
			// 判断
			if(null != is){
				try {
					// 关闭流
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 判断
			if(null != os){
				try {
					// 关闭流
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 返回标识符
		return flag;
	}

	// set
	public void setAnnounceService(IAnnounceService announceService) {
		this.announceService = announceService;
	}

	// set
	public void setAnnounceLogService(IAnnounceLogService announceLogService) {
		this.announceLogService = announceLogService;
	}

	// set
	public void setJbossImagePath(String jbossImagePath) {
		this.jbossImagePath = jbossImagePath;
	}

	// set
	public void setJbossPressImagePath(String jbossPressImagePath) {
		this.jbossPressImagePath = jbossPressImagePath;
	}

	// set
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	// set
	public void setCommunitySynNewsUrl(String communitySynNewsUrl) {
		this.communitySynNewsUrl = communitySynNewsUrl;
	}

}
