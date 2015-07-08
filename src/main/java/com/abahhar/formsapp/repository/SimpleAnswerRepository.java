package com.abahhar.formsapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abahhar.formsapp.domain.SimpleAnswer;
import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.domain.User;

public interface SimpleAnswerRepository extends
		JpaRepository<SimpleAnswer, Integer> {
	
	//List<SimpleAnswer> findAllBySimpleQuestionAndUser(SimpleQuestion simpleQuestion, User user);

}
