package com.deppon.dpm.module.wfs.server.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.module.wfs.server.dao.IMonitorDao;
import com.deppon.dpm.module.wfs.shared.domain.NWorkflowInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowLevelMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowMonitorEntity;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowNewMonitorEntity;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 工作流数据监控  对于工作流的查看和审批 记录日志  kpi数据保存
 * @author gcl
 */
public class MonitorDao extends iBatis3DaoImpl implements IMonitorDao {
	
	private JdbcTemplate template;

	// 命名空间
	private String NAMESPACE = "com.deppon.dpm.module.wfs.server.dao.workitems.";

	// 工作流在移动端审批次数
	private String WORKFLOW__MONITOR = "addWfsMonitor";

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
    /**
     * 保存数据监控日志
     */
	@Override
	public void addWfsMonitor(WfsMonitorVo vo) {
		//对于dpm 中记录的开始时间和结束时间进行转换 转化为字符串（毫秒） 
		//dpmontal 老工作流中时间为字符串 不进行转化
		if(vo.getBdateStr() == null || vo.getBdateStr().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			vo.setBdateStr(sdf.format(vo.getBegindate()));
			vo.setEdateStr(sdf.format(vo.getEnddate()));
		}
		//执行数据库插入
		getSqlSession().insert(NAMESPACE + WORKFLOW__MONITOR, vo);
	}
	
	/**
	 * 根据工号 查询所有监控表信息 集合对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkflowLevelMonitorEntity> queryBandApproveMonitor(String userId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(NAMESPACE + "queryBandApproveMonitor", userId);
	}

	/**
	 * 添加新工作流接口异常监控
	 * @param wmEntity
	 */
	public int insertMonitor(WorkflowMonitorEntity wmEntity){
		
		return getSqlSession().insert(NAMESPACE + "insertMonitor", wmEntity);
	}
	
	/**
	 * 添加老工作流审批接口监控--批准
	 */
	@Override
	public int insertApprovalEntityNewMonitor(WorkflowNewMonitorEntity wmEntity) {
		// TODO Auto-generated method stub
		return getSqlSession().insert(NAMESPACE + "insertApprovalNewMonitor", wmEntity);
	}
	
	/**
	 * 添加老工作流审批接口监控--批准
	 * @param wmEntity
	 * @throws Exception 
	 * 新加版本号字段
	 */
	public int insertApprovalNewMonitor(String userId,String joblevel, weaver.workflow.webservices.WorkflowRequestInfo requestInfo, String resultString, String data, String isAttachment) throws Exception{
		WorkflowNewMonitorEntity wmEntity = new WorkflowNewMonitorEntity();
        //拼装实体
		wmEntity.setUserId(userId);
		wmEntity.setJobLevel(joblevel);
		wmEntity.setWorkflowId(requestInfo.getWorkflowBaseInfo().getWorkflowId());
		wmEntity.setRequestId(requestInfo.getRequestId());
		//有的为空
		wmEntity.setWorkflowName(requestInfo.getWorkflowBaseInfo().getWorkflowName());
		//周围系统名称
		wmEntity.setSysCode(requestInfo.getWorkflowBaseInfo().getWorkflowTypeName());
		//old new 工作流
		wmEntity.setStatus(requestInfo.getRejectButtonName());
		wmEntity.setApprovalOption(requestInfo.getSubmitButtonName());
		wmEntity.setRemark(requestInfo.getMessageType());
		wmEntity.setData(data);
		wmEntity.setErrorInfo(requestInfo.getRemark());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date createTime = sdf.parse(requestInfo.getCreateTime());
		wmEntity.setCreateTime(createTime);
		wmEntity.setRejectNode("");
		wmEntity.setMethodTime(requestInfo.getReceiveTime());
		if(isAttachment.equals("1")){
			wmEntity.setFileDocId(requestInfo.getCurrentNodeId());
			wmEntity.setFileName(requestInfo.getCurrentNodeName());
			wmEntity.setFilePath(requestInfo.getLastOperatorName());
			wmEntity.setFileOpenCount(Integer.parseInt(requestInfo.getType()));
			wmEntity.setUi_type(requestInfo.getNodename());
		}else{
			wmEntity.setFileDocId("");
			wmEntity.setFileName("");
			wmEntity.setFilePath("");
			wmEntity.setFileOpenCount(0);
			wmEntity.setUi_type("");
		}
		if(requestInfo.getForwardButtonName() != null && !"".equals(requestInfo.getForwardButtonName())){
			//新加字段 版本号
			wmEntity.setRemark1(requestInfo.getForwardButtonName());
		}else{
			wmEntity.setRemark1("");
		}
		wmEntity.setRemark2("");
		wmEntity.setRemark3("");
		if(resultString != null){
			if(resultString.length() >= 50){
				wmEntity.setResult(resultString.substring(0, 50));
			}else{
				wmEntity.setResult(resultString);
			}
			if(resultString.equals("success")){
				wmEntity.setIsSuccess(1);
			}
		}
		wmEntity.setInterfaceName(requestInfo.getRequestName());
		return getSqlSession().insert(NAMESPACE + "insertApprovalNewMonitor", wmEntity);
	}
	
