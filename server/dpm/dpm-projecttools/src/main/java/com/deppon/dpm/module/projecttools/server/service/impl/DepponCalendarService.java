package com.deppon.dpm.module.projecttools.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.module.projecttools.server.service.IDepponCalendarService;

public class DepponCalendarService implements IDepponCalendarService{
    private static Logger logger = LoggerFactory.getLogger(DepponCalendarService.class);
    
    //地址
    private String calendarPlanPath;
    
    //ESB CODE
    private String calendarEsbCode;
    
    /**
     * 获取日程排班信息
     * @param userId
     * @param year
     * @param month
     * @return
     * @throws Exception
     */
    public Result<JSONObject> getCalendarPlan(String userId, String year, String month) {
        // 返回结果集定义
        Result<JSONObject> result = new Result<JSONObject>();
        // 用以参数拼接
        Map<String, String> map = new HashMap<String, String>();
        try {
            // 工号
            map.put("empCode", userId);
            // 年份
            map.put("year", year);
            // 月份
            map.put("month", month);
            // log
            JSONObject paramJson = JsonUtil.mapToJsonObject(map);
            logger.info("日程排班插入参数:" + paramJson);
            // http请求，数据返回
            String data = HttpUtil.httpClient(paramJson,
                    calendarPlanPath, calendarEsbCode);
            // log
            logger.info("日程排班获取值:" + data);
            
            // json-->object
            JSONObject object = JSON.parseObject(data);
            // count
            result.setCount(Constants.ACTION_RESULT_SUC);
            // errorCode
            result.setErrorCode(Constants.SUCCESS);
            // errorMessage
            result.setErrorMessage("");
            // 返回日程排班日期
            result.setData(object);
        } catch (Exception e) {
            // count
            result.setCount(Constants.ACTION_RESULT_ERROR);
            // errorCode
            result.setErrorCode(Constants.WRONG_REQUEST);
            // errorMessage
            result.setErrorMessage("获取数据出错,请稍后再试");
            // data
            result.setData(null);
            // 错误打印
            e.printStackTrace();
        }
        
        return result;
    }

    public void setCalendarPlanPath(String calendarPlanPath) {
        this.calendarPlanPath = calendarPlanPath;
    }

    public void setCalendarEsbCode(String calendarEsbCode) {
        this.calendarEsbCode = calendarEsbCode;
    }
}
