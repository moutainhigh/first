
    package com.deppon.montal.module.notice.service; 

import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.BusAssistantMent;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
/** 
 * @Title: AnnounceMentService.java
 * @Package com.deppon.montal.module.todolist.service 
 * @Description: (公告通知) 
 * @author 廖建雄 
 * @date 2013-2-19 下午3:49:16 
 * @version V1.0 
 */
public class BusAssistantMentService implements IBusAssistantMentService {
    private static Logger logger = Logger.getLogger(ConnectionManager.class);
    
    /**
     * 查询出差小助手
     */
    public List<BusAssistantMent> queryAssistantMentList(Long empId,String key,int pageNum,int pageSize){
		
    	if(null == key){
			key = "";
		}
		//查询sql
		String sql = SQLManager.QUERY_Assistants_LIST;
		
		List<BusAssistantMent> oaAnnounceList = new ArrayList<BusAssistantMent>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
//已读未读		
/*			stmt.setString(1,empId+"");
			stmt.setString(2, "%"+key+"%");
			stmt.setInt(3, pageNum*pageSize);
			stmt.setInt(4, (pageNum-1)*pageSize+1);*/
			
			stmt.setString(1, "%"+key+"%");
			stmt.setInt(2, pageNum*pageSize);
			stmt.setInt(3, (pageNum-1)*pageSize+1);

			rs = stmt.executeQuery();
			
			while(rs.next()){
				BusAssistantMent bae = 	new BusAssistantMent() ;
			    bae.setID(rs.getBigDecimal("ID"));
			    bae.setPUBLISHOR(rs.getString("PUBLISHOR"));
			    bae.setPUBLISHTIME(rs.getString("PUBLISHTIME"));
			    bae.setTITLE(rs.getString("TITLE"));
//			    Clob clob = rs.getClob("CONTENT");//java.sql.Clob
//			    bae.setCONTENTSTR(clob.getSubString((long)1,(int)clob.length()));
			    oaAnnounceList.add(bae);
			}
		} catch (SQLException e) {
		    logger.error(e.getMessage());
		} 
		ConnectionManager.closeAll(conn, null, rs);
		return oaAnnounceList;
    }
    
    /**
     * 获取详细
     */
    public BusAssistantMent queryById(String ggId){
    	BusAssistantMent bae = null ;
		String sql = SQLManager.QUERY_Assistants_BY_ID;
		Object[] params = {ggId};
		// 连接数据库
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		try {
			
		    rs = ConnectionManager.query(conn, sql, params);
		    bae = 	new BusAssistantMent() ;
		    while(rs.next()){
				    bae.setID(rs.getBigDecimal("ID"));
				    bae.setPUBLISHOR(rs.getString("PUBLISHOR"));
				    bae.setPUBLISHTIME(rs.getString("PUBLISHTIME"));
				    bae.setTITLE(rs.getString("TITLE"));
				    Clob clob = rs.getClob("CONTENT");//java.sql.Clob
				    bae.setCONTENTSTR(clob.getSubString((long)1,(int)clob.length()));
			}
		    // 将 ResultSet 转化为List
//		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    // 转换成POJO
		   
//		    oaAnn = (BusAssistantMent) ConvertPojoUtil.mapToBean(new BusAssistantMent(), (Map)resultList.get(0));
		} catch (SQLException e) {
		    logger.error(e.getMessage());
		} 
		// 关闭连接
		ConnectionManager.closeAll(conn, null, rs);
		return bae;
    }
}

