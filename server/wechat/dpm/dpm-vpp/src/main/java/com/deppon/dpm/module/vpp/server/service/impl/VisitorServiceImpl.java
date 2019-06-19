package com.deppon.dpm.module.vpp.server.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.vpp.server.service.IVisitorService;

/**
 * 访客预约
 * @author 195406 高春玲
 * @date 2017-4-19 下午1:45:08
 **/
public class VisitorServiceImpl implements IVisitorService {

	private static Logger logger  = LoggerFactory.getLogger(VisitorServiceImpl.class);
    //访客预约保存接口地址
	private String vppaddUrl;
	//访客信息查询接口地址
	private String vppqueryUrl;
	//访客信息删除接口地址
	private String vppdelUrl;
	
	
	
	
	/**
     * 访客预约保存
     */
	@Override
	public String visitorAdd(String json) throws IOException {
		logger.info("vpp visitorAdd url is :" + this.vppaddUrl);
		return HttpUtil.doPostJson(this.vppaddUrl, json);
	}
	/**
	 * @param vppaddUrl the vppaddUrl to set
	 */
	public void setVppaddUrl(String vppaddUrl) {
		this.vppaddUrl = vppaddUrl;
	}
   
	
	/**
	 * 删 除访客信息
	 * */
	@Override
	public String visitorDel(String json) throws IOException {
		logger.info("vpp visitorDel url is :" + this.vppdelUrl);
		return HttpUtil.doPostJson(this.vppdelUrl, json);
		
	}
	/**
	 * @param vppdelUrl the vppdelUrl to set
	 */
	public void setVppdelUrl(String vppdelUrl) {
		this.vppdelUrl = vppdelUrl;
	}

	
	/**
	 * 预约信息查询
	 * */
	@Override
	public String visitorQuery(String json) throws IOException {
		
		logger.info("vpp visitorQuery url is :" + this.vppqueryUrl);
		return HttpUtil.doPostJson(this.vppqueryUrl, json);
		
	}
	/**
	 * @param vppqueryUrl the vppqueryUrl to set
	 */
	public void setVppqueryUrl(String vppqueryUrl) {
		this.vppqueryUrl = vppqueryUrl;
	}
	
}
