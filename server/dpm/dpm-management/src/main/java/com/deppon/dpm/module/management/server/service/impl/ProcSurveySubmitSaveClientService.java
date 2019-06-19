package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.impl.MySSLProtocolSocketFactory;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProcSurveySubmitSaveClientDao;
import com.deppon.dpm.module.management.server.service.IProcSurveySubmitSaveClientService;
import com.deppon.dpm.module.management.shared.domain.ProcSurveySubmitSaveClientEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.foss.framework.exception.BusinessException;


/**
 * 工程保存接口
 * @author 274858
 *
 */
public class ProcSurveySubmitSaveClientService implements IProcSurveySubmitSaveClientService{
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcSurveySubmitSaveClientService.class);
	private String proManagerUrl;
	
	public String getProManagerUrl() {
		return proManagerUrl;
	}

	public void setProManagerUrl(String proManagerUrl) {
		this.proManagerUrl = proManagerUrl;
	}

	private IProcSurveySubmitSaveClientDao procSurveySubmitSaveClientDao;
	
	public void setProcSurveySubmitSaveClientDao(
			IProcSurveySubmitSaveClientDao procSurveySubmitSaveClientDao) {
		this.procSurveySubmitSaveClientDao = procSurveySubmitSaveClientDao;
	}

	/* 传入参数：
		 * 
		 *    {
			    "attachments": [
			        "图片1",
			        "图片2",
			        "图片3",
			        "图片4",
			        "图片5"
			    ],
			    "checkCode": "项目编码",
			    "checkName": "项目名称",
			    "checkNo": "单号",
			    "checkId": 1,
			    "dateList": [
			        {
			            "checkId": 1,
			            "id": 1,
			            "lineId": 1,
			            "proCode": "勘测项目code1",
                                    "explainCode":"勘测说明code1"
			        },
                               {
			            "checkId": 1,
			            "id": 2,
			            "lineId": 1,
			            "proCode": "勘测项目code1",
                                    "explainCode":"勘测说明code2"
			        },
                                {
			            "checkId": 1,
			            "id": 3,
			            "lineId": 1,
			            "proCode": "勘测项目code1",
                                    "explainCode":"勘测说明code3"
			        },
			        {
			            "checkId": 1,
			            "id": 4,
			            "lineId": 2,
			            "proCode": "勘测项目code2",
                                     "explainCode":"勘测说明code1"         
			        },
			        {
			            "checkId": 1,
			            "id": 5,
			            "lineId": 2,
			            "proCode": "勘测项目code2",
                                     "explainCode":"勘测说明code2"         
			        },
			        {
			            "checkId": 1,
			            "id": 6,
			            "lineId": 3,
			            "proCode": "勘测项目code3",
                                     "explainCode":"勘测说明code1"         
			        }
			    ],
			    "integratedEvaluation": "是否达到开点要求(mark)",
			    "location": "定位地址",
			    "specialNeeds": "备注信息(note)",
			    "userNo": "操作人工号"
			}
	 * @see com.deppon.dpm.module.management.server.service.IProcSurvrySubmitSaveClientService#saveBaseDate()
	 */
	@Override
	public String saveBaseDate(String str) throws BusinessException, HttpException, IOException {
			
		
		//List<ProcSurveySubmitSaveClientEntity> psdfsd = procSurveySubmitSaveClientDao.selectAll();
		//System.out.println(JsonUtil.listToJsonString(psdfsd));
		//String res = "{\"resultFlag\":false,\"failureReason\":\"对不起，您的信息提交失败！\"}";
		//ProcSurveySubmitSaveClientEntity parBean = parseParameter(str);
		//解析参数
		ProcSurveySubmitSaveClientEntity parBean = JsonUtil.jsonToEntity(str,ProcSurveySubmitSaveClientEntity.class);
		//参数校验
		if(parBean == null || checkParameter(parBean)){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为不合格！\"}";
		}
		
		
		//往PC端推送数据
		ProcSurveySubmitSaveClientEntity resToPC = submitToPC(parBean);
		if(resToPC.getIsSuccess() != 1){
			return "{\"resultFlag\":false,\"failureReason\":\"往PC端推送数据失败，失败原因："+resToPC.getMessage()+"\"}";			
		}
		
		
		//保存数据到本地数据库
		ProcSurveySubmitSaveClientEntity resNative = saveNative(parBean);
		if(resNative.getIsSuccess() <= 0){
			return "{\"resultFlag\":false,\"failureReason\":\"保存本地数据失败，失败原因："+resNative.getMessage()+"\"}";
		}else{
			return "{\"resultFlag\":true,\"failureReason\":\"恭喜您，您的数据提交成功！！！\"}";
		}
		
		//return res;
	}
	/*public static void test(){
		ProcSurveySubmitSaveClientEntity testBean1 = new ProcSurveySubmitSaveClientEntity();
		ProcSurveySubmitSaveClientEntity testBean2 = new ProcSurveySubmitSaveClientEntity();
		List<ProcSurveySubmitSaveClientEntity> testList = new ArrayList<ProcSurveySubmitSaveClientEntity>();		
		Map<String,Object> resMap = new HashMap<String,Object>(); 
		testBean1.setId(1);
		testBean1.setCheckId(1);
		testBean1.setProCode("勘测项目code1");
		testBean1.setLineId(1);
		testList.add(testBean1);
		
		testBean2.setId(2);
		testBean2.setProCode("勘测项目code2");
		testBean2.setLineId(2);
		testBean2.setCheckId(2);
		testList.add(testBean2);
		
		resMap.put("dateList", testList);
		resMap.put("checkName","项目名称");
		resMap.put("checkCode","项目编码");
		resMap.put("userNo","操作人工号");
		resMap.put("checkNo","单号");
		resMap.put("location","定位地址");
		resMap.put("integratedEvaluation","是否达到开点要求(mark)");
		resMap.put("specialNeeds","备注信息(note)");
		List<String> phoneList = new ArrayList<String>();
		phoneList.add("图片1");
		phoneList.add("图片2");
		phoneList.add("图片3");
		phoneList.add("图片4");
		phoneList.add("图片5");
		resMap.put("attachments",phoneList);
		String res = JsonUtil.mapToJsonString(resMap);
		System.out.println("res"+res);
	}*/
	/*public static void main(String[] args) {
		parseParameter(null);
	}
*/

	/**
	 * 保存到本地数据库
	 * @param parBean
	 * @return
	 */
	private ProcSurveySubmitSaveClientEntity saveNative(
			ProcSurveySubmitSaveClientEntity parBean) throws BusinessException{
		ProcSurveySubmitSaveClientEntity toPCResBean = new ProcSurveySubmitSaveClientEntity();
		//图片转换
		ProcSurveySubmitSaveClientEntity  photoBean = setPhotoBean(parBean);
		//重复提交
		int checkCheckId = procSurveySubmitSaveClientDao.checkNativeToPhoto(photoBean.getCheckId());
		if(checkCheckId>0){
			toPCResBean.setIsSuccess(-1);
			toPCResBean.setMessage("对不起，你的任务已经提交，请勿重复提交！");
			return toPCResBean;
		}
		//保存勘测图片表
		int resPhoto = procSurveySubmitSaveClientDao.saveNativeToPhoto(photoBean);
		
		if(resPhoto>0){
			List<ProcSurveySubmitSaveClientEntity> relaBean = parBean.getDateList();
			//提交记录关系表
			int resRelation = procSurveySubmitSaveClientDao.saveNativeToRelation(relaBean);
			if(resRelation > 0){
				//更新任务状态
				int taskStatus = procSurveySubmitSaveClientDao.updateTaskStatus(parBean.getCheckId());
				if(taskStatus > 0){				
					toPCResBean.setIsSuccess(1);
					toPCResBean.setMessage("恭喜您，保存数据成功！");
					return toPCResBean;
				}else{
					toPCResBean.setIsSuccess(-1);
					toPCResBean.setMessage("对不起，更新“任务表”失败");
					return toPCResBean;
				}
				
			}
			toPCResBean.setIsSuccess(-1);
			toPCResBean.setMessage("对不起，保存“提交记录关系表”失败！");
			return toPCResBean;
			
		}
		toPCResBean.setIsSuccess(-1);
		toPCResBean.setMessage("对不起，保存“勘测图片表”失败！");
		return toPCResBean;
	}

	/**
	 * 保存图片
	 * @param parBean
	 * @return
	 */
	private ProcSurveySubmitSaveClientEntity setPhotoBean(
			ProcSurveySubmitSaveClientEntity parBean) {
		List<String> photos = parBean.getAttachments();
		
		int size = photos.size();
		String photos1 = "";
		String photos2 = "";
		String photos3 = "";
		switch (size) {
			case 1:
				//图一
				photos1 = photos.get(0);
				if(photos1 != null && photos1.length() > 0 ){
					parBean.setPhoto1(photos1);
				}
				break;
	        case 2:
	        	//图一
	    		photos1 = photos.get(0);
	    		if(photos1 != null && photos1.length() > 0){
	    			parBean.setPhoto1(photos1);
	    		}
	    		//图二
	    		photos2 = photos.get(1);
	    		if(photos2 != null && photos2.length() > 0){
	    			parBean.setPhoto2(photos2);
	    		}
				break;
	        case Constants.PROC_SURV_THREE:
	        	//图一
	    		photos1 = photos.get(0);
	    		if(photos1 != null && photos1.length() > 0){
	    			parBean.setPhoto1(photos1);
	    		}
	    		//图二
	    		photos2 = photos.get(1);
	    		if(photos2 != null && photos2.length() > 0){
	    			parBean.setPhoto2(photos2);
	    		}
	    		//图三
	    		photos3 = photos.get(2);
	    		if(photos3 != null && photos3.length() > 0){
	    			parBean.setPhoto3(photos3);
	    		}
				break;
	        case Constants.PROC_SURV_FOUR:
	        	
	        	parBean = setphotosFour(parBean);
				break;
			default:
				
				parBean = setphotosFive(parBean);
				break;
		}
		
		return parBean;
	}

	private ProcSurveySubmitSaveClientEntity setphotosFour(
			ProcSurveySubmitSaveClientEntity parBean) {
		List<String> photos = parBean.getAttachments();
		String photos1 = "";
		String photos2 = "";
		String photos3 = "";
		String photos4 = "";
		//图一
		photos1 = photos.get(0);
		if(photos1 != null && photos1.length() > 0){
			parBean.setPhoto1(photos1);
		}
		//图二
		photos2 = photos.get(1);
		if(photos2 != null && photos2.length() > 0){
			parBean.setPhoto2(photos2);
		}
		//图三
		photos3 = photos.get(2);
		if(photos3 != null && photos3.length() > 0){
			parBean.setPhoto3(photos3);
		}
		//图四
		photos4 = photos.get(Constants.PROC_SURV_THREE);
		if(photos4 != null && photos4.length() > 0){
			parBean.setPhoto4(photos4);
		}
		return parBean;
	}

	private ProcSurveySubmitSaveClientEntity setphotosFive(
			ProcSurveySubmitSaveClientEntity parBean) {
		List<String> photos = parBean.getAttachments();
		String photos1 = "";
		String photos2 = "";
		String photos3 = "";
		String photos4 = "";
		String photos5 = "";
		//图一
		photos1 = photos.get(0);
		if(photos1 != null && photos1.length() > 0){
			parBean.setPhoto1(photos1);
		}
		//图二
	    photos2 = photos.get(1);
		if(photos2 != null && photos2.length() > 0){
			parBean.setPhoto2(photos2);
		}
		//图三
		photos3 = photos.get(2);
		if(photos3 != null && photos3.length() > 0){
			parBean.setPhoto3(photos3);
		}
		//图四
		photos4 = photos.get(Constants.PROC_SURV_THREE);
		if(photos4 != null && photos4.length() > 0){
			parBean.setPhoto4(photos4);
		}
		//图五
		photos5 = photos.get(Constants.PROC_SURV_FOUR);
		if(photos5 != null && photos5.length() > 0){
			parBean.setPhoto5(photos5);
		}
		return parBean;
	}

	/**
	 *     {
			    "attachments": [
			        "sdafdsf",
			        "fsdafsdf",
			        "sadfsdaf",
			        "asdfdsafdsa",
			        "sadfdsf"
			    ],
			    "checkCode": "GDM-20151210-3001",
			    "checkName": "一凡营业部",
			    "checkNo": "店面设计-20151210-0001",
			    "checkId": 17,
			    "dateList": [
			        {
			            "checkId": 17,
			            "id": 1,
			            "lineId": 1,
			            "proCode": "decorationType",
                                    "explainCode":"10"
			        },
                               {
			             "checkId": 17,
			             "id": 2,
			             "lineId": 1,
			             "proCode": "decorationType",
                                    "explainCode":"20"
			        },
                                {
			             "checkId": 17,
			            "id": 3,
			             "lineId": 1,
			             "proCode": "decorationType",
                                    "explainCode":"30"
			        },
			        {
			            "checkId": 17,
			            "id": 4,
			            "lineId": 2,
			            "proCode": "businessType",
                                     "explainCode":"10"         
			        },
			        {
			            "checkId": 17,
			            "id": 5,
			            "lineId": 2,
			            "proCode": "businessType",
                                     "explainCode":"20"         
			        },
			        {
			            "checkId": 17,
			            "id": 6,
			            "lineId": 3,
			            "proCode": "wallStructure",
                                     "explainCode":"10"         
			        }
			    ],
			    "integratedEvaluation": 1,
			    "location": "定位地址",
			    "specialNeeds": "备注信息(note)",
			    "userNo": "操作人工号"
			} 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 往PC端推送数据
	 * @param parBean
	 * @return
	 * @throws IOException 
	 * @throws HttpException 
	 */
	private ProcSurveySubmitSaveClientEntity submitToPC(
			ProcSurveySubmitSaveClientEntity parBean) throws BusinessException, HttpException, IOException{
		String url = proManagerUrl+"/addSurvey";
		//String url = "http://10.224.64.148:8089/lsp/webservice/baseProjectService/addSurvey";
		//设置到PC端的参数
		Map<String,Object> param  = setToPCParameter(parBean);
		
		ProcSurveySubmitSaveClientEntity parLog = new ProcSurveySubmitSaveClientEntity();
		parLog.setUserNo(param.get("checkUserNo")+"");
		parLog.setModule("工程勘测");
		
		ProcSurveySubmitSaveClientEntity toPCResBean = new ProcSurveySubmitSaveClientEntity();
		String pcOfRes = "";
		try{
			log.info("工程勘测PC联调开始");
			parLog.setPkyContent(param.get("checkNo")+"");
			procSurveySubmitSaveClientDao.saveToPCLogBefore(parLog);
			pcOfRes = requestClient(param,url,"ESB_APP2ESB_PROJECT_POLLING");
			 //pcOfRes = "{ \"isSuccess\":0,\"message\":\"成撒旦法师打发送到发送到功\"}";
			log.info("工程勘测PC联调结束,PC端返回参数："+pcOfRes);
			JSONObject json = JSONObject.parseObject(pcOfRes);
			int isSuccess = json.getInteger("isSuccess") == null ?0:json.getInteger("isSuccess");
			String message = json.getString("message") == null ?"PC端没有返回参数！":json.getString("message");
			//联调失败保存日志
			if(isSuccess != 1){
				
			    parLog.setMessage(pcOfRes);
				procSurveySubmitSaveClientDao.saveToPCLog(parLog);
			}
			toPCResBean.setIsSuccess(isSuccess);
			toPCResBean.setMessage(message);
		}catch(BusinessException e){
			log.info("和PC端联调是抛异常！"+e);			
			//保存错误日志
			parLog.setMessage(e.toString());			
			procSurveySubmitSaveClientDao.saveToPCLog(parLog);
			
			toPCResBean.setIsSuccess(0);
			toPCResBean.setMessage("和PC端联调是抛异常！"+e);
		}
		
		return toPCResBean;
	}

	/**
	 * 到PC端参数设计
	 * @param parBean
	 * @return
	 */
	private Map<String, Object> setToPCParameter(
			ProcSurveySubmitSaveClientEntity parBean) {
		List<ProcSurveySubmitSaveClientEntity> dateList = parBean.getDateList();
		Map<String,Object> param = new HashMap<String,Object>();
		//备注信息
		param.put("specialNeeds",parBean.getSpecialNeeds());
		//是否达标
		param.put("integratedEvaluation",parBean.getIntegratedEvaluation()==1 ? "是":"否");
		param.put("location",parBean.getLocation());//定位
		param.put("checkName",parBean.getCheckName()); //项目名称
		param.put("checkCode",parBean.getCheckCode());  ///项目编码
		param.put("checkUserNo",parBean.getUserNo()); //工号
		param.put("checkNo",parBean.getCheckNo()); //单号
		param.put("attachments",parBean.getAttachments());  //图片
		//组拼说明项code
		List<ProcSurveySubmitSaveClientEntity> newDateList = filterDate(dateList);
		//设置其他参数
		for(ProcSurveySubmitSaveClientEntity bean : newDateList){
			String lineId = bean.getLineId()+"";
			String proCode = bean.getProCode().trim();
			String key = proCode+lineId.trim();
			String value = bean.getExplainCode();
			param.put(key.trim(), value);
		}
		return param;
	}

	/**
	 * 对说明项进行组拼  10|20|30
	 * @param dateList
	 * @return
	 */
	private List<ProcSurveySubmitSaveClientEntity> filterDate(
			List<ProcSurveySubmitSaveClientEntity> dateList) {
		//勘测项目分类
		
		Map<String,List<ProcSurveySubmitSaveClientEntity>> cacheMap = new HashMap<String,List<ProcSurveySubmitSaveClientEntity>>();
	    for(ProcSurveySubmitSaveClientEntity cacheBean:dateList){
	    	
	    	//取勘测项code
	    	String proCode = cacheBean.getProCode().trim();
	    	int proLineId = cacheBean.getLineId();
	    	String proExplain = (proCode+proLineId).trim();
	    	if(proExplain != null && !"".equals(proExplain)){
	    		
	    		if(cacheMap.containsKey(proExplain)){
	    			//存在key
	    			List<ProcSurveySubmitSaveClientEntity> oldList = cacheMap.get(proExplain);
	    			oldList.add(cacheBean);
	    			
	    		}else{
	    			//不存在key
	    			List<ProcSurveySubmitSaveClientEntity> newList = new ArrayList<ProcSurveySubmitSaveClientEntity>();
	    			newList.add(cacheBean);
	    			cacheMap.put(proExplain,newList);
	    		}
	    	}
	    }
	    
		//Collection<List<ProcSurveySubmitSaveClientEntity>> values = cacheMap.values();
	    //新建一个返回list
		List<ProcSurveySubmitSaveClientEntity> resList = new ArrayList<ProcSurveySubmitSaveClientEntity>();
		
	    Set<String> kesSet = cacheMap.keySet();
		for(String kesStr:kesSet){
			List<ProcSurveySubmitSaveClientEntity> eneryList = cacheMap.get(kesStr.trim());
			if(eneryList != null && eneryList.size() >0){
				StringBuffer  explainCodes = new StringBuffer();
				//组拼值 10|20
				for(ProcSurveySubmitSaveClientEntity resBean:eneryList){
					String explainCode = resBean.getExplainCode().trim();
					explainCodes.append("|"+explainCode);
				}
				//新建一个返回实体
				ProcSurveySubmitSaveClientEntity newResBean = eneryList.get(0);
				//截掉第一个“|” 设置到实体里
				newResBean.setExplainCode(explainCodes.substring(1)+"");
				resList.add(newResBean);
			}
			
		}
	    /*//新建一个返回list
		List<ProcSurveySubmitSaveClientEntity> resList = new ArrayList<ProcSurveySubmitSaveClientEntity>();
		//迭代分类后勘测项目
		for(List<ProcSurveySubmitSaveClientEntity> beanList:values){
			if(beanList != null && beanList.size() >0){
				StringBuffer  explainCodes = new StringBuffer();
				//组拼值 10|20
				for(ProcSurveySubmitSaveClientEntity resBean:beanList){
					String explainCode = resBean.getExplainCode().trim();
					explainCodes.append("|"+explainCode);
				}
				//新建一个返回实体
				ProcSurveySubmitSaveClientEntity newResBean = beanList.get(0);
				//截掉第一个“|” 设置到实体里
				newResBean.setExplainCode(explainCodes.substring(1)+"");
				resList.add(newResBean);
			}
			
		}*/
		
		return resList;
	}

	/**
	 *  "checkCode": "项目编码",
		    "checkName": "项目名称",
		    "checkNo": "单号",
	 * 参数检验
	 * @param parBean
	 * @return
	 */
	private boolean checkParameter(ProcSurveySubmitSaveClientEntity parBean) {
		//图片
		List<String> attachments = parBean.getAttachments();
		
		if(attachments==null || attachments.size()<=0){
			log.info("参数attachments（图片）为空");
			return true;
		}
		
		String userNo = parBean.getUserNo();
		String checkCode = parBean.getCheckCode();
		if(userNo==null || "".equals(userNo) || 
				checkCode==null || "".equals(checkCode)){
			
			log.info("工号或项目编码为空");
			return true;
		}
		String checkName = parBean.getCheckName();
		String checkNo = parBean.getCheckNo();
		if(checkName==null || "".equals(checkName) || 
				checkNo==null || "".equals(checkNo)){
			
			log.info("单号或项目名称为空");
			return true;
		}
		/*List<ProcSurveySubmitSaveClientEntity> dateList = parBean.getDateList();
		if(dateList==null || dateList.size()<=0){
			log.info("基础数据为空");
			return true;
		}
		
		int integratedEvaluation = parBean.getIntegratedEvaluation();
		int checkId = parBean.getCheckId();
		if(!(integratedEvaluation == 0 || integratedEvaluation == 1)|| checkId <= 0){
			
			log.info("'是否达到'或'校验任务ID'为空");
			return true;
		}*/
		//为应付无聊的唢呐，降低复杂度
		if(checkOther(parBean)){
			return true;
		}
		return false;
	}

	/**
	 * 对参数进行解析
	 * @param str
	 * @return
	 */
	/*private static ProcSurveySubmitSaveClientEntity parseParameter(String str) {
		//反序列化
		str = "{\"attachments\":[\"图片1\",\"图片2\",\"图片3\",\"图片4\",\"图片5\"],\"checkCode\":\"项目编码\"," +
				"\"checkName\":\"项目名称\",\"checkNo\":\"单号\",\"dateList\":[{\"checkId\":1,\"id\":1," +
				"\"lineId\":1,\"proCode\":\"勘测项目code1\"},{\"checkId\":2,\"id\":2,\"lineId\":2,\"proCode\":\"勘测项目code2\"}]," +
				"\"integratedEvaluation\":\"是否达到开点要求(mark)\",\"location\":\"定位地址\",\"specialNeeds\":\"备注信息(note)\"," +
				"\"userNo\":\"操作人工号\"}"; 
		
		ProcSurveySubmitSaveClientEntity parBean = JsonUtil.jsonToEntity(str,ProcSurveySubmitSaveClientEntity.class);
		System.out.println(parBean);
		return parBean;
	}*/
	
	private boolean checkOther(ProcSurveySubmitSaveClientEntity parBean) {
		List<ProcSurveySubmitSaveClientEntity> dateList = parBean.getDateList();
		if(dateList==null || dateList.size()<=0){
			log.info("基础数据为空");
			return true;
		}
		
		int integratedEvaluation = parBean.getIntegratedEvaluation();
		int checkId = parBean.getCheckId();
		if(!(integratedEvaluation == 0 || integratedEvaluation == 1)|| checkId <= 0){
			
			log.info("'是否达到'或'校验任务ID'为空");
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * Description:获取Http的客户端
	 * </p>
	 * 
	 * @param param
	 * @param url
	 * @param esbServiceCode
	 * @return
	 * @throws BusinessException
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public String requestClient(Map<String, Object> param, String url,
			String esbServiceCode) throws BusinessException, HttpException, IOException {
		HttpClient hc = new HttpClient();

		// 设置编码格式
		hc.getParams().setContentCharset("UTF-8");

		// 设置超时时间
		HttpConnectionManagerParams managerParams = hc
				.getHttpConnectionManager().getParams();

		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(Constants.HTTP_CON_TIMEOUT);

		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(Constants.HTTP_SO_TIMEOUT);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(),Constants.HTTP_PROTOCOL);
		Protocol.registerProtocol("https", myhttps);

		// header设置
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "DPM");

		// 参数设置
		String paramJson = JsonUtil.mapToJsonString(param);
		String headerJson = JsonUtil.mapToJsonString(map);

		RequestEntity entity = new StringRequestEntity(paramJson,
				"application/json", "UTF-8");
		PostMethod post = new PostMethod(url);
		post.setRequestEntity(entity);
		post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
		post.addRequestHeader("requestHeaders", headerJson);

		log.info("post url ==========>" + url);
		log.info("post paramter ==========>" + param);
		log.info("post header ==========>" + headerJson);

		// 执行postMethod
		hc.executeMethod(post);

		String result = post.getResponseBodyAsString();
		log.info(esbServiceCode + " response data : " + result);

		return result;
	}
	
	/*
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,2,2,2,2,2,23,3,4,4,3,5,5,6};
		StringBuffer str = new StringBuffer();
		str.append("<tr>");
		int j = 1;
		for(int i= 0;i<a.length;i++){
			str.append("<td>");
			str.append(a[i]);
			str.append("</td>");
			
			if(j%3 == 0){
				str.append("</tr><tr>");
			}
			j++;
		}
		str.append("</tr>");
		System.out.println(str);
		
		int[] testArr = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
		String testStr = "<tr>";
		int j = 1;
		for(int i=0;i<testArr.length;i++){
		   testStr += testArr[i];
		    if( j%3 == 0){
		    testStr += "</tr><tr>";
		    }
		    j = j+1;
		}
		System.out.println(testStr);
	}
	
	*/
	
	
	
	
	
}
