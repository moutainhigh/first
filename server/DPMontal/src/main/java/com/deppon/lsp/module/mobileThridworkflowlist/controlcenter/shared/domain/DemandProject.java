package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * @author liuchangming-lms
 * @createtime 2013-8-29下午7:07:04
 * @description 需求项目实体类
 */
public class DemandProject extends BaseEntity {

	/**
	 * 随机序列化id
	 */
	private static final long serialVersionUID = 8035746309332176683L;
	// id
	private String id;
	// 单据编号
	private String number;
	// 中文名称
	private String nameChinese;
	// 创建者
	private String creatorName;
	// 创建时间
	private Date createTime;
	// 最后修改者
	private String lastUpdateUsername;
	// 最后修改时间
	private Date lastUpdateTime;
	// 控制单元
	private String controlUnit;
	// 计量单位
	private String measureUnit;
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 id属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public String getId() {
		return id;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 id的值
	 *
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 number属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public String getNumber() {
		return number;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 number的值
	 *
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 nameChinese属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public String getNameChinese() {
		return nameChinese;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 nameChinese的值
	 *
	 */
	public void setNameChinese(String nameChinese) {
		this.nameChinese = nameChinese;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 creatorName属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public String getCreatorName() {
		return creatorName;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 creatorName的值
	 *
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 createTime属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 createTime的值
	 *
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 lastUpdateUsername属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public String getLastUpdateUsername() {
		return lastUpdateUsername;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 lastUpdateUsername的值
	 *
	 */
	public void setLastUpdateUsername(String lastUpdateUsername) {
		this.lastUpdateUsername = lastUpdateUsername;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 lastUpdateTime属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 lastUpdateTime的值
	 *
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 controlUnit属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public String getControlUnit() {
		return controlUnit;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 controlUnit的值
	 *
	 */
	public void setControlUnit(String controlUnit) {
		this.controlUnit = controlUnit;
	}
	/**
	 * @Description : getter
	 *
	 * @Description : 返回 measureUnit属性的值
	 *
	 * @date 2014-4-22 上午10:24:03
	 */
	
	public String getMeasureUnit() {
		return measureUnit;
	}
	/**
	 *
	 * @Description : setter
	 *
	 * @date 2014-4-22 上午10:24:03
	 *
	 * @param  设置属性 measureUnit的值
	 *
	 */
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	

}
