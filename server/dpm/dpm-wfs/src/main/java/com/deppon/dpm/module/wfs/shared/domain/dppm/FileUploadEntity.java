package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
* @title: FileUploadEntity 
* @description：文件上传实体类
* @author： 高孟冉
* @date： 2014年7月22日 上午11:27:03
 */
public class FileUploadEntity extends BaseEntity {
	/**
	 * 附件数据实体类
	 */
	private static final long serialVersionUID = -3910533314396125367L;

	/**
     * 主键
     */
    private Long fId;

    private String module;

    private Integer moduleId;

    private String moduleCode;

    private String fileName;

    private String saveName;

    private String savePath;

    private Long fileSize;

    private Date uploadTime;
    
    private String uploadEmp;
    
    private String fileType;
    
    private Integer fileId;

	/**
	 * @return  the fId
	 */
	public Long getfId() {
		return fId;
	}

	/**
	 * @param fId the fId to set
	 */
	public void setfId(Long fId) {
		this.fId = fId;
	}

	/**
	 * @return  the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @return  the moduleId
	 */
	public Integer getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return  the moduleCode
	 */
	public String getModuleCode() {
		return moduleCode;
	}

	/**
	 * @param moduleCode the moduleCode to set
	 */
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	/**
	 * @return  the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return  the saveName
	 */
	public String getSaveName() {
		return saveName;
	}

	/**
	 * @param saveName the saveName to set
	 */
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	/**
	 * @return  the savePath
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * @return  the fileSize
	 */
	public Long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return  the uploadTime
	 */
	public Date getUploadTime() {
		return uploadTime;
	}

	/**
	 * @param uploadTime the uploadTime to set
	 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * @return  the uploadEmp
	 */
	public String getUploadEmp() {
		return uploadEmp;
	}

	/**
	 * @param uploadEmp the uploadEmp to set
	 */
	public void setUploadEmp(String uploadEmp) {
		this.uploadEmp = uploadEmp;
	}

	/**
	 * @return  the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return  the fileId
	 */
	public Integer getFileId() {
		return fileId;
	}

	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
}
