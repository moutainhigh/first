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

import com.deppon.montal.model.OAManagerRegularizationApply;
import com.deppon.montal.model.TWFSexpensehk;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: IManagerBecomeDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description:(管理人员转正/成长期通过申请工作流申请数据层) 
* @author yin 
* @date 2013-7-22 下午3:23:31 
* @version V1.0 
*/
public class ManagerBecomeDao implements IManagerBecomeDao {

	private static Logger logger = Logger.getLogger(ManagerBecomeDao.class);
	
	//获取付款申请信息SQL
	private static String QUERY_INFO_SQL = "select   " +
			"PROCESSINSTID    ,  " +
			"NAME              ,  " +
			"EMPID             ,  " +
			"DEPT              ,  " +
			"DEPTCODE          ,  " +
			"STARTDATE         ,  " +
			"(select dict.dictname from eos_dict_entry dict where dict.dicttypeid='DIP_IFVALID' and dict.dictid = t.istalkspay) ISTALKSPAY        ,  " +
			"TALKSPAY          ,  " +
			"REASON            ,  " +
			"(select dict.dictname from eos_dict_entry dict where dict.dicttypeid='DIP_TEST_PENNEL_NEW' and dict.dictid = t.enterprisearea) ENTERPRISEAREA    ,  USERID            ,  " +
			"(select dict.dictname from eos_dict_entry dict where dict.dicttypeid='DIP_ZZ_TYPE' and dict.dictid = t.apptype) APPTYPE           ,  " +
			"APPLYTYPE         ,  " +
			"GROWTHTHROUGHTYPE ,  " +
			"POSITION          ,  " +
			"INSPECTIONLEVEL   ,  " +
			"APPOINTMENTDATE   ,  " +
			"POSITIVEPROID     ,  " +
			"POSITIVEDATE      ,  " +
			"(select w.workitemname from wfworkitem w where (w.currentstate = '10' or  w.currentstate = '4') and w.processinstid = t.processinstid ) currentnode   " +
			"from oa_managerregularizationapply t where t.processinstid = ?";
	
	/**
	 * 获取管理人员转正/成长期通过申请工作流申请信息
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAManagerRegularizationApply getManagerRegApply(String processinstid) {
		
		Object[] params = new Object[]{processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAManagerRegularizationApply apply = null;
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				apply = (OAManagerRegularizationApply)ConvertPojoUtil.mapToBean(new OAManagerRegularizationApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[ManagerBecomeDao.getManagerRegApply] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[ManagerBecomeDao.getManagerRegApply] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return apply;
	}

}
