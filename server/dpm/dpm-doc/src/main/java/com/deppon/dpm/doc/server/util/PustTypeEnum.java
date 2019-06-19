package com.deppon.dpm.doc.server.util;

public enum PustTypeEnum {

    ONLY(1),     //只发微信
    FAILSMS(2);  //失败后转发短信

    PustTypeEnum(int type) {
        this.type = type;
    }

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
