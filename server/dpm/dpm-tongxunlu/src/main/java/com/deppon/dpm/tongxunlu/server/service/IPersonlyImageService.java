package com.deppon.dpm.tongxunlu.server.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;

import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.foss.framework.service.IService;

/**
 * 个人头像设置service
 * 
 * @author 231586
 * 
 */
public interface IPersonlyImageService extends IService {
	/**
	 * 修改
	 * 
	 * @param empCode
	 * @param is
	 * @return
	 */
	public int updateImage(EmpExtensionEntity emtity);

	/**
	 * 上传
	 * 
	 * @param emtity
	 * @param is
	 * @throws IOException
	 */
	public int uploadImage(File[] file, String opeCode, String[] fileNames)
			throws IOException;

	/**
	 * 下载
	 * 
	 * @param empCode
	 * @return
	 * @throws FileNotFoundException
	 */
	public String downloadImage(String empCode) throws FileNotFoundException;

	/**
	 * 删除文件
	 * 
	 * @param empCode
	 * @throws IOException
	 */
	public void deleteFile(String empCode) throws IOException;
}
