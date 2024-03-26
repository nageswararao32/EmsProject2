package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.UserPlayList;

public interface UserPlayListRepo extends JpaRepository<UserPlayList, Long> {

}
