
package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OACheckFileApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OACheckFileApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 发文审核申请数据操作
 * @author yinrongping 
 * @date 2013-8-22 上午9:07:43 
 * @version V1.0 
 */
public class OACheckFileApplyDao implements IOACheckFileApplyDao{

private static Logger logger = Logger.getLogger(OACheckFileApplyDao.class);
	
	private static final String QUERY_INFO_SQL = " " +
			  "  select  processinstid,empid,name,filename,prevfilename, "+
			  "          remark,jobno,applydept,editfilenum, "+
			  "          (select dict.dictname from eos_dict_entry dict  "+
			  "          where dict.dicttypeid='FILEUSEAREA' and dict.dictid = t.usearea) usearea, "+
			  "          (select dict.dictname from eos_dict_entry dict  "+
			  "          where dict.dicttypeid='FILECATEGORY' and dict.dictid = t.filecategory) filecategory "+
			  " from oa_checkfileapply t where t.processinstid = ?  ";
	
	/**
	 * 获取发文审核申请信息
	 */
	@Override
	public OACheckFileApply getCheckFileApplyInfo(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OACheckFileApply apply = new OACheckFileApply();
		try {
			rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if(resultList.size()>0){
				apply = (OACheckFileApply)ConvertPojoUtil.mapToBean(new OACheckFileApply(), (Map)resultList.get(0));
			}
		} catch (SQLException e) {
		    logger.error("ERROR:[OACheckFileApplyDao.getCheckFileApplyInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OACheckFileApplyDao.getCheckFileApplyInfo] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return apply;
	}

}

