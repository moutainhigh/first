package com.deppon.dpm.module.common.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IPunchClockPositionGlobalPcService;

public class PunchClockPositionGlobalPcService implements IPunchClockPositionGlobalPcService{
	
	private JdbcTemplate template;
	
	/**
	 * 查询所有数据
	 */
	public List<Map<String,Object>> queryList(int begin,int limit) {
		//sql
		String sql = "SELECT P.id,P.org_id,O.ORGNAME org_name,P.sales_depart_addr,P.manager_id,"
				+ "P.parent_org_id,T.ORGNAME parent_org_name,P.latitude,P.longitude,P.radius,P.verify_status"
				+ " FROM om_punch_position P,om_organization O,"
				+ "(SELECT PT.id,PT.org_id,OT.ORGNAME FROM om_punch_position PT,om_organization OT WHERE OT.ORGID=PT.parent_org_id AND PT.is_enable = 1 ) T "
				+ "WHERE P.org_id=O.ORGID AND P.id=T.id AND P.is_enable = 1 limit ?,?";
		//执行sql
		List<Map<String,Object>> list = template.query(sql, new RowMapper<Map<String,Object>>(){
			//实现方法
			public Map<String,Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//封装对象
				Map<String,Object> appPermission = new HashMap<String,Object>();
				//id
				appPermission.put("id", rs.getInt(1));
				//orgid
				appPermission.put("orgid", rs.getInt(2));
				//orgname
				appPermission.put("orgname", rs.getString(3));
				//salesdepartaddr
				appPermission.put("salesdepartaddr", rs.getString(4));
				//managerid
				appPermission.put("managerid", rs.getString(5));
				//parentorgid
				appPermission.put("parentorgid", rs.getInt(6));
				//parentorgname
				appPermission.put("parentorgname", rs.getString(7));
				//latitude
				appPermission.put("latitude", rs.getString(8));
				//longitude
				appPermission.put("longitude", rs.getString(9));
				//radius
				appPermission.put("radius", rs.getInt(10));
				//verifystatus
				appPermission.put("verifystatus", rs.getInt(11));
				//返回
				return appPermission;
			}
			
		},begin,limit);
		
		return list;
	}
	
	/**
	 * 查询总数据条数
	 */
	public long queryCount() {
		String sql = "SELECT COUNT(1) FROM om_punch_position where is_enable = 1";
		return template.queryForLong(sql);
	}

	/**
	 * 新增position信息
	 */
	public int insert(JSONObject position) {
		
		String sql = "INSERT INTO om_punch_position (org_id,manager_id,sales_depart_addr,parent_org_id,latitude,"
				+ "longitude,radius,create_time,update_time,is_enable,verify_status)"
				+ " values(?,?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,1,0)";
		
		int orgid = position.getIntValue("orgid");
		String managerid = position.getString("managerid");
		String salesdepartaddr = position.getString("salesdepartaddr");
		int parentorgid = position.getIntValue("parentorgid");
		String latitude = position.getString("latitude");
		String longitude = position.getString("longitude");
		int radius = position.getIntValue("radius");
		
		return template.update(sql, orgid,managerid,salesdepartaddr,parentorgid,latitude,longitude,radius);
		
	}

	/**
	 * 修改position信息
	 */
	public int update(JSONObject position) {
		
		String sql = "UPDATE om_punch_position SET latitude = ?,longitude = ?,radius = ?,verify_status = ?,update_time = CURRENT_TIMESTAMP WHERE id = ? ";
		
		int id = position.getIntValue("id");
		String latitude = position.getString("latitude");
		String longitude = position.getString("longitude");
		int radius = position.getIntValue("radius");
		int verifystatus = position.getIntValue("verifystatus");
		
		return template.update(sql, latitude,longitude,radius,verifystatus,id);
	}
	
	/**
	 * 根据应用编号删除信息
	 */
	public void deleteByApplyCodes(String applyCodes) {
		//根据,切割
		String[] codes = applyCodes.split(",");
		//健壮判断
		if(null != codes && codes.length > 0){
			//由于拼接字符串
			StringBuilder sb = new StringBuilder();
			sb.append("delete from om_punch_position where id in(");
			//遍历
			for (String code : codes) {
				//拼接
				sb.append(code + ",");
			}
			//删除多余的,
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append(")");
			//执行sql
			template.update(sb.toString());
		}
	}
	
	/**
	 * 根据部门名称查询信息
	 */
	public List<Map<String,Object>> getOrganizationByOrgName(String orgName){
		//sql
		String sql = "SELECT O.ORGID,O.ORGNAME,O.managerId,O.PARENTORGID,OP.ORGNAME PARENTORGNAME FROM om_organization O,om_organization OP"
				+ " WHERE O.ORGNAME= ? AND O.PARENTORGID=OP.ORGID";
		//执行sql
		List<Map<String,Object>> list = template.query(sql, new RowMapper<Map<String,Object>>(){
			//实现方法
			public Map<String,Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//封装对象
				Map<String,Object> appPermission = new HashMap<String,Object>();
				//orgid
				appPermission.put("orgid", rs.getInt(1));
				//orgname
				appPermission.put("orgname", rs.getString(2));
				//managerid
				appPermission.put("managerid", rs.getString(3));
				//parentorgid
				appPermission.put("parentorgid", rs.getInt(4));
				//parentorgname
				appPermission.put("parentorgname", rs.getString(5));
				//返回
				return appPermission;
			}
			
		},orgName);
		return list;
	}

	// setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
