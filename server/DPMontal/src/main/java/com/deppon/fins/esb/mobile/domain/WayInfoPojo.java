
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �˵���Ϣ
 * 
 * <p>WayInfoPojo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="WayInfoPojo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="businessnumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="noverification" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WayInfoPojo", propOrder = {
    "businessnumber",
    "noverification",
    "businessdate"
})
public class WayInfoPojo {

    @XmlElement(required = true)
    protected String businessnumber;
    @XmlElement(required = true)
    protected String noverification;
    @XmlElement(required = true)
    protected String businessdate;

    /**
     * ��ȡbusinessnumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessnumber() {
        return businessnumber;
    }

    /**
     * ����businessnumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessnumber(String value) {
        this.businessnumber = value;
    }

    /**
     * ��ȡnoverification���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoverification() {
        return noverification;
    }

    /**
     * ����noverification���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoverification(String value) {
        this.noverification = value;
    }

    /**
     * ��ȡbusinessdate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessdate() {
        return businessdate;
    }

    /**
     * ����businessdate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessdate(String value) {
        this.businessdate = value;
    }

}
