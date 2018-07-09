package com.christian.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.christian.spring.entity.Style;
import com.christian.spring.service.StyleService;

@Controller
public class StyleController {
	
	@Autowired
	private StyleService styleService;
	

	
	@RequestMapping(value = "/styles", method = RequestMethod.GET)
	public String listStyles(Model model) {
		model.addAttribute("style", new Style());
		model.addAttribute("listStyles", this.styleService.listStyles());
		return "style";
	}
	
	@RequestMapping(value = "/style/return", method = RequestMethod.GET)
	public String returnHome(Model model) {
		return "main";
	}
	
	//For add and update style both
	@RequestMapping(value= "/style/add", method = RequestMethod.POST)
	public String addStyle(@ModelAttribute("style") Style a){
		
		if(a.getId() == 0){
			//new style, add it
			this.styleService.addStyle(a);
		}else{
			//existing style, call update
			this.styleService.updateStyle(a);
		}
		
		return "redirect:/styles";
		
	}
	
	@RequestMapping("/style/remove/{id}")
    public String removeStyle(@PathVariable("id") long id){
        this.styleService.removeStyle(id);
        return "redirect:/styles";
    }
 
    @RequestMapping("/style/edit/{id}")
    public String editStyle(@PathVariable("id") long id, Model model){
        model.addAttribute("style", this.styleService.getStyleById(id));
        model.addAttribute("listStyles", this.styleService.listStyles());
        return "style";
    }
	
}
