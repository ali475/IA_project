package com.onlineInterview.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidate {
	
	@Id
	private String userNAme;
	
	private String phoneNumber;
	private String email;
	private String password;
	
	@Column(columnDefinition="text")
	private String cv;
	
	private boolean approvalState;
	
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Set<Interview> interviews;
	
	@ManyToOne
    @JoinColumn(name = "pos_name")
	private Position position;


	public Candidate() {}
	
	public Candidate(String userNAme, String phoneNumber, String email, String password, String cv){
		super();
		this.userNAme = userNAme;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.cv = cv;
	}


	public String getUserNAme() {
		return userNAme;
	}

	public void setUserNAme(String userNAme) {
		this.userNAme = userNAme;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	
	public boolean isApprovalState() {
		return approvalState;
	}

	public void setApprovalState(boolean approvalState) {
		this.approvalState = approvalState;
	}

	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}


	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	

}
