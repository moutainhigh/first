
package com.deppon.pm.module.end.participant;

import java.util.Map;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.domain.ParticipantRule;
import com.deppon.dpm.module.wfs.server.util.SpringContextUtil;
import com.deppon.pm.module.end.participant.service.IParticipantManagerService;

/**
 * 参与者
 * @author 106140
 * @date 2014-11-5 上午11:02:54
 * @since
 * @version
 */
public class EndParticipantCommon {
	/**
	 * participantManagerService
	 */
	private IParticipantManagerService participantManagerService = ((IParticipantManagerService)SpringContextUtil.getBean("participantManagerService"));
	
	/**
	 * <p>落地：项目经理</p> 
	 * @author 106140
	 * @date 2014-11-5 上午11:17:03
	 * @param rule
	 * @param params
	 * @return
	 * @throws Exception
	 * @see
	 */
	public BpmsParticipant[] getProjectManager(ParticipantRule rule,Map<?,?> params) throws Exception{
    	return participantManagerService.getProjectManager(rule, params); 
    }
	/**
	 * <p>落地：业务承接部门、IT项目管理组</p> 
	 * @author 106140
	 * @date 2014-11-5 上午11:17:03
	 * @param rule
	 * @param params
	 * @return
	 * @throws Exception
	 * @see
	 */
	public BpmsParticipant[] getGroundOverTakenAndIT(ParticipantRule rule,Map<?,?> params) throws Exception{
		return participantManagerService.getGroundOverTakenAndIT(rule, params); 
	}
	/**
	 * <p>落地：业务承接部门、档案管理组</p> 
	 * @author 106140
	 * @date 2014-11-5 上午11:17:03
	 * @param rule
	 * @param params
	 * @return
	 * @throws Exception
	 * @see
	 */
	public BpmsParticipant[] getGroundOverTakenAndDA(ParticipantRule rule,Map<?,?> params) throws Exception{
		return participantManagerService.getGroundOverTakenAndDA(rule, params); 
	}
	/**
	 * <p>结项：业务验收负责人</p> 
	 * @author 106140
	 * @date 2014-11-5 上午11:17:03
	 * @param rule
	 * @param params
	 * @return
	 * @throws Exception
	 * @see
	 */
	public BpmsParticipant[] getBusinessCheckManager(ParticipantRule rule,Map<?,?> params) throws Exception{
		return participantManagerService.getBusinessCheckManager(rule, params); 
	}
	/**
	 * <p>结项：模块验收负责人</p> 
	 * @author 106140
	 * @date 2014-11-5 上午11:17:03
	 * @param rule
	 * @param params
	 * @return
	 * @throws Exception
	 * @see
	 */
	public BpmsParticipant[] getModuleCheckManager(ParticipantRule rule,Map<?,?> params) throws Exception{
		return participantManagerService.getModuleCheckManager(rule, params); 
	}
	
	/**
	 * <p>结项：项目经理</p> 
	 * @author 106140
	 * @date 2014-11-5 上午11:17:03
	 * @param rule
	 * @param params
	 * @return
	 * @throws Exception
	 * @see
	 */
	public BpmsParticipant[] getProjectClosingManager(ParticipantRule rule,Map<?,?> params) throws Exception{
    	return participantManagerService.getProjectClosingManager(rule, params); 
    }
	
}
