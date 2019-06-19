package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingCheckTypeEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingIndexEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingIsPassEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingOrgInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.FileUploadEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectClosingEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectFallGroundEntity;

/**
 * dppm项目管理 Interface
 * 195406 高春玲
 **/
public interface IDppmWorkInfoDao {
	/**
     * 获得项目结项工作流详情
     * 根据工作流号获得工作流详情
     * @param entity
	 * @return
     */
	public ProjectClosingEntity projClosingDetail(String busino) ;
	/**
	 * 附件列表
	 * @param busino
	 * @return
	 */
	public List<FileUploadEntity> fileList(String busino);
	/**
	 * 通过项目编号获取指标相关信息
	 * @param busino 业务单号
	 * @return
	 */
	public List<ClosingIndexEntity> closingIndexList(String busino);
	/**
	 * 获取验收类型
	 * @param busino 业务单号
	 * @return
	 */
	public List<ClosingCheckTypeEntity> closingCheckTypeList(String busino);
	/**
	 * 结项是否通过
	 * @param busino 业务单号
	 * @return
	 */
    public ClosingIsPassEntity closingIsPassInfo(String busino);
    /**
     * 验收组织信息
     * @param busino
     * @return
     */
    public ClosingOrgInfoEntity closingOrgInfoEntity(String busino);
    /**
     * 审批通过时 保存页面填写的组织信息
     * @param closingOrgInfoEntity
     */
    public void insertClosingOrgInfo(ClosingOrgInfoEntity entity) ;
    /**
     * 审批通过时 保存页面填写的指标信息
     * @param list
     */
    public void insertClosingIndex(List<ClosingIndexEntity> list) ;
    /**
     * 审批通过时，插入是否结项通过
     * @param e
     */
    public void insertChosingIsPass(ClosingIsPassEntity e)  ;
    /**
     * 将结项验收类型插入数据库
     * @param list
     */
    public void insertClosingCheckType(List<ClosingCheckTypeEntity> list)  ;
    /**
     * 更新状态
     * @param projectClosingEntity
     */
    public void updateProjectClosing(ProjectClosingEntity entity)  ;
    /**
     * 通过projectCode修改项目状态
     * @param proCode
     */
    public void updateProStatusByProCode(String proCode)  ;
    /**
     * 根据业务编号获得项目落地详情
     * @param busino
     * @return
     */
    public ProjectFallGroundEntity projFallGroundDetail(String busino);
    /**
     * 更新项目落地状态
     * @param projectClosingEntity
     */
    public void updateProjFallGround(ProjectFallGroundEntity entity)  ;
    /**
  	 * 项目新建查询
  	 * @param workitemid 工作流号
  	 */
    public Map<String, Object> queryProjectInfo(String workitemid);
    /**
     * 项目新建工作流审批
     * @param entity
     * @param empCode
     */
 	public void approveProjInfo(ProjectEntity entity,String empCode);
}
