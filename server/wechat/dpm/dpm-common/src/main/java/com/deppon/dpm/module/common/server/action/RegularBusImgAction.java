package com.deppon.dpm.module.common.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.IRegularBusImgService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.RegularBusImgEntity;
import com.opensymphony.xwork2.ModelDriven;

public class RegularBusImgAction extends BaseAction implements ModelDriven<RegularBusImgEntity>{

	private static final Logger LOG = LoggerFactory.getLogger(RegularBusImgAction.class);
	
	private RegularBusImgEntity entity = new RegularBusImgEntity();
	
	private File file;
	
	private String fileFileName;
	
	private String regularBusImgBaseUrl;
	
	private IRegularBusImgService regularBusImgService;
	
	/**
	 * getModel
	 */
	@Override
	public RegularBusImgEntity getModel() {
		return entity;
	}
	
	/**
	 * 列表查询
	 */
	public void list() {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<RegularBusImgEntity> list =  regularBusImgService.pageQuery(entity);
			Long count = regularBusImgService.queryTotalCount();
			result.put("total", count);
			result.put("rows", list);
		} catch (Exception e) {
			LOG.error("班车图片列表查询出错!!!",e);
		}
		writeToPage(result);
	}
	
	/**
	 * 查询上下班图片信息
	 */
	public void queryBusImgs() {
		List<RegularBusImgEntity> list = null;
		try {
			list =  regularBusImgService.queryBusImgs();
		} catch (Exception e) {
			LOG.error("查询上下班图片信息出错!!!",e);
		}
		writeToPage(list);
	}
	
	/**
	 * 上传图片
	 */
	public void uploadImg() {
		// 健壮判断
		if(null == file){
			writeToPage(false);
			return;
		}
		// 将文件写到本地
		File baseFile = new File(regularBusImgBaseUrl);
		// 路径不存在，则创建
		if(!baseFile.exists()) {
			baseFile.mkdirs();
		}
		FileOutputStream fos = null;
		FileInputStream fis = null;
		int i = 0;
		try {
			// 两个流
			fos = new FileOutputStream(new File(baseFile,fileFileName));
			fis = new FileInputStream(file);
			byte[] buf = new byte[MagicNumber.NUM1024];
			int len = 0;
			// 循环写入文件
			while((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			fos.flush();
			
			// 封装实体
			// 全类名
			entity.setImgUrl(regularBusImgBaseUrl + "/" + fileFileName);
			entity.setCreateTime(new Date());
			entity.setUpdateTime(entity.getCreateTime());
			// 保存上传信息
			regularBusImgService.save(entity);
			i++;
			writeToPage("success");
		} catch (Exception e) {
			LOG.error("班车图片上传失败!!!",e);
		} finally {
			// 释放资源
			if(null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					LOG.error("RegularBusImgAction.uploadImg关闭输出流异常!!!",e);
				}
			}
			
			if(null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					LOG.error("RegularBusImgAction.uploadImg关闭输入流异常!!!",e);
				}
			}
			
			if(i == 0) {
				try {
					// 删除上传的图片
					File uploaded = new File(entity.getImgUrl());
					if(uploaded.exists()) {
						uploaded.delete();
					}
				} catch (Exception e1) {
					LOG.error("班车图片文件删除出错!!!",e1);
				}
			}
		}
	}
	
	/**
	 * 删除图片和数据
	 */
	public void delete() {
		try {
			// 删除数据
			regularBusImgService.delete(entity);
			writeToPage("success");
		} catch (Exception e) {
			LOG.error("班车图片删除出错!!! params{id="+entity.getId()+",imgUrl="+entity.getImgUrl()+"}",e);
		}
	}
	
	
	// getter
	public File getFile() {
		return file;
	}

	// setter
	public void setFile(File file) {
		this.file = file;
	}

	// getter
	public String getFileFileName() {
		return fileFileName;
	}
	
	// setter
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	// setter
	public void setRegularBusImgService(IRegularBusImgService regularBusImgService) {
		this.regularBusImgService = regularBusImgService;
	}

	// setter
	public void setRegularBusImgBaseUrl(String regularBusImgBaseUrl) {
		this.regularBusImgBaseUrl = regularBusImgBaseUrl;
	}

}
