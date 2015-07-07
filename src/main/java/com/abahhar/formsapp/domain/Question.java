package com.abahhar.formsapp.domain;

import javax.persistence.*;

@Entity
@Table(name="questions")
@Inheritance(strategy=InheritanceType.JOINED) //Joined strategy for table per subclass
public class Question {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String text;
	
	//---------------------------------Navigation properties---------------------------------//
	
	@ManyToOne
	@JoinColumn(name="form_id")
	private Form form;

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
	
	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

}
