package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abahhar.formsapp.domain.Choice;
import com.abahhar.formsapp.repository.ChoiceRepository;

@Service
public class ChoiceService {
	
	@Autowired
	private ChoiceRepository choiceRepository;
	
	public Iterable<Choice> findAll() {
	  return choiceRepository.findAll();
	}
	 
	public Choice save(Choice entity) {
	  return choiceRepository.save(entity);
	}
	
	public void delete(Integer id) {
		choiceRepository.delete(id);
	}
	
	public Choice findOne(Integer id) {
	  return choiceRepository.findOne(id);
	}

}
