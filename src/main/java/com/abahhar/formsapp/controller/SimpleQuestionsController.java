package com.abahhar.formsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abahhar.formsapp.service.SimpleQuestionService;

@Controller
public class SimpleQuestionsController {
	
	@Autowired
	private SimpleQuestionService simpleQuestionService;
	
	@RequestMapping(value="/simpleQuestions/details", method=RequestMethod.GET)
	public ModelAndView details(@RequestParam Integer id){
		ModelAndView modelAndView = new ModelAndView("simpleQuestions/details");
		modelAndView.addObject("simpleQuestion", simpleQuestionService.findOne(id));
		
		return modelAndView;
	}

}
