package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectClearEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ProjectClearEntryEntity;

/**
 * 
 * @author niuyafeng
 * @date 2014-5-21 10:09:56
 * @describe 工程项目结算单实体Vo对象
 * @version 0.1
 *
 */
public class ProjectclearVo {
	
	/**
	 *  表头信息列表
	 */
		private List<ProjectClearEntity> billlist;
		
	/**
	 * 工程项目结算单分录表信息
	 */
		private List<ProjectClearEntryEntity> entryList;

	public List<ProjectClearEntity> getBilllist() {
		if (billlist == null) {
			billlist = new ArrayList<ProjectClearEntity>();
		}
		return billlist;
	}

	public void setBilllist(List<ProjectClearEntity> billlist) {
		this.billlist = billlist;
	}

	public List<ProjectClearEntryEntity> getEntryList() {
		if (entryList == null) {
			entryList = new ArrayList<ProjectClearEntryEntity>();
		}
		return entryList;
	}

	public void setEntryList(List<ProjectClearEntryEntity> entryList) {
		this.entryList = entryList;
	}
	
}
