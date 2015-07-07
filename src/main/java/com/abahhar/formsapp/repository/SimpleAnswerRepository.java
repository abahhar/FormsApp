package com.abahhar.formsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.SimpleAnswer;

public interface SimpleAnswerRepository extends
		JpaRepository<SimpleAnswer, Integer> {

}
