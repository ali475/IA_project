package com.onlineInterview.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserExamQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private float questionMark;
	
	@ManyToOne
    @JoinColumn(name = "userExam_id")
	private UserExam userExam;
	
	@ManyToOne
    @JoinColumn(name = "question_id")
	private Question userQuestion;
	private String state;
	
	public UserExamQuestion() {}

	public UserExamQuestion(UserExam userExam, Question userQuestion,String state) {
		super();
		this.userExam = userExam;
		this.userQuestion = userQuestion;
		this.state = state;
	}
	
	public Question getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(Question userQuestion) {
		this.userQuestion = userQuestion;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(float questionMark) {
		this.questionMark = questionMark;
	}

	public UserExam getUserExam() {
		return userExam;
	}

	public void setUserExam(UserExam userExam) {
		this.userExam = userExam;
	}

	public Question getQuestion() {
		return userQuestion;
	}

	public void setQuestion(Question question) {
		this.userQuestion = question;
	}

	
	

}
