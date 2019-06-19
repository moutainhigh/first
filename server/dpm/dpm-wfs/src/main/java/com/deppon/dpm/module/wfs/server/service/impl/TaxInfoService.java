package com.deppon.dpm.module.wfs.server.service.impl;

import com.deppon.dpm.module.wfs.server.dao.ITaxInfoDao;
import com.deppon.dpm.module.wfs.server.service.ITaxInfoService;
import com.deppon.dpm.module.wfs.shared.domain.TaxInfoEntity;

public class TaxInfoService implements ITaxInfoService {
    private ITaxInfoDao taxInfoDao;
    
    @Override
    public void insert(TaxInfoEntity taxinfo)  {
        try {
			taxInfoDao.insert(taxinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public TaxInfoEntity getWorkFlowTaxinfo(String busino)  {
    	TaxInfoEntity taxInfoEntity=null;
        try {
        	taxInfoEntity=taxInfoDao.getWorkFlowTaxinfo(busino);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return taxInfoEntity;
    }

    public void setTaxInfoDao(ITaxInfoDao taxInfoDao) {
        this.taxInfoDao = taxInfoDao;
    }
    
    
}
