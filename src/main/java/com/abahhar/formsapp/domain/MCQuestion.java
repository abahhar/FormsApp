package com.abahhar.formsapp.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="mcquestions")
public class MCQuestion extends Question {
	
	//---------------------------------Navigation properties---------------------------------//
	
	@OneToMany(mappedBy="mcQuestion", cascade=CascadeType.REMOVE)
	private Set<Choice> choices;
	
	@OneToMany(mappedBy="mcQuestion", cascade=CascadeType.REMOVE)
	private Set<ChoiceAnswer> choiceAnswers;

	public Set<Choice> getChoices() {
		return choices;
	}

	public void setChoices(Set<Choice> choices) {
		this.choices = choices;
	}
	
	public Set<ChoiceAnswer> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(Set<ChoiceAnswer> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

}
