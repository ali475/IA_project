package com.onlineInterview.BusinessLogic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Entities.Hr;
import com.onlineInterview.Entities.Interview;
import com.onlineInterview.Entities.UserExam;
import com.onlineInterview.Repositories.CandidateRepository;
import com.onlineInterview.Repositories.InterviewRepository;
import com.onlineInterview.Repositories.UserExamRepository;

@Service
public class HrUtility {
	
	@Autowired
	InterviewRepository ivRepo;
	
	@Autowired
	UserExamRepository usrExamRepo;
	
	@Autowired
	CandidateRepository canRepo;

	public HrUtility() {}
	
	public Interview generateInterview(String interviewState,Date deadline,Candidate candidate,Hr hr) {
		Interview newIv = new Interview(interviewState, deadline, candidate, hr);
		return ivRepo.save(newIv);
	}
	
	public UserExam generateExam(Interview iv, int order, int duration, int numOfQuestions, String examType) {
		UserExam newExam = new UserExam(iv, order, duration, numOfQuestions, examType);
		return usrExamRepo.save(newExam);
	}
	
	public void approveCandidate(Candidate candidate) {
		candidate.setApprovalState(true);
		canRepo.save(candidate);
	}
	
	public void disapproveCandidate(Candidate candidate) {
		candidate.setApprovalState(false);
		canRepo.save(candidate);
	}

}
