package com.deppon.pm.module.end.participant.service.impl;

import java.util.List;
import java.util.Map;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.domain.ParticipantRule;
import com.deppon.bpmsapi.module.client.util.BPMSConstant;
import com.deppon.dpm.module.wfs.server.dao.IDppmWorkInfoDao;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingCheckTypeEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingOrgInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectClosingEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectFallGroundEntity;
import com.deppon.pm.module.end.participant.service.IParticipantManagerService;
/**
 * 参与者管理service实现
 * @author 106140
 * @date 2014-12-15 下午5:06:10
 * @since
 * @version
 */
public class ParticipantManagerServiceImpl implements IParticipantManagerService {
	/**
	 * 落地,结项DAO
	 */
	private IDppmWorkInfoDao dao;
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
	@Override
	public BpmsParticipant[] getProjectManager(ParticipantRule rule,
			Map<?, ?> map)  {
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		//业务信息
		ProjectFallGroundEntity projectFallGroundEntity = dao.projFallGroundDetail(busino);
		//工号
		String empcode = projectFallGroundEntity.getManagerCode();
		//姓名
		String empName = projectFallGroundEntity.getProjectManager();
		//能与者实体
		BpmsParticipant[] bp = new BpmsParticipant[1];
		bp[0] = new BpmsParticipant();
		//id
		bp[0].setId(empcode);
		//名称
		bp[0].setName(empName);
		//类型
		bp[0].setTypeCode(BPMSConstant.PART_PERSON);
		return bp;
	}
	
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
	@Override
	public BpmsParticipant[] getGroundOverTakenAndIT(ParticipantRule rule,
			Map<?, ?> map)  {

		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		//业务信息
		ProjectFallGroundEntity projectFallGroundEntity = dao.projFallGroundDetail(busino);
		//code
		String overTaken = projectFallGroundEntity.getUndertakeDeptCode()+",DP10556";
		String[] overTakens = overTaken.split(",");
		//参与者实体
		BpmsParticipant[] bp = new BpmsParticipant[overTakens.length];
		for (int i = 0; i < overTakens.length; i++) {
			bp[i] = new BpmsParticipant();
			//id
			bp[i].setId(overTakens[i]);
			//类型
			bp[i].setTypeCode(BPMSConstant.PART_ORG);
		}
		return bp;
	}
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
	@Override
	public BpmsParticipant[] getGroundOverTakenAndDA(ParticipantRule rule,
			Map<?, ?> map)  {
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		// 业务实体
		ProjectFallGroundEntity projectFallGroundEntity = dao.projFallGroundDetail(busino);
		//code
		String overTaken = projectFallGroundEntity.getUndertakeDeptCode()+",DP02347";
		String[] overTakens = overTaken.split(",");
		//参与者实体
		BpmsParticipant[] bp = new BpmsParticipant[overTakens.length];
		for (int i = 0; i < overTakens.length; i++) {
			bp[i] = new BpmsParticipant();
			//id
			bp[i].setId(overTakens[i]);
			//类型
			bp[i].setTypeCode(BPMSConstant.PART_ORG);
		}
		return bp;
	}
	
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
	@Override
	public BpmsParticipant[] getBusinessCheckManager(ParticipantRule rule,
			Map<?, ?> map)  {
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		//业务信息
		ClosingOrgInfoEntity closingOrgInfoEntity = dao.closingOrgInfoEntity(busino);
		//工号
		String mangerCode = closingOrgInfoEntity.getManagerCode();
		//姓名
		String mangerName = closingOrgInfoEntity.getManagerName();
		//参与者实体
		BpmsParticipant[] bp = new BpmsParticipant[1];
		bp[0] = new BpmsParticipant();
		//id
		bp[0].setId(mangerCode);
		//姓名
		bp[0].setName(mangerName);
		//类型
		bp[0].setTypeCode(BPMSConstant.PART_PERSON);
		return bp;
	}
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
	@Override
	public BpmsParticipant[] getModuleCheckManager(ParticipantRule rule,
			Map<?, ?> map)  {
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		//业务信息
		List<ClosingCheckTypeEntity> closingCheckTypeList = dao.closingCheckTypeList(busino);
		BpmsParticipant[] bp = null;
		if(closingCheckTypeList != null && closingCheckTypeList.size()>0){
			
			bp = new BpmsParticipant[closingCheckTypeList.size()];
			for (int i = 0; i < closingCheckTypeList.size(); i++) {

				//参与 者实体
				bp[i] = new BpmsParticipant();
				//工号
				bp[i].setId(closingCheckTypeList.get(i).getManagerCode());
				//姓名
				bp[i].setName(closingCheckTypeList.get(i).getManagerName());
				// 类型
				bp[i].setTypeCode(BPMSConstant.PART_PERSON);
			}
		}
		
		return bp;
	}

	/**
	 * 
	 * <p>getProjectClosingManager</p> 
	 * @author 106140
	 * @date 2014-12-24 下午2:41:56
	 * @param rule
	 * @param map
	 * @return
	 * @ 
	 * @see com.deppon.pm.module.end.participant.service.IParticipantManagerService#getProjectClosingManager(com.deppon.bpmsapi.module.client.domain.ParticipantRule, java.util.Map)
	 */
	@Override
	public BpmsParticipant[] getProjectClosingManager(ParticipantRule rule,
			Map<?, ?> map)  {
		//业务编号
		String busino = (String) map.get(BPMSConstant.BIZCODE);
		// 业务实体
		ProjectClosingEntity projectClosingEntity = dao.projClosingDetail(busino);
		// 工号
		String empcode = projectClosingEntity.getManagerCode();
		// 姓名
		String empName = projectClosingEntity.getProjectManager();
		BpmsParticipant[] bp = new BpmsParticipant[1];
		bp[0] = new BpmsParticipant();
		//id
		bp[0].setId(empcode);
		// 姓名
		bp[0].setName(empName);
		// 类型
		bp[0].setTypeCode(BPMSConstant.PART_PERSON);
		return bp;
	}

	/**
	 * @return the dao
	 */
	public IDppmWorkInfoDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(IDppmWorkInfoDao dao) {
		this.dao = dao;
	}
	


}
