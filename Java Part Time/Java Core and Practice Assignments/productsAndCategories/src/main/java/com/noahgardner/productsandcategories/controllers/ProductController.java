package com.noahgardner.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.productsandcategories.models.Category;
import com.noahgardner.productsandcategories.models.Product;
import com.noahgardner.productsandcategories.services.CategoryService;
import com.noahgardner.productsandcategories.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public String productPage(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
	@PostMapping("/product/new")
	public String newProduct(@Valid
			@ModelAttribute("product") Product product,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "product.jsp";
		}
		
		else {
			productService.updateOrCreate(product);
			return "redirect:/";
		}
	}
	
	@GetMapping("/product/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("product") Product product) {
		Product oneProduct = productService.findOne(id);
		List<Category> allCategories = categoryService.findAll();
		model.addAttribute("oneProduct", oneProduct);
		model.addAttribute("allCategories", allCategories);
		return "one_product.jsp";
	}
	
	@PostMapping("/product/edit")
	public String editProduct(@Valid @ModelAttribute("product") Product product) {
		productService.updateOrCreate(product);
		return "redirect:/product/{product.id}";
	}
}
