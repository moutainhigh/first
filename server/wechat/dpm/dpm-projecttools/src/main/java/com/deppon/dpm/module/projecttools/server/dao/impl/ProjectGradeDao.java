package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.projecttools.server.dao.IProjectGradeDao;
import com.deppon.dpm.module.projecttools.shared.domain.ProgradebillEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectGradeEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 项目评级 dao
 * @author 195406 高春玲
 * @date 2015-9-25 下午1:45:08
 * @since
 **/
public class ProjectGradeDao extends iBatis3DaoImpl implements IProjectGradeDao {
	static Logger logger = LoggerFactory.getLogger(ProjectGradeDao.class);
    //
	private JdbcTemplate template;
	// 定义map 变量
    Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 根据项目编号获得项目四个评级信息
	 * @param projectCode 项目编号
	 * @return 评级信息
	 * @throws Exception
	 */
	public String gradeInfo(int projectCode) {
		map = new HashMap<String, Object>();
		// 项目评级 sql
		String sql = "select PRO.PROJECTID, PRO.PROGRADEID, PRO.TEMPLATEID, PRO.PROJECTNAME," +
				"PRO.PROJECTJM,PRO.PROJECTTYPE,PRO.PROJECTLEVEL,PRO.GRADEPHASE," +
				"PRO.GRADETIME,PRO.GRADEQUARTER,PRO.TOTALSCROE,PRO.PLEVEL," +
				// 扣分合计
				"(select sum(deductionobtain) from dotp_pm_progradebill bill " +
				"where bill.progradeid=PRO.progradeid) DELSCORE," +
				// 加分合计
				"(select sum(addscroebtain) from dotp_pm_progradebill bill " +
				"where bill.progradeid=PRO.progradeid) ADDSCORE," +
				// 基础分
				"(select pt.BASESCORE from dotp_pm_protempmaintain pt " +
				"where pt.templateid=PRO.templateid ) BASESCORE " +
				// 根据项目编号获得
				"FROM dotp_pm_prograde PRO ,dotp_pm_projects p " +
				"where pro.projectid = p.project_id and p.project_code=" + projectCode;
		// 根据 sql获得　项目评级
		this.template.query(sql, new RowMapper<ProjectGradeEntity>() {
			@Override
			public ProjectGradeEntity mapRow(ResultSet rs, int arg1)
						throws SQLException {
				// 创建 项目评级实体
				ProjectGradeEntity info = new ProjectGradeEntity();
				info.setProjectId(rs.getInt("PROJECTID"));
				// 设置 id
				info.setProGradeId(rs.getString("PROGRADEID"));
				// 设置模板ID
				info.setTemplateId(rs.getString("TEMPLATEID"));
				// 项目名称
				info.setProjectName(rs.getString("PROJECTNAME"));
				//  项目简码
				info.setProjectJm(rs.getString("PROJECTJM"));
				//  项目类型
				info.setProjectType(rs.getString("PROJECTTYPE"));
				//项目级别
				info.setProjectLevel(rs.getString("PROJECTLEVEL"));
				//评级阶段
				info.setGradePhase(rs.getString("GRADEPHASE"));
				//评级时间
				info.setGradeTime(rs.getDate("GRADETIME"));
				//评级季度
				info.setGradeQuarter(rs.getString("GRADEQUARTER"));
				//总分
				info.setTotalScroe(rs.getDouble("TOTALSCROE"));
				//等级
				info.setPlevel(rs.getString("PLEVEL"));
				//扣分
				info.setDelScore(rs.getDouble("DELSCORE"));
				//加分
				info.setAddScore(rs.getDouble("ADDSCORE"));
				// 基础分
				info.setBaseScore(rs.getDouble("BASESCORE"));
				//设置 四个评级 集合
				if("过程评级".equals(info.getGradePhase())) {
					map.put("gclist", info);
				} else if ("立项评级".equals(info.getGradePhase())) {
					map.put("lxlist", info);
				} else if ("结项评级".equals(info.getGradePhase())) {
					map.put("jxlist", info);
				} else if ("落地评级".equals(info.getGradePhase())) {
					map.put("ldlist", info);
				}
				return info;
			}
		});
		return JSON.toJSONString(map);
	}
	/**
	 * 根据评级编号获得项目评级详情
	 * @param gradeId 评级编号
	 * @return 评级详情
	 * @throws Exception
	 */
	public String gradeBillInfo(String gradeId) {
		// 初始化
//		ProgradebillEntity e = new ProgradebillEntity();
		// 项目评级详情sql
		String sql = "select PRO.PROGRADEID,PRO.GRADEDIMEN,PRO.GRADEINDEX,PRO.GRADEINDEXDESC," +
		  "PRO.DEDUCTIONDESC, PRO.ADDSCROEDESC, PRO.PLANTARGET, PRO.ACTUALCOMPLETE," +
		  "PRO.COMPLETEDESC, PRO.DEDUCTIONOBTAIN, PRO.ADDSCROEBTAIN " +
		  "from dotp_pm_progradebill pro where pro.proGradeId='" + gradeId + "'";
		// 根据 sql获得　项目评级
		List<ProgradebillEntity> list = this.template.query(sql, 
				new RowMapper<ProgradebillEntity>() {
			@Override
			public ProgradebillEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// 创建 项目评级详情实体
				ProgradebillEntity info = new ProgradebillEntity();
				//评级项目id
				info.setProgradeId(rs.getString("PROGRADEID"));
				// 评级维度
				info.setGradeDimen(rs.getString("GRADEDIMEN"));
				//评级指标
				info.setGradeIndex(rs.getString("GRADEINDEX"));
				//评级指标明细
				info.setGradeIndexDesc(rs.getString("GRADEINDEXDESC"));
				//扣分细则
				info.setDeductionDesc(rs.getString("DEDUCTIONDESC"));
				//加分细则
				info.setAddScroeDesc(rs.getString("ADDSCROEDESC"));
				//项目计划目标
				info.setPlanTarget(rs.getString("PLANTARGET"));
				//项目实际完成
				info.setActualComplete(rs.getString("ACTUALCOMPLETE"));
				info.setCompleteDesc(rs.getString("COMPLETEDESC"));
				info.setDeductionoBtain(rs.getShort("DEDUCTIONOBTAIN"));
				info.setAddscroeBtain(rs.getShort("ADDSCROEBTAIN"));
				return info;
			}
		});
//		if(list != null && list.size() > 0 ) {
//			e = list.get(0);
//		}
		// 实体转换为json 字符串
		return JSON.toJSONString(list);
	}
	/**
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
}
