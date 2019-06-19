package com.deppon.dpm.module.management.server.service;

/**
 * @author 
 * 接口
 *
 */
public interface IReportHistoryService {
    /**
     * @param userId 工号
     * @return 查询信息
     */
    public String queryReportHistory(String userId);
}
