package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author 王亚男
 * 向PC端推送数据 明细信息
 *
 */
public class TaskSubmitEntity implements Serializable {

	
	private static final long serialVersionUID = -4061463682204809372L;
	//序列
	private String number;					
	//项目编号
	private String acceptancePeople;		
	//验收人编码
	private String acceptanceTime;			
	//验收时间
	private String acceptancePass = "是";			
	//验收是否通过("是"或"否")
	private double pointsTotal;				
	//扣分总计（小数）
	private String acceptanceVerdict;		
	//验收结论  -- 验收合格
	private double firstPointsTotal;		
	//初次扣分总计（小数） 
	private String firstAcceptanceTime;		
	//初次验收时间
	private List<EntriesEntity> entries = new ArrayList<EntriesEntity>();				
	//分录
	private List<AttachmentsEntity> attachments = new ArrayList<AttachmentsEntity>();	
	//附件信息
	private int isSuccess;					
	//是否成功（0:插入任务数据,1:是,2:有任务数据但是没有提交,不做修改;10:异常）
	private String message;					
	//结果信息
	
	/**
	 * 构造函数
	 */
	public TaskSubmitEntity(){
		
	}
	
	/**
	 * 添加
	 * @param pc
	 */
	public void addPcInfo(ProcCheckPCEntity pc){
		String baseString = "data:image/jpeg;base64,";
		String fileContent = "";
		//非空判断
		if(StringUtils.isNotEmpty(pc.getImgOne())){
			AttachmentsEntity attachmentsEntity = new AttachmentsEntity();
			fileContent = pc.getImgOne().replace(baseString, "");
			attachmentsEntity.setFileContent(fileContent);
			attachmentsEntity.setCreaterCode(pc.getUserNo());
			attachmentsEntity.setLastUpdaterCode(pc.getUserNo());
			//添加到对象里面
			this.getAttachments().add(attachmentsEntity);
		}
		//非空判断
		if(StringUtils.isNotEmpty(pc.getImgTwo())){
			AttachmentsEntity attachmentsEntity = new AttachmentsEntity();
			fileContent = pc.getImgTwo().replace(baseString, "");
			attachmentsEntity.setFileContent(fileContent);
			attachmentsEntity.setCreaterCode(pc.getUserNo());
			attachmentsEntity.setLastUpdaterCode(pc.getUserNo());
			//添加到对象里面
			this.getAttachments().add(attachmentsEntity);
		}
		//非空判断
		if(StringUtils.isNotEmpty(pc.getImgThree())){
			AttachmentsEntity attachmentsEntity = new AttachmentsEntity();
			fileContent = pc.getImgThree().replace(baseString, "");
			attachmentsEntity.setFileContent(fileContent);
			attachmentsEntity.setCreaterCode(pc.getUserNo());
			attachmentsEntity.setLastUpdaterCode(pc.getUserNo());
			//添加到对象里面
			this.getAttachments().add(attachmentsEntity);
		}
		//非空判断
		if(StringUtils.isNotEmpty(pc.getImgFour())){
			AttachmentsEntity attachmentsEntity = new AttachmentsEntity();
			fileContent = pc.getImgFour().replace(baseString, "");
			attachmentsEntity.setFileContent(fileContent);
			attachmentsEntity.setCreaterCode(pc.getUserNo());
			attachmentsEntity.setLastUpdaterCode(pc.getUserNo());
			//添加到对象里面
			this.getAttachments().add(attachmentsEntity);
		}
		//非空判断
		if(StringUtils.isNotEmpty(pc.getImgFive())){
			AttachmentsEntity attachmentsEntity = new AttachmentsEntity();
			fileContent = pc.getImgFive().replace(baseString, "");
			attachmentsEntity.setFileContent(fileContent);
			attachmentsEntity.setCreaterCode(pc.getUserNo());
			attachmentsEntity.setLastUpdaterCode(pc.getUserNo());
			//添加到对象里面
			this.getAttachments().add(attachmentsEntity);
		}
		
	}
	
	/**
	 * 数字
	 * @return
	 */
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 人
	 * @return
	 */
	public String getAcceptancePeople() {
		return acceptancePeople;
	}
	public void setAcceptancePeople(String acceptancePeople) {
		this.acceptancePeople = acceptancePeople;
	}
	
	/**
	 * acceptancePass
	 * @return
	 */
	public String getAcceptancePass() {
		return acceptancePass;
	}
	public void setAcceptancePass(String acceptancePass) {
		this.acceptancePass = acceptancePass;
	}
	
	/**
	 * acceptanceVerdict
	 * @return
	 */
	public String getAcceptanceVerdict() {
		return acceptanceVerdict;
	}
	public void setAcceptanceVerdict(String acceptanceVerdict) {
		this.acceptanceVerdict = acceptanceVerdict;
	}
	
	/**
	 * 集合entries
	 * @return
	 */
	public List<EntriesEntity> getEntries() {
		return entries;
	}
	public void setEntries(List<EntriesEntity> entries) {
		this.entries = entries;
	}
	/**
	 * 集合attachments
	 * @return
	 */
	public List<AttachmentsEntity> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AttachmentsEntity> attachments) {
		this.attachments = attachments;
	}
	/**
	 * 标示
	 * @return
	 */
	public int getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	/**
	 * 消息
	 * @return
	 */
	public String getMessage() {
		if(this.isSuccess == 1){
			this.message = "查询明细成功";
		}else if(isSuccess == 2){
			this.message="有任务记录,但是没有最终提交";
		}else if(this.isSuccess == 0) {
			this.message = "setIsSuccess";
		}else{
			this.message = "系统出现异常";
		}
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	/**
	 * 时间
	 * @return
	 */
	public String getFirstAcceptanceTime() {
		return firstAcceptanceTime;
	}

	public void setFirstAcceptanceTime(String firstAcceptanceTime) {
		this.firstAcceptanceTime = firstAcceptanceTime;
	}
	/**
	 * 时间
	 * @return
	 */
	public String getAcceptanceTime() {
		return acceptanceTime;
	}

	public void setAcceptanceTime(String acceptanceTime) {
		this.acceptanceTime = acceptanceTime;
	}
	/**
	 * 总和
	 * @return
	 */
	public double getPointsTotal() {
		return pointsTotal;
	}

	public void setPointsTotal(double pointsTotal) {
		this.pointsTotal = pointsTotal;
	}
	/**
	 * 总和
	 * @return
	 */
	public double getFirstPointsTotal() {
		return firstPointsTotal;
	}

	public void setFirstPointsTotal(double firstPointsTotal) {
		this.firstPointsTotal = firstPointsTotal;
	}
	
	
}
