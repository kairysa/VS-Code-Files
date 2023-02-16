package com.noahgardner.dojosandninjas.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.dojosandninjas.models.Dojo;
import com.noahgardner.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("dojo") Dojo dojo) {
		ArrayList<Dojo> dojos = (ArrayList<Dojo>) dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@PostMapping("/create/dojo")
	public String pCreateDojo(
			Model model, 
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			ArrayList<Dojo> dojos = (ArrayList<Dojo>) dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "index.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String gViewDojo(
			@PathVariable("id") Long id,
			Model model
			) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "viewdojo.jsp";
	}
	
}
