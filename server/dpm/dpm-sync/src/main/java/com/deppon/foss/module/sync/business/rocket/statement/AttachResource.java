package com.deppon.foss.module.sync.business.rocket.statement;

import com.deppon.foss.framework.entity.BaseEntity;

public class AttachResource extends BaseEntity {


	  private static final long serialVersionUID = -8029186543648898355L;
	  private String id;

	  // 附件关联外键id
	  private String attachguid;

	  // 附件的名称
	  private String attachname;

	  // 附件的类型
	  private String attachtype;

	  // 附件的路径
	  private String attachpath;

	  // 附件的大小
	  private String attachsize;

	  // 扩展字段1-存放工作流编码-200984
	  private String extra1;

	  @Override
	  public String getId() {
	    return id;
	  }

	  @Override
	  public void setId(String id) {
	    this.id = id;
	  }

	  public String getAttachguid() {
	    return attachguid;
	  }

	  public void setAttachguid(String attachguid) {
	    this.attachguid = attachguid;
	  }

	  public String getAttachname() {
	    return attachname;
	  }

	  public void setAttachname(String attachname) {
	    this.attachname = attachname;
	  }

	  public String getAttachtype() {
	    return attachtype;
	  }

	  public void setAttachtype(String attachtype) {
	    this.attachtype = attachtype;
	  }

	  public String getAttachpath() {
	    return attachpath;
	  }

	  public void setAttachpath(String attachpath) {
	    this.attachpath = attachpath;
	  }

	  public String getAttachsize() {
	    return attachsize;
	  }

	  public void setAttachsize(String attachsize) {
	    this.attachsize = attachsize;
	  }

	  public String getExtra1() {
	    return extra1;
	  }

	  public void setExtra1(String extra1) {
	    this.extra1 = extra1;
	  }
	}