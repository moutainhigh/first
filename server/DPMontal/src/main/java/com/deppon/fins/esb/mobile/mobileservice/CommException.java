
package com.deppon.fins.esb.mobile.mobileservice;

import javax.xml.ws.WebFault;

import com.deppon.esb.exception.CommonExceptionInfo;


/**
 * This class was generated by Apache CXF 2.6.7
 * 2014-04-18T14:25:06.125+08:00
 * Generated source version: 2.6.7
 */

@WebFault(name = "commonExceptionInfo", targetNamespace = "http://www.deppon.com/esb/exception")
public class CommException extends Exception {
    
    private CommonExceptionInfo commonExceptionInfo;

    public CommException() {
        super();
    }
    
    public CommException(String message) {
        super(message);
    }
    
    public CommException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommException(String message, CommonExceptionInfo commonExceptionInfo) {
        super(message);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public CommException(String message, CommonExceptionInfo commonExceptionInfo, Throwable cause) {
        super(message, cause);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public CommonExceptionInfo getFaultInfo() {
        return this.commonExceptionInfo;
    }
}