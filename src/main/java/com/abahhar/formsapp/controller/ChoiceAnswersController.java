package com.abahhar.formsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abahhar.formsapp.domain.ChoiceAnswer;
import com.abahhar.formsapp.domain.MCQuestion;
import com.abahhar.formsapp.domain.User;
import com.abahhar.formsapp.service.ChoiceAnswerService;
import com.abahhar.formsapp.service.MCQuestionService;
import com.abahhar.formsapp.service.UserService;

@Controller
public class ChoiceAnswersController {
	
	@Autowired
	private ChoiceAnswerService choiceAnswerService;
	
	@Autowired
	private MCQuestionService mcQuestionService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/choiceAnswers/create", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView create(@ModelAttribute("choiceAnswer") ChoiceAnswer choiceAnswer){
		ModelAndView modelAndView = new ModelAndView("redirect:/mcQuestions/details?id="+choiceAnswer.getMcQuestion().getId().toString());
		
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.getUser(login);
		choiceAnswer.setUser(user);
		
		MCQuestion mcQuestion = mcQuestionService.findOne(choiceAnswer.getMcQuestion().getId());
		choiceAnswer.setMcQuestion(mcQuestion);
		
		choiceAnswerService.save(choiceAnswer);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/choiceAnswers/delete", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam Integer answerId, @RequestParam Integer questionId){
		ModelAndView modelAndView = new ModelAndView("redirect:/mcQuestions/details?id="+questionId);
		
		choiceAnswerService.delete(answerId);
		
		return modelAndView;
	}

}
