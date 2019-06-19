package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.ISendParcelDao;
import com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity;
import com.deppon.dpm.module.management.shared.domain.ParcelDataEntity;
import com.deppon.dpm.module.management.shared.domain.ParcelEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 包裹录入信息
 * @author 王亚男
 *
 */
public class SendParcelDao extends iBatis3DaoImpl implements ISendParcelDao {

	private String mappernamespace="com.deppon.dpm.module.management.server.dao.sendParcelData";	
	
	/**
	 * 批量插入包裹录入信息
	 * @param list
	 */
	public void insertSendPraceList(List<ParcelDataEntity> list) {
		this.getSqlSession().insert(mappernamespace+".insertSendData", list);
	}

	@SuppressWarnings("unchecked")
	public  List<Long> selectAllPackagesIdsList() {
		return this.getSqlSession().selectList(mappernamespace+".selectAllPackageId");
		
	}

	@SuppressWarnings("unchecked")
	public List<ParcelEntity> getAllPackagesInfoPage(String userNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", userNo);
		return this.getSqlSession().selectList(mappernamespace+".selectParcelPageData", map);
	}

	/**
	 * 获取用户未签收总条数（包含代签）
	 * @param userNo 用户工号
	 * @return
	 */
	public int getPageCount(String userNo) {
		return (Integer) this.getSqlSession().selectOne(this.mappernamespace+".selectParcelPageCount",userNo);
	}

	/**
	 * @param packageId 包裹唯一标识
	 * @return 包裹信息
	 */
	public ParcelEntity getPackageInfo(Long packageId) {
		@SuppressWarnings("unchecked")
		List<ParcelEntity> list = this.getSqlSession().selectList(this.mappernamespace+".selectOneByPackagesId",packageId);
		if(list != null){
			if(list.size()>0)
				return list.get(0);
		}
		return null;
	}

	/**
	 * @param packageId 包裹唯一标识
	 * @return List 包裹信息
	 */
	public List<ParcelEntity> getPackageList(Long packageId) {
		@SuppressWarnings("unchecked")
		List<ParcelEntity> list = this.getSqlSession().selectList(this.mappernamespace+".selectOneByPackagesId",packageId);
		if(list != null){
			if(list.size()>0)
				return list;
		}
		return null;
	}

	/* 
	 * 保存消息通知
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.ISendParcelDao#saveMesssageToDB(com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity)
	 */
	@Override
	public int saveMesssageToDB(MailReceiveSendFunctionEntity parBean) {
		
		return this.getSqlSession().insert(this.mappernamespace+".saveMesssageToDB", parBean);
	}

	/* 
	 * 催领查询
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.dao.ISendParcelDao#queryMesssageToDBCorporal(com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity)
	 */
	@Override
	public String queryMesssageToDBCorporal(Long parBean) {
		return (String)this.getSqlSession().selectOne(this.mappernamespace+".queryMesssageToDBCorporal", parBean);
	}


}
