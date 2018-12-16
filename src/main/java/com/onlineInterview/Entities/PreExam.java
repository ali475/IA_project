package com.onlineInterview.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PreExam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "exam_id")
	private UserExam exam;
	
	@ManyToOne
    @JoinColumn(name = "preExam_id")
	private UserExam preExam;
	
	private boolean doneOrNot;
	
	public PreExam() {}

	public PreExam(UserExam exam, UserExam preExam, boolean doneOrNot) {
		super();
		this.exam = exam;
		this.preExam = preExam;
		this.doneOrNot = doneOrNot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserExam getExam() {
		return exam;
	}

	public void setExam(UserExam exam) {
		this.exam = exam;
	}

	public UserExam getPreExam() {
		return preExam;
	}

	public void setPreExam(UserExam preExam) {
		this.preExam = preExam;
	}

	public boolean isDoneOrNot() {
		return doneOrNot;
	}

	public void setDoneOrNot(boolean doneOrNot) {
		this.doneOrNot = doneOrNot;
	}
	
	

}
