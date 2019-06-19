//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.19 时间 09:17:43 AM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.nhr.module.remote.dpm.shared.domain.workflow package. 
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

    private final static QName _QueryWorkflowInfoResponse_QNAME = new QName("http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", "queryWorkflowInfoResponse");
    private final static QName _DealWorkFlowRequest_QNAME = new QName("http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", "dealWorkFlowRequest");
    private final static QName _QueryWorkflowInfoRequest_QNAME = new QName("http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", "queryWorkflowInfoRequest");
    private final static QName _DealWorkFlowResponse_QNAME = new QName("http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", "dealWorkFlowResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.nhr.module.remote.dpm.shared.domain.workflow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DealWorkFlowRequest }
     * 
     */
    public DealWorkFlowRequest createDealWorkFlowRequest() {
        return new DealWorkFlowRequest();
    }

    /**
     * Create an instance of {@link QueryWorkflowInfoRequest }
     * 
     */
    public QueryWorkflowInfoRequest createQueryWorkflowInfoRequest() {
        return new QueryWorkflowInfoRequest();
    }

    /**
     * Create an instance of {@link DealWorkFlowResponse }
     * 
     */
    public DealWorkFlowResponse createDealWorkFlowResponse() {
        return new DealWorkFlowResponse();
    }

    /**
     * Create an instance of {@link QueryWorkflowInfoResponse }
     * 
     */
    public QueryWorkflowInfoResponse createQueryWorkflowInfoResponse() {
        return new QueryWorkflowInfoResponse();
    }

    /**
     * Create an instance of {@link PositiveInfo }
     * 
     */
    public PositiveInfo createPositiveInfo() {
        return new PositiveInfo();
    }

    /**
     * Create an instance of {@link RecInfoList }
     * 
     */
    public RecInfoList createRecInfoList() {
        return new RecInfoList();
    }

    /**
     * Create an instance of {@link TransferInfo }
     * 
     */
    public TransferInfo createTransferInfo() {
        return new TransferInfo();
    }

    /**
     * Create an instance of {@link OriginInfo }
     * 
     */
    public OriginInfo createOriginInfo() {
        return new OriginInfo();
    }

    /**
     * Create an instance of {@link RecruiterInfo }
     * 
     */
    public RecruiterInfo createRecruiterInfo() {
        return new RecruiterInfo();
    }

    /**
     * Create an instance of {@link WorkflowInfo }
     * 
     */
    public WorkflowInfo createWorkflowInfo() {
        return new WorkflowInfo();
    }

    /**
     * Create an instance of {@link FileInfo }
     * 
     */
    public FileInfo createFileInfo() {
        return new FileInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", name = "queryWorkflowInfoResponse")
    public JAXBElement<QueryWorkflowInfoResponse> createQueryWorkflowInfoResponse(QueryWorkflowInfoResponse value) {
        return new JAXBElement<QueryWorkflowInfoResponse>(_QueryWorkflowInfoResponse_QNAME, QueryWorkflowInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DealWorkFlowRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", name = "dealWorkFlowRequest")
    public JAXBElement<DealWorkFlowRequest> createDealWorkFlowRequest(DealWorkFlowRequest value) {
        return new JAXBElement<DealWorkFlowRequest>(_DealWorkFlowRequest_QNAME, DealWorkFlowRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", name = "queryWorkflowInfoRequest")
    public JAXBElement<QueryWorkflowInfoRequest> createQueryWorkflowInfoRequest(QueryWorkflowInfoRequest value) {
        return new JAXBElement<QueryWorkflowInfoRequest>(_QueryWorkflowInfoRequest_QNAME, QueryWorkflowInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DealWorkFlowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", name = "dealWorkFlowResponse")
    public JAXBElement<DealWorkFlowResponse> createDealWorkFlowResponse(DealWorkFlowResponse value) {
        return new JAXBElement<DealWorkFlowResponse>(_DealWorkFlowResponse_QNAME, DealWorkFlowResponse.class, null, value);
    }

}
