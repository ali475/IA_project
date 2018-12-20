package com.onlineInterview.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Position {

	@Id
	private String positionName;
	
	private String positionDescribtion;
	
	@OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
	private Set<Candidate> candidates;

	public Position(String positionName, String positionDescribtion) {
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
