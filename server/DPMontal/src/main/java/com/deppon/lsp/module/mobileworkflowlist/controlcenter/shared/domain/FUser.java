package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

public class FUser extends BaseEntity {

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 6217064352152110410L;
	//用户编号
	private String fnumber;
	//用户姓名
	private String fname;
	public String getFsimplename() {
		return fsimplename;
	}

	public void setFsimplename(String fsimplename) {
		this.fsimplename = fsimplename;
	}
	//用户所属部门
	private String forg;
	//用户所属部门标杆编码
	private String fsimplename;
	
	/**
	 * 
	 * @Description:组织单元 Getter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public String getForg() {
		return forg;
	}
	
	/**
	 * 
	 * @Description:组织单元 setter
	 * @return
	 * String
	 * @exception:
	 * @author: zhangxing
	 * @time:2013-9-27 下午5:56:46
	 */
	public void setForg(String forg) {
		this.forg = forg;
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
	public String getFnumber() {
		return fnumber;
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
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
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
	public String getFname() {
		return fname;
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
	public void setFname(String fname) {
		this.fname = fname;
		
	}
	
	
	
	

}
