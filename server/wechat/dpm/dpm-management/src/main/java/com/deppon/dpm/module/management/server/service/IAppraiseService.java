package com.deppon.dpm.module.management.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deppon.dpm.module.management.shared.domain.AppraiseEntity;

@Path("appraiseService")
public interface IAppraiseService {
	/**
	 * 提交
	 * 	  手机调用此接口,向PC端提交评价信息
	 * @throws Exception
	 */
	public String appraiseCommit(AppraiseEntity requestParam) throws Exception;
	
	/**
	 * 待确认
	 * 		当IT上报流程状态在PC端变为待确认时，
	 * 		PC端通过Restful调用此接口向手机推送评价通知
	 */
	@POST
	@Path("confirm")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirm(String param);
	//注释
}
