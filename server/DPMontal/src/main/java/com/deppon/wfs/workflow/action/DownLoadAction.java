package com.deppon.wfs.workflow.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.conf.F_Constants;
import com.deppon.wfs.workflow.domain.Fileupload;
import com.deppon.wfs.workflow.service.FileuploadServiceImpl;
import com.deppon.wfs.workflow.service.IFileuploadService;

public class DownLoadAction extends AppDelegateAction{

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Fileupload fileupload = new Fileupload();
	private String enc = "UTF-8";
	private String syscode;
	private String path ;
	
	private Logger logger = Logger.getLogger(DownLoadAction.class);
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IFileuploadService fileuploadService = new FileuploadServiceImpl();
		syscode = (String) request.getAttribute("syscode");
		String fileId = (String)request.getAttribute("fileId");
		//波波写的方法仅测试工作流这边的附件
	//	String path = getServletContext().getRealPath(File.separator + "wfs" + File.separator + getRealPath(fileupload.getFilePath()));
		//当要下载的附件是属于工作流系统的时候，通过fileId去取path
		if( F_Constants.DWFS_WORKFLOW_SYSCODE.equals(syscode) && fileId != null) {
		    if(fileupload == null){
		        fileupload =  new Fileupload();
		    }
			fileupload.setFileId(fileId);
			fileupload = fileuploadService.getOneFileupload(fileupload);
			
			path = getServletContext().getRealPath(File.separator + syscode + File.separator + getRealPath(fileupload.getFilePath()));
		}
//		else if( F_Constants.WDGH_WORKFLOW_SYSCODE.equals(syscode)){
//			path = getServletContext().getRealPath(File.separator + syscode + File.separator + request.getAttribute("filePath")+"."+ request.getAttribute("fileType"));
//		}
		else {
		//当属于外部系统的时候则从页面上，从接口中取出的path取
		    path = getServletContext().getRealPath(File.separator + syscode + File.separator + request.getAttribute("filePath"));
		}
		File downloadFile = new File(path);
		logger.info("file path :" + path);
		if (downloadFile.exists()) {
//			downloadFile = new File("d:\\dpmontal.txt");
			logger.info("file exists");
			response.setContentType(fileupload.getFileType()==null?"application/octet-stream":fileupload.getFileType());
			Long length = downloadFile.length();
			response.setContentLength(length.intValue());
			if ( F_Constants.DWFS_WORKFLOW_SYSCODE.equals(syscode) && fileId != null) {
				response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileupload.getFileName(), enc));
			}else {
				response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode((String)request.getAttribute("fileName"), enc));
			}
			
//			response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("dpmontal.txt", enc));
			ServletOutputStream outputStream = response.getOutputStream();
			FileInputStream inputStream = new FileInputStream(downloadFile);
			int size = 0;
			byte[] buffer = new byte[4096];
			while ((size = inputStream.read(buffer)) != -1) {
				logger.info("write to output stream..");
				outputStream.write(buffer, 0, size);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();
		} else {
			logger.info("File is not exist");
		}
	}
	
	private String getRealPath(String path) {
		if(path.startsWith("\\")) {
			return path.startsWith("\\") ? path.substring(1) : path;
		}
		return path.startsWith("/") ? path.substring(1) : path;
	}
}
