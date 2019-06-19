package com.deppon.montal.module.notice.service;

import java.io.File;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.deppon.montal.model.MonthPaperEntity;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ImageUtil;
import com.deppon.montal.util.ImgUtil;
import com.deppon.montal.util.InitDataServlet;

public class MonthPaperService implements IMonthPaperService {
	private static Logger logger = Logger.getLogger(MonthPaperService.class);

	/**
	 * 查询最新10条（下拉使用）
	 */
	@Override
	public List<MonthPaperEntity> queryMonthPaperList(int pid,int pageNum,int pageSize) {
		
		//查询sql
		String sql = SQLManager.QUERY_MonthPaper_BY_QikanId;
		List<MonthPaperEntity> monthPaperEntityList = new ArrayList<MonthPaperEntity>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String srcFileUrl = InitDataServlet.prop.getProperty("oaArticle_imgsrc");
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pid);
			stmt.setInt(2, pageNum*pageSize);
			stmt.setInt(3, (pageNum-1)*pageSize+1);
			rs = stmt.executeQuery();
			System.out.println(sql);
			System.out.println(pid+"-");
			while(rs.next()){
				MonthPaperEntity monthPaperEntity = 	new MonthPaperEntity() ;
				monthPaperEntity.setArticleId(rs.getInt("ARTICLE_ID"));
				monthPaperEntity.setArticleName(ImgUtil.getTitleImgStr(rs.getString("ARTICLE_NAME")));
				monthPaperEntity.setViewsAmount(rs.getInt("VIEWS_AMOUNT"));
				Clob clob = rs.getClob("CONTENT");//java.sql.Clob
				String content="",pic="";
				if(clob!=null){
					content = clob.getSubString((long)1,(int)clob.length());
					String img=ImgUtil.getImgStr(content);
					if(img==null||img.equals("")){
						pic = "images/default.png";
					}else{
						String imgstr=ImgUtil.getImgStr(content);
						if(imgstr.indexOf("oa.deppon.com")>=0){
							pic=imgstr;
						}else{
							pic = srcFileUrl+imgstr;
						}
					}
				}else{
					pic = "images/default.png";
				}
//				monthPaperEntity.setContent(content);
				monthPaperEntity.setPicture(pic);
			    monthPaperEntityList.add(monthPaperEntity);
			    
			}
		} catch (Exception e) {
		    logger.error(e.getMessage());
		} 
		ConnectionManager.closeAll(conn, null, rs);
		return monthPaperEntityList;
    }
	@Override
	public List<MonthPaperEntity> queryMonthPaperPicList(int pid) {
		List<MonthPaperEntity> monthPaperEntityList = new ArrayList<MonthPaperEntity>();
		//查询sql
		String sql = SQLManager.QUERY_MonthPaperPic_QikanId;
		MonthPaperEntity monthPaperEntity = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String srcFileUrl = InitDataServlet.prop.getProperty("oaArticle_imgsrc");
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pid);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				monthPaperEntity = new MonthPaperEntity();
				monthPaperEntity.setArticleId(rs.getInt("ARTICLE_ID"));
				monthPaperEntity.setArticleName(rs.getString("ARTICLE_NAME"));
				Clob clob = rs.getClob("CONTENT");//java.sql.Clob
				String content="",pic="";
				if(clob!=null){
					content = clob.getSubString((long)1,(int)clob.length());
//					pic = srcFileUrl+ImgUtil.getImgStr(content);
					String imgstr=ImgUtil.getImgStr(content);
					if(imgstr.indexOf("oa.deppon.com")>=0){
						pic=imgstr;
					}else{
						pic = srcFileUrl+imgstr;
					}
				}
////				monthPaperEntity.setContent(content); //文章内容很大 暂不显示
//				File file=new File(pic);
//				String img="d:\\"+InitDataServlet.prop.getProperty("imgnews_srcPath")+"\\peroidical\\"+file.getName();
//				File pfile=new File(img);
//				if(!pfile.exists()){
//					System.out.println("========");
//					img=img(pic);
//				}
				monthPaperEntity.setPicture(pic);
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
	 /**
   	 * 月报数据查询（根据id查询详细月报消息）
   	 * @param id
   	 * @return
   	 */
	@Override
	public MonthPaperEntity queryMonthPaperInformation(int id) {
		//查询sql
		String sql = SQLManager.QUERY_MonthPaper_BY_INFORMATION;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MonthPaperEntity monthPaperEntity = new MonthPaperEntity() ;
		try {
			String srcFileUrl = InitDataServlet.prop.getProperty("oaArticle_imgsrc");
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				monthPaperEntity.setArticleId(rs.getInt("ARTICLE_ID"));
				monthPaperEntity.setArticleName(rs.getString("ARTICLE_NAME"));
				monthPaperEntity.setLayoutId(rs.getInt("LAYOUT_ID"));
				Clob clob = rs.getClob("CONTENT");//java.sql.Clob
				String content="";
				if(clob!=null){
					content = clob.getSubString((long)1,(int)clob.length()).replaceAll("src=\"/dipApp/mail/mail", "src=\""+srcFileUrl+"/dipApp/mail/mail");
					
				}
				monthPaperEntity.setContent(ImgUtil.getContentImgStr(content));
			}
		} catch (SQLException e) {
		    logger.error(e.getMessage());
		} 
		ConnectionManager.closeAll(conn, null, rs);
		return monthPaperEntity;
    
	
	}

}