	/**
	 * 添加老工作流审批接口监控--批准
	 * @param wmEntity
	 */
	public int insertApprovalMonitorOld(String userId,String joblevel, weaver.workflow.webservices.WorkflowRequestInfo requestInfo, String resultString){
		WorkflowMonitorEntity wmEntity = new WorkflowMonitorEntity();
        //拼装实体
		wmEntity.setEmpCode(userId);
		wmEntity.setJobLevel(joblevel);
		//这个回退节点字段  暂存 返回给前端的结果数据
		wmEntity.setRejectNode(requestInfo.getRejectButtonName());
		wmEntity.setWorkflowId(Integer.valueOf(requestInfo.getWorkflowBaseInfo().getWorkflowId()));
		wmEntity.setWorkflowName(requestInfo.getWorkflowBaseInfo().getWorkflowName());
		wmEntity.setSysCode(requestInfo.getWorkflowBaseInfo().getWorkflowTypeName());
		if(requestInfo.getForwardButtonName() != null && !"".equals(requestInfo.getForwardButtonName())){
			//审批操作 暂时拼接 版本号（没有多余字段存）
			wmEntity.setApprovalOption(requestInfo.getSubmitButtonName() + ", version:" + requestInfo.getForwardButtonName());
		}else{
			wmEntity.setApprovalOption(requestInfo.getSubmitButtonName());
		}
		wmEntity.setErrorInfo(requestInfo.getMessageType());//错误信息
		if(resultString != null){
			if(resultString.length() >= 50){
				wmEntity.setResult(resultString.substring(0, 50));
			}else{
				wmEntity.setResult(resultString);
			}
			if(resultString.equals("success")){
				wmEntity.setIsSuccess(1);
			}
		}
		wmEntity.setInterfaceName("approveWorkflowRequest");
		return getSqlSession().insert(NAMESPACE + "insertApprovalMonitor", wmEntity);
	}
	
	/**
	 * 删除监控表未匹配到的数据 代办列表
	 */
	@Override
	public int deleteLevelMonitor(String workflowName) {
		// TODO Auto-generated method stub
		return getSqlSession().delete(NAMESPACE+"deleteLevelMonitor", workflowName);
	}
	
	/**
	 * 添加老工作流 level为10以上 审批接口监控--批准
	 * @param wmEntity
	 * 新加版本号 字段
	 */
	public int insertLevelMonitor(String userId,String joblevel, weaver.workflow.webservices.WorkflowRequestInfo requestInfo, String resultString){
		WorkflowLevelMonitorEntity wmEntity = new WorkflowLevelMonitorEntity();
        //拼装实体
		wmEntity.setUserId(userId);
		wmEntity.setJobLevel(joblevel);
		wmEntity.setWorkflowId(Integer.valueOf(requestInfo.getWorkflowBaseInfo().getWorkflowId()));
		wmEntity.setWorkflowName(requestInfo.getWorkflowBaseInfo().getWorkflowName());
		if(requestInfo.getForwardButtonName() != null && !"".equals(requestInfo.getForwardButtonName())){
			//审批操作 暂时拼接 版本号（没有多余字段存）
			wmEntity.setApprovalOption(requestInfo.getSubmitButtonName() + ", version:" + requestInfo.getForwardButtonName());
		}else{
			//审批操作
			wmEntity.setApprovalOption(requestInfo.getSubmitButtonName());
		}
		wmEntity.setErrorInfo(requestInfo.getMessageType());//错误信息
		if(resultString != null){
			wmEntity.setResult(resultString);
			if(resultString.equals("success")){
				wmEntity.setIsSuccess(1);
			}
		}
		return getSqlSession().insert(NAMESPACE + "insertLevelMonitor", wmEntity);
	}
	
