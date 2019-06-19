package com.deppon.dpm.module.wechat.server.service.impl;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.qpid.management.common.sasl.CRAMMD5HashedSaslClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

import net.sf.json.JSONArray;
import com.alibaba.fastjson.JSON;


import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.wechat.server.dao.IWechatTongxunluDao;
import com.deppon.dpm.module.wechat.server.service.IWechatTongxunluService;
import com.deppon.dpm.module.wechat.server.util.CSVCrate;
import com.deppon.dpm.module.wechat.shared.domain.WechatDelleteUserInfoEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatExecuteResultEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatOrgInfoEntity;
import com.deppon.dpm.module.wechat.shared.domain.WechatUserInfoEntity;
import com.deppon.dpm.module.wechat.shared.dto.DepartmentDto;
import com.deppon.dpm.module.wechat.shared.dto.JobDto;
import com.deppon.dpm.module.wechat.shared.dto.UserDto;

public class WechatTongxunluService implements IWechatTongxunluService {
	// 日志
	private static Logger logger  = LoggerFactory.getLogger(WechatTongxunluService.class);
	IWechatTongxunluDao wechatDao;
	private RedisService redisService;
	//企业微信id
	private String corpid;
	//通讯录密钥
	private String corpsecret;
	//发送消息密钥
	private String messageSecret;
	//获取token
	private String tokenUrl;
    //上传CSV
	private String csvUrl;
    //全最更新部门列表
	private String departmentUrl;
    //增量更新员工信息
	private String userUrl;
    //根据jobid获取异步执行结果URL
	private String resultUrl;
	private String userDeleteUrl;
    //从企业微信拉取部门信息
	private String WechatDepartmentUrl;
    //从企业微信拉取成员信息
	private String WechatUserInfoUrl;
	//发送消息URL
	private String wechatMessageSendUrl;
	//更新成员
	private String updateUserUrl;
	//创建标签 
	private String createTagUrl;
	//给成员添加标签
	private String createUserTagUrl;
	//创建成员
	private String createUserUrl;


	/**
	 * 此方法用来调试
	 */
    @Override
	public void methodTest() {
    	
//    	insertJobInfo("aa", "bb", "0", "12");
    	
    	String token = this.getAccess_token();
    	System.out.println(token);
    	
    	redisService.del("access_token");
//
//    	String token1 = redisService.get("wechatToken");
//    	System.out.println(token1);
//    	redisService.set("wechatToken", "aaaaaaaaa", 60);
//    	String token = redisService.get("wechatToken");
//    	System.out.println(token);
	}

