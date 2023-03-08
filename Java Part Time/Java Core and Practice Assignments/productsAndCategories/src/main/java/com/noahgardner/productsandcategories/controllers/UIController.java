package com.noahgardner.productsandcategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.noahgardner.productsandcategories.models.Category;
import com.noahgardner.productsandcategories.models.Product;
import com.noahgardner.productsandcategories.services.CategoryService;
import com.noahgardner.productsandcategories.services.ProductService;

@Controller
public class UIController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Category> allCategories = categoryService.findAll();
		List<Product> allProducts = productService.findAll();
		model.addAttribute("categories", allCategories);
		model.addAttribute("products", allProducts);
		return "index.jsp";
	}
}
