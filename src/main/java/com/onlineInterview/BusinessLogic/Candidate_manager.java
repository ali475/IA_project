package com.onlineInterview.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Repositories.CandidateRepository;

@Service
public class Candidate_manager extends Account_Manager<Candidate>{
	@Autowired
	private CandidateRepository candidatedb;
	
	@Override
	public boolean login(String user_name, String password) {
		Candidate user = candidatedb.findById(user_name).get();
		if (user==null|| !user.getPassword().equals(password)) {
			return false ;
		}
		
		return true;
	}

	@Override
	public boolean register(Candidate user) {
		Candidate getuser = candidatedb.findById(user.getUserNAme()).get();
		if (getuser==null) {
			candidatedb.save(user);
			return true ;
		}
		return false;
	}

	public boolean isExests(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
