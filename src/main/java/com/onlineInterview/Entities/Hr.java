package com.onlineInterview.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hr {

	@Id
	private String userName;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "hr", cascade = CascadeType.ALL)
	Set<Interview> interviews;
	
	
	
	public Hr() {}


	public Hr(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


	public Set<Interview> getInterviews() {
		return interviews;
	}


	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}


	

}
