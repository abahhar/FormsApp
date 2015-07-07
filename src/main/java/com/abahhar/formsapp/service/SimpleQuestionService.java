package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.repository.SimpleQuestionRepository;

@Service
public class SimpleQuestionService {
	
	@Autowired
	private SimpleQuestionRepository simpleQuestionRepository;
	
	public Iterable<SimpleQuestion> findAll() {
	  return simpleQuestionRepository.findAll();
	}
	 
	public SimpleQuestion save(SimpleQuestion entity) {
	  return simpleQuestionRepository.save(entity);
	}
	
	public void delete(Integer id) {
		simpleQuestionRepository.delete(id);
	}
	
	public SimpleQuestion findOne(Integer id) {
	  return simpleQuestionRepository.findOne(id);
	}

}
