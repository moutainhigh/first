
package com.deppon.montal.module.notice.service; 
   /** 
 * @Title: SqlManager.java
 * @Package com.deppon.montal.module.notice.service 
 * @Description: (SQL语句管理类) 
 * @author 廖建雄 
 * @date 2013-2-21 下午3:51:46 
 * @version V1.0 
 */
public class SQLManager {
    
//	 /**查询任免公告List*/
    public static final String QUERY_ANNOUNCEMENT_LIST = "" +
    		  " select * from (select s1.*, rownum rd "+
    		  " from (select gg.ggid, gg.header, gg.fbr, gg.fbdate,obc.ckbh"+
    		  " from oa_gg gg,(select * from oa_bulletin_click obc where obc.ckempid = ? ) obc "+
    		  " where gg.ggid = obc.ggid(+) and gg.lmid = 909 and gg.header like ? "+
    		  " order by gg.fbdate desc)s1  where rownum <=?)s2 " +
    		  " where s2.rd >=? ";
    
    /**查询任免公告List*/
//    public static final String QUERY_ANNOUNCEMENT_LIST = "" +
//    		         " select * from (select s1.*, rownum rd "+
//    				 " from (select gg.ggid, gg.header, gg.fbr, gg.fbdate,null ckbh "+
//    				 " from oa_gg gg  where gg.lmid = 909 and gg.header like ? "+
//    				 " order by gg.fbdate desc)s1  where rownum <=?)s2 " +
//    				 " where s2.rd >=? ";
    
    
    
    /**根据公告ID获取公告详细信息*/
    public static final String QUERY_ANNOUNCEMENT_BY_ID = "" +
    		"select gg.ggid,gg.lmid,gg.header,gg.fbr,gg.fbdate,gg.keepdate,gg.ggfw,gg.ggfwname,gg.jjgg,gg.savedate,gg.content " +
    		"from oa_gg gg" +
    		" where gg.ggid = ?";
    
    /**公告未读置已读**/
    public static final String INSERT_BULLETIN_CLICK = ""+
    		 " insert into oa_bulletin_click(CKBH,GGID, CKEMPID, CKEMPNAME, CKCS, CKSJ) "+
             " select ?,?, ?, ?, ?, sysdate from dual dl "+
             " where not exists(select 1 from oa_bulletin_click bc where bc.ggid = ? and bc.ckempid = ?) ";
    
    /**查询图片新闻**/
    public static final String QUERY_ROLLNEW_LIST = ""+
    		"SELECT *                                                                       "+
    		"  FROM (SELECT S.*, ROWNUM RD                                                  "+
    		"          FROM (SELECT V.GGID,                                                 "+
    		"                       V.FBR,                                                  "+
    		"                       V.TPSM,                                                 "+
    		"                       V.HEADER,                                               "+
    		"                       V.FBDATE,                                               "+
    		"                       V.SAVEDATE,                                             "+
    		"                       F.FILE_NEW_NAME filename,                               "+
    		"                       v.CKBH,                                                  "+
    		"                       v.CONTENT                                                "+
    		"                  FROM (SELECT *                                               "+
    		"                          FROM (SELECT GG.GGID,                                "+
    		"                                       GG.FBR,                                 "+
    		"                                       GG.TPSM,                                "+
    		"                                       GG.HEADER,                              "+
    		"                                       GG.FBDATE,                              "+
    		"                                       GG.SAVEDATE,                            "+
    		"                                       OBC.CKBH,                                "+
    		"                                       GG.CONTENT                             "+
    		"                                  FROM DIPOA.OA_GG GG                          "+
    		"                                  LEFT JOIN (SELECT *                          "+
    		"                                              FROM dipoa.OA_BULLETIN_CLICK OBC "+
    		"                                             WHERE OBC.CKEMPID = ?) OBC   "+
    		"                                    ON GG.GGID = OBC.GGID                      "+
    		"                                 WHERE GG.LMID = 25                            "+
    		"                                 ORDER BY GG.SAVEDATE DESC)) V                 "+
    		"                  LEFT JOIN DIPOA.AT_FILEUPLOAD F                              "+
    		"                    ON (V.GGID = F.RELATION_ID                                 "+
    		"                   AND F.GROUP_ID = 'rollPaper')                               "+
    		"                 WHERE F.FILE_NEW_NAME IS NOT NULL                             "+
    		"                 ORDER BY V.SAVEDATE DESC) S                                   "+
    		"         WHERE ROWNUM <= ?) V1                                                  "+
    		" WHERE V1.RD >= ?                                                              ";

