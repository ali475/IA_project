package com.onlineInterview.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@OneToMany(mappedBy = "userQuestion", cascade = CascadeType.ALL)
	private Set<UserExamQuestion> userExamQuestions;
	@Column(columnDefinition="text")
	private String correct_answers;
	@Column(columnDefinition="text")
	private String wrong_answers;
	
	
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


	public Set<UserExamQuestion> getUserExamQuestions() {
		return userExamQuestions;
	}

	public void setUserExamQuestions(Set<UserExamQuestion> userExamQuestions) {
		this.userExamQuestions = userExamQuestions;
	}

	public String[] getCorrect_answers() {
		return correct_answers.split("|");
	}

	public void setCorrect_answers(String correct_answers) {
		this.correct_answers = correct_answers;
	}

	public String[] getWrong_answers() {
		String [] result = wrong_answers.split("|");
		return result;
	}

	public void setWrong_answers(String wrong_answers) {
		this.wrong_answers = wrong_answers;
	}
	
	

}
