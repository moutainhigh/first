package com.deppon.wfs.workflow.service;

import java.util.List;

import com.deppon.wfs.workflow.domain.Fileupload;

public interface IFileuploadService {
	/**
	 * 
	* @MethodName: getAllFileupload 
	* @description : 根据流程号获取所有文件列表信息
	* @author：何玲菠 
	* @date： 2014-4-2 上午11:23:14
	* @param fileupload
	* @return List<Fileupload>
	 */
	List<Fileupload> getAllFileupload(Fileupload fileupload);
	
	/**
	 * 
	* @MethodName: getOneFileupload 
	* @description : 根据文件id获取单个文件信息
	* @author：何玲菠 
	* @date： 2014-4-2 上午11:23:29
	* @param fileupload
	* @return Fileupload
	 */
	Fileupload getOneFileupload(Fileupload fileupload);
}
