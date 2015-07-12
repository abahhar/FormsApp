package com.abahhar.formsapp.domain;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abahhar.formsapp.domain.Form;
import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.service.FormService;
import com.abahhar.formsapp.service.SimpleQuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:servlet-context.xml", "classpath*:datasource.xml" })
public class SimpleQuestionTest {

	@Autowired
	SimpleQuestionService simpleQuestionService;
	
	@Autowired
	FormService formService;
	
	@Ignore
	@Test
	public void testInsert() {
		SimpleQuestion savedQuestion = new SimpleQuestion();
		
		String text = "Test simple question";
		Integer numberOfAnswers = 3;
		Form form = formService.findAll().iterator().next();
		
		savedQuestion.setText(text);
		savedQuestion.setForm(form);
		simpleQuestionService.save(savedQuestion);
		
		int id = savedQuestion.getId();
		SimpleQuestion simpleQuestion = simpleQuestionService.findOne(id);
		
		Assert.assertNotNull(simpleQuestion);
		Assert.assertEquals(text, simpleQuestion.getText());
		Assert.assertEquals(form.getId(), simpleQuestion.getForm().getId());
	}
	
	@Ignore
	@Test
	public void testUpdate(){
		SimpleQuestion questionToUpdate = simpleQuestionService.findAll().iterator().next();
		
		String text = "Edited simple question";
		Integer numberOfAnswers = 4;
		
		questionToUpdate.setText(text);
		simpleQuestionService.save(questionToUpdate);
		
		int id = questionToUpdate.getId();
		SimpleQuestion simpleQuestion = simpleQuestionService.findOne(id);
		
		Assert.assertNotNull(simpleQuestion);
		Assert.assertEquals(text, simpleQuestion.getText());
	}
	
	@Ignore
	@Test
	public void testDelete(){
		SimpleQuestion questionToDelete = simpleQuestionService.findAll().iterator().next();
		
		int id = questionToDelete.getId();
		simpleQuestionService.delete(id);
		
		SimpleQuestion simpleQuestion = simpleQuestionService.findOne(id);
		
		Assert.assertNull(simpleQuestion);
	}

}
