package com.deppon.lsp.module.mobileworkflowlist.controlcenter.server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.7
 * 2014-04-18T08:36:20.703+08:00
 * Generated source version: 2.6.7
 * 
 */
@WebService(targetNamespace = "http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/server/service", name = "IMobileWorkflowService")
@XmlSeeAlso({com.deppon.esb.header.ObjectFactory.class, com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.ObjectFactory.class, com.deppon.esb.exception.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IMobileWorkflowService {

    @WebResult(name = "auditOperationInLspResponse", targetNamespace = "http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/shared/domain", partName = "response")
    @WebMethod(action = "http://www.deppon.com/lsp/interface/LspService/workflowApprove")
    public int workflowApprove(
        @WebParam(partName = "request", name = "auditOperationInLsp", targetNamespace = "http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/shared/domain")
        com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.Auditparameters request,
        @WebParam(partName = "esbHeader", mode = WebParam.Mode.INOUT, name = "esbHeader", targetNamespace = "http://www.deppon.com/esb/header", header = true)
        javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader> esbHeader
    ) throws CommException;

    @WebResult(name = "WorkflowBusinessDataResponse", targetNamespace = "http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/shared/domain", partName = "response")
    @WebMethod(action = "http://www.deppon.com/lsp/interface/LspService/queryWorkflowInfo")
    public com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity queryWorkflowInfo(
        @WebParam(partName = "request", name = "WorkflowBusinessData", targetNamespace = "http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/shared/domain")
        com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowBusinessData request,
        @WebParam(partName = "esbHeader", mode = WebParam.Mode.INOUT, name = "esbHeader", targetNamespace = "http://www.deppon.com/esb/header", header = true)
        javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader> esbHeader
    ) throws CommException;
}
