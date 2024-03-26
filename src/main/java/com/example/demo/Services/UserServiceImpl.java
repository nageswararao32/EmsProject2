package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.User;
import com.example.demo.Repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	
	UserRepo repo;

	@Override
	public void addUser(User u) {
		
		repo.save(u);
	}

}
