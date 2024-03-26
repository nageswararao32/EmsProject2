package com.example.demo.Entities;

public class UpdateDataDTO {
	
	String username;
	
	String email;
	
	String password;
	
	public UpdateDataDTO() {
		super();
	}

	public UpdateDataDTO(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UpdateDataDTO [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	
	
	
}
