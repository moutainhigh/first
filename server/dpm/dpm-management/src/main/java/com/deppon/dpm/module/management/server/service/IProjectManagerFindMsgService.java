package com.deppon.dpm.module.management.server.service;

import java.io.IOException;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * <p>
 * ClassName: ProjectManagerFindMsgService.
 * </p>
 * <p>
 * Description:获取界面参数
 * </p>
 * <p>
 * Author: xieyidong
 * </p>
 * <p>
 * Date: 2015-7-14
 * </p>
 */
public interface IProjectManagerFindMsgService {
	/*
	 * <p>Description:获取界面参数</p>
	 * 
	 * @param str
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #getProjectMsg(java.lang.String)
	 */
	public String getProjectMsg(String str) throws BusinessException, IOException; 
	/*
	 * <p>Description:单独获取历史评分项</p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #getSigHistoryInfo(java.lang.String)
	 */
	public String getSigHistoryInfo(String str) throws BusinessException;
	/*
	 * <p>移动端所有信息的提交方法————保存数据到PC端 Title: setToPcRecord</p>
	 * <p>Description:保存数据到PC端</p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #setToPcRecord(java.lang.String)
	 */
	public String setToPcRecord(String str) throws BusinessException, IOException;
	/*
	 * 提交检验 <p>Title: checkSubmit</p> <p>Description:提交检验</p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #checkSubmit(java.lang.String)
	 */
	public String checkSubmit(String str) throws BusinessException;
	
}
