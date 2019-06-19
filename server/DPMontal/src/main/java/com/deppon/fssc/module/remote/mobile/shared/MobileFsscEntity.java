//package com.deppon.fssc.module.remote.mobile.shared;
//
//import java.io.Serializable;
//
//
///**
// * 
// * 移动客户端调取报账系统实体封装对象
// * @author 陈平樊
// * @date 2013-11-6 下午6:17:36
// * @since
// * @version
// */
//public class MobileFsscEntity implements Serializable{
//
//	/**
//	* 
//	*/
//	private static final long serialVersionUID = -3899218491026909977L;
//
//	//报账移动客户端基本头信息
//	private ClaimFsscBase mobileBaseEntity;
//	
//	//报账移动客户端明细信息
//	private ClaimLineFssc[] mobileLineArray;
//	
//	//报账移动客户端流程动态（各阶段审批信息实体）
//	private ApproveFssc[] mobileApprovalArray;
//	
//	//报账移动客户端回退节点信息
//	private MobileBranchRule[] mobileBackRule;
//	
//	//报账移动客户端附件信息
//	private AttachResource[] attachResource;
//	
//	public ClaimFsscBase getMobileBaseEntity() {
//		return mobileBaseEntity;
//	}
//
//	public void setMobileBaseEntity(ClaimFsscBase mobileBaseEntity) {
//		this.mobileBaseEntity = mobileBaseEntity;
//		System.out.println("aa");
//	}
//
//	public ClaimLineFssc[] getMobileLineArray() {
//		return mobileLineArray;
//	}
//
//	public void setMobileLineArray(ClaimLineFssc[] mobileLineArray) {
//		System.out.println("aa");
//		this.mobileLineArray = mobileLineArray;
//	}
//
//	public ApproveFssc[] getMobileApprovalArray() {
//		return mobileApprovalArray == null ? new ApproveFssc[0] : mobileApprovalArray;
//	}
//
//	public void setMobileApprovalArray(ApproveFssc[] mobileApprovalArray) {
//		this.mobileApprovalArray = mobileApprovalArray;
//	}
//
//	public MobileBranchRule[] getMobileBackRule() {
//	
//		return mobileBackRule == null ? new MobileBranchRule[0] : mobileBackRule;
//	}
//
//	public void setMobileBackRule(MobileBranchRule[] mobileBackRule) {
//	
//		this.mobileBackRule = mobileBackRule;
//	}
//
//	/**
//	 * @return the attachResource
//	 */
//	public AttachResource[] getAttachResource() {
//		return attachResource;
//	}
//
//	/**
//	 * @param attachResource the attachResource to set
//	 */
//	public void setAttachResource(AttachResource[] attachResource) {
//		this.attachResource = attachResource;
//	}
//	
//}
