
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuditOperationInLsp_QNAME = new QName("http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", "auditOperationInLsp");
    private final static QName _WorkflowBusinessData_QNAME = new QName("http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", "WorkflowBusinessData");
    private final static QName _WorkflowBusinessDataResponse_QNAME = new QName("http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", "WorkflowBusinessDataResponse");
    private final static QName _AuditOperationInLspResponse_QNAME = new QName("http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", "auditOperationInLspResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Auditparameters }
     * 
     */
    public Auditparameters createAuditparameters() {
        return new Auditparameters();
    }

    /**
     * Create an instance of {@link WorkflowBusinessData }
     * 
     */
    public WorkflowBusinessData createWorkflowBusinessData() {
        return new WorkflowBusinessData();
    }

    /**
     * Create an instance of {@link WorkflowSecondEntity }
     * 
     */
    public WorkflowSecondEntity createWorkflowSecondEntity() {
        return new WorkflowSecondEntity();
    }

    /**
     * Create an instance of {@link ApprovalInfo }
     * 
     */
    public ApprovalInfo createApprovalInfo() {
        return new ApprovalInfo();
    }

    /**
     * Create an instance of {@link AttachEntity }
     * 
     */
    public AttachEntity createAttachEntity() {
        return new AttachEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Auditparameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", name = "auditOperationInLsp")
    public JAXBElement<Auditparameters> createAuditOperationInLsp(Auditparameters value) {
        return new JAXBElement<Auditparameters>(_AuditOperationInLsp_QNAME, Auditparameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowBusinessData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", name = "WorkflowBusinessData")
    public JAXBElement<WorkflowBusinessData> createWorkflowBusinessData(WorkflowBusinessData value) {
        return new JAXBElement<WorkflowBusinessData>(_WorkflowBusinessData_QNAME, WorkflowBusinessData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowSecondEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", name = "WorkflowBusinessDataResponse")
    public JAXBElement<WorkflowSecondEntity> createWorkflowBusinessDataResponse(WorkflowSecondEntity value) {
        return new JAXBElement<WorkflowSecondEntity>(_WorkflowBusinessDataResponse_QNAME, WorkflowSecondEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/shared/domain", name = "auditOperationInLspResponse")
    public JAXBElement<Integer> createAuditOperationInLspResponse(Integer value) {
        return new JAXBElement<Integer>(_AuditOperationInLspResponse_QNAME, Integer.class, null, value);
    }

}
