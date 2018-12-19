package com.onlineInterview.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class requestRestController {
@RequestMapping("/test")
public boolean test (HttpServletRequest request) {
	return false;
}
}
