package com.abahhar.formsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abahhar.formsapp.domain.SimpleAnswer;
import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.domain.User;
import com.abahhar.formsapp.service.SimpleAnswerService;
import com.abahhar.formsapp.service.SimpleQuestionService;
import com.abahhar.formsapp.service.UserService;

@Controller
public class SimpleAnswersController {
	
	@Autowired
	private SimpleAnswerService simpleAnswerService;
	
	@Autowired
	private SimpleQuestionService simpleQuestionService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/simpleAnswers/create", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView create(@ModelAttribute("simpleAnswer") SimpleAnswer simpleAnswer){
		ModelAndView modelAndView = new ModelAndView("redirect:/simpleQuestions/details?id="+simpleAnswer.getSimpleQuestion().getId().toString());
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.getUser(login);
		simpleAnswer.setUser(user);
		
		SimpleQuestion simpleQuestion = simpleQuestionService.findOne(simpleAnswer.getSimpleQuestion().getId());
		simpleAnswer.setSimpleQuestion(simpleQuestion);
		
		simpleAnswerService.save(simpleAnswer);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/simpleAnswers/delete", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam Integer answerId, @RequestParam Integer questionId){
		ModelAndView modelAndView = new ModelAndView("redirect:/simpleQuestions/details?id="+questionId);
		
		simpleAnswerService.delete(answerId);
		
		return modelAndView;
	}

}
