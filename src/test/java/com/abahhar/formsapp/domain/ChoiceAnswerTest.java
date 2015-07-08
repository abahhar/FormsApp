package com.abahhar.formsapp.domain;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abahhar.formsapp.service.UserService;
import com.abahhar.formsapp.service.ChoiceAnswerService;
import com.abahhar.formsapp.service.MCQuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:servlet-context.xml", "classpath*:datasource.xml" })
public class ChoiceAnswerTest {
	
	@Autowired
	ChoiceAnswerService choiceAnswerService;
	
	@Autowired
	MCQuestionService mcQuestionService;
	
	@Autowired
	UserService userService;

	@Ignore
	@Test
	public void testInsert(){
		ChoiceAnswer choiceAnswer = new ChoiceAnswer();
		MCQuestion mcQuestion = mcQuestionService.findAll().iterator().next();
		Choice choice = mcQuestion.getChoices().iterator().next();
		User user = userService.getUser("admin");
		
		choiceAnswer.setMcQuestion(mcQuestion);
		choiceAnswer.setChoice(choice);
		choiceAnswer.setUser(user);
		choiceAnswerService.save(choiceAnswer);
		
		int id = choiceAnswer.getId();
		choiceAnswer = choiceAnswerService.findOne(id);
		
		Assert.assertNotNull(choiceAnswer);
	}
	
	@Ignore
	@Test
	public void testDelete(){
		ChoiceAnswer choiceAnswerToDelete = choiceAnswerService.findAll().iterator().next();
		int id = choiceAnswerToDelete.getId();
		choiceAnswerService.delete(id);
		
		ChoiceAnswer choiceAnswer = choiceAnswerService.findOne(id);
		
		Assert.assertNull(choiceAnswer);
	}

}
