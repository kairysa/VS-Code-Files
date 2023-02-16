package com.noahgardner.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.authentication.models.Book;
import com.noahgardner.authentication.models.Borrow;
import com.noahgardner.authentication.services.BookService;
import com.noahgardner.authentication.services.BorrowService;
import com.noahgardner.authentication.services.UserService;

@Controller
public class BorrowController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BorrowService borrowService;
	
	@PostMapping("/borrow/{id}")
	public String borrowBook(HttpSession session,
			@Valid @ModelAttribute("borrow") Borrow borrow,
			BindingResult result,
			@PathVariable("id") Long id) {
		borrowService.createBorrow(borrow);
		bookService.deleteBook(id);
		return "redirect:/home";
	}
	
	@PostMapping("/return/{id}")
	public String returnBook(HttpSession session,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			@PathVariable("id") Long id) {
		bookService.createBook(book);
		borrowService.deleteBorrow(id);
		return "redirect:/home";
	}
	
}
