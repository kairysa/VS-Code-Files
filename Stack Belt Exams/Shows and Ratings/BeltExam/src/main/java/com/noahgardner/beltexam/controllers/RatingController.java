package com.noahgardner.beltexam.controllers;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.beltexam.models.Rating;
import com.noahgardner.beltexam.models.RatingComparator;
import com.noahgardner.beltexam.services.RatingService;
import com.noahgardner.beltexam.services.ShowService;
import com.noahgardner.beltexam.services.UserService;

@Controller
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShowService showService;
	
	@PostMapping("/rating/new")
	public String newRating(
			@Valid @ModelAttribute("rating") Rating rating,
			BindingResult result,
			HttpSession session,
			Model model
			) {
		Long showId = (Long) session.getAttribute("showId");
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("id");
			ArrayList<Rating> ratingList = (ArrayList<Rating>) ratingService.findAll();
			Collections.sort(ratingList, new RatingComparator());
			model.addAttribute("ratings", ratingList);
			model.addAttribute("user", userService.findUser(userId));
			model.addAttribute("selectedShow", showService.findOne(showId));
			return "view.jsp";
		}
		else {
			ratingService.updateOrCreate(rating);
			return "redirect:/shows/view/" + showId;
		}
	}
}
