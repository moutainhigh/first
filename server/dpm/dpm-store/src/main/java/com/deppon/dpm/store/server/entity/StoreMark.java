package com.deppon.dpm.store.server.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.deppon.dpm.store.server.vo.LabelVo;

/**
 * 模块打分表实体类
 * @author XiaoTian
 *
 */
public class StoreMark {
	/**
	 * 模块打分id
	 */
    private Integer markid;
    /**
	 * 分数
	 */
    private BigDecimal grade;
    /**
	 * 说明
	 */
    private String markinfo;
    /**
	 * 照片地址
	 */
    private String photo;
    /**
	 * 标签
	 */
    private String label;
    
    /**
     * 执行id
     */
    private Long exeid;
    
    /**
     * 模块名称
     */
    private Integer modid;
    /**
     * 接收传入数组
     */
    private List<LabelVo> arraylabel;
	/**
	 * 接收入图片数组
	 */
    private String[] arrayphoto;
    /**
     * 自定义记录状态 
     */
    private Integer dr;
    /**
     * 自定义时间
     */
    private Date ts;
    /**
     * 说明
     */
    private String modinfo;
    /**
     * 自定义项
     */
    private CustomNape customNape;
    
   /**
     * 
     * @return
     */
    public CustomNape getCustomNape() {
		return customNape;
	}
    /**
     * secondmodname
     */
    private String secondmodname;
    /**
     * checkGarde
     */
    private Integer checkGarde;
    /**
     * firstmodid
     */
    private Integer  firstmodid;
    /**
     * 
     * @param customNape
     */
	public void setCustomNape(CustomNape customNape) {
		this.customNape = customNape;
	}
	/**
	 * firstmodname
	 */
	private String firstmodname;
	/**
	 * 
	 * @return
	 */
	public Integer getMarkid() {
		return markid;
	}
	/**
	 * 
	 * @param markid
	 */
	public void setMarkid(Integer markid) {
		this.markid = markid;
	}
	/**
     * 
     * @return
     */
    public BigDecimal getGrade() {
		return grade;
	}
    /**
     * 
     * @param grade
     */
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	/**
     * 
     * @return
     */
    public String getMarkinfo() {
        return markinfo;
    }
    /**
     * 
     * @param markinfo
     */
    public void setMarkinfo(String markinfo) {
        this.markinfo = markinfo == null ? null : markinfo.trim();
    }
    /**
     * 
     * @return
     */
    public String getPhoto() {
        return photo;
    }
    /**
     * 
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
    /**
     * 
     * @return
     */
    public String getLabel() {
        return label;
    }
    /**
     * 
     * @param label
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
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
	public String[] getArrayphoto() {
		return arrayphoto;
	}
	/**
	 * 
	 * @param arrayphoto
	 */
	public void setArrayphoto(String[] arrayphoto) {
		this.arrayphoto = arrayphoto;
	}
	/**
	 * 
	 * @return
	 */
	public List<LabelVo> getArraylabel() {
		return arraylabel;
	}
	/**
	 * 
	 * @param arraylabel
	 */
	public void setArraylabel(List<LabelVo> arraylabel) {
		this.arraylabel = arraylabel;
	}
	/**
	 * 
	 * @return
	 */
	public Long getExeid() {
		return exeid;
	}
	/**
	 * 
	 * @param exeid
	 */
	public void setExeid(Long exeid) {
		this.exeid = exeid;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getModid() {
		return modid;
	}
	/**
	 * 
	 * @param modid
	 */
	public void setModid(Integer modid) {
		this.modid = modid;
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
	public String getSecondmodname() {
		return secondmodname;
	}
	public void setSecondmodname(String secondmodname) {
		this.secondmodname = secondmodname;
	}
	public Integer getCheckGarde() {
		return checkGarde;
	}
	public void setCheckGarde(Integer checkGarde) {
		this.checkGarde = checkGarde;
	}
	public Integer getFirstmodid() {
		return firstmodid;
	}
	public void setFirstmodid(Integer firstmodid) {
		this.firstmodid = firstmodid;
	}
	/**
	 * 
	 * @return
	 */
	public String getModinfo() {
		return modinfo;
	}
	/**
	 * 
	 * @param modinfo
	 */
	public void setModinfo(String modinfo) {
		this.modinfo = modinfo;
	}
	public String getFirstmodname() {
		return firstmodname;
	}
	public void setFirstmodname(String firstmodname) {
		this.firstmodname = firstmodname;
	}
	
	
}