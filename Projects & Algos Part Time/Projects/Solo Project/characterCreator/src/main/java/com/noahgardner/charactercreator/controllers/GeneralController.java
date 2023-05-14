package com.noahgardner.charactercreator.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.noahgardner.charactercreator.services.UserService;

@Controller
public class GeneralController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String home(HttpSession session,
			Model model) {
		if(session.getAttribute("id") != null) {
			Long id = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.findUser(id));
		}
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
			session.removeAttribute("id");
			return "redirect:/";
		}
}
