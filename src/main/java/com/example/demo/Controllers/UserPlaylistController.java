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
import com.example.demo.Entities.UserPlayList;
import com.example.demo.Services.UserPlayListService;

@CrossOrigin("*")
@RestController
public class UserPlaylistController {
		
	@Autowired
	
	UserPlayListService playlistService;
	
	@PostMapping("/addUserPlayList")
	public String addPlayList(@RequestBody UserPlayList playlist) {

	    // Add the playlist
	    playlistService.addPlayList(playlist);

	    // Update the songs with the new playlist
	    List<Song> songList = playlist.getUsongs();
	    for (Song s : songList) {
	        s.getUplists().add(playlist);
	        //songService.updateSong(s);
	    }
	    return "PlayList Created Successfully";
	}
	
	@GetMapping("/viewUserPlayList")
	
	public List<UserPlayList> viewPlayList(Model model) {
		
		List<UserPlayList> allPlaylists = playlistService.fetchALlPlayLists();
		
		model.addAttribute("allPlaylists", allPlaylists);
		
		return playlistService.fetchALlPlayLists();
	}

}