    /**查询图片新闻详情**/
    public static final String QUERY_ROLLNEW_BY_ID = ""+
    		" SELECT GG.GGID, GG.FBR, GG.TPSM, GG.HEADER, GG.FBDATE,GG.CONTENT, GG.SAVEDATE "+
    		" FROM DIPOA.OA_GG GG "+
    		" WHERE GG.Ggid = ? ";
    
    
    /**图片新闻图片压缩**/
    public static final String ROLLNEW_IMAGE_SQL=""+
   		 " SELECT "+
   		 "      F.FILE_NEW_NAME FILENAME  "+      
   		 " FROM (SELECT * "+
   		 "         FROM (SELECT GG.GGID,   "+                    
   		 "                      GG.SAVEDATE    "+                  
   		 "                 FROM DIPOA.OA_GG GG   "+               
   		 "                WHERE GG.LMID = 25 "+
   		 "                  AND gg.fbdate >= ? "+
   		 "                ORDER BY GG.SAVEDATE DESC)) V "+
   		 "  LEFT JOIN DIPOA.AT_FILEUPLOAD F "+
   		 "    ON (V.GGID = F.RELATION_ID AND F.GROUP_ID = 'rollPaper') "+
   		 "  WHERE F.FILE_NEW_NAME IS NOT NULL    ";   
    
//	 /**查询出差小助手List*/
  public static final String QUERY_Assistants_LIST = ""
  		  +"      select * from (select s1.*, rownum rd " 
  		  +"          from ( "
		  +"			select * from bus_assistant " 
		  +"			where title like ?  order by publishtime desc"
		  +"		)s1  where rownum <=?)s2  "
  		  +"  where s2.rd >=?";
  
  /**根据信息ID获取出出差小助手详细信息*/
  public static final String QUERY_Assistants_BY_ID = "select * from bus_assistant where id=?";
  /**根据id查询详细月报消息*/
  public static final String QUERY_MonthPaper_BY_INFORMATION = "select * from dipoa.OA_ARTICLE where article_id=?";
  
  /**查询月报期刊最新4条消息*/
  public static final String QUERY_MonthQikan_BY_NEW = ""
  		  +"      select * from (select s1.*, rownum rd " 
  		  +"          from ( "
		  +"			select p.*,l.picture from dipoa.OA_PERIODICAL p LEFT JOIN dipoa.OA_LAYOUT l ON p.periodical_id=l.periodical_id AND l.layout_name='A1' where p.type_id=1 and p.publish_status='已发布' order by p.periodical_id DESC" 
		  +"		)s1  where rownum <=?)s2  "
  		  +"  where s2.rd >=?";		
  public static final String QUERY_MonthPaper_BY_QikanId=""
  		  +"      select * from (select s1.*, rownum rd " 
  		  +"          from ( SELECT a.article_id,replace(a.article_name,'color:#000080;font-size:24px;font-weight:bold','') article_name,a.content,a.views_amount FROM dipoa.OA_ARTICLE a,dipoa.OA_LAYOUT l WHERE a.layout_id=l.layout_id AND l.periodical_id=? ORDER BY l.layout_order ASC, a.article_id ASC"
  		  +"		)s1  where rownum <=?)s2  "
 		  +"  where s2.rd >=?";	
  /**获取最新的一条带有图片的文章**/
  public static final String QUERY_MonthPaperPic_QikanId=" select s1.* from (SELECT a.article_id,a.article_name,a.content FROM dipoa.OA_ARTICLE a,dipoa.OA_LAYOUT l WHERE a.layout_id=l.layout_id AND l.periodical_id=? "
		  +" AND a.content LIKE '%<img%' ORDER BY l.layout_order ASC,a.article_id ASC ) s1  where rownum <=3";
  /**获取板块**/
  public static final String QUERY_MonthLayout_QikanId="SELECT l.layout_id,l.layout_name,l.periodical_id FROM dipoa.OA_LAYOUT l WHERE l.periodical_id=? ORDER BY l.layout_order ASC";
  public static final String QUERY_Monthpaper_Layoutid=""
		  +" select * from (select s1.*, rownum rd " 
		  +"   from ( SELECT a.article_id,a.article_name,a.content FROM dipoa.OA_ARTICLE a where a.layout_id=? "
		  +" ORDER BY a.article_id ASC"
		  +"		)s1  where rownum <=?)s2  "
	  +"  where s2.rd >=?";	
  
