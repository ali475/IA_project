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
import javax.persistence.OneToOne;

@Entity
public class UserExam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "iv_id")
	private Interview iv;
	
	private int duration;
	private int numOfQuestions;
	private float totalScore;
	private String examType;
	@OneToOne
	@JoinColumn(name = "pre_id")
	private UserExam pre_exam;
	
	@OneToMany(mappedBy = "userExam", cascade = CascadeType.ALL)
	private Set<UserExamQuestion> userExamQuestions;
	
	public UserExam() {}

	public UserExam(Interview iv, int duration, int numOfQuestions, float totalScore, String examType, UserExam pre) {
		super();
		this.iv = iv;
		this.duration = duration;
		this.numOfQuestions = numOfQuestions;
		this.totalScore = totalScore;
		this.examType = examType;
		pre_exam= pre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Interview getIv() {
		return iv;
	}

	public void setIv(Interview iv) {
		this.iv = iv;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNumOfQuestions() {
		return numOfQuestions;
	}

	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}

	public float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}


	public Set<UserExamQuestion> getUserExamQuestions() {
		return userExamQuestions;
	}

	public void setUserExamQuestions(Set<UserExamQuestion> userExamQuestions) {
		this.userExamQuestions = userExamQuestions;
	}
	
	

}
