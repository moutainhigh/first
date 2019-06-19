package com.deppon.dpm.module.management.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IQueryPcInfoDao;
import com.deppon.dpm.module.management.server.service.IQueryPcInfoService;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.vo.PcDetailInfoVo;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 查询所有拼车信息
 * 
 * @author 293888
 * 
 */
public class QueryPcInfoServiceImpl implements IQueryPcInfoService {

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(QueryPcInfoServiceImpl.class);
	/**
	 * 查询拼车DAO
	 */
	IQueryPcInfoDao queryPcInfoDao;

	/**
	 * 根据拼车类型，查询拼车信息列表(用于拼车首页)
	 */
	@Override
	public List<ServeOriginatorsInfoEntity> queryPCListByType(int pageNum,
			int pageSize, String origType,String startProvinceCode, String keyWord,int carType,int payType) {
		// TODO Auto-generated method stub
		try {
			//返回数据
			return queryPcInfoDao
					.queryPCListByType(pageNum, pageSize, origType,startProvinceCode,keyWord,carType,payType);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			//如果异常返回null
			logger.info("查询拼车信息列表发生异常，拼车类型为：" + origType);
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * 根据id串返回拼车列表
	 */
	@Override
	public List<ServeOriginatorsInfoEntity> queryPCListByOrgiNo(String origNo) {
		// TODO Auto-generated method stub
		try {
			return queryPcInfoDao.queryPCListByOrgiNo(origNo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			logger.info("我发起信息列表异常，员工工号为：" + origNo);
			e.printStackTrace();
			//如果异常返回null
			return null;
		}
	}
	/**
	 * 根据id串返回拼车列表
	 */
	@Override
	public List<ServeOriginatorsInfoEntity> queryPCListById(String origNo) {
		// TODO Auto-generated method stub

		try {

			return queryPcInfoDao.queryPCListByIds(origNo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			logger.info("根据我参与列表获得拼车列表异常,工号为：" + origNo);
			e.printStackTrace();
			//如果异常返回null
			return null;
		}
	}

	/**
	 * 根据id组装拼车详细信息
	 */
	@Override
	public PcDetailInfoVo queryPCDetailById(String id) {
		// TODO Auto-generated method stub
		//用于封装VO
		PcDetailInfoVo infoVos = null;
		if (null != id) {
			ServeOriginatorsInfoEntity entity = null;
			try {
				//set
				if (null != queryPcInfoDao.queryPCListById(id)) {
					entity = queryPcInfoDao.queryPCListById(id).get(0);
				}
				infoVos = new PcDetailInfoVo();

				infoVos.setServeParticipantsInfoEntities(queryPcInfoDao
						.queryBMListById(id));
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("获得详情信息异常，id为：" + id);
			}
			if (null != entity) {
				infoVos.setServeOriginatorsInfoEntity(entity);
			}

		}
		//返回详情信息
		return infoVos;
	}

	/**
	 * 获得拼车记录总数
	 */
	@Override
	public int getCount(String origType,String startProvinceCode, String keyWord,int carType,int payType) throws BusinessException {
		// TODO Auto-generated method stub
		return queryPcInfoDao.getCount(origType,startProvinceCode,keyWord,carType,payType);
	}
	
	/**
	 * 获得参名者人数
	 */
	@Override
	public int getPeoCount(String id) throws BusinessException {
		// TODO Auto-generated method stub
		return queryPcInfoDao.getPeoCount(id);
	}
	/**
	 * 查询拼车DAO
	 * @return 查询拼车DAO
	 */
	public IQueryPcInfoDao getQueryPcInfoDao() {
		return queryPcInfoDao;
	}

	public void setQueryPcInfoDao(IQueryPcInfoDao queryPcInfoDao) {
		this.queryPcInfoDao = queryPcInfoDao;
	}

}
