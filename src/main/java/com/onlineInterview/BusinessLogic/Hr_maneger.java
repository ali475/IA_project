package com.onlineInterview.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Hr;
import com.onlineInterview.Repositories.HrRepository;

@Service
public class Hr_maneger  {
	
	@Autowired
	HrRepository Hr_db;
	
	public Hr_maneger() {}

	public boolean login(String user_name, String password) {
		boolean test = Hr_db.existsById(user_name);
		if (test) {
			Hr getuser = Hr_db.findById(user_name).get();
			if (getuser.getPassword().equals(password))
				return true;
			else {
				return false;
			}
		}
		return false;
	}

	
	public boolean register(Hr user) {
		Hr getuser = Hr_db.findById(user.getUserName()).get();
		if (getuser==null) {
			Hr_db.save(user);
			return true ;
		}
		return false;
		
	}


	public boolean isExests(String email) {
		return  Hr_db.existsById(email);
	}
	public Hr get_Hr(String Email) {
		return Hr_db.findById(Email).get();
	}

}
