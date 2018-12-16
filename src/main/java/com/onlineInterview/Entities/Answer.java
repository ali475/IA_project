package com.onlineInterview.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String text;
	private boolean state;
	
	@ManyToOne
    @JoinColumn(name = "question_id")
	private Question question;
	
	@OneToMany(mappedBy = "userAnswer", cascade = CascadeType.ALL)
	private Set<UserExamQuestion> userExamQuestions;
	
	public Answer() {}

	public Answer(String text, boolean state, Question question) {
		super();
		this.text = text;
		this.state = state;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Set<UserExamQuestion> getUserExamQuestions() {
		return userExamQuestions;
	}

	public void setUserExamQuestions(Set<UserExamQuestion> userExamQuestions) {
		this.userExamQuestions = userExamQuestions;
	}
	
	

}
