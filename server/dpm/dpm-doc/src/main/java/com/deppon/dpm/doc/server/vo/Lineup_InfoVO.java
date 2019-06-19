package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

/**
 * 滴滴排队信息VO
 * @author guzf
 *
 */
public class Lineup_InfoVO implements Serializable {

	/**
	 * 构造方法 
	 */
	public Lineup_InfoVO(){
		super();
	}
	
	private static final long serialVersionUID = 1L;
	//当前在队列里的位置
	private int ranking;
	//队列总长度
	private int queue_length;
	//预估需要等待的时间(秒)
	private int wait_time;
//	public int getRanking() {
//		return ranking;
//	}
//	public void setRanking(int ranking) {
//		this.ranking = ranking;
//	}
//	public int getQueue_length() {
//		return queue_length;
//	}
//	public void setQueue_length(int queue_length) {
//		this.queue_length = queue_length;
//	}
//	public int getWait_time() {
//		return wait_time;
//	}
//	public void setWait_time(int wait_time) {
//		this.wait_time = wait_time;
//	}
	/**
	 * @return the ranking
	 */
	public int getRanking() {
		return ranking;
	}
	/**
	 * @param ranking the ranking to set
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	/**
	 * @return the queue_length
	 */
	public int getQueue_length() {
		return queue_length;
	}
	/**
	 * @param queue_length the queue_length to set
	 */
	public void setQueue_length(int queue_length) {
		this.queue_length = queue_length;
	}
	/**
	 * @return the wait_time
	 */
	public int getWait_time() {
		return wait_time;
	}
	/**
	 * @param wait_time the wait_time to set
	 */
	public void setWait_time(int wait_time) {
		this.wait_time = wait_time;
	}
	
	
}
