package com.deppon.dpm.module.announce.server.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("synAnnounceService")
public interface ISynAnnounceService {
	/**
	 * 新闻资讯同步接口
	 * 
	 * @date 2015/03/18 09:10:11
	 * @author 045925
	 * @param stn
	 * @return 
	 */
	// 请求类型
	@POST
	// 请求地址
	@Path("synAnnounceRequest")
	// 接受参数类型 
	@Consumes(MediaType.APPLICATION_JSON)
	// 返回参数类型
	@Produces(MediaType.APPLICATION_JSON)
	// 数据同步
	public Response synAnnounceRequest(String announeJson) throws IOException;
}
