package com.christian.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.christian.spring.constants.Constants;

@Controller
public class MainController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listArtists(Model model) {
		return Constants.MAIN_PAGE;
	}
	
}
