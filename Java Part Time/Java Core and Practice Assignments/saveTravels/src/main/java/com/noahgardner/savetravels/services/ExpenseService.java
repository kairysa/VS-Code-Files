package com.noahgardner.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.savetravels.models.Expense;
import com.noahgardner.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	public final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	
	public Expense createExpense(Expense b) {
		return expenseRepo.save(b);
	}
	
	public Expense updateExpense(Expense b) {
		return expenseRepo.save(b);
	}
	
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
}