  /**查询图片新闻**/
  public static final String QUERY_NEWS_LIST = ""+
  		"SELECT *                                                                       "+
  		"  FROM (SELECT S.*, ROWNUM RD                                                  "+
  		"          FROM (SELECT V.GGID,                                                 "+
  		"                       V.FBR,                                                  "+
  		"                       V.TPSM,                                                 "+
  		"                       V.HEADER,                                               "+
  		"                       V.FBDATE,                                               "+
  		"                       V.SAVEDATE,                                             "+
  		"                       F.FILE_NEW_NAME filename,                               "+
  		"                       v.CKBH,                                                  "+
  		"                       v.CONTENT                                                "+
  		"                  FROM (SELECT *                                               "+
  		"                          FROM (SELECT GG.GGID,                                "+
  		"                                       GG.FBR,                                 "+
  		"                                       GG.TPSM,                                "+
  		"                                       GG.HEADER,                              "+
  		"                                       GG.FBDATE,                              "+
  		"                                       GG.SAVEDATE,                            "+
  		"                                       OBC.CKBH,                                "+
  		"                                       GG.CONTENT                             "+
  		"                                  FROM DIPOA.OA_GG GG                          "+
  		"                                  LEFT JOIN (SELECT *                          "+
  		"                                              FROM dipoa.OA_BULLETIN_CLICK OBC "+
  		"                                             WHERE OBC.CKEMPID = ?) OBC   "+
  		"                                    ON GG.GGID = OBC.GGID                      "+
  		"                                 WHERE GG.LMID = 25                            "+
  		"                                 ORDER BY GG.SAVEDATE DESC)) V                 "+
  		"                  LEFT JOIN DIPOA.AT_FILEUPLOAD F                              "+
  		"                    ON (V.GGID = F.RELATION_ID                                 "+
  		"                   AND F.GROUP_ID = 'GgTp')                                    "+
  		"                 WHERE F.FILE_NEW_NAME IS NOT NULL                             "+
  		"                 ORDER BY V.SAVEDATE DESC) S                                   "+
  		"         WHERE ROWNUM <= ?) V1                                                  "+
  		" WHERE V1.RD >= ?                                                              ";

  /**查询图片新闻**/
  public static final String QUERY_NEWS_BYDATA =""+                                                                     
		  "SELECT "+
			"V.GGID, "+
		"V.FBR, "+
			"V.TPSM, "+
		"V.HEADER, "+
			"V.FBDATE, "+
		"V.SAVEDATE, "+
			"F.FILE_NEW_NAME FILENAME, "+
		"V.CONTENT "+
		"FROM  DIPOA.OA_GG v "+
		"LEFT JOIN DIPOA.AT_FILEUPLOAD F ON V.GGID = F.RELATION_ID  AND F. GROUP_ID = 'GgTp' "+
		"WHERE "+
			"F.FILE_NEW_NAME IS NOT NULL "+
		"and v.LMID = 25 "+
		"AND V.FBDATE BETWEEN TO_DATE ( "+
			"?, "+
		"'yyyy-MM-dd HH24:mi:ss' "+
		") "+
		"AND TO_DATE ( "+
			"?, "+
		"'yyyy-MM-dd HH24:mi:ss' "+
		") "+
		"ORDER BY "+
			"V.SAVEDATE DESC ";
}

