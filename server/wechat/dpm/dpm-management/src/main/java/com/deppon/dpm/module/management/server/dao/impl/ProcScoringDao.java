package com.deppon.dpm.module.management.server.dao.impl;




import java.util.List;

import com.deppon.dpm.module.management.server.dao.IProcScoringDao;
import com.deppon.dpm.module.management.shared.domain.ProcAddressEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMessageEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchDeptEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchProjectEntity;

import com.deppon.dpm.module.management.shared.domain.ProcScoringEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 实现分数保存信息
 * 和数据监控
 * @author 袁中华
 * @date 2015.07.14
 *
 */

public class ProcScoringDao extends iBatis3DaoImpl implements IProcScoringDao{
	/**
	 * engScoring.xml中的空间id
	 */
	private String mappernamespace="com.deppon.dpm.module.management.server.dao.procScoringDao";
	   /**
	    * <p>Description：保村分数</p>
	    * @param engAddressEntity
	    * @return int
	    * @throws Exception
	    */
	@Override             
	public int savaEngScoring(ProcScoringEntity scoring) throws Exception {
		// TODO Auto-generated method stub
			return this.getSqlSession().insert(mappernamespace+".savaScoring", scoring);
	}
	   /**
	    *  <p>Description：保存地址</p>
	    * @param procMessageEntity
	    * @return int
	    * @throws Exception
	    */

	@Override
	public int savaEngAddress(ProcAddressEntity engAddressEntity) throws Exception {
		// TODO Auto-generated method stub
	       return this.getSqlSession().insert(mappernamespace+".savauserAddress", engAddressEntity);
	}

	 /**
	  *  <p>Description：保存损坏原因</p>
	  * @param procMessageEntity
	  * @return int
	  * @throws Exception
	  * 保存评分详细表
	  */

	@Override
	public int savaProcMessage(ProcMessageEntity procMessageEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+".savaMessage", procMessageEntity);
	}
	 
	/**
	  * <p>Description：修改分数</p>
	  * @param engScoringEntity
	  * @return int
	  * @throws Exception
	  *
      * @see com.deppon.dpm.module.management.server.dao.IProcScoringDao#UpdateEngScoring(com.deppon.dpm.module.management.shared.domain.ProcScoringEntity)
      */
	public int updateEngScoring(ProcScoringEntity engScoringEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mappernamespace+".updateScoring", engScoringEntity);
	}
	/**
	  * <p>Description：修改地址</p>
	  * @param engAddressEntity
	  * @return int
	  * @throws Exception
	  * @see com.deppon.dpm.module.management.server.dao.IProcScoringDao#UpdateEngAddress(com.deppon.dpm.module.management.shared.domain.ProcAddressEntity)
	  */
	public int updateEngAddress(ProcAddressEntity engAddressEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mappernamespace+".updateuserAddress", engAddressEntity);
	}
	/**
	  * <p>Description：修改损坏信息</p>
	  * @param procMessageEntity
	  * @return int
	  * @throws Exception
	  * @see com.deppon.dpm.module.management.server.dao.IProcScoringDao#UpdateProcMessage(com.deppon.dpm.module.management.shared.domain.ProcMessageEntity)
	  */
	public int updateProcMessage(ProcMessageEntity procMessageEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mappernamespace+".updateMessage",procMessageEntity);
	}


	/**
      * <p>Description：查询地址</p>
      * @param engAddressEntity
      * @return String 
      * @throws Exception
	  * @see com.deppon.dpm.module.management.server.dao.IProcScoringDao#SelectAddressid(com.deppon.dpm.module.management.shared.domain.ProcAddressEntity)
	  */
	public String selectAddressid(ProcAddressEntity engAddressEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return (String) this.getSqlSession().selectOne(mappernamespace+".getAddressid", engAddressEntity);
	}
	/**
	  * <p>Description：修改分数表ID</p>
	  * @param procScoringEntity
	  * @return String 
	  * @throws Exception
	  * @see com.deppon.dpm.module.management.server.dao.IProcScoringDao#SelectScopeid(com.deppon.dpm.module.management.shared.domain.ProcScoringEntity)
	  */
	@Override
	public String selectScopeid(ProcScoringEntity procScoringEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return (String)this.getSqlSession().selectOne(mappernamespace+".getScoringid",procScoringEntity);
	}
	/** <p>Description：修改损坏原因表ID</p>
	  * @param scopeid
	  * @return String 
	  * @throws Exception
	  * @see com.deppon.dpm.module.management.server.dao.IProcScoringDao#SelectMessageid(java.lang.String)
	  */
	@Override
	public String selectMessageid(String scopeid) throws Exception {
		// TODO Auto-generated method stub
		return (String)this.getSqlSession().selectOne(mappernamespace+".getMessageid", scopeid);
	}
	
	/** <p>Description：监控部门数量表</p>
	  * @param procWatchDeptEntity
	  * @return int
	  * @throws Exception
	  * 
	  */
	@Override
	public int savaProcWatchDept(ProcWatchDeptEntity procWatchDeptEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+".savaWatchDept",procWatchDeptEntity);
	}
	
	
	
	/** <p>Description：异常数量维修数量表</p>
	  * @param procWatchDeptEntity
	  * @return int
	  * @throws Exception
	  * 
	  */
	
	public int savaProcWatchProject(List<ProcWatchProjectEntity> list)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+".savaWatchProject",list);
	}
	 /**
	  * <p>Description：查询时间</p>
	  * @param procWatchDeptEntity
	  * @return  String
	  * @throws Exception
	  */
	@Override
	public String selectProcWatchDept(String deptcode) throws Exception {
		// TODO Auto-generated method stub
		return (String) this.getSqlSession().selectOne(mappernamespace+".getWatchDept", deptcode);
	}

	 /**
	  * <p>Description：批量删除</p>
	  * @param procWatchDeptEntity
	  * @return  String
	  * @throws Exception
	  */
	public int deleteProcWatchProject(List<ProcWatchProjectEntity> list)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert(mappernamespace+".deleteWatchProject",list);
	}
	
	


}
