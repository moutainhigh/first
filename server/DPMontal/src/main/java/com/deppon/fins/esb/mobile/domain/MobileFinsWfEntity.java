
package com.deppon.fins.esb.mobile.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MobileFinsWfEntity complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MobileFinsWfEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wfInfoEntity" type="{http://www.deppon.com/fins/esb/mobile/domain/}WfInfoEntity"/>
 *         &lt;element name="baddebtMobileWfEntity" type="{http://www.deppon.com/fins/esb/mobile/domain/}BaddebtMobileWfEntity"/>
 *         &lt;element name="unBaddebtMobileWfEntity" type="{http://www.deppon.com/fins/esb/mobile/domain/}UnBaddebtMobileWfEntity"/>
 *         &lt;element name="approveInfoList" type="{http://www.deppon.com/fins/esb/mobile/domain/}ApproveInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fjList" type="{http://www.deppon.com/fins/esb/mobile/domain/}Fj" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MobileFinsWfEntity", propOrder = {
    "wfInfoEntity",
    "baddebtMobileWfEntity",
    "unBaddebtMobileWfEntity",
    "approveInfoList",
    "fjList"
})
public class MobileFinsWfEntity {

    @XmlElement(required = true)
    protected WfInfoEntity wfInfoEntity;
    @XmlElement(required = true)
    protected BaddebtMobileWfEntity baddebtMobileWfEntity;
    @XmlElement(required = true)
    protected UnBaddebtMobileWfEntity unBaddebtMobileWfEntity;
    protected List<ApproveInfo> approveInfoList;
    protected List<Fj> fjList;

    /**
     * ��ȡwfInfoEntity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link WfInfoEntity }
     *     
     */
    public WfInfoEntity getWfInfoEntity() {
        return wfInfoEntity;
    }

    /**
     * ����wfInfoEntity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link WfInfoEntity }
     *     
     */
    public void setWfInfoEntity(WfInfoEntity value) {
        this.wfInfoEntity = value;
    }

    /**
     * ��ȡbaddebtMobileWfEntity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BaddebtMobileWfEntity }
     *     
     */
    public BaddebtMobileWfEntity getBaddebtMobileWfEntity() {
        return baddebtMobileWfEntity;
    }

    /**
     * ����baddebtMobileWfEntity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BaddebtMobileWfEntity }
     *     
     */
    public void setBaddebtMobileWfEntity(BaddebtMobileWfEntity value) {
        this.baddebtMobileWfEntity = value;
    }

    /**
     * ��ȡunBaddebtMobileWfEntity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UnBaddebtMobileWfEntity }
     *     
     */
    public UnBaddebtMobileWfEntity getUnBaddebtMobileWfEntity() {
        return unBaddebtMobileWfEntity;
    }

    /**
     * ����unBaddebtMobileWfEntity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UnBaddebtMobileWfEntity }
     *     
     */
    public void setUnBaddebtMobileWfEntity(UnBaddebtMobileWfEntity value) {
        this.unBaddebtMobileWfEntity = value;
    }

    /**
     * Gets the value of the approveInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approveInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApproveInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApproveInfo }
     * 
     * 
     */
    public List<ApproveInfo> getApproveInfoList() {
        if (approveInfoList == null) {
            approveInfoList = new ArrayList<ApproveInfo>();
        }
        return this.approveInfoList;
    }

    /**
     * Gets the value of the fjList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fjList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFjList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fj }
     * 
     * 
     */
    public List<Fj> getFjList() {
        if (fjList == null) {
            fjList = new ArrayList<Fj>();
        }
        return this.fjList;
    }

}
