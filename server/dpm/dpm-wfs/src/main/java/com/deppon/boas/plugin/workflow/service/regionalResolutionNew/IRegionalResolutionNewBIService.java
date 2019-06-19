package com.deppon.boas.plugin.workflow.service.regionalResolutionNew;

import com.deppon.boas.bean.workflow.entity.ApprovalRecordEntity;
import com.deppon.boas.bean.workflow.entity.Result;
import com.deppon.boas.bean.workflow.entity.regionalResolutionNew.RegionalResolutionDetailDo;

import java.util.List;
import java.util.Map;

/**
 * 区域ST/AT决议上报工作流移动端接口
 *
 * @author offves
 * @since 2019/1/15 9:36
 */
public interface IRegionalResolutionNewBIService {
    /**
     * 获取流程详情信息
     *
     * @param requestId 流程 Id
     * @return
     */
    Result<RegionalResolutionDetailDo> getRegionalResolutionDetail(Integer requestId);

    /**
     * 获取审批记录信息
     *
     * @param requestId 流程 Id
     * @return
     */
    Result<List<ApprovalRecordEntity>> getRegionalResolutionApprovalLog(Integer requestId);

    /**
     * 审批流程
     *
     * @param requestId  流程 Id
     * @param workCode   审批人工号
     * @param approver   需审批人 Id, 以 ',' 分割
     * @param isDisAgree 是否是否决操作
     * @param remark     审批意见
     * @return
     */
    Result<List<Map<String, Object>>> approval(Integer requestId, String workCode, String approver, Boolean isDisAgree, String remark);

    /**
     * 退回到起草人
     *
     * @param requestId 流程 Id
     * @param workCode  审批人工号
     * @param remark    审批意见
     * @return
     */
    Result<String> reject(Integer requestId, String workCode, String remark);
}
