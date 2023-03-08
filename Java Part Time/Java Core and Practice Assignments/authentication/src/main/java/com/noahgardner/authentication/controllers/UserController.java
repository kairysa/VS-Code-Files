package com.noahgardner.authentication.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noahgardner.authentication.models.Book;
import com.noahgardner.authentication.models.Borrow;
import com.noahgardner.authentication.models.LoginUser;
import com.noahgardner.authentication.models.User;
import com.noahgardner.authentication.services.BookService;
import com.noahgardner.authentication.services.BorrowService;
import com.noahgardner.authentication.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BorrowService borrowService;

	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user,
			@ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {		
			// Be sure to send in the empty LoginUser before re-rendering the page due to errors. //
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		else {
			// No errors. To do: Store their ID from the DB in session. Log them in.
			userService.register(user, result);	
			Long id = user.getId();
			session.setAttribute("id", id);
			return "redirect:/home";
		}
		
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		else {
			User loggedUser = (User) userService.login(loginUser, result);
			Long id = loggedUser.getId();
			session.setAttribute("id", id);
			// No errors. To do: Store their ID from the DB in session. Log them in.
			return "redirect:/home";
		}
		
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, 
			Model model, 
			@ModelAttribute("borrow") Borrow borrow, 
			@ModelAttribute("book") Book book) {
		Long id = (Long) session.getAttribute("id");
		User loggedUser = userService.findUser(id);
		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
		ArrayList<Borrow> borrows = (ArrayList<Borrow>) borrowService.allBorrows();
		
		model.addAttribute("borrows", borrows);
		model.addAttribute("user", loggedUser);
		model.addAttribute("books", books);
		return "home.jsp";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	
}
