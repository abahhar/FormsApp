package com.abahhar.formsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
