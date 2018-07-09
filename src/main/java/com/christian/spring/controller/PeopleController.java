package com.christian.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.christian.spring.entity.People;
import com.christian.spring.service.PeopleService;

@Controller
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	


	@RequestMapping(value = "/people/return", method = RequestMethod.GET)
	public String returnHome(Model model) {
		return "main";
	}
	@RequestMapping(value = "/people", method = RequestMethod.GET)
	public String listPeoples(Model model) {
		model.addAttribute("people", new People());
		model.addAttribute("listPeople", this.peopleService.listPeople());
		return "people";
	}
	
	
	//For add and update people both
	@RequestMapping(value= "/people/add", method = RequestMethod.POST)
	public String addPeople(@ModelAttribute("people") People a){
		
		if(a.getId() == 0){
			//new people, add it
			this.peopleService.addPeople(a);
		}else{
			//existing people, call update
			this.peopleService.updatePeople(a);
		}
		
		return "redirect:/people";
		
	}
	
	@RequestMapping("/people/remove/{id}")
    public String removePeople(@PathVariable("id") long id){
        this.peopleService.removePeople(id);
        return "redirect:/people";
    }
 
    @RequestMapping("/people/edit/{id}")
    public String editPeople(@PathVariable("id") long id, Model model){
        model.addAttribute("people", this.peopleService.getPeopleById(id));
        model.addAttribute("listPeople", this.peopleService.listPeople());
        return "people";
    }
	
}
