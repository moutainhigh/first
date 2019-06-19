package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author 268101
 * 站点表
 *
 */
public class BusLineOfSite implements Serializable {
	/**
	 * 线路站点表主键ID
	 */
    private Integer id;

    /**
	 * 线路ID
	 */
    private Integer lineId;

    /**
	 * 站点ID
	 */
    private Integer siteId;

    /**
	 * 是否起始站点
	 */
    private Integer isStart;

    /**
	 * 是否终止站点
	 */
    private Integer isEnd;

    /**
	 * 站点顺序
	 */
    private Integer siteSort;

    /**
	 * 站点开启状态
	 */
    private Integer isAct;

    /**
	 * 备注
	 */
    private String remark;

    /**
     * @return 线路站点表主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 线路站点表主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 线路ID
     */
    public Integer getLineId() {
        return lineId;
    }

    /**
     * @param lineId 线路ID
     */
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    /**
     * @return 站点ID
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     * @param siteId 站点ID
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     * @return 是否起始站点
     */
    public Integer getIsStart() {
        return isStart;
    }

    /**
     * @param isStart 是否起始站点
     */
    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    /**
     * @return 是否终止站点
     */
    public Integer getIsEnd() {
        return isEnd;
    }

    /**
     * @param isEnd 是否终止站点
     */
    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * @return 站点顺序
     */
    public Integer getSiteSort() {
        return siteSort;
    }

    /**
     * @param siteSort 站点顺序
     */
    public void setSiteSort(Integer siteSort) {
        this.siteSort = siteSort;
    }

    public Integer getIsAct() {
        return isAct;
    }

    public void setIsAct(Integer isAct) {
        this.isAct = isAct;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}