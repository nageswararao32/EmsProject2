package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.PlayList;

public interface PlayListService {

	public void addPlayList(PlayList playlist);

	public List<PlayList> fetchALlPlayLists();

}
