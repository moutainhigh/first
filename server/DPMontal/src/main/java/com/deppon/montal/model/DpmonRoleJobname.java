package com.deppon.montal.model;

import java.io.Serializable;

public class DpmonRoleJobname implements Serializable {

	private static final long serialVersionUID = -2061037150208794440L;

	private int id;
	
	private String jobname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
}
