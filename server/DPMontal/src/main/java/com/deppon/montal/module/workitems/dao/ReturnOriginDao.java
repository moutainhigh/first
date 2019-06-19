/**
 * 
 */
package com.deppon.montal.module.workitems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAReturnDomOfOrigin;
import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
 * @Title: ReturnOriginDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(回原籍申请dao层) 
 * @author yin
 * @date 2013-7-16 上午12:04:48 
 * @version V1.0 
 */
public class ReturnOriginDao implements IReturnOriginDao {

	private static Logger logger = Logger.getLogger(ReturnOriginDao.class);
	
	//获取付款申请信息SQL
	private static String QUERY_INFO_SQL = " "+
	        " select processinstid,applypersoncode,applypersonname,joblevel,  "+
			"		property,hrdept,hrdeptname,nativeplace,currentjob,        "+
			"	    orgid,currentdept,inaera,inaeraname,indept,indeptname,    "+
			"       workdata,isrelegation,performance,competency,officetel,   "+
			"       phone,handovercard,nextuser,balance,reason,fileid,billid  "+
			"  from t_oa_return_dom_of_origin t                               "+
			" where t.processinstid = ?  ";          
	             
	/**
	 * 获取回原籍申请信息
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAReturnDomOfOrigin getReturnOriginInfo(String processinstid) {
		Object[] params = new Object[]{processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAReturnDomOfOrigin origin = null;
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				origin = (OAReturnDomOfOrigin)ConvertPojoUtil.mapToBean(new OAReturnDomOfOrigin(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[ReturnOriginDao.getReturnOriginInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[ReturnOriginDao.getReturnOriginInfo] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return origin;

	}

}
