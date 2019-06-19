package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.DecryptNewFile;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.wfs.server.service.ICrmWorkInfoService;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.server.util.HttpClientUtil;
import com.deppon.dpm.module.wfs.server.util.workflowStrUtil;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.domain.CrmAttachmentsEntity;
import com.deppon.dpm.module.wfs.shared.domain.crm.CrmApproveParam;
import com.deppon.dpm.module.wfs.shared.vo.CrmAttachmentsResultVO;
import com.deppon.dpm.module.wfs.shared.vo.QueryParamVo;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * crm 客户关系管理系统的工作流
 * 疑似重复客户处理工作流
 * @version
 */
public class CrmWorkInfoAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	private Logger logger  = LoggerFactory.getLogger(CrmWorkInfoAction.class);
	/**
	 * service
	 */
	private ICrmWorkInfoService crmWfsSrv;
	private IWeaverWfsService weaverService;
	private IMonitorService monitorService;
	
	// 工作流单据号
	private String busino;
	// 工作流单据号
	private String cbusino;
	// 工作流类型
	private String flowtype;
	// 错误信息 用于错误预警
	private String errorInfo;

	/**
 	 * 附件 参数
 	 */
 	//工作流号
 	private String workFlowId;
 	//工作流名称
 	private String workFlowName;
 	//附件名称
    private String attachmentsName;
    //工号
   	private String userId;
    //系统类型
    private String syscode;
    //附件路径【重复附件 唯一标示】
    private String savePath;
    //附件信息 CRM接口地址
  	private String attachmentUrl;
  	
  	/**
  	 * 远程 下载 crm附件
  	 */
	public void openCrmAttachmentInfo() {
		//解决H5跨域
		solveCrossDomain();
		JSONObject jsonObject = new JSONObject();
        //打印出参数
        logger.info("----crm query action param:" + this.workFlowId + "------" + this.workFlowName + "------" + this.savePath + "------" + this.attachmentsName + "------" + this.userId + "------" + this.syscode + "------" + this.attachmentUrl);
//        System.out.println("----crm query action param:" + this.workFlowId + "------" + this.workFlowName + "------" + this.savePath  + "------" + this.attachmentsName+ "------" + this.userId + "------" + this.syscode + "------" + this.attachmentUrl);
        //判断请求参数不为空
        if(StringUtils.isNotEmpty(workFlowId) || StringUtils.isNotEmpty(workFlowName) || StringUtils.isNotEmpty(attachmentsName) || StringUtils.isNotEmpty(userId) || StringUtils.isNotEmpty(syscode) || StringUtils.isNotEmpty(attachmentUrl)){
	        //请求参数实体
        	CrmAttachmentsEntity crmAttachmentsEntity = new CrmAttachmentsEntity(this.workFlowId, this.workFlowName, this.attachmentsName, this.savePath);
	        //转成json字符串
			String json = JSON.toJSONString(crmAttachmentsEntity,SerializerFeature.WriteNullStringAsEmpty);
			logger.info(json);
			
			try {
				//根据 地址 获取 crm系统 返回的 数据
				String requestJson = HttpClientUtil.httpPost(attachmentUrl,json);
				//得到返回参数实体
				CrmAttachmentsResultVO resultvo = JSON.parseObject(requestJson, CrmAttachmentsResultVO.class);
				//crm 返回的 附件 字符串 需要用Base64解码 【不是文件输入流】
				String stream = resultvo.getStream();
				//crm 返回的 错误码 0：正常 1：错误
				int errorCode = resultvo.getErrorCode();
				//crm 返回的 错误信息
				String errorMessage = resultvo.getErrorMessage();
				jsonObject.put("errorCode:", errorCode);
	        	jsonObject.put("errorMessage:", errorMessage);
	        	//判断返回错误信息  前端展示
				if(errorCode==0){
					//要保存的路径  测试环境 及 生产环境 要先在本地建一个文件夹，没有权限自动创建
		    		String path = "/dpmfile/emailattachment/";
					//保存文件到本地路径
		    		File file = new File(path + attachmentsName);
					//crm返回strem字符串  Base64解码
		    		byte[] bytes = Base64.decodeBase64(stream);
					FileUtils.writeByteArrayToFile(file, bytes);
					logger.info("件写入workflowFile完毕");
					if(!file.exists()){
						// 附件不存在
						logger.info("写入workflowFile之后判断有没有写成功 40006");
						writeToPage("40006");
						return;
					}
//					ServletOutputStream out = null;
//					InputStream in = null;
		    		//调用解密 方法
		            //weaverService.decryptFile(userId, syscode, attachmentsName, file);
					DecryptNewFile.delFile(userId,syscode, attachmentsName,file);
					
				}else{
					writeToPage(jsonObject);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else{
        	jsonObject.put("errorCode:", "1");
        	jsonObject.put("errorMessage:", "请求参数不能为空");
        	writeToPage(jsonObject);
        }
	}
	
	public void decryptFile(File file) {
		ServletOutputStream out = null;
		InputStream in = null;
		
		logger.info("附件解密开始>>>>");
		try {
			// 获取response的输出流
			out = ServletActionContext.getResponse().getOutputStream();
			
			byte[] buff = new byte[MagicNumber.NUM1024];
			int len = 0;			
				    // 获取响应数据
					in = new FileInputStream(file);
					// 将解密后的文件数据写出
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
			
		} catch (Exception e) {
			logger.error("附件解密失败>>>>", e);
			try {
				if(null != out){
					// 异常返回
					out.write("40007".getBytes());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 释放资源
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 释放资源
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
	
	
		
	/**
	 * 详情查看 根据审批流程中任一人的工号，姓名，工作流单据号 使用restful的方式进行接口调用
	 * 
	 * @author 195406 高春玲
	 * @date 2015-6-29 上午9:45:08
	 * @see
	 */
	@CookieNotCheckedRequired
	public void queryWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		String str = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			QueryParamVo query = null;
			str = StringUtil.bufferString(bu);
			//打印出参数
			logger.info("============crm query action param:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				query = JSONObject.parseObject(str,
						QueryParamVo.class);
				//给busino赋值
				busino = query.getBusino();
				query.setEmpName(java.net.URLDecoder.decode(query.getEmpName(), "utf-8"));
				//调用service
				String json = crmWfsSrv.queryWorkInfo(query);
				//打印返回的json
				logger.info("============crm query action return:" + json);
				json = workflowStrUtil.replaceJsonSpecialCharacter(json);
				//返回给页面
				writeToPage(response, json);
				if(json != null && !json.equals("")) {
					String s = JsonUtil.jsonGetValueBykey(json,"isSuccess");
					if(s != null && s.equals("Y")) {//查询成功
						issuccess = "1";
					}
				}
				errorInfo = json;
			}
		} catch (Exception e) {
			errorInfo = e.getMessage();
			e.printStackTrace();
		} finally {
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				if( flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.operate.multiReparation") 
						||  flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.claims.generalclaims") ){
					WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.cbusino, 
							issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
				else{
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "0", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
			}
		}
	}

	/**
	 * 工作流审批
	 */
	public void approveWorkInfo() {
		Date begindate = new Date();
		String issuccess = "0";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			CrmApproveParam audit = null;// 构建审批后勤需要的参数
			str = StringUtil.bufferString(bu);
			//打印出参数
			logger.info("============crm approve action param:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//给实体赋值
				audit = JSONObject.parseObject(str,
						CrmApproveParam.class);
//				audit.setDealEmpName(java.net.URLDecoder.decode(audit.getDealEmpName(), "utf-8"));
				busino = audit.getBusino();
				//调用service
				String json = crmWfsSrv.approveWorkInfo(audit);
				String s = JsonUtil.jsonGetValueBykey(json,"success");
				if(s != null && s.equals("true")) {//审批成功
					issuccess = "1";
				}
				logger.info("============crm approve action return:" + json);
				//返回给页面
				writeToPage(response, json);
				errorInfo = json;
			}
		} catch (Exception e) {
			//打印出报错信息
			e.printStackTrace();
			writeToPage(response, "0");
			errorInfo = e.getMessage();
		} finally {
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				if(flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.operate.multiReparation") 
						||  flowtype !=null && flowtype.equals("com.deppon.bpms.module.crm.bpsdesign.claims.generalclaims")){
					WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype, begindate, this.cbusino, 
							issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
				else{
				//保存数据监控
				WFSMonitorUtil.addMonitor(this.userId, "1", this.flowtype, begindate, this.busino, 
						issuccess, this.errorInfo, ServletActionContext.getRequest().getSession(), this.monitorService, null,str);
				}
			}
		}
	}

	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}
	
	/**
	 * @param crmWfsSrv the crmWfsSrv to set
	 */
	public void setCrmWfsSrv(ICrmWorkInfoService crmWfsSrv) {
		this.crmWfsSrv = crmWfsSrv;
	}

	/**
	 * @param monitorService the monitorService to set
	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}

	/**
	 * @param empName the empName to set
	 */
	/*public void setEmpName(String empName) {
		this.empName = empName;
	}*/

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}


	/**
	 * @param flowtype the flowtype to set
	 */
	public void setFlowtype(String flowtype) {
		this.flowtype = flowtype;
	}

	/**
	 * @param cbusino the cbusino to set
	 */
	public void setCbusino(String cbusino) {
		this.cbusino = cbusino;
	}

	public String getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getWorkFlowName() {
		return workFlowName;
	}

	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}

	public String getAttachmentsName() {
		return attachmentsName;
	}

	public void setAttachmentsName(String attachmentsName) {
		this.attachmentsName = attachmentsName;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public IWeaverWfsService getWeaverService() {
		return weaverService;
	}

	public void setWeaverService(IWeaverWfsService weaverService) {
		this.weaverService = weaverService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}

	public ICrmWorkInfoService getCrmWfsSrv() {
		return crmWfsSrv;
	}

	public IMonitorService getMonitorService() {
		return monitorService;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}