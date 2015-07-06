package com.abahhar.formsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByLogin(String login);
	
}
