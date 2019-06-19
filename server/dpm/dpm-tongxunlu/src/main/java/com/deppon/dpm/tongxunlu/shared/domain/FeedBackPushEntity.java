package com.deppon.dpm.tongxunlu.shared.domain;

/**
 * Created by deppon on 05/08/2017.
 * 将用户反馈的信息推送给指定处理人
 */
public class FeedBackPushEntity {

    /**
     * 用户反馈信息的id
     */
    private String id;

    /**
     * 该反馈信息对应的处理者，即推送对象的工号
     */
    private String excEmpCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExcEmpCode() {
        return excEmpCode;
    }

    public void setExcEmpCode(String excEmpCode) {
        this.excEmpCode = excEmpCode;
    }

    @Override
    public String toString() {
        return "FeedBackPushEntity{" +
                "id='" + id + '\'' +
                ", excEmpCode='" + excEmpCode + '\'' +
                '}';
    }
}
