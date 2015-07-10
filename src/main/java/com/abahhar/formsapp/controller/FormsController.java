package com.abahhar.formsapp.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abahhar.formsapp.domain.Form;
import com.abahhar.formsapp.domain.MCQuestion;
import com.abahhar.formsapp.domain.Question;
import com.abahhar.formsapp.domain.SimpleQuestion;
import com.abahhar.formsapp.service.FormService;

@Controller
public class FormsController {
	
	@Autowired
	private FormService formService;
	
	@RequestMapping(value="/forms", method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("forms/index");
		modelAndView.addObject("forms", formService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value="/forms/details", method=RequestMethod.GET)
	public ModelAndView details(@RequestParam Integer id){
		ModelAndView modelAndView = new ModelAndView("forms/details");
		
		Form form = formService.findOne(id);
		
		Set<SimpleQuestion> simpleQuestions = new HashSet<SimpleQuestion>();
		
		Set<MCQuestion> mcQuestions = new HashSet<MCQuestion>();
		
		Iterator<Question> iterator = form.getQuestions().iterator();
		while(iterator.hasNext()){
			Question question = iterator.next();
			if(question instanceof SimpleQuestion){
				SimpleQuestion simpleQuestion = (SimpleQuestion) question;
				simpleQuestions.add(simpleQuestion);
			}else{
				MCQuestion mcQuestion = (MCQuestion) question;
				mcQuestions.add(mcQuestion);
			}
		}
		
		modelAndView.addObject("form", formService.findOne(id));
		modelAndView.addObject("simpleQuestions", simpleQuestions);
		modelAndView.addObject("mcQuestions", mcQuestions);
		return modelAndView;
	}
	
	@RequestMapping(value="/forms/create", method=RequestMethod.GET)
	public String create(){
		return "forms/create";
	}
	
	@RequestMapping(value="/forms/create", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView create(@ModelAttribute("form") Form form){
		formService.save(form);
		
		return new ModelAndView("redirect:/forms");
	}

}
