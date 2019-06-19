package com.deppon.pm.module.change.bpms.branch.service.impl;

import java.util.Map;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.util.BPMSConstant;
import com.deppon.dpm.module.projecttools.shared.domain.EmployeeEntity;
import com.deppon.dpm.module.wfs.server.dao.IDppmChangeCheckDao;
import com.deppon.dpm.module.wfs.util.Constants;
import com.deppon.pm.module.change.bpms.branch.service.IChangeBranchService;

/**
 * 变更管理工作流业务规则接口实现
 * @author 106140
 * @date 2014-11-4 下午2:34:21
 * @since
 * @version
 */
public class ChangeBranchServiceImpl implements IChangeBranchService {
	
	/**
	 * 注入变更service
	 */
	private IDppmChangeCheckDao commonChangeService;
	
	/**
	 * 
	 * <p>判断是否战略级项目</p> 
	 * @author 150970
	 * @date 2014年12月12日 下午3:22:53
	 * @param map
	 * @return 
	 * @see com.deppon.pm.module.change.bpms.branch.service.IChangeBranchService#isStrategy(java.util.Map)
	 */
	@Override
	public boolean isStrategy(Map<?, ?> map) {
		Long processId = (Long)map.get(BPMSConstant.PROCESS_INST_ID);
		Integer ghLevel = commonChangeService.queryGhLevel(processId);
		return ghLevel == Constants.CONSTANT_THREE ? true : false;
	}

	/**
	 * 
	 * <p>判断项目是否管理咨询</p> 
	 * @author 150970
	 * @date 2014年12月12日 下午3:23:23
	 * @param map
	 * @return
	 * @see
	 */
	@Override
	public boolean isMngConsult(Map<?, ?> map) {
		Long processId = (Long)map.get(BPMSConstant.PROCESS_INST_ID);
		Integer ghType = commonChangeService.queryGhType(processId);
		return ghType == 2 ? true : false;
	}
	
	/**
	 * 
	 * <p>判断项目是否研发型</p> 
	 * @author 150970
	 * @date 2014年12月12日 下午4:22:12
	 * @param map
	 * @return 
	 * @see com.deppon.pm.module.change.bpms.branch.service.IChangeBranchService#isDevelopment(java.util.Map)
	 */
	@Override
	public boolean isDevelopment(Map<?, ?> map) {
		Long processId = (Long)map.get(BPMSConstant.PROCESS_INST_ID);
		Integer ghType = commonChangeService.queryGhType(processId);
		return ghType == 1 ? true : false;
	}
	
	/**
	 * 
	 * <p>是否重大变更</p> 
	 * @author 150970
	 * @date 2014年12月12日 下午4:22:59
	 * @param map
	 * @return 
	 * @see com.deppon.pm.module.change.bpms.branch.service.IChangeBranchService#isMajorChange(java.util.Map)
	 */
	@Override
	public boolean isMajorChange(Map<?, ?> map) {
		Long processId = (Long)map.get(BPMSConstant.PROCESS_INST_ID);
		Integer changeState = commonChangeService.queryChangeState(processId);
		return changeState == Constants.CONSTANT_FOUR ? true : false;
	}

	/**
	 * 
	 * <p>获取项目发起人</p> 
	 * @author 150970
	 * @date 2014年12月12日 下午4:23:16
	 * @param map
	 * @return 
	 * @see com.deppon.pm.module.change.bpms.branch.service.IChangeBranchService#getProjectSponsor(java.util.Map)
	 */
	@Override
	public BpmsParticipant[] getProjectSponsor(Map<?, ?> map) {
		Long processId = (Long)map.get(BPMSConstant.PROCESS_INST_ID);
		EmployeeEntity emplyee = commonChangeService.queryProjectSponsor(processId);
		BpmsParticipant[] participants = new BpmsParticipant[1];
		BpmsParticipant participant = new BpmsParticipant();
		participant.setId(emplyee.getContactEmployeeCode());
		participant.setName(emplyee.getContactOrderBy());
		participant.setTypeCode(BPMSConstant.PART_PERSON);
		participants[0] = participant;
		return participants;
	}

	/**
	 * @param commonChangeService
	 */
	public void setCommonChangeService(IDppmChangeCheckDao commonChangeService) {
		this.commonChangeService = commonChangeService;
	}

	
}
