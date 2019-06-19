package com.deppon.foss.module.sync.business.jms;

import java.util.ArrayList;
import java.util.List;

/**
 * Schema fragment(s) for this class:
 * 
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.deppon.com/uums/inteface/domain/usermanagement" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="SendMdmEmpResponse">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:int" name="successCount" minOccurs="1" maxOccurs="1"/>
 *     &lt;xs:element type="xs:int" name="failedCount" minOccurs="1" maxOccurs="1"/>
 *     &lt;xs:element type="ns:SendMdmEmpProcessReult" name="processResult" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class SendMdmEmpResponse {
	private int successCount;
	private int failedCount;
	private String sysName;
	private List<SendMdmEmpProcessReult> processResultList = new ArrayList<SendMdmEmpProcessReult>();

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	/**
	 * Get the 'successCount' element value. 成功总数
	 * 
	 * @return value
	 */
	public int getSuccessCount() {
		return successCount;
	}

	/**
	 * Set the 'successCount' element value. 成功总数
	 * 
	 * @param successCount
	 */
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	/**
	 * Get the 'failedCount' element value. 失败总数
	 * 
	 * @return value
	 */
	public int getFailedCount() {
		return failedCount;
	}

	/**
	 * Set the 'failedCount' element value. 失败总数
	 * 
	 * @param failedCount
	 */
	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	/**
	 * Get the list of 'processResult' element items. 处理明细
	 * 
	 * @return list
	 */
	public List<SendMdmEmpProcessReult> getProcessResultList() {
		return processResultList;
	}

	/**
	 * Set the list of 'processResult' element items. 处理明细
	 * 
	 * @param list
	 */
	public void setProcessResultList(List<SendMdmEmpProcessReult> list) {
		processResultList = list;
	}
}
