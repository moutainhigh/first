package com.deppon.dpm.module.common.server.action;

import java.io.File;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.DecryptNewFile;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.vo.Result;

public class DlpNewFileAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日志
	 */
	private static final Logger logger = Logger.getLogger(DlpNewFileAction.class);
   
	
	/**
	 * 工号
	 */
	private String userId;
	/**
	 * 原生类型（android,ios）
	 */
	private String deviceType;
	/**
	 * 文件名称
	 */
	private String filename;
	/**
	 * 解密的文件
	 */
	private File file;
	
	
	public void dlpFile(){
		
		logger.info("新的解密开始,文件开始解密,工号是:"+userId+"文件名"+filename);
		//结果集
		Result<Object> result = new Result<Object>();
		//校验工号
		if(ParamUtils.checkUserId(userId)){
			   result.setErrorCode(1);
			   // errorMessage
			   result.setErrorMessage("工号错误，不符合规范");
			   writeToPage(result);
			   return;
		 }
		
		 //判断是否为空
		if (null == file ) {
				// errorMessage
				result.setErrorMessage("请选择上传文件");
				// count
				//result.setCount(Constants.ACTION_RESULT_ERROR);
				// 返回提示
				result.setData("");
				// errorCode
				result.setErrorCode(1);
				// 返回前端数据信息
				writeToPage(result);
				// 跳出
				return;
			}
		
		//开始解密
		try {
			if(!file.exists()){
				// 附件不存在
				writeToPage("40006");
				return;
			}
			if("iphone".equals(deviceType)||"ios".equals(deviceType)){
			  filename=file.getName();
			}
			DecryptNewFile.delFile(userId, deviceType, filename, file);
			result.setErrorCode(0);
			result.setErrorMessage("Y");
			writeToPage(result);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("新的解密异常" , e);
			result.setErrorCode(1);
			result.setErrorMessage("N");
			writeToPage(result);
			return;
		}

	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	

}
