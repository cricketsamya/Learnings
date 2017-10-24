package com.sk.webtry.springmvcdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private LoginService service;

	@RequestMapping(method = RequestMethod.GET, value = "/usercreate")
	public String showCreateUserPage() {
		return "usercreate";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/usercreate")
	public String handleLoginRequest(
			@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "location") String location, ModelMap model) {
		if (service.checkIfUserExists(username)) {
			model.put("errorMessage",
					"User already Exists! please change the username");
			return "usercreate";
		}
		service.createUser(name, location, username, password);
		model.put("successMessage", "User Created!");
		return "usercreate";
	}
}
