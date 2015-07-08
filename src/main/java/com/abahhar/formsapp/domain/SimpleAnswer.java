package com.abahhar.formsapp.domain;

import javax.persistence.*;

@Entity
@Table(name="simpleanswers")
public class SimpleAnswer {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String text;
	
	public SimpleAnswer(){
		
	}
	
	public SimpleAnswer(String text){
		this.text = text;
	}
	
	//---------------------------------Navigation properties---------------------------------//
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private SimpleQuestion simpleQuestion;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public SimpleQuestion getSimpleQuestion() {
		return simpleQuestion;
	}

	public void setSimpleQuestion(SimpleQuestion simpleQuestion) {
		this.simpleQuestion = simpleQuestion;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
