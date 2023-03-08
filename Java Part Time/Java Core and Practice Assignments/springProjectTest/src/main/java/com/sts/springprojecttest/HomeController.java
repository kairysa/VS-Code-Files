package com.sts.springprojecttest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required = false) String searchQuery) {
		if(searchQuery == null) {
			return "You searched for nothing";
		} 
		if(searchQuery.length() == 0) {
			return "You searched for nothing";
		}
		else {
		return "You searched for: " + searchQuery;
		}
	}
}
