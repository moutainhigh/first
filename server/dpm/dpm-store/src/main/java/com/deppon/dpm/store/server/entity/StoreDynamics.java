package com.deppon.dpm.store.server.entity;

import java.util.Date;

/**
 * 动态表实体类
 * @author XiaoTian
 *
 */
public class StoreDynamics {
    /**
     * id
     */
    private Integer id;
    /**
     * 任务id
     */
    private Integer taskid;
    /**
     * 名字
     */
    private String name;
    /**
     * 内容
     */
    private String info;
    /**
     * 时间
     */
    private Date dynamicstime;
    /**
     * 类型
     */
    private String dynamicstype;
    /**
     * 自定义记录状态
     */
    private Integer dr;
    /**
     * 自定义时间
     */
    private Date ts;
    /**
     * 自定义项
     */
    private CustomNape customNape;
    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
    /**
     * 
     * @return
     */
    public Integer getTaskid() {
		return taskid;
	}
    /**
     * 
     * @param taskid
     */
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	/**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @return
     */
    public String getInfo() {
        return info;
    }

    /**
     *
     * @param info
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     *
     * @return
     */
    

    /**
     *
     * @return
     */
    public String getDynamicstype() {
        return dynamicstype;
    }

    /**
     *
     * @param dynamicstype
     */
    public void setDynamicstype(String dynamicstype) {
        this.dynamicstype = dynamicstype == null ? null : dynamicstype.trim();
    }

    /**
     *
     * @return
     */
    public Integer getDr() {
        return dr;
    }

    /**
     *
     * @param dr
     */
    public void setDr(Integer dr) {
        this.dr = dr;
    }

    /**
     * 
     * @return
     */
    public Date getTs() {
		return ts;
	}
    /**
     * 
     * @param ts
     */
	public void setTs(Date ts) {
		this.ts = ts;
	}

	/**
     * 
     * @return
     */
	public CustomNape getCustomNape() {
		return customNape;
	}
	/**
	 * 
	 * @param customNape
	 */
	public void setCustomNape(CustomNape customNape) {
		this.customNape = customNape;
	}

	public Date getDynamicstime() {
		return dynamicstime;
	}

	public void setDynamicstime(Date dynamicstime) {
		this.dynamicstime = dynamicstime;
	}
    
}