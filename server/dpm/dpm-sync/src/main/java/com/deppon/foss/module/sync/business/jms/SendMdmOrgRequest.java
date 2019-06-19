package com.deppon.foss.module.sync.business.jms;

import java.util.ArrayList;
import java.util.List;

/**
 * Schema fragment(s) for this class:
 * 
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.deppon.com/uums/inteface/domain/usermanagement" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SendMdmOrgRequest">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:MdmOrgInfo" name="adminOrgInfo" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class SendMdmOrgRequest {
	private List<MdmOrgInfo> adminOrgInfoList = new ArrayList<MdmOrgInfo>();

	/**
	 * Get the list of 'adminOrgInfo' element items. 行政组织信息
	 * 
	 * @return list
	 */
	public List<MdmOrgInfo> getAdminOrgInfoList() {
		return adminOrgInfoList;
	}

	/**
	 * Set the list of 'adminOrgInfo' element items. 行政组织信息
	 * 
	 * @param list
	 */
	public void setAdminOrgInfoList(List<MdmOrgInfo> list) {
		adminOrgInfoList = list;
	}
}
