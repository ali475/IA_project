package com.onlineInterview.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {

	@Id
	private String topicName;
	
	private String examType;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Question> questions;
	
	public Topic() {}

	public Topic(String topicName, String examType) {
		super();
		this.topicName = topicName;
		this.examType = examType;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	

}
