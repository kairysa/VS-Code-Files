package com.noahgardner.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.authentication.models.Book;
import com.noahgardner.authentication.models.User;
import com.noahgardner.authentication.services.BookService;
import com.noahgardner.authentication.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/books/new")
	public String gBookPage(HttpSession session,
			@ModelAttribute("newBook") Book book,
			Model model) {
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
		
		else {
			Long userId = (Long) session.getAttribute("id");
			User loggedUser = userService.findUser(userId);
			model.addAttribute("currentUser", loggedUser);
			return "book.jsp";
		}
	}
	
	@PostMapping("/books/create")
	public String pBookPage(HttpSession session,
			@Valid @ModelAttribute("newBook") Book book,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("id");
			User loggedUser = userService.findUser(userId);
			model.addAttribute("currentUser", loggedUser);
			return "book.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/home";
		}
		
	}
	
	@GetMapping("/books/{id}")
	public String pBook(HttpSession session, @PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "view.jsp";
	}
	
	@PostMapping("/delete/{id}")
	public String dBook(HttpSession session, @PathVariable("id") Long id) {
		Long userId = (Long) session.getAttribute("id");
		Book selectedBook = bookService.findBook(id);
		if(userId == selectedBook.getUser().getId()) {
			bookService.deleteBook(id);
			return "redirect:/home";
		}
		else {
			return "redirect:/home";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(HttpSession session, 
			@PathVariable("id") Long id, 
			Model model, 
			@ModelAttribute("book") Book book) {
		Long userId = (Long) session.getAttribute("id");
		Book selectedBook = bookService.findBook(id);
		if(userId == selectedBook.getUser().getId()) {
			model.addAttribute("book", selectedBook);
			return "edit.jsp";
		}
		else {
			return "redirect:/home";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String editBook(HttpSession session,
			@PathVariable("id") Long id,
			Model model,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		Book selectedBook = bookService.findBook(id);
		if(result.hasErrors()) {
			model.addAttribute("book", selectedBook);
			return "edit.jsp";
		}
		else {
			bookService.updateBook(book);
			return "redirect:/home";
		}
	}
}
