package com.noahgardner.savetravels.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.noahgardner.savetravels.models.Expense;
import com.noahgardner.savetravels.services.ExpenseService;

@Controller
public class SaveTravelsController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(Model model, 
						@ModelAttribute("expense") Expense expense) {
		ArrayList<Expense> expenses = (ArrayList<Expense>) expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String pCreate(
			Model model, 
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if(result.hasErrors()) {
			ArrayList<Expense> expenses = (ArrayList<Expense>) expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expense/edit/{id}")
	public String gEdit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String pEdit(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/expense/{id}")
	public String dDelete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
	
	@GetMapping("/expense/{id}")
	public String gView(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "view.jsp";
	}
}
