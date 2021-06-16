package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Registration;
import com.example.exception.RegistrationException;
import com.example.service.RegistrationServiceImpl;


@RestController
@RequestMapping("/registration")
public class RegistartionController {
	
	@Autowired(required = true)
	RegistrationServiceImpl registrationServiceImpl;

	
	
	@PostMapping("/UserRegistration")
	public ResponseEntity<String> UserRegistration(@RequestBody Registration registration) throws RegistrationException {
		String str = registrationServiceImpl.UserRegistration(registration);
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}
}


