
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAPlaceSublet;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OAPlaceSubletDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-6-28 上午10:33:13 
 * @version V1.0 
 */
public class OAPlaceSubletDao implements IOAPlaceSubletDao {
	private static Logger logger = Logger.getLogger(OAPlaceSubletDao.class);
	private static String QUERY_INFO = "select t.processinstid," +
			"t.empname," +
			"t.empcode, " +
			"t.sign_type," +
			"(select b.dictname from eos_dict_entry b where t.finance_dept = b.dictid and b.dicttypeid = 'DIP_FINANCEDEPT') finance_dept," +
			"(select d.dictname from eos_dict_entry d where t.area = d.dictid and d.dicttypeid = 'DIP_DIVISION_NEW') area," +
			"(select q.dictname from eos_dict_entry q where t.is_change = q.dictid and q.dicttypeid = 'WFS_YESORNO') is_change, " +
			"t.rent_name," +
			"t.lease_name," +
			"t.change_amt," +
			"t.lease_business, " +
			"t.sublet_dept, " +
			"t.pay_months," +
			"t.old_lease_area," +
			"t.old_lease_price," +
			"t.new_lease_area, " +
			"t.new_lease_price," +
			"to_char(t.lease_start_date,'yyyy-mm-dd') lease_start_date," +
			"to_char(t.lease_end_date,'yyyy-mm-dd') lease_end_date," +
			"t.apply_origin," +
			"t.sublet_dept_code," +
			"(select w.dictname from eos_dict_entry w where t.matter_team = w.dictid and w.dicttypeid = 'WFS_MATTER_TEAM') matter_team " +
			" from oa_place_sublet t where t.processinstid = ?";
	@Override
	public OAPlaceSublet getOAPlaceSublet(String workId) {
		Object[] parmam = {workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAPlaceSublet oaplacesublet = null;
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO, parmam);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				oaplacesublet = (OAPlaceSublet)ConvertPojoUtil.mapToBean(new OAPlaceSublet(), (Map)(resultList.get(0)));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OAPlaceSubletDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OAPlaceSubletDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return oaplacesublet;
	}

}

