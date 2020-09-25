package com.ucelebi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ucelebi.model.User;
import com.ucelebi.repo.UserRepository;


@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {

		return new ModelAndView("redirect:/job/jobs");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute User user) {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute User user) {
		
		user.setRole("ROLE_USER");
		userRepository.save(user);
		
		return new ModelAndView("login");
	}

}
