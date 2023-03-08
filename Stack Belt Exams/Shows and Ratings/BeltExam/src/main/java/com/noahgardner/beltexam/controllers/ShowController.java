package com.noahgardner.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.beltexam.models.Show;
import com.noahgardner.beltexam.services.ShowService;

@Controller
public class ShowController {
	
	@Autowired
	ShowService showService;
	
	@PostMapping("/shows/new/create")
	public String newShow(
			@Valid @ModelAttribute("newShow") Show show,
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		else {
			showService.updateOrCreate(show);
			return "redirect:/shows";
		}
	}
	
	@PostMapping("/shows/delete/{id}")
	public String deleteShow(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("id");
		Show selectedShow = showService.findOne(id);
		if (userId == selectedShow.getUser().getId()) {
			showService.deleteOne(id);
			return "redirect:/shows";
		}
		else {
			return "redirect:/shows";
		}
	}
	
	@PostMapping("/shows/edit")
	public String editShow(
			@Valid @ModelAttribute("editShow") Show show,
			BindingResult result,
			HttpSession session,
			Model model
			) {
		Show selectedShow = showService.findOne((Long) session.getAttribute("showId"));
		if(result.hasErrors()) {
			model.addAttribute("selectedShow", selectedShow);
			return "edit.jsp";
		}
		else {
			showService.updateOrCreate(show);
			return "redirect:/shows";
		}
	}
}
