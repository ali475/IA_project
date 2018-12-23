package com.onlineInterview.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	public MainController() {}
	
	@GetMapping("/")
	public String mainUrl(HttpServletRequest request ) {
		HttpSession userSession = system.getUserSession(request);
		if(userSession==null) {return "redirect:/index";}
		else {
			String userType = (String) userSession.getAttribute("userType");
			if(userType.equals("hr")) {return "redirect:/mainHR";}
			return "redirect:/mainApplicant";
		}
	}
	
	
	@GetMapping ("/login")
	public String loginRequest(HttpServletRequest request) {
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String type = request.getParameter("type");
			
			if(type.equals("h")) {
				boolean result = Hr_maneger.login(email, password);
				if(result) {return "redirect:/mainHR";}
				return "redirect:/index";
			}
			else if(type.equals("a")) {
				boolean result = Candidate_manager.login(email, password);
				if(result) {return "redirect:/mainApplicant";}
				return "redirect:/index";
			}
			else {return "redirect:/index";}
		} 
		catch (NullPointerException e) {return "redirect:/index";}
		
	}

	
	
	@GetMapping("/positions")
	public void getPositions(HttpServletRequest request, HttpServletResponse response) {
		List<Position> positions = system.getPositions();
		RequestDispatcher rd = request.getRequestDispatcher("mainApplicant");
		request.setAttribute("positions", positions);
		try {rd.forward(request, response);} 
		catch (ServletException | IOException e) {e.printStackTrace();}
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
	
	
	
		
	
	
}
