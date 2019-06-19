package com.deppon.dpm.tongxunlu.shared.vo;

import java.util.List;

public class CIDBook {
	
	private List<Long> number;

	private List<String> labels;

	public CIDBook() {
		super();
	}

	public CIDBook(List<Long> number, List<String> labels) {
		super();
		this.number = number;
		this.labels = labels;
	}

	public List<Long> getNumber() {
		return number;
	}

	public void setNumber(List<Long> number) {
		this.number = number;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
}