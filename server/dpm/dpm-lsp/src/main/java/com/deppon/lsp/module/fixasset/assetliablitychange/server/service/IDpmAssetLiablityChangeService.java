package com.deppon.lsp.module.fixasset.assetliablitychange.server.service;

public interface IDpmAssetLiablityChangeService {

	/**
	 * 查询登录用户名下资产 
	 * @param userCode
	 * @return
	 */
	public String queryPersonAsset(String userCode);
	
	/**
	 * 查询变更后责任人
	 * @param userCode
	 * @return
	 */
	public String queryAssetliablity(String userCode);
	
	/**
	 * 提交单据生成工作流
	 * @param userCode
	 * @param liablitychangeheadinfo
	 */
	public String submitBill(String userCode,String billJson);
}
