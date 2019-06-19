package com.deppon.dpm.module.wfs.server.service;

/**
 * dppm项目管理 Interface
 * 195406 高春玲
 **/
public interface IDppmWorkInfoService {
	/**
     * 获得项目结项工作流详情
     * 根据工作流号获得工作流详情
     * @param busino
     * @param empCode
     * @param empName
     */
	public String projClosingDetail(String busino, String empCode, String empName) ;
	/**
	 * 审批项目结项工作流
	 * @param entity 结项实体
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approvalProjClosing(String str,String empCode,String empName);
	/**
     * 根据业务编号获得项目落地详情
     * @param busino 
     * @param empCode
     * @param empName
     * @return
     */
    public String projFallGroundDetail(String busino,String empCode,String empName);
    /**
	 * 审批落地结项工作流
	 * @param entity 落地实体
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approvalProjFallGround(String str,String empCode,String empName);
	/**
	 * 项目新建查询
	 * @param workitemid 工作流号
	 * @param empCode  审批人工号
	 * @param empName
	 * @return
	 */
	public String queryProjectInfo(String workitemid,String empCode,String empName);
	/**
	 * 项目新增工作流审批
	 * @param str 审批记录
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approveProjInfo(String str,String empCode,String empName);
	/**
	 * 项目变更审核信息获得
	 * @param wfsid 工作流号
	 * @return
	 */
	public String queryChangeCheckInfo(String wfsid,String empCode,String empName);
	/**
	 * 项目变更审批工作流审批
	 * @param str 审批记录
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approveProjChange(String str,String empCode,String empName);
	
	/**
	 * 查询
	 * @param url
	 * @param param
	 * @return
	 */
	public String queryWf(String url, String param);
	
	/**
	 * 审批
	 * @param url
	 * @param param
	 * @return
	 */
	public String approveWf(String url, String param);
}
