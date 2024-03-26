package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.User;
import com.example.demo.Repos.UserRepo;
import com.example.demo.Services.UserService;

@RestController

@CrossOrigin("*")
public class UserController {
	
	@Autowired
	
	UserService userService;
	
	@Autowired
	
	UserRepo repo;
	
	@PostMapping("/addFavSong")
	
	public String addFavSOng(@RequestBody User u) {
		
		userService.addUser(u);
		
		return "Song added successfully!";
		
	}
	
	@GetMapping("/getFavDetails")
	
	public List<User> getDetails(){
		
		return repo.findAll();
	}
	
}
