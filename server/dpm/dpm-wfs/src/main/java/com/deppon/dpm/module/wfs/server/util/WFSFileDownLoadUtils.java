package com.deppon.dpm.module.wfs.server.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


/*import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;*/
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.DecryptNewFile;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.wfs.server.service.IWeaverWfsService;
import com.deppon.dpm.module.wfs.util.Constants;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 
 * @author 251624
 *
 */
public class WFSFileDownLoadUtils {
    //根路径
    private static final String rootPath = "/opt/workflowFiles";
    private static final String rootPaths = "/dpmfile/emailattachment";
    private static final String separator = "/";
//    private static final String appInterfaceUrl = "http://127.0.0.1:8080/AppInterface/center/decryptFile";
//    private static String enc = "UTF-8";

    // service层
 	private static IWeaverWfsService weaverService;
 	
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
                byte[] buffer = new byte[Constants.ARRAY_LENGTH];
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
    
    /**
	 * 根据url 下载 附件到 指定目录
	 * @param userId
	 * @param fileURL
	 * @param fileName
	 * @param syscode
	 * @param response
	 * @throws MalformedURLException
	 */
	public static void dealAttachments(String userId, String syscode, String filePath, String fileName, String ui_type, HttpServletResponse response) throws MalformedURLException {
		
		//http://192.168.67.41:8180/lsp/attachment/download.action?resource.id=LSP154656641950435D8163D04
		URL url = new URL(filePath);
		
        try {
        	//保存文件到本地路径   \dpmfile\emailattachment\人性的弱点.pdf
    		File file = new File(rootPaths + separator + syscode + separator + fileName);
    		URLConnection con = url.openConnection();
            //输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			OutputStream os = new FileOutputStream(file);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
			
            //调用解密 方法
			//weaverService.decryptFile(userId, ui_type, fileName, file);
			DecryptNewFile.delFile(userId, ui_type, fileName, file);
//			decrypt(userId, file, fileName, ui_type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

	public static IWeaverWfsService getWeaverService() {
		return weaverService;
	}

	public static void setWeaverService(IWeaverWfsService weaverService) {
		WFSFileDownLoadUtils.weaverService = weaverService;
	}
	
}
