package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.vo.EmpVO;
import com.deppon.dpm.module.management.shared.vo.ParcelListVO;

public interface ISendParcelWorkDao {
	/** 
	* @Description: 判断用户是否收发室管理员
	* @author 268087 张广波
	* @date 2015-9-10 上午8:17:39 
	*  @param empCode
	*  @return 
	*/
	public int checkIsSendAdm(String empCode);
	
	/** 
	* @Description: 查询用户信息列表
	* @author 268087 张广波
	* @date 2015-9-12 上午10:54:20 
	*  @param empVO
	*  @return 
	*/
	public List<EmpVO> queryEmpInfoList(EmpVO empVO);
	
	/** 
	* @Description: 根据当前登录人工号查询已领取列表
	* @author 268087 张广波
	* @date 2015-9-15 下午12:07:39 
	*  @param parcelListVO
	*  @return 
	*/
	public List<ParcelListVO> queryParcelList(ParcelListVO parcelListVO);
	
	
	/** 
	* @Description: 保存代领信息
	* @author 268087 张广波
	* @date 2015-9-15 下午2:31:33 
	*  @param parcelListVO
	*  @return 
	*/
	public int saveParcelAct(ParcelListVO parcelListVO);
	
	/** 
	* @Description: 校验重复提交
	* @author 268087 张广波
	* @date 2015-9-22 下午5:15:53 
	*  @param parcelListVO
	*  @return 
	*/
	public int checkIsRepeat(ParcelListVO parcelListVO);
	/** 
	* @Description: 更新代领状态
	* @author 268087 张广波
	* @date 2015-9-22 下午5:15:53 
	*  @param parcelListVO
	*  @return 
	*/
	public int updatePostStatus(ParcelListVO parcelListVO);
	
	
	/** 
	* @Description: 查询通告
	* @author 268087 张广波
	* @date 2015-9-28 上午9:12:02 
	*  @return 
	*/
	public String queryNotice();
	
	
	/** 
	* @Description: 更新通告
	* @author 268087 张广波
	* @date 2015-9-28 上午9:17:21 
	*  @param content
	*  @return 
	*/
	public int updateNotice(String content);
	
}
