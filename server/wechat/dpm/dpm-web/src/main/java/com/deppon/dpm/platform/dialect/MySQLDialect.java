package com.deppon.dpm.platform.dialect;

import com.deppon.foss.framework.server.components.dataaccess.dialect.Dialect;

/**
 * 实现ibatis支持MySQL的物理分页功能
 * 
 * ClassName: MySQLDialect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-22 下午3:25:53 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
public class MySQLDialect extends Dialect {

	private static final String LIMIT = " limit ";
	
	public boolean supportsLimitOffset() {
		return true;
	}

	public boolean supportsLimit() {
		return true;
	}

	/**
	 * 为mysql 的语句添加limit限制
	 * @see com.deppon.foss.framework.server.components.dataaccess.dialect.Dialect#getLimitString(java.lang.String, int, java.lang.String, int, java.lang.String)
	 */
	public String getLimitString(String sql, int offset,
			String offsetPlaceholder, int limit, String limitPlaceholder) {
		if(!checkLimit(sql)){
			if (offset > 0) {
				return sql + LIMIT + offsetPlaceholder + "," + limitPlaceholder;
			} else {
				return sql + LIMIT + limitPlaceholder;
			}
		}else{
			return sql;
		}
	}

	/**
	 * 为mysql 的语句添加limit限制
	 * @see com.deppon.foss.framework.server.components.dataaccess.dialect.Dialect#getLimitString(java.lang.String, int)
	 */
	@Override
	public String getLimitString(String sql, int limit) {
		if(!checkLimit(sql)){
			return sql + LIMIT + limit;
		}
		return sql;
	}
	
	/**
	 * 判断sql语句是否已经加了limit限制
	 * 
	 * Date:2014-8-22下午3:32:28
	 * @author 157229-zxy
	 * @param sql
	 * @return
	 * @since JDK 1.6
	 */
	private boolean checkLimit(String sql){
		boolean isLimited = false;
		if(sql.toLowerCase().indexOf(LIMIT)!=-1){
			isLimited = true;
		}
		return isLimited;
	}
}