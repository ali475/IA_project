package com.onlineInterview.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Repositories.CandidateRepository;

@Service
public class Candidate_manager {
	@Autowired
	private CandidateRepository candidatedb;
	
	
	public boolean login(String user_name, String password) {
		boolean result = candidatedb.existsById(user_name);
		if (result) {
			Candidate getuser = candidatedb.findById(user_name).get();
			if (getuser.getPassword().equals(password)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	
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
		return candidatedb.existsById(email);
	}

}
