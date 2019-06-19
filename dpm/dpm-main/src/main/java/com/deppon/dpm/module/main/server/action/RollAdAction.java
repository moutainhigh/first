package com.deppon.dpm.module.main.server.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.server.util.UploadUtil;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.main.server.service.IRollAdService;
import com.deppon.dpm.module.main.shared.domain.RollAddDetailEntity;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

public class RollAdAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	private static final Logger log = LoggerFactory
			.getLogger(RollAdAction.class);
	private File file;
	private String fileName;
	
	/**
	 * CRM有权限的岗位数组
	 */
	private static List<String> HAS_BBB_JOBNAMES = null;
	
/*	static {
		HAS_BBB_JOBNAMES = new ArrayList<String>();
		HAS_BBB_JOBNAMES.add("快递员");
		HAS_BBB_JOBNAMES.add("快递员组长");
		HAS_BBB_JOBNAMES.add("营业部经理");
		HAS_BBB_JOBNAMES.add("点部经理");
		HAS_BBB_JOBNAMES.add("分部经理");
		HAS_BBB_JOBNAMES.add("营业点经理");
		HAS_BBB_JOBNAMES.add("大件快递员");

		
	}*/

	/**
	 * 首页滚动广告
	 */
	private int id;

	// 公众号类型
	private String appType;

	private IRollAdService rollAdService;

	/**
	 * 公文图片存储地址
	 */
	private static String filePath = "/dpmfile/rollAdd/";

	private String webUrl;

	// 上传图片
	//@CookieNotCheckedRequired
	public void uploadRollAdPhoto() {
		
		//&&!empCode.equals("265564")
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		String empCode = loginResult.getUserEntity().getEmpCode();
		if(ParamUtils.checkUserId(empCode)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		
		if(!(empCode.equals("265564")||empCode.equals("357095"))){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("该用户没有权限");
			writeToPage(result);
			return;
			
		}
		
		String photoName = getFileName(fileName);
		try {
			if (null == file || null == fileName) {
				// errorMessage
				result.setErrorMessage("请选择上传文件");
				// count
				result.setCount(Constants.ACTION_RESULT_ERROR);
				// 返回提示
				result.setData("");
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// 返回前端数据信息
				writeToPage(result);
				// 跳出
				return;
			}
			// 工具类是File[],这边做个简单的转换
			File[] files = { file };
			// 工具类是String[],这边做个简单的转换
			String[] fileNames = { fileName };
			if (!UploadUtil.validateImage(files, fileNames)) {
				// errorMessage
				result.setErrorMessage("上传文件格式不符，请重新选择正确格式（.bmg,.jpg,.jpeg,.gif,.png）的文件");
				// count
				result.setCount(Constants.ACTION_RESULT_ERROR);
				// 返回提示
				result.setData("");
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// 返回前端数据信息
				writeToPage(result);
				// 跳出
				return;
			}

			FileUtils.copyFile(file, new File(filePath + photoName));
		} catch (IOException e) {
			log.error("上传图片失败{}", e);
			e.printStackTrace();

		}

		StringBuffer sb = new StringBuffer();
		sb.append(webUrl + "/rollAdd/").append(photoName);

		result.setCount(Constants.ACTION_RESULT_SUC);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setData(sb.toString());
		writeToPage(result);
	}

	/**
	 * 获取图片名名
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFileName(String fileName) {
		StringBuilder sb = new StringBuilder();
		// 文件名用UUID防止重复
		sb.append(UUID.randomUUID().toString());
		// 拼接后缀名，如果存在的话
		if (fileName.indexOf(".") != -1) {
			// 拼接
			sb.append(fileName.substring(fileName.lastIndexOf(".")));
		}
		return sb.toString();
	}

	/**
	 * 首页广告上传
	 */
	//@CookieNotCheckedRequired
	public void uploadRollAd() {
		this.solveCrossDomain();
		// 结果集
		Result<String> result = new Result<String>();
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		String empCode = loginResult.getUserEntity().getEmpCode();
		if(ParamUtils.checkUserId(empCode)){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}
		
		if(!(empCode.equals("265564")||empCode.equals("357095"))){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("该用户没有权限");
			writeToPage(result);
			return;
			
		}
		
		BufferedReader bu;
		try {
			bu = ServletActionContext.getRequest().getReader();
			// 编码转换
			String str = java.net.URLDecoder.decode(
					StringUtil.bufferString(bu), "utf-8");
			// json转换得到数据
			if (StringUtils.isNotBlank(str)) {
				JSONObject strObject = JSONObject.parseObject(str);
				RollAddDetailEntity rollAddDetailEntity = new RollAddDetailEntity();
				rollAddDetailEntity.setAdOrgName(strObject
						.getString("department"));

				rollAddDetailEntity.setAdContent(strObject
						.getString("qEditContent"));

				rollAddDetailEntity.setAdTitle(strObject.getString("title"));

				rollAddDetailEntity.setAppType(strObject.getString("appType"));
				
				rollAddDetailEntity.setExtraLink(strObject.getString("extraLink"));
				if(null!=strObject.getInteger("isExtraLink")){
				  rollAddDetailEntity.setIsExtraLink(strObject.getInteger("isExtraLink"));
				}else{
					rollAddDetailEntity.setIsExtraLink(0);
				}


				if (null != strObject.getString("bannerUrl")) {
					rollAddDetailEntity.setAdPhoto(strObject
							.getString("bannerUrl"));
				}

				if (null != strObject.getString("videoImages")) {
					rollAddDetailEntity.setVideoImage(strObject
							.getString("videoImages"));
				}
				if (null != strObject.getString("videosUrl")) {
					rollAddDetailEntity.setVideoUrl(strObject
							.getString("videosUrl"));
				}

				if (null != strObject.getString("contentImages")) {
					rollAddDetailEntity.setContentImage(strObject
							.getString("contentImages"));
				}

				int count = rollAdService.upload(rollAddDetailEntity);
				if (count == 0) {
					// 插入失败

					result.setCount(Constants.ACTION_RESULT_ERROR);
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					writeToPage(result);
					return;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("发生异常为：", e);
			result.setCount(Constants.ACTION_RESULT_ERROR);
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			writeToPage(result);
			return;
		}
		result.setCount(Constants.ACTION_RESULT_SUC);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		writeToPage(result);

	}

	/**
	 * 根据广告id获取广告详情
	 */
	//@CookieNotCheckedRequired
	public void getRollAdById() {
		this.solveCrossDomain();
		// 结果集
		Result<Object> result = new Result<Object>();
		if (0 == id ) {
			// errorMessage
			result.setErrorMessage("id必传参数，大于0");
			// count
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// 返回提示
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 返回前端数据信息
			writeToPage(result);
			// 跳出
			return;
		}
		//获取应用详情
		RollAddDetailEntity rolladd = rollAdService.getRollAdDetail(id);
		rolladd.setAdPhoto(rolladd.getAdPhoto().replaceAll("https://dpm.deppon.com:8881/dpm/dpmfile", "http://mrsi.deppon.com:8000"));
		rolladd.setContentImage(rolladd.getContentImage().replaceAll("https://dpm.deppon.com:8881/dpm/dpmfile", "http://mrsi.deppon.com:8000"));
		result.setCount(Constants.ACTION_RESULT_SUC);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setData(rolladd);
		writeToPage(result);

	}

	/**
	 * 获取广告列表
	 */
	//@CookieNotCheckedRequired
	public void getRollAdList() {
		this.solveCrossDomain();
		//Boolean flag=false;
		// 结果集
		Result<Object> result = new Result<Object>();
		if (null == appType ) {
			// errorMessage
			result.setErrorMessage("appType必传参数");
			// count
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// 返回提示
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 返回前端数据信息
			writeToPage(result);
			// 跳出
			return;
		}
		/*//获取当前登录人
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		//登录人岗位
		String jobName = loginResult.getUserEntity().getEmployee().getJobName();
		//判断是否有帮帮帮权限
		if(HAS_BBB_JOBNAMES.contains(jobName)){
			flag = true;
		}*/
		
		//过滤外部链接
		if(appType.equals("0")){
			List<RollAddDetailEntity> rolladList = rollAdService
					.getRollAdList(appType);
			for (RollAddDetailEntity rollAdd : rolladList) {
				if(null==rollAdd.getExtraLink()||rollAdd.getExtraLink().equals("")){
					//rollAdd.setExtraLink("http://10.224.195.70:8090/#/detail?id="+rollAdd.getId()+"&from=banner");
					rollAdd.setExtraLink("http://file.deppon.com.cn/DPM_BEI/dpm_share/index.html#/detail?id="+rollAdd.getId()+"&from=banner");
					//rollAdd.setExtraLink("http://10.224.192.62:8090/index.html#/detail?id="+rollAdd.getId()+"&from=banner");
				}
				rollAdd.setAdPhoto(rollAdd.getAdPhoto().replaceAll("https://dpm.deppon.com:8881/dpm/dpmfile", "http://mrsi.deppon.com:8000"));
				rollAdd.setContentImage(rollAdd.getContentImage().replaceAll("https://dpm.deppon.com:8881/dpm/dpmfile", "http://mrsi.deppon.com:8000"));
				
			}
			result.setData(rolladList);
		}else{
			//List<RollAddDetailEntity> rolladList = rollAdService.getRollAdList(appType);
			List<RollAddDetailEntity> arrayList = new ArrayList<RollAddDetailEntity>();
			result.setData(arrayList);
		}
		result.setCount(Constants.ACTION_RESULT_SUC);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		//显示结果集
		writeToPage(result);

	}
	/**
	 * 获取广告列表
	 */
	//@CookieNotCheckedRequired
	public void getRollAdNewList() {
		this.solveCrossDomain();
		//Boolean flag=false;
		// 结果集
		Result<Object> result = new Result<Object>();
		if (null == appType ) {
			// errorMessage
			result.setErrorMessage("appType必传参数");
			// count
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// 返回提示
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 返回前端数据信息
			writeToPage(result);
			// 跳出
			return;
		}
		/*//获取当前登录人
		LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
		//登录人岗位
		String jobName = loginResult.getUserEntity().getEmployee().getJobName();
		//判断是否有帮帮帮权限
		if(HAS_BBB_JOBNAMES.contains(jobName)){
			flag = true;
		}*/
		
		//过滤外部链接
		if(appType.equals("0")){
			List<RollAddDetailEntity> rolladList = rollAdService
					.getRollAdList(appType);
			for (RollAddDetailEntity rollAdd : rolladList) {
				if(null==rollAdd.getExtraLink()||rollAdd.getExtraLink().equals("")){
					//rollAdd.setExtraLink("http://10.224.195.70:8090/#/detail?id="+rollAdd.getId()+"&from=banner");
				rollAdd.setExtraLink("http://file.deppon.com.cn/DPM_BEI/dpm_share/index.html#/detail?id="+rollAdd.getId()+"&from=banner");
					//rollAdd.setExtraLink("http://10.224.192.62:8090/index.html#/detail?id="+rollAdd.getId()+"&from=banner");
				}
				rollAdd.setAdPhoto(rollAdd.getAdPhoto().replaceAll("https://dpm.deppon.com:8881/dpm/dpmfile", "http://mrsi.deppon.com:8000"));
				rollAdd.setContentImage(rollAdd.getContentImage().replaceAll("https://dpm.deppon.com:8881/dpm/dpmfile", "http://mrsi.deppon.com:8000"));
				
			}
			result.setData(rolladList);
		}else{
			List<RollAddDetailEntity> rolladList = rollAdService
					.getRollAdList(appType);
			result.setData(rolladList);
		}
		result.setCount(Constants.ACTION_RESULT_SUC);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		//显示结果集
		writeToPage(result);
		
	}
	
	/**
	 * 删除滚动广告
	 */
	@CookieNotCheckedRequired
	public void deleteRollAd(){
		this.solveCrossDomain();
		// 结果集
		Result<Object> result = new Result<Object>();
		if (id == 0 ) {
			// errorMessage
			result.setErrorMessage("id必传参数，大于0");
			// count
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// 返回提示
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 返回前端数据信息
			writeToPage(result);
			// 跳出
			return;
		}
		
		int count=0;
		try {
			count = rollAdService.deleteRollAd(id);
		} catch (Exception e) {
			log.error("添加联系人失败", e);
			System.out.println(e);
			e.printStackTrace();
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// 返回提示
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			writeToPage(result);
			return;
		}
		if(count>0){
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			writeToPage(result);
			return;
		}else{
			result.setErrorMessage("删除失败，或者不存在这一条广告记录");
			// count
			result.setCount(Constants.ACTION_RESULT_ERROR);
			// 返回提示
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// 返回前端数据信息
			writeToPage(result);
			return;
		}
	}
	
	/**
	 * 更新失效软了的首页大广告显示
	 */
	/*@CookieNotCheckedRequired
	public void  updateMainPageRollAd(){
		this.solveCrossDomain();
		// 结果集
		Result<Object> result = new Result<Object>();
		//获取所有存在的大广告列表
		List<RollAddDetailEntity> rolladList = rollAdService
				.getAllRollAdList();
		//更新失效的软连接前缀
		for (RollAddDetailEntity rollAdd : rolladList) {
			if(rollAdd.getAdPhoto().contains("https://dpm.deppon.com:8881")){
				rollAdd.setAdPhoto(rollAdd.getAdPhoto().replace("https://dpm.deppon.com:8881", "https://dpm.deppon.com:8881"));
			}
			
			if(rollAdd.getContentImage().contains("https://dpm.deppon.com:8881")){
				rollAdd.setContentImage(rollAdd.getContentImage().replace("https://dpm.deppon.com:8881", "https://dpm.deppon.com:8881"));
			}
			
			int count=rollAdService.update(rollAdd);
			
		}
		
		
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		writeToPage(result);
		
	}*/
	
	
	

	/**
	 * 解决H5跨域 Access-Control-Allow-Credentials
	 */
	public void solveCrossDomain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public void setId(int id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public IRollAdService getRollAdService() {
		return rollAdService;
	}

	public void setRollAdService(IRollAdService rollAdService) {
		this.rollAdService = rollAdService;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}
