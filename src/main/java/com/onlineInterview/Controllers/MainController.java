package com.onlineInterview.Controllers;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlineInterview.BusinessLogic.*;
import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Repositories.CandidateRepository;
@Controller
public class MainController {
	
	@Autowired
	Hr_maneger Hr_maneger ;
	@Autowired
	Candidate_manager Candidate_manager;
	@Autowired
	CandidateRepository canRepo;

	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	

	@GetMapping("/insert")
	@ResponseBody
	public String insert (HttpServletRequest req) {
		Candidate can = new Candidate("abdo", "01224788990", "mymail@demo.com", "pass", "resume");
		canRepo.save(can);
		return "added";
	}
	
	
	
	@GetMapping("/shit")
	public String test (HttpServletRequest req) {
		req.setAttribute("test", "this is from the shit url");
		return "welcome";
	}

	@GetMapping("/index")
	public String index (HttpServletRequest req) {
		return"index";
	}
	
	
	
	@GetMapping ("/login")
	public String test (@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("type")String type
			,HttpServletRequest request) {
		if(type.equals("h")) {
			boolean result = Hr_maneger.login(email, password);
			
			if (result) {
				return "mainHR";
			}
			else {
			return "index";	
			}
			
		}
		else if (type.equals("a")) {
			boolean result = Candidate_manager.login(email, password);
			
			if (result) {
				return "mainApplicant";
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
