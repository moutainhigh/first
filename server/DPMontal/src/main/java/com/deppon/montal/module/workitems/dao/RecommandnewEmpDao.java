
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OaBudgetdataApply;
import com.deppon.montal.model.RecommandNewEMP;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: RecommandnewEmpDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: TODO(添加描述) 
 * @author 何玲菠 
 * @date 2013-5-13 下午2:44:29 
 * @version V1.0 
 */
public class RecommandnewEmpDao implements IRecommandnewEmpDao {
	private static Logger logger = Logger.getLogger(RecommandnewEmpDao.class);
	private static final String QUERY_INFO = "select a.processinstid,"+
       "a.applyname,"+
      " a.applyuserid,"+
      " a.recommendedname,"+
      " a.relation,"+
      " decode(a.recommendedsex,'m','男','f','女') recommendedsex,"+
     "  (select e.dictname from  eos_dict_entry e  where e.dicttypeid = 'OA_EDUCATIONLEVEL' and e.dictid = a.recommendededu) recommendededu,"+
     "  a.graduatecollege,"+
      " to_char(a.graduateyears) GRADUATEYEARS,"+
      " (select f.dictname from eos_dict_entry f where f.dicttypeid = 'OA_RECOMMENDEDTYPE' and f.dictid = a.recommendedtype) recommendedtype,"+
      " a.recommendedarecode,"+
      " a.recommendedarename,"+
      " a.recommendeddeptcode,"+
      " a.recommendeddeptname,"+
      " a.recommendedreason"+
      " from  OA_RECOMMEND_NEW_EMP a "+
      " where 1=1 "+
      "and a.processinstid = ?";
	@Override
	public RecommandNewEMP getRecommandNewEmp(String pid) {

		// TODO Auto-generated method stub return null;
		RecommandNewEMP recommandNewEmp = new RecommandNewEMP();
		Object[] parms = {pid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		try{
			//申请信息
			rs = ConnectionManager.query(conn, QUERY_INFO, parms);
			List  resultList = ConvertPojoUtil.resultSetToList(rs);
			recommandNewEmp = (RecommandNewEMP) ConvertPojoUtil.mapToBean(new RecommandNewEMP(), (Map)resultList.get(0));
		}catch (SQLException e) {
		    logger.error("SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("文件流读取失败！" + e.getMessage());
		}finally{
			ConnectionManager.closeAll(conn, null, rs);
		}
		return recommandNewEmp;

	}

}

