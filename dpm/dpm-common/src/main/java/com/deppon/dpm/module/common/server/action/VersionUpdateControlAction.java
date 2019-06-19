package com.deppon.dpm.module.common.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.service.IVersionUpdateControlService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.VersionUpdateControlEntity;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 *系统版本更新控制Action
 */
public class VersionUpdateControlAction extends BaseAction implements ModelDriven<VersionUpdateControlEntity>{
	
	// 实体
	private VersionUpdateControlEntity versionUpdateControlEntity = new VersionUpdateControlEntity();
	
	// 上传的class文件
	private File file;
	
	// 文件名
	private String fileFileName;
	
	private String classFileBaseUrl;
	
	// service
	private IVersionUpdateControlService versionUpdateControlService;
	
	// 复写方法
	@Override
	public VersionUpdateControlEntity getModel() {
		return versionUpdateControlEntity;
	}
	
	// 列表
	public void list(){
		// 返回的结果
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", 0);
		result.put("rows", null);
		try {
			// 查询所有
			List<VersionUpdateControlEntity> list = versionUpdateControlService.list();
			result.put("total", list.size());
			result.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回
		writeToPage(result);
	}
	
	// 删除
	public void delete() {
		try {
			// 获取id
			String id = ServletActionContext.getRequest().getParameter("id");
			// 根据id删除
			versionUpdateControlService.deleteById(Integer.parseInt(id));
			// 返回
			writeToPage(true);
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		writeToPage(false);
	}
	
	// 上传文件
	public void uploadJavaFile(){
		// 健壮判断
		if(null == file){
			writeToPage(false);
			return;
		}
		// 将文件写到本地
		File baseFile = new File(classFileBaseUrl);
		// 路径不存在，则创建
		if(!baseFile.exists()) {
			baseFile.mkdirs();
		}
		FileOutputStream fos = null;
		FileInputStream fis = null;
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
			
			// 封装实体
			// 全类名
			versionUpdateControlEntity.setFileName(versionUpdateControlEntity.getPackageName() + "." + fileFileName.substring(0, fileFileName.lastIndexOf(".")));
			versionUpdateControlEntity.setFilePath(classFileBaseUrl + "/" + fileFileName);
			versionUpdateControlEntity.setLoadStatus("off");
			versionUpdateControlEntity.setCreateTime(new Date());
			versionUpdateControlEntity.setUpdateTime(versionUpdateControlEntity.getCreateTime());
			// 保存上传信息
			versionUpdateControlService.save(versionUpdateControlEntity);
			writeToPage("success");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if(null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	// 更新
	public void update() {
		try {
			// 更新
			versionUpdateControlService.update(versionUpdateControlEntity);
			// 返回
			writeToPage(true);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage(false);
	}

	
	// setter
	public void setVersionUpdateControlService(
			IVersionUpdateControlService versionUpdateControlService) {
		this.versionUpdateControlService = versionUpdateControlService;
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
	public void setClassFileBaseUrl(String classFileBaseUrl) {
		this.classFileBaseUrl = classFileBaseUrl;
	}

}
