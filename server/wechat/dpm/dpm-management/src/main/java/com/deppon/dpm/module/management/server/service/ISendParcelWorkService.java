package com.deppon.dpm.module.management.server.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import com.deppon.dpm.module.management.shared.vo.EmpVO;
import com.deppon.dpm.module.management.shared.vo.ParcelListVO;


@Path("parcelService")
public interface ISendParcelWorkService {
	/** 
	* @Description: 盘点当前用户是否收发室管理员
	* @author 268087 张广波
	* @date 2015-9-10 下午3:26:35 
	*  @param empCode
	*  @return 
	*/
	public int checkIsSendAdm(String empCode);
	
	/** 
	* @Description: 查询人员详细信息
	* @author 268087 张广波
	* @date 2015-9-12 上午10:56:17 
	*  @param empVO
	*  @return 
	*/
	public List<EmpVO> queryEmpInfoList(EmpVO empVO);
	
	
	/** 
	* @Description: 根据当前登录人工号查询已领取列表
	* @author 268087 张广波
	* @date 2015-9-15 下午12:10:53 
	*  @param parcelListVO
	*  @return 
	*/
	public List<ParcelListVO> queryParcelList(ParcelListVO parcelListVO);
	
	/** 
	* @Description: 保存代领人员信息
	* @author 268087 张广波
	* @date 2015-9-15 下午3:43:43 
	*  @param parcelListVO
	*  @return 
	*/
	public Map<String, Object> saveParcelAct(String jsonParcelStr,HashMap<String, Object> retMap);
	
	/** 
	* @Description: 查询通告
	* @author 268087 张广波
	* @date 2015-9-28 上午9:33:41 
	*  @return 
	*/
	public String queryNotice();
	/** 
	* @Description: 更新通告
	* @author 268087 张广波
	* @date 2015-9-28 上午9:33:52 
	*  @param content
	*  @return 
	*/
	public int updateNotice(String content);
}
