package com.careydevelopment.zillowdemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.careydevelopment.zillowdemo.model.Address;


@Controller
public class AddressController {

	//starting page for zillow api demo
	@RequestMapping(value = "/enterAddress", method=RequestMethod.GET)
	public String enterAddress(Model model) {
		//instantiate an empty address object
		Address address = new Address();
		
		//put the object in the model
		model.addAttribute("address", address);
		
		//get out
		return "enterAddress";
	}

	
	@RequestMapping(value = "/enterAddress", method=RequestMethod.POST)
	public String formSubmit(@Valid Address address, BindingResult bindingResult, Model model) {
		//check for errors
		if (bindingResult.hasErrors()) {
            return "enterAddress";
        }
		
		//if there are no errors, show results
		return "showResults";
	}
		
	
	//redirect to demo if user hits the root
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:enterAddress";
	}
}
