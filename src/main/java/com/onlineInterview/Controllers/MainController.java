package com.onlineInterview.Controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlineInterview.BusinessLogic.*;
import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Entities.Position;
import com.onlineInterview.Repositories.CandidateRepository;
@Controller
public class MainController {
	
	@Autowired
	Hr_maneger Hr_maneger ;
	@Autowired
	Candidate_manager Candidate_manager;
	@Autowired
	SystemUtility system;
	@Autowired
	CandidateRepository canRepo;

	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/positions")
	public String getPositions(HttpServletRequest request ) {
		List<Position> positions = system.getPositions();
		int length = positions.size();
		request.setAttribute("number_of_positions", length);
		for (int i = 0; i < length; i++) {
			request.setAttribute("Position"+i, positions.get(i).getPositionName());
		}
		return"positions";
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
	@GetMapping("applicants")
	public String applicants (HttpServletRequest req) {
		return "applicants";
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
