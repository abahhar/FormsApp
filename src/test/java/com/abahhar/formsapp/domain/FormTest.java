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

import com.abahhar.formsapp.service.FormService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:servlet-context.xml", "classpath*:datasource.xml" })
public class FormTest {
	
	@Autowired
	FormService formService;
	
	@Ignore
	@Test
	public void testInsert() {
		String testTitle = "Test form";
		Form savedForm = new Form("Test form");
		
		//savedForm.setTitle(testTitle);
		formService.save(savedForm);
		
		int id = savedForm.getId();
		Form form = formService.findOne(id);
		
		Assert.assertNotNull(form);
		Assert.assertEquals(testTitle, form.getTitle());
	}
	
	@Ignore
	@Test
	public void testUpdate(){
		Form formToUpdate = formService.findAll().iterator().next();
		
		String newTitle = "Edited test form";
		formToUpdate.setTitle(newTitle);
		formService.save(formToUpdate);
		
		int id = formToUpdate.getId();
		Form form = formService.findOne(id);
		
		Set<Question> questions = form.getQuestions();
		for(Iterator<Question> it = questions.iterator(); it.hasNext() ; ){
			System.out.println(it.next().getText());
		}
		
		Assert.assertNotNull(form);
		Assert.assertEquals(newTitle, form.getTitle());
	}
	
	@Ignore
	@Test
	public void testDelete(){
		Form formToDelete = formService.findAll().iterator().next();
		int id = formToDelete.getId();
		
		formService.delete(id);;
		
		Form form = formService.findOne(id);
		
		Assert.assertNull(form);
	}

}
