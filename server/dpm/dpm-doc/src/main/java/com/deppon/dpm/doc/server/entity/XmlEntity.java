package com.deppon.dpm.doc.server.entity;

/**
 * com.deppon.ump.api.demo.dto
 *
 * @auth zhh
 * @created 2018/9/17
 */
public class XmlEntity {
    private String url;
    private ClientMessEntity clientMessEntity;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ClientMessEntity getClientMessEntity() {
        return clientMessEntity;
    }

    public void setClientMessEntity(ClientMessEntity clientMessEntity) {
        this.clientMessEntity = clientMessEntity;
    }
}
