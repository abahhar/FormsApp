package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abahhar.formsapp.domain.User;
import com.abahhar.formsapp.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String login){
		return userRepository.findByLogin(login);
	}

}
