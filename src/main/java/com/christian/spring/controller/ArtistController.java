package com.christian.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.christian.spring.constants.Constants;
import com.christian.spring.entity.Artist;
import com.christian.spring.service.ArtistService;

@Controller
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	/*@Autowired
	ArtistValidator artistValidator;
	
	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(artistValidator);
	}*/
	
	@RequestMapping(value = "/artist/return", method = RequestMethod.GET)
	public String returnHome(Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/artists", method = RequestMethod.GET)
	public String listArtists(Model model) {
		model.addAttribute("artist", new Artist());
		model.addAttribute("listArtists", this.artistService.listArtists());
		return Constants.ARTISTS_LIST_PAGE;
	}
	
	//For add and update artist both
	@RequestMapping(value= "artist/add", method = RequestMethod.POST)
	public String addArtist(@ModelAttribute("artistForm") Artist a, Model model){
		
			if(a.getId() == 0){
				//new artist, add it
				this.artistService.addArtist(a);
			}else{
				//existing artist, call update
				this.artistService.updateArtist(a);
			}
		
		return "redirect:/artists";
		
	}
	
	@RequestMapping("/artist/remove/{id}")
    public String removeArtist(@PathVariable("id") long id){
        this.artistService.removeArtist(id);
        return "redirect:/artists";
    }
 
    @RequestMapping("/artist/edit/{id}")
    public String editArtist(@PathVariable("id") long id, Model model){
        model.addAttribute("artist", this.artistService.getArtistById(id));
        model.addAttribute("listArtists", this.artistService.listArtists());
        return Constants.ARTISTS_LIST_PAGE;
    }
	
}
