
package com.deppon.montal.module.crm.damin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ContractInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applyPersonCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyPersonName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="divisionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyPersonDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contractNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subsidiary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contractStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="contractEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="customerCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amountOfConsignment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customerAllName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nodeSectionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="settleAccountsDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="balanceAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="preferentialType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="freightDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generationRateDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chargeRateDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cargoFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliveryFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="protocolContactName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contactPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contactTel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modifyContractType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oldContractNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newBalanceAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newFreightDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newPreferentialType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newGenerationRateDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newChargeRateDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newCargoFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newDeliveryFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contrctAscriptionDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyBondingDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ascriptionDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyRenewalDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priceVersionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="expPriceVersiondate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="modifyPreferentialType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expressPreferentialType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expNewPreferentialType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expFreightDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expNewFreightDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expWxpgenerationRateDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expNewDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expChargeRateDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expNewChargeRateDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expCargoFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expNewCargoFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expDeliVeryFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expNewDeliveryFeeDiscount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expNodesectionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expAmountOfConsignMent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="signCompany" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invoiceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invoiceTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newSignCompany" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newInvoiceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newInvoiceTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contrctAscriptionDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyBondingDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ascriptionDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyRenewalDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractInfo", propOrder = {
    "applyPersonCode",
    "applyPersonName",
    "divisionCode",
    "applyPersonDept",
    "applyType",
    "contractNumber",
    "subsidiary",
    "contractStartDate",
    "contractEndDate",
    "customerCode",
    "customerName",
    "amountOfConsignment",
    "customerAllName",
    "nodeSectionType",
    "settleAccountsDate",
    "balanceAccount",
    "preferentialType",
    "freightDiscount",
    "generationRateDiscount",
    "chargeRateDiscount",
    "cargoFeeDiscount",
    "deliveryFeeDiscount",
    "protocolContactName",
    "contactPhone",
    "contactTel",
    "discount",
    "modifyContractType",
    "oldContractNumber",
    "newBalanceAccount",
    "newFreightDiscount",
    "newPreferentialType",
    "newGenerationRateDiscount",
    "newChargeRateDiscount",
    "newCargoFeeDiscount",
    "newDeliveryFeeDiscount",
    "contrctAscriptionDept",
    "applyBondingDept",
    "ascriptionDept",
    "applyRenewalDept",
    "applyReason",
    "priceVersionDate",
    "expPriceVersiondate",
    "modifyPreferentialType",
    "expressPreferentialType",
    "expNewPreferentialType",
    "expFreightDiscount",
    "expNewFreightDiscount",
    "expWxpgenerationRateDiscount",
    "expNewDiscount",
    "expChargeRateDiscount",
    "expNewChargeRateDiscount",
    "expCargoFeeDiscount",
    "expNewCargoFeeDiscount",
    "expDeliVeryFeeDiscount",
    "expNewDeliveryFeeDiscount",
    "expNodesectionType",
    "expAmountOfConsignMent",
    "signCompany",
    "invoiceType",
    "invoiceTypeName",
    "newSignCompany",
    "newInvoiceType",
    "newInvoiceTypeName",
    "contrctAscriptionDeptName",
    "applyBondingDeptName",
    "ascriptionDeptName",
    "applyRenewalDeptName"
})
public class ContractInfo {
	//申请人工号
    @XmlElement(required = true)
    protected String applyPersonCode;
    //申请人
    @XmlElement(required = true)
    protected String applyPersonName;
    //所属事业部
    @XmlElement(required = true)
    protected String divisionCode;
    //所属部门
    @XmlElement(required = true)
    protected String applyPersonDept;
    //申请类型
    @XmlElement(required = true)
    protected String applyType;
    //合同序号
    @XmlElement(required = true)
    protected String contractNumber;
    //所属子公司
    @XmlElement(required = true)
    protected String subsidiary;
    //合同起始日期
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contractStartDate;
    //合同到期日期
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contractEndDate;
    //客户编码
    @XmlElement(required = true)
    protected String customerCode;
    //客户名称
    @XmlElement(required = true)
    protected String customerName;
    //近三月发货金额
    @XmlElement(required = true)
    protected String amountOfConsignment;
    //客户全称
    @XmlElement(required = true)
    protected String customerAllName;
    //结款方式
    @XmlElement(required = true)
    protected String nodeSectionType;
    //结款日期
    @XmlElement(required = true)
    protected String settleAccountsDate;
    //结算限额
    @XmlElement(required = true)
    protected String balanceAccount;
    //优惠类型
    @XmlElement(required = true)
    protected String preferentialType;
    //运费折扣
    @XmlElement(required = true)
    protected String freightDiscount;
    //代收费率折扣
    @XmlElement(required = true)
    protected String generationRateDiscount;
    //保价费率折扣
    @XmlElement(required = true)
    protected String chargeRateDiscount;
    //接货费折扣
    @XmlElement(required = true)
    protected String cargoFeeDiscount;
    //送货费折扣
    @XmlElement(required = true)
    protected String deliveryFeeDiscount;
    //协议联系人
    @XmlElement(required = true)
    protected String protocolContactName;
    //联系人手机
    @XmlElement(required = true)
    protected String contactPhone;
    //联系人电话
    @XmlElement(required = true)
    protected String contactTel;
    @XmlElement(required = true)
    protected String discount;
    @XmlElement(required = true)
    protected String modifyContractType;
    @XmlElement(required = true)
    protected String oldContractNumber;
    //新结算限额
    @XmlElement(required = true)
    protected String newBalanceAccount;
    @XmlElement(required = true)
    protected String newFreightDiscount;
    @XmlElement(required = true)
    protected String newPreferentialType;
    @XmlElement(required = true)
    protected String newGenerationRateDiscount;
    @XmlElement(required = true)
    protected String newChargeRateDiscount;
    @XmlElement(required = true)
    protected String newCargoFeeDiscount;
    @XmlElement(required = true)
    protected String newDeliveryFeeDiscount;
    @XmlElement(required = true)
    protected String contrctAscriptionDept;
    @XmlElement(required = true)
    protected String applyBondingDept;
    @XmlElement(required = true)
    protected String ascriptionDept;
    @XmlElement(required = true)
    protected String applyRenewalDept;
    @XmlElement(required = true)
    protected String applyReason;
    //价格版本
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar priceVersionDate;
    //快递价格版本
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expPriceVersiondate;
    @XmlElement(required = true)
    protected String modifyPreferentialType;
    //快递优惠类型
    @XmlElement(required = true)
    protected String expressPreferentialType;
    @XmlElement(required = true)
    protected String expNewPreferentialType;
    //快递运费折扣
    @XmlElement(required = true)
    protected String expFreightDiscount;
    @XmlElement(required = true)
    protected String expNewFreightDiscount;
    //快递代收费率折扣( 即日退代收折扣)
    @XmlElement(required = true)
    protected String expWxpgenerationRateDiscount;
    @XmlElement(required = true)
    protected String expNewDiscount;
    //快递保价费率折扣
    @XmlElement(required = true)
    protected String expChargeRateDiscount;
    @XmlElement(required = true)
    protected String expNewChargeRateDiscount;
    @XmlElement(required = true)
    protected String expCargoFeeDiscount;
    @XmlElement(required = true)
    protected String expNewCargoFeeDiscount;
    @XmlElement(required = true)
    protected String expDeliVeryFeeDiscount;
    @XmlElement(required = true)
    protected String expNewDeliveryFeeDiscount;
    //快递结款方式
    @XmlElement(required = true)
    protected String expNodesectionType;
    //快递近三月发货金额
    @XmlElement(required = true)
    protected String expAmountOfConsignMent;
    //签署合同公司
    @XmlElement(required = true)
    protected String signCompany;
    //发票标记
    @XmlElement(required = true)
    protected String invoiceType;
    //发票标记名称
    @XmlElement(required = true)
    protected String invoiceTypeName;
    //新签署合同公司
    @XmlElement(required = true)
    protected String newSignCompany;
    @XmlElement(required = true)
    protected String newInvoiceType;
    @XmlElement(required = true)
    protected String newInvoiceTypeName;
    //申请绑定部门名字
	@XmlElement(required = true)
    protected String contrctAscriptionDeptName;
	 //申请绑定部门名字
    @XmlElement(required = true)
    protected String applyBondingDeptName;
    public String getContrctAscriptionDeptName() {
		return contrctAscriptionDeptName;
	}

