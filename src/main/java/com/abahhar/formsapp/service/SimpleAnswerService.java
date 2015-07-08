package com.abahhar.formsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abahhar.formsapp.domain.SimpleAnswer;
import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.domain.User;
import com.abahhar.formsapp.repository.SimpleAnswerRepository;

@Service
@Transactional
public class SimpleAnswerService {
	
	@Autowired
	private SimpleAnswerRepository simpleAnswerRepository;
	
	public Iterable<SimpleAnswer> findAll() {
	  return simpleAnswerRepository.findAll();
	}
	
	/*public List<SimpleAnswer> findAll(SimpleQuestion simpleQuestion, User user){
		return simpleAnswerRepository.findAllBySimpleQuestionAndUser(simpleQuestion, user);
	}*/
	 
	public SimpleAnswer save(SimpleAnswer entity) {
	  return simpleAnswerRepository.save(entity);
	}
	
	public void delete(Integer id) {
		simpleAnswerRepository.delete(id);
	}
	
	/*public void delete(SimpleQuestion simpleQuestion, User user){
		List<SimpleAnswer> simpleAnswers = simpleAnswerRepository.findAllBySimpleQuestionAndUser(simpleQuestion, user);
		simpleAnswerRepository.delete(simpleAnswers);
	}*/
	
	public SimpleAnswer findOne(Integer id) {
	  return simpleAnswerRepository.findOne(id);
	}

}
