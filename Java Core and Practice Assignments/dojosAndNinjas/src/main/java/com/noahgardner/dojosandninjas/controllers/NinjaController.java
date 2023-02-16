package com.noahgardner.dojosandninjas.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.dojosandninjas.models.Dojo;
import com.noahgardner.dojosandninjas.models.Ninja;
import com.noahgardner.dojosandninjas.services.DojoService;
import com.noahgardner.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/ninja")
	public String gNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		ArrayList<Dojo> dojoList = (ArrayList<Dojo>) dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
		return "newninja.jsp";
	}
	
	@PostMapping("/create/ninja")
	public String pNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
			Model model, BindingResult result) {
		if(result.hasErrors()) {
			ArrayList<Dojo> dojoList = (ArrayList<Dojo>) dojoService.allDojos();
			model.addAttribute("dojoList", dojoList);
			return "newninja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
}
