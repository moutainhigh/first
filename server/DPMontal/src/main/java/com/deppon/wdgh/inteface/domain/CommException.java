
package com.deppon.wdgh.inteface.domain;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.7
 * 2014-06-30T14:56:17.687+08:00
 * Generated source version: 2.6.7
 */

@WebFault(name = "commonExceptionInfo", targetNamespace = "http://www.deppon.com/esb/exception")
public class CommException extends Exception {
    
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