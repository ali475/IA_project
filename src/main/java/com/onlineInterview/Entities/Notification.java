package com.onlineInterview.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String content;
	private String userType;//sender or reciever
	
	@ManyToOne
    @JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne
    @JoinColumn(name = "hr_id")
	private Hr hr;
	
	public Notification() {}

	public Notification(String content, String userType, Candidate candidate, Hr hr) {
		super();
		this.content = content;
		this.userType = userType;
		this.candidate = candidate;
		this.hr = hr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	
}
