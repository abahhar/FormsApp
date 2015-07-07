package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abahhar.formsapp.domain.ChoiceAnswer;
import com.abahhar.formsapp.repository.ChoiceAnswerRepository;

@Service
public class ChoiceAnswerService {
	
	@Autowired
	private ChoiceAnswerRepository choiceAnswerRepository;
	
	public Iterable<ChoiceAnswer> findAll() {
	  return choiceAnswerRepository.findAll();
	}
	 
	public ChoiceAnswer save(ChoiceAnswer entity) {
	  return choiceAnswerRepository.save(entity);
	}
	
	public void delete(Integer id) {
		choiceAnswerRepository.delete(id);
	}
	
	public ChoiceAnswer findOne(Integer id) {
	  return choiceAnswerRepository.findOne(id);
	}

}
