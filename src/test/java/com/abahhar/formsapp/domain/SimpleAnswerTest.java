package com.abahhar.formsapp.domain;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abahhar.formsapp.service.UserService;
import com.abahhar.formsapp.service.SimpleAnswerService;
import com.abahhar.formsapp.service.SimpleQuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:servlet-context.xml", "classpath*:datasource.xml" })
public class SimpleAnswerTest {

	@Autowired
	SimpleAnswerService simpleAnswerService;
	
	@Autowired
	SimpleQuestionService simpleQuestionService;
	
	@Autowired
	UserService userService;
	
	@Ignore
	@Test
	public void testInsert() {
		SimpleQuestion simpleQuestion = simpleQuestionService.findAll().iterator().next();
		
		User user = userService.getUser("admin");
		
		SimpleAnswer savedAnswer1 = new SimpleAnswer("This is answer1");
		savedAnswer1.setSimpleQuestion(simpleQuestion);
		savedAnswer1.setUser(user);
		simpleAnswerService.save(savedAnswer1);
		
		/*SimpleAnswer savedAnswer2 = new SimpleAnswer("This is answer2");
		savedAnswer2.setSimpleQuestion(simpleQuestion);
		savedAnswer2.setUser(user);
		simpleAnswerService.save(savedAnswer2);
		
		SimpleAnswer savedAnswer3 = new SimpleAnswer("This is answer3");
		savedAnswer3.setSimpleQuestion(simpleQuestion);
		savedAnswer3.setUser(user);
		simpleAnswerService.save(savedAnswer3);*/
		
		int id = savedAnswer1.getId();
		SimpleAnswer simpleAnswer = simpleAnswerService.findOne(id);
		
		Assert.assertNotNull(simpleAnswer);
		Assert.assertEquals("This is answer1", simpleAnswer.getText());
		Assert.assertEquals(simpleQuestion.getText(), simpleAnswer.getSimpleQuestion().getText());
		Assert.assertEquals(user.getLogin(), simpleAnswer.getUser().getLogin());
	}
	
	@Ignore
	@Test
	public void testDelete(){
		/*SimpleQuestion simpleQuestion = simpleQuestionService.findAll().iterator().next();
		User user = userService.getUser("admin");
		
		simpleAnswerService.delete(simpleQuestion, user);
		
		List<SimpleAnswer> simpleAnswers = simpleAnswerService.findAll(simpleQuestion, user);
		
		Assert.assertEquals(0, simpleAnswers.size());*/
		
		SimpleAnswer simpleAnswerToDelete = simpleAnswerService.findAll().iterator().next();
		int id = simpleAnswerToDelete.getId();
		
		simpleAnswerService.delete(id);
		
		SimpleAnswer simpleAnswer = simpleAnswerService.findOne(id);
		
		Assert.assertNull(simpleAnswer);
	}

}
