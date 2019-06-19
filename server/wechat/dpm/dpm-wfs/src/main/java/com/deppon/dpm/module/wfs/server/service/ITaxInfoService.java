package com.deppon.dpm.module.wfs.server.service;

import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;

public interface ITaxInfoService {
    /**
     * 保存工作流的印花税务信息
     * @param taxinfo
     * @throws Exception
     */
    public void insert(TaxInfoEntity taxinfo) throws Exception;
    
    /**
     * 获取工作流保存的税务信息
     * @param busino
     * @param processinstid
     * @return
     * @throws Exception
     */
    public TaxInfoEntity getWorkFlowTaxinfo(String busino)throws Exception;
}
