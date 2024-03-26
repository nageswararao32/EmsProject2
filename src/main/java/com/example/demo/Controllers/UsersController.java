package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.LoginData;
import com.example.demo.Entities.UpdateData;
import com.example.demo.Entities.UpdateDataDTO;
import com.example.demo.Entities.Users;
import com.example.demo.Services.SongServices;
import com.example.demo.Services.UsersService;

import jakarta.servlet.http.HttpSession;


@CrossOrigin("*")
@RestController
public class UsersController {

	@Autowired

	UsersService service;
	
	@Autowired
	
	SongServices services;
	
	@PostMapping("/validate")
	public String validate(@RequestBody LoginData data,
			HttpSession session, Model model) {
		
		System.out.println("Login come");
		
		String email = data.getEmail();
		
		String password = data.getPassword();
		
		if(service.validateUser(email,password) == true) {
			
			String role = service.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("Admin")) {
				
				return "AdminHome";
			}
			else {
				Users user = service.getUser(email);
				boolean userStatus = user.isPremium();
				model.addAttribute("isPremium", userStatus);
				return "CustomerHome";
			}
		}
		else if(service.validateUser(email,password) == false){
			return "Invalid Email or Password";
		}else {
			return "login";
		}
	}

	@PostMapping("/register")

	public String addUsers(@RequestBody Users user) {

		boolean userStatus = service.emailExists(user.getEmail());

		if (userStatus == false) {

			service.addUsers(user);

			return "User added.";
		} else {
			return "User already Exists..";
		}

	}

	
	
	@GetMapping("/logout")
	
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("Logged Out");
		return "login";
	}
	
	@PostMapping("/isPrimeOrNot")
	public String isPrimeOrNot(@RequestBody LoginData data) {
		
		String email = data.getEmail();
		
		boolean res = service.isPrimeOrNot(email);
		
		if(res) {
			
			return "true";
		}
		
		return "false";
	}
	
	@PostMapping("/getUsername")
	
	public Users getUserDeatils(@RequestBody  LoginData data) {
		
		String email = data.getEmail();
		
		System.out.println("EMail at line 119  "+email);
		
		Users d = service.getUser(email);
		
		if(d==null) {
			
			System.out.println("User Not Found!");
		}else {
	
		System.out.println("At Line 118"+d.getUsername());
		
		}
		
		return service.getUserDeatils(email);
	}
	
	
	
	@PostMapping("/updatePwd")
	
	public Users updatePassword(@RequestBody UpdateData d) {
		
		String email = d.getEmail();
		
		System.out.println(email);
		
		String password = d.getPassword();
		
		System.out.println("At line No 158"+password);
		
		System.out.println("Mail Is:  "+email+" password is:  "+password);
		
		Users u = service.getUser(email);
		
		System.out.println("UserName is"+u.getUsername());
		
		u.setPassword(password);
		
		return service.updatePassword(password, email);
	}
	
	@GetMapping("/getUserDetails")
	public List<Users> getUserDetails() {
	    
		return service.getUserDetails();
	}
	
	@PostMapping("/updateUserDetails/{id}")
	
	public Users updateUserDetails(@PathVariable Integer id,  @RequestBody UpdateDataDTO upd) {
		
		String username = upd.getUsername();
		
		String email = upd.getEmail();
		
		String password = upd.getPassword();
		
		System.out.println("At 166 Username is: "+username+" Email is:  "+email+" pwd is: "+password);
			
		Users u = service.findUserByID(id);
		
		System.out.println("Username 170 is: "+u);
		
		u.setUsername(username);
		
		u.setEmail(email);
		
		u.setPassword(password);
		
		return service.updateUserData(id, username, email, password);
	}
	
	@PostMapping("/deleteUser")
	
	public String deleteUser(@RequestBody Users u) {
		
		String email = u.getEmail();
		
		Users usr = service.getUser(email);
		
		System.out.println("User at line 163 "+usr);
		
		service.deleteUser(usr);
		
		return "User deleted Successfully!";		
	}
	
}






