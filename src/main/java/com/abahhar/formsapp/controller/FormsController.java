package com.abahhar.formsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
