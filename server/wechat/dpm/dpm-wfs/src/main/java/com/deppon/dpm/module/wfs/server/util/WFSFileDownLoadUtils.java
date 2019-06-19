package com.deppon.dpm.module.wfs.server.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 
 * @author 251624
 *
 */
public class WFSFileDownLoadUtils {
    //根路径
    private static final String rootPath = "/opt/workflowFiles";
    private static final String separator = "/";
    /**日志*/
    private static Logger logger = LoggerFactory.getLogger(WFSFileDownLoadUtils.class);
    
    /**
     * 工作流附件下载方法
     * 2016-3-16
     * @param sysCode
     * @param filePath
     * @param fileName
     * @param fileType
     * @param response
     */
    public static void downLoadFile(String sysCode,String filePath, String fileName, String fileType, HttpServletResponse response){
       
        StringBuffer sb = new StringBuffer();
        sb.append(rootPath);
        sb.append(separator);
        sb.append(sysCode);
        if(!filePath.startsWith(separator)){
            sb.append(separator);
        }
        sb.append(filePath);
        if(!filePath.endsWith(separator)){
            sb.append(separator);
        }
//        sb.append(fileName);
        ServletOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            logger.info("download file path: " + sb.toString());
            File downloadFile = new File(sb.toString());
//            File downloadFile = new File("D:\\biwenbing\\5月工作汇报模板.docx");
            // 判断文件是否存在
            if (downloadFile.exists()) {
                // 设置下载类型
                response.setContentType(StringUtil.isEmpty(fileType) ? "application/octet-stream"
                        : fileType);

                // 文件长度
                Long length = downloadFile.length();
                response.setContentLength(length.intValue());

                // 设置下载文件名称
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));

                outputStream = response.getOutputStream();
                inputStream = new FileInputStream(downloadFile);
                int size = 0;
                byte[] buffer = new byte[4096];
                while ((size = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, size);
                }
                outputStream.flush();
                
                logger.info("文件下载成功！");
            }else{
                logger.info("文件不存在，下载失败！");
            }
        }catch(Exception ex){
            logger.info("文件下载失败！",ex);
        }finally{
            try {
                if(outputStream != null){
                    outputStream.close();
                }
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
