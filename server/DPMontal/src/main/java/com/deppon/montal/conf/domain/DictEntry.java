package com.deppon.montal.conf.domain;

import java.io.Serializable;

public class DictEntry implements Serializable,Comparable<DictEntry>
{
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String dicttypeid;
	private String dictid;
	private String dictname;
	private int rank;
	private String seqno;
	private Integer sortno;
	
	public Integer getSortno() {
		return sortno;
	}
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	public String getDicttypeid() {
		return dicttypeid;
	}
	public void setDicttypeid(String dicttypeid) {
		this.dicttypeid = dicttypeid;
	}
	public String getDictid() {
		return dictid;
	}
	public void setDictid(String dictid) {
		this.dictid = dictid;
	}
	public String getDictname() {
		return dictname;
	}
	public void setDictname(String dictname) {
		this.dictname = dictname;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	@Override
	public int compareTo(DictEntry o) {
		return this.getSortno().compareTo(o.getSortno());
	}
}
