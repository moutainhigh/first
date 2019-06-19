package com.deppon.pm.module.end.participant.service;

import java.util.Map;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.domain.ParticipantRule;
/**
 * 参与者
 * @author 106140
 * @date 2014-11-5 上午11:04:04
 * @since
 * @version
 */
public interface IParticipantManagerService {
	/**
	 * <p>项目管理</p> 
	 * @author 106140
	 * @date 2014-12-15 下午5:08:30
	 * @param rule
	 * @param map
	 * @return
	 * @
	 * @see
	 */
	 BpmsParticipant[] getProjectManager(ParticipantRule rule, Map<?,?> map) ;
	 /**
	  * <p>获取项目结项项目经理</p> 
	  * @author 106140
	  * @date 2014-12-15 下午5:08:36
	  * @param rule
	  * @param map
	  * @return
	  * @
	  * @see
	  */
	 BpmsParticipant[] getProjectClosingManager(ParticipantRule rule, Map<?,?> map) ;
	 /**
	  * <p>获取落地IT</p> 
	  * @author 106140
	  * @date 2014-12-15 下午5:09:54
	  * @param rule
	  * @param map
	  * @return
	  * @
	  * @see
	  */
	 BpmsParticipant[] getGroundOverTakenAndIT(ParticipantRule rule, Map<?,?> map) ;
	 /**
	  * <p></p> 
	  * @author 106140
	  * @date 2014-12-15 下午5:08:45
	  * @param rule
	  * @param map
	  * @return
	  * @
	  * @see
	  */
	 BpmsParticipant[] getGroundOverTakenAndDA(ParticipantRule rule, Map<?,?> map) ;
	 /**
	  * <p></p> 
	  * @author 106140
	  * @date 2014-12-15 下午5:08:50
	  * @param rule
	  * @param map
	  * @return
	  * @
	  * @see
	  */
	 BpmsParticipant[] getBusinessCheckManager(ParticipantRule rule, Map<?,?> map) ;
	 /**
	  * <p></p> 
	  * @author 106140
	  * @date 2014-12-15 下午5:08:54
	  * @param rule
	  * @param map
	  * @return
	  * @
	  * @see
	  */
	 BpmsParticipant[] getModuleCheckManager(ParticipantRule rule, Map<?,?> map) ;
	 
}
