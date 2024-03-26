package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
