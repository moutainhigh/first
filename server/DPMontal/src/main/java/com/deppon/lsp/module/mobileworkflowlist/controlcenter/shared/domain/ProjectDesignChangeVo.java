package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;

import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.DesignChangeEntryVo;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.DesignChangeVo;
import com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.DesignChangee2Vo;

/**
 *设计变更单VO
 */
public class ProjectDesignChangeVo {
	//设计变更单核算明细
	private List<DesignChangee2Vo> designChagee2Vo;
	//设计变更单分录明细
	private List<DesignChangeEntryVo> designChangeEntryVo;
	//设计变更单
	private DesignChangeVo designChangeVo;
	
	
	
	public List<DesignChangee2Vo> getDesignChagee2Vo() {
		if (designChagee2Vo == null) {
			designChagee2Vo = new ArrayList<DesignChangee2Vo>();
		}
		return designChagee2Vo;
	}
	public void setDesignChagee2Vo(List<DesignChangee2Vo> designChagee2Vo) {
		this.designChagee2Vo = designChagee2Vo;
	}
	public List<DesignChangeEntryVo> getDesignChangeEntryVo() {
		if (designChangeEntryVo == null) {
			designChangeEntryVo = new ArrayList<DesignChangeEntryVo>();
		}
		return designChangeEntryVo;
	}
	public void setDesignChangeEntryVo(List<DesignChangeEntryVo> designChangeEntryVo) {
		this.designChangeEntryVo = designChangeEntryVo;
	}
	public DesignChangeVo getDesignChangeVo() {
		if (designChangeVo == null) {
			designChangeVo = new DesignChangeVo();
		}
		return designChangeVo;
	}
	public void setDesignChangeVo(DesignChangeVo designChangeVo) {
		this.designChangeVo = designChangeVo;
	}
}
