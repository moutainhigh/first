package com.deppon.dpm.dlpfile.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.dlpfile.server.service.IDlpService;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.deppon.util.PropertiesTools;

/**
 * DLP文件解密的Action控制类.
 * 
 * @author 130126
 * 
 */
public class DlpfileAction extends BaseAction {
	public static final String SAVELOG_URL = PropertiesTools
			.getConfigProperties("savebusinesslog");
	private IDlpService dlpfileService;

	// 下面的属性可以通过配置文件来配置，允许动态设置---典型的依赖注入---见这个action的配置文件。
	private String savePath;
	private File upload;
	private String filename;

	// private String uploadFileName;

	// public String getUploadFileName() {
	// return uploadFileName;
	// }
	//
	// public void setUploadFileName(String uploadFileName) {
	// this.uploadFileName = uploadFileName;
	// }

	public int getFileSizes(File f) throws Exception {// 取得文件大小
		int s = 0;
		if (f.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s = fis.available();
		} else {
			f.createNewFile();
			System.out.println("文件不存在");
		}
		return s;
	}

	public IDlpService getDlpfileService() {
		return dlpfileService;
	}

	public void setDlpfileService(IDlpService dlpfileService) {
		this.dlpfileService = dlpfileService;
	}

	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * 解密文件流
	 * 
	 * @return
	 */
	public String decryptFile() {
		ServletOutputStream out = null;
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 最大缓存
			factory.setSizeThreshold(5 * 1024);
			// 设置临时文件目录
			factory.setRepository(new File(getSavePath()));
			ServletFileUpload uu = new ServletFileUpload(factory);
			// 文件最大上限
			uu.setSizeMax(2 * 1024 * 1024);
			FileInputStream fis = new FileInputStream(getUpload());

			Random ran = new Random();
			// 文件后缀名.
			String ext = "";
			if (filename != null && !"".equals(filename.trim()))
				ext = filename.substring(filename.lastIndexOf("."))
						.toLowerCase();
			// 随机文件名，防多线程解同一文件名，需求对文件名不敏感
			String fileName = String.valueOf(ran.nextInt(Integer.MAX_VALUE));
			File file = dlpfileService.decryptFile(fis, fileName, ext);

			if (!file.exists()) {
				out.write(IDlpService.ERROR.getBytes());
				return null;
			}
			FileInputStream fiss = new FileInputStream(file);
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ fileName);

			out = response.getOutputStream();

			byte[] buff = new byte[1024];
			for (int i = 0; (i = fiss.read(buff)) > 0;) {
				out.write(buff, 0, i);
			}
			out.flush();
			fiss.close();
			// 文件删除
			file.delete();
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			Result res = new Result();
			res.setErrorCode(Constants.SERVICE_ERROR);
			res.setErrorMessage("文件解析出现异常");
			writeToPage(response, res);
		}
		return null;
	}
}
