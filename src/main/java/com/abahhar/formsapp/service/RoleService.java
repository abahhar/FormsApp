package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abahhar.formsapp.domain.Role;
import com.abahhar.formsapp.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRole(int id){
		return roleRepository.findOne(id);
	}
	
}
