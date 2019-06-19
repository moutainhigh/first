package com.deppon.dpm.module.projecttools.shared.domain;

import java.io.Serializable;

/**
 * 部门人员占比 和 任务工时
 * @author 251624
 *
 */
public class DppmResourcesAllDeptEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**所有人**/
    private int allPeo=0;
    /**管理人数**/
    private int mangerPeo=0;
    /**管理在项目人数**/
    private int mProPeo=0;
    /**非管理在项目人数**/
    private int nomProPeo=0;
    /**项目任务工时**/
    private Long proTasktime=0l;
    /**需求任务工时**/
    private Long demTasktime=0l;
    /**事务任务工时**/
    private Long tranTasktime=0l;
    /**常规任务工时**/
    private Long routineTasktime=0l;
    /**所有任务工时**/
    private Long allTaskTime = 0l;
    /**项目任务功能点**/
    private int proPoint=0;
    /**需求任务功能点**/
    private int demPoint=0;
    /**事务任务功能点**/
    private int tranPoint=0;
    /**常规任务功能点**/
    private int routinePoint=0;
    /**所有任务工时**/
    private int allPoint = 0;
    /**部门总成本*/
    private Long salaryAll = 0l;
    /**部门管理成本*/
    private Long salarym = 0l;
    /**部门管理在项目成本*/
    private Long salarymPro = 0l;
    /**部门非管理成本*/
    private Long salaryNom = 0l;
    /**部门非管理在项目成本*/
    private Long salaryNomPro = 0l;
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getSalaryAll() {
        return salaryAll;
    }
    /**
     * 
     * 2015-12-22
     * @param salaryAll
     */
    public void setSalaryAll(Long salaryAll) {
        this.salaryAll = salaryAll;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getSalarym() {
        return salarym;
    }
    /**
     * 
     * 2015-12-22
     * @param salarym
     */
    public void setSalarym(Long salarym) {
        this.salarym = salarym;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getSalarymPro() {
        return salarymPro;
    }
    /**
     * 
     * 2015-12-22
     * @param salarymPro
     */
    public void setSalarymPro(Long salarymPro) {
        this.salarymPro = salarymPro;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getSalaryNom() {
        return salaryNom;
    }
    /**
     * 
     * 2015-12-22
     * @param salaryNom
     */
    public void setSalaryNom(Long salaryNom) {
        this.salaryNom = salaryNom;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getSalaryNomPro() {
        return salaryNomPro;
    }
    /**
     * 
     * 2015-12-22
     * @param salaryNomPro
     */
    public void setSalaryNomPro(Long salaryNomPro) {
        this.salaryNomPro = salaryNomPro;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getAllPeo() {
        return allPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param allPeo
     */
    public void setAllPeo(int allPeo) {
        this.allPeo = allPeo;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getMangerPeo() {
        return mangerPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param mangerPeo
     */
    public void setMangerPeo(int mangerPeo) {
        this.mangerPeo = mangerPeo;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getmProPeo() {
        return mProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param mProPeo
     */
    public void setmProPeo(int mProPeo) {
        this.mProPeo = mProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getNomProPeo() {
        return nomProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param nomProPeo
     */
    public void setNomProPeo(int nomProPeo) {
        this.nomProPeo = nomProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getProTasktime() {
        return proTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param proTasktime
     */
    public void setProTasktime(Long proTasktime) {
        this.proTasktime = proTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getDemTasktime() {
        return demTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param demTasktime
     */
    public void setDemTasktime(Long demTasktime) {
        this.demTasktime = demTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getTranTasktime() {
        return tranTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param tranTasktime
     */
    public void setTranTasktime(Long tranTasktime) {
        this.tranTasktime = tranTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getRoutineTasktime() {
        return routineTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param routineTasktime
     */
    public void setRoutineTasktime(Long routineTasktime) {
        this.routineTasktime = routineTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getAllTaskTime() {
        return allTaskTime == 0l ? (proTasktime + demTasktime + tranTasktime + routineTasktime)
                : allTaskTime;
    }
    /**
     * 
     * 2015-12-21
     * @param allTaskTime
     */
    public void setAllTaskTime(Long allTaskTime) {
        this.allTaskTime = allTaskTime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getProPoint() {
        return proPoint;
    }
    /**
     * 2015-12-21
     * @param proPoint
     */
    public void setProPoint(int proPoint) {
        this.proPoint = proPoint;
    }
    /**
     * 2015-12-21
     * @return
     */
    public int getDemPoint() {
        return demPoint;
    }
    /**
     * 2015-12-21
     * @param demPoint
     */
    public void setDemPoint(int demPoint) {
        this.demPoint = demPoint;
    }
    /**
     * 2015-12-21
     * @return
     */
    public int getTranPoint() {
        return tranPoint;
    }
    /**
     * 2015-12-21
     * @param tranPoint
     */
    public void setTranPoint(int tranPoint) {
        this.tranPoint = tranPoint;
    }
    /**
     * 2015-12-21
     * @return
     */
    public int getRoutinePoint() {
        return routinePoint;
    }
    /**
     * 2015-12-21
     * @param routinePoint
     */
    public void setRoutinePoint(int routinePoint) {
        this.routinePoint = routinePoint;
    }
   
    /**
     * 2015-12-21
     * @param allPoint
     */
    public void setAllPoint(int allPoint) {
        this.allPoint = allPoint;
    }
    /**
     * 2015-12-21
     * @return
     */
    public int getAllPoint() {
        return allPoint == 0 ? (proPoint + demPoint + tranPoint + routinePoint) : allPoint;
    }
}
