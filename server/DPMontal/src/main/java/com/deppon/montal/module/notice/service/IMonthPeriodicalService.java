package com.deppon.montal.module.notice.service;

import java.util.List;

import com.deppon.montal.model.MonthPeriodicalEntity;

public interface IMonthPeriodicalService {
	/**
	 * 月报数据查询(最新10条)
	 * @return
	 */
    public List<MonthPeriodicalEntity> queryMonthPeriodicalList(int pageNum,int pageSize);
}
