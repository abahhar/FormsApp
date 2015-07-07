package com.abahhar.formsapp.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="choices")
public class Choice {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String text;
	
	//---------------------------------Navigation properties---------------------------------//
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private MCQuestion mcQuestion;
	
	@OneToMany(mappedBy="choice", cascade=CascadeType.REMOVE)
	private Set<ChoiceAnswer> choiceAnswers;

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
	
	public MCQuestion getMcQuestion() {
		return mcQuestion;
	}

	public void setMcQuestion(MCQuestion mcQuestion) {
		this.mcQuestion = mcQuestion;
	}
	
	public Set<ChoiceAnswer> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(Set<ChoiceAnswer> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

}
