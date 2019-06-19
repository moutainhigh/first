/**
 * 
 */
package com.deppon.montal.module.notice.action;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.module.notice.service.AnnounceMentService;
import com.deppon.montal.module.notice.service.IAnnounceMentService;
import com.deppon.montal.util.ImgUtil;
import com.deppon.montal.util.InitDataServlet;

/**
 * @author yin
 * 压缩图片新闻图片
 *
 */
public class NewOfRollNewsImageAction1 extends AppDelegateAction {

	  private static final long serialVersionUID = 1L;

	  private static IAnnounceMentService announceService = new AnnounceMentService();
	  
	  protected void response() {
		  
		  Date date = null;
		  String dateStr =  reqPara.get("sdate");
		  if(null != dateStr){
			  date = Date.valueOf(dateStr);
		  }
		  
		  List<String> list = announceService.queryRollnewImage(date);
		  
		  //压缩图片
		  int count = create(list);
		  
		  try {
			response.getWriter().write("压缩成功：一共"+count+"条.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	 
	  /**
	   * 压缩图片
	   * @param fileNames
	   */
	  public int create(List<String> fileNames){
		  
		  
		  File pathFile = new File(InitDataServlet.prop.getProperty("imgnews_distPath"));
		  
		  File fileL = new File(pathFile.getAbsolutePath()+"/list");
		  if(!fileL.exists()){
			  fileL.mkdirs();
		  }
		  File fileD = new File(pathFile.getAbsolutePath()+"/detail");
		  if(!fileD.exists()){
			  fileD.mkdirs();
		  }
		  
		  ImgUtil imgUtil = new ImgUtil();
		  int count = 0;
		  for(String filename :fileNames){
			   String rt = imgUtil.compressPic(pathFile.getAbsolutePath()+"/", pathFile.getAbsolutePath()+"/list/", filename, filename, 120, 120, true);
			   rt = imgUtil.compressPic(pathFile.getAbsolutePath()+"/", pathFile.getAbsolutePath()+"/detail/", filename, filename, 400, 400, true);
 			  if(null != rt && rt.equals("ok")){
 				  count+=1;
 			  }
		  }
		  return count;
	  }
	  
	  
	  @Override
	  protected void mapParameters() {
	      super.mapParameters();
	  }
}
