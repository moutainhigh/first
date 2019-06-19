
package com.deppon.dpm.webservice.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.dpm.webservice.domain package. 
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

    private final static QName _QueryWorkflowItemsResponse_QNAME = new QName("http://www.deppon.com/dpm/webService/domain/", "queryWorkflowItemsResponse");
    private final static QName _QueryWorkflowItemsRequest_QNAME = new QName("http://www.deppon.com/dpm/webService/domain/", "queryWorkflowItemsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.dpm.webservice.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryWorkflowItemsResponse }
     * 
     */
    public QueryWorkflowItemsResponse createQueryWorkflowItemsResponse() {
        return new QueryWorkflowItemsResponse();
    }

    /**
     * Create an instance of {@link QueryWorkflowItemsRequest }
     * 
     */
    public QueryWorkflowItemsRequest createQueryWorkflowItemsRequest() {
        return new QueryWorkflowItemsRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/dpm/webService/domain/", name = "queryWorkflowItemsResponse")
    public JAXBElement<QueryWorkflowItemsResponse> createQueryWorkflowItemsResponse(QueryWorkflowItemsResponse value) {
        return new JAXBElement<QueryWorkflowItemsResponse>(_QueryWorkflowItemsResponse_QNAME, QueryWorkflowItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWorkflowItemsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/dpm/webService/domain/", name = "queryWorkflowItemsRequest")
    public JAXBElement<QueryWorkflowItemsRequest> createQueryWorkflowItemsRequest(QueryWorkflowItemsRequest value) {
        return new JAXBElement<QueryWorkflowItemsRequest>(_QueryWorkflowItemsRequest_QNAME, QueryWorkflowItemsRequest.class, null, value);
    }

}
