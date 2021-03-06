package com.deppon.dpm.module.management.server.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.service.IAppDetailService;
import com.deppon.dpm.module.management.shared.domain.AppCommentEntity;
import com.deppon.dpm.module.management.shared.domain.AppDetailEntity;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.Result;


/**
 * 应用详情action
 * @author 491275
 *
 */
@SuppressWarnings("serial")
public class AppDetailAction extends BaseAction{   /*implements ModelDriven<AppDetailEntity>*/
	
	/**
	 * 日志
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AppDetailAction.class);
	/**
	 * 应用详情实体类
	 */
	private AppDetailEntity appdetailEntity = new AppDetailEntity();
	/**
	 * 应用商店实体类
	 */
	private ApplyStore applyStore = new ApplyStore();
	/**
	 * 应用评论实体类列表
	 */
	private List<AppCommentEntity> commentlist = new ArrayList<AppCommentEntity>();
	
	private IAppDetailService appdetailService;
	
	private static final int PAGESIZE_10 = 10;
	
	/**
	 * 应用商店对应id
	 */
	private int appstoreId;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * 应用介绍
	 */
	private String appIntroduce;
	/**
	 * 详细信息
	 */
	private String detailMessage;
	/**
	 * 上传的图片文件
	 */
	private File[] photos;
	/**
	 * 上传的图片名
	 */
	private String[] photosFileName;
	/**
	 * 对应应用id
	 */
	private int appId;
	/**
	 * 评论人id
	 */
	private String empCode;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 评分
	 */
	private int score;
	/**
	 * 总评分
	 */
	private Double totalScore;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页
	 */
	private int currentPage = 1;
	/**
	 * 起始评论编号
	 */
	private int startNo;
	/**
	 * 每页条数
	 */
	private int pageSize = PAGESIZE_10;
	/**
	 * 该应用评论总条数
	 */
	private int commentCount;
	/**
	 * 新特性
	 */
	private String newFeature;
	/**
	 * 评论id
	 */
	private int commentId;
	/**
	 * 评论回复内容
	 */
	private String replyContent;
	

