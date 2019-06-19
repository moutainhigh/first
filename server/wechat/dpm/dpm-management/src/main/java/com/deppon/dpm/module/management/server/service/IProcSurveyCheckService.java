package com.deppon.dpm.module.management.server.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deppon.dpm.module.management.shared.domain.ProcSurveyCheck;

/**
 * 工程勘测PC端推送APP接口
 * 
 * @author 293888
 * 
 */
@Path("procSurveyCheckClass")
public interface IProcSurveyCheckService {

	/**
	 * 与PC端数据同步接口
	 * 
	 * @param json
	 */
	@POST
	@Path("surveyCheck")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveprocSurvey(String json);

	/**
	 * 根据工号查出对应的信息 
	 * @param userNo
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public List<ProcSurveyCheck> getProjectList(String userNo, String keyWord) throws Exception;
}
