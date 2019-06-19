package com.deppon.montal.module.notice.service;

import java.util.List;

import com.deppon.montal.model.MonthPaperEntity;

public interface IMonthPaperService {
	/**
	 * 月报数据查询(最新10条)
	 * @return
	 */
    public List<MonthPaperEntity> queryMonthPaperList(int pid,int pageNum,int pageSize);
    /**
   	 * 月报数据查询（根据id查询详细月报消息）
   	 * @param id
   	 * @return
   	 */
    public MonthPaperEntity queryMonthPaperInformation(int id);
    /**
     * 获取最新的一条带有图片的文章
     * @param pid
     * @return
     */
    public List<MonthPaperEntity> queryMonthPaperPicList(int pid);
}
