
package com.deppon.dpm.webserviceclient.calendar.dip.portal.main.calendar;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.4.3
 * 2014-10-17T20:00:31.066+08:00
 * Generated source version: 2.4.3
 */

@WebFault(name = "fault", targetNamespace = "http://calendar.main.portal.dip")
public class JSONException extends Exception {
    
    private com.deppon.dpm.webserviceclient.calendar.dip.portal.dataclient.json.JSONException fault;

    public JSONException() {
        super();
    }
    
    public JSONException(String message) {
        super(message);
    }
    
    public JSONException(String message, Throwable cause) {
        super(message, cause);
    }

    public JSONException(String message, com.deppon.dpm.webserviceclient.calendar.dip.portal.dataclient.json.JSONException fault) {
        super(message);
        this.fault = fault;
    }

    public JSONException(String message, com.deppon.dpm.webserviceclient.calendar.dip.portal.dataclient.json.JSONException fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public com.deppon.dpm.webserviceclient.calendar.dip.portal.dataclient.json.JSONException getFaultInfo() {
        return this.fault;
    }
}
