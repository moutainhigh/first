package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IServePhotoService;
import com.deppon.dpm.module.management.shared.domain.ServeNoticeInfo;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 拼车吧上传广告图片action
 * 
 */
public class ServePhotoAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户工号
	 */
	private String userNo;
	/**
	 * servePhotoService 接口
	 */
	private IServePhotoService servePhotoService;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ServePhotoAction.class);

	/**
	 * 判断是否有权限上传图片
	 */
	public void getPermissions() {
		// 设置页面响应实体
		String res = "{\"resultFlag\":false,\"failureReason\":\"参数为null！\"}";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			// 判断传入放入工号是否为null
			if (!StringUtil.isEmpty(userNo)) {
				// 得到json
				res = this.servePhotoService.getPermissions(userNo);
			}

		} catch (Exception ce) {
			//捕获异常
			res = "{\"resultFlag\":false,\"failureReason\":\"出现异常！\"}";
			ce.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);

	}

	/**
	 * 添加照片
	 */
	public void insertPhoto() {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
        //跨域的判断
		if ("POST".equals(ServletActionContext.getRequest().getMethod())) {
			String res = "";
			BufferedReader bu = null;
			String str = "";
			try {
				bu = ServletActionContext.getRequest().getReader();
				// 得到页面传来的参数
				str = com.deppon.dpm.module.common.server.util.StringUtil
						.bufferString(bu);
				if (!StringUtil.isEmpty(str)) {
					//保存图片
					res = this.servePhotoService.insertPhoto(str);

				} else {
					res = "{\"resultFlag\":false,\"failureReason\":\"传入参数有误！\"}";
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//写入数据
			writeToPage(response, res);
		}

	}

	/**
	 * 得到照片
	 */
	public void getPhoto() {
		// 设置页面响应实体
		String res = "{\"resultFlag\":false,\"failureReason\":\"没有数据！\"}";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			//得到照片列表
			List<ServeNoticeInfo> infos = this.servePhotoService.listSer();
			//判断参数是否非空
			if (null != infos && infos.size() > 0) {
				res = JsonUtil.listToJsonString(infos);
			}

		} catch (Exception ce) {
			//捕获异常
			res = "{\"resultFlag\":false,\"failureReason\":\"出现异常！\"}";
			ce.printStackTrace();
		}
		//写入数据
		writeToPage(response, res);

	}
    //用户工号
	public String getUserNo() {
		return userNo;
	}
	  //用户工号
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public void setServePhotoService(IServePhotoService servePhotoService) {
		this.servePhotoService = servePhotoService;
	}
}
