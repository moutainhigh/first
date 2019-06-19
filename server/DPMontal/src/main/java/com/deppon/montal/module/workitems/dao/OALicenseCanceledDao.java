
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OALicenseCanceledInfo;
import com.deppon.montal.model.RecommendExcellentEmp;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;

   /** 
   * @ClassName: OALicenseCanceledDao 
   * @Description:(分公司证照注销工作流数据操作) 
   * @author 廖建雄 
   * @date 2013-8-22 上午10:07:53 
   * 
   */
public class OALicenseCanceledDao implements IOALicenseCanceledDao {
    private static Logger logger = Logger.getLogger(OALicenseCanceledDao.class);
    private static String QUERY_OA_LICENSECANCELL_INFO ="" +
    		"SELECT OA.*," +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'DIP_FINANCEDEPT' AND D.DICTID = OA.FINANCEDEP" +
    		")FINANCEDEP," +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'WFS_MATTER_TEAM' AND D.DICTID = OA.MATTERTEAM" +
    		")MATTERTEAM " +
    		"FROM OA_LICENSECANCELL OA WHERE OA.PROCESSINSTID = ?";
    @Override
    public OALicenseCanceledInfo getLicenseCanceledInfo(String processinstid) {
	String sql = QUERY_OA_LICENSECANCELL_INFO;
	Object[] params = {processinstid};
	Connection conn = ConnectionManager.getConnection();
	ResultSet rs = null;
	OALicenseCanceledInfo licenseCanceled = new OALicenseCanceledInfo();
	try {
	    rs = ConnectionManager.query(conn, sql, params);
	    //解析rs 转换为LIST
	    List rsList = ConvertPojoUtil.resultSetToList(rs);
	    
	    //映射实体类
	    for(Object obj : rsList){
		licenseCanceled = (OALicenseCanceledInfo) ConvertPojoUtil.mapToBean(
			new OALicenseCanceledInfo(), (Map)obj);
	    }
	    licenseCanceled = getCancelType(licenseCanceled, conn);
	} catch (SQLException e) {
	    logger.error("ERROR:[OALicenseCanceledDao] SQL语句出错！" + e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[OALicenseCanceledDao] rs转换为list失败!" + e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return licenseCanceled;

    }
    public static OALicenseCanceledInfo getCancelType(OALicenseCanceledInfo info,Connection conn) throws SQLException{
	ResultSet rs = null;
	
	String[] code = info.getCanceltype().split(",");
	int length = code.length;
	String type ="";
	int index = 1;
	for (String str : code) {
	    type += "'" + str + "'";
	    if(index == length)
		continue;
	    type += ",";
	    index++;
	}
	String sql = "SELECT D.DICTNAME FROM EOS_DICT_ENTRY D   WHERE D.DICTTYPEID = 'WFS_CANCELTYPE' AND D.DICTID IN (" + type + ")";
	String canceltype = "";
	int i =1;
	    rs = ConnectionManager.query(conn, sql, null);
	    while (rs.next()) {
		 canceltype += rs.getString(1);
		 if(i == length)
		     continue;
		 canceltype += "|";
		 i++;
	    }
	info.setCanceltype(canceltype);
	
	return info;
    }

}

