package com.deppon.dpm.tongxunlu.server.action;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.shared.vo.PortraitRequest;
import com.deppon.dpm.tongxunlu.shared.vo.PortraitResponse;

@Path("/headPhoto")
public class HeadPhotoAction {
	// 日志
	private static final Logger LOG = LoggerFactory.getLogger(HeadPhotoAction.class);
	
	// 注入
	private IPersonlyImageService personlyImageService;
	
	/*******移动CRM调用的头像接口*********/
	@Path("queryByEmpCode")
	// 接收参数类型
	@Consumes(MediaType.APPLICATION_JSON)
	// 返回参数类型
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Object queryPortraitByEmpCode(PortraitRequest portraitRequest){
		long start = System.currentTimeMillis();
		PortraitResponse portraitResponse = new PortraitResponse();
		// 头像地址
		String detailPath = "";
		try {
			// 根据工号查询头像路径
			detailPath = personlyImageService.downloadImage(portraitRequest.getUserId());
			// 设置成功状态码
			portraitResponse.setErrorCode(0);
			// 响应
			portraitResponse.setResult(detailPath);
		} catch (Exception e) {
			if(null == portraitRequest) {
				portraitRequest = new PortraitRequest();
			}
			// 设置错误码
			portraitResponse.setErrorCode(1);
			// 设置错误消息
			portraitResponse.setErrorMsg("调用头像接口失败");
			// 日志
			LOG.error("移动CRM调用头像接口出错>>>>{userId:"+portraitRequest.getUserId()+"}",e);
		}
		long end = System.currentTimeMillis();
		LOG.info("["+ portraitRequest.getUserId() +"]移动CRM调用头像接口用时>>>>" + (end - start) + "ms");
		// 响应
		return resultToResponse(portraitResponse);
	}
	
	/**
	 * 封装数据返回给response
	 */
	private Response resultToResponse(PortraitResponse portraitResponse) {
		// 即如果返回
		return Response
				.ok()
				// json返回
				.entity(JSON.toJSONString(portraitResponse))
				// 头消息类型
				.header(HttpHeaders.CONTENT_TYPE,
						MediaType.APPLICATION_JSON + ";charset=UTF-8")
				// 跨域请求处理
				.header("Access-Control-Allow-Origin", "*").build();
	}
	
	// set
	public void setPersonlyImageService(
			IPersonlyImageService personlyImageService) {
		this.personlyImageService = personlyImageService;
	}
}
