package com.deppon.dpm.module.wfs.server.service;

import java.io.File;
import java.rmi.RemoteException;
import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.BandApproveEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowListEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;
import com.deppon.dpm.module.wfs.shared.vo.NwfsSearchVo;
import com.deppon.dpm.module.wfs.shared.vo.WeaverAttachments;
import com.deppon.dpm.module.wfs.shared.vo.WeaverWorkflowInfo;
/**
 * 工作流service层
 * @author 276344
 *
 */

public interface IWeaverWfsService {
	/**
	 * 根据workflowId 把工作流对应页面拼接实体 返回给前端
	 * @param requestInfoArray
	 * @return
	 */
	public List<WorkflowListEntity> dealData(weaver.workflow.webservices.WorkflowRequestInfo[] requestInfoArray, List<WorkflowPageInfo> pageInfoArray);
	/**
	 * 附件解密+转PDF
	 * @param userId
	 * @param deviceType
	 * @param filename
	 * @param file
	 */
	public void decryptFile(String userId,String deviceType,String filename,File file);
	/**
	 * 附件接口给前端返回实体参数拼接处理
	 * @param docInfo
	 * @return
	 */
	public WeaverAttachments valueToEntity(weaver.docs.webservices.DocInfo docInfo);
	/**
	 * 待办工作流
	 */
	public List<WorkflowListEntity> workflowList(String userId, String status, String pageNo) throws RemoteException;
	/**
	 * 工作流详情
	 */
	public weaver.workflow.webservices.WorkflowRequestInfo workflowInfo(String userId, int requestId) throws RemoteException;
	/**
	 * 工作流提交接口
	 */
	public String workflowSubmit(String userId, WeaverWorkflowInfo entity) throws RemoteException;
	/**
	 * 已办理流程列表
	 * @param userId
	 * @return
	 * 没有分页功能
	 */
	public List<WorkflowListEntity> getHendledWorkflowList(String userId,String pageNo,String workflowStatus);
	/**
	 * 已办理流程列表
	 * @param userId
	 * @return
	 * 包含分页功能
	 */
	public List<WorkflowListEntity> getHendledWorkflowPageList(String userId,String pageNo,String workflowStatus);
	/**
	 *  我的已办流程列表：getMyWorkflowRequestList  自己起草的审批完成的（没批的）
	 *  没有分页功能
	 */
	public List<WorkflowListEntity> myWorkflowList(String userId, String status, String pageNo) throws RemoteException;
	/**
	 *  我的已办流程列表：getMyWorkflowRequestList  自己起草的审批完成的（没批的）
	 *  包含分页功能
	 */
	public List<WorkflowListEntity> myWorkflowPageList(String userId, String status, String pageNo) throws RemoteException;
	/**
	 * 工作流不同意接口
	 * @param userId
	 * @param requestId
	 * @return
	 */
	public String workflowtUnagree(String userId, int requestId, String workflowName, String sysCode, String version) throws RemoteException;
	/**
	 * 工作流查询接口
	 * @param userId 工号
	 * @param pageNo 当前页
	 * @param startTime 查询开始时间
	 * @param endTime 查询结束时间
	 * @param sysCode 系统编码
	 * @return
	 * @throws RemoteException
	 */
	public List<WorkflowListEntity> workflowSearch(String userId, NwfsSearchVo entity) throws RemoteException;
	
	/**
	 * 搜索框搜索
	 * @param text 用户输入内容
	 * @param userId 工号
	 * @return
	 * @throws RemoteException
	 */
	public List<WorkflowListEntity> textSearch(String text, String userId) throws RemoteException;
	
	/**
	 * 删除工作流接口
	 * @param userId
	 * @param requestId
	 * @return
	 * @throws RemoteException
	 */
	public boolean workflowDelete(String userId, int requestId) throws RemoteException;
	/**
	 * 撤回工作流接口
	 * @param requestId
	 * @param userId
	 * @return
	 * @throws RemoteException
	 */
	public boolean workflowRevoke(int requestId, String userId) throws RemoteException;
	/**
	 * 获取工作流详情页的头像地址
	 * @param workflow
	 * @return
	 */ 
    public WorkflowListEntity getInfoHeadpictures(WorkflowListEntity workflow);
	/**
	 * 获取工作流列表对应头像地址
	 * @param listData
	 * @return
	 */
	public List<WorkflowListEntity> getListHeadpictures(List<WorkflowListEntity> listData);
	/**
	 * 添加工作流接口异常监控
	 * @param wmEntity
	 * @return
	 */
	public int insertMonitor(WorkflowMonitorEntity wmEntity);
	/**
	 * 添加新工作流审批接口监控
	 * @param wmEntity
	 * @return
	 */
	public int insertApprovalMonitor(WorkflowMonitorEntity wmEntity);
	//List<WorkflowListEntity> dealData(WorkflowRequestInfo[] requestInfoArray,
	//List<WorkflowPageInfo> pageInfoArray, String userId);
	/**
	 * 新增一条工作流
	 * @param workflowId
	 * @param workflowName
	 * @param workflowPage
	 * @return
	 */
	public int insertNWorkflow(String workflowId,String workflowName,String workflowPage);
	/**
	 * 更改一条工作流状态
	 * @param workflowId
	 * @param workflowStatus
	 * @return
	 */
	public int updateNWorkflowStatus(String workflowId,String workflowStatus);
	/**
	 * 通知中心首页-审批通知
	 * @param userId
	 * @param pageNo
	 * @return
	 */
	public List<Object> workflowNotice(String userId, String pageNo);
	/**
	 * 通知中心-审批通知列表
	 * @param userId
	 * @param pageNo
	 * @return
	 */
	public List<Object> workflowNoticeList(String userId, String pageNo);
	
	/**
	 * 查询B10表信息
	 * @return
	 */
	public List<BandApproveEntity> queryBandApproveEntity();
	
	/**
	 * 根据工作流号查等级
	 * @param userId
	 * @return
	 */
	public String getJoblevelByworkFlowId(String workflowId);
	
}
