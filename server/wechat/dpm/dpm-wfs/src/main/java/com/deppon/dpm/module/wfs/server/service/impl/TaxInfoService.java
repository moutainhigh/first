package com.deppon.dpm.module.wfs.server.service.impl;

import com.deppon.dpm.module.wfs.server.dao.ITaxInfoDao;
import com.deppon.dpm.module.wfs.server.service.ITaxInfoService;
import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;

public class TaxInfoService implements ITaxInfoService {
    private ITaxInfoDao taxInfoDao;
    
    @Override
    public void insert(TaxInfoEntity taxinfo) throws Exception {
        taxInfoDao.insert(taxinfo);
    }

    @Override
    public TaxInfoEntity getWorkFlowTaxinfo(String busino) throws Exception {
        return taxInfoDao.getWorkFlowTaxinfo(busino);
    }

    public void setTaxInfoDao(ITaxInfoDao taxInfoDao) {
        this.taxInfoDao = taxInfoDao;
    }
    
    
}
