package com.onlineInterview.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Entities.Hr;
import com.onlineInterview.Repositories.CandidateRepository;
import com.onlineInterview.Repositories.HrRepository;

@Service
public class AccountManager {
	
	@Autowired
	CandidateRepository candidateDb;
	
	@Autowired
	private HrRepository HrDb;

	public AccountManager() {}
	
	
	public boolean login(String userType, String userName, String password) {
		if(userType.equals("h")) {
			boolean result = HrDb.existsById(userName);
			if (result) {
				Hr hr = HrDb.findById(userName).get();
				if (hr.getPassword().equals(password)) {return true;}
				else {return false;}
			}
			return false;
		}
		else if(userType.equals("a")) {
			boolean result = candidateDb.existsById(userName);
			if (result) {
				Candidate getuser = candidateDb.findById(userName).get();
				if (getuser.getPassword().equals(password)) {return true;}
				else {return false;}
			}
			return false;
		}
		return false;
	}
	
	
	public boolean register(Candidate user) {
		if(candidateDb.existsById(user.getUserNAme())){return false;}
		if(candidateDb.existsByEmail(user.getEmail())){return false;}
		
		try {
			candidateDb.save(user);
			return true;
		}
		catch (NullPointerException e) {
			System.out.println("register problem");
			e.printStackTrace();
			return false;
		}
		
	}
	
	

}
