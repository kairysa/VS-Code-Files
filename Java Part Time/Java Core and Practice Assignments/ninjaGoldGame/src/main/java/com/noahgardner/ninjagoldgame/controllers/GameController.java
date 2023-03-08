package com.noahgardner.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
	Random randomNumber = new Random();
	ArrayList<String> activities = new ArrayList<String>();
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			int gold = 0;
			session.setAttribute("gold", gold);
		}
		return "index.jsp";
	}
	@PostMapping("/gold")
	public String farm(HttpSession session,
						@RequestParam(value="farm", required=false) String farm,
						@RequestParam(value="cave", required=false) String cave,
						@RequestParam(value="house", required=false) String house,
						@RequestParam(value="quest", required=false) String quest) {
		Integer gold = (Integer) session.getAttribute("gold");
		if(farm != null) {
			Date date = new Date();
			Integer random = randomNumber.nextInt(11) + 10;
			gold += random;
			session.setAttribute("gold", gold);
			activities.add("You entered a farm and earned " + random + " gold. " + date);
			session.setAttribute("activities", activities);
		}
		if(cave != null) {
			Date date = new Date();
			Integer random = randomNumber.nextInt(6) + 5;
			gold += random;
			session.setAttribute("gold", gold);
			activities.add("You entered a cave and earned " + random + " gold. " + date);
			session.setAttribute("activities", activities);
		}
		if(house != null) {
			Date date = new Date();
			Integer random = randomNumber.nextInt(4) + 2;
			gold += random;
			session.setAttribute("gold", gold);
			activities.add("You entered a house and earned " + random + " gold. " + date);
			session.setAttribute("activities", activities);
		}
		if(quest != null) {
			Date date = new Date();
			Integer random = randomNumber.nextInt(101) - 50;
			if(random < 0) {
				gold += random;
				session.setAttribute("gold", gold);
				activities.add("You completed a quest, but unfortunately lost " + random + " gold! " + date);
				session.setAttribute("activities", activities);
			}
			if(random > 0) {
				gold += random;
				session.setAttribute("gold", gold);
				activities.add("You completed a quest and earned " + random + " gold! " + date);
				session.setAttribute("activities", activities);
			}
			if(random == 0) {
				activities.add("You completed a quest which yielded no rewards!");
				session.setAttribute("activities", activities);
			}
		}
		return "redirect:/";
	}
}
