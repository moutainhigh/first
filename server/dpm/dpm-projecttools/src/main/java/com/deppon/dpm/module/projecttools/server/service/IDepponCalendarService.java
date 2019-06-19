package com.deppon.dpm.module.projecttools.server.service;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.foss.framework.exception.BusinessException;

public interface IDepponCalendarService {
    /**
     * 获取日程排班信息
     * @param userId
     * @param year
     * @param month
     * @return
     * @throws BusinessException
     */
    public Result<JSONObject> getCalendarPlan(String userId, String year, String month) throws BusinessException;
}
