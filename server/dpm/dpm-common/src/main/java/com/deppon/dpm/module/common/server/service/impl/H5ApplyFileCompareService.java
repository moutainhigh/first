package com.deppon.dpm.module.common.server.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.common.server.service.IH5ApplyFileCompareService;
import com.deppon.dpm.module.common.server.util.JdbcTemplateUtil;
import com.deppon.dpm.module.common.shared.domain.H5FileCountEntity;

public class H5ApplyFileCompareService implements IH5ApplyFileCompareService{
	
	private JdbcTemplate template;
	
	/**
	 * 角标3
	 */
	private static final int INDEX_3 = 3;

	/**
	 * 保存
	 */
	public int saveCount(int applyCode,int count) {
		String sql = "INSERT INTO apply_filecount_info (apply_code, count, update_time) VALUES (?, ?, NOW())";
		return template.update(sql, applyCode,count);
	}

	/**
	 * 更新
	 */
	public int updateCount(int applyCode,int count) {
		String sql = "UPDATE apply_filecount_info SET count=?,update_time=NOW() WHERE apply_code=?";
		return template.update(sql, count,applyCode);
	}
	
	/**
	 * 根据应用编号查询
	 */
	public int getFileCount(int applyCode){
		String sql = "SELECT count FROM apply_filecount_info WHERE apply_code = ?";
		return JdbcTemplateUtil.queryForInt(template, sql, new Integer[]{applyCode});
	}
	
	/**
	 * 查询所有数据
	 */
	public List<H5FileCountEntity> queryList(int begin,int limit) {
		//sql
		String sql = "SELECT apply_code,count,update_time FROM apply_filecount_info limit ?,?";
		//执行sql
		List<H5FileCountEntity> list = template.query(sql, new RowMapper<H5FileCountEntity>(){
			//实现方法
			public H5FileCountEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//从结果集中获取应用编号
				int applyCode = rs.getInt(1);
				//获取文件数量
				int count = rs.getInt(2);
				//更新时间
				Date updateTime = rs.getTimestamp(INDEX_3);
				//封装对象
				H5FileCountEntity entity = new H5FileCountEntity(applyCode,count,updateTime);
				//返回
				return entity;
			}
			
		},begin,limit);
		
		return list;
	}
	
	/**
	 * 查询总数据条数
	 */
	public long queryCount() {
		String sql = "SELECT COUNT(1) FROM apply_filecount_info";
		return template.queryForLong(sql);
	}

	/**
	 * 新增H5资源文件信息
	 */
	public int insert(int applyCode, int count) {
		String sql = "INSERT INTO apply_filecount_info (apply_code, count, update_time) VALUES (?, ?, NOW())";
		return template.update(sql, applyCode,count);
	}

	/**
	 * 修改H5资源文件信息
	 */
	public int update(int applyCode, int count) {
		String sql = "UPDATE apply_filecount_info SET count=?, update_time=NOW() WHERE apply_code=?";
		return template.update(sql, count,applyCode);
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
			sb.append("delete from apply_filecount_info where apply_code in(");
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

	// setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
