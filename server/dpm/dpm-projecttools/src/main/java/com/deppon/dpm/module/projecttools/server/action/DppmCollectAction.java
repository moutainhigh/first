package com.deppon.dpm.module.projecttools.server.action;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.projecttools.server.service.IDppmCollectService;
import com.deppon.dpm.module.projecttools.shared.vo.CollectVo;
/**
 * 项目管理 我的关注收藏
 * @author gcl
 * 2015-07-27
 */
public class DppmCollectAction extends BaseAction {
	/*** 日志*/
	private Logger logger = LoggerFactory.getLogger(DppmCollectAction.class);
	
	private static final long serialVersionUID = 1L;
	
	/*** service*/
	private IDppmCollectService service;
	

	/**
	 *  点击收藏
	 */
	public void collectInfo() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		int resInfo = 0 ;
        if ("POST".equals(request.getMethod())) {
            try {
                BufferedReader bu = ServletActionContext.getRequest()
                        .getReader();
                CollectVo vo = null;
                // 前端 参数获得
                String str = StringUtil.bufferString(bu);
                this.logger.info("点击我的收藏  param is :" + str);
                if (!com.deppon.foss.framework.shared.util.string.StringUtil
                        .isEmpty(str)) {
                    vo = JSONObject.parseObject(str, CollectVo.class);
                    // 执行收藏操作
                    resInfo = this.service.dppmCollect(vo);
                    // 返回收藏标示 到前端
                    writeToPage(response, resInfo + "");
                }
            } catch (Exception e) {
                logger.info("点击我的收藏出现异常！", e);
                resInfo = 0;
                writeToPage(response, resInfo + "");
            }
        }else{
		    writeToPage(response, "");
		}
	}


	/**
	 * @param service
	 */
	public void setService(IDppmCollectService service) {
		this.service = service;
	}
}
