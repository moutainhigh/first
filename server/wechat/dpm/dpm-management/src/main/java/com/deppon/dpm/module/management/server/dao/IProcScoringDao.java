package com.deppon.dpm.module.management.server.dao;



import java.util.List;
import com.deppon.dpm.module.management.shared.domain.ProcAddressEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMessageEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchDeptEntity;
import com.deppon.dpm.module.management.shared.domain.ProcScoringEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchProjectEntity;

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
	  * @throws Exception
	  */
	 public int savaEngScoring(ProcScoringEntity engScoringEntity) throws Exception;
	 /**
	  * <p>Description：保存地址</p>
	  * @param engAddressEntity
	  * @return
	  * @throws Exception
	  */
	 public int savaEngAddress(ProcAddressEntity engAddressEntity) throws Exception;
	 /**
	  *  <p>Description：保存损坏原因</p>
	  * @param procMessageEntity
	  * @return
	  * @throws Exception
	  */
	 public int savaProcMessage(ProcMessageEntity procMessageEntity ) throws Exception;
	 
	
	 
	 /**
	  * <p>Description：修改分数</p>
	  * @param engScoringEntity
	  * @return
	  * @throws Exception
	  */
	 public int updateEngScoring(ProcScoringEntity engScoringEntity)throws Exception;
	 /**
	  * <p>Description：修改地址</p>
	  * @param engAddressEntity
	  * @return
	  * @throws Exception
	  */
	 public int updateEngAddress(ProcAddressEntity engAddressEntity) throws Exception;
	 /**
	  * <p>Description：修改损坏信息</p>
	  * @param procMessageEntity
	  * @return
	  * @throws Exception
	  */
	 public int updateProcMessage(ProcMessageEntity procMessageEntity ) throws Exception;
	 

	 
     /**
      * <p>Description：查询地址</p>
      * @param engAddressEntity
      * @return
      * @throws Exception
      */
	 public String selectAddressid(ProcAddressEntity engAddressEntity) throws Exception;
	 /**
	  * <p>Description：修改分数表ID</p>
	  * @param procScoringEntity
	  * @return
	  * @throws Exception
	  */
	 public String selectScopeid(ProcScoringEntity procScoringEntity) throws Exception;
	 /**
	  * <p>Description：修改损坏原因表ID</p>
	  * @param scopeid
	  * @return
	  * @throws Exception
	  */
	 public String selectMessageid(String scopeid) throws Exception;
	 

	 /**
	  * <p>Description：保存信息</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws Exception
	  */
     public int savaProcWatchDept(ProcWatchDeptEntity procWatchDeptEntity )throws Exception;
	
     /**
	  * <p>Description：批量处理保存</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws Exception
	  */
     public int savaProcWatchProject(List<ProcWatchProjectEntity> list )throws Exception;
     
     /**
	  * <p>Description：查询时间</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws Exception
	  */
     public String selectProcWatchDept(String deptcode)throws Exception;
     /**
	  * <p>Description：批量删除</p>
	  * @param procWatchDeptEntity
	  * @return 
	  * @throws Exception
	  */
     public int deleteProcWatchProject(List<ProcWatchProjectEntity> list)throws Exception;
}
