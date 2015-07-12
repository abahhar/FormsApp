package com.abahhar.formsapp.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="simplequestions")
public class SimpleQuestion extends Question {
	
	public SimpleQuestion(){
		super();
	}
	
	public SimpleQuestion(String text){
		super(text);
	}
	
	//---------------------------------Navigation properties---------------------------------//
	
	@OneToMany(mappedBy="simpleQuestion", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Set<SimpleAnswer> simpleAnswers;
	
	public Set<SimpleAnswer> getSimpleAnswers() {
		return simpleAnswers;
	}

	public void setSimpleAnswers(Set<SimpleAnswer> simpleAnswers) {
		this.simpleAnswers = simpleAnswers;
	}

}
