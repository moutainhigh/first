package com.deppon.montal.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.Date;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.html.CreateFile;
import com.deppon.montal.html.RollNewsHtmlInfo;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ImgUtil;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.StringUtil;

/**
 * 定时去门户下载图片（已作废）
 * @author Administrator
 *
 */
public class ImageCompressService implements IAppThreadService {
	private static Logger logger  = Logger.getLogger(ImageCompressService.class);
	
	@Override
	public void run() {
		File srcFile = new File(InitDataServlet.prop.getProperty("imgnews_srcPath"));
		File distFile = new File(InitDataServlet.prop.getProperty("imgnews_distPath"));
		String srcFileUrl = InitDataServlet.prop.getProperty("imgnews_srcServerUrl");
		
		ImgUtil imgUtil = new ImgUtil();
		
		while(true){
			
			System.out.println("ImageCompressService start....");
			
			List<Map> imgs = getRecentImgs();
			
			//下载并压缩图片
			for(Map img : imgs){
				String fileName = (String)img.get("FILE_NEW_NAME");
				if( StringUtil.isEmptyOrNull( fileName ) ) continue;
				File targetFile = new File(distFile,fileName);
				//if( targetFile.exists() ) continue;//判断文件是否已经存在
				fetchRemoteImgFile( srcFileUrl, srcFile.getAbsolutePath(), fileName );
				imgUtil.compressImg(srcFile.getAbsolutePath(), distFile.getAbsolutePath(), fileName);
				
			}
			
			//生成图片新闻Html
			RollNewsHtmlInfo.createHtmlForRollNew(imgs);
			
			System.out.println("ImageCompressService end ....");
			try {
				Thread.sleep(3*60*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private List<Map> getRecentImgs(){
		List<Map> imgs=null;
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		SimpleDateFormat dtfmt1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dtfmt2 = new SimpleDateFormat("MM-dd");
		try{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement("select s.* from (select v.ggid,v.lmid,v.fbr,v.tpsm, v.header,v.fbdate,v.content,v.sfcompdoc,v.jjgg,v.savedate,f.file_new_name  " +
										" from (select * from (select gg.ggid,gg.lmid,gg.fbr,gg.tpsm,gg.header,gg.fbdate,gg.content, " +
										" gglm.sfcompdoc,gg.jjgg,gg.savedate from oa_gg gg inner join oa_gglm gglm on gg.lmid = gglm.lmid " +
										" where gg.lmid = 25 order by gg.savedate desc) where rownum < 10) v " +
										" left join at_fileupload f on v.ggid = f.relation_id(+) and f.group_id = 'rollPaper' " +
										" where f.file_new_name is not null order by v.savedate desc)s where rownum < 6 ");
			rs = stmt.executeQuery();
			imgs = new ArrayList<Map>();
			String content = "";
			Clob clobContent = null;
			while(rs.next()){
				Map item = new LinkedHashMap();
				Integer ggid = rs.getInt("GGID");
				Date fbdate = rs.getDate("FBDATE");
				
				clobContent = rs.getClob("CONTENT");
				if(null != clobContent){
					content = clobContent.getSubString((long)1, (int)clobContent.length());
				}else{
					content = "";
				}
				
				item.put("FILE_NEW_NAME", rs.getString("FILE_NEW_NAME"));
				item.put("HEADER", rs.getString("HEADER"));
				item.put("GGID", ggid.toString());
				item.put("FBDATE", dtfmt1.format(fbdate));
				item.put("SHORTFBDATE", dtfmt2.format(fbdate));
				item.put("CONTENT", content);
				item.put("FBR", rs.getString("FBR"));
				item.put("TPSM", rs.getString("TPSM"));
				logger.info(" CONTENT ==================="+content);
				imgs.add(item);
			}
		} catch ( Exception e ){
			logger.error("get recent img error: "+e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		return imgs;
	}
	
	private void fetchRemoteImgFile( String URL, String distPath, String filename ){
		//FileInputStream flin = null;
		URLConnection  urlconn = null;
		BufferedInputStream bufin = null;
		FileOutputStream flout = null;
		BufferedOutputStream bufout = null;
		
		try {
			logger.info("fetchRemoteImgFile["+URL+filename+"]");
			
			URL  remoteFile=new  URL(URL+filename);
			urlconn = remoteFile.openConnection();
			bufin = new BufferedInputStream(urlconn.getInputStream());
			
			logger.info("copy file["+distPath+"/"+filename+"]");
			flout = new FileOutputStream(distPath+"/"+filename);
			bufout = new BufferedOutputStream(flout);
			
			byte[] bytes = new byte[1024];
			int rbytes=0;
			while( (rbytes=bufin.read(bytes)) != -1 ){
				bufout.write(bytes,0,rbytes);
				bufout.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			/*try{
				flin.close();
			}catch(Exception e){}*/
			try{
				bufin.close();
			}catch(Exception e){}
			try{
				flout.close();
			}catch(Exception e){}
			try{
				bufout.close();
			}catch(Exception e){}
		}
	}
	
	public static void main(String[] args){
		ImageCompressService s = new ImageCompressService();
		s.fetchRemoteImgFile("http://192.168.17.25/portal/upload/oaGg/", "d:\\oaupload\\oaGg", "402891f83da625a8013da63ee77c09db.jpg");
	}
}
