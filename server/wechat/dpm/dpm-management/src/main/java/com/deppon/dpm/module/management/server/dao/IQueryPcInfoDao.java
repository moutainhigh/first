package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.domain.ServeParticipantsInfoEntity;

/**
 * 查询拼车信息DAO层
 * @author 293888
 *
 */
public interface IQueryPcInfoDao {
	/**
	 * 根据拼车类型，查询拼车信息列表(用于拼车首页)
	 * @param origType  拼车类型 (0：上班车、1：下班车、2：活动)
	 * @return	拼车信息列表
	 */
	public List<ServeOriginatorsInfoEntity> queryPCListByType(int pageNum, int pageSize,String origType,String startProvinceCode, String keyWord,int carType,int payType) throws Exception;
	
	/**
	 * 我发起列表查询   根据报名截止时间倒序
	 * @param orgiNo	发起者员工工号
	 * @return 拼车信息列表
	 */
	public List<ServeOriginatorsInfoEntity> queryPCListByOrgiNo(String origNo) throws Exception;
	
	/**
	 *	根据工号，获得我参与列表 
	 * @param orgiNo	参与者员工工号
	 * @return 参与者信息列表
	 */
	public List<ServeParticipantsInfoEntity> queryBMListByOrgiNo(String origNo) throws Exception;
	/**
	 * 根据id串返回拼车列表
	 * @param id 发布信息的主键 (拼成这样的形式：1,5,11)
	 * @return 拼车信息列表
	 */
	public List<ServeOriginatorsInfoEntity> queryPCListByIds(String id) throws Exception;
	
	/**
	 * 根据外键获得参与者列表
	 * @param id
	 * @return 参与者信息列表
	 */
	public List<ServeParticipantsInfoEntity> queryBMListById(String id) throws Exception;
	
	public List<ServeOriginatorsInfoEntity> queryPCListById(String id);
	
	/**
	 * 获得拼车记录总数
	 * @return
	 * @throws Exception
	 */
	public int getCount(String origType,String startProvinceCode, String keyWord,int carType,int payType) throws Exception;
	
	/**
	 * 获得参名者人数
	 * @return
	 * @throws Exception
	 */
	public int getPeoCount(String id) throws Exception;
	
}
