package com.abahhar.formsapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abahhar.formsapp.domain.Choice;
import com.abahhar.formsapp.domain.Form;
import com.abahhar.formsapp.domain.MCQuestion;
import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.service.ChoiceService;
import com.abahhar.formsapp.service.FormService;
import com.abahhar.formsapp.service.MCQuestionService;
import com.abahhar.formsapp.wrapper.MCQuestionWrapper;

@Controller
public class MCQuestionsController {
	
	@Autowired
	private MCQuestionService mcQuestionService;
	
	@Autowired
	private ChoiceService choiceService;
	
	@Autowired
	private FormService formService;
	
	@RequestMapping(value="/mcQuestions/details", method=RequestMethod.GET)
	public ModelAndView details(@RequestParam Integer id){
		ModelAndView modelAndView = new ModelAndView("mcQuestions/details");
		modelAndView.addObject("mcQuestion", mcQuestionService.findOne(id));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/mcQuestions/create", method=RequestMethod.GET)
	public ModelAndView create(@RequestParam Integer formId){
		ModelAndView modelAndView = new ModelAndView("mcQuestions/create");
		
		MCQuestionWrapper mcQuestionWrapper = new MCQuestionWrapper();
		//add 4 choices to be filled
		for(int i = 1; i <= 4; i++){
			mcQuestionWrapper.getChoices().add(new Choice());
		}
		
		modelAndView.addObject("form", formService.findOne(formId));
		modelAndView.addObject("mcQuestionWrapper", mcQuestionWrapper);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/mcQuestions/create", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView create(@ModelAttribute("mcQuestionWrapper") MCQuestionWrapper mcQuestionWrapper){
		MCQuestion mcQuestion = mcQuestionWrapper.getMcQuestion();
		List<Choice> choices = mcQuestionWrapper.getChoices();
		
		mcQuestionService.save(mcQuestion);
		
		Iterator<Choice> iterator = choices.iterator();
		
		while(iterator.hasNext()){
			Choice choice = iterator.next();
			choice.setMcQuestion(mcQuestion);
			choiceService.save(choice);
		}
		
		return new ModelAndView("redirect:/forms/details?id="+mcQuestion.getForm().getId().toString());
	}
	
	@RequestMapping(value="/mcQuestions/update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam Integer id){
		ModelAndView modelAndView = new ModelAndView("mcQuestions/edit");
		
		MCQuestionWrapper mcQuestionWrapper = new MCQuestionWrapper();
		
		MCQuestion mcQuestion = mcQuestionService.findOne(id);
		mcQuestionWrapper.setMcQuestion(mcQuestion);
		
		Set<Choice> choices = mcQuestion.getChoices();
		List<Choice> choicesList = new ArrayList<Choice>();
		
		for(Iterator<Choice> iterator = choices.iterator(); iterator.hasNext(); ){
			choicesList.add(iterator.next());
		}
		
		mcQuestionWrapper.setChoices(choicesList);
		
		modelAndView.addObject("mcQuestionWrapper", mcQuestionWrapper);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/mcQuestions/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("mcQuestionWrapper") MCQuestionWrapper mcQuestionWrapper){
		MCQuestion mcQuestion = mcQuestionWrapper.getMcQuestion();
		List<Choice> choices = mcQuestionWrapper.getChoices();
		
		mcQuestionService.save(mcQuestion);
		
		mcQuestion = mcQuestionService.findOne(mcQuestion.getId());
		
		Iterator<Choice> iterator = mcQuestion.getChoices().iterator();
		
		while(iterator.hasNext()){
			Integer choiceId = iterator.next().getId();
			choiceService.delete(choiceId);
		}
		
		iterator = choices.iterator();
		
		while(iterator.hasNext()){
			Choice choice = iterator.next();
			choice.setMcQuestion(mcQuestion);
			choiceService.save(choice);
		}
		
		return new ModelAndView("redirect:/forms/details?id="+mcQuestion.getForm().getId().toString());
	}
	
	@RequestMapping(value="/mcQuestions/delete", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam Integer id){
		Integer formId = mcQuestionService.findOne(id).getForm().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/forms/details?id="+formId.toString());
		
		mcQuestionService.delete(id);
		
		return modelAndView;
	}

}
