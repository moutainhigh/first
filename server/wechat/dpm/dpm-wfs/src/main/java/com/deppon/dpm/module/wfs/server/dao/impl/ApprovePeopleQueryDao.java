package com.deppon.dpm.module.wfs.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.wfs.server.dao.IApprovePeopleQueryDao;
import com.deppon.dpm.module.wfs.shared.domain.ApprovePeopleInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * <p>ClassName: 下个审批人查询</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-8-26</p>
 */
public class ApprovePeopleQueryDao extends iBatis3DaoImpl implements IApprovePeopleQueryDao{
	private JdbcTemplate template;
	
	@Override
	public List<ApprovePeopleInfo> approveQeury(String processinstId) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append(" A .*, ROWNUM page");
		builder.append(" FROM");
		builder.append("(SELECT");
		builder.append(" PARTICIPANTID,PARTICIPANTNAME FROM");
		builder.append(" BPSDB.WFWIPARTICIPANT");
		builder.append(" WHERE PROCESSINSTID = ?");
		builder.append(" ORDER BY");
		builder.append(" createtime DESC) A");
		builder.append(" WHERE");
		builder.append(" ROWNUM <= 1");
		String sql = builder.toString();
		List<ApprovePeopleInfo> infoList = template.query(sql,new String[]{processinstId},new RowMapper<ApprovePeopleInfo>() {
			
			@Override
			public ApprovePeopleInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			    ApprovePeopleInfo info = new ApprovePeopleInfo();
				info.setParticipantId(rs.getString("PARTICIPANTID"));
				info.setParticipantName(rs.getString("PARTICIPANTNAME"));
				return info;
			}
		});
		
		return infoList;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
