package com.deppon.dpm.module.common.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IOutSourceUserManagerPcService;
import com.deppon.dpm.module.common.server.util.DES;
import com.deppon.dpm.module.common.server.util.ServletUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;

/**
 * out source user 管理
 * 2018-09-25
 */
public class OutSourceUserManagerPcAction extends BaseAction{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -1L;
	
	/**
	 * 日志
	 */
	private final static Logger LOG = LoggerFactory.getLogger(OutSourceUserManagerPcAction.class);
	
	//错误状态码
	private static final int STATUS_500 = 500;
	
	//弱密码状态码
	private static final int STATUS_599 = 599;
	
	//修改成功状态码
	private static final int STATUS_204 = 204;
	
	//app permission编号
	private int id;
	
	//应用编号s，以,分隔的字符串
	private String ids;
	
	//跳转的页面类型
	private String pageType;
	
	//操作类型
	private String operation;
	
	//update staff_id
	private int updateid;
	
	//工号
	private String staff_id;
	
	//姓名
	private String staff_name;
	
	//密码
	private String passwd;
	
	//密码
	private String newPasswd;
	
	//当前页
	private int page;
	
	//每页显示条数
	private int rows;
	
	//service
	private IOutSourceUserManagerPcService outSourceUserManagerPcService;
	
	/**
	 * 页面跳转
	 */
	public String toPage(){
		return pageType;
	}
	
	/**
	 * 更新外包人员密码信息
	 */
	public void updateOutUser(){
		
		//操作的数据条数
		int i = 0;
		BufferedReader bu;
		try {
			bu = ServletActionContext.getRequest().getReader();
			// 编码转换
			String strRegist = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			Map<String,String> requestparam = getRequestParam(strRegist);
			passwd = requestparam.get("newPasswd");
			staff_id = requestparam.get("staff_id");
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String pwd_enc = new String(Base64.encodeBase64(md5.digest(passwd.getBytes("utf-8"))));
			boolean is_weak = outSourceUserManagerPcService.isWeakPassword(pwd_enc);
			if(is_weak){
				//更新失败的状态码
				ServletUtil.getResponse().setStatus(STATUS_599);
				ServletUtil.getResponse().getWriter().write("更改密码失败:新密码为弱密码,请重新输入新密码!");
			}else{
				JSONObject user = new JSONObject();
				user.put("staff_id", staff_id);
				user.put("passwd", DES.encryptDES(new String(Base64.encodeBase64(passwd.getBytes()))));
				//更新
				i = outSourceUserManagerPcService.update(user);
				if( i == 1){
					//更新成功的状态码
					ServletUtil.getResponse().setStatus(STATUS_204);
					ServletUtil.getResponse().getWriter().write("更改密码成功!");
				}else{
					//更新失败的状态码
					ServletUtil.getResponse().setStatus(STATUS_500);
					ServletUtil.getResponse().getWriter().write("更改密码失败!");
				}
			}
			
		} catch (Exception e) {
			//错误状态码
			ServletUtil.getResponse().setStatus(STATUS_500);
			try {
				ServletUtil.getResponse().getWriter().write("更改密码失败:"+e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//日志
			LOG.error("修改外包人员信息出错>>>>:",e);
		}
		
	}
	//deal with request parameters string
	private Map<String,String> getRequestParam(String paramStr){
		Map<String,String> requestParam = new HashMap<String,String>();
		if(paramStr != null){
			String[] request = paramStr.split("&");
			if(request != null && request.length > 0){
				for(String req : request){
					String[] entry = req.split("=");
					requestParam.put(entry[0], entry[1]);
				}
			}
		}
		return requestParam;
	}
	
	/**
	 * 删除
	 */
	public void delete(){
		// 判断是否为空
		if(StringUtils.isEmpty(ids)){
			//返回500
			ServletActionContext.getResponse().setStatus(STATUS_500);
			return;
		}
		try {
			outSourceUserManagerPcService.deleteByApplyCodes(ids);
			//删除成功返回204
			ServletActionContext.getResponse().setStatus(STATUS_204);
		} catch (Exception e) {
			//出现异常，返回500
			ServletActionContext.getResponse().setStatus(STATUS_500);
		}
	}
	
	/**
	 * 列表
	 */
	public void list(){
		//分页查询起始索引
		int begin = (page - 1) * rows;
		//定义返回的数据列表
		List<Map<String,Object>> list = null;
		try {
			//查询列表数据
			list = outSourceUserManagerPcService.queryList(begin,rows);
			for(Map<String,Object> user :list){
				user.put("passwd",new String(Base64.decodeBase64(DES.decryptDES(user.get("passwd").toString()))));
			}
		} catch (Exception e) {
			//日志
			LOG.error("查询app permission信息列表出错!!!", e);
		}
		//查询总的数据条数
		long count = outSourceUserManagerPcService.queryCount();
		//需要转为json的数据
		Map<String,Object> map = new HashMap<String,Object>();
		//封装数据
		map.put("rows", list);
		map.put("total", count);
		//写入页面
		writeToPage(map);
	}
	
	//getter
	public int getId() {
		return id;
	}

	//setter
	public void setid(int id) {
		this.id = id;
	}

	//getter
	public String getPageType() {
		return pageType;
	}

	//setter
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	//getter
	public int getPage() {
		return page;
	}
	
	//setter
	public void setPage(int page) {
		this.page = page;
	}

	//getter
	public int getRows() {
		return rows;
	}

	//setter
	public void setRows(int rows) {
		this.rows = rows;
	}

	//getter
	public String getOperation() {
		return operation;
	}
	
	//setter
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	//getter
	public String getIds() {
		return ids;
	}

	//setter
	public void setIds(String ids) {
		this.ids = ids;
	}

	//setter
	public void setOutSourceUserManagerPcService(IOutSourceUserManagerPcService outSourceUserManagerPcService) {
		this.outSourceUserManagerPcService = outSourceUserManagerPcService;
	}

	public int getUpdateid() {
		return updateid;
	}

	public void setUpdateid(int updateid) {
		this.updateid = updateid;
	}
	
	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNewPasswd() {
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}
}
