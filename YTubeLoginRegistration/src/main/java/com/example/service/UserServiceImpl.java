package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Registration;
import com.example.entity.User;
import com.example.exception.UserException;
import com.example.repository.RegistrationRepository;
import com.example.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired(required = true)
	UserRepository userrepo;
	
	@Autowired(required = true)
	RegistrationRepository registerrepo;
	

	@Override
	public String UserLogin(User user) throws UserException {
		
		if(!(registerrepo.existsById(user.getEmail()))) {
			throw new UserException("UserId Invalid");
		}
		
		Registration dbuser = registerrepo.findById(user.getEmail()).get();
		
		
		if(!(dbuser.getPassword().equals(user.getPassword()))) {
			throw new UserException("Incorrect password");
		}
		
		userrepo.save(user);

		return "Login Successful";
	}

	@Override
	public String AdminLogin(User user) throws UserException {
		if (!registerrepo.existsById(user.getEmail())) {
			throw new UserException("UserId Invalid");
		}
		
		Registration dbuser = registerrepo.findById(user.getEmail()).get();

		
		if (!dbuser.getPassword().equals(user.getPassword())) {
			throw new UserException("Incorrect Password");
		}

		userrepo.save(user);

		return "Admin Login Successful";
	}

	@Override
	public String UserLogout(User user) throws UserException {
		if (!userrepo.existsById(user.getEmail())) {
			throw new UserException("EmailInvalid");
		}
		
		User dbuser = userrepo.findById(user.getEmail()).get();

		

		if (!dbuser.getPassword().equals(user.getPassword())) {
			throw new UserException("Incorrect Password");
		}

		userrepo.delete(dbuser);

		return "Logout Successful";
	}

	@Override
	public String AdminLogout(User user) throws UserException {
		if (!userrepo.existsById(user.getEmail())) {
			throw new UserException("Email Invalid");
		}
		
		User dbuser = userrepo.findById(user.getEmail()).get();


		if (!dbuser.getPassword().equals(user.getPassword())) {
			throw new UserException("Incorrect Password");
		}

		userrepo.delete(dbuser);

		return "Admin Logout Successful";
	}


}
