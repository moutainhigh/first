package com.deppon.dpm.login.server.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.FeedBackPushEntity;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.module.announce.server.dao.impl.NormalQuestionDao;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;
import com.deppon.dpm.module.common.server.service.impl.PhotoAddressService;
import com.deppon.dpm.module.common.server.util.UploadUtil;
import com.deppon.dpm.module.common.shared.domain.HxQuestionEntity;
import com.deppon.dpm.tongxunlu.server.dao.IFeedbackDao;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackDetailsEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackHxRecordEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackProblemListEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackSearch;
import com.deppon.dpm.tongxunlu.shared.domain.UserEntity;
import com.deppon.foss.framework.server.context.UserContext;

/**
 * 意见反馈service实现层
 * 
 * @author 231586
 * 
 */
public class FeedbackService implements IFeedbackService {

	/**
	 * set injection
	 */
	private PhotoAddressService photoAddressService;

	/**
	 * set injection
	 */
	private IFeedbackDao feedbackDao;

	/**
	 * 常见问题dao层实现
	 */
	private NormalQuestionDao normalQuestionDao;

	@Override
	public void feedback(File[] files, String[] fileNames, String content,
			String userId, String osType, String type) {
		// 如果userId为null
		if (userId == null) {
			// 从context中获取
			UserEntity user = (UserEntity) (UserContext.getCurrentUser());
			// 不为null
			if (user != null) {
				// 获取工号
				userId = user.getEmpCode();
			}
		}
		// 获取意见反馈图片路径
		String feedBackAddress = photoAddressService.getFeedBackAddress();
		try {
			// 上传图片文件
			List<String> returnPath = UploadUtil.uploadFiles(files,
					feedBackAddress, fileNames);
			// 用以拼接参数
			Map<String, String> map = new HashMap<String, String>();
			// 工号
			map.put("userId", userId);
			// 内容
			map.put("content", content);
			// 设备类型
			map.put("osType", osType);
			// 意见反馈类型
			map.put("type", type);
			// 路径
			String path = null;
			// 直接获取图片路径
			if (returnPath != null && returnPath.size() > 0) {
				path = returnPath.toString().substring(1,
						returnPath.toString().length() - 1);
				// 文件图片
				map.put("file_path", path);
			}
			
			/**判断反馈类型否为提成奖金，如果是，则不保存数据库，调用接口将数据发送
			 * 
			 * 发送数据：
			 * 		用户ID、用户姓名、意见反馈类型、反馈内容、提交时间、图片全路径
			 * */
			
			// 保存
			feedbackDao.feedback(map);
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		}
	}
	
