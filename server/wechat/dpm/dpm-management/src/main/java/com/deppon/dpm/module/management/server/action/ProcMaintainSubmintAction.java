package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IProcMainService;
import com.deppon.dpm.module.management.shared.domain.DepartAPPEntity;
import com.deppon.dpm.module.management.shared.domain.DepartEntity;
import com.deppon.dpm.module.management.shared.domain.DeptRepairEntity;
import com.deppon.dpm.module.management.shared.domain.ProNameEntity;
import com.deppon.dpm.module.management.shared.vo.ResultVO;

/**
 * 
 * @author 王亚男
 *	工程维修提交Action
 */
public class ProcMaintainSubmintAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6457505737595547678L;
	Logger logger = LoggerFactory.getLogger(ProcMaintainSubmintAction.class);
	
	private IProcMainService repairService;
	
	/*public void submitInfo(){
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		
		ResultVO<Object> resultVo = new ResultVO<Object>();
		
		try{
			String userNo = getUserId();
			userNo = "046707";
			if(StringUtils.isNotBlank(userNo)){
				resultVo = this.repairService.postMessage(userNo);
			}else{
				resultVo.setResultFlag(false);
				resultVo.setMessage("没有获取参数");
				logger.info("submitInfo 提交 按钮点击后 没有获取参数 userNo");
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("出现异常");
			resultVo.setResultFlag(false);
			resultVo.setMessage("异常信息");
		}
		writeToPage(response,JsonUtil.beanToJsonString(resultVo));
	}*/
	
	/**
	 * 获取项目编码列表
	 */
	public void getDeptList(){
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		String str = "";
		ResultVO<DepartAPPEntity> result = new ResultVO<DepartAPPEntity>();
		try{
			bu = ServletActionContext.getRequest().getReader();
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			logger.info("APP获取项目信息的参数是:"+str+";(-->ProcMaintainSubmintAction.getDeptList)");
			if(StringUtils.isNotBlank(str)){
				JSONObject json = JSON.parseObject(str);
				String proName = json.getString("proName");
				if(StringUtils.isNotBlank(proName)){
					DeptRepairEntity entity = this.repairService.getDeptMessageFromPC(proName);
					if(entity.getIsSuccess()==1){
						List<DepartEntity> list = (List<DepartEntity>)entity.getData();
						Map<String, DepartAPPEntity> mapProName = new HashMap<String, DepartAPPEntity>();
						List<DepartAPPEntity> dataList = new ArrayList<DepartAPPEntity>();
						for(DepartEntity en : list){
							String key = en.getProName();
							if(mapProName.containsKey(key)){
								mapProName.get(key).getProCodeList().add(en.getProCode());
							}else{
								DepartAPPEntity appEntity = new DepartAPPEntity();
								appEntity.setDepartment(en.getDepartment());
								appEntity.setProName(key);
								appEntity.getProCodeList().add(en.getProCode());
								mapProName.put(key, appEntity);
								dataList.add(appEntity);
							}
						}
						result.setData(dataList);
						result.setCount(dataList.size());
					}else{
						result.setMessage("PC端数据出错");
					}
				}else{
					result.setMessage("未收到对应参数");
				}
			}else{
				result.setMessage("参数为空!");
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("getDeptList---has error");
		}
		writeToPage(response,JsonUtil.beanToJsonString(result));
	}
	
	/**
	 * 获取所属工程部列表
	 */
	public void getProList(){
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		ResultVO<ProNameEntity> resultVo = new ResultVO<ProNameEntity>();
		try{
			resultVo = this.repairService.getProList();
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("出现异常");
			resultVo.setResultFlag(false);
			resultVo.setMessage("异常信息");
		}
		writeToPage(response,JsonUtil.beanToJsonString(resultVo));
	}
	

	public IProcMainService getRepairService() {
		return repairService;
	}

	public void setRepairService(IProcMainService repairService) {
		this.repairService = repairService;
	}
}
