package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @Description : 维修申请单
 * @author : jianweiqiang
 * @date 2014-5-20 下午5:32:30
 * @since
 * @version v0.1
 */
public class MaintenrequestVo {
	// 维修申请单主表
	private MaintenRequestEntity maintenRequestEntity;
	// 维修申请单分录
	private MaintenRequestEntryEntity[] maintenRequestEntryEntityList;

	/**
	 * @Description : 返回 maintenRequestEntity属性的值
	 * @date 2014-5-20 下午5:34:25
	 */

	public MaintenRequestEntity getMaintenRequestEntity() {
		if (maintenRequestEntity == null) {
			maintenRequestEntity = new MaintenRequestEntity();
		}
		return maintenRequestEntity;
	}

	/**
	 * @param 设置属性
	 *            maintenRequestEntity的值
	 */
	public void setMaintenRequestEntity(
			MaintenRequestEntity maintenRequestEntity) {
		this.maintenRequestEntity = maintenRequestEntity;
	}

	/**
	 * @Description : 返回 maintenRequestEntryEntityList属性的值
	 * @date 2014-5-20 下午5:34:25
	 */

	public MaintenRequestEntryEntity[] getMaintenRequestEntryEntityList() {
		if (maintenRequestEntryEntityList == null) {
			MaintenRequestEntryEntity temp = new MaintenRequestEntryEntity();
			maintenRequestEntryEntityList = new MaintenRequestEntryEntity[1];
			maintenRequestEntryEntityList[0] = temp;
		}
		return maintenRequestEntryEntityList;
	}

	/**
	 * @param 设置属性
	 *            maintenRequestEntryEntityList的值
	 */
	public void setMaintenRequestEntryEntityList(
			MaintenRequestEntryEntity[] maintenRequestEntryEntityList) {
		this.maintenRequestEntryEntityList = maintenRequestEntryEntityList;
	}

	/**
	 * 
	 * @Description : 覆盖toString方法
	 * @author : jianweiqiang
	 * @date 2014-5-20 下午5:35:49
	 * @return 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
