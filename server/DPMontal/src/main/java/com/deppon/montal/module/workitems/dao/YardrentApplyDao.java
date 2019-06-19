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

import com.deppon.montal.model.CCOnbusiness;
import com.deppon.montal.model.OAYardrentApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

/** 
* @Title: YardrentApplyDao.java
* @Package com.deppon.montal.module.workitems.dao 
* @Description: (场地租赁申请工作流数据层) 
* @author yin 
* @date 2013-6-27 上午9:58:20 
* @version V1.0 
*/
public class YardrentApplyDao implements IYardrentApplyDao {

	private static Logger logger = Logger.getLogger(YardrentApplyDao.class);
	
	private static final String QUERY_YARDRENT_SQL = ""+
			" select processinstid,empid,empcode,signtype, oldcontarctnum,name,allagreetime, "+
		    "        (select dict.dictname from dipoa.eos_dict_entry dict "+
		    "          where dict.dicttypeid = 'DIP_DIVISION_NEW'  and dict.dictid = t.area) area, "+
		    "        childcompany,rentname,leasename,leasedept,leasecreage,startdate, "+
		    "        enddate,yearrental,paytype,rentfreebgdate,rentfreeenddate,reason, "+
		    "        (select dict.dictname from dipoa.eos_dict_entry dict  "+
		    "          where dict.dicttypeid = 'DIP_FINANCEDEPT'  and dict.dictid = t.financedept) financedept, "+
		    "        (select dict.dictname from dipoa.eos_dict_entry dict "+
		    "         where dict.dicttypeid = 'WFS_MATTER_TEAM' and dict.dictid = t.matter_team) matterteam, "+
		    "        projectid,projectname,leasetype, "+
		    "        (select w.workitemname from wfworkitem w where (w.currentstate = '10' or  w.currentstate = '4') and w.processinstid = t.processinstid and rownum = 1) currentnode  "+
		    " from dipoa.oa_yardrentapply t where t.processinstid = ? ";
	
	/**
	 * 获取场地租赁申请
	 * @param processinstid
	 * @return
	 */
	@Override
	public OAYardrentApply getYardrentApplyInfo(String processinstid) {
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAYardrentApply apply = new OAYardrentApply();
		try {
		    rs = ConnectionManager.query(conn, QUERY_YARDRENT_SQL, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    if (resultList.size() > 0) {
		    	apply = (OAYardrentApply) ConvertPojoUtil.mapToBean(new OAYardrentApply(),
				(Map)resultList.get(0));
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[YardrentApplyDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[YardrentApplyDao] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return apply;
	}

}
