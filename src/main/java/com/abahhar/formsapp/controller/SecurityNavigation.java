package com.abahhar.formsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abahhar.formsapp.domain.User;
import com.abahhar.formsapp.service.UserService;

@Controller
public class SecurityNavigation {
    
	@Autowired
	UserService userService;
	
    @RequestMapping(value="/user-login", method=RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("login-form");
    }
     
    @RequestMapping(value="/error-login", method=RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("login-form");
        modelAndView.addObject("error", true);
        return modelAndView;
    }
     
    @RequestMapping(value="/success-login", method=RequestMethod.GET)
    public ModelAndView successLogin() {
        return new ModelAndView("success-login");
    }
    
    @RequestMapping(value="/users/register", method=RequestMethod.GET)
    public ModelAndView register(){
    	return new ModelAndView("users/register");
    }
    
    @RequestMapping(value="/users/register", method=RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") User user){
    	
    	if(!userService.registerUser(user)){
    		return new ModelAndView("users/register").addObject("error", true);
    	}
    	
    	return new ModelAndView("login-form").addObject("registered", true);
    }
 
}
