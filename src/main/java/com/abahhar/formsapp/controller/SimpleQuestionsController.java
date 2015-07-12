package com.abahhar.formsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abahhar.formsapp.domain.Form;
import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.service.FormService;
import com.abahhar.formsapp.service.SimpleQuestionService;

@Controller
public class SimpleQuestionsController {
	
	@Autowired
	private SimpleQuestionService simpleQuestionService;
	
	@Autowired
	private FormService formService;
	
	@RequestMapping(value="/simpleQuestions/details", method=RequestMethod.GET)
	public ModelAndView details(@RequestParam Integer id){
		ModelAndView modelAndView = new ModelAndView("simpleQuestions/details");
		modelAndView.addObject("simpleQuestion", simpleQuestionService.findOne(id));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/simpleQuestions/create", method=RequestMethod.GET)
	public ModelAndView create(@RequestParam Integer formId){
		ModelAndView modelAndView = new ModelAndView("simpleQuestions/create");
		modelAndView.addObject("form", formService.findOne(formId));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/simpleQuestions/create", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView create(@ModelAttribute("simpleQuestion") SimpleQuestion simpleQuestion){
		simpleQuestionService.save(simpleQuestion);
		
		return new ModelAndView("redirect:/forms/details?id="+simpleQuestion.getForm().getId().toString());
	}
	
	@RequestMapping(value="/simpleQuestions/update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam Integer id){
		ModelAndView modelAndView = new ModelAndView("simpleQuestions/edit");
		modelAndView.addObject("simpleQuestion", simpleQuestionService.findOne(id));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/simpleQuestions/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("simpleQuestion") SimpleQuestion simpleQuestion){
		simpleQuestion = simpleQuestionService.save(simpleQuestion);
		ModelAndView modelAndView = new ModelAndView("redirect:/forms/details?id="+simpleQuestion.getForm().getId().toString());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/simpleQuestions/delete", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam Integer id){
		Integer formId = simpleQuestionService.findOne(id).getForm().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/forms/details?id="+formId.toString());
		
		simpleQuestionService.delete(id);
		
		return modelAndView;
	}

}
