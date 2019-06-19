package com.deppon.dpm.module.news.shared.domain;

/**
 * @author 046130 推送平台有字数限制
 */
public class NewsCenterEntity {

	/**
	 * 应用编号
	 */
	private String a;

	/**
	 * 推送类型<br>
	 * 0 表示我的工资条<br>
	 * 1 表示HR自助<br>
	 * 2 表示系统通知<br>
	 * 3 表示 固定资产<br>
	 * 4表示it服务台<br>
	 * 5表示我的任务<br>
	 * 6表示工作流<br>
	 * 7表示差旅助手<br>
	 */
	private int b;

	/**
	 * 是否显示小红点，0 显示，1 不显示
	 */
	private int c;

	/**
	 * 是否是消息中心， 0 是消息中心 ， 1 是应用
	 */
	private int d;

	/**
	 * 超链接
	 */
	private String e;

	/**
	 * 标题
	 */
	private String f;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getA() {
		return a;
	}

	/**
	 * set
	 * 
	 * @param a
	 */
	public void setA(String a) {
		this.a = a;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getB() {
		return b;
	}

	/**
	 * set
	 * 
	 * @param b
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getC() {
		return c;
	}

	/**
	 * set
	 * 
	 * @param c
	 */
	public void setC(int c) {
		this.c = c;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getD() {
		return d;
	}

	/**
	 * set
	 * 
	 * @param d
	 */
	public void setD(int d) {
		this.d = d;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getE() {
		return e;
	}

	/**
	 * set
	 * 
	 * @param e
	 */
	public void setE(String e) {
		this.e = e;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getF() {
		return f;
	}

	/**
	 * set
	 * 
	 * @param f
	 */
	public void setF(String f) {
		this.f = f;
	}
	
	public NewsCenterEntity() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param f
	 */
	public NewsCenterEntity(String a, int b, int c, int d, String f) {
		this(a, b, c, d, null, f);
	}

	/**
	 * Constructor
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 */
	public NewsCenterEntity(String a, int b, int c, int d, String e, String f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}

}
