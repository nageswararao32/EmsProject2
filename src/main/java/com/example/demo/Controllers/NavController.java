package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavController {

	@GetMapping("/login")

	public String login() {
		return "login";
	}

	@GetMapping("/reg")

	public String register() {
		return "register";
	}
	
	@GetMapping("/newSong")
	public String addSong() {
		return "newSong";
	}
	
	
	
}
