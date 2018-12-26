package com.onlineInterview.Controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlineInterview.BusinessLogic.*;
import com.onlineInterview.Entities.Candidate;
import com.onlineInterview.Entities.Hr;
import com.onlineInterview.Entities.Interview;
import com.onlineInterview.Entities.Position;
import com.onlineInterview.Entities.Question;
import com.onlineInterview.Entities.Topic;
import com.onlineInterview.Entities.UserExam;
import com.onlineInterview.Entities.UserExamQuestion;
import com.onlineInterview.Repositories.CandidateRepository;
import com.onlineInterview.Repositories.HrRepository;
import com.onlineInterview.Repositories.InterviewRepository;
import com.onlineInterview.Repositories.PositionRepository;
import com.onlineInterview.Repositories.QuestionRepository;
import com.onlineInterview.Repositories.TopicRepository;
import com.onlineInterview.Repositories.UserExamQuestionRepository;
import com.onlineInterview.Repositories.UserExamRepository;

@Controller
public class MainController {

	@Autowired
	SystemUtility system;

	@Autowired
	CandidateRepository canRepo;
	
	@Autowired
	HrRepository hrRepo;

	@Autowired
	PositionRepository posRepo;
	
	@Autowired
	QuestionRepository QRepo;
	@Autowired
	TopicRepository TRepo;
	@Autowired
	UserExamRepository UERepo;
	@Autowired
	UserExamQuestionRepository UEQRepo;
	@Autowired
	InterviewRepository IVRepo;

	@Autowired
	AccountManager acc;

	public MainController() {}

	@GetMapping("/")
	public String mainUrl(HttpServletRequest request) {
		HttpSession userSession = system.getUserSession(request);
		if (userSession == null) {
			return "redirect:/index";
		} else {
			String userType = (String) userSession.getAttribute("userType");
			if (userType.equals("hr")) {
				return "redirect:/mainHR";
			}
			return "redirect:/mainApplicant";
		}
	}

	@GetMapping("/index")
	public String index(HttpServletRequest req) {
		return "index";
	}

	@GetMapping("/login")
	public String loginRequest(HttpServletRequest request) {

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String type = request.getParameter("type");

			if (type.equals("h")) {
				boolean result = acc.login(type, email, password);
				if (result) {
					request.getSession().setAttribute("userName", email);
					request.getSession().setAttribute("userType", type);
					return "redirect:/home";
				}
				return "redirect:/index";
			} else if (type.equals("a")) {
				boolean result = acc.login(type, email, password);
				if (result) {
					request.getSession().setAttribute("userName", email);
					request.getSession().setAttribute("userType", type);
					return "redirect:/home";
				}
				return "redirect:/index";
			} else {
				return "redirect:/index";
			}
		} catch (NullPointerException e) {
			return "redirect:/index";
		}

	}

	@GetMapping("/register")
	public String registerPage(HttpServletRequest request) {
		return "register";
	}

	@PostMapping("/register")
	public String registerRequest(HttpServletRequest request) {
		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			Candidate user = new Candidate(username, phone, email, password, null);
			if (!acc.register(user)) {return "register";}
			return "redirect:/index";
		} 
		catch (NullPointerException e) {return "redirect:/register";}
	}

	@GetMapping("/home")
	public String getPositions(HttpServletRequest request) {
		HttpSession session = request.getSession(false); 
		if(session==null) {return "redirect:/index";}
		else {
			List<Position> positions = system.getPositions();
			request.setAttribute("positions", positions);
			String userType = (String) session.getAttribute("userType");
			if(userType.equals("a")) {return "mainApplicant";}
			else if(userType.equals("h")) {return "mainHR";}
			else {return "redirect:/index";}
		}
	}

	@GetMapping("/apply")
	public String applyPage(HttpServletRequest request) {
		String pName = request.getParameter("pName");
		Position pos = system.getPositionByName(pName);
		request.setAttribute("position", pos);

		return "apply";
	}
	
	@GetMapping("/candidates")
	public String shit(HttpServletRequest request) {
		String pName = request.getParameter("pName");
		List<Candidate> cans = system.getPositionApplicants(pName);
		request.setAttribute("applicants", cans);
		return "applicants";
		
	}


	@PostMapping("/upload")
	@ResponseBody
	public String cv(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		String fileName = request.getParameter("cv");
		File f = new File(fileName);
		//need to update that candidant`s cv by file "f"
		System.out.println(fileName);
		
		return "uploaded";
	}

	@GetMapping("/insert")
	@ResponseBody
	public String insert(HttpServletRequest req) {
		
		Position pos1 = new Position("Java Developer", "java,oop,spring");
		Position pos2 = new Position("PHP Developer", "Php,oop,larvel");
		posRepo.save(pos1);
		posRepo.save(pos2);

		//File f = new File("C:\\Users\\Ali\\Downloads\\PN.pdf");
		Candidate can = new Candidate("abdo", "01224788990", "mymail@demo.com", "1234", null);
		can.setPosition(pos1);
		canRepo.save(can);
		
		Candidate can2 = new Candidate("khaled", "01224788990", "mymail2@demo.com", "1234", null);
		can2.setPosition(pos1);
		canRepo.save(can2);
		
		Hr hr = new Hr("ali", "mymail1@demo.com", "1234");
		hrRepo.save(hr);
		
		Interview IV = new Interview("?", new Date(0), can, hr);
		IVRepo.save(IV);
		
		UserExam UE1 = new UserExam(IV, 1, 4, "Java");
		UserExam UE2 = new UserExam(IV, 1, 4, "PHP");
		UERepo.save(UE1);
		UERepo.save(UE2);
		
		
		Topic T1 = new Topic("OOP", "Java");
		Topic T2 = new Topic("DB", "Java");
		Topic T3 = new Topic("Connections", "PHP");
		Topic T4 = new Topic("Basics", "PHP");
		TRepo.save(T1);
		TRepo.save(T2);
		TRepo.save(T3);
		TRepo.save(T4);
		
		Question Q1 = new Question("Question1J", T1);
		Question Q2 = new Question("Question2J", T2);
		Question Q3 = new Question("Question1P", T3);
		Question Q4 = new Question("Question2P", T4);
		Q1.setCorrect_answers("1#2");
		Q2.setCorrect_answers("1#2");
		Q3.setCorrect_answers("1#2");
		Q4.setCorrect_answers("1#2");
		Q1.setWrong_answers("3#4#5#6#7");
		Q2.setWrong_answers("3#4#5#6#7");
		Q3.setWrong_answers("3#4#5#6#7");
		Q4.setWrong_answers("3#4#5#6#7");

		QRepo.save(Q1);
		QRepo.save(Q2);
		QRepo.save(Q3);
		QRepo.save(Q4);
		
		UserExamQuestion UEQ1 = new UserExamQuestion(UE1, Q1);
		UserExamQuestion UEQ2 = new UserExamQuestion(UE1, Q2);
		UserExamQuestion UEQ3 = new UserExamQuestion(UE2, Q3);
		UserExamQuestion UEQ4 = new UserExamQuestion(UE2, Q4);
		UEQRepo.save(UEQ1);
		UEQRepo.save(UEQ2);
		UEQRepo.save(UEQ3);
		UEQRepo.save(UEQ4);

		return "added";
	}


	@GetMapping("applicants")
	public String applicants(HttpServletRequest req) {
		return "applicants";
	}

}
