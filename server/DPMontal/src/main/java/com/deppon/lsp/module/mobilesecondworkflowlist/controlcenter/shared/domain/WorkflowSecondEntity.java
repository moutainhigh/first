
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.ApprovalInfo;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.DailysuppliesVo;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.PlanDesignApplyVo;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.ProjectSourceVo;


/**
 * <p>Java class for workflowSecondEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workflowSecondEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="approvalInfoList" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}approvalInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attachList" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain}attachEntity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dailysuppliesVo" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}dailysuppliesVo" minOccurs="0"/>
 *         &lt;element name="planDesignApplyVo" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}planDesignApplyVo" minOccurs="0"/>
 *         &lt;element name="projectSourceVo" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}projectSourceVo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflowSecondEntity", propOrder = {
    "approvalInfoList",
    "attachList",
    "dailysuppliesVo",
    "planDesignApplyVo",
    "projectSourceVo"
})
public class WorkflowSecondEntity {

    @XmlElement(nillable = true)
    protected List<ApprovalInfo> approvalInfoList;
    @XmlElement(nillable = true)
    protected List<AttachEntity> attachList;
    protected DailysuppliesVo dailysuppliesVo;
    protected PlanDesignApplyVo planDesignApplyVo;
    protected ProjectSourceVo projectSourceVo;

    /**
     * Gets the value of the approvalInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalInfo }
     * 
     * 
     */
    public List<ApprovalInfo> getApprovalInfoList() {
        if (approvalInfoList == null) {
            approvalInfoList = new ArrayList<ApprovalInfo>();
        }
        return this.approvalInfoList;
    }

    /**
     * Gets the value of the attachList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachEntity }
     * 
     * 
     */
    public List<AttachEntity> getAttachList() {
        if (attachList == null) {
            attachList = new ArrayList<AttachEntity>();
        }
        return this.attachList;
    }

    /**
     * Gets the value of the dailysuppliesVo property.
     * 
     * @return
     *     possible object is
     *     {@link DailysuppliesVo }
     *     
     */
    public DailysuppliesVo getDailysuppliesVo() {
        return dailysuppliesVo;
    }

    /**
     * Sets the value of the dailysuppliesVo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DailysuppliesVo }
     *     
     */
    public void setDailysuppliesVo(DailysuppliesVo value) {
        this.dailysuppliesVo = value;
    }

    /**
     * Gets the value of the planDesignApplyVo property.
     * 
     * @return
     *     possible object is
     *     {@link PlanDesignApplyVo }
     *     
     */
    public PlanDesignApplyVo getPlanDesignApplyVo() {
        return planDesignApplyVo;
    }

    /**
     * Sets the value of the planDesignApplyVo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanDesignApplyVo }
     *     
     */
    public void setPlanDesignApplyVo(PlanDesignApplyVo value) {
        this.planDesignApplyVo = value;
    }

    /**
     * Gets the value of the projectSourceVo property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectSourceVo }
     *     
     */
    public ProjectSourceVo getProjectSourceVo() {
        return projectSourceVo;
    }

    /**
     * Sets the value of the projectSourceVo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectSourceVo }
     *     
     */
    public void setProjectSourceVo(ProjectSourceVo value) {
        this.projectSourceVo = value;
    }

}
