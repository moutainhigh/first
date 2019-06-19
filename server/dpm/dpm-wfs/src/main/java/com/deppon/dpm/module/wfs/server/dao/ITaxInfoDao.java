package com.deppon.dpm.module.wfs.server.dao;

import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;

public interface ITaxInfoDao {
    /**
     * 保存工作流的印花税务信息
     * @param taxinfo
     * @throws Exception
     */
    public void insert(TaxInfoEntity taxinfo) ;
    
    /**
     * 获取工作流保存的税务信息
     * @param busino
     * @param processinstid
     * @return
     * @throws Exception
     */
    public TaxInfoEntity getWorkFlowTaxinfo(String busino);
}
