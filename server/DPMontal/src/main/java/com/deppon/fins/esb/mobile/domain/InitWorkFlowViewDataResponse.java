
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>InitWorkFlowViewDataResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="InitWorkFlowViewDataResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mobileFinsWfEntity" type="{http://www.deppon.com/fins/esb/mobile/domain/}MobileFinsWfEntity"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InitWorkFlowViewDataResponse", propOrder = {
    "mobileFinsWfEntity"
})
public class InitWorkFlowViewDataResponse {

    @XmlElement(required = true)
    protected MobileFinsWfEntity mobileFinsWfEntity;

    /**
     * ��ȡmobileFinsWfEntity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MobileFinsWfEntity }
     *     
     */
    public MobileFinsWfEntity getMobileFinsWfEntity() {
        return mobileFinsWfEntity;
    }

    /**
     * ����mobileFinsWfEntity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MobileFinsWfEntity }
     *     
     */
    public void setMobileFinsWfEntity(MobileFinsWfEntity value) {
        this.mobileFinsWfEntity = value;
    }

}
