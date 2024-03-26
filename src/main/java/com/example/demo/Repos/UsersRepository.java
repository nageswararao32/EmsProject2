package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	public Users findByEmail(String email);
}
