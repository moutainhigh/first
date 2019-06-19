package com.deppon.montal.module.notice.service;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.deppon.montal.model.MonthPeriodicalEntity;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ImageUtil;
import com.deppon.montal.util.InitDataServlet;
/**
 * 月报--期刊 每次刷新4条
 * @author gcl
 */
public class MonthPeriodicalService implements IMonthPeriodicalService {
	private static Logger logger = Logger.getLogger(MonthPeriodicalService.class);

	/**
	 * 查询最新4条
	 */
	@Override
	public List<MonthPeriodicalEntity> queryMonthPeriodicalList(int pageNum,int pageSize) {
		
		//查询sql
		String sql = SQLManager.QUERY_MonthQikan_BY_NEW;
		List<MonthPeriodicalEntity> monthPaperEntityList = new ArrayList<MonthPeriodicalEntity>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String srcFileUrl = InitDataServlet.prop.getProperty("oaPeriodical_imgsrc");
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pageNum*pageSize);
			stmt.setInt(2, (pageNum-1)*pageSize+1);
			rs = stmt.executeQuery();
			while(rs.next()){
				MonthPeriodicalEntity monthPaperEntity = 	new MonthPeriodicalEntity() ;
				monthPaperEntity.setPeriodicalId(rs.getInt("PERIODICAL_ID"));
				monthPaperEntity.setPeriodicalNo(rs.getString("PERIODICAL_NO"));
				monthPaperEntity.setTypeId(rs.getInt("TYPE_ID"));
				monthPaperEntity.setPublicationDate(rs.getString("PUBLICATION_DATE"));
				monthPaperEntity.setPublicStatus(rs.getString("PUBLISH_STATUS"));
				if(rs.getString("picture")==null||rs.getString("picture").equals("")){
					monthPaperEntity.setPicture("images/default.png");
				}else{
					String pic=srcFileUrl+rs.getString("picture");
//					File file=new File(pic);
//					String img="d:/"+InitDataServlet.prop.getProperty("imgnews_srcPath")+"/peroidical/"+file.getName();
//					File pfile=new File(img);
//					if(!pfile.exists()){
//						System.out.println("========");
//						img=img(pic);
//					}
					monthPaperEntity.setPicture(pic);
//					monthPaperEntity.setPicture(srcFileUrl+rs.getString("picture"));
				}
			    monthPaperEntityList.add(monthPaperEntity);
			}
		} catch (SQLException e) {
		    logger.error(e.getMessage());
		} 
		ConnectionManager.closeAll(conn, null, rs);
		return monthPaperEntityList;
    }
	
	public String img(String filename){
		File file=new File(filename);
		try {
			ImageUtil.CopyImageFromURL(
					filename,
					InitDataServlet.prop.getProperty("imgnews_srcPath")+"/peroidical/"+file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "d:/"+InitDataServlet.prop.getProperty("imgnews_srcPath")+"/peroidical/"+file.getName();
	}
}
