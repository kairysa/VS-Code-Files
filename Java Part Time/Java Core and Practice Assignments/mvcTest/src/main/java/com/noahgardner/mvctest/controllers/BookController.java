package com.noahgardner.mvctest.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noahgardner.mvctest.models.Book;
import com.noahgardner.mvctest.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
		
	@GetMapping("/books/{bookId}")
	public String showBook(Model model, @PathVariable("bookId") Long bookId) {
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	@GetMapping("/books")
	public String index(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
		model.addAttribute("books", books);
		System.out.println(books);
		return "index.jsp";
		
	}
	@GetMapping("/books/new")
	public String createBookPage(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@PostMapping("/books/new/create")
	public String createNewBook(
		@Valid @ModelAttribute("book") Book book,
		BindingResult result) {
		
		if (result.hasErrors()) {
			return "new.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/books";
		}
		
	}
}
