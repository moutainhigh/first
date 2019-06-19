package com.deppon.foss.module.sync.business.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * UUMS发送至业务系统的人员信息，由UUMS负责统一维护公司员工数据；
 * 
 * Schema fragment(s) for this class:
 * 
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.deppon.com/uums/inteface/domain/usermanagement" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SendMdmEmpRequest">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:MdmEmpInfo" name="employeeInfo" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class SendMdmEmpRequests {
	private List<MdmEmployeeInfo> employeeInfoList = new ArrayList<MdmEmployeeInfo>();

	/**
	 * Get the list of 'employeeInfo' element items. 人员信息
	 * 
	 * @return list
	 */
	public List<MdmEmployeeInfo> getEmployeeInfoList() {
		return employeeInfoList;
	}

	/**
	 * Set the list of 'employeeInfo' element items. 人员信息
	 * 
	 * @param list
	 */
	public void setEmployeeInfoList(List<MdmEmployeeInfo> list) {
		employeeInfoList = list;
	}
}
