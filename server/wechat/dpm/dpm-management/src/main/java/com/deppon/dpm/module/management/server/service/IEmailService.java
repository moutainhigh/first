package com.deppon.dpm.module.management.server.service;

import java.io.File;

import microsoft.exchange.webservices.data.ExchangeService;

import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;

public interface IEmailService {
	
	/**
	 *获取邮件列表（新20160303） 
	 * @param page
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public Result<Object> queryListNew(int page, int pageSize, String userId);

	/**
	 * 获取邮件列表
	 * 
	 * @param page
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public Result<Object> queryList(int page, int pageSize, String userId);
	
	/**
	 * 获取邮件列表（新）
	 * 2016-01-29
	 */
	public Result<Object> queryListByPage(int page, int pageSize, String userId);
	
	/**
	 * 条件搜索邮件
	 * 
	 * @param userId
	 * @param searchType
	 * @param condition
	 * @param more
	 * @return
	 */
	public Result<Object> searchEmailByCondition(String userId,String searchType, String condition, String more);
	
	/**
	 * 根据邮件id加载附件
	 * 2016-02-18
	 * @param userId
	 * @param emailId
	 * @return
	 */
	public Result<Object> loadEmailById(String userId, String emailId);

	/**
	 * 将邮件从收件箱移动到已删除邮件
	 * 
	 * @param userId
	 * @param osType
	 * @param emailIds
	 * @return
	 * @throws Exception
	 */
	public Result<Object> delete(String userId, String osType, String[] emailIds)
			throws Exception;

	/**
	 * 读取一封邮件，更新成已读状态
	 * 
	 * @param userId
	 * @param emailId
	 * @return
	 * @throws Exception
	 */
	public Result<Object> read(String userId, String emailId) throws Exception;
	
	/**
	 * 更新多封邮件成已读
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Result<Object> readAll(String userId) throws Exception;

	/**
	 * 获取邮件服务
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public ExchangeService getExchangeService(String userId) throws Exception;

	/**
	 * 下载邮件中的附件
	 * 
	 * @param userId
	 * @param emailId
	 * @param attachmentName
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public Result<Object> downLoad(String userId, String emailId,
			String attachmentName) throws Exception;
	
	/**
	 * 下载附件 （新）
	 * 
	 * @param userId
	 * @param emailId
	 * @param attachmentId
	 * @param attachmentUrl
	 * @return
	 */
	public Result<Object> downloadAttachment(String userId,String emailId,String attachmentId,String attachmentUrl);

	/**
	 * 是否含有新邮件
	 * 
	 * @param userId
	 * @param lastTime
	 * @return
	 * @throws Exception
	 */
	public Result<Object> hasNew(String userId, long lastTime) throws Exception;

	/**
	 * 邮件回复
	 * 
	 * @param userId
	 * @param emailId
	 * @param subject
	 * @param replyContent
	 * @return
	 * @throws Exception
	 */
	public Result<Object> reply(String userId, String emailId, String subject,
			String replyContent) throws Exception;
	
	/**
	 * 邮件回复
	 * 
	 * @param userId
	 * @param emailId
	 * @param subject
	 * @param replyContent
	 * @return
	 * @throws Exception
	 */
	public Result<Object> replyAll(String userId, String emailId, String subject,
			String emailTo,String replyContent) throws Exception;

	/**
	 * 邮件转发
	 * 
	 * @param userId
	 * @param emailId
	 * @param subject
	 * @param emailTo
	 * @param replyContent
	 * @return
	 * @throws Exception
	 */
	public Result<Object> forward(String userId, String emailId,
			String subject, String emailTo, String emailToCc, String replyContent)
			throws Exception;

	/**
	 * 邮件发送 单个附件
	 * 
	 * @param info
	 * @param userId
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public Result<Object> sendEmail(MailSenderInfo info, String userId,
			File file) throws Exception;

	/**
	 * 邮件发送 多个附件
	 * 
	 * @param info
	 * @param userId
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public Result<Object> sendEmail(MailSenderInfo info, String userId,
			File[] files) throws Exception;

}
