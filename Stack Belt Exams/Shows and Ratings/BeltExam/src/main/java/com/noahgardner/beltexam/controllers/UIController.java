package com.noahgardner.beltexam.controllers;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.noahgardner.beltexam.models.LoginUser;
import com.noahgardner.beltexam.models.Rating;
import com.noahgardner.beltexam.models.RatingComparator;
import com.noahgardner.beltexam.models.Show;
import com.noahgardner.beltexam.models.User;
import com.noahgardner.beltexam.services.RatingService;
import com.noahgardner.beltexam.services.ShowService;
import com.noahgardner.beltexam.services.UserService;


// Controller that handles all GetMapping requests //

@Controller
public class UIController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShowService showService;
	
	@Autowired
	RatingService ratingService;
	
	@GetMapping("/")
	public String loginPage(
			@ModelAttribute("newUser") User user,
			@ModelAttribute("newLogin") LoginUser loginUser
			) {
		return "login_and_reg.jsp";
	}
	
	@GetMapping("/shows")
	public String home(HttpSession session,
			Model model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
		else {
			if(session.getAttribute("showId") != null) {
				session.removeAttribute("showId");
			}
			Long id = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.findUser(id));
			model.addAttribute("shows", showService.findAll());
			model.addAttribute("ratings", ratingService.findAll());
			return "home.jsp";
		}
	}
	
	@GetMapping("/shows/new")
	public String newShowPage(HttpSession session,
			@ModelAttribute("newShow") Show show,
			Model model
			) {
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
		else {
			Long id = (Long) session.getAttribute("id");
			User user = userService.findUser(id);
			model.addAttribute("user", user);
			return "new.jsp";
		}
	}
	
	@GetMapping("/shows/view/{id}")
	public String viewShowPage(@PathVariable("id") Long id,
			HttpSession session,
			Model model,
			@ModelAttribute("rating") Rating rating) {
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
		else {
			if(session.getAttribute("showId") != null) {
				session.removeAttribute("showId");
			}
			Long userId = (Long) session.getAttribute("id");
			ArrayList<Rating> ratingList = (ArrayList<Rating>) ratingService.findAll();
			Collections.sort(ratingList, new RatingComparator());
			model.addAttribute("ratings", ratingList);
			model.addAttribute("user", userService.findUser(userId));
			model.addAttribute("selectedShow", showService.findOne(id));
			session.setAttribute("showId", showService.findOne(id).getId());
			return "view.jsp";
		}
	}
	
	@GetMapping("/shows/edit/{id}")
	public String editShowPage(@PathVariable("id") Long id,
			@ModelAttribute("editShow") Show show,
			HttpSession session,
			Model model) {
		Long userId = (Long) session.getAttribute("id");
		Show selectedShow = showService.findOne(id);
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
		if(userId != selectedShow.getUser().getId()) {
			return "redirect:/";
		}
		else {
			model.addAttribute("user", userService.findUser(userId));
			model.addAttribute("selectedShow", selectedShow);
			session.setAttribute("showId", showService.findOne(id).getId());
			return "edit.jsp";
		}
	}
}
