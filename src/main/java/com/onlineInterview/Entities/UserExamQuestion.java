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
	
	private boolean questionMark;
	
	@ManyToOne
    @JoinColumn(name = "userExam_id")
	private UserExam userExam;
	
	@ManyToOne
    @JoinColumn(name = "question_id")
	private Question userQuestion;
	
	
	public UserExamQuestion() {}

	public UserExamQuestion(UserExam userExam, Question userQuestion) {
		super();
		this.userExam = userExam;
		this.userQuestion = userQuestion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(boolean questionMark) {
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
