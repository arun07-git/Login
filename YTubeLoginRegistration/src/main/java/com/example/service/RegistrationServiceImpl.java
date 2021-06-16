package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Registration;
import com.example.exception.RegistrationException;
import com.example.repository.RegistrationRepository;


@Service
@Transactional

public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired(required = true)
	RegistrationRepository registerrepo;

	@Override
	public String UserRegistration(Registration registartion) throws RegistrationException {
		if(registerrepo.existsById(registartion.getEmail())) {
			throw new RegistrationException("Email already exist");
		}
		if(!(registartion.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))) {
			throw new RegistrationException("Give valid Email");
		}
		if(!(registartion.getPassword().matches("^[A-Za-z0-9@.*#$!]{6,10}$"))) {
			throw new RegistrationException("Give Valid Password");
		}
		registerrepo.save(registartion);
		return "User Registration Successful";
	}
	
}
