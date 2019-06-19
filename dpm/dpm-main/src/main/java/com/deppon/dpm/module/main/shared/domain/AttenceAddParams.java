package com.deppon.dpm.module.main.shared.domain;

public class AttenceAddParams {
	//请求全国打卡参数类
		/**
		 * 打卡参数
		 * @author 266021
		 * @date 2015-6-24
		 */

		//工号
		private String empcode;
		//移动端登录密码
		private String password;
		//打卡日期
		private String curdate;
		//打卡时间
		private String curtime;
		//打卡类型     0 上班     1 下班
		private String type;
		//手机序列号	 手机唯一标识
		private String mobileID;
		//打卡 IP
		private String ip;
		// 打卡心情
		private String moodScore;
		// 心情留言
		private String moodMessage;
		
		//是否前一天（Y-是；N-否）
		private String yesterday;


		/**
		 * @return the moodScore
		 */
		public String getMoodScore() {
			return moodScore;
		}
		/**
		 * @param moodScore the moodScore to set
		 */
		public void setMoodScore(String moodScore) {
			this.moodScore = moodScore;
		}
		/**
		 * @return the moodMessage
		 */
		public String getMoodMessage() {
			return moodMessage;
		}
		/**
		 * @param moodMessage the moodMessage to set
		 */
		public void setMoodMessage(String moodMessage) {
			this.moodMessage = moodMessage;
		}
		//获得工号
		public String getEmpcode() {
			return empcode;
		}
		//给工号赋值
		public void setEmpcode(String empcode) {
			this.empcode = empcode;
		}
		//获得密码
		public String getPassword() {
			return password;
		}
		//给密码赋值
		public void setPassword(String password) {
			this.password = password;
		}
		//获得打卡日期
		public String getCurdate() {
			return curdate;
		}
		//给打卡日期赋值
		public void setCurdate(String curdate) {
			this.curdate = curdate;
		}
		//获得打卡时间
		public String getCurtime() {
			return curtime;
		}
		//给打卡时间赋值
		public void setCurtime(String curtime) {
			this.curtime = curtime;
		}
		//获得打卡类型
		public String getType() {
			return type;
		}
		//给打卡类型赋值
		public void setType(String type) {
			this.type = type;
		}
		//获得手机标识
		public String getMobileID() {
			return mobileID;
		}
		//设置手机标识
		public void setMobileID(String mobileID) {
			this.mobileID = mobileID;
		}
		//获得 IP
		public String getIp() {
			return ip;
		}
		//设置 IP
		public void setIp(String ip) {
			this.ip = ip;
		}
		/**
		 * <p>Description: TODO</p>
		 * @return the yesterday
		 */
		public String getYesterday() {
			return yesterday;
		}
		/**
		 * <p>Description: TODO</p>
		 * @param yesterday the yesterday to set
		 */
		public void setYesterday(String yesterday) {
			this.yesterday = yesterday;
		}
		
		
		
	}