package com.noahgardner.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/input")
	public String inputs(HttpSession session,
						@RequestParam(value="number") String number,
						@RequestParam(value="city") String city,
						@RequestParam(value="name") String name,
						@RequestParam(value="hobby") String hobby,
						@RequestParam(value="thing") String thing,
						@RequestParam(value="saysomething") String saysomething) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("saysomething", saysomething);
		
		return "redirect:/omikuji/show";
	}
	@GetMapping("/show")
	public String show(HttpSession session) {
		return "show.jsp";
	}
}
