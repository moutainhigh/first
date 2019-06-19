package com.deppon.dpm.module.management.shared.domain;


import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @author zhangxing
 *@createtime 2013-8-27上午11:04:43
 *@description 部门基础信息
 */
public class AdminOrgUnit extends BaseEntity{

	/**
	 * serialVersionUID,long
	 */
	private static final long serialVersionUID = -6060681150242552950L;
	//部门id
	private String id;
	//部门名称
	private String name;
	//部门编码
	private String number;
	//部门标杆编码
	private String simpleName;
	//部门描述
	private String description;
	//cuid
	private String cuid;
	//上级组织id
	private String fparentId ;
	
	private String parameter;
	
	//公司组织单元
	private String companyOrgUnit;

	/**
	 * 
	 * @Description:参数 getter
	 * @return
	 * String
	 * @exception:
	 * @author: ZouYong
	 * @time: 2013-9-29
	 */
	public String getCompanyOrgUnit() {
		return companyOrgUnit;
	}

	/**
	 * 
	 * @Description:参数 setter
	 * @return
	 * String
	 * @exception:
	 * @author: ZouYong
	 * @time:2013-9-29
	 */
	public void setCompanyOrgUnit(String companyOrgUnit) {
		this.companyOrgUnit = companyOrgUnit;
	}

	/**
	 * 
	 * @Description:参数 getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getParameter() {
		return parameter;
	}
	
	/**
	 * 
	 * @Description:参数 getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	/**
	 * 
	 * @Description:cuid getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getCuid() {
		return cuid;
	}
	/**
	 * 
	 * @Description:cuid setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	
	/**
	 * 
	 * @Description:id getter
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
	 * @Description:id setter
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
	 * @Description:名称 getter
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
	 * @Description:名称 setter
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
	 * @Description:编码 getter
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
	 * @Description:标杆编码 getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getSimpleName() {
		return simpleName;
	}
	
	/**
	 * 
	 * @Description:标杆编码 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	
	/**
	 * 
	 * @Description: 描述 getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @Description: 描述 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @Description:父类id Getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getFparentId() {
		return fparentId;
	}
	/**
	 * 
	 * @Description:父类id setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setFparentId(String fparentId) {
		this.fparentId = fparentId;
	}
	
}
