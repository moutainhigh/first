package com.deppon.boas.bean.workflow.entity;

import java.io.Serializable;

/**
 * @author 275067
 * @since created  on  2018/5/5.
 * Description:
 */
public class ApprovalRecordEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -76915102703902877L;

    /**
     *
     * @return
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     *
     * @return
     */
    public String getOperateDate() {
        return OperateDate;
    }

    /**
     *
     * @param operateDate
     */
    public void setOperateDate(String operateDate) {
        OperateDate = operateDate;
    }

    /**
     *
     * @return
     */
    public String getOperatorName() {
        return OperatorName;
    }

    /**
     *
     * @param operatorName
     */
    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    /**
     *
     * @return
     */
    public String getOperateType() {
        return OperateType;
    }

    /**
     *
     * @param operateType
     */
    public void setOperateType(String operateType) {
        OperateType = operateType;
    }

    /**
     *
     * @return
     */
    public String getRemark() {
        return Remark;
    }

    /**
     *
     * @param remark
     */
    public void setRemark(String remark) {
        Remark = remark;
    }

    /**
     *
     * @return
     */
    public String getOperateDuty() {
        return OperateDuty;
    }

    /**
     *
     * @param operateDuty
     */
    public void setOperateDuty(String operateDuty) {
        OperateDuty = operateDuty;
    }

    //审批时间
    private String OperateDate;
    //审批人姓名
    private String OperatorName;
    //审批类型
    private String OperateType;
    //审批意见
    private String Remark;

//  private String OperateDate;
    //审批职责
    private String OperateDuty;

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        /**
         *
         */
        return "ApprovalRecordEntity{" +
                "OperateDate='" + OperateDate + '\'' +
                ", OperatorName='" + OperatorName + '\'' +
                ", OperateType='" + OperateType + '\'' +
                ", Remark='" + Remark + '\'' +
                ", OperateDuty='" + OperateDuty + '\'' +
                '}';
    }
}
