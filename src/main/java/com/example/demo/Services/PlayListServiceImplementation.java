package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.PlayList;
import com.example.demo.Repos.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {
	
	@Autowired
	
	PlayListRepository repo;
	
	@Override
	public void addPlayList(PlayList playlist) {
		
		repo.save(playlist);
		
	}

	@Override
	public List<PlayList> fetchALlPlayLists() {
		
		return repo.findAll();
	}

}
