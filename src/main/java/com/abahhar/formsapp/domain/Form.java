package com.abahhar.formsapp.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="forms")
public class Form {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String title;
	
	//---------------------------------Navigation properties---------------------------------//
	
	@OneToMany(mappedBy="form", cascade=CascadeType.REMOVE)
	private Set<Question> questions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}
