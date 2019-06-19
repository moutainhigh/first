
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OALicenseCanceledInfo;
import com.deppon.montal.model.OALicenseLendRead;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;



   /** 
   * @ClassName: OALicenseLendReadDao 
   * @Description:(证照借阅申请（新）数据操作) 
   * @author 廖建雄 
   * @date 2013-8-23 下午2:53:19 
   * 
   */
public class OALicenseLendReadDao implements IOALicenseLendReadDao {
    private static Logger logger = Logger.getLogger(OALicenseLendReadDao.class);
    private static String QUERY_OA_LOANCERTIFICATE_INFO ="" +
    		"SELECT OA.*," +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_DIVISION_NEW' AND D.DICTID = OA.AREA" +
    		")AREA " +
    		"FROM OA_LOANCERTIFICATE OA WHERE OA.PROCESSINSTID = ?";
    @Override
    public OALicenseLendRead getLicenseLendRead(String processinstid) {
	String sql = QUERY_OA_LOANCERTIFICATE_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OALicenseLendRead licenseLend = new OALicenseLendRead();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //解析rs 转换为LIST
	    List rsList = ConvertPojoUtil.resultSetToList(rs);
	    
	    //映射实体类
	    for(Object obj : rsList){
		licenseLend = (OALicenseLendRead) ConvertPojoUtil.mapToBean(
			new OALicenseLendRead(), (Map)obj);
	    }
	} catch (SQLException e) {
	    logger.error("ERROR:[OALicenseLendReadDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OALicenseLendReadDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return licenseLend;

    }
}

