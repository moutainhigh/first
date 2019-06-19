package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.IH5ApplyFileCompareService;
import com.deppon.dpm.module.common.server.util.ServletUtil;
import com.deppon.dpm.module.common.shared.domain.H5FileCountEntity;

/**
 * 专为Android记录H5应用文件数量使用，
 * 每次点击H5应用时查询文件数量，在前台作对比判断文件是否缺失
 * 2016-01-27
 */
public class H5ApplyFileComparePcAction extends BaseAction{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 5447499379440386214L;
	
	/**
	 * 日志
	 */
	private final static Logger LOG = LoggerFactory.getLogger(H5ApplyFileComparePcAction.class);
	
	//错误状态码
	private static final int STATUS_500 = 500;
	
	//增加成功状态码
	private static final int STATUS_201 = 201;
	
	//修改成功状态码
	private static final int STATUS_204 = 204;
	
	//H5应用编号
	private int applyCode;
	
	//应用编号s，以,分隔的字符串
	private String applyCodes;
	
	//跳转的页面类型
	private String pageType;
	
	//操作类型
	private String operation;
	
	//H5文件数量
	private int count;
	
	//当前页
	private int page;
	
	//每页显示条数
	private int rows;
	
	//service
	private IH5ApplyFileCompareService h5ApplyFileCompareService;
	
	/**
	 * 页面跳转
	 */
	public String toPage(){
		return pageType;
	}
	
	/**
	 * 新增H5应用文件信息
	 */
	public void insertOrUpdate(){
		//操作的数据条数
		int i = 0;
		//如果是保存操作
		if("save".equals(operation)){
			try {
				//保存数据
				i = h5ApplyFileCompareService.insert(applyCode,count);
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
				LOG.error("新增H5资源文件信息出错>>>>{applyCode="+applyCode+",count="+count+"}",e);
			}
		}else if("update".equals(operation)){ //更新操作
			try {
				//更新
				i = h5ApplyFileCompareService.update(applyCode,count);
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
				LOG.error("修改H5资源文件信息出错>>>>{applyCode="+applyCode+",count="+count+"}",e);
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
		if(StringUtils.isEmpty(applyCodes)){
			//返回500
			ServletActionContext.getResponse().setStatus(STATUS_500);
			return;
		}
		try {
			h5ApplyFileCompareService.deleteByApplyCodes(applyCodes);
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
		List<H5FileCountEntity> list = null;
		try {
			//查询列表数据
			list = h5ApplyFileCompareService.queryList(begin,rows);
		} catch (Exception e) {
			//日志
			LOG.error("查询H5资源文件数量信息列表出错!!!", e);
		}
		//查询总的数据条数
		long count = h5ApplyFileCompareService.queryCount();
		//需要转为json的数据
		Map<String,Object> map = new HashMap<String,Object>();
		//封装数据
		map.put("rows", list);
		map.put("total", count);
		//写入页面
		writeToPage(map);
	}
	
	//getter
	public int getApplyCode() {
		return applyCode;
	}

	//setter
	public void setApplyCode(int applyCode) {
		this.applyCode = applyCode;
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
	public int getCount() {
		return count;
	}

	//setter
	public void setCount(int count) {
		this.count = count;
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
	public String getApplyCodes() {
		return applyCodes;
	}

	//setter
	public void setApplyCodes(String applyCodes) {
		this.applyCodes = applyCodes;
	}

	//setter
	public void setH5ApplyFileCompareService(
			IH5ApplyFileCompareService h5ApplyFileCompareService) {
		this.h5ApplyFileCompareService = h5ApplyFileCompareService;
	}
}
