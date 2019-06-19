

package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.deppon.montal.util.FormatUtil;


/**
 * <p>Java class for receiptData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="receiptData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="applyTotalAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrivalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrivalApartmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrivalApartmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="associationPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="budgetAssumeApartment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="budgetAssumeApartmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="changeRepair" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="childCompanyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childCompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="departmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fauditorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcompanyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fisl" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="inventoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inventoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="materialAtt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planOutPurchase" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="receiptId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receiptNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receiptStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfisexpress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receiptData", propOrder = {
    "applyTime",
    "applyTotalAccount",
    "arrivalAddress",
    "arrivalApartmentId",
    "arrivalApartmentName",
    "associationPhone",
    "budgetAssumeApartment",
    "budgetAssumeApartmentId",
    "changeRepair",
    "childCompanyId",
    "childCompanyName",
    "currentTime",
    "departmentId",
    "departmentName",
    "fauditorId",
    "fcompanyId",
    "fisl",
    "inventoryId",
    "inventoryName",
    "mark",
    "materialAtt",
    "personId",
    "personName",
    "planOutPurchase",
    "receiptId",
    "receiptNumber",
    "receiptStatus",
    "cfisexpress",
    "isB2B",
    "istype",
    "address",
    "addressId",
    "cfdetailaddress",
    "cfarrivaldepartment",
    "cfarrivaldepartmentid"
})
public class ReceiptData {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applyTime;
    protected String applyTotalAccount;
    protected String arrivalAddress;
    protected String arrivalApartmentId;
    protected String arrivalApartmentName;
    protected String associationPhone;
    protected String budgetAssumeApartment;
    protected String budgetAssumeApartmentId;
    protected Long changeRepair;
    protected String childCompanyId;
    protected String childCompanyName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar currentTime;
    protected String departmentId;
    protected String departmentName;
    protected String fauditorId;
    protected String fcompanyId;
    protected Long fisl;
    protected String inventoryId;
    protected String inventoryName;
    protected String mark;
    protected String materialAtt;
    protected String personId;
    protected String personName;
    protected Long planOutPurchase;
    protected String receiptId;
    protected String receiptNumber;
    protected String receiptStatus;
    protected String cfisexpress;
    //是否电商类采购     6.18
  	private String isB2B;
  	//非库存非固定资产日常采购（统购）；
  	//非库存非固定资产日常采购（分购）；
  	//非库存固定资产日常采购（统购）；
  	//非库存固定资产日常采购（分购）；
  	//这四类采购需要显示是否电商类；
  	private String istype;
  	
  	///10.12
    private String cfdetailaddress;         //详细地址
    private String cfarrivaldepartment; 
    private String cfarrivaldepartmentid; 
    private String address;  //到货地址
	private String addressId;

    public String getIsB2B() {
		return isB2B;
	}

	public void setIsB2B(String isB2B) {
		this.isB2B = isB2B;
	}

	public String getIstype() {
		return istype;
	}

	public void setIstype(String istype) {
		this.istype = istype;
	}

	/**
	 * @return the cfdetailaddress
	 */
	public String getCfdetailaddress() {
		return cfdetailaddress;
	}

	/**
	 * @param cfdetailaddress
	 */
	public void setCfdetailaddress(String cfdetailaddress) {
		this.cfdetailaddress = cfdetailaddress;
	}

	/**
	 * @return the cfarrivaldepartment
	 */
	public String getCfarrivaldepartment() {
		return cfarrivaldepartment;
	}

	/**
	 * @param cfarrivaldepartment
	 */
	public void setCfarrivaldepartment(String cfarrivaldepartment) {
		this.cfarrivaldepartment = cfarrivaldepartment;
	}

	/**
	 * @return the cfarrivaldepartmentid
	 */
	public String getCfarrivaldepartmentid() {
		return cfarrivaldepartmentid;
	}

	/**
	 * @param cfarrivaldepartmentid
	 */
	public void setCfarrivaldepartmentid(String cfarrivaldepartmentid) {
		this.cfarrivaldepartmentid = cfarrivaldepartmentid;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	/**
     * Gets the value of the applyTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplyTime() {
        return applyTime;
    }

    public String getApplyTimeStr() {
        return FormatUtil.formatDate(applyTime, "yyyy-MM-dd");
    }
    /**
     * Sets the value of the applyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplyTime(XMLGregorianCalendar value) {
        this.applyTime = value;
    }

    /**
     * Gets the value of the applyTotalAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyTotalAccount() {
    	if (applyTotalAccount == null) {
    		applyTotalAccount = "";
    	}
    	return applyTotalAccount;
    }

    public String getApplyTotalAccountStr() {
    	if (applyTotalAccount == null) {
    		return  "";
    	}else {
    		BigDecimal b = new BigDecimal(applyTotalAccount);
    		return FormatUtil.formatMoney(b);
    	}
    }
    /**
     * Sets the value of the applyTotalAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyTotalAccount(String value) {
        this.applyTotalAccount = value;
    }

    /**
     * Gets the value of the arrivalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalAddress() {
    	if (arrivalAddress == null) {
    		arrivalAddress = "";
    	}
    	return arrivalAddress;
    }

    /**
     * Sets the value of the arrivalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalAddress(String value) {
        this.arrivalAddress = value;
    }

    /**
     * Gets the value of the arrivalApartmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalApartmentId() {
        return arrivalApartmentId;
    }

    /**
     * Sets the value of the arrivalApartmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalApartmentId(String value) {
        this.arrivalApartmentId = value;
    }

    /**
     * Gets the value of the arrivalApartmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalApartmentName() {
    	if (arrivalApartmentName == null) {
    		arrivalApartmentName = "";
    	}
    	return arrivalApartmentName;
    }

    /**
     * Sets the value of the arrivalApartmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalApartmentName(String value) {
        this.arrivalApartmentName = value;
    }

    /**
     * Gets the value of the associationPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssociationPhone() {
    	if (associationPhone == null) {
    		associationPhone = "";
    	}
    	return associationPhone;
    }

    /**
     * Sets the value of the associationPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssociationPhone(String value) {
        this.associationPhone = value;
    }

    /**
     * Gets the value of the budgetAssumeApartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetAssumeApartment() {
    	if (budgetAssumeApartment == null) {
    		budgetAssumeApartment = "";
    	}
    	return budgetAssumeApartment;
    }

    /**
     * Sets the value of the budgetAssumeApartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetAssumeApartment(String value) {
        this.budgetAssumeApartment = value;
    }

    /**
     * Gets the value of the budgetAssumeApartmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBudgetAssumeApartmentId() {
        return budgetAssumeApartmentId;
    }

    /**
     * Sets the value of the budgetAssumeApartmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBudgetAssumeApartmentId(String value) {
        this.budgetAssumeApartmentId = value;
    }

    /**
     * Gets the value of the changeRepair property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChangeRepair() {
        return changeRepair;
    }
    public String getChangeRepairStr() {
    	if (changeRepair != null && changeRepair == 1) {
    		return "是";
    	}else {
    		return "否";
    	}
    }
    /**
     * Sets the value of the changeRepair property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChangeRepair(Long value) {
        this.changeRepair = value;
    }

    /**
     * Gets the value of the childCompanyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildCompanyId() {
        return childCompanyId;
    }

    /**
     * Sets the value of the childCompanyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildCompanyId(String value) {
        this.childCompanyId = value;
    }

    /**
     * Gets the value of the childCompanyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildCompanyName() {
    	if (childCompanyName == null) {
    		childCompanyName = "";
    	}
    	return childCompanyName;
    }

    /**
     * Sets the value of the childCompanyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildCompanyName(String value) {
        this.childCompanyName = value;
    }

    /**
     * Gets the value of the currentTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets the value of the currentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCurrentTime(XMLGregorianCalendar value) {
        this.currentTime = value;
    }

    /**
     * Gets the value of the departmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the value of the departmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartmentId(String value) {
        this.departmentId = value;
    }

    /**
     * Gets the value of the departmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the value of the departmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartmentName(String value) {
        this.departmentName = value;
    }

    /**
     * Gets the value of the fauditorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFauditorId() {
        return fauditorId;
    }

    /**
     * Sets the value of the fauditorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFauditorId(String value) {
        this.fauditorId = value;
    }

    /**
     * Gets the value of the fcompanyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcompanyId() {
        return fcompanyId;
    }

    /**
     * Sets the value of the fcompanyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcompanyId(String value) {
        this.fcompanyId = value;
    }

    /**
     * Gets the value of the fisl property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFisl() {
        return fisl;
    }
    public String getFislStr() {
    	if (fisl != null && fisl == 1) {
    		return "是";
    	}else {
    		return "否";
    	}
    }
    /**
     * Sets the value of the fisl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFisl(Long value) {
        this.fisl = value;
    }

    /**
     * Gets the value of the inventoryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInventoryId() {
        return inventoryId;
    }

    /**
     * Sets the value of the inventoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventoryId(String value) {
        this.inventoryId = value;
    }

    /**
     * Gets the value of the inventoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInventoryName() {
    	if (inventoryName == null) inventoryName = "";
    	return inventoryName;
    }

    /**
     * Sets the value of the inventoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventoryName(String value) {
        this.inventoryName = value;
    }

    /**
     * Gets the value of the mark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMark() {
    	if (mark == null) {
    		mark = "";
    	}
    	return mark;
    }

    /**
     * Sets the value of the mark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMark(String value) {
        this.mark = value;
    }

    /**
     * Gets the value of the materialAtt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialAtt() {
        return materialAtt;
    }

    /**
     * Sets the value of the materialAtt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialAtt(String value) {
        this.materialAtt = value;
    }

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonId(String value) {
        this.personId = value;
    }

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonName(String value) {
        this.personName = value;
    }

    /**
     * Gets the value of the planOutPurchase property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPlanOutPurchase() {
        return planOutPurchase;
    }

    public String getPlanOutPurchaseStr() {
    	if (planOutPurchase != null && planOutPurchase == 1) {
    		return "是";
    	}else {
    		return "否";
    	}
    }
    /**
     * Sets the value of the planOutPurchase property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPlanOutPurchase(Long value) {
        this.planOutPurchase = value;
    }

    /**
     * Gets the value of the receiptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptId() {
        return receiptId;
    }

    /**
     * Sets the value of the receiptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptId(String value) {
        this.receiptId = value;
    }

    /**
     * Gets the value of the receiptNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNumber() {
    	if (receiptNumber == null) {
    		receiptNumber = "";
    	}
    	return receiptNumber;
    }

    /**
     * Sets the value of the receiptNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNumber(String value) {
        this.receiptNumber = value;
    }

    /**
     * Gets the value of the receiptStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptStatus() {
        return receiptStatus;
    }

    /**
     * Sets the value of the receiptStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptStatus(String value) {
        this.receiptStatus = value;
    }

    /**
     * Gets the value of the cfisexpress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfisexpress() {
    	if (cfisexpress == null) {
    		cfisexpress = "";
		}else if("0".equals(cfisexpress))
		{
			return "否";
		}else {
			return "是";
		}
        return cfisexpress;
    }

    /**
     * Sets the value of the cfisexpress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfisexpress(String value) {
        this.cfisexpress = value;
    }

}
