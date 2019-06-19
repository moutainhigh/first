package com.deppon.dpm.module.management.server.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProcMaintainMessageDao;
import com.deppon.dpm.module.management.server.service.IProcMainService;
import com.deppon.dpm.module.management.shared.domain.DeptRepairEntity;
import com.deppon.dpm.module.management.shared.domain.ProNameEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainPCEntity;
import com.deppon.dpm.module.management.shared.vo.ResultVO;
import com.deppon.dpm.module.management.util.Constants;

/**
 * 
 * @author 王亚男
 *
 */

public class ProcMainService implements IProcMainService {

	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(ProcMainService.class);
	
	/**
	 * maintainMessageDao
	 */
	private IProcMaintainMessageDao maintainMessageDao;
	
	//获取部门信息的URL
	private String getDeptListUrl;
	//获取部门信息的esbCode
	private String esbCodeDept;
	//提交申请URL
	private String postDataUrl;
	//提交申请esbCode
	private String esbCodePost;
	
	/**
	 * getProListUrl
	 */
	private String getProListUrl;
	
	/**
	 * esbCodePro
	 */
	private String esbCodePro;
	
	/**
	 * 提交接口
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	/* (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IProcMainService#postMessage(com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity)
	 */
	/* (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IProcMainService#postMessage(com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity)
	 */
	
	public ResultVO<Object> postMessage(ProcMaintainEntity entity) throws Exception {
		
		//new 一个 ResultVO
		ResultVO<Object> resultMessage = new ResultVO<Object>();
			//ProcMaintainEntity entity = this.maintainMessageDao.selectMaintain(userNo);
		//ProcMaintainEntity entity = new ProcMaintainEntity();
		/*if(entity.getId()==0){
			String userNo = entity.getUserNo();
			entity = this.maintainMessageDao.selectMaintain(userNo);
			entity.setUserNo(userNo);
		}else{
			//entity = entityOld;
		}*/
		//得到id
		int id = entity.getId();
		//new 一个新的 ProcMaintainPCEntity
		ProcMaintainPCEntity toPC = new ProcMaintainPCEntity();
		//塞入数据
		toPC.setUserNo(entity.getUserNo());
		//塞入数据
		toPC.setApplyReason(entity.getApplyReason());
		//塞入数据
		toPC.setProCode(entity.getProCode());
		//塞入数据
		toPC.setBill(entity.getBill());
		//塞入数据
		toPC.setAdminID(entity.getAdminID());
		//塞入数据
		toPC.setAdminName(entity.getDepartment());
		//是否为监控
		toPC.setFisNOtMonitor(entity.getFisNOtMonitor());
		
		logger.info("postMessage 提交给PC端的参数是:"+JsonUtil.beanToJsonString(toPC).toString());
		
		
		
		List<String> images = new ArrayList<String>();
		//塞入数据
		images.add(entity.getImgOne());
		//塞入数据
		images.add(entity.getImgTwo());
		//塞入数据
		images.add(entity.getImgThree());
		//塞入数据
		images.add(entity.getImgFour());
		//塞入数据
		images.add(entity.getImgFive());
		
		toPC.setAttachments(getAttachmentsList(images));
		//得到json格式的数据
		// http://10.224.196.144:8089/lsp/webservice/baseProjectService/addMaintenRequest
		JSONObject json = getMessageForPCByHttp(JsonUtil.beanToJsonString(toPC).toString(),postDataUrl,esbCodePost);
		logger.info("postMessage PC端的参数是:"+json.toString());
		//转json格式
		String result = json.toString();
		//判断result 是否为null
		if(StringUtils.isNotBlank(result)){
			//得到参数值
			int isSuccess = json.getInt("isSuccess");
			//得到参数值
			String message = json.getString("message");
			String bill = null;
			//对isSuccess 进行判断
			if(isSuccess==1){
				try{
					bill = json.getString("bill");
				}catch (Exception e) {
					logger.info("bill is null");
				}
				resultMessage.setResultFlag(true);
				resultMessage.setMessage(message);
				//判断参数是否为Null
				if(StringUtils.isNotBlank(entity.getBill())){
					//判断参数是否相等
					if(!entity.getBill().equals(bill)){
						logger.info("单号不相同--PC端数据出问题,本地单号Bill:"+entity.getBill()+",PC传过来的单号Bill:"+bill);
					}else{
						logger.info("单号相同");
					}
				}else{
					logger.info("初次提交单号时空,修改对应数据的单号信息");
					/*Map<String,Object> map = new HashMap<String, Object>();
					map.put("id", id);
					map.put("bill", bill);*/
					logger.info("修改审核中状态");
					//对对象set数据
					entity.setApprovalMark(0);
					//对对象set数据
					entity.setBill(bill);
					int insert = 0;
					//判断id几种状况
					if(id == 0){
						insert = this.maintainMessageDao.saveProcMain(entity);
					}
					if(insert == 1){
						logger.info("新增单号修为"+bill+",成功,并修改审核中状态");
					}else{
						logger.info("新增单号修为"+bill+",失败");
					}
				}
				if(id!=0){
					//修改approvalMark 为审核中=0
					logger.info("修改审核中状态");
					//更新获得标志位
					int num = this.maintainMessageDao.updateApprovalMark(id);
					//判断是否更新成功
					if(num > 0){
						logger.info("修改审核中状态成功!");
					}else{
						logger.info("修改审核中状态失败");
					}
				}
			}else{
				resultMessage.setResultFlag(false);
				resultMessage.setMessage("PC端出现异常"+message);
				logger.info("PC端出现异常：isSuccess:"+isSuccess+",message:"+message+",bill:"+bill);
			}
		}
		//判断boolean值
		if(!resultMessage.isResultFlag()){
			logger.info("故意抛出异常,是为了事物回滚");
			throw new Exception();
		}
		//return 数据
		return resultMessage;
	}


