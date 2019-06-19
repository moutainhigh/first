package com.deppon.lsp.module.materialexception.materialexceptionapply.server.service;

/**
 * 对接LSP物资异常Service
 * @author 275050
 *
 */
public interface IDPMMaterialExceptionService {
	/**
	 * 物资反馈--物料查询
	 * @author 275050
	 * @param materialName
	 * @param pageNo
	 * @return
	 */
	public String appQueryMaterial(String parameterJson);
	
	/**
	 * 物资反馈--提交方法
	 * @author 275050
	 * @param parameterJson
	 * @return
	 */
	public String appSubmit(String parameterJson);
	
	/**
	 * DPM物资反馈--查询物资异常历史记录
	 * @author 275050
	 * @param parameterJson
	 * @return
	 */
	public String appQueryMaterialExceptionHistory(String parameterJson);
}
