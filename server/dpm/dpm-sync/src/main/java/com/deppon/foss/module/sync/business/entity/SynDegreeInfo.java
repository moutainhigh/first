package com.deppon.foss.module.sync.business.entity;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class SynDegreeInfo
    implements Serializable{

    private final static long serialVersionUID = 11082011L;
    protected String id;
    protected String degreeChangeId;
    protected String degreeCode;
    protected String degreeName;
    protected String lastModifyTime;
    protected String status;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getDegreeChangeId() {
        return degreeChangeId;
    }

    public void setDegreeChangeId(String value) {
        this.degreeChangeId = value;
    }

    public String getDegreeCode() {
        return degreeCode;
    }

    public void setDegreeCode(String value) {
        this.degreeCode = value;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String value) {
        this.degreeName = value;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String value) {
        this.lastModifyTime = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

}
