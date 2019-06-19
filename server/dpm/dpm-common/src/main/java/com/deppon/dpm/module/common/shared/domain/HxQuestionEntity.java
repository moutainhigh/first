package com.deppon.dpm.module.common.shared.domain;

import java.io.Serializable;

/**
 * 欢行小服务台问题实体类
 * @since 2019-04-19
 * */
public class HxQuestionEntity implements Serializable{

	private static final long serialVersionUID = -4197231043587875081L;

	//问题ID
	private int questionId;
	//问题类型
	private int questionType;
	//问题名称
	private String question;
	//答案
	private String answer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
