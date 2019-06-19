package com.deppon.dpm.module.management.server.dao;



import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcAddressEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMessageEntity;
import com.deppon.dpm.module.management.shared.domain.ProcScoringEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchDeptEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchProjectEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 保存分数信息
 * 和数据监控
 * @author 袁中华
 * @date 2015.07.14
 *
 */

public interface IProcScoringDao {
	 /**
	  * <p>Description：保存5分</p>
	  * @param engScoringEntity
	  * @return
	  * @throws BusinessException
	  */
	 public int savaEngScoring(ProcScoringEntity engScoringEntity) throws BusinessException;
	 /**
	  * <p>Description：保存地址</p>
	  * @param engAddressEntity
	  * @return
	  * @throws BusinessException
	  */
	 public int savaEngAddress(ProcAddressEntity engAddressEntity) throws BusinessException;
	 /**
	  *  <p>Description：保存损坏原因</p>
	  * @param procMessageEntity
	  * @return
	  * @throws BusinessException
	  */
	 public int savaProcMessage(ProcMessageEntity procMessageEntity ) throws BusinessException;
	 
	
	 
	 /**
	  * <p>Description：修改分数</p>
	  * @param engScoringEntity
	  * @return
	  * @throws BusinessException
	  */
	 public int updateEngScoring(ProcScoringEntity engScoringEntity)throws BusinessException;
	 /**
	  * <p>Description：修改地址</p>
	  * @param engAddressEntity
	  * @return
	  * @throws BusinessException
	  */
	 public int updateEngAddress(ProcAddressEntity engAddressEntity) throws BusinessException;
	 /**
	  * <p>Description：修改损坏信息</p>
	  * @param procMessageEntity
	  * @return
	  * @throws BusinessException
	  */
	 public int updateProcMessage(ProcMessageEntity procMessageEntity ) throws BusinessException;
	 

	 
     /**
      * <p>Description：查询地址</p>
      * @param engAddressEntity
      * @return
      * @throws BusinessException
      */
	 public String selectAddressid(ProcAddressEntity engAddressEntity) throws BusinessException;
	 /**
	  * <p>Description：修改分数表ID</p>
	  * @param procScoringEntity
	  * @return
	  * @throws BusinessException
	  */
	 public String selectScopeid(ProcScoringEntity procScoringEntity) throws BusinessException;
	 /**
	  * <p>Description：修改损坏原因表ID</p>
	  * @param scopeid
	  * @return
	  * @throws BusinessException
	  */
	 public String selectMessageid(String scopeid) throws BusinessException;
	 

	 /**
	  * <p>Description：保存信息</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws BusinessException
	  */
     public int savaProcWatchDept(ProcWatchDeptEntity procWatchDeptEntity )throws BusinessException;
	
     /**
	  * <p>Description：批量处理保存</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws BusinessException
	  */
     public int savaProcWatchProject(List<ProcWatchProjectEntity> list )throws BusinessException;
     
     /**
	  * <p>Description：查询时间</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws BusinessException
	  */
     public String selectProcWatchDept(String deptcode)throws BusinessException;
     /**
	  * <p>Description：批量删除</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws BusinessException
	  */
     public int deleteProcWatchProject(List<ProcWatchProjectEntity> list)throws BusinessException;
}
