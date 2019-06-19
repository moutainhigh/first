
package com.deppon.dpm.webserviceclient.affiche.dip.integrateportal.informationcenter.bulletinmanage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dip.integrateportal.informationcenter.bulletinmanage package. 
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

    private final static QName _RequestStr_QNAME = new QName("http://bulletinManage.informationCenter.integrateportal.dip", "requestStr");
    private final static QName _QueryInnerGgReturn_QNAME = new QName("http://bulletinManage.informationCenter.integrateportal.dip", "requestStrReturn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dip.integrateportal.informationcenter.bulletinmanage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bulletinManage.informationCenter.integrateportal.dip", name = "requestStr")
    public JAXBElement<String> createRequestStr(String value) {
        return new JAXBElement<String>(_RequestStr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bulletinManage.informationCenter.integrateportal.dip", name = "requestStrReturn")
    public JAXBElement<String> createQueryInnerGgReturn(String value) {
        return new JAXBElement<String>(_QueryInnerGgReturn_QNAME, String.class, null, value);
    }

}
