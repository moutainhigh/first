package com.deppon.dpm.module.management.server.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import microsoft.exchange.webservices.data.Attachment;
import microsoft.exchange.webservices.data.AttachmentCollection;
import microsoft.exchange.webservices.data.BasePropertySet;
import microsoft.exchange.webservices.data.BodyType;
import microsoft.exchange.webservices.data.ConflictResolutionMode;
import microsoft.exchange.webservices.data.DeleteMode;
import microsoft.exchange.webservices.data.EmailAddress;
import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.EmailMessageSchema;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.FileAttachment;
import microsoft.exchange.webservices.data.FindItemsResults;
import microsoft.exchange.webservices.data.Folder;
import microsoft.exchange.webservices.data.HttpErrorException;
import microsoft.exchange.webservices.data.Item;
import microsoft.exchange.webservices.data.ItemId;
import microsoft.exchange.webservices.data.ItemSchema;
import microsoft.exchange.webservices.data.ItemView;
import microsoft.exchange.webservices.data.LogicalOperator;
import microsoft.exchange.webservices.data.MeetingMessage;
import microsoft.exchange.webservices.data.MessageBody;
import microsoft.exchange.webservices.data.OffsetBasePoint;
import microsoft.exchange.webservices.data.PropertySet;
import microsoft.exchange.webservices.data.ResponseMessage;
import microsoft.exchange.webservices.data.SearchFilter;
import microsoft.exchange.webservices.data.SortDirection;
import microsoft.exchange.webservices.data.WellKnownFolderName;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.deppon.dpm.module.common.server.util.ThreadCallBack;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IEmailService;
import com.deppon.dpm.module.management.shared.domain.DpmMail;
import com.deppon.dpm.module.management.shared.domain.EmailErrorLog;
import com.deppon.dpm.module.management.shared.domain.MailAttachment;
import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;
import com.deppon.dpm.module.management.shared.domain.NewDpmMail;
import com.deppon.dpm.module.management.shared.exception.EmailNullPointException;
import com.deppon.dpm.module.management.shared.exception.EmailPasswordErrorException;
import com.deppon.dpm.module.management.shared.exception.EmailPasswordNullPointException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 
 * EmailService 接口
 *
 */
public class EmailService extends OutlookService implements IEmailService {
    //标志位
	private final static int ITEMVIEW_10 = 10;
	//标志位
	private final static int ERRORCODE_4 = 4;
	//标志位
	private final static int ERRORCODE_3 = 3;
	//标志位
	private final static int ERRORCODE_2 = 2;
	//标志位
	private final static int ERRORCODE_1 = 1;
	//标志位
	private final static int ERRORCODE_0 = 0;
	//标志位
	private final static int LASTTIME_1000 = 1000;
	//标志位
	private final static int ADDHOURS_8 = 8;
	//标志位
	private final static int INITNUM = 50;
	//标志位
	private final static int MAXNUM = 200;
	//标志位
	private final static int ISREADNUM_500 = 500;
	//标志位
	private final static int MONTH_OFFSET = -2;

