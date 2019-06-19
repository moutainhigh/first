package com.deppon.dpm.doc.server.entity;

/**
 * 滴滴城市列表信息表(DIDI_CITY) ��Ӧ��domain
 * @author guzf core 开发组
 * 2017-12-04
 */

public class DidiCityEntity {
	
    //主键
    private Integer id ;
    //城市名称
    private String name ;
    //城市ID
    private Integer cityid ;
    //是否开通专车
    private Integer openZhuanche ;
    //是否开通快车
    private Integer openKuaiche ;
    //时间
    private String ts ;
    
    /**
     * ���� 主键
     */
    public Integer getId() {
        return id ;
    }

    /**
     * ���� 城市名称
     */
    public String getName() {
        return name ;
    }

    /**
     * ���� 城市ID
     */
    public Integer getCityid() {
        return cityid ;
    }

    /**
     * ���� 是否开通专车
     */
    public Integer getOpenZhuanche() {
        return openZhuanche ;
    }

    /**
     * ���� 是否开通快车
     */
    public Integer getOpenKuaiche() {
        return openKuaiche ;
    }

    /**
     * ���� 时间
     */
    public String getTs() {
        return ts ;
    }


    /**
     * ���� 主键
     */
    public void setId(Integer id) {
        this.id = id ;
    }

    /**
     * ���� 城市名称
     */
    public void setName(String name) {
        this.name = name ;
    }

    /**
     * ���� 城市ID
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid ;
    }

    /**
     * ���� 是否开通专车
     */
    public void setOpenZhuanche(Integer openZhuanche) {
        this.openZhuanche = openZhuanche ;
    }

    /**
     * ���� 是否开通快车
     */
    public void setOpenKuaiche(Integer openKuaiche) {
        this.openKuaiche = openKuaiche ;
    }

    /**
     * ���� 时间
     */
    public void setTs(String ts) {
        this.ts = ts ;
    }

    @Override
    public String toString() {
        return " DidiCity ["
            + " id=" + id 
            + ", name=" + name 
            + ", cityid=" + cityid 
            + ", openZhuanche=" + openZhuanche 
            + ", openKuaiche=" + openKuaiche 
            + ", ts=" + ts 
            + "]" ;
    }
}