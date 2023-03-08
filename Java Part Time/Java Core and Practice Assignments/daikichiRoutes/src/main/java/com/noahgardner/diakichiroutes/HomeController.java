package com.noahgardner.diakichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {
	
	// Daikichi Routes //
	@RequestMapping("")
	public String home() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportuniry will arise, so be sure to be open to new ideas!";
	}
	
	// Daikichi Path Variables
	@RequestMapping("/travel/{location}")
	public String travel(@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location;
	}
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") String number) {
		int numberInt = Integer.parseInt(number);
		if ((numberInt % 2) == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers.";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
