package com.sk.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String handleLoginRequest(@RequestParam(name = "name") String name,
			@RequestParam(name = "password") String password, ModelMap model) {
		if (service.validateUser(name, password)) {
			model.put("name", name);
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials!!");
		return "login";
	}
}
