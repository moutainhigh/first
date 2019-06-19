
    package com.deppon.montal.module.notice.service; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OaAnnounceMent;
import com.deppon.montal.model.OaRollNews;
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
public class AnnounceMentService implements IAnnounceMentService {
    private static Logger logger = Logger.getLogger(ConnectionManager.class);
    
    /**
     * 查询任免列表
     */
    public List<OaAnnounceMent> queryAnnounceMentList(Long empId,String key,int pageNum,int pageSize){
		
    	if(null == key){
			key = "";
		}
		//查询sql
		String sql = SQLManager.QUERY_ANNOUNCEMENT_LIST;
		
		List<OaAnnounceMent> oaAnnounceList = new ArrayList<OaAnnounceMent>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
//已读未读		
			stmt.setString(1,empId+"");
			stmt.setString(2, "%"+key+"%");
			stmt.setInt(3, pageNum*pageSize);
			stmt.setInt(4, (pageNum-1)*pageSize+1);
//暂无		
//			stmt.setString(1, "%"+key+"%");
//			stmt.setInt(2, pageNum*8);
//			stmt.setInt(3, (pageNum-1)*8+1);
			
			rs = stmt.executeQuery();
		    // 将 ResultSet 转化为List
		    List  resultList = ConvertPojoUtil.resultSetToList(rs);
		    for (int i = 0; i < resultList.size(); i++) {
			// 转换成POJO
			oaAnnounceList.add((OaAnnounceMent) ConvertPojoUtil.mapToBean(new OaAnnounceMent(),
				(Map)resultList.get(i)));
		    }
		} catch (SQLException e) {
		    logger.error(e.getMessage());
		} catch (IOException e) {
		    logger.error(e.getMessage());
		}
		ConnectionManager.closeAll(conn, null, rs);
		return oaAnnounceList;
    }
    
    /**
     * 获取公告详细
     */
    public OaAnnounceMent queryById(String ggId){
		OaAnnounceMent oaAnn = null ;
		String sql = SQLManager.QUERY_ANNOUNCEMENT_BY_ID;
		Object[] params = {ggId};
		// 连接数据库
		Connection conn = ConnectionManager.getConnection();
		ResultSet rs = null;
		try {
		    rs = ConnectionManager.query(conn, sql, params);
		    // 将 ResultSet 转化为List
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		    // 转换成POJO
		    oaAnn = (OaAnnounceMent) ConvertPojoUtil.mapToBean(new OaAnnounceMent(), (Map)resultList.get(0));
		} catch (SQLException e) {
		    logger.error(e.getMessage());
		} catch (IOException e) {
		    logger.error(e.getMessage());
		}
		// 关闭连接
		ConnectionManager.closeAll(conn, null, rs);
		return oaAnn;
    }
    
    /**
     * 公告未读置已读
     * @param ggId
     * @param empId
     * @param empName
     */
    public void insertBulletinClick(String ggId,Long empId,String empName){
    	
    	String sql = SQLManager.INSERT_BULLETIN_CLICK;
    	
    	Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql); 
			java.util.Date dd=new java.util.Date();
	    	 SimpleDateFormat  date = new SimpleDateFormat ("yyyyMMddHHmmssms");
	    	 String ckbh = date.format(dd) + empId;
			stmt.setString(1, ckbh);
			stmt.setString(2, ggId);
			stmt.setString(3,empId+"");
			stmt.setString(4, empName);
			stmt.setLong(5, 1);
			stmt.setString(6, ggId);
			stmt.setString(7,empId+"");
			
			stmt.executeUpdate();
		}catch (SQLException e) {
		    logger.error(e.getMessage());
		} finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, null);
		}
    }
    
    
    /**
     * 查询图片新闻列表
     * @param empId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<OaRollNews>  queryRollnews(Long empId,int pageNum,int pageSize){
    	
    	//查询sql
		String sql = SQLManager.QUERY_ROLLNEW_LIST;
		
		List<OaRollNews> list = new ArrayList<OaRollNews>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
	
			stmt.setString(1,empId.toString());
			stmt.setInt(2, pageNum*pageSize);
			stmt.setInt(3, (pageNum-1)*pageSize+1);
			
			rs = stmt.executeQuery();
			
		    // 将 ResultSet 转化为List
		    List  resultList = ConvertPojoUtil.resultSetToList(rs);
			
			for (int i = 0; i < resultList.size(); i++) {
				// 转换成POJO
				list.add((OaRollNews) ConvertPojoUtil.mapToBean(new OaRollNews(),
					(Map)resultList.get(i)));
			}
			System.out.println("=================-----------");
		}catch (SQLException e) {
		    logger.error(e.getMessage());
		} catch (IOException e) {
		    logger.error(e.getMessage());
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, null);
		}
		
		return list;
    }
    
    /**
     * 查询图片新闻详情
     * @param ggid
     * @return
     */
    public OaRollNews getRollnewDetail(String ggid){
    	
    	//查询sql
		String sql = SQLManager.QUERY_ROLLNEW_BY_ID;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		OaRollNews rollnew = null;
		
		try{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
	
			stmt.setString(1,ggid);
			rs = stmt.executeQuery();
			
			// 将 ResultSet 转化为List
		    List resultList = ConvertPojoUtil.resultSetToList(rs);
		   
		    // 转换成POJO
		    rollnew = (OaRollNews) ConvertPojoUtil.mapToBean(new OaRollNews(), (Map)resultList.get(0));
			
		}catch (SQLException e) {
		    logger.error(e.getMessage());
		} catch (IOException e) {
		    logger.error(e.getMessage());
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, null);
		}
		
		return rollnew;
    }
    
    
    /**
     * 压缩图片
     * @param startDate
     */
    public List<String> queryRollnewImage(Date startDate){
    	
    	//查询sql
		String sql = SQLManager.ROLLNEW_IMAGE_SQL;
		
		List<String> filelsit = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
    	
		try{
			
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
	
			stmt.setDate(1, startDate);
			rs = stmt.executeQuery();
			while(rs.next()){
				filelsit.add(rs.getString("filename"));
			}
			
		}catch(Exception e){
			
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, null);
		}
		return filelsit;
		
    }
