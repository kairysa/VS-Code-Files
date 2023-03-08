package com.noahgardner.displaydate.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/YY");
		model.addAttribute("date", dateForm.format(thisDate));
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date thisDate = new Date();
		SimpleDateFormat timeForm = new SimpleDateFormat("hh:mm a");
		model.addAttribute("time", timeForm.format(thisDate));
		return "time.jsp";
	}
}
