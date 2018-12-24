package com.onlineInterview.Controllers;

import java.io.IOException;
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
import com.onlineInterview.Entities.Position;
import com.onlineInterview.Repositories.CandidateRepository;
import com.onlineInterview.Repositories.PositionRepository;

@Controller
public class MainController {

	@Autowired
	SystemUtility system;

	@Autowired
	CandidateRepository canRepo;

	@Autowired
	PositionRepository posRepo;

	@Autowired
	AccountManager acc;

	public MainController() {
	}

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
					return "redirect:/mainHR";
				}
				return "redirect:/index";
			} else if (type.equals("a")) {
				boolean result = acc.login(type, email, password);
				if (result) {
					return "redirect:/mainApplicant";
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
			System.out.println(email);
			Candidate user = new Candidate(username, phone, email, password, null);
			if (!acc.register(user)) {
				return "register";
			}
			return "redirect:/index";

		} catch (NullPointerException e) {
			return "redirect:/register";
		}

	}

	@GetMapping("/mainApplicant")
	public String getPositions(HttpServletRequest request) {
		List<Position> positions = system.getPositions();
		request.setAttribute("positions", positions);
		return "mainApplicant";
	}

	@GetMapping("/apply")
	public String applyPage(HttpServletRequest request) {
		String pName = request.getParameter("pName");
		Position pos = system.getPositionByName(pName);
		request.setAttribute("position", pos);

		return "apply";
	}

	@PostMapping("/upload")
	@ResponseBody
	public String cv(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		String fileName = (String) request.getParameter("cv");
		

		return "uploaded";
	}

	@GetMapping("/insert")
	@ResponseBody
	public String insert(HttpServletRequest req) {

		Object usrObj = new Candidate("abdo", "01224788990", "mymail@demo.com", "pass", "resume");
		canRepo.save((Candidate) usrObj);
		Position pos = new Position("Java Developer", "java,oop,spring");
		posRepo.save(pos);
		Position pos1 = new Position("PHP Developer", "Php,oop,larvel");
		posRepo.save(pos1);
		return "added";
	}

	@GetMapping("/shit")
	public String test(HttpServletRequest req) {
		req.setAttribute("test", "this is from the shit url");
		return "welcome";
	}

	@GetMapping("applicants")
	public String applicants(HttpServletRequest req) {
		return "applicants";
	}

}
