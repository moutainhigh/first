package com.deppon.nhr.module.remote.dpm.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.7
 * 2014-04-16T09:38:06.546+08:00
 * Generated source version: 2.6.7
 * 
 */
@WebService(targetNamespace = "http://www.deppon.com/nhr/module/remote/dpm/service", name = "WorkFlowToDPMService")
@XmlSeeAlso({com.deppon.nhr.module.remote.dpm.shared.domain.workflow.ObjectFactory.class, com.deppon.esb.header.ObjectFactory.class, com.deppon.esb.exception.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface WorkFlowToDPMService {

    /**
     * 审批工作流
     */
    @WebResult(name = "dealWorkFlowResponse", targetNamespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", partName = "dealWorkFlowResponse")
    @WebMethod(action = "http://www.deppon.com/nhr/module/remote/dpm/service/dealWorkFlow")
    public com.deppon.nhr.module.remote.dpm.shared.domain.workflow.DealWorkFlowResponse dealWorkFlow(
        @WebParam(partName = "dealWorkFlowRequest", name = "dealWorkFlowRequest", targetNamespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow")
        com.deppon.nhr.module.remote.dpm.shared.domain.workflow.DealWorkFlowRequest dealWorkFlowRequest,
        @WebParam(partName = "esbHeader", mode = WebParam.Mode.INOUT, name = "esbHeader", targetNamespace = "http://www.deppon.com/esb/header", header = true)
        javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader> esbHeader
    ) throws CommonException;

    /**
     * 查询工作流
     */
    @WebResult(name = "queryWorkflowInfoResponse", targetNamespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow", partName = "queryWorkflowInfoResponse")
    @WebMethod(action = "http://www.deppon.com/nhr/module/remote/dpm/service/queryByWrokFlowEntity")
    public com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoResponse queryByWrokFlowEntity(
        @WebParam(partName = "queryWorkflowInfoRequest", name = "queryWorkflowInfoRequest", targetNamespace = "http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow")
        com.deppon.nhr.module.remote.dpm.shared.domain.workflow.QueryWorkflowInfoRequest queryWorkflowInfoRequest,
        @WebParam(partName = "esbHeader", mode = WebParam.Mode.INOUT, name = "esbHeader", targetNamespace = "http://www.deppon.com/esb/header", header = true)
        javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader> esbHeader
    ) throws CommonException;
}
