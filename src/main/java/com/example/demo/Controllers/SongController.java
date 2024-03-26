package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entities.Song;
import com.example.demo.Repos.SongRepository;
import com.example.demo.Services.SongServices;

@CrossOrigin("*")

@RestController
public class SongController {

	@Autowired

	SongServices service;
	
	@Autowired
	SongRepository repo;

	@PostMapping("/addSong")

	public String addSong(@RequestBody Song song) {

		boolean songStatus = service.songExist(song.getName());

		if (songStatus == false) {

			service.addSong(song);
			
			return "Song added successfully!";

		} else {
			return "Song already Exists.";
		}
	}

	/*@GetMapping("/viewSongs")

	public String viewSongs(Model model) {

		List<Song> songList = service.fetchAllSongs();

		model.addAttribute("songs", songList);

		return "displaySongs";
	}*/
	
	@GetMapping("/viewSongs")
	public List<Song> viewSongs() {
	    return service.fetchAllSongs();
	}

	
	@CrossOrigin("http://localhost:3000")
	
	@GetMapping("/playSongs")

	public List<Song> playSongs(Model model) {	
		
		List<Song> songList = service.fetchAllSongs();

		model.addAttribute("songs", songList);
		
		return service.fetchAllSongs();
		
		}
		
}
