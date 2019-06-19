
package com.deppon.montal.module.crm.damin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.crm.inteface.dpm.domain package. 
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

    private final static QName _QueryWorkflowInfoResponse_QNAME = new QName("http://www.deppon.com/crm/inteface/dpm/domain/", "queryWorkflowInfoResponse");
    private final static QName _WorkflowApproveResponse_QNAME = new QName("http://www.deppon.com/crm/inteface/dpm/domain/", "workflowApproveResponse");
    private final static QName _WorkflowApproveRequest_QNAME = new QName("http://www.deppon.com/crm/inteface/dpm/domain/", "workflowApproveRequest");
    private final static QName _QueryWorkflowInfoRequest_QNAME = new QName("http://www.deppon.com/crm/inteface/dpm/domain/", "queryWorkflowInfoRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.crm.inteface.dpm.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryWorkflowInfoRequest }
     * 
     */
    public QueryWorkflowInfoRequest createQueryWorkflowInfoRequest() {
        return new QueryWorkflowInfoRequest();
    }

    /**
     * Create an instance of {@link OverpayInfo }
     * 
     */
    public OverpayInfo createOverpayInfo() {
        return new OverpayInfo();
    }

    /**
     * Create an instance of {@link WorkflowApproveRequest }
     * 
     */
    public WorkflowApproveRequest createWorkflowApproveRequest() {
        return new WorkflowApproveRequest();
    }

    /**
     * Create an instance of {@link RecompenseInfo }
     * 
     */
    public RecompenseInfo createRecompenseInfo() {
        return new RecompenseInfo();
    }

    /**
     * Create an instance of {@link QueryWorkflowInfoResponse }
     * 
     */
    public QueryWorkflowInfoResponse createQueryWorkflowInfoResponse() {
        return new QueryWorkflowInfoResponse();
    }

    /**
     * Create an instance of {@link AwardItem }
     * 
     */
    public AwardItem createAwardItem() {
        return new AwardItem();
    }

    /**
     * Create an instance of {@link FileInfo }
     * 
     */
    public FileInfo createFileInfo() {
        return new FileInfo();
    }

    /**
     * Create an instance of {@link WorkflowApproveResponse }
     * 
     */
    public WorkflowApproveResponse createWorkflowApproveResponse() {
        return new WorkflowApproveResponse();
    }

    /**
     * Create an instance of {@link DeptCharge }
     * 
     */
    public DeptCharge createDeptCharge() {
        return new DeptCharge();
    }

    /**
     * Create an instance of {@link ApprovalInfo }
     * 
     */
    public ApprovalInfo createApprovalInfo() {
        return new ApprovalInfo();
    }

    /**
     * Create an instance of {@link ContractInfo }
     * 
     */
    public ContractInfo createContractInfo() {
        return new ContractInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/crm/inteface/dpm/domain/", name = "queryWorkflowInfoResponse")
    public JAXBElement<QueryWorkflowInfoResponse> createQueryWorkflowInfoResponse(QueryWorkflowInfoResponse value) {
        return new JAXBElement<QueryWorkflowInfoResponse>(_QueryWorkflowInfoResponse_QNAME, QueryWorkflowInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowApproveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/crm/inteface/dpm/domain/", name = "workflowApproveResponse")
    public JAXBElement<WorkflowApproveResponse> createWorkflowApproveResponse(WorkflowApproveResponse value) {
        return new JAXBElement<WorkflowApproveResponse>(_WorkflowApproveResponse_QNAME, WorkflowApproveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowApproveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/crm/inteface/dpm/domain/", name = "workflowApproveRequest")
    public JAXBElement<WorkflowApproveRequest> createWorkflowApproveRequest(WorkflowApproveRequest value) {
        return new JAXBElement<WorkflowApproveRequest>(_WorkflowApproveRequest_QNAME, WorkflowApproveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/crm/inteface/dpm/domain/", name = "queryWorkflowInfoRequest")
    public JAXBElement<QueryWorkflowInfoRequest> createQueryWorkflowInfoRequest(QueryWorkflowInfoRequest value) {
        return new JAXBElement<QueryWorkflowInfoRequest>(_QueryWorkflowInfoRequest_QNAME, QueryWorkflowInfoRequest.class, null, value);
    }

}
