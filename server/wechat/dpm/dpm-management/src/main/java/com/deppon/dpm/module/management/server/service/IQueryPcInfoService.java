package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.vo.PcDetailInfoVo;
/**
 * 查询所有拼车信息
 * @author 293888
 *
 */
public interface IQueryPcInfoService {

	/**
	 * 根据拼车类型，查询拼车信息列表(用于拼车首页)
	 * @param origType  拼车类型 (0：上班车、1：下班车、2：活动)
	 * @return	拼车信息列表
	 */
	public List<ServeOriginatorsInfoEntity> queryPCListByType(int pageNum, int pageSize,String origType,String startProvinceCode, String keyWord,int carType,int payType);
	
	/**
	 * 我发起列表查询   根据报名截止时间倒序
	 * @param orgiNo	发起者员工工号
	 * @return 拼车信息列表
	 */
	public List<ServeOriginatorsInfoEntity> queryPCListByOrgiNo(String origNo);
	
	
	/**
	 * 根据id串返回拼车列表
	 * @param id 发布信息的主键 (拼成这样的形式：1,5,11)
	 * @return 拼车信息列表
	 */
	public List<ServeOriginatorsInfoEntity> queryPCListById(String origNo);
	/**
	 * 根据id组装拼车详细信息
	 * @param id 
	 * @return
	 */
	public PcDetailInfoVo queryPCDetailById(String id);
	
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
