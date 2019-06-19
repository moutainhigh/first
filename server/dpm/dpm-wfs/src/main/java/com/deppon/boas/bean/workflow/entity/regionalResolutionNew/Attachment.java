package com.deppon.boas.bean.workflow.entity.regionalResolutionNew;

import java.io.Serializable;

/**
 * @author offves
 * @since 2019/1/15 14:15
 */
public class Attachment implements Serializable {
    private static final long   serialVersionUID = -5314433148577838678L;
    /**
     * 附件名称
     */
    private              String attachmentName;
    /**
     * 附件 fileDocId
     */
    private              String attachmentFileDocId;

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentFileDocId() {
        return attachmentFileDocId;
    }

    public void setAttachmentFileDocId(String attachmentFileDocId) {
        this.attachmentFileDocId = attachmentFileDocId;
    }
}
