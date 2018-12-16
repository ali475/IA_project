package com.onlineInterview.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineInterview.Entities.Hr;
import com.onlineInterview.Repositories.HrRepository;
@Service
public class Hr_maneger  extends Account_Manager<Hr>{
	@Autowired
	HrRepository Hr_db;
	public boolean login(String user_name, String password) {
		Hr user = Hr_db.findById(user_name).get();
		if (user==null|| !user.getPassword().equals(password)) {
			return false ;
		}
		return true;
	}

	
	public boolean regester(Hr user) {
		Hr getuser = Hr_db.findById(user.getUserName()).get();
		if (getuser==null) {
			Hr_db.save(user);
			return true ;
		}
		return false;
		
	}

}
