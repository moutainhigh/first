package com.deppon.dpm.doc.server.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IDiDiRecordService;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.shared.encypt.base64.BASE64Decoder;

/**
 * 备案新增、修改功能
 * 
 * @author gwl
 * 
 * 20180118
 */


public class DiDiRecordAction extends BaseAction{


	private static final long serialVersionUID = 1L;
	/**
	 * 构造方法
	 */
	public DiDiRecordAction(){
		super();
	}
	/*
	 * 调用接口
	 */
	private IExternalMethodService externalMethodService;//获取用户头像
	private IDiDiRecordService didirecordService;
	private static final Logger log = LoggerFactory.getLogger(DiDiRecordAction.class);
	private static String filePath = "/dpmfile/didirecord/";
	
	//private static String filePath = "F:/Media";
	/**
	 * 备案新增方法
	 */
	@CookieNotCheckedRequired
	public void insertRecode(){
//		Map map = JSONObject.parseObject(json);
		
//		HttpServletRequest request = ServletActionContext.getRequest();
//		Object[] aas = (Object[]) request.getParameterMap().get("userId");
//		String aasss =getvalue("comment");
//		Object aaa = request.getParameterMap().get("userId");
		//前台界面得值，封装VO
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ufdate = sdf.format(System.currentTimeMillis());
		DiDiRecordVO didirecordVO = new DiDiRecordVO();
		didirecordVO.setUserId(getvalue("userId"));
		
		Result<Object> result = new Result<Object>();//修漏洞添加
		if(ParamUtils.checkUserId(getvalue("userId"))){
			   result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			   // errorMessage
			   result.setErrorMessage("工号错误，不符合规范");
			   writeToPage(result);
			   return;
			  }
		
		didirecordVO.setUserName(getvalue("userName"));
		didirecordVO.setDept(getvalue("dept"));
		didirecordVO.setRecordtime(ufdate);
		didirecordVO.setRecordtype(getvalue("recordtype"));
		didirecordVO.setTaxidate(getvalue("taxidate"));
		didirecordVO.setFromName(getvalue("fromName"));
		didirecordVO.setToName(getvalue("toName"));
		didirecordVO.setAmount(getvalue("amount"));
		didirecordVO.setRecordpic(getvalue("recordpic"));
		didirecordVO.setCarremark(getvalue("carremark"));
		didirecordVO.setRemark(getvalue("remark"));
		didirecordVO.setRecordstate("0");
		didirecordVO.setComment("");
		JSONObject jonum = new JSONObject();
		log.info("<<<<<<<<<<<查找用户头像>>>>>>>>>>>");
		List<EmployeeVO> employeeList = externalMethodService.getEmpInfolist(getvalue("userId"));
		if(employeeList != null &&employeeList.size()>0){
			didirecordVO.setUserPic(employeeList.get(0).getHeadPhoto());
		}
		log.info("<<<<<<<<<<<查找用户头像>>>>>>>>>>>"+didirecordVO.getUserId()+"");
		if(didirecordVO.getUserId() == null || didirecordVO.getUserId()==""){
			jonum.put("error", 0);
			jonum.put("msg", "图片过大，提交失败。");
		}else{
			//调用新增接口 0 失败，1成功
			int aa = didirecordService.insert(didirecordVO);
			if(aa == 0){
				jonum.put("error", aa);
				jonum.put("msg", "备案失败");
				
			}else{
				jonum.put("error", aa);
				jonum.put("msg", "备案成功");
				
			}
		}
		log.info("<<<<<<<<<<<备案json信息>>>>>>>>>>>",jonum);
		writeToPage(jonum);
		
	}
	/**
	 * 备案批复方法
	 */
	@CookieNotCheckedRequired
	public void updateRecode(){
		
		int id = Integer.parseInt((getvalue("id")==""?"0":getvalue("id")).toString());
		String recordstate = getvalue("recordstate").toString();
		String comment = getvalue("comment").toString();
		int aa = didirecordService.update(id,recordstate,comment);
		JSONObject jsonObject = new JSONObject();
		if(aa == 0){
			jsonObject.put("error", aa);
			jsonObject.put("msg", "备案失败");
			
		}else{
			jsonObject.put("error", aa);
			jsonObject.put("msg", "备案成功");
			
		}
		writeToPage(jsonObject);
	}
	/**
	 * 前台取值处理方法
	 * @return the json
	 */
	public String getvalue(String key) {
		Object[] values;
		String value="";
		HttpServletRequest request = ServletActionContext.getRequest();
		log.info("<<<<<<<<<<<我的备案数据>>>>>>>>>>>",request);
		if(key == "recordpic"){
			values = (Object[]) request.getParameterMap().get("recordpic[]");
		}else{
			values = (Object[]) request.getParameterMap().get(key);
		}
		try{
			if(values != null){
				if(values.length!=0){
					if(key == "recordpic"){
						for(int i=0;i<values.length;i++){
							//前台获取image
							String recordpic = values[i].toString();//
							//得到文件格式
							String spcode = recordpic.substring(recordpic.lastIndexOf("."));
//							//去掉后缀
							String imagecode = recordpic.substring(0,recordpic.lastIndexOf("."));
							StringBuilder sb = new StringBuilder();
							// 文件名用UUID防止重复
							sb.append(UUID.randomUUID().toString());
							//文件名fileName
							String fileName = sb.toString()+spcode;
							byte[] buffer = new BASE64Decoder().decodeBuffer(imagecode.replaceAll("(?s)'.*'", "").replaceAll(" ", "+"));
							OutputStream out = null;
							out = new FileOutputStream(new File(filePath,fileName));
							out.write(buffer);
							if(i == values.length-1){
								value = value + fileName;
							}else{
								value = value + fileName+",";
							}
						}
					}else{
						value = values[0].toString();
					}
				}
			}
		}catch (Exception e) {
			e.getMessage();
			log.error("保存图片发生错误 ", e);
		}finally{
			
		}
		return value;
	}

	/**
	 * @param json the json to set
	 */
//	public void setJson(String json) {
//		this.json = json;
//	}

//	/**
//	 * @return the didirecordService
//	 */
//	public IDiDiRecordService getDidirecordService() {
//		return didirecordService;
//	}

	/**
	 * @param didirecordService the didirecordService to set
	 */
	public void setDidirecordService(IDiDiRecordService didirecordService) {
		this.didirecordService = didirecordService;
	}
	/**
	 * @return the filePath
	 */
	public static String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public static void setFilePath(String filePath) {
		DiDiRecordAction.filePath = filePath;
	}
	/**
	 * @return the externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}
	/**
	 * @param externalMethodService the externalMethodService to set
	 */
	public void setExternalMethodService(
			IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}
	
}
