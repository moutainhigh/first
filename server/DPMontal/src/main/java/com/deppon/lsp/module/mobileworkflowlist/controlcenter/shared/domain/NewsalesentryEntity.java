package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;
public class NewsalesentryEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8612736053462977518L;
	/**
	 * 表头id
	 */
	private String parentid;
	/**
	 * 预算项目
	 */
	private String budgetid;
	/**
	 * 预算名称
	 */
	private String budgetName;
	/**
	 * 物品id
	 */
	private String materialId;
	//物料编码
	private String materialCode;
	//物料名称
	private String materialName;
	//物料类型名称
	private String materialType;
	//物料型号
	private String materialModel;
	//单位id
	private String baseunitId;
	//单位名称
	private String baseunitName;
	//物料属性
	private String materialattId;
	//物料属性名称
	private String materialattName;
	//申请数量
	private BigDecimal applyNum;
	//未签收数量
	private BigDecimal unsignNum;
	//调拨数量
	private BigDecimal moveableNum;
	//参考单价
	private BigDecimal referencePrice;
	//参考金额
	private BigDecimal referenceAmount;
	//申请原因
	private String applyReason;
	//报废申请单编号
	private String scrapapplyedCode;
	//备注
	private String remark;
	//出库数量
	private BigDecimal outstoreNum;
	//使用部门
	private String usedeptid;
	//使用部门名称
	private String usedeptName;
	//分录标签类型
	private String tabPanelType;
	//枚举编码
	private String itemCode;
	//枚举值
	private String itemKey;
	
	/**
	 * parentid
	 *
	 * @return  the parentid
	 * @since   1.0.0
	 */
	
	public String getParentid() {
		return parentid;
	}
	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * budgetid
	 *
	 * @return  the budgetid
	 * @since   1.0.0
	 */
	
	public String getBudgetid() {
		return budgetid;
	}
	/**
	 * @param budgetid the budgetid to set
	 */
	public void setBudgetid(String budgetid) {
		this.budgetid = budgetid;
	}
	/**
	 * budgetName
	 *
	 * @return  the budgetName
	 * @since   1.0.0
	 */
	
	public String getBudgetName() {
		return budgetName;
	}
	/**
	 * @param budgetName the budgetName to set
	 */
	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}
	/**
	 * materialId
	 *
	 * @return  the materialId
	 * @since   1.0.0
	 */
	
	public String getMaterialId() {
		return materialId;
	}
	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	/**
	 * materialCode
	 *
	 * @return  the materialCode
	 * @since   1.0.0
	 */
	
	public String getMaterialCode() {
		return materialCode;
	}
	/**
	 * @param materialCode the materialCode to set
	 */
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	/**
	 * materialName
	 *
	 * @return  the materialName
	 * @since   1.0.0
	 */
	
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 * materialType
	 *
	 * @return  the materialType
	 * @since   1.0.0
	 */
	
	public String getMaterialType() {
		return materialType;
	}
	/**
	 * @param materialType the materialType to set
	 */
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	/**
	 * materialModel
	 *
	 * @return  the materialModel
	 * @since   1.0.0
	 */
	
	public String getMaterialModel() {
		return materialModel;
	}
	/**
	 * @param materialModel the materialModel to set
	 */
	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
	}
	/**
	 * baseunitId
	 *
	 * @return  the baseunitId
	 * @since   1.0.0
	 */
	
	public String getBaseunitId() {
		return baseunitId;
	}
	/**
	 * @param baseunitId the baseunitId to set
	 */
	public void setBaseunitId(String baseunitId) {
		this.baseunitId = baseunitId;
	}
	/**
	 * baseunitName
	 *
	 * @return  the baseunitName
	 * @since   1.0.0
	 */
	
	public String getBaseunitName() {
		return baseunitName;
	}
	/**
	 * @param baseunitName the baseunitName to set
	 */
	public void setBaseunitName(String baseunitName) {
		this.baseunitName = baseunitName;
	}
	/**
	 * materialattId
	 *
	 * @return  the materialattId
	 * @since   1.0.0
	 */
	
	public String getMaterialattId() {
		return materialattId;
	}
	/**
	 * @param materialattId the materialattId to set
	 */
	public void setMaterialattId(String materialattId) {
		this.materialattId = materialattId;
	}
	/**
	 * materialattName
	 *
	 * @return  the materialattName
	 * @since   1.0.0
	 */
	
	public String getMaterialattName() {
		return materialattName;
	}
	/**
	 * @param materialattName the materialattName to set
	 */
	public void setMaterialattName(String materialattName) {
		this.materialattName = materialattName;
	}
	/**
	 * applynum
	 *
	 * @return  the applynum
	 * @since   1.0.0
	 */
	
	public BigDecimal getApplyNum() {
		return applyNum;
	}
	/**
	 * applyreason
	 *
	 * @return  the applyreason
	 * @since   1.0.0
	 */
	
	public String getApplyreason() {
		return applyReason;
	}
	/**
	 * @param applyreason the applyreason to set
	 */
	public void setApplyreason(String applyreason) {
		this.applyReason = applyreason;
	}
	
	
	/**
	 * unsignNum
	 *
	 * @return  the unsignNum
	 * @since   1.0.0
	 */
	
	public BigDecimal getUnsignNum() {
		return unsignNum;
	}
	/**
	 * @param unsignNum the unsignNum to set
	 */
	public void setUnsignNum(BigDecimal unsignNum) {
		this.unsignNum = unsignNum;
	}
	/**
	 * moveableNum
	 *
	 * @return  the moveableNum
	 * @since   1.0.0
	 */
	
	public BigDecimal getMoveableNum() {
		return moveableNum;
	}
	/**
	 * @param moveableNum the moveableNum to set
	 */
	public void setMoveableNum(BigDecimal moveableNum) {
		this.moveableNum = moveableNum;
	}
	/**
	 * referencePrice
	 *
	 * @return  the referencePrice
	 * @since   1.0.0
	 */
	
	public BigDecimal getReferencePrice() {
		return referencePrice;
	}
	/**
	 * @param referencePrice the referencePrice to set
	 */
	public void setReferencePrice(BigDecimal referencePrice) {
		this.referencePrice = referencePrice;
	}
	/**
	 * referenceAmount
	 *
	 * @return  the referenceAmount
	 * @since   1.0.0
	 */
	
	public BigDecimal getReferenceAmount() {
		return referenceAmount;
	}
	/**
	 * @param referenceAmount the referenceAmount to set
	 */
	public void setReferenceAmount(BigDecimal referenceAmount) {
		this.referenceAmount = referenceAmount;
	}
	/**
	 * scrapapplyedCode
	 *
	 * @return  the scrapapplyedCode
	 * @since   1.0.0
	 */
	
	public String getScrapapplyedCode() {
		return scrapapplyedCode;
	}
	/**
	 * @param scrapapplyedCode the scrapapplyedCode to set
	 */
	public void setScrapapplyedCode(String scrapapplyedCode) {
		this.scrapapplyedCode = scrapapplyedCode;
	}
	/**
	 * outstoreNum
	 *
	 * @return  the outstoreNum
	 * @since   1.0.0
	 */
	
	public BigDecimal getOutstoreNum() {
		return outstoreNum;
	}
	/**
	 * @param outstoreNum the outstoreNum to set
	 */
	public void setOutstoreNum(BigDecimal outstoreNum) {
		this.outstoreNum = outstoreNum;
	}
	/**
	 * @param applyNum the applyNum to set
	 */
	public void setApplyNum(BigDecimal applyNum) {
		this.applyNum = applyNum;
	}
	/**
	 * remark
	 *
	 * @return  the remark
	 * @since   1.0.0
	 */
	
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * usedeptid
	 *
	 * @return  the usedeptid
	 * @since   1.0.0
	 */
	
	public String getUsedeptid() {
		return usedeptid;
	}
	/**
	 * @param usedeptid the usedeptid to set
	 */
	public void setUsedeptid(String usedeptid) {
		this.usedeptid = usedeptid;
	}
	/**
	 * usedeptName
	 *
	 * @return  the usedeptName
	 * @since   1.0.0
	 */
	
	public String getUsedeptName() {
		return usedeptName;
	}
	/**
	 * @param usedeptName the usedeptName to set
	 */
	public void setUsedeptName(String usedeptName) {
		this.usedeptName = usedeptName;
	}
	/**
	 * tabPanelType
	 *
	 * @return  the tabPanelType
	 * @since   1.0.0
	 */
	
	public String getTabPanelType() {
		return tabPanelType;
	}
	/**
	 * @param tabPanelType the tabPanelType to set
	 */
	public void setTabPanelType(String tabPanelType) {
		this.tabPanelType = tabPanelType;
	}
	/**
	 * itemCode
	 *
	 * @return  the itemCode
	 * @since   1.0.0
	 */
	
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * @param itemCode the itemCode to set
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * itemKeyp
	 *
	 * @return  the itemKeyp
	 * @since   1.0.0
	 */
	
	public String getItemKey() {
		return itemKey;
	}
	/**
	 * @param itemKeyp the itemKeyp to set
	 */
	public void setItemKey(String itemKeyp) {
		this.itemKey = itemKeyp;
	}
	
	/* (non-Javadoc)
	 * @see com.deppon.foss.framework.entity.BaseEntity#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof NewsalesentryEntity){
			
			NewsalesentryEntity entity=(NewsalesentryEntity) obj;
			if(!StringUtil.isBlank(entity.getId())&&!StringUtil.isBlank(this.getId())){
				return this.getId().equals(entity.getId());
			}else{
				return entity.getMaterialId().equals(this.getMaterialId())&&entity.getUsedeptid().equals(this.getUsedeptid())
					&&entity.getItemCode().equals(this.getItemCode())&&entity.getItemKey().equals(this.getItemKey());
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
}

