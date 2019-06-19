package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CostDpte;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.Deviation;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.FinalAccountApplyEntity;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.FinalAccountLine;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.MeetingSummary;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.NonConstructionType;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WithHoldLine;

/**
 * 
 * @author niuyafeng
 * @date 2014-5-21 10:09:56
 * @describe 决算单实体Vo对象
 * @version 0.1
 *
 */
public class FinalAccountApplyVo {

	/**
	 * 表头实体
	 */
	private FinalAccountApplyEntity finalAccountApplyEntity;
	//
	/**
	 * 明细表体实体LIST
	 */
	private List<FinalAccountLine> lineList;
	/**
	 * 非施工类型明细实体
	 */
	private List<NonConstructionType> nonConstTypelineList;
	/**
	 * 扣款明细实体
	 */
	private List<WithHoldLine> withHoldlineList;
	/**
	 * 偏离度明细实体
	 */
	private List<Deviation> deviationLineList;
	/**
	 * 费用承担部门实体
	 */
	private List<CostDpte> costDpteList;
	
	/**
	 * 项目类型为非网点时，多加显示的实体,决算会审意见和审计报告属于表头实体字段
	 */
	/**
	 * 查询会议纪要明细实体
	 */
	private List<MeetingSummary> meetingSummaryList;

	
	public FinalAccountApplyEntity getFinalAccountApplyEntity() {
		return finalAccountApplyEntity;
	}

	public void setFinalAccountApplyEntity(
			FinalAccountApplyEntity finalAccountApplyEntity) {
		this.finalAccountApplyEntity = finalAccountApplyEntity;
	}

	public List<FinalAccountLine> getLineList() {
		if (lineList == null) {
			lineList = new ArrayList<FinalAccountLine>();
		}
		return lineList;
	}

	public void setLineList(List<FinalAccountLine> lineList) {
		this.lineList = lineList;
	}

	public List<NonConstructionType> getNonConstTypelineList() {
		if (nonConstTypelineList == null) {
			nonConstTypelineList = new ArrayList<NonConstructionType>();
		}
		return nonConstTypelineList;
	}

	public void setNonConstTypelineList(
			List<NonConstructionType> nonConstTypelineList) {
		this.nonConstTypelineList = nonConstTypelineList;
	}

	public List<WithHoldLine> getWithHoldlineList() {
		if (withHoldlineList == null) {
			withHoldlineList = new ArrayList<WithHoldLine>();
		}
		return withHoldlineList;
	}

	public void setWithHoldlineList(List<WithHoldLine> withHoldlineList) {
		this.withHoldlineList = withHoldlineList;
	}

	public List<Deviation> getDeviationLineList() {
		if (deviationLineList == null) {
			deviationLineList = new ArrayList<Deviation>();
		}
		return deviationLineList;
	}

	public void setDeviationLineList(List<Deviation> deviationLineList) {
		this.deviationLineList = deviationLineList;
	}

	public List<CostDpte> getCostDpteList() {
		if (costDpteList == null) {
			costDpteList = new ArrayList<CostDpte>();
		}
		return costDpteList;
	}

	public void setCostDpteList(List<CostDpte> costDpteList) {
		this.costDpteList = costDpteList;
	}

	public List<MeetingSummary> getMeetingSummaryList() {
		if (meetingSummaryList == null) {
			meetingSummaryList = new ArrayList<MeetingSummary>();
		}
		return meetingSummaryList;
	}

	public void setMeetingSummaryList(List<MeetingSummary> meetingSummaryList) {
		this.meetingSummaryList = meetingSummaryList;
	}
}
