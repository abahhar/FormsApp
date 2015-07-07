package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abahhar.formsapp.domain.SimpleAnswer;
import com.abahhar.formsapp.repository.SimpleAnswerRepository;

@Service
public class SimpleAnswerService {
	
	@Autowired
	private SimpleAnswerRepository simpleAnswerRepository;
	
	public Iterable<SimpleAnswer> findAll() {
	  return simpleAnswerRepository.findAll();
	}
	 
	public SimpleAnswer save(SimpleAnswer entity) {
	  return simpleAnswerRepository.save(entity);
	}
	
	public void delete(Integer id) {
		simpleAnswerRepository.delete(id);
	}
	
	public SimpleAnswer findOne(Integer id) {
	  return simpleAnswerRepository.findOne(id);
	}

}
