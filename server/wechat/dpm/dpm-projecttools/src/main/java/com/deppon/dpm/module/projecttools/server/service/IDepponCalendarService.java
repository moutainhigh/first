package com.deppon.dpm.module.projecttools.server.service;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.shared.vo.Result;

public interface IDepponCalendarService {
    /**
     * 获取日程排班信息
     * @param userId
     * @param year
     * @param month
     * @return
     * @throws Exception
     */
    public Result<JSONObject> getCalendarPlan(String userId, String year, String month) throws Exception;
}
