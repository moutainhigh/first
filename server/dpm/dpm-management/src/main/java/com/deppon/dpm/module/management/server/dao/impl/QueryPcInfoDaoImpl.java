package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IQueryPcInfoDao;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 拼车dao
 * @author 293888
 *
 */
public class QueryPcInfoDaoImpl extends iBatis3DaoImpl implements
		IQueryPcInfoDao {
    //命名的工作空间
	private static final String mappernamespace = "com.deppon.dpm.module.management.server.dao.queryPCInfo";

	/**
	 * 根据拼车类型，查询拼车信息列表(用于拼车首页)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServeOriginatorsInfoEntity> queryPCListByType(int pageNum, int pageSize,String origType,String startProvinceCode, String keyWord,int carType,int payType) throws BusinessException{
		//判断参数是否为空
		if (null != origType) {
			//分页
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("pageStart", pageNum*pageSize);
			params.put("pageSize", pageSize);
			params.put("origType", origType);
			params.put("startProvinceCode", startProvinceCode);
			params.put("keyWord", keyWord);
			params.put("carType", carType);
			params.put("payType", payType);
			//返回数据
			return this.getSqlSession().selectList(
					mappernamespace + ".queryPCListByType", params);
		}
		return null;
	}

	/**
	 * 我发起列表查询 根据报名截止时间倒序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServeOriginatorsInfoEntity> queryPCListByOrgiNo(String origNo) throws BusinessException{
		//判断参数是否为空
		if (null != origNo && !"".equals(origNo)) {
			//返回数据
			return this.getSqlSession().selectList(
					mappernamespace + ".queryPCListByOrgiNo", origNo);
		}
		return null;
	}

	/**
	 * 根据工号，获得我参与列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServeParticipantsInfoEntity> queryBMListByOrgiNo(String origNo) throws BusinessException{
		//判断参数是否为空
		if (null != origNo && !"".equals(origNo)) {
			//返回数据
			return this.getSqlSession().selectList(
					mappernamespace + ".queryBMListByOrgiNo", origNo);
		}
		return null;
	}

	/**
	 * 根据id串返回拼车列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServeOriginatorsInfoEntity> queryPCListByIds(String id) throws BusinessException{
		//判断参数是否为空
		if(null != id && !"".equals(id)){
			//返回数据
			return this.getSqlSession().selectList(mappernamespace + ".queryPCListByIds", id); 
		}
		return null;
	}

	/**
	 * 根据外键获得参与者列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServeParticipantsInfoEntity> queryBMListById(String id) throws BusinessException{
		// TODO Auto-generated method stub
		//判断参数是否为空
		if(null != id && !"".equals(id)){
			//返回数据
			return this.getSqlSession().selectList(mappernamespace + ".queryBMListById", id); 
		}
		return null;
	}
	
	/**
	 * 根据ID返回拼车列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServeOriginatorsInfoEntity> queryPCListById(String id) {
		// TODO Auto-generated method stub
		//判断参数是否为空
		if(null != id && !"".equals(id)){
			//返回数据
			return this.getSqlSession().selectList(mappernamespace + ".queryPCListById", id); 
		}
		return null;
	}

	/**
	 * 获得拼车记录总数
	 */
	@Override
	public int getCount(String origType,String startProvinceCode, String keyWord,int carType,int payType) throws BusinessException {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("origType", origType);
		params.put("startProvinceCode", startProvinceCode);
		params.put("keyWord", keyWord);
		params.put("carType", carType);
		params.put("payType", payType);
		//返回数据
		return (Integer) this.getSqlSession().selectOne(mappernamespace+".getCount",params);
	}

	/**
	 * 获得参与者人数
	 */
	@Override
	public int getPeoCount(String id) throws BusinessException {
		//返回数据
		 return (Integer) this.getSqlSession().selectOne(mappernamespace+".getPeoCount",id);
	}

	

}
