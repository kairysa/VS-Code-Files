package com.noahgardner.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.beltexam.models.LoginUser;
import com.noahgardner.beltexam.models.User;
import com.noahgardner.beltexam.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login_and_reg.jsp";
		}
		else {
			userService.register(user, result);
			Long id = user.getId();
			session.setAttribute("id", id);
			return "redirect:/shows";
		}
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login_and_reg.jsp";
		}
		else {
			if(userService.login(loginUser, result) == null) {
				model.addAttribute("newUser", new User());
				return "login_and_reg.jsp";
			}
			else {
				User loggedUser = userService.login(loginUser, result);
				Long id = loggedUser.getId();
				session.setAttribute("id", id);
				return "redirect:/shows";
			}
		}
	}
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
}
