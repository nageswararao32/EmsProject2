package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.UserPlayList;
import com.example.demo.Repos.UserPlayListRepo;

@Service
public class UserPlayListServiceImpl implements UserPlayListService {
	
	@Autowired
	
	UserPlayListRepo repo;

	@Override
	public void addPlayList(UserPlayList playlist) {
		
		repo.save(playlist);
	}

	@Override
	public List<UserPlayList> fetchALlPlayLists() {
		
		return repo.findAll();
	}

}
