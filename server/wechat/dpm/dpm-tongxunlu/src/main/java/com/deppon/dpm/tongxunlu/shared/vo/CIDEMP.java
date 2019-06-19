package com.deppon.dpm.tongxunlu.shared.vo;

public class CIDEMP implements Comparable<CIDEMP> {
	private long mobileNo;

	private String empname;

	private String orgname;

	public CIDEMP() {
		super();
	}

	public CIDEMP(long mobileNo, String empname, String orgname) {
		super();
		this.mobileNo = mobileNo;
		this.empname = empname;
		this.orgname = orgname;
	}

	@Override
	public int compareTo(CIDEMP other) {
		if (other.getMobileNo() > this.mobileNo) {
			return -1;
		} else if (other.getMobileNo() < this.mobileNo) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CIDEMP other = (CIDEMP) obj;
		if (mobileNo != other.mobileNo)
			return false;
		return true;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

}