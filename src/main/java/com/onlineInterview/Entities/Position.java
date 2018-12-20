package com.onlineInterview.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Position {

	@Id
	private String positionName;
	@Column(columnDefinition="text")
	private String positionDescribtion;
	
	@OneToMany(mappedBy = "position", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Candidate> candidates;

	public Position() {}
	
	public Position(String positionName, String positionDescribtion) {
		super();
		this.positionName = positionName;
		this.positionDescribtion = positionDescribtion;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionDescribtion() {
		return positionDescribtion;
	}

	public void setPositionDescribtion(String positionDescribtion) {
		this.positionDescribtion = positionDescribtion;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	

}
