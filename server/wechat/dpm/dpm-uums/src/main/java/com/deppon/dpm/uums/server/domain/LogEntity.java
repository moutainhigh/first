package com.deppon.dpm.uums.server.domain;

import java.io.Serializable;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.foss.framework.entity.IFunction;
import com.deppon.foss.framework.entity.IModule;

/** 
 * @ClassName: LogEntity 
 * @Description: 日志实体类
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年9月18日 下午10:51:13 
 *  
 */
public class LogEntity extends BaseEntity  implements IFunction,Serializable  {

	/** 
	*/ 
	private static final long serialVersionUID = 3390266944217297778L;

	/**
	 * 名称(更新或者删除或者添加)
	 */
	private String name;
	/**
	 * code(update或者delete或者add)
	 */
	private String code;

	/**
	 * 操作时间(用来排序的字段)
	 */
	private Date dateTime;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 操作人名称
	 */
	private String userName;
	/**
	 * 操作人code
	 */
	private String userCode;
	/**
	 * 操作人组织名称
	 */
	private String organizationName;
	/**
	 * 操作人组织code
	 */
	private String organizationCode;
	/** 
	 * @return name 
	 */
	public String getName() {
		return name;
	}
	/** 
	 * @param name 要设置的 name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/** 
	 * @return code 
	 */
	public String getCode() {
		return code;
	}
	/** 
	 * @param code 要设置的 code 
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/** 
	 * @return dateTime 
	 */
	public Date getDateTime() {
		return dateTime;
	}
	/** 
	 * @param dateTime 要设置的 dateTime 
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	/** 
	 * @return content 
	 */
	public String getContent() {
		return content;
	}
	/** 
	 * @param content 要设置的 content 
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/** 
	 * @return userName 
	 */
	public String getUserName() {
		return userName;
	}
	/** 
	 * @param userName 要设置的 userName 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** 
	 * @return userCode 
	 */
	public String getUserCode() {
		return userCode;
	}
	/** 
	 * @param userCode 要设置的 userCode 
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/** 
	 * @return organizationName 
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/** 
	 * @param organizationName 要设置的 organizationName 
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/** 
	 * @return organizationCode 
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/** 
	 * @param organizationCode 要设置的 organizationCode 
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/** 
	* @Title: getModule 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年9月19日 上午8:35:44 
	* @param @return
	* @param @deprecated    设定文件 
	* @throws 
	*/
	@Override
	public IModule getModule() {
		// TODO Auto-generated method stub
		return null;
	}
	/** 
	* @Title: getUri 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年9月19日 上午8:35:44 
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public String getUri() {
		// TODO Auto-generated method stub
		return null;
	}
	/** 
	* @Title: getKey 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年9月19日 上午8:35:44 
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	/** 
	* @Title: getFunctionCode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年9月19日 上午8:35:44 
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public String getFunctionCode() {
		// TODO Auto-generated method stub
		return null;
	}
	/** 
	* @Title: getValidFlag 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author yuyongxiang-134019-yuyongxiang@deppon.com
	* @date 2014年9月19日 上午8:35:44 
	* @param @return    设定文件 
	* @throws 
	*/
	@Override
	public Boolean getValidFlag() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
