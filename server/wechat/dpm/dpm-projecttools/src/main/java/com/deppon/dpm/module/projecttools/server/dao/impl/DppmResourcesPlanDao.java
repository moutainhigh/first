package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.projecttools.server.dao.IDppmResourcesPlanDao;
import com.deppon.dpm.module.projecttools.server.util.SqlUtil;
import com.deppon.dpm.module.projecttools.shared.domain.DppmResourcesDeptEntity;
import com.deppon.dpm.module.projecttools.shared.domain.DppmResourcesPeoEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * @author 251624
 *
 */
public class DppmResourcesPlanDao extends iBatis3DaoImpl implements
        IDppmResourcesPlanDao {
    /**获取JDBC连接*/
    JdbcTemplate dppmTemp;
    
    /**
     * 资源计划-部门人员占比和任务工时(有子部门)
     * @param userId
     * @param date
     * @return
     * @throws Exception
     */
    @Override
    public List<DppmResourcesDeptEntity> getDeptResourcesInfo(String userId, String date)
            throws Exception {
        String sql = SqlUtil.getDeptResourcesInfoSql(userId,date);
        List<DppmResourcesDeptEntity> list = dppmTemp.query(sql,new RowMapper<DppmResourcesDeptEntity>(){
            @Override
            public DppmResourcesDeptEntity mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                DppmResourcesDeptEntity drs = new DppmResourcesDeptEntity();
                    drs.setDeptId(rs.getString("deptId"));
                    drs.setDeptBenchmarkCode(rs.getString("deptBenchmarkCode"));
                    drs.setDeptName(rs.getString("deptName"));
                    drs.setDeptAllPeo(rs.getInt("deptAllPeo"));
                    drs.setDeptMangerPeo(rs.getInt("deptMangerPeo"));
                    drs.setDeptMProPeo(rs.getInt("deptMProPeo"));
                    drs.setDeptNomProPeo(rs.getInt("deptNomProPeo"));
                    drs.setDeptProTasktime(rs.getLong("deptProTasktime"));
                    drs.setDeptDemTasktime(rs.getLong("deptDemTasktime"));
                    drs.setDeptTranTasktime(rs.getLong("deptTranTasktime"));
                    drs.setDeptRoutineTasktime(rs.getLong("deptRoutineTasktime"));
                    drs.setDeptProPoint(rs.getInt("deptProPoint"));
                    drs.setDeptDemPoint(rs.getInt("deptDemPoint"));
                    drs.setDeptTranPoint(rs.getInt("deptTranPoint"));
                    drs.setDeptRoutinePoint(rs.getInt("deptRoutinePoint"));
                    drs.setDeptSalaryAll(rs.getLong("deptSalaryAll"));
                    drs.setDeptSalarym(rs.getLong("deptSalarym"));
                    drs.setDeptSalarymPro(rs.getLong("deptSalarymPro"));
                    drs.setDeptSalaryNom(rs.getLong("deptSalaryNom"));
                    drs.setDeptSalaryNomPro(rs.getLong("deptSalaryNomPro"));
                return drs;
            }
        });
        return list;
    }

    /**
     * 资源计划-获取子部门
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public int getSubDeptCount(String userId) throws Exception {
        String sql = SqlUtil.getSubDeptCount(userId);
        int count = dppmTemp.queryForInt(sql);
        return count;
    }

    /**
     * 资源计划-部门人员占比和任务工时(无子部门或普通员工)
     * @param userId
     * @param date
     * @param flag
     * @return
     * @throws Exception
     */
    @Override
    public List<DppmResourcesPeoEntity> getPeoResourcesInfo(String userId,
            String date) throws Exception {
        String sql = SqlUtil.getPeoResourcesInfoSql(userId,date);
        List<DppmResourcesPeoEntity> list = dppmTemp.query(sql, new RowMapper<DppmResourcesPeoEntity>(){

            @Override
            public DppmResourcesPeoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                DppmResourcesPeoEntity res = new DppmResourcesPeoEntity();
                res.setEmpCode(rs.getString("empCode"));
                res.setEmpName(rs.getString("empName"));
                res.setEmpLevel(rs.getString("empLevel"));
                res.setTaskCategory(rs.getString("taskCategory"));
                res.setInProject(rs.getInt("inProject"));
                res.setTaskDuration(rs.getLong("taskDuration"));
                res.setTaskPoint(rs.getInt("taskPoint"));
               return res;
            }
        });
        return list;
    }

    public void setDppmTemp(JdbcTemplate dppmTemp) {
        this.dppmTemp = dppmTemp;
    }

    /**
     * 获取工号所属的部门的资源信息
     * @param userId
     * @param date
     * @return
     * @throws Exception
     */
    @Override
    public DppmResourcesDeptEntity getDeptStaInfoByUser(String userId,
            String date) throws Exception {
        String sql = SqlUtil.getDeptStaInfoSql(userId, date);
        return dppmTemp.query(sql,
                new ResultSetExtractor<DppmResourcesDeptEntity>() {

                    @Override
                    public DppmResourcesDeptEntity extractData(ResultSet rs)
                            throws SQLException, DataAccessException {
                        DppmResourcesDeptEntity drs = null;
                        while (rs.next()) {
                            drs = new DppmResourcesDeptEntity();
                            drs.setDeptBenchmarkCode(rs.getString("deptBenchmarkCode"));
                            drs.setDeptAllPeo(rs.getInt("deptAllPeo"));
                            drs.setDeptMangerPeo(rs.getInt("deptMangerPeo"));
                            drs.setDeptMProPeo(rs.getInt("deptMProPeo"));
                            drs.setDeptNomProPeo(rs.getInt("deptNomProPeo"));
                            drs.setDeptProTasktime(rs.getLong("deptProTasktime"));
                            drs.setDeptDemTasktime(rs.getLong("deptDemTasktime"));
                            drs.setDeptTranTasktime(rs.getLong("deptTranTasktime"));
                            drs.setDeptRoutineTasktime(rs.getLong("deptRoutineTasktime"));
                            drs.setDeptProPoint(rs.getInt("deptProPoint"));
                            drs.setDeptDemPoint(rs.getInt("deptDemPoint"));
                            drs.setDeptTranPoint(rs.getInt("deptTranPoint"));
                            drs.setDeptRoutinePoint(rs.getInt("deptRoutinePoint"));
                            drs.setDeptSalaryAll(rs.getLong("deptSalaryAll"));
                            drs.setDeptSalarym(rs.getLong("deptSalarym"));
                            drs.setDeptSalarymPro(rs.getLong("deptSalarymPro"));
                            drs.setDeptSalaryNom(rs.getLong("deptSalaryNom"));
                            drs.setDeptSalaryNomPro(rs.getLong("deptSalaryNomPro"));
                         } 
                        
                        return drs == null ? new DppmResourcesDeptEntity() : drs;
                    }

                });
    }
}
