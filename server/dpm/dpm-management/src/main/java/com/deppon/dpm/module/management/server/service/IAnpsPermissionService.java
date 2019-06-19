package com.deppon.dpm.module.management.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces("application/json")
@Consumes("application/json")
public interface IAnpsPermissionService {
	/**
	 * 是否有滴滴权限
	 */
	@POST
	@Path("/query")
   public Response isHaveAppPermission(String request);
}
