
package com.deppon.dpm.webservice.dpmtoappservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.1.4
 * Mon Jun 30 16:47:37 CST 2014
 * Generated source version: 2.1.4
 * 
 */

@WebFault(name = "commonExceptionInfo", targetNamespace = "http://www.deppon.com/esb/exception")
public class CommException extends Exception {
    public static final long serialVersionUID = 20140630164737L;
    
    private com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo;

    public CommException() {
        super();
    }
    
    public CommException(String message) {
        super(message);
    }
    
    public CommException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommException(String message, com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo) {
        super(message);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public CommException(String message, com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo, Throwable cause) {
        super(message, cause);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public com.deppon.esb.exception.CommonExceptionInfo getFaultInfo() {
        return this.commonExceptionInfo;
    }
}
