package com.deppon.dpm.module.wfs.server.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.wfs.server.util.WFSFileDownLoadUtils;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 工作流文件下载Action
 * @author 251624
 *
 */
public class FileDownLoadAction extends BaseAction {

    /**
     * 251624
     * @2016-3-15
     */
    private static final long serialVersionUID = 1L;
    /**
     * Log
     */
    private static Logger logger = LoggerFactory.getLogger(FileDownLoadAction.class);
    
    /**
     * 附件参数
     */
    //工号
   	private String userId;
    //返回的 文件路径url
    private String filePath;
    //文件名称
    private String fileName;
    private String fileType;
    //系统类型
    private String syscode;
    //android ios
   	private String ui_type;
   	
    
    /**
	 * 所有老工作流下载附件接口
	 * http://10.224.195.67:8882/dpm/downloadFiles?syscode=FSSC&
	 * controller=1&
	 * userinfo=undefined&
	 * ui_type=ios&
	 * filePath=/attachment/2019/1/3/30072CAE69.txt&
	 * fileName=测试.txt
	 */
	public void attachmentInfo() {
		//解决H5跨域
		solveCrossDomain();
		HttpServletResponse response = ServletActionContext.getResponse();
        //前端点一件附件时 触发 一次请求，如果列表包含很多附件 用户点哪个附件下载哪个附件
		logger.info("old workflow download file param is :userId=" + userId + "ui_type=" + ui_type + " fileURL=" + filePath + " fileName=" + fileName + " syscode=" + syscode);
        if(StringUtil.isEmpty(filePath) || StringUtil.isEmpty(fileName) || StringUtil.isEmpty(ui_type)){
            logger.info("文件路径和文件名称为空,附件下载失败！");
        }else{
            try {
            	WFSFileDownLoadUtils.dealAttachments(userId, syscode, filePath, fileName, ui_type, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
    /**
     * 工作流附件下载
     * 2016-3-16
     */
    public void downloadFiles(){
        logger.info("download workflow file param is : filePath=" + filePath + " fileName=" + fileName + " syscode=" + syscode);
        if(StringUtil.isEmpty(filePath) || StringUtil.isEmpty(fileName) || StringUtil.isEmpty(syscode)){
            logger.info("文件路径和文件名称为空,附件下载失败！");
        }else{
            HttpServletResponse response = ServletActionContext.getResponse();
            WFSFileDownLoadUtils.downLoadFile(syscode,filePath, fileName, fileType, response);
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
     * filePath
     * 2016-3-15
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * fileName
     * 2016-3-15
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * fileType
     * 2016-3-15
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * syscode
     * 2016-3-16
     * @param syscode
     */
    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

	/**
     * ui_type
     * 2019-1-05
     * @param syscode
     */
	public void setUi_type(String ui_type) {
		this.ui_type = ui_type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    

}
