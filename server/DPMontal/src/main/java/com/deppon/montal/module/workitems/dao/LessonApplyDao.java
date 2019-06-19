
    package com.deppon.montal.module.workitems.dao; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OAAssessreduceApply;
import com.deppon.montal.model.OALessonApply;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: LessonApplyDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description:(课程研发/审核申请工作流数据处理) 
 * @author 廖建雄 
 * @date 2013-7-16 下午3:23:50 
 * @version V1.0 
 */
public class LessonApplyDao implements ILessonApplyDao {
    
    private static Logger logger = Logger.getLogger(LessonApplyDao.class);
    private static String QUERY_OALESSONAPPLY_INFO = "" +
    		"SELECT L.*, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'ABF_LESSONTYPE' AND D.DICTID = L.lessontype" +
    		")LESSONTYPE, " +
    		"(" +
    		" SELECT D.DICTNAME FROM EOS_DICT_ENTRY D " +
    		"  WHERE D.DICTTYPEID = 'ABF_LESSONGROUP' AND D.DICTID = L.MANAGERGROUP" +
    		")MANAGERGROUP  " +
    		"FROM OALESSONAPPLY L  " +
    		"WHERE PROCESSINSTID = ? ";

    @Override
    public OALessonApply getLessonApply(String processinstid) {
	String sql = QUERY_OALESSONAPPLY_INFO;
	Object[] params = {processinstid};
	OALessonApply info = new OALessonApply();
	ResultSet rs = null;
	Connection conn = ConnectionManager.getConnection();
	
	try {
	    //查询数据库
	    rs = ConnectionManager.query(conn, sql, params);
	    //将rs 转换为list
	    List list = ConvertPojoUtil.resultSetToList(rs); 
	    
	    //判空返回
	    if (list.size() == 0) 
		return info;
	    
	    //映射pojo
	    info = (OALessonApply) ConvertPojoUtil.mapToBean(
		    new OALessonApply(), (Map)list.get(0));
	    
	} catch (SQLException e) {
	    logger.error("ERROR:[LessonApplyDao] SQL Query  Failure!" + 
		    e.getMessage());
	} catch (IOException e) {
	    logger.error("ERROR:[LessonApplyDao] ResultSet To List Failure!" +
		    e.getMessage());
	} finally {
	    ConnectionManager.closeAll(conn, null, rs);
	}
	return info;
    }

}