	/**
	 * @param deptName 部门名称
	 */
	public DeptRepairEntity getDeptMessageFromPC(String proName) {
		//new 一个对象
		DeptRepairEntity result = new DeptRepairEntity();
		try{
			String json = "{\"proName\":\""+proName+"\"}";
			logger.info("getDeptMessageFromPC 获取项目信息;提交给PC端的参数是:"+json);
			logger.info("getDeptListUrl is:"+getDeptListUrl);
			//转Json
			// http://10.224.196.144:8089/lsp/webservice/baseProjectService/queryBaseProject
			JSONObject jsonObj = this.getMessageForPCByHttp(json, getDeptListUrl, esbCodeDept);
			logger.info("PC端返回数据:"+jsonObj.toString());
			try{
				//json转实体对象
				result = JsonUtil.jsonToEntity(jsonObj.toString(), DeptRepairEntity.class);
			}catch (Exception e) {
				//捕获异常
				e.printStackTrace();
				logger.info("解析数据失败");
			}
		}catch (Exception e) {
			//捕获异常
			e.printStackTrace();
			logger.info("与PC端数据交互数据出现异常");
		}
		//打出日志
		logger.info("list:"+result.getData());
		//返回结果
		return result;
	}


	/**
	 * 获取所属工程部列表
	 */
	public ResultVO<ProNameEntity> getProList() {
		//new 一个新的 ResultVO
		ResultVO<ProNameEntity> result = new ResultVO<ProNameEntity>();
		try{
			//new 一个新的 paramMap
			Map<String,String> paramMap = new HashMap<String, String>();
			//对map put数据
			paramMap.put("param", "test");
			//json转字符
			String params = JsonUtil.beanToJsonString(paramMap);
			// http://10.224.196.144:8089/lsp/webservice/baseProjectService/queryProjectDepartment
			JSONObject json = getMessageForPCByHttp(params,getProListUrl,esbCodePro);
			logger.info("PC getProList data" + json.toString());
			//判断参数是否为Null
			if(StringUtils.isNotBlank(json.toString())){
				//得到参数值
				int isSuccess = json.getInt("isSuccess");
				//得到参数值
				String message = json.getString("message");
				//判断参数值
				if(isSuccess == 1){
					//得到参数值
					String dataStr = json.getString("data");
					List<ProNameEntity> entities = JsonUtil.jsonToList(dataStr, ProNameEntity.class);
					result.setData(entities);
				}else{
					//塞入数据
					result.setResultFlag(false);
					//塞入数据
					result.setMessage(message);
				}
			}else{
				//塞入数据
				result.setResultFlag(false);
				//塞入数据
				result.setMessage("PC has error");
			}
		}catch (Exception e) {
			//捕获异常
			result.setResultFlag(false);
			result.setMessage("PC has error");
			e.printStackTrace();		
		}
		//返回结果
		return result;
	}

	
	

	
	/**
	 * 
	 * @param json JsonParam
	 * @param url serviceURL
	 * @param esbServiceCode 
	 * @return
	 * @throws Exception
	 */
	public JSONObject getMessageForPCByHttp(String json,String url,String esbServiceCode) throws Exception{
		//logger.info("toPcUrl:"+toPcUrl+";json:"+json);
			HttpClient hc = new HttpClient();
			// 设置编码格式
			hc.getParams().setContentCharset("UTF-8");
			// 设置超时时间
			HttpConnectionManagerParams managerParams = hc
					.getHttpConnectionManager().getParams();
			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(Constants.HTTP_CON_TIMEOUT);
			// 设置读数据超时时间(单位毫秒)
			managerParams.setSoTimeout(Constants.HTTP_CON_TIMEOUT);
			Protocol myhttps = new Protocol("https",
					new MySSLProtocolSocketFactory(), Constants.HTTP_PROTOCOL);
			Protocol.registerProtocol("https", myhttps);
			// header设置
			Map<String, String> map = new HashMap<String, String>();
			map.put("version", "1.0");
			map.put("Content-Type", "application/json;charset=UTF-8");
			map.put("esbServiceCode", esbServiceCode);
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "DPM");
			String headerJson = JsonUtil.mapToJsonString(map);
            //设置编码字符集UTF-8
			RequestEntity entity = new StringRequestEntity(json,
					"application/json", "UTF-8");
			//得到url
			PostMethod post = new PostMethod(url);
			post.setRequestEntity(entity);
			post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
			post.addRequestHeader("requestHeaders", headerJson);

