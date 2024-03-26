package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entities.PlayList;
import com.example.demo.Entities.Song;
import com.example.demo.Services.PlayListService;
import com.example.demo.Services.SongServices;


@CrossOrigin("*")
@RestController
public class PlayListController {
		
	@Autowired
	
	SongServices songService;
	
	@Autowired
	
	PlayListService playlistService;
	
	@GetMapping("/createPlaylist")
	
	public List<Song> createPlayList(Model model) {
		
		List<Song> songList = songService.fetchAllSongs();
		
		model.addAttribute("songs", songList);
		
		return songService.fetchAllSongs();
	}
	
	/*
	@PostMapping("/addPlayList")
	
	public String addPlayList(@RequestBody PlayList playlist) {
		
		//updating playList Table
		
		//String name = playlist.getName();
		
		//List<Song>songs = playlist.getSongs();
		
		playlistService.addPlayList(playlist);
		
		//Updating Song Table
		
		List<Song>songList = playlist.getSongs();
		
		for(Song s: songList) {
		
			s.getPlaylist().add(playlist);
			
			//Updating song objects in DB
			
			songService.updateSong(s);
			
		}
		
		return "PlayList Created Successfully";
	}
	*/
	
	@PostMapping("/addPlayList")
	public String addPlayList(@RequestBody PlayList playlist) {

	    // Add the playlist
	    playlistService.addPlayList(playlist);

	    // Update the songs with the new playlist
	    List<Song> songList = playlist.getSongs();
	    for (Song s : songList) {
	        s.getPlaylist().add(playlist);
	        //songService.updateSong(s);
	    }
	    return "PlayList Created Successfully";
	}

	
	
	@GetMapping("/playListSongs")
	
	public List<PlayList> playListSongs(){
		
		
		return playlistService.fetchALlPlayLists();
	}
	
	
	@GetMapping("/viewPlayList")
	
	public List<PlayList> viewPlayList(Model model) {
		
		List<PlayList> allPlaylists = playlistService.fetchALlPlayLists();
		
		model.addAttribute("allPlaylists", allPlaylists);
		
		return playlistService.fetchALlPlayLists();
	}

}
