package com.deppon.dpm.module.projecttools.shared.domain;

import java.io.Serializable;

public class DppmResourcesPeoEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**工号**/
    private String empCode;
    /**名称**/
    private String empName;
    /**人员级别**/
    private String empLevel;
    /**任务类别**/
    private String taskCategory;
    /**是否在项目**/
    private int inProject;
    /**任务工时**/
    private Long taskDuration;
    /**任务功能点**/
    private int taskPoint;
    /**项目任务工时**/
    private Long peoProTasktime = 0l;
    /**需求任务工时**/
    private Long peoDemTasktime = 0l;
    /**事务任务工时**/
    private Long peoTranTasktime = 0l;
    /**常规任务工时**/
    private Long peoRoutineTasktime = 0l;
    /**任务总工时**/
    private Long peoAllTaskTime = 0l;
    /**项目任务功能点**/
    private int peoProPoint = 0;
    /**需求任务功能点**/
    private int peoDemPoint = 0;
    /**事务任务功能点**/
    private int peoTranPoint = 0;
    /**常规任务功能点**/
    private int peoRoutinePoint = 0;
    /**任务总功能点**/
    private int peoAllPoint = 0;
    /**当月的任务总工时**/
    private int mouthTaskTime = 0;
    /**
     * 
     * 2015-12-21
     * @return
     */
    public String getEmpCode() {
        return empCode;
    }
    /**
     * 
     * 2015-12-21
     * @param empCode
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public String getEmpName() {
        return empName;
    }
    /**
     * 
     * 2015-12-21
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public String getEmpLevel() {
        return empLevel;
    }
    /**
     * 
     * 2015-12-21
     * @param empLevel
     */
    public void setEmpLevel(String empLevel) {
        this.empLevel = empLevel;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public String getTaskCategory() {
        return taskCategory;
    }
    /**
     * 
     * 2015-12-21
     * @param taskCategory
     */
    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getInProject() {
        return inProject;
    }
    /**
     * 
     * 2015-12-21
     * @param inProject
     */
    public void setInProject(int inProject) {
        this.inProject = inProject;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getTaskDuration() {
        return taskDuration;
    }
    /**
     * 
     * 2015-12-21
     * @param taskDuration
     */
    public void setTaskDuration(Long taskDuration) {
        this.taskDuration = taskDuration;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getTaskPoint() {
        return taskPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param taskPoint
     */
    public void setTaskPoint(int taskPoint) {
        this.taskPoint = taskPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getPeoProTasktime() {
        return peoProTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param peoProTasktime
     */
    public void setPeoProTasktime(Long peoProTasktime) {
        this.peoProTasktime = peoProTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getPeoDemTasktime() {
        return peoDemTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param peoDemTasktime
     */
    public void setPeoDemTasktime(Long peoDemTasktime) {
        this.peoDemTasktime = peoDemTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getPeoTranTasktime() {
        return peoTranTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param peoTranTasktime
     */
    public void setPeoTranTasktime(Long peoTranTasktime) {
        this.peoTranTasktime = peoTranTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getPeoRoutineTasktime() {
        return peoRoutineTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param peoRoutineTasktime
     */
    public void setPeoRoutineTasktime(Long peoRoutineTasktime) {
        this.peoRoutineTasktime = peoRoutineTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getPeoAllTaskTime() {
        return peoAllTaskTime == 0 ? (peoProTasktime + peoDemTasktime
                + peoTranTasktime + peoRoutineTasktime) : peoAllTaskTime;
    }
    /**
     * 
     * 2015-12-21
     * @param peoAllTaskTime
     */
    public void setPeoAllTaskTime(Long peoAllTaskTime) {
        this.peoAllTaskTime = peoAllTaskTime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getPeoProPoint() {
        return peoProPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param peoProPoint
     */
    public void setPeoProPoint(int peoProPoint) {
        this.peoProPoint = peoProPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getPeoDemPoint() {
        return peoDemPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param peoDemPoint
     */
    public void setPeoDemPoint(int peoDemPoint) {
        this.peoDemPoint = peoDemPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getPeoTranPoint() {
        return peoTranPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param peoTranPoint
     */
    public void setPeoTranPoint(int peoTranPoint) {
        this.peoTranPoint = peoTranPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getPeoRoutinePoint() {
        return peoRoutinePoint;
    }
    /**
     * 
     * 2015-12-21
     * @param peoRoutinePoint
     */
    public void setPeoRoutinePoint(int peoRoutinePoint) {
        this.peoRoutinePoint = peoRoutinePoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getPeoAllPoint() {
        return peoAllPoint == 0 ? (peoProPoint + peoDemPoint + peoTranPoint + peoRoutinePoint)
                : peoAllPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param peoAllPoint
     */
    public void setPeoAllPoint(int peoAllPoint) {
        this.peoAllPoint = peoAllPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getMouthTaskTime() {
        return mouthTaskTime;
    }
    /**
     * 
     * 2015-12-21
     * @param mouthTaskTime
     */
    public void setMouthTaskTime(int mouthTaskTime) {
        this.mouthTaskTime = mouthTaskTime;
    }
}
