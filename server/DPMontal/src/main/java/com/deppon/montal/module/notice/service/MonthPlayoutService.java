package com.deppon.montal.module.notice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.deppon.montal.model.MonthLayoutEntity;
import com.deppon.montal.model.MonthPaperEntity;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ImgUtil;

public class MonthPlayoutService implements IMonthPlayoutService {
	private static Logger logger = Logger.getLogger(MonthPlayoutService.class);

	/**
	 * 查询板块
	 */
	@Override
	public List<MonthLayoutEntity> queryMonthPlayoutList(int pid) {
		
		//查询sql
		String sql = SQLManager.QUERY_MonthLayout_QikanId;
		List<MonthLayoutEntity> monthPlayoutEntityList = new ArrayList<MonthLayoutEntity>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pid);
			rs = stmt.executeQuery();
			while(rs.next()){
				MonthLayoutEntity monthlayoutEntity = 	new MonthLayoutEntity() ;
				monthlayoutEntity.setLayoutId(rs.getInt("LAYOUT_ID"));
				monthlayoutEntity.setLayoutName(rs.getString("LAYOUT_NAME"));
				monthlayoutEntity.setPeriodicalId(rs.getInt("PERIODICAL_ID"));
				monthPlayoutEntityList.add(monthlayoutEntity);
			    
			}
		} catch (Exception e) {
		    logger.error(e.getMessage());
		} 
		ConnectionManager.closeAll(conn, null, rs);
		return monthPlayoutEntityList;
    }
	/**
	 * 查询板块
	 */
	@Override
	public List<MonthPaperEntity> queryMonthPaperList(int layoutid,int pageNum,int pageSize) {
		
		//查询sql
		String sql = SQLManager.QUERY_Monthpaper_Layoutid;
		List<MonthPaperEntity> monthPlayoutEntityList = new ArrayList<MonthPaperEntity>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			MonthPaperEntity monthPaperEntity = null;
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, layoutid);
			stmt.setInt(2, pageNum*pageSize);
			stmt.setInt(3, (pageNum-1)*pageSize+1);
			rs = stmt.executeQuery();
			while(rs.next()){
				monthPaperEntity = new MonthPaperEntity();
				monthPaperEntity.setArticleId(rs.getInt("ARTICLE_ID"));
				monthPaperEntity.setArticleName(ImgUtil.getTitleImgStr(rs.getString("ARTICLE_NAME")));
				monthPlayoutEntityList.add(monthPaperEntity);
//			    System.out.println(monthPaperEntity.getArticleName()+"----------");
			}
		} catch (Exception e) {
		    logger.error(e.getMessage());
		} 
		ConnectionManager.closeAll(conn, null, rs);
		return monthPlayoutEntityList;
    }
}