	/**
	 * 根据用户id分页查询邮件（旧版本，附件会一起加载）
	 */
	@Override
	public Result<Object> queryList(int page, int pageSize, String userId) {
		//返回的结果集
		final Result<Object> result = new Result<Object>();
		//封装邮件错误日志信息
		EmailErrorLog emailErrorLog = new EmailErrorLog();
		emailErrorLog.setUserId(userId);
		emailErrorLog.setPassword(getPassword(userId));
		try {
			//获取邮件地址  /dpmfile/emailattachment/
			String path = getRelativePath();
			//交换机服务
			ExchangeService service = null;
			try {
				//根据用户id获取对应的交换机
				service = getExchangeService(userId);
			} catch (Exception e) {
				//交换机获取失败，将错误信息封装进结果集
				emailErrorLog.setErrorMessage(e.getMessage());
				if (e instanceof EmailNullPointException) {
					result.setErrorCode(1);
					result.setData("邮箱为空");
				} else if (e instanceof EmailPasswordNullPointException) {
					result.setErrorCode(2);
					result.setData("邮箱密码为空");
				} else if (e instanceof EmailPasswordErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				logger.error("加载邮件列表调用getExchangeService失败>>>>>>>" +
						"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
				return result;
			}
			Folder inbox = null;
			try {
				//收件箱
				inbox = Folder.bind(service, WellKnownFolderName.Inbox);
			} catch (Exception e) {
				//收件箱获取失败，封装错误信息
				emailErrorLog.setErrorMessage(e.getMessage());
				if (e instanceof HttpErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				logger.error("加载邮件列表调用Folder.bind失败>>>>>>>" +
						"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
				return result;
			}

			ItemView view = new ItemView(pageSize, pageSize * (page - 1),
					OffsetBasePoint.Beginning);
			//分页获取邮件信息
			FindItemsResults<Item> findResults = service.findItems(
					inbox.getId(), view);

			List<DpmMail> list = new ArrayList<DpmMail>();
			//遍历
			for (Item item : findResults.getItems()) {
				if (item instanceof MeetingMessage) {
					continue;// 过滤会议
				}
				//邮箱消息
				EmailMessage message = (EmailMessage) item;
				
				//加载邮件
				item.load(PropertySet.FirstClassProperties);
				//邮件实体对象
				DpmMail dpmMail = new DpmMail(message);
				//如果有附件
				if (message.getHasAttachments()
						|| message.getAttachments().getCount() > 0) {
					String pre = userId
							+ message.getDateTimeReceived().getTime() + "@";
					//获取附件
					AttachmentCollection attachments = message.getAttachments();
					//遍历所有附件
					for (Attachment attachment : attachments) {
						if (!(attachment instanceof FileAttachment))
							continue;//排除不是文件附件
						final FileAttachment fileAttachment = (FileAttachment) attachment;
						//加载附件
						fileAttachment.load();
						//附件名称
						String name = fileAttachment.getName();
						if (fileAttachment.isContactPhoto()
								|| fileAttachment.getIsInline()) {// 内嵌式图片
							String contentId = fileAttachment.getContentId();
							//处理文件名
							String fileName = null;
							if (contentId.indexOf("@") != -1) {
								String[] split = contentId.split("@");
								if(split.length>1){
									fileName = split[1] + "@" + split[0];
								}
							} else {
								fileName = contentId + "@" + name;
							}
							//获取邮件内容
							String content = dpmMail.getContent();
							content = content.replaceAll("src=\"cid:"
									+ contentId, "src=\"" + serverHostPort
									+ "emailattachment/" + pre + fileName);
							dpmMail.setContent(content);
							//下载图片
							final File file = new File(path + pre + fileName);
							if (!file.exists()) {
								ThreadCallBack.run(new Runnable() {

									@Override
									public void run() {
										try {
											FileUtils.writeByteArrayToFile(
													file,
													fileAttachment.getContent());
										} catch (IOException e) {
											result.setErrorMessage(e
													.getMessage());
										}
									}
								});
							}
						} else {// 是附件，如ppt，excel，zip等
							dpmMail.getAttachments().add(
									serverHostPort + "emailattachment/" + pre
											+ name);
							//下载附件
							final File file = new File(path + pre + name);
							if (!file.exists())
								ThreadCallBack.run(new Runnable() {

									@Override
									public void run() {
										try {
											FileUtils.writeByteArrayToFile(
													file,
													fileAttachment.getContent());
										} catch (IOException e) {
											result.setErrorMessage(e
													.getMessage());
										}
									}
								});
						}
					}
				}
				//添加到集合中
				list.add(dpmMail);
			}
			//封装结果集
			result.setData(list);
			result.setCount(list.size());
			return result;
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setErrorMessage(e.getMessage());
			result.setData("查询收件箱列表错误");
			logger.error("加载邮件列表出现异常>>>>>>>" +
					"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
		}
		return result;
	}
	
	/**
	 * 查询邮件列表（新  201603017）
	 * 不会加载邮件，只返回部分邮件数据，点击邮件再请求加载邮件详情接口
	 */
	public Result<Object> queryListNew(int page, int pageSize, String userId) {
		//返回的结果集
		final Result<Object> result = new Result<Object>();
		try {
			//交换机服务
			ExchangeService service = null;
			try {
				//根据用户id获取对应的交换机
				service = getExchangeService(userId);
			} catch (Exception e) {
				//根据不同的异常设置返回的结果数据
				if (e instanceof EmailNullPointException) {
					result.setErrorCode(1);
					result.setData("邮箱为空");
				} else if (e instanceof EmailPasswordNullPointException) {
					result.setErrorCode(2);
					result.setData("邮箱密码为空");
				} else if (e instanceof EmailPasswordErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				//日志
				logger.error("queryListNew调用getExchangeService失败>>>>>>>" +
						"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
				//返回
				return result;
			}
			//定义收件箱
			Folder inbox = null;
			try {
				//收件箱
				inbox = Folder.bind(service, WellKnownFolderName.Inbox);
			} catch (Exception e) {
				//异常处理
				if (e instanceof HttpErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				//日志
				logger.error("queryListNew调用Folder.bind失败>>>>>>>" +
						"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
				//返回
				return result;
			}
			//指定分页信息
			ItemView view = new ItemView(pageSize, pageSize * (page - 1),
					OffsetBasePoint.Beginning);
			//指定返回字段
			this.setEmailPropertySet(view);
			//获取邮件集合
			FindItemsResults<Item> findResults = service.findItems(inbox.getId(), view);
			//定义邮件列表集合
			List<NewDpmMail> list = new ArrayList<NewDpmMail>();
			//空判断
			if(null != findResults){
				//遍历
				for (Item item : findResults.getItems()) {
					if (item instanceof MeetingMessage) {
						continue;// 过滤会议
					}
					//邮箱消息
					EmailMessage message = (EmailMessage) item;
					//封装邮件实体对象
					NewDpmMail dpmMail = new NewDpmMail(
												message.getId().getUniqueId(),
												message.getSubject(),
												message.getSender().getName(),
												message.getIsRead(),
												message.getHasAttachments(),
												message.getDateTimeReceived()
											);
					//添加到集合中
					list.add(dpmMail);
				}
			}
			//封装结果集
			result.setData(list);
			result.setCount(list.size());
			return result;
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setErrorMessage(e.getMessage());
			result.setData("加载收件箱列表错误");
			logger.error("queryListNew加载邮件列表失败>>>>>>>" +
					"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
		}
		return result;
	}
	
	/**
	 * 获取邮件列表（不加载附件）
	 * 2016-03-03
	 */
	@Override
	public Result<Object> queryListByPage(int page, int pageSize, String userId) {
		//返回的结果集
		final Result<Object> result = new Result<Object>();
		try {
			//获取邮件地址  /dpmfile/emailattachment/
			String path = getRelativePath();
			//交换机服务
			ExchangeService service = null;
			try {
				//根据用户id获取对应的交换机
				service = getExchangeService(userId);
			} catch (Exception e) {
				if (e instanceof EmailNullPointException) {
					result.setErrorCode(1);
					result.setData("邮箱为空");
				} else if (e instanceof EmailPasswordNullPointException) {
					result.setErrorCode(2);
					result.setData("邮箱密码为空");
				} else if (e instanceof EmailPasswordErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				logger.error("加载邮件列表调用getExchangeService失败>>>>>>>" +
						"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
				return result;
			}
			Folder inbox = null;
			try {
				//收件箱
				inbox = Folder.bind(service, WellKnownFolderName.Inbox);
			} catch (Exception e) {
				if (e instanceof HttpErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				logger.error("加载邮件列表调用Folder.bind失败>>>>>>>" +
						"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
				return result;
			}
			//指定分页信息
			ItemView view = new ItemView(pageSize, pageSize * (page - 1),
					OffsetBasePoint.Beginning);
			//指定排序，按照收件时间降序
			view.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Descending);
			//分页获取邮件信息
			FindItemsResults<Item> findResults = service.findItems(inbox.getId(), view);
			//定义返回的邮件数据结果集
			List<NewDpmMail> list = new ArrayList<NewDpmMail>();
			if(null != findResults){
				//遍历
				for (Item item : findResults.getItems()) {
					if (item instanceof MeetingMessage) {
						continue;// 过滤会议
					}
					//邮箱消息
					EmailMessage message = (EmailMessage) item;
					//加载邮件
					item.load(PropertySet.FirstClassProperties);
					//邮件实体对象
					NewDpmMail dpmMail = new NewDpmMail(message);
					//如果有附件
					if (message.getHasAttachments()
							|| message.getAttachments().getCount() > 0) {
						//附件名前缀
						String pre = userId
								+ message.getDateTimeReceived().getTime() + "@";
						//获取附件
						AttachmentCollection attachments = message.getAttachments();
						//遍历所有附件
						for (Attachment attachment : attachments) {
							if (!(attachment instanceof FileAttachment))
								continue;//排除不是文件附件
							final FileAttachment fileAttachment = (FileAttachment) attachment;
							/**处理附件start*/
							//附件名称
							String name = fileAttachment.getName();
							if (fileAttachment.isContactPhoto()
									|| fileAttachment.getIsInline()) {// 内嵌式图片
								//加载图片附件
								fileAttachment.load();
								String contentId = fileAttachment.getContentId();
								//处理文件名
								String fileName = null;
								if (contentId.indexOf("@") != -1) {
									String[] split = contentId.split("@");
									if(split.length>1){
										fileName = split[1] + "@" + split[0];
									}
								} else {
									fileName = contentId + "@" + name;
								}
								//获取邮件内容
								String content = dpmMail.getContent();
								content = content.replaceAll("src=\"cid:"
										+ contentId, "src=\"" + serverHostPort
										+ "emailattachment/" + pre + fileName);
								dpmMail.setContent(content);
								//下载图片
								final File file = new File(path + pre + fileName);
								if (!file.exists()) {
									ThreadCallBack.run(new Runnable() {
										
										@Override
										public void run() {
											try {
												FileUtils.writeByteArrayToFile(
														file,
														fileAttachment.getContent());
											} catch (IOException e) {
												result.setErrorMessage(e
														.getMessage());
											}
										}
									});
								}
							} else {// 是附件，如ppt，excel，zip等
								//附件实体
								MailAttachment mailAttachment = new MailAttachment();
								//附件id
								mailAttachment.setId(fileAttachment.getId());
								//附件Url，例如：https://dpm.deppon.com:8881/dpm/emailattachment/2690071453667982000@XXX.excel
								mailAttachment.setAttachmentUrl(serverHostPort + "emailattachment/" + pre + name);
								//封装进结果集
								dpmMail.getAttachments().add(mailAttachment);
							}
							
							/**处理附件end*/
						}
					}
					//添加到集合中
					list.add(dpmMail);
				}
			}
			//封装结果集
			result.setData(list);
			result.setCount(list.size());
			return result;
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setErrorMessage(e.getMessage());
			result.setData("加载收件箱列表错误");
			logger.error("加载邮件列表出现异常>>>>>>>" +
					"{userId="+userId+",page="+page+",pageSize="+pageSize+"}",e);
		}
		return result;
	}
	
	/**
	 * 设置搜索的邮件的返回字段
	 */
	private void setEmailPropertySet(ItemView view){
		// 设置返回字段
		view.setPropertySet(new PropertySet(
			        BasePropertySet.IdOnly,
			        ItemSchema.Subject,
			        ItemSchema.HasAttachments,
			        EmailMessageSchema.IsRead,
			        EmailMessageSchema.Sender,
			        ItemSchema.DateTimeReceived)
				);
	}
	
	/**
	 * 条件搜索邮件
	 * 
	 * @param userId
	 * @param searchType
	 * @param condition
	 * @param more
	 * @return
	 */
	@Override
	public Result<Object> searchEmailByCondition(String userId,
			String searchType, String condition, String more) {
		//返回的结果集
		final Result<Object> result = new Result<Object>();
		try {
			//交换机服务
			ExchangeService service = null;
			try {
				//根据用户id获取对应的交换机
				service = getExchangeService(userId);
			} catch (Exception e) {
				//根据不同的异常设置返回的结果数据
				if (e instanceof EmailNullPointException) {
					result.setErrorCode(1);
					result.setData("邮箱为空");
				} else if (e instanceof EmailPasswordNullPointException) {
					result.setErrorCode(2);
					result.setData("邮箱密码为空");
				} else if (e instanceof EmailPasswordErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				//日志
				logger.error("条件搜索邮件getExchangeService失败>>>>>>>" +
						"{userId="+userId+",searchType="+searchType+",condition="+condition+",more="+more+"}",e);
				//返回
				return result;
			}
			//定义收件箱
			Folder inbox = null;
			try {
				//收件箱
				inbox = Folder.bind(service, WellKnownFolderName.Inbox);
			} catch (Exception e) {
				//异常处理
				if (e instanceof HttpErrorException) {
					result.setErrorCode(2);
					result.setData("邮箱密码错误");
				}
				//日志
				logger.error("条件搜索邮件Folder.bind失败>>>>>>>" +
						"{userId="+userId+",searchType="+searchType+",condition="+condition+",more="+more+"}",e);
				//返回
				return result;
			}
			//指定分页信息
			ItemView view = new ItemView(INITNUM);
			//指定排序，按照收件时间降序
			view.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Descending);
			//指定返回字段
			this.setEmailPropertySet(view);
			
			//定义邮件集合
			FindItemsResults<Item> findResults = null;
			//传入参数判断
			if(StringUtil.isNotBlank(searchType) && StringUtil.isNotBlank(condition)){ 
				//前2个月的时间
				Date time = DateUtils.addMonths(new Date(), MONTH_OFFSET);
				//根据主题搜索
				if("subject".equals(searchType)){ 
					//点击更多
					if("yes".equals(more)){
						//加载符合条件的前200条
						view = new ItemView(MAXNUM);
						//排序设置
						view.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Descending);
						//指定返回字段
						this.setEmailPropertySet(view);
						//根据主题搜索，最多200条邮件
						findResults = service.findItems(inbox.getId(),//指定收件箱id
								new SearchFilter.SearchFilterCollection(
										LogicalOperator.And,//条件是and的关系
										//搜索条件：主题
										new SearchFilter.ContainsSubstring(ItemSchema.Subject, condition)
								),
								view);//分页信息
					}else{
						//根据主题搜索，并且指定2个月内的邮件
						findResults = service.findItems(inbox.getId(),//指定收件箱id
								new SearchFilter.SearchFilterCollection(
										LogicalOperator.And,//条件是and的关系
										//搜索条件：主题
										new SearchFilter.ContainsSubstring(ItemSchema.Subject, condition),
										//搜索条件：大于或等于这个时间（2个月内的）
										new SearchFilter.IsGreaterThan(ItemSchema.DateTimeSent, time)
										),
										view);//分页信息
					}
				}else if("sendFrom".equals(searchType)){ //根据发件人搜索
					//如果点击更多
					if("yes".equals(more)){
						//加载符合条件的前多少条
						view = new ItemView(MAXNUM);
						//排序设置
						view.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Descending);
						//指定返回字段
						this.setEmailPropertySet(view);
						//根据主题搜索，最多200条邮件
						findResults = service.findItems(inbox.getId(),//指定收件箱id
								new SearchFilter.SearchFilterCollection(
										LogicalOperator.And,//条件是and的关系
										//搜索条件：发件人
										new SearchFilter.ContainsSubstring(ItemSchema.LastModifiedName, condition)
								),
								view);//分页信息
					}else{
						//根据发件人搜索，并且指定2个月内的邮件
						findResults = service.findItems(inbox.getId(),//指定收件箱id
								new SearchFilter.SearchFilterCollection(
										LogicalOperator.And,//条件是and的关系
										//搜索条件：邮件发送人
										new SearchFilter.ContainsSubstring(ItemSchema.LastModifiedName, condition),
										//搜索条件：大于或等于这个时间（2个月内的）
										new SearchFilter.IsGreaterThanOrEqualTo(ItemSchema.DateTimeReceived, time)
										),
										view);//分页信息
					}
				}else if("all".equals(searchType)){ //根据主题或发件人搜索
					//如果点击更多
					if("yes".equals(more)){
						//加载符合条件的前200条
						view = new ItemView(MAXNUM);
						//排序设置
						view.getOrderBy().add(ItemSchema.DateTimeReceived, SortDirection.Descending);
						//指定返回字段
						this.setEmailPropertySet(view);
					}
					//根据主题或者发件人搜索
					findResults = service.findItems(inbox.getId(),//指定收件箱id
							new SearchFilter.SearchFilterCollection(
									LogicalOperator.Or,//条件是or的关系
									//搜索条件：邮件发送人
									new SearchFilter.ContainsSubstring(ItemSchema.LastModifiedName, condition),
									//搜索条件：主题
									new SearchFilter.ContainsSubstring(ItemSchema.Subject, condition)
							),
							view);//分页信息
				}
			}
			//定义邮件列表集合
			List<NewDpmMail> list = new ArrayList<NewDpmMail>();
			//空判断
			if(null != findResults){
				//遍历
				for (Item item : findResults.getItems()) {
					if (item instanceof MeetingMessage) {
						continue;// 过滤会议
					}
					//邮箱消息
					EmailMessage message = (EmailMessage) item;
					//封装邮件实体对象
					NewDpmMail dpmMail = new NewDpmMail(
												message.getId().getUniqueId(),
												message.getSubject(),
												message.getSender().getName(),
												message.getIsRead(),
												message.getHasAttachments(),
												message.getDateTimeReceived()
											);
					//添加到集合中
					list.add(dpmMail);
				}
			}
			//封装结果集
			result.setData(list);
			result.setCount(list.size());
			return result;
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setErrorMessage(e.getMessage());
			result.setData("查询收件箱列表错误");
			logger.error("条件搜索邮件出现异常>>>>>>>" +
					"{userId="+userId+",searchType="+searchType+",condition="+condition+",more="+more+"}",e);
		}
		return result;
	}
	
	/**
	 * 根据邮件id来加载邮件
	 * 
	 * 2016-02-18
	 */
	public Result<Object> loadEmailById(String userId, String emailId){
		//返回的结果集
		final Result<Object> result = new Result<Object>();
		//获取邮件地址  /dpmfile/emailattachment/
		String path = getRelativePath();
		//交换机服务
		ExchangeService service = null;
		try {
			//根据用户id获取对应的交换机
			service = getExchangeService(userId);
		} catch (Exception e) {
			if (e instanceof EmailNullPointException) {
				result.setErrorCode(1);
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			logger.error("根据邮件id加载邮件getExchangeService失败>>>>>>>" +
					"{userId="+userId+",emailId="+emailId+"}",e);
			return result;
		}
		Item item = null;
		try {
			//通过邮件id构建ItemId对象
			ItemId itemId = new ItemId(emailId);
			//获取Item对象
			item = Item.bind(service, itemId);
		} catch (Exception e) {
			//邮件绑定失败
			result.setErrorCode(2);
			result.setData("邮箱密码错误");
			logger.error("根据邮件id加载邮件Item.bind失败>>>>>>>" +
					"{userId="+userId+",emailId="+emailId+"}",e);
			
			return result;
		}
		//封装实体
		NewDpmMail dpmMail = null;
		try {
			// 加载邮件
			item.load(PropertySet.FirstClassProperties);
			//强转为邮件信息对象
			EmailMessage message = (EmailMessage) item;
			dpmMail = new NewDpmMail(message);
			//判断该邮件是否含有附件
			if (message.getHasAttachments() || message.getAttachments().getCount() > 0) {
				//获取邮件所有的附件
				AttachmentCollection attachments = message.getAttachments();
				//附件名前缀
				String pre = userId
						+ message.getDateTimeReceived().getTime() + "@";
				//遍历所有附件
				for (Attachment attachment : attachments) {
					if (!(attachment instanceof FileAttachment))
						continue;//排除不是文件附件
					final FileAttachment fileAttachment = (FileAttachment) attachment;
					/**处理附件start*/
					//附件名称
					String name = fileAttachment.getName();
					if (fileAttachment.isContactPhoto()
							|| fileAttachment.getIsInline()) {// 内嵌式图片
						//加载图片附件
						fileAttachment.load();
						String contentId = fileAttachment.getContentId();
						//处理文件名
						String fileName = null;
						if (contentId.indexOf("@") != -1) {
							String[] split = contentId.split("@");
							if(split.length>1){
								fileName = split[1] + "@" + split[0];
							}
						} else {
							fileName = contentId + "@" + name;
						}
						//获取邮件内容
						String content = dpmMail.getContent();
						content = content.replaceAll("src=\"cid:"
								+ contentId, "src=\"" + serverHostPort
								+ "emailattachment/" + pre + fileName);
						dpmMail.setContent(content);
						//下载图片
						final File file = new File(path + pre + fileName);
						if (!file.exists()) {
							ThreadCallBack.run(new Runnable() {
								
								@Override
								public void run() {
									try {
										FileUtils.writeByteArrayToFile(
												file,
												fileAttachment.getContent());
									} catch (IOException e) {
										result.setErrorMessage(e
												.getMessage());
									}
								}
							});
						}
					} else {// 是附件，如ppt，excel，zip等
						//附件实体
						MailAttachment mailAttachment = new MailAttachment();
						//附件id
						mailAttachment.setId(fileAttachment.getId());
						//附件Url，例如：https://dpm.deppon.com:8881/dpm/emailattachment/2690071453667982000@XXX.excel
						mailAttachment.setAttachmentUrl(serverHostPort + "emailattachment/" + pre + name);
						//封装进结果集
						dpmMail.getAttachments().add(mailAttachment);
					}
					
					/**处理附件end*/
				}
			}
			//封装结果集
			result.setErrorCode(ERRORCODE_0);
			result.setData(dpmMail);
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setErrorMessage(e.getMessage());
			result.setData("邮件加载失败");
			logger.error("根据邮件id来加载邮件出现异常>>>>>>>" +
					"{userId="+userId+",emailId="+emailId+"}",e);
		}
			
		return result;
	}
	

	/**
	 * 根据用户Id、设备类型、邮件Id删除邮件
	 * 
	 */
	@Override
	public Result<Object> delete(String userId, String osType, String[] emailIds)
			throws Exception {
		//构造结果集
		Result<Object> result = new Result<Object>();
		ExchangeService service = null;
		try {
			//根据用户Id获取邮件交换服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//获取服务的异常处理
			if (e instanceof EmailNullPointException) {
				result.setErrorCode(1);
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
			return result;
		}
		//遍历传递的邮件id
		for (String emailId : emailIds) {
			ItemId itemId = new ItemId(emailId);
			Item item = null;
			try {
				//邮件绑定服务
				item = Item.bind(service, itemId);
			} catch (Exception e) {
				//绑定异常处理
				if (e instanceof HttpErrorException) {
					//设置错误码
					result.setErrorCode(2);
					//设置错误信息
					result.setData("邮箱密码错误");
				}
				logger.info(e.getMessage());
				return result;
			}
			//无异常，删除邮件
			item.delete(DeleteMode.MoveToDeletedItems);
		}
		//返回结果集
		return result;
	}

	/**
	 * 根据用户id、邮件id标记邮件已读
	 */
	@Override
	public Result<Object> read(String userId, String emailId) throws Exception {
		//构造结果集
		Result<Object> result = new Result<Object>();
		ExchangeService service = null;
		try {
			//获取邮件交换服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//获取服务的各种异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			//日志输出错误信息
			logger.info(e.getMessage());
			//返回结果集
			return result;
		}

		//根据邮件id构建邮件组件
		ItemId itemId = new ItemId(emailId);
		Item item = null;
		try {
			//绑定服务
			item = Item.bind(service, itemId);
		} catch (Exception e) {
			//绑定服务异常处理
			if (e instanceof HttpErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			logger.info(e.getMessage());
			return result;
		}
		//强转为邮件信息
		EmailMessage message = (EmailMessage) item;
		message.setIsRead(true);
		//将此邮件更新为已读
		message.update(ConflictResolutionMode.AlwaysOverwrite);
		return result;
	}
	
	/**
	 * 更新多封邮件为已读状态
	 * 2016-01-29
	 */
	@Override
	public Result<Object> readAll(String userId) throws Exception {
		//构造返回的结果集
		Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取邮件服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//获取邮件服务的异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			//日志
			logger.error("更新多封邮件为已读状态调用getExchangeService失败>>>>>>>" +
					"{userId="+userId+"}",e);
			//返回
			return result;
		}
		
		// 收件箱
		Folder inbox = Folder.bind(service, WellKnownFolderName.Inbox);
		// 查询视图
		ItemView view = new ItemView(ISREADNUM_500);
		//创建过滤器, 条件为邮件未读.  
		SearchFilter sf = new SearchFilter.IsEqualTo(EmailMessageSchema.IsRead, false); 
		// 条件搜索
		FindItemsResults<Item> findItems = service.findItems(inbox.getId(),sf,view);
		// 空判断
		if(null != findItems && findItems.getItems().size() > 0){
			// 遍历
			for (Item item : findItems) {
				//强转为邮件信息对象
				EmailMessage message = (EmailMessage) item;
				//如果邮件未读
				if(!message.getIsRead()){
					//设置邮件已读
					message.setIsRead(true);
					//更新状态
					message.update(ConflictResolutionMode.AlwaysOverwrite);
				}
			}
		}
		// 设置返回结果
		result.setErrorCode(ERRORCODE_0);
		// 返回
		return result;
	}

	/**
	 * 下载邮件附件
	 */
	@Override
	@Deprecated
	public Result<Object> downLoad(String userId, String emailId,
			String attachmentName) throws Exception {
		//构造返回的结果集
		Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取邮件服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
			//返回
			return result;
		}

		//构建邮件实体对象
		ItemId itemId = new ItemId(emailId);
		Item item = null;
		try {
			//获取邮件
			item = Item.bind(service, itemId);
		} catch (Exception e) {
			//获取邮件异常处理
			if (e instanceof HttpErrorException) {
				//设置错误码
				result.setErrorCode(2);
				//设置错误信息
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
			//返回
			return result;
		}
		//强转为邮件信息对象
		EmailMessage message = (EmailMessage) item;
		//判断该邮件是否含有附件
		if (message.getHasAttachments()) {
			//获取邮件所有的附件
			AttachmentCollection attachments = message.getAttachments();
			//遍历附件
			for (Attachment attachment : attachments) {
				//强转为文件附件
				FileAttachment fileAttachment = (FileAttachment) attachment;
				//加载附件
				fileAttachment.load();
				//获取附件名称
				String name = fileAttachment.getName();
				//判断如果附件名称与要下载的附件名称一致
				if (name.equals(attachmentName)) {
					//将附件内容封装进结果集
					result.setData(fileAttachment.getContent());
					//返回
					return result;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * 下载邮件附件 （新）
	 */
	public Result<Object> downloadAttachment(String userId,String emailId,String attachmentId,String attachmentUrl){
		//构造返回的结果集
		final Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取邮件服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(ERRORCODE_1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(ERRORCODE_2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(ERRORCODE_2);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.error("下载邮件附件调用getExchangeService失败>>>>>>>" +
					"{userId="+userId+",emailId="+emailId+",attachmentId="+attachmentId+",attachmentUrl="+attachmentUrl+"}",e);
			//返回
			return result;
		}
		
		Item item = null;
		try {
			//获取附件加载到本地服务器的路径
			String path = attachmentUrl.replaceAll(serverHostPort, "/dpmfile/");
			//通过邮件id构建ItemId对象
			ItemId itemId = new ItemId(emailId);
			//获取Item对象
			item = Item.bind(service, itemId);
			//强转为邮件信息对象
			EmailMessage message = (EmailMessage) item;
			//判断该邮件是否含有附件
			if (message.getHasAttachments() || message.getAttachments().getCount() > 0) {
				//获取邮件所有的附件
				AttachmentCollection attachments = message.getAttachments();
				
				/**处理附件 start*/
				//遍历附件
				for (Attachment attachment : attachments) {
					if (!(attachment instanceof FileAttachment))
						continue;//排除不是文件附件
					//强转为文件附件
					final FileAttachment fileAttachment = (FileAttachment) attachment;
					//判断如果当前遍历到的附件id与传递的附件id是否一致
					if(fileAttachment.getId().equals(attachmentId)){
						try {
							//加载附件
							fileAttachment.load();
							//附件路径
							File file = new File(path);
							//将附件下载到服务器本地
							FileUtils.writeByteArrayToFile(file,fileAttachment.getContent());
						} catch (Exception e) {
							result.setErrorCode(ERRORCODE_3);
							result.setErrorMessage("附件加载失败");
							logger.error("加载附件失败>>>>>>>" +
									"{userId="+userId+",emailId="+emailId+",attachmentId="+attachmentId+",attachmentUrl="+attachmentUrl+"}",e);
							return result;
						}
						//成功
						result.setErrorCode(ERRORCODE_0);
					}
				}
				/**处理附件 end*/
			}
		} catch (Exception e) {
			result.setErrorCode(ERRORCODE_3);
			result.setErrorMessage("系统异常，请稍后再试");
			//日志输出
			logger.error("下载邮件附件出现异常>>>>>>>" +
					"{userId="+userId+",emailId="+emailId+",attachmentId="+attachmentId+",attachmentUrl="+attachmentUrl+"}",e);
			//返回
			return result;
		}
		//返回
		return result;
	}

	/**
	 * 查看是否有新邮件
	 */
	@Override
	public Result<Object> hasNew(String userId, long lastTime) throws Exception {
		//构造返回的结果集
		Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取邮件服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//获取邮件服务的异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			//返回
			return result;
		}
		Folder inbox = null;
		try {
			//收件箱
			inbox = Folder.bind(service, WellKnownFolderName.Inbox);
		} catch (Exception e) {
			if (e instanceof HttpErrorException) {
				result.setErrorCode(2);
				result.setData("邮箱密码错误");
			}
			return result;
		}
		ItemView view = new ItemView(ITEMVIEW_10);
		//获取收件箱中邮件
		FindItemsResults<Item> findResults = service.findItems(inbox.getId(),
				view);
		//遍历
		for (Item item : findResults.getItems()) {
			//获取接收邮件时间+8小时   的毫秒数
			long time = DateUtils.addHours(item.getDateTimeReceived(),
					ADDHOURS_8).getTime();
			//判断如果偏移后的时间是大于传递的最后时间，说明有新邮件
			if (time > lastTime * LASTTIME_1000) {
				//设置状态吗
				result.setErrorCode(0);
				//设置信息
				result.setErrorMessage("有新邮件");
				return result;
			} else if (time < lastTime) {
				result.setErrorCode(1);
				result.setErrorMessage("没有新邮件");
				return result;
			}
		}
		//如果一次都没有遍历，说明没有邮件，也就没有新邮件
		result.setErrorCode(1);
		result.setErrorMessage("没有新邮件");
		return result;
	}

	/**
	 * 邮件回复
	 */
	public Result<Object> reply(String userId, String emailId, String subject,
			String replyContent) {

		//构造返回的结果集
		Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取邮件服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(ERRORCODE_3);
				result.setData("邮箱密码错误");
			}
			logger.info(e.getMessage());
			return result;
		}

		ItemId itemId = null;
		try {
			//根据邮件id构造邮件实体对象
			itemId = new ItemId(emailId);
		} catch (Exception e1) {
			//如果构造失败，邮件回复错误
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件回复失败");
			//返回
			return result;
		}
		Item item = null;
		try {
			//绑定邮件服务
			item = Item.bind(service, itemId);
		} catch (Exception e) {
			//如果绑定出现异常，说明邮件密码错误
			if (e instanceof HttpErrorException) {
				result.setErrorCode(ERRORCODE_3);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
		}

		// sonar 整改
		if (null == item) {
			//如果以上发生异常，直接邮件回复失败
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件回复失败");
			return result;
		}
		//强转为邮件消息对象
		EmailMessage message = (EmailMessage) item;
		//构建消息体
		MessageBody body = new MessageBody();
		//设置消息体类型
		body.setBodyType(BodyType.HTML);
		// sonar 整改
		// body.setText(replyContent);
		//设置消息体的内容
		body.setText(replyContent == null ? "" : replyContent);
		try {
			//创建一个邮件回复
			ResponseMessage reply = message.createReply(false);
			//判断
			if (reply != null) {
				//设置回复主题
				reply.setSubject(subject);
				//设置回复的消息体
				reply.setBodyPrefix(body);
				//回复邮件
				reply.sendAndSaveCopy();
			}
		} catch (Exception e) {
			//邮件回复的异常处理
			e.printStackTrace();
			//设置错误码
			result.setErrorCode(ERRORCODE_4);
			//设置错误信息
			result.setResult("邮件回复失败");
		}
		//返回
		return result;
	}
	
	/**
	 * 邮件回复
	 */
	public Result<Object> replyAll(String userId, String emailId, String subject,
			String emailTo, String replyContent) {
		//构造返回的结果集
		Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取邮件服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(ERRORCODE_3);
				result.setData("邮箱密码错误");
			}
			logger.info(e.getMessage());
			return result;
		}

		ItemId itemId = null;
		try {
			//根据邮件id构造邮件实体对象
			itemId = new ItemId(emailId);
		} catch (Exception e1) {
			//如果构造失败，邮件回复错误
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件回复失败");
			//返回
			return result;
		}
		Item item = null;
		try {
			//绑定邮件服务
			item = Item.bind(service, itemId);
		} catch (Exception e) {
			//如果绑定出现异常，说明邮件密码错误
			if (e instanceof HttpErrorException) {
				result.setErrorCode(ERRORCODE_3);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
		}

		// sonar 整改
		if (null == item) {
			//如果以上发生异常，直接邮件回复失败
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件回复失败");
			return result;
		}
		//强转为邮件消息对象
		EmailMessage message = (EmailMessage) item;
		//构建消息体
		MessageBody body = new MessageBody();
		//设置消息体类型
		body.setBodyType(BodyType.HTML);
		//设置消息体的内容
		body.setText(replyContent == null ? "" : replyContent);
		try {
			// 回复所有人
			message.reply(body, true);
		} catch (Exception e) {
			//邮件回复的异常处理
			e.printStackTrace();
			//设置错误码
			result.setErrorCode(ERRORCODE_4);
			//设置错误信息
			result.setResult("邮件全部回复失败");
		}
		//返回
		return result;
	}

	/**
	 * 邮件转发
	 */
	@Override
	public Result<Object> forward(String userId, String emailId,
			String subject, String emailTo, String emailToCc, String forwardContent) {

		//构造返回结果集
		Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(ERRORCODE_3);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
			//返回
			return result;
		}

		ItemId itemId = null;
		try {
			//根据邮件Id构建实体对象
			itemId = new ItemId(emailId);
		} catch (Exception e1) {
			//构建异常直接返回
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件转发失败");
			return result;
		}
		Item item = null;
		try {
			//绑定服务
			item = Item.bind(service, itemId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof HttpErrorException) {
				//设置错误码
				result.setErrorCode(ERRORCODE_3);
				//设置错误信息
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
		}
		// sonar 整改
		//如果以上出现异常
		if (null == item) {
			//设置错误码
			result.setErrorCode(ERRORCODE_4);
			//设置参错误信息
			result.setResult("邮件转发失败");
			//返回
			return result;
		}
		//强转为邮件消息对象
		EmailMessage message = (EmailMessage) item;
		try {
			// sonar 整改
			// String[] split = emailTo.split(",");
			//以,作为切割点  转为String数组，元素为被转发人邮箱
			String[] split = (emailTo == null) ? new String[] {} : emailTo
					.split(",");
			// 抄送
			String[] toCcEmails = null;
			if(StringUtils.isNotBlank(emailToCc)){
				toCcEmails = emailToCc.split(",");
			}
			//构造消息体
			MessageBody body = new MessageBody();
			//设置消息体的类型为HTML
			body.setBodyType(BodyType.HTML);
			//设置消息体的内容
			body.setText(forwardContent);
			//创建转发
			ResponseMessage forward = message.createForward();
			//判断
			if (forward != null) {
				//设置转发的消息体
				forward.setBodyPrefix(body);
				//设置转发的主题
				forward.setSubject(subject);
				//遍历被转发人
				for (int i = 0; i < split.length; i++) {
					//添加转发的接收人
					forward.getToRecipients().add(new EmailAddress(split[i]));
				}
				// 抄送
				if(null != toCcEmails){
					for (String ccEmail : toCcEmails) {
						forward.getCcRecipients().add(new EmailAddress(ccEmail));
					}
				}
				//设置消息体的主题
				message.setSubject(subject);
				//转发
				forward.sendAndSaveCopy();
				result.setResult("邮件转发成功");
			} else {
				//如果转发创建失败
				//设置错误码
				result.setErrorCode(ERRORCODE_4);
				//设置错误信息
				result.setResult("邮件转发失败");
			}
		} catch (Exception e) {
			//转发出现异常
			e.printStackTrace();
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件转发失败");
		}
		//返回
		return result;
	}

	/**
	 * 发送邮件，带多附件
	 */
	@Override
	public Result<Object> sendEmail(MailSenderInfo info, String userId,
			File[] files) throws Exception {
		//构造返回的结果集
		Result<Object> result = new Result<Object>();
		//定义邮件服务
		ExchangeService service = null;
		try {
			//获取服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(ERRORCODE_3);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
			//返回
			return result;
		}
		//构建邮件消息实体对象
		EmailMessage message = new EmailMessage(service);
		//定义读取文件的输入流
		FileInputStream fs = null;
		try {
			//构造消息体对象
			MessageBody body = new MessageBody();
			//设置消息主题
			message.setSubject(info.getSubject());
			//设置消息体
			message.setBody(body);
			//设置消息体的类型
			body.setBodyType(BodyType.Text);
			//设置消息体的内容
			body.setText(info.getContent());
			//遍历要发送的邮箱
			for (int i = 0; i < info.getToAddress().size(); i++) {
				// 收件人地址
				message.getToRecipients().add(
						new EmailAddress(info.getToAddress().get(i)));
			}
			// 抄送人邮箱
			if(null != info.getToCcAddress() && info.getToCcAddress().size() > 0){
				for (String toCcAddr : info.getToCcAddress()) {
					message.getCcRecipients().add(new EmailAddress(toCcAddr));
				}
			}
			//判断发送的邮件是否有附件
			if (null != files && files.length > 0) {
				//遍历附件
				for (int i = 0; i < files.length; i++) {
					//判断附件不为空
					if (null != files[i]) {
						//创建一个输入流来读取附件
						fs = new FileInputStream(files[i]);
						//将附件添加进消息实体中
						message.getAttachments().addFileAttachment(
								info.getAttachFileNames()[i], fs);
					}
				}
			}

			//发送邮件
			message.sendAndSaveCopy();
			//邮件发送成功
			result.setErrorCode(0);
			result.setResult("邮件发送成功");
		} catch (IOException e) {
			//发送邮件异常
			e.printStackTrace();
			//设置错误码
			result.setErrorCode(ERRORCODE_4);
			//设置错误信息
			result.setResult("邮件发送失败");
		} catch (Exception e) {
			e.printStackTrace();
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件发送失败");
		} finally {
			//释放资源
			try {
				if (null != fs) {
					fs.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//返回
		return result;
	}

	/**
	 * 发送邮件，带单个附件
	 */
	@Override
	public Result<Object> sendEmail(MailSenderInfo info, String userId,
			File file) throws Exception {
		//构造返回的结果集
		Result<Object> result = new Result<Object>();
		//定义邮件交换服务
		ExchangeService service = null;
		try {
			//获取邮件服务
			service = getExchangeService(userId);
		} catch (Exception e) {
			//异常处理
			if (e instanceof EmailNullPointException) {
				//设置错误码
				result.setErrorCode(1);
				//设置错误信息
				result.setData("邮箱为空");
			} else if (e instanceof EmailPasswordNullPointException) {
				result.setErrorCode(2);
				result.setData("邮箱密码为空");
			} else if (e instanceof EmailPasswordErrorException) {
				result.setErrorCode(ERRORCODE_3);
				result.setData("邮箱密码错误");
			}
			//日志输出
			logger.info(e.getMessage());
			//返回
			return result;
		}
		
		//获取邮件消息实体对象
		EmailMessage message = new EmailMessage(service);
		//定义输入流
		FileInputStream fs = null;
		try {
			//构造消息体
			MessageBody body = new MessageBody();
			//设置消息主题
			message.setSubject(info.getSubject());
			//设置消息体
			message.setBody(body);
			//设置消息体类型
			body.setBodyType(BodyType.Text);
			//设置消息体内容
			body.setText(info.getContent());
			//遍历邮件接收人
			for (int i = 0; i < info.getToAddress().size(); i++) {
				// 收件人地址
				message.getToRecipients().add(
						new EmailAddress(info.getToAddress().get(i)));
			}
			// 单个附件
			if (null != file) {
				//创建读取附件的输入流
				fs = new FileInputStream(file);
				message.getAttachments().addFileAttachment(
						info.getAttachFileNames()[0], fs);
			}
			
			//发送邮件
			message.sendAndSaveCopy();
			//邮件发送成功
			result.setErrorCode(0);
			result.setResult("邮件发送成功");
			//邮件发送异常
		} catch (IOException e) {
			//捕获io异常，附件出错
			e.printStackTrace();
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件发送失败");
		} catch (Exception e) {
			//其他异常捕获，邮件发送失败
			e.printStackTrace();
			result.setErrorCode(ERRORCODE_4);
			result.setResult("邮件发送失败");
		} finally {
			//释放资源
			try {
				if (null != fs) {
					fs.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//返回
		return result;
	}
}
