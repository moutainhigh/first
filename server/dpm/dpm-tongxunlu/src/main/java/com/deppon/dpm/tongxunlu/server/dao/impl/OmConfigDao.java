///**
// * Project Name:dpm-tongxunlu
// * File Name:OmConfigDao.java
// * Package Name:com.deppon.dpm.tongxunlu.server.dao
// * Date:2014-8-8下午3:11:14
// * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
// *
//*/
//
//package com.deppon.dpm.tongxunlu.server.dao.impl;
//
//import java.util.List;
//
//import org.apache.ibatis.session.RowBounds;
//
//import com.deppon.dpm.tongxunlu.server.dao.IOmConfigDao;
//import com.deppon.dpm.tongxunlu.shared.domain.OmConfigEntity;
//import com.deppon.dpm.tongxunlu.shared.dto.OmConfigQueryDto;
//import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
//
///**
// * ClassName:OmConfigDao <br/>
// * Function: TODO ADD FUNCTION. <br/>
// * 
// * Date:     2014-8-8 下午3:11:14 <br/>
// * @author   157229-zxy
// * @version  
// * @since    JDK 1.6
// */
//public class OmConfigDao extends iBatis3DaoImpl implements IOmConfigDao {
//		
//	//命名空间
//	private String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.omConfig.";
//	//查询最新的同步记录
//	private String QUERY_OMCONFIGENTITY_BY_ENTITY = "queryOmConfigEntityByEntity";
//	
//	
//	@Override
//	public List<OmConfigEntity> queryOmConfigEntityByEntity(OmConfigQueryDto omConfigEntity, int offset, int limit) {
//		if(limit == -1)
//			return (List<OmConfigEntity>) this.getSqlSession().selectList(NAMESPACE + QUERY_OMCONFIGENTITY_BY_ENTITY,omConfigEntity);
//		else{
//			RowBounds rb = new RowBounds(offset, limit);
//			return (List<OmConfigEntity>) this.getSqlSession().selectList(NAMESPACE + QUERY_OMCONFIGENTITY_BY_ENTITY,omConfigEntity,rb);
//		}
//	}
//}
//
