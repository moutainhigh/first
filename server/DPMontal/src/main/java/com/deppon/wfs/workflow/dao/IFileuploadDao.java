package com.deppon.wfs.workflow.dao;

import java.util.List;

import com.deppon.wfs.workflow.domain.Fileupload;

public interface IFileuploadDao {
	/**
	 * 
	* @MethodName: getAllFileupload 
	* @description : 根据业务单据号获取所有的文件列表
	* @author：何玲菠 
	* @date： 2014-4-2 上午11:08:32
	* @param fileupload
	* @return List<Fileupload>
	 */
	List<Fileupload> getAllFileupload(Fileupload fileupload);
	/**
	 * 
	* @MethodName: getOneFileupload 
	* @description : 根据文件id获取指定文件信息
	* @author：何玲菠 
	* @date： 2014-4-2 上午11:08:47
	* @param fileupload
	* @return Fileupload
	 */
	Fileupload getOneFileupload(Fileupload fileupload);
}
