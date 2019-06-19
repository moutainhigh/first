
/*
 * 
 */

package com.deppon.lsp.module.mobileworkflowlist.controlcenter.server.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.1.4
 * Thu Apr 17 16:24:03 CST 2014
 * Generated source version: 2.1.4
 * 
 */


@WebServiceClient(name = "LspService", 
wsdlLocation = "http://192.168.67.12:8580/esb2/ws/dpm2lsp/queryWorkflow?wsdl",
targetNamespace = "http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/server/service") 
public class LspService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/server/service", "LspService");
    public final static QName LspServiceSOAP = new QName("http://www.deppon.com/lsp/module/mobileworkflowlist/controlcenter/server/service", "LspServiceSOAP");
    static {
        URL url = null;
        try {
            url = new URL("http://192.168.67.12:8580/esb2/ws/dpm2lsp/queryWorkflow?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(LspService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://192.168.67.12:8580/esb2/ws/dpm2lsp/queryWorkflow?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public LspService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LspService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LspService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns IMobileWorkflowService
     */
    @WebEndpoint(name = "LspServiceSOAP")
    public IMobileWorkflowService getLspServiceSOAP() {
        return super.getPort(LspServiceSOAP, IMobileWorkflowService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMobileWorkflowService
     */
    @WebEndpoint(name = "LspServiceSOAP")
    public IMobileWorkflowService getLspServiceSOAP(WebServiceFeature... features) {
        return super.getPort(LspServiceSOAP, IMobileWorkflowService.class, features);
    }

}
