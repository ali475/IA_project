package com.onlineInterview.Entities;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String stateType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
	private Date deadline;
	
	@ManyToOne
    @JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne
    @JoinColumn(name = "hr_id")
	private Hr hr;
	
	@OneToMany(mappedBy = "iv", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Set<UserExam> userExams;
	
	public Interview() {}

	public Interview(String stateType,Date deadline, Candidate candidate, Hr hr) {
		super();
		this.stateType = stateType;
		this.deadline = deadline;
		this.candidate = candidate;
		this.hr = hr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateType() {
		return stateType;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Hr getHr() {
		return hr;
	}

	public void setHr(Hr hr) {
		this.hr = hr;
	}

	//public Set<UserExam> getUserExams() {
		//return userExams;
	//}

	//public void setUserExams(Set<UserExam> userExams) {
	//	this.userExams = userExams;
	//}
	
	
	

}
