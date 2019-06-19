package com.deppon.dpm.tongxunlu.server.action;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.ThreadCallBack;
import com.deppon.dpm.module.common.server.util.UploadUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.server.util.Constants;

/**
 * 个人头像action
 * @author 231586
 *
 */
public class PersonlyPicAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	// log
	private static final Logger logger = Logger.getLogger(PersonlyPicAction.class);
	// fileName
	private String fileFileName;
	// reflection to the jsp's file tag
	private File file;
	// set injection
	private IPersonlyImageService personlyImageService;
	// lsp 地址
	private String lsysyncheadphoto;
	private String imagePic;
	/**
	 * 头像上传
	 */
	public void upload() {
		// 定义返回实体
		Result<String> result = new Result<String>();
		try {
//			 判断是否为空
			if (null == file || null == fileFileName) {
				// errorMessage
				result.setErrorMessage("请选择上传文件");
				// count
				result.setCount(Constants.ACTION_RESULT_ERROR);
				// 返回提示
				result.setData("");
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// 返回前端数据信息
				writeToPage(result);
				// 跳出
				return;
			}
			// 工具类是File[],这边做个简单的转换
			File[] files = { file };
			// 工具类是String[],这边做个简单的转换
			String[] fileNames = { fileFileName };
			//校验上传图片格式：".bmg",".jpg",".jpeg",".gif",".png"
			if(!UploadUtil.validateImage(files, fileNames)){
				// errorMessage
				result.setErrorMessage("上传文件格式不符，请重新选择正确格式（.bmg,.jpg,.jpeg,.gif,.png）的文件");
				// count
				result.setCount(Constants.ACTION_RESULT_ERROR);
				// 返回提示
				result.setData("");
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// 返回前端数据信息
				writeToPage(result);
				// 跳出
				return;
			}
			// 头像上传
			personlyImageService.uploadImage(files, userId, fileNames);
		} catch (IOException e) {
			// 出错信息
			result.setErrorMessage("上传出现错误，请稍后重试");
			// 返回提示
			result.setData("");
			// count
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 返回前端数据信息
			writeToPage(result);
			// 跳出
			return;
		}
		// 上传信息
		result.setErrorMessage("上传成功");
		// count
		result.setCount(Constants.SUCCESS);
		try {
			String imgpath = personlyImageService.downloadImage(userId);
			// 返回地址信息
			result.setData(imgpath);
			//2017.4.7 后勤同步头像信息 
			imagePic = imgpath.substring(imgpath.lastIndexOf("/") + 1);
//			logger.info("-------lsp "+ lsysyncheadphoto);
			if(imagePic != null && !"".equals(imagePic)) {
				Thread saveThread = new Thread() {
					@Override
					public void run() {
						try {
//							logger.info("-------lsp--- "+ "{\"empCode\":\"" + userId + "\",\"picUrl\":\"" + imagePic + "\"}");
							String lspresult = HttpUtil.doPostJson(lsysyncheadphoto, "{\"empCode\":\"" + userId + "\",\"picUrl\":\"" + imagePic + "\"}");
							logger.info("同步头像信息与LSP，工号：" + userId + "--" + lspresult);
						} catch (Exception e) {
							logger.error("同步头像信息与LSP出错，工号：" + userId + "---",e);
						}
					}
				};
				ThreadCallBack.run(saveThread);
			}
		} catch (FileNotFoundException e) {
			// 打印
			logger.error("头像上传出错：", e);
		}
		// errorCode
		result.setErrorCode(Constants.SUCCESS);
		// 返回前端数据
		writeToPage(result);
	}

	// set
	public void setPersonlyImageService(
			IPersonlyImageService personlyImageService) {
		this.personlyImageService = personlyImageService;
	}

	// get
	public String getFileFileName() {
		return fileFileName;
	}

	// set
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	// get
	public File getFile() {
		return file;
	}

	// set
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @param lsysyncheadphoto the lsysyncheadphoto to set
	 */
	public void setLsysyncheadphoto(String lsysyncheadphoto) {
		this.lsysyncheadphoto = lsysyncheadphoto;
	}

}
