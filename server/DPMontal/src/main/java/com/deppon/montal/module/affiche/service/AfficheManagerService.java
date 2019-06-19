/**
 * Project Name:DPMontal_20141030
 * File Name:AfficheManagerService.java
 * Package Name:com.deppon.montal.module.affiche.service
 * Date:2014-10-18上午11:34:03
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.montal.module.affiche.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.deppon.dpm.webserviceclient.affiche.dip.integrateportal.informationcenter.bulletinmanage.InnerGgService;
import com.deppon.esb.header.ESBHeader;
import com.deppon.montal.util.JSONUtil;
import com.google.gson.Gson;

/**
 * ClassName:AfficheManagerService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-10-18 上午11:34:03 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class AfficheManagerService implements IAfficheManagerService{

	/**
	 * 日志
	 */
	private static Logger logger = Logger.getLogger(AfficheManagerService.class);
	
	@Resource
	private InnerGgService innerGgService;
	
	/**
	 * 返回处理结果标志 1成功 0失败
	 */
	private final static String STATUS_CODE = "statusCode";
	
	/**
	 * 操作码 1、查询2、增加3、修改、4删除
	 */
	private final static String CODE = "code";
	
	/**
	 * 返回详细信息
	 */
	private final static String MSG = "msg";
	
	/**
	 * OA处理成功标志
	 */
	private final static String STATUS_CODE_SUCCESS = "1";
	
	/**
	 * OA处失败标志
	 */
	private final static String STATUS_CODE_FAIL = "0";
	
	/**
	 * ESB处理SOAP HEADER帮助
	 */
	private ESBHeader esbHeader;
	
	/**
	 * 版本号
	 */
	private static final String VERSION = "0.1";
	
	private String[] smallPicPath = {"http://ioa.deppon.com/portal/upload/popPics/pop_0.jpg",
			"http://ioa.deppon.com/portal/upload/popPics/pop_1.jpg",
			"http://ioa.deppon.com/portal/upload/popPics/pop_2.jpg"}; 

	/**
	 * 业务ID
	 */
	private static final String BUSINESS_ID = "affiche";
	
	private static final String ESB_SERVICE_CODE = "ESB_DPM2ESB_OA_NOTICE";
	
	private void createHeader() {
		if (this.esbHeader == null) {
			esbHeader = new ESBHeader();
			esbHeader.setVersion(VERSION);
			esbHeader.setBusinessId(BUSINESS_ID);
			esbHeader.setSourceSystem("DPM");
//			esbHeader.setTargetSystem("OA");
			esbHeader.setMessageFormat("SOAP");
			esbHeader.setExchangePattern(1);
		}
	}
	
	@Override
	public String queryInnerGg(String requestStr) throws Exception{
		createHeader();
		esbHeader.setRequestId(getUUID());
		esbHeader.setEsbServiceCode(ESB_SERVICE_CODE);
		String json = innerGgService.queryInnerGg(requestStr, esbHeader);
		logger.info("公告图片查询操作返回报文:" + json);
		Map resultMap = JSONUtil.toMap(json,String.class,Object.class);
		if(STATUS_CODE_FAIL.equals(resultMap.get(STATUS_CODE))){
			String code = (String) resultMap.get(CODE);
			String msg = (String) resultMap.get(MSG);
			throw new Exception("错误详情[code:" + code + ",msg:" + msg + "]");
		}
		List picLst = (List)resultMap.get("msg");
		//获取缩略图地址
		if(picLst != null && picLst.size() > 0){
			for(int i = 0; i < picLst.size() && i < 3; i++){
				((Map)picLst.get(i)).put("smallPicPath", smallPicPath[i]);
			}
			json = JSONUtil.encapsulateJsonObject(resultMap);
		}
		return json;
	}
	
	/**
	 * 获取UUID
	 * getUUID: <br/>
	 * 
	 * Date:2014-10-18上午9:03:03
	 * @author 157229-zxy
	 * @return
	 * @since JDK 1.6
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

}

