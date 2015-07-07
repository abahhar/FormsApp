package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abahhar.formsapp.domain.MCQuestion;
import com.abahhar.formsapp.repository.MCQuestionRepository;

@Service
public class MCQuestionService {
	
	@Autowired
	private MCQuestionRepository mcQuestionRepository;
	
	public Iterable<MCQuestion> findAll() {
	  return mcQuestionRepository.findAll();
	}
	 
	public MCQuestion save(MCQuestion entity) {
	  return mcQuestionRepository.save(entity);
	}
	
	public void delete(Integer id) {
		mcQuestionRepository.delete(id);
	}
	
	public MCQuestion findOne(Integer id) {
	  return mcQuestionRepository.findOne(id);
	}

}
