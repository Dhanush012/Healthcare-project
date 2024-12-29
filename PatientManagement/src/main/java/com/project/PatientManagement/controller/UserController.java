package com.project.PatientManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.PatientManagement.model.PatientUser;
import com.project.PatientManagement.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public PatientUser adduser(@RequestBody PatientUser user) {
		return service.adduser(user);
	}
	
	@PostMapping("/login")
	public String verify(@RequestBody PatientUser user) {
		return service.verify(user);
	}
}
