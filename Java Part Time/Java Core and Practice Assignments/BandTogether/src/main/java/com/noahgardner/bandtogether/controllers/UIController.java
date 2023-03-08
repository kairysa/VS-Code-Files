package com.noahgardner.bandtogether.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
	@GetMapping("/")
	public String rTest() {
		return "index.jsp";
	}
}
