package com.example.demo.Services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Song;
import com.example.demo.Repos.SongRepository;


@Service
public class SongServiceImplementation implements SongServices {
	
	@Autowired
	
	SongRepository repo;
	
	@Autowired
	
	SessionFactory sessionFactory;

	@Override
	public void addSong(Song song) {
		
		repo.save(song);
		
	}

	@Override
	public List<Song> fetchAllSongs() {
		
		return repo.findAll();
	}

	@Override
	public boolean songExist(String name) {
		
		Song song = repo.findByName(name);
		
		if(song == null) {
			
			return false;
		}else {
		
		return true;
		
		}
	}

	@Override
	public void updateSong(Song song) {
		
		repo.save(song);
		
	}


}
