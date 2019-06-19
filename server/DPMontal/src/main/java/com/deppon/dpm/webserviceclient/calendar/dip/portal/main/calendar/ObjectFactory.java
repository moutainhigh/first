
package com.deppon.dpm.webserviceclient.calendar.dip.portal.main.calendar;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.deppon.dpm.webserviceclient.calendar.dip.portal.dataclient.json.JSONException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dip.portal.main.calendar package. 
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

    private final static QName _Fault_QNAME = new QName("http://calendar.main.portal.dip", "fault");
    private final static QName _RequestStr_QNAME = new QName("http://calendar.main.portal.dip", "requestStr");
    private final static QName _HandleCalendarReturn_QNAME = new QName("http://calendar.main.portal.dip", "requestStrReturn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dip.portal.main.calendar
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JSONException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calendar.main.portal.dip", name = "fault")
    public JAXBElement<JSONException> createFault(JSONException value) {
        return new JAXBElement<JSONException>(_Fault_QNAME, JSONException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calendar.main.portal.dip", name = "requestStr")
    public JAXBElement<String> createRequestStr(String value) {
        return new JAXBElement<String>(_RequestStr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calendar.main.portal.dip", name = "requestStrReturn")
    public JAXBElement<String> createHandleCalendarReturn(String value) {
        return new JAXBElement<String>(_HandleCalendarReturn_QNAME, String.class, null, value);
    }

}
