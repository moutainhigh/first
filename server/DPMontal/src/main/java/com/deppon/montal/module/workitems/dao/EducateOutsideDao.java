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

import com.deppon.montal.model.CCEntertainmentFees;
import com.deppon.montal.model.OAExterNaltraining;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
 * @Title: IEducateOutsideDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (外训申请) 
 * @author yin
 * @date 2013-7-19 上午11:44:35 
 * @version V1.0 
 */
public class EducateOutsideDao implements IEducateOutsideDao {

	private static Logger logger = Logger.getLogger(EducateOutsideDao.class);
    private static String QUERY_INFO_SQL = " "+
    		  " select processinstid,name,empid,participant,coursefee,  "+
    		  " (select e.dictname from eos_dict_entry e   "+
    		  "     where e.dicttypeid = 'DIP_ENTERPRISEPERSONNEL_NEW' and e.dictid = t.personel) personel, "+
    		  " trainsdate,trainedate, trainplace,coursename,sponsoringorg, "+
    		  " reason,apppersonnumber,apppersonorgname, apppersonorgid, "+
    		  " (select e.dictname from eos_dict_entry e   "+
    		  "     where e.dicttypeid = 'DIP_IFVALID' and e.dictid = t.isremark) isremark "+
    		  " from oa_externaltraining t where t.processinstid = ? ";
	
	/**
	 * 获取外训申请信息
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAExterNaltraining getExterNaltrainingInfo(String processinstid) {
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAExterNaltraining training = new  OAExterNaltraining();
		try {
		    rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    for (Object object : resultList) {
		    	training = (OAExterNaltraining) ConvertPojoUtil.mapToBean(new OAExterNaltraining(), 
				(Map)object);
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[EducateOutsideDao.getExterNaltrainingInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[EducateOutsideDao.getExterNaltrainingInfo] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return training;
	}

}
