package com.onlineInterview.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineInterview.BusinessLogic.Candidate_manager;
import com.onlineInterview.BusinessLogic.Hr_maneger;

@RestController
public class requestRestController {
	@Autowired
	Candidate_manager Candidate_manager;
	@Autowired 
	Hr_maneger Hr_maneger;
	
	
@RequestMapping("/testemail")
public String test (@RequestParam("email") String email,@RequestParam("type")String type
		,HttpServletRequest request) {
	System.out.println(email+"   	"+ type);
	if(type.equals("h")) {
		boolean result = Hr_maneger.isExests(email);
		
		if (result) {
			return "";
		}
		else {
		return "not exests";	
		}
		
	}
	else if (type.equals("a")) {
		boolean result = Candidate_manager.isExests(email);
		if (result) {
			return "";
		}
		else {
		return "not exests";	
		}
	}
	else {
		return "not exests ";
	}
}

}
