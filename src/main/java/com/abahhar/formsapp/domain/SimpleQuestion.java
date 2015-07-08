package com.abahhar.formsapp.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="simplequestions")
public class SimpleQuestion extends Question {
	
	@Column
	private Integer numberOfAnswers;
	
	public SimpleQuestion(){
		super();
	}
	
	public SimpleQuestion(String text, Integer numberOfAnswers){
		super(text);
		this.numberOfAnswers = numberOfAnswers;
	}
	
	//---------------------------------Navigation properties---------------------------------//
	
	@OneToMany(mappedBy="simpleQuestion", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Set<SimpleAnswer> simpleAnswers;

	public Integer getNumberOfAnswers() {
		return numberOfAnswers;
	}

	public void setNumberOfAnswers(Integer numberOfAnswers) {
		this.numberOfAnswers = numberOfAnswers;
	}
	
	public Set<SimpleAnswer> getSimpleAnswers() {
		return simpleAnswers;
	}

	public void setSimpleAnswers(Set<SimpleAnswer> simpleAnswers) {
		this.simpleAnswers = simpleAnswers;
	}

}
