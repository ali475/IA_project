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
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String text;
	
	@ManyToOne
    @JoinColumn(name = "topic_name")
	private Topic topic;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Answer> answers;
	
	@OneToMany(mappedBy = "userQuestion", cascade = CascadeType.ALL)
	private Set<UserExamQuestion> userExamQuestions;
	
	public Question() {}

	public Question(String text, Topic topic) {
		super();
		this.text = text;
		this.topic = topic;
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Set<Answer> getQuestions() {
		return answers;
	}

	public void setQuestions(Set<Answer> answers) {
		this.answers = answers;
	}

	public Set<UserExamQuestion> getUserExamQuestions() {
		return userExamQuestions;
	}

	public void setUserExamQuestions(Set<UserExamQuestion> userExamQuestions) {
		this.userExamQuestions = userExamQuestions;
	}
	
	

}
