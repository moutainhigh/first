package com.deppon.pm.module.change.bpms.branch.service;

import java.util.Map;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;


/**
 * 变更管理工作流业务规则接口
 * @author 106140
 * @date 2014-11-4 下午2:30:03
 * @since
 * @version
 */
public interface IChangeBranchService {
	
	/**
	 * 
	 * <p>判断是否战略级项目（年度规划变更）</p> 
	 * @author 150970
	 * @date 2014年11月5日 上午9:44:33
	 * @param map
	 * @return
	 * @see
	 */
	boolean isStrategy(Map<?, ?> map);

	/**
	 * 
	 * <p>判断是否管理咨询型项目（年度规划变更）</p> 
	 * @author 150970
	 * @date 2014年11月5日 上午9:18:23
	 * @param map
	 * @return
	 * @see
	 */
	boolean isMngConsult(Map<?, ?> map);
	
	/**
	 * 
	 * <p>判断是否研发型</p> 
	 * @author 150970
	 * @date 2014年11月5日 上午9:41:04
	 * @param map
	 * @return
	 * @see
	 */
	boolean isDevelopment(Map<?, ?> map);
	
	/**
	 * 
	 * <p>判断是否重大变更</p> 
	 * @author 150970
	 * @date 2014年11月5日 上午9:54:33
	 * @param map
	 * @return
	 * @see
	 */
	boolean isMajorChange(Map<?, ?> map);

	/**
	 * 
	 * <p>获取项目发起人</p> 
	 * @author 150970
	 * @date 2014年11月12日 下午4:32:02
	 * @param map
	 * @return
	 * @see
	 */
	BpmsParticipant[] getProjectSponsor(Map<?, ?> map);
}
