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

import com.deppon.montal.model.OAOvertimeApply;
import com.deppon.montal.model.OAQualificationAuth;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: OAQualificationAuthDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(任职资格申请流数据操作) 
* @author yin
* @date 2013-6-29 上午9:59:06 
* @version V1.0 
*/
public class OAQualificationAuthDao implements IOAQualificationAuthDao {

	private static Logger logger = Logger.getLogger(OAQualificationAuthDao.class);
	
	private static final String QUERY_QUALIFICATIONAUTH_SQL = ""+
			" select  processinstid,name,userid,empid,reason,apptype,outexperience, "+
			"         sex,degree,department,pincodes,incompanytime,inapplytime,salary_now salarynow, "+
			"         performance,isrecommend,managementlevel,isoutexperience,salary_new salarynew, "+
			"         appchannelworktime,appchannellevel,appchannel,applevel,position, "+
			"         appprofessionalpost,certificationpasstime,reexaminationtime,reexaminationnowlevel, "+
			"         reexaminationchannel,reexaminationlevel,reexaminationprofesspost, "+  
			"         (select ede.dictname from eos_dict_entry ede where ede.dicttypeid = 'DIP_PERFORMANCE'  "+
			"             and ede.dictid = t.performance_now) performancenow, "+
			"         (select ede.dictname from eos_dict_entry ede where ede.dicttypeid = 'DIP_PERFORMANCE'  "+
			"             and ede.dictid = t.performance_now) performancenew  "+ 
			" from oa_qualificationauth t where t.processinstid = ? ";   
	
	/**
	 * 获取任职资格申请
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAQualificationAuth getQualificationAuth(String processinstid) {
		Object[] params = new Object[]{processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAQualificationAuth auth = null;
		try {
			rs = ConnectionManager.query(conn, QUERY_QUALIFICATIONAUTH_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if (resultList.size() > 0) {
				auth = (OAQualificationAuth) ConvertPojoUtil.mapToBean(new OAQualificationAuth(),(Map)resultList.get(0));
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[OAQualificationAuthDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OAQualificationAuthDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return auth;
	}

}
