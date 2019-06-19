
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.CCPorent;
import com.deppon.montal.model.CCPorentEntry;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: RentDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO房租dao层) 
 * @author 何玲菠 
 * @date 2013-5-28 上午9:09:21 
 * @version V1.0 
 */
public class RentDao implements IRentDao {
	private static Logger logger = Logger.getLogger(RentDao.class);
	private static String QUERY_RENT_INFO = "SELECT CC.*, " +
			"(SELECT W.WORKITEMNAME FROM WFWORKITEM W WHERE " +
			"(W.CURRENTSTATE = '10' OR W.CURRENTSTATE = '4') AND " +
			"W.PROCESSINSTID = CC.PROCESSINSTID) CURRENTNODE　 " +
			"FROM CC_PORENT CC WHERE CC.PROCESSINSTID = ?";
	private static String QUERY_RENT_ENTRY = "SELECT *　FROM " +
			"CC_PORENTENTRY WHERE PROCESSINSTID =?";
	@Override
	public CCPorent queryRentByWorkId(String workId) {
		String sql = QUERY_RENT_INFO;
		Object[] params = {workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		CCPorent rent = new CCPorent();
		try {
			rs = ConnectionManager.query(conn, sql, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size() > 0){
				rent = (CCPorent)ConvertPojoUtil.mapToBean(new CCPorent(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("ERROR:[CCExpenseClaimDao] SQL语句出错！" + e.getMessage());
		} catch(IOException e){
			 logger.error("ERROR:[CCExpenseClaimDao] rs转换为list失败!" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return rent;
	}

	@Override
	public List<CCPorentEntry> queryRentEntryByWorkId(String workId) {
		String sql = QUERY_RENT_ENTRY;
		Object[] params = {workId};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		List<CCPorentEntry> rentEntries = new ArrayList<CCPorentEntry>();
		CCPorentEntry rentEntry = new CCPorentEntry();
		try {
			rs = ConnectionManager.query(conn, sql, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size() > 0){
				for (Object temp : resultList) {
					rentEntry = (CCPorentEntry)ConvertPojoUtil.mapToBean(new CCPorentEntry(), (Map)temp);
					rentEntries.add(rentEntry);
				}
			}
		} catch (SQLException e) {
			logger.error("ERROR:[CCExpenseClaimDao] SQL语句出错！" + e.getMessage());
		} catch (IOException e){
			logger.error("ERROR:[CCExpenseClaimDao] rs转换为list失败!" + e.getMessage());
		} finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return rentEntries;
	}

}

