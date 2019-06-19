package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;

/** 
* @ClassName: QueryRquestBudgetEntity 
* @Description: TODO(预算查询请求参数) 
* @author 287306
* @date 2017-11-21 下午8:47:07 
*  
*/
public class QueryRquestBudgetEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empCode;

	/**
	 * 构造方法
	 */
	public QueryRquestBudgetEntity(){
		super();
	}
	
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	

}
