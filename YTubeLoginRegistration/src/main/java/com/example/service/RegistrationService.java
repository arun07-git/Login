package com.example.service;



import org.springframework.stereotype.Service;

import com.example.entity.Registration;
import com.example.exception.RegistrationException;



@Service
public interface RegistrationService {
	
	public String UserRegistration(Registration registartion) throws RegistrationException;
	
	
}
