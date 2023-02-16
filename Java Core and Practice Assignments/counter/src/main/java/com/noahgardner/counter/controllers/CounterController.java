package com.noahgardner.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			count += 1;
			session.setAttribute("count", count);
			}
		return "index.jsp";
	}
	@PostMapping("/addTwo")
	public String addTwo(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count += 1;
		session.setAttribute("count", count);
		return "redirect:/";
	}
	@PostMapping("/clear")
	public String clear(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count = -1;
		session.setAttribute("count", count);
		return "redirect:/";
	}
}
