package com.noahgardner.diakichiroutes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("fruit", "banana");
		return "demo.jsp";
	}
	
/*	public String index(@RequestParam(value="name", required = false) String firstName, 
						@RequestParam(value="last_name", required = false) String lastName,
						@RequestParam(value="times", required = false) String times) {
		if (times == null) {
			if (firstName == null) {
				return "Hello Human";
			}
			if (lastName == null) {
				return "Hello " + firstName;
			}
			else {
				return "Hello " + firstName + " " + lastName;
			}
		}
		if (times != null) {
			int number = Integer.parseInt(times);
			if(firstName == null) {
				String hello = "Hello Human";
				return hello.repeat(number);
			}
			if(lastName == null) {
				String hello = "Hello " + firstName;
				return hello.repeat(number);
			}
			else {
				String hello = "Hello " + firstName + " " + lastName;
				return hello.repeat(number);
			}
		}
		else {
			return "Hello " + firstName + " " + lastName;
		}
	} */
}
