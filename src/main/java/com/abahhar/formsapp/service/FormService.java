package com.abahhar.formsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abahhar.formsapp.domain.Form;
import com.abahhar.formsapp.repository.FormRepository;

@Service
@Transactional
public class FormService {
	
	@Autowired
	private FormRepository formRepository;
	
	public Iterable<Form> findAll() {
	  return formRepository.findAll();
	}
	 
	public Form save(Form entity) {
	  return formRepository.save(entity);
	}
	
	public void delete(Integer id) {
		formRepository.delete(id);
	}
	
	public Form findOne(Integer id) {
	  return formRepository.findOne(id);
	}

}
