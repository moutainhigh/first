package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 * 工程项目结算单分录表实体
 * @author hesiwei
 * @date 2013-10-25 上午10:07:57
 * @since
 * @version
 *
 */
public class ProjectClearEntryEntity extends BaseEntity implements Serializable{

	/** 序列号 */
	private static final long serialVersionUID = 5419431619624096135L;
	/**分录表主键 */
	private String fid;
	/**单据分录序 */
	private Integer fseq;
	/**父级表主键 */
	private String fparentid;
	/***/
	private Integer cfseq;
	/**费用承担部门 */
	private String cfcostundertakedep;
	/**费用比例 */
	private BigDecimal cfcostratio;
	/**金额 */
	private BigDecimal cfsum;
	//******配合界面显示新增字段******//
	/**费用承担部门名称 */
	private String cfcostundertakedepName;
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public Integer getFseq() {
		return fseq;
	}
	public void setFseq(Integer fseq) {
		this.fseq = fseq;
	}
	public String getFparentid() {
		return fparentid;
	}
	public void setFparentid(String fparentid) {
		this.fparentid = fparentid;
	}
	public Integer getCfseq() {
		return cfseq;
	}
	public void setCfseq(Integer cfseq) {
		this.cfseq = cfseq;
	}
	public String getCfcostundertakedep() {
		return cfcostundertakedep;
	}
	public void setCfcostundertakedep(String cfcostundertakedep) {
		this.cfcostundertakedep = cfcostundertakedep;
	}
	public BigDecimal getCfcostratio() {
		return cfcostratio;
	}
	public void setCfcostratio(BigDecimal cfcostratio) {
		this.cfcostratio = cfcostratio;
	}
	public BigDecimal getCfsum() {
		return cfsum;
	}
	public void setCfsum(BigDecimal cfsum) {
		this.cfsum = cfsum;
	}
	public String getCfcostundertakedepName() {
		return cfcostundertakedepName;
	}
	public void setCfcostundertakedepName(String cfcostundertakedepName) {
		this.cfcostundertakedepName = cfcostundertakedepName;
	}
}
