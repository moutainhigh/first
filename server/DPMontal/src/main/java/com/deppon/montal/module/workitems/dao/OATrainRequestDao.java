package com.deppon.montal.module.workitems.dao; 


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OATrainRequest;
import com.deppon.montal.model.OAaddAttendance;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
   /** 
 * @Title: OATrainRequestDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: 获取培训申请数据操作层
 * @author yinrongping 
 * @date 2013-8-21 上午8:20:28 
 * @version V1.0 
 */
public class OATrainRequestDao implements IOATrainRequestDao{

	private static Logger logger = Logger.getLogger(OATrainRequestDao.class);
    
    private static String QUERY_INFO_SQL =" " +
    		" select  processinstid,applyname,applyuserid,applydeptname,             "+
    		" begintraindate,endtraindate,expectednum,trainmanagerposition,          "+
    		" lecturername,lectureruserid,trainsubjects,trainorg_name trainorgname,  "+
    		" managerlevel, applyorgid,directoruserid,trainorg,                      "+
    		" (select ede.dictname from eos_dict_entry ede                           "+
    		"   	   where ede.dicttypeid = 'WFS_TRAINTYPE_NEW'                    "+
    		"   	     and ede.dictid = t.traintype) traintype,                    "+
    		"  (select ede.dictname from eos_dict_entry ede                          "+
    		"   	   where ede.dicttypeid = 'DIP_IFVALID'                          "+
    		"   	     and ede.dictid = t.isconsultant) isconsultant               "+
    		"  from oa_trainrequest t where t.processinstid = ?                      ";
	
	/**
	 * 获取培训申请信息
	 */
    @Override
	public OATrainRequest getTrainRequestInfo(String processinstid) {
		
		Object[] params = {processinstid};
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		OATrainRequest request = new OATrainRequest();
		try {
		    rs = ConnectionManager.query(conn, QUERY_INFO_SQL, params);
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    if (resultList.size() > 0) {
		    	request = (OATrainRequest) ConvertPojoUtil.mapToBean(new OATrainRequest(),
				(Map)resultList.get(0));
		    }
		} catch (SQLException e) {
		    logger.error("ERROR:[OATrainRequestDao.getTrainRequestInfo] SQL语句出错！" + e.getMessage());
		} catch (IOException e) {
		    logger.error("ERROR:[OATrainRequestDao.getTrainRequestInfo] rs转换为list失败!" + e.getMessage());
		} finally {
		    ConnectionManager.closeAll(conn, null, rs);
		}
		
		return request;
	}

}

