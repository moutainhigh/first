package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.BillSingleChange;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ChangeLine;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.StuffLine;

/**
 * 
 * @author niuyafeng
 * @date 2014-5-21 10:09:56
 * @describe 工程量单变更单实体Vo对象
 * @version 0.1
 *
 */
public class ProgrammeChangeNoticeVo {
	
	/**
	 * 表头实体
	 */
	private BillSingleChange proChangeEntity;
	
	/**
	 * 查询明细中的变更明细信息
	 */
	private List<ChangeLine> changeLineList;
	/**
	 * 材料明细信息分录
	 */
	private List<StuffLine> stuffLineList;
	
	public BillSingleChange getProChangeEntity() {
		return proChangeEntity;
	}

	public void setProChangeEntity(BillSingleChange proChangeEntity) {
		this.proChangeEntity = proChangeEntity;
	}

	public List<ChangeLine> getChangeLineList() {
		if (changeLineList == null) {
			changeLineList = new ArrayList<ChangeLine>();
		}
		return changeLineList;
	}

	public void setChangeLineList(List<ChangeLine> changeLineList) {
		this.changeLineList = changeLineList;
	}

	public List<StuffLine> getStuffLineList() {
		if (stuffLineList == null) {
			stuffLineList = new ArrayList<StuffLine>();
		}
		return stuffLineList;
	}

	public void setStuffLineList(List<StuffLine> stuffLineList) {
		this.stuffLineList = stuffLineList;
	}
}
