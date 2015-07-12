package com.abahhar.formsapp.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.abahhar.formsapp.domain.Choice;
import com.abahhar.formsapp.domain.Form;
import com.abahhar.formsapp.domain.MCQuestion;

public class MCQuestionWrapper {
	
	private MCQuestion mcQuestion;

	private List<Choice> choices;
	
	public MCQuestionWrapper(){
		this.mcQuestion = new MCQuestion();
		this.choices = new ArrayList<Choice>();
	}

	public MCQuestion getMcQuestion() {
		return mcQuestion;
	}

	public void setMcQuestion(MCQuestion mcQuestion) {
		this.mcQuestion = mcQuestion;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

}
