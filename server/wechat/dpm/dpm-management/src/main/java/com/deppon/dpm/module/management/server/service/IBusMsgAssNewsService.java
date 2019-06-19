package com.deppon.dpm.module.management.server.service;

/**
 * <!-- 异常信息的查询、新增，评价建议的回复、删除，开线建议统计、新增 Service层-->
 * 
 * @author xieyidong
 * @date 2015-6-29 上午8:58:10
 * @since
 * @version
 */
public interface IBusMsgAssNewsService {
	/**
	 * <p>
	 * 获取异常信息表的数据
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-29 上午11:22:03
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#getGustyMessage()
	 */
	public String getGustyMessage() throws Exception;

	/**
	 * <p>
	 * 保存消息表
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-29 下午2:01:31
	 * @param str
	 *            （用户Id、内容）
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#saveGustyMessage(java.lang.String)
	 */
	public String saveGustyMessage(String str) throws Exception;

	/**
	 * <p>
	 * 点击量保存
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 上午10:13:52
	 * @param str
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#saveHits(java.lang.String)
	 */
	public String saveHits(String str) throws Exception;

	/**
	 * <p>
	 * 保存建议新开的站点
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:50:54
	 * @param str
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#saveSite(java.lang.String)
	 */
	public String saveSite(String str) throws Exception;

	/**
	 * <p>
	 * 删除评价回复
	 * </p>
	 * 
	 * @author xieyidong
	 * @date 2015-7-1 下午6:57:29
	 * @param str
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#deleteReplySugg(java.lang.String)
	 */
	public String deleteReply(String str) throws Exception;

	/*
	 * <p>Title: saveReply</p> <p>Description:保存建议评价回复</p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService
	 * #saveReply(java.lang.String)
	 */
	public String saveReply(String str) throws Exception;
	/**
	 * 保存建议
	 * @param openId
	 * @param userNo
	 * @param replyContent
	 * @return
	 */
	public int setSuggest(int openId,
			String userNo, String replyContent) ;
	/** 
	* @Title: saveOtherData 
	* @Description: 走你
	* @param @param siteId
	* @param @param userNo
	* @param @return
	* @param @throws Exception    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/ 
	
	public boolean saveOtherData(int siteId, String userNo) ;

}
