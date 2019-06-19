package com.deppon.dpm.module.wfs.server.action;

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
    
    //
    private String filePath;
    private String fileName;
    private String fileType;
    private String syscode;
    
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

}
