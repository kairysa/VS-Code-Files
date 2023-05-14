package com.noahgardner.charactercreator.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.charactercreator.models.LoginUser;
import com.noahgardner.charactercreator.models.User;
import com.noahgardner.charactercreator.services.UserService;

@Controller
public class UserController {
	
	@Autowired 
	UserService userService;
	
	// REGISTER ROUTES //
	@GetMapping("/register")
	public String gRegister(
			HttpSession session,
			@ModelAttribute("newUser") User user,
			@ModelAttribute("newLogin") LoginUser loginUser) {
		if(session.getAttribute("id") != null) {
			return "redirect:/";
		} 
		else {
			return "register.jsp";
		}
	}
	
	@PostMapping("/register")
	public String pRegister(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "register.jsp";
		}
		else {
			// No errors. To do: Store their ID from the DB in session. Log them in.
			userService.register(user, result);	
			Long id = user.getId();
			session.setAttribute("id", id);
			return "redirect:/";
		}
		
	}
	
	// LOGIN ROUTES //
	@GetMapping("/login")
	public String gLogin(
			HttpSession session,
			@ModelAttribute("newLogin") LoginUser loginUser,
			@ModelAttribute("newUser") User user) {
		if(session.getAttribute("id") != null) {
			return "redirect:/";
		} 
		else {
			return "login.jsp";
		}
	}
	
	@PostMapping("/login")
	public String pLogin(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		else {
			User loggedUser = (User) userService.login(loginUser, result);
			Long id = loggedUser.getId();
			session.setAttribute("id", id);
			// No errors. To do: Store their ID from the DB in session. Log them in.
			return "redirect:/";
		}
		
	}
}