	@Override
	public List<String> feedbackHx(File[] files, String[] fileNames, String content,
			String userId, String osType, String type) {
		// 如果userId为null
		if (userId == null) {
			// 从context中获取
			UserEntity user = (UserEntity) (UserContext.getCurrentUser());
			// 不为null
			if (user != null) {
				// 获取工号
				userId = user.getEmpCode();
			}
		}
		// 获取意见反馈图片路径
		String feedBackAddress = photoAddressService.getFeedBackAddress();
		try {
			// 上传图片文件
			List<String> returnPath = UploadUtil.uploadFiles(files,feedBackAddress, fileNames);
			// 用以拼接参数
			Map<String, String> map = new HashMap<String, String>();
			// 工号
			map.put("userId", userId);
			// 内容
			map.put("content", content);
			// 设备类型
			map.put("osType", osType);
			// 意见反馈类型
			map.put("type", type);
			// 路径
			String path = null;
			// 直接获取图片路径
			if (returnPath != null && returnPath.size() > 0) {
				path = returnPath.toString().substring(1,
						returnPath.toString().length() - 1);
				// 文件图片
				map.put("file_path", path);
			}
			// 保存
			feedbackDao.feedback(map);
			
			//返回上传图片的路径
			List<String> picPaths = new ArrayList<String>();
			if(returnPath != null){
				for (int i = 0; i < returnPath.size(); i++) {
					String fullPath = photoAddressService.getServerHostPort()+feedBackAddress+path;
					picPaths.add(fullPath.replace("dpmfile", ""));
				}
			}
			return picPaths;
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据工号获取小服务台聊天记录
	 * @since 2019-04-13
	 * */
	public FeedBackHxRecordEntity getHxChatRecordByUserId(String userId){
		return feedbackDao.getHxChatRecordByUserId(userId);
	}
	
	/**
	 * 根据工号新增小服务台聊天记录
	 * @since 2019-04-13
	 * */
	public void insertHxChatRecord(String userId,String content,String type) throws Exception{
		feedbackDao.insertHxChatRecord(userId, content, type);
	}
	
	/**
	 * 根据工号更新小服务台聊天记录
	 * @since 2019-04-13
	 * */
	public void updateHxChatRecord(String userId,String content) throws Exception{
		feedbackDao.updateHxChatRecord(userId, content);
	}

	@Override
	public List<FeedBackDetailsEntity> getFeedbackDetails(int start,
			int pageSize,FeedbackSearch search) {
		// 获取意见反馈图片路径(带ip、端口)
		String feedBackAddress = photoAddressService.getServerHostPort()
				+ photoAddressService.getFeedBackAddress().replace("/dpmfile", "");
		List<FeedBackDetailsEntity> list = feedbackDao.getFeedbackDetails(
				start, pageSize, search);
		// 数据请求不为null
		if (null != list && list.size() > 0) {
			// 循环 处理附件
			for (int i = 0; i < list.size(); i++) {
				// 获取文件名
				String fileName = list.get(i).getFileName();
				// 不为null
				if (StringUtils.isNotEmpty(fileName)) {
					// 多个文件
					String[] split = fileName.split(",");
					// 拼接
					StringBuilder sb = new StringBuilder();
					// 循环
					for (int j = 0; j < split.length; j++) {
						// 默认list中的之后元素前面会有空，放在浏览器上会有%20字段，导致图片无法显示
						String file = feedBackAddress + "/" + split[j].trim();
						// 拼接
						sb.append(file.trim());
						// 拼接
						sb.append(",");
					}
					String str = sb.substring(0 , sb.length() - 1);
					// 重新设置
					list.get(i).setFileName(str);
				}
			}
		}
		
		return list;
	}

	@Override
	public FeedBackDetailsEntity getFeedBackDetailsById(int id) {
		FeedBackDetailsEntity entity = feedbackDao.getFeedBackDetailsById(id);
		EmployeeEntity ementity = feedbackDao.getExecuteEntById(id);
		if (entity != null && ementity != null) {
			entity.setExecutePerson(ementity.getEmpName());
			entity.setExecuteMobile(ementity.getMobileNo());
		}
		if (entity != null) {
			String fileName = entity.getFileName();
			String feedBackAddress = photoAddressService.getServerHostPort()
					+ photoAddressService.getFeedBackAddress().replace("/dpmfile", "");
			// 不为null
			if (StringUtils.isNotEmpty(fileName)) {
				// 多个文件
				String[] split = fileName.split(",");
				// 拼接
				StringBuilder sb = new StringBuilder();
				// 循环
				for (int j = 0; j < split.length; j++) {
					// 默认list中的之后元素前面会有空，放在浏览器上会有%20字段，导致图片无法显示
					String file = feedBackAddress + "/" + split[j].trim();
					// 拼接
					sb.append(file.trim());
					// 拼接
					sb.append(",");
				}
				String str = sb.substring(0, sb.length() - 1);
				// 重新设置
				entity.setFileName(str);
			}
		}
		return entity;
	}

	@Override
	public int feedBackCount(FeedbackSearch search) {
		// 查询
		return feedbackDao.getTotalCounts(search);
	}
	
	@Override
	public boolean checkExcEmpCode(String excEmpCode){
		int count = feedbackDao.getExcEmpCodeCount(excEmpCode);
		if(count > 0){
			return true;
		}
		return false;
	}
	
	@Override
	public String updateFeedbackReply(FeedBackDetailsEntity feedBackDetailsEntity){
		// 结果默认失败
		String result = "fail";
		// 更新意见反馈
		if (feedbackDao.updateFeedbackReply(feedBackDetailsEntity) > 0) {
		// 返回对应jsp
	     	result = "success";
		}
		// 返回
		return result;
	}

	@Override
	public String updateFeedback(FeedBackDetailsEntity feedBackDetailsEntity) {
		// 结果默认失败
		String result = "fail";
		// 更新意见反馈
		if (feedbackDao.updateFeedback(feedBackDetailsEntity) > 0) {
			// 返回对应jsp
			result = "success";
		}
		// 返回
		return result;
	}

	@Override
	public Date getSubmitTimeById(int id) {
		// 获取提交时间
		return feedbackDao.getSubmitTimeById(id);
	}

	/**
	 * 根据员工id获取意见反馈列表
	 */
	@Override
	public Map<String, List<FeedBackDetailsEntity>> getFeedbackByEmpcode(
			int start, int pageSize, String empCode) {
		// 常见问题
		List<NormalQuestionEntity> normalQuestionList = normalQuestionDao
				.getNormalQuestion();
		// 根据empCode获取意见反馈
		List<FeedBackDetailsEntity> list = feedbackDao.getFeedbackByEmpcode(
				start, pageSize, empCode);
		// 对常见问题结果集进行处理
		List<FeedBackDetailsEntity> normalQuestion = new ArrayList<FeedBackDetailsEntity>();
		// 结果集Map
		Map<String, List<FeedBackDetailsEntity>> map = new HashMap<String, List<FeedBackDetailsEntity>>();

		// 获取意见反馈图片路径(带ip、端口)
		String feedBackAddress = photoAddressService.getServerHostPort()
				+ photoAddressService.getFeedBackAddress().replace("/dpmfile", "");
		if (null != list && list.size() > 0) {
			// 循环 处理附件
			for (int i = 0; i < list.size(); i++) {
				// 获取文件名
				String fileName = list.get(i).getFileName();
				// 不为null
				if (StringUtils.isNotEmpty(fileName)) {
					// 多个文件
					String[] split = fileName.split(",");
					// 拼接
					StringBuilder sb = new StringBuilder();
					// 循环
					for (int j = 0; j < split.length; j++) {
						String file = feedBackAddress + "/" + split[j].trim();
						// 拼接
						sb.append(file.trim());
						// 拼接
						sb.append(",");
					}
					String str = sb.substring(0 , sb.length() - 1);
					// 重新设置
					list.get(i).setFileName(str);
				}
			}
		}
		
		/**根据用户id调用接口获取提成奖金的意见反馈列表，所需要的数据:
		 * feedBackId:反馈id (Integer)-->必须
		 * osType:登录类型 (String,例如：android,ios)
		 * type:反馈类型(String,例如：提成奖金)-->必须
		 * empCode:用户id(String)-->必须
		 * empName:用户名(String)-->必须
		 * content:反馈内容(String)
		 * executePerson:处理人(String)
		 * submitTime:提交时间(Date)@JSONField(format = "yyyy-MM-dd HH:mm:ss")-->必须
		 * fileName:图片的全路径(String)
		 * executeStatus:处理状态(String) 0:已解决，1：未解决  当在web页面来处理意见的反馈的时候会传递
		 * plan:迭代安排(String)
		 * PS:备注(String)
		 * isSolve:是否已解决(String) 0:已解决，1：未解决  当用户点击：是的，已解决的时候需要传递
		 * 除了必须的其他有就传递，没有则不传递
		 * 
		 * 
		 * 拿到数据后需要将2个集合合并并按照提交时间排序DESC
		 * */

		// 常见问题
		if (null != normalQuestionList && normalQuestionList.size() > 0) {
			// 循环
			for (NormalQuestionEntity normalQuestionEntity : normalQuestionList) {
				// 创建对象
				FeedBackDetailsEntity feedBackDetailsEntity = new FeedBackDetailsEntity();
				// 常见问题与意见反馈对象转换
				feedBackDetailsEntity.setContent(normalQuestionEntity
						.getContent());
				feedBackDetailsEntity.setTitle(normalQuestionEntity.getTitle());
				feedBackDetailsEntity.setType(normalQuestionEntity
						.getQuestionType());
				feedBackDetailsEntity.setSubmitTime(normalQuestionEntity
						.getCreateTime());
				// list
				normalQuestion.add(feedBackDetailsEntity);
			}
		}
		map.put("feedback", list);
		map.put("normal", normalQuestion);
		return map;
	}
	
	/**
	 * 意见反馈 问题类型
	 */
	@Override
	public List<FeedbackProblemListEntity> problemList() {
		return feedbackDao.problemList();
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public PhotoAddressService getPhotoAddressService() {
		return photoAddressService;
	}

	/**
	 * set
	 * 
	 * @param photoAddressService
	 */
	public void setPhotoAddressService(PhotoAddressService photoAddressService) {
		this.photoAddressService = photoAddressService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IFeedbackDao getFeedbackDao() {
		return feedbackDao;
	}

	/**
	 * set
	 * 
	 * @param feedbackDao
	 */
	public void setFeedbackDao(IFeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public NormalQuestionDao getNormalQuestionDao() {
		return normalQuestionDao;
	}

	/**
	 * set
	 * 
	 * @param
	 */
	public void setNormalQuestionDao(NormalQuestionDao normalQuestionDao) {
		this.normalQuestionDao = normalQuestionDao;
	}

	@Override
	public FeedBackPushEntity getSloverById(String userId) {
		return feedbackDao.getSloverById(userId);
	}

	@Override
	public List<FeedBackDetailsEntity> getReportListByHandleId(String userId, int current, int pageSize, FeedbackSearch search) {

		int start = (current - 1)*pageSize;

		List<FeedBackDetailsEntity> entitys = feedbackDao.getReportListByHandleId(userId, start, pageSize, search);

		for (FeedBackDetailsEntity entity : entitys) {
			if (entity != null) {
				String fileName = entity.getFileName();
				String feedBackAddress = photoAddressService.getServerHostPort()
						+ photoAddressService.getFeedBackAddress().replace("/dpmfile", "");
				// 不为null
				if (StringUtils.isNotEmpty(fileName)) {
					// 多个文件
					String[] split = fileName.split(",");
					// 拼接
					StringBuilder sb = new StringBuilder();
					// 循环
					for (int j = 0; j < split.length; j++) {
						// 默认list中的之后元素前面会有空，放在浏览器上会有%20字段，导致图片无法显示
						String file = feedBackAddress + "/" + split[j].trim();
						// 拼接
						sb.append(file.trim());
						// 拼接
						sb.append(",");
					}
					String str = sb.substring(0, sb.length() - 1);
					// 重新设置
					entity.setFileName(str);
				}
			}
		}

		return entitys;
	}

	@Override
	public int getReportListSize(String userId, FeedbackSearch search) {
		return feedbackDao.getReportListSize(userId, search);
	}
	
	/**
	 * 判断userId指定员工是否还有【指定类型】的意见反馈
	 * @param type 意见反馈类型
	 * @param userId 工号
	 * */
	@Override
	public boolean hasUnsolvedProblem(String type,String userId){
		
		return feedbackDao.hasUnsolvedProblem(type,userId);
	}
	
	/**
	 * 获取欢行小服务台问题列表
	 * @since 2019-04-12
	 * */
	@Override
	public List<HxQuestionEntity> getHxQuestions(){
		return feedbackDao.getHxQuestions();
	}
}
