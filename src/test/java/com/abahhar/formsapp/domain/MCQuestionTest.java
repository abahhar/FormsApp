package com.abahhar.formsapp.domain;

import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abahhar.formsapp.service.MCQuestionService;
import com.abahhar.formsapp.service.ChoiceService;
import com.abahhar.formsapp.service.FormService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:servlet-context.xml", "classpath*:datasource.xml" })
public class MCQuestionTest {

	@Autowired
	MCQuestionService mcQuestionService;
	
	@Autowired
	ChoiceService choiceService;
	
	@Autowired
	FormService formService;
	
	@Ignore
	@Test
	public void testInsert() {
		MCQuestion savedQuestion = new MCQuestion();
		
		String text = "Test MC question";
		Form form = formService.findAll().iterator().next();
		
		savedQuestion.setText(text);
		savedQuestion.setForm(form);
		mcQuestionService.save(savedQuestion);
		
		Choice choice1 = new Choice("choice1");
		choice1.setMcQuestion(savedQuestion);
		choiceService.save(choice1);
		
		Choice choice2 = new Choice("choice2");
		choice2.setMcQuestion(savedQuestion);
		choiceService.save(choice2);
		
		Choice choice3 = new Choice("choice3");
		choice3.setMcQuestion(savedQuestion);
		choiceService.save(choice3);
		
		Choice choice4 = new Choice("choice4");
		choice4.setMcQuestion(savedQuestion);
		choiceService.save(choice4);
		
		/*Set<Choice> choices = new HashSet<Choice>();
		choices.add(choice1);
		choices.add(choice2);
		choices.add(choice3);
		choices.add(choice4);
		
		savedQuestion.setChoices(choices);
		mcQuestionService.save(savedQuestion);*/
		
		int id = savedQuestion.getId();
		MCQuestion mcQuestion = mcQuestionService.findOne(id);
		
		Set<Choice> choices = mcQuestion.getChoices();
		//int size = choices.size();
		
		for(Iterator<Choice> it = choices.iterator(); it.hasNext(); ){
			System.out.println(it.next().getText());
		}
		
		Assert.assertNotNull(mcQuestion);
		Assert.assertEquals(text, mcQuestion.getText());
		Assert.assertNotNull(mcQuestion.getChoices());
		Assert.assertEquals(form.getId(), mcQuestion.getForm().getId());
	}
	
	@Ignore
	@Test
	public void testUpdate(){
		MCQuestion questionToUpdate = mcQuestionService.findAll().iterator().next();
		
		String text = "Edited MC question";
		Set<Choice> choices = questionToUpdate.getChoices();
		
		for(Iterator<Choice> it = choices.iterator(); it.hasNext(); ){
			Choice editedChoice = it.next();
			String currentText = editedChoice.getText();
			editedChoice.setText("Edited" + currentText);
			choiceService.save(editedChoice);
		}
		
		questionToUpdate.setText(text);
		questionToUpdate.setChoices(choices);
		mcQuestionService.save(questionToUpdate);
		
		int id = questionToUpdate.getId();
		MCQuestion mcQuestion = mcQuestionService.findOne(id);
		
		Assert.assertNotNull(mcQuestion);
		Assert.assertEquals(text, mcQuestion.getText());
		
		for(Iterator<Choice> it = choices.iterator(); it.hasNext(); ){
			Choice editedChoice = it.next();
			String currentText = editedChoice.getText();
			Assert.assertTrue(currentText.contains("Edited"));
		}
	}
	
	@Ignore
	@Test
	public void testDelete(){
		MCQuestion questionToDelete = mcQuestionService.findAll().iterator().next();
		
		int id = questionToDelete.getId();
		mcQuestionService.delete(id);
		
		MCQuestion mcQuestion = mcQuestionService.findOne(id);
		
		Assert.assertNull(mcQuestion);
	}

}
