package com.deppon.dpm.module.wfs.server.dao.impl;

import com.deppon.dpm.module.wfs.server.dao.ITaxInfoDao;
import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class TaxInfoDao  extends iBatis3DaoImpl implements ITaxInfoDao {
    private static String nameSpace = "com.deppon.dpm.module.wfs.server.dao.workitems.";
    
    /**
     * 保存工作流的印花税务信息
     * @param taxinfo
     * @throws Exception
     */
    @Override
    public void insert(TaxInfoEntity taxinfo) throws Exception {
        this.getSqlSession().insert(nameSpace + "insertTaxInfo", taxinfo);
    }

    /**
     * 获取工作流保存的税务信息
     * @param busino
     * @param processinstid
     * @return
     * @throws Exception
     */
    @Override
    public TaxInfoEntity getWorkFlowTaxinfo(String busino)
            throws Exception {
        return (TaxInfoEntity)this.getSqlSession().selectOne(nameSpace  + "selectTaxinfo", busino);
    }
}
