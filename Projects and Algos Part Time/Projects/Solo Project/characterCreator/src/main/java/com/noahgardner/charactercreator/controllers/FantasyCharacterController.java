package com.noahgardner.charactercreator.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.charactercreator.models.FantasyCharacter;
import com.noahgardner.charactercreator.services.FantasyCharacterService;
import com.noahgardner.charactercreator.services.UserService;

@Controller
public class FantasyCharacterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FantasyCharacterService fantasyCharacterService;
	
	@GetMapping("/character")
	public String gCharacterList(HttpSession session,
			Model model) {
		if(session.getAttribute("id") != null) {
			Long userId = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.findUser(userId));
		}
		model.addAttribute("characterList", fantasyCharacterService.findAll());
		return "characters.jsp";
	}
	
	@GetMapping("/character/create")
	public String gCreatePage(
			HttpSession session,
			@ModelAttribute("newCharacter") FantasyCharacter fantasyCharacter,
			Model model
			) {
		if(session.getAttribute("id") == null) {
			return "redirect:/login";
		}
		else {
			Long id = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.findUser(id));
			return "create.jsp";
		}
	}
	
	@PostMapping("/character/create/new")
	public String pCreateCharacter(
			HttpSession session,
			@Valid @ModelAttribute("newCharacter") FantasyCharacter fantasyCharacter,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			Long id = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.findUser(id));
			return "create.jsp";
		}
		else {
			fantasyCharacterService.createCharacter(fantasyCharacter, result);
			return "redirect:/character";
		}
	}
	
	@GetMapping("/character/view/{id}")
	public String gViewPage(
			HttpSession session,
			@PathVariable("id") Long id,
			Model model) {
		if(session.getAttribute("id") != null) {
			Long userId = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.findUser(userId));
		}
			model.addAttribute("selectedCharacter", fantasyCharacterService.findOne(id));
			return "view.jsp";
	}
	
	@GetMapping("/character/view")
	public String gOwnedPage(
			HttpSession session,
			Model model){
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
		else {
			Long userId = (Long) session.getAttribute("id");
			model.addAttribute("characterList", fantasyCharacterService.findAll());
			model.addAttribute("user", userService.findUser(userId));
			return "personal-list.jsp";
		}
		
		
	}
	
	@GetMapping("/character/edit/{id}")
	public String gEditPage(
			HttpSession session,
			@PathVariable("id") Long id,
			Model model) {
		Long userId = (Long) session.getAttribute("id");
		FantasyCharacter selectedCharacter = fantasyCharacterService.findOne(id);
		if(userId == selectedCharacter.getUser().getId()) {
			model.addAttribute("user", userService.findUser(userId));
			model.addAttribute("selectedCharacter", selectedCharacter);
			return "edit.jsp";
		}
		else {
			return "redirect:/logout";
		}
	}
	
	@PostMapping("/character/edit/{id}")
	public String pEditPage(
			HttpSession session,
			@PathVariable("id") Long id,
			Model model,
			@Valid @ModelAttribute("selectedCharacter") FantasyCharacter fantasyCharacter,
			BindingResult result) {
		FantasyCharacter selectedCharacter = fantasyCharacterService.findOne(id);
		if(result.hasErrors()) {
			model.addAttribute("selectedCharacter", selectedCharacter);
			return "edit.jsp";
		}
		else {
			System.out.println(selectedCharacter);
			fantasyCharacterService.updateCharacter(fantasyCharacter);
			return "redirect:/character";
		}
	}
	
	@GetMapping("/character/delete/{id}")
	public String dCharacter(
			HttpSession session,
			@PathVariable("id") Long id) {
		Long userId = (Long) session.getAttribute("id");
		FantasyCharacter selectedCharacter = fantasyCharacterService.findOne(id);
		if(userId == selectedCharacter.getUser().getId()) {
			fantasyCharacterService.deleteOne(id);
			return "redirect:/character";
		}
		else {
			return "redirect:/logout";
		}
	}
}
