
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �����˼����β���
 * 
 * <p>Duty complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Duty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responsibledept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="indeptmoney" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responsibleperson" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deductionamount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Duty", propOrder = {
    "responsibledept",
    "indeptmoney",
    "responsibleperson",
    "deductionamount"
})
public class Duty {

    @XmlElement(required = true)
    protected String responsibledept;
    @XmlElement(required = true)
    protected String indeptmoney;
    @XmlElement(required = true)
    protected String responsibleperson;
    @XmlElement(required = true)
    protected String deductionamount;

    /**
     * ��ȡresponsibledept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibledept() {
        return responsibledept;
    }

    /**
     * ����responsibledept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibledept(String value) {
        this.responsibledept = value;
    }

    /**
     * ��ȡindeptmoney���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndeptmoney() {
        return indeptmoney;
    }

    /**
     * ����indeptmoney���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndeptmoney(String value) {
        this.indeptmoney = value;
    }

    /**
     * ��ȡresponsibleperson���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleperson() {
        return responsibleperson;
    }

    /**
     * ����responsibleperson���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleperson(String value) {
        this.responsibleperson = value;
    }

    /**
     * ��ȡdeductionamount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeductionamount() {
        return deductionamount;
    }

    /**
     * ����deductionamount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeductionamount(String value) {
        this.deductionamount = value;
    }

}
