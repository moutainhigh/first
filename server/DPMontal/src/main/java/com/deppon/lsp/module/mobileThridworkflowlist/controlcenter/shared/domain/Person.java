/**
 * 
 */
package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @author zhangxing
 *@createtime 2013-8-27上午11:06:46
 *@description 人员信息	
 */
public class Person extends BaseEntity{

	/**
	 * serialVersionUID,long
	 */
	private static final long serialVersionUID = 3640947579535962573L;
	//人员id
	private String id;
	//人员名称
	private String name;
	//人员工号
	private String number;
	//所属部门
	private String dept;
	//所属部门id
	private String deptid;
	//职位名称
	private String positionName;
	//部门标杆编码
	private String adminSimpleName;
	
	/**
	 * 
	 * @Description:id Getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 
	 * @Description:id Setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @Description:名称 Getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @Description:描述 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @Description:编码 Getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * 
	 * @Description:编码 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * 
	 * @Description:部门 Getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getDept() {
		return dept;
	}
	
	/**
	 * 
	 * @Description:部门 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	/**
	 * 
	 * @Description:职位getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getPositionName() {
		return positionName;
	}
	
	/**
	 * 
	 * @Description:部门 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	/**
	 * 
	 * @Description:部门id getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getDeptid() {
		return deptid;
	}
	
	/**
	 * 
	 * @Description:部门 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getAdminSimpleName() {
		return adminSimpleName;
	}

	public void setAdminSimpleName(String adminSimpleName) {
		this.adminSimpleName = adminSimpleName;
	}
}
