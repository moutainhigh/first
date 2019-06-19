
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ����������Ϣ
 * 
 * <p>WfInfoEntity complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="WfInfoEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applydept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applydate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WfInfoEntity", propOrder = {
    "workflowid",
    "applyname",
    "applydept",
    "applydate"
})
public class WfInfoEntity {

    @XmlElement(required = true)
    protected String workflowid;
    @XmlElement(required = true)
    protected String applyname;
    @XmlElement(required = true)
    protected String applydept;
    @XmlElement(required = true)
    protected String applydate;

    /**
     * ��ȡworkflowid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowid() {
        return workflowid;
    }

    /**
     * ����workflowid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowid(String value) {
        this.workflowid = value;
    }

    /**
     * ��ȡapplyname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyname() {
        return applyname;
    }

    /**
     * ����applyname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyname(String value) {
        this.applyname = value;
    }

    /**
     * ��ȡapplydept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplydept() {
        return applydept;
    }

    /**
     * ����applydept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplydept(String value) {
        this.applydept = value;
    }

    /**
     * ��ȡapplydate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplydate() {
        return applydate;
    }

    /**
     * ����applydate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplydate(String value) {
        this.applydate = value;
    }

}
