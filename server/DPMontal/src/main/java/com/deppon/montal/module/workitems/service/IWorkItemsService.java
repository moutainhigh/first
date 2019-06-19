
    package com.deppon.montal.module.workitems.service; 

import java.util.List;
import java.util.Map;

import com.deppon.montal.model.OaApprovalInfo;
import com.deppon.montal.model.OaNomalClaim;
import com.deppon.montal.model.OaContractApply;
import com.deppon.montal.model.OaDecoprogramApply;
import com.deppon.montal.model.OaFilePublish;
import com.deppon.montal.model.OaResignApply;
import com.deppon.montal.model.OaWorkItem;
   /** 
 * @Title: IWorkItemsService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-2-22 下午2:19:25 
 * @version V1.0 
 */
public interface IWorkItemsService {
    /** 
     * @Title: queryWorkItem 
     * @Description:(查询工作流) 
     * @returnList<OaWfWorkItem> 返回类型 
     * @throws 
     * @date 2013-2-21 下午4:31:34 
     */
  public List<OaWorkItem> queryWorkItem(String userid,String syscodes);
  
  /**
   *  查询代办列表(分页查询)
   */
  public List<OaWorkItem> queryWorkItem(String userid,String key,int pageNum,int pageSize,String syscodes);
  
  
  /**
   * 查询审批处理记录
   * @param processinstid
   * @return
   */
  public List<OaApprovalInfo> queryApprovalInfoList(String processinstid);
  
  /**
   * 装修工程申请详细信息获取
   * @param processinstid
   * @return
   */
  public OaDecoprogramApply getDecoprogramApplyById(String processinstid);
 
  
  /**
   * 获取增补员申请详细
   * @param processinstid
   * @return
   */
  public Map getPersonAddInfo(String processinstid);
  
   /** 
   * @Title: getLeaveWorkFlowApplyById 
   * @Description:(获取请假/调休工作流详细信息) 
   * @param @param processinstid
   * @return OaLeaveApply 返回类型 
   * @throws 
   * @date 2013-2-26 上午9:40:30 
   */
  public Map getLeaveWorkFlowApplyById(String processinstid);
  
  /**
   * 获取文件发布申请详细
   * @param processinstid
   * @return
   */
  public OaFilePublish getFilePublishInfo(String processinstid);
  
  /**
   * 获取签订合同申请详细(yin)
   * @param processinstid
   * @return 
   */
  public OaContractApply getContractSignInfo(String processinstid);  
  
   /** 
   * @Title: getResingWorkFlowApplyById 
   * @Description:(获取辞职申请详细信息) 
   * @param @param processinstid
   * @return OaResignApply 返回类型 
   * @throws 
   * @date 2013-2-27 上午10:09:06 
   */
  public OaResignApply getResingWorkFlowApplyById(String processinstid);
  
   /** 
   * @Title: getWfActivityInstInfo 
   * @Description:(获取工作流活动节点) 
   * @param @param processinstid
   * @return List<WfActivityInst> 返回类型 
   * @throws 
   * @date 2013-2-27 下午5:00:18 
   */
  public String getWfActivityInstInfo(long processinstid);

  /** 
   * @Title: getResingWorkFlowApplyById 
   * @Description:(获取常规理赔申请详细信息) 
   * @param @param processinstid
   * @return OaResignApply 返回类型 
   * @throws 
   * @date 2013-2-27 上午10:09:06 
   */
  public Map getClaimsWorkFlowApplyById(String processinstid);
  
  
   /** 
   * @Title: getActivityStartId 
   * @Description:(获取工作流返回节点) 
   * @param @param processinstid
   * @param @return 设定文件 
   * @returnString 返回类型 
   * @throws 
   * @date 2013-2-28 下午6:50:06 
   */
  public Map getActivityStartId(String processinstid);
}

