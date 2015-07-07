package com.abahhar.formsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.Form;

public interface FormRepository extends JpaRepository<Form, Integer> {

}
