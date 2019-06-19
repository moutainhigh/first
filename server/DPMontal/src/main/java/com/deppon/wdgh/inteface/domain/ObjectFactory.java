
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.wdgh.inteface.domain package. 
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

    private final static QName _QueryWorkflowInfoResponse_QNAME = new QName("http://www.deppon.com/wdgh/inteface/domain/", "queryWorkflowInfoResponse");
    private final static QName _WorkflowApproveResponse_QNAME = new QName("http://www.deppon.com/wdgh/inteface/domain/", "workflowApproveResponse");
    private final static QName _WorkflowApproveRequest_QNAME = new QName("http://www.deppon.com/wdgh/inteface/domain/", "workflowApproveRequest");
    private final static QName _QueryWorkflowInfoRequest_QNAME = new QName("http://www.deppon.com/wdgh/inteface/domain/", "queryWorkflowInfoRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.wdgh.inteface.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WorkflowApproveResponse }
     * 
     */
    public WorkflowApproveResponse createWorkflowApproveResponse() {
        return new WorkflowApproveResponse();
    }

    /**
     * Create an instance of {@link WorkflowApproveRequest }
     * 
     */
    public WorkflowApproveRequest createWorkflowApproveRequest() {
        return new WorkflowApproveRequest();
    }

    /**
     * Create an instance of {@link QueryWorkflowInfoRequest }
     * 
     */
    public QueryWorkflowInfoRequest createQueryWorkflowInfoRequest() {
        return new QueryWorkflowInfoRequest();
    }

    /**
     * Create an instance of {@link QueryWorkflowInfoResponse }
     * 
     */
    public QueryWorkflowInfoResponse createQueryWorkflowInfoResponse() {
        return new QueryWorkflowInfoResponse();
    }

    /**
     * Create an instance of {@link ModifyDeptDetail }
     * 
     */
    public ModifyDeptDetail createModifyDeptDetail() {
        return new ModifyDeptDetail();
    }

    /**
     * Create an instance of {@link UploadInfo }
     * 
     */
    public UploadInfo createUploadInfo() {
        return new UploadInfo();
    }

    /**
     * Create an instance of {@link Modifyscope }
     * 
     */
    public Modifyscope createModifyscope() {
        return new Modifyscope();
    }

    /**
     * Create an instance of {@link NewPointDept }
     * 
     */
    public NewPointDept createNewPointDept() {
        return new NewPointDept();
    }

    /**
     * Create an instance of {@link DeptInfoModify }
     * 
     */
    public DeptInfoModify createDeptInfoModify() {
        return new DeptInfoModify();
    }

    /**
     * Create an instance of {@link ModifyscopeDetail }
     * 
     */
    public ModifyscopeDetail createModifyscopeDetail() {
        return new ModifyscopeDetail();
    }

    /**
     * Create an instance of {@link DeptRevoke }
     * 
     */
    public DeptRevoke createDeptRevoke() {
        return new DeptRevoke();
    }

    /**
     * Create an instance of {@link NewPointInfo }
     * 
     */
    public NewPointInfo createNewPointInfo() {
        return new NewPointInfo();
    }

    /**
     * Create an instance of {@link ApproveInfo }
     * 
     */
    public ApproveInfo createApproveInfo() {
        return new ApproveInfo();
    }

    /**
     * Create an instance of {@link DeptRent }
     * 
     */
    public DeptRent createDeptRent() {
        return new DeptRent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/wdgh/inteface/domain/", name = "queryWorkflowInfoResponse")
    public JAXBElement<QueryWorkflowInfoResponse> createQueryWorkflowInfoResponse(QueryWorkflowInfoResponse value) {
        return new JAXBElement<QueryWorkflowInfoResponse>(_QueryWorkflowInfoResponse_QNAME, QueryWorkflowInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowApproveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/wdgh/inteface/domain/", name = "workflowApproveResponse")
    public JAXBElement<WorkflowApproveResponse> createWorkflowApproveResponse(WorkflowApproveResponse value) {
        return new JAXBElement<WorkflowApproveResponse>(_WorkflowApproveResponse_QNAME, WorkflowApproveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowApproveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/wdgh/inteface/domain/", name = "workflowApproveRequest")
    public JAXBElement<WorkflowApproveRequest> createWorkflowApproveRequest(WorkflowApproveRequest value) {
        return new JAXBElement<WorkflowApproveRequest>(_WorkflowApproveRequest_QNAME, WorkflowApproveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/wdgh/inteface/domain/", name = "queryWorkflowInfoRequest")
    public JAXBElement<QueryWorkflowInfoRequest> createQueryWorkflowInfoRequest(QueryWorkflowInfoRequest value) {
        return new JAXBElement<QueryWorkflowInfoRequest>(_QueryWorkflowInfoRequest_QNAME, QueryWorkflowInfoRequest.class, null, value);
    }

}
