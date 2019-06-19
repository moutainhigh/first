package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity;
import com.deppon.dpm.module.management.shared.domain.ParcelDataEntity;
import com.deppon.dpm.module.management.shared.domain.ParcelEntity;

/**
 * 包裹录入信息DAO
 * @author 王亚男
 *
 */
public interface ISendParcelDao {
	
	/**
	 * 批量插入包裹录入信息
	 * @param list
	 */
	public void insertSendPraceList(List<ParcelDataEntity> list);

	/**
	 * 查询所有未签收的包裹ID
	 */
	public List<Long> selectAllPackagesIdsList();
	
	/**
	 * 分页查询
	 * @param userNo 用户工号
	 * @param pageSize 每页条数
	 * @param pageNum 页码
	 * @return
	 */
	public List<ParcelEntity> getAllPackagesInfoPage(String userNo);
	
	/**
	 * 获取用户未签收总条数（包含代签）
	 * @param userNo 用户工号
	 * @return
	 */
	public int getPageCount(String userNo);
	
	/**
	 * @param packageId 包裹唯一标识
	 * @return 包裹信息
	 */
	public ParcelEntity getPackageInfo(Long packageId);
	
	/**
	 * @param packageId 包裹唯一标识
	 * @return List 包裹信息
	 */
	public List<ParcelEntity> getPackageList(Long packageId);
	
	/**
	 * 保存消息
	 * @param parBean
	 * @return
	 */
	public int saveMesssageToDB(MailReceiveSendFunctionEntity parBean);
	/**
	 * 催领单独查询
	 * @param parBean
	 * @return
	 */
	public String queryMesssageToDBCorporal(Long parBean);
	
}
