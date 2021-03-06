package com.deppon.dpm.webservice.dpmtoappservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.1.4
 * Wed Jun 03 09:29:36 CST 2015
 * Generated source version: 2.1.4
 * 
 */
 
@WebService(targetNamespace = "http://www.deppon.com/dpm/webService/DpmToAppService", name = "DpmToAppService")
@XmlSeeAlso({com.deppon.esb.header.ObjectFactory.class,com.deppon.esb.exception.ObjectFactory.class,com.deppon.dpm.webservice.domain.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface DpmToAppService {

    @WebResult(name = "queryWorkflowItemsResponse", targetNamespace = "http://www.deppon.com/dpm/webService/domain/", partName = "response")
    @WebMethod(action = "http://www.deppon.com/dpm/webService/DpmToAppService/queryWorkflowItems")
    public com.deppon.dpm.webservice.domain.QueryWorkflowItemsResponse queryWorkflowItems(
        @WebParam(partName = "request", name = "queryWorkflowItemsRequest", targetNamespace = "http://www.deppon.com/dpm/webService/domain/")
        com.deppon.dpm.webservice.domain.QueryWorkflowItemsRequest request,
        @WebParam(partName = "esbHeader", mode = WebParam.Mode.INOUT, name = "esbHeader", targetNamespace = "http://www.deppon.com/esb/header", header = true)
        javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader> esbHeader
    ) throws CommException;
}