	/**
	 * 添加新工作流审批接口监控--批准
	 * @param wmEntity
	 * 新加版本号 字段
	 */
	public int insertApprovalMonitor(String userId,String joblevel, weaver.workflow.webservices.WorkflowRequestInfo requestInfo, String resultString){
		WorkflowMonitorEntity wmEntity = new WorkflowMonitorEntity();
        //拼装实体
		wmEntity.setEmpCode(userId);
		wmEntity.setJobLevel(joblevel);
		wmEntity.setWorkflowId(Integer.valueOf(requestInfo.getWorkflowBaseInfo().getWorkflowId()));
		wmEntity.setWorkflowName(requestInfo.getWorkflowBaseInfo().getWorkflowName());
		wmEntity.setSysCode(requestInfo.getWorkflowBaseInfo().getWorkflowTypeName());
		wmEntity.setApprovalOption(requestInfo.getSubmitButtonName());
		if(requestInfo.getForwardButtonName() != null && !"".equals(requestInfo.getForwardButtonName())){
			//暂存 版本号
			wmEntity.setRejectNode(requestInfo.getForwardButtonName());
		}else{
			//节点默认为空
			wmEntity.setRejectNode("");
		}
		if(resultString != null){
			if(resultString.length() >= 50){
				wmEntity.setResult(resultString.substring(0, 50));
			}else{
				wmEntity.setResult(resultString);
			}
			if(resultString.equals("success")){
				wmEntity.setIsSuccess(1);
			}
		}
		wmEntity.setInterfaceName("submitWorkflowRequest");
		return getSqlSession().insert(NAMESPACE + "insertApprovalMonitor", wmEntity);
	}
	
	/**
	 * 添加新工作流审批接口监控--不同意、回退
	 * @param wmEntity
	 */
	public int insertUApprovalMonitor(WorkflowMonitorEntity wmEntity){
		/*WorkflowMonitorEntity wmEntity = new WorkflowMonitorEntity();
        //拼装实体
		wmEntity.setEmpCode(userId);
		wmEntity.setJobLevel(jobLevel);
		wmEntity.setWorkflowId(requestId);
		wmEntity.setWorkflowName(workflowName);
		wmEntity.setSysCode(sysCode);
		wmEntity.setApprovalOption("不同意");
		if(resultString != null){
			wmEntity.setResult(resultString);
		}
		wmEntity.setInterfaceName("workflowtUnagree");*/
		return getSqlSession().insert(NAMESPACE + "insertApprovalMonitor", wmEntity);
	}
	
	/**
	 * 查询‘合伙人资质审核’工作流的id
	 */
	public String getPartnerWid(){
		
		return (String)getSqlSession().selectOne(NAMESPACE + "getPartnerWid");
	}
	
	/**
	 * 新增一条工作流
	 * @param nworkflowinfo
	 * @return
	 */
	public int insertNWorkflow(NWorkflowInfoEntity nworkflowinfo){
		
		return getSqlSession().insert(NAMESPACE + "insertNWorkflow", nworkflowinfo);
	}
	
	/**
	 * 更改一条工作流状态
	 * @param nworkflowinfo
	 * @return
	 */
	public int updateNWorkflowStatus(NWorkflowInfoEntity nworkflowinfo){
		
		return getSqlSession().update(NAMESPACE + "updateNWorkflowStatus", nworkflowinfo);
	}

	
}
