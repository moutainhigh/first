package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.server.service.IProjectManageDeptService;
import com.deppon.dpm.module.common.shared.domain.ProjectManageDeptEntity;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 工程管理部门
 */
public class ProjectManagePcAction extends BaseAction implements ModelDriven<ProjectManageDeptEntity>{

	// 构建实体
	private ProjectManageDeptEntity entity = new ProjectManageDeptEntity();
	
	// service
	private IProjectManageDeptService projectManageDeptService;
	
	// getModel
	public ProjectManageDeptEntity getModel() {
		return entity;
	}
	
	// 列表查询
	public void list() {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			// 当前页
			int page = entity.getPage();
			// 每页条数
			int rows = entity.getRows();
			int start = 0;
			if(page != 0) {
				start = (page -1) * rows;
			}
			// 查询
			List<ProjectManageDeptEntity> list = projectManageDeptService.list(start,rows);
			long count = projectManageDeptService.queryCount();
			result.put("total", count);
			result.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回
		writeToPage(result);
	}
	
	// 删除
	public void delete() {
		try {
			projectManageDeptService.delete(entity);
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}
	
	// 新增
	public void save() {
		try {
			projectManageDeptService.save(entity);
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}

	// setter
	public void setProjectManageDeptService(
			IProjectManageDeptService projectManageDeptService) {
		this.projectManageDeptService = projectManageDeptService;
	}
	
}
