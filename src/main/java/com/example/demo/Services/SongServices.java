package com.example.demo.Services;

import java.util.List;


import com.example.demo.Entities.Song;

public interface SongServices {

	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean songExist(String name);
	
	public void updateSong(Song song);

}
