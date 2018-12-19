package com.onlineInterview.Controllers;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Entities.Hr;
import com.onlineInterview.Entities.Interview;
import com.onlineInterview.Repositories.CandidateRepository;
import com.onlineInterview.Repositories.HrRepository;
import com.onlineInterview.Repositories.InterviewRepository;

@Controller
public class MainController {
	
	@Autowired
	HrRepository hrRepo;
	
	@Autowired
	CandidateRepository canRepo;
	
	@Autowired
	InterviewRepository ivRepo;

	public MainController() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/shit")
	public String test (HttpServletRequest req) {
		req.setAttribute("test", "this is from the shit url");
		return "welcome";
	}
	@GetMapping("/insert")
	public HashMap<String, Object> test1(HttpServletRequest req) {
		Candidate c = new Candidate("abdo", "122", "mail--", "pass1", "cvLink", false);
		Hr hr = new Hr("ahmed fathi", "mail1", "hr_pass");
		canRepo.save(c);
		hrRepo.save(hr);
		
		Interview iv = new Interview("pending", new Date(2018, 12, 15), c, hr);
		iv.setCandidate(c);
		iv.setHr(hr);
		
		Interview iv2 = new Interview("finished", new Date(2018, 12, 15), c, hr);
		iv2.setCandidate(c);
		iv2.setHr(hr);
		
		ivRepo.save(iv);
		ivRepo.save(iv2);
		HashMap<String, Object>result = new HashMap<>() ;
		result.put("ali", "20150167");
		return result;
		
	}
	@GetMapping("/index")
	public String index (HttpServletRequest req) {
		return"index";
	}
	@GetMapping("/read")
	public void test2(HttpServletRequest req) {
		
		Candidate c1 = canRepo.findById("abdo").get();
		//Hr h1 = hrRepo.findById("ahmed fathi").get();
		System.out.println("-----------------------------------------------");
		System.out.println(c1.getUserNAme());
		System.out.println(c1.getUserNAme()+" Interviews:");
		System.out.println("IV ID : "+c1.getInterviews().iterator().next().getId());
		System.out.println("IV State : "+c1.getInterviews().iterator().next().getStateType());
		System.out.println("IV userID : "+c1.getInterviews().iterator().next().getCandidate().getUserNAme());
		
	}
	
	@GetMapping("/delete")
	public void test3(HttpServletRequest req) {
		Candidate c1 = canRepo.findById("abdo").get();
		canRepo.delete(c1);
	}
	
	
}
