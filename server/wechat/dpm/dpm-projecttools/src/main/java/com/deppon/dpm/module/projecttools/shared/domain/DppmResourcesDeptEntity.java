package com.deppon.dpm.module.projecttools.shared.domain;

import java.io.Serializable;

/**
 * 部门人员占比 和 任务工时
 * @author 251624
 *
 */
public class DppmResourcesDeptEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**部门ID**/
    private String deptId;
    /**部门标杆编码**/
    private String deptBenchmarkCode;
    /**部门名称**/
    private String deptName;
    /**部门所有人**/
    private int deptAllPeo=0;
    /**部门管理人数**/
    private int deptMangerPeo=0;
    /**部门管理在项目人数**/
    private int deptMProPeo=0;
    /**部门非管理在项目人数**/
    private int deptNomProPeo=0;
    /**部门项目任务工时**/
    private Long deptProTasktime=0l;
    /**部门需求任务工时**/
    private Long deptDemTasktime=0l;
    /**部门事务任务工时**/
    private Long deptTranTasktime=0l;
    /**部门常规任务工时**/
    private Long deptRoutineTasktime=0l;
    /**部门所有任务工时**/
    private Long deptAllTaskTime = 0l;
    /**部门项目任务功能点**/
    private int deptProPoint=0;
    /**部门需求任务功能点**/
    private int deptDemPoint=0;
    /**部门事务任务功能点**/
    private int deptTranPoint=0;
    /**部门常规任务功能点**/
    private int deptRoutinePoint=0;
    /**部门所有任务工时**/
    private int deptAllPoint = 0;
    /**部门总成本*/
    private Long deptSalaryAll = 0l;
    /**部门管理成本*/
    private Long deptSalarym = 0l;
    /**部门管理在项目成本*/
    private Long deptSalarymPro = 0l;
    /**部门管理成本*/
    private Long deptSalaryNom = 0l;
    /**部门管理在项目成本*/
    private Long deptSalaryNomPro = 0l;
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getDeptSalaryAll() {
        return deptSalaryAll;
    }
    /**
     * 
     * 2015-12-22
     * @param deptSalaryAll
     */
    public void setDeptSalaryAll(Long deptSalaryAll) {
        this.deptSalaryAll = deptSalaryAll;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getDeptSalarym() {
        return deptSalarym;
    }
    /**
     * 
     * 2015-12-22
     * @param deptSalarym
     */
    public void setDeptSalarym(Long deptSalarym) {
        this.deptSalarym = deptSalarym;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getDeptSalarymPro() {
        return deptSalarymPro;
    }
    /**
     * 
     * 2015-12-22
     * @param deptSalarymPro
     */
    public void setDeptSalarymPro(Long deptSalarymPro) {
        this.deptSalarymPro = deptSalarymPro;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getDeptSalaryNom() {
        return deptSalaryNom;
    }
    /**
     * 
     * 2015-12-22
     * @param deptSalaryNom
     */
    public void setDeptSalaryNom(Long deptSalaryNom) {
        this.deptSalaryNom = deptSalaryNom;
    }
    /**
     * 
     * 2015-12-22
     * @return
     */
    public Long getDeptSalaryNomPro() {
        return deptSalaryNomPro;
    }
    /**
     * 
     * 2015-12-22
     * @param deptSalaryNomPro
     */
    public void setDeptSalaryNomPro(Long deptSalaryNomPro) {
        this.deptSalaryNomPro = deptSalaryNomPro;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public String getDeptId() {
        return deptId;
    }
    /**
     * 
     * 2015-12-21
     * @param deptId
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public String getDeptBenchmarkCode() {
        return deptBenchmarkCode;
    }
    /**
     * 
     * 2015-12-21
     * @param deptBenchmarkCode
     */
    public void setDeptBenchmarkCode(String deptBenchmarkCode) {
        this.deptBenchmarkCode = deptBenchmarkCode;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public String getDeptName() {
        return deptName;
    }
    /**
     * 
     * 2015-12-21
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptAllPeo() {
        return deptAllPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param deptAllPeo
     */
    public void setDeptAllPeo(int deptAllPeo) {
        this.deptAllPeo = deptAllPeo;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptMangerPeo() {
        return deptMangerPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param deptMangerPeo
     */
    public void setDeptMangerPeo(int deptMangerPeo) {
        this.deptMangerPeo = deptMangerPeo;
    }
    /**
    * 
    * 2015-12-21
    * @return
    */
    public int getDeptMProPeo() {
        return deptMProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param deptMProPeo
     */
    public void setDeptMProPeo(int deptMProPeo) {
        this.deptMProPeo = deptMProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptNomProPeo() {
        return deptNomProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @param deptNomProPeo
     */
    public void setDeptNomProPeo(int deptNomProPeo) {
        this.deptNomProPeo = deptNomProPeo;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getDeptProTasktime() {
        return deptProTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param deptProTasktime
     */
    public void setDeptProTasktime(Long deptProTasktime) {
        this.deptProTasktime = deptProTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getDeptDemTasktime() {
        return deptDemTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param deptDemTasktime
     */
    public void setDeptDemTasktime(Long deptDemTasktime) {
        this.deptDemTasktime = deptDemTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getDeptTranTasktime() {
        return deptTranTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param deptTranTasktime
     */
    public void setDeptTranTasktime(Long deptTranTasktime) {
        this.deptTranTasktime = deptTranTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getDeptRoutineTasktime() {
        return deptRoutineTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @param deptRoutineTasktime
     */
    public void setDeptRoutineTasktime(Long deptRoutineTasktime) {
        this.deptRoutineTasktime = deptRoutineTasktime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public Long getDeptAllTaskTime() {
        return this.deptAllTaskTime == 0l ? (deptProTasktime + deptDemTasktime
                + deptTranTasktime + deptRoutineTasktime)
                : this.deptAllTaskTime;
    }
    /**
     * 
     * 2015-12-21
     * @param deptAllTaskTime
     */
    public void setDeptAllTaskTime(Long deptAllTaskTime) {
        this.deptAllTaskTime = deptAllTaskTime;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptProPoint() {
        return deptProPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param deptProPoint
     */
    public void setDeptProPoint(int deptProPoint) {
        this.deptProPoint = deptProPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptDemPoint() {
        return deptDemPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param deptDemPoint
     */
    public void setDeptDemPoint(int deptDemPoint) {
        this.deptDemPoint = deptDemPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptTranPoint() {
        return deptTranPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param deptTranPoint
     */
    public void setDeptTranPoint(int deptTranPoint) {
        this.deptTranPoint = deptTranPoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptRoutinePoint() {
        return deptRoutinePoint;
    }
    /**
     * 
     * 2015-12-21
     * @param deptRoutinePoint
     */
    public void setDeptRoutinePoint(int deptRoutinePoint) {
        this.deptRoutinePoint = deptRoutinePoint;
    }
    /**
     * 
     * 2015-12-21
     * @return
     */
    public int getDeptAllPoint() {
        return this.deptAllPoint == 0 ? (deptProPoint + deptDemPoint
                + deptTranPoint + deptRoutinePoint) : this.deptAllPoint;
    }
    /**
     * 
     * 2015-12-21
     * @param deptAllPoint
     */
    public void setDeptAllPoint(int deptAllPoint) {
        this.deptAllPoint = deptAllPoint;
    }
    
}
