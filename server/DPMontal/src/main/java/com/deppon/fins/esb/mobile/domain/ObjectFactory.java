
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.fins.esb.mobile.domain package. 
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

    private final static QName _InitWorkFlowViewDataResponse_QNAME = new QName("http://www.deppon.com/fins/esb/mobile/domain/", "initWorkFlowViewDataResponse");
    private final static QName _ApproveResponse_QNAME = new QName("http://www.deppon.com/fins/esb/mobile/domain/", "approveResponse");
    private final static QName _InitWorkFlowViewDataRequest_QNAME = new QName("http://www.deppon.com/fins/esb/mobile/domain/", "initWorkFlowViewDataRequest");
    private final static QName _ApproveRequest_QNAME = new QName("http://www.deppon.com/fins/esb/mobile/domain/", "approveRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.fins.esb.mobile.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ApproveResponse }
     * 
     */
    public ApproveResponse createApproveResponse() {
        return new ApproveResponse();
    }

    /**
     * Create an instance of {@link InitWorkFlowViewDataResponse }
     * 
     */
    public InitWorkFlowViewDataResponse createInitWorkFlowViewDataResponse() {
        return new InitWorkFlowViewDataResponse();
    }

    /**
     * Create an instance of {@link InitWorkFlowViewDataRequest }
     * 
     */
    public InitWorkFlowViewDataRequest createInitWorkFlowViewDataRequest() {
        return new InitWorkFlowViewDataRequest();
    }

    /**
     * Create an instance of {@link ApproveRequest }
     * 
     */
    public ApproveRequest createApproveRequest() {
        return new ApproveRequest();
    }

    /**
     * Create an instance of {@link UnBaddebtMobileWfEntity }
     * 
     */
    public UnBaddebtMobileWfEntity createUnBaddebtMobileWfEntity() {
        return new UnBaddebtMobileWfEntity();
    }

    /**
     * Create an instance of {@link WfInfoEntity }
     * 
     */
    public WfInfoEntity createWfInfoEntity() {
        return new WfInfoEntity();
    }

    /**
     * Create an instance of {@link Duty }
     * 
     */
    public Duty createDuty() {
        return new Duty();
    }

    /**
     * Create an instance of {@link WayInfoPojo }
     * 
     */
    public WayInfoPojo createWayInfoPojo() {
        return new WayInfoPojo();
    }

    /**
     * Create an instance of {@link MobileFinsWfEntity }
     * 
     */
    public MobileFinsWfEntity createMobileFinsWfEntity() {
        return new MobileFinsWfEntity();
    }

    /**
     * Create an instance of {@link BaddebtMobileWfEntity }
     * 
     */
    public BaddebtMobileWfEntity createBaddebtMobileWfEntity() {
        return new BaddebtMobileWfEntity();
    }

    /**
     * Create an instance of {@link Fj }
     * 
     */
    public Fj createFj() {
        return new Fj();
    }

    /**
     * Create an instance of {@link ApproveInfo }
     * 
     */
    public ApproveInfo createApproveInfo() {
        return new ApproveInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitWorkFlowViewDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/fins/esb/mobile/domain/", name = "initWorkFlowViewDataResponse")
    public JAXBElement<InitWorkFlowViewDataResponse> createInitWorkFlowViewDataResponse(InitWorkFlowViewDataResponse value) {
        return new JAXBElement<InitWorkFlowViewDataResponse>(_InitWorkFlowViewDataResponse_QNAME, InitWorkFlowViewDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApproveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/fins/esb/mobile/domain/", name = "approveResponse")
    public JAXBElement<ApproveResponse> createApproveResponse(ApproveResponse value) {
        return new JAXBElement<ApproveResponse>(_ApproveResponse_QNAME, ApproveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitWorkFlowViewDataRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/fins/esb/mobile/domain/", name = "initWorkFlowViewDataRequest")
    public JAXBElement<InitWorkFlowViewDataRequest> createInitWorkFlowViewDataRequest(InitWorkFlowViewDataRequest value) {
        return new JAXBElement<InitWorkFlowViewDataRequest>(_InitWorkFlowViewDataRequest_QNAME, InitWorkFlowViewDataRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApproveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/fins/esb/mobile/domain/", name = "approveRequest")
    public JAXBElement<ApproveRequest> createApproveRequest(ApproveRequest value) {
        return new JAXBElement<ApproveRequest>(_ApproveRequest_QNAME, ApproveRequest.class, null, value);
    }

}
