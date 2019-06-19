package com.deppon.dpm.module.projecttools.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.projecttools.server.dao.IDppmResourcesPlanDao;
import com.deppon.dpm.module.projecttools.server.service.IDepponCalendarService;
import com.deppon.dpm.module.projecttools.server.service.IDppmResourcesPlanService;
import com.deppon.dpm.module.projecttools.shared.domain.DppmResourcesAllDeptEntity;
import com.deppon.dpm.module.projecttools.shared.domain.DppmResourcesDeptEntity;
import com.deppon.dpm.module.projecttools.shared.domain.DppmResourcesPeoEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 资源计划Service
 * @author 251624
 *
 */
public class DppmResourcesPlanService implements IDppmResourcesPlanService {

    private IDppmResourcesPlanDao dppmResourcesPlanDao;
    private IDepponCalendarService depponCalendarService;
    /**
     * 资源计划-部门人员占比
     * @param userId
     * @param date
     * @return
     * @throws BusinessException
     */
    @Override
    public Map<String,Object> getDeptPeopleInfo(String userId, String date)
            throws BusinessException {
        
        Map<String,Object> retMap = new HashMap<String,Object>();
        
       //判断员工有没有之部门或者是不是部门负责人
        //String[] d = date.split("-");
       int subDepeCon = dppmResourcesPlanDao.getSubDeptCount(userId);
        if (subDepeCon == 0 || subDepeCon == 1) {
            /**
             * 0: 普通员工 没有参与部门管理 1: 部门管理人 但没有子部门 查询的是员工所属部门的人员的工作信息
             */
            List<DppmResourcesPeoEntity> listRet = new ArrayList<DppmResourcesPeoEntity>();
            List<DppmResourcesPeoEntity> list = dppmResourcesPlanDao.getPeoResourcesInfo(userId, date);
            if (list != null && !list.isEmpty()) {
                DppmResourcesPeoEntity info = null;
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    DppmResourcesPeoEntity peoInfo = list.get(i);
                    
                    //员工的当月日程信息
//                    int cal = getMouthWorkTime(peoInfo.getEmpCode(),d[0],d[1]);
//                    peoInfo.setMouthTaskTime(cal * 10);
                    /**
                     * 1 项目类任务
                     * 2 事务类任务
                     * 3 需求类任务
                     * 4 常规类任务
                     */
                    //抽取方法
                    info = setPeoInfo(listRet, info, len, i, peoInfo);
                }
            }
            
            //员工所属部门信息
            DppmResourcesDeptEntity deptInfo= dppmResourcesPlanDao.getDeptStaInfoByUser(userId,date);
            
            //当月日程信息
            retMap.put("code", 0);
            //按部门的人员进行显示
            retMap.put("showType", 0);
            retMap.put("allResInfo", deptInfo);
            retMap.put("resPlan", listRet);
            return retMap;
        }else if(subDepeCon > 1){
           /**
            * 员工属于部门管理者,有子部门
            * 查询的是员工所有的子部门的信息
            */
           
           List<DppmResourcesDeptEntity> list = dppmResourcesPlanDao.getDeptResourcesInfo(userId, date);
           if(list == null){
               list = new ArrayList<DppmResourcesDeptEntity>();
           }
           int len = list.size();
           
           DppmResourcesAllDeptEntity allDept = new DppmResourcesAllDeptEntity();
           
           //多级部门时，计算部门的人数时，把子部门中的管理，在项目，非项目的人进行相
           //加计算;
           //多级部门时，计算部门工时时，把所有子部门的任务工时分类(项目类，事务类
           //需求类，常规类)进行相加操作;
           for(int i = 0; i < len; i++){
               DppmResourcesDeptEntity info = list.get(i);
               allDept.setAllPeo(allDept.getAllPeo() + info.getDeptAllPeo());
               allDept.setAllPoint(allDept.getAllPoint() + info.getDeptAllPoint());
               allDept.setAllTaskTime(allDept.getAllTaskTime() + info.getDeptAllTaskTime());
               
               allDept.setMangerPeo(allDept.getMangerPeo() + info.getDeptMangerPeo());
               allDept.setmProPeo(allDept.getmProPeo() + info.getDeptMProPeo());
               allDept.setNomProPeo(allDept.getNomProPeo() + info.getDeptNomProPeo());
               
               allDept.setProPoint(allDept.getProPoint() + info.getDeptProPoint());
               allDept.setProTasktime(allDept.getProTasktime() + info.getDeptProTasktime());
               
               allDept.setDemPoint(allDept.getDemPoint() + info.getDeptDemPoint());
               allDept.setDemTasktime(allDept.getDemTasktime() + info.getDeptDemTasktime());

               allDept.setTranPoint(allDept.getTranPoint() + info.getDeptTranPoint());
               allDept.setTranTasktime(allDept.getTranTasktime() + info.getDeptTranTasktime());
               
               allDept.setRoutinePoint(allDept.getRoutinePoint() + info.getDeptRoutinePoint());
               allDept.setRoutineTasktime(allDept.getRoutineTasktime() + info.getDeptRoutineTasktime());
               
               allDept.setSalaryAll(allDept.getSalaryAll() + info.getDeptSalaryAll());
               allDept.setSalarym(allDept.getSalarym() + info.getDeptSalarym());
               allDept.setSalarymPro(allDept.getSalarymPro() + info.getDeptSalarymPro());
               allDept.setSalaryNom(allDept.getSalaryNom() + info.getDeptSalaryNom());
               allDept.setSalaryNomPro(allDept.getSalaryNomPro() + info.getDeptSalaryNomPro());
           }
           
           retMap.put("code", 0);
           //按部门的子部门显示
           retMap.put("showType", 1);
           retMap.put("allResInfo", allDept);
           retMap.put("resPlan", list);
          
           return  retMap;
       }
       