	/**
	 * 传给前端显示所有应用
	 */
	@CookieNotCheckedRequired
	public String showAllApp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<ApplyStore> list = new ArrayList<ApplyStore>();
		try{
			//应用列表
			list = appdetailService.selectAllAppId();
		}catch (Exception e) {
			Log.error("查询应用列表失败! " + e);	
		}
		if(list != null){
			request.setAttribute("list", list);
			return "success";
		}else{
			return "error";
		}
	}
	
	/**
	 * 插入应用详情
	 */
	@CookieNotCheckedRequired
	public String insertAppDetail(){
		//根据应用id获得应用名称
		appName = appdetailService.selectAppNameById(appstoreId);
		//前端传参：appstoreId，appIntroduce，detailMessage，photos
        System.out.println(appstoreId + appName + appIntroduce + newFeature + detailMessage + photos + photosFileName);
        //添加应用详情
		appdetailService.insertAppDetail(appstoreId, appName,appIntroduce,newFeature,detailMessage,photos,photosFileName);
        //跳转原页面
		return "insertDetail";
	}
	
	/**
	 * 查询应用详情
	 */
	@CookieNotCheckedRequired
	public void selectAppDetailById(){
		//根据应用商店里app的id查询应用详情  前端传值：appstoreId
		appdetailEntity = appdetailService.selectAppDetailById(appstoreId);
	    //获得评论表对应的appid
		/*appId = appdetailEntity.getId();
		//总评分
		Double totalScore = 0.0;
		try{
			//计算应用得分
			totalScore = appdetailService.getAppScore(appId);
			appdetailEntity.setTotalScope(totalScore);
		}catch (Exception e) {
			Log.error("计算应用评分失败! " + e);	
		}*/
		//前端输出
		Result<AppDetailEntity> result = new Result<AppDetailEntity>();
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(appdetailEntity);
		writeToPage(result);
	}
	
	/**
	 * 插入应用评论
	 */
	@CookieNotCheckedRequired
	public void insertAppComment(){
		//前端传值:appstoreId(applystore表的主键), empCode, content, score
		System.out.println(appstoreId + empCode + content + score);
		Result<Integer> result = new Result<Integer>();
		//添加评论
		int res = appdetailService.insertAppComment(appstoreId, empCode, content, score);
		//判断该工号是否已评论
		if(res >= 0){
			//未评论res=1，已评论res=0
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			result.setData(res);
		}else{
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		writeToPage(result);		
	}
	
	/**
	 * 分页展示评论列表
	 */
	@CookieNotCheckedRequired
	public void getCommentList(){
		//前端传值：appstoreId(applystore表的主键), currentPage
		System.out.println(appstoreId +" "+currentPage);
		//分页获得评论列表
		commentlist = appdetailService.getCommentList(appstoreId, getStartNo(), pageSize);
		//获得该应用评论条数
		commentCount = appdetailService.getCommentCount(appstoreId);
		//获得总页数
		totalPage = getTotalPage();
		//判断登陆工号是否有权限回复评论
		Boolean flag = false;
		List<String> codelist = appdetailService.getExcEmpcodeList();
		if(codelist.contains(userId)){
			flag = true;
		}
		//存入map
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("commentlist", commentlist);
		map.put("commentCount", commentCount);
		map.put("totalPage", totalPage);
		map.put("flag", flag);
		//传入前端
		Result<Map<Object,Object>> result = new Result<Map<Object,Object>>();
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(map);
		writeToPage(result);	
	}
	
	/**
	 * 添加评论回复
	 * @param commentId
	 * @param replyContent
	 * @param replyEmpCode
	 * @return
	 */
	@CookieNotCheckedRequired
	public void updateCommentReply(){
		Result<Integer> result = new Result<Integer>();
		//判断登陆工号是否有权限回复评论
		List<String> codelist = appdetailService.getExcEmpcodeList();
		if(codelist.contains(userId)){
			int res = appdetailService.updateCommentReply(commentId, replyContent, userId);
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			result.setData(res);
		}
		writeToPage(result);
	}
	

	public IAppDetailService getAppdetailService() {
		return appdetailService;
	}

	public void setAppdetailService(IAppDetailService appdetailService) {
		this.appdetailService = appdetailService;
	}

	public AppDetailEntity getAppdetailEntity() {
		return appdetailEntity;
	}

	public void setAppdetailEntity(AppDetailEntity appdetailEntity) {
		this.appdetailEntity = appdetailEntity;
	}
	
	public int getAppstoreId() {
		return appstoreId;
	}

	public void setAppstoreId(int appstoreId) {
		this.appstoreId = appstoreId;
	}
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppIntroduce() {
		return appIntroduce;
	}
	public void setAppIntroduce(String appIntroduce) {
		this.appIntroduce = appIntroduce;
	}
	public String getDetailMessage() {
		return detailMessage;
	}
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
	
	public File[] getPhotos() {
		return photos;
	}
	public void setPhotos(File[] photos) {
		this.photos = photos;
	}
	public String[] getPhotosFileName() {
		return photosFileName;
	}
	public void setPhotosFileName(String[] photosFileName) {
		this.photosFileName = photosFileName;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public ApplyStore getApplyStore() {
		return applyStore;
	}

	public void setApplyStore(ApplyStore applyStore) {
		this.applyStore = applyStore;
	}

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	
	public int getTotalPage() {
		//总页数
		if(commentCount % pageSize == 0){
			totalPage = commentCount / pageSize;
		}else{
			totalPage = commentCount / pageSize + 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartNo() {
		//起始评论编号
		startNo = (currentPage -1) * pageSize;
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
		if (currentPage > getTotalPage()) {
			currentPage = getTotalPage();
		}
	}
	
	public String getNewFeature() {
		return newFeature;
	}

	public void setNewFeature(String newFeature) {
		this.newFeature = newFeature;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	/*@Override
	public AppDetailEntity getModel() {
		// TODO Auto-generated method stub
		return appdetailEntity;
	}*/

}