	public String getApplyBondingDeptName() {
		return applyBondingDeptName;
	}

	public String getAscriptionDeptName() {
		return ascriptionDeptName;
	}

	public String getApplyRenewalDeptName() {
		return applyRenewalDeptName;
	}

	public void setContrctAscriptionDeptName(String contrctAscriptionDeptName) {
		this.contrctAscriptionDeptName = contrctAscriptionDeptName;
	}

	public void setApplyBondingDeptName(String applyBondingDeptName) {
		this.applyBondingDeptName = applyBondingDeptName;
	}

	public void setAscriptionDeptName(String ascriptionDeptName) {
		this.ascriptionDeptName = ascriptionDeptName;
	}

	public void setApplyRenewalDeptName(String applyRenewalDeptName) {
		this.applyRenewalDeptName = applyRenewalDeptName;
	}

	//现有归属部门名字
    @XmlElement(required = true)
    protected String ascriptionDeptName;
    //申请变更部门名字
    @XmlElement(required = true)
    protected String applyRenewalDeptName;

    /**
     * Gets the value of the applyPersonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyPersonCode() {
        return applyPersonCode;
    }

    /**
     * Sets the value of the applyPersonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyPersonCode(String value) {
        this.applyPersonCode = value;
    }

    /**
     * Gets the value of the applyPersonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyPersonName() {
        return applyPersonName;
    }

    /**
     * Sets the value of the applyPersonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyPersonName(String value) {
        this.applyPersonName = value;
    }

    /**
     * Gets the value of the divisionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivisionCode() {
        return divisionCode;
    }

    /**
     * Sets the value of the divisionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivisionCode(String value) {
        this.divisionCode = value;
    }

    /**
     * Gets the value of the applyPersonDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyPersonDept() {
        return applyPersonDept;
    }

    /**
     * Sets the value of the applyPersonDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyPersonDept(String value) {
        this.applyPersonDept = value;
    }

    /**
     * Gets the value of the applyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * Sets the value of the applyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyType(String value) {
        this.applyType = value;
    }

    /**
     * Gets the value of the contractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Sets the value of the contractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractNumber(String value) {
        this.contractNumber = value;
    }

    /**
     * Gets the value of the subsidiary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubsidiary() {
        return subsidiary;
    }

    /**
     * Sets the value of the subsidiary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubsidiary(String value) {
        this.subsidiary = value;
    }

    /**
     * Gets the value of the contractStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractStartDate() {
        return contractStartDate;
    }

    /**
     * Sets the value of the contractStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractStartDate(XMLGregorianCalendar value) {
        this.contractStartDate = value;
    }

    /**
     * Gets the value of the contractEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractEndDate() {
        return contractEndDate;
    }

    /**
     * Sets the value of the contractEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractEndDate(XMLGregorianCalendar value) {
        this.contractEndDate = value;
    }

    /**
     * Gets the value of the customerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Sets the value of the customerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the amountOfConsignment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountOfConsignment() {
        return amountOfConsignment;
    }

    /**
     * Sets the value of the amountOfConsignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountOfConsignment(String value) {
        this.amountOfConsignment = value;
    }

    /**
     * Gets the value of the customerAllName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerAllName() {
        return customerAllName;
    }

    /**
     * Sets the value of the customerAllName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerAllName(String value) {
        this.customerAllName = value;
    }

    /**
     * Gets the value of the nodeSectionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeSectionType() {
        return nodeSectionType;
    }

    /**
     * Sets the value of the nodeSectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeSectionType(String value) {
        this.nodeSectionType = value;
    }

    /**
     * Gets the value of the settleAccountsDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettleAccountsDate() {
        return settleAccountsDate;
    }

    /**
     * Sets the value of the settleAccountsDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettleAccountsDate(String value) {
        this.settleAccountsDate = value;
    }

    /**
     * Gets the value of the balanceAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceAccount() {
        return balanceAccount;
    }

    /**
     * Sets the value of the balanceAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceAccount(String value) {
        this.balanceAccount = value;
    }

    /**
     * Gets the value of the preferentialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferentialType() {
        return preferentialType;
    }

    /**
     * Sets the value of the preferentialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferentialType(String value) {
        this.preferentialType = value;
    }

    /**
     * Gets the value of the freightDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreightDiscount() {
        return freightDiscount;
    }

    /**
     * Sets the value of the freightDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreightDiscount(String value) {
        this.freightDiscount = value;
    }

    /**
     * Gets the value of the generationRateDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerationRateDiscount() {
        return generationRateDiscount;
    }

    /**
     * Sets the value of the generationRateDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerationRateDiscount(String value) {
        this.generationRateDiscount = value;
    }

    /**
     * Gets the value of the chargeRateDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeRateDiscount() {
        return chargeRateDiscount;
    }

    /**
     * Sets the value of the chargeRateDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeRateDiscount(String value) {
        this.chargeRateDiscount = value;
    }

    /**
     * Gets the value of the cargoFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCargoFeeDiscount() {
        return cargoFeeDiscount;
    }

    /**
     * Sets the value of the cargoFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCargoFeeDiscount(String value) {
        this.cargoFeeDiscount = value;
    }

    /**
     * Gets the value of the deliveryFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryFeeDiscount() {
        return deliveryFeeDiscount;
    }

    /**
     * Sets the value of the deliveryFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryFeeDiscount(String value) {
        this.deliveryFeeDiscount = value;
    }

    /**
     * Gets the value of the protocolContactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolContactName() {
        return protocolContactName;
    }

    /**
     * Sets the value of the protocolContactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolContactName(String value) {
        this.protocolContactName = value;
    }

    /**
     * Gets the value of the contactPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets the value of the contactPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhone(String value) {
        this.contactPhone = value;
    }

    /**
     * Gets the value of the contactTel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * Sets the value of the contactTel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTel(String value) {
        this.contactTel = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscount(String value) {
        this.discount = value;
    }

    /**
     * Gets the value of the modifyContractType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifyContractType() {
        return modifyContractType;
    }

    /**
     * Sets the value of the modifyContractType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifyContractType(String value) {
        this.modifyContractType = value;
    }

    /**
     * Gets the value of the oldContractNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldContractNumber() {
        return oldContractNumber;
    }

    /**
     * Sets the value of the oldContractNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldContractNumber(String value) {
        this.oldContractNumber = value;
    }

    /**
     * Gets the value of the newBalanceAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewBalanceAccount() {
        return newBalanceAccount;
    }

    /**
     * Sets the value of the newBalanceAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewBalanceAccount(String value) {
        this.newBalanceAccount = value;
    }

    /**
     * Gets the value of the newFreightDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewFreightDiscount() {
        return newFreightDiscount;
    }

    /**
     * Sets the value of the newFreightDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewFreightDiscount(String value) {
        this.newFreightDiscount = value;
    }

    /**
     * Gets the value of the newPreferentialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPreferentialType() {
        return newPreferentialType;
    }

    /**
     * Sets the value of the newPreferentialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPreferentialType(String value) {
        this.newPreferentialType = value;
    }

    /**
     * Gets the value of the newGenerationRateDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewGenerationRateDiscount() {
        return newGenerationRateDiscount;
    }

    /**
     * Sets the value of the newGenerationRateDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewGenerationRateDiscount(String value) {
        this.newGenerationRateDiscount = value;
    }

    /**
     * Gets the value of the newChargeRateDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewChargeRateDiscount() {
        return newChargeRateDiscount;
    }

    /**
     * Sets the value of the newChargeRateDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewChargeRateDiscount(String value) {
        this.newChargeRateDiscount = value;
    }

    /**
     * Gets the value of the newCargoFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewCargoFeeDiscount() {
        return newCargoFeeDiscount;
    }

    /**
     * Sets the value of the newCargoFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewCargoFeeDiscount(String value) {
        this.newCargoFeeDiscount = value;
    }

    /**
     * Gets the value of the newDeliveryFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDeliveryFeeDiscount() {
        return newDeliveryFeeDiscount;
    }

    /**
     * Sets the value of the newDeliveryFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDeliveryFeeDiscount(String value) {
        this.newDeliveryFeeDiscount = value;
    }

    /**
     * Gets the value of the contrctAscriptionDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrctAscriptionDept() {
        return contrctAscriptionDept;
    }

    /**
     * Sets the value of the contrctAscriptionDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrctAscriptionDept(String value) {
        this.contrctAscriptionDept = value;
    }

    /**
     * Gets the value of the applyBondingDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyBondingDept() {
        return applyBondingDept;
    }

    /**
     * Sets the value of the applyBondingDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyBondingDept(String value) {
        this.applyBondingDept = value;
    }

    /**
     * Gets the value of the ascriptionDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAscriptionDept() {
        return ascriptionDept;
    }

    /**
     * Sets the value of the ascriptionDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAscriptionDept(String value) {
        this.ascriptionDept = value;
    }

    /**
     * Gets the value of the applyRenewalDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyRenewalDept() {
        return applyRenewalDept;
    }

    /**
     * Sets the value of the applyRenewalDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyRenewalDept(String value) {
        this.applyRenewalDept = value;
    }

    /**
     * Gets the value of the applyReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * Sets the value of the applyReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyReason(String value) {
        this.applyReason = value;
    }

    /**
     * Gets the value of the priceVersionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPriceVersionDate() {
        return priceVersionDate;
    }

    /**
     * Sets the value of the priceVersionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPriceVersionDate(XMLGregorianCalendar value) {
        this.priceVersionDate = value;
    }

    /**
     * Gets the value of the expPriceVersiondate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpPriceVersiondate() {
        return expPriceVersiondate;
    }

    /**
     * Sets the value of the expPriceVersiondate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpPriceVersiondate(XMLGregorianCalendar value) {
        this.expPriceVersiondate = value;
    }

    /**
     * Gets the value of the modifyPreferentialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifyPreferentialType() {
        return modifyPreferentialType;
    }

    /**
     * Sets the value of the modifyPreferentialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifyPreferentialType(String value) {
        this.modifyPreferentialType = value;
    }

    /**
     * Gets the value of the expressPreferentialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressPreferentialType() {
        return expressPreferentialType;
    }

    /**
     * Sets the value of the expressPreferentialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressPreferentialType(String value) {
        this.expressPreferentialType = value;
    }

    /**
     * Gets the value of the expNewPreferentialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNewPreferentialType() {
        return expNewPreferentialType;
    }

    /**
     * Sets the value of the expNewPreferentialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNewPreferentialType(String value) {
        this.expNewPreferentialType = value;
    }

    /**
     * Gets the value of the expFreightDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpFreightDiscount() {
        return expFreightDiscount;
    }

    /**
     * Sets the value of the expFreightDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpFreightDiscount(String value) {
        this.expFreightDiscount = value;
    }

    /**
     * Gets the value of the expNewFreightDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNewFreightDiscount() {
        return expNewFreightDiscount;
    }

    /**
     * Sets the value of the expNewFreightDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNewFreightDiscount(String value) {
        this.expNewFreightDiscount = value;
    }

    /**
     * Gets the value of the expWxpgenerationRateDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpWxpgenerationRateDiscount() {
        return expWxpgenerationRateDiscount;
    }

    /**
     * Sets the value of the expWxpgenerationRateDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpWxpgenerationRateDiscount(String value) {
        this.expWxpgenerationRateDiscount = value;
    }

    /**
     * Gets the value of the expNewDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNewDiscount() {
        return expNewDiscount;
    }

    /**
     * Sets the value of the expNewDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNewDiscount(String value) {
        this.expNewDiscount = value;
    }

    /**
     * Gets the value of the expChargeRateDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpChargeRateDiscount() {
        return expChargeRateDiscount;
    }

    /**
     * Sets the value of the expChargeRateDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpChargeRateDiscount(String value) {
        this.expChargeRateDiscount = value;
    }

    /**
     * Gets the value of the expNewChargeRateDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNewChargeRateDiscount() {
        return expNewChargeRateDiscount;
    }

    /**
     * Sets the value of the expNewChargeRateDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNewChargeRateDiscount(String value) {
        this.expNewChargeRateDiscount = value;
    }

    /**
     * Gets the value of the expCargoFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpCargoFeeDiscount() {
        return expCargoFeeDiscount;
    }

    /**
     * Sets the value of the expCargoFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpCargoFeeDiscount(String value) {
        this.expCargoFeeDiscount = value;
    }

    /**
     * Gets the value of the expNewCargoFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNewCargoFeeDiscount() {
        return expNewCargoFeeDiscount;
    }

    /**
     * Sets the value of the expNewCargoFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNewCargoFeeDiscount(String value) {
        this.expNewCargoFeeDiscount = value;
    }

    /**
     * Gets the value of the expDeliVeryFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpDeliVeryFeeDiscount() {
        return expDeliVeryFeeDiscount;
    }

    /**
     * Sets the value of the expDeliVeryFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpDeliVeryFeeDiscount(String value) {
        this.expDeliVeryFeeDiscount = value;
    }

    /**
     * Gets the value of the expNewDeliveryFeeDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNewDeliveryFeeDiscount() {
        return expNewDeliveryFeeDiscount;
    }

    /**
     * Sets the value of the expNewDeliveryFeeDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNewDeliveryFeeDiscount(String value) {
        this.expNewDeliveryFeeDiscount = value;
    }

    /**
     * Gets the value of the expNodesectionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpNodesectionType() {
        return expNodesectionType;
    }

    /**
     * Sets the value of the expNodesectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpNodesectionType(String value) {
        this.expNodesectionType = value;
    }

    /**
     * Gets the value of the expAmountOfConsignMent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpAmountOfConsignMent() {
        return expAmountOfConsignMent;
    }

    /**
     * Sets the value of the expAmountOfConsignMent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpAmountOfConsignMent(String value) {
        this.expAmountOfConsignMent = value;
    }

    /**
     * Gets the value of the signCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignCompany() {
        return signCompany;
    }

    /**
     * Sets the value of the signCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignCompany(String value) {
        this.signCompany = value;
    }

    /**
     * Gets the value of the invoiceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * Sets the value of the invoiceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceType(String value) {
        this.invoiceType = value;
    }

    /**
     * Gets the value of the invoiceTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceTypeName() {
        return invoiceTypeName;
    }

    /**
     * Sets the value of the invoiceTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceTypeName(String value) {
        this.invoiceTypeName = value;
    }

    /**
     * Gets the value of the newSignCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewSignCompany() {
        return newSignCompany;
    }

    /**
     * Sets the value of the newSignCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewSignCompany(String value) {
        this.newSignCompany = value;
    }

    /**
     * Gets the value of the newInvoiceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewInvoiceType() {
        return newInvoiceType;
    }

    /**
     * Sets the value of the newInvoiceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewInvoiceType(String value) {
        this.newInvoiceType = value;
    }

    /**
     * Gets the value of the newInvoiceTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewInvoiceTypeName() {
        return newInvoiceTypeName;
    }

    /**
     * Sets the value of the newInvoiceTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewInvoiceTypeName(String value) {
        this.newInvoiceTypeName = value;
    }
}