       retMap.put("code", 1);
       return retMap;
    }

	private DppmResourcesPeoEntity setPeoInfo(
			List<DppmResourcesPeoEntity> listRet, DppmResourcesPeoEntity info,
			int len, int i, DppmResourcesPeoEntity peoInfo) {
		if (i == 0) {
		    info = peoInfo;
		    if (len == 1) {// 只有一条
		        if ("1".equals(peoInfo.getTaskCategory())) {
		            peoInfo.setPeoProTasktime(peoInfo.getTaskDuration());
		            peoInfo.setPeoProPoint(peoInfo.getTaskPoint());
		        } else if ("2".equals(peoInfo.getTaskCategory())) {
		            peoInfo.setPeoTranTasktime(peoInfo.getTaskDuration());
		            peoInfo.setPeoTranPoint(peoInfo.getTaskPoint());
		        } else if ("3".equals(peoInfo.getTaskCategory())) {
		            peoInfo.setPeoDemTasktime(peoInfo.getTaskDuration());
		            peoInfo.setPeoDemPoint(peoInfo.getTaskPoint());
		        } else if ("4".equals(peoInfo.getTaskCategory())) {
		            peoInfo.setPeoRoutineTasktime(peoInfo.getTaskDuration());
		            peoInfo.setPeoRoutinePoint( peoInfo.getTaskPoint());
		        }
		        listRet.add(peoInfo);
		    }
		    return info;
		}
		if (info.getEmpCode().equals(peoInfo.getEmpCode())) {
		    if ("1".equals(peoInfo.getTaskCategory())) {
		        info.setPeoProTasktime(info.getPeoProTasktime()
		                + peoInfo.getTaskDuration());
		        info.setPeoProPoint(info.getPeoProPoint()
		                + peoInfo.getTaskPoint());
		    } else if ("2".equals(peoInfo.getTaskCategory())) {
		        info.setPeoTranTasktime(info.getPeoTranTasktime()
		                + peoInfo.getTaskDuration());
		        info.setPeoTranPoint(info.getPeoTranPoint()
		                + peoInfo.getTaskPoint());
		    } else if ("3".equals(peoInfo.getTaskCategory())) {
		        info.setPeoDemTasktime(info.getPeoDemTasktime()
		                + peoInfo.getTaskDuration());
		        info.setPeoDemPoint(info.getPeoDemPoint()
		                + peoInfo.getTaskPoint());
		    } else if ("4".equals(peoInfo.getTaskCategory())) {
		        info.setPeoRoutineTasktime(info
		                .getPeoRoutineTasktime()
		                + peoInfo.getTaskDuration());
		        info.setPeoRoutinePoint(info.getPeoRoutinePoint()
		                + peoInfo.getTaskPoint());
		    }

		    // 最后一条
		    if (i == len - 1) {
		        listRet.add(info);
		    }
		} else {
		    if ("1".equals(info.getTaskCategory())) {
		        info.setPeoProTasktime(info.getTaskDuration());
		        info.setPeoProPoint(info.getTaskPoint());
		    } else if ("2".equals(info.getTaskCategory())) {
		        info.setPeoTranTasktime(info.getTaskDuration());
		        info.setPeoTranPoint(info.getTaskPoint());
		    } else if ("3".equals(info.getTaskCategory())) {
		        info.setPeoDemTasktime(info.getTaskDuration());
		        info.setPeoDemPoint(info.getTaskPoint());
		    } else if ("4".equals(info.getTaskCategory())) {
		        info.setPeoRoutineTasktime(info.getTaskDuration());
		        info.setPeoRoutinePoint( info.getTaskPoint());
		    }
		    
		    listRet.add(info);
		    info = peoInfo;
		    // 最后一条
		    if (i == len - 1) {
		        listRet.add(info);
		    }
		}
		return info;
	}
    
    /**
     * 获取月排班日程工时
     * @return
     */
	public static final int NUMBER_OF_THIRTYONE = 31;

    public int getMouthWorkTime(String userId,String year,String month){
        //出勤天数
        int workDay = 0;
        try {
            //调用接口获取当前工号人员的当月考勤信息
            Result<JSONObject> result = depponCalendarService.getCalendarPlan(userId, year, month);
            if(result.getErrorCode() == 0){
                JSONArray jsonArr = result.getData().getJSONArray("scheduleInfoEntity");
               if(jsonArr != null && !jsonArr.isEmpty()){
                   JSONObject jsonObj = jsonArr.getJSONObject(0);
                   //抽取方法
                   workDay = setWorkDayValue(workDay, jsonObj);
                   
                   return workDay;
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workDay;
    }

	private int setWorkDayValue(int workDay, JSONObject jsonObj) {
		for(int i = 1; i<=NUMBER_OF_THIRTYONE; i++){
		       if(jsonObj.containsKey("day" + i)){
		           //计算出勤天数
		           if("标".equals(jsonObj.get("day" + i))){
		               workDay++;
		           }
		       }
		   }
		return workDay;
	}
    public void setDppmResourcesPlanDao(IDppmResourcesPlanDao dppmResourcesPlanDao) {
        this.dppmResourcesPlanDao = dppmResourcesPlanDao;
    }

    public void setDepponCalendarService(
            IDepponCalendarService depponCalendarService) {
        this.depponCalendarService = depponCalendarService;
    }

}
