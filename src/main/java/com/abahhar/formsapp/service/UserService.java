package com.abahhar.formsapp.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abahhar.formsapp.domain.Role;
import com.abahhar.formsapp.domain.User;
import com.abahhar.formsapp.repository.RoleRepository;
import com.abahhar.formsapp.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public User getUser(String login){
		return userRepository.findByLogin(login);
	}
	
	public boolean registerUser(User user){
		User loadedUser = userRepository.findByLogin(user.getLogin());
		
		if(loadedUser != null){
			return false;
		}
		
		String hashedPassword = DigestUtils.sha1Hex(user.getPassword());
		
		Role role = roleRepository.findOne(2);
		List<User> usersList = userRepository.findAll();
		Set<User> userRoles = new HashSet<User>();
		
		Iterator<User> iterator = usersList.iterator();
		while(iterator.hasNext()){
			User userRole = iterator.next();
			//The admin doesn't need to have the ROLE_USER, only users
			if(userRole.getRole().getId() != 1){
				userRoles.add(userRole);
			}
		}
		userRoles.add(user);
		
		role.setUserRoles(userRoles);
		
		user.setPassword(hashedPassword);
		
		roleRepository.save(role);
		
		return true;
	}

}
