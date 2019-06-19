package com.deppon.montal.module.notice.service;

import java.util.List;

import com.deppon.montal.model.MonthLayoutEntity;
import com.deppon.montal.model.MonthPaperEntity;
public interface IMonthPlayoutService {
	/**
	 * 板块数据查询
	 * @return
	 */
    public List<MonthLayoutEntity> queryMonthPlayoutList(int pid);
    public List<MonthPaperEntity> queryMonthPaperList(int layoutid,int pageNum,int pageSize);
}
