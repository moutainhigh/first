package com.deppon.dpm.module.management.server.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deppon.dpm.module.management.shared.domain.ParcelEntity;

/**
 * 
 * @author 王亚男
 * 包裹录入接口(陈江浪)PC->APP
 */
@Path("put")
public interface ISendParcelService {
	
	/**
	 * 包裹录入接口(陈江浪)PC->APP
	 * @param json
	 * @return
	 */
	@POST
	@Path("sendParcelData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendParcelData(String json);
	
	/**
	 * @param userNo 用户工号
	 * @param pageSize 每页条数
	 * @param pageNum 页码
	 * @return
	 */
	public List<ParcelEntity> getParcelList(String userNo);
	
	/**
	 * 获取用户未签收总条数（包含代签）
	 * @param userNo 用户工号
	 * @return
	 */
	public int getPageCount(String userNo);
	
}
