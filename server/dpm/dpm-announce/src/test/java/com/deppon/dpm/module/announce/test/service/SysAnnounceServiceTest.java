package com.deppon.dpm.module.announce.test.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.announce.server.service.IAnnounceLogService;
import com.deppon.dpm.module.announce.server.service.IAnnounceService;
import com.deppon.dpm.module.announce.server.service.ISynAnnounceService;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;
import com.deppon.dpm.module.announce.shared.dto.AnnounceDto;
import com.deppon.dpm.module.announce.shared.util.ImagePressPic;
import com.deppon.dpm.module.announce.test.BaseTestCase;
import com.deppon.dpm.module.announce.test.domain.OAAnnounce;

public class SysAnnounceServiceTest extends BaseTestCase{
	
	private String webUrl;
	@Autowired
	private IAnnounceService announceService;
	@Autowired
	private IAnnounceLogService announceLogService;
	@Autowired
	private ISynAnnounceService synAnnounceService;
	
	@Test
	public void SynAnnounceInsertRequest(){
		List<AnnounceEntity> list = announceService.queryNormalNews(1, 0);
		for(AnnounceEntity entity : list){
			//System.out.println("正文图片路径："+entity.getAttachmentPath());
			//System.out.println("滚动图片路径："+entity.getSrcollImagPath());
			OAAnnounce oa = new OAAnnounce();
			//OA原Id
			oa.setId(entity.getOaId());
			//状态
			oa.setOptState("INSERT");
			//标题
			oa.setTitle("111111");
			//内容
			oa.setContent("222222");
			Long time = new Date().getTime();
			//发布时间
			oa.setPublishTime(String.valueOf(time));
			//类型
			oa.setType("NEWS");
			//滚动图片路径
			oa.setScrollImg(entity.getSrcollImagPath());
			//正文图片路径
			oa.setConImg(entity.getAttachmentPath());
			//正文图片名
			oa.setConImgName(entity.getConImgName());
			//滚动图片名
			oa.setScrollImgName(entity.getScrollImgName());
			String announeJson = JSONObject.toJSONString(oa);
//			System.out.println(announeJson);
			try {
				synAnnounceService.synAnnounceRequest(announeJson);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	class SysAnnounceEntity{
		private String conImgName;
		private String scrollImgName;
		private String scrollImg;
		private List<String> deleteList;
		private String title;
		private Long publishTime;
		private String type;
		private String optState;
		private String content;
		private String conImg;
		private String id;
		public String getConImgName() {
			return conImgName;
		}
		public void setConImgName(String conImgName) {
			this.conImgName = conImgName;
		}
		public String getScrollImgName() {
			return scrollImgName;
		}
		public void setScrollImgName(String scrollImgName) {
			this.scrollImgName = scrollImgName;
		}
		public String getScrollImg() {
			return scrollImg;
		}
		public void setScrollImg(String scrollImg) {
			this.scrollImg = scrollImg;
		}
		public List<String> getDeleteList() {
			return deleteList;
		}
		public void setDeleteList(List<String> deleteList) {
			this.deleteList = deleteList;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Long getPublishTime() {
			return publishTime;
		}
		public void setPublishTime(Long publishTime) {
			this.publishTime = publishTime;
		}
		public String getOptState() {
			return optState;
		}
		public void setOptState(String optState) {
			this.optState = optState;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getConImg() {
			return conImg;
		}
		public void setConImg(String conImg) {
			this.conImg = conImg;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
	
	@Test
	public void SynAnnounceRequest() throws IOException{
//		BufferedReader br = new BufferedReader(new FileReader(new File("/opt/apk/sysAnnounce.txt")));
//		String announeJson = br.readLine();
//		br.close();
		SysAnnounceEntity entity = new SysAnnounceEntity();
		entity.setConImgName("neiye .jpg");
		entity.setScrollImgName("首页.jpg");
		entity.setScrollImg("http://192.168.68.117:8083/4028822a53e61c4401550411bb4c3b92.jpg");
		entity.setTitle("一生挚爱，一路前行  我司第十一届集体婚礼即将开启 (图)");
		entity.setPublishTime(1464624000000L);
		entity.setType("NEWS");
		entity.setOptState("UPDATE");
		entity.setContent("内容..");
		entity.setConImg("http://192.168.68.117:8083/4028822a53e61c4401550411bb4c3b92.jpg");
		entity.setId("1745955");
		synAnnounceService.synAnnounceRequest(JSON.toJSONString(entity));
	}
	
	private static String StreamToStr(File file){
		InputStream is;
		String str = null;
		try {
			is = new FileInputStream(file);
			byte buffer[] = new byte[8192];
			int count = 0;
			StringBuffer buff = new StringBuffer();
			while ((count = is.read(buffer)) != -1) {
				String s = new String(buffer,0,count,"gbk");  
				buff.append(s);
			}
			is.close();
			str = buff.toString();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return str;
	}
	
	/**
	 * 
	* @Title: operate 
	* @Description: 同步OA资讯(任免公告、新闻动态、高管随笔)
	* @param @param entity
	* @param @return    设定文件 
	* @return Response    返回类型 
	* @throws IOException
	 */
	private static AnnounceEntity getAnnounceEntity(JSONObject jsonObject){
		try {
			String oaId = jsonObject.get("id").toString();
			String publishTime = jsonObject.get("publishTime").toString();
			String content = jsonObject.get("content").toString();
			String title = jsonObject.get("title").toString();
			String conImg = jsonObject.get("conImg").toString();
			String scrollImg = jsonObject.get("scrollImg").toString();
			String type = jsonObject.get("type").toString();
			String conImgName = jsonObject.get("conImgName").toString();
			String scrollImgName = jsonObject.get("scrollImgName").toString();
			Long longDate = Long.valueOf(publishTime);
			Date publishDate = new Date(longDate);
			//String scrollImgPath = getScrollImgPath(scrollImg, scrollImgName);
			//String conImgPath = getConImgPath(conImg, conImgName);
			AnnounceEntity announceEntity = new AnnounceEntity();
			announceEntity.setOaId(oaId);
			announceEntity.setTitle(title);
			announceEntity.setType(type);
			announceEntity.setPublishTime(publishDate);
			announceEntity.setContent(content);
			//announceEntity.setAttachmentPath(conImgPath);
			//announceEntity.setSrcollImagPath(scrollImgPath);
			return announceEntity;
		} catch (Exception e) {
			//logger.info(e.getMessage());
		}
		return null;
	}
	
	
	@Test
	public void proCreateImage(){
		AnnounceDto queryParam = new AnnounceDto();
		queryParam.setType("NEWS");
		queryParam.setId("57451b4d-29a6-4408-9621-64bf04b95ab6");
		List<AnnounceEntity> list = announceService.queryCommonAll(1000, 0, queryParam);
		if(null == list){
			return;
		}
		int row = 0;
		for(AnnounceEntity entity : list){
			AnnounceEntity newEntity = new AnnounceEntity();
			String scrollImgPath = entity.getSrcollImagPath();
		    String conImgPath = entity.getAttachmentPath();
		    newEntity.setId(entity.getId());
			if(StringUtils.isNotEmpty(scrollImgPath)){
				String appScrollImgPath = pressImage(scrollImgPath);
				//entity.setAppScrollImgPath(appScrollImgPath);
				newEntity.setAppScrollImgPath(appScrollImgPath);
			}
			if(StringUtils.isNotEmpty(conImgPath)){
				String appConImgPath = pressImage(conImgPath);
				//entity.setAppConImgPath(appConImgPath);
				newEntity.setAppConImgPath(appConImgPath);
			}
			row = announceService.update(newEntity);
			row += 1;
		}
		System.out.println("更新总行数："+row);
	}
	
	
	
	private String pressImage(String imgURLPath){
		int index = imgURLPath.lastIndexOf("/");
		String imageName = imgURLPath.substring(index + 1, imgURLPath.length());	
		String inputDir = getImagePath();
		String inputFileName = imageName,outputFileName=imageName;
		//获得存放应用的路径
		String saveImagePath = inputDir+imageName;
		File imageFile = new File(saveImagePath);
		String imagePressPath ="/upload/announce/image/press/"+imageName;
		//如果存在文件，则不保存
		if(imageFile.exists()){
			ImagePressPic prePic = new ImagePressPic();
			String outputDir = inputDir+"press";
			File savedDir = new File(outputDir);
			//如果不存在文件夹
			if(!savedDir.exists()) {
				savedDir.mkdirs();
			}
			prePic.compressPic(inputDir, outputDir+"\\", inputFileName, outputFileName, 300, 300, true);
			return imagePressPath;
		}
		//添加图片到此应用目录下
		else{
			String imgUrl=imgURLPath,fileURL=getImagePath();
			boolean flag = makeImg(imgUrl,fileURL);
			//成功保存图片
			if(flag){
				File newImageFile = new File(fileURL+"\\"+imageName);
				if(newImageFile.exists()){
					ImagePressPic prePic = new ImagePressPic();
					String outputDir = inputDir+"press";
					File savedDir = new File(outputDir);
					//如果不存在文件夹
					if(!savedDir.exists()) {
						savedDir.mkdirs();
					}
					prePic.compressPic(inputDir, outputDir+"\\", inputFileName, outputFileName, 300, 300, true);
					return imagePressPath;
				}
			}
		}
		return null;
	}
	
	private String getImagePath(){
		String savePath = null;
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
		String secendPath = path.substring(1, path.lastIndexOf("/"));
		String absolutelyPath = secendPath.substring(0,secendPath.lastIndexOf("/"));
		String webAnnouncePath = absolutelyPath.substring(0,absolutelyPath.lastIndexOf("/"));
		String dmpPath = webAnnouncePath.substring(0,webAnnouncePath.lastIndexOf("/"));
		StringBuffer webRootPath = new StringBuffer();
		webRootPath.append(dmpPath.replace("/", "\\"));
		webRootPath.append("\\dpm-web\\src\\main\\webapp");
		String rootPath = webRootPath.toString();
		String directPath = "\\upload\\announce\\image\\";
		File savedDir = new File(rootPath+directPath);
		//如果不存在文件夹
		if(!savedDir.exists()) {
			savedDir.mkdirs();
			//String message = "文件夹创建成功！";
		}
		savePath = rootPath+directPath;
		return savePath;
	}
	
	
	private boolean makeImg(String imgUrl, String fileURL) {
		boolean flag = false;
		try {
			// 创建流
			BufferedInputStream is = new BufferedInputStream(
					new URL(imgUrl).openStream());
			// 生成图片名
			int index = imgUrl.lastIndexOf("/");
			String sName = imgUrl.substring(index + 1, imgUrl.length());
			System.out.println(sName);
			// 存放地址
			File img = new File(fileURL + "\\" + sName);
			// 生成图片
			BufferedOutputStream os = new BufferedOutputStream(
					new FileOutputStream(img));
			byte buffer[] = new byte[8192];
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			is.close();
			os.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}

