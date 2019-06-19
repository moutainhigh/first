package com.deppon.pm.module.change.bpms.branch;

import java.util.Map;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.domain.ParticipantRule;
import com.deppon.dpm.module.wfs.server.util.SpringContextUtil;
import com.deppon.pm.module.change.bpms.branch.service.IChangeBranchService;

/**
 * 
 * 变更分支规则管理类
 * @author 150970
 * @date 2015年1月9日 下午2:59:56
 * @since
 * @version
 */
public class ChangeBranchCommon {
	
	/**
	 * 实例化变更分支规则service
	 */
	private IChangeBranchService changeBranchService = (IChangeBranchService)SpringContextUtil.
			getBean("changeBranchService");


	 /**
	 * 
	 * <p>判断是否战略级项目</p> 
	 * @author 150970
	 * @date 2014年11月4日 上午10:14:57
	 * @param map
	 * @return
	 * @see
	 */
	public boolean isStrategy(Map<?, ?> map) {
		return changeBranchService.isStrategy(map);
	}
	 
	/**
	 * 
	 * <p>判断项目是否管理咨询</p> 
	 * @author 150970
	 * @date 2014年11月4日 上午9:55:01
	 * @return
	 * @see
	 */
	public boolean isMngConsult(Map<?, ?> map) {
		return changeBranchService.isMngConsult(map);
	}
	
	/**
	 * 
	 * <p>判断项目是否研发型</p> 
	 * @author 150970
	 * @date 2014年11月4日 上午10:14:01
	 * @param map
	 * @return
	 * @see
	 */
	public boolean isDevelopment(Map<?, ?> map) {
		return changeBranchService.isDevelopment(map);
	}
	
	/**
	 * 
	 * <p>是否重大变更</p> 
	 * @author 150970
	 * @date 2014年11月4日 上午10:16:13
	 * @param map
	 * @return
	 * @see
	 */
	public boolean isMajorChange(Map<?, ?> map) {
		return changeBranchService.isMajorChange(map);
	}
	
	/**
	 * 
	 * <p>获取项目发起人</p> 
	 * @author 150970
	 * @date 2014年11月12日 下午4:32:52
	 * @param map
	 * @return
	 * @see
	 */
	public BpmsParticipant[] getProjectSponsor(ParticipantRule rule, Map<?, ?> map) {
		return changeBranchService.getProjectSponsor(map);
	}
}
