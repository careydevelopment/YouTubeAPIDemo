package com.careydevelopment.youtubedemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.careydevelopment.youtubedemo.model.YoutubeSearchCriteria;


@Controller
public class YouTubeDemoController {

	//starting page for YouTube api demo
	@RequestMapping(value = "/youtubeDemo", method=RequestMethod.GET)
	public String youtubeDemo(Model model) {
		//instantiate an empty address object
		YoutubeSearchCriteria youtubeSearchCriteria = new YoutubeSearchCriteria();
		
		//put the object in the model
		model.addAttribute("youtubeSearchCriteria", youtubeSearchCriteria);
		
		//get out
		return "youtubeDemo";
	}

	
	@RequestMapping(value = "/youtubeDemo", method=RequestMethod.POST)
	public String formSubmit(@Valid YoutubeSearchCriteria youtubeSearchCriteria, BindingResult bindingResult, Model model) {
		//check for errors
		if (bindingResult.hasErrors()) {
            return "youtubeDemo";
        }
		
		//get the search results object
		//ZillowSearchResults results = ZillowApiHelper.getSearchResults(address);
		
		//put it in the model
		//model.addAttribute("results", results);
		
		//add the address to the model as well
		model.addAttribute("youtubeSearchCriteria", youtubeSearchCriteria);
		
		//get out
		return "showZillowResults";
	}
		
	
	//redirect to demo if user hits the root
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:youtubeDemo";
	}
}
