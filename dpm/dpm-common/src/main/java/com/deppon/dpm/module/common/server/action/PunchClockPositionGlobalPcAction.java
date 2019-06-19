package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IPunchClockPositionGlobalPcService;
import com.deppon.dpm.module.common.server.util.ServletUtil;

/**
 * 全国打卡位置信息管理
 * 2018-11-22
 */
public class PunchClockPositionGlobalPcAction extends BaseAction{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 5447499379440386214L;
	
	/**
	 * 日志
	 */
	private final static Logger LOG = LoggerFactory.getLogger(PunchClockPositionGlobalPcAction.class);
	
	//错误状态码
	private static final int STATUS_500 = 500;
	
	//错误状态码
	private static final int STATUS_501 = 501;
	
	//增加成功状态码
	private static final int STATUS_201 = 201;
	
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
	
	//更新id
	private int updateid;
	
	//部门ID
	private int orgid;
	
	//部门名称
	private String orgname;
	
	//打卡地址
	private String salesdepartaddr;
	
	//
	private String managerid;
	
	//
	private int parentorgid;
	
	//纬度
	private String latitude;

	//经度
	private String longitude;
	
	//打卡半径
	private String radius;
	
	//审核状态
	private int verifystatus;
	
	//当前页
	private int page;
	
	//每页显示条数
	private int rows;
	
	//service
	private IPunchClockPositionGlobalPcService punchClockPositionGlobalPcService;
	
	/**
	 * 页面跳转
	 */
	public String toPage(){
		return pageType;
	}
	
	/**
	 * 新增或更新全国打卡位置信息
	 */
	public void insertOrUpdate(){
		//操作的数据条数
		int i = 0;
		//如果是保存操作
		if("save".equals(operation)){
			try {
				//校验对应orgname的部门信息是否存在
				List<Map<String, Object>> orgInfos = punchClockPositionGlobalPcService.getOrganizationByOrgName(orgname);
				if(orgInfos == null || orgInfos.isEmpty()){
					//错误状态码
					ServletUtil.getResponse().setStatus(STATUS_501);
					//日志
					LOG.error("新增全国打卡位置信息出错>>>>:对应的部门名称不存在!");
					return;
				}
				//组装入表信息
				JSONObject hotLine = new JSONObject();
				hotLine.put("orgid", orgInfos.get(0).get("orgid"));
				hotLine.put("orgname", orgname);
				hotLine.put("salesdepartaddr", salesdepartaddr);
				hotLine.put("managerid", orgInfos.get(0).get("managerid"));
				hotLine.put("parentorgid", orgInfos.get(0).get("parentorgid"));
				hotLine.put("longitude", longitude);
				hotLine.put("latitude", latitude);
				hotLine.put("radius", radius);
				//保存数据
				i = punchClockPositionGlobalPcService.insert(hotLine);
				if( i == 1){
					//保存成功的状态码
					ServletUtil.getResponse().setStatus(STATUS_201);
				}else{
					//保存失败的状态码
					ServletUtil.getResponse().setStatus(STATUS_500);
				}
			} catch (Exception e) {
				//错误状态码
				ServletUtil.getResponse().setStatus(STATUS_500);
				//日志
				LOG.error("新增全国打卡位置信息出错>>>>:",e);
			}
		}else if("update".equals(operation)){ //更新操作
			try {
				JSONObject hotLine = new JSONObject();
				hotLine.put("id", updateid);
				hotLine.put("orgid", orgid);
				hotLine.put("longitude", longitude);
				hotLine.put("latitude", latitude);
				hotLine.put("radius", radius);
				hotLine.put("verifystatus", verifystatus);
				//更新
				i = punchClockPositionGlobalPcService.update(hotLine);
				if( i == 1){
					//更新成功的状态码
					ServletUtil.getResponse().setStatus(STATUS_204);
				}else{
					//更新失败的状态码
					ServletUtil.getResponse().setStatus(STATUS_500);
				}
			} catch (Exception e) {
				//错误状态码
				ServletUtil.getResponse().setStatus(STATUS_500);
				//日志
				LOG.error("修改全国打卡位置信息出错>>>>:",e);
			}
		}else{
			//错误状态码
			ServletUtil.getResponse().setStatus(STATUS_500);
		}
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
			punchClockPositionGlobalPcService.deleteByApplyCodes(ids);
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
			list = punchClockPositionGlobalPcService.queryList(begin,rows);
		} catch (Exception e) {
			//日志
			LOG.error("查询全国打卡位置信息列表出错!!!", e);
		}
		//查询总的数据条数
		long count = punchClockPositionGlobalPcService.queryCount();
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
	public void setPunchClockPositionGlobalPcService(
			IPunchClockPositionGlobalPcService punchClockPositionGlobalPcService) {
		this.punchClockPositionGlobalPcService = punchClockPositionGlobalPcService;
	}

	public int getUpdateid() {
		return updateid;
	}

	public void setUpdateid(int updateid) {
		this.updateid = updateid;
	}
	
	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getSalesdepartaddr() {
		return salesdepartaddr;
	}

	public void setSalesdepartaddr(String salesdepartaddr) {
		this.salesdepartaddr = salesdepartaddr;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public int getVerifystatus() {
		return verifystatus;
	}

	public void setVerifystatus(int verifystatus) {
		this.verifystatus = verifystatus;
	}
	
	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public int getParentorgid() {
		return parentorgid;
	}

	public void setParentorgid(int parentorgid) {
		this.parentorgid = parentorgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
}
