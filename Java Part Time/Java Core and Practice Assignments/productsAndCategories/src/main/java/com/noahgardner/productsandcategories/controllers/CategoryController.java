package com.noahgardner.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.productsandcategories.models.Category;
import com.noahgardner.productsandcategories.services.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category")
	public String categoryPage(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@PostMapping("/category/new")
	public String newCategory(@Valid 
			@ModelAttribute("category") Category category,
			BindingResult result) {
		if(result.hasErrors()) {
			return "category.jsp";
		}
		else {
			categoryService.updateOrCreate(category);
			return "redirect:/";
		}
	}
}
