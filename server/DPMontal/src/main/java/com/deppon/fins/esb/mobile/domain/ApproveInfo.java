
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * �����¼
 * 
 * <p>ApproveInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ApproveInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="approvedate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="approverPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isagree" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approveOpinion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApproveInfo", propOrder = {
    "approvedate",
    "approverPosition",
    "approver",
    "isagree",
    "approveOpinion"
})
public class ApproveInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar approvedate;
    @XmlElement(required = true)
    protected String approverPosition;
    @XmlElement(required = true)
    protected String approver;
    @XmlElement(required = true)
    protected String isagree;
    @XmlElement(required = true)
    protected String approveOpinion;

    /**
     * ��ȡapprovedate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApprovedate() {
        return approvedate;
    }

    /**
     * ����approvedate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApprovedate(XMLGregorianCalendar value) {
        this.approvedate = value;
    }

    /**
     * ��ȡapproverPosition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverPosition() {
        return approverPosition;
    }

    /**
     * ����approverPosition���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverPosition(String value) {
        this.approverPosition = value;
    }

    /**
     * ��ȡapprover���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprover() {
        return approver;
    }

    /**
     * ����approver���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprover(String value) {
        this.approver = value;
    }

    /**
     * ��ȡisagree���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsagree() {
        return isagree;
    }

    /**
     * ����isagree���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsagree(String value) {
        this.isagree = value;
    }

    /**
     * ��ȡapproveOpinion���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * ����approveOpinion���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOpinion(String value) {
        this.approveOpinion = value;
    }

}
