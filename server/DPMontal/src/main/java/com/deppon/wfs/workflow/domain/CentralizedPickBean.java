package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @title: CentralizedpickBean 
 * @description： 集中接货申请Bean
 * @author： 关波
 * @date： 2014年5月29日 下午4:57:21
 */
/**
 * 命名空间
 */
public class CentralizedPickBean implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -8268544673680338914L;

	/**
	 * 主键ID
	 */
    private String busino;
	/**
	 * 流程实例ID
	 */
	private Long processinstid;
	/**
	 * 申请人姓名
	 */
	private String applyPersonName;
	/**
	 * 申请人工号
	 */
	private String applyPersonId;
	/**
	 * 申请事由
	 */
	private String applyReason;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 业务状态，是否有效（1-有效 0-无效）
	 */
	private String isEffective;
	/**
	 * 备注1
	 */
	private Long reserve1;
	/**
	 * 备注2
	 */
	private String reserve2;
	/**
	 * 备注3
	 */
	private String reserve3;
	
	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * @return the processinstid
	 */
	public Long getProcessinstid() {
		return processinstid;
	}
	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}
	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}
	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	 * @return the applyReason
	 */
	public String getApplyReason() {
		if (applyReason == null) {
			applyReason = "";
		}
		return applyReason;
	}
	/**
	 * @param applyReason the applyReason to set
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the isEffective
	 */
	public String getIsEffective() {
		return isEffective;
	}
	/**
	 * @param isEffective the isEffective to set
	 */
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	/**
	 * @return the reserve1
	 */
	public Long getReserve1() {
		return reserve1;
	}
	/**
	 * @param reserve1 the reserve1 to set
	 */
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}
	/**
	 * @return the reserve2
	 */
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * @param reserve2 the reserve2 to set
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	/**
	 * @return the reserve3
	 */
	public String getReserve3() {
		return reserve3;
	}
	/**
	 * @param reserve3 the reserve3 to set
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	
	/**
	 * @MethodName: toString 
	 * @description: 重载toString方法
	 * @author： wuyaqing 
	 * @date： 2013年10月21日 下午4:55:25
	 * @return
	 */
	@Override
	public String toString() {
		//返回结果
		return 
				//主键ID
				"AssessreduceBean [busino=" + busino 
				//流程实例ID
				+ ", processinstid=" + processinstid 
				//申请人姓名
				+ ", applyPersonName=" + applyPersonName
				//申请人工号
				+ ", applyPersonId=" + applyPersonId 
				//申请事由
				+ ", applyReason=" + applyReason 
				//创建时间
				+ ", createTime=" + createTime 
				//修改时间
				+ ", modifyTime=" + modifyTime 
				//业务状态，是否有效（1-有效 0-无效）
				+ ", isEffective=" + isEffective 
				//备注1
				+ ", reserve1=" + reserve1 
				//备注2
				+ ", reserve2=" + reserve2 
				//备注3
				+ ", reserve3=" + reserve3 
				//获取业务主键
				+ ", getBusino()=" + getBusino() 
				//获取流程实例ID
				+ ", getProcessinstid()=" + getProcessinstid()
				//获取申请人姓名
				+ ", getApplyPersonName()=" + getApplyPersonName()
				//获取申请人id
				+ ", getApplyPersonId()=" + getApplyPersonId()
				//获取申请事由
				+ ", getApplyReason()=" + getApplyReason()
				//获取创建时间
				+ ", getCreateTime()=" + getCreateTime() 
				//获取修改时间
				+ ", getModifyTime()=" + getModifyTime() 
				//获取业务状态，是否有效（1-有效 0-无效）
				+ ", getIsEffective()=" + getIsEffective()
				//获取备注1
				+ ", getReserve1()=" + getReserve1() 
				//获取备注2
				+ ", getReserve2()=" + getReserve2() 
				//获取备注3
				+ ", getReserve3()=" + getReserve3()
				//获取hashCode值
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	/**
	 * @MethodName: hashCode 
	 * @description: 重载hashCode方法
	 * @author： wuyaqing 
	 * @date： 2013年10月21日 下午5:01:41
	 * @return
	 */
	@Override
	public int hashCode() {
		//定义常量
		final int prime = 31;
		//定义结果变量，并初始化为1
		int result = 1;
		//计算结果加上申请人工号
		result = prime * result + ((applyPersonId == null) ? 0 : applyPersonId.hashCode());
		//计算结果加上申请人姓名
		result = prime * result + ((applyPersonName == null) ? 0 : applyPersonName.hashCode());
		//计算结果加上申请事由
		result = prime * result + ((applyReason == null) ? 0 : applyReason.hashCode());
		//计算结果加上主键ID
		result = prime * result + ((busino == null) ? 0 : busino.hashCode());
		//计算结果加上创建时间
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		//计算结果加上业务状态，是否有效（1-有效 0-无效）
		result = prime * result + ((isEffective == null) ? 0 : isEffective.hashCode());
		//计算结果加上修改时间
		result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
		//计算结果加上流程实例ID
		result = prime * result + ((processinstid == null) ? 0 : processinstid.hashCode());
		//计算结果加上备注1
		result = prime * result + ((reserve1 == null) ? 0 : reserve1.hashCode());
		//计算结果加上备注2
		result = prime * result + ((reserve2 == null) ? 0 : reserve2.hashCode());
		//计算结果加上备注3
		result = prime * result + ((reserve3 == null) ? 0 : reserve3.hashCode());
		//返回结果
		return result;
	}
	
	/**
	 * @MethodName: equals 
	 * @description: 重载equals方法
	 * @author： wuyaqing 
	 * @date： 2013年10月21日 下午5:01:21
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		//引用同一个对象
		if (this == obj)
			//返回true
			return true;
		//参数对象为空
		if (obj == null)
			//返回false
			return false;
		//不属于同一个类名
		if (getClass() != obj.getClass())
			//返回false
			return false;
		//参数obj是该对象的一个引用
		CentralizedPickBean other = (CentralizedPickBean) obj;
		//该对象的applyPersonId为空
		if (applyPersonId == null) {
			//参数的applyPersonId不为空
			if (other.applyPersonId != null)
				//返回false
				return false;
		} else if (!applyPersonId.equals(other.applyPersonId))
			//参数的applyPersonId与该对象的applyPersonId不相等
			//返回false
			return false;
		//该对象的applyPersonName为空
		if (applyPersonName == null) {
			//参数的applyPersonName不为空
			if (other.applyPersonName != null)
				//返回false
				return false;
		} else if (!applyPersonName.equals(other.applyPersonName))
			//参数的applyPersonName与该对象的applyPersonName不相等
			//返回false
			return false;
		//该对象的applyReason为空
		if (applyReason == null) {
			//参数的applyReason不为空
			if (other.applyReason != null)
				//返回false
				return false;
		} else if (!applyReason.equals(other.applyReason))
			//参数的applyReason与该对象的applyReason不相等
			//返回false
			return false;
		//该对象的busino为空
		if (busino == null) {
			//参数的busino不为空
			if (other.busino != null)
				//返回false
				return false;
		} else if (!busino.equals(other.busino))
			//参数的busino与该对象的busino不相等
			//返回false
			return false;
		//该对象的createTime为空
		if (createTime == null) {
			//参数的createTime不为空
			if (other.createTime != null)
				//返回false
				return false;
		} else if (!createTime.equals(other.createTime))
			//参数的createTime与该对象的createTime不相等
			//返回false
			return false;
		//该对象的isEffective为空
		if (isEffective == null) {
			//参数的isEffective不为空
			if (other.isEffective != null)
				//返回false
				return false;
		} else if (!isEffective.equals(other.isEffective))
			//参数的isEffective与该对象的isEffective不相等
			//返回false
			return false;
		//该对象的modifyTime为空
		if (modifyTime == null) {
			//参数的modifyTime不为空
			if (other.modifyTime != null)
				//返回false
				return false;
		} else if (!modifyTime.equals(other.modifyTime))
			//参数的modifyTime与该对象的modifyTime不相等
			//返回false
			return false;
		//该对象的processinstid为空
		if (processinstid == null) {
			//参数的processinstid不为空
			if (other.processinstid != null)
				//返回false
				return false;
		} else if (!processinstid.equals(other.processinstid))
			//参数的processinstid与该对象的processinstid不相等
			//返回false
			return false;
		//该对象的reserve1为空
		if (reserve1 == null) {
			//参数的reserve1不为空
			if (other.reserve1 != null)
				//返回false
				return false;
		} else if (!reserve1.equals(other.reserve1))
			//参数的reserve1与该对象的reserve1不相等
			//返回false
			return false;
		//该对象的reserve2为空
		if (reserve2 == null) {
			//参数的reserve2不为空
			if (other.reserve2 != null)
				//返回false
				return false;
		} else if (!reserve2.equals(other.reserve2))
			//参数的reserve2与该对象的reserve2不相等
			//返回false
			return false;
		//该对象的reserve3为空
		if (reserve3 == null) {
			//参数的reserve3不为空
			if (other.reserve3 != null)
				//返回false
				return false;
		} else if (!reserve3.equals(other.reserve3))
			//参数的reserve3与该对象的reserve3不相等
			//返回false
			return false;
		//上述情况都不满足时，参数对象和该对象就相等
		//返回true
		return true;
	}
}
