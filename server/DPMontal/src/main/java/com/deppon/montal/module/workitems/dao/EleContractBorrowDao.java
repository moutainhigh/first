
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.deppon.montal.model.OAElectroniContractBorrow;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: EleContractBorrowDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 电子合同借阅申请数据操作层 
 * @author yinrongping 
 * @date 2013-8-5 上午9:38:10 
 * @version V1.0 
 */
public class EleContractBorrowDao implements IEleContractBorrowDao {

	private static Logger logger = Logger.getLogger(EleContractBorrowDao.class);
    private static String QUERY_INFO_SQL ="" +
    		  " select processinstid,name,empcode,reason, contractnum,contracttype,borrowdays,  "+
    	      "  startdate,enddate,extend1,extend2,contractdense,amssn,amsapplytype, "+
    	      "  (select dict.dictname from eos_dict_entry dict  "+
    	      "      where dict.dicttypeid='DIP_DIVISION_NEW' and dict.dictid = t.area) area "+
              " from  oa_electroniccontractborrow t where t.processinstid = ?  ";
	/**
	   * 
	   * @Title: getEleContractBorrowInfo 
	   * @Description:获取电子合同借阅申请
	   * @date 2013-8-5 上午9:35:33
	 */
	@Override
	public OAElectroniContractBorrow getEleContractBorrowInfo(
			String processinstid) {
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OAElectroniContractBorrow apply = new OAElectroniContractBorrow();
		try {
		    rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    for (Object object : resultList) {
		    	apply = (OAElectroniContractBorrow)ConvertPojoUtil.mapToBean(
				new OAElectroniContractBorrow(),(Map)object);
		    }
		    
		} catch (SQLException e) {
		    logger.error("ERROR:[EleContractBorrowDao.getEleContractBorrowInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[EleContractBorrowDao.getEleContractBorrowInfo] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		return apply;

	}

}

