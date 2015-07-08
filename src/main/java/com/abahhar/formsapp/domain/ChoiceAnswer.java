package com.abahhar.formsapp.domain;

import javax.persistence.*;

@Entity
@Table(name="choiceanswers")
public class ChoiceAnswer {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public ChoiceAnswer(){
		
	}
	
	//---------------------------------Navigation properties---------------------------------//
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private MCQuestion mcQuestion;
	
	@ManyToOne
	@JoinColumn(name="choice_id")
	private Choice choice;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public MCQuestion getMcQuestion() {
		return mcQuestion;
	}

	public void setMcQuestion(MCQuestion mcQuestion) {
		this.mcQuestion = mcQuestion;
	}
	
	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