			logger.info("post url ==========>" + url);
			//logger.info("post paramter ==========>" + json);
			logger.info("post header ==========>" + headerJson);

			// 执行postMethod
			hc.executeMethod(post);
			//读取数据
			InputStream is = post.getResponseBodyAsStream();
			//读取数据
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			StringBuffer sb = new StringBuffer();
			String tempbf; 
			//判断
			while((tempbf=br.readLine())!=null){
				sb.append(tempbf);
			} 
			//转json
			JSONObject response = JSONObject.fromObject(sb.toString());
            //打出日志
			logger.info(" response status : " + post.getStatusCode());
			logger.info(esbServiceCode + " response data : " + sb.toString());
			logger.info("response:"+response);
			//返回数据
			return response;
	}

	/**
	 * @param list 得到数据
	 * @return list
	 */ 
	public static List<String> getAttachmentsList(List<String> list){
		// 判断是否为base64
		String baseString = "data:image/jpeg;base64,";
		//new 一个新的list
		List<String> attachments = new ArrayList<String>();
		//循环
		for(String str : list){
			if(StringUtils.isNotBlank(str)){
				String attachment = str.replace(baseString, "");
				attachments.add(attachment);
			}
		}
		//返回数据
		return attachments;
	}
	
	/**
	 * @return getDeptListUrl
	 */
	public String getGetDeptListUrl() {
		return getDeptListUrl;
	}

	/**
	 * @param getDeptListUrl getDeptListUrl
	 */
	public void setGetDeptListUrl(String getDeptListUrl) {
		this.getDeptListUrl = getDeptListUrl;
	}

	/**
	 * @return esbCodeDept
	 */
	public String getEsbCodeDept() {
		return esbCodeDept;
	}

	/**
	 * @param esbCodeDept esbCodeDept
	 */
	public void setEsbCodeDept(String esbCodeDept) {
		this.esbCodeDept = esbCodeDept;
	}

	/**
	 * @return postDataUrl
	 */
	public String getPostDataUrl() {
		return postDataUrl;
	}

	/**
	 * @param postDataUrl postDataUrl
	 */
	public void setPostDataUrl(String postDataUrl) {
		this.postDataUrl = postDataUrl;
	}

	/**
	 * @return esbCodePost
	 */
	public String getEsbCodePost() {
		return esbCodePost;
	}

	/**
	 * @param esbCodePost esbCodePost
	 */
	public void setEsbCodePost(String esbCodePost) {
		this.esbCodePost = esbCodePost;
	}


	/**
	 * @return maintainMessageDao
	 */
	public IProcMaintainMessageDao getMaintainMessageDao() {
		return maintainMessageDao;
	}


	/**
	 * @param maintainMessageDao maintainMessageDao
	 */
	public void setMaintainMessageDao(IProcMaintainMessageDao maintainMessageDao) {
		this.maintainMessageDao = maintainMessageDao;
	}


	/**
	 * @return getProListUrl
	 */
	public String getGetProListUrl() {
		return getProListUrl;
	}


	/**
	 * @param getProListUrl getProListUrl
	 */
	public void setGetProListUrl(String getProListUrl) {
		this.getProListUrl = getProListUrl;
	}


	/**
	 * @return esbCodePro
	 */
	public String getEsbCodePro() {
		return esbCodePro;
	}


	/**
	 * @param esbCodePro esbCodePro
	 */
	public void setEsbCodePro(String esbCodePro) {
		this.esbCodePro = esbCodePro;
	}

	


}
