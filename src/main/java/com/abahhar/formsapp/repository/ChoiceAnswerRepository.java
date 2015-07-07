package com.abahhar.formsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.ChoiceAnswer;

public interface ChoiceAnswerRepository extends
		JpaRepository<ChoiceAnswer, Integer> {

}
