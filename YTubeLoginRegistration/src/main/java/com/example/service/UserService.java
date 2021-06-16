package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.exception.UserException;
@Service
public interface UserService {
	
public String UserLogin(User user) throws UserException;
	
	public String AdminLogin(User user) throws UserException;

	public String UserLogout(User user) throws UserException;
	
	public String AdminLogout(User user) throws UserException;

}