	/**
	 * 全量更新部门 异步
	 * @return
	 */
	@Override
	public JSONObject updateDepponDepartmentAll() {
		logger.info("wechat-开始更新部门信息");
		try {
			String token = this.getAccess_token();
			if (token == null) {
				logger.error("WECHAT-更新部门时获取token异常");
				String RESULT_ERROR = "{'ERROR_MSG':'" + "获取token异常" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			String url = departmentUrl + "?" + "access_token=" + token;
			//生成CSV文件 并返回文件路径
			String filePath = createDepartmentCSV();
//			String filePath = "E:/test/department.txt";
			//上传csv文件到腾讯服务器  获取 media_id
			String media_id = send("file", filePath, token);
//			//全量覆盖部门 获取 jodid(异步任务id) 可由jodid查看异步任务进度
			JSONObject object = sendCVSData(media_id, url, "0");
			return object;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("WECHAT-全量更新部门出现异常:" + e);
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}

	}
	/**
	 * 全量更新员工 异步
	 * @return
	 */
	@Override
	public JSONObject updateDepponUserAll() {
		logger.info("wechat-开始更新员工信息");
		try {
			String token = this.getAccess_token();;
			if (token == null) {
				logger.error("WECHAT-更新员工时获取token异常");
				String RESULT_ERROR = "{'ERROR_MSG':'" + "获取token异常" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			String url = userUrl + "?" + "access_token=" + token;
			//生成CSV文件 并返回文件路径
			String filePath = createUserCSV(false);
//			String filePath = "E:/test/user.txt";
			//上传csv文件到腾讯服务器  获取 media_id
			String media_id = send("file", filePath, token);
			//全量覆盖部门 获取 jodid(异步任务id) 可由jodid查看异步任务进度
			JSONObject object = sendCVSData(media_id, url, "1");
			return object;
		} catch (Exception e) {
			logger.error("WECHAT-增量更新员工出现异常：" + e);
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}
	}
	
	/**
	 * 上线第一次手动全量更新所有员工，之后每天定时器跑增量
	 */
	public JSONObject updateDepponUserAllForOnce() {
		logger.info("wechat-全量更新员工信息（只一次）");
		try {
			String token = this.getAccess_token();;
			if (token == null) {
				logger.error("WECHAT-更新员工时获取token异常");
				String RESULT_ERROR = "{'ERROR_MSG':'" + "获取token异常" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			String url = userUrl + "?" + "access_token=" + token;
			//生成CSV文件 并返回文件路径
			String filePath = createUserCSV(true);
//			String filePath = "E:/test/user.txt";
			//上传csv文件到腾讯服务器  获取 media_id
			String media_id = send("file", filePath, token);
			//全量覆盖部门 获取 jodid(异步任务id) 可由jodid查看异步任务进度
			JSONObject object = sendCVSData(media_id, url, "1");
			return object;
		} catch (Exception e) {
			logger.error("WECHAT-增量更新员工出现异常：" + e);
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}
	}
    
	/**
	 * 获取Access_token
	 */
	private String getAccess_token() {
		String ac_token = redisService.get("access_token");
		if (ac_token == null) {
			String params = "corpid=" + corpid + "&" + "corpsecret=" + corpsecret;
			JSONObject obj = new JSONObject();
			try {
				String resultJson = HttpUtil.getHttp(tokenUrl, params,  "utf-8");
				//json转对象
				obj = JSONObject.fromObject(resultJson);
				String error_code = obj.getString("errcode");
				if (error_code.equals("0")) {
					//获取token成功
					ac_token = obj.getString("access_token");
					//access_token 有效期两小时
					redisService.set("access_token", ac_token, 60*60*2);
				}else {
					//获取token失败时 把错误码存到数据库
					insertJobInfo("", "", error_code, "2");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				logger.error("WECHAT-获取access_token出错 reson:" + e);
			}
		}
		return ac_token;
	}  
	

	/**
	 * 全量生成部门CSV文件
	 * @throws Exception 
	 */
	private String createDepartmentCSV() {
		//表头
		Object[] csvHeader = {"部门名称","部门ID","父部门ID","排序"};
		CSVCrate csvFile = new CSVCrate();
		//本地文件路径
//		String filePath = "E:/test/";
		//服务器软链接路径
		String filePath = "/dpmfile/emailattachment/";
		//文件名称
		String fileName = "department.csv";
//		String fileName = "department.txt";
		
		//第一部分 创建CSV文件
		List<WechatOrgInfoEntity> entitys = wechatDao.getOrgInfoAll();
		//所有行数组
		List<List<Object>> rowList = new ArrayList<List<Object>>();
		for (WechatOrgInfoEntity entity : entitys) {
			List<Object> row = new ArrayList<Object>();
			row.add(entity.getOrgName());
			row.add(entity.getOrgid());
			if (entity.getOrgid() == 1) {
				// 办公门户研发部 父部门改为
				entity.setParentOrgid(0);
			}
			row.add(entity.getParentOrgid());
			row.add("0");
			rowList.add(row);
		}
		csvFile.createCSV(csvHeader, rowList, fileName, filePath);
		return filePath + fileName;
	};
	
	/*
	 * 全量生成员工CSV文件  
	 * @param isAll  是否是全量更新员工 true:全量   false:增量
	 */
	private String createUserCSV(boolean isAll){
		//表头
		Object[] csvHeader = {"姓名","帐号","手机号","邮箱","所在部门","职位","性别","是否领导","排序","英文名","座机","禁用"};
		CSVCrate csvFile = new CSVCrate();
		//本地文件路径
//		String filePath = "E:/test/";
//		String fileName = "user.csv";
		//服务器软链接路径
		String filePath = "/dpmfile/emailattachment/";
		//文件名称
		String fileName = "user.csv";
		
		//所有行
		List<List<Object>> rowList = new ArrayList<List<Object>>();
		List<WechatUserInfoEntity> list = new ArrayList<WechatUserInfoEntity>();
		if (isAll) {
			//全量
			list = wechatDao.getUserInfoForOnce();
		}else{
			//增量
			list = wechatDao.getUserInfoAll();
		}
		
		for (WechatUserInfoEntity entity : list) {
			List<Object> row = new ArrayList<Object>();
			
			if (isEmpty(entity.getUserid())) entity.setUserid("");
			if (isEmpty(entity.getName())) entity.setName("");
			if (isEmpty(entity.getMobile())) entity.setMobile("");
			
			if (!isSixNum(entity.getUserid().substring(3)) || (entity.getName().indexOf("外包") !=-1)) {
				//工号DP-之后不是6位纯数字  人员姓名包含“外包”两个字的 都剔除
				continue;
			}
			//如果长度超过20位  那长截取前20位
			String name = entity.getName();
			if (name.length() > 20) {
				name = name.substring(0, 20);
			}
			row.add(name);//姓名
			row.add(entity.getUserid());//帐号
			//手机号
			if (isMobile(entity.getMobile())) {
				row.add(entity.getMobile());//手机号
			}else {
				row.add("");//手机号
			}
			
			row.add(entity.getEmail());//邮箱
			row.add(entity.getDepartment());//所在部门id
			row.add(entity.getPosition());//职位
			if (entity.getGender().equals("f")) {
				//女
				entity.setGender("2");
			}else {
				//男
				entity.setGender("1");
			}
			row.add(entity.getGender());//性别
			row.add("");//是否领导
			row.add("");//排序
			row.add("");//英文名
			row.add("");//座机
			row.add("");//禁用
			//较验电话和邮箱合不合规 且 两者必须有一个不为空
/*			if (isEmpty(entity.getMobile()) || isEmpty(entity.getEmail()) || !isMobile(entity.getMobile()) || !isEmail(entity.getEmail())) {
				//手机号 或 邮箱 必须有一个不为空   此处需把两者都为空的记录到数据库中 方便排查异常 
//				System.out.println("工号：" + entity.getUserid() + "的手机号或邮箱为空 或格式不对 " + "手机号：" + entity.getMobile() + "邮箱：" + entity.getEmail());
				continue;
			}*/
			rowList.add(row);
			
		}
		csvFile.createCSV(csvHeader, rowList, fileName, filePath);
		return filePath + fileName;
	}
	//判断是否是6位纯数字
	private static boolean isSixNum(String num) {
		String regex = "^[0-9]{6}$";
		return Pattern.matches(regex,num);
	}
	//判断字符串为空
	private  boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
	
	// 手机号验证
	// private  boolean isMobile(String mobile){  
		// String regex = "(\\+\\d+)?1[34578]\\d{9}$";    
		// return Pattern.matches(regex, mobile);  
	// } 
	// 邮箱验证
	// public static boolean isEmail(final String email) {
		// String regex = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";
		// return email.matches(regex);	} 
	
	/**
     * 文件上传到微信服务器
     * @param fileType 文件类型
     * @param filePath 文件路径
     * @return JSONObject
     * @throws Exception
     */
    public String send(String fileType, String filePath, String token) throws Exception {  
        String result = null;  
        File file = new File(filePath);  
        if (!file.exists() || !file.isFile()) {  
            throw new IOException("文件不存在");  
        }  
        /** 
        * 第一部分 
        */  
        URL urlObj = new URL(csvUrl + "?" + "access_token="+ token   
                + "&type=file");   
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();  
        con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式  
        con.setDoInput(true);  
        con.setDoOutput(true);  
        con.setUseCaches(false); // post方式不能使用缓存  
        // 设置请求头信息  
        con.setRequestProperty("Connection", "Keep-Alive");  
        con.setRequestProperty("Charset", "UTF-8");  
        // 设置边界  
        String BOUNDARY = "----------" + System.currentTimeMillis();  
        con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+ BOUNDARY);  
        // 请求正文信息  
        // 第一部分：  
        StringBuilder sb = new StringBuilder();  
        sb.append("--"); // 必须多两道线  
        sb.append(BOUNDARY);  
        sb.append("\r\n");  
        sb.append("Content-Disposition: form-data;name=\"file\";filename=\""+ file.getName() + "\"\r\n");  
        sb.append("Content-Type:application/octet-stream\r\n\r\n");  
        byte[] head = sb.toString().getBytes("utf-8");  
        // 获得输出流  
        OutputStream out = new DataOutputStream(con.getOutputStream());  
        // 输出表头  
        out.write(head);  
        // 文件正文部分  
        // 把文件已流文件的方式 推入到url中  
        DataInputStream in = new DataInputStream(new FileInputStream(file));  
        int bytes = 0;  
        byte[] bufferOut = new byte[1024];  
        while ((bytes = in.read(bufferOut)) != -1) {  
        out.write(bufferOut, 0, bytes);  
        }  
        in.close();  
        // 结尾部分  
        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
        out.write(foot);  
        out.flush();  
        out.close();  
        StringBuffer buffer = new StringBuffer();  
        BufferedReader reader = null;  
        try {  
        // 定义BufferedReader输入流来读取URL的响应  
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
        String line = null;  
        while ((line = reader.readLine()) != null) {  
        //System.out.println(line);  
        buffer.append(line);  
        }  
        if(result==null){  
        result = buffer.toString();  
        }  
        } catch (IOException e) {  
        System.out.println("发送POST请求出现异常！" + e);  
        e.printStackTrace();  
        throw new IOException("数据读取异常");  
        } finally {  
        if(reader!=null){  
        reader.close();  
        }  
        }  
        JSONObject jsonObj = JSONObject.fromObject(result);
        //errcode 0:成功  其它：失败
        String errcode = jsonObj.getString("errcode");
        String media_id = "";
        if (errcode.equals("0")) {
        	media_id = jsonObj.getString("media_id");
		}else if (errcode.equals("40014")) {
			media_id = "不合法的access_token";
		}else {
			media_id = "获取media_id异常";
		}
        return media_id;    
    }

    /**
     * 
     * @param mediaId
     * @param url
     * @param type 类型  0：部门  1：员工   用来记入数据库
     * @return
     */
	private JSONObject sendCVSData(String mediaId, String url, String type) {
		String json = "{"+  
                "\"media_id\":\""+mediaId+"\""+  
            "}"; 
		JSONObject object = new JSONObject();
		try {
			String resultJson = HttpUtil.doPostJson(url, json);
			//json转对象
			object = JSONObject.fromObject(resultJson);
			String errcode = object.getString("errcode");
			if (errcode.equals("0")) {
				//成功 jobid存入数据库
				String jobid = object.getString("jobid");
				insertJobInfo(mediaId, jobid, errcode, type);
			}else {
				//jobid存入数据库
				insertJobInfo(mediaId, "", errcode, type);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("WECHAT-上传CSV文件获取jobid错误 reason:" + e);
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			object = JSONObject.fromObject(RESULT_ERROR);
		}
		return object;
	}
	
	//获取异步结果
	@Override
	public JSONObject getTaskResult(String jobid) {
		String token = this.getAccess_token();;
		if (token == null) {
			logger.error("WECHAT-更新员工时获取token异常");
			String RESULT_ERROR = "{'ERROR_MSG':'" + "获取token异常" + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}
		String params = "access_token=" + token + "&" + "jobid=" + jobid;
		try {
			String resultJson = HttpUtil.getHttp(resultUrl, params,  "utf-8");
			//json转对象
			JSONObject object = JSONObject.fromObject(resultJson);
			return object;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			logger.error("WECHAT-获取access_token出错 reson:" + e);
			return object;
		}
		
	}
	
	/**
	 * 删除员工信息
	 */
	@Override
	public void deleteUserInfo() {
		logger.info("wechat-开始删除员工信息");
		try {
			List<WechatDelleteUserInfoEntity> delUsers = wechatDao.delUserInfo();
			for (WechatDelleteUserInfoEntity entity : delUsers) {
				String userid = entity.getEmpCode();
				this.deleteUserByEmpcode(userid);
			}
		} catch (Exception e) {
			logger.error("WECHAT-删除员工时出错，Reason:" + e);
		}

	}
	
	/**
	 * 根据工号删除员工信息
	 */
	private void deleteUserByEmpcode(String empCode){
		try {
			String token = this.getAccess_token();
			if (token == null) {
				logger.error("WECHAT-删除员工时时获取token异常");
			}
			String params = "access_token=" + token + "&" + "userid=" + empCode;
			JSONObject obj = new JSONObject();
			String resultJson = HttpUtil.getHttp(userDeleteUrl, params,  "utf-8");
			//json转对象
			obj = JSONObject.fromObject(resultJson);
			String error_code = obj.getString("errcode");
			if (!error_code.equals("0")) {
				//删除员工信息失败
				String errMsg = obj.getString("errmsg");
				logger.error("WECHAT-删除员工：" + empCode +"失败 errcode:" + error_code + " errMsg:" + errMsg);
			}else {
				logger.info("WECHAT-删除员工：" + empCode +"成功");
			}
		} catch (Exception e) {
			logger.error("WECHAT-删除员工失败 reason:" + e);
		}
	}
	
	/**
	 * 根据工号创建员工
	 * @param empCode
	 */
	@Override
	public JSONObject createUserByEmpcode(String empCode) {
		//先删除员工信息 再创建
		this.deleteUserByEmpcode("DP-" + empCode);
		logger.info("WECHAT-开始创建员工:" + empCode);
		try {
			String token = this.getAccess_token();
			if (token == null) {
				logger.error("WECHAT-创建员工时时获取token异常");
			}
			
			WechatUserInfoEntity entity = wechatDao.getUserInfoByEmpcode(empCode);
			if (isEmpty(entity.getUserid())) entity.setUserid("");
			if (isEmpty(entity.getName())) entity.setName("");
			if (isEmpty(entity.getMobile())) entity.setMobile("");
			if (!isSixNum(entity.getUserid().substring(3)) || (entity.getName().indexOf("外包") !=-1)) {
				//工号DP-之后不是6位纯数字  人员姓名包含“外包”两个字的 都剔除
				String RESULT_ERROR = "{'ERROR_MSG':'" + "工号不为纯数字或人员姓名里包含有\"外包\"-两个字" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			//手机号
			if (!isMobile(entity.getMobile())) {
				//手机号不符合规则  则置""
				entity.setMobile("");
			}
			if (entity.getGender().equals("f")) {
				//女
				entity.setGender("2");
			}else {
				//男
				entity.setGender("1");
			}
			String url = createUserUrl + "?" + "access_token=" + token;
			String postJson = "{"+  
	                "\"userid\":\""+ entity.getUserid() +"\""+ "," +
	                "\"name\":\""+ entity.getName() +"\""+ "," +
	                "\"mobile\":\""+entity.getMobile()+"\""+ "," + 
	                "\"department\":\""+entity.getDepartment()+"\""+ "," + 
	                "\"position\":\""+entity.getPosition()+"\""+ "," + 
	                "\"gender\":\""+entity.getGender()+"\""+ "," + 
	                "\"email\":\""+entity.getEmail()+"\"" +
	            "}";
			String resultJson = HttpUtil.doPostJson(url, postJson);
			//json转对象
			JSONObject object = JSONObject.fromObject(resultJson);
			return object;
		
		} catch (Exception e) {
			logger.error("WECHAT-创建员工失败 reason:" + e);
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}
	}
	
	/**
	 * 从企业微信拉取部门信息存到本地数据库 方便异常排查
	 * access_token:	调用接口凭证
	 * id: 非必传	部门id。获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构
	 */
	public JSONObject getDepartmentInfoFromWechat(String token, String id){
		String params = "access_token=" + token + "&" + "id=" + id;
		JSONObject object = new JSONObject();
		try {
			String resultJson = HttpUtil.getHttp(WechatDepartmentUrl, params,  "utf-8");
			object = JSONObject.fromObject(resultJson);
			JSONArray array = object.getJSONArray("department");
			List<DepartmentDto> departmentList = new ArrayList<DepartmentDto>();
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = array.getJSONObject(i);
				String orgId = obj.getString("id");//创建的部门id
				String name = obj.getString("name");//部门名称
				String parentid = obj.getString("parentid");//父亲部门id。根部门为1
				String order = obj.getString("order");//父部门中的次序值。order值大的排序靠前。值范围是[0, 2^32)
				DepartmentDto dto = new DepartmentDto();
				dto.setOrgId(orgId);
				dto.setOrgName(name);
				dto.setParentOrgid(parentid);
				dto.setOrder(order);
				departmentList.add(dto);
			}
			wechatDao.insertDepartmentInfo(departmentList);
		} catch (Exception e) {
			// TODO: handle exception
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			object = JSONObject.fromObject(RESULT_ERROR);
			logger.error("WECHAT-获取部门列表失败 reason:" + e);
		}
		return object;
	}
	/**
	 * 从企业微信拉取成员信息
	 * @param token：       调用接口凭证
	 * @param departmentId：        获取的部门id
	 * @param child:	1/0：是否递归获取子部门下面的成员
	 * @return
	 */
	public JSONObject getUserInfoFromWechat(String token, String department_id, String fetch_child){
		String params = "access_token=" + token + "&" + "department_id=" + department_id + "&" + "fetch_child=" + fetch_child ;
		JSONObject object = new JSONObject();
		try {
			String resultJson = HttpUtil.getHttp(WechatUserInfoUrl, params,  "utf-8");
			object = JSONObject.fromObject(resultJson);
			JSONArray array = object.getJSONArray("userlist");
			List<UserDto> userList = new ArrayList<UserDto>();
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = array.getJSONObject(i);
				String userId = obj.getString("userid");//
				String name = obj.getString("name");//
				String department = obj.getString("department");//
				UserDto dto = new UserDto();
				dto.setUserId(userId);
				dto.setName(name);
				dto.setDepartment(department);
				userList.add(dto);
			}
			wechatDao.insertUserInfo(userList);
		} catch (Exception e) {
			// TODO: handle exception
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			object = JSONObject.fromObject(RESULT_ERROR);
			logger.error("WECHAT-获取员工信息失败 reason:" + e);
		}
		return object;
	}
	
	/**
	 * 将列新部门  、员工、 获取token时的一些记录存入数据库（获取token只有失败时才存，更新部门、员工每次都存）
	 */
	private void insertJobInfo(String media_id, String jobid, String error_code, String type){
		JobDto job = new JobDto();
		job.setMedia_id(media_id);
		job.setJobid(jobid);
		job.setErrcode(error_code);
		job.setType(type);
		wechatDao.insertJobInfo(job);
	}
	
	/**
	 * 获取access_token返回给前端  方便在查看异步任务执行进度时填入参数token
	 */
	public JSONObject getWechatAccess_token() {

		String params = "corpid=" + corpid + "&" + "corpsecret=" + corpsecret;
		JSONObject obj = new JSONObject();
		try {
			String resultJson = HttpUtil.getHttp(tokenUrl, params,  "utf-8");
			//json转对象
			obj = JSONObject.fromObject(resultJson);
			return obj;

		} catch (Exception e) {
			// TODO: handle exception
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}

	}  
	
	
	/**
	 * 获取消息推送Access_token
	 * 后期添加的消息推送功能   前期功能已全部实现且无问题 所以新增获取消息推送token方法 以免在已有方法上改出问题
	 */
	private String getMessagePushAccess_token() {
		String ac_token = redisService.get("message_access_token");
		if (ac_token == null) {
			String params = "corpid=" + corpid + "&" + "corpsecret=" + messageSecret;
			JSONObject obj = new JSONObject();
			try {
				String resultJson = HttpUtil.getHttp(tokenUrl, params,  "utf-8");
				//json转对象
				obj = JSONObject.fromObject(resultJson);
				String error_code = obj.getString("errcode");
				if (error_code.equals("0")) {
					//获取token成功
					ac_token = obj.getString("access_token");
					//access_token 有效期两小时
					redisService.set("message_access_token", ac_token, 60*60*2);
				}else {
					//获取token失败时 把错误码存到数据库
					insertJobInfo("", "", error_code, "2");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				logger.error("WECHAT-获取消息推送access_token出错 reson:" + e);
			}
		}
		return ac_token;
	}  
	
	@Override
	public void sendMessage(int type){
		logger.info("wechat-开始推送企业微信消息");
		//推送内容
		String sendContent = "wechat-开始推送企业微信消息";
//		String params = "access_token=" + corpid + "&" + "corpsecret=" + corpsecret;
		try {
			//获取同步执行结果
			WechatExecuteResultEntity sysResult = wechatDao.executeResult(type);
			String errorcode = sysResult.getErrcode();
			if (errorcode.equals("0")) {
				//同步信息成功
				JSONObject object = this.getTaskResult(sysResult.getJobid());
				String errcode = object.getString("errcode");
				String errmsg = object.getString("errmsg");
			/*	try {
					//有的执行结果没有status之后的字段  所
					errcode = object.getString("errcode");
					errmsg = object.getString("errmsg");
					status = object.getString("status");
					total = object.getString("total");
					percentage = object.getString("percentage");
				} catch (Exception e) {
					// TODO: handle exception
					status = "";
					total = "";
					percentage = "";
				}*/
				
				String sysType = "";
				if (type == 0 ) {
					sysType = "部门同步时间：" + sysResult.getCreateTime() + " 结果：";
				}else if(type == 1) {
					sysType = "员工同步时间：" + sysResult.getCreateTime() + " 结果";
				}
				sendContent = sysType + "["   
						+ "errcode:" + errcode + ";"
						+ "errmsg:" + errmsg + ";"
						+ "]";
			}else {
				//同步信息失败
				if (type == 0){
					//部门
					sendContent = "同步部门信息出错：errorCode="  + sysResult.getErrcode()
							+ "  同步时间：" + sysResult.getCreateTime() ;
				} else if(type == 1) {
					//员工
					sendContent = "同步员工信息出错：errorCode="  + sysResult.getErrcode()
							+ "  同步时间：" + sysResult.getCreateTime() ;
				}
			}
			//要发送的json数据
			String json = "{"+  
	                "\"touser\":\""+"DP-042198|DP-039047|DP-091801"+"\""+ "," +
	                "\"msgtype\":\""+"text"+"\""+ "," +
	                "\"agentid\":\""+36+"\""+ "," + 
	                "\"text\":"+ 
	                "{"+  
		            "\"content\":\""+ sendContent +"\""+
		            "}" + "," +
	                "\"safe\":\""+0+"\""+
	            "}"; 
			String messageToken = this.getMessagePushAccess_token();
			if (messageToken == null) {
				logger.error("WECHAT-推送消息时获取token异常");
				return ;
			}
			String url = wechatMessageSendUrl + "?" + "access_token=" + messageToken;
			String resultJson = HttpUtil.doPostJson(url, json);
			//json转对象
			JSONObject object = JSONObject.fromObject(resultJson);
			String errcode = object.getString("errcode");
			if (!errcode.equals("0")) {
				//消息发送失败
				logger.error("消息发送失败Errcode:" + errcode + "," + "Errmsg:" + object.getString("errmsg"));
			}

		} catch (Exception e) {
			logger.error("WECHAT-推送消息时出现异常：" + e);

		}
		
	}
	
	/**
	 * 更新员工信息
	 */
	@Override
	public JSONObject updateUserInfoByEmpcode(String empcode){
		logger.info("wechat-更新员工信息");
		try {
			String token = this.getAccess_token();
			if (token == null) {
				logger.error("WECHAT-更新部门时获取token异常");
				String RESULT_ERROR = "{'ERROR_MSG':'" + "获取token异常" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			String url = updateUserUrl + "?" + "access_token=" + token;
			WechatUserInfoEntity entity = wechatDao.getUserInfoByEmpcode(empcode);
			if (isEmpty(entity.getUserid())) entity.setUserid("");
			if (isEmpty(entity.getName())) entity.setName("");
			if (isEmpty(entity.getMobile())) entity.setMobile("");
			if (!isSixNum(entity.getUserid().substring(3)) || (entity.getName().indexOf("外包") !=-1)) {
				//工号DP-之后不是6位纯数字  人员姓名包含“外包”两个字的 都剔除
				String RESULT_ERROR = "{'ERROR_MSG':'" + "工号不为纯数字或人员姓名里包含有\"外包\"-两个字" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			//手机号
			if (!isMobile(entity.getMobile())) {
				//手机号不符合规则  则置""
				entity.setMobile("");
			}
			if (entity.getGender().equals("f")) {
				//女
				entity.setGender("2");
			}else {
				//男
				entity.setGender("1");
			}
			
			String postJson = "{"+  
	                "\"userid\":\""+ entity.getUserid() +"\""+ "," +
	                "\"name\":\""+ entity.getName() +"\""+ "," +
	                "\"mobile\":\""+entity.getMobile()+"\""+ "," + 
	                "\"department\":\""+entity.getDepartment()+"\""+ "," + 
	                "\"position\":\""+entity.getPosition()+"\""+ "," + 
	                "\"gender\":\""+entity.getGender()+"\""+ "," + 
	                "\"email\":\""+entity.getEmail()+"\"" +
	            "}";
			String resultJson = HttpUtil.doPostJson(url, postJson);
			JSONObject object = JSONObject.fromObject(resultJson);
			return object;
		} catch (Exception e) {
			// TODO: handle exception
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}
		
	}
	
	/**
	 * 创建标签
	 */
	@Override
	public JSONObject createTag(String tagname, String tagid) {
		logger.info("wechat-创建标签");
		try {
			String token = this.getAccess_token();
			if (token == null) {
				logger.error("WECHAT-创建标签时获取token异常");
				String RESULT_ERROR = "{'ERROR_MSG':'" + "获取token异常" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			
			String url = createTagUrl + "?" + "access_token=" + token; 
			String json = "{"+  
	                "\"tagname\":\""+ tagname +"\""+ "," +
	                "\"tagid\":"+ tagid + 
	            "}";
			
			String resultJson = HttpUtil.doPostJson(url, json);
			//json转对象
			JSONObject obj = JSONObject.fromObject(resultJson);
			return obj;
			 
		} catch (Exception e) {
			// TODO: handle exception
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}
	}

	/**
	 * 增加成员标签 
	 */
	@Override
	public JSONObject addTagUsers(String tagid) {
		// TODO Auto-generated method stub
		logger.info("wechat-增加成员标签");
		try {
			String token = this.getAccess_token();
			if (token == null) {
				logger.error("WECHAT-增加成员标签时获取token异常");
				String RESULT_ERROR = "{'ERROR_MSG':'" + "获取token异常" + "'}";
				JSONObject object = JSONObject.fromObject(RESULT_ERROR);
				return object;
			}
			
			String url = createUserTagUrl + "?" + "access_token=" + token; 
			String managerLevel = "";
			if (tagid.equals("1000")) {
				//M6
				managerLevel = "06";
			}else if(tagid.equals("1001")) {
				//M7
				managerLevel = "07";
			}else if(tagid.equals("1002")) {
				//M8
				managerLevel = "08";
			}else if(tagid.equals("1003")) {
				//M9
				managerLevel = "09";
			}
			List<String> userIds = wechatDao.getUserInfoByManagerLevel(managerLevel);
			double num = userIds.size() / 1000.0;
			//每次只能更新1000条 小数向上取整
			int total = (int) Math.ceil(num);
			for (int i = 0; i < total; i++) {
				List<String> tempUserIds = new ArrayList<String>();
				if ( i == (total - 1) ) {
					tempUserIds = userIds.subList(i * 1000, userIds.size());
				}else {
					tempUserIds = userIds.subList(i * 1000, (i+1) * 1000);
				}
				
				System.out.println(i);
				String json = "{"+  
		                "\"tagid\":"+ tagid + "," +
		                "\"userlist\":"+ tempUserIds + 
		            "}";  
				String resultJson = HttpUtil.doPostJson(url, json);
				logger.info("WECHAT-增加成员标签执行结果：" + resultJson);
			}

			//json转对象
			String RESULT_SUCCESS = "{'SUCCESS':'" + "WECHAT-增加成员标签成功，具体结果信息请查看日志" + "'}"; 
			JSONObject object = JSONObject.fromObject(RESULT_SUCCESS);
			return object;
			 
		} catch (Exception e) {
			// TODO: handle exception
			String RESULT_ERROR = "{'ERROR_MSG':'" + e + "'}";
			JSONObject object = JSONObject.fromObject(RESULT_ERROR);
			return object;
		}
		
	}

	
	/**
	 * set
	 * @param wechatDao
	 */
	public void setWechatDao(IWechatTongxunluDao wechatDao) {
		this.wechatDao = wechatDao;
	}

	
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

	
	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getCorpsecret() {
		return corpsecret;
	}

	public void setCorpsecret(String corpsecret) {
		this.corpsecret = corpsecret;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getCsvUrl() {
		return csvUrl;
	}

	public void setCsvUrl(String csvUrl) {
		this.csvUrl = csvUrl;
	}

	public String getDepartmentUrl() {
		return departmentUrl;
	}

	public void setDepartmentUrl(String departmentUrl) {
		this.departmentUrl = departmentUrl;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public String getResultUrl() {
		return resultUrl;
	}

	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	public String getUserDeleteUrl() {
		return userDeleteUrl;
	}

	public void setUserDeleteUrl(String userDeleteUrl) {
		this.userDeleteUrl = userDeleteUrl;
	}

	public String getWechatDepartmentUrl() {
		return WechatDepartmentUrl;
	}

	public void setWechatDepartmentUrl(String wechatDepartmentUrl) {
		WechatDepartmentUrl = wechatDepartmentUrl;
	}

	public String getWechatUserInfoUrl() {
		return WechatUserInfoUrl;
	}

	public void setWechatUserInfoUrl(String wechatUserInfoUrl) {
		WechatUserInfoUrl = wechatUserInfoUrl;
	}
	public String getMessageSecret() {
		return messageSecret;
	}

	public void setMessageSecret(String messageSecret) {
		this.messageSecret = messageSecret;
	}

	public String getWechatMessageSendUrl() {
		return wechatMessageSendUrl;
	}

	public void setWechatMessageSendUrl(String wechatMessageSendUrl) {
		this.wechatMessageSendUrl = wechatMessageSendUrl;
	}

	public String getUpdateUserUrl() {
		return updateUserUrl;
	}

	public void setUpdateUserUrl(String updateUserUrl) {
		this.updateUserUrl = updateUserUrl;
	}

	public String getCreateTagUrl() {
		return createTagUrl;
	}

	public void setCreateTagUrl(String createTagUrl) {
		this.createTagUrl = createTagUrl;
	}

	public String getCreateUserTagUrl() {
		return createUserTagUrl;
	}

	public void setCreateUserTagUrl(String createUserTagUrl) {
		this.createUserTagUrl = createUserTagUrl;
	}

	public String getCreateUserUrl() {
		return createUserUrl;
	}

	public void setCreateUserUrl(String createUserUrl) {
		this.createUserUrl = createUserUrl;
	}

}
