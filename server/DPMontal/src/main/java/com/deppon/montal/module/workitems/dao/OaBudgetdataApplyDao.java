
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OaBudgetdataApply;
import com.deppon.montal.model.OaContractAdd;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OaBudgetdataApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-5-13 下午2:39:40 
 * @version V1.0 
 */
public class OaBudgetdataApplyDao implements IOaBudgetdataApplyDao {
	private static Logger logger = Logger.getLogger(OaBudgetdataApplyDao.class);
	private static final String QUERY_INFO = "select b.processinstid,"+
       "b.empid,"+
       "b.name,"+
       "b.budgetdyeay,"+
       "b.budgetdquaeter,"+
       "b.budgetorgcode,"+
       "b.budgetorgname,"+
       "b.whyapply,"+
       "decode(b.apptype,1,'预算提交',2,'预算调整') apptype,"+
       "b.feetype,"+
       "b.rate "+
       "from oa_budgetdataapply b "+ 	
       "where 1=1"+
       "and b.processinstid = ?";
	@Override
	public OaBudgetdataApply getOaBudgetdataApply(String pid) {
		// TODO Auto-generated method stub return null;
		OaBudgetdataApply oaBudgetdataApply = new OaBudgetdataApply();
		Object[] parms = {pid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		try{
			//申请信息
			rs = ConnectionManager.query(conn, QUERY_INFO, parms);
			List  resultList = ConvertPojoUtil.resultSetToList(rs);
			oaBudgetdataApply = (OaBudgetdataApply) ConvertPojoUtil.mapToBean(new OaBudgetdataApply(), (Map)resultList.get(0));
		}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return oaBudgetdataApply;

	}

}