public List<OaRollNews>  queryNewsList(Long empId,int pageNum,int pageSize){
    	
    	//查询sql
		String sql = SQLManager.QUERY_NEWS_LIST;
		
		List<OaRollNews> list = new ArrayList<OaRollNews>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
	
			stmt.setString(1,empId.toString());
			stmt.setInt(2, pageNum*pageSize);
			stmt.setInt(3, (pageNum-1)*pageSize+1);
			
			rs = stmt.executeQuery();
			
		    // 将 ResultSet 转化为List
		    List  resultList = ConvertPojoUtil.resultSetToList(rs);
			
			for (int i = 0; i < resultList.size(); i++) {
				// 转换成POJO
				list.add((OaRollNews) ConvertPojoUtil.mapToBean(new OaRollNews(),
					(Map)resultList.get(i)));
			}
			
		}catch (SQLException e) {
		    logger.error(e.getMessage());
		} catch (IOException e) {
		    logger.error(e.getMessage());
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, null);
		}
		
		return list;
    }

@Override
public List<OaRollNews> queryNewsByDate(String startDate, String endDate) {
	//查询sql
	String sql = SQLManager.QUERY_NEWS_BYDATA;
	logger.info("获得SQL"+sql);
	List<OaRollNews> list = new ArrayList<OaRollNews>();
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try{
		conn = ConnectionManager.getConnection();
		stmt = conn.prepareStatement(sql);

		stmt.setString(1,startDate);
		stmt.setString(2, endDate);
		logger.info("查询时间段"+startDate+"至"+endDate);
		rs = stmt.executeQuery();
		
	    // 将 ResultSet 转化为List
	    List  resultList = ConvertPojoUtil.resultSetToList(rs);
	    logger.info("获得查询结果"+resultList);
		for (int i = 0; i < resultList.size(); i++) {
			// 转换成POJO
			list.add((OaRollNews) ConvertPojoUtil.mapToBean(new OaRollNews(),
				(Map)resultList.get(i)));
		}
	}catch (SQLException e) {
		logger.error("查询失败");
	    logger.error(e.getMessage());
	} catch (IOException e) {
		logger.error("查询失败");
	    logger.error(e.getMessage());
	}finally{
		//关闭连接
		ConnectionManager.closeAll(conn, stmt, null);
	}
	return list;
}
}

