package com.deppon.dpm.uums.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.uums.server.domain.VersionEntity;
import com.deppon.dpm.uums.server.service.IVersionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VersionPcAction extends ActionSupport implements ModelDriven<VersionEntity>{
	
	// 返回的结果集
	private Object resultObj;

	// 构建实例
	private VersionEntity versionEntity = new VersionEntity();
	
	// service
	private IVersionService versionService;
	
	// 复写
	public VersionEntity getModel() {
		return versionEntity;
	}
	
	/**
	 * 页面跳转
	 */
	public String toEditPage(){
		return "editPage";
	}

	/**
	 * 查询所有，新的PC端后台管理系统用
	 */
	public String list(){
		// 查询所有
		List<VersionEntity> list = versionService.selectVersions();
		// 返回的结果
		Map<String,Object> map = new HashMap<String,Object>();
		// 判断
		if(null != list){
			map.put("total", list.size());
		}else{
			map.put("total", 0);
		}
		map.put("rows", list);
		// 压入值栈
		this.setResultObj(map);
		// 返回
		return SUCCESS;
	}
	
	/**
	 * 更新，新的PC端后台管理系统用
	 */
	public String update(){
		String result = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			result = versionService.updateVersion(getModel());
			// 判断是否成功
			if("-1".equals(result)){
				map.put("success", false);
			}else{
				map.put("success", true);
			}
		} catch (Exception e) {
			map.put("success", false);
			e.printStackTrace();
		}
		// 返回的结果
		// 压入值栈
		this.resultObj = map;
		// 返回
		return SUCCESS;
	}

	// setter
	public void setVersionService(IVersionService versionService) {
		this.versionService = versionService;
	}

	// getter
	public Object getResultObj() {
		return resultObj;
	}

	// setter
	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}
}
