package com.deppon.boas.bean.workflow.entity.regionalResolutionNew;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author offves
 * @since 2019/1/15 10:05
 */
public class RegionalResolutionDetailDo implements Serializable {
    private static final long                      serialVersionUID = 4309237926791644276L;
    /**
     * 流程 id
     */
    private              Integer                   requestId;
    /**
     * 流程编号
     */
    private              String                    flowNumer;
    /**
     * 申请人 id
     */
    private              Integer                   applyId;
    /**
     * 申请人工号
     */
    private              String                    applyCode;
    /**
     * 申请人姓名
     */
    private              String                    applyName;
    /**
     * 申请人部门 id
     */
    private              Integer                   applyDeptId;
    /**
     * 申请人部门名称
     */
    private              String                    applyDeptName;
    /**
     * 议题类型(ST/AT)
     */
    private              String                    issueType;
    /**
     * 会议名称
     */
    private              String                    conferenceTitle;
    /**
     * 所属事业部 id
     */
    private              Integer                   businessDeptId;
    /**
     * 所属事业部名称
     */
    private              String                    businessDeptName;
    /**
     * 申请事由
     */
    private              String                    applyReason;
    /**
     * 起草附件
     */
    private              List<Attachment>          attachments;
    /**
     * 审批意见附件
     */
    private              List<Attachment>          opinionAttachments;
    /**
     * 起草时间
     */
    private              String                    createTime;
    /**
     * 工作流名称
     */
    private              String                    workflowName;
    /**
     * 需审批人
     */
    private              List<Map<String, Object>> approver;
    /**
     * 当前节点名称
     */
    private              String                    currentNodeName;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getFlowNumer() {
        return flowNumer;
    }

    public void setFlowNumer(String flowNumer) {
        this.flowNumer = flowNumer;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Integer getApplyDeptId() {
        return applyDeptId;
    }

    public void setApplyDeptId(Integer applyDeptId) {
        this.applyDeptId = applyDeptId;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public Integer getBusinessDeptId() {
        return businessDeptId;
    }

    public void setBusinessDeptId(Integer businessDeptId) {
        this.businessDeptId = businessDeptId;
    }

    public String getBusinessDeptName() {
        return businessDeptName;
    }

    public void setBusinessDeptName(String businessDeptName) {
        this.businessDeptName = businessDeptName;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Attachment> getOpinionAttachments() {
        return opinionAttachments;
    }

    public void setOpinionAttachments(List<Attachment> opinionAttachments) {
        this.opinionAttachments = opinionAttachments;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public List<Map<String, Object>> getApprover() {
        return approver;
    }

    public void setApprover(List<Map<String, Object>> approver) {
        this.approver = approver;
    }

    public String getCurrentNodeName() {
        return currentNodeName;
    }

    public void setCurrentNodeName(String currentNodeName) {
        this.currentNodeName = currentNodeName;
    }
}
