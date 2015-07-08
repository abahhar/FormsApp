package com.abahhar.formsapp.domain;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="mcquestions")
public class MCQuestion extends Question {
	
	public MCQuestion(){
		super();
	}
	
	//---------------------------------Navigation properties---------------------------------//
	
	@OneToMany(mappedBy="mcQuestion", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Set<Choice> choices;
	
	@OneToMany(mappedBy="mcQuestion", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private Set<ChoiceAnswer> choiceAnswers;

	public Set<Choice> getChoices() {
		return choices;
	}

	public void setChoices(Set<Choice> choices) {
		/*for(Iterator<Choice> c = choices.iterator(); c.hasNext(); ){
			c.next().setMcQuestion(this);
		}*/
		this.choices = choices;
	}
	
	public Set<ChoiceAnswer> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(Set<ChoiceAnswer> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

}
